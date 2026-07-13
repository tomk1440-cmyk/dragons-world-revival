package com.google.android.gms.tagmanager;

import android.content.Context;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
class zzcm implements zzp.zze {
    private boolean mClosed;
    private final Context mContext;
    private final String zzbhM;
    private String zzbij;
    private zzbf<com.google.android.gms.internal.zzaf.zzj> zzbkg;
    private zzs zzbkh;
    private final ScheduledExecutorService zzbkj;
    private final zza zzbkk;
    private ScheduledFuture<?> zzbkl;

    interface zza {
        zzcl zza(zzs zzsVar);
    }

    interface zzb {
        ScheduledExecutorService zzHb();
    }

    public zzcm(Context context, String str, zzs zzsVar) {
        this(context, str, zzsVar, null, null);
    }

    zzcm(Context context, String str, zzs zzsVar, zzb zzbVar, zza zzaVar) {
        this.zzbkh = zzsVar;
        this.mContext = context;
        this.zzbhM = str;
        this.zzbkj = (zzbVar == null ? new zzb() { // from class: com.google.android.gms.tagmanager.zzcm.1
            @Override // com.google.android.gms.tagmanager.zzcm.zzb
            public ScheduledExecutorService zzHb() {
                return Executors.newSingleThreadScheduledExecutor();
            }
        } : zzbVar).zzHb();
        if (zzaVar == null) {
            this.zzbkk = new zza() { // from class: com.google.android.gms.tagmanager.zzcm.2
                @Override // com.google.android.gms.tagmanager.zzcm.zza
                public zzcl zza(zzs zzsVar2) {
                    return new zzcl(zzcm.this.mContext, zzcm.this.zzbhM, zzsVar2);
                }
            };
        } else {
            this.zzbkk = zzaVar;
        }
    }

    private synchronized void zzHa() {
        if (this.mClosed) {
            throw new IllegalStateException("called method after closed");
        }
    }

    private zzcl zzgm(String str) {
        zzcl zzclVarZza = this.zzbkk.zza(this.zzbkh);
        zzclVarZza.zza(this.zzbkg);
        zzclVarZza.zzfW(this.zzbij);
        zzclVarZza.zzgl(str);
        return zzclVarZza;
    }

    @Override // com.google.android.gms.common.api.Releasable
    public synchronized void release() {
        zzHa();
        if (this.zzbkl != null) {
            this.zzbkl.cancel(false);
        }
        this.zzbkj.shutdown();
        this.mClosed = true;
    }

    @Override // com.google.android.gms.tagmanager.zzp.zze
    public synchronized void zza(zzbf<com.google.android.gms.internal.zzaf.zzj> zzbfVar) {
        zzHa();
        this.zzbkg = zzbfVar;
    }

    @Override // com.google.android.gms.tagmanager.zzp.zze
    public synchronized void zzf(long j, String str) {
        zzbg.v("loadAfterDelay: containerId=" + this.zzbhM + " delay=" + j);
        zzHa();
        if (this.zzbkg == null) {
            throw new IllegalStateException("callback must be set before loadAfterDelay() is called.");
        }
        if (this.zzbkl != null) {
            this.zzbkl.cancel(false);
        }
        this.zzbkl = this.zzbkj.schedule(zzgm(str), j, TimeUnit.MILLISECONDS);
    }

    @Override // com.google.android.gms.tagmanager.zzp.zze
    public synchronized void zzfW(String str) {
        zzHa();
        this.zzbij = str;
    }
}
