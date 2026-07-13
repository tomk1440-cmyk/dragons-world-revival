package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzeb extends com.google.android.gms.ads.internal.client.zzu.zza {
    private com.google.android.gms.ads.internal.zzk zzAD;
    private zzdx zzAJ;
    private zzgh zzAK;
    private String zzAL;
    private zzdv zzAz;
    private String zzpS;

    public zzeb(Context context, String str, zzex zzexVar, VersionInfoParcel versionInfoParcel, com.google.android.gms.ads.internal.zzd zzdVar) {
        this(str, new zzdv(context.getApplicationContext(), zzexVar, versionInfoParcel, zzdVar));
    }

    public zzeb(String str, zzdv zzdvVar) {
        this.zzpS = str;
        this.zzAz = zzdvVar;
        this.zzAJ = new zzdx();
        com.google.android.gms.ads.internal.zzr.zzbN().zza(zzdvVar);
    }

    private void zzel() {
        if (this.zzAD == null || this.zzAK == null) {
            return;
        }
        this.zzAD.zza(this.zzAK, this.zzAL);
    }

    void abort() {
        if (this.zzAD != null) {
            return;
        }
        this.zzAD = this.zzAz.zzX(this.zzpS);
        this.zzAJ.zzc(this.zzAD);
        zzel();
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void destroy() throws RemoteException {
        if (this.zzAD != null) {
            this.zzAD.destroy();
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public String getMediationAdapterClassName() throws RemoteException {
        if (this.zzAD != null) {
            return this.zzAD.getMediationAdapterClassName();
        }
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public boolean isLoading() throws RemoteException {
        return this.zzAD != null && this.zzAD.isLoading();
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public boolean isReady() throws RemoteException {
        return this.zzAD != null && this.zzAD.isReady();
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void pause() throws RemoteException {
        if (this.zzAD != null) {
            this.zzAD.pause();
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void resume() throws RemoteException {
        if (this.zzAD != null) {
            this.zzAD.resume();
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void setManualImpressionsEnabled(boolean manualImpressionsEnabled) throws RemoteException {
        abort();
        if (this.zzAD != null) {
            this.zzAD.setManualImpressionsEnabled(manualImpressionsEnabled);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void setUserId(String useId) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void showInterstitial() throws RemoteException {
        if (this.zzAD != null) {
            this.zzAD.showInterstitial();
        } else {
            zzin.zzaK("Interstitial ad must be loaded before showInterstitial().");
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void stopLoading() throws RemoteException {
        if (this.zzAD != null) {
            this.zzAD.stopLoading();
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void zza(AdSizeParcel adSizeParcel) throws RemoteException {
        if (this.zzAD != null) {
            this.zzAD.zza(adSizeParcel);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void zza(com.google.android.gms.ads.internal.client.zzp zzpVar) throws RemoteException {
        this.zzAJ.zzAt = zzpVar;
        if (this.zzAD != null) {
            this.zzAJ.zzc(this.zzAD);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void zza(com.google.android.gms.ads.internal.client.zzq zzqVar) throws RemoteException {
        this.zzAJ.zzpK = zzqVar;
        if (this.zzAD != null) {
            this.zzAJ.zzc(this.zzAD);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void zza(com.google.android.gms.ads.internal.client.zzw zzwVar) throws RemoteException {
        this.zzAJ.zzAq = zzwVar;
        if (this.zzAD != null) {
            this.zzAJ.zzc(this.zzAD);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void zza(com.google.android.gms.ads.internal.client.zzx zzxVar) throws RemoteException {
        abort();
        if (this.zzAD != null) {
            this.zzAD.zza(zzxVar);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void zza(com.google.android.gms.ads.internal.reward.client.zzd zzdVar) {
        this.zzAJ.zzAu = zzdVar;
        if (this.zzAD != null) {
            this.zzAJ.zzc(this.zzAD);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void zza(zzcf zzcfVar) throws RemoteException {
        this.zzAJ.zzAs = zzcfVar;
        if (this.zzAD != null) {
            this.zzAJ.zzc(this.zzAD);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void zza(zzgd zzgdVar) throws RemoteException {
        this.zzAJ.zzAr = zzgdVar;
        if (this.zzAD != null) {
            this.zzAJ.zzc(this.zzAD);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void zza(zzgh zzghVar, String str) throws RemoteException {
        this.zzAK = zzghVar;
        this.zzAL = str;
        zzel();
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public com.google.android.gms.dynamic.zzd zzaM() throws RemoteException {
        if (this.zzAD != null) {
            return this.zzAD.zzaM();
        }
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public AdSizeParcel zzaN() throws RemoteException {
        if (this.zzAD != null) {
            return this.zzAD.zzaN();
        }
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void zzaP() throws RemoteException {
        if (this.zzAD != null) {
            this.zzAD.zzaP();
        } else {
            zzin.zzaK("Interstitial ad must be loaded before pingManualTrackingUrl().");
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public boolean zzb(AdRequestParcel adRequestParcel) throws RemoteException {
        if (zzi(adRequestParcel)) {
            abort();
        }
        if (adRequestParcel.zztJ != null) {
            abort();
        }
        if (this.zzAD != null) {
            return this.zzAD.zzb(adRequestParcel);
        }
        zzea.zza zzaVarZza = com.google.android.gms.ads.internal.zzr.zzbN().zza(adRequestParcel, this.zzpS);
        if (zzaVarZza == null) {
            this.zzAD = this.zzAz.zzX(this.zzpS);
            this.zzAJ.zzc(this.zzAD);
            zzel();
            return this.zzAD.zzb(adRequestParcel);
        }
        if (!zzaVarZza.zzAG) {
            zzaVarZza.zzh(adRequestParcel);
        }
        this.zzAD = zzaVarZza.zzAD;
        zzaVarZza.zzc(this.zzAz);
        zzaVarZza.zzAE.zza(this.zzAJ);
        this.zzAJ.zzc(this.zzAD);
        zzel();
        return zzaVarZza.zzAH;
    }

    boolean zzi(AdRequestParcel adRequestParcel) {
        Bundle bundle;
        Bundle bundle2 = adRequestParcel.zztM;
        if (bundle2 == null || (bundle = bundle2.getBundle(AdMobAdapter.class.getCanonicalName())) == null) {
            return false;
        }
        return bundle.keySet().contains("gw");
    }
}
