package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class zza implements Parcelable.Creator<ClientAppContext> {
    static void zza(ClientAppContext clientAppContext, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, clientAppContext.versionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, clientAppContext.zzbco, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, clientAppContext.zzbcp, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, clientAppContext.zzbbH);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 5, clientAppContext.zzbcq);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzgg, reason: merged with bridge method [inline-methods] */
    public ClientAppContext createFromParcel(Parcel parcel) {
        String strZzp = null;
        int iZzg = 0;
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        boolean zZzc = false;
        String strZzp2 = null;
        int iZzg2 = 0;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    iZzg2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 2:
                    strZzp2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 3:
                    strZzp = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 4:
                    zZzc = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat);
                    break;
                case 5:
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
        return new ClientAppContext(iZzg2, strZzp2, strZzp, zZzc, iZzg);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzjl, reason: merged with bridge method [inline-methods] */
    public ClientAppContext[] newArray(int i) {
        return new ClientAppContext[i];
    }
}
