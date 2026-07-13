package com.google.android.gms.internal;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzgy implements zzgw.zza<com.google.android.gms.ads.internal.formats.zze> {
    private final boolean zzHc;
    private final boolean zzHd;

    public zzgy(boolean z, boolean z2) {
        this.zzHc = z;
        this.zzHd = z2;
    }

    @Override // com.google.android.gms.internal.zzgw.zza
    /* JADX INFO: renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public com.google.android.gms.ads.internal.formats.zze zza(zzgw zzgwVar, JSONObject jSONObject) throws ExecutionException, JSONException, InterruptedException {
        List<zzjg<com.google.android.gms.ads.internal.formats.zzc>> listZza = zzgwVar.zza(jSONObject, "images", true, this.zzHc, this.zzHd);
        zzjg<com.google.android.gms.ads.internal.formats.zzc> zzjgVarZza = zzgwVar.zza(jSONObject, "secondary_image", false, this.zzHc);
        zzjg<com.google.android.gms.ads.internal.formats.zza> zzjgVarZzf = zzgwVar.zzf(jSONObject);
        ArrayList arrayList = new ArrayList();
        Iterator<zzjg<com.google.android.gms.ads.internal.formats.zzc>> it = listZza.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().get());
        }
        return new com.google.android.gms.ads.internal.formats.zze(jSONObject.getString("headline"), arrayList, jSONObject.getString("body"), zzjgVarZza.get(), jSONObject.getString("call_to_action"), jSONObject.getString("advertiser"), zzjgVarZzf.get(), new Bundle());
    }
}
