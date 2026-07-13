package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.data.Bucket;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.RawBucket;
import com.google.android.gms.fitness.data.RawDataSet;
import com.google.android.gms.fitness.request.DataReadRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DataReadResult implements Result, SafeParcelable {
    public static final Parcelable.Creator<DataReadResult> CREATOR = new zzc();
    private final int mVersionCode;
    private final Status zzUX;
    private final List<Bucket> zzaBF;
    private int zzaBG;
    private final List<DataType> zzaBH;
    private final List<DataSet> zzawg;
    private final List<DataSource> zzawq;

    DataReadResult(int versionCode, List<RawDataSet> dataSets, Status status, List<RawBucket> buckets, int batchCount, List<DataSource> uniqueDataSources, List<DataType> uniqueDataTypes) {
        this.mVersionCode = versionCode;
        this.zzUX = status;
        this.zzaBG = batchCount;
        this.zzawq = uniqueDataSources;
        this.zzaBH = uniqueDataTypes;
        this.zzawg = new ArrayList(dataSets.size());
        Iterator<RawDataSet> it = dataSets.iterator();
        while (it.hasNext()) {
            this.zzawg.add(new DataSet(it.next(), uniqueDataSources));
        }
        this.zzaBF = new ArrayList(buckets.size());
        Iterator<RawBucket> it2 = buckets.iterator();
        while (it2.hasNext()) {
            this.zzaBF.add(new Bucket(it2.next(), uniqueDataSources));
        }
    }

    public DataReadResult(List<DataSet> dataSets, List<Bucket> buckets, Status status) {
        this.mVersionCode = 5;
        this.zzawg = dataSets;
        this.zzUX = status;
        this.zzaBF = buckets;
        this.zzaBG = 1;
        this.zzawq = new ArrayList();
        this.zzaBH = new ArrayList();
    }

    public static DataReadResult zza(Status status, DataReadRequest dataReadRequest) {
        ArrayList arrayList = new ArrayList();
        Iterator<DataSource> it = dataReadRequest.getDataSources().iterator();
        while (it.hasNext()) {
            arrayList.add(DataSet.create(it.next()));
        }
        Iterator<DataType> it2 = dataReadRequest.getDataTypes().iterator();
        while (it2.hasNext()) {
            arrayList.add(DataSet.create(new DataSource.Builder().setDataType(it2.next()).setType(1).setName("Default").build()));
        }
        return new DataReadResult(arrayList, Collections.emptyList(), status);
    }

    private void zza(Bucket bucket, List<Bucket> list) {
        for (Bucket bucket2 : list) {
            if (bucket2.zzb(bucket)) {
                Iterator<DataSet> it = bucket.getDataSets().iterator();
                while (it.hasNext()) {
                    zza(it.next(), bucket2.getDataSets());
                }
                return;
            }
        }
        this.zzaBF.add(bucket);
    }

    private void zza(DataSet dataSet, List<DataSet> list) {
        for (DataSet dataSet2 : list) {
            if (dataSet2.getDataSource().equals(dataSet.getDataSource())) {
                dataSet2.zzb(dataSet.getDataPoints());
                return;
            }
        }
        list.add(dataSet);
    }

    private boolean zzc(DataReadResult dataReadResult) {
        return this.zzUX.equals(dataReadResult.zzUX) && zzw.equal(this.zzawg, dataReadResult.zzawg) && zzw.equal(this.zzaBF, dataReadResult.zzaBF);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof DataReadResult) && zzc((DataReadResult) that));
    }

    public List<Bucket> getBuckets() {
        return this.zzaBF;
    }

    public DataSet getDataSet(DataSource dataSource) {
        for (DataSet dataSet : this.zzawg) {
            if (dataSource.equals(dataSet.getDataSource())) {
                return dataSet;
            }
        }
        return DataSet.create(dataSource);
    }

    public DataSet getDataSet(DataType dataType) {
        for (DataSet dataSet : this.zzawg) {
            if (dataType.equals(dataSet.getDataType())) {
                return dataSet;
            }
        }
        return DataSet.create(new DataSource.Builder().setDataType(dataType).setType(1).build());
    }

    public List<DataSet> getDataSets() {
        return this.zzawg;
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.zzUX;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzUX, this.zzawg, this.zzaBF);
    }

    public String toString() {
        return zzw.zzy(this).zzg("status", this.zzUX).zzg("dataSets", this.zzawg.size() > 5 ? this.zzawg.size() + " data sets" : this.zzawg).zzg("buckets", this.zzaBF.size() > 5 ? this.zzaBF.size() + " buckets" : this.zzaBF).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzc.zza(this, dest, flags);
    }

    public void zzb(DataReadResult dataReadResult) {
        Iterator<DataSet> it = dataReadResult.getDataSets().iterator();
        while (it.hasNext()) {
            zza(it.next(), this.zzawg);
        }
        Iterator<Bucket> it2 = dataReadResult.getBuckets().iterator();
        while (it2.hasNext()) {
            zza(it2.next(), this.zzaBF);
        }
    }

    List<DataSource> zzul() {
        return this.zzawq;
    }

    public int zzvj() {
        return this.zzaBG;
    }

    List<RawBucket> zzvk() {
        ArrayList arrayList = new ArrayList(this.zzaBF.size());
        Iterator<Bucket> it = this.zzaBF.iterator();
        while (it.hasNext()) {
            arrayList.add(new RawBucket(it.next(), this.zzawq, this.zzaBH));
        }
        return arrayList;
    }

    List<RawDataSet> zzvl() {
        ArrayList arrayList = new ArrayList(this.zzawg.size());
        Iterator<DataSet> it = this.zzawg.iterator();
        while (it.hasNext()) {
            arrayList.add(new RawDataSet(it.next(), this.zzawq, this.zzaBH));
        }
        return arrayList;
    }

    List<DataType> zzvm() {
        return this.zzaBH;
    }
}
