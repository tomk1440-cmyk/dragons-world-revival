package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzc {
    protected final DataHolder zzahi;
    protected int zzaje;
    private int zzajf;

    public zzc(DataHolder dataHolder, int i) {
        this.zzahi = (DataHolder) zzx.zzz(dataHolder);
        zzbF(i);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof zzc)) {
            return false;
        }
        zzc zzcVar = (zzc) obj;
        return zzw.equal(Integer.valueOf(zzcVar.zzaje), Integer.valueOf(this.zzaje)) && zzw.equal(Integer.valueOf(zzcVar.zzajf), Integer.valueOf(this.zzajf)) && zzcVar.zzahi == this.zzahi;
    }

    protected boolean getBoolean(String column) {
        return this.zzahi.zze(column, this.zzaje, this.zzajf);
    }

    protected byte[] getByteArray(String column) {
        return this.zzahi.zzg(column, this.zzaje, this.zzajf);
    }

    protected float getFloat(String column) {
        return this.zzahi.zzf(column, this.zzaje, this.zzajf);
    }

    protected int getInteger(String column) {
        return this.zzahi.zzc(column, this.zzaje, this.zzajf);
    }

    protected long getLong(String column) {
        return this.zzahi.zzb(column, this.zzaje, this.zzajf);
    }

    protected String getString(String column) {
        return this.zzahi.zzd(column, this.zzaje, this.zzajf);
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.zzaje), Integer.valueOf(this.zzajf), this.zzahi);
    }

    public boolean isDataValid() {
        return !this.zzahi.isClosed();
    }

    protected void zza(String str, CharArrayBuffer charArrayBuffer) {
        this.zzahi.zza(str, this.zzaje, this.zzajf, charArrayBuffer);
    }

    protected void zzbF(int i) {
        zzx.zzab(i >= 0 && i < this.zzahi.getCount());
        this.zzaje = i;
        this.zzajf = this.zzahi.zzbH(this.zzaje);
    }

    protected Uri zzcA(String str) {
        return this.zzahi.zzh(str, this.zzaje, this.zzajf);
    }

    protected boolean zzcB(String str) {
        return this.zzahi.zzi(str, this.zzaje, this.zzajf);
    }

    public boolean zzcz(String str) {
        return this.zzahi.zzcz(str);
    }

    protected int zzqc() {
        return this.zzaje;
    }
}
