package com.google.android.gms.tagmanager;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
abstract class zzbv extends zzca {
    public zzbv(String str) {
        super(str);
    }

    @Override // com.google.android.gms.tagmanager.zzca
    protected boolean zza(com.google.android.gms.internal.zzag.zza zzaVar, com.google.android.gms.internal.zzag.zza zzaVar2, Map<String, com.google.android.gms.internal.zzag.zza> map) {
        zzde zzdeVarZzh = zzdf.zzh(zzaVar);
        zzde zzdeVarZzh2 = zzdf.zzh(zzaVar2);
        if (zzdeVarZzh == zzdf.zzHD() || zzdeVarZzh2 == zzdf.zzHD()) {
            return false;
        }
        return zza(zzdeVarZzh, zzdeVarZzh2, map);
    }

    protected abstract boolean zza(zzde zzdeVar, zzde zzdeVar2, Map<String, com.google.android.gms.internal.zzag.zza> map);
}
