package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.internal.zzew;
import com.google.android.gms.internal.zzhb;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzad {
    private static final Object zzqy = new Object();
    private static zzad zzuV;
    private zzy zzuW;
    private RewardedVideoAd zzuX;

    private zzad() {
    }

    public static zzad zzdi() {
        zzad zzadVar;
        synchronized (zzqy) {
            if (zzuV == null) {
                zzuV = new zzad();
            }
            zzadVar = zzuV;
        }
        return zzadVar;
    }

    public RewardedVideoAd getRewardedVideoAdInstance(Context context) {
        RewardedVideoAd rewardedVideoAd;
        synchronized (zzqy) {
            if (this.zzuX != null) {
                rewardedVideoAd = this.zzuX;
            } else {
                this.zzuX = new com.google.android.gms.ads.internal.reward.client.zzi(context, zzn.zzcX().zza(context, new zzew()));
                rewardedVideoAd = this.zzuX;
            }
        }
        return rewardedVideoAd;
    }

    public void initialize(Context context) {
        synchronized (zzqy) {
            if (this.zzuW != null) {
                return;
            }
            if (context == null) {
                throw new IllegalArgumentException("Context cannot be null.");
            }
            try {
                this.zzuW = zzn.zzcV().zzu(context);
                this.zzuW.zza();
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzb.zzaK("Fail to initialize mobile ads setting manager");
            }
        }
    }

    public void setAppVolume(float volume) {
        com.google.android.gms.common.internal.zzx.zzb(0.0f <= volume && volume <= 1.0f, "The app volume must be a value between 0 and 1 inclusive.");
        com.google.android.gms.common.internal.zzx.zza(this.zzuW != null, "MobileAds.initialize() must be called prior to setting the app volume.");
        try {
            this.zzuW.setAppVolume(volume);
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzb("Unable to set app volume.", e);
        }
    }

    public void zza(Context context, String str, zzae zzaeVar) {
        initialize(context);
    }
}
