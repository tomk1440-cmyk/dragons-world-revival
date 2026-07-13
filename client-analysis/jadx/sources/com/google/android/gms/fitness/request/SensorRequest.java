package com.google.android.gms.fitness.request;

import android.os.SystemClock;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.location.LocationRequest;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class SensorRequest {
    public static final int ACCURACY_MODE_DEFAULT = 2;
    public static final int ACCURACY_MODE_HIGH = 3;
    public static final int ACCURACY_MODE_LOW = 1;
    private final long zzaBk;
    private final long zzaBl;
    private final LocationRequest zzaBp;
    private final long zzaBq;
    private final DataType zzavT;
    private final DataSource zzavU;
    private final long zzaxo;
    private final int zzaxp;

    public static class Builder {
        private DataType zzavT;
        private DataSource zzavU;
        private long zzaxo = -1;
        private long zzaBl = 0;
        private long zzaBk = 0;
        private boolean zzaBr = false;
        private int zzaxp = 2;
        private long zzaBq = Long.MAX_VALUE;

        public SensorRequest build() {
            com.google.android.gms.common.internal.zzx.zza((this.zzavU == null && this.zzavT == null) ? false : true, "Must call setDataSource() or setDataType()");
            com.google.android.gms.common.internal.zzx.zza(this.zzavT == null || this.zzavU == null || this.zzavT.equals(this.zzavU.getDataType()), "Specified data type is incompatible with specified data source");
            return new SensorRequest(this);
        }

        public Builder setAccuracyMode(int accuracyMode) {
            this.zzaxp = SensorRequest.zzfB(accuracyMode);
            return this;
        }

        public Builder setDataSource(DataSource dataSource) {
            this.zzavU = dataSource;
            return this;
        }

        public Builder setDataType(DataType dataType) {
            this.zzavT = dataType;
            return this;
        }

        public Builder setFastestRate(int fastestInterval, TimeUnit unit) {
            com.google.android.gms.common.internal.zzx.zzb(fastestInterval >= 0, "Cannot use a negative interval");
            this.zzaBr = true;
            this.zzaBl = unit.toMicros(fastestInterval);
            return this;
        }

        public Builder setMaxDeliveryLatency(int interval, TimeUnit unit) {
            com.google.android.gms.common.internal.zzx.zzb(interval >= 0, "Cannot use a negative delivery interval");
            this.zzaBk = unit.toMicros(interval);
            return this;
        }

        public Builder setSamplingRate(long interval, TimeUnit unit) {
            com.google.android.gms.common.internal.zzx.zzb(interval >= 0, "Cannot use a negative sampling interval");
            this.zzaxo = unit.toMicros(interval);
            if (!this.zzaBr) {
                this.zzaBl = this.zzaxo / 2;
            }
            return this;
        }

        public Builder setTimeout(long timeout, TimeUnit timeUnit) {
            com.google.android.gms.common.internal.zzx.zzb(timeout > 0, "Invalid time out value specified: %d", Long.valueOf(timeout));
            com.google.android.gms.common.internal.zzx.zzb(timeUnit != null, "Invalid time unit specified");
            this.zzaBq = timeUnit.toMicros(timeout);
            return this;
        }
    }

    private SensorRequest(DataSource dataSource, LocationRequest locationRequest) {
        this.zzaBp = locationRequest;
        this.zzaxo = TimeUnit.MILLISECONDS.toMicros(locationRequest.getInterval());
        this.zzaBl = TimeUnit.MILLISECONDS.toMicros(locationRequest.getFastestInterval());
        this.zzaBk = this.zzaxo;
        this.zzavT = dataSource.getDataType();
        this.zzaxp = zza(locationRequest);
        this.zzavU = dataSource;
        long expirationTime = locationRequest.getExpirationTime();
        if (expirationTime == Long.MAX_VALUE) {
            this.zzaBq = Long.MAX_VALUE;
        } else {
            this.zzaBq = TimeUnit.MILLISECONDS.toMicros(expirationTime - SystemClock.elapsedRealtime());
        }
    }

    private SensorRequest(Builder builder) {
        this.zzavU = builder.zzavU;
        this.zzavT = builder.zzavT;
        this.zzaxo = builder.zzaxo;
        this.zzaBl = builder.zzaBl;
        this.zzaBk = builder.zzaBk;
        this.zzaxp = builder.zzaxp;
        this.zzaBp = null;
        this.zzaBq = builder.zzaBq;
    }

    public static SensorRequest fromLocationRequest(DataSource dataSource, LocationRequest locationRequest) {
        return new SensorRequest(dataSource, locationRequest);
    }

    private static int zza(LocationRequest locationRequest) {
        switch (locationRequest.getPriority()) {
            case 100:
                return 3;
            case LocationRequest.PRIORITY_LOW_POWER /* 104 */:
                return 1;
            default:
                return 2;
        }
    }

    private boolean zza(SensorRequest sensorRequest) {
        return com.google.android.gms.common.internal.zzw.equal(this.zzavU, sensorRequest.zzavU) && com.google.android.gms.common.internal.zzw.equal(this.zzavT, sensorRequest.zzavT) && this.zzaxo == sensorRequest.zzaxo && this.zzaBl == sensorRequest.zzaBl && this.zzaBk == sensorRequest.zzaBk && this.zzaxp == sensorRequest.zzaxp && com.google.android.gms.common.internal.zzw.equal(this.zzaBp, sensorRequest.zzaBp) && this.zzaBq == sensorRequest.zzaBq;
    }

    public static int zzfB(int i) {
        switch (i) {
            case 1:
            case 3:
                return i;
            case 2:
            default:
                return 2;
        }
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof SensorRequest) && zza((SensorRequest) that));
    }

    public int getAccuracyMode() {
        return this.zzaxp;
    }

    public DataSource getDataSource() {
        return this.zzavU;
    }

    public DataType getDataType() {
        return this.zzavT;
    }

    public long getFastestRate(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzaBl, TimeUnit.MICROSECONDS);
    }

    public long getMaxDeliveryLatency(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzaBk, TimeUnit.MICROSECONDS);
    }

    public long getSamplingRate(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzaxo, TimeUnit.MICROSECONDS);
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.zzw.hashCode(this.zzavU, this.zzavT, Long.valueOf(this.zzaxo), Long.valueOf(this.zzaBl), Long.valueOf(this.zzaBk), Integer.valueOf(this.zzaxp), this.zzaBp, Long.valueOf(this.zzaBq));
    }

    public String toString() {
        return com.google.android.gms.common.internal.zzw.zzy(this).zzg("dataSource", this.zzavU).zzg("dataType", this.zzavT).zzg("samplingRateMicros", Long.valueOf(this.zzaxo)).zzg("deliveryLatencyMicros", Long.valueOf(this.zzaBk)).zzg("timeOutMicros", Long.valueOf(this.zzaBq)).toString();
    }

    public long zzvc() {
        return this.zzaBq;
    }
}
