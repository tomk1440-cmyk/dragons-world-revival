package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class zzi implements Parcelable.Creator<WalletObjectMessage> {
    static void zza(WalletObjectMessage walletObjectMessage, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, walletObjectMessage.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, walletObjectMessage.zzbqO, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, walletObjectMessage.body, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, (Parcelable) walletObjectMessage.zzbqR, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, (Parcelable) walletObjectMessage.zzbqS, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, (Parcelable) walletObjectMessage.zzbqT, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzhW, reason: merged with bridge method [inline-methods] */
    public WalletObjectMessage createFromParcel(Parcel parcel) {
        UriData uriData = null;
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int iZzg = 0;
        UriData uriData2 = null;
        TimeInterval timeInterval = null;
        String strZzp = null;
        String strZzp2 = null;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 2:
                    strZzp2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 3:
                    strZzp = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 4:
                    timeInterval = (TimeInterval) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, TimeInterval.CREATOR);
                    break;
                case 5:
                    uriData2 = (UriData) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, UriData.CREATOR);
                    break;
                case 6:
                    uriData = (UriData) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, UriData.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat);
                    break;
            }
        }
        if (parcel.dataPosition() != iZzau) {
            throw new com.google.android.gms.common.internal.safeparcel.zza.C0052zza("Overread allowed size end=" + iZzau, parcel);
        }
        return new WalletObjectMessage(iZzg, strZzp2, strZzp, timeInterval, uriData2, uriData);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzlx, reason: merged with bridge method [inline-methods] */
    public WalletObjectMessage[] newArray(int i) {
        return new WalletObjectMessage[i];
    }
}
