package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzbq {
    private final Collection<zzbp> zzvu = new ArrayList();
    private final Collection<zzbp<String>> zzvv = new ArrayList();
    private final Collection<zzbp<String>> zzvw = new ArrayList();

    public void zza(zzbp zzbpVar) {
        this.zzvu.add(zzbpVar);
    }

    public void zzb(zzbp<String> zzbpVar) {
        this.zzvv.add(zzbpVar);
    }

    public void zzc(zzbp<String> zzbpVar) {
        this.zzvw.add(zzbpVar);
    }

    public List<String> zzdr() {
        ArrayList arrayList = new ArrayList();
        Iterator<zzbp<String>> it = this.zzvv.iterator();
        while (it.hasNext()) {
            String str = it.next().get();
            if (str != null) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public List<String> zzds() {
        List<String> listZzdr = zzdr();
        Iterator<zzbp<String>> it = this.zzvw.iterator();
        while (it.hasNext()) {
            String str = it.next().get();
            if (str != null) {
                listZzdr.add(str);
            }
        }
        return listZzdr;
    }
}
