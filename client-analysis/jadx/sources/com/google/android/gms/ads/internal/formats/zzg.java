package com.google.android.gms.ads.internal.formats;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzan;
import com.google.android.gms.internal.zzfb;
import com.google.android.gms.internal.zzfc;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzjp;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzg extends zzi {
    private Object zzpV;
    private zzfb zzyl;
    private zzfc zzym;
    private final zzp zzyn;
    private zzh zzyo;
    private boolean zzyp;

    private zzg(Context context, zzp zzpVar, zzan zzanVar) {
        super(context, zzpVar, null, zzanVar, null, null, null);
        this.zzyp = false;
        this.zzpV = new Object();
        this.zzyn = zzpVar;
    }

    public zzg(Context context, zzp zzpVar, zzan zzanVar, zzfb zzfbVar) {
        this(context, zzpVar, zzanVar);
        this.zzyl = zzfbVar;
    }

    public zzg(Context context, zzp zzpVar, zzan zzanVar, zzfc zzfcVar) {
        this(context, zzpVar, zzanVar);
        this.zzym = zzfcVar;
    }

    @Override // com.google.android.gms.ads.internal.formats.zzi, com.google.android.gms.ads.internal.formats.zzh
    public void recordImpression() {
        zzx.zzcD("recordImpression must be called on the main UI thread.");
        synchronized (this.zzpV) {
            zzn(true);
            if (this.zzyo != null) {
                this.zzyo.recordImpression();
            } else {
                try {
                    if (this.zzyl != null && !this.zzyl.getOverrideImpressionRecording()) {
                        this.zzyl.recordImpression();
                    } else if (this.zzym != null && !this.zzym.getOverrideImpressionRecording()) {
                        this.zzym.recordImpression();
                    }
                } catch (RemoteException e) {
                    zzin.zzd("Failed to call recordImpression", e);
                }
            }
            this.zzyn.recordImpression();
        }
    }

    @Override // com.google.android.gms.ads.internal.formats.zzi
    public zzb zza(View.OnClickListener onClickListener) {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.formats.zzi, com.google.android.gms.ads.internal.formats.zzh
    public void zza(View view, Map<String, WeakReference<View>> map, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        zzx.zzcD("performClick must be called on the main UI thread.");
        synchronized (this.zzpV) {
            if (this.zzyo != null) {
                this.zzyo.zza(view, map, jSONObject, jSONObject2, jSONObject3);
                this.zzyn.onAdClicked();
            } else {
                try {
                    if (this.zzyl != null && !this.zzyl.getOverrideClickHandling()) {
                        this.zzyl.zzc(com.google.android.gms.dynamic.zze.zzC(view));
                        this.zzyn.onAdClicked();
                    }
                    if (this.zzym != null && !this.zzym.getOverrideClickHandling()) {
                        this.zzym.zzc(com.google.android.gms.dynamic.zze.zzC(view));
                        this.zzyn.onAdClicked();
                    }
                } catch (RemoteException e) {
                    zzin.zzd("Failed to call performClick", e);
                }
            }
        }
    }

    public void zzc(zzh zzhVar) {
        synchronized (this.zzpV) {
            this.zzyo = zzhVar;
        }
    }

    public boolean zzdP() {
        boolean z;
        synchronized (this.zzpV) {
            z = this.zzyp;
        }
        return z;
    }

    public zzh zzdQ() {
        zzh zzhVar;
        synchronized (this.zzpV) {
            zzhVar = this.zzyo;
        }
        return zzhVar;
    }

    @Override // com.google.android.gms.ads.internal.formats.zzi
    public zzjp zzdR() {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.formats.zzi
    public void zzg(View view) {
        synchronized (this.zzpV) {
            this.zzyp = true;
            try {
                if (this.zzyl != null) {
                    this.zzyl.zzd(com.google.android.gms.dynamic.zze.zzC(view));
                } else if (this.zzym != null) {
                    this.zzym.zzd(com.google.android.gms.dynamic.zze.zzC(view));
                }
            } catch (RemoteException e) {
                zzin.zzd("Failed to call prepareAd", e);
            }
            this.zzyp = false;
        }
    }
}
