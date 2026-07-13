package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public final class CredentialPickerConfig implements SafeParcelable {
    public static final Parcelable.Creator<CredentialPickerConfig> CREATOR = new zzb();
    private final boolean mShowCancelButton;
    final int mVersionCode;
    private final boolean zzWb;
    private final boolean zzWc;

    public static class Builder {
        private boolean zzWb = false;
        private boolean mShowCancelButton = true;
        private boolean zzWc = false;

        public CredentialPickerConfig build() {
            return new CredentialPickerConfig(this);
        }

        public Builder setForNewAccount(boolean forNewAccount) {
            this.zzWc = forNewAccount;
            return this;
        }

        public Builder setShowAddAccountButton(boolean showAddAccountButton) {
            this.zzWb = showAddAccountButton;
            return this;
        }

        public Builder setShowCancelButton(boolean showCancelButton) {
            this.mShowCancelButton = showCancelButton;
            return this;
        }
    }

    CredentialPickerConfig(int version, boolean showAddAccountButton, boolean showCancelButton, boolean forNewAccount) {
        this.mVersionCode = version;
        this.zzWb = showAddAccountButton;
        this.mShowCancelButton = showCancelButton;
        this.zzWc = forNewAccount;
    }

    private CredentialPickerConfig(Builder builder) {
        this(1, builder.zzWb, builder.mShowCancelButton, builder.zzWc);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean isForNewAccount() {
        return this.zzWc;
    }

    public boolean shouldShowAddAccountButton() {
        return this.zzWb;
    }

    public boolean shouldShowCancelButton() {
        return this.mShowCancelButton;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        zzb.zza(this, out, flags);
    }
}
