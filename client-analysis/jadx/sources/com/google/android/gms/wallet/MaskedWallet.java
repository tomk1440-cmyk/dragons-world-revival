package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.identity.intents.model.UserAddress;

/* JADX INFO: loaded from: classes.dex */
public final class MaskedWallet implements SafeParcelable {
    public static final Parcelable.Creator<MaskedWallet> CREATOR = new zzl();
    private final int mVersionCode;
    String zzboo;
    String zzbop;
    String zzbor;
    Address zzbos;
    Address zzbot;
    String[] zzbou;
    UserAddress zzbov;
    UserAddress zzbow;
    InstrumentInfo[] zzbox;
    LoyaltyWalletObject[] zzbpi;
    OfferWalletObject[] zzbpj;

    public final class Builder {
        private Builder() {
        }

        public MaskedWallet build() {
            return MaskedWallet.this;
        }

        public Builder setBillingAddress(Address billingAddress) {
            MaskedWallet.this.zzbos = billingAddress;
            return this;
        }

        public Builder setBuyerBillingAddress(UserAddress buyerBillingAddress) {
            MaskedWallet.this.zzbov = buyerBillingAddress;
            return this;
        }

        public Builder setBuyerShippingAddress(UserAddress buyerShippingAddress) {
            MaskedWallet.this.zzbow = buyerShippingAddress;
            return this;
        }

        public Builder setEmail(String email) {
            MaskedWallet.this.zzbor = email;
            return this;
        }

        public Builder setGoogleTransactionId(String googleTransactionId) {
            MaskedWallet.this.zzboo = googleTransactionId;
            return this;
        }

        public Builder setInstrumentInfos(InstrumentInfo[] instrumentInfos) {
            MaskedWallet.this.zzbox = instrumentInfos;
            return this;
        }

        public Builder setMerchantTransactionId(String merchantTransactionId) {
            MaskedWallet.this.zzbop = merchantTransactionId;
            return this;
        }

        public Builder setPaymentDescriptions(String[] paymentDescriptions) {
            MaskedWallet.this.zzbou = paymentDescriptions;
            return this;
        }

        public Builder setShippingAddress(Address shippingAddress) {
            MaskedWallet.this.zzbot = shippingAddress;
            return this;
        }

        @Deprecated
        public Builder zza(LoyaltyWalletObject[] loyaltyWalletObjectArr) {
            MaskedWallet.this.zzbpi = loyaltyWalletObjectArr;
            return this;
        }

        @Deprecated
        public Builder zza(OfferWalletObject[] offerWalletObjectArr) {
            MaskedWallet.this.zzbpj = offerWalletObjectArr;
            return this;
        }
    }

    private MaskedWallet() {
        this.mVersionCode = 2;
    }

    MaskedWallet(int versionCode, String googleTransactionId, String merchantTransactionId, String[] paymentDescriptions, String email, Address billingAddress, Address shippingAddress, LoyaltyWalletObject[] loyaltyWalletObjects, OfferWalletObject[] offerWalletObjects, UserAddress buyerBillingAddress, UserAddress buyerShippingAddress, InstrumentInfo[] instrumentInfos) {
        this.mVersionCode = versionCode;
        this.zzboo = googleTransactionId;
        this.zzbop = merchantTransactionId;
        this.zzbou = paymentDescriptions;
        this.zzbor = email;
        this.zzbos = billingAddress;
        this.zzbot = shippingAddress;
        this.zzbpi = loyaltyWalletObjects;
        this.zzbpj = offerWalletObjects;
        this.zzbov = buyerBillingAddress;
        this.zzbow = buyerShippingAddress;
        this.zzbox = instrumentInfos;
    }

    public static Builder newBuilderFrom(MaskedWallet maskedWallet) {
        zzx.zzz(maskedWallet);
        return zzIl().setGoogleTransactionId(maskedWallet.getGoogleTransactionId()).setMerchantTransactionId(maskedWallet.getMerchantTransactionId()).setPaymentDescriptions(maskedWallet.getPaymentDescriptions()).setInstrumentInfos(maskedWallet.getInstrumentInfos()).setEmail(maskedWallet.getEmail()).zza(maskedWallet.zzIm()).zza(maskedWallet.zzIn()).setBuyerBillingAddress(maskedWallet.getBuyerBillingAddress()).setBuyerShippingAddress(maskedWallet.getBuyerShippingAddress());
    }

    public static Builder zzIl() {
        MaskedWallet maskedWallet = new MaskedWallet();
        maskedWallet.getClass();
        return new Builder();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Deprecated
    public Address getBillingAddress() {
        return this.zzbos;
    }

    public UserAddress getBuyerBillingAddress() {
        return this.zzbov;
    }

    public UserAddress getBuyerShippingAddress() {
        return this.zzbow;
    }

    public String getEmail() {
        return this.zzbor;
    }

    public String getGoogleTransactionId() {
        return this.zzboo;
    }

    public InstrumentInfo[] getInstrumentInfos() {
        return this.zzbox;
    }

    public String getMerchantTransactionId() {
        return this.zzbop;
    }

    public String[] getPaymentDescriptions() {
        return this.zzbou;
    }

    @Deprecated
    public Address getShippingAddress() {
        return this.zzbot;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzl.zza(this, dest, flags);
    }

    @Deprecated
    public LoyaltyWalletObject[] zzIm() {
        return this.zzbpi;
    }

    @Deprecated
    public OfferWalletObject[] zzIn() {
        return this.zzbpj;
    }
}
