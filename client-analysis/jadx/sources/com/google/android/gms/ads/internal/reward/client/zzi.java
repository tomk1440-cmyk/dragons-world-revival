package com.google.android.gms.ads.internal.reward.client;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.internal.zzhb;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzi implements RewardedVideoAd {
    private final Context mContext;
    private final zzb zzKA;
    private RewardedVideoAdListener zzaX;
    private final Object zzpV = new Object();
    private String zzrG;

    public zzi(Context context, zzb zzbVar) {
        this.zzKA = zzbVar;
        this.mContext = context;
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public void destroy() {
        synchronized (this.zzpV) {
            if (this.zzKA == null) {
                return;
            }
            try {
                this.zzKA.destroy();
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not forward destroy to RewardedVideoAd", e);
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public RewardedVideoAdListener getRewardedVideoAdListener() {
        RewardedVideoAdListener rewardedVideoAdListener;
        synchronized (this.zzpV) {
            rewardedVideoAdListener = this.zzaX;
        }
        return rewardedVideoAdListener;
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public String getUserId() {
        String str;
        synchronized (this.zzpV) {
            str = this.zzrG;
        }
        return str;
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public boolean isLoaded() {
        boolean zIsLoaded = false;
        synchronized (this.zzpV) {
            if (this.zzKA != null) {
                try {
                    zIsLoaded = this.zzKA.isLoaded();
                } catch (RemoteException e) {
                    com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not forward isLoaded to RewardedVideoAd", e);
                }
            }
        }
        return zIsLoaded;
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public void loadAd(String adUnitId, AdRequest adRequest) {
        synchronized (this.zzpV) {
            if (this.zzKA == null) {
                return;
            }
            try {
                this.zzKA.zza(com.google.android.gms.ads.internal.client.zzh.zzcO().zza(this.mContext, adRequest.zzaE(), adUnitId));
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not forward loadAd to RewardedVideoAd", e);
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public void pause() {
        synchronized (this.zzpV) {
            if (this.zzKA == null) {
                return;
            }
            try {
                this.zzKA.pause();
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not forward pause to RewardedVideoAd", e);
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public void resume() {
        synchronized (this.zzpV) {
            if (this.zzKA == null) {
                return;
            }
            try {
                this.zzKA.resume();
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not forward resume to RewardedVideoAd", e);
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public void setRewardedVideoAdListener(RewardedVideoAdListener listener) {
        synchronized (this.zzpV) {
            this.zzaX = listener;
            if (this.zzKA != null) {
                try {
                    this.zzKA.zza(new zzg(listener));
                } catch (RemoteException e) {
                    com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not forward setRewardedVideoAdListener to RewardedVideoAd", e);
                }
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public void setUserId(String userId) {
        synchronized (this.zzpV) {
            if (!TextUtils.isEmpty(this.zzrG)) {
                com.google.android.gms.ads.internal.util.client.zzb.zzaK("A user id has already been set, ignoring.");
                return;
            }
            this.zzrG = userId;
            if (this.zzKA != null) {
                try {
                    this.zzKA.setUserId(userId);
                } catch (RemoteException e) {
                    com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not forward setUserId to RewardedVideoAd", e);
                }
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public void show() {
        synchronized (this.zzpV) {
            if (this.zzKA == null) {
                return;
            }
            try {
                this.zzKA.show();
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not forward show to RewardedVideoAd", e);
            }
        }
    }
}
