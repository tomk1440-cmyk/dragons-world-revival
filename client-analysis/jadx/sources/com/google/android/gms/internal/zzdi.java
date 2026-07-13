package com.google.android.gms.internal;

import com.facebook.appevents.AppEventsConstants;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzdi implements zzdf {
    private final zzdj zzzy;

    public zzdi(zzdj zzdjVar) {
        this.zzzy = zzdjVar;
    }

    @Override // com.google.android.gms.internal.zzdf
    public void zza(zzjp zzjpVar, Map<String, String> map) {
        float f;
        boolean zEquals = AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(map.get("transparentBackground"));
        boolean zEquals2 = AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(map.get("blur"));
        try {
            f = map.get("blurRadius") != null ? Float.parseFloat(map.get("blurRadius")) : 0.0f;
        } catch (NumberFormatException e) {
            zzin.zzb("Fail to parse float", e);
        }
        this.zzzy.zzd(zEquals);
        this.zzzy.zza(zEquals2, f);
    }
}
