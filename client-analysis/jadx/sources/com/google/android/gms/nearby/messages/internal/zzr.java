package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class zzr implements Parcelable.Creator<RegisterStatusCallbackRequest> {
    static void zza(RegisterStatusCallbackRequest registerStatusCallbackRequest, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, registerStatusCallbackRequest.versionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, registerStatusCallbackRequest.zzED(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, registerStatusCallbackRequest.zzEG(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, registerStatusCallbackRequest.zzbcX);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, registerStatusCallbackRequest.zzbbF, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, (Parcelable) registerStatusCallbackRequest.zzbcs, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzgm, reason: merged with bridge method [inline-methods] */
    public RegisterStatusCallbackRequest createFromParcel(Parcel parcel) {
        boolean zZzc = false;
        ClientAppContext clientAppContext = null;
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        String strZzp = null;
        IBinder iBinderZzq = null;
        IBinder iBinderZzq2 = null;
        int iZzg = 0;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 2:
                    iBinderZzq2 = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, iZzat);
                    break;
                case 3:
                    iBinderZzq = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, iZzat);
                    break;
                case 4:
                    zZzc = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat);
                    break;
                case 5:
                    strZzp = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 6:
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
        return new RegisterStatusCallbackRequest(iZzg, iBinderZzq2, iBinderZzq, zZzc, strZzp, clientAppContext);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzjs, reason: merged with bridge method [inline-methods] */
    public RegisterStatusCallbackRequest[] newArray(int i) {
        return new RegisterStatusCallbackRequest[i];
    }
}
