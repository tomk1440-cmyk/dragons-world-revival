package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzu;
import com.google.android.gms.ads.internal.client.zzy;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.zzbt;
import com.google.android.gms.internal.zzcj;
import com.google.android.gms.internal.zzeb;
import com.google.android.gms.internal.zzew;
import com.google.android.gms.internal.zzfv;
import com.google.android.gms.internal.zzge;
import com.google.android.gms.internal.zzhs;

/* JADX INFO: loaded from: classes.dex */
public class ClientApi implements com.google.android.gms.ads.internal.client.zzm {
    public static void retainReference() {
        com.google.android.gms.ads.internal.client.zzl.zzuq = ClientApi.class.getName();
    }

    @Override // com.google.android.gms.ads.internal.client.zzm
    public com.google.android.gms.ads.internal.client.zzs createAdLoaderBuilder(Context context, String adUnitId, zzew adapterCreator, VersionInfoParcel versionInfo) {
        return new zzj(context, adUnitId, adapterCreator, versionInfo, zzd.zzbg());
    }

    @Override // com.google.android.gms.ads.internal.client.zzm
    public zzfv createAdOverlay(Activity activity) {
        return new com.google.android.gms.ads.internal.overlay.zzd(activity);
    }

    @Override // com.google.android.gms.ads.internal.client.zzm
    public zzu createBannerAdManager(Context context, AdSizeParcel adSize, String adUnitId, zzew adapterCreator, VersionInfoParcel versionInfo) {
        return new zzf(context, adSize, adUnitId, adapterCreator, versionInfo, zzd.zzbg());
    }

    @Override // com.google.android.gms.ads.internal.client.zzm
    public zzge createInAppPurchaseManager(Activity activity) {
        return new com.google.android.gms.ads.internal.purchase.zze(activity);
    }

    @Override // com.google.android.gms.ads.internal.client.zzm
    public zzu createInterstitialAdManager(Context context, AdSizeParcel adSize, String adUnitId, zzew adapterCreator, VersionInfoParcel versionInfo) {
        return zzbt.zzwE.get().booleanValue() ? new zzeb(context, adUnitId, adapterCreator, versionInfo, zzd.zzbg()) : new zzk(context, adSize, adUnitId, adapterCreator, versionInfo, zzd.zzbg());
    }

    @Override // com.google.android.gms.ads.internal.client.zzm
    public zzcj createNativeAdViewDelegate(FrameLayout nativeAdView, FrameLayout overlayFrame) {
        return new com.google.android.gms.ads.internal.formats.zzk(nativeAdView, overlayFrame);
    }

    @Override // com.google.android.gms.ads.internal.client.zzm
    public com.google.android.gms.ads.internal.reward.client.zzb createRewardedVideoAd(Context context, zzew adapterCreator, VersionInfoParcel versionInfo) {
        return new zzhs(context, zzd.zzbg(), adapterCreator, versionInfo);
    }

    @Override // com.google.android.gms.ads.internal.client.zzm
    public zzy getMobileAdsSettingsManager(Context context) {
        return zzn.zzr(context);
    }
}
