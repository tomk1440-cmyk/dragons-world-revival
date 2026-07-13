package com.google.android.gms.internal;

/* JADX INFO: loaded from: classes.dex */
public interface zzji<T> {

    public interface zza {
        void run();
    }

    public static class zzb implements zza {
        @Override // com.google.android.gms.internal.zzji.zza
        public void run() {
        }
    }

    public interface zzc<T> {
        void zze(T t);
    }

    void zza(zzc<T> zzcVar, zza zzaVar);

    void zzh(T t);
}
