package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzhx extends com.google.android.gms.ads.internal.reward.mediation.client.zza.AbstractBinderC0036zza {
    private zzhy zzKC;
    private zzhv zzKJ;
    private zzhw zzKK;

    public zzhx(zzhw zzhwVar) {
        this.zzKK = zzhwVar;
    }

    @Override // com.google.android.gms.ads.internal.reward.mediation.client.zza
    public void zza(com.google.android.gms.dynamic.zzd zzdVar, RewardItemParcel rewardItemParcel) {
        if (this.zzKK != null) {
            this.zzKK.zzc(rewardItemParcel);
        }
    }

    public void zza(zzhv zzhvVar) {
        this.zzKJ = zzhvVar;
    }

    public void zza(zzhy zzhyVar) {
        this.zzKC = zzhyVar;
    }

    @Override // com.google.android.gms.ads.internal.reward.mediation.client.zza
    public void zzb(com.google.android.gms.dynamic.zzd zzdVar, int i) {
        if (this.zzKJ != null) {
            this.zzKJ.zzN(i);
        }
    }

    @Override // com.google.android.gms.ads.internal.reward.mediation.client.zza
    public void zzc(com.google.android.gms.dynamic.zzd zzdVar, int i) {
        if (this.zzKC != null) {
            this.zzKC.zza(com.google.android.gms.dynamic.zze.zzp(zzdVar).getClass().getName(), i);
        }
    }

    @Override // com.google.android.gms.ads.internal.reward.mediation.client.zza
    public void zzg(com.google.android.gms.dynamic.zzd zzdVar) {
        if (this.zzKJ != null) {
            this.zzKJ.zzgN();
        }
    }

    @Override // com.google.android.gms.ads.internal.reward.mediation.client.zza
    public void zzh(com.google.android.gms.dynamic.zzd zzdVar) {
        if (this.zzKC != null) {
            this.zzKC.zzax(com.google.android.gms.dynamic.zze.zzp(zzdVar).getClass().getName());
        }
    }

    @Override // com.google.android.gms.ads.internal.reward.mediation.client.zza
    public void zzi(com.google.android.gms.dynamic.zzd zzdVar) {
        if (this.zzKK != null) {
            this.zzKK.onRewardedVideoAdOpened();
        }
    }

    @Override // com.google.android.gms.ads.internal.reward.mediation.client.zza
    public void zzj(com.google.android.gms.dynamic.zzd zzdVar) {
        if (this.zzKK != null) {
            this.zzKK.onRewardedVideoStarted();
        }
    }

    @Override // com.google.android.gms.ads.internal.reward.mediation.client.zza
    public void zzk(com.google.android.gms.dynamic.zzd zzdVar) {
        if (this.zzKK != null) {
            this.zzKK.onRewardedVideoAdClosed();
        }
    }

    @Override // com.google.android.gms.ads.internal.reward.mediation.client.zza
    public void zzl(com.google.android.gms.dynamic.zzd zzdVar) {
        if (this.zzKK != null) {
            this.zzKK.zzgM();
        }
    }

    @Override // com.google.android.gms.ads.internal.reward.mediation.client.zza
    public void zzm(com.google.android.gms.dynamic.zzd zzdVar) {
        if (this.zzKK != null) {
            this.zzKK.onRewardedVideoAdLeftApplication();
        }
    }
}
