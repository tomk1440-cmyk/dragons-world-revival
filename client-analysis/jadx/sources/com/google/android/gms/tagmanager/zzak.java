package com.google.android.gms.tagmanager;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
abstract class zzak {
    private final Set<String> zzbiU;
    private final String zzbiV;

    public zzak(String str, String... strArr) {
        this.zzbiV = str;
        this.zzbiU = new HashSet(strArr.length);
        for (String str2 : strArr) {
            this.zzbiU.add(str2);
        }
    }

    public abstract boolean zzFW();

    public String zzGB() {
        return this.zzbiV;
    }

    public Set<String> zzGC() {
        return this.zzbiU;
    }

    public abstract com.google.android.gms.internal.zzag.zza zzP(Map<String, com.google.android.gms.internal.zzag.zza> map);

    boolean zze(Set<String> set) {
        return set.containsAll(this.zzbiU);
    }
}
