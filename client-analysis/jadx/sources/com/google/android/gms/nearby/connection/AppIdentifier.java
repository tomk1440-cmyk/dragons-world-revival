package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

/* JADX INFO: loaded from: classes.dex */
public final class AppIdentifier implements SafeParcelable {
    public static final Parcelable.Creator<AppIdentifier> CREATOR = new zza();
    private final int mVersionCode;
    private final String zzaxk;

    AppIdentifier(int versionCode, String identifier) {
        this.mVersionCode = versionCode;
        this.zzaxk = zzx.zzh(identifier, "Missing application identifier value");
    }

    public AppIdentifier(String identifier) {
        this(1, identifier);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getIdentifier() {
        return this.zzaxk;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        zza.zza(this, out, flags);
    }
}
