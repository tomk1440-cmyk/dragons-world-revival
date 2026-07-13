package com.google.android.gms.tagmanager;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class zzv extends zzak {
    private static final String ID = com.google.android.gms.internal.zzad.CUSTOM_VAR.toString();
    private static final String NAME = com.google.android.gms.internal.zzae.NAME.toString();
    private static final String zzbiA = com.google.android.gms.internal.zzae.DEFAULT_VALUE.toString();
    private final DataLayer zzbhN;

    public zzv(DataLayer dataLayer) {
        super(ID, NAME);
        this.zzbhN = dataLayer;
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public boolean zzFW() {
        return false;
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public com.google.android.gms.internal.zzag.zza zzP(Map<String, com.google.android.gms.internal.zzag.zza> map) {
        Object obj = this.zzbhN.get(zzdf.zzg(map.get(NAME)));
        if (obj != null) {
            return zzdf.zzR(obj);
        }
        com.google.android.gms.internal.zzag.zza zzaVar = map.get(zzbiA);
        return zzaVar != null ? zzaVar : zzdf.zzHF();
    }
}
