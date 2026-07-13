package com.google.android.gms.tagmanager;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class zzt extends zzak {
    private final zza zzbiq;
    private static final String ID = com.google.android.gms.internal.zzad.FUNCTION_CALL.toString();
    private static final String zzbip = com.google.android.gms.internal.zzae.FUNCTION_CALL_NAME.toString();
    private static final String zzbhF = com.google.android.gms.internal.zzae.ADDITIONAL_PARAMS.toString();

    public interface zza {
        Object zzc(String str, Map<String, Object> map);
    }

    public zzt(zza zzaVar) {
        super(ID, zzbip);
        this.zzbiq = zzaVar;
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public boolean zzFW() {
        return false;
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public com.google.android.gms.internal.zzag.zza zzP(Map<String, com.google.android.gms.internal.zzag.zza> map) {
        String strZzg = zzdf.zzg(map.get(zzbip));
        HashMap map2 = new HashMap();
        com.google.android.gms.internal.zzag.zza zzaVar = map.get(zzbhF);
        if (zzaVar != null) {
            Object objZzl = zzdf.zzl(zzaVar);
            if (!(objZzl instanceof Map)) {
                zzbg.zzaK("FunctionCallMacro: expected ADDITIONAL_PARAMS to be a map.");
                return zzdf.zzHF();
            }
            for (Map.Entry entry : ((Map) objZzl).entrySet()) {
                map2.put(entry.getKey().toString(), entry.getValue());
            }
        }
        try {
            return zzdf.zzR(this.zzbiq.zzc(strZzg, map2));
        } catch (Exception e) {
            zzbg.zzaK("Custom macro/tag " + strZzg + " threw exception " + e.getMessage());
            return zzdf.zzHF();
        }
    }
}
