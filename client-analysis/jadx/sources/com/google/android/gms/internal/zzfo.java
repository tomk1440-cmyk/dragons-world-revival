package com.google.android.gms.internal;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzfo {
    private final boolean zzDp;
    private final String zzDq;
    private final zzjp zzpD;

    public zzfo(zzjp zzjpVar, Map<String, String> map) {
        this.zzpD = zzjpVar;
        this.zzDq = map.get("forceOrientation");
        if (map.containsKey("allowOrientationChange")) {
            this.zzDp = Boolean.parseBoolean(map.get("allowOrientationChange"));
        } else {
            this.zzDp = true;
        }
    }

    public void execute() {
        int iZzhx;
        if (this.zzpD == null) {
            zzin.zzaK("AdWebView is null");
            return;
        }
        if ("portrait".equalsIgnoreCase(this.zzDq)) {
            iZzhx = com.google.android.gms.ads.internal.zzr.zzbE().zzhw();
        } else if ("landscape".equalsIgnoreCase(this.zzDq)) {
            iZzhx = com.google.android.gms.ads.internal.zzr.zzbE().zzhv();
        } else {
            iZzhx = this.zzDp ? -1 : com.google.android.gms.ads.internal.zzr.zzbE().zzhx();
        }
        this.zzpD.setRequestedOrientation(iZzhx);
    }
}
