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
public interface zzm {
    zzs createAdLoaderBuilder(Context context, String str, zzew zzewVar, VersionInfoParcel versionInfoParcel);

    @Nullable
    zzfv createAdOverlay(Activity activity);

    zzu createBannerAdManager(Context context, AdSizeParcel adSizeParcel, String str, zzew zzewVar, VersionInfoParcel versionInfoParcel);

    @Nullable
    zzge createInAppPurchaseManager(Activity activity);

    zzu createInterstitialAdManager(Context context, AdSizeParcel adSizeParcel, String str, zzew zzewVar, VersionInfoParcel versionInfoParcel);

    zzcj createNativeAdViewDelegate(FrameLayout frameLayout, FrameLayout frameLayout2);

    com.google.android.gms.ads.internal.reward.client.zzb createRewardedVideoAd(Context context, zzew zzewVar, VersionInfoParcel versionInfoParcel);

    zzy getMobileAdsSettingsManager(Context context);
}
