package com.google.android.gms.nearby.sharing.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

/* JADX INFO: loaded from: classes.dex */
public final class TrustedDevicesRequest implements SafeParcelable {
    public static final Parcelable.Creator<TrustedDevicesRequest> CREATOR = new zzk();
    final int versionCode;
    public zzc zzbdo;
    public String zzbdq;
    public byte[] zzbdr;

    TrustedDevicesRequest(int versionCode, String deviceIdentifier, byte[] message, IBinder callbackAsBinder) {
        this.versionCode = versionCode;
        this.zzbdq = (String) zzx.zzz(deviceIdentifier);
        this.zzbdr = (byte[]) zzx.zzz(message);
        this.zzbdo = zzc.zza.zzdH(callbackAsBinder);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzk.zza(this, dest, flags);
    }

    IBinder zzED() {
        return this.zzbdo.asBinder();
    }
}
