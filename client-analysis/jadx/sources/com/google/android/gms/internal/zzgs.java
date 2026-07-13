package com.google.android.gms.internal;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzgs extends zzgn implements zzjq.zza {
    zzgs(Context context, zzif.zza zzaVar, zzjp zzjpVar, zzgr.zza zzaVar2) {
        super(context, zzaVar, zzjpVar, zzaVar2);
    }

    @Override // com.google.android.gms.internal.zzgn
    protected void zzgb() {
        if (this.zzGe.errorCode != -2) {
            return;
        }
        this.zzpD.zzhU().zza(this);
        zzgi();
        zzin.zzaI("Loading HTML in WebView.");
        this.zzpD.loadDataWithBaseURL(com.google.android.gms.ads.internal.zzr.zzbC().zzaC(this.zzGe.zzEF), this.zzGe.body, "text/html", "UTF-8", null);
    }

    protected void zzgi() {
    }
}
