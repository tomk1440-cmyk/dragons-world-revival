package com.google.android.gms.internal;

import com.google.android.gms.ads.formats.NativeCustomTemplateAd;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzcy extends zzct.zza {
    private final NativeCustomTemplateAd.OnCustomClickListener zzyU;

    public zzcy(NativeCustomTemplateAd.OnCustomClickListener onCustomClickListener) {
        this.zzyU = onCustomClickListener;
    }

    @Override // com.google.android.gms.internal.zzct
    public void zza(zzcp zzcpVar, String str) {
        this.zzyU.onCustomClick(new zzcq(zzcpVar), str);
    }
}
