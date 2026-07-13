package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

/* JADX INFO: loaded from: classes.dex */
public class OnDriveIdResponse implements SafeParcelable {
    public static final Parcelable.Creator<OnDriveIdResponse> CREATOR = new zzaz();
    final int mVersionCode;
    DriveId zzaqj;

    OnDriveIdResponse(int versionCode, DriveId driveId) {
        this.mVersionCode = versionCode;
        this.zzaqj = driveId;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public DriveId getDriveId() {
        return this.zzaqj;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzaz.zza(this, dest, flags);
    }
}
