package com.google.android.gms.tagmanager;

import android.os.Build;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class zzcr extends zzak {
    private static final String ID = com.google.android.gms.internal.zzad.SDK_VERSION.toString();

    public zzcr() {
        super(ID, new String[0]);
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public boolean zzFW() {
        return true;
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public com.google.android.gms.internal.zzag.zza zzP(Map<String, com.google.android.gms.internal.zzag.zza> map) {
        return zzdf.zzR(Integer.valueOf(Build.VERSION.SDK_INT));
    }
}
