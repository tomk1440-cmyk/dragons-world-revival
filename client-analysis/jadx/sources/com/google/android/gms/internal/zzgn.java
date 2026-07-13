package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public abstract class zzgn implements zzit<Void>, zzjq.zza {
    protected final Context mContext;
    protected final zzgr.zza zzGc;
    protected final zzif.zza zzGd;
    protected AdResponseParcel zzGe;
    private Runnable zzGf;
    protected final Object zzGg = new Object();
    private AtomicBoolean zzGh = new AtomicBoolean(true);
    protected final zzjp zzpD;

    protected zzgn(Context context, zzif.zza zzaVar, zzjp zzjpVar, zzgr.zza zzaVar2) {
        this.mContext = context;
        this.zzGd = zzaVar;
        this.zzGe = this.zzGd.zzLe;
        this.zzpD = zzjpVar;
        this.zzGc = zzaVar2;
    }

    private zzif zzD(int i) {
        AdRequestInfoParcel adRequestInfoParcel = this.zzGd.zzLd;
        return new zzif(adRequestInfoParcel.zzHt, this.zzpD, this.zzGe.zzBQ, i, this.zzGe.zzBR, this.zzGe.zzHV, this.zzGe.orientation, this.zzGe.zzBU, adRequestInfoParcel.zzHw, this.zzGe.zzHT, null, null, null, null, null, this.zzGe.zzHU, this.zzGd.zzrp, this.zzGe.zzHS, this.zzGd.zzKY, this.zzGe.zzHX, this.zzGe.zzHY, this.zzGd.zzKT, null, this.zzGe.zzIj, this.zzGe.zzIk, this.zzGe.zzIl, this.zzGe.zzIm);
    }

    @Override // com.google.android.gms.internal.zzit
    public void cancel() {
        if (this.zzGh.getAndSet(false)) {
            this.zzpD.stopLoading();
            com.google.android.gms.ads.internal.zzr.zzbE().zzi(this.zzpD);
            zzC(-1);
            zzir.zzMc.removeCallbacks(this.zzGf);
        }
    }

    protected void zzC(int i) {
        if (i != -2) {
            this.zzGe = new AdResponseParcel(i, this.zzGe.zzBU);
        }
        this.zzpD.zzhO();
        this.zzGc.zzb(zzD(i));
    }

    @Override // com.google.android.gms.internal.zzjq.zza
    public void zza(zzjp zzjpVar, boolean z) {
        zzin.zzaI("WebView finished loading.");
        if (this.zzGh.getAndSet(false)) {
            zzC(z ? zzgc() : -1);
            zzir.zzMc.removeCallbacks(this.zzGf);
        }
    }

    @Override // com.google.android.gms.internal.zzit
    /* JADX INFO: renamed from: zzga, reason: merged with bridge method [inline-methods] */
    public final Void zzgd() {
        com.google.android.gms.common.internal.zzx.zzcD("Webview render task needs to be called on UI thread.");
        this.zzGf = new Runnable() { // from class: com.google.android.gms.internal.zzgn.1
            @Override // java.lang.Runnable
            public void run() {
                if (zzgn.this.zzGh.get()) {
                    zzin.e("Timed out waiting for WebView to finish loading.");
                    zzgn.this.cancel();
                }
            }
        };
        zzir.zzMc.postDelayed(this.zzGf, zzbt.zzwY.get().longValue());
        zzgb();
        return null;
    }

    protected abstract void zzgb();

    protected int zzgc() {
        return -2;
    }
}
