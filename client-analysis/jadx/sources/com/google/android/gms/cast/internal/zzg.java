package com.google.android.gms.cast.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.cast.ApplicationMetadata;

/* JADX INFO: loaded from: classes.dex */
public class zzg implements Parcelable.Creator<DeviceStatus> {
    static void zza(DeviceStatus deviceStatus, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, deviceStatus.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, deviceStatus.zzok());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, deviceStatus.zzot());
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 4, deviceStatus.zzol());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, (Parcelable) deviceStatus.getApplicationMetadata(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 6, deviceStatus.zzom());
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzae, reason: merged with bridge method [inline-methods] */
    public DeviceStatus createFromParcel(Parcel parcel) {
        int iZzg = 0;
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        double dZzn = 0.0d;
        ApplicationMetadata applicationMetadata = null;
        int iZzg2 = 0;
        boolean zZzc = false;
        int iZzg3 = 0;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    iZzg3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 2:
                    dZzn = com.google.android.gms.common.internal.safeparcel.zza.zzn(parcel, iZzat);
                    break;
                case 3:
                    zZzc = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat);
                    break;
                case 4:
                    iZzg2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 5:
                    applicationMetadata = (ApplicationMetadata) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, ApplicationMetadata.CREATOR);
                    break;
                case 6:
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
        return new DeviceStatus(iZzg3, dZzn, zZzc, iZzg2, applicationMetadata, iZzg);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzbo, reason: merged with bridge method [inline-methods] */
    public DeviceStatus[] newArray(int i) {
        return new DeviceStatus[i];
    }
}
