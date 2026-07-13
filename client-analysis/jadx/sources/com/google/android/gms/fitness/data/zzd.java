package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class zzd implements Parcelable.Creator<DataPoint> {
    static void zza(DataPoint dataPoint, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, (Parcelable) dataPoint.getDataSource(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, dataPoint.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, dataPoint.getTimestampNanos());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, dataPoint.zzuj());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, (Parcelable[]) dataPoint.zzuf(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, (Parcelable) dataPoint.getOriginalDataSource(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, dataPoint.zzug());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 8, dataPoint.zzuh());
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzcQ, reason: merged with bridge method [inline-methods] */
    public DataPoint createFromParcel(Parcel parcel) {
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int iZzg = 0;
        DataSource dataSource = null;
        long jZzi = 0;
        long jZzi2 = 0;
        Value[] valueArr = null;
        DataSource dataSource2 = null;
        long jZzi3 = 0;
        long jZzi4 = 0;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    dataSource = (DataSource) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, DataSource.CREATOR);
                    break;
                case 3:
                    jZzi = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, iZzat);
                    break;
                case 4:
                    jZzi2 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, iZzat);
                    break;
                case 5:
                    valueArr = (Value[]) com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat, Value.CREATOR);
                    break;
                case 6:
                    dataSource2 = (DataSource) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, DataSource.CREATOR);
                    break;
                case 7:
                    jZzi3 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, iZzat);
                    break;
                case 8:
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
        return new DataPoint(iZzg, dataSource, jZzi, jZzi2, valueArr, dataSource2, jZzi3, jZzi4);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzeP, reason: merged with bridge method [inline-methods] */
    public DataPoint[] newArray(int i) {
        return new DataPoint[i];
    }
}
