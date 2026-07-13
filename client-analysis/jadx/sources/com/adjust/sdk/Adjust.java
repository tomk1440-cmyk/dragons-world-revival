package com.adjust.sdk;

import android.content.Context;
import android.net.Uri;

/* JADX INFO: loaded from: classes.dex */
public class Adjust {
    private static AdjustInstance defaultInstance;

    private Adjust() {
    }

    public static synchronized AdjustInstance getDefaultInstance() {
        if (defaultInstance == null) {
            defaultInstance = new AdjustInstance();
        }
        return defaultInstance;
    }

    public static void onCreate(AdjustConfig adjustConfig) {
        AdjustInstance adjustInstance = getDefaultInstance();
        adjustInstance.onCreate(adjustConfig);
    }

    public static void trackEvent(AdjustEvent event) {
        AdjustInstance adjustInstance = getDefaultInstance();
        adjustInstance.trackEvent(event);
    }

    public static void onResume() {
        AdjustInstance adjustInstance = getDefaultInstance();
        adjustInstance.onResume();
    }

    public static void onPause() {
        AdjustInstance adjustInstance = getDefaultInstance();
        adjustInstance.onPause();
    }

    public static void setEnabled(boolean enabled) {
        AdjustInstance adjustInstance = getDefaultInstance();
        adjustInstance.setEnabled(enabled);
    }

    public static boolean isEnabled() {
        AdjustInstance adjustInstance = getDefaultInstance();
        return adjustInstance.isEnabled();
    }

    public static void appWillOpenUrl(Uri url) {
        AdjustInstance adjustInstance = getDefaultInstance();
        adjustInstance.appWillOpenUrl(url);
    }

    public static void setReferrer(String referrer) {
        AdjustInstance adjustInstance = getDefaultInstance();
        adjustInstance.sendReferrer(referrer);
    }

    public static void setOfflineMode(boolean enabled) {
        AdjustInstance adjustInstance = getDefaultInstance();
        adjustInstance.setOfflineMode(enabled);
    }

    public static void sendFirstPackages() {
        AdjustInstance adjustInstance = getDefaultInstance();
        adjustInstance.sendFirstPackages();
    }

    public static void addSessionCallbackParameter(String key, String value) {
        AdjustInstance adjustInstance = getDefaultInstance();
        adjustInstance.addSessionCallbackParameter(key, value);
    }

    public static void addSessionPartnerParameter(String key, String value) {
        AdjustInstance adjustInstance = getDefaultInstance();
        adjustInstance.addSessionPartnerParameter(key, value);
    }

    public static void removeSessionCallbackParameter(String key) {
        AdjustInstance adjustInstance = getDefaultInstance();
        adjustInstance.removeSessionCallbackParameter(key);
    }

    public static void removeSessionPartnerParameter(String key) {
        AdjustInstance adjustInstance = getDefaultInstance();
        adjustInstance.removeSessionPartnerParameter(key);
    }

    public static void resetSessionCallbackParameters() {
        AdjustInstance adjustInstance = getDefaultInstance();
        adjustInstance.resetSessionCallbackParameters();
    }

    public static void resetSessionPartnerParameters() {
        AdjustInstance adjustInstance = getDefaultInstance();
        adjustInstance.resetSessionPartnerParameters();
    }

    public static void setPushToken(String token) {
        AdjustInstance adjustInstance = getDefaultInstance();
        adjustInstance.setPushToken(token);
    }

    public static void getGoogleAdId(Context context, OnDeviceIdsRead onDeviceIdRead) {
        Util.getGoogleAdId(context, onDeviceIdRead);
    }

    public static String getAdid() {
        AdjustInstance adjustInstance = getDefaultInstance();
        return adjustInstance.getAdid();
    }

    public static AdjustAttribution getAttribution() {
        AdjustInstance adjustInstance = getDefaultInstance();
        return adjustInstance.getAttribution();
    }
}
