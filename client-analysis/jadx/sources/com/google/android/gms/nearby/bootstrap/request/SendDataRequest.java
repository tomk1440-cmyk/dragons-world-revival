package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzqg;
import com.google.android.gms.nearby.bootstrap.Device;

/* JADX INFO: loaded from: classes.dex */
public class SendDataRequest implements SafeParcelable {
    public static final zzf CREATOR = new zzf();
    private final byte[] data;
    final int versionCode;
    private final Device zzbaS;
    private final zzqg zzbaV;

    SendDataRequest(int versionCode, Device device, byte[] data, IBinder callback) {
        this.versionCode = versionCode;
        this.zzbaS = (Device) zzx.zzz(device);
        this.data = (byte[]) zzx.zzz(data);
        zzx.zzz(callback);
        this.zzbaV = zzqg.zza.zzds(callback);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        zzf zzfVar = CREATOR;
        return 0;
    }

    public IBinder getCallbackBinder() {
        if (this.zzbaV == null) {
            return null;
        }
        return this.zzbaV.asBinder();
    }

    public byte[] getData() {
        return this.data;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        zzf zzfVar = CREATOR;
        zzf.zza(this, out, flags);
    }

    public Device zzEd() {
        return this.zzbaS;
    }
}
