package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collection;

/* JADX INFO: loaded from: classes.dex */
public final class MaskedWalletRequest implements SafeParcelable {
    public static final Parcelable.Creator<MaskedWalletRequest> CREATOR = new zzm();
    private final int mVersionCode;
    String zzboi;
    String zzbop;
    Cart zzboz;
    boolean zzbpl;
    boolean zzbpm;
    boolean zzbpn;
    String zzbpo;
    String zzbpp;
    boolean zzbpq;
    boolean zzbpr;
    CountrySpecification[] zzbps;
    boolean zzbpt;
    boolean zzbpu;
    ArrayList<com.google.android.gms.identity.intents.model.CountrySpecification> zzbpv;
    PaymentMethodTokenizationParameters zzbpw;
    ArrayList<Integer> zzbpx;

    public final class Builder {
        private Builder() {
        }

        public Builder addAllowedCardNetwork(int allowedCardNetwork) {
            if (MaskedWalletRequest.this.zzbpx == null) {
                MaskedWalletRequest.this.zzbpx = new ArrayList<>();
            }
            MaskedWalletRequest.this.zzbpx.add(Integer.valueOf(allowedCardNetwork));
            return this;
        }

        public Builder addAllowedCardNetworks(Collection<Integer> allowedCardNetworks) {
            if (allowedCardNetworks != null) {
                if (MaskedWalletRequest.this.zzbpx == null) {
                    MaskedWalletRequest.this.zzbpx = new ArrayList<>();
                }
                MaskedWalletRequest.this.zzbpx.addAll(allowedCardNetworks);
            }
            return this;
        }

        public Builder addAllowedCountrySpecificationForShipping(com.google.android.gms.identity.intents.model.CountrySpecification countrySpecification) {
            if (MaskedWalletRequest.this.zzbpv == null) {
                MaskedWalletRequest.this.zzbpv = new ArrayList<>();
            }
            MaskedWalletRequest.this.zzbpv.add(countrySpecification);
            return this;
        }

        public Builder addAllowedCountrySpecificationsForShipping(Collection<com.google.android.gms.identity.intents.model.CountrySpecification> countrySpecifications) {
            if (countrySpecifications != null) {
                if (MaskedWalletRequest.this.zzbpv == null) {
                    MaskedWalletRequest.this.zzbpv = new ArrayList<>();
                }
                MaskedWalletRequest.this.zzbpv.addAll(countrySpecifications);
            }
            return this;
        }

        public MaskedWalletRequest build() {
            return MaskedWalletRequest.this;
        }

        public Builder setAllowDebitCard(boolean allowDebitCard) {
            MaskedWalletRequest.this.zzbpu = allowDebitCard;
            return this;
        }

        public Builder setAllowPrepaidCard(boolean allowPrepaidCard) {
            MaskedWalletRequest.this.zzbpt = allowPrepaidCard;
            return this;
        }

        public Builder setCart(Cart cart) {
            MaskedWalletRequest.this.zzboz = cart;
            return this;
        }

        public Builder setCurrencyCode(String currencyCode) {
            MaskedWalletRequest.this.zzboi = currencyCode;
            return this;
        }

        public Builder setEstimatedTotalPrice(String estimatedTotalPrice) {
            MaskedWalletRequest.this.zzbpo = estimatedTotalPrice;
            return this;
        }

        @Deprecated
        public Builder setIsBillingAgreement(boolean isBillingAgreement) {
            MaskedWalletRequest.this.zzbpr = isBillingAgreement;
            return this;
        }

        public Builder setMerchantName(String merchantName) {
            MaskedWalletRequest.this.zzbpp = merchantName;
            return this;
        }

        public Builder setMerchantTransactionId(String merchantTransactionId) {
            MaskedWalletRequest.this.zzbop = merchantTransactionId;
            return this;
        }

        public Builder setPaymentMethodTokenizationParameters(PaymentMethodTokenizationParameters paymentMethodTokenizationParameters) {
            MaskedWalletRequest.this.zzbpw = paymentMethodTokenizationParameters;
            return this;
        }

        public Builder setPhoneNumberRequired(boolean phoneNumberRequired) {
            MaskedWalletRequest.this.zzbpl = phoneNumberRequired;
            return this;
        }

        public Builder setShippingAddressRequired(boolean shippingAddressRequired) {
            MaskedWalletRequest.this.zzbpm = shippingAddressRequired;
            return this;
        }

        @Deprecated
        public Builder setUseMinimalBillingAddress(boolean useMinimalBillingAddress) {
            MaskedWalletRequest.this.zzbpn = useMinimalBillingAddress;
            return this;
        }
    }

    MaskedWalletRequest() {
        this.mVersionCode = 3;
        this.zzbpt = true;
        this.zzbpu = true;
    }

    MaskedWalletRequest(int versionCode, String merchantTransactionId, boolean phoneNumberRequired, boolean shippingAddressRequired, boolean useMinimalBillingAddress, String estimatedTotalPrice, String currencyCode, String merchantName, Cart cart, boolean shouldRetrieveWalletObjects, boolean isBillingAgreement, CountrySpecification[] allowedShippingCountrySpecifications, boolean allowPrepaidCard, boolean allowDebitCard, ArrayList<com.google.android.gms.identity.intents.model.CountrySpecification> allowedCountrySpecificationsForShipping, PaymentMethodTokenizationParameters paymentMethodTokenizationParameters, ArrayList<Integer> allowedCardNetworks) {
        this.mVersionCode = versionCode;
        this.zzbop = merchantTransactionId;
        this.zzbpl = phoneNumberRequired;
        this.zzbpm = shippingAddressRequired;
        this.zzbpn = useMinimalBillingAddress;
        this.zzbpo = estimatedTotalPrice;
        this.zzboi = currencyCode;
        this.zzbpp = merchantName;
        this.zzboz = cart;
        this.zzbpq = shouldRetrieveWalletObjects;
        this.zzbpr = isBillingAgreement;
        this.zzbps = allowedShippingCountrySpecifications;
        this.zzbpt = allowPrepaidCard;
        this.zzbpu = allowDebitCard;
        this.zzbpv = allowedCountrySpecificationsForShipping;
        this.zzbpw = paymentMethodTokenizationParameters;
        this.zzbpx = allowedCardNetworks;
    }

    public static Builder newBuilder() {
        MaskedWalletRequest maskedWalletRequest = new MaskedWalletRequest();
        maskedWalletRequest.getClass();
        return new Builder();
    }

    public boolean allowDebitCard() {
        return this.zzbpu;
    }

    public boolean allowPrepaidCard() {
        return this.zzbpt;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ArrayList<Integer> getAllowedCardNetworks() {
        return this.zzbpx;
    }

    public ArrayList<com.google.android.gms.identity.intents.model.CountrySpecification> getAllowedCountrySpecificationsForShipping() {
        return this.zzbpv;
    }

    public CountrySpecification[] getAllowedShippingCountrySpecifications() {
        return this.zzbps;
    }

    public Cart getCart() {
        return this.zzboz;
    }

    public String getCurrencyCode() {
        return this.zzboi;
    }

    public String getEstimatedTotalPrice() {
        return this.zzbpo;
    }

    public String getMerchantName() {
        return this.zzbpp;
    }

    public String getMerchantTransactionId() {
        return this.zzbop;
    }

    public PaymentMethodTokenizationParameters getPaymentMethodTokenizationParameters() {
        return this.zzbpw;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    @Deprecated
    public boolean isBillingAgreement() {
        return this.zzbpr;
    }

    public boolean isPhoneNumberRequired() {
        return this.zzbpl;
    }

    public boolean isShippingAddressRequired() {
        return this.zzbpm;
    }

    @Deprecated
    public boolean useMinimalBillingAddress() {
        return this.zzbpn;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzm.zza(this, dest, flags);
    }
}
