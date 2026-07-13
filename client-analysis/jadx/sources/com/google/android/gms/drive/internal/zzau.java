package com.google.android.gms.drive.internal;

import com.google.android.gms.internal.zzsm;
import com.google.android.gms.internal.zzsn;
import com.google.android.gms.internal.zzso;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class zzau extends zzso<zzau> {
    public long zzarW;
    public long zzarZ;

    public zzau() {
        zztm();
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof zzau)) {
            return false;
        }
        zzau zzauVar = (zzau) o;
        if (this.zzarZ != zzauVar.zzarZ || this.zzarW != zzauVar.zzarW) {
            return false;
        }
        if (this.zzbuj == null || this.zzbuj.isEmpty()) {
            return zzauVar.zzbuj == null || zzauVar.zzbuj.isEmpty();
        }
        return this.zzbuj.equals(zzauVar.zzbuj);
    }

    public int hashCode() {
        return ((this.zzbuj == null || this.zzbuj.isEmpty()) ? 0 : this.zzbuj.hashCode()) + ((((((getClass().getName().hashCode() + 527) * 31) + ((int) (this.zzarZ ^ (this.zzarZ >>> 32)))) * 31) + ((int) (this.zzarW ^ (this.zzarW >>> 32)))) * 31);
    }

    @Override // com.google.android.gms.internal.zzso, com.google.android.gms.internal.zzsu
    public void writeTo(zzsn output) throws IOException {
        output.zzc(1, this.zzarZ);
        output.zzc(2, this.zzarW);
        super.writeTo(output);
    }

    @Override // com.google.android.gms.internal.zzsu
    /* JADX INFO: renamed from: zzn, reason: merged with bridge method [inline-methods] */
    public zzau mergeFrom(zzsm zzsmVar) throws IOException {
        while (true) {
            int iZzIX = zzsmVar.zzIX();
            switch (iZzIX) {
                case 0:
                    break;
                case 8:
                    this.zzarZ = zzsmVar.zzJe();
                    break;
                case 16:
                    this.zzarW = zzsmVar.zzJe();
                    break;
                default:
                    if (!zza(zzsmVar, iZzIX)) {
                    }
                    break;
            }
        }
        return this;
    }

    public zzau zztm() {
        this.zzarZ = -1L;
        this.zzarW = -1L;
        this.zzbuj = null;
        this.zzbuu = -1;
        return this;
    }

    @Override // com.google.android.gms.internal.zzso, com.google.android.gms.internal.zzsu
    protected int zzz() {
        return super.zzz() + zzsn.zze(1, this.zzarZ) + zzsn.zze(2, this.zzarW);
    }
}
