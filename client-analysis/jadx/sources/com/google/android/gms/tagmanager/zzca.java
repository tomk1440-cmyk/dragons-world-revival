package com.google.android.gms.tagmanager;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzca extends zzak {
    private static final String zzbiQ = com.google.android.gms.internal.zzae.ARG0.toString();
    private static final String zzbjO = com.google.android.gms.internal.zzae.ARG1.toString();

    public zzca(String str) {
        super(str, zzbiQ, zzbjO);
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public boolean zzFW() {
        return true;
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public /* bridge */ /* synthetic */ String zzGB() {
        return super.zzGB();
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public /* bridge */ /* synthetic */ Set zzGC() {
        return super.zzGC();
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public com.google.android.gms.internal.zzag.zza zzP(Map<String, com.google.android.gms.internal.zzag.zza> map) {
        Iterator<com.google.android.gms.internal.zzag.zza> it = map.values().iterator();
        while (it.hasNext()) {
            if (it.next() == zzdf.zzHF()) {
                return zzdf.zzR(false);
            }
        }
        com.google.android.gms.internal.zzag.zza zzaVar = map.get(zzbiQ);
        com.google.android.gms.internal.zzag.zza zzaVar2 = map.get(zzbjO);
        return zzdf.zzR(Boolean.valueOf((zzaVar == null || zzaVar2 == null) ? false : zza(zzaVar, zzaVar2, map)));
    }

    protected abstract boolean zza(com.google.android.gms.internal.zzag.zza zzaVar, com.google.android.gms.internal.zzag.zza zzaVar2, Map<String, com.google.android.gms.internal.zzag.zza> map);
}
