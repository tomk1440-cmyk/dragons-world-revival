package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class zzb implements Parcelable.Creator<GetPermissionStatusRequest> {
    static void zza(GetPermissionStatusRequest getPermissionStatusRequest, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, getPermissionStatusRequest.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, getPermissionStatusRequest.zzED(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, getPermissionStatusRequest.zzbbF, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, (Parcelable) getPermissionStatusRequest.zzbcs, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzgh, reason: merged with bridge method [inline-methods] */
    public GetPermissionStatusRequest createFromParcel(Parcel parcel) {
        ClientAppContext clientAppContext = null;
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int iZzg = 0;
        String strZzp = null;
        IBinder iBinderZzq = null;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 2:
                    iBinderZzq = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, iZzat);
                    break;
                case 3:
                    strZzp = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 4:
                    clientAppContext = (ClientAppContext) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, ClientAppContext.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat);
                    break;
            }
        }
        if (parcel.dataPosition() != iZzau) {
            throw new com.google.android.gms.common.internal.safeparcel.zza.C0052zza("Overread allowed size end=" + iZzau, parcel);
        }
        return new GetPermissionStatusRequest(iZzg, iBinderZzq, strZzp, clientAppContext);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzjm, reason: merged with bridge method [inline-methods] */
    public GetPermissionStatusRequest[] newArray(int i) {
        return new GetPermissionStatusRequest[i];
    }
}
