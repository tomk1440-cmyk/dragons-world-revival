package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.zzog;

/* JADX INFO: loaded from: classes.dex */
public class DailyTotalRequest implements SafeParcelable {
    public static final Parcelable.Creator<DailyTotalRequest> CREATOR = new zzc();
    private final int mVersionCode;
    private final zzog zzaAE;
    private DataType zzavT;

    DailyTotalRequest(int versionCode, IBinder callback, DataType dataType) {
        this.mVersionCode = versionCode;
        this.zzaAE = zzog.zza.zzbB(callback);
        this.zzavT = dataType;
    }

    public DailyTotalRequest(zzog callback, DataType dataType) {
        this.mVersionCode = 2;
        this.zzaAE = callback;
        this.zzavT = dataType;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public IBinder getCallbackBinder() {
        return this.zzaAE.asBinder();
    }

    public DataType getDataType() {
        return this.zzavT;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public String toString() {
        return String.format("DailyTotalRequest{%s}", this.zzavT.zzuo());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        zzc.zza(this, parcel, flags);
    }
}
