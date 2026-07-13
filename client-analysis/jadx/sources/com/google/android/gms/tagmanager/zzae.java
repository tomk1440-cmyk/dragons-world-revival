package com.google.android.gms.tagmanager;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class zzae extends zzcz {
    private static final String ID = com.google.android.gms.internal.zzad.ENDS_WITH.toString();

    public zzae() {
        super(ID);
    }

    @Override // com.google.android.gms.tagmanager.zzcz
    protected boolean zza(String str, String str2, Map<String, com.google.android.gms.internal.zzag.zza> map) {
        return str.endsWith(str2);
    }
}
