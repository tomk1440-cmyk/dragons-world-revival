package com.google.android.gms.internal;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzds implements zzdf {
    @Override // com.google.android.gms.internal.zzdf
    public void zza(zzjp zzjpVar, Map<String, String> map) {
        int i;
        zzdq zzdqVarZzbR = com.google.android.gms.ads.internal.zzr.zzbR();
        if (map.containsKey("abort")) {
            if (zzdqVarZzbR.zzd(zzjpVar)) {
                return;
            }
            zzin.zzaK("Precache abort but no preload task running.");
            return;
        }
        String str = map.get("src");
        if (str == null) {
            zzin.zzaK("Precache video action is missing the src parameter.");
            return;
        }
        try {
            i = Integer.parseInt(map.get("player"));
        } catch (NumberFormatException e) {
            i = 0;
        }
        String str2 = map.containsKey("mimetype") ? map.get("mimetype") : "";
        if (zzdqVarZzbR.zze(zzjpVar)) {
            zzin.zzaK("Precache task already running.");
        } else {
            com.google.android.gms.common.internal.zzb.zzv(zzjpVar.zzhR());
            new zzdp(zzjpVar, zzjpVar.zzhR().zzpw.zza(zzjpVar, i, str2), str).zzgd();
        }
    }
}
