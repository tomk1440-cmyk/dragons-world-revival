package com.google.android.gms.nearby.sharing.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class zzk implements Parcelable.Creator<TrustedDevicesRequest> {
    static void zza(TrustedDevicesRequest trustedDevicesRequest, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, trustedDevicesRequest.versionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, trustedDevicesRequest.zzbdq, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, trustedDevicesRequest.zzbdr, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, trustedDevicesRequest.zzED(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzgx, reason: merged with bridge method [inline-methods] */
    public TrustedDevicesRequest createFromParcel(Parcel parcel) {
        IBinder iBinderZzq = null;
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int iZzg = 0;
        byte[] bArrZzs = null;
        String strZzp = null;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 2:
                    strZzp = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 3:
                    bArrZzs = com.google.android.gms.common.internal.safeparcel.zza.zzs(parcel, iZzat);
                    break;
                case 4:
                    iBinderZzq = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, iZzat);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat);
                    break;
            }
        }
        if (parcel.dataPosition() != iZzau) {
            throw new com.google.android.gms.common.internal.safeparcel.zza.C0052zza("Overread allowed size end=" + iZzau, parcel);
        }
        return new TrustedDevicesRequest(iZzg, strZzp, bArrZzs, iBinderZzq);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzjD, reason: merged with bridge method [inline-methods] */
    public TrustedDevicesRequest[] newArray(int i) {
        return new TrustedDevicesRequest[i];
    }
}
