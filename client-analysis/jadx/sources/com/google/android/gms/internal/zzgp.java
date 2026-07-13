package com.google.android.gms.internal;

import android.content.Context;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.internal.client.AdSizeParcel;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzgp extends zzgn {
    private zzgo zzGs;

    zzgp(Context context, zzif.zza zzaVar, zzjp zzjpVar, zzgr.zza zzaVar2) {
        super(context, zzaVar, zzjpVar, zzaVar2);
    }

    @Override // com.google.android.gms.internal.zzgn
    protected void zzgb() {
        int i;
        int i2;
        AdSizeParcel adSizeParcelZzaN = this.zzpD.zzaN();
        if (adSizeParcelZzaN.zzui) {
            DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
            i = displayMetrics.widthPixels;
            i2 = displayMetrics.heightPixels;
        } else {
            i = adSizeParcelZzaN.widthPixels;
            i2 = adSizeParcelZzaN.heightPixels;
        }
        this.zzGs = new zzgo(this, this.zzpD, i, i2);
        this.zzpD.zzhU().zza(this);
        this.zzGs.zza(this.zzGe);
    }

    @Override // com.google.android.gms.internal.zzgn
    protected int zzgc() {
        if (!this.zzGs.zzgg()) {
            return !this.zzGs.zzgh() ? 2 : -2;
        }
        zzin.zzaI("Ad-Network indicated no fill with passback URL.");
        return 3;
    }
}
