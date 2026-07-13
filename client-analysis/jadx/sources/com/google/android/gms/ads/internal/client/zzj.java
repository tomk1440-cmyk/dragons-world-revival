package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.internal.zzhb;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public final class zzj extends zzw.zza {
    private final AppEventListener zzun;

    public zzj(AppEventListener appEventListener) {
        this.zzun = appEventListener;
    }

    @Override // com.google.android.gms.ads.internal.client.zzw
    public void onAppEvent(String name, String info) {
        this.zzun.onAppEvent(name, info);
    }
}
