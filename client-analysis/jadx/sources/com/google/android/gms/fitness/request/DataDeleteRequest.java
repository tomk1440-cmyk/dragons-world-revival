package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.internal.zzow;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class DataDeleteRequest implements SafeParcelable {
    public static final Parcelable.Creator<DataDeleteRequest> CREATOR = new zzd();
    private final int mVersionCode;
    private final long zzRD;
    private final zzow zzaAD;
    private final List<DataSource> zzaAF;
    private final List<Session> zzaAG;
    private final boolean zzaAH;
    private final boolean zzaAI;
    private final long zzavV;
    private final List<DataType> zzawe;

    public static class Builder {
        private long zzRD;
        private long zzavV;
        private List<DataSource> zzaAF = new ArrayList();
        private List<DataType> zzawe = new ArrayList();
        private List<Session> zzaAG = new ArrayList();
        private boolean zzaAH = false;
        private boolean zzaAI = false;

        private void zzuN() {
            if (this.zzaAG.isEmpty()) {
                return;
            }
            for (Session session : this.zzaAG) {
                com.google.android.gms.common.internal.zzx.zza(session.getStartTime(TimeUnit.MILLISECONDS) >= this.zzRD && session.getEndTime(TimeUnit.MILLISECONDS) <= this.zzavV, "Session %s is outside the time interval [%d, %d]", session, Long.valueOf(this.zzRD), Long.valueOf(this.zzavV));
            }
        }

        public Builder addDataSource(DataSource dataSource) {
            com.google.android.gms.common.internal.zzx.zzb(!this.zzaAH, "All data is already marked for deletion.  addDataSource() cannot be combined with deleteAllData()");
            com.google.android.gms.common.internal.zzx.zzb(dataSource != null, "Must specify a valid data source");
            if (!this.zzaAF.contains(dataSource)) {
                this.zzaAF.add(dataSource);
            }
            return this;
        }

        public Builder addDataType(DataType dataType) {
            com.google.android.gms.common.internal.zzx.zzb(!this.zzaAH, "All data is already marked for deletion.  addDataType() cannot be combined with deleteAllData()");
            com.google.android.gms.common.internal.zzx.zzb(dataType != null, "Must specify a valid data type");
            if (!this.zzawe.contains(dataType)) {
                this.zzawe.add(dataType);
            }
            return this;
        }

        public Builder addSession(Session session) {
            com.google.android.gms.common.internal.zzx.zzb(!this.zzaAI, "All sessions already marked for deletion.  addSession() cannot be combined with deleteAllSessions()");
            com.google.android.gms.common.internal.zzx.zzb(session != null, "Must specify a valid session");
            com.google.android.gms.common.internal.zzx.zzb(session.getEndTime(TimeUnit.MILLISECONDS) > 0, "Cannot delete an ongoing session. Please stop the session prior to deleting it");
            this.zzaAG.add(session);
            return this;
        }

        public DataDeleteRequest build() {
            com.google.android.gms.common.internal.zzx.zza(this.zzRD > 0 && this.zzavV > this.zzRD, "Must specify a valid time interval");
            com.google.android.gms.common.internal.zzx.zza((this.zzaAH || !this.zzaAF.isEmpty() || !this.zzawe.isEmpty()) || (this.zzaAI || !this.zzaAG.isEmpty()), "No data or session marked for deletion");
            zzuN();
            return new DataDeleteRequest(this);
        }

        public Builder deleteAllData() {
            com.google.android.gms.common.internal.zzx.zzb(this.zzawe.isEmpty(), "Specific data type already added for deletion. deleteAllData() will delete all data types and cannot be combined with addDataType()");
            com.google.android.gms.common.internal.zzx.zzb(this.zzaAF.isEmpty(), "Specific data source already added for deletion. deleteAllData() will delete all data sources and cannot be combined with addDataSource()");
            this.zzaAH = true;
            return this;
        }

        public Builder deleteAllSessions() {
            com.google.android.gms.common.internal.zzx.zzb(this.zzaAG.isEmpty(), "Specific session already added for deletion. deleteAllData() will delete all sessions and cannot be combined with addSession()");
            this.zzaAI = true;
            return this;
        }

        public Builder setTimeInterval(long startTime, long endTime, TimeUnit timeUnit) {
            com.google.android.gms.common.internal.zzx.zzb(startTime > 0, "Invalid start time :%d", Long.valueOf(startTime));
            com.google.android.gms.common.internal.zzx.zzb(endTime > startTime, "Invalid end time :%d", Long.valueOf(endTime));
            this.zzRD = timeUnit.toMillis(startTime);
            this.zzavV = timeUnit.toMillis(endTime);
            return this;
        }
    }

    DataDeleteRequest(int versionCode, long startTimeMillis, long endTimeMillis, List<DataSource> dataSources, List<DataType> dataTypes, List<Session> sessions, boolean deleteAllData, boolean deleteAllSessions, IBinder callback) {
        this.mVersionCode = versionCode;
        this.zzRD = startTimeMillis;
        this.zzavV = endTimeMillis;
        this.zzaAF = Collections.unmodifiableList(dataSources);
        this.zzawe = Collections.unmodifiableList(dataTypes);
        this.zzaAG = sessions;
        this.zzaAH = deleteAllData;
        this.zzaAI = deleteAllSessions;
        this.zzaAD = zzow.zza.zzbR(callback);
    }

    public DataDeleteRequest(long startTimeMillis, long endTimeMillis, List<DataSource> dataSources, List<DataType> dataTypes, List<Session> sessions, boolean deleteAllData, boolean deleteAllSessions, zzow callback) {
        this.mVersionCode = 3;
        this.zzRD = startTimeMillis;
        this.zzavV = endTimeMillis;
        this.zzaAF = Collections.unmodifiableList(dataSources);
        this.zzawe = Collections.unmodifiableList(dataTypes);
        this.zzaAG = sessions;
        this.zzaAH = deleteAllData;
        this.zzaAI = deleteAllSessions;
        this.zzaAD = callback;
    }

    private DataDeleteRequest(Builder builder) {
        this(builder.zzRD, builder.zzavV, builder.zzaAF, builder.zzawe, builder.zzaAG, builder.zzaAH, builder.zzaAI, null);
    }

    public DataDeleteRequest(DataDeleteRequest request, zzow callback) {
        this(request.zzRD, request.zzavV, request.zzaAF, request.zzawe, request.zzaAG, request.zzaAH, request.zzaAI, callback);
    }

    private boolean zzb(DataDeleteRequest dataDeleteRequest) {
        return this.zzRD == dataDeleteRequest.zzRD && this.zzavV == dataDeleteRequest.zzavV && com.google.android.gms.common.internal.zzw.equal(this.zzaAF, dataDeleteRequest.zzaAF) && com.google.android.gms.common.internal.zzw.equal(this.zzawe, dataDeleteRequest.zzawe) && com.google.android.gms.common.internal.zzw.equal(this.zzaAG, dataDeleteRequest.zzaAG) && this.zzaAH == dataDeleteRequest.zzaAH && this.zzaAI == dataDeleteRequest.zzaAI;
    }

    public boolean deleteAllData() {
        return this.zzaAH;
    }

    public boolean deleteAllSessions() {
        return this.zzaAI;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return o == this || ((o instanceof DataDeleteRequest) && zzb((DataDeleteRequest) o));
    }

    public IBinder getCallbackBinder() {
        if (this.zzaAD == null) {
            return null;
        }
        return this.zzaAD.asBinder();
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

    public List<Session> getSessions() {
        return this.zzaAG;
    }

    public long getStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzRD, TimeUnit.MILLISECONDS);
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.zzw.hashCode(Long.valueOf(this.zzRD), Long.valueOf(this.zzavV));
    }

    public String toString() {
        return com.google.android.gms.common.internal.zzw.zzy(this).zzg("startTimeMillis", Long.valueOf(this.zzRD)).zzg("endTimeMillis", Long.valueOf(this.zzavV)).zzg("dataSources", this.zzaAF).zzg("dateTypes", this.zzawe).zzg("sessions", this.zzaAG).zzg("deleteAllData", Boolean.valueOf(this.zzaAH)).zzg("deleteAllSessions", Boolean.valueOf(this.zzaAI)).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzd.zza(this, dest, flags);
    }

    public long zzlO() {
        return this.zzRD;
    }

    public boolean zzuL() {
        return this.zzaAH;
    }

    public boolean zzuM() {
        return this.zzaAI;
    }

    public long zzud() {
        return this.zzavV;
    }
}
