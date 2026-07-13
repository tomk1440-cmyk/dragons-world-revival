package com.google.android.gms.tagmanager;

import android.annotation.TargetApi;
import android.util.LruCache;

/* JADX INFO: loaded from: classes.dex */
@TargetApi(12)
class zzba<K, V> implements zzl<K, V> {
    private LruCache<K, V> zzbjq;

    zzba(int i, final zzm.zza<K, V> zzaVar) {
        this.zzbjq = new LruCache<K, V>(i) { // from class: com.google.android.gms.tagmanager.zzba.1
            @Override // android.util.LruCache
            protected int sizeOf(K key, V value) {
                return zzaVar.sizeOf(key, value);
            }
        };
    }

    @Override // com.google.android.gms.tagmanager.zzl
    public V get(K key) {
        return this.zzbjq.get(key);
    }

    @Override // com.google.android.gms.tagmanager.zzl
    public void zzh(K k, V v) {
        this.zzbjq.put(k, v);
    }
}
