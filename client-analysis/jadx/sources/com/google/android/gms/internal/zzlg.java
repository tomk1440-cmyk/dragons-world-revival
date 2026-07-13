package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import com.google.android.gms.auth.api.signin.internal.IdpTokenType;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzlg implements zzlf {
    protected final Activity mActivity;
    private String zzWP;
    private String zzXT;
    protected final Set<String> zzXf;
    private zzlf.zza zzYe;

    protected zzlg(Activity activity, List<String> list, List<String> list2) {
        this.mActivity = (Activity) com.google.android.gms.common.internal.zzx.zzz(activity);
        HashSet hashSet = new HashSet((Collection) com.google.android.gms.common.internal.zzx.zzz(list));
        hashSet.addAll((Collection) com.google.android.gms.common.internal.zzx.zzz(list2));
        this.zzXf = Collections.unmodifiableSet(hashSet);
    }

    protected Intent zza(IdpTokenType idpTokenType, String str, String str2) {
        com.google.android.gms.common.internal.zzx.zzz(idpTokenType);
        com.google.android.gms.common.internal.zzx.zzcM(str);
        Intent intent = new Intent("com.google.android.gms.auth.VERIFY_ASSERTION");
        intent.putExtra("idpTokenType", idpTokenType);
        intent.putExtra("idpToken", str);
        intent.putExtra("pendingToken", str2);
        com.google.android.gms.auth.api.signin.zzd zzdVarZzmU = zzmU();
        if (zzdVarZzmU != null) {
            intent.putExtra("idProvider", zzdVarZzmU.zzmT());
        }
        return intent;
    }

    protected void zzb(zzlf.zza zzaVar) {
        this.zzYe = (zzlf.zza) com.google.android.gms.common.internal.zzx.zzz(zzaVar);
    }

    protected void zzb(String str, String str2, zzlf.zza zzaVar) {
        zzbW(str);
        zzbX(str2);
        zzb(zzaVar);
    }

    protected void zzbW(String str) {
        this.zzWP = str;
    }

    protected void zzbX(String str) {
        this.zzXT = str;
    }

    protected Set<String> zzns() {
        return this.zzXf;
    }

    protected zzlf.zza zznt() {
        return this.zzYe;
    }

    protected String zznu() {
        return this.zzXT;
    }
}
