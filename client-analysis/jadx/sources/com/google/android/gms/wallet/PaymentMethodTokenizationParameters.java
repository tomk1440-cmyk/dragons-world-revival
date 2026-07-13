package com.google.android.gms.wallet;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

/* JADX INFO: loaded from: classes.dex */
public final class PaymentMethodTokenizationParameters implements SafeParcelable {
    public static final Parcelable.Creator<PaymentMethodTokenizationParameters> CREATOR = new zzq();
    private final int mVersionCode;
    int zzbpC;
    Bundle zzbpD;

    public final class Builder {
        private Builder() {
        }

        public Builder addParameter(String name, String value) {
            zzx.zzh(name, "Tokenization parameter name must not be empty");
            zzx.zzh(value, "Tokenization parameter value must not be empty");
            PaymentMethodTokenizationParameters.this.zzbpD.putString(name, value);
            return this;
        }

        public PaymentMethodTokenizationParameters build() {
            return PaymentMethodTokenizationParameters.this;
        }

        public Builder setPaymentMethodTokenizationType(int tokenizationType) {
            PaymentMethodTokenizationParameters.this.zzbpC = tokenizationType;
            return this;
        }
    }

    private PaymentMethodTokenizationParameters() {
        this.zzbpD = new Bundle();
        this.mVersionCode = 1;
    }

    PaymentMethodTokenizationParameters(int versionCode, int tokenizationType, Bundle parameters) {
        this.zzbpD = new Bundle();
        this.mVersionCode = versionCode;
        this.zzbpC = tokenizationType;
        this.zzbpD = parameters;
    }

    public static Builder newBuilder() {
        PaymentMethodTokenizationParameters paymentMethodTokenizationParameters = new PaymentMethodTokenizationParameters();
        paymentMethodTokenizationParameters.getClass();
        return new Builder();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Bundle getParameters() {
        return new Bundle(this.zzbpD);
    }

    public int getPaymentMethodTokenizationType() {
        return this.zzbpC;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        zzq.zza(this, out, flags);
    }
}
