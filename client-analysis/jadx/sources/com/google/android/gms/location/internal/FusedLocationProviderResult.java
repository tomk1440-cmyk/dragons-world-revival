package com.google.android.gms.location.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public final class FusedLocationProviderResult implements Result, SafeParcelable {
    private final int mVersionCode;
    private final Status zzUX;
    public static final FusedLocationProviderResult zzaOC = new FusedLocationProviderResult(Status.zzagC);
    public static final Parcelable.Creator<FusedLocationProviderResult> CREATOR = new zze();

    FusedLocationProviderResult(int version, Status status) {
        this.mVersionCode = version;
        this.zzUX = status;
    }

    public FusedLocationProviderResult(Status status) {
        this(1, status);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.zzUX;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zze.zza(this, dest, flags);
    }
}
