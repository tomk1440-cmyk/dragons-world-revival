package com.google.android.gms.tagmanager;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class zzda extends zzak {
    private static final String ID = com.google.android.gms.internal.zzad.TIME.toString();

    public zzda() {
        super(ID, new String[0]);
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public boolean zzFW() {
        return false;
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public com.google.android.gms.internal.zzag.zza zzP(Map<String, com.google.android.gms.internal.zzag.zza> map) {
        return zzdf.zzR(Long.valueOf(System.currentTimeMillis()));
    }
}
