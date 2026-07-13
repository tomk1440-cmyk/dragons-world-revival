package com.facebook.unity;

import android.app.Activity;
import android.util.Log;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class UnityReflection {
    private static Class<?> unityPlayer;

    public static void SendMessage(String unityObject, String unityMethod, String message) {
        try {
            if (unityPlayer == null) {
                unityPlayer = Class.forName("com.unity3d.player.UnityPlayer");
            }
            Method method = unityPlayer.getMethod("UnitySendMessage", String.class, String.class, String.class);
            method.invoke(unityPlayer, unityObject, unityMethod, message);
        } catch (Exception ex) {
            Log.d("TODO", ex.toString());
        }
    }

    public static Activity GetUnityActivity() {
        try {
            if (unityPlayer == null) {
                unityPlayer = Class.forName("com.unity3d.player.UnityPlayer");
            }
            Activity activity = (Activity) unityPlayer.getField("currentActivity").get(null);
            if (activity == null) {
                Log.d(FB.TAG, "Current unity activity is null");
                return activity;
            }
            return activity;
        } catch (Exception ex) {
            Log.d(FB.TAG, ex.toString());
            return null;
        }
    }
}
