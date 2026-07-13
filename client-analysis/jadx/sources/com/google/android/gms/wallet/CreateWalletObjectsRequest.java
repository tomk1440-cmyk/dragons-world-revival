package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public final class CreateWalletObjectsRequest implements SafeParcelable {
    public static final Parcelable.Creator<CreateWalletObjectsRequest> CREATOR = new zzd();
    private final int mVersionCode;
    LoyaltyWalletObject zzbol;
    OfferWalletObject zzbom;
    GiftCardWalletObject zzbon;

    CreateWalletObjectsRequest() {
        this.mVersionCode = 3;
    }

    CreateWalletObjectsRequest(int versionCode, LoyaltyWalletObject loyaltyWalletObject, OfferWalletObject offerWalletObject, GiftCardWalletObject giftCardWalletObject) {
        this.mVersionCode = versionCode;
        this.zzbol = loyaltyWalletObject;
        this.zzbom = offerWalletObject;
        this.zzbon = giftCardWalletObject;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzd.zza(this, dest, flags);
    }
}
