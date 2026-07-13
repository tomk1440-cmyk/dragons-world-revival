package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public final class LoyaltyPointsBalance implements SafeParcelable {
    public static final Parcelable.Creator<LoyaltyPointsBalance> CREATOR = new zzd();
    private final int mVersionCode;
    String zzboF;
    int zzbqJ;
    String zzbqK;
    double zzbqL;
    long zzbqM;
    int zzbqN;

    LoyaltyPointsBalance() {
        this.mVersionCode = 1;
        this.zzbqN = -1;
        this.zzbqJ = -1;
        this.zzbqL = -1.0d;
    }

    LoyaltyPointsBalance(int versionCode, int balanceInt, String balanceString, double balanceDouble, String currencyCode, long currencyMicros, int balanceType) {
        this.mVersionCode = versionCode;
        this.zzbqJ = balanceInt;
        this.zzbqK = balanceString;
        this.zzbqL = balanceDouble;
        this.zzboF = currencyCode;
        this.zzbqM = currencyMicros;
        this.zzbqN = balanceType;
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
