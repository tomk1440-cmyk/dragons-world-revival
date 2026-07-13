package com.google.android.gms.internal;

import android.content.Intent;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.panorama.PanoramaApi;

/* JADX INFO: loaded from: classes.dex */
class zzqs implements PanoramaApi.PanoramaResult {
    private final Status zzUX;
    private final Intent zzbdv;

    public zzqs(Status status, Intent intent) {
        this.zzUX = (Status) com.google.android.gms.common.internal.zzx.zzz(status);
        this.zzbdv = intent;
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.zzUX;
    }

    @Override // com.google.android.gms.panorama.PanoramaApi.PanoramaResult
    public Intent getViewerIntent() {
        return this.zzbdv;
    }
}
