package com.google.android.gms.internal;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzdp extends zzim {
    final zzjp zzpD;
    final zzdr zzzJ;
    private final String zzzK;

    zzdp(zzjp zzjpVar, zzdr zzdrVar, String str) {
        this.zzpD = zzjpVar;
        this.zzzJ = zzdrVar;
        this.zzzK = str;
        com.google.android.gms.ads.internal.zzr.zzbR().zza(this);
    }

    @Override // com.google.android.gms.internal.zzim
    public void onStop() {
        this.zzzJ.abort();
    }

    @Override // com.google.android.gms.internal.zzim
    public void zzbr() {
        try {
            this.zzzJ.zzU(this.zzzK);
        } finally {
            zzir.zzMc.post(new Runnable() { // from class: com.google.android.gms.internal.zzdp.1
                @Override // java.lang.Runnable
                public void run() {
                    com.google.android.gms.ads.internal.zzr.zzbR().zzb(zzdp.this);
                }
            });
        }
    }
}
