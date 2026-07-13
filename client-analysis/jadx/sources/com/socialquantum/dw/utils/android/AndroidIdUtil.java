package com.socialquantum.dw.utils.android;

import android.provider.Settings;
import android.util.Log;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.unity3d.player.UnityPlayer;

/* JADX INFO: loaded from: classes.dex */
public class AndroidIdUtil {
    private static boolean sceneLoadedFlag = false;

    public static String getAndroidDeviceId() {
        try {
            return Settings.Secure.getString(UnityPlayer.currentActivity.getContentResolver(), "android_id");
        } catch (Exception e) {
            return "";
        }
    }

    public static void generateCrash() {
        UnityPlayer.currentActivity.finish();
    }

    public static String getAdvertisingId() {
        try {
            AdvertisingIdClient.Info adInfo = AdvertisingIdClient.getAdvertisingIdInfo(UnityPlayer.currentActivity);
            return adInfo.getId();
        } catch (Exception e) {
            return "";
        }
    }

    public static String getODIN() {
        try {
            UnityPlayer.currentActivity.getApplication();
            String androidId = Settings.System.getString(UnityPlayer.currentActivity.getContentResolver(), "android_id");
            return OdinGenerator.SHA1(androidId);
        } catch (Exception e) {
            return null;
        }
    }

    public static void setSceneLoadedFlag() {
        Log.w("UnityAndroidUtils", "Scene loaded set!");
        sceneLoadedFlag = true;
    }

    public static boolean sceneLoaded() {
        Log.w("UnityAndroidUtils", "Scene loaded valuse = " + sceneLoadedFlag);
        return sceneLoadedFlag;
    }
}
