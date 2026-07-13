package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.Permission;

/* JADX INFO: loaded from: classes.dex */
public class AddPermissionRequest implements SafeParcelable {
    public static final Parcelable.Creator<AddPermissionRequest> CREATOR = new zzb();
    final int mVersionCode;
    final String zzaoV;
    final DriveId zzaoz;
    final Permission zzaqa;
    final boolean zzaqb;
    final String zzaqc;
    final boolean zzaqd;

    AddPermissionRequest(int versionCode, DriveId driveId, Permission permission, boolean sendNotificationEmail, String emailMessage, boolean sendEventOnCompletion, String trackingTag) {
        this.mVersionCode = versionCode;
        this.zzaoz = driveId;
        this.zzaqa = permission;
        this.zzaqb = sendNotificationEmail;
        this.zzaqc = emailMessage;
        this.zzaqd = sendEventOnCompletion;
        this.zzaoV = trackingTag;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzb.zza(this, dest, flags);
    }
}
