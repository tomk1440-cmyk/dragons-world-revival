package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzba extends zzau {
    private zzeg.zzd zzsF;
    private boolean zzsG;

    public zzba(Context context, AdSizeParcel adSizeParcel, zzif zzifVar, VersionInfoParcel versionInfoParcel, zzbb zzbbVar, zzeg zzegVar) {
        super(context, adSizeParcel, zzifVar, versionInfoParcel, zzbbVar);
        this.zzsF = zzegVar.zzer();
        try {
            final JSONObject jSONObjectZzd = zzd(zzbbVar.zzcq().zzco());
            this.zzsF.zza(new zzji.zzc<zzeh>() { // from class: com.google.android.gms.internal.zzba.1
                @Override // com.google.android.gms.internal.zzji.zzc
                /* JADX INFO: renamed from: zzd, reason: merged with bridge method [inline-methods] */
                public void zze(zzeh zzehVar) {
                    zzba.this.zza(jSONObjectZzd);
                }
            }, new zzji.zza() { // from class: com.google.android.gms.internal.zzba.2
                @Override // com.google.android.gms.internal.zzji.zza
                public void run() {
                }
            });
        } catch (RuntimeException e) {
            zzin.zzb("Failure while processing active view data.", e);
        } catch (JSONException e2) {
        }
        this.zzsF.zza(new zzji.zzc<zzeh>() { // from class: com.google.android.gms.internal.zzba.3
            @Override // com.google.android.gms.internal.zzji.zzc
            /* JADX INFO: renamed from: zzd, reason: merged with bridge method [inline-methods] */
            public void zze(zzeh zzehVar) {
                zzba.this.zzsG = true;
                zzba.this.zzb(zzehVar);
                zzba.this.zzcd();
                zzba.this.zzh(false);
            }
        }, new zzji.zza() { // from class: com.google.android.gms.internal.zzba.4
            @Override // com.google.android.gms.internal.zzji.zza
            public void run() {
                zzba.this.destroy();
            }
        });
        zzin.zzaI("Tracking ad unit: " + this.zzrZ.zzcu());
    }

    @Override // com.google.android.gms.internal.zzau
    protected void destroy() {
        synchronized (this.zzpV) {
            super.destroy();
            this.zzsF.zza(new zzji.zzc<zzeh>() { // from class: com.google.android.gms.internal.zzba.6
                @Override // com.google.android.gms.internal.zzji.zzc
                /* JADX INFO: renamed from: zzd, reason: merged with bridge method [inline-methods] */
                public void zze(zzeh zzehVar) {
                    zzba.this.zzc(zzehVar);
                }
            }, new zzji.zzb());
            this.zzsF.release();
        }
    }

    @Override // com.google.android.gms.internal.zzau
    protected void zzb(final JSONObject jSONObject) {
        this.zzsF.zza(new zzji.zzc<zzeh>() { // from class: com.google.android.gms.internal.zzba.5
            @Override // com.google.android.gms.internal.zzji.zzc
            /* JADX INFO: renamed from: zzd, reason: merged with bridge method [inline-methods] */
            public void zze(zzeh zzehVar) {
                zzehVar.zza("AFMA_updateActiveView", jSONObject);
            }
        }, new zzji.zzb());
    }

    @Override // com.google.android.gms.internal.zzau
    protected boolean zzcl() {
        return this.zzsG;
    }
}
