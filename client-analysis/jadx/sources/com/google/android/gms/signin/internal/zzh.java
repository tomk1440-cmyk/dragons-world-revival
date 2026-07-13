package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.auth.api.signin.internal.zzq;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.zzp;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzrn;
import com.google.android.gms.internal.zzro;

/* JADX INFO: loaded from: classes.dex */
public class zzh extends com.google.android.gms.common.internal.zzj<zze> implements zzrn {
    private final com.google.android.gms.common.internal.zzf zzahz;
    private Integer zzale;
    private final Bundle zzbgU;
    private final boolean zzbhi;

    public zzh(Context context, Looper looper, boolean z, com.google.android.gms.common.internal.zzf zzfVar, Bundle bundle, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 44, zzfVar, connectionCallbacks, onConnectionFailedListener);
        this.zzbhi = z;
        this.zzahz = zzfVar;
        this.zzbgU = bundle;
        this.zzale = zzfVar.zzqz();
    }

    public zzh(Context context, Looper looper, boolean z, com.google.android.gms.common.internal.zzf zzfVar, zzro zzroVar, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this(context, looper, z, zzfVar, zza(zzfVar), connectionCallbacks, onConnectionFailedListener);
    }

    private ResolveAccountRequest zzFN() {
        Account accountZzqq = this.zzahz.zzqq();
        return new ResolveAccountRequest(accountZzqq, this.zzale.intValue(), "<<default account>>".equals(accountZzqq.name) ? zzq.zzaf(getContext()).zzno() : null);
    }

    public static Bundle zza(com.google.android.gms.common.internal.zzf zzfVar) {
        zzro zzroVarZzqy = zzfVar.zzqy();
        Integer numZzqz = zzfVar.zzqz();
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", zzfVar.getAccount());
        if (numZzqz != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", numZzqz.intValue());
        }
        if (zzroVarZzqy != null) {
            bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", zzroVarZzqy.zzFH());
            bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", zzroVarZzqy.zzmO());
            bundle.putString("com.google.android.gms.signin.internal.serverClientId", zzroVarZzqy.zzmR());
            bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
            bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", zzroVarZzqy.zzmQ());
            bundle.putString("com.google.android.gms.signin.internal.hostedDomain", zzroVarZzqy.zzmS());
            bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", zzroVarZzqy.zzFI());
        }
        return bundle;
    }

    @Override // com.google.android.gms.internal.zzrn
    public void connect() {
        zza(new com.google.android.gms.common.internal.zzj.zzf());
    }

    @Override // com.google.android.gms.internal.zzrn
    public void zzFG() {
        try {
            zzqJ().zzka(this.zzale.intValue());
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when clearAccountFromSessionStore is called");
        }
    }

    @Override // com.google.android.gms.internal.zzrn
    public void zza(zzp zzpVar, boolean z) {
        try {
            zzqJ().zza(zzpVar, this.zzale.intValue(), z);
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when saveDefaultAccount is called");
        }
    }

    @Override // com.google.android.gms.internal.zzrn
    public void zza(zzd zzdVar) {
        zzx.zzb(zzdVar, "Expecting a valid ISignInCallbacks");
        try {
            zzqJ().zza(new SignInRequest(zzFN()), zzdVar);
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
            try {
                zzdVar.zzb(new SignInResponse(8));
            } catch (RemoteException e2) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzj
    /* JADX INFO: renamed from: zzec, reason: merged with bridge method [inline-methods] */
    public zze zzW(IBinder iBinder) {
        return zze.zza.zzeb(iBinder);
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzgu() {
        return "com.google.android.gms.signin.service.START";
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzgv() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    @Override // com.google.android.gms.common.internal.zzj, com.google.android.gms.common.api.Api.zzb
    public boolean zzmE() {
        return this.zzbhi;
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected Bundle zzml() {
        if (!getContext().getPackageName().equals(this.zzahz.zzqv())) {
            this.zzbgU.putString("com.google.android.gms.signin.internal.realClientPackageName", this.zzahz.zzqv());
        }
        return this.zzbgU;
    }
}
