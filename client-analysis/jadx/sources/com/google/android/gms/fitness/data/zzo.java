package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class zzo implements Parcelable.Creator<RawDataPoint> {
    static void zza(RawDataPoint rawDataPoint, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, rawDataPoint.zzawj);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, rawDataPoint.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, rawDataPoint.zzawk);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, (Parcelable[]) rawDataPoint.zzawl, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 4, rawDataPoint.zzaxg);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 5, rawDataPoint.zzaxh);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, rawDataPoint.zzawn);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, rawDataPoint.zzawo);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzcZ, reason: merged with bridge method [inline-methods] */
    public RawDataPoint createFromParcel(Parcel parcel) {
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int iZzg = 0;
        long jZzi = 0;
        long jZzi2 = 0;
        Value[] valueArr = null;
        int iZzg2 = 0;
        int iZzg3 = 0;
        long jZzi3 = 0;
        long jZzi4 = 0;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    jZzi = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, iZzat);
                    break;
                case 2:
                    jZzi2 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, iZzat);
                    break;
                case 3:
                    valueArr = (Value[]) com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat, Value.CREATOR);
                    break;
                case 4:
                    iZzg2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 5:
                    iZzg3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 6:
                    jZzi3 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, iZzat);
                    break;
                case 7:
                    jZzi4 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, iZzat);
                    break;
                case 1000:
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat);
                    break;
            }
        }
        if (parcel.dataPosition() != iZzau) {
            throw new com.google.android.gms.common.internal.safeparcel.zza.C0052zza("Overread allowed size end=" + iZzau, parcel);
        }
        return new RawDataPoint(iZzg, jZzi, jZzi2, valueArr, iZzg2, iZzg3, jZzi3, jZzi4);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzeY, reason: merged with bridge method [inline-methods] */
    public RawDataPoint[] newArray(int i) {
        return new RawDataPoint[i];
    }
}
