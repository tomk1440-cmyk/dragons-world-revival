package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public final class LineItem implements SafeParcelable {
    public static final Parcelable.Creator<LineItem> CREATOR = new zzj();
    String description;
    private final int mVersionCode;
    String zzboL;
    String zzboM;
    int zzboN;
    String zzboh;
    String zzboi;

    public final class Builder {
        private Builder() {
        }

        public LineItem build() {
            return LineItem.this;
        }

        public Builder setCurrencyCode(String currencyCode) {
            LineItem.this.zzboi = currencyCode;
            return this;
        }

        public Builder setDescription(String description) {
            LineItem.this.description = description;
            return this;
        }

        public Builder setQuantity(String quantity) {
            LineItem.this.zzboL = quantity;
            return this;
        }

        public Builder setRole(int role) {
            LineItem.this.zzboN = role;
            return this;
        }

        public Builder setTotalPrice(String totalPrice) {
            LineItem.this.zzboh = totalPrice;
            return this;
        }

        public Builder setUnitPrice(String unitPrice) {
            LineItem.this.zzboM = unitPrice;
            return this;
        }
    }

    public interface Role {
        public static final int REGULAR = 0;
        public static final int SHIPPING = 2;
        public static final int TAX = 1;
    }

    LineItem() {
        this.mVersionCode = 1;
        this.zzboN = 0;
    }

    LineItem(int versionCode, String description, String quantity, String unitPrice, String totalPrice, int role, String currencyCode) {
        this.mVersionCode = versionCode;
        this.description = description;
        this.zzboL = quantity;
        this.zzboM = unitPrice;
        this.zzboh = totalPrice;
        this.zzboN = role;
        this.zzboi = currencyCode;
    }

    public static Builder newBuilder() {
        LineItem lineItem = new LineItem();
        lineItem.getClass();
        return new Builder();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getCurrencyCode() {
        return this.zzboi;
    }

    public String getDescription() {
        return this.description;
    }

    public String getQuantity() {
        return this.zzboL;
    }

    public int getRole() {
        return this.zzboN;
    }

    public String getTotalPrice() {
        return this.zzboh;
    }

    public String getUnitPrice() {
        return this.zzboM;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzj.zza(this, dest, flags);
    }
}
