package com.google.android.gms.auth.api.signin.internal;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.text.TextUtils;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzlf;
import com.google.android.gms.internal.zzlh;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
@KeepName
public class SignInHubActivity extends FragmentActivity {
    private zzq zzXP;
    private zzk zzXQ;
    private SignInConfiguration zzXR;
    private boolean zzXS;
    private String zzXT;
    private String zzXU;
    private boolean zzXV;
    private int zzXW;
    private Intent zzXX;

    private class zza implements LoaderManager.LoaderCallbacks<Void> {
        private zza() {
        }

        @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
        public Loader<Void> onCreateLoader(int i, Bundle bundle) {
            return new zzb(SignInHubActivity.this, GoogleApiClient.zzoV());
        }

        @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
        public void onLoaderReset(Loader<Void> loader) {
        }

        @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
        /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
        public void onLoadFinished(Loader<Void> loader, Void r5) {
            SignInHubActivity.this.setResult(SignInHubActivity.this.zzXW, SignInHubActivity.this.zzXX);
            SignInHubActivity.this.finish();
        }
    }

    private void zza(int i, int i2, Intent intent) {
        Iterator<zzlf> it = this.zzXQ.zznh().iterator();
        while (it.hasNext() && !it.next().zza(i, i2, intent, zzbO(this.zzXU))) {
        }
        if (i2 == 0) {
            finish();
        }
    }

    private void zza(int i, Intent intent) {
        if (intent != null) {
            SignInAccount signInAccount = (SignInAccount) intent.getParcelableExtra("signInAccount");
            if (signInAccount != null && signInAccount.zzmV() != null) {
                GoogleSignInAccount googleSignInAccountZzmV = signInAccount.zzmV();
                this.zzXP.zzb(googleSignInAccountZzmV, this.zzXR.zznm());
                intent.removeExtra("signInAccount");
                intent.putExtra("googleSignInAccount", googleSignInAccountZzmV);
                this.zzXV = true;
                this.zzXW = i;
                this.zzXX = intent;
                zzd(i, intent);
                return;
            }
            if (intent.hasExtra("errorCode")) {
                zzaS(intent.getIntExtra("errorCode", 8));
                return;
            }
        }
        zzaS(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzaR(int i) {
        Intent intent = new Intent();
        intent.putExtra("errorCode", i);
        setResult(0, intent);
        finish();
    }

    private void zzaS(int i) {
        Status status = new Status(i);
        Intent intent = new Intent();
        intent.putExtra("googleSignInStatus", status);
        setResult(0, intent);
        finish();
    }

    private void zzb(int i, Intent intent) {
        if (i == -1) {
            SignInAccount signInAccount = (SignInAccount) intent.getParcelableExtra("signInAccount");
            if (signInAccount == null) {
                Log.w("AuthSignInClient", "[SignInHubActivity] SignInAccount is null.");
                zzaR(2);
                return;
            }
            this.zzXP.zzb(signInAccount, this.zzXR);
            String stringExtra = intent.getStringExtra("accessToken");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(this.zzXU)) {
                zzm.zzbN(signInAccount.getUserId()).zza(new HashSet(Arrays.asList(TextUtils.split(this.zzXU, " "))), new zzm.zza(stringExtra, intent.getLongExtra("accessTokenExpiresAtSecs", 0L)));
                intent.removeExtra("accessTokenExpiresAtSecs");
            }
            setResult(-1, intent);
            finish();
            return;
        }
        if (intent == null) {
            finish();
            return;
        }
        String stringExtra2 = intent.getStringExtra("email");
        com.google.android.gms.auth.api.signin.zzd zzdVarZzbL = com.google.android.gms.auth.api.signin.zzd.zzbL(intent.getStringExtra("idProvider"));
        if (zzdVarZzbL == null) {
            setResult(i, intent);
            finish();
            return;
        }
        this.zzXT = intent.getStringExtra("pendingToken");
        zzlf zzlfVarZza = this.zzXQ.zza(zzdVarZzbL);
        if (zzlfVarZza == null) {
            Log.w("AuthSignInClient", ((Object) zzdVarZzbL.zzae(this)) + " is not supported. Please check your configuration");
            zzaR(1);
            return;
        }
        int intExtra = intent.getIntExtra("idpAction", -1);
        if (intExtra == 0) {
            if (TextUtils.isEmpty(stringExtra2)) {
                zzlfVarZza.zza(zzbO(this.zzXU));
                return;
            } else {
                zzlfVarZza.zza(stringExtra2, zzbO(this.zzXU));
                return;
            }
        }
        if (intExtra == 1 && !TextUtils.isEmpty(this.zzXT) && !TextUtils.isEmpty(stringExtra2)) {
            zzlfVarZza.zza(stringExtra2, this.zzXT, zzbO(this.zzXU));
        } else {
            Log.w("AuthSignInClient", "Internal error!");
            zzaR(2);
        }
    }

    private zzlf.zza zzbO(final String str) {
        return new zzlf.zza() { // from class: com.google.android.gms.auth.api.signin.internal.SignInHubActivity.1
            @Override // com.google.android.gms.internal.zzlf.zza
            public void zzk(Intent intent) {
                if (intent == null) {
                    Log.w("AuthSignInClient", "Idp signin failed!");
                    SignInHubActivity.this.zzaR(4);
                } else {
                    if (!TextUtils.isEmpty(str)) {
                        intent.putExtra("scopes", str);
                    }
                    SignInHubActivity.this.zzj(intent);
                }
            }
        };
    }

    private void zzc(int i, Intent intent) {
        if (i == 0) {
            setResult(0, intent);
            finish();
            return;
        }
        Intent intent2 = new Intent("com.google.android.gms.auth.VERIFY_ASSERTION");
        intent2.putExtra("idpTokenType", IdpTokenType.zzXA);
        intent2.putExtra("idpToken", intent.getStringExtra("idpToken"));
        intent2.putExtra("pendingToken", this.zzXT);
        intent2.putExtra("idProvider", com.google.android.gms.auth.api.signin.zzd.FACEBOOK.zzmT());
        zzj(intent2);
    }

    private void zzd(int i, Intent intent) {
        getSupportLoaderManager().initLoader(0, null, new zza());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzj(Intent intent) {
        intent.setPackage("com.google.android.gms");
        intent.putExtra("config", this.zzXR);
        try {
            startActivityForResult(intent, this.zzXS ? 40962 : 40961);
        } catch (ActivityNotFoundException e) {
            Log.w("AuthSignInClient", "Could not launch sign in Intent. Google Play Service is probably being updated...");
            if (this.zzXS) {
                zzaS(8);
            } else {
                zzaR(2);
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        return true;
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        setResult(0);
        switch (requestCode) {
            case 40961:
                zzb(resultCode, data);
                break;
            case 40962:
                zza(resultCode, data);
                break;
            case 45057:
                zzc(resultCode, data);
                break;
            default:
                zza(requestCode, resultCode, data);
                break;
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.BaseFragmentActivityDonut, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent;
        SignInAccount signInAccount;
        zzlf zzlfVar = null;
        super.onCreate(savedInstanceState);
        this.zzXP = zzq.zzaf(this);
        Intent intent2 = getIntent();
        this.zzXR = (SignInConfiguration) intent2.getParcelableExtra("config");
        this.zzXS = "com.google.android.gms.auth.GOOGLE_SIGN_IN".equals(intent2.getAction());
        this.zzXU = intent2.getStringExtra("scopes");
        if (this.zzXR == null) {
            Log.e("AuthSignInClient", "Activity started with invalid configuration.");
            setResult(0);
            finish();
            return;
        }
        LinkedList linkedList = new LinkedList();
        HashMap map = new HashMap();
        zzi.zza(this.zzXR, linkedList, map);
        this.zzXQ = new zzk(this, linkedList, map);
        if (savedInstanceState != null) {
            this.zzXT = savedInstanceState.getString("pendingToken");
            this.zzXV = savedInstanceState.getBoolean("signingInGoogleApiClients");
            if (this.zzXV) {
                this.zzXW = savedInstanceState.getInt("signInResultCode");
                this.zzXX = (Intent) savedInstanceState.getParcelable("signInResultData");
                zzd(this.zzXW, this.zzXX);
                return;
            }
            return;
        }
        if (this.zzXS) {
            intent = new Intent("com.google.android.gms.auth.GOOGLE_SIGN_IN");
            signInAccount = null;
        } else {
            intent = new Intent("com.google.android.gms.auth.LOGIN_PICKER");
            if ("com.google.android.gms.auth.RESOLVE_CREDENTIAL".equals(intent2.getAction())) {
                intent.fillIn(intent2, 3);
                signInAccount = (SignInAccount) intent2.getParcelableExtra("signInAccount");
            } else {
                this.zzXP.zznq();
                if (0 != 0) {
                    try {
                        zzlh.zzag(this);
                        signInAccount = null;
                    } catch (IllegalStateException e) {
                        signInAccount = null;
                    }
                } else {
                    signInAccount = null;
                }
            }
        }
        if (signInAccount == null || signInAccount.zzmU() != com.google.android.gms.auth.api.signin.zzd.FACEBOOK) {
            zzj(intent);
        } else {
            zzlfVar.zza(zzbO(this.zzXU));
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("pendingToken", this.zzXT);
        outState.putBoolean("signingInGoogleApiClients", this.zzXV);
        if (this.zzXV) {
            outState.putInt("signInResultCode", this.zzXW);
            outState.putParcelable("signInResultData", this.zzXX);
        }
    }
}
