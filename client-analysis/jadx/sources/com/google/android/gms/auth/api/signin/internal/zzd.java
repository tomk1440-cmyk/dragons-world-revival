package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class zzd extends com.google.android.gms.common.internal.zzj<zzh> {
    private final GoogleSignInOptions zzXx;

    public zzd(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, GoogleSignInOptions googleSignInOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 91, zzfVar, connectionCallbacks, onConnectionFailedListener);
        googleSignInOptions = googleSignInOptions == null ? new GoogleSignInOptions.Builder().build() : googleSignInOptions;
        if (!zzfVar.zzqt().isEmpty()) {
            GoogleSignInOptions.Builder builder = new GoogleSignInOptions.Builder(googleSignInOptions);
            Iterator<Scope> it = zzfVar.zzqt().iterator();
            while (it.hasNext()) {
                builder.requestScopes(it.next(), new Scope[0]);
            }
            googleSignInOptions = builder.build();
        }
        this.zzXx = googleSignInOptions;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzj
    /* JADX INFO: renamed from: zzaB, reason: merged with bridge method [inline-methods] */
    public zzh zzW(IBinder iBinder) {
        return zzh.zza.zzaD(iBinder);
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzgu() {
        return "com.google.android.gms.auth.api.signin.service.START";
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzgv() {
        return "com.google.android.gms.auth.api.signin.internal.ISignInService";
    }

    @Override // com.google.android.gms.common.internal.zzj, com.google.android.gms.common.api.Api.zzb
    public boolean zznb() {
        return true;
    }

    @Override // com.google.android.gms.common.internal.zzj, com.google.android.gms.common.api.Api.zzb
    public Intent zznc() {
        SignInConfiguration signInConfigurationZzmX = new com.google.android.gms.auth.api.signin.zzg.zza(getContext().getPackageName()).zzi(this.zzXx).zzmY().zzmX();
        Intent intent = new Intent("com.google.android.gms.auth.GOOGLE_SIGN_IN");
        intent.setClass(getContext(), SignInHubActivity.class);
        intent.putExtra("config", signInConfigurationZzmX);
        return intent;
    }

    public GoogleSignInOptions zznd() {
        return this.zzXx;
    }
}
