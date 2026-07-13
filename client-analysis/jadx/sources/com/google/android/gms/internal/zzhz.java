package com.google.android.gms.internal;

import android.content.Context;
import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzhz extends zzim implements zzhy {
    private final Context mContext;
    private final zzif.zza zzGd;
    private final zzht zzKO;
    private final String zzrG;
    private final ArrayList<Future> zzKL = new ArrayList<>();
    private final ArrayList<String> zzKM = new ArrayList<>();
    private final HashSet<String> zzKN = new HashSet<>();
    private final Object zzpV = new Object();

    public zzhz(Context context, String str, zzif.zza zzaVar, zzht zzhtVar) {
        this.mContext = context;
        this.zzrG = str;
        this.zzGd = zzaVar;
        this.zzKO = zzhtVar;
    }

    private zzif zza(int i, @Nullable String str, @Nullable zzen zzenVar) {
        return new zzif(this.zzGd.zzLd.zzHt, null, this.zzGd.zzLe.zzBQ, i, this.zzGd.zzLe.zzBR, this.zzGd.zzLe.zzHV, this.zzGd.zzLe.orientation, this.zzGd.zzLe.zzBU, this.zzGd.zzLd.zzHw, this.zzGd.zzLe.zzHT, zzenVar, null, str, this.zzGd.zzKV, null, this.zzGd.zzLe.zzHU, this.zzGd.zzrp, this.zzGd.zzLe.zzHS, this.zzGd.zzKY, this.zzGd.zzLe.zzHX, this.zzGd.zzLe.zzHY, this.zzGd.zzKT, null, this.zzGd.zzLe.zzIj, this.zzGd.zzLe.zzIk, this.zzGd.zzLe.zzIl, this.zzGd.zzLe.zzIm);
    }

    private zzif zza(String str, zzen zzenVar) {
        return zza(-2, str, zzenVar);
    }

    private void zzd(String str, String str2, String str3) {
        synchronized (this.zzpV) {
            zzia zziaVarZzaw = this.zzKO.zzaw(str);
            if (zziaVarZzaw == null || zziaVarZzaw.zzgQ() == null || zziaVarZzaw.zzgP() == null) {
                return;
            }
            this.zzKL.add(new zzhu(this.mContext, str, this.zzrG, str2, str3, this.zzGd, zziaVarZzaw, this).zzgd());
            this.zzKM.add(str);
        }
    }

    private zzif zzgO() {
        return zza(3, null, null);
    }

    @Override // com.google.android.gms.internal.zzim
    public void onStop() {
    }

    @Override // com.google.android.gms.internal.zzhy
    public void zza(String str, int i) {
    }

    @Override // com.google.android.gms.internal.zzhy
    public void zzax(String str) {
        synchronized (this.zzpV) {
            this.zzKN.add(str);
        }
    }

    @Override // com.google.android.gms.internal.zzim
    public void zzbr() {
        for (zzen zzenVar : this.zzGd.zzKV.zzBO) {
            String str = zzenVar.zzBG;
            Iterator<String> it = zzenVar.zzBB.iterator();
            while (it.hasNext()) {
                zzd(it.next(), str, zzenVar.zzBz);
            }
        }
        for (int i = 0; i < this.zzKL.size(); i++) {
            try {
                this.zzKL.get(i).get();
                synchronized (this.zzpV) {
                    if (this.zzKN.contains(this.zzKM.get(i))) {
                        final zzif zzifVarZza = zza(this.zzKM.get(i), this.zzGd.zzKV.zzBO.get(i));
                        com.google.android.gms.ads.internal.util.client.zza.zzMS.post(new Runnable() { // from class: com.google.android.gms.internal.zzhz.1
                            @Override // java.lang.Runnable
                            public void run() {
                                zzhz.this.zzKO.zzb(zzifVarZza);
                            }
                        });
                        return;
                    }
                }
            } catch (InterruptedException e) {
            } catch (Exception e2) {
            }
        }
        final zzif zzifVarZzgO = zzgO();
        com.google.android.gms.ads.internal.util.client.zza.zzMS.post(new Runnable() { // from class: com.google.android.gms.internal.zzhz.2
            @Override // java.lang.Runnable
            public void run() {
                zzhz.this.zzKO.zzb(zzifVarZzgO);
            }
        });
    }
}
