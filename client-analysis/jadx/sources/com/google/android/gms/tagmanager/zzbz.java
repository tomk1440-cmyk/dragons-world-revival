package com.google.android.gms.tagmanager;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class zzbz extends zzak {
    private static final String ID = com.google.android.gms.internal.zzad.PLATFORM.toString();
    private static final com.google.android.gms.internal.zzag.zza zzbjN = zzdf.zzR("Android");

    public zzbz() {
        super(ID, new String[0]);
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public boolean zzFW() {
        return true;
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public com.google.android.gms.internal.zzag.zza zzP(Map<String, com.google.android.gms.internal.zzag.zza> map) {
        return zzbjN;
    }
}
