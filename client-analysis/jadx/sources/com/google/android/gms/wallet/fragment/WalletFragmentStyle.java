package com.google.android.gms.wallet.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.google.android.gms.R;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public final class WalletFragmentStyle implements SafeParcelable {
    public static final Parcelable.Creator<WalletFragmentStyle> CREATOR = new zzc();
    final int mVersionCode;
    Bundle zzbqu;
    int zzbqv;

    @Retention(RetentionPolicy.SOURCE)
    public @interface BuyButtonAppearance {
        public static final int ANDROID_PAY_DARK = 4;
        public static final int ANDROID_PAY_LIGHT = 5;
        public static final int ANDROID_PAY_LIGHT_WITH_BORDER = 6;

        @Deprecated
        public static final int GOOGLE_WALLET_CLASSIC = 1;

        @Deprecated
        public static final int GOOGLE_WALLET_GRAYSCALE = 2;

        @Deprecated
        public static final int GOOGLE_WALLET_MONOCHROME = 3;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface BuyButtonText {
        public static final int BUY_WITH = 5;
        public static final int DONATE_WITH = 7;
        public static final int LOGO_ONLY = 6;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Dimension {
        public static final int MATCH_PARENT = -1;
        public static final int UNIT_DIP = 1;
        public static final int UNIT_IN = 4;
        public static final int UNIT_MM = 5;
        public static final int UNIT_PT = 3;
        public static final int UNIT_PX = 0;
        public static final int UNIT_SP = 2;
        public static final int WRAP_CONTENT = -2;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface LogoImageType {
        public static final int ANDROID_PAY = 3;

        @Deprecated
        public static final int GOOGLE_WALLET_CLASSIC = 1;

        @Deprecated
        public static final int GOOGLE_WALLET_MONOCHROME = 2;
    }

    public WalletFragmentStyle() {
        this.mVersionCode = 1;
        this.zzbqu = new Bundle();
        this.zzbqu.putInt("buyButtonAppearanceDefault", 4);
        this.zzbqu.putInt("maskedWalletDetailsLogoImageTypeDefault", 3);
    }

    WalletFragmentStyle(int versionCode, Bundle attributes, int styleResourceId) {
        this.mVersionCode = versionCode;
        this.zzbqu = attributes;
        this.zzbqv = styleResourceId;
    }

    private static int zza(long j, DisplayMetrics displayMetrics) {
        int i;
        int i2 = (int) (j >>> 32);
        int i3 = (int) j;
        switch (i2) {
            case 0:
                i = 0;
                break;
            case 1:
                i = 1;
                break;
            case 2:
                i = 2;
                break;
            case 3:
                i = 3;
                break;
            case 4:
                i = 4;
                break;
            case 5:
                i = 5;
                break;
            case 128:
                return TypedValue.complexToDimensionPixelSize(i3, displayMetrics);
            case 129:
                return i3;
            default:
                throw new IllegalStateException("Unexpected unit or type: " + i2);
        }
        return Math.round(TypedValue.applyDimension(i, Float.intBitsToFloat(i3), displayMetrics));
    }

    private static long zza(int i, float f) {
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                return zzv(i, Float.floatToIntBits(f));
            default:
                throw new IllegalArgumentException("Unrecognized unit: " + i);
        }
    }

    private static long zza(TypedValue typedValue) {
        switch (typedValue.type) {
            case 5:
                return zzv(128, typedValue.data);
            case 16:
                return zzll(typedValue.data);
            default:
                throw new IllegalArgumentException("Unexpected dimension type: " + typedValue.type);
        }
    }

    private void zza(TypedArray typedArray, int i, String str) {
        TypedValue typedValuePeekValue;
        if (this.zzbqu.containsKey(str) || (typedValuePeekValue = typedArray.peekValue(i)) == null) {
            return;
        }
        this.zzbqu.putLong(str, zza(typedValuePeekValue));
    }

    private void zza(TypedArray typedArray, int i, String str, String str2) {
        TypedValue typedValuePeekValue;
        if (this.zzbqu.containsKey(str) || this.zzbqu.containsKey(str2) || (typedValuePeekValue = typedArray.peekValue(i)) == null) {
            return;
        }
        if (typedValuePeekValue.type < 28 || typedValuePeekValue.type > 31) {
            this.zzbqu.putInt(str2, typedValuePeekValue.resourceId);
        } else {
            this.zzbqu.putInt(str, typedValuePeekValue.data);
        }
    }

    private void zzb(TypedArray typedArray, int i, String str) {
        TypedValue typedValuePeekValue;
        if (this.zzbqu.containsKey(str) || (typedValuePeekValue = typedArray.peekValue(i)) == null) {
            return;
        }
        this.zzbqu.putInt(str, typedValuePeekValue.data);
    }

    private static long zzll(int i) {
        if (i >= 0) {
            return zza(0, i);
        }
        if (i == -1 || i == -2) {
            return zzv(129, i);
        }
        throw new IllegalArgumentException("Unexpected dimension value: " + i);
    }

    private static long zzv(int i, int i2) {
        return (((long) i) << 32) | (((long) i2) & 4294967295L);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public WalletFragmentStyle setBuyButtonAppearance(int buyButtonAppearance) {
        this.zzbqu.putInt("buyButtonAppearance", buyButtonAppearance);
        return this;
    }

    public WalletFragmentStyle setBuyButtonHeight(int height) {
        this.zzbqu.putLong("buyButtonHeight", zzll(height));
        return this;
    }

    public WalletFragmentStyle setBuyButtonHeight(int unit, float height) {
        this.zzbqu.putLong("buyButtonHeight", zza(unit, height));
        return this;
    }

    public WalletFragmentStyle setBuyButtonText(int buyButtonText) {
        this.zzbqu.putInt("buyButtonText", buyButtonText);
        return this;
    }

    public WalletFragmentStyle setBuyButtonWidth(int width) {
        this.zzbqu.putLong("buyButtonWidth", zzll(width));
        return this;
    }

    public WalletFragmentStyle setBuyButtonWidth(int unit, float width) {
        this.zzbqu.putLong("buyButtonWidth", zza(unit, width));
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsBackgroundColor(int color) {
        this.zzbqu.remove("maskedWalletDetailsBackgroundResource");
        this.zzbqu.putInt("maskedWalletDetailsBackgroundColor", color);
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsBackgroundResource(int resourceId) {
        this.zzbqu.remove("maskedWalletDetailsBackgroundColor");
        this.zzbqu.putInt("maskedWalletDetailsBackgroundResource", resourceId);
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsButtonBackgroundColor(int color) {
        this.zzbqu.remove("maskedWalletDetailsButtonBackgroundResource");
        this.zzbqu.putInt("maskedWalletDetailsButtonBackgroundColor", color);
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsButtonBackgroundResource(int resourceId) {
        this.zzbqu.remove("maskedWalletDetailsButtonBackgroundColor");
        this.zzbqu.putInt("maskedWalletDetailsButtonBackgroundResource", resourceId);
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsButtonTextAppearance(int resourceId) {
        this.zzbqu.putInt("maskedWalletDetailsButtonTextAppearance", resourceId);
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsHeaderTextAppearance(int resourceId) {
        this.zzbqu.putInt("maskedWalletDetailsHeaderTextAppearance", resourceId);
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsLogoImageType(int imageType) {
        this.zzbqu.putInt("maskedWalletDetailsLogoImageType", imageType);
        return this;
    }

    @Deprecated
    public WalletFragmentStyle setMaskedWalletDetailsLogoTextColor(int color) {
        this.zzbqu.putInt("maskedWalletDetailsLogoTextColor", color);
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsTextAppearance(int resourceId) {
        this.zzbqu.putInt("maskedWalletDetailsTextAppearance", resourceId);
        return this;
    }

    public WalletFragmentStyle setStyleResourceId(int id) {
        this.zzbqv = id;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzc.zza(this, dest, flags);
    }

    public int zza(String str, DisplayMetrics displayMetrics, int i) {
        return this.zzbqu.containsKey(str) ? zza(this.zzbqu.getLong(str), displayMetrics) : i;
    }

    public void zzbc(Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(this.zzbqv <= 0 ? R.style.WalletFragmentDefaultStyle : this.zzbqv, R.styleable.WalletFragmentStyle);
        zza(typedArrayObtainStyledAttributes, R.styleable.WalletFragmentStyle_buyButtonWidth, "buyButtonWidth");
        zza(typedArrayObtainStyledAttributes, R.styleable.WalletFragmentStyle_buyButtonHeight, "buyButtonHeight");
        zzb(typedArrayObtainStyledAttributes, R.styleable.WalletFragmentStyle_buyButtonText, "buyButtonText");
        zzb(typedArrayObtainStyledAttributes, R.styleable.WalletFragmentStyle_buyButtonAppearance, "buyButtonAppearance");
        zzb(typedArrayObtainStyledAttributes, R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance, "maskedWalletDetailsTextAppearance");
        zzb(typedArrayObtainStyledAttributes, R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance, "maskedWalletDetailsHeaderTextAppearance");
        zza(typedArrayObtainStyledAttributes, R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground, "maskedWalletDetailsBackgroundColor", "maskedWalletDetailsBackgroundResource");
        zzb(typedArrayObtainStyledAttributes, R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance, "maskedWalletDetailsButtonTextAppearance");
        zza(typedArrayObtainStyledAttributes, R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonBackground, "maskedWalletDetailsButtonBackgroundColor", "maskedWalletDetailsButtonBackgroundResource");
        zzb(typedArrayObtainStyledAttributes, R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor, "maskedWalletDetailsLogoTextColor");
        zzb(typedArrayObtainStyledAttributes, R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType, "maskedWalletDetailsLogoImageType");
        typedArrayObtainStyledAttributes.recycle();
    }
}
