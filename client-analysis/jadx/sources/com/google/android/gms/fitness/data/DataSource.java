package com.google.android.gms.fitness.data;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

/* JADX INFO: loaded from: classes.dex */
public class DataSource implements SafeParcelable {
    public static final Parcelable.Creator<DataSource> CREATOR = new zzf();
    public static final String EXTRA_DATA_SOURCE = "vnd.google.fitness.data_source";
    public static final int TYPE_DERIVED = 1;
    public static final int TYPE_RAW = 0;
    private final String mName;
    private final int mVersionCode;
    private final int zzabB;
    private final DataType zzavT;
    private final Device zzawr;
    private final Application zzaws;
    private final String zzawt;
    private final String zzawu;

    public static final class Builder {
        private String mName;
        private DataType zzavT;
        private Device zzawr;
        private Application zzaws;
        private int zzabB = -1;
        private String zzawt = "";

        public DataSource build() {
            zzx.zza(this.zzavT != null, "Must set data type");
            zzx.zza(this.zzabB >= 0, "Must set data source type");
            return new DataSource(this);
        }

        public Builder setAppPackageName(Context appContext) {
            return setAppPackageName(appContext.getPackageName());
        }

        public Builder setAppPackageName(String packageName) {
            this.zzaws = Application.zzdn(packageName);
            return this;
        }

        public Builder setDataType(DataType dataType) {
            this.zzavT = dataType;
            return this;
        }

        public Builder setDevice(Device device) {
            this.zzawr = device;
            return this;
        }

        public Builder setName(String name) {
            this.mName = name;
            return this;
        }

        public Builder setStreamName(String streamName) {
            zzx.zzb(streamName != null, "Must specify a valid stream name");
            this.zzawt = streamName;
            return this;
        }

        public Builder setType(int type) {
            this.zzabB = type;
            return this;
        }
    }

    DataSource(int versionCode, DataType dataType, String name, int type, Device device, Application application, String streamName) {
        this.mVersionCode = versionCode;
        this.zzavT = dataType;
        this.zzabB = type;
        this.mName = name;
        this.zzawr = device;
        this.zzaws = application;
        this.zzawt = streamName;
        this.zzawu = zzun();
    }

    private DataSource(Builder builder) {
        this.mVersionCode = 3;
        this.zzavT = builder.zzavT;
        this.zzabB = builder.zzabB;
        this.mName = builder.mName;
        this.zzawr = builder.zzawr;
        this.zzaws = builder.zzaws;
        this.zzawt = builder.zzawt;
        this.zzawu = zzun();
    }

    public static DataSource extract(Intent intent) {
        if (intent == null) {
            return null;
        }
        return (DataSource) com.google.android.gms.common.internal.safeparcel.zzc.zza(intent, EXTRA_DATA_SOURCE, CREATOR);
    }

    private String getTypeString() {
        switch (this.zzabB) {
            case 0:
                return "raw";
            case 1:
                return "derived";
            default:
                throw new IllegalArgumentException("invalid type value");
        }
    }

    private boolean zza(DataSource dataSource) {
        return this.zzawu.equals(dataSource.zzawu);
    }

    private String zzun() {
        StringBuilder sb = new StringBuilder();
        sb.append(getTypeString());
        sb.append(":").append(this.zzavT.getName());
        if (this.zzaws != null) {
            sb.append(":").append(this.zzaws.getPackageName());
        }
        if (this.zzawr != null) {
            sb.append(":").append(this.zzawr.getStreamIdentifier());
        }
        if (this.zzawt != null) {
            sb.append(":").append(this.zzawt);
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof DataSource) && zza((DataSource) that));
    }

    public String getAppPackageName() {
        if (this.zzaws == null) {
            return null;
        }
        return this.zzaws.getPackageName();
    }

    public DataType getDataType() {
        return this.zzavT;
    }

    public Device getDevice() {
        return this.zzawr;
    }

    public String getName() {
        return this.mName;
    }

    public String getStreamIdentifier() {
        return this.zzawu;
    }

    public String getStreamName() {
        return this.zzawt;
    }

    public int getType() {
        return this.zzabB;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return this.zzawu.hashCode();
    }

    public String toDebugString() {
        String str;
        StringBuilder sbAppend = new StringBuilder().append(this.zzabB == 0 ? "r" : "d").append(":").append(this.zzavT.zzuo());
        if (this.zzaws == null) {
            str = "";
        } else {
            str = this.zzaws.equals(Application.zzawa) ? ":gms" : ":" + this.zzaws.getPackageName();
        }
        return sbAppend.append(str).append(this.zzawr != null ? ":" + this.zzawr.getModel() + ":" + this.zzawr.getUid() : "").append(this.zzawt != null ? ":" + this.zzawt : "").toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DataSource{");
        sb.append(getTypeString());
        if (this.mName != null) {
            sb.append(":").append(this.mName);
        }
        if (this.zzaws != null) {
            sb.append(":").append(this.zzaws);
        }
        if (this.zzawr != null) {
            sb.append(":").append(this.zzawr);
        }
        if (this.zzawt != null) {
            sb.append(":").append(this.zzawt);
        }
        sb.append(":").append(this.zzavT);
        return sb.append("}").toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        zzf.zza(this, parcel, flags);
    }

    public Application zzum() {
        return this.zzaws;
    }
}
