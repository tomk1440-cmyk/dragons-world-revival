package com.google.android.gms.internal;

import java.util.Map;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public final class zzhf {
    private String zzEY;
    private String zzJh;
    zzeg.zzd zzJj;
    zzjp zzpD;
    private final Object zzpV = new Object();
    private zzjd<zzhi> zzJi = new zzjd<>();
    public final zzdf zzJk = new zzdf() { // from class: com.google.android.gms.internal.zzhf.1
        @Override // com.google.android.gms.internal.zzdf
        public void zza(zzjp zzjpVar, Map<String, String> map) {
            synchronized (zzhf.this.zzpV) {
                if (zzhf.this.zzJi.isDone()) {
                    return;
                }
                if (zzhf.this.zzEY.equals(map.get("request_id"))) {
                    zzhi zzhiVar = new zzhi(1, map);
                    zzin.zzaK("Invalid " + zzhiVar.getType() + " request error: " + zzhiVar.zzgE());
                    zzhf.this.zzJi.zzg(zzhiVar);
                }
            }
        }
    };
    public final zzdf zzJl = new zzdf() { // from class: com.google.android.gms.internal.zzhf.2
        @Override // com.google.android.gms.internal.zzdf
        public void zza(zzjp zzjpVar, Map<String, String> map) {
            synchronized (zzhf.this.zzpV) {
                if (zzhf.this.zzJi.isDone()) {
                    return;
                }
                zzhi zzhiVar = new zzhi(-2, map);
                if (!zzhf.this.zzEY.equals(zzhiVar.getRequestId())) {
                    zzin.zzaK(zzhiVar.getRequestId() + " ==== " + zzhf.this.zzEY);
                    return;
                }
                String url = zzhiVar.getUrl();
                if (url == null) {
                    zzin.zzaK("URL missing in loadAdUrl GMSG.");
                    return;
                }
                if (url.contains("%40mediation_adapters%40")) {
                    String strReplaceAll = url.replaceAll("%40mediation_adapters%40", zzil.zza(zzjpVar.getContext(), map.get("check_adapters"), zzhf.this.zzJh));
                    zzhiVar.setUrl(strReplaceAll);
                    zzin.v("Ad request URL modified to " + strReplaceAll);
                }
                zzhf.this.zzJi.zzg(zzhiVar);
            }
        }
    };

    public zzhf(String str, String str2) {
        this.zzJh = str2;
        this.zzEY = str;
    }

    public void zzb(zzeg.zzd zzdVar) {
        this.zzJj = zzdVar;
    }

    public zzeg.zzd zzgB() {
        return this.zzJj;
    }

    public Future<zzhi> zzgC() {
        return this.zzJi;
    }

    public void zzgD() {
        if (this.zzpD != null) {
            this.zzpD.destroy();
            this.zzpD = null;
        }
    }

    public void zzh(zzjp zzjpVar) {
        this.zzpD = zzjpVar;
    }
}
