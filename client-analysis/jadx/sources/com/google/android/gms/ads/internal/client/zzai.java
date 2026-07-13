package com.google.android.gms.ads.internal.client;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.zzcj;
import com.google.android.gms.internal.zzew;
import com.google.android.gms.internal.zzfv;
import com.google.android.gms.internal.zzge;

/* JADX INFO: loaded from: classes.dex */
public class zzai implements zzm {
    @Override // com.google.android.gms.ads.internal.client.zzm
    public zzs createAdLoaderBuilder(Context context, String adUnitId, zzew adapterCreator, VersionInfoParcel versionInfo) {
        return new zzag();
    }

    @Override // com.google.android.gms.ads.internal.client.zzm
    @Nullable
    public zzfv createAdOverlay(Activity activity) {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzm
    public zzu createBannerAdManager(Context context, AdSizeParcel adSize, String adUnitId, zzew adapterCreator, VersionInfoParcel versionInfo) {
        return new zzah();
    }

    @Override // com.google.android.gms.ads.internal.client.zzm
    @Nullable
    public zzge createInAppPurchaseManager(Activity activity) {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzm
    public zzu createInterstitialAdManager(Context context, AdSizeParcel adSize, String adUnitId, zzew adapterCreator, VersionInfoParcel versionInfo) {
        return new zzah();
    }

    @Override // com.google.android.gms.ads.internal.client.zzm
    public zzcj createNativeAdViewDelegate(FrameLayout nativeAdView, FrameLayout overlayFrame) {
        return new zzak();
    }

    @Override // com.google.android.gms.ads.internal.client.zzm
    public com.google.android.gms.ads.internal.reward.client.zzb createRewardedVideoAd(Context context, zzew adapterCreator, VersionInfoParcel versionInfo) {
        return new zzal();
    }

    @Override // com.google.android.gms.ads.internal.client.zzm
    public zzy getMobileAdsSettingsManager(Context context) {
        return new zzaj();
    }
}
