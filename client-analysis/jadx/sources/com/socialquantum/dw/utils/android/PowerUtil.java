package com.socialquantum.dw.utils.android;

import android.os.PowerManager;
import android.util.Log;
import com.unity3d.player.UnityPlayer;

/* JADX INFO: loaded from: classes.dex */
public class PowerUtil {
    private static final String TAG = "PowerUtil";
    private static PowerManager.WakeLock mWakeLock;

    public static void WakeLock() {
        Log.i(TAG, "WakeLock");
        try {
            if (mWakeLock != null) {
                Log.i("PWR", "WakeLock release");
                mWakeLock.release();
                mWakeLock = null;
            }
        } catch (Exception ex) {
            Log.e(TAG, "Close exist WakeLock", ex);
        }
        try {
            Log.i(TAG, "WakeLock acquire");
            PowerManager pm = (PowerManager) UnityPlayer.currentActivity.getSystemService("power");
            mWakeLock = pm.newWakeLock(536870918, "My Tag");
            mWakeLock.acquire();
        } catch (Exception ex2) {
            Log.e(TAG, "WakeLock", ex2);
        }
    }

    public static void WakeUnlock() {
        Log.i(TAG, "WakeUnlock");
        try {
            if (mWakeLock != null) {
                Log.i(TAG, "WakeUnlock release");
                mWakeLock.release();
            }
        } catch (Exception ex) {
            Log.e(TAG, "WakeUnlock", ex);
        }
    }
}
