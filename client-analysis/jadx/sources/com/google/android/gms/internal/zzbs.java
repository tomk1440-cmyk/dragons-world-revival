package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzbs {
    private final Object zzpV = new Object();
    private boolean zzqA = false;
    private SharedPreferences zzvx = null;

    public void initialize(Context context) {
        synchronized (this.zzpV) {
            if (this.zzqA) {
                return;
            }
            Context remoteContext = com.google.android.gms.common.zze.getRemoteContext(context);
            if (remoteContext == null) {
                return;
            }
            this.zzvx = com.google.android.gms.ads.internal.zzr.zzbJ().zzw(remoteContext);
            this.zzqA = true;
        }
    }

    public <T> T zzd(final zzbp<T> zzbpVar) {
        synchronized (this.zzpV) {
            if (this.zzqA) {
                return (T) zzjb.zzb(new Callable<T>() { // from class: com.google.android.gms.internal.zzbs.1
                    @Override // java.util.concurrent.Callable
                    public T call() {
                        return (T) zzbpVar.zza(zzbs.this.zzvx);
                    }
                });
            }
            return zzbpVar.zzdq();
        }
    }
}
