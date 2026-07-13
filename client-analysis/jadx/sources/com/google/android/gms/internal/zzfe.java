package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public final class zzfe extends zzey.zza {
    private final MediationAdapter zzCI;
    private zzff zzCJ;

    public zzfe(MediationAdapter mediationAdapter) {
        this.zzCI = mediationAdapter;
    }

    private Bundle zza(String str, int i, String str2) throws RemoteException {
        com.google.android.gms.ads.internal.util.client.zzb.zzaK("Server parameters: " + str);
        try {
            Bundle bundle = new Bundle();
            if (str != null) {
                JSONObject jSONObject = new JSONObject(str);
                Bundle bundle2 = new Bundle();
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    bundle2.putString(next, jSONObject.getString(next));
                }
                bundle = bundle2;
            }
            if (this.zzCI instanceof AdMobAdapter) {
                bundle.putString("adJson", str2);
                bundle.putInt("tagForChildDirectedTreatment", i);
            }
            return bundle;
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not get Server Parameters Bundle.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzey
    public void destroy() throws RemoteException {
        try {
            this.zzCI.onDestroy();
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not destroy adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzey
    public Bundle getInterstitialAdapterInfo() {
        if (this.zzCI instanceof zzka) {
            return ((zzka) this.zzCI).getInterstitialAdapterInfo();
        }
        com.google.android.gms.ads.internal.util.client.zzb.zzaK("MediationAdapter is not a v2 MediationInterstitialAdapter: " + this.zzCI.getClass().getCanonicalName());
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.zzey
    public com.google.android.gms.dynamic.zzd getView() throws RemoteException {
        if (!(this.zzCI instanceof MediationBannerAdapter)) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaK("MediationAdapter is not a MediationBannerAdapter: " + this.zzCI.getClass().getCanonicalName());
            throw new RemoteException();
        }
        try {
            return com.google.android.gms.dynamic.zze.zzC(((MediationBannerAdapter) this.zzCI).getBannerView());
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not get banner view from adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzey
    public boolean isInitialized() throws RemoteException {
        if (!(this.zzCI instanceof MediationRewardedVideoAdAdapter)) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaK("MediationAdapter is not a MediationRewardedVideoAdAdapter: " + this.zzCI.getClass().getCanonicalName());
            throw new RemoteException();
        }
        com.google.android.gms.ads.internal.util.client.zzb.zzaI("Check if adapter is initialized.");
        try {
            return ((MediationRewardedVideoAdAdapter) this.zzCI).isInitialized();
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not check if adapter is initialized.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzey
    public void pause() throws RemoteException {
        try {
            this.zzCI.onPause();
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not pause adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzey
    public void resume() throws RemoteException {
        try {
            this.zzCI.onResume();
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not resume adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzey
    public void showInterstitial() throws RemoteException {
        if (!(this.zzCI instanceof MediationInterstitialAdapter)) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaK("MediationAdapter is not a MediationInterstitialAdapter: " + this.zzCI.getClass().getCanonicalName());
            throw new RemoteException();
        }
        com.google.android.gms.ads.internal.util.client.zzb.zzaI("Showing interstitial from adapter.");
        try {
            ((MediationInterstitialAdapter) this.zzCI).showInterstitial();
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not show interstitial from adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzey
    public void showVideo() throws RemoteException {
        if (!(this.zzCI instanceof MediationRewardedVideoAdAdapter)) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaK("MediationAdapter is not a MediationRewardedVideoAdAdapter: " + this.zzCI.getClass().getCanonicalName());
            throw new RemoteException();
        }
        com.google.android.gms.ads.internal.util.client.zzb.zzaI("Show rewarded video ad from adapter.");
        try {
            ((MediationRewardedVideoAdAdapter) this.zzCI).showVideo();
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not show rewarded video ad from adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzey
    public void zza(AdRequestParcel adRequestParcel, String str, String str2) throws RemoteException {
        if (!(this.zzCI instanceof MediationRewardedVideoAdAdapter)) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaK("MediationAdapter is not a MediationRewardedVideoAdAdapter: " + this.zzCI.getClass().getCanonicalName());
            throw new RemoteException();
        }
        com.google.android.gms.ads.internal.util.client.zzb.zzaI("Requesting rewarded video ad from adapter.");
        try {
            MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter = (MediationRewardedVideoAdAdapter) this.zzCI;
            mediationRewardedVideoAdAdapter.loadAd(new zzfd(adRequestParcel.zztC == -1 ? null : new Date(adRequestParcel.zztC), adRequestParcel.zztD, adRequestParcel.zztE != null ? new HashSet(adRequestParcel.zztE) : null, adRequestParcel.zztK, adRequestParcel.zztF, adRequestParcel.zztG, adRequestParcel.zztR), zza(str, adRequestParcel.zztG, str2), adRequestParcel.zztM != null ? adRequestParcel.zztM.getBundle(mediationRewardedVideoAdAdapter.getClass().getName()) : null);
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not load rewarded video ad from adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzey
    public void zza(com.google.android.gms.dynamic.zzd zzdVar, AdRequestParcel adRequestParcel, String str, com.google.android.gms.ads.internal.reward.mediation.client.zza zzaVar, String str2) throws RemoteException {
        if (!(this.zzCI instanceof MediationRewardedVideoAdAdapter)) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaK("MediationAdapter is not a MediationRewardedVideoAdAdapter: " + this.zzCI.getClass().getCanonicalName());
            throw new RemoteException();
        }
        com.google.android.gms.ads.internal.util.client.zzb.zzaI("Initialize rewarded video adapter.");
        try {
            MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter = (MediationRewardedVideoAdAdapter) this.zzCI;
            mediationRewardedVideoAdAdapter.initialize((Context) com.google.android.gms.dynamic.zze.zzp(zzdVar), new zzfd(adRequestParcel.zztC == -1 ? null : new Date(adRequestParcel.zztC), adRequestParcel.zztD, adRequestParcel.zztE != null ? new HashSet(adRequestParcel.zztE) : null, adRequestParcel.zztK, adRequestParcel.zztF, adRequestParcel.zztG, adRequestParcel.zztR), str, new com.google.android.gms.ads.internal.reward.mediation.client.zzb(zzaVar), zza(str2, adRequestParcel.zztG, (String) null), adRequestParcel.zztM != null ? adRequestParcel.zztM.getBundle(mediationRewardedVideoAdAdapter.getClass().getName()) : null);
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not initialize rewarded video adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzey
    public void zza(com.google.android.gms.dynamic.zzd zzdVar, AdRequestParcel adRequestParcel, String str, zzez zzezVar) throws RemoteException {
        zza(zzdVar, adRequestParcel, str, (String) null, zzezVar);
    }

    @Override // com.google.android.gms.internal.zzey
    public void zza(com.google.android.gms.dynamic.zzd zzdVar, AdRequestParcel adRequestParcel, String str, String str2, zzez zzezVar) throws RemoteException {
        if (!(this.zzCI instanceof MediationInterstitialAdapter)) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaK("MediationAdapter is not a MediationInterstitialAdapter: " + this.zzCI.getClass().getCanonicalName());
            throw new RemoteException();
        }
        com.google.android.gms.ads.internal.util.client.zzb.zzaI("Requesting interstitial ad from adapter.");
        try {
            MediationInterstitialAdapter mediationInterstitialAdapter = (MediationInterstitialAdapter) this.zzCI;
            mediationInterstitialAdapter.requestInterstitialAd((Context) com.google.android.gms.dynamic.zze.zzp(zzdVar), new zzff(zzezVar), zza(str, adRequestParcel.zztG, str2), new zzfd(adRequestParcel.zztC == -1 ? null : new Date(adRequestParcel.zztC), adRequestParcel.zztD, adRequestParcel.zztE != null ? new HashSet(adRequestParcel.zztE) : null, adRequestParcel.zztK, adRequestParcel.zztF, adRequestParcel.zztG, adRequestParcel.zztR), adRequestParcel.zztM != null ? adRequestParcel.zztM.getBundle(mediationInterstitialAdapter.getClass().getName()) : null);
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not request interstitial ad from adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzey
    public void zza(com.google.android.gms.dynamic.zzd zzdVar, AdRequestParcel adRequestParcel, String str, String str2, zzez zzezVar, NativeAdOptionsParcel nativeAdOptionsParcel, List<String> list) throws RemoteException {
        if (!(this.zzCI instanceof MediationNativeAdapter)) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaK("MediationAdapter is not a MediationNativeAdapter: " + this.zzCI.getClass().getCanonicalName());
            throw new RemoteException();
        }
        try {
            MediationNativeAdapter mediationNativeAdapter = (MediationNativeAdapter) this.zzCI;
            zzfi zzfiVar = new zzfi(adRequestParcel.zztC == -1 ? null : new Date(adRequestParcel.zztC), adRequestParcel.zztD, adRequestParcel.zztE != null ? new HashSet(adRequestParcel.zztE) : null, adRequestParcel.zztK, adRequestParcel.zztF, adRequestParcel.zztG, nativeAdOptionsParcel, list, adRequestParcel.zztR);
            Bundle bundle = adRequestParcel.zztM != null ? adRequestParcel.zztM.getBundle(mediationNativeAdapter.getClass().getName()) : null;
            this.zzCJ = new zzff(zzezVar);
            mediationNativeAdapter.requestNativeAd((Context) com.google.android.gms.dynamic.zze.zzp(zzdVar), this.zzCJ, zza(str, adRequestParcel.zztG, str2), zzfiVar, bundle);
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not request native ad from adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzey
    public void zza(com.google.android.gms.dynamic.zzd zzdVar, AdSizeParcel adSizeParcel, AdRequestParcel adRequestParcel, String str, zzez zzezVar) throws RemoteException {
        zza(zzdVar, adSizeParcel, adRequestParcel, str, null, zzezVar);
    }

    @Override // com.google.android.gms.internal.zzey
    public void zza(com.google.android.gms.dynamic.zzd zzdVar, AdSizeParcel adSizeParcel, AdRequestParcel adRequestParcel, String str, String str2, zzez zzezVar) throws RemoteException {
        if (!(this.zzCI instanceof MediationBannerAdapter)) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaK("MediationAdapter is not a MediationBannerAdapter: " + this.zzCI.getClass().getCanonicalName());
            throw new RemoteException();
        }
        com.google.android.gms.ads.internal.util.client.zzb.zzaI("Requesting banner ad from adapter.");
        try {
            MediationBannerAdapter mediationBannerAdapter = (MediationBannerAdapter) this.zzCI;
            mediationBannerAdapter.requestBannerAd((Context) com.google.android.gms.dynamic.zze.zzp(zzdVar), new zzff(zzezVar), zza(str, adRequestParcel.zztG, str2), com.google.android.gms.ads.zza.zza(adSizeParcel.width, adSizeParcel.height, adSizeParcel.zzuh), new zzfd(adRequestParcel.zztC == -1 ? null : new Date(adRequestParcel.zztC), adRequestParcel.zztD, adRequestParcel.zztE != null ? new HashSet(adRequestParcel.zztE) : null, adRequestParcel.zztK, adRequestParcel.zztF, adRequestParcel.zztG, adRequestParcel.zztR), adRequestParcel.zztM != null ? adRequestParcel.zztM.getBundle(mediationBannerAdapter.getClass().getName()) : null);
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not request banner ad from adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzey
    public void zzb(AdRequestParcel adRequestParcel, String str) throws RemoteException {
        zza(adRequestParcel, str, (String) null);
    }

    @Override // com.google.android.gms.internal.zzey
    public zzfb zzeF() {
        NativeAdMapper nativeAdMapperZzeJ = this.zzCJ.zzeJ();
        if (nativeAdMapperZzeJ instanceof NativeAppInstallAdMapper) {
            return new zzfg((NativeAppInstallAdMapper) nativeAdMapperZzeJ);
        }
        return null;
    }

    @Override // com.google.android.gms.internal.zzey
    public zzfc zzeG() {
        NativeAdMapper nativeAdMapperZzeJ = this.zzCJ.zzeJ();
        if (nativeAdMapperZzeJ instanceof NativeContentAdMapper) {
            return new zzfh((NativeContentAdMapper) nativeAdMapperZzeJ);
        }
        return null;
    }

    @Override // com.google.android.gms.internal.zzey
    public Bundle zzeH() {
        if (this.zzCI instanceof zzjz) {
            return ((zzjz) this.zzCI).zzeH();
        }
        com.google.android.gms.ads.internal.util.client.zzb.zzaK("MediationAdapter is not a v2 MediationBannerAdapter: " + this.zzCI.getClass().getCanonicalName());
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.zzey
    public Bundle zzeI() {
        return new Bundle();
    }
}
