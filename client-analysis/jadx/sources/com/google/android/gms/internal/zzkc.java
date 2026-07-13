package com.google.android.gms.internal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzkc extends com.google.android.gms.measurement.zze<zzkc> {
    private Map<Integer, Double> zzPM = new HashMap(4);

    public String toString() {
        HashMap map = new HashMap();
        for (Map.Entry<Integer, Double> entry : this.zzPM.entrySet()) {
            map.put("metric" + entry.getKey(), entry.getValue());
        }
        return zzF(map);
    }

    @Override // com.google.android.gms.measurement.zze
    public void zza(zzkc zzkcVar) {
        zzkcVar.zzPM.putAll(this.zzPM);
    }

    public Map<Integer, Double> zziQ() {
        return Collections.unmodifiableMap(this.zzPM);
    }
}
