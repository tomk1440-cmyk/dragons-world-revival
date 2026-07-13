package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.TransferProgressOptions;

/* JADX INFO: loaded from: classes.dex */
public class RemoveEventListenerRequest implements SafeParcelable {
    public static final Parcelable.Creator<RemoveEventListenerRequest> CREATOR = new zzbp();
    final int mVersionCode;
    final int zzanf;
    final DriveId zzaoz;
    final TransferProgressOptions zzapZ;

    RemoveEventListenerRequest(int versionCode, DriveId driveId, int eventType, TransferProgressOptions transferProgressOptions) {
        this.mVersionCode = versionCode;
        this.zzaoz = driveId;
        this.zzanf = eventType;
        this.zzapZ = transferProgressOptions;
    }

    public RemoveEventListenerRequest(DriveId id, int eventType) {
        this(id, eventType, null);
    }

    RemoveEventListenerRequest(DriveId id, int eventType, TransferProgressOptions transferProgressOptions) {
        this(1, id, eventType, transferProgressOptions);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzbp.zza(this, dest, flags);
    }
}
