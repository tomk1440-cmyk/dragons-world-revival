package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class ChangeEvent implements SafeParcelable, ResourceEvent {
    public static final Parcelable.Creator<ChangeEvent> CREATOR = new zza();
    final int mVersionCode;
    final DriveId zzaoz;
    final int zzapx;

    ChangeEvent(int versionCode, DriveId driveId, int changeFlags) {
        this.mVersionCode = versionCode;
        this.zzaoz = driveId;
        this.zzapx = changeFlags;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.drive.events.ResourceEvent
    public DriveId getDriveId() {
        return this.zzaoz;
    }

    @Override // com.google.android.gms.drive.events.DriveEvent
    public int getType() {
        return 1;
    }

    public boolean hasBeenDeleted() {
        return (this.zzapx & 4) != 0;
    }

    public boolean hasContentChanged() {
        return (this.zzapx & 2) != 0;
    }

    public boolean hasMetadataChanged() {
        return (this.zzapx & 1) != 0;
    }

    public String toString() {
        return String.format(Locale.US, "ChangeEvent [id=%s,changeFlags=%x]", this.zzaoz, Integer.valueOf(this.zzapx));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zza.zza(this, dest, flags);
    }
}
