package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

/* JADX INFO: loaded from: classes.dex */
public final class IdpTokenType implements SafeParcelable {
    final int versionCode;
    private final String zzXC;
    public static final IdpTokenType zzXA = new IdpTokenType("accessToken");
    public static final IdpTokenType zzXB = new IdpTokenType("idToken");
    public static final Parcelable.Creator<IdpTokenType> CREATOR = new zzj();

    IdpTokenType(int versionCode, String tokenType) {
        this.versionCode = versionCode;
        this.zzXC = zzx.zzcM(tokenType);
    }

    private IdpTokenType(String tokenType) {
        this(1, tokenType);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return this.zzXC.equals(((IdpTokenType) obj).zzng());
        } catch (ClassCastException e) {
            return false;
        }
    }

    public int hashCode() {
        return this.zzXC.hashCode();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        zzj.zza(this, out, flags);
    }

    public String zzng() {
        return this.zzXC;
    }
}
