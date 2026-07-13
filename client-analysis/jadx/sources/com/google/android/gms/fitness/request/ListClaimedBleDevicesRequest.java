package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzpj;

/* JADX INFO: loaded from: classes.dex */
public class ListClaimedBleDevicesRequest implements SafeParcelable {
    public static final Parcelable.Creator<ListClaimedBleDevicesRequest> CREATOR = new zzr();
    private final int mVersionCode;
    private final zzpj zzaBc;

    ListClaimedBleDevicesRequest(int versionCode, IBinder callback) {
        this.mVersionCode = versionCode;
        this.zzaBc = zzpj.zza.zzbT(callback);
    }

    public ListClaimedBleDevicesRequest(zzpj callback) {
        this.mVersionCode = 2;
        this.zzaBc = callback;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public IBinder getCallbackBinder() {
        return this.zzaBc.asBinder();
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        zzr.zza(this, parcel, flags);
    }
}
