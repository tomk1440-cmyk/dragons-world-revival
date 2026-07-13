package com.google.android.gms.ads.internal.overlay;

import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzir;

/* JADX INFO: loaded from: classes.dex */
@zzhb
class zzu implements Runnable {
    private boolean mCancelled = false;
    private zzk zzFo;

    zzu(zzk zzkVar) {
        this.zzFo = zzkVar;
    }

    public void cancel() {
        this.mCancelled = true;
        zzir.zzMc.removeCallbacks(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.mCancelled) {
            return;
        }
        this.zzFo.zzfF();
        zzfQ();
    }

    public void zzfQ() {
        zzir.zzMc.postDelayed(this, 250L);
    }
}
