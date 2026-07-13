package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class zzbf implements Parcelable.Creator<OnPinnedDownloadPreferencesResponse> {
    static void zza(OnPinnedDownloadPreferencesResponse onPinnedDownloadPreferencesResponse, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, onPinnedDownloadPreferencesResponse.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, (Parcelable) onPinnedDownloadPreferencesResponse.zzasu, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzbI, reason: merged with bridge method [inline-methods] */
    public OnPinnedDownloadPreferencesResponse createFromParcel(Parcel parcel) {
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int iZzg = 0;
        ParcelableTransferPreferences parcelableTransferPreferences = null;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 2:
                    parcelableTransferPreferences = (ParcelableTransferPreferences) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, ParcelableTransferPreferences.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat);
                    break;
            }
        }
        if (parcel.dataPosition() != iZzau) {
            throw new com.google.android.gms.common.internal.safeparcel.zza.C0052zza("Overread allowed size end=" + iZzau, parcel);
        }
        return new OnPinnedDownloadPreferencesResponse(iZzg, parcelableTransferPreferences);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzdD, reason: merged with bridge method [inline-methods] */
    public OnPinnedDownloadPreferencesResponse[] newArray(int i) {
        return new OnPinnedDownloadPreferencesResponse[i];
    }
}
