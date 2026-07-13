package com.google.android.gms.ads.internal.reward.client;

import android.os.RemoteException;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.internal.zzhb;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zze implements RewardItem {
    private final zza zzKz;

    public zze(zza zzaVar) {
        this.zzKz = zzaVar;
    }

    @Override // com.google.android.gms.ads.reward.RewardItem
    public int getAmount() {
        if (this.zzKz == null) {
            return 0;
        }
        try {
            return this.zzKz.getAmount();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not forward getAmount to RewardItem", e);
            return 0;
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardItem
    public String getType() {
        if (this.zzKz == null) {
            return null;
        }
        try {
            return this.zzKz.getType();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not forward getType to RewardItem", e);
            return null;
        }
    }
}
