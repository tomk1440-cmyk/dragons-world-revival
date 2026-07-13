package com.google.android.gms.internal;

import android.os.StrictMode;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzjb {
    public static <T> T zzb(Callable<T> callable) {
        T tCall;
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        try {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitDiskReads().permitDiskWrites().build());
            tCall = callable.call();
        } catch (Throwable th) {
            zzin.zzb("Unexpected exception.", th);
            com.google.android.gms.ads.internal.zzr.zzbF().zzb(th, true);
            tCall = null;
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
        return tCall;
    }
}
