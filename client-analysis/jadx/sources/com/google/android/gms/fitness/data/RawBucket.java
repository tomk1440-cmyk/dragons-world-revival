package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
@KeepName
public final class RawBucket implements SafeParcelable {
    public static final Parcelable.Creator<RawBucket> CREATOR = new zzn();
    final int mVersionCode;
    public final long zzRD;
    public final long zzavV;
    public final Session zzavX;
    public final List<RawDataSet> zzawg;
    public final int zzawh;
    public final boolean zzawi;
    public final int zzaxf;

    public RawBucket(int versionCode, long startTimeMillis, long endTimeMillis, Session session, int activity, List<RawDataSet> dataSets, int bucketType, boolean serverHasMoreData) {
        this.mVersionCode = versionCode;
        this.zzRD = startTimeMillis;
        this.zzavV = endTimeMillis;
        this.zzavX = session;
        this.zzaxf = activity;
        this.zzawg = dataSets;
        this.zzawh = bucketType;
        this.zzawi = serverHasMoreData;
    }

    public RawBucket(Bucket bucket, List<DataSource> uniqueDataSources, List<DataType> uniqueDataTypes) {
        this.mVersionCode = 2;
        this.zzRD = bucket.getStartTime(TimeUnit.MILLISECONDS);
        this.zzavV = bucket.getEndTime(TimeUnit.MILLISECONDS);
        this.zzavX = bucket.getSession();
        this.zzaxf = bucket.zzub();
        this.zzawh = bucket.getBucketType();
        this.zzawi = bucket.zzuc();
        List<DataSet> dataSets = bucket.getDataSets();
        this.zzawg = new ArrayList(dataSets.size());
        Iterator<DataSet> it = dataSets.iterator();
        while (it.hasNext()) {
            this.zzawg.add(new RawDataSet(it.next(), uniqueDataSources, uniqueDataTypes));
        }
    }

    private boolean zza(RawBucket rawBucket) {
        return this.zzRD == rawBucket.zzRD && this.zzavV == rawBucket.zzavV && this.zzaxf == rawBucket.zzaxf && zzw.equal(this.zzawg, rawBucket.zzawg) && this.zzawh == rawBucket.zzawh && this.zzawi == rawBucket.zzawi;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return this == o || ((o instanceof RawBucket) && zza((RawBucket) o));
    }

    public int hashCode() {
        return zzw.hashCode(Long.valueOf(this.zzRD), Long.valueOf(this.zzavV), Integer.valueOf(this.zzawh));
    }

    public String toString() {
        return zzw.zzy(this).zzg("startTime", Long.valueOf(this.zzRD)).zzg("endTime", Long.valueOf(this.zzavV)).zzg("activity", Integer.valueOf(this.zzaxf)).zzg("dataSets", this.zzawg).zzg("bucketType", Integer.valueOf(this.zzawh)).zzg("serverHasMoreData", Boolean.valueOf(this.zzawi)).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        zzn.zza(this, parcel, flags);
    }
}
