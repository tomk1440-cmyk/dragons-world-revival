package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class zzh implements Parcelable.Creator<DataUpdateNotification> {
    static void zza(DataUpdateNotification dataUpdateNotification, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, dataUpdateNotification.zzup());
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, dataUpdateNotification.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, dataUpdateNotification.zzuq());
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 3, dataUpdateNotification.getOperationType());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, (Parcelable) dataUpdateNotification.getDataSource(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, (Parcelable) dataUpdateNotification.getDataType(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzcU, reason: merged with bridge method [inline-methods] */
    public DataUpdateNotification createFromParcel(Parcel parcel) {
        long jZzi = 0;
        DataType dataType = null;
        int iZzg = 0;
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        DataSource dataSource = null;
        long jZzi2 = 0;
        int iZzg2 = 0;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    jZzi2 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, iZzat);
                    break;
                case 2:
                    jZzi = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, iZzat);
                    break;
                case 3:
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 4:
                    dataSource = (DataSource) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, DataSource.CREATOR);
                    break;
                case 5:
                    dataType = (DataType) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, DataType.CREATOR);
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
        return new DataUpdateNotification(iZzg2, jZzi2, jZzi, iZzg, dataSource, dataType);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzeT, reason: merged with bridge method [inline-methods] */
    public DataUpdateNotification[] newArray(int i) {
        return new DataUpdateNotification[i];
    }
}
