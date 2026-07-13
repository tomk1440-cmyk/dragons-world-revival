package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class zzbs implements Parcelable.Creator<SetPinnedDownloadPreferencesRequest> {
    static void zza(SetPinnedDownloadPreferencesRequest setPinnedDownloadPreferencesRequest, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, setPinnedDownloadPreferencesRequest.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, (Parcelable) setPinnedDownloadPreferencesRequest.zzasu, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzbU, reason: merged with bridge method [inline-methods] */
    public SetPinnedDownloadPreferencesRequest createFromParcel(Parcel parcel) {
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
        return new SetPinnedDownloadPreferencesRequest(iZzg, parcelableTransferPreferences);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzdP, reason: merged with bridge method [inline-methods] */
    public SetPinnedDownloadPreferencesRequest[] newArray(int i) {
        return new SetPinnedDownloadPreferencesRequest[i];
    }
}
