package com.google.android.gms.fitness.internal.service;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.data.DataType;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class FitnessDataSourcesRequest implements SafeParcelable {
    public static final Parcelable.Creator<FitnessDataSourcesRequest> CREATOR = new zza();
    private final int mVersionCode;
    private final List<DataType> zzawe;

    FitnessDataSourcesRequest(int versionCode, List<DataType> dataTypes) {
        this.mVersionCode = versionCode;
        this.zzawe = dataTypes;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<DataType> getDataTypes() {
        return Collections.unmodifiableList(this.zzawe);
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public String toString() {
        return zzw.zzy(this).zzg("dataTypes", this.zzawe).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        zza.zza(this, parcel, flags);
    }
}
