package com.google.android.gms.tagmanager;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class zzq extends zzak {
    private static final String ID = com.google.android.gms.internal.zzad.CONTAINER_VERSION.toString();
    private final String zzadc;

    public zzq(String str) {
        super(ID, new String[0]);
        this.zzadc = str;
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public boolean zzFW() {
        return true;
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public com.google.android.gms.internal.zzag.zza zzP(Map<String, com.google.android.gms.internal.zzag.zza> map) {
        return this.zzadc == null ? zzdf.zzHF() : zzdf.zzR(this.zzadc);
    }
}
