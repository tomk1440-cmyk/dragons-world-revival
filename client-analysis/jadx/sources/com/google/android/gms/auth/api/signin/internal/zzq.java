package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.common.internal.zzx;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;

/* JADX INFO: loaded from: classes.dex */
public class zzq {
    private static final Lock zzYa = new ReentrantLock();
    private static zzq zzYb;
    private final Lock zzYc = new ReentrantLock();
    private final SharedPreferences zzYd;

    zzq(Context context) {
        this.zzYd = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    public static zzq zzaf(Context context) {
        zzx.zzz(context);
        zzYa.lock();
        try {
            if (zzYb == null) {
                zzYb = new zzq(context.getApplicationContext());
            }
            return zzYb;
        } finally {
            zzYa.unlock();
        }
    }

    private String zzs(String str, String str2) {
        return str + ":" + str2;
    }

    void zza(GoogleSignInAccount googleSignInAccount, GoogleSignInOptions googleSignInOptions) {
        zzx.zzz(googleSignInAccount);
        zzx.zzz(googleSignInOptions);
        String strZzmL = googleSignInAccount.zzmL();
        zzr(zzs("googleSignInAccount", strZzmL), googleSignInAccount.zzmM());
        zzr(zzs("googleSignInOptions", strZzmL), googleSignInOptions.zzmI());
    }

    void zza(SignInAccount signInAccount, SignInConfiguration signInConfiguration) {
        zzx.zzz(signInAccount);
        zzx.zzz(signInConfiguration);
        String userId = signInAccount.getUserId();
        SignInAccount signInAccountZzbP = zzbP(userId);
        if (signInAccountZzbP != null && signInAccountZzbP.zzmV() != null) {
            zzbU(signInAccountZzbP.zzmV().zzmL());
        }
        zzr(zzs("signInConfiguration", userId), signInConfiguration.zzmI());
        zzr(zzs("signInAccount", userId), signInAccount.zzmI());
        if (signInAccount.zzmV() != null) {
            zza(signInAccount.zzmV(), signInConfiguration.zznm());
        }
    }

    public void zzb(GoogleSignInAccount googleSignInAccount, GoogleSignInOptions googleSignInOptions) {
        zzx.zzz(googleSignInAccount);
        zzx.zzz(googleSignInOptions);
        zzr("defaultGoogleSignInAccount", googleSignInAccount.zzmL());
        zza(googleSignInAccount, googleSignInOptions);
    }

    public void zzb(SignInAccount signInAccount, SignInConfiguration signInConfiguration) {
        zzx.zzz(signInAccount);
        zzx.zzz(signInConfiguration);
        zznq();
        zzr("defaultSignInAccount", signInAccount.getUserId());
        if (signInAccount.zzmV() != null) {
            zzr("defaultGoogleSignInAccount", signInAccount.zzmV().zzmL());
        }
        zza(signInAccount, signInConfiguration);
    }

    SignInAccount zzbP(String str) {
        GoogleSignInAccount googleSignInAccountZzbQ;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String strZzbS = zzbS(zzs("signInAccount", str));
        if (TextUtils.isEmpty(strZzbS)) {
            return null;
        }
        try {
            SignInAccount signInAccountZzbM = SignInAccount.zzbM(strZzbS);
            if (signInAccountZzbM.zzmV() != null && (googleSignInAccountZzbQ = zzbQ(signInAccountZzbM.zzmV().zzmL())) != null) {
                signInAccountZzbM.zza(googleSignInAccountZzbQ);
            }
            return signInAccountZzbM;
        } catch (JSONException e) {
            return null;
        }
    }

    GoogleSignInAccount zzbQ(String str) {
        String strZzbS;
        if (TextUtils.isEmpty(str) || (strZzbS = zzbS(zzs("googleSignInAccount", str))) == null) {
            return null;
        }
        try {
            return GoogleSignInAccount.zzbH(strZzbS);
        } catch (JSONException e) {
            return null;
        }
    }

    GoogleSignInOptions zzbR(String str) {
        String strZzbS;
        if (TextUtils.isEmpty(str) || (strZzbS = zzbS(zzs("googleSignInOptions", str))) == null) {
            return null;
        }
        try {
            return GoogleSignInOptions.zzbJ(strZzbS);
        } catch (JSONException e) {
            return null;
        }
    }

    protected String zzbS(String str) {
        this.zzYc.lock();
        try {
            return this.zzYd.getString(str, null);
        } finally {
            this.zzYc.unlock();
        }
    }

    void zzbT(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        SignInAccount signInAccountZzbP = zzbP(str);
        zzbV(zzs("signInAccount", str));
        zzbV(zzs("signInConfiguration", str));
        if (signInAccountZzbP == null || signInAccountZzbP.zzmV() == null) {
            return;
        }
        zzbU(signInAccountZzbP.zzmV().zzmL());
    }

    void zzbU(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        zzbV(zzs("googleSignInAccount", str));
        zzbV(zzs("googleSignInOptions", str));
    }

    protected void zzbV(String str) {
        this.zzYc.lock();
        try {
            this.zzYd.edit().remove(str).apply();
        } finally {
            this.zzYc.unlock();
        }
    }

    public GoogleSignInAccount zzno() {
        return zzbQ(zzbS("defaultGoogleSignInAccount"));
    }

    public GoogleSignInOptions zznp() {
        return zzbR(zzbS("defaultGoogleSignInAccount"));
    }

    public void zznq() {
        String strZzbS = zzbS("defaultSignInAccount");
        zzbV("defaultSignInAccount");
        zznr();
        zzbT(strZzbS);
    }

    public void zznr() {
        String strZzbS = zzbS("defaultGoogleSignInAccount");
        zzbV("defaultGoogleSignInAccount");
        zzbU(strZzbS);
    }

    protected void zzr(String str, String str2) {
        this.zzYc.lock();
        try {
            this.zzYd.edit().putString(str, str2).apply();
        } finally {
            this.zzYc.unlock();
        }
    }
}
