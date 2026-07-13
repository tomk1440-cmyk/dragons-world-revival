package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.Bucket;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Device;
import com.google.android.gms.internal.zzoh;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class DataReadRequest implements SafeParcelable {
    public static final Parcelable.Creator<DataReadRequest> CREATOR = new zzf();
    public static final int NO_LIMIT = 0;
    private final int mVersionCode;
    private final long zzRD;
    private final List<DataSource> zzaAF;
    private final List<DataType> zzaAK;
    private final List<DataSource> zzaAL;
    private final long zzaAM;
    private final DataSource zzaAN;
    private final int zzaAO;
    private final boolean zzaAP;
    private final boolean zzaAQ;
    private final zzoh zzaAR;
    private final List<Device> zzaAS;
    private final long zzavV;
    private final List<DataType> zzawe;
    private final int zzawh;

    public static class Builder {
        private long zzRD;
        private DataSource zzaAN;
        private long zzavV;
        private List<DataType> zzawe = new ArrayList();
        private List<DataSource> zzaAF = new ArrayList();
        private List<DataType> zzaAK = new ArrayList();
        private List<DataSource> zzaAL = new ArrayList();
        private int zzawh = 0;
        private long zzaAM = 0;
        private int zzaAO = 0;
        private boolean zzaAP = false;
        private boolean zzaAQ = false;
        private List<Device> zzaAS = new ArrayList();

        public Builder aggregate(DataSource dataSource, DataType outputDataType) {
            com.google.android.gms.common.internal.zzx.zzb(dataSource, "Attempting to add a null data source");
            com.google.android.gms.common.internal.zzx.zza(!this.zzaAF.contains(dataSource), "Cannot add the same data source for aggregated and detailed");
            DataType dataType = dataSource.getDataType();
            com.google.android.gms.common.internal.zzx.zzb(DataType.AGGREGATE_INPUT_TYPES.contains(dataType), "Unsupported input data type specified for aggregation: %s", dataType);
            com.google.android.gms.common.internal.zzx.zzb(DataType.getAggregatesForInput(dataType).contains(outputDataType), "Invalid output aggregate data type specified: %s -> %s", dataType, outputDataType);
            if (!this.zzaAL.contains(dataSource)) {
                this.zzaAL.add(dataSource);
            }
            return this;
        }

        public Builder aggregate(DataType inputDataType, DataType outputDataType) {
            com.google.android.gms.common.internal.zzx.zzb(inputDataType, "Attempting to use a null data type");
            com.google.android.gms.common.internal.zzx.zza(!this.zzawe.contains(inputDataType), "Cannot add the same data type as aggregated and detailed");
            com.google.android.gms.common.internal.zzx.zzb(DataType.AGGREGATE_INPUT_TYPES.contains(inputDataType), "Unsupported input data type specified for aggregation: %s", inputDataType);
            com.google.android.gms.common.internal.zzx.zzb(DataType.getAggregatesForInput(inputDataType).contains(outputDataType), "Invalid output aggregate data type specified: %s -> %s", inputDataType, outputDataType);
            if (!this.zzaAK.contains(inputDataType)) {
                this.zzaAK.add(inputDataType);
            }
            return this;
        }

        public Builder bucketByActivitySegment(int minDuration, TimeUnit timeUnit) {
            com.google.android.gms.common.internal.zzx.zzb(this.zzawh == 0, "Bucketing strategy already set to %s", Integer.valueOf(this.zzawh));
            com.google.android.gms.common.internal.zzx.zzb(minDuration > 0, "Must specify a valid minimum duration for an activity segment: %d", Integer.valueOf(minDuration));
            this.zzawh = 4;
            this.zzaAM = timeUnit.toMillis(minDuration);
            return this;
        }

        public Builder bucketByActivitySegment(int minDuration, TimeUnit timeUnit, DataSource activityDataSource) {
            com.google.android.gms.common.internal.zzx.zzb(this.zzawh == 0, "Bucketing strategy already set to %s", Integer.valueOf(this.zzawh));
            com.google.android.gms.common.internal.zzx.zzb(minDuration > 0, "Must specify a valid minimum duration for an activity segment: %d", Integer.valueOf(minDuration));
            com.google.android.gms.common.internal.zzx.zzb(activityDataSource != null, "Invalid activity data source specified");
            com.google.android.gms.common.internal.zzx.zzb(activityDataSource.getDataType().equals(DataType.TYPE_ACTIVITY_SEGMENT), "Invalid activity data source specified: %s", activityDataSource);
            this.zzaAN = activityDataSource;
            this.zzawh = 4;
            this.zzaAM = timeUnit.toMillis(minDuration);
            return this;
        }

        public Builder bucketByActivityType(int minDuration, TimeUnit timeUnit) {
            com.google.android.gms.common.internal.zzx.zzb(this.zzawh == 0, "Bucketing strategy already set to %s", Integer.valueOf(this.zzawh));
            com.google.android.gms.common.internal.zzx.zzb(minDuration > 0, "Must specify a valid minimum duration for an activity segment: %d", Integer.valueOf(minDuration));
            this.zzawh = 3;
            this.zzaAM = timeUnit.toMillis(minDuration);
            return this;
        }

        public Builder bucketByActivityType(int minDuration, TimeUnit timeUnit, DataSource activityDataSource) {
            com.google.android.gms.common.internal.zzx.zzb(this.zzawh == 0, "Bucketing strategy already set to %s", Integer.valueOf(this.zzawh));
            com.google.android.gms.common.internal.zzx.zzb(minDuration > 0, "Must specify a valid minimum duration for an activity segment: %d", Integer.valueOf(minDuration));
            com.google.android.gms.common.internal.zzx.zzb(activityDataSource != null, "Invalid activity data source specified");
            com.google.android.gms.common.internal.zzx.zzb(activityDataSource.getDataType().equals(DataType.TYPE_ACTIVITY_SEGMENT), "Invalid activity data source specified: %s", activityDataSource);
            this.zzaAN = activityDataSource;
            this.zzawh = 3;
            this.zzaAM = timeUnit.toMillis(minDuration);
            return this;
        }

        public Builder bucketBySession(int minDuration, TimeUnit timeUnit) {
            com.google.android.gms.common.internal.zzx.zzb(this.zzawh == 0, "Bucketing strategy already set to %s", Integer.valueOf(this.zzawh));
            com.google.android.gms.common.internal.zzx.zzb(minDuration > 0, "Must specify a valid minimum duration for an activity segment: %d", Integer.valueOf(minDuration));
            this.zzawh = 2;
            this.zzaAM = timeUnit.toMillis(minDuration);
            return this;
        }

        public Builder bucketByTime(int duration, TimeUnit timeUnit) {
            com.google.android.gms.common.internal.zzx.zzb(this.zzawh == 0, "Bucketing strategy already set to %s", Integer.valueOf(this.zzawh));
            com.google.android.gms.common.internal.zzx.zzb(duration > 0, "Must specify a valid minimum duration for an activity segment: %d", Integer.valueOf(duration));
            this.zzawh = 1;
            this.zzaAM = timeUnit.toMillis(duration);
            return this;
        }

        public DataReadRequest build() {
            boolean z = true;
            com.google.android.gms.common.internal.zzx.zza((this.zzaAF.isEmpty() && this.zzawe.isEmpty() && this.zzaAL.isEmpty() && this.zzaAK.isEmpty()) ? false : true, "Must add at least one data source (aggregated or detailed)");
            com.google.android.gms.common.internal.zzx.zza(this.zzRD > 0, "Invalid start time: %s", Long.valueOf(this.zzRD));
            com.google.android.gms.common.internal.zzx.zza(this.zzavV > 0 && this.zzavV > this.zzRD, "Invalid end time: %s", Long.valueOf(this.zzavV));
            boolean z2 = this.zzaAL.isEmpty() && this.zzaAK.isEmpty();
            if ((!z2 || this.zzawh != 0) && (z2 || this.zzawh == 0)) {
                z = false;
            }
            com.google.android.gms.common.internal.zzx.zza(z, "Must specify a valid bucketing strategy while requesting aggregation");
            return new DataReadRequest(this);
        }

        public Builder enableServerQueries() {
            this.zzaAQ = true;
            return this;
        }

        public Builder read(DataSource dataSource) {
            com.google.android.gms.common.internal.zzx.zzb(dataSource, "Attempting to add a null data source");
            com.google.android.gms.common.internal.zzx.zzb(!this.zzaAL.contains(dataSource), "Cannot add the same data source as aggregated and detailed");
            if (!this.zzaAF.contains(dataSource)) {
                this.zzaAF.add(dataSource);
            }
            return this;
        }

        public Builder read(DataType dataType) {
            com.google.android.gms.common.internal.zzx.zzb(dataType, "Attempting to use a null data type");
            com.google.android.gms.common.internal.zzx.zza(!this.zzaAK.contains(dataType), "Cannot add the same data type as aggregated and detailed");
            if (!this.zzawe.contains(dataType)) {
                this.zzawe.add(dataType);
            }
            return this;
        }

        public Builder setLimit(int limit) {
            com.google.android.gms.common.internal.zzx.zzb(limit > 0, "Invalid limit %d is specified", Integer.valueOf(limit));
            this.zzaAO = limit;
            return this;
        }

        public Builder setTimeRange(long start, long end, TimeUnit timeUnit) {
            this.zzRD = timeUnit.toMillis(start);
            this.zzavV = timeUnit.toMillis(end);
            return this;
        }
    }

    DataReadRequest(int versionCode, List<DataType> dataTypes, List<DataSource> dataSources, long startTimeMillis, long endTimeMillis, List<DataType> aggregatedDataTypes, List<DataSource> aggregatedDataSources, int bucketType, long bucketDurationMillis, DataSource activityDataSource, int limit, boolean flushBeforeRead, boolean serverQueriesEnabled, IBinder callback, List<Device> filteredDevices) {
        this.mVersionCode = versionCode;
        this.zzawe = dataTypes;
        this.zzaAF = dataSources;
        this.zzRD = startTimeMillis;
        this.zzavV = endTimeMillis;
        this.zzaAK = aggregatedDataTypes;
        this.zzaAL = aggregatedDataSources;
        this.zzawh = bucketType;
        this.zzaAM = bucketDurationMillis;
        this.zzaAN = activityDataSource;
        this.zzaAO = limit;
        this.zzaAP = flushBeforeRead;
        this.zzaAQ = serverQueriesEnabled;
        this.zzaAR = callback == null ? null : zzoh.zza.zzbC(callback);
        this.zzaAS = filteredDevices == null ? Collections.emptyList() : filteredDevices;
    }

    private DataReadRequest(Builder builder) {
        this(builder.zzawe, builder.zzaAF, builder.zzRD, builder.zzavV, builder.zzaAK, builder.zzaAL, builder.zzawh, builder.zzaAM, builder.zzaAN, builder.zzaAO, builder.zzaAP, builder.zzaAQ, null, builder.zzaAS);
    }

    public DataReadRequest(DataReadRequest request, zzoh callback) {
        this(request.zzawe, request.zzaAF, request.zzRD, request.zzavV, request.zzaAK, request.zzaAL, request.zzawh, request.zzaAM, request.zzaAN, request.zzaAO, request.zzaAP, request.zzaAQ, callback, request.zzaAS);
    }

    public DataReadRequest(List<DataType> dataTypes, List<DataSource> dataSources, long startTimeMillis, long endTimeMillis, List<DataType> aggregatedDataTypes, List<DataSource> aggregatedDataSources, int bucketType, long bucketDurationMillis, DataSource activityDataSource, int limit, boolean flushBeforeRead, boolean serverQueriesEnabled, zzoh callback, List<Device> filteredDevices) {
        this(5, dataTypes, dataSources, startTimeMillis, endTimeMillis, aggregatedDataTypes, aggregatedDataSources, bucketType, bucketDurationMillis, activityDataSource, limit, flushBeforeRead, serverQueriesEnabled, callback == null ? null : callback.asBinder(), filteredDevices);
    }

    private boolean zzb(DataReadRequest dataReadRequest) {
        return this.zzawe.equals(dataReadRequest.zzawe) && this.zzaAF.equals(dataReadRequest.zzaAF) && this.zzRD == dataReadRequest.zzRD && this.zzavV == dataReadRequest.zzavV && this.zzawh == dataReadRequest.zzawh && this.zzaAL.equals(dataReadRequest.zzaAL) && this.zzaAK.equals(dataReadRequest.zzaAK) && com.google.android.gms.common.internal.zzw.equal(this.zzaAN, dataReadRequest.zzaAN) && this.zzaAM == dataReadRequest.zzaAM && this.zzaAQ == dataReadRequest.zzaAQ;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof DataReadRequest) && zzb((DataReadRequest) that));
    }

    public DataSource getActivityDataSource() {
        return this.zzaAN;
    }

    public List<DataSource> getAggregatedDataSources() {
        return this.zzaAL;
    }

    public List<DataType> getAggregatedDataTypes() {
        return this.zzaAK;
    }

    public long getBucketDuration(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzaAM, TimeUnit.MILLISECONDS);
    }

    public int getBucketType() {
        return this.zzawh;
    }

    public IBinder getCallbackBinder() {
        if (this.zzaAR == null) {
            return null;
        }
        return this.zzaAR.asBinder();
    }

    public List<DataSource> getDataSources() {
        return this.zzaAF;
    }

    public List<DataType> getDataTypes() {
        return this.zzawe;
    }

    public long getEndTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzavV, TimeUnit.MILLISECONDS);
    }

    public int getLimit() {
        return this.zzaAO;
    }

    public long getStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzRD, TimeUnit.MILLISECONDS);
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.zzw.hashCode(Integer.valueOf(this.zzawh), Long.valueOf(this.zzRD), Long.valueOf(this.zzavV));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DataReadRequest{");
        if (!this.zzawe.isEmpty()) {
            Iterator<DataType> it = this.zzawe.iterator();
            while (it.hasNext()) {
                sb.append(it.next().zzuo()).append(" ");
            }
        }
        if (!this.zzaAF.isEmpty()) {
            Iterator<DataSource> it2 = this.zzaAF.iterator();
            while (it2.hasNext()) {
                sb.append(it2.next().toDebugString()).append(" ");
            }
        }
        if (this.zzawh != 0) {
            sb.append("bucket by ").append(Bucket.zzeM(this.zzawh));
            if (this.zzaAM > 0) {
                sb.append(" >").append(this.zzaAM).append("ms");
            }
            sb.append(": ");
        }
        if (!this.zzaAK.isEmpty()) {
            Iterator<DataType> it3 = this.zzaAK.iterator();
            while (it3.hasNext()) {
                sb.append(it3.next().zzuo()).append(" ");
            }
        }
        if (!this.zzaAL.isEmpty()) {
            Iterator<DataSource> it4 = this.zzaAL.iterator();
            while (it4.hasNext()) {
                sb.append(it4.next().toDebugString()).append(" ");
            }
        }
        sb.append(String.format("(%tF %tT - %tF %tT)", Long.valueOf(this.zzRD), Long.valueOf(this.zzRD), Long.valueOf(this.zzavV), Long.valueOf(this.zzavV)));
        if (this.zzaAN != null) {
            sb.append("activities: ").append(this.zzaAN.toDebugString());
        }
        if (this.zzaAQ) {
            sb.append(" +server");
        }
        sb.append("}");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzf.zza(this, dest, flags);
    }

    public long zzlO() {
        return this.zzRD;
    }

    public boolean zzuP() {
        return this.zzaAQ;
    }

    public boolean zzuQ() {
        return this.zzaAP;
    }

    public long zzuR() {
        return this.zzaAM;
    }

    public List<Device> zzuS() {
        return this.zzaAS;
    }

    public long zzud() {
        return this.zzavV;
    }
}
