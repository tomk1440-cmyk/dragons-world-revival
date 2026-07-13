package com.google.android.gms.tagmanager;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class zzx extends zzdd {
    private static final String ID = com.google.android.gms.internal.zzad.DATA_LAYER_WRITE.toString();
    private static final String VALUE = com.google.android.gms.internal.zzae.VALUE.toString();
    private static final String zzbiL = com.google.android.gms.internal.zzae.CLEAR_PERSISTENT_DATA_LAYER_PREFIX.toString();
    private final DataLayer zzbhN;

    public zzx(DataLayer dataLayer) {
        super(ID, VALUE);
        this.zzbhN = dataLayer;
    }

    private void zza(com.google.android.gms.internal.zzag.zza zzaVar) {
        String strZzg;
        if (zzaVar == null || zzaVar == zzdf.zzHz() || (strZzg = zzdf.zzg(zzaVar)) == zzdf.zzHE()) {
            return;
        }
        this.zzbhN.zzfX(strZzg);
    }

    private void zzb(com.google.android.gms.internal.zzag.zza zzaVar) {
        if (zzaVar == null || zzaVar == zzdf.zzHz()) {
            return;
        }
        Object objZzl = zzdf.zzl(zzaVar);
        if (objZzl instanceof List) {
            for (Object obj : (List) objZzl) {
                if (obj instanceof Map) {
                    this.zzbhN.push((Map) obj);
                }
            }
        }
    }

    @Override // com.google.android.gms.tagmanager.zzdd
    public void zzR(Map<String, com.google.android.gms.internal.zzag.zza> map) {
        zzb(map.get(VALUE));
        zza(map.get(zzbiL));
    }
}
