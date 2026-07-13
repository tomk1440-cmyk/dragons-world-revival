package com.google.android.gms.nearby.messages.devices;

import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class zzd {
    private final zze zzbca;

    public zzd(byte[] bArr) {
        this.zzbca = new zze(zzu(bArr));
    }

    private static byte[] zzu(byte[] bArr) {
        zzx.zzb(bArr.length == 20, "iBeacon ID must be a UUID, a major, and a minor (20 total bytes).");
        return bArr;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof zzd) {
            return zzw.equal(this.zzbca, ((zzd) o).zzbca);
        }
        return false;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzbca);
    }

    public String toString() {
        return "IBeaconId{proximityUuid=" + zzEu() + ", major=" + ((int) zzEv()) + ", minor=" + ((int) zzEw()) + '}';
    }

    public UUID zzEu() {
        return this.zzbca.zzEu();
    }

    public short zzEv() {
        return this.zzbca.zzEx().shortValue();
    }

    public short zzEw() {
        return this.zzbca.zzEy().shortValue();
    }
}
