package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

/* JADX INFO: loaded from: classes.dex */
public class GetPermissionsRequest implements SafeParcelable {
    public static final Parcelable.Creator<GetPermissionsRequest> CREATOR = new zzak();
    final int mVersionCode;
    final DriveId zzaoz;

    GetPermissionsRequest(int versionCode, DriveId driveId) {
        this.mVersionCode = versionCode;
        this.zzaoz = driveId;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzak.zza(this, dest, flags);
    }
}
