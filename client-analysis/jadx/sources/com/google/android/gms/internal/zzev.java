package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzev implements zzem {
    private final Context mContext;
    private zzer zzCD;
    private final zzeo zzCf;
    private final AdRequestInfoParcel zzCu;
    private final long zzCv;
    private final long zzCw;
    private final zzcb zzpe;
    private final zzex zzpn;
    private final boolean zzsA;
    private final boolean zzuS;
    private final Object zzpV = new Object();
    private boolean zzCy = false;

    public zzev(Context context, AdRequestInfoParcel adRequestInfoParcel, zzex zzexVar, zzeo zzeoVar, boolean z, boolean z2, long j, long j2, zzcb zzcbVar) {
        this.mContext = context;
        this.zzCu = adRequestInfoParcel;
        this.zzpn = zzexVar;
        this.zzCf = zzeoVar;
        this.zzsA = z;
        this.zzuS = z2;
        this.zzCv = j;
        this.zzCw = j2;
        this.zzpe = zzcbVar;
    }

    @Override // com.google.android.gms.internal.zzem
    public void cancel() {
        synchronized (this.zzpV) {
            this.zzCy = true;
            if (this.zzCD != null) {
                this.zzCD.cancel();
            }
        }
    }

    @Override // com.google.android.gms.internal.zzem
    public zzes zzc(List<zzen> list) {
        zzin.zzaI("Starting mediation.");
        ArrayList arrayList = new ArrayList();
        zzbz zzbzVarZzdB = this.zzpe.zzdB();
        for (zzen zzenVar : list) {
            zzin.zzaJ("Trying mediation network: " + zzenVar.zzBA);
            for (String str : zzenVar.zzBB) {
                zzbz zzbzVarZzdB2 = this.zzpe.zzdB();
                synchronized (this.zzpV) {
                    if (this.zzCy) {
                        return new zzes(-1);
                    }
                    this.zzCD = new zzer(this.mContext, str, this.zzpn, this.zzCf, zzenVar, this.zzCu.zzHt, this.zzCu.zzrp, this.zzCu.zzrl, this.zzsA, this.zzuS, this.zzCu.zzrD, this.zzCu.zzrH);
                    final zzes zzesVarZza = this.zzCD.zza(this.zzCv, this.zzCw);
                    if (zzesVarZza.zzCo == 0) {
                        zzin.zzaI("Adapter succeeded.");
                        this.zzpe.zzc("mediation_network_succeed", str);
                        if (!arrayList.isEmpty()) {
                            this.zzpe.zzc("mediation_networks_fail", TextUtils.join(",", arrayList));
                        }
                        this.zzpe.zza(zzbzVarZzdB2, "mls");
                        this.zzpe.zza(zzbzVarZzdB, "ttm");
                        return zzesVarZza;
                    }
                    arrayList.add(str);
                    this.zzpe.zza(zzbzVarZzdB2, "mlf");
                    if (zzesVarZza.zzCq != null) {
                        zzir.zzMc.post(new Runnable() { // from class: com.google.android.gms.internal.zzev.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    zzesVarZza.zzCq.destroy();
                                } catch (RemoteException e) {
                                    zzin.zzd("Could not destroy mediation adapter.", e);
                                }
                            }
                        });
                    }
                }
            }
        }
        if (!arrayList.isEmpty()) {
            this.zzpe.zzc("mediation_networks_fail", TextUtils.join(",", arrayList));
        }
        return new zzes(1);
    }
}
