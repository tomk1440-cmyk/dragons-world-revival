package com.google.android.gms.vision;

import android.util.SparseArray;

/* JADX INFO: loaded from: classes.dex */
public class zza {
    private SparseArray<Integer> zzbnm = new SparseArray<>();
    private SparseArray<Integer> zzbnn = new SparseArray<>();
    private static final Object zzqy = new Object();
    private static int zzbnl = 0;

    public int zzkr(int i) {
        int iIntValue;
        synchronized (zzqy) {
            Integer num = this.zzbnm.get(i);
            if (num != null) {
                iIntValue = num.intValue();
            } else {
                iIntValue = zzbnl;
                zzbnl++;
                this.zzbnm.append(i, Integer.valueOf(iIntValue));
                this.zzbnn.append(iIntValue, Integer.valueOf(i));
            }
        }
        return iIntValue;
    }

    public int zzks(int i) {
        int iIntValue;
        synchronized (zzqy) {
            iIntValue = this.zzbnn.get(i).intValue();
        }
        return iIntValue;
    }
}
