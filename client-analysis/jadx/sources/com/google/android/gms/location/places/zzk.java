package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class zzk implements Parcelable.Creator<PlaceRequest> {
    static void zza(PlaceRequest placeRequest, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, placeRequest.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, (Parcelable) placeRequest.zzyZ(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, placeRequest.getInterval());
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 4, placeRequest.getPriority());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, placeRequest.getExpirationTime());
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzfi, reason: merged with bridge method [inline-methods] */
    public PlaceRequest createFromParcel(Parcel parcel) {
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int iZzg = 0;
        PlaceFilter placeFilter = null;
        long jZzi = PlaceRequest.zzaPJ;
        int iZzg2 = 102;
        long jZzi2 = Long.MAX_VALUE;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 2:
                    placeFilter = (PlaceFilter) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, PlaceFilter.CREATOR);
                    break;
                case 3:
                    jZzi = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, iZzat);
                    break;
                case 4:
                    iZzg2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 5:
                    jZzi2 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, iZzat);
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
        return new PlaceRequest(iZzg, placeFilter, jZzi, iZzg2, jZzi2);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzhT, reason: merged with bridge method [inline-methods] */
    public PlaceRequest[] newArray(int i) {
        return new PlaceRequest[i];
    }
}
