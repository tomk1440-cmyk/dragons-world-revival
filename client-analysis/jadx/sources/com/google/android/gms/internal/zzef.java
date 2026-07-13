package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzef implements zzed {
    private final zzjp zzpD;

    public zzef(Context context, VersionInfoParcel versionInfoParcel, zzan zzanVar) {
        this.zzpD = com.google.android.gms.ads.internal.zzr.zzbD().zza(context, new AdSizeParcel(), false, false, zzanVar, versionInfoParcel);
        this.zzpD.getWebView().setWillNotDraw(true);
    }

    private void runOnUiThread(Runnable runnable) {
        if (com.google.android.gms.ads.internal.client.zzn.zzcS().zzhJ()) {
            runnable.run();
        } else {
            zzir.zzMc.post(runnable);
        }
    }

    @Override // com.google.android.gms.internal.zzed
    public void destroy() {
        this.zzpD.destroy();
    }

    @Override // com.google.android.gms.internal.zzed
    public void zzZ(String str) {
        final String str2 = String.format("<!DOCTYPE html><html><head><script src=\"%s\"></script></head><body></body></html>", str);
        runOnUiThread(new Runnable() { // from class: com.google.android.gms.internal.zzef.3
            @Override // java.lang.Runnable
            public void run() {
                zzef.this.zzpD.loadData(str2, "text/html", "UTF-8");
            }
        });
    }

    @Override // com.google.android.gms.internal.zzed
    public void zza(com.google.android.gms.ads.internal.client.zza zzaVar, com.google.android.gms.ads.internal.overlay.zzg zzgVar, zzdb zzdbVar, com.google.android.gms.ads.internal.overlay.zzp zzpVar, boolean z, zzdh zzdhVar, zzdj zzdjVar, com.google.android.gms.ads.internal.zze zzeVar, zzft zzftVar) {
        this.zzpD.zzhU().zzb(zzaVar, zzgVar, zzdbVar, zzpVar, z, zzdhVar, zzdjVar, new com.google.android.gms.ads.internal.zze(false), zzftVar);
    }

    @Override // com.google.android.gms.internal.zzed
    public void zza(final zzed.zza zzaVar) {
        this.zzpD.zzhU().zza(new zzjq.zza() { // from class: com.google.android.gms.internal.zzef.6
            @Override // com.google.android.gms.internal.zzjq.zza
            public void zza(zzjp zzjpVar, boolean z) {
                zzaVar.zzeo();
            }
        });
    }

    @Override // com.google.android.gms.internal.zzeh
    public void zza(String str, zzdf zzdfVar) {
        this.zzpD.zzhU().zza(str, zzdfVar);
    }

    @Override // com.google.android.gms.internal.zzeh
    public void zza(final String str, final JSONObject jSONObject) {
        runOnUiThread(new Runnable() { // from class: com.google.android.gms.internal.zzef.1
            @Override // java.lang.Runnable
            public void run() {
                zzef.this.zzpD.zza(str, jSONObject);
            }
        });
    }

    @Override // com.google.android.gms.internal.zzed
    public void zzaa(final String str) {
        runOnUiThread(new Runnable() { // from class: com.google.android.gms.internal.zzef.5
            @Override // java.lang.Runnable
            public void run() {
                zzef.this.zzpD.loadUrl(str);
            }
        });
    }

    @Override // com.google.android.gms.internal.zzed
    public void zzab(final String str) {
        runOnUiThread(new Runnable() { // from class: com.google.android.gms.internal.zzef.4
            @Override // java.lang.Runnable
            public void run() {
                zzef.this.zzpD.loadData(str, "text/html", "UTF-8");
            }
        });
    }

    @Override // com.google.android.gms.internal.zzeh
    public void zzb(String str, zzdf zzdfVar) {
        this.zzpD.zzhU().zzb(str, zzdfVar);
    }

    @Override // com.google.android.gms.internal.zzeh
    public void zzb(String str, JSONObject jSONObject) {
        this.zzpD.zzb(str, jSONObject);
    }

    @Override // com.google.android.gms.internal.zzeh
    public void zze(final String str, final String str2) {
        runOnUiThread(new Runnable() { // from class: com.google.android.gms.internal.zzef.2
            @Override // java.lang.Runnable
            public void run() {
                zzef.this.zzpD.zze(str, str2);
            }
        });
    }

    @Override // com.google.android.gms.internal.zzed
    public zzei zzen() {
        return new zzej(this);
    }
}
