package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public class GetPermissionStatusRequest implements SafeParcelable {
    public static final Parcelable.Creator<GetPermissionStatusRequest> CREATOR = new zzb();
    final int mVersionCode;

    @Deprecated
    public final String zzbbF;
    public final zze zzbcr;
    public final ClientAppContext zzbcs;

    GetPermissionStatusRequest(int versionCode, IBinder callbackAsBinder, String zeroPartyPackageName, ClientAppContext clientAppContext) {
        this.mVersionCode = versionCode;
        this.zzbcr = zze.zza.zzdz(callbackAsBinder);
        this.zzbbF = zeroPartyPackageName;
        this.zzbcs = clientAppContext == null ? new ClientAppContext(null, this.zzbbF) : clientAppContext;
    }

    GetPermissionStatusRequest(IBinder callbackAsBinder, ClientAppContext clientAppContext) {
        this(1, callbackAsBinder, null, clientAppContext);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzb.zza(this, dest, flags);
    }

    IBinder zzED() {
        return this.zzbcr.asBinder();
    }
}
