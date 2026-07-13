package com.google.android.gms.tagmanager;

import android.os.Build;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class zzbx extends zzak {
    private static final String ID = com.google.android.gms.internal.zzad.OS_VERSION.toString();

    public zzbx() {
        super(ID, new String[0]);
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public boolean zzFW() {
        return true;
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public com.google.android.gms.internal.zzag.zza zzP(Map<String, com.google.android.gms.internal.zzag.zza> map) {
        return zzdf.zzR(Build.VERSION.RELEASE);
    }
}
