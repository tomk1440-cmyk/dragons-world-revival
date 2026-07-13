package com.google.android.gms.internal;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public final class zzcc extends zzce.zza {
    private final com.google.android.gms.ads.internal.zzg zzxE;
    private final String zzxF;
    private final String zzxG;

    public zzcc(com.google.android.gms.ads.internal.zzg zzgVar, String str, String str2) {
        this.zzxE = zzgVar;
        this.zzxF = str;
        this.zzxG = str2;
    }

    @Override // com.google.android.gms.internal.zzce
    public String getContent() {
        return this.zzxG;
    }

    @Override // com.google.android.gms.internal.zzce
    public void recordClick() {
        this.zzxE.zzbd();
    }

    @Override // com.google.android.gms.internal.zzce
    public void recordImpression() {
        this.zzxE.zzbe();
    }

    @Override // com.google.android.gms.internal.zzce
    public void zzb(com.google.android.gms.dynamic.zzd zzdVar) {
        if (zzdVar == null) {
            return;
        }
        this.zzxE.zzc((View) com.google.android.gms.dynamic.zze.zzp(zzdVar));
    }

    @Override // com.google.android.gms.internal.zzce
    public String zzdF() {
        return this.zzxF;
    }
}
