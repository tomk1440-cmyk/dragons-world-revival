package com.google.android.gms.drive.events.internal;

import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.zzj;

/* JADX INFO: loaded from: classes.dex */
public class zzb implements zzj {
    private final int zzBc;
    private final DriveId zzaoz;
    private final int zzapT;

    public zzb(TransferProgressData transferProgressData) {
        this.zzaoz = transferProgressData.getDriveId();
        this.zzapT = transferProgressData.zztb();
        this.zzBc = transferProgressData.getStatus();
    }

    public boolean equals(Object o) {
        if (o == null || o.getClass() != getClass()) {
            return false;
        }
        if (o == this) {
            return true;
        }
        zzb zzbVar = (zzb) o;
        return zzw.equal(this.zzaoz, zzbVar.zzaoz) && this.zzapT == zzbVar.zzapT && this.zzBc == zzbVar.zzBc;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzaoz, Integer.valueOf(this.zzapT), Integer.valueOf(this.zzBc));
    }

    public String toString() {
        return String.format("FileTransferState[TransferType: %d, DriveId: %s, status: %d]", Integer.valueOf(this.zzapT), this.zzaoz, Integer.valueOf(this.zzBc));
    }
}
