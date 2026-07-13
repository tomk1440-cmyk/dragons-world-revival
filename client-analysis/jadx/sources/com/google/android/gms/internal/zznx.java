package com.google.android.gms.internal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class zznx {
    private static final double zzazE = 1000.0d / TimeUnit.SECONDS.toNanos(1);
    private static final double zzazF = 1000.0d / TimeUnit.SECONDS.toNanos(1);
    private static final zznx zzazI = new zznx();
    private final Map<String, Map<String, zza>> zzazG;
    private final Map<String, zza> zzazH;

    public static class zza {
        private final double zzazJ;
        private final double zzazK;

        private zza(double d, double d2) {
            this.zzazJ = d;
            this.zzazK = d2;
        }

        public boolean zzh(double d) {
            return d >= this.zzazJ && d <= this.zzazK;
        }
    }

    private zznx() {
        double d = 1000.0d;
        double d2 = 100.0d;
        double d3 = 0.0d;
        HashMap map = new HashMap();
        map.put(zznt.zzaxF.name, new zza(-90.0d, 90.0d));
        map.put(zznt.zzaxG.name, new zza(-180.0d, 180.0d));
        map.put(zznt.zzaxH.name, new zza(d3, 10000.0d));
        map.put(zznt.zzaxE.name, new zza(d3, d));
        map.put(zznt.zzaxI.name, new zza(-100000.0d, 100000.0d));
        map.put(zznt.zzaxP.name, new zza(d3, d2));
        map.put(zznt.zzaxx.name, new zza(d3, d2));
        map.put(zznt.zzaxA.name, new zza(d3, 9.223372036854776E18d));
        map.put(zznt.zzaxM.name, new zza(d3, 10.0d));
        map.put(zznt.zzaxN.name, new zza(d3, d));
        map.put(zznt.zzaxQ.name, new zza(d3, 200000.0d));
        this.zzazH = Collections.unmodifiableMap(map);
        HashMap map2 = new HashMap();
        map2.put("com.google.step_count.delta", zzf(zznt.zzaxz.name, new zza(d3, zzazE)));
        map2.put("com.google.calories.consumed", zzf(zznt.zzaxT.name, new zza(d3, zzazF)));
        map2.put("com.google.calories.expended", zzf(zznt.zzaxT.name, new zza(d3, zzazF)));
        this.zzazG = Collections.unmodifiableMap(map2);
    }

    private static <K, V> Map<K, V> zzf(K k, V v) {
        HashMap map = new HashMap();
        map.put(k, v);
        return map;
    }

    public static zznx zzuG() {
        return zzazI;
    }

    public zza zzC(String str, String str2) {
        Map<String, zza> map = this.zzazG.get(str);
        if (map != null) {
            return map.get(str2);
        }
        return null;
    }

    public zza zzdE(String str) {
        return this.zzazH.get(str);
    }
}
