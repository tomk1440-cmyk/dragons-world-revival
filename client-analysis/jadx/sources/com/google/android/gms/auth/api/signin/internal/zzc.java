package com.google.android.gms.auth.api.signin.internal;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zzr;
import com.google.android.gms.common.internal.zzx;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class zzc implements GoogleSignInApi {

    private abstract class zza<R extends Result> extends com.google.android.gms.common.api.internal.zza.AbstractC0049zza<R, zzd> {
        public zza(GoogleApiClient googleApiClient) {
            super(Auth.zzVx, googleApiClient);
        }
    }

    private OptionalPendingResult<GoogleSignInResult> zza(GoogleApiClient googleApiClient, final GoogleSignInOptions googleSignInOptions) {
        Log.d("GoogleSignInApiImpl", "trySilentSignIn");
        return new zzr(googleApiClient.zza(new zza<GoogleSignInResult>(googleApiClient) { // from class: com.google.android.gms.auth.api.signin.internal.zzc.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzd zzdVar) throws RemoteException {
                final zzq zzqVarZzaf = zzq.zzaf(zzdVar.getContext());
                zzdVar.zzqJ().zza(new com.google.android.gms.auth.api.signin.internal.zza() { // from class: com.google.android.gms.auth.api.signin.internal.zzc.1.1
                    @Override // com.google.android.gms.auth.api.signin.internal.zza, com.google.android.gms.auth.api.signin.internal.zzg
                    public void zza(GoogleSignInAccount googleSignInAccount, Status status) throws RemoteException {
                        if (googleSignInAccount != null) {
                            zzqVarZzaf.zzb(googleSignInAccount, googleSignInOptions);
                        }
                        zza(new GoogleSignInResult(googleSignInAccount, status));
                    }
                }, googleSignInOptions);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zzb
            /* JADX INFO: renamed from: zzn, reason: merged with bridge method [inline-methods] */
            public GoogleSignInResult zzc(Status status) {
                return new GoogleSignInResult(null, status);
            }
        }));
    }

    private boolean zza(Account account, Account account2) {
        if (account == null) {
            return account2 == null;
        }
        return account.equals(account2);
    }

    private GoogleSignInOptions zzb(GoogleApiClient googleApiClient) {
        return ((zzd) googleApiClient.zza(Auth.zzVx)).zznd();
    }

    @Override // com.google.android.gms.auth.api.signin.GoogleSignInApi
    public Intent getSignInIntent(GoogleApiClient client) {
        zzx.zzz(client);
        return ((zzd) client.zza(Auth.zzVx)).zznc();
    }

    @Override // com.google.android.gms.auth.api.signin.GoogleSignInApi
    public GoogleSignInResult getSignInResultFromIntent(Intent data) {
        if (data == null || !(data.hasExtra("googleSignInStatus") || data.hasExtra("googleSignInAccount"))) {
            return null;
        }
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) data.getParcelableExtra("googleSignInAccount");
        Status status = (Status) data.getParcelableExtra("googleSignInStatus");
        if (googleSignInAccount != null) {
            status = Status.zzagC;
        }
        return new GoogleSignInResult(googleSignInAccount, status);
    }

    @Override // com.google.android.gms.auth.api.signin.GoogleSignInApi
    public PendingResult<Status> revokeAccess(GoogleApiClient client) {
        zzq.zzaf(client.getContext()).zznr();
        Iterator<GoogleApiClient> it = GoogleApiClient.zzoV().iterator();
        while (it.hasNext()) {
            it.next().zzoW();
        }
        return client.zzb(new zza<Status>(client) { // from class: com.google.android.gms.auth.api.signin.internal.zzc.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzd zzdVar) throws RemoteException {
                zzdVar.zzqJ().zzc(new com.google.android.gms.auth.api.signin.internal.zza() { // from class: com.google.android.gms.auth.api.signin.internal.zzc.3.1
                    @Override // com.google.android.gms.auth.api.signin.internal.zza, com.google.android.gms.auth.api.signin.internal.zzg
                    public void zzm(Status status) throws RemoteException {
                        zza(status);
                    }
                }, zzdVar.zznd());
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zzb
            /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
            public Status zzc(Status status) {
                return status;
            }
        });
    }

    @Override // com.google.android.gms.auth.api.signin.GoogleSignInApi
    public PendingResult<Status> signOut(GoogleApiClient client) {
        zzq.zzaf(client.getContext()).zznr();
        Iterator<GoogleApiClient> it = GoogleApiClient.zzoV().iterator();
        while (it.hasNext()) {
            it.next().zzoW();
        }
        return client.zzb(new zza<Status>(client) { // from class: com.google.android.gms.auth.api.signin.internal.zzc.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzd zzdVar) throws RemoteException {
                zzdVar.zzqJ().zzb(new com.google.android.gms.auth.api.signin.internal.zza() { // from class: com.google.android.gms.auth.api.signin.internal.zzc.2.1
                    @Override // com.google.android.gms.auth.api.signin.internal.zza, com.google.android.gms.auth.api.signin.internal.zzg
                    public void zzl(Status status) throws RemoteException {
                        zza(status);
                    }
                }, zzdVar.zznd());
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zzb
            /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
            public Status zzc(Status status) {
                return status;
            }
        });
    }

    @Override // com.google.android.gms.auth.api.signin.GoogleSignInApi
    public OptionalPendingResult<GoogleSignInResult> silentSignIn(GoogleApiClient client) {
        GoogleSignInOptions googleSignInOptionsZzb = zzb(client);
        GoogleSignInResult googleSignInResultZza = zza(client.getContext(), googleSignInOptionsZzb);
        return googleSignInResultZza != null ? PendingResults.zzb(googleSignInResultZza, client) : zza(client, googleSignInOptionsZzb);
    }

    public GoogleSignInResult zza(Context context, GoogleSignInOptions googleSignInOptions) {
        GoogleSignInAccount googleSignInAccountZzno;
        Log.d("GoogleSignInApiImpl", "getSavedSignInResultIfEligible");
        zzx.zzz(googleSignInOptions);
        zzq zzqVarZzaf = zzq.zzaf(context);
        GoogleSignInOptions googleSignInOptionsZznp = zzqVarZzaf.zznp();
        if (googleSignInOptionsZznp == null || !zza(googleSignInOptionsZznp.getAccount(), googleSignInOptions.getAccount()) || googleSignInOptions.zzmP()) {
            return null;
        }
        if ((!googleSignInOptions.zzmO() || (googleSignInOptionsZznp.zzmO() && googleSignInOptions.zzmR().equals(googleSignInOptionsZznp.zzmR()))) && new HashSet(googleSignInOptionsZznp.zzmN()).containsAll(new HashSet(googleSignInOptions.zzmN())) && (googleSignInAccountZzno = zzqVarZzaf.zzno()) != null && !googleSignInAccountZzno.zzb()) {
            return new GoogleSignInResult(googleSignInAccountZzno, Status.zzagC);
        }
        return null;
    }
}
