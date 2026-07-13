package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.wallet.wobs.CommonWalletObject;

/* JADX INFO: loaded from: classes.dex */
public class zzg implements Parcelable.Creator<GiftCardWalletObject> {
    static void zza(GiftCardWalletObject giftCardWalletObject, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, giftCardWalletObject.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, (Parcelable) giftCardWalletObject.zzboB, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, giftCardWalletObject.zzboC, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, giftCardWalletObject.pin, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, giftCardWalletObject.zzboD, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, giftCardWalletObject.zzboE);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, giftCardWalletObject.zzboF, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 8, giftCardWalletObject.zzboG);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 9, giftCardWalletObject.zzboH, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzhu, reason: merged with bridge method [inline-methods] */
    public GiftCardWalletObject createFromParcel(Parcel parcel) {
        long jZzi = 0;
        String strZzp = null;
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int iZzg = 0;
        String strZzp2 = null;
        long jZzi2 = 0;
        String strZzp3 = null;
        String strZzp4 = null;
        String strZzp5 = null;
        CommonWalletObject commonWalletObject = null;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 2:
                    commonWalletObject = (CommonWalletObject) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, CommonWalletObject.CREATOR);
                    break;
                case 3:
                    strZzp5 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 4:
                    strZzp4 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 5:
                    strZzp3 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 6:
                    jZzi2 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, iZzat);
                    break;
                case 7:
                    strZzp2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 8:
                    jZzi = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, iZzat);
                    break;
                case 9:
                    strZzp = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat);
                    break;
            }
        }
        if (parcel.dataPosition() != iZzau) {
            throw new com.google.android.gms.common.internal.safeparcel.zza.C0052zza("Overread allowed size end=" + iZzau, parcel);
        }
        return new GiftCardWalletObject(iZzg, commonWalletObject, strZzp5, strZzp4, strZzp3, jZzi2, strZzp2, jZzi, strZzp);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzkS, reason: merged with bridge method [inline-methods] */
    public GiftCardWalletObject[] newArray(int i) {
        return new GiftCardWalletObject[i];
    }
}
