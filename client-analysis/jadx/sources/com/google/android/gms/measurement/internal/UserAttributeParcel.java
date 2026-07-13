package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public class UserAttributeParcel implements SafeParcelable {
    public static final zzah CREATOR = new zzah();
    public final String name;
    public final int versionCode;
    public final String zzaVW;
    public final long zzaZm;
    public final Long zzaZn;
    public final Float zzaZo;
    public final String zzamJ;

    UserAttributeParcel(int versionCode, String name, long timestamp, Long longValue, Float floatValue, String stringValue, String origin) {
        this.versionCode = versionCode;
        this.name = name;
        this.zzaZm = timestamp;
        this.zzaZn = longValue;
        this.zzaZo = floatValue;
        this.zzamJ = stringValue;
        this.zzaVW = origin;
    }

    UserAttributeParcel(zzai property) {
        this(property.mName, property.zzaZp, property.zzNc, property.zzaUa);
    }

    UserAttributeParcel(String name, long setTimestamp, Object value, String origin) {
        com.google.android.gms.common.internal.zzx.zzcM(name);
        this.versionCode = 1;
        this.name = name;
        this.zzaZm = setTimestamp;
        this.zzaVW = origin;
        if (value == null) {
            this.zzaZn = null;
            this.zzaZo = null;
            this.zzamJ = null;
            return;
        }
        if (value instanceof Long) {
            this.zzaZn = (Long) value;
            this.zzaZo = null;
            this.zzamJ = null;
        } else if (value instanceof Float) {
            this.zzaZn = null;
            this.zzaZo = (Float) value;
            this.zzamJ = null;
        } else {
            if (!(value instanceof String)) {
                throw new IllegalArgumentException("User attribute given of un-supported type");
            }
            this.zzaZn = null;
            this.zzaZo = null;
            this.zzamJ = (String) value;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Object getValue() {
        if (this.zzaZn != null) {
            return this.zzaZn;
        }
        if (this.zzaZo != null) {
            return this.zzaZo;
        }
        if (this.zzamJ != null) {
            return this.zzamJ;
        }
        return null;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        zzah.zza(this, out, flags);
    }
}
