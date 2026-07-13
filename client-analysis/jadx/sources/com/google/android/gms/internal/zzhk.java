package com.google.android.gms.internal;

import android.content.Context;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public final class zzhk {
    private WeakHashMap<Context, zza> zzKm = new WeakHashMap<>();

    private class zza {
        public final long zzKn = com.google.android.gms.ads.internal.zzr.zzbG().currentTimeMillis();
        public final zzhj zzKo;

        public zza(zzhj zzhjVar) {
            this.zzKo = zzhjVar;
        }

        public boolean hasExpired() {
            return zzbt.zzwM.get().longValue() + this.zzKn < com.google.android.gms.ads.internal.zzr.zzbG().currentTimeMillis();
        }
    }

    public zzhj zzE(Context context) {
        zza zzaVar = this.zzKm.get(context);
        zzhj zzhjVarZzgI = (zzaVar == null || zzaVar.hasExpired() || !zzbt.zzwL.get().booleanValue()) ? new zzhj.zza(context).zzgI() : new zzhj.zza(context, zzaVar.zzKo).zzgI();
        this.zzKm.put(context, new zza(zzhjVarZzgI));
        return zzhjVarZzgI;
    }
}
