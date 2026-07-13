package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@zzhb
class zzjh {
    private final Object zzNm = new Object();
    private final List<Runnable> zzNn = new ArrayList();
    private final List<Runnable> zzNo = new ArrayList();
    private boolean zzNp = false;

    private void zzd(Runnable runnable) {
        zziq.zza(runnable);
    }

    private void zze(Runnable runnable) {
        com.google.android.gms.ads.internal.util.client.zza.zzMS.post(runnable);
    }

    public void zzb(Runnable runnable) {
        synchronized (this.zzNm) {
            if (this.zzNp) {
                zzd(runnable);
            } else {
                this.zzNn.add(runnable);
            }
        }
    }

    public void zzc(Runnable runnable) {
        synchronized (this.zzNm) {
            if (this.zzNp) {
                zze(runnable);
            } else {
                this.zzNo.add(runnable);
            }
        }
    }

    public void zzhK() {
        synchronized (this.zzNm) {
            if (this.zzNp) {
                return;
            }
            Iterator<Runnable> it = this.zzNn.iterator();
            while (it.hasNext()) {
                zzd(it.next());
            }
            Iterator<Runnable> it2 = this.zzNo.iterator();
            while (it2.hasNext()) {
                zze(it2.next());
            }
            this.zzNn.clear();
            this.zzNo.clear();
            this.zzNp = true;
        }
    }
}
