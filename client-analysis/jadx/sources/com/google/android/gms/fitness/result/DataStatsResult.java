package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DataStatsResult implements Result, SafeParcelable {
    public static final Parcelable.Creator<DataStatsResult> CREATOR = new zzf();
    private final int mVersionCode;
    private final Status zzUX;
    private final List<DataSourceStatsResult> zzaBL;

    DataStatsResult(int versionCode, Status status, List<DataSourceStatsResult> dataSourceStats) {
        this.mVersionCode = versionCode;
        this.zzUX = status;
        this.zzaBL = dataSourceStats;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.zzUX;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzf.zza(this, dest, flags);
    }

    List<DataSourceStatsResult> zzvn() {
        return this.zzaBL;
    }
}
