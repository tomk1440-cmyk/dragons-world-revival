package com.google.android.gms.ads.internal;

import android.content.Context;
import android.view.MotionEvent;
import com.google.android.gms.internal.zzaj;
import com.google.android.gms.internal.zzam;
import com.google.android.gms.internal.zzbt;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zziq;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
@zzhb
class zzh implements zzaj, Runnable {
    private final List<Object[]> zzpH = new Vector();
    private final AtomicReference<zzaj> zzpI = new AtomicReference<>();
    CountDownLatch zzpJ = new CountDownLatch(1);
    private zzs zzpj;

    public zzh(zzs zzsVar) {
        this.zzpj = zzsVar;
        if (com.google.android.gms.ads.internal.client.zzn.zzcS().zzhJ()) {
            zziq.zza(this);
        } else {
            run();
        }
    }

    private void zzbk() {
        if (this.zzpH.isEmpty()) {
            return;
        }
        for (Object[] objArr : this.zzpH) {
            if (objArr.length == 1) {
                this.zzpI.get().zza((MotionEvent) objArr[0]);
            } else if (objArr.length == 3) {
                this.zzpI.get().zza(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue());
            }
        }
        this.zzpH.clear();
    }

    private Context zzq(Context context) {
        Context applicationContext;
        return (zzbt.zzvM.get().booleanValue() && (applicationContext = context.getApplicationContext()) != null) ? applicationContext : context;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            zza(zzb(this.zzpj.zzrl.afmaVersion, zzq(this.zzpj.context), !zzbt.zzvY.get().booleanValue() || this.zzpj.zzrl.zzNb));
        } finally {
            this.zzpJ.countDown();
            this.zzpj = null;
        }
    }

    @Override // com.google.android.gms.internal.zzaj
    public void zza(int i, int i2, int i3) {
        zzaj zzajVar = this.zzpI.get();
        if (zzajVar == null) {
            this.zzpH.add(new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        } else {
            zzbk();
            zzajVar.zza(i, i2, i3);
        }
    }

    @Override // com.google.android.gms.internal.zzaj
    public void zza(MotionEvent motionEvent) {
        zzaj zzajVar = this.zzpI.get();
        if (zzajVar == null) {
            this.zzpH.add(new Object[]{motionEvent});
        } else {
            zzbk();
            zzajVar.zza(motionEvent);
        }
    }

    protected void zza(zzaj zzajVar) {
        this.zzpI.set(zzajVar);
    }

    protected zzaj zzb(String str, Context context, boolean z) {
        return zzam.zza(str, context, z);
    }

    @Override // com.google.android.gms.internal.zzaj
    public String zzb(Context context) {
        zzaj zzajVar;
        if (!zzbj() || (zzajVar = this.zzpI.get()) == null) {
            return "";
        }
        zzbk();
        return zzajVar.zzb(zzq(context));
    }

    @Override // com.google.android.gms.internal.zzaj
    public String zzb(Context context, String str) {
        zzaj zzajVar;
        if (!zzbj() || (zzajVar = this.zzpI.get()) == null) {
            return "";
        }
        zzbk();
        return zzajVar.zzb(zzq(context), str);
    }

    protected boolean zzbj() {
        try {
            this.zzpJ.await();
            return true;
        } catch (InterruptedException e) {
            zzin.zzd("Interrupted during GADSignals creation.", e);
            return false;
        }
    }
}
