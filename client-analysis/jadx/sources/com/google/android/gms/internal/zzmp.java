package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Process;

/* JADX INFO: loaded from: classes.dex */
public class zzmp {
    public static boolean zzk(Context context, String str) {
        try {
            return (context.getPackageManager().getApplicationInfo(str, 0).flags & 2097152) != 0;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    public static boolean zzkr() {
        return com.google.android.gms.common.internal.zzd.zzakE && zzlz.isInitialized() && zzlz.zzpW() == Process.myUid();
    }
}
