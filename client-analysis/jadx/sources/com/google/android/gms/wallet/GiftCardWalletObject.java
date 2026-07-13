package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.wobs.CommonWalletObject;

/* JADX INFO: loaded from: classes.dex */
public final class GiftCardWalletObject implements SafeParcelable {
    public static final Parcelable.Creator<GiftCardWalletObject> CREATOR = new zzg();
    final int mVersionCode;
    String pin;
    CommonWalletObject zzboB;
    String zzboC;
    String zzboD;
    long zzboE;
    String zzboF;
    long zzboG;
    String zzboH;

    GiftCardWalletObject() {
        this.zzboB = CommonWalletObject.zzIr().zzIs();
        this.mVersionCode = 1;
    }

    GiftCardWalletObject(int versionCode, CommonWalletObject commonWalletObject, String cardNumber, String pin, String cardIdentifier, long balanceMicros, String balanceCurrencyCode, long balanceUpdateTime, String eventNumber) {
        this.zzboB = CommonWalletObject.zzIr().zzIs();
        this.mVersionCode = versionCode;
        this.zzboB = commonWalletObject;
        this.zzboC = cardNumber;
        this.pin = pin;
        this.zzboE = balanceMicros;
        this.zzboF = balanceCurrencyCode;
        this.zzboG = balanceUpdateTime;
        this.zzboH = eventNumber;
        this.zzboD = cardIdentifier;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getId() {
        return this.zzboB.getId();
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzg.zza(this, dest, flags);
    }
}
