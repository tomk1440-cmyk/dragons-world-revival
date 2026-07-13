package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class zzc implements Parcelable.Creator<HandleClientLifecycleEventRequest> {
    static void zza(HandleClientLifecycleEventRequest handleClientLifecycleEventRequest, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, handleClientLifecycleEventRequest.versionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, (Parcelable) handleClientLifecycleEventRequest.zzbcs, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 3, handleClientLifecycleEventRequest.zzbct);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzgi, reason: merged with bridge method [inline-methods] */
    public HandleClientLifecycleEventRequest createFromParcel(Parcel parcel) {
        int iZzg;
        ClientAppContext clientAppContext;
        int iZzg2;
        int i = 0;
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        ClientAppContext clientAppContext2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    int i3 = i;
                    clientAppContext = clientAppContext2;
                    iZzg2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    iZzg = i3;
                    break;
                case 2:
                    ClientAppContext clientAppContext3 = (ClientAppContext) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, ClientAppContext.CREATOR);
                    iZzg2 = i2;
                    iZzg = i;
                    clientAppContext = clientAppContext3;
                    break;
                case 3:
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    clientAppContext = clientAppContext2;
                    iZzg2 = i2;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat);
                    iZzg = i;
                    clientAppContext = clientAppContext2;
                    iZzg2 = i2;
                    break;
            }
            i2 = iZzg2;
            clientAppContext2 = clientAppContext;
            i = iZzg;
        }
        if (parcel.dataPosition() != iZzau) {
            throw new com.google.android.gms.common.internal.safeparcel.zza.C0052zza("Overread allowed size end=" + iZzau, parcel);
        }
        return new HandleClientLifecycleEventRequest(i2, clientAppContext2, i);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzjn, reason: merged with bridge method [inline-methods] */
    public HandleClientLifecycleEventRequest[] newArray(int i) {
        return new HandleClientLifecycleEventRequest[i];
    }
}
