package com.google.android.gms.internal;

/* JADX INFO: loaded from: classes.dex */
public class zzm<T> {
    public final T result;
    public final com.google.android.gms.internal.zzb.zza zzag;
    public final zzr zzah;
    public boolean zzai;

    public interface zza {
        void zze(zzr zzrVar);
    }

    public interface zzb<T> {
        void zzb(T t);
    }

    private zzm(zzr zzrVar) {
        this.zzai = false;
        this.result = null;
        this.zzag = null;
        this.zzah = zzrVar;
    }

    private zzm(T t, com.google.android.gms.internal.zzb.zza zzaVar) {
        this.zzai = false;
        this.result = t;
        this.zzag = zzaVar;
        this.zzah = null;
    }

    public static <T> zzm<T> zza(T t, com.google.android.gms.internal.zzb.zza zzaVar) {
        return new zzm<>(t, zzaVar);
    }

    public static <T> zzm<T> zzd(zzr zzrVar) {
        return new zzm<>(zzrVar);
    }

    public boolean isSuccess() {
        return this.zzah == null;
    }
}
