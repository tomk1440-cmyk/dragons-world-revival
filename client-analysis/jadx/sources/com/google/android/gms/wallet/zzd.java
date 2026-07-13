package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class zzd implements Parcelable.Creator<CreateWalletObjectsRequest> {
    static void zza(CreateWalletObjectsRequest createWalletObjectsRequest, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, createWalletObjectsRequest.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, (Parcelable) createWalletObjectsRequest.zzbol, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, (Parcelable) createWalletObjectsRequest.zzbom, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, (Parcelable) createWalletObjectsRequest.zzbon, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzhr, reason: merged with bridge method [inline-methods] */
    public CreateWalletObjectsRequest createFromParcel(Parcel parcel) {
        GiftCardWalletObject giftCardWalletObject;
        OfferWalletObject offerWalletObject;
        LoyaltyWalletObject loyaltyWalletObject;
        int iZzg;
        GiftCardWalletObject giftCardWalletObject2 = null;
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int i = 0;
        OfferWalletObject offerWalletObject2 = null;
        LoyaltyWalletObject loyaltyWalletObject2 = null;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    GiftCardWalletObject giftCardWalletObject3 = giftCardWalletObject2;
                    offerWalletObject = offerWalletObject2;
                    loyaltyWalletObject = loyaltyWalletObject2;
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    giftCardWalletObject = giftCardWalletObject3;
                    break;
                case 2:
                    iZzg = i;
                    OfferWalletObject offerWalletObject3 = offerWalletObject2;
                    loyaltyWalletObject = (LoyaltyWalletObject) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, LoyaltyWalletObject.CREATOR);
                    giftCardWalletObject = giftCardWalletObject2;
                    offerWalletObject = offerWalletObject3;
                    break;
                case 3:
                    loyaltyWalletObject = loyaltyWalletObject2;
                    iZzg = i;
                    GiftCardWalletObject giftCardWalletObject4 = giftCardWalletObject2;
                    offerWalletObject = (OfferWalletObject) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, OfferWalletObject.CREATOR);
                    giftCardWalletObject = giftCardWalletObject4;
                    break;
                case 4:
                    giftCardWalletObject = (GiftCardWalletObject) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, GiftCardWalletObject.CREATOR);
                    offerWalletObject = offerWalletObject2;
                    loyaltyWalletObject = loyaltyWalletObject2;
                    iZzg = i;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat);
                    giftCardWalletObject = giftCardWalletObject2;
                    offerWalletObject = offerWalletObject2;
                    loyaltyWalletObject = loyaltyWalletObject2;
                    iZzg = i;
                    break;
            }
            i = iZzg;
            loyaltyWalletObject2 = loyaltyWalletObject;
            offerWalletObject2 = offerWalletObject;
            giftCardWalletObject2 = giftCardWalletObject;
        }
        if (parcel.dataPosition() != iZzau) {
            throw new com.google.android.gms.common.internal.safeparcel.zza.C0052zza("Overread allowed size end=" + iZzau, parcel);
        }
        return new CreateWalletObjectsRequest(i, loyaltyWalletObject2, offerWalletObject2, giftCardWalletObject2);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzkP, reason: merged with bridge method [inline-methods] */
    public CreateWalletObjectsRequest[] newArray(int i) {
        return new CreateWalletObjectsRequest[i];
    }
}
