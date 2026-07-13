package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzow;

/* JADX INFO: loaded from: classes.dex */
public class UnclaimBleDeviceRequest implements SafeParcelable {
    public static final Parcelable.Creator<UnclaimBleDeviceRequest> CREATOR = new zzag();
    private final int mVersionCode;
    private final String zzaAB;
    private final zzow zzaAD;

    UnclaimBleDeviceRequest(int versionCode, String deviceAddress, IBinder callback) {
        this.mVersionCode = versionCode;
        this.zzaAB = deviceAddress;
        this.zzaAD = zzow.zza.zzbR(callback);
    }

    public UnclaimBleDeviceRequest(String deviceAddress, zzow callback) {
        this.mVersionCode = 5;
        this.zzaAB = deviceAddress;
        this.zzaAD = callback;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public IBinder getCallbackBinder() {
        if (this.zzaAD == null) {
            return null;
        }
        return this.zzaAD.asBinder();
    }

    public String getDeviceAddress() {
        return this.zzaAB;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public String toString() {
        return String.format("UnclaimBleDeviceRequest{%s}", this.zzaAB);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        zzag.zza(this, parcel, flags);
    }
}
