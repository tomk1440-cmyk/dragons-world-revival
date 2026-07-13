package com.google.android.gms.internal;

import android.app.Activity;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public final class zzjc {
    private Activity zzMM;
    private boolean zzMN;
    private boolean zzMO;
    private boolean zzMP;
    private ViewTreeObserver.OnGlobalLayoutListener zzMQ;
    private ViewTreeObserver.OnScrollChangedListener zzMR;

    public zzjc(Activity activity, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        this.zzMM = activity;
        this.zzMQ = onGlobalLayoutListener;
        this.zzMR = onScrollChangedListener;
    }

    private void zzhG() {
        if (this.zzMM == null || this.zzMN) {
            return;
        }
        if (this.zzMQ != null) {
            com.google.android.gms.ads.internal.zzr.zzbC().zza(this.zzMM, this.zzMQ);
        }
        if (this.zzMR != null) {
            com.google.android.gms.ads.internal.zzr.zzbC().zza(this.zzMM, this.zzMR);
        }
        this.zzMN = true;
    }

    private void zzhH() {
        if (this.zzMM != null && this.zzMN) {
            if (this.zzMQ != null) {
                com.google.android.gms.ads.internal.zzr.zzbE().zzb(this.zzMM, this.zzMQ);
            }
            if (this.zzMR != null) {
                com.google.android.gms.ads.internal.zzr.zzbC().zzb(this.zzMM, this.zzMR);
            }
            this.zzMN = false;
        }
    }

    public void onAttachedToWindow() {
        this.zzMO = true;
        if (this.zzMP) {
            zzhG();
        }
    }

    public void onDetachedFromWindow() {
        this.zzMO = false;
        zzhH();
    }

    public void zzhE() {
        this.zzMP = true;
        if (this.zzMO) {
            zzhG();
        }
    }

    public void zzhF() {
        this.zzMP = false;
        zzhH();
    }

    public void zzi(Activity activity) {
        this.zzMM = activity;
    }
}
