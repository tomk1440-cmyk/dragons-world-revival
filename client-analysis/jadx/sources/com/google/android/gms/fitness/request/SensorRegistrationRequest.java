package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.zzow;
import com.google.android.gms.location.LocationRequest;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class SensorRegistrationRequest implements SafeParcelable {
    public static final Parcelable.Creator<SensorRegistrationRequest> CREATOR = new zzv();
    private final PendingIntent mPendingIntent;
    private final int mVersionCode;
    private final zzow zzaAD;
    private com.google.android.gms.fitness.data.zzk zzaBh;
    int zzaBi;
    int zzaBj;
    private final long zzaBk;
    private final long zzaBl;
    private final List<LocationRequest> zzaBm;
    private final long zzaBn;
    private final List<Object> zzaBo;
    private DataType zzavT;
    private DataSource zzavU;
    private final long zzaxo;
    private final int zzaxp;

    SensorRegistrationRequest(int versionCode, DataSource dataSource, DataType dataType, IBinder listenerBinder, int samplingIntervalMicrosInt, int maxDeliveryLatencyMicrosInt, long samplingIntervalMicros, long maxDeliveryLatencyMicros, PendingIntent intent, long fastestIntervalMicros, int accuracyMode, List<LocationRequest> locationRequests, long registrationTimeOutMicros, IBinder callback) {
        this.mVersionCode = versionCode;
        this.zzavU = dataSource;
        this.zzavT = dataType;
        this.zzaBh = listenerBinder == null ? null : com.google.android.gms.fitness.data.zzk.zza.zzbt(listenerBinder);
        this.zzaxo = samplingIntervalMicros == 0 ? samplingIntervalMicrosInt : samplingIntervalMicros;
        this.zzaBl = fastestIntervalMicros;
        this.zzaBk = maxDeliveryLatencyMicros == 0 ? maxDeliveryLatencyMicrosInt : maxDeliveryLatencyMicros;
        this.zzaBm = locationRequests;
        this.mPendingIntent = intent;
        this.zzaxp = accuracyMode;
        this.zzaBo = Collections.emptyList();
        this.zzaBn = registrationTimeOutMicros;
        this.zzaAD = zzow.zza.zzbR(callback);
    }

    public SensorRegistrationRequest(DataSource dataSource, DataType dataType, com.google.android.gms.fitness.data.zzk listener, PendingIntent pendingIntent, long samplingIntervalMicros, long fastestIntervalMicros, long maxDeliveryLatencyMicros, int accuracyMode, List<LocationRequest> locationRequests, List<Object> list, long registrationTimeOutMicros, zzow callback) {
        this.mVersionCode = 6;
        this.zzavU = dataSource;
        this.zzavT = dataType;
        this.zzaBh = listener;
        this.mPendingIntent = pendingIntent;
        this.zzaxo = samplingIntervalMicros;
        this.zzaBl = fastestIntervalMicros;
        this.zzaBk = maxDeliveryLatencyMicros;
        this.zzaxp = accuracyMode;
        this.zzaBm = locationRequests;
        this.zzaBo = list;
        this.zzaBn = registrationTimeOutMicros;
        this.zzaAD = callback;
    }

    public SensorRegistrationRequest(SensorRequest request, com.google.android.gms.fitness.data.zzk listener, PendingIntent intent, zzow callback) {
        this(request.getDataSource(), request.getDataType(), listener, intent, request.getSamplingRate(TimeUnit.MICROSECONDS), request.getFastestRate(TimeUnit.MICROSECONDS), request.getMaxDeliveryLatency(TimeUnit.MICROSECONDS), request.getAccuracyMode(), null, Collections.emptyList(), request.zzvc(), callback);
    }

    private boolean zzb(SensorRegistrationRequest sensorRegistrationRequest) {
        return com.google.android.gms.common.internal.zzw.equal(this.zzavU, sensorRegistrationRequest.zzavU) && com.google.android.gms.common.internal.zzw.equal(this.zzavT, sensorRegistrationRequest.zzavT) && this.zzaxo == sensorRegistrationRequest.zzaxo && this.zzaBl == sensorRegistrationRequest.zzaBl && this.zzaBk == sensorRegistrationRequest.zzaBk && this.zzaxp == sensorRegistrationRequest.zzaxp && com.google.android.gms.common.internal.zzw.equal(this.zzaBm, sensorRegistrationRequest.zzaBm);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof SensorRegistrationRequest) && zzb((SensorRegistrationRequest) that));
    }

    public int getAccuracyMode() {
        return this.zzaxp;
    }

    public IBinder getCallbackBinder() {
        if (this.zzaAD == null) {
            return null;
        }
        return this.zzaAD.asBinder();
    }

    public DataSource getDataSource() {
        return this.zzavU;
    }

    public DataType getDataType() {
        return this.zzavT;
    }

    public PendingIntent getIntent() {
        return this.mPendingIntent;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.zzw.hashCode(this.zzavU, this.zzavT, this.zzaBh, Long.valueOf(this.zzaxo), Long.valueOf(this.zzaBl), Long.valueOf(this.zzaBk), Integer.valueOf(this.zzaxp), this.zzaBm);
    }

    public String toString() {
        return String.format("SensorRegistrationRequest{type %s source %s interval %s fastest %s latency %s}", this.zzavT, this.zzavU, Long.valueOf(this.zzaxo), Long.valueOf(this.zzaBl), Long.valueOf(this.zzaBk));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        zzv.zza(this, parcel, flags);
    }

    public long zzuX() {
        return this.zzaBl;
    }

    public long zzuY() {
        return this.zzaBk;
    }

    public List<LocationRequest> zzuZ() {
        return this.zzaBm;
    }

    public long zzux() {
        return this.zzaxo;
    }

    public long zzva() {
        return this.zzaBn;
    }

    IBinder zzvb() {
        if (this.zzaBh == null) {
            return null;
        }
        return this.zzaBh.asBinder();
    }
}
