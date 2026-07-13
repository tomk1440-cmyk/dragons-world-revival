package com.google.android.gms.internal;

import android.content.Context;
import android.os.SystemClock;
import com.google.android.gms.ads.internal.request.AdResponseParcel;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public abstract class zzgq extends zzim {
    protected final Context mContext;
    protected final zzgr.zza zzGc;
    protected final zzif.zza zzGd;
    protected AdResponseParcel zzGe;
    protected final Object zzGg;
    protected final Object zzpV;

    protected static final class zza extends Exception {
        private final int zzGu;

        public zza(String str, int i) {
            super(str);
            this.zzGu = i;
        }

        public int getErrorCode() {
            return this.zzGu;
        }
    }

    protected zzgq(Context context, zzif.zza zzaVar, zzgr.zza zzaVar2) {
        super(true);
        this.zzpV = new Object();
        this.zzGg = new Object();
        this.mContext = context;
        this.zzGd = zzaVar;
        this.zzGe = zzaVar.zzLe;
        this.zzGc = zzaVar2;
    }

    @Override // com.google.android.gms.internal.zzim
    public void onStop() {
    }

    protected abstract zzif zzD(int i);

    @Override // com.google.android.gms.internal.zzim
    public void zzbr() {
        synchronized (this.zzpV) {
            zzin.zzaI("AdRendererBackgroundTask started.");
            int i = this.zzGd.errorCode;
            try {
                zzh(SystemClock.elapsedRealtime());
            } catch (zza e) {
                int errorCode = e.getErrorCode();
                if (errorCode == 3 || errorCode == -1) {
                    zzin.zzaJ(e.getMessage());
                } else {
                    zzin.zzaK(e.getMessage());
                }
                if (this.zzGe == null) {
                    this.zzGe = new AdResponseParcel(errorCode);
                } else {
                    this.zzGe = new AdResponseParcel(errorCode, this.zzGe.zzBU);
                }
                zzir.zzMc.post(new Runnable() { // from class: com.google.android.gms.internal.zzgq.1
                    @Override // java.lang.Runnable
                    public void run() {
                        zzgq.this.onStop();
                    }
                });
                i = errorCode;
            }
            final zzif zzifVarZzD = zzD(i);
            zzir.zzMc.post(new Runnable() { // from class: com.google.android.gms.internal.zzgq.2
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (zzgq.this.zzpV) {
                        zzgq.this.zzm(zzifVarZzD);
                    }
                }
            });
        }
    }

    protected abstract void zzh(long j) throws zza;

    protected void zzm(zzif zzifVar) {
        this.zzGc.zzb(zzifVar);
    }
}
