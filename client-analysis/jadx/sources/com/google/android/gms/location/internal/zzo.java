package com.google.android.gms.location.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class zzo implements Parcelable.Creator<ParcelableGeofence> {
    static void zza(ParcelableGeofence parcelableGeofence, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, parcelableGeofence.getRequestId(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, parcelableGeofence.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, parcelableGeofence.getExpirationTime());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, parcelableGeofence.zzyT());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, parcelableGeofence.getLatitude());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, parcelableGeofence.getLongitude());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, parcelableGeofence.zzyU());
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 7, parcelableGeofence.zzyV());
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 8, parcelableGeofence.getNotificationResponsiveness());
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 9, parcelableGeofence.zzyW());
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzeZ, reason: merged with bridge method [inline-methods] */
    public ParcelableGeofence createFromParcel(Parcel parcel) {
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int iZzg = 0;
        String strZzp = null;
        int iZzg2 = 0;
        short sZzf = 0;
        double dZzn = 0.0d;
        double dZzn2 = 0.0d;
        float fZzl = 0.0f;
        long jZzi = 0;
        int iZzg3 = 0;
        int iZzg4 = -1;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    strZzp = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 2:
                    jZzi = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, iZzat);
                    break;
                case 3:
                    sZzf = com.google.android.gms.common.internal.safeparcel.zza.zzf(parcel, iZzat);
                    break;
                case 4:
                    dZzn = com.google.android.gms.common.internal.safeparcel.zza.zzn(parcel, iZzat);
                    break;
                case 5:
                    dZzn2 = com.google.android.gms.common.internal.safeparcel.zza.zzn(parcel, iZzat);
                    break;
                case 6:
                    fZzl = com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, iZzat);
                    break;
                case 7:
                    iZzg2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 8:
                    iZzg3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 9:
                    iZzg4 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
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
        return new ParcelableGeofence(iZzg, strZzp, iZzg2, sZzf, dZzn, dZzn2, fZzl, jZzi, iZzg3, iZzg4);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzhH, reason: merged with bridge method [inline-methods] */
    public ParcelableGeofence[] newArray(int i) {
        return new ParcelableGeofence[i];
    }
}
