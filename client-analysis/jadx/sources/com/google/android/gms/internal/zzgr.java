package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.request.AdResponseParcel;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzgr {

    public interface zza {
        void zzb(zzif zzifVar);
    }

    public zzit zza(Context context, com.google.android.gms.ads.internal.zza zzaVar, zzif.zza zzaVar2, zzan zzanVar, zzjp zzjpVar, zzex zzexVar, zza zzaVar3, zzcb zzcbVar) {
        zzit zzgtVar;
        AdResponseParcel adResponseParcel = zzaVar2.zzLe;
        if (adResponseParcel.zzHT) {
            zzgtVar = new zzgu(context, zzaVar2, zzexVar, zzaVar3, zzcbVar, zzjpVar);
        } else if (adResponseParcel.zzuk) {
            if (!(zzaVar instanceof com.google.android.gms.ads.internal.zzp)) {
                throw new IllegalArgumentException("Invalid NativeAdManager type. Found: " + (zzaVar != null ? zzaVar.getClass().getName() : "null") + "; Required: NativeAdManager.");
            }
            zzgtVar = new zzgv(context, (com.google.android.gms.ads.internal.zzp) zzaVar, new zzee(), zzaVar2, zzanVar, zzaVar3);
        } else if (adResponseParcel.zzHZ) {
            zzgtVar = new zzgp(context, zzaVar2, zzjpVar, zzaVar3);
        } else {
            zzgtVar = (zzbt.zzwu.get().booleanValue() && zzne.zzsk() && !zzne.isAtLeastL() && zzjpVar.zzaN().zzui) ? new zzgt(context, zzaVar2, zzjpVar, zzaVar3) : new zzgs(context, zzaVar2, zzjpVar, zzaVar3);
        }
        zzin.zzaI("AdRenderer: " + zzgtVar.getClass().getName());
        zzgtVar.zzgd();
        return zzgtVar;
    }

    public zzit zza(Context context, String str, zzif.zza zzaVar, zzht zzhtVar) {
        zzhz zzhzVar = new zzhz(context, str, zzaVar, zzhtVar);
        zzin.zzaI("AdRenderer: " + zzhzVar.getClass().getName());
        zzhzVar.zzgd();
        return zzhzVar;
    }
}
