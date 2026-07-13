package com.google.android.gms.wallet.fragment;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;

/* JADX INFO: loaded from: classes.dex */
public final class WalletFragmentInitParams implements SafeParcelable {
    public static final Parcelable.Creator<WalletFragmentInitParams> CREATOR = new zza();
    final int mVersionCode;
    private String zzVa;
    private MaskedWalletRequest zzbqc;
    private MaskedWallet zzbqd;
    private int zzbqq;

    public final class Builder {
        private Builder() {
        }

        public WalletFragmentInitParams build() {
            zzx.zza((WalletFragmentInitParams.this.zzbqd != null && WalletFragmentInitParams.this.zzbqc == null) || (WalletFragmentInitParams.this.zzbqd == null && WalletFragmentInitParams.this.zzbqc != null), "Exactly one of MaskedWallet or MaskedWalletRequest is required");
            zzx.zza(WalletFragmentInitParams.this.zzbqq >= 0, "masked wallet request code is required and must be non-negative");
            return WalletFragmentInitParams.this;
        }

        public Builder setAccountName(String accountName) {
            WalletFragmentInitParams.this.zzVa = accountName;
            return this;
        }

        public Builder setMaskedWallet(MaskedWallet maskedWallet) {
            WalletFragmentInitParams.this.zzbqd = maskedWallet;
            return this;
        }

        public Builder setMaskedWalletRequest(MaskedWalletRequest request) {
            WalletFragmentInitParams.this.zzbqc = request;
            return this;
        }

        public Builder setMaskedWalletRequestCode(int requestCode) {
            WalletFragmentInitParams.this.zzbqq = requestCode;
            return this;
        }
    }

    private WalletFragmentInitParams() {
        this.mVersionCode = 1;
        this.zzbqq = -1;
    }

    WalletFragmentInitParams(int versionCode, String accountName, MaskedWalletRequest maskedWalletRequest, int maskedWalletRequestCode, MaskedWallet maskedWallet) {
        this.mVersionCode = versionCode;
        this.zzVa = accountName;
        this.zzbqc = maskedWalletRequest;
        this.zzbqq = maskedWalletRequestCode;
        this.zzbqd = maskedWallet;
    }

    public static Builder newBuilder() {
        WalletFragmentInitParams walletFragmentInitParams = new WalletFragmentInitParams();
        walletFragmentInitParams.getClass();
        return new Builder();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAccountName() {
        return this.zzVa;
    }

    public MaskedWallet getMaskedWallet() {
        return this.zzbqd;
    }

    public MaskedWalletRequest getMaskedWalletRequest() {
        return this.zzbqc;
    }

    public int getMaskedWalletRequestCode() {
        return this.zzbqq;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zza.zza(this, dest, flags);
    }
}
