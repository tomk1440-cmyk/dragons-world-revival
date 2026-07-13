package com.google.android.gms.internal;

import com.google.android.gms.internal.zzso;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzso<M extends zzso<M>> extends zzsu {
    protected zzsq zzbuj;

    @Override // com.google.android.gms.internal.zzsu
    public void writeTo(zzsn output) throws IOException {
        if (this.zzbuj == null) {
            return;
        }
        for (int i = 0; i < this.zzbuj.size(); i++) {
            this.zzbuj.zzmG(i).writeTo(output);
        }
    }

    @Override // com.google.android.gms.internal.zzsu
    /* JADX INFO: renamed from: zzJp, reason: merged with bridge method [inline-methods] */
    public M mo4clone() throws CloneNotSupportedException {
        M m = (M) super.mo4clone();
        zzss.zza(this, m);
        return m;
    }

    public final <T> T zza(zzsp<M, T> zzspVar) {
        zzsr zzsrVarZzmF;
        if (this.zzbuj == null || (zzsrVarZzmF = this.zzbuj.zzmF(zzsx.zzmJ(zzspVar.tag))) == null) {
            return null;
        }
        return (T) zzsrVarZzmF.zzb(zzspVar);
    }

    protected final boolean zza(zzsm zzsmVar, int i) throws IOException {
        int position = zzsmVar.getPosition();
        if (!zzsmVar.zzmo(i)) {
            return false;
        }
        int iZzmJ = zzsx.zzmJ(i);
        zzsw zzswVar = new zzsw(i, zzsmVar.zzz(position, zzsmVar.getPosition() - position));
        zzsr zzsrVarZzmF = null;
        if (this.zzbuj == null) {
            this.zzbuj = new zzsq();
        } else {
            zzsrVarZzmF = this.zzbuj.zzmF(iZzmJ);
        }
        if (zzsrVarZzmF == null) {
            zzsrVarZzmF = new zzsr();
            this.zzbuj.zza(iZzmJ, zzsrVarZzmF);
        }
        zzsrVarZzmF.zza(zzswVar);
        return true;
    }

    @Override // com.google.android.gms.internal.zzsu
    protected int zzz() {
        if (this.zzbuj == null) {
            return 0;
        }
        int iZzz = 0;
        for (int i = 0; i < this.zzbuj.size(); i++) {
            iZzz += this.zzbuj.zzmG(i).zzz();
        }
        return iZzz;
    }
}
