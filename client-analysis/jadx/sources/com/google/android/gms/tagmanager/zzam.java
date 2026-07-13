package com.google.android.gms.tagmanager;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class zzam extends zzbv {
    private static final String ID = com.google.android.gms.internal.zzad.GREATER_EQUALS.toString();

    public zzam() {
        super(ID);
    }

    @Override // com.google.android.gms.tagmanager.zzbv
    protected boolean zza(zzde zzdeVar, zzde zzdeVar2, Map<String, com.google.android.gms.internal.zzag.zza> map) {
        return zzdeVar.compareTo(zzdeVar2) >= 0;
    }
}
