package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public class SignInRequest implements SafeParcelable {
    public static final Parcelable.Creator<SignInRequest> CREATOR = new zzi();
    final int mVersionCode;
    final ResolveAccountRequest zzbhj;

    SignInRequest(int versionCode, ResolveAccountRequest resolveAccountRequest) {
        this.mVersionCode = versionCode;
        this.zzbhj = resolveAccountRequest;
    }

    public SignInRequest(ResolveAccountRequest resolveAccountRequest) {
        this(1, resolveAccountRequest);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzi.zza(this, dest, flags);
    }

    public ResolveAccountRequest zzFO() {
        return this.zzbhj;
    }
}
