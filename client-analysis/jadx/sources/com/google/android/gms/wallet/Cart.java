package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class Cart implements SafeParcelable {
    public static final Parcelable.Creator<Cart> CREATOR = new zzb();
    private final int mVersionCode;
    String zzboh;
    String zzboi;
    ArrayList<LineItem> zzboj;

    public final class Builder {
        private Builder() {
        }

        public Builder addLineItem(LineItem lineItem) {
            Cart.this.zzboj.add(lineItem);
            return this;
        }

        public Cart build() {
            return Cart.this;
        }

        public Builder setCurrencyCode(String currencyCode) {
            Cart.this.zzboi = currencyCode;
            return this;
        }

        public Builder setLineItems(List<LineItem> lineItems) {
            Cart.this.zzboj.clear();
            Cart.this.zzboj.addAll(lineItems);
            return this;
        }

        public Builder setTotalPrice(String totalPrice) {
            Cart.this.zzboh = totalPrice;
            return this;
        }
    }

    Cart() {
        this.mVersionCode = 1;
        this.zzboj = new ArrayList<>();
    }

    Cart(int versionCode, String totalPrice, String currencyCode, ArrayList<LineItem> lineItems) {
        this.mVersionCode = versionCode;
        this.zzboh = totalPrice;
        this.zzboi = currencyCode;
        this.zzboj = lineItems;
    }

    public static Builder newBuilder() {
        Cart cart = new Cart();
        cart.getClass();
        return new Builder();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getCurrencyCode() {
        return this.zzboi;
    }

    public ArrayList<LineItem> getLineItems() {
        return this.zzboj;
    }

    public String getTotalPrice() {
        return this.zzboh;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzb.zza(this, dest, flags);
    }
}
