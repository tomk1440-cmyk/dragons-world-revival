package com.google.android.gms.internal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzkd extends com.google.android.gms.measurement.zze<zzkd> {
    private final Map<String, Object> zzxA = new HashMap();

    private String zzaW(String str) {
        com.google.android.gms.common.internal.zzx.zzcM(str);
        if (str != null && str.startsWith("&")) {
            str = str.substring(1);
        }
        com.google.android.gms.common.internal.zzx.zzh(str, "Name can not be empty or \"&\"");
        return str;
    }

    public void set(String name, String value) {
        this.zzxA.put(zzaW(name), value);
    }

    public String toString() {
        return zzF(this.zzxA);
    }

    @Override // com.google.android.gms.measurement.zze
    public void zza(zzkd zzkdVar) {
        com.google.android.gms.common.internal.zzx.zzz(zzkdVar);
        zzkdVar.zzxA.putAll(this.zzxA);
    }

    public Map<String, Object> zziR() {
        return Collections.unmodifiableMap(this.zzxA);
    }
}
