package com.google.android.gms.internal;

import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.auth.api.proxy.ProxyResponse;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
class zzle implements ProxyApi.ProxyResult {
    private Status zzUX;
    private ProxyResponse zzWK;

    public zzle(ProxyResponse proxyResponse) {
        this.zzWK = proxyResponse;
        this.zzUX = Status.zzagC;
    }

    public zzle(Status status) {
        this.zzUX = status;
    }

    @Override // com.google.android.gms.auth.api.proxy.ProxyApi.ProxyResult
    public ProxyResponse getResponse() {
        return this.zzWK;
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.zzUX;
    }
}
