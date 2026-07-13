package com.google.ads.mediation.customevent;

import android.app.Activity;
import android.view.View;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.customevent.CustomEventExtras;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.internal.zzin;

/* JADX INFO: loaded from: classes.dex */
@KeepName
public final class CustomEventAdapter implements MediationBannerAdapter<CustomEventExtras, CustomEventServerParameters>, MediationInterstitialAdapter<CustomEventExtras, CustomEventServerParameters> {
    private View zzbk;
    CustomEventBanner zzbl;
    CustomEventInterstitial zzbm;

    static final class zza implements CustomEventBannerListener {
        private final CustomEventAdapter zzbn;
        private final MediationBannerListener zzbo;

        public zza(CustomEventAdapter customEventAdapter, MediationBannerListener mediationBannerListener) {
            this.zzbn = customEventAdapter;
            this.zzbo = mediationBannerListener;
        }

        @Override // com.google.ads.mediation.customevent.CustomEventBannerListener
        public void onClick() {
            zzin.zzaI("Custom event adapter called onFailedToReceiveAd.");
            this.zzbo.onClick(this.zzbn);
        }

        @Override // com.google.ads.mediation.customevent.CustomEventListener
        public void onDismissScreen() {
            zzin.zzaI("Custom event adapter called onFailedToReceiveAd.");
            this.zzbo.onDismissScreen(this.zzbn);
        }

        @Override // com.google.ads.mediation.customevent.CustomEventListener
        public void onFailedToReceiveAd() {
            zzin.zzaI("Custom event adapter called onFailedToReceiveAd.");
            this.zzbo.onFailedToReceiveAd(this.zzbn, AdRequest.ErrorCode.NO_FILL);
        }

        @Override // com.google.ads.mediation.customevent.CustomEventListener
        public void onLeaveApplication() {
            zzin.zzaI("Custom event adapter called onFailedToReceiveAd.");
            this.zzbo.onLeaveApplication(this.zzbn);
        }

        @Override // com.google.ads.mediation.customevent.CustomEventListener
        public void onPresentScreen() {
            zzin.zzaI("Custom event adapter called onFailedToReceiveAd.");
            this.zzbo.onPresentScreen(this.zzbn);
        }

        @Override // com.google.ads.mediation.customevent.CustomEventBannerListener
        public void onReceivedAd(View view) {
            zzin.zzaI("Custom event adapter called onReceivedAd.");
            this.zzbn.zza(view);
            this.zzbo.onReceivedAd(this.zzbn);
        }
    }

    class zzb implements CustomEventInterstitialListener {
        private final CustomEventAdapter zzbn;
        private final MediationInterstitialListener zzbp;

        public zzb(CustomEventAdapter customEventAdapter, MediationInterstitialListener mediationInterstitialListener) {
            this.zzbn = customEventAdapter;
            this.zzbp = mediationInterstitialListener;
        }

        @Override // com.google.ads.mediation.customevent.CustomEventListener
        public void onDismissScreen() {
            zzin.zzaI("Custom event adapter called onDismissScreen.");
            this.zzbp.onDismissScreen(this.zzbn);
        }

        @Override // com.google.ads.mediation.customevent.CustomEventListener
        public void onFailedToReceiveAd() {
            zzin.zzaI("Custom event adapter called onFailedToReceiveAd.");
            this.zzbp.onFailedToReceiveAd(this.zzbn, AdRequest.ErrorCode.NO_FILL);
        }

        @Override // com.google.ads.mediation.customevent.CustomEventListener
        public void onLeaveApplication() {
            zzin.zzaI("Custom event adapter called onLeaveApplication.");
            this.zzbp.onLeaveApplication(this.zzbn);
        }

        @Override // com.google.ads.mediation.customevent.CustomEventListener
        public void onPresentScreen() {
            zzin.zzaI("Custom event adapter called onPresentScreen.");
            this.zzbp.onPresentScreen(this.zzbn);
        }

        @Override // com.google.ads.mediation.customevent.CustomEventInterstitialListener
        public void onReceivedAd() {
            zzin.zzaI("Custom event adapter called onReceivedAd.");
            this.zzbp.onReceivedAd(CustomEventAdapter.this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zza(View view) {
        this.zzbk = view;
    }

    private static <T> T zzj(String str) {
        try {
            return (T) Class.forName(str).newInstance();
        } catch (Throwable th) {
            zzin.zzaK("Could not instantiate custom event adapter: " + str + ". " + th.getMessage());
            return null;
        }
    }

    @Override // com.google.ads.mediation.MediationAdapter
    public void destroy() {
        if (this.zzbl != null) {
            this.zzbl.destroy();
        }
        if (this.zzbm != null) {
            this.zzbm.destroy();
        }
    }

    @Override // com.google.ads.mediation.MediationAdapter
    public Class<CustomEventExtras> getAdditionalParametersType() {
        return CustomEventExtras.class;
    }

    @Override // com.google.ads.mediation.MediationBannerAdapter
    public View getBannerView() {
        return this.zzbk;
    }

    @Override // com.google.ads.mediation.MediationAdapter
    public Class<CustomEventServerParameters> getServerParametersType() {
        return CustomEventServerParameters.class;
    }

    @Override // com.google.ads.mediation.MediationBannerAdapter
    public void requestBannerAd(MediationBannerListener listener, Activity activity, CustomEventServerParameters serverParameters, AdSize adSize, MediationAdRequest mediationAdRequest, CustomEventExtras customEventExtras) {
        this.zzbl = (CustomEventBanner) zzj(serverParameters.className);
        if (this.zzbl == null) {
            listener.onFailedToReceiveAd(this, AdRequest.ErrorCode.INTERNAL_ERROR);
        } else {
            this.zzbl.requestBannerAd(new zza(this, listener), activity, serverParameters.label, serverParameters.parameter, adSize, mediationAdRequest, customEventExtras == null ? null : customEventExtras.getExtra(serverParameters.label));
        }
    }

    @Override // com.google.ads.mediation.MediationInterstitialAdapter
    public void requestInterstitialAd(MediationInterstitialListener listener, Activity activity, CustomEventServerParameters serverParameters, MediationAdRequest mediationAdRequest, CustomEventExtras customEventExtras) {
        this.zzbm = (CustomEventInterstitial) zzj(serverParameters.className);
        if (this.zzbm == null) {
            listener.onFailedToReceiveAd(this, AdRequest.ErrorCode.INTERNAL_ERROR);
        } else {
            this.zzbm.requestInterstitialAd(zza(listener), activity, serverParameters.label, serverParameters.parameter, mediationAdRequest, customEventExtras == null ? null : customEventExtras.getExtra(serverParameters.label));
        }
    }

    @Override // com.google.ads.mediation.MediationInterstitialAdapter
    public void showInterstitial() {
        this.zzbm.showInterstitial();
    }

    zzb zza(MediationInterstitialListener mediationInterstitialListener) {
        return new zzb(this, mediationInterstitialListener);
    }
}
