package com.google.android.gms.auth.api.credentials;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.adjust.sdk.Constants;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Credential implements SafeParcelable {
    public static final Parcelable.Creator<Credential> CREATOR = new zza();
    public static final String EXTRA_KEY = "com.google.android.gms.credentials.Credential";

    @Nullable
    private final String mName;
    final int mVersionCode;

    @Nullable
    private final Uri zzVV;
    private final List<IdToken> zzVW;

    @Nullable
    private final String zzVX;

    @Nullable
    private final String zzVY;

    @Nullable
    private final String zzVZ;

    @Nullable
    private final String zzWa;
    private final String zzyv;

    public static class Builder {
        private String mName;
        private Uri zzVV;
        private List<IdToken> zzVW;
        private String zzVX;
        private String zzVY;
        private String zzVZ;
        private String zzWa;
        private final String zzyv;

        public Builder(Credential credential) {
            this.zzyv = credential.zzyv;
            this.mName = credential.mName;
            this.zzVV = credential.zzVV;
            this.zzVW = credential.zzVW;
            this.zzVX = credential.zzVX;
            this.zzVY = credential.zzVY;
            this.zzVZ = credential.zzVZ;
            this.zzWa = credential.zzWa;
        }

        public Builder(String id) {
            this.zzyv = id;
        }

        public Credential build() {
            return new Credential(3, this.zzyv, this.mName, this.zzVV, this.zzVW, this.zzVX, this.zzVY, this.zzVZ, this.zzWa);
        }

        public Builder setAccountType(String accountType) {
            this.zzVY = accountType;
            return this;
        }

        public Builder setName(String name) {
            this.mName = name;
            return this;
        }

        public Builder setPassword(String password) {
            this.zzVX = password;
            return this;
        }

        public Builder setProfilePictureUri(Uri profilePictureUri) {
            this.zzVV = profilePictureUri;
            return this;
        }
    }

    Credential(int version, String id, String name, Uri profilePictureUri, List<IdToken> idTokens, String password, String accountType, String generatedPassword, String generatedHintId) {
        this.mVersionCode = version;
        String strTrim = ((String) zzx.zzb(id, "credential identifier cannot be null")).trim();
        zzx.zzh(strTrim, "credential identifier cannot be empty");
        this.zzyv = strTrim;
        if (name != null && TextUtils.isEmpty(name.trim())) {
            name = null;
        }
        this.mName = name;
        this.zzVV = profilePictureUri;
        this.zzVW = idTokens == null ? Collections.emptyList() : Collections.unmodifiableList(idTokens);
        this.zzVX = password;
        if (password != null && password.isEmpty()) {
            throw new IllegalArgumentException("password cannot be empty");
        }
        if (!TextUtils.isEmpty(accountType)) {
            String scheme = Uri.parse(accountType).getScheme();
            zzx.zzac("http".equalsIgnoreCase(scheme) || Constants.SCHEME.equalsIgnoreCase(scheme));
        }
        this.zzVY = accountType;
        this.zzVZ = generatedPassword;
        this.zzWa = generatedHintId;
        if (!TextUtils.isEmpty(this.zzVX) && !TextUtils.isEmpty(this.zzVY)) {
            throw new IllegalStateException("password and accountType cannot both be set");
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Credential)) {
            return false;
        }
        Credential credential = (Credential) other;
        return TextUtils.equals(this.zzyv, credential.zzyv) && TextUtils.equals(this.mName, credential.mName) && zzw.equal(this.zzVV, credential.zzVV) && TextUtils.equals(this.zzVX, credential.zzVX) && TextUtils.equals(this.zzVY, credential.zzVY) && TextUtils.equals(this.zzVZ, credential.zzVZ);
    }

    @Nullable
    public String getAccountType() {
        return this.zzVY;
    }

    @Nullable
    public String getGeneratedPassword() {
        return this.zzVZ;
    }

    public String getId() {
        return this.zzyv;
    }

    public List<IdToken> getIdTokens() {
        return this.zzVW;
    }

    @Nullable
    public String getName() {
        return this.mName;
    }

    @Nullable
    public String getPassword() {
        return this.zzVX;
    }

    @Nullable
    public Uri getProfilePictureUri() {
        return this.zzVV;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzyv, this.mName, this.zzVV, this.zzVX, this.zzVY, this.zzVZ);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        zza.zza(this, out, flags);
    }

    public String zzmx() {
        return this.zzWa;
    }
}
