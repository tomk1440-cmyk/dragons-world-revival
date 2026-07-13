package com.google.android.gms.internal;

import com.google.android.gms.common.api.Scope;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class zznh {
    public static String[] zzb(Scope[] scopeArr) {
        com.google.android.gms.common.internal.zzx.zzb(scopeArr, "scopes can't be null.");
        String[] strArr = new String[scopeArr.length];
        for (int i = 0; i < scopeArr.length; i++) {
            strArr[i] = scopeArr[i].zzpb();
        }
        return strArr;
    }

    public static String[] zzc(Set<Scope> set) {
        com.google.android.gms.common.internal.zzx.zzb(set, "scopes can't be null.");
        return zzb((Scope[]) set.toArray(new Scope[set.size()]));
    }
}
