package com.google.android.gms.tagmanager;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class zzdh extends zzak {
    private static final String ID = com.google.android.gms.internal.zzad.UPPERCASE_STRING.toString();
    private static final String zzbiQ = com.google.android.gms.internal.zzae.ARG0.toString();

    public zzdh() {
        super(ID, zzbiQ);
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public boolean zzFW() {
        return true;
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public com.google.android.gms.internal.zzag.zza zzP(Map<String, com.google.android.gms.internal.zzag.zza> map) {
        return zzdf.zzR(zzdf.zzg(map.get(zzbiQ)).toUpperCase());
    }
}
