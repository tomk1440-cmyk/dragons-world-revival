package com.google.android.gms.auth.api.proxy;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public class ProxyGrpcRequest implements SafeParcelable {
    public static final Parcelable.Creator<ProxyGrpcRequest> CREATOR = new zza();
    public final byte[] body;
    public final String hostname;
    public final String method;
    public final int port;
    public final long timeoutMillis;
    final int versionCode;

    ProxyGrpcRequest(int version, String hostname, int port, long timeoutMillis, byte[] body, String method) {
        this.versionCode = version;
        this.hostname = hostname;
        this.port = port;
        this.timeoutMillis = timeoutMillis;
        this.body = body;
        this.method = method;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        zza.zza(this, parcel, flags);
    }
}
