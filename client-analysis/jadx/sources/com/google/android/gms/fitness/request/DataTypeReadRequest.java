package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzoj;

/* JADX INFO: loaded from: classes.dex */
public class DataTypeReadRequest implements SafeParcelable {
    public static final Parcelable.Creator<DataTypeReadRequest> CREATOR = new zzj();
    private final String mName;
    private final int mVersionCode;
    private final zzoj zzaBa;

    DataTypeReadRequest(int versionCode, String name, IBinder callback) {
        this.mVersionCode = versionCode;
        this.mName = name;
        this.zzaBa = zzoj.zza.zzbE(callback);
    }

    public DataTypeReadRequest(String name, zzoj callback) {
        this.mVersionCode = 3;
        this.mName = name;
        this.zzaBa = callback;
    }

    private boolean zzb(DataTypeReadRequest dataTypeReadRequest) {
        return com.google.android.gms.common.internal.zzw.equal(this.mName, dataTypeReadRequest.mName);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return o == this || ((o instanceof DataTypeReadRequest) && zzb((DataTypeReadRequest) o));
    }

    public IBinder getCallbackBinder() {
        return this.zzaBa.asBinder();
    }

    public String getName() {
        return this.mName;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.zzw.hashCode(this.mName);
    }

    public String toString() {
        return com.google.android.gms.common.internal.zzw.zzy(this).zzg("name", this.mName).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzj.zza(this, dest, flags);
    }
}
