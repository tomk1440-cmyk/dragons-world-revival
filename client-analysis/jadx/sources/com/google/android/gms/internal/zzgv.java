package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzgv extends zzim {
    private final zzgw zzGC;
    private Future<zzif> zzGD;
    private final zzgr.zza zzGc;
    private final zzif.zza zzGd;
    private final AdResponseParcel zzGe;
    private final Object zzpV;

    public zzgv(Context context, com.google.android.gms.ads.internal.zzp zzpVar, zzee zzeeVar, zzif.zza zzaVar, zzan zzanVar, zzgr.zza zzaVar2) {
        this(zzaVar, zzaVar2, new zzgw(context, zzpVar, zzeeVar, new zziw(context), zzanVar, zzaVar));
    }

    zzgv(zzif.zza zzaVar, zzgr.zza zzaVar2, zzgw zzgwVar) {
        this.zzpV = new Object();
        this.zzGd = zzaVar;
        this.zzGe = zzaVar.zzLe;
        this.zzGc = zzaVar2;
        this.zzGC = zzgwVar;
    }

    private zzif zzE(int i) {
        return new zzif(this.zzGd.zzLd.zzHt, null, null, i, null, null, this.zzGe.orientation, this.zzGe.zzBU, this.zzGd.zzLd.zzHw, false, null, null, null, null, null, this.zzGe.zzHU, this.zzGd.zzrp, this.zzGe.zzHS, this.zzGd.zzKY, this.zzGe.zzHX, this.zzGe.zzHY, this.zzGd.zzKT, null, null, null, null, this.zzGd.zzLe.zzIm);
    }

    @Override // com.google.android.gms.internal.zzim
    public void onStop() {
        synchronized (this.zzpV) {
            if (this.zzGD != null) {
                this.zzGD.cancel(true);
            }
        }
    }

    @Override // com.google.android.gms.internal.zzim
    public void zzbr() {
        int i;
        final zzif zzifVarZzE;
        try {
            synchronized (this.zzpV) {
                this.zzGD = zziq.zza(this.zzGC);
            }
            zzifVarZzE = this.zzGD.get(60000L, TimeUnit.MILLISECONDS);
            i = -2;
        } catch (InterruptedException e) {
            zzifVarZzE = null;
            i = -1;
        } catch (CancellationException e2) {
            zzifVarZzE = null;
            i = -1;
        } catch (ExecutionException e3) {
            i = 0;
            zzifVarZzE = null;
        } catch (TimeoutException e4) {
            zzin.zzaK("Timed out waiting for native ad.");
            this.zzGD.cancel(true);
            i = 2;
            zzifVarZzE = null;
        }
        if (zzifVarZzE == null) {
            zzifVarZzE = zzE(i);
        }
        zzir.zzMc.post(new Runnable() { // from class: com.google.android.gms.internal.zzgv.1
            @Override // java.lang.Runnable
            public void run() {
                zzgv.this.zzGc.zzb(zzifVarZzE);
            }
        });
    }
}
