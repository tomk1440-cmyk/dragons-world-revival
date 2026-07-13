package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.os.Binder;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;

/* JADX INFO: loaded from: classes.dex */
public class zzl extends zzf.zza {
    private final Context mContext;

    public zzl(Context context) {
        this.mContext = context;
    }

    private void zzni() {
        if (!GooglePlayServicesUtil.zzf(this.mContext, Binder.getCallingUid())) {
            throw new SecurityException("Calling UID " + Binder.getCallingUid() + " is not Google Play services.");
        }
    }

    private void zznj() {
        zzq zzqVarZzaf = zzq.zzaf(this.mContext);
        GoogleSignInAccount googleSignInAccountZzno = zzqVarZzaf.zzno();
        GoogleSignInOptions googleSignInOptionsZznp = GoogleSignInOptions.DEFAULT_SIGN_IN;
        if (googleSignInAccountZzno != null) {
            googleSignInOptionsZznp = zzqVarZzaf.zznp();
        }
        GoogleApiClient googleApiClientBuild = new GoogleApiClient.Builder(this.mContext).addApi(Auth.GOOGLE_SIGN_IN_API, googleSignInOptionsZznp).build();
        try {
            if (googleApiClientBuild.blockingConnect().isSuccess()) {
                if (googleSignInAccountZzno != null) {
                    Auth.GoogleSignInApi.revokeAccess(googleApiClientBuild);
                } else {
                    googleApiClientBuild.clearDefaultAccountAndReconnect();
                }
            }
        } finally {
            googleApiClientBuild.disconnect();
        }
    }

    @Override // com.google.android.gms.auth.api.signin.internal.zzf
    public void zznf() {
        zzni();
        zznj();
    }
}
