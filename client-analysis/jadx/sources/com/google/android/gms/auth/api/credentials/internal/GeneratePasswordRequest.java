package com.google.android.gms.auth.api.credentials.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.credentials.PasswordSpecification;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public final class GeneratePasswordRequest implements SafeParcelable {
    public static final Parcelable.Creator<GeneratePasswordRequest> CREATOR = new zzh();
    final int mVersionCode;
    private final PasswordSpecification zzVM;

    GeneratePasswordRequest(int version, PasswordSpecification passwordSpecification) {
        this.mVersionCode = version;
        this.zzVM = passwordSpecification;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        zzh.zza(this, out, flags);
    }

    public PasswordSpecification zzmr() {
        return this.zzVM;
    }
}
