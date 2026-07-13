package com.google.android.gms.ads.internal.reward.client;

import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.internal.zzhb;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzg extends zzd.zza {
    private final RewardedVideoAdListener zzaX;

    public zzg(RewardedVideoAdListener rewardedVideoAdListener) {
        this.zzaX = rewardedVideoAdListener;
    }

    @Override // com.google.android.gms.ads.internal.reward.client.zzd
    public void onRewardedVideoAdClosed() {
        if (this.zzaX != null) {
            this.zzaX.onRewardedVideoAdClosed();
        }
    }

    @Override // com.google.android.gms.ads.internal.reward.client.zzd
    public void onRewardedVideoAdFailedToLoad(int errorCode) {
        if (this.zzaX != null) {
            this.zzaX.onRewardedVideoAdFailedToLoad(errorCode);
        }
    }

    @Override // com.google.android.gms.ads.internal.reward.client.zzd
    public void onRewardedVideoAdLeftApplication() {
        if (this.zzaX != null) {
            this.zzaX.onRewardedVideoAdLeftApplication();
        }
    }

    @Override // com.google.android.gms.ads.internal.reward.client.zzd
    public void onRewardedVideoAdLoaded() {
        if (this.zzaX != null) {
            this.zzaX.onRewardedVideoAdLoaded();
        }
    }

    @Override // com.google.android.gms.ads.internal.reward.client.zzd
    public void onRewardedVideoAdOpened() {
        if (this.zzaX != null) {
            this.zzaX.onRewardedVideoAdOpened();
        }
    }

    @Override // com.google.android.gms.ads.internal.reward.client.zzd
    public void onRewardedVideoStarted() {
        if (this.zzaX != null) {
            this.zzaX.onRewardedVideoStarted();
        }
    }

    @Override // com.google.android.gms.ads.internal.reward.client.zzd
    public void zza(zza zzaVar) {
        if (this.zzaX != null) {
            this.zzaX.onRewarded(new zze(zzaVar));
        }
    }
}
