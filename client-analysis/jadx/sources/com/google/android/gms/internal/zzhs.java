package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.reward.client.RewardedVideoAdRequestParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzhs extends com.google.android.gms.ads.internal.reward.client.zzb.zza {
    private final Context mContext;
    private final zzht zzKu;
    private final VersionInfoParcel zzpT;
    private final Object zzpV = new Object();

    public zzhs(Context context, com.google.android.gms.ads.internal.zzd zzdVar, zzex zzexVar, VersionInfoParcel versionInfoParcel) {
        this.mContext = context;
        this.zzpT = versionInfoParcel;
        this.zzKu = new zzht(context, zzdVar, AdSizeParcel.zzcP(), zzexVar, versionInfoParcel);
    }

    @Override // com.google.android.gms.ads.internal.reward.client.zzb
    public void destroy() {
        synchronized (this.zzpV) {
            this.zzKu.destroy();
        }
    }

    @Override // com.google.android.gms.ads.internal.reward.client.zzb
    public boolean isLoaded() {
        boolean zIsLoaded;
        synchronized (this.zzpV) {
            zIsLoaded = this.zzKu.isLoaded();
        }
        return zIsLoaded;
    }

    @Override // com.google.android.gms.ads.internal.reward.client.zzb
    public void pause() {
        synchronized (this.zzpV) {
            this.zzKu.pause();
        }
    }

    @Override // com.google.android.gms.ads.internal.reward.client.zzb
    public void resume() {
        synchronized (this.zzpV) {
            this.zzKu.resume();
        }
    }

    @Override // com.google.android.gms.ads.internal.reward.client.zzb
    public void setUserId(String userId) {
        synchronized (this.zzpV) {
            this.zzKu.setUserId(userId);
        }
    }

    @Override // com.google.android.gms.ads.internal.reward.client.zzb
    public void show() {
        synchronized (this.zzpV) {
            this.zzKu.zzgL();
        }
    }

    @Override // com.google.android.gms.ads.internal.reward.client.zzb
    public void zza(RewardedVideoAdRequestParcel rewardedVideoAdRequestParcel) {
        synchronized (this.zzpV) {
            this.zzKu.zza(rewardedVideoAdRequestParcel);
        }
    }

    @Override // com.google.android.gms.ads.internal.reward.client.zzb
    public void zza(com.google.android.gms.ads.internal.reward.client.zzd zzdVar) {
        synchronized (this.zzpV) {
            this.zzKu.zza(zzdVar);
        }
    }
}
