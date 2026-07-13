package com.google.android.gms.fitness.data;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class zzu implements Parcelable.Creator<Value> {
    static void zza(Value value, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, value.getFormat());
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, value.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, value.isSet());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, value.zzuv());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, value.zzuA(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, value.zzuB(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, value.zzuC(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, value.zzuD(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 8, value.zzuE(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzde, reason: merged with bridge method [inline-methods] */
    public Value createFromParcel(Parcel parcel) {
        boolean zZzc = false;
        byte[] bArrZzs = null;
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        float fZzl = 0.0f;
        float[] fArrZzy = null;
        int[] iArrZzv = null;
        Bundle bundleZzr = null;
        String strZzp = null;
        int iZzg = 0;
        int iZzg2 = 0;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 2:
                    zZzc = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat);
                    break;
                case 3:
                    fZzl = com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, iZzat);
                    break;
                case 4:
                    strZzp = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 5:
                    bundleZzr = com.google.android.gms.common.internal.safeparcel.zza.zzr(parcel, iZzat);
                    break;
                case 6:
                    iArrZzv = com.google.android.gms.common.internal.safeparcel.zza.zzv(parcel, iZzat);
                    break;
                case 7:
                    fArrZzy = com.google.android.gms.common.internal.safeparcel.zza.zzy(parcel, iZzat);
                    break;
                case 8:
                    bArrZzs = com.google.android.gms.common.internal.safeparcel.zza.zzs(parcel, iZzat);
                    break;
                case 1000:
                    iZzg2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat);
                    break;
            }
        }
        if (parcel.dataPosition() != iZzau) {
            throw new com.google.android.gms.common.internal.safeparcel.zza.C0052zza("Overread allowed size end=" + iZzau, parcel);
        }
        return new Value(iZzg2, iZzg, zZzc, fZzl, strZzp, bundleZzr, iArrZzv, fArrZzy, bArrZzs);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzfe, reason: merged with bridge method [inline-methods] */
    public Value[] newArray(int i) {
        return new Value[i];
    }
}
