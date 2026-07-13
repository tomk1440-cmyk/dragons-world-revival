package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzx;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzi {
    public static void zza(SignInConfiguration signInConfiguration, List<com.google.android.gms.auth.api.signin.zzd> list, Map<com.google.android.gms.auth.api.signin.zzd, List<String>> map) {
        zzx.zzz(signInConfiguration);
        zzx.zzz(list);
        zzx.zzz(map);
        GoogleSignInOptions googleSignInOptionsZznm = signInConfiguration.zznm();
        if (googleSignInOptionsZznm != null) {
            list.add(com.google.android.gms.auth.api.signin.zzd.GOOGLE);
            LinkedList linkedList = new LinkedList();
            Iterator<Scope> it = googleSignInOptionsZznm.zzmN().iterator();
            while (it.hasNext()) {
                linkedList.add(it.next().zzpb());
            }
            map.put(com.google.android.gms.auth.api.signin.zzd.GOOGLE, linkedList);
        }
    }
}
