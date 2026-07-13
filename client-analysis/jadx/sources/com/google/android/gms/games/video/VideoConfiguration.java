package com.google.android.gms.games.video;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

/* JADX INFO: loaded from: classes.dex */
public final class VideoConfiguration implements SafeParcelable {
    public static final Parcelable.Creator<VideoConfiguration> CREATOR = new VideoConfigurationCreator();
    private final int mVersionCode;
    private final int zzaLr;
    private final int zzaLs;
    private final String zzaLt;
    private final String zzaLu;

    public static final class Builder {
    }

    public VideoConfiguration(int versionCode, int qualityLevel, int captureMode, String streamUrl, String streamKey) {
        this.mVersionCode = versionCode;
        zzx.zzac(zzgZ(qualityLevel));
        zzx.zzac(zzha(captureMode));
        this.zzaLr = qualityLevel;
        this.zzaLs = captureMode;
        if (captureMode == 1) {
            this.zzaLu = streamKey;
            this.zzaLt = streamUrl;
        } else {
            zzx.zzb(streamKey == null, "Stream key should be null when not streaming");
            zzx.zzb(streamUrl == null, "Stream url should be null when not streaming");
            this.zzaLu = null;
            this.zzaLt = null;
        }
    }

    public static boolean zzgZ(int i) {
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
                return true;
            default:
                return false;
        }
    }

    public static boolean zzha(int i) {
        switch (i) {
            case 0:
            case 1:
                return true;
            default:
                return false;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getStreamUrl() {
        return this.zzaLt;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        VideoConfigurationCreator.zza(this, out, flags);
    }

    public int zzyd() {
        return this.zzaLr;
    }

    public int zzye() {
        return this.zzaLs;
    }

    public String zzyf() {
        return this.zzaLu;
    }
}
