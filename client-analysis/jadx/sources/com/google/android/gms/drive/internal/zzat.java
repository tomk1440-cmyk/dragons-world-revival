package com.google.android.gms.drive.internal;

import com.google.android.gms.internal.zzsm;
import com.google.android.gms.internal.zzsn;
import com.google.android.gms.internal.zzso;
import com.google.android.gms.internal.zzst;
import com.google.android.gms.internal.zzsu;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class zzat extends zzso<zzat> {
    public int versionCode;
    public long zzarW;
    public String zzarY;
    public long zzarZ;
    public int zzasa;

    public zzat() {
        zztl();
    }

    public static zzat zzm(byte[] bArr) throws zzst {
        return (zzat) zzsu.mergeFrom(new zzat(), bArr);
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof zzat)) {
            return false;
        }
        zzat zzatVar = (zzat) o;
        if (this.versionCode != zzatVar.versionCode) {
            return false;
        }
        if (this.zzarY == null) {
            if (zzatVar.zzarY != null) {
                return false;
            }
        } else if (!this.zzarY.equals(zzatVar.zzarY)) {
            return false;
        }
        if (this.zzarZ != zzatVar.zzarZ || this.zzarW != zzatVar.zzarW || this.zzasa != zzatVar.zzasa) {
            return false;
        }
        if (this.zzbuj == null || this.zzbuj.isEmpty()) {
            return zzatVar.zzbuj == null || zzatVar.zzbuj.isEmpty();
        }
        return this.zzbuj.equals(zzatVar.zzbuj);
    }

    public int hashCode() {
        int iHashCode = 0;
        int iHashCode2 = ((((((((this.zzarY == null ? 0 : this.zzarY.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + this.versionCode) * 31)) * 31) + ((int) (this.zzarZ ^ (this.zzarZ >>> 32)))) * 31) + ((int) (this.zzarW ^ (this.zzarW >>> 32)))) * 31) + this.zzasa) * 31;
        if (this.zzbuj != null && !this.zzbuj.isEmpty()) {
            iHashCode = this.zzbuj.hashCode();
        }
        return iHashCode2 + iHashCode;
    }

    @Override // com.google.android.gms.internal.zzso, com.google.android.gms.internal.zzsu
    public void writeTo(zzsn output) throws IOException {
        output.zzA(1, this.versionCode);
        output.zzn(2, this.zzarY);
        output.zzc(3, this.zzarZ);
        output.zzc(4, this.zzarW);
        if (this.zzasa != -1) {
            output.zzA(5, this.zzasa);
        }
        super.writeTo(output);
    }

    @Override // com.google.android.gms.internal.zzsu
    /* JADX INFO: renamed from: zzm, reason: merged with bridge method [inline-methods] */
    public zzat mergeFrom(zzsm zzsmVar) throws IOException {
        while (true) {
            int iZzIX = zzsmVar.zzIX();
            switch (iZzIX) {
                case 0:
                    break;
                case 8:
                    this.versionCode = zzsmVar.zzJb();
                    break;
                case 18:
                    this.zzarY = zzsmVar.readString();
                    break;
                case 24:
                    this.zzarZ = zzsmVar.zzJe();
                    break;
                case 32:
                    this.zzarW = zzsmVar.zzJe();
                    break;
                case 40:
                    this.zzasa = zzsmVar.zzJb();
                    break;
                default:
                    if (!zza(zzsmVar, iZzIX)) {
                    }
                    break;
            }
        }
        return this;
    }

    public zzat zztl() {
        this.versionCode = 1;
        this.zzarY = "";
        this.zzarZ = -1L;
        this.zzarW = -1L;
        this.zzasa = -1;
        this.zzbuj = null;
        this.zzbuu = -1;
        return this;
    }

    @Override // com.google.android.gms.internal.zzso, com.google.android.gms.internal.zzsu
    protected int zzz() {
        int iZzz = super.zzz() + zzsn.zzC(1, this.versionCode) + zzsn.zzo(2, this.zzarY) + zzsn.zze(3, this.zzarZ) + zzsn.zze(4, this.zzarW);
        return this.zzasa != -1 ? iZzz + zzsn.zzC(5, this.zzasa) : iZzz;
    }
}
