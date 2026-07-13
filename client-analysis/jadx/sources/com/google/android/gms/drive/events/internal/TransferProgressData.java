package com.google.android.gms.drive.events.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.drive.DriveId;

/* JADX INFO: loaded from: classes.dex */
public class TransferProgressData implements SafeParcelable {
    public static final Parcelable.Creator<TransferProgressData> CREATOR = new zzc();
    final int mVersionCode;
    final int zzBc;
    final DriveId zzaoz;
    final int zzapT;
    final long zzapW;
    final long zzapX;

    TransferProgressData(int versionCode, int transferType, DriveId driveId, int status, long bytesTransferred, long totalBytes) {
        this.mVersionCode = versionCode;
        this.zzapT = transferType;
        this.zzaoz = driveId;
        this.zzBc = status;
        this.zzapW = bytesTransferred;
        this.zzapX = totalBytes;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (o == null || o.getClass() != getClass()) {
            return false;
        }
        if (o == this) {
            return true;
        }
        TransferProgressData transferProgressData = (TransferProgressData) o;
        return this.zzapT == transferProgressData.zzapT && zzw.equal(this.zzaoz, transferProgressData.zzaoz) && this.zzBc == transferProgressData.zzBc && this.zzapW == transferProgressData.zzapW && this.zzapX == transferProgressData.zzapX;
    }

    public long getBytesTransferred() {
        return this.zzapW;
    }

    public DriveId getDriveId() {
        return this.zzaoz;
    }

    public int getStatus() {
        return this.zzBc;
    }

    public long getTotalBytes() {
        return this.zzapX;
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.zzapT), this.zzaoz, Integer.valueOf(this.zzBc), Long.valueOf(this.zzapW), Long.valueOf(this.zzapX));
    }

    public String toString() {
        return String.format("TransferProgressData[TransferType: %d, DriveId: %s, status: %d, bytes transferred: %d, total bytes: %d]", Integer.valueOf(this.zzapT), this.zzaoz, Integer.valueOf(this.zzBc), Long.valueOf(this.zzapW), Long.valueOf(this.zzapX));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzc.zza(this, dest, flags);
    }

    public int zztb() {
        return this.zzapT;
    }
}
