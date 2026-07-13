package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.AdRequestParcel;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzhu extends zzim implements zzhv, zzhy {
    private final Context mContext;
    private final String zzCd;
    private final zzif.zza zzGd;
    private final zzia zzKB;
    private final zzhy zzKC;
    private final String zzKD;
    private final String zzKE;
    private final String zzrG;
    private int zzKF = 0;
    private int zzGu = 3;
    private final Object zzpV = new Object();

    public zzhu(Context context, String str, String str2, String str3, String str4, zzif.zza zzaVar, zzia zziaVar, zzhy zzhyVar) {
        this.mContext = context;
        this.zzCd = str;
        this.zzrG = str2;
        this.zzKD = str3;
        this.zzKE = str4;
        this.zzGd = zzaVar;
        this.zzKB = zziaVar;
        this.zzKC = zzhyVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zza(AdRequestParcel adRequestParcel, zzey zzeyVar) {
        try {
            if ("com.google.ads.mediation.admob.AdMobAdapter".equals(this.zzCd)) {
                zzeyVar.zza(adRequestParcel, this.zzKD, this.zzKE);
            } else {
                zzeyVar.zzb(adRequestParcel, this.zzKD);
            }
        } catch (RemoteException e) {
            zzin.zzd("Fail to load ad from adapter.", e);
            zza(this.zzCd, 0);
        }
    }

    private void zzk(long j) {
        while (true) {
            synchronized (this.zzpV) {
                if (this.zzKF != 0) {
                    return;
                }
                if (!zzf(j)) {
                    return;
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.zzim
    public void onStop() {
    }

    @Override // com.google.android.gms.internal.zzhv
    public void zzN(int i) {
        zza(this.zzCd, 0);
    }

    @Override // com.google.android.gms.internal.zzhy
    public void zza(String str, int i) {
        synchronized (this.zzpV) {
            this.zzKF = 2;
            this.zzGu = i;
            this.zzpV.notify();
        }
    }

    @Override // com.google.android.gms.internal.zzhy
    public void zzax(String str) {
        synchronized (this.zzpV) {
            this.zzKF = 1;
            this.zzpV.notify();
        }
    }

    @Override // com.google.android.gms.internal.zzim
    public void zzbr() {
        if (this.zzKB == null || this.zzKB.zzgQ() == null || this.zzKB.zzgP() == null) {
            return;
        }
        final zzhx zzhxVarZzgQ = this.zzKB.zzgQ();
        zzhxVarZzgQ.zza((zzhy) this);
        zzhxVarZzgQ.zza((zzhv) this);
        final AdRequestParcel adRequestParcel = this.zzGd.zzLd.zzHt;
        final zzey zzeyVarZzgP = this.zzKB.zzgP();
        try {
            if (zzeyVarZzgP.isInitialized()) {
                com.google.android.gms.ads.internal.util.client.zza.zzMS.post(new Runnable() { // from class: com.google.android.gms.internal.zzhu.1
                    @Override // java.lang.Runnable
                    public void run() {
                        zzhu.this.zza(adRequestParcel, zzeyVarZzgP);
                    }
                });
            } else {
                com.google.android.gms.ads.internal.util.client.zza.zzMS.post(new Runnable() { // from class: com.google.android.gms.internal.zzhu.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            zzeyVarZzgP.zza(com.google.android.gms.dynamic.zze.zzC(zzhu.this.mContext), adRequestParcel, zzhu.this.zzrG, zzhxVarZzgQ, zzhu.this.zzKD);
                        } catch (RemoteException e) {
                            zzin.zzd("Fail to initialize adapter " + zzhu.this.zzCd, e);
                            zzhu.this.zza(zzhu.this.zzCd, 0);
                        }
                    }
                });
            }
        } catch (RemoteException e) {
            zzin.zzd("Fail to check if adapter is initialized.", e);
            zza(this.zzCd, 0);
        }
        zzk(com.google.android.gms.ads.internal.zzr.zzbG().elapsedRealtime());
        zzhxVarZzgQ.zza((zzhy) null);
        zzhxVarZzgQ.zza((zzhv) null);
        if (this.zzKF == 1) {
            this.zzKC.zzax(this.zzCd);
        } else {
            this.zzKC.zza(this.zzCd, this.zzGu);
        }
    }

    protected boolean zzf(long j) {
        long jElapsedRealtime = 20000 - (com.google.android.gms.ads.internal.zzr.zzbG().elapsedRealtime() - j);
        if (jElapsedRealtime <= 0) {
            return false;
        }
        try {
            this.zzpV.wait(jElapsedRealtime);
            return true;
        } catch (InterruptedException e) {
            return false;
        }
    }

    @Override // com.google.android.gms.internal.zzhv
    public void zzgN() {
        zza(this.zzGd.zzLd.zzHt, this.zzKB.zzgP());
    }
}
