package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public class SignInResponse implements SafeParcelable {
    public static final Parcelable.Creator<SignInResponse> CREATOR = new zzj();
    final int mVersionCode;
    private final ConnectionResult zzams;
    private final ResolveAccountResponse zzbhk;

    public SignInResponse(int connectionResultStatusCode) {
        this(new ConnectionResult(connectionResultStatusCode, null), null);
    }

    SignInResponse(int versionCode, ConnectionResult connectionResult, ResolveAccountResponse resolveAccountResponse) {
        this.mVersionCode = versionCode;
        this.zzams = connectionResult;
        this.zzbhk = resolveAccountResponse;
    }

    public SignInResponse(ConnectionResult result, ResolveAccountResponse resolveAccountResponse) {
        this(1, result, resolveAccountResponse);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzj.zza(this, dest, flags);
    }

    public ResolveAccountResponse zzFP() {
        return this.zzbhk;
    }

    public ConnectionResult zzqY() {
        return this.zzams;
    }
}
