package com.adjust.sdk;

import android.net.Uri;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class AttributionHandler implements IAttributionHandler {
    private static final String ATTRIBUTION_TIMER_NAME = "Attribution timer";
    private WeakReference<IActivityHandler> activityHandlerWeakRef;
    private ActivityPackage attributionPackage;
    public URL lastUrlUsed;
    private boolean paused;
    private CustomScheduledExecutor scheduledExecutor = new CustomScheduledExecutor("AttributionHandler");
    private ILogger logger = AdjustFactory.getLogger();
    private TimerOnce timer = new TimerOnce(this.scheduledExecutor, new Runnable() { // from class: com.adjust.sdk.AttributionHandler.1
        @Override // java.lang.Runnable
        public void run() {
            AttributionHandler.this.sendAttributionRequestI();
        }
    }, ATTRIBUTION_TIMER_NAME);

    @Override // com.adjust.sdk.IAttributionHandler
    public void teardown() {
        this.logger.verbose("AttributionHandler teardown", new Object[0]);
        if (this.timer != null) {
            this.timer.teardown();
        }
        if (this.scheduledExecutor != null) {
            try {
                this.scheduledExecutor.shutdownNow();
            } catch (SecurityException e) {
            }
        }
        if (this.activityHandlerWeakRef != null) {
            this.activityHandlerWeakRef.clear();
        }
        this.scheduledExecutor = null;
        this.activityHandlerWeakRef = null;
        this.logger = null;
        this.attributionPackage = null;
        this.timer = null;
    }

    public AttributionHandler(IActivityHandler activityHandler, ActivityPackage attributionPackage, boolean startsSending) {
        init(activityHandler, attributionPackage, startsSending);
    }

    @Override // com.adjust.sdk.IAttributionHandler
    public void init(IActivityHandler activityHandler, ActivityPackage attributionPackage, boolean startsSending) {
        this.activityHandlerWeakRef = new WeakReference<>(activityHandler);
        this.attributionPackage = attributionPackage;
        this.paused = !startsSending;
    }

    @Override // com.adjust.sdk.IAttributionHandler
    public void getAttribution() {
        this.scheduledExecutor.submit(new Runnable() { // from class: com.adjust.sdk.AttributionHandler.2
            @Override // java.lang.Runnable
            public void run() {
                AttributionHandler.this.getAttributionI(0L);
            }
        });
    }

    @Override // com.adjust.sdk.IAttributionHandler
    public void checkSessionResponse(final SessionResponseData sessionResponseData) {
        this.scheduledExecutor.submit(new Runnable() { // from class: com.adjust.sdk.AttributionHandler.3
            @Override // java.lang.Runnable
            public void run() {
                IActivityHandler activityHandler = (IActivityHandler) AttributionHandler.this.activityHandlerWeakRef.get();
                if (activityHandler != null) {
                    AttributionHandler.this.checkSessionResponseI(activityHandler, sessionResponseData);
                }
            }
        });
    }

    public void checkAttributionResponse(final AttributionResponseData attributionResponseData) {
        this.scheduledExecutor.submit(new Runnable() { // from class: com.adjust.sdk.AttributionHandler.4
            @Override // java.lang.Runnable
            public void run() {
                IActivityHandler activityHandler = (IActivityHandler) AttributionHandler.this.activityHandlerWeakRef.get();
                if (activityHandler != null) {
                    AttributionHandler.this.checkAttributionResponseI(activityHandler, attributionResponseData);
                }
            }
        });
    }

    @Override // com.adjust.sdk.IAttributionHandler
    public void pauseSending() {
        this.paused = true;
    }

    @Override // com.adjust.sdk.IAttributionHandler
    public void resumeSending() {
        this.paused = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getAttributionI(long delayInMilliseconds) {
        if (this.timer.getFireIn() <= delayInMilliseconds) {
            if (delayInMilliseconds != 0) {
                double waitTimeSeconds = delayInMilliseconds / 1000.0d;
                String secondsString = Util.SecondsDisplayFormat.format(waitTimeSeconds);
                this.logger.debug("Waiting to query attribution in %s seconds", secondsString);
            }
            this.timer.startIn(delayInMilliseconds);
        }
    }

    private void checkAttributionI(IActivityHandler activityHandler, ResponseData responseData) {
        if (responseData.jsonResponse != null) {
            long timerMilliseconds = responseData.jsonResponse.optLong("ask_in", -1L);
            if (timerMilliseconds >= 0) {
                activityHandler.setAskingAttribution(true);
                getAttributionI(timerMilliseconds);
            } else {
                activityHandler.setAskingAttribution(false);
                JSONObject attributionJson = responseData.jsonResponse.optJSONObject("attribution");
                responseData.attribution = AdjustAttribution.fromJson(attributionJson, responseData.adid);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkSessionResponseI(IActivityHandler activityHandler, SessionResponseData sessionResponseData) {
        checkAttributionI(activityHandler, sessionResponseData);
        activityHandler.launchSessionResponseTasks(sessionResponseData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkAttributionResponseI(IActivityHandler activityHandler, AttributionResponseData attributionResponseData) {
        checkAttributionI(activityHandler, attributionResponseData);
        checkDeeplinkI(attributionResponseData);
        activityHandler.launchAttributionResponseTasks(attributionResponseData);
    }

    private void checkDeeplinkI(AttributionResponseData attributionResponseData) {
        JSONObject attributionJson;
        String deeplinkString;
        if (attributionResponseData.jsonResponse != null && (attributionJson = attributionResponseData.jsonResponse.optJSONObject("attribution")) != null && (deeplinkString = attributionJson.optString(Constants.DEEPLINK, null)) != null) {
            attributionResponseData.deeplink = Uri.parse(deeplinkString);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendAttributionRequestI() {
        if (this.paused) {
            this.logger.debug("Attribution handler is paused", new Object[0]);
            return;
        }
        this.logger.verbose("%s", this.attributionPackage.getExtendedString());
        try {
            AdjustFactory.URLGetConnection urlGetConnection = Util.createGETHttpsURLConnection(buildUriI(this.attributionPackage.getPath(), this.attributionPackage.getParameters()).toString(), this.attributionPackage.getClientSdk());
            ResponseData responseData = Util.readHttpResponse(urlGetConnection.httpsURLConnection, this.attributionPackage);
            this.lastUrlUsed = urlGetConnection.url;
            if (responseData instanceof AttributionResponseData) {
                checkAttributionResponse((AttributionResponseData) responseData);
            }
        } catch (Exception e) {
            this.logger.error("Failed to get attribution (%s)", e.getMessage());
        }
    }

    private Uri buildUriI(String path, Map<String, String> parameters) {
        Uri.Builder uriBuilder = new Uri.Builder();
        uriBuilder.scheme(Constants.SCHEME);
        uriBuilder.authority(Constants.AUTHORITY);
        uriBuilder.appendPath(path);
        for (Map.Entry<String, String> entry : parameters.entrySet()) {
            uriBuilder.appendQueryParameter(entry.getKey(), entry.getValue());
        }
        long now = System.currentTimeMillis();
        String dateString = Util.dateFormatter.format(Long.valueOf(now));
        uriBuilder.appendQueryParameter("sent_at", dateString);
        return uriBuilder.build();
    }
}
