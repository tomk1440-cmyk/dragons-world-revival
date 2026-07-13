package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.view.View;
import android.webkit.WebChromeClient;

/* JADX INFO: loaded from: classes.dex */
@zzhb
@TargetApi(14)
public final class zzjx extends zzjv {
    public zzjx(zzjp zzjpVar) {
        super(zzjpVar);
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View view, int requestedOrientation, WebChromeClient.CustomViewCallback customViewCallback) {
        zza(view, requestedOrientation, customViewCallback);
    }
}
