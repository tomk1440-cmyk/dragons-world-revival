package com.google.android.gms.tagmanager;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
abstract class zzdd extends zzak {
    public zzdd(String str, String... strArr) {
        super(str, strArr);
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public boolean zzFW() {
        return false;
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public com.google.android.gms.internal.zzag.zza zzP(Map<String, com.google.android.gms.internal.zzag.zza> map) {
        zzR(map);
        return zzdf.zzHF();
    }

    public abstract void zzR(Map<String, com.google.android.gms.internal.zzag.zza> map);
}
