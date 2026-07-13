package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zziv {
    private final String[] zzMn;
    private final double[] zzMo;
    private final double[] zzMp;
    private final int[] zzMq;
    private int zzMr;

    public static class zza {
        public final int count;
        public final String name;
        public final double zzMs;
        public final double zzMt;
        public final double zzMu;

        public zza(String str, double d, double d2, double d3, int i) {
            this.name = str;
            this.zzMt = d;
            this.zzMs = d2;
            this.zzMu = d3;
            this.count = i;
        }

        public boolean equals(Object other) {
            if (!(other instanceof zza)) {
                return false;
            }
            zza zzaVar = (zza) other;
            return com.google.android.gms.common.internal.zzw.equal(this.name, zzaVar.name) && this.zzMs == zzaVar.zzMs && this.zzMt == zzaVar.zzMt && this.count == zzaVar.count && Double.compare(this.zzMu, zzaVar.zzMu) == 0;
        }

        public int hashCode() {
            return com.google.android.gms.common.internal.zzw.hashCode(this.name, Double.valueOf(this.zzMs), Double.valueOf(this.zzMt), Double.valueOf(this.zzMu), Integer.valueOf(this.count));
        }

        public String toString() {
            return com.google.android.gms.common.internal.zzw.zzy(this).zzg("name", this.name).zzg("minBound", Double.valueOf(this.zzMt)).zzg("maxBound", Double.valueOf(this.zzMs)).zzg("percent", Double.valueOf(this.zzMu)).zzg("count", Integer.valueOf(this.count)).toString();
        }
    }

    public static class zzb {
        private final List<String> zzMv = new ArrayList();
        private final List<Double> zzMw = new ArrayList();
        private final List<Double> zzMx = new ArrayList();

        public zzb zza(String str, double d, double d2) {
            int i;
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= this.zzMv.size()) {
                    break;
                }
                double dDoubleValue = this.zzMx.get(i).doubleValue();
                double dDoubleValue2 = this.zzMw.get(i).doubleValue();
                if (d < dDoubleValue || (dDoubleValue == d && d2 < dDoubleValue2)) {
                    break;
                }
                i2 = i + 1;
            }
            this.zzMv.add(i, str);
            this.zzMx.add(i, Double.valueOf(d));
            this.zzMw.add(i, Double.valueOf(d2));
            return this;
        }

        public zziv zzhA() {
            return new zziv(this);
        }
    }

    private zziv(zzb zzbVar) {
        int size = zzbVar.zzMw.size();
        this.zzMn = (String[]) zzbVar.zzMv.toArray(new String[size]);
        this.zzMo = zzk(zzbVar.zzMw);
        this.zzMp = zzk(zzbVar.zzMx);
        this.zzMq = new int[size];
        this.zzMr = 0;
    }

    private double[] zzk(List<Double> list) {
        double[] dArr = new double[list.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= dArr.length) {
                return dArr;
            }
            dArr[i2] = list.get(i2).doubleValue();
            i = i2 + 1;
        }
    }

    public List<zza> getBuckets() {
        ArrayList arrayList = new ArrayList(this.zzMn.length);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.zzMn.length) {
                return arrayList;
            }
            arrayList.add(new zza(this.zzMn[i2], this.zzMp[i2], this.zzMo[i2], ((double) this.zzMq[i2]) / ((double) this.zzMr), this.zzMq[i2]));
            i = i2 + 1;
        }
    }

    public void zza(double d) {
        this.zzMr++;
        for (int i = 0; i < this.zzMp.length; i++) {
            if (this.zzMp[i] <= d && d < this.zzMo[i]) {
                int[] iArr = this.zzMq;
                iArr[i] = iArr[i] + 1;
            }
            if (d < this.zzMp[i]) {
                return;
            }
        }
    }
}
