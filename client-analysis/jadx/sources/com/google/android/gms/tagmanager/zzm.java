package com.google.android.gms.tagmanager;

import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
class zzm<K, V> {
    final zza<K, V> zzbhK = new zza<K, V>() { // from class: com.google.android.gms.tagmanager.zzm.1
        @Override // com.google.android.gms.tagmanager.zzm.zza
        public int sizeOf(K key, V value) {
            return 1;
        }
    };

    public interface zza<K, V> {
        int sizeOf(K k, V v);
    }

    int zzFY() {
        return Build.VERSION.SDK_INT;
    }

    public zzl<K, V> zza(int i, zza<K, V> zzaVar) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        return zzFY() < 12 ? new zzcw(i, zzaVar) : new zzba(i, zzaVar);
    }
}
