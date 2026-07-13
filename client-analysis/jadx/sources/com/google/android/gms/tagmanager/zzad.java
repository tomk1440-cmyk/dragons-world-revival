package com.google.android.gms.tagmanager;

import android.util.Base64;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class zzad extends zzak {
    private static final String ID = com.google.android.gms.internal.zzad.ENCODE.toString();
    private static final String zzbiQ = com.google.android.gms.internal.zzae.ARG0.toString();
    private static final String zzbiR = com.google.android.gms.internal.zzae.NO_PADDING.toString();
    private static final String zzbiS = com.google.android.gms.internal.zzae.INPUT_FORMAT.toString();
    private static final String zzbiT = com.google.android.gms.internal.zzae.OUTPUT_FORMAT.toString();

    public zzad() {
        super(ID, zzbiQ);
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public boolean zzFW() {
        return true;
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public com.google.android.gms.internal.zzag.zza zzP(Map<String, com.google.android.gms.internal.zzag.zza> map) {
        byte[] bArrDecode;
        String strEncodeToString;
        com.google.android.gms.internal.zzag.zza zzaVar = map.get(zzbiQ);
        if (zzaVar == null || zzaVar == zzdf.zzHF()) {
            return zzdf.zzHF();
        }
        String strZzg = zzdf.zzg(zzaVar);
        com.google.android.gms.internal.zzag.zza zzaVar2 = map.get(zzbiS);
        String strZzg2 = zzaVar2 == null ? "text" : zzdf.zzg(zzaVar2);
        com.google.android.gms.internal.zzag.zza zzaVar3 = map.get(zzbiT);
        String strZzg3 = zzaVar3 == null ? "base16" : zzdf.zzg(zzaVar3);
        com.google.android.gms.internal.zzag.zza zzaVar4 = map.get(zzbiR);
        int i = (zzaVar4 == null || !zzdf.zzk(zzaVar4).booleanValue()) ? 2 : 3;
        try {
            if ("text".equals(strZzg2)) {
                bArrDecode = strZzg.getBytes();
            } else if ("base16".equals(strZzg2)) {
                bArrDecode = zzk.zzfO(strZzg);
            } else if ("base64".equals(strZzg2)) {
                bArrDecode = Base64.decode(strZzg, i);
            } else {
                if (!"base64url".equals(strZzg2)) {
                    zzbg.e("Encode: unknown input format: " + strZzg2);
                    return zzdf.zzHF();
                }
                bArrDecode = Base64.decode(strZzg, i | 8);
            }
            if ("base16".equals(strZzg3)) {
                strEncodeToString = zzk.zzj(bArrDecode);
            } else if ("base64".equals(strZzg3)) {
                strEncodeToString = Base64.encodeToString(bArrDecode, i);
            } else {
                if (!"base64url".equals(strZzg3)) {
                    zzbg.e("Encode: unknown output format: " + strZzg3);
                    return zzdf.zzHF();
                }
                strEncodeToString = Base64.encodeToString(bArrDecode, i | 8);
            }
            return zzdf.zzR(strEncodeToString);
        } catch (IllegalArgumentException e) {
            zzbg.e("Encode: invalid input:");
            return zzdf.zzHF();
        }
    }
}
