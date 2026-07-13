package com.google.android.gms.analytics.internal;

import com.google.android.gms.internal.zzpq;

/* JADX INFO: loaded from: classes.dex */
public class zzk extends zzd {
    private final zzpq zzQX;

    zzk(zzf zzfVar) {
        super(zzfVar);
        this.zzQX = new zzpq();
    }

    public void zziE() {
        zzan zzanVarZziI = zziI();
        String strZzlg = zzanVarZziI.zzlg();
        if (strZzlg != null) {
            this.zzQX.setAppName(strZzlg);
        }
        String strZzli = zzanVarZziI.zzli();
        if (strZzli != null) {
            this.zzQX.setAppVersion(strZzli);
        }
    }

    @Override // com.google.android.gms.analytics.internal.zzd
    protected void zziJ() {
        zzjo().zzAH().zza(this.zzQX);
        zziE();
    }

    public zzpq zzjS() {
        zzjv();
        return this.zzQX;
    }
}
