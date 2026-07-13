package com.google.android.gms.internal;

import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class zzdn implements zzdf {
    private final zza zzzH;

    public interface zza {
        void zzb(RewardItemParcel rewardItemParcel);

        void zzbq();
    }

    public zzdn(zza zzaVar) {
        this.zzzH = zzaVar;
    }

    public static void zza(zzjp zzjpVar, zza zzaVar) {
        zzjpVar.zzhU().zza("/reward", new zzdn(zzaVar));
    }

    private void zze(Map<String, String> map) {
        RewardItemParcel rewardItemParcel;
        try {
            int i = Integer.parseInt(map.get("amount"));
            String str = map.get(ShareConstants.MEDIA_TYPE);
            rewardItemParcel = !TextUtils.isEmpty(str) ? new RewardItemParcel(str, i) : null;
        } catch (NumberFormatException e) {
            zzin.zzd("Unable to parse reward amount.", e);
        }
        this.zzzH.zzb(rewardItemParcel);
    }

    private void zzf(Map<String, String> map) {
        this.zzzH.zzbq();
    }

    @Override // com.google.android.gms.internal.zzdf
    public void zza(zzjp zzjpVar, Map<String, String> map) {
        String str = map.get(NativeProtocol.WEB_DIALOG_ACTION);
        if ("grant".equals(str)) {
            zze(map);
        } else if ("video_start".equals(str)) {
            zzf(map);
        }
    }
}
