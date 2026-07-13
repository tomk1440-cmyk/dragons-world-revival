package com.google.android.gms.tagmanager;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class zzcw<K, V> implements zzl<K, V> {
    private final Map<K, V> zzbld = new HashMap();
    private final int zzble;
    private final zzm.zza<K, V> zzblf;
    private int zzblg;

    zzcw(int i, zzm.zza<K, V> zzaVar) {
        this.zzble = i;
        this.zzblf = zzaVar;
    }

    @Override // com.google.android.gms.tagmanager.zzl
    public synchronized V get(K key) {
        return this.zzbld.get(key);
    }

    @Override // com.google.android.gms.tagmanager.zzl
    public synchronized void zzh(K k, V v) {
        try {
            if (k == null || v == null) {
                throw new NullPointerException("key == null || value == null");
            }
            this.zzblg += this.zzblf.sizeOf(k, v);
            if (this.zzblg > this.zzble) {
                Iterator<Map.Entry<K, V>> it = this.zzbld.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<K, V> next = it.next();
                    this.zzblg -= this.zzblf.sizeOf(next.getKey(), next.getValue());
                    it.remove();
                    if (this.zzblg <= this.zzble) {
                        break;
                    }
                }
            }
            this.zzbld.put(k, v);
        } catch (Throwable th) {
            throw th;
        }
    }
}
