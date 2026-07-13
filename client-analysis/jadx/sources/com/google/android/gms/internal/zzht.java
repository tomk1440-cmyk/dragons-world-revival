package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.ads.mediation.AbstractAdViewAdapter;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.reward.client.RewardedVideoAdRequestParcel;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzht extends com.google.android.gms.ads.internal.zzb implements zzhw {
    private static final zzew zzKv = new zzew();
    private final Map<String, zzia> zzKw;
    private boolean zzKx;

    public zzht(Context context, com.google.android.gms.ads.internal.zzd zzdVar, AdSizeParcel adSizeParcel, zzex zzexVar, VersionInfoParcel versionInfoParcel) {
        super(context, adSizeParcel, null, zzexVar, versionInfoParcel, zzdVar);
        this.zzKw = new HashMap();
    }

    private zzif.zza zzc(zzif.zza zzaVar) {
        zzin.v("Creating mediation ad response for non-mediated rewarded ad.");
        try {
            String string = zzhe.zzc(zzaVar.zzLe).toString();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER, zzaVar.zzLd.zzrj);
            return new zzif.zza(zzaVar.zzLd, zzaVar.zzLe, new zzeo(Arrays.asList(new zzen(string, null, Arrays.asList("com.google.ads.mediation.admob.AdMobAdapter"), null, null, Collections.emptyList(), Collections.emptyList(), jSONObject.toString(), null, Collections.emptyList(), Collections.emptyList(), null, null, null, null, null)), -1L, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), "", -1L, 0, 1, null, 0, -1, -1L), zzaVar.zzrp, zzaVar.errorCode, zzaVar.zzKY, zzaVar.zzKZ, zzaVar.zzKT);
        } catch (JSONException e) {
            zzin.zzb("Unable to generate ad state for non-mediated rewarded video.", e);
            return zzd(zzaVar);
        }
    }

    private zzif.zza zzd(zzif.zza zzaVar) {
        return new zzif.zza(zzaVar.zzLd, zzaVar.zzLe, null, zzaVar.zzrp, 0, zzaVar.zzKY, zzaVar.zzKZ, zzaVar.zzKT);
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.ads.internal.client.zzu
    public void destroy() {
        com.google.android.gms.common.internal.zzx.zzcD("destroy must be called on the main UI thread.");
        for (String str : this.zzKw.keySet()) {
            try {
                zzia zziaVar = this.zzKw.get(str);
                if (zziaVar != null && zziaVar.zzgP() != null) {
                    zziaVar.zzgP().destroy();
                }
            } catch (RemoteException e) {
                zzin.zzaK("Fail to destroy adapter: " + str);
            }
        }
    }

    public boolean isLoaded() {
        com.google.android.gms.common.internal.zzx.zzcD("isLoaded must be called on the main UI thread.");
        return this.zzpj.zzrn == null && this.zzpj.zzro == null && this.zzpj.zzrq != null && !this.zzKx;
    }

    @Override // com.google.android.gms.internal.zzhw
    public void onRewardedVideoAdClosed() {
        zzaQ();
    }

    @Override // com.google.android.gms.internal.zzhw
    public void onRewardedVideoAdLeftApplication() {
        zzaR();
    }

    @Override // com.google.android.gms.internal.zzhw
    public void onRewardedVideoAdOpened() {
        zza(this.zzpj.zzrq, false);
        zzaS();
    }

    @Override // com.google.android.gms.internal.zzhw
    public void onRewardedVideoStarted() {
        if (this.zzpj.zzrq != null && this.zzpj.zzrq.zzCp != null) {
            com.google.android.gms.ads.internal.zzr.zzbP().zza(this.zzpj.context, this.zzpj.zzrl.afmaVersion, this.zzpj.zzrq, this.zzpj.zzrj, false, this.zzpj.zzrq.zzCp.zzBH);
        }
        zzaU();
    }

    @Override // com.google.android.gms.ads.internal.zzb, com.google.android.gms.ads.internal.zza, com.google.android.gms.ads.internal.client.zzu
    public void pause() {
        com.google.android.gms.common.internal.zzx.zzcD("pause must be called on the main UI thread.");
        for (String str : this.zzKw.keySet()) {
            try {
                zzia zziaVar = this.zzKw.get(str);
                if (zziaVar != null && zziaVar.zzgP() != null) {
                    zziaVar.zzgP().pause();
                }
            } catch (RemoteException e) {
                zzin.zzaK("Fail to pause adapter: " + str);
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.zzb, com.google.android.gms.ads.internal.zza, com.google.android.gms.ads.internal.client.zzu
    public void resume() {
        com.google.android.gms.common.internal.zzx.zzcD("resume must be called on the main UI thread.");
        for (String str : this.zzKw.keySet()) {
            try {
                zzia zziaVar = this.zzKw.get(str);
                if (zziaVar != null && zziaVar.zzgP() != null) {
                    zziaVar.zzgP().resume();
                }
            } catch (RemoteException e) {
                zzin.zzaK("Fail to resume adapter: " + str);
            }
        }
    }

    public void zza(RewardedVideoAdRequestParcel rewardedVideoAdRequestParcel) {
        com.google.android.gms.common.internal.zzx.zzcD("loadAd must be called on the main UI thread.");
        if (TextUtils.isEmpty(rewardedVideoAdRequestParcel.zzrj)) {
            zzin.zzaK("Invalid ad unit id. Aborting.");
            return;
        }
        this.zzKx = false;
        this.zzpj.zzrj = rewardedVideoAdRequestParcel.zzrj;
        super.zzb(rewardedVideoAdRequestParcel.zzHt);
    }

    @Override // com.google.android.gms.ads.internal.zza
    public void zza(final zzif.zza zzaVar, zzcb zzcbVar) {
        if (zzaVar.errorCode != -2) {
            zzir.zzMc.post(new Runnable() { // from class: com.google.android.gms.internal.zzht.1
                @Override // java.lang.Runnable
                public void run() {
                    zzht.this.zzb(new zzif(zzaVar, null, null, null, null, null, null));
                }
            });
            return;
        }
        this.zzpj.zzrr = zzaVar;
        if (zzaVar.zzKV == null) {
            this.zzpj.zzrr = zzc(zzaVar);
        }
        this.zzpj.zzrL = 0;
        this.zzpj.zzro = com.google.android.gms.ads.internal.zzr.zzbB().zza(this.zzpj.context, this.zzpj.getUserId(), this.zzpj.zzrr, this);
    }

    @Override // com.google.android.gms.ads.internal.zzb, com.google.android.gms.ads.internal.zza
    public boolean zza(zzif zzifVar, zzif zzifVar2) {
        return true;
    }

    @Nullable
    public zzia zzaw(String str) {
        zzia zziaVar = this.zzKw.get(str);
        if (zziaVar != null) {
            return zziaVar;
        }
        try {
            zzia zziaVar2 = new zzia(("com.google.ads.mediation.admob.AdMobAdapter".equals(str) ? zzKv : this.zzpn).zzaf(str), this);
            try {
                this.zzKw.put(str, zziaVar2);
                return zziaVar2;
            } catch (Exception e) {
                zziaVar = zziaVar2;
                e = e;
                zzin.zzd("Fail to instantiate adapter " + str, e);
                return zziaVar;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    @Override // com.google.android.gms.internal.zzhw
    public void zzc(@Nullable RewardItemParcel rewardItemParcel) {
        if (this.zzpj.zzrq != null && this.zzpj.zzrq.zzCp != null) {
            com.google.android.gms.ads.internal.zzr.zzbP().zza(this.zzpj.context, this.zzpj.zzrl.afmaVersion, this.zzpj.zzrq, this.zzpj.zzrj, false, this.zzpj.zzrq.zzCp.zzBI);
        }
        if (this.zzpj.zzrq != null && this.zzpj.zzrq.zzKV != null && !TextUtils.isEmpty(this.zzpj.zzrq.zzKV.zzBV)) {
            rewardItemParcel = new RewardItemParcel(this.zzpj.zzrq.zzKV.zzBV, this.zzpj.zzrq.zzKV.zzBW);
        }
        zza(rewardItemParcel);
    }

    public void zzgL() {
        com.google.android.gms.common.internal.zzx.zzcD("showAd must be called on the main UI thread.");
        if (!isLoaded()) {
            zzin.zzaK("The reward video has not loaded.");
            return;
        }
        this.zzKx = true;
        zzia zziaVarZzaw = zzaw(this.zzpj.zzrq.zzCr);
        if (zziaVarZzaw == null || zziaVarZzaw.zzgP() == null) {
            return;
        }
        try {
            zziaVarZzaw.zzgP().showVideo();
        } catch (RemoteException e) {
            zzin.zzd("Could not call showVideo.", e);
        }
    }

    @Override // com.google.android.gms.internal.zzhw
    public void zzgM() {
        onAdClicked();
    }
}
