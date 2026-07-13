package com.adjust.sdk;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class PackageHandler implements IPackageHandler {
    private static final String PACKAGE_QUEUE_FILENAME = "AdjustIoPackageQueue";
    private static final String PACKAGE_QUEUE_NAME = "Package queue";
    private WeakReference<IActivityHandler> activityHandlerWeakRef;
    private Context context;
    private AtomicBoolean isSending;
    private List<ActivityPackage> packageQueue;
    private boolean paused;
    private IRequestHandler requestHandler;
    private CustomScheduledExecutor scheduledExecutor = new CustomScheduledExecutor("PackageHandler");
    private ILogger logger = AdjustFactory.getLogger();
    private BackoffStrategy backoffStrategy = AdjustFactory.getPackageHandlerBackoffStrategy();

    @Override // com.adjust.sdk.IPackageHandler
    public void teardown(boolean deleteState) {
        this.logger.verbose("PackageHandler teardown", new Object[0]);
        if (this.scheduledExecutor != null) {
            try {
                this.scheduledExecutor.shutdownNow();
            } catch (SecurityException e) {
            }
        }
        if (this.activityHandlerWeakRef != null) {
            this.activityHandlerWeakRef.clear();
        }
        if (this.requestHandler != null) {
            this.requestHandler.teardown();
        }
        if (this.packageQueue != null) {
            this.packageQueue.clear();
        }
        if (deleteState && this.context != null) {
            deletePackageQueue(this.context);
        }
        this.scheduledExecutor = null;
        this.requestHandler = null;
        this.activityHandlerWeakRef = null;
        this.packageQueue = null;
        this.isSending = null;
        this.context = null;
        this.logger = null;
        this.backoffStrategy = null;
    }

    public PackageHandler(IActivityHandler activityHandler, Context context, boolean startsSending) {
        init(activityHandler, context, startsSending);
        this.scheduledExecutor.submit(new Runnable() { // from class: com.adjust.sdk.PackageHandler.1
            @Override // java.lang.Runnable
            public void run() {
                PackageHandler.this.initI();
            }
        });
    }

    @Override // com.adjust.sdk.IPackageHandler
    public void init(IActivityHandler activityHandler, Context context, boolean startsSending) {
        this.activityHandlerWeakRef = new WeakReference<>(activityHandler);
        this.context = context;
        this.paused = !startsSending;
    }

    @Override // com.adjust.sdk.IPackageHandler
    public void addPackage(final ActivityPackage activityPackage) {
        this.scheduledExecutor.submit(new Runnable() { // from class: com.adjust.sdk.PackageHandler.2
            @Override // java.lang.Runnable
            public void run() {
                PackageHandler.this.addI(activityPackage);
            }
        });
    }

    @Override // com.adjust.sdk.IPackageHandler
    public void sendFirstPackage() {
        this.scheduledExecutor.submit(new Runnable() { // from class: com.adjust.sdk.PackageHandler.3
            @Override // java.lang.Runnable
            public void run() {
                PackageHandler.this.sendFirstI();
            }
        });
    }

    @Override // com.adjust.sdk.IPackageHandler
    public void sendNextPackage(ResponseData responseData) {
        this.scheduledExecutor.submit(new Runnable() { // from class: com.adjust.sdk.PackageHandler.4
            @Override // java.lang.Runnable
            public void run() {
                PackageHandler.this.sendNextI();
            }
        });
        IActivityHandler activityHandler = this.activityHandlerWeakRef.get();
        if (activityHandler != null) {
            activityHandler.finishedTrackingActivity(responseData);
        }
    }

    @Override // com.adjust.sdk.IPackageHandler
    public void closeFirstPackage(ResponseData responseData, ActivityPackage activityPackage) {
        responseData.willRetry = true;
        IActivityHandler activityHandler = this.activityHandlerWeakRef.get();
        if (activityHandler != null) {
            activityHandler.finishedTrackingActivity(responseData);
        }
        Runnable runnable = new Runnable() { // from class: com.adjust.sdk.PackageHandler.5
            @Override // java.lang.Runnable
            public void run() {
                PackageHandler.this.logger.verbose("Package handler can send", new Object[0]);
                PackageHandler.this.isSending.set(false);
                PackageHandler.this.sendFirstPackage();
            }
        };
        if (activityPackage == null) {
            runnable.run();
            return;
        }
        int retries = activityPackage.increaseRetries();
        long waitTimeMilliSeconds = Util.getWaitingTime(retries, this.backoffStrategy);
        double waitTimeSeconds = waitTimeMilliSeconds / 1000.0d;
        String secondsString = Util.SecondsDisplayFormat.format(waitTimeSeconds);
        this.logger.verbose("Waiting for %s seconds before retrying the %d time", secondsString, Integer.valueOf(retries));
        this.scheduledExecutor.schedule(runnable, waitTimeMilliSeconds, TimeUnit.MILLISECONDS);
    }

    @Override // com.adjust.sdk.IPackageHandler
    public void pauseSending() {
        this.paused = true;
    }

    @Override // com.adjust.sdk.IPackageHandler
    public void resumeSending() {
        this.paused = false;
    }

    @Override // com.adjust.sdk.IPackageHandler
    public void updatePackages(SessionParameters sessionParameters) {
        final SessionParameters sessionParametersCopy;
        if (sessionParameters != null) {
            sessionParametersCopy = sessionParameters.deepCopy();
        } else {
            sessionParametersCopy = null;
        }
        this.scheduledExecutor.submit(new Runnable() { // from class: com.adjust.sdk.PackageHandler.6
            @Override // java.lang.Runnable
            public void run() {
                PackageHandler.this.updatePackagesI(sessionParametersCopy);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initI() {
        this.requestHandler = AdjustFactory.getRequestHandler(this);
        this.isSending = new AtomicBoolean();
        readPackageQueueI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addI(ActivityPackage newPackage) {
        this.packageQueue.add(newPackage);
        this.logger.debug("Added package %d (%s)", Integer.valueOf(this.packageQueue.size()), newPackage);
        this.logger.verbose("%s", newPackage.getExtendedString());
        writePackageQueueI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendFirstI() {
        if (!this.packageQueue.isEmpty()) {
            if (this.paused) {
                this.logger.debug("Package handler is paused", new Object[0]);
            } else if (this.isSending.getAndSet(true)) {
                this.logger.verbose("Package handler is already sending", new Object[0]);
            } else {
                ActivityPackage firstPackage = this.packageQueue.get(0);
                this.requestHandler.sendPackage(firstPackage, this.packageQueue.size() - 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendNextI() {
        this.packageQueue.remove(0);
        writePackageQueueI();
        this.isSending.set(false);
        this.logger.verbose("Package handler can send", new Object[0]);
        sendFirstI();
    }

    public void updatePackagesI(SessionParameters sessionParameters) {
        if (sessionParameters != null) {
            this.logger.debug("Updating package handler queue", new Object[0]);
            this.logger.verbose("Session callback parameters: %s", sessionParameters.callbackParameters);
            this.logger.verbose("Session partner parameters: %s", sessionParameters.partnerParameters);
            for (ActivityPackage activityPackage : this.packageQueue) {
                Map<String, String> parameters = activityPackage.getParameters();
                Map<String, String> mergedCallbackParameters = Util.mergeParameters(sessionParameters.callbackParameters, activityPackage.getCallbackParameters(), "Callback");
                PackageBuilder.addMapJson(parameters, Constants.CALLBACK_PARAMETERS, mergedCallbackParameters);
                Map<String, String> mergedPartnerParameters = Util.mergeParameters(sessionParameters.partnerParameters, activityPackage.getPartnerParameters(), "Partner");
                PackageBuilder.addMapJson(parameters, Constants.PARTNER_PARAMETERS, mergedPartnerParameters);
            }
            writePackageQueueI();
        }
    }

    private void readPackageQueueI() {
        try {
            this.packageQueue = (List) Util.readObject(this.context, PACKAGE_QUEUE_FILENAME, PACKAGE_QUEUE_NAME, List.class);
        } catch (Exception e) {
            this.logger.error("Failed to read %s file (%s)", PACKAGE_QUEUE_NAME, e.getMessage());
            this.packageQueue = null;
        }
        if (this.packageQueue != null) {
            this.logger.debug("Package handler read %d packages", Integer.valueOf(this.packageQueue.size()));
        } else {
            this.packageQueue = new ArrayList();
        }
    }

    private void writePackageQueueI() {
        Util.writeObject(this.packageQueue, this.context, PACKAGE_QUEUE_FILENAME, PACKAGE_QUEUE_NAME);
        this.logger.debug("Package handler wrote %d packages", Integer.valueOf(this.packageQueue.size()));
    }

    public static Boolean deletePackageQueue(Context context) {
        return Boolean.valueOf(context.deleteFile(PACKAGE_QUEUE_FILENAME));
    }
}
