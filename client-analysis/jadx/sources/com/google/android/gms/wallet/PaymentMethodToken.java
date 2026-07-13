package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public final class PaymentMethodToken implements SafeParcelable {
    public static final Parcelable.Creator<PaymentMethodToken> CREATOR = new zzp();
    private final int mVersionCode;
    String zzbaW;
    int zzbpC;

    private PaymentMethodToken() {
        this.mVersionCode = 1;
    }

    PaymentMethodToken(int versionCode, int tokenizationType, String token) {
        this.mVersionCode = versionCode;
        this.zzbpC = tokenizationType;
        this.zzbaW = token;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getPaymentMethodTokenizationType() {
        return this.zzbpC;
    }

    public String getToken() {
        return this.zzbaW;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        zzp.zza(this, out, flags);
    }
}
