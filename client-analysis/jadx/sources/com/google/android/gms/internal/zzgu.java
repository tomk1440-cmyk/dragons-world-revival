package com.google.android.gms.internal;

import android.content.Context;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzgu extends zzgq {
    private zzeo zzCf;
    private boolean zzGA;
    private zzem zzGy;
    protected zzes zzGz;
    private final zzjp zzpD;
    private final zzcb zzpe;
    private zzex zzpn;

    zzgu(Context context, zzif.zza zzaVar, zzex zzexVar, zzgr.zza zzaVar2, zzcb zzcbVar, zzjp zzjpVar) {
        super(context, zzaVar, zzaVar2);
        this.zzpn = zzexVar;
        this.zzCf = zzaVar.zzKV;
        this.zzpe = zzcbVar;
        this.zzpD = zzjpVar;
    }

    private void zzgk() throws zzgq.zza {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        zzir.zzMc.post(new Runnable() { // from class: com.google.android.gms.internal.zzgu.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (zzgu.this.zzGg) {
                    zzgu.this.zzGA = com.google.android.gms.ads.internal.zzm.zza(zzgu.this.zzpD, zzgu.this.zzGz, countDownLatch);
                }
            }
        });
        try {
            countDownLatch.await(10L, TimeUnit.SECONDS);
            synchronized (this.zzGg) {
                if (!this.zzGA) {
                    throw new zzgq.zza("View could not be prepared", 0);
                }
                if (this.zzpD.isDestroyed()) {
                    throw new zzgq.zza("Assets not loaded, web view is destroyed", 0);
                }
            }
        } catch (InterruptedException e) {
            throw new zzgq.zza("Interrupted while waiting for latch : " + e, 0);
        }
    }

    @Override // com.google.android.gms.internal.zzgq, com.google.android.gms.internal.zzim
    public void onStop() {
        synchronized (this.zzGg) {
            super.onStop();
            if (this.zzGy != null) {
                this.zzGy.cancel();
            }
        }
    }

    @Override // com.google.android.gms.internal.zzgq
    protected zzif zzD(int i) {
        AdRequestInfoParcel adRequestInfoParcel = this.zzGd.zzLd;
        return new zzif(adRequestInfoParcel.zzHt, this.zzpD, this.zzGe.zzBQ, i, this.zzGe.zzBR, this.zzGe.zzHV, this.zzGe.orientation, this.zzGe.zzBU, adRequestInfoParcel.zzHw, this.zzGe.zzHT, this.zzGz != null ? this.zzGz.zzCp : null, this.zzGz != null ? this.zzGz.zzCq : null, this.zzGz != null ? this.zzGz.zzCr : AdMobAdapter.class.getName(), this.zzCf, this.zzGz != null ? this.zzGz.zzCs : null, this.zzGe.zzHU, this.zzGd.zzrp, this.zzGe.zzHS, this.zzGd.zzKY, this.zzGe.zzHX, this.zzGe.zzHY, this.zzGd.zzKT, null, this.zzGe.zzIj, this.zzGe.zzIk, this.zzGe.zzIl, this.zzGe.zzIm);
    }

    @Override // com.google.android.gms.internal.zzgq
    protected void zzh(long j) throws zzgq.zza {
        synchronized (this.zzGg) {
            this.zzGy = zzi(j);
        }
        this.zzGz = this.zzGy.zzc(this.zzCf.zzBO);
        switch (this.zzGz.zzCo) {
            case 0:
                if (this.zzGz.zzCp == null || this.zzGz.zzCp.zzBJ == null) {
                    return;
                }
                zzgk();
                return;
            case 1:
                throw new zzgq.zza("No fill from any mediation ad networks.", 3);
            default:
                throw new zzgq.zza("Unexpected mediation result: " + this.zzGz.zzCo, 0);
        }
    }

    zzem zzi(long j) {
        return this.zzCf.zzBX != -1 ? new zzeu(this.mContext, this.zzGd.zzLd, this.zzpn, this.zzCf, this.zzGe.zzuk, this.zzGe.zzum, j, zzbt.zzwY.get().longValue(), 2) : new zzev(this.mContext, this.zzGd.zzLd, this.zzpn, this.zzCf, this.zzGe.zzuk, this.zzGe.zzum, j, zzbt.zzwY.get().longValue(), this.zzpe);
    }
}
