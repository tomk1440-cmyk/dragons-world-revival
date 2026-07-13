package com.google.android.gms.drive.internal;

import com.google.android.gms.internal.zzsm;
import com.google.android.gms.internal.zzsn;
import com.google.android.gms.internal.zzso;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class zzas extends zzso<zzas> {
    public int versionCode;
    public long zzarV;
    public long zzarW;
    public long zzarX;

    public zzas() {
        zztk();
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof zzas)) {
            return false;
        }
        zzas zzasVar = (zzas) o;
        if (this.versionCode != zzasVar.versionCode || this.zzarV != zzasVar.zzarV || this.zzarW != zzasVar.zzarW || this.zzarX != zzasVar.zzarX) {
            return false;
        }
        if (this.zzbuj == null || this.zzbuj.isEmpty()) {
            return zzasVar.zzbuj == null || zzasVar.zzbuj.isEmpty();
        }
        return this.zzbuj.equals(zzasVar.zzbuj);
    }

    public int hashCode() {
        return ((this.zzbuj == null || this.zzbuj.isEmpty()) ? 0 : this.zzbuj.hashCode()) + ((((((((((getClass().getName().hashCode() + 527) * 31) + this.versionCode) * 31) + ((int) (this.zzarV ^ (this.zzarV >>> 32)))) * 31) + ((int) (this.zzarW ^ (this.zzarW >>> 32)))) * 31) + ((int) (this.zzarX ^ (this.zzarX >>> 32)))) * 31);
    }

    @Override // com.google.android.gms.internal.zzso, com.google.android.gms.internal.zzsu
    public void writeTo(zzsn output) throws IOException {
        output.zzA(1, this.versionCode);
        output.zzc(2, this.zzarV);
        output.zzc(3, this.zzarW);
        output.zzc(4, this.zzarX);
        super.writeTo(output);
    }

    @Override // com.google.android.gms.internal.zzsu
    /* JADX INFO: renamed from: zzl, reason: merged with bridge method [inline-methods] */
    public zzas mergeFrom(zzsm zzsmVar) throws IOException {
        while (true) {
            int iZzIX = zzsmVar.zzIX();
            switch (iZzIX) {
                case 0:
                    break;
                case 8:
                    this.versionCode = zzsmVar.zzJb();
                    break;
                case 16:
                    this.zzarV = zzsmVar.zzJe();
                    break;
                case 24:
                    this.zzarW = zzsmVar.zzJe();
                    break;
                case 32:
                    this.zzarX = zzsmVar.zzJe();
                    break;
                default:
                    if (!zza(zzsmVar, iZzIX)) {
                    }
                    break;
            }
        }
        return this;
    }

    public zzas zztk() {
        this.versionCode = 1;
        this.zzarV = -1L;
        this.zzarW = -1L;
        this.zzarX = -1L;
        this.zzbuj = null;
        this.zzbuu = -1;
        return this;
    }

    @Override // com.google.android.gms.internal.zzso, com.google.android.gms.internal.zzsu
    protected int zzz() {
        return super.zzz() + zzsn.zzC(1, this.versionCode) + zzsn.zze(2, this.zzarV) + zzsn.zze(3, this.zzarW) + zzsn.zze(4, this.zzarX);
    }
}
