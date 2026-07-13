package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.ChangesAvailableOptions;
import com.google.android.gms.drive.events.TransferProgressOptions;
import com.google.android.gms.drive.events.TransferStateOptions;

/* JADX INFO: loaded from: classes.dex */
public class AddEventListenerRequest implements SafeParcelable {
    public static final Parcelable.Creator<AddEventListenerRequest> CREATOR = new zza();
    final int mVersionCode;
    final int zzanf;
    final DriveId zzaoz;
    final TransferStateOptions zzapY;
    final TransferProgressOptions zzapZ;
    final ChangesAvailableOptions zzapy;

    public AddEventListenerRequest(int eventType, DriveId id) {
        this(1, (DriveId) com.google.android.gms.common.internal.zzx.zzz(id), eventType, null, null, null);
    }

    AddEventListenerRequest(int versionCode, DriveId driveId, int eventType, ChangesAvailableOptions changesAvailableOptions, TransferStateOptions transferStateOptions, TransferProgressOptions transferProgressOptions) {
        this.mVersionCode = versionCode;
        this.zzaoz = driveId;
        this.zzanf = eventType;
        this.zzapy = changesAvailableOptions;
        this.zzapY = transferStateOptions;
        this.zzapZ = transferProgressOptions;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public DriveId getDriveId() {
        return this.zzaoz;
    }

    public int getEventType() {
        return this.zzanf;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zza.zza(this, dest, flags);
    }
}
