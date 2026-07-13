package com.google.android.gms.ads.internal.reward.mediation.client;

import android.os.RemoteException;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzin;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzb implements MediationRewardedVideoAdListener {
    private final zza zzKR;

    public zzb(zza zzaVar) {
        this.zzKR = zzaVar;
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public void onAdClicked(MediationRewardedVideoAdAdapter adapter) {
        zzx.zzcD("onAdClicked must be called on the main UI thread.");
        zzin.zzaI("Adapter called onAdClicked.");
        try {
            this.zzKR.zzl(zze.zzC(adapter));
        } catch (RemoteException e) {
            zzin.zzd("Could not call onAdClicked.", e);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public void onAdClosed(MediationRewardedVideoAdAdapter adapter) {
        zzx.zzcD("onAdClosed must be called on the main UI thread.");
        zzin.zzaI("Adapter called onAdClosed.");
        try {
            this.zzKR.zzk(zze.zzC(adapter));
        } catch (RemoteException e) {
            zzin.zzd("Could not call onAdClosed.", e);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public void onAdFailedToLoad(MediationRewardedVideoAdAdapter adapter, int errorCode) {
        zzx.zzcD("onAdFailedToLoad must be called on the main UI thread.");
        zzin.zzaI("Adapter called onAdFailedToLoad.");
        try {
            this.zzKR.zzc(zze.zzC(adapter), errorCode);
        } catch (RemoteException e) {
            zzin.zzd("Could not call onAdFailedToLoad.", e);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public void onAdLeftApplication(MediationRewardedVideoAdAdapter adapter) {
        zzx.zzcD("onAdLeftApplication must be called on the main UI thread.");
        zzin.zzaI("Adapter called onAdLeftApplication.");
        try {
            this.zzKR.zzm(zze.zzC(adapter));
        } catch (RemoteException e) {
            zzin.zzd("Could not call onAdLeftApplication.", e);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public void onAdLoaded(MediationRewardedVideoAdAdapter adapter) {
        zzx.zzcD("onAdLoaded must be called on the main UI thread.");
        zzin.zzaI("Adapter called onAdLoaded.");
        try {
            this.zzKR.zzh(zze.zzC(adapter));
        } catch (RemoteException e) {
            zzin.zzd("Could not call onAdLoaded.", e);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public void onAdOpened(MediationRewardedVideoAdAdapter adapter) {
        zzx.zzcD("onAdOpened must be called on the main UI thread.");
        zzin.zzaI("Adapter called onAdOpened.");
        try {
            this.zzKR.zzi(zze.zzC(adapter));
        } catch (RemoteException e) {
            zzin.zzd("Could not call onAdOpened.", e);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public void onInitializationFailed(MediationRewardedVideoAdAdapter adapter, int errorCode) {
        zzx.zzcD("onInitializationFailed must be called on the main UI thread.");
        zzin.zzaI("Adapter called onInitializationFailed.");
        try {
            this.zzKR.zzb(zze.zzC(adapter), errorCode);
        } catch (RemoteException e) {
            zzin.zzd("Could not call onInitializationFailed.", e);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public void onInitializationSucceeded(MediationRewardedVideoAdAdapter adapter) {
        zzx.zzcD("onInitializationSucceeded must be called on the main UI thread.");
        zzin.zzaI("Adapter called onInitializationSucceeded.");
        try {
            this.zzKR.zzg(zze.zzC(adapter));
        } catch (RemoteException e) {
            zzin.zzd("Could not call onInitializationSucceeded.", e);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public void onRewarded(MediationRewardedVideoAdAdapter adapter, RewardItem rewardItem) {
        zzx.zzcD("onRewarded must be called on the main UI thread.");
        zzin.zzaI("Adapter called onRewarded.");
        try {
            if (rewardItem != null) {
                this.zzKR.zza(zze.zzC(adapter), new RewardItemParcel(rewardItem));
            } else {
                this.zzKR.zza(zze.zzC(adapter), new RewardItemParcel(adapter.getClass().getName(), 1));
            }
        } catch (RemoteException e) {
            zzin.zzd("Could not call onRewarded.", e);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public void onVideoStarted(MediationRewardedVideoAdAdapter adapter) {
        zzx.zzcD("onVideoStarted must be called on the main UI thread.");
        zzin.zzaI("Adapter called onVideoStarted.");
        try {
            this.zzKR.zzj(zze.zzC(adapter));
        } catch (RemoteException e) {
            zzin.zzd("Could not call onVideoStarted.", e);
        }
    }
}
