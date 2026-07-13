package com.google.android.gms.ads.internal.reward.client;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzn;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.zzew;
import com.google.android.gms.internal.zzhb;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzf extends com.google.android.gms.dynamic.zzg<zzc> {
    public zzf() {
        super("com.google.android.gms.ads.reward.RewardedVideoAdCreatorImpl");
    }

    private zzb zzb(Context context, zzew zzewVar) {
        try {
            return zzb.zza.zzaa(zzaB(context).zza(com.google.android.gms.dynamic.zze.zzC(context), zzewVar, 8487000));
        } catch (RemoteException | com.google.android.gms.dynamic.zzg.zza e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not get remote RewardedVideoAd.", e);
            return null;
        }
    }

    public zzb zza(Context context, zzew zzewVar) {
        zzb zzbVarZzb;
        if (zzn.zzcS().zzU(context) && (zzbVarZzb = zzb(context, zzewVar)) != null) {
            return zzbVarZzb;
        }
        com.google.android.gms.ads.internal.util.client.zzb.zzaI("Using RewardedVideoAd from the client jar.");
        return zzn.zzcU().createRewardedVideoAd(context, zzewVar, new VersionInfoParcel(8487000, 8487000, true));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.dynamic.zzg
    /* JADX INFO: renamed from: zzad, reason: merged with bridge method [inline-methods] */
    public zzc zzd(IBinder iBinder) {
        return zzc.zza.zzab(iBinder);
    }
}
