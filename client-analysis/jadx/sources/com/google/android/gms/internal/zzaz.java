package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzaz extends zzau {
    private final zzeh zzsE;

    public zzaz(Context context, AdSizeParcel adSizeParcel, zzif zzifVar, VersionInfoParcel versionInfoParcel, zzbb zzbbVar, zzeh zzehVar) {
        super(context, adSizeParcel, zzifVar, versionInfoParcel, zzbbVar);
        this.zzsE = zzehVar;
        zzb(this.zzsE);
        zzcd();
        zzh(false);
        zzin.zzaI("Tracking ad unit: " + this.zzrZ.zzcu());
    }

    @Override // com.google.android.gms.internal.zzau
    protected void destroy() {
        synchronized (this.zzpV) {
            super.destroy();
            zzc(this.zzsE);
        }
    }

    @Override // com.google.android.gms.internal.zzau
    protected void zzb(JSONObject jSONObject) {
        this.zzsE.zza("AFMA_updateActiveView", jSONObject);
    }

    @Override // com.google.android.gms.internal.zzau
    public void zzcf() {
        destroy();
    }

    @Override // com.google.android.gms.internal.zzau
    protected boolean zzcl() {
        return true;
    }
}
