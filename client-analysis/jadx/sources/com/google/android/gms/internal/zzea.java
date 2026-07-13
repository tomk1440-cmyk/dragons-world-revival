package com.google.android.gms.internal;

import android.content.MutableContextWrapper;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
@zzhb
class zzea {
    private final LinkedList<zza> zzAB;
    private final int zzAC;
    private final String zzpS;
    private AdRequestParcel zzqH;

    class zza {
        com.google.android.gms.ads.internal.zzk zzAD;
        zzdw zzAE;
        long zzAF;
        boolean zzAG;
        boolean zzAH;
        MutableContextWrapper zzAb;

        zza(zzdv zzdvVar) {
            zzdv zzdvVarZzec = zzdvVar.zzec();
            this.zzAb = zzdvVar.zzed();
            this.zzAD = zzdvVarZzec.zzX(zzea.this.zzpS);
            this.zzAE = new zzdw();
            this.zzAE.zzc(this.zzAD);
        }

        private void zzek() {
            if (this.zzAG || zzea.this.zzqH == null) {
                return;
            }
            this.zzAH = this.zzAD.zzb(zzea.this.zzqH);
            this.zzAG = true;
            this.zzAF = com.google.android.gms.ads.internal.zzr.zzbG().currentTimeMillis();
        }

        void zzc(zzdv zzdvVar) {
            this.zzAb.setBaseContext(zzdvVar.zzed().getBaseContext());
        }

        void zzh(AdRequestParcel adRequestParcel) {
            if (adRequestParcel != null) {
                zzea.this.zzqH = adRequestParcel;
            }
            zzek();
            Iterator it = zzea.this.zzAB.iterator();
            while (it.hasNext()) {
                ((zza) it.next()).zzek();
            }
        }
    }

    zzea(AdRequestParcel adRequestParcel, String str, int i) {
        com.google.android.gms.common.internal.zzx.zzz(adRequestParcel);
        com.google.android.gms.common.internal.zzx.zzz(str);
        this.zzAB = new LinkedList<>();
        this.zzqH = adRequestParcel;
        this.zzpS = str;
        this.zzAC = i;
    }

    String getAdUnitId() {
        return this.zzpS;
    }

    int getNetworkType() {
        return this.zzAC;
    }

    int size() {
        return this.zzAB.size();
    }

    void zzb(zzdv zzdvVar) {
        zza zzaVar = new zza(zzdvVar);
        this.zzAB.add(zzaVar);
        zzaVar.zzh(this.zzqH);
    }

    AdRequestParcel zzei() {
        return this.zzqH;
    }

    zza zzej() {
        return this.zzAB.remove();
    }
}
