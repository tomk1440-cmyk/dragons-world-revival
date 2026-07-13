package com.google.android.gms.internal;

import android.content.Context;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzjo {
    private final Context mContext;
    private com.google.android.gms.ads.internal.overlay.zzk zzFo;
    private final ViewGroup zzNx;
    private final zzjp zzpD;

    public zzjo(Context context, ViewGroup viewGroup, zzjp zzjpVar) {
        this(context, viewGroup, zzjpVar, null);
    }

    zzjo(Context context, ViewGroup viewGroup, zzjp zzjpVar, com.google.android.gms.ads.internal.overlay.zzk zzkVar) {
        this.mContext = context;
        this.zzNx = viewGroup;
        this.zzpD = zzjpVar;
        this.zzFo = zzkVar;
    }

    public void onDestroy() {
        com.google.android.gms.common.internal.zzx.zzcD("onDestroy must be called from the UI thread.");
        if (this.zzFo != null) {
            this.zzFo.destroy();
        }
    }

    public void onPause() {
        com.google.android.gms.common.internal.zzx.zzcD("onPause must be called from the UI thread.");
        if (this.zzFo != null) {
            this.zzFo.pause();
        }
    }

    public void zza(int i, int i2, int i3, int i4, int i5) {
        if (this.zzFo != null) {
            return;
        }
        zzbx.zza(this.zzpD.zzic().zzdA(), this.zzpD.zzib(), "vpr");
        this.zzFo = new com.google.android.gms.ads.internal.overlay.zzk(this.mContext, this.zzpD, i5, this.zzpD.zzic().zzdA(), zzbx.zzb(this.zzpD.zzic().zzdA()));
        this.zzNx.addView(this.zzFo, 0, new ViewGroup.LayoutParams(-1, -1));
        this.zzFo.zzd(i, i2, i3, i4);
        this.zzpD.zzhU().zzG(false);
    }

    public void zze(int i, int i2, int i3, int i4) {
        com.google.android.gms.common.internal.zzx.zzcD("The underlay may only be modified from the UI thread.");
        if (this.zzFo != null) {
            this.zzFo.zzd(i, i2, i3, i4);
        }
    }

    public com.google.android.gms.ads.internal.overlay.zzk zzhM() {
        com.google.android.gms.common.internal.zzx.zzcD("getAdVideoUnderlay must be called from the UI thread.");
        return this.zzFo;
    }
}
