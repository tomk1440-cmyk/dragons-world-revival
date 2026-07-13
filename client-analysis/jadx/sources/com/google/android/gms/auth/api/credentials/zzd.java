package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class zzd implements Parcelable.Creator<HintRequest> {
    static void zza(HintRequest hintRequest, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, (Parcelable) hintRequest.getHintPickerConfig(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, hintRequest.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, hintRequest.isEmailAddressIdentifierSupported());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, hintRequest.zzmy());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, hintRequest.getAccountTypes(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzH, reason: merged with bridge method [inline-methods] */
    public HintRequest createFromParcel(Parcel parcel) {
        String[] strArrZzB = null;
        boolean zZzc = false;
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        boolean zZzc2 = false;
        CredentialPickerConfig credentialPickerConfig = null;
        int iZzg = 0;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    credentialPickerConfig = (CredentialPickerConfig) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, CredentialPickerConfig.CREATOR);
                    break;
                case 2:
                    zZzc2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat);
                    break;
                case 3:
                    zZzc = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat);
                    break;
                case 4:
                    strArrZzB = com.google.android.gms.common.internal.safeparcel.zza.zzB(parcel, iZzat);
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
        return new HintRequest(iZzg, credentialPickerConfig, zZzc2, zZzc, strArrZzB);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzaC, reason: merged with bridge method [inline-methods] */
    public HintRequest[] newArray(int i) {
        return new HintRequest[i];
    }
}
