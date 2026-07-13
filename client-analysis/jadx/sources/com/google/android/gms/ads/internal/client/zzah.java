package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import com.google.android.gms.internal.zzcf;
import com.google.android.gms.internal.zzgd;
import com.google.android.gms.internal.zzgh;

/* JADX INFO: loaded from: classes.dex */
public class zzah extends zzu.zza {
    private zzq zzpK;

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void destroy() {
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public String getMediationAdapterClassName() {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public boolean isLoading() {
        return false;
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public boolean isReady() {
        return false;
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void pause() {
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void resume() {
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void setManualImpressionsEnabled(boolean enabled) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void setUserId(String userId) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void showInterstitial() {
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void stopLoading() {
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void zza(AdSizeParcel adSizeParcel) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void zza(zzp zzpVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void zza(zzq zzqVar) {
        this.zzpK = zzqVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void zza(zzw zzwVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void zza(zzx zzxVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void zza(com.google.android.gms.ads.internal.reward.client.zzd zzdVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void zza(zzcf zzcfVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void zza(zzgd zzgdVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void zza(zzgh zzghVar, String str) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public com.google.android.gms.dynamic.zzd zzaM() {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public AdSizeParcel zzaN() {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void zzaP() {
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public boolean zzb(AdRequestParcel adRequestParcel) {
        com.google.android.gms.ads.internal.util.client.zzb.e("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        com.google.android.gms.ads.internal.util.client.zza.zzMS.post(new Runnable() { // from class: com.google.android.gms.ads.internal.client.zzah.1
            @Override // java.lang.Runnable
            public void run() {
                if (zzah.this.zzpK != null) {
                    try {
                        zzah.this.zzpK.onAdFailedToLoad(1);
                    } catch (RemoteException e) {
                        com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not notify onAdFailedToLoad event.", e);
                    }
                }
            }
        });
        return false;
    }
}
