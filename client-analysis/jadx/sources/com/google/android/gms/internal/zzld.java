package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.auth.api.proxy.ProxyRequest;
import com.google.android.gms.auth.api.proxy.ProxyResponse;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;

/* JADX INFO: loaded from: classes.dex */
public class zzld implements ProxyApi {
    @Override // com.google.android.gms.auth.api.proxy.ProxyApi
    public PendingResult<ProxyApi.ProxyResult> performProxyRequest(GoogleApiClient client, final ProxyRequest request) {
        com.google.android.gms.common.internal.zzx.zzz(client);
        com.google.android.gms.common.internal.zzx.zzz(request);
        return client.zzb(new zzlc(client) { // from class: com.google.android.gms.internal.zzld.1
            @Override // com.google.android.gms.internal.zzlc
            protected void zza(Context context, zzlb zzlbVar) throws RemoteException {
                zzlbVar.zza(new zzky() { // from class: com.google.android.gms.internal.zzld.1.1
                    @Override // com.google.android.gms.internal.zzky, com.google.android.gms.internal.zzla
                    public void zza(ProxyResponse proxyResponse) {
                        zza(new zzle(proxyResponse));
                    }
                }, request);
            }
        });
    }
}
