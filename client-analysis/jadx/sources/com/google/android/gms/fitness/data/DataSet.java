package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zznw;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class DataSet implements SafeParcelable {
    public static final Parcelable.Creator<DataSet> CREATOR = new zze();
    private final int mVersionCode;
    private final DataType zzavT;
    private final DataSource zzavU;
    private boolean zzawi;
    private final List<DataPoint> zzawp;
    private final List<DataSource> zzawq;

    DataSet(int versionCode, DataSource dataSource, DataType dataType, List<RawDataPoint> dataPoints, List<DataSource> uniqueDataSources, boolean serverHasMoreData) {
        this.zzawi = false;
        this.mVersionCode = versionCode;
        this.zzavU = dataSource;
        this.zzavT = dataSource.getDataType();
        this.zzawi = serverHasMoreData;
        this.zzawp = new ArrayList(dataPoints.size());
        this.zzawq = versionCode < 2 ? Collections.singletonList(dataSource) : uniqueDataSources;
        Iterator<RawDataPoint> it = dataPoints.iterator();
        while (it.hasNext()) {
            this.zzawp.add(new DataPoint(this.zzawq, it.next()));
        }
    }

    public DataSet(DataSource dataSource) {
        this.zzawi = false;
        this.mVersionCode = 3;
        this.zzavU = (DataSource) zzx.zzz(dataSource);
        this.zzavT = dataSource.getDataType();
        this.zzawp = new ArrayList();
        this.zzawq = new ArrayList();
        this.zzawq.add(this.zzavU);
    }

    public DataSet(RawDataSet dataSet, List<DataSource> uniqueDataSources) {
        this.zzawi = false;
        this.mVersionCode = 3;
        this.zzavU = (DataSource) zzb(uniqueDataSources, dataSet.zzaxg);
        this.zzavT = this.zzavU.getDataType();
        this.zzawq = uniqueDataSources;
        this.zzawi = dataSet.zzawi;
        List<RawDataPoint> list = dataSet.zzaxj;
        this.zzawp = new ArrayList(list.size());
        Iterator<RawDataPoint> it = list.iterator();
        while (it.hasNext()) {
            this.zzawp.add(new DataPoint(this.zzawq, it.next()));
        }
    }

    public static DataSet create(DataSource dataSource) {
        zzx.zzb(dataSource, "DataSource should be specified");
        return new DataSet(dataSource);
    }

    private boolean zza(DataSet dataSet) {
        return zzw.equal(getDataType(), dataSet.getDataType()) && zzw.equal(this.zzavU, dataSet.zzavU) && zzw.equal(this.zzawp, dataSet.zzawp) && this.zzawi == dataSet.zzawi;
    }

    private static <T> T zzb(List<T> list, int i) {
        if (i < 0 || i >= list.size()) {
            return null;
        }
        return list.get(i);
    }

    public void add(DataPoint dataPoint) {
        DataSource dataSource = dataPoint.getDataSource();
        zzx.zzb(dataSource.getStreamIdentifier().equals(this.zzavU.getStreamIdentifier()), "Conflicting data sources found %s vs %s", dataSource, this.zzavU);
        dataPoint.zzui();
        zznw.zze(dataPoint);
        zzb(dataPoint);
    }

    public void addAll(Iterable<DataPoint> dataPoints) {
        Iterator<DataPoint> it = dataPoints.iterator();
        while (it.hasNext()) {
            add(it.next());
        }
    }

    public DataPoint createDataPoint() {
        return DataPoint.create(this.zzavU);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return o == this || ((o instanceof DataSet) && zza((DataSet) o));
    }

    public List<DataPoint> getDataPoints() {
        return Collections.unmodifiableList(this.zzawp);
    }

    public DataSource getDataSource() {
        return this.zzavU;
    }

    public DataType getDataType() {
        return this.zzavU.getDataType();
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzavU);
    }

    public boolean isEmpty() {
        return this.zzawp.isEmpty();
    }

    public String toString() {
        List<RawDataPoint> listZzuk = zzuk();
        Object[] objArr = new Object[2];
        objArr[0] = this.zzavU.toDebugString();
        Object obj = listZzuk;
        if (this.zzawp.size() >= 10) {
            obj = String.format("%d data points, first 5: %s", Integer.valueOf(this.zzawp.size()), listZzuk.subList(0, 5));
        }
        objArr[1] = obj;
        return String.format("DataSet{%s %s}", objArr);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        zze.zza(this, parcel, flags);
    }

    public void zzb(DataPoint dataPoint) {
        this.zzawp.add(dataPoint);
        DataSource originalDataSource = dataPoint.getOriginalDataSource();
        if (originalDataSource == null || this.zzawq.contains(originalDataSource)) {
            return;
        }
        this.zzawq.add(originalDataSource);
    }

    public void zzb(Iterable<DataPoint> iterable) {
        Iterator<DataPoint> it = iterable.iterator();
        while (it.hasNext()) {
            zzb(it.next());
        }
    }

    public boolean zzuc() {
        return this.zzawi;
    }

    List<RawDataPoint> zzuk() {
        return zzv(this.zzawq);
    }

    List<DataSource> zzul() {
        return this.zzawq;
    }

    List<RawDataPoint> zzv(List<DataSource> list) {
        ArrayList arrayList = new ArrayList(this.zzawp.size());
        Iterator<DataPoint> it = this.zzawp.iterator();
        while (it.hasNext()) {
            arrayList.add(new RawDataPoint(it.next(), list));
        }
        return arrayList;
    }
}
