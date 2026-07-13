package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
@KeepName
public final class RawDataPoint implements SafeParcelable {
    public static final Parcelable.Creator<RawDataPoint> CREATOR = new zzo();
    final int mVersionCode;
    public final long zzawj;
    public final long zzawk;
    public final Value[] zzawl;
    public final long zzawn;
    public final long zzawo;
    public final int zzaxg;
    public final int zzaxh;

    public RawDataPoint(int versionCode, long timestampNanos, long startTimeNanos, Value[] values, int dataSourceIndex, int originalDataSourceIndex, long rawTimestamp, long insertionTimeMillis) {
        this.mVersionCode = versionCode;
        this.zzawj = timestampNanos;
        this.zzawk = startTimeNanos;
        this.zzaxg = dataSourceIndex;
        this.zzaxh = originalDataSourceIndex;
        this.zzawn = rawTimestamp;
        this.zzawo = insertionTimeMillis;
        this.zzawl = values;
    }

    RawDataPoint(DataPoint dataPoint, List<DataSource> dataSources) {
        this.mVersionCode = 4;
        this.zzawj = dataPoint.getTimestamp(TimeUnit.NANOSECONDS);
        this.zzawk = dataPoint.getStartTime(TimeUnit.NANOSECONDS);
        this.zzawl = dataPoint.zzuf();
        this.zzaxg = zzt.zza(dataPoint.getDataSource(), dataSources);
        this.zzaxh = zzt.zza(dataPoint.getOriginalDataSource(), dataSources);
        this.zzawn = dataPoint.zzug();
        this.zzawo = dataPoint.zzuh();
    }

    private boolean zza(RawDataPoint rawDataPoint) {
        return this.zzawj == rawDataPoint.zzawj && this.zzawk == rawDataPoint.zzawk && Arrays.equals(this.zzawl, rawDataPoint.zzawl) && this.zzaxg == rawDataPoint.zzaxg && this.zzaxh == rawDataPoint.zzaxh && this.zzawn == rawDataPoint.zzawn;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return this == o || ((o instanceof RawDataPoint) && zza((RawDataPoint) o));
    }

    public int hashCode() {
        return zzw.hashCode(Long.valueOf(this.zzawj), Long.valueOf(this.zzawk));
    }

    public String toString() {
        return String.format("RawDataPoint{%s@[%s, %s](%d,%d)}", Arrays.toString(this.zzawl), Long.valueOf(this.zzawk), Long.valueOf(this.zzawj), Integer.valueOf(this.zzaxg), Integer.valueOf(this.zzaxh));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        zzo.zza(this, parcel, flags);
    }
}
