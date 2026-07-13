package com.google.android.gms.location.places.personalized;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
public class zzc implements Parcelable.Creator<PlaceAliasResult> {
    static void zza(PlaceAliasResult placeAliasResult, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, (Parcelable) placeAliasResult.getStatus(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, placeAliasResult.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, (Parcelable) placeAliasResult.zzzC(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzfr, reason: merged with bridge method [inline-methods] */
    public PlaceAliasResult createFromParcel(Parcel parcel) {
        PlaceUserData placeUserData;
        Status status;
        int iZzg;
        PlaceUserData placeUserData2 = null;
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int i = 0;
        Status status2 = null;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    Status status3 = (Status) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, Status.CREATOR);
                    iZzg = i;
                    placeUserData = placeUserData2;
                    status = status3;
                    break;
                case 2:
                    placeUserData = (PlaceUserData) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, PlaceUserData.CREATOR);
                    status = status2;
                    iZzg = i;
                    break;
                case 1000:
                    PlaceUserData placeUserData3 = placeUserData2;
                    status = status2;
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    placeUserData = placeUserData3;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat);
                    placeUserData = placeUserData2;
                    status = status2;
                    iZzg = i;
                    break;
            }
            i = iZzg;
            status2 = status;
            placeUserData2 = placeUserData;
        }
        if (parcel.dataPosition() != iZzau) {
            throw new com.google.android.gms.common.internal.safeparcel.zza.C0052zza("Overread allowed size end=" + iZzau, parcel);
        }
        return new PlaceAliasResult(i, status2, placeUserData2);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzie, reason: merged with bridge method [inline-methods] */
    public PlaceAliasResult[] newArray(int i) {
        return new PlaceAliasResult[i];
    }
}
