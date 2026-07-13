package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class zze implements Parcelable.Creator<NearbyAlertRequest> {
    static void zza(NearbyAlertRequest nearbyAlertRequest, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, nearbyAlertRequest.zzyV());
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, nearbyAlertRequest.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 2, nearbyAlertRequest.zzyY());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, (Parcelable) nearbyAlertRequest.zzyZ(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, (Parcelable) nearbyAlertRequest.zzza(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, nearbyAlertRequest.zzzb());
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 6, nearbyAlertRequest.zzzc());
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 7, nearbyAlertRequest.getPriority());
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzfd, reason: merged with bridge method [inline-methods] */
    public NearbyAlertRequest createFromParcel(Parcel parcel) {
        NearbyAlertFilter nearbyAlertFilter = null;
        int iZzg = 0;
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int iZzg2 = -1;
        int iZzg3 = 0;
        boolean zZzc = false;
        PlaceFilter placeFilter = null;
        int iZzg4 = 0;
        int iZzg5 = 0;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    iZzg4 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 2:
                    iZzg2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 3:
                    placeFilter = (PlaceFilter) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, PlaceFilter.CREATOR);
                    break;
                case 4:
                    nearbyAlertFilter = (NearbyAlertFilter) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, NearbyAlertFilter.CREATOR);
                    break;
                case 5:
                    zZzc = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat);
                    break;
                case 6:
                    iZzg3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 7:
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 1000:
                    iZzg5 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat);
                    break;
            }
        }
        if (parcel.dataPosition() != iZzau) {
            throw new com.google.android.gms.common.internal.safeparcel.zza.C0052zza("Overread allowed size end=" + iZzau, parcel);
        }
        return new NearbyAlertRequest(iZzg5, iZzg4, iZzg2, placeFilter, nearbyAlertFilter, zZzc, iZzg3, iZzg);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzhN, reason: merged with bridge method [inline-methods] */
    public NearbyAlertRequest[] newArray(int i) {
        return new NearbyAlertRequest[i];
    }
}
