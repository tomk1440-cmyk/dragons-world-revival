package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class zzh {
    final String mName;
    final String zzaUa;
    final String zzaVM;
    final long zzaVN;
    final EventParams zzaVO;
    final long zzaez;

    zzh(zzw zzwVar, String str, String str2, String str3, long j, long j2, Bundle bundle) {
        com.google.android.gms.common.internal.zzx.zzcM(str2);
        com.google.android.gms.common.internal.zzx.zzcM(str3);
        this.zzaUa = str2;
        this.mName = str3;
        this.zzaVM = TextUtils.isEmpty(str) ? null : str;
        this.zzaez = j;
        this.zzaVN = j2;
        if (this.zzaVN != 0 && this.zzaVN > this.zzaez) {
            zzwVar.zzAo().zzCF().zzfg("Event created with reverse previous/current timestamps");
        }
        this.zzaVO = zza(zzwVar, bundle);
    }

    private zzh(zzw zzwVar, String str, String str2, String str3, long j, long j2, EventParams eventParams) {
        com.google.android.gms.common.internal.zzx.zzcM(str2);
        com.google.android.gms.common.internal.zzx.zzcM(str3);
        com.google.android.gms.common.internal.zzx.zzz(eventParams);
        this.zzaUa = str2;
        this.mName = str3;
        this.zzaVM = TextUtils.isEmpty(str) ? null : str;
        this.zzaez = j;
        this.zzaVN = j2;
        if (this.zzaVN != 0 && this.zzaVN > this.zzaez) {
            zzwVar.zzAo().zzCF().zzfg("Event created with reverse previous/current timestamps");
        }
        this.zzaVO = eventParams;
    }

    private EventParams zza(zzw zzwVar, Bundle bundle) {
        if (bundle == null || bundle.isEmpty()) {
            return new EventParams(new Bundle());
        }
        Bundle bundle2 = new Bundle(bundle);
        Iterator<String> it = bundle2.keySet().iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (next == null) {
                it.remove();
            } else {
                Object objZzk = zzwVar.zzCk().zzk(next, bundle2.get(next));
                if (objZzk == null) {
                    it.remove();
                } else {
                    zzwVar.zzCk().zza(bundle2, next, objZzk);
                }
            }
        }
        return new EventParams(bundle2);
    }

    public String toString() {
        return "Event{appId='" + this.zzaUa + "', name='" + this.mName + "', params=" + this.zzaVO + '}';
    }

    zzh zza(zzw zzwVar, long j) {
        return new zzh(zzwVar, this.zzaVM, this.zzaUa, this.mName, this.zzaez, j, this.zzaVO);
    }
}
