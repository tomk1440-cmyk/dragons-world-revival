package com.google.android.gms.ads.internal;

import android.os.Bundle;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.ThinAdSizeParcel;
import com.google.android.gms.ads.internal.client.zzu;
import com.google.android.gms.ads.internal.client.zzw;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzax;
import com.google.android.gms.internal.zzbc;
import com.google.android.gms.internal.zzbf;
import com.google.android.gms.internal.zzbt;
import com.google.android.gms.internal.zzbz;
import com.google.android.gms.internal.zzcb;
import com.google.android.gms.internal.zzcf;
import com.google.android.gms.internal.zzdb;
import com.google.android.gms.internal.zzgd;
import com.google.android.gms.internal.zzgh;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzhr;
import com.google.android.gms.internal.zzif;
import com.google.android.gms.internal.zzig;
import com.google.android.gms.internal.zzij;
import com.google.android.gms.internal.zzik;
import com.google.android.gms.internal.zzin;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public abstract class zza extends zzu.zza implements com.google.android.gms.ads.internal.client.zza, com.google.android.gms.ads.internal.overlay.zzp, com.google.android.gms.ads.internal.request.zza.InterfaceC0027zza, zzdb, zzgr.zza, zzij {
    protected zzcb zzpe;
    protected zzbz zzpf;
    protected zzbz zzpg;
    protected boolean zzph = false;
    protected final zzq zzpi;
    protected final zzs zzpj;
    protected transient AdRequestParcel zzpk;
    protected final zzax zzpl;
    protected final zzd zzpm;

    zza(zzs zzsVar, zzq zzqVar, zzd zzdVar) {
        this.zzpj = zzsVar;
        this.zzpi = zzqVar == null ? new zzq(this) : zzqVar;
        this.zzpm = zzdVar;
        zzr.zzbC().zzJ(this.zzpj.context);
        zzr.zzbF().zzb(this.zzpj.context, this.zzpj.zzrl);
        this.zzpl = zzr.zzbF().zzhh();
    }

    private AdRequestParcel zza(AdRequestParcel adRequestParcel) {
        return (!com.google.android.gms.common.zze.zzap(this.zzpj.context) || adRequestParcel.zztK == null) ? adRequestParcel : new com.google.android.gms.ads.internal.client.zzf(adRequestParcel).zza(null).zzcN();
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void destroy() {
        zzx.zzcD("destroy must be called on the main UI thread.");
        this.zzpi.cancel();
        this.zzpl.zzj(this.zzpj.zzrq);
        this.zzpj.destroy();
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public boolean isLoading() {
        return this.zzph;
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public boolean isReady() {
        zzx.zzcD("isLoaded must be called on the main UI thread.");
        return this.zzpj.zzrn == null && this.zzpj.zzro == null && this.zzpj.zzrq != null;
    }

    @Override // com.google.android.gms.ads.internal.client.zza
    public void onAdClicked() {
        if (this.zzpj.zzrq == null) {
            zzin.zzaK("Ad state was null when trying to ping click URLs.");
            return;
        }
        zzin.zzaI("Pinging click URLs.");
        this.zzpj.zzrs.zzgT();
        if (this.zzpj.zzrq.zzBQ != null) {
            zzr.zzbC().zza(this.zzpj.context, this.zzpj.zzrl.afmaVersion, this.zzpj.zzrq.zzBQ);
        }
        if (this.zzpj.zzrt != null) {
            try {
                this.zzpj.zzrt.onAdClicked();
            } catch (RemoteException e) {
                zzin.zzd("Could not notify onAdClicked event.", e);
            }
        }
    }

    @Override // com.google.android.gms.internal.zzdb
    public void onAppEvent(String name, String info) {
        if (this.zzpj.zzrv != null) {
            try {
                this.zzpj.zzrv.onAppEvent(name, info);
            } catch (RemoteException e) {
                zzin.zzd("Could not call the AppEventListener.", e);
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void pause() {
        zzx.zzcD("pause must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void resume() {
        zzx.zzcD("resume must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void setManualImpressionsEnabled(boolean enabled) {
        throw new UnsupportedOperationException("Attempt to call setManualImpressionsEnabled for an unsupported ad type.");
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void setUserId(String userId) {
        zzx.zzcD("setUserId must be called on the main UI thread.");
        this.zzpj.setUserId(userId);
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void stopLoading() {
        zzx.zzcD("stopLoading must be called on the main UI thread.");
        this.zzph = false;
        this.zzpj.zzf(true);
    }

    Bundle zza(zzbf zzbfVar) {
        String strZzhf;
        String strZzcz;
        Bundle bundle = null;
        if (zzbfVar != null) {
            if (zzbfVar.zzcK()) {
                zzbfVar.wakeup();
            }
            zzbc zzbcVarZzcI = zzbfVar.zzcI();
            if (zzbcVarZzcI != null) {
                strZzhf = zzbcVarZzcI.zzcy();
                strZzcz = zzbcVarZzcI.zzcz();
                zzin.zzaI("In AdManager: loadAd, " + zzbcVarZzcI.toString());
                if (strZzhf != null) {
                    zzr.zzbF().zzaA(strZzhf);
                }
            } else {
                strZzhf = zzr.zzbF().zzhf();
                strZzcz = null;
            }
            if (strZzhf != null) {
                bundle = new Bundle(1);
                bundle.putString("fingerprint", strZzhf);
                if (!strZzhf.equals(strZzcz)) {
                    bundle.putString("v_fp", strZzcz);
                }
            }
        }
        return bundle;
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void zza(AdSizeParcel adSizeParcel) {
        zzx.zzcD("setAdSize must be called on the main UI thread.");
        this.zzpj.zzrp = adSizeParcel;
        if (this.zzpj.zzrq != null && this.zzpj.zzrq.zzED != null && this.zzpj.zzrL == 0) {
            this.zzpj.zzrq.zzED.zza(adSizeParcel);
        }
        if (this.zzpj.zzrm == null) {
            return;
        }
        if (this.zzpj.zzrm.getChildCount() > 1) {
            this.zzpj.zzrm.removeView(this.zzpj.zzrm.getNextView());
        }
        this.zzpj.zzrm.setMinimumWidth(adSizeParcel.widthPixels);
        this.zzpj.zzrm.setMinimumHeight(adSizeParcel.heightPixels);
        this.zzpj.zzrm.requestLayout();
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void zza(com.google.android.gms.ads.internal.client.zzp zzpVar) {
        zzx.zzcD("setAdListener must be called on the main UI thread.");
        this.zzpj.zzrt = zzpVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void zza(com.google.android.gms.ads.internal.client.zzq zzqVar) {
        zzx.zzcD("setAdListener must be called on the main UI thread.");
        this.zzpj.zzru = zzqVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void zza(zzw zzwVar) {
        zzx.zzcD("setAppEventListener must be called on the main UI thread.");
        this.zzpj.zzrv = zzwVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void zza(com.google.android.gms.ads.internal.client.zzx zzxVar) {
        zzx.zzcD("setCorrelationIdProvider must be called on the main UI thread");
        this.zzpj.zzrw = zzxVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void zza(com.google.android.gms.ads.internal.reward.client.zzd zzdVar) {
        zzx.zzcD("setRewardedVideoAdListener can only be called from the UI thread.");
        this.zzpj.zzrF = zzdVar;
    }

    protected void zza(RewardItemParcel rewardItemParcel) {
        if (this.zzpj.zzrF == null) {
            return;
        }
        String str = "";
        int i = 0;
        if (rewardItemParcel != null) {
            try {
                str = rewardItemParcel.type;
                i = rewardItemParcel.zzKS;
            } catch (RemoteException e) {
                zzin.zzd("Could not call RewardedVideoAdListener.onRewarded().", e);
                return;
            }
        }
        this.zzpj.zzrF.zza(new zzhr(str, i));
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void zza(zzcf zzcfVar) {
        throw new IllegalStateException("setOnCustomRenderedAdLoadedListener is not supported for current ad type");
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void zza(zzgd zzgdVar) {
        throw new IllegalStateException("setInAppPurchaseListener is not supported for current ad type");
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void zza(zzgh zzghVar, String str) {
        throw new IllegalStateException("setPlayStorePurchaseParams is not supported for current ad type");
    }

    @Override // com.google.android.gms.ads.internal.request.zza.InterfaceC0027zza
    public void zza(zzif.zza zzaVar) {
        if (zzaVar.zzLe.zzHX != -1 && !TextUtils.isEmpty(zzaVar.zzLe.zzIh)) {
            long jZzp = zzp(zzaVar.zzLe.zzIh);
            if (jZzp != -1) {
                this.zzpe.zza(this.zzpe.zzb(jZzp + zzaVar.zzLe.zzHX), "stc");
            }
        }
        this.zzpe.zzN(zzaVar.zzLe.zzIh);
        this.zzpe.zza(this.zzpf, "arf");
        this.zzpg = this.zzpe.zzdB();
        this.zzpe.zzc("gqi", zzaVar.zzLe.zzIi);
        this.zzpj.zzrn = null;
        this.zzpj.zzrr = zzaVar;
        zza(zzaVar, this.zzpe);
    }

    protected abstract void zza(zzif.zza zzaVar, zzcb zzcbVar);

    @Override // com.google.android.gms.internal.zzij
    public void zza(HashSet<zzig> hashSet) {
        this.zzpj.zza(hashSet);
    }

    protected abstract boolean zza(AdRequestParcel adRequestParcel, zzcb zzcbVar);

    boolean zza(zzif zzifVar) {
        return false;
    }

    protected abstract boolean zza(zzif zzifVar, zzif zzifVar2);

    void zzaL() {
        this.zzpe = new zzcb(zzbt.zzwg.get().booleanValue(), "load_ad", this.zzpj.zzrp.zzuh);
        this.zzpf = new zzbz(-1L, null, null);
        this.zzpg = new zzbz(-1L, null, null);
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public com.google.android.gms.dynamic.zzd zzaM() {
        zzx.zzcD("getAdFrame must be called on the main UI thread.");
        return com.google.android.gms.dynamic.zze.zzC(this.zzpj.zzrm);
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public AdSizeParcel zzaN() {
        zzx.zzcD("getAdSize must be called on the main UI thread.");
        if (this.zzpj.zzrp == null) {
            return null;
        }
        return new ThinAdSizeParcel(this.zzpj.zzrp);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public void zzaO() {
        zzaR();
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void zzaP() {
        zzx.zzcD("recordManualImpression must be called on the main UI thread.");
        if (this.zzpj.zzrq == null) {
            zzin.zzaK("Ad state was null when trying to ping manual tracking URLs.");
            return;
        }
        zzin.zzaI("Pinging manual tracking URLs.");
        if (this.zzpj.zzrq.zzHV == null || this.zzpj.zzrq.zzLc) {
            return;
        }
        zzr.zzbC().zza(this.zzpj.context, this.zzpj.zzrl.afmaVersion, this.zzpj.zzrq.zzHV);
        this.zzpj.zzrq.zzLc = true;
    }

    protected void zzaQ() {
        zzin.zzaJ("Ad closing.");
        if (this.zzpj.zzru != null) {
            try {
                this.zzpj.zzru.onAdClosed();
            } catch (RemoteException e) {
                zzin.zzd("Could not call AdListener.onAdClosed().", e);
            }
        }
        if (this.zzpj.zzrF != null) {
            try {
                this.zzpj.zzrF.onRewardedVideoAdClosed();
            } catch (RemoteException e2) {
                zzin.zzd("Could not call RewardedVideoAdListener.onRewardedVideoAdClosed().", e2);
            }
        }
    }

    protected void zzaR() {
        zzin.zzaJ("Ad leaving application.");
        if (this.zzpj.zzru != null) {
            try {
                this.zzpj.zzru.onAdLeftApplication();
            } catch (RemoteException e) {
                zzin.zzd("Could not call AdListener.onAdLeftApplication().", e);
            }
        }
        if (this.zzpj.zzrF != null) {
            try {
                this.zzpj.zzrF.onRewardedVideoAdLeftApplication();
            } catch (RemoteException e2) {
                zzin.zzd("Could not call  RewardedVideoAdListener.onRewardedVideoAdLeftApplication().", e2);
            }
        }
    }

    protected void zzaS() {
        zzin.zzaJ("Ad opening.");
        if (this.zzpj.zzru != null) {
            try {
                this.zzpj.zzru.onAdOpened();
            } catch (RemoteException e) {
                zzin.zzd("Could not call AdListener.onAdOpened().", e);
            }
        }
        if (this.zzpj.zzrF != null) {
            try {
                this.zzpj.zzrF.onRewardedVideoAdOpened();
            } catch (RemoteException e2) {
                zzin.zzd("Could not call RewardedVideoAdListener.onRewardedVideoAdOpened().", e2);
            }
        }
    }

    protected void zzaT() {
        zzin.zzaJ("Ad finished loading.");
        this.zzph = false;
        if (this.zzpj.zzru != null) {
            try {
                this.zzpj.zzru.onAdLoaded();
            } catch (RemoteException e) {
                zzin.zzd("Could not call AdListener.onAdLoaded().", e);
            }
        }
        if (this.zzpj.zzrF != null) {
            try {
                this.zzpj.zzrF.onRewardedVideoAdLoaded();
            } catch (RemoteException e2) {
                zzin.zzd("Could not call RewardedVideoAdListener.onRewardedVideoAdLoaded().", e2);
            }
        }
    }

    protected void zzaU() {
        if (this.zzpj.zzrF == null) {
            return;
        }
        try {
            this.zzpj.zzrF.onRewardedVideoStarted();
        } catch (RemoteException e) {
            zzin.zzd("Could not call RewardedVideoAdListener.onVideoStarted().", e);
        }
    }

    protected void zzb(View view) {
        this.zzpj.zzrm.addView(view, zzr.zzbE().zzhy());
    }

    @Override // com.google.android.gms.internal.zzgr.zza
    public void zzb(zzif zzifVar) {
        this.zzpe.zza(this.zzpg, "awr");
        this.zzpj.zzro = null;
        if (zzifVar.errorCode != -2 && zzifVar.errorCode != 3) {
            zzr.zzbF().zzb(this.zzpj.zzbS());
        }
        if (zzifVar.errorCode == -1) {
            this.zzph = false;
            return;
        }
        if (zza(zzifVar)) {
            zzin.zzaI("Ad refresh scheduled.");
        }
        if (zzifVar.errorCode != -2) {
            zzf(zzifVar.errorCode);
            return;
        }
        if (this.zzpj.zzrJ == null) {
            this.zzpj.zzrJ = new zzik(this.zzpj.zzrj);
        }
        this.zzpl.zzi(this.zzpj.zzrq);
        if (zza(this.zzpj.zzrq, zzifVar)) {
            this.zzpj.zzrq = zzifVar;
            this.zzpj.zzcb();
            this.zzpe.zzc("is_mraid", this.zzpj.zzrq.zzcv() ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO);
            this.zzpe.zzc("is_mediation", this.zzpj.zzrq.zzHT ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO);
            if (this.zzpj.zzrq.zzED != null && this.zzpj.zzrq.zzED.zzhU() != null) {
                this.zzpe.zzc("is_video", this.zzpj.zzrq.zzED.zzhU().zzih() ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO);
            }
            this.zzpe.zza(this.zzpf, "ttc");
            if (zzr.zzbF().zzhb() != null) {
                zzr.zzbF().zzhb().zza(this.zzpe);
            }
            if (this.zzpj.zzbW()) {
                zzaT();
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public boolean zzb(AdRequestParcel adRequestParcel) {
        zzx.zzcD("loadAd must be called on the main UI thread.");
        AdRequestParcel adRequestParcelZza = zza(adRequestParcel);
        if (this.zzpj.zzrn != null || this.zzpj.zzro != null) {
            if (this.zzpk != null) {
                zzin.zzaK("Aborting last ad request since another ad request is already in progress. The current request object will still be cached for future refreshes.");
            } else {
                zzin.zzaK("Loading already in progress, saving this object for future refreshes.");
            }
            this.zzpk = adRequestParcelZza;
            return false;
        }
        zzin.zzaJ("Starting ad request.");
        zzaL();
        this.zzpf = this.zzpe.zzdB();
        if (!adRequestParcelZza.zztF) {
            zzin.zzaJ("Use AdRequest.Builder.addTestDevice(\"" + com.google.android.gms.ads.internal.client.zzn.zzcS().zzT(this.zzpj.context) + "\") to get test ads on this device.");
        }
        this.zzph = zza(adRequestParcelZza, this.zzpe);
        return this.zzph;
    }

    protected void zzc(zzif zzifVar) {
        if (zzifVar == null) {
            zzin.zzaK("Ad state was null when trying to ping impression URLs.");
            return;
        }
        zzin.zzaI("Pinging Impression URLs.");
        this.zzpj.zzrs.zzgS();
        if (zzifVar.zzBR == null || zzifVar.zzLb) {
            return;
        }
        zzr.zzbC().zza(this.zzpj.context, this.zzpj.zzrl.afmaVersion, zzifVar.zzBR);
        zzifVar.zzLb = true;
    }

    protected boolean zzc(AdRequestParcel adRequestParcel) {
        Object parent = this.zzpj.zzrm.getParent();
        return (parent instanceof View) && ((View) parent).isShown() && zzr.zzbC().zzhq();
    }

    public void zzd(AdRequestParcel adRequestParcel) {
        if (zzc(adRequestParcel)) {
            zzb(adRequestParcel);
        } else {
            zzin.zzaJ("Ad is not visible. Not refreshing ad.");
            this.zzpi.zzg(adRequestParcel);
        }
    }

    protected void zzf(int i) {
        zzin.zzaK("Failed to load ad: " + i);
        this.zzph = false;
        if (this.zzpj.zzru != null) {
            try {
                this.zzpj.zzru.onAdFailedToLoad(i);
            } catch (RemoteException e) {
                zzin.zzd("Could not call AdListener.onAdFailedToLoad().", e);
            }
        }
        if (this.zzpj.zzrF != null) {
            try {
                this.zzpj.zzrF.onRewardedVideoAdFailedToLoad(i);
            } catch (RemoteException e2) {
                zzin.zzd("Could not call RewardedVideoAdListener.onRewardedVideoAdFailedToLoad().", e2);
            }
        }
    }

    long zzp(@NonNull String str) {
        int iIndexOf = str.indexOf("ufe");
        int iIndexOf2 = str.indexOf(44, iIndexOf);
        if (iIndexOf2 == -1) {
            iIndexOf2 = str.length();
        }
        try {
            return Long.parseLong(str.substring(iIndexOf + 4, iIndexOf2));
        } catch (IndexOutOfBoundsException e) {
            zzin.zzaK("Invalid index for Url fetch time in CSI latency info.");
            return -1L;
        } catch (NumberFormatException e2) {
            zzin.zzaK("Cannot find valid format of Url fetch time in CSI latency info.");
            return -1L;
        }
    }
}
