package com.google.android.gms.drive.events.internal;

import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.drive.events.zzh;
import com.google.android.gms.drive.events.zzj;

/* JADX INFO: loaded from: classes.dex */
public class zza implements zzh {
    private final zzj zzapV;
    private final long zzapW;
    private final long zzapX;

    public zza(TransferProgressData transferProgressData) {
        this.zzapV = new zzb(transferProgressData);
        this.zzapW = transferProgressData.getBytesTransferred();
        this.zzapX = transferProgressData.getTotalBytes();
    }

    public boolean equals(Object o) {
        if (o == null || o.getClass() != getClass()) {
            return false;
        }
        if (o == this) {
            return true;
        }
        zza zzaVar = (zza) o;
        return zzw.equal(this.zzapV, zzaVar.zzapV) && this.zzapW == zzaVar.zzapW && this.zzapX == zzaVar.zzapX;
    }

    public int hashCode() {
        return zzw.hashCode(Long.valueOf(this.zzapX), Long.valueOf(this.zzapW), Long.valueOf(this.zzapX));
    }

    public String toString() {
        return String.format("FileTransferProgress[FileTransferState: %s, BytesTransferred: %d, TotalBytes: %d]", this.zzapV.toString(), Long.valueOf(this.zzapW), Long.valueOf(this.zzapX));
    }
}
