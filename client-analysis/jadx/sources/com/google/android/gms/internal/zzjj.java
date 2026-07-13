package com.google.android.gms.internal;

import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzjj<T> implements zzji<T> {
    protected T zzNr;
    private final Object zzpV = new Object();
    protected int zzBc = 0;
    protected final BlockingQueue<zzjj<T>.zza> zzNq = new LinkedBlockingQueue();

    class zza {
        public final zzji.zzc<T> zzNs;
        public final zzji.zza zzNt;

        public zza(zzji.zzc<T> zzcVar, zzji.zza zzaVar) {
            this.zzNs = zzcVar;
            this.zzNt = zzaVar;
        }
    }

    public int getStatus() {
        return this.zzBc;
    }

    public void reject() {
        synchronized (this.zzpV) {
            if (this.zzBc != 0) {
                throw new UnsupportedOperationException();
            }
            this.zzBc = -1;
            Iterator it = this.zzNq.iterator();
            while (it.hasNext()) {
                ((zza) it.next()).zzNt.run();
            }
            this.zzNq.clear();
        }
    }

    @Override // com.google.android.gms.internal.zzji
    public void zza(zzji.zzc<T> zzcVar, zzji.zza zzaVar) {
        synchronized (this.zzpV) {
            if (this.zzBc == 1) {
                zzcVar.zze(this.zzNr);
            } else if (this.zzBc == -1) {
                zzaVar.run();
            } else if (this.zzBc == 0) {
                this.zzNq.add(new zza(zzcVar, zzaVar));
            }
        }
    }

    @Override // com.google.android.gms.internal.zzji
    public void zzh(T t) {
        synchronized (this.zzpV) {
            if (this.zzBc != 0) {
                throw new UnsupportedOperationException();
            }
            this.zzNr = t;
            this.zzBc = 1;
            Iterator it = this.zzNq.iterator();
            while (it.hasNext()) {
                ((zza) it.next()).zzNs.zze(t);
            }
            this.zzNq.clear();
        }
    }
}
