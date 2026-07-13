package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzeu implements zzem {
    private final Context mContext;
    private final zzeo zzCf;
    private final AdRequestInfoParcel zzCu;
    private final long zzCv;
    private final long zzCw;
    private final int zzCx;
    private final zzex zzpn;
    private final boolean zzsA;
    private final boolean zzuS;
    private final Object zzpV = new Object();
    private boolean zzCy = false;
    private final Map<zzjg<zzes>, zzer> zzCz = new HashMap();

    public zzeu(Context context, AdRequestInfoParcel adRequestInfoParcel, zzex zzexVar, zzeo zzeoVar, boolean z, boolean z2, long j, long j2, int i) {
        this.mContext = context;
        this.zzCu = adRequestInfoParcel;
        this.zzpn = zzexVar;
        this.zzCf = zzeoVar;
        this.zzsA = z;
        this.zzuS = z2;
        this.zzCv = j;
        this.zzCw = j2;
        this.zzCx = i;
    }

    private void zza(final zzjg<zzes> zzjgVar) {
        zzir.zzMc.post(new Runnable() { // from class: com.google.android.gms.internal.zzeu.2
            @Override // java.lang.Runnable
            public void run() {
                for (zzjg zzjgVar2 : zzeu.this.zzCz.keySet()) {
                    if (zzjgVar2 != zzjgVar) {
                        ((zzer) zzeu.this.zzCz.get(zzjgVar2)).cancel();
                    }
                }
            }
        });
    }

    private zzes zzd(List<zzjg<zzes>> list) {
        synchronized (this.zzpV) {
            if (this.zzCy) {
                return new zzes(-1);
            }
            for (zzjg<zzes> zzjgVar : list) {
                try {
                    zzes zzesVar = zzjgVar.get();
                    if (zzesVar != null && zzesVar.zzCo == 0) {
                        zza(zzjgVar);
                        return zzesVar;
                    }
                } catch (InterruptedException | ExecutionException e) {
                    zzin.zzd("Exception while processing an adapter; continuing with other adapters", e);
                }
            }
            zza((zzjg<zzes>) null);
            return new zzes(1);
        }
    }

    /* JADX WARN: Code duplicated, block: B:36:0x0081 A[Catch: RemoteException -> 0x008a, all -> 0x00a2, InterruptedException -> 0x00c1, ExecutionException -> 0x00c3, RemoteException | InterruptedException | ExecutionException | TimeoutException -> 0x00c5, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x00a2, blocks: (B:18:0x0040, B:20:0x0046, B:22:0x004e, B:24:0x0052, B:26:0x0056, B:28:0x005c, B:36:0x0081, B:39:0x008b), top: B:54:0x0040 }] */
    private zzes zze(List<zzjg<zzes>> list) {
        zzes zzesVar;
        zzes zzesVar2;
        zzjg<zzes> zzjgVar;
        int iZzeD;
        zzfa zzfaVar;
        synchronized (this.zzpV) {
            if (this.zzCy) {
                return new zzes(-1);
            }
            int i = -1;
            zzjg<zzes> zzjgVar2 = null;
            zzes zzesVar3 = null;
            long jMax = this.zzCf.zzBY != -1 ? this.zzCf.zzBY : 10000L;
            Iterator<zzjg<zzes>> it = list.iterator();
            while (true) {
                long j = jMax;
                if (!it.hasNext()) {
                    break;
                }
                zzjg<zzes> next = it.next();
                long jCurrentTimeMillis = com.google.android.gms.ads.internal.zzr.zzbG().currentTimeMillis();
                if (j == 0) {
                    try {
                        try {
                            if (next.isDone()) {
                                zzesVar = next.get();
                            } else {
                                zzesVar = next.get(j, TimeUnit.MILLISECONDS);
                            }
                        } catch (Throwable th) {
                            Math.max(j - (com.google.android.gms.ads.internal.zzr.zzbG().currentTimeMillis() - jCurrentTimeMillis), 0L);
                            throw th;
                        }
                    } catch (RemoteException | InterruptedException | ExecutionException | TimeoutException e) {
                        zzin.zzd("Exception while processing an adapter; continuing with other adapters", e);
                        jMax = Math.max(j - (com.google.android.gms.ads.internal.zzr.zzbG().currentTimeMillis() - jCurrentTimeMillis), 0L);
                    }
                } else {
                    zzesVar = next.get(j, TimeUnit.MILLISECONDS);
                }
                if (zzesVar == null || zzesVar.zzCo != 0 || (zzfaVar = zzesVar.zzCt) == null || zzfaVar.zzeD() <= i) {
                    zzesVar2 = zzesVar3;
                    zzjgVar = zzjgVar2;
                    iZzeD = i;
                } else {
                    iZzeD = zzfaVar.zzeD();
                    zzes zzesVar4 = zzesVar;
                    zzjgVar = next;
                    zzesVar2 = zzesVar4;
                }
                zzjgVar2 = zzjgVar;
                zzes zzesVar5 = zzesVar2;
                jMax = Math.max(j - (com.google.android.gms.ads.internal.zzr.zzbG().currentTimeMillis() - jCurrentTimeMillis), 0L);
                i = iZzeD;
                zzesVar3 = zzesVar5;
            }
            zza(zzjgVar2);
            return zzesVar3 == null ? new zzes(1) : zzesVar3;
        }
    }

    @Override // com.google.android.gms.internal.zzem
    public void cancel() {
        synchronized (this.zzpV) {
            this.zzCy = true;
            Iterator<zzer> it = this.zzCz.values().iterator();
            while (it.hasNext()) {
                it.next().cancel();
            }
        }
    }

    @Override // com.google.android.gms.internal.zzem
    public zzes zzc(List<zzen> list) {
        zzin.zzaI("Starting mediation.");
        ExecutorService executorServiceNewCachedThreadPool = Executors.newCachedThreadPool();
        ArrayList arrayList = new ArrayList();
        for (zzen zzenVar : list) {
            zzin.zzaJ("Trying mediation network: " + zzenVar.zzBA);
            Iterator<String> it = zzenVar.zzBB.iterator();
            while (it.hasNext()) {
                final zzer zzerVar = new zzer(this.mContext, it.next(), this.zzpn, this.zzCf, zzenVar, this.zzCu.zzHt, this.zzCu.zzrp, this.zzCu.zzrl, this.zzsA, this.zzuS, this.zzCu.zzrD, this.zzCu.zzrH);
                zzjg<zzes> zzjgVarZza = zziq.zza(executorServiceNewCachedThreadPool, new Callable<zzes>() { // from class: com.google.android.gms.internal.zzeu.1
                    @Override // java.util.concurrent.Callable
                    /* JADX INFO: renamed from: zzeE, reason: merged with bridge method [inline-methods] */
                    public zzes call() throws Exception {
                        synchronized (zzeu.this.zzpV) {
                            if (zzeu.this.zzCy) {
                                return null;
                            }
                            return zzerVar.zza(zzeu.this.zzCv, zzeu.this.zzCw);
                        }
                    }
                });
                this.zzCz.put(zzjgVarZza, zzerVar);
                arrayList.add(zzjgVarZza);
            }
        }
        switch (this.zzCx) {
            case 2:
                return zze(arrayList);
            default:
                return zzd(arrayList);
        }
    }
}
