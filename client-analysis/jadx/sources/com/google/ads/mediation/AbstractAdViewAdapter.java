package com.google.ads.mediation;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAdView;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.internal.client.zzn;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzka;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public abstract class AbstractAdViewAdapter implements com.google.android.gms.ads.mediation.MediationBannerAdapter, MediationNativeAdapter, MediationRewardedVideoAdAdapter, zzka {
    public static final String AD_UNIT_ID_PARAMETER = "pubid";
    protected AdView zzaQ;
    protected InterstitialAd zzaR;
    private AdLoader zzaS;
    private Context zzaT;
    private InterstitialAd zzaU;
    private MediationRewardedVideoAdListener zzaV;
    private String zzaW;
    final RewardedVideoAdListener zzaX = new RewardedVideoAdListener() { // from class: com.google.ads.mediation.AbstractAdViewAdapter.1
        @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
        public void onRewarded(RewardItem reward) {
            AbstractAdViewAdapter.this.zzaV.onRewarded(AbstractAdViewAdapter.this, reward);
        }

        @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
        public void onRewardedVideoAdClosed() {
            AbstractAdViewAdapter.this.zzaV.onAdClosed(AbstractAdViewAdapter.this);
            AbstractAdViewAdapter.this.zzaU = null;
        }

        @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
        public void onRewardedVideoAdFailedToLoad(int errorCode) {
            AbstractAdViewAdapter.this.zzaV.onAdFailedToLoad(AbstractAdViewAdapter.this, errorCode);
        }

        @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
        public void onRewardedVideoAdLeftApplication() {
            AbstractAdViewAdapter.this.zzaV.onAdLeftApplication(AbstractAdViewAdapter.this);
        }

        @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
        public void onRewardedVideoAdLoaded() {
            AbstractAdViewAdapter.this.zzaV.onAdLoaded(AbstractAdViewAdapter.this);
        }

        @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
        public void onRewardedVideoAdOpened() {
            AbstractAdViewAdapter.this.zzaV.onAdOpened(AbstractAdViewAdapter.this);
        }

        @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
        public void onRewardedVideoStarted() {
            AbstractAdViewAdapter.this.zzaV.onVideoStarted(AbstractAdViewAdapter.this);
        }
    };

    static class zza extends NativeAppInstallAdMapper {
        private final NativeAppInstallAd zzaZ;

        public zza(NativeAppInstallAd nativeAppInstallAd) {
            this.zzaZ = nativeAppInstallAd;
            setHeadline(nativeAppInstallAd.getHeadline().toString());
            setImages(nativeAppInstallAd.getImages());
            setBody(nativeAppInstallAd.getBody().toString());
            setIcon(nativeAppInstallAd.getIcon());
            setCallToAction(nativeAppInstallAd.getCallToAction().toString());
            setStarRating(nativeAppInstallAd.getStarRating().doubleValue());
            setStore(nativeAppInstallAd.getStore().toString());
            setPrice(nativeAppInstallAd.getPrice().toString());
            setOverrideImpressionRecording(true);
            setOverrideClickHandling(true);
        }

        @Override // com.google.android.gms.ads.mediation.NativeAdMapper
        public void trackView(View view) {
            if (view instanceof NativeAdView) {
                ((NativeAdView) view).setNativeAd(this.zzaZ);
            }
        }
    }

    static class zzb extends NativeContentAdMapper {
        private final NativeContentAd zzba;

        public zzb(NativeContentAd nativeContentAd) {
            this.zzba = nativeContentAd;
            setHeadline(nativeContentAd.getHeadline().toString());
            setImages(nativeContentAd.getImages());
            setBody(nativeContentAd.getBody().toString());
            setLogo(nativeContentAd.getLogo());
            setCallToAction(nativeContentAd.getCallToAction().toString());
            setAdvertiser(nativeContentAd.getAdvertiser().toString());
            setOverrideImpressionRecording(true);
            setOverrideClickHandling(true);
        }

        @Override // com.google.android.gms.ads.mediation.NativeAdMapper
        public void trackView(View view) {
            if (view instanceof NativeAdView) {
                ((NativeAdView) view).setNativeAd(this.zzba);
            }
        }
    }

    static final class zzc extends AdListener implements com.google.android.gms.ads.internal.client.zza {
        final AbstractAdViewAdapter zzbb;
        final com.google.android.gms.ads.mediation.MediationBannerListener zzbc;

        public zzc(AbstractAdViewAdapter abstractAdViewAdapter, com.google.android.gms.ads.mediation.MediationBannerListener mediationBannerListener) {
            this.zzbb = abstractAdViewAdapter;
            this.zzbc = mediationBannerListener;
        }

        @Override // com.google.android.gms.ads.internal.client.zza
        public void onAdClicked() {
            this.zzbc.onAdClicked(this.zzbb);
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdClosed() {
            this.zzbc.onAdClosed(this.zzbb);
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdFailedToLoad(int errorCode) {
            this.zzbc.onAdFailedToLoad(this.zzbb, errorCode);
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdLeftApplication() {
            this.zzbc.onAdLeftApplication(this.zzbb);
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdLoaded() {
            this.zzbc.onAdLoaded(this.zzbb);
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdOpened() {
            this.zzbc.onAdOpened(this.zzbb);
        }
    }

    static final class zzd extends AdListener implements com.google.android.gms.ads.internal.client.zza {
        final AbstractAdViewAdapter zzbb;
        final com.google.android.gms.ads.mediation.MediationInterstitialListener zzbd;

        public zzd(AbstractAdViewAdapter abstractAdViewAdapter, com.google.android.gms.ads.mediation.MediationInterstitialListener mediationInterstitialListener) {
            this.zzbb = abstractAdViewAdapter;
            this.zzbd = mediationInterstitialListener;
        }

        @Override // com.google.android.gms.ads.internal.client.zza
        public void onAdClicked() {
            this.zzbd.onAdClicked(this.zzbb);
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdClosed() {
            this.zzbd.onAdClosed(this.zzbb);
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdFailedToLoad(int errorCode) {
            this.zzbd.onAdFailedToLoad(this.zzbb, errorCode);
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdLeftApplication() {
            this.zzbd.onAdLeftApplication(this.zzbb);
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdLoaded() {
            this.zzbd.onAdLoaded(this.zzbb);
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdOpened() {
            this.zzbd.onAdOpened(this.zzbb);
        }
    }

    static final class zze extends AdListener implements NativeAppInstallAd.OnAppInstallAdLoadedListener, NativeContentAd.OnContentAdLoadedListener, com.google.android.gms.ads.internal.client.zza {
        final AbstractAdViewAdapter zzbb;
        final MediationNativeListener zzbe;

        public zze(AbstractAdViewAdapter abstractAdViewAdapter, MediationNativeListener mediationNativeListener) {
            this.zzbb = abstractAdViewAdapter;
            this.zzbe = mediationNativeListener;
        }

        @Override // com.google.android.gms.ads.internal.client.zza
        public void onAdClicked() {
            this.zzbe.onAdClicked(this.zzbb);
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdClosed() {
            this.zzbe.onAdClosed(this.zzbb);
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdFailedToLoad(int errorCode) {
            this.zzbe.onAdFailedToLoad(this.zzbb, errorCode);
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdLeftApplication() {
            this.zzbe.onAdLeftApplication(this.zzbb);
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdLoaded() {
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdOpened() {
            this.zzbe.onAdOpened(this.zzbb);
        }

        @Override // com.google.android.gms.ads.formats.NativeAppInstallAd.OnAppInstallAdLoadedListener
        public void onAppInstallAdLoaded(NativeAppInstallAd ad) {
            this.zzbe.onAdLoaded(this.zzbb, new zza(ad));
        }

        @Override // com.google.android.gms.ads.formats.NativeContentAd.OnContentAdLoadedListener
        public void onContentAdLoaded(NativeContentAd ad) {
            this.zzbe.onAdLoaded(this.zzbb, new zzb(ad));
        }
    }

    public String getAdUnitId(Bundle serverParameters) {
        return serverParameters.getString(AD_UNIT_ID_PARAMETER);
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAdapter
    public View getBannerView() {
        return this.zzaQ;
    }

    @Override // com.google.android.gms.internal.zzka
    public Bundle getInterstitialAdapterInfo() {
        return new com.google.android.gms.ads.mediation.MediationAdapter.zza().zzS(1).zziw();
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter
    public void initialize(Context context, com.google.android.gms.ads.mediation.MediationAdRequest mediationAdRequest, String userId, MediationRewardedVideoAdListener listener, Bundle serverParameters, Bundle networkExtras) {
        this.zzaT = context.getApplicationContext();
        this.zzaW = userId;
        this.zzaV = listener;
        this.zzaV.onInitializationSucceeded(this);
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter
    public boolean isInitialized() {
        return this.zzaV != null;
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter
    public void loadAd(com.google.android.gms.ads.mediation.MediationAdRequest mediationAdRequest, Bundle serverParameters, Bundle networkExtras) {
        if (this.zzaT == null || this.zzaV == null) {
            zzin.e("AdMobAdapter.loadAd called before initialize.");
            return;
        }
        this.zzaU = new InterstitialAd(this.zzaT);
        this.zzaU.zza(true);
        this.zzaU.setAdUnitId(getAdUnitId(serverParameters));
        this.zzaU.setRewardedVideoAdListener(this.zzaX);
        this.zzaU.zzm(this.zzaW);
        this.zzaU.loadAd(zza(this.zzaT, mediationAdRequest, networkExtras, serverParameters));
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public void onDestroy() {
        if (this.zzaQ != null) {
            this.zzaQ.destroy();
            this.zzaQ = null;
        }
        if (this.zzaR != null) {
            this.zzaR = null;
        }
        if (this.zzaS != null) {
            this.zzaS = null;
        }
        if (this.zzaU != null) {
            this.zzaU = null;
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public void onPause() {
        if (this.zzaQ != null) {
            this.zzaQ.pause();
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public void onResume() {
        if (this.zzaQ != null) {
            this.zzaQ.resume();
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAdapter
    public void requestBannerAd(Context context, com.google.android.gms.ads.mediation.MediationBannerListener bannerListener, Bundle serverParameters, AdSize adSize, com.google.android.gms.ads.mediation.MediationAdRequest mediationAdRequest, Bundle extras) {
        this.zzaQ = new AdView(context);
        this.zzaQ.setAdSize(new AdSize(adSize.getWidth(), adSize.getHeight()));
        this.zzaQ.setAdUnitId(getAdUnitId(serverParameters));
        this.zzaQ.setAdListener(new zzc(this, bannerListener));
        this.zzaQ.loadAd(zza(context, mediationAdRequest, extras, serverParameters));
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public void requestInterstitialAd(Context context, com.google.android.gms.ads.mediation.MediationInterstitialListener interstitialListener, Bundle serverParameters, com.google.android.gms.ads.mediation.MediationAdRequest mediationAdRequest, Bundle extras) {
        this.zzaR = new InterstitialAd(context);
        this.zzaR.setAdUnitId(getAdUnitId(serverParameters));
        this.zzaR.setAdListener(new zzd(this, interstitialListener));
        this.zzaR.loadAd(zza(context, mediationAdRequest, extras, serverParameters));
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeAdapter
    public void requestNativeAd(Context context, MediationNativeListener listener, Bundle serverParameters, NativeMediationAdRequest mediationAdRequest, Bundle extras) {
        zze zzeVar = new zze(this, listener);
        AdLoader.Builder builderWithAdListener = zza(context, serverParameters.getString(AD_UNIT_ID_PARAMETER)).withAdListener(zzeVar);
        NativeAdOptions nativeAdOptions = mediationAdRequest.getNativeAdOptions();
        if (nativeAdOptions != null) {
            builderWithAdListener.withNativeAdOptions(nativeAdOptions);
        }
        if (mediationAdRequest.isAppInstallAdRequested()) {
            builderWithAdListener.forAppInstallAd(zzeVar);
        }
        if (mediationAdRequest.isContentAdRequested()) {
            builderWithAdListener.forContentAd(zzeVar);
        }
        this.zzaS = builderWithAdListener.build();
        this.zzaS.loadAd(zza(context, mediationAdRequest, extras, serverParameters));
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public void showInterstitial() {
        this.zzaR.show();
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter
    public void showVideo() {
        this.zzaU.show();
    }

    protected abstract Bundle zza(Bundle bundle, Bundle bundle2);

    AdLoader.Builder zza(Context context, String str) {
        return new AdLoader.Builder(context, str);
    }

    AdRequest zza(Context context, com.google.android.gms.ads.mediation.MediationAdRequest mediationAdRequest, Bundle bundle, Bundle bundle2) {
        AdRequest.Builder builder = new AdRequest.Builder();
        Date birthday = mediationAdRequest.getBirthday();
        if (birthday != null) {
            builder.setBirthday(birthday);
        }
        int gender = mediationAdRequest.getGender();
        if (gender != 0) {
            builder.setGender(gender);
        }
        Set<String> keywords = mediationAdRequest.getKeywords();
        if (keywords != null) {
            Iterator<String> it = keywords.iterator();
            while (it.hasNext()) {
                builder.addKeyword(it.next());
            }
        }
        Location location = mediationAdRequest.getLocation();
        if (location != null) {
            builder.setLocation(location);
        }
        if (mediationAdRequest.isTesting()) {
            builder.addTestDevice(zzn.zzcS().zzT(context));
        }
        if (mediationAdRequest.taggedForChildDirectedTreatment() != -1) {
            builder.tagForChildDirectedTreatment(mediationAdRequest.taggedForChildDirectedTreatment() == 1);
        }
        builder.setIsDesignedForFamilies(mediationAdRequest.isDesignedForFamilies());
        builder.addNetworkExtrasBundle(AdMobAdapter.class, zza(bundle, bundle2));
        return builder.build();
    }
}
