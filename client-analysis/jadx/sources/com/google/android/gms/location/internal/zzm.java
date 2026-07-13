package com.google.android.gms.location.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.location.LocationRequest;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class zzm implements Parcelable.Creator<LocationRequestInternal> {
    static void zza(LocationRequestInternal locationRequestInternal, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, (Parcelable) locationRequestInternal.zzaBp, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, locationRequestInternal.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, locationRequestInternal.zzaOP);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, locationRequestInternal.zzaOQ);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, locationRequestInternal.zzaOR);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 5, locationRequestInternal.zzaOS, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, locationRequestInternal.mTag, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, locationRequestInternal.zzaOT);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzeX, reason: merged with bridge method [inline-methods] */
    public LocationRequestInternal createFromParcel(Parcel parcel) {
        String strZzp = null;
        boolean zZzc = true;
        boolean zZzc2 = false;
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        List<ClientIdentity> listZzc = LocationRequestInternal.zzaOO;
        boolean zZzc3 = true;
        boolean zZzc4 = false;
        LocationRequest locationRequest = null;
        int iZzg = 0;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    locationRequest = (LocationRequest) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, LocationRequest.CREATOR);
                    break;
                case 2:
                    zZzc4 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat);
                    break;
                case 3:
                    zZzc3 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat);
                    break;
                case 4:
                    zZzc = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat);
                    break;
                case 5:
                    listZzc = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat, ClientIdentity.CREATOR);
                    break;
                case 6:
                    strZzp = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 7:
                    zZzc2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat);
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
        return new LocationRequestInternal(iZzg, locationRequest, zZzc4, zZzc3, zZzc, listZzc, strZzp, zZzc2);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzhD, reason: merged with bridge method [inline-methods] */
    public LocationRequestInternal[] newArray(int i) {
        return new LocationRequestInternal[i];
    }
}
