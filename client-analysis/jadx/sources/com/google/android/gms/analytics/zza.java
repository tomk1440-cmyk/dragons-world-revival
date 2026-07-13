package com.google.android.gms.analytics;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzke;
import com.google.android.gms.measurement.zzf;
import com.google.android.gms.measurement.zzi;
import java.util.ListIterator;

/* JADX INFO: loaded from: classes.dex */
public class zza extends zzf<zza> {
    private final com.google.android.gms.analytics.internal.zzf zzOK;
    private boolean zzOL;

    public zza(com.google.android.gms.analytics.internal.zzf zzfVar) {
        super(zzfVar.zzjo(), zzfVar.zzjl());
        this.zzOK = zzfVar;
    }

    public void enableAdvertisingIdCollection(boolean enable) {
        this.zzOL = enable;
    }

    @Override // com.google.android.gms.measurement.zzf
    protected void zza(com.google.android.gms.measurement.zzc zzcVar) {
        zzke zzkeVar = (zzke) zzcVar.zzf(zzke.class);
        if (TextUtils.isEmpty(zzkeVar.getClientId())) {
            zzkeVar.setClientId(this.zzOK.zzjC().zzkk());
        }
        if (this.zzOL && TextUtils.isEmpty(zzkeVar.zziT())) {
            com.google.android.gms.analytics.internal.zza zzaVarZzjB = this.zzOK.zzjB();
            zzkeVar.zzaY(zzaVarZzjB.zziY());
            zzkeVar.zzH(zzaVarZzjB.zziU());
        }
    }

    public void zzaS(String str) {
        zzx.zzcM(str);
        zzaT(str);
        zzAG().add(new zzb(this.zzOK, str));
    }

    public void zzaT(String str) {
        Uri uriZzaU = zzb.zzaU(str);
        ListIterator<zzi> listIterator = zzAG().listIterator();
        while (listIterator.hasNext()) {
            if (uriZzaU.equals(listIterator.next().zziA())) {
                listIterator.remove();
            }
        }
    }

    com.google.android.gms.analytics.internal.zzf zzix() {
        return this.zzOK;
    }

    @Override // com.google.android.gms.measurement.zzf
    public com.google.android.gms.measurement.zzc zziy() {
        com.google.android.gms.measurement.zzc zzcVarZzAu = zzAF().zzAu();
        zzcVarZzAu.zzb(this.zzOK.zzjt().zzjS());
        zzcVarZzAu.zzb(this.zzOK.zzju().zzkZ());
        zzd(zzcVarZzAu);
        return zzcVarZzAu;
    }
}
