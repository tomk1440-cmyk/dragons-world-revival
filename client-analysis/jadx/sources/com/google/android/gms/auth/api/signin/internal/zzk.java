package com.google.android.gms.auth.api.signin.internal;

import android.app.Activity;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzlf;
import com.google.android.gms.internal.zzlh;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class zzk {
    private final Map<com.google.android.gms.auth.api.signin.zzd, zzlf> zzXD;

    public zzk(Activity activity, List<com.google.android.gms.auth.api.signin.zzd> list, Map<com.google.android.gms.auth.api.signin.zzd, List<String>> map) {
        zzx.zzz(activity);
        zzx.zzz(list);
        zzx.zzz(map);
        HashMap map2 = new HashMap();
        for (com.google.android.gms.auth.api.signin.zzd zzdVar : list) {
            List<String> list2 = map.get(zzdVar);
            zzlf zzlfVarZza = zza(zzdVar, activity, list2 == null ? Collections.emptyList() : list2);
            if (zzlfVarZza != null) {
                map2.put(zzdVar, zzlfVarZza);
            }
        }
        this.zzXD = Collections.unmodifiableMap(map2);
    }

    private zzlf zza(com.google.android.gms.auth.api.signin.zzd zzdVar, Activity activity, List<String> list) {
        if (com.google.android.gms.auth.api.signin.zzd.FACEBOOK.equals(zzdVar)) {
            return new zzlh(activity, list);
        }
        return null;
    }

    public zzlf zza(com.google.android.gms.auth.api.signin.zzd zzdVar) {
        zzx.zzz(zzdVar);
        return this.zzXD.get(zzdVar);
    }

    public Collection<zzlf> zznh() {
        return this.zzXD.values();
    }
}
