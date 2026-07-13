package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

/* JADX INFO: loaded from: classes.dex */
public final class CredentialRequest implements SafeParcelable {
    public static final Parcelable.Creator<CredentialRequest> CREATOR = new zzc();
    final int mVersionCode;
    private final boolean zzWd;
    private final String[] zzWe;
    private final CredentialPickerConfig zzWf;
    private final CredentialPickerConfig zzWg;

    public static final class Builder {
        private boolean zzWd;
        private String[] zzWe;
        private CredentialPickerConfig zzWf;
        private CredentialPickerConfig zzWg;

        public CredentialRequest build() {
            if (this.zzWe == null) {
                this.zzWe = new String[0];
            }
            if (this.zzWd || this.zzWe.length != 0) {
                return new CredentialRequest(this);
            }
            throw new IllegalStateException("At least one authentication method must be specified");
        }

        public Builder setAccountTypes(String... accountTypes) {
            if (accountTypes == null) {
                accountTypes = new String[0];
            }
            this.zzWe = accountTypes;
            return this;
        }

        public Builder setCredentialHintPickerConfig(CredentialPickerConfig config) {
            this.zzWg = config;
            return this;
        }

        public Builder setCredentialPickerConfig(CredentialPickerConfig config) {
            this.zzWf = config;
            return this;
        }

        public Builder setPasswordLoginSupported(boolean passwordLoginSupported) {
            this.zzWd = passwordLoginSupported;
            return this;
        }

        @Deprecated
        public Builder setSupportsPasswordLogin(boolean supportsPasswordLogin) {
            return setPasswordLoginSupported(supportsPasswordLogin);
        }
    }

    CredentialRequest(int version, boolean passwordLoginSupported, String[] accountTypes, CredentialPickerConfig credentialPickerConfig, CredentialPickerConfig credentialHintPickerConfig) {
        this.mVersionCode = version;
        this.zzWd = passwordLoginSupported;
        this.zzWe = (String[]) zzx.zzz(accountTypes);
        this.zzWf = credentialPickerConfig == null ? new CredentialPickerConfig.Builder().build() : credentialPickerConfig;
        this.zzWg = credentialHintPickerConfig == null ? new CredentialPickerConfig.Builder().build() : credentialHintPickerConfig;
    }

    private CredentialRequest(Builder builder) {
        this(2, builder.zzWd, builder.zzWe, builder.zzWf, builder.zzWg);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NonNull
    public String[] getAccountTypes() {
        return this.zzWe;
    }

    @NonNull
    public CredentialPickerConfig getCredentialHintPickerConfig() {
        return this.zzWg;
    }

    @NonNull
    public CredentialPickerConfig getCredentialPickerConfig() {
        return this.zzWf;
    }

    @Deprecated
    public boolean getSupportsPasswordLogin() {
        return isPasswordLoginSupported();
    }

    public boolean isPasswordLoginSupported() {
        return this.zzWd;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        zzc.zza(this, out, flags);
    }
}
