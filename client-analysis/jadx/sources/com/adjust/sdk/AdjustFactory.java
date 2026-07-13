package com.adjust.sdk;

import android.content.Context;
import java.io.IOException;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

/* JADX INFO: loaded from: classes.dex */
public class AdjustFactory {
    private static IPackageHandler packageHandler = null;
    private static IRequestHandler requestHandler = null;
    private static IAttributionHandler attributionHandler = null;
    private static IActivityHandler activityHandler = null;
    private static ILogger logger = null;
    private static HttpsURLConnection httpsURLConnection = null;
    private static ISdkClickHandler sdkClickHandler = null;
    private static long timerInterval = -1;
    private static long timerStart = -1;
    private static long sessionInterval = -1;
    private static long subsessionInterval = -1;
    private static BackoffStrategy sdkClickBackoffStrategy = null;
    private static BackoffStrategy packageHandlerBackoffStrategy = null;
    private static long maxDelayStart = -1;

    public static class URLGetConnection {
        HttpsURLConnection httpsURLConnection;
        URL url;

        URLGetConnection(HttpsURLConnection httpsURLConnection, URL url) {
            this.httpsURLConnection = httpsURLConnection;
            this.url = url;
        }
    }

    public static IPackageHandler getPackageHandler(ActivityHandler activityHandler2, Context context, boolean startsSending) {
        if (packageHandler == null) {
            return new PackageHandler(activityHandler2, context, startsSending);
        }
        packageHandler.init(activityHandler2, context, startsSending);
        return packageHandler;
    }

    public static IRequestHandler getRequestHandler(IPackageHandler packageHandler2) {
        if (requestHandler == null) {
            return new RequestHandler(packageHandler2);
        }
        requestHandler.init(packageHandler2);
        return requestHandler;
    }

    public static ILogger getLogger() {
        if (logger == null) {
            logger = new Logger();
        }
        return logger;
    }

    public static long getTimerInterval() {
        if (timerInterval == -1) {
            return 60000L;
        }
        return timerInterval;
    }

    public static long getTimerStart() {
        if (timerStart == -1) {
            return 60000L;
        }
        return timerStart;
    }

    public static long getSessionInterval() {
        if (sessionInterval == -1) {
            return 1800000L;
        }
        return sessionInterval;
    }

    public static long getSubsessionInterval() {
        if (subsessionInterval == -1) {
            return 1000L;
        }
        return subsessionInterval;
    }

    public static BackoffStrategy getSdkClickBackoffStrategy() {
        return sdkClickBackoffStrategy == null ? BackoffStrategy.SHORT_WAIT : sdkClickBackoffStrategy;
    }

    public static BackoffStrategy getPackageHandlerBackoffStrategy() {
        return packageHandlerBackoffStrategy == null ? BackoffStrategy.LONG_WAIT : packageHandlerBackoffStrategy;
    }

    public static IActivityHandler getActivityHandler(AdjustConfig config) {
        if (activityHandler == null) {
            return ActivityHandler.getInstance(config);
        }
        activityHandler.init(config);
        return activityHandler;
    }

    public static IAttributionHandler getAttributionHandler(IActivityHandler activityHandler2, ActivityPackage attributionPackage, boolean startsSending) {
        if (attributionHandler == null) {
            return new AttributionHandler(activityHandler2, attributionPackage, startsSending);
        }
        attributionHandler.init(activityHandler2, attributionPackage, startsSending);
        return attributionHandler;
    }

    public static HttpsURLConnection getHttpsURLConnection(URL url) throws IOException {
        return httpsURLConnection == null ? (HttpsURLConnection) url.openConnection() : httpsURLConnection;
    }

    public static URLGetConnection getHttpsURLGetConnection(URL url) throws IOException {
        return httpsURLConnection == null ? new URLGetConnection((HttpsURLConnection) url.openConnection(), url) : new URLGetConnection(httpsURLConnection, url);
    }

    public static ISdkClickHandler getSdkClickHandler(boolean startsSending) {
        if (sdkClickHandler == null) {
            return new SdkClickHandler(startsSending);
        }
        sdkClickHandler.init(startsSending);
        return sdkClickHandler;
    }

    public static long getMaxDelayStart() {
        if (maxDelayStart == -1) {
            return 10000L;
        }
        return maxDelayStart;
    }

    public static void setPackageHandler(IPackageHandler packageHandler2) {
        packageHandler = packageHandler2;
    }

    public static void setRequestHandler(IRequestHandler requestHandler2) {
        requestHandler = requestHandler2;
    }

    public static void setLogger(ILogger logger2) {
        logger = logger2;
    }

    public static void setTimerInterval(long timerInterval2) {
        timerInterval = timerInterval2;
    }

    public static void setTimerStart(long timerStart2) {
        timerStart = timerStart2;
    }

    public static void setSessionInterval(long sessionInterval2) {
        sessionInterval = sessionInterval2;
    }

    public static void setSubsessionInterval(long subsessionInterval2) {
        subsessionInterval = subsessionInterval2;
    }

    public static void setSdkClickBackoffStrategy(BackoffStrategy sdkClickBackoffStrategy2) {
        sdkClickBackoffStrategy = sdkClickBackoffStrategy2;
    }

    public static void setPackageHandlerBackoffStrategy(BackoffStrategy packageHandlerBackoffStrategy2) {
        packageHandlerBackoffStrategy = packageHandlerBackoffStrategy2;
    }

    public static void setActivityHandler(IActivityHandler activityHandler2) {
        activityHandler = activityHandler2;
    }

    public static void setAttributionHandler(IAttributionHandler attributionHandler2) {
        attributionHandler = attributionHandler2;
    }

    public static void setHttpsURLConnection(HttpsURLConnection httpsURLConnection2) {
        httpsURLConnection = httpsURLConnection2;
    }

    public static void setSdkClickHandler(ISdkClickHandler sdkClickHandler2) {
        sdkClickHandler = sdkClickHandler2;
    }
}
