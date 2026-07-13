package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;

/* JADX INFO: loaded from: classes.dex */
public class zzj implements Parcelable.Creator<SignInResponse> {
    static void zza(SignInResponse signInResponse, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, signInResponse.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, (Parcelable) signInResponse.zzqY(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, (Parcelable) signInResponse.zzFP(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzgV, reason: merged with bridge method [inline-methods] */
    public SignInResponse createFromParcel(Parcel parcel) {
        ResolveAccountResponse resolveAccountResponse;
        ConnectionResult connectionResult;
        int iZzg;
        ResolveAccountResponse resolveAccountResponse2 = null;
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int i = 0;
        ConnectionResult connectionResult2 = null;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    ResolveAccountResponse resolveAccountResponse3 = resolveAccountResponse2;
                    connectionResult = connectionResult2;
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    resolveAccountResponse = resolveAccountResponse3;
                    break;
                case 2:
                    ConnectionResult connectionResult3 = (ConnectionResult) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, ConnectionResult.CREATOR);
                    iZzg = i;
                    resolveAccountResponse = resolveAccountResponse2;
                    connectionResult = connectionResult3;
                    break;
                case 3:
                    resolveAccountResponse = (ResolveAccountResponse) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, ResolveAccountResponse.CREATOR);
                    connectionResult = connectionResult2;
                    iZzg = i;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat);
                    resolveAccountResponse = resolveAccountResponse2;
                    connectionResult = connectionResult2;
                    iZzg = i;
                    break;
            }
            i = iZzg;
            connectionResult2 = connectionResult;
            resolveAccountResponse2 = resolveAccountResponse;
        }
        if (parcel.dataPosition() != iZzau) {
            throw new com.google.android.gms.common.internal.safeparcel.zza.C0052zza("Overread allowed size end=" + iZzau, parcel);
        }
        return new SignInResponse(i, connectionResult2, resolveAccountResponse2);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzkd, reason: merged with bridge method [inline-methods] */
    public SignInResponse[] newArray(int i) {
        return new SignInResponse[i];
    }
}
