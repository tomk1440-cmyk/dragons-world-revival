package com.google.android.gms.games.video;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

/* JADX INFO: loaded from: classes.dex */
public final class VideoCapabilities implements SafeParcelable {
    public static final Parcelable.Creator<VideoCapabilities> CREATOR = new VideoCapabilitiesCreator();
    private final int mVersionCode;
    private final boolean zzaLm;
    private final boolean zzaLn;
    private final boolean zzaLo;
    private final boolean[] zzaLp;
    private final boolean[] zzaLq;

    public VideoCapabilities(int versionCode, boolean isCameraSupported, boolean isMicSupported, boolean isWriteStorageSupported, boolean[] supportedCaptureModes, boolean[] supportedQualityLevels) {
        this.mVersionCode = versionCode;
        this.zzaLm = isCameraSupported;
        this.zzaLn = isMicSupported;
        this.zzaLo = isWriteStorageSupported;
        this.zzaLp = supportedCaptureModes;
        this.zzaLq = supportedQualityLevels;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof VideoCapabilities)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        VideoCapabilities videoCapabilities = (VideoCapabilities) obj;
        return zzw.equal(videoCapabilities.zzyb(), zzyb()) && zzw.equal(videoCapabilities.zzyc(), zzyc()) && zzw.equal(Boolean.valueOf(videoCapabilities.zzxZ()), Boolean.valueOf(zzxZ())) && zzw.equal(Boolean.valueOf(videoCapabilities.zzxY()), Boolean.valueOf(zzxY())) && zzw.equal(Boolean.valueOf(videoCapabilities.zzya()), Boolean.valueOf(zzya()));
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(zzyb(), zzyc(), Boolean.valueOf(zzxZ()), Boolean.valueOf(zzxY()), Boolean.valueOf(zzya()));
    }

    public String toString() {
        return zzw.zzy(this).zzg("SupportedCaptureModes", zzyb()).zzg("SupportedQualityLevels", zzyc()).zzg("CameraSupported", Boolean.valueOf(zzxZ())).zzg("MicSupported", Boolean.valueOf(zzxY())).zzg("StorageWriteSupported", Boolean.valueOf(zzya())).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        VideoCapabilitiesCreator.zza(this, out, flags);
    }

    public boolean zzxY() {
        return this.zzaLn;
    }

    public boolean zzxZ() {
        return this.zzaLm;
    }

    public boolean zzya() {
        return this.zzaLo;
    }

    public boolean[] zzyb() {
        return this.zzaLp;
    }

    public boolean[] zzyc() {
        return this.zzaLq;
    }
}
