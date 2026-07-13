package com.google.android.gms.tagmanager;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class zzcc extends zzak {
    private static final String ID = com.google.android.gms.internal.zzad.RANDOM.toString();
    private static final String zzbjY = com.google.android.gms.internal.zzae.MIN.toString();
    private static final String zzbjZ = com.google.android.gms.internal.zzae.MAX.toString();

    public zzcc() {
        super(ID, new String[0]);
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public boolean zzFW() {
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x005c  */
    @Override // com.google.android.gms.tagmanager.zzak
    public com.google.android.gms.internal.zzag.zza zzP(Map<String, com.google.android.gms.internal.zzag.zza> map) {
        double dDoubleValue;
        double d;
        com.google.android.gms.internal.zzag.zza zzaVar = map.get(zzbjY);
        com.google.android.gms.internal.zzag.zza zzaVar2 = map.get(zzbjZ);
        if (zzaVar == null || zzaVar == zzdf.zzHF() || zzaVar2 == null || zzaVar2 == zzdf.zzHF()) {
            dDoubleValue = 2.147483647E9d;
            d = 0.0d;
        } else {
            zzde zzdeVarZzh = zzdf.zzh(zzaVar);
            zzde zzdeVarZzh2 = zzdf.zzh(zzaVar2);
            if (zzdeVarZzh == zzdf.zzHD() || zzdeVarZzh2 == zzdf.zzHD()) {
                dDoubleValue = 2.147483647E9d;
                d = 0.0d;
            } else {
                double dDoubleValue2 = zzdeVarZzh.doubleValue();
                dDoubleValue = zzdeVarZzh2.doubleValue();
                if (dDoubleValue2 <= dDoubleValue) {
                    d = dDoubleValue2;
                } else {
                    dDoubleValue = 2.147483647E9d;
                    d = 0.0d;
                }
            }
        }
        return zzdf.zzR(Long.valueOf(Math.round(((dDoubleValue - d) * Math.random()) + d)));
    }
}
