package com.google.android.gms.tagmanager;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
abstract class zzcz extends zzca {
    public zzcz(String str) {
        super(str);
    }

    @Override // com.google.android.gms.tagmanager.zzca
    protected boolean zza(com.google.android.gms.internal.zzag.zza zzaVar, com.google.android.gms.internal.zzag.zza zzaVar2, Map<String, com.google.android.gms.internal.zzag.zza> map) {
        String strZzg = zzdf.zzg(zzaVar);
        String strZzg2 = zzdf.zzg(zzaVar2);
        if (strZzg == zzdf.zzHE() || strZzg2 == zzdf.zzHE()) {
            return false;
        }
        return zza(strZzg, strZzg2, map);
    }

    protected abstract boolean zza(String str, String str2, Map<String, com.google.android.gms.internal.zzag.zza> map);
}
