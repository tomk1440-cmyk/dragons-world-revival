package com.google.android.gms.ads.internal;

import android.os.Handler;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzir;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzq {
    private final zza zzqG;
    private AdRequestParcel zzqH;
    private boolean zzqI;
    private boolean zzqJ;
    private long zzqK;
    private final Runnable zzx;

    public static class zza {
        private final Handler mHandler;

        public zza(Handler handler) {
            this.mHandler = handler;
        }

        public boolean postDelayed(Runnable runnable, long timeFromNowInMillis) {
            return this.mHandler.postDelayed(runnable, timeFromNowInMillis);
        }

        public void removeCallbacks(Runnable runnable) {
            this.mHandler.removeCallbacks(runnable);
        }
    }

    public zzq(com.google.android.gms.ads.internal.zza zzaVar) {
        this(zzaVar, new zza(zzir.zzMc));
    }

    zzq(com.google.android.gms.ads.internal.zza zzaVar, zza zzaVar2) {
        this.zzqI = false;
        this.zzqJ = false;
        this.zzqK = 0L;
        this.zzqG = zzaVar2;
        final WeakReference weakReference = new WeakReference(zzaVar);
        this.zzx = new Runnable() { // from class: com.google.android.gms.ads.internal.zzq.1
            @Override // java.lang.Runnable
            public void run() {
                zzq.this.zzqI = false;
                com.google.android.gms.ads.internal.zza zzaVar3 = (com.google.android.gms.ads.internal.zza) weakReference.get();
                if (zzaVar3 != null) {
                    zzaVar3.zzd(zzq.this.zzqH);
                }
            }
        };
    }

    public void cancel() {
        this.zzqI = false;
        this.zzqG.removeCallbacks(this.zzx);
    }

    public void pause() {
        this.zzqJ = true;
        if (this.zzqI) {
            this.zzqG.removeCallbacks(this.zzx);
        }
    }

    public void resume() {
        this.zzqJ = false;
        if (this.zzqI) {
            this.zzqI = false;
            zza(this.zzqH, this.zzqK);
        }
    }

    public void zza(AdRequestParcel adRequestParcel, long j) {
        if (this.zzqI) {
            zzin.zzaK("An ad refresh is already scheduled.");
            return;
        }
        this.zzqH = adRequestParcel;
        this.zzqI = true;
        this.zzqK = j;
        if (this.zzqJ) {
            return;
        }
        zzin.zzaJ("Scheduling ad refresh " + j + " milliseconds from now.");
        this.zzqG.postDelayed(this.zzx, j);
    }

    public boolean zzbw() {
        return this.zzqI;
    }

    public void zzg(AdRequestParcel adRequestParcel) {
        zza(adRequestParcel, 60000L);
    }
}
