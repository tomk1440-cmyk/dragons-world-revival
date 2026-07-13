package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.internal.zzow;

/* JADX INFO: loaded from: classes.dex */
public class DataInsertRequest implements SafeParcelable {
    public static final Parcelable.Creator<DataInsertRequest> CREATOR = new zze();
    private final int mVersionCode;
    private final zzow zzaAD;
    private final boolean zzaAJ;
    private final DataSet zzaxn;

    DataInsertRequest(int versionCode, DataSet dataSet, IBinder callback, boolean skipSync) {
        this.mVersionCode = versionCode;
        this.zzaxn = dataSet;
        this.zzaAD = zzow.zza.zzbR(callback);
        this.zzaAJ = skipSync;
    }

    public DataInsertRequest(DataSet dataSet, zzow callback, boolean skipSync) {
        this.mVersionCode = 4;
        this.zzaxn = dataSet;
        this.zzaAD = callback;
        this.zzaAJ = skipSync;
    }

    private boolean zzc(DataInsertRequest dataInsertRequest) {
        return com.google.android.gms.common.internal.zzw.equal(this.zzaxn, dataInsertRequest.zzaxn);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return o == this || ((o instanceof DataInsertRequest) && zzc((DataInsertRequest) o));
    }

    public IBinder getCallbackBinder() {
        if (this.zzaAD == null) {
            return null;
        }
        return this.zzaAD.asBinder();
    }

    public DataSet getDataSet() {
        return this.zzaxn;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.zzw.hashCode(this.zzaxn);
    }

    public String toString() {
        return com.google.android.gms.common.internal.zzw.zzy(this).zzg("dataSet", this.zzaxn).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zze.zza(this, dest, flags);
    }

    public boolean zzuO() {
        return this.zzaAJ;
    }
}
