package com.socialquantum.dw.utils;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import com.unity3d.player.UnityPlayer;

/* JADX INFO: loaded from: classes.dex */
public class RedirectUtil {
    public static void RedirectToGooglePlay() {
        String appName = UnityPlayer.currentActivity.getPackageName();
        try {
            UnityPlayer.currentActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + appName)));
        } catch (ActivityNotFoundException e) {
            UnityPlayer.currentActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://play.google.com/store/apps/details?id=" + appName)));
        }
    }
}
