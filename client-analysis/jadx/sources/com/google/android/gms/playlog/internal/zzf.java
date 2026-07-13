package com.google.android.gms.playlog.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzsu;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class zzf extends zzj<zza> {
    private final String zzTJ;
    private final zzd zzbdT;
    private final zzb zzbdU;
    private boolean zzbdV;
    private final Object zzpV;

    public zzf(Context context, Looper looper, zzd zzdVar, com.google.android.gms.common.internal.zzf zzfVar) {
        super(context, looper, 24, zzfVar, zzdVar, zzdVar);
        this.zzTJ = context.getPackageName();
        this.zzbdT = (zzd) zzx.zzz(zzdVar);
        this.zzbdT.zza(this);
        this.zzbdU = new zzb();
        this.zzpV = new Object();
        this.zzbdV = true;
    }

    private void zzEW() {
        PlayLoggerContext playLoggerContext;
        com.google.android.gms.common.internal.zzb.zzab(!this.zzbdV);
        if (this.zzbdU.isEmpty()) {
            return;
        }
        PlayLoggerContext playLoggerContext2 = null;
        try {
            ArrayList arrayList = new ArrayList();
            for (zzb.zza zzaVar : this.zzbdU.zzEU()) {
                if (zzaVar.zzbdI != null) {
                    zzqJ().zza(this.zzTJ, zzaVar.zzbdG, zzsu.toByteArray(zzaVar.zzbdI));
                } else {
                    if (zzaVar.zzbdG.equals(playLoggerContext2)) {
                        arrayList.add(zzaVar.zzbdH);
                        playLoggerContext = playLoggerContext2;
                    } else {
                        if (!arrayList.isEmpty()) {
                            zzqJ().zza(this.zzTJ, playLoggerContext2, arrayList);
                            arrayList.clear();
                        }
                        PlayLoggerContext playLoggerContext3 = zzaVar.zzbdG;
                        arrayList.add(zzaVar.zzbdH);
                        playLoggerContext = playLoggerContext3;
                    }
                    playLoggerContext2 = playLoggerContext;
                }
            }
            if (!arrayList.isEmpty()) {
                zzqJ().zza(this.zzTJ, playLoggerContext2, arrayList);
            }
            this.zzbdU.clear();
        } catch (RemoteException e) {
            Log.e("PlayLoggerImpl", "Couldn't send cached log events to AndroidLog service.  Retaining in memory cache.");
        }
    }

    private void zzc(PlayLoggerContext playLoggerContext, LogEvent logEvent) {
        this.zzbdU.zza(playLoggerContext, logEvent);
    }

    private void zzd(PlayLoggerContext playLoggerContext, LogEvent logEvent) {
        try {
            zzEW();
            zzqJ().zza(this.zzTJ, playLoggerContext, logEvent);
        } catch (RemoteException e) {
            Log.e("PlayLoggerImpl", "Couldn't send log event.  Will try caching.");
            zzc(playLoggerContext, logEvent);
        } catch (IllegalStateException e2) {
            Log.e("PlayLoggerImpl", "Service was disconnected.  Will try caching.");
            zzc(playLoggerContext, logEvent);
        }
    }

    public void start() {
        synchronized (this.zzpV) {
            if (isConnecting() || isConnected()) {
                return;
            }
            this.zzbdT.zzat(true);
            zzqG();
        }
    }

    public void stop() {
        synchronized (this.zzpV) {
            this.zzbdT.zzat(false);
            disconnect();
        }
    }

    void zzau(boolean z) {
        synchronized (this.zzpV) {
            boolean z2 = this.zzbdV;
            this.zzbdV = z;
            if (z2 && !this.zzbdV) {
                zzEW();
            }
        }
    }

    public void zzb(PlayLoggerContext playLoggerContext, LogEvent logEvent) {
        synchronized (this.zzpV) {
            if (this.zzbdV) {
                zzc(playLoggerContext, logEvent);
            } else {
                zzd(playLoggerContext, logEvent);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzj
    /* JADX INFO: renamed from: zzdO, reason: merged with bridge method [inline-methods] */
    public zza zzW(IBinder iBinder) {
        return zza.AbstractBinderC0265zza.zzdN(iBinder);
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzgu() {
        return "com.google.android.gms.playlog.service.START";
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzgv() {
        return "com.google.android.gms.playlog.internal.IPlayLogService";
    }
}
