package com.google.android.gms.internal;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public final class zzfj<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> extends zzey.zza {
    private final MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> zzCO;
    private final NETWORK_EXTRAS zzCP;

    public zzfj(MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter, NETWORK_EXTRAS network_extras) {
        this.zzCO = mediationAdapter;
        this.zzCP = network_extras;
    }

    private SERVER_PARAMETERS zzb(String str, int i, String str2) throws RemoteException {
        HashMap map;
        try {
            if (str != null) {
                JSONObject jSONObject = new JSONObject(str);
                map = new HashMap(jSONObject.length());
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    map.put(next, jSONObject.getString(next));
                }
            } else {
                map = new HashMap(0);
            }
            Class<SERVER_PARAMETERS> serverParametersType = this.zzCO.getServerParametersType();
            if (serverParametersType == null) {
                return null;
            }
            SERVER_PARAMETERS server_parametersNewInstance = serverParametersType.newInstance();
            server_parametersNewInstance.load(map);
            return server_parametersNewInstance;
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not get MediationServerParameters.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzey
    public void destroy() throws RemoteException {
        try {
            this.zzCO.destroy();
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not destroy adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzey
    public Bundle getInterstitialAdapterInfo() {
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.zzey
    public com.google.android.gms.dynamic.zzd getView() throws RemoteException {
        if (!(this.zzCO instanceof MediationBannerAdapter)) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaK("MediationAdapter is not a MediationBannerAdapter: " + this.zzCO.getClass().getCanonicalName());
            throw new RemoteException();
        }
        try {
            return com.google.android.gms.dynamic.zze.zzC(((MediationBannerAdapter) this.zzCO).getBannerView());
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not get banner view from adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzey
    public boolean isInitialized() {
        return true;
    }

    @Override // com.google.android.gms.internal.zzey
    public void pause() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.zzey
    public void resume() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.zzey
    public void showInterstitial() throws RemoteException {
        if (!(this.zzCO instanceof MediationInterstitialAdapter)) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaK("MediationAdapter is not a MediationInterstitialAdapter: " + this.zzCO.getClass().getCanonicalName());
            throw new RemoteException();
        }
        com.google.android.gms.ads.internal.util.client.zzb.zzaI("Showing interstitial from adapter.");
        try {
            ((MediationInterstitialAdapter) this.zzCO).showInterstitial();
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not show interstitial from adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzey
    public void showVideo() {
    }

    @Override // com.google.android.gms.internal.zzey
    public void zza(AdRequestParcel adRequestParcel, String str, String str2) {
    }

    @Override // com.google.android.gms.internal.zzey
    public void zza(com.google.android.gms.dynamic.zzd zzdVar, AdRequestParcel adRequestParcel, String str, com.google.android.gms.ads.internal.reward.mediation.client.zza zzaVar, String str2) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.zzey
    public void zza(com.google.android.gms.dynamic.zzd zzdVar, AdRequestParcel adRequestParcel, String str, zzez zzezVar) throws RemoteException {
        zza(zzdVar, adRequestParcel, str, (String) null, zzezVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.zzey
    public void zza(com.google.android.gms.dynamic.zzd zzdVar, AdRequestParcel adRequestParcel, String str, String str2, zzez zzezVar) throws RemoteException {
        if (!(this.zzCO instanceof MediationInterstitialAdapter)) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaK("MediationAdapter is not a MediationInterstitialAdapter: " + this.zzCO.getClass().getCanonicalName());
            throw new RemoteException();
        }
        com.google.android.gms.ads.internal.util.client.zzb.zzaI("Requesting interstitial ad from adapter.");
        try {
            ((MediationInterstitialAdapter) this.zzCO).requestInterstitialAd(new zzfk(zzezVar), (Activity) com.google.android.gms.dynamic.zze.zzp(zzdVar), zzb(str, adRequestParcel.zztG, str2), zzfl.zzj(adRequestParcel), this.zzCP);
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not request interstitial ad from adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzey
    public void zza(com.google.android.gms.dynamic.zzd zzdVar, AdRequestParcel adRequestParcel, String str, String str2, zzez zzezVar, NativeAdOptionsParcel nativeAdOptionsParcel, List<String> list) {
    }

    @Override // com.google.android.gms.internal.zzey
    public void zza(com.google.android.gms.dynamic.zzd zzdVar, AdSizeParcel adSizeParcel, AdRequestParcel adRequestParcel, String str, zzez zzezVar) throws RemoteException {
        zza(zzdVar, adSizeParcel, adRequestParcel, str, null, zzezVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.zzey
    public void zza(com.google.android.gms.dynamic.zzd zzdVar, AdSizeParcel adSizeParcel, AdRequestParcel adRequestParcel, String str, String str2, zzez zzezVar) throws RemoteException {
        if (!(this.zzCO instanceof MediationBannerAdapter)) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaK("MediationAdapter is not a MediationBannerAdapter: " + this.zzCO.getClass().getCanonicalName());
            throw new RemoteException();
        }
        com.google.android.gms.ads.internal.util.client.zzb.zzaI("Requesting banner ad from adapter.");
        try {
            ((MediationBannerAdapter) this.zzCO).requestBannerAd(new zzfk(zzezVar), (Activity) com.google.android.gms.dynamic.zze.zzp(zzdVar), zzb(str, adRequestParcel.zztG, str2), zzfl.zzb(adSizeParcel), zzfl.zzj(adRequestParcel), this.zzCP);
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not request banner ad from adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzey
    public void zzb(AdRequestParcel adRequestParcel, String str) {
    }

    @Override // com.google.android.gms.internal.zzey
    public zzfb zzeF() {
        return null;
    }

    @Override // com.google.android.gms.internal.zzey
    public zzfc zzeG() {
        return null;
    }

    @Override // com.google.android.gms.internal.zzey
    public Bundle zzeH() {
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.zzey
    public Bundle zzeI() {
        return new Bundle();
    }
}
