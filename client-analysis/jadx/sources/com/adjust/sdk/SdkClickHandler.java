package com.adjust.sdk;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HttpsURLConnection;

/* JADX INFO: loaded from: classes.dex */
public class SdkClickHandler implements ISdkClickHandler {
    private BackoffStrategy backoffStrategy;
    private ILogger logger;
    private List<ActivityPackage> packageQueue;
    private boolean paused;
    private CustomScheduledExecutor scheduledExecutor;

    @Override // com.adjust.sdk.ISdkClickHandler
    public void teardown() {
        this.logger.verbose("SdkClickHandler teardown", new Object[0]);
        if (this.scheduledExecutor != null) {
            try {
                this.scheduledExecutor.shutdownNow();
            } catch (SecurityException e) {
            }
        }
        if (this.packageQueue != null) {
            this.packageQueue.clear();
        }
        this.scheduledExecutor = null;
        this.logger = null;
        this.packageQueue = null;
        this.backoffStrategy = null;
    }

    public SdkClickHandler(boolean startsSending) {
        init(startsSending);
        this.logger = AdjustFactory.getLogger();
        this.scheduledExecutor = new CustomScheduledExecutor("SdkClickHandler");
        this.backoffStrategy = AdjustFactory.getSdkClickBackoffStrategy();
    }

    @Override // com.adjust.sdk.ISdkClickHandler
    public void init(boolean startsSending) {
        this.paused = !startsSending;
        this.packageQueue = new ArrayList();
    }

    @Override // com.adjust.sdk.ISdkClickHandler
    public void pauseSending() {
        this.paused = true;
    }

    @Override // com.adjust.sdk.ISdkClickHandler
    public void resumeSending() {
        this.paused = false;
        sendNextSdkClick();
    }

    @Override // com.adjust.sdk.ISdkClickHandler
    public void sendSdkClick(final ActivityPackage sdkClick) {
        this.scheduledExecutor.submit(new Runnable() { // from class: com.adjust.sdk.SdkClickHandler.1
            @Override // java.lang.Runnable
            public void run() {
                SdkClickHandler.this.packageQueue.add(sdkClick);
                SdkClickHandler.this.logger.debug("Added sdk_click %d", Integer.valueOf(SdkClickHandler.this.packageQueue.size()));
                SdkClickHandler.this.logger.verbose("%s", sdkClick.getExtendedString());
                SdkClickHandler.this.sendNextSdkClick();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendNextSdkClick() {
        this.scheduledExecutor.submit(new Runnable() { // from class: com.adjust.sdk.SdkClickHandler.2
            @Override // java.lang.Runnable
            public void run() {
                SdkClickHandler.this.sendNextSdkClickI();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendNextSdkClickI() {
        if (!this.paused && !this.packageQueue.isEmpty()) {
            final ActivityPackage sdkClickPackage = this.packageQueue.remove(0);
            int retries = sdkClickPackage.getRetries();
            Runnable runnable = new Runnable() { // from class: com.adjust.sdk.SdkClickHandler.3
                @Override // java.lang.Runnable
                public void run() {
                    SdkClickHandler.this.sendSdkClickI(sdkClickPackage);
                    SdkClickHandler.this.sendNextSdkClick();
                }
            };
            if (retries <= 0) {
                runnable.run();
                return;
            }
            long waitTimeMilliSeconds = Util.getWaitingTime(retries, this.backoffStrategy);
            double waitTimeSeconds = waitTimeMilliSeconds / 1000.0d;
            String secondsString = Util.SecondsDisplayFormat.format(waitTimeSeconds);
            this.logger.verbose("Waiting for %s seconds before retrying sdk_click for the %d time", secondsString, Integer.valueOf(retries));
            this.scheduledExecutor.schedule(runnable, waitTimeMilliSeconds, TimeUnit.MILLISECONDS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendSdkClickI(ActivityPackage sdkClickPackage) {
        String targetURL = Constants.BASE_URL + sdkClickPackage.getPath();
        try {
            HttpsURLConnection connection = Util.createPOSTHttpsURLConnection(targetURL, sdkClickPackage.getClientSdk(), sdkClickPackage.getParameters(), this.packageQueue.size() - 1);
            ResponseData responseData = Util.readHttpResponse(connection, sdkClickPackage);
            if (responseData.jsonResponse == null) {
                retrySendingI(sdkClickPackage);
            }
        } catch (UnsupportedEncodingException e) {
            logErrorMessageI(sdkClickPackage, "Sdk_click failed to encode parameters", e);
        } catch (SocketTimeoutException e2) {
            logErrorMessageI(sdkClickPackage, "Sdk_click request timed out. Will retry later", e2);
            retrySendingI(sdkClickPackage);
        } catch (IOException e3) {
            logErrorMessageI(sdkClickPackage, "Sdk_click request failed. Will retry later", e3);
            retrySendingI(sdkClickPackage);
        } catch (Throwable e4) {
            logErrorMessageI(sdkClickPackage, "Sdk_click runtime exception", e4);
        }
    }

    private void retrySendingI(ActivityPackage sdkClickPackage) {
        int retries = sdkClickPackage.increaseRetries();
        this.logger.error("Retrying sdk_click package for the %d time", Integer.valueOf(retries));
        sendSdkClick(sdkClickPackage);
    }

    private void logErrorMessageI(ActivityPackage sdkClickPackage, String message, Throwable throwable) {
        String packageMessage = sdkClickPackage.getFailureMessage();
        String reasonString = Util.getReasonString(message, throwable);
        String finalMessage = String.format("%s. (%s)", packageMessage, reasonString);
        this.logger.error(finalMessage, new Object[0]);
    }
}
