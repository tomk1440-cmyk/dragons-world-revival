package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

/* JADX INFO: loaded from: classes.dex */
public class UpdatePermissionRequest implements SafeParcelable {
    public static final Parcelable.Creator<UpdatePermissionRequest> CREATOR = new zzcb();
    final int mVersionCode;
    final String zzaoV;
    final DriveId zzaoz;
    final String zzapk;
    final boolean zzaqd;
    final int zzasE;

    UpdatePermissionRequest(int versionCode, DriveId driveId, String accountIdentifier, int newRole, boolean sendEventOnCompletion, String trackingTag) {
        this.mVersionCode = versionCode;
        this.zzaoz = driveId;
        this.zzapk = accountIdentifier;
        this.zzasE = newRole;
        this.zzaqd = sendEventOnCompletion;
        this.zzaoV = trackingTag;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzcb.zza(this, dest, flags);
    }
}
