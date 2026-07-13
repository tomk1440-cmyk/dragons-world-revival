package com.google.android.gms.ads.internal.client;

import com.google.android.gms.internal.zzhb;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public final class zzb extends zzp.zza {
    private final zza zztz;

    public zzb(zza zzaVar) {
        this.zztz = zzaVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzp
    public void onAdClicked() {
        this.zztz.onAdClicked();
    }
}
