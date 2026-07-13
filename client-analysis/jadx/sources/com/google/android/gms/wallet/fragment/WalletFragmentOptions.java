package com.google.android.gms.wallet.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import com.google.android.gms.R;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public final class WalletFragmentOptions implements SafeParcelable {
    public static final Parcelable.Creator<WalletFragmentOptions> CREATOR = new zzb();
    private int mTheme;
    final int mVersionCode;
    private int zzaoy;
    private int zzbpM;
    private WalletFragmentStyle zzbqs;

    public final class Builder {
        private Builder() {
        }

        public WalletFragmentOptions build() {
            return WalletFragmentOptions.this;
        }

        public Builder setEnvironment(int environment) {
            WalletFragmentOptions.this.zzbpM = environment;
            return this;
        }

        public Builder setFragmentStyle(int styleResourceId) {
            WalletFragmentOptions.this.zzbqs = new WalletFragmentStyle().setStyleResourceId(styleResourceId);
            return this;
        }

        public Builder setFragmentStyle(WalletFragmentStyle fragmentStyle) {
            WalletFragmentOptions.this.zzbqs = fragmentStyle;
            return this;
        }

        public Builder setMode(int mode) {
            WalletFragmentOptions.this.zzaoy = mode;
            return this;
        }

        public Builder setTheme(int theme) {
            WalletFragmentOptions.this.mTheme = theme;
            return this;
        }
    }

    private WalletFragmentOptions() {
        this.mVersionCode = 1;
        this.zzbpM = 3;
        this.zzbqs = new WalletFragmentStyle();
    }

    WalletFragmentOptions(int versionCode, int environment, int theme, WalletFragmentStyle fragmentStyle, int mode) {
        this.mVersionCode = versionCode;
        this.zzbpM = environment;
        this.mTheme = theme;
        this.zzbqs = fragmentStyle;
        this.zzaoy = mode;
    }

    public static Builder newBuilder() {
        WalletFragmentOptions walletFragmentOptions = new WalletFragmentOptions();
        walletFragmentOptions.getClass();
        return new Builder();
    }

    public static WalletFragmentOptions zzb(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.WalletFragmentOptions);
        int i = typedArrayObtainStyledAttributes.getInt(R.styleable.WalletFragmentOptions_appTheme, 0);
        int i2 = typedArrayObtainStyledAttributes.getInt(R.styleable.WalletFragmentOptions_environment, 1);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.WalletFragmentOptions_fragmentStyle, 0);
        int i3 = typedArrayObtainStyledAttributes.getInt(R.styleable.WalletFragmentOptions_fragmentMode, 1);
        typedArrayObtainStyledAttributes.recycle();
        WalletFragmentOptions walletFragmentOptions = new WalletFragmentOptions();
        walletFragmentOptions.mTheme = i;
        walletFragmentOptions.zzbpM = i2;
        walletFragmentOptions.zzbqs = new WalletFragmentStyle().setStyleResourceId(resourceId);
        walletFragmentOptions.zzbqs.zzbc(context);
        walletFragmentOptions.zzaoy = i3;
        return walletFragmentOptions;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getEnvironment() {
        return this.zzbpM;
    }

    public WalletFragmentStyle getFragmentStyle() {
        return this.zzbqs;
    }

    public int getMode() {
        return this.zzaoy;
    }

    public int getTheme() {
        return this.mTheme;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzb.zza(this, dest, flags);
    }

    public void zzbc(Context context) {
        if (this.zzbqs != null) {
            this.zzbqs.zzbc(context);
        }
    }
}
