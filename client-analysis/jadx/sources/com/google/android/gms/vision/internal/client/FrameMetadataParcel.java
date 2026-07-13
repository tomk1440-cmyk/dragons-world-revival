package com.google.android.gms.vision.internal.client;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.vision.Frame;

/* JADX INFO: loaded from: classes.dex */
public class FrameMetadataParcel implements SafeParcelable {
    public static final zza CREATOR = new zza();
    public int height;
    public int id;
    public int rotation;
    final int versionCode;
    public int width;
    public long zzboe;

    public FrameMetadataParcel() {
        this.versionCode = 1;
    }

    public FrameMetadataParcel(int versionCode, int width, int height, int id, long timestampMillis, int rotation) {
        this.versionCode = versionCode;
        this.width = width;
        this.height = height;
        this.id = id;
        this.zzboe = timestampMillis;
        this.rotation = rotation;
    }

    public static FrameMetadataParcel zzc(Frame frame) {
        FrameMetadataParcel frameMetadataParcel = new FrameMetadataParcel();
        frameMetadataParcel.width = frame.getMetadata().getWidth();
        frameMetadataParcel.height = frame.getMetadata().getHeight();
        frameMetadataParcel.rotation = frame.getMetadata().getRotation();
        frameMetadataParcel.id = frame.getMetadata().getId();
        frameMetadataParcel.zzboe = frame.getMetadata().getTimestampMillis();
        return frameMetadataParcel;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        zza zzaVar = CREATOR;
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        zza zzaVar = CREATOR;
        zza.zza(this, parcel, flags);
    }
}
