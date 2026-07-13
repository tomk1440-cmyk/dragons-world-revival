package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

/* JADX INFO: loaded from: classes.dex */
public final class Scope implements SafeParcelable {
    public static final Parcelable.Creator<Scope> CREATOR = new zzb();
    final int mVersionCode;
    private final String zzagB;

    Scope(int versionCode, String scopeUri) {
        zzx.zzh(scopeUri, "scopeUri must not be null or empty");
        this.mVersionCode = versionCode;
        this.zzagB = scopeUri;
    }

    public Scope(String scopeUri) {
        this(1, scopeUri);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof Scope) {
            return this.zzagB.equals(((Scope) o).zzagB);
        }
        return false;
    }

    public int hashCode() {
        return this.zzagB.hashCode();
    }

    public String toString() {
        return this.zzagB;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzb.zza(this, dest, flags);
    }

    public String zzpb() {
        return this.zzagB;
    }
}
