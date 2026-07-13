package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

/* JADX INFO: loaded from: classes.dex */
public final class HintRequest implements SafeParcelable {
    public static final Parcelable.Creator<HintRequest> CREATOR = new zzd();
    final int mVersionCode;
    private final String[] zzWe;
    private final CredentialPickerConfig zzWh;
    private final boolean zzWi;
    private final boolean zzWj;

    public static final class Builder {
        private String[] zzWe;
        private CredentialPickerConfig zzWh = new CredentialPickerConfig.Builder().build();
        private boolean zzWi;
        private boolean zzWj;

        public HintRequest build() {
            if (this.zzWe == null) {
                this.zzWe = new String[0];
            }
            if (this.zzWi || this.zzWj || this.zzWe.length != 0) {
                return new HintRequest(this);
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

        public Builder setEmailAddressIdentifierSupported(boolean emailAddressIdentifierSupported) {
            this.zzWi = emailAddressIdentifierSupported;
            return this;
        }

        public Builder setHintPickerConfig(@NonNull CredentialPickerConfig hintPickerConfig) {
            this.zzWh = (CredentialPickerConfig) zzx.zzz(hintPickerConfig);
            return this;
        }
    }

    HintRequest(int version, CredentialPickerConfig hintPickerConfig, boolean emailAddressIdentifierSupported, boolean phoneNumberIdentifierSupported, String[] accountTypes) {
        this.mVersionCode = version;
        this.zzWh = (CredentialPickerConfig) zzx.zzz(hintPickerConfig);
        this.zzWi = emailAddressIdentifierSupported;
        this.zzWj = phoneNumberIdentifierSupported;
        this.zzWe = (String[]) zzx.zzz(accountTypes);
    }

    private HintRequest(Builder builder) {
        this(1, builder.zzWh, builder.zzWi, builder.zzWj, builder.zzWe);
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
    public CredentialPickerConfig getHintPickerConfig() {
        return this.zzWh;
    }

    public boolean isEmailAddressIdentifierSupported() {
        return this.zzWi;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        zzd.zza(this, out, flags);
    }

    public boolean zzmy() {
        return this.zzWj;
    }
}
