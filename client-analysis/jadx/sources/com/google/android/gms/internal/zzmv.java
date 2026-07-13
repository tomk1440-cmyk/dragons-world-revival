package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import android.os.SystemClock;

/* JADX INFO: loaded from: classes.dex */
public final class zzmv {
    private static long zzaoc;
    private static IntentFilter zzaob = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    private static float zzaod = Float.NaN;

    @TargetApi(20)
    public static int zzax(Context context) {
        if (context == null || context.getApplicationContext() == null) {
            return -1;
        }
        Intent intentRegisterReceiver = context.getApplicationContext().registerReceiver(null, zzaob);
        boolean z = ((intentRegisterReceiver == null ? 0 : intentRegisterReceiver.getIntExtra("plugged", 0)) & 7) != 0;
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager == null) {
            return -1;
        }
        return ((zzne.zzsl() ? powerManager.isInteractive() : powerManager.isScreenOn() ? 1 : 0) << 1) | (z ? 1 : 0);
    }

    public static synchronized float zzay(Context context) {
        float f;
        if (SystemClock.elapsedRealtime() - zzaoc >= 60000 || zzaod == Float.NaN) {
            Intent intentRegisterReceiver = context.getApplicationContext().registerReceiver(null, zzaob);
            if (intentRegisterReceiver != null) {
                zzaod = intentRegisterReceiver.getIntExtra("level", -1) / intentRegisterReceiver.getIntExtra("scale", -1);
            }
            zzaoc = SystemClock.elapsedRealtime();
            f = zzaod;
        } else {
            f = zzaod;
        }
        return f;
    }
}
