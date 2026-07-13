package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class zzf implements Parcelable.Creator<DataSource> {
    static void zza(DataSource dataSource, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, (Parcelable) dataSource.getDataType(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, dataSource.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, dataSource.getName(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 3, dataSource.getType());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, (Parcelable) dataSource.getDevice(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, (Parcelable) dataSource.zzum(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, dataSource.getStreamName(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzcS, reason: merged with bridge method [inline-methods] */
    public DataSource createFromParcel(Parcel parcel) {
        int iZzg = 0;
        String strZzp = null;
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        Application application = null;
        Device device = null;
        String strZzp2 = null;
        DataType dataType = null;
        int iZzg2 = 0;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    dataType = (DataType) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, DataType.CREATOR);
                    break;
                case 2:
                    strZzp2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 3:
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 4:
                    device = (Device) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, Device.CREATOR);
                    break;
                case 5:
                    application = (Application) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, Application.CREATOR);
                    break;
                case 6:
                    strZzp = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
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
        return new DataSource(iZzg2, dataType, strZzp2, iZzg, device, application, strZzp);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzeR, reason: merged with bridge method [inline-methods] */
    public DataSource[] newArray(int i) {
        return new DataSource[i];
    }
}
