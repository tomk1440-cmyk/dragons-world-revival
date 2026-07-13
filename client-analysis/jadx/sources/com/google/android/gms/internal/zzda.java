package com.google.android.gms.internal;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public final class zzda implements zzdf {
    private final zzdb zzyW;

    public zzda(zzdb zzdbVar) {
        this.zzyW = zzdbVar;
    }

    @Override // com.google.android.gms.internal.zzdf
    public void zza(zzjp zzjpVar, Map<String, String> map) {
        String str = map.get("name");
        if (str == null) {
            zzin.zzaK("App event with no name parameter.");
        } else {
            this.zzyW.onAppEvent(str, map.get("info"));
        }
    }
}
