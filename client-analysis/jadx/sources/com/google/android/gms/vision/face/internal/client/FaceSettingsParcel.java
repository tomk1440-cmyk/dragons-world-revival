package com.google.android.gms.vision.face.internal.client;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public class FaceSettingsParcel implements SafeParcelable {
    public static final zzb CREATOR = new zzb();
    public int mode;
    public final int versionCode;
    public int zzbnV;
    public int zzbnW;
    public boolean zzbnX;
    public boolean zzbnY;
    public float zzbnZ;

    public FaceSettingsParcel() {
        this.versionCode = 2;
    }

    public FaceSettingsParcel(int versionCode, int mode, int landmarkType, int classificationType, boolean prominentFaceOnly, boolean trackingEnabled, float proportionalMinFaceSize) {
        this.versionCode = versionCode;
        this.mode = mode;
        this.zzbnV = landmarkType;
        this.zzbnW = classificationType;
        this.zzbnX = prominentFaceOnly;
        this.zzbnY = trackingEnabled;
        this.zzbnZ = proportionalMinFaceSize;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        zzb.zza(this, parcel, flags);
    }
}
