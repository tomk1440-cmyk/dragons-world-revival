package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

/* JADX INFO: loaded from: classes.dex */
public class PartialDriveId implements SafeParcelable {
    public static final Parcelable.Creator<PartialDriveId> CREATOR = new zzn();
    final int mVersionCode;
    final String zzaoL;
    final long zzaoM;
    final int zzaoN;

    PartialDriveId(int versionCode, String resourceId, long sqlId, int resourceType) {
        this.mVersionCode = versionCode;
        this.zzaoL = resourceId;
        this.zzaoM = sqlId;
        this.zzaoN = resourceType;
    }

    public PartialDriveId(String resourceId, long sqlId, int resourceType) {
        this(1, resourceId, sqlId, resourceType);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        zzn.zza(this, out, flags);
    }

    public DriveId zzE(long j) {
        return new DriveId(this.zzaoL, this.zzaoM, j, this.zzaoN);
    }
}
