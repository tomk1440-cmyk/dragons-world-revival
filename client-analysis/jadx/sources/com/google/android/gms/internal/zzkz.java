package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.api.GoogleApiClient;

/* JADX INFO: loaded from: classes.dex */
public final class zzkz extends com.google.android.gms.common.internal.zzj<zzlb> {
    private final Bundle zzVN;

    public zzkz(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, Auth.zza zzaVar, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 16, zzfVar, connectionCallbacks, onConnectionFailedListener);
        this.zzVN = zzaVar == null ? new Bundle() : zzaVar.zzms();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzj
    /* JADX INFO: renamed from: zzay, reason: merged with bridge method [inline-methods] */
    public zzlb zzW(IBinder iBinder) {
        return zzlb.zza.zzaA(iBinder);
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzgu() {
        return "com.google.android.gms.auth.service.START";
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzgv() {
        return "com.google.android.gms.auth.api.internal.IAuthService";
    }

    @Override // com.google.android.gms.common.internal.zzj, com.google.android.gms.common.api.Api.zzb
    public boolean zzmE() {
        com.google.android.gms.common.internal.zzf zzfVarZzqH = zzqH();
        return (TextUtils.isEmpty(zzfVarZzqH.getAccountName()) || zzfVarZzqH.zzb(Auth.PROXY_API).isEmpty()) ? false : true;
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected Bundle zzml() {
        return this.zzVN;
    }
}
