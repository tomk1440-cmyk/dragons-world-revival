package com.google.android.gms.cast.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

/* JADX INFO: loaded from: classes.dex */
public class DeviceStatus implements SafeParcelable {
    public static final Parcelable.Creator<DeviceStatus> CREATOR = new zzg();
    private final int mVersionCode;
    private double zzabs;
    private boolean zzabt;
    private int zzadG;
    private int zzadH;
    private ApplicationMetadata zzadR;

    public DeviceStatus() {
        this(3, Double.NaN, false, -1, null, -1);
    }

    DeviceStatus(int versionCode, double volume, boolean muteState, int activeInputState, ApplicationMetadata applicationMetadata, int standbyState) {
        this.mVersionCode = versionCode;
        this.zzabs = volume;
        this.zzabt = muteState;
        this.zzadG = activeInputState;
        this.zzadR = applicationMetadata;
        this.zzadH = standbyState;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DeviceStatus)) {
            return false;
        }
        DeviceStatus deviceStatus = (DeviceStatus) obj;
        return this.zzabs == deviceStatus.zzabs && this.zzabt == deviceStatus.zzabt && this.zzadG == deviceStatus.zzadG && zzf.zza(this.zzadR, deviceStatus.zzadR) && this.zzadH == deviceStatus.zzadH;
    }

    public ApplicationMetadata getApplicationMetadata() {
        return this.zzadR;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(Double.valueOf(this.zzabs), Boolean.valueOf(this.zzabt), Integer.valueOf(this.zzadG), this.zzadR, Integer.valueOf(this.zzadH));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        zzg.zza(this, out, flags);
    }

    public double zzok() {
        return this.zzabs;
    }

    public int zzol() {
        return this.zzadG;
    }

    public int zzom() {
        return this.zzadH;
    }

    public boolean zzot() {
        return this.zzabt;
    }
}
