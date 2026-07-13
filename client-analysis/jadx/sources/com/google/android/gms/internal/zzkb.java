package com.google.android.gms.internal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzkb extends com.google.android.gms.measurement.zze<zzkb> {
    private Map<Integer, String> zzPL = new HashMap(4);

    public String toString() {
        HashMap map = new HashMap();
        for (Map.Entry<Integer, String> entry : this.zzPL.entrySet()) {
            map.put("dimension" + entry.getKey(), entry.getValue());
        }
        return zzF(map);
    }

    @Override // com.google.android.gms.measurement.zze
    public void zza(zzkb zzkbVar) {
        zzkbVar.zzPL.putAll(this.zzPL);
    }

    public Map<Integer, String> zziP() {
        return Collections.unmodifiableMap(this.zzPL);
    }
}
