package com.google.android.gms.internal;

import android.os.Bundle;
import com.unity3d.ads.metadata.InAppPurchaseMetaData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzgx implements zzgw.zza<com.google.android.gms.ads.internal.formats.zzd> {
    private final boolean zzHc;
    private final boolean zzHd;

    public zzgx(boolean z, boolean z2) {
        this.zzHc = z;
        this.zzHd = z2;
    }

    @Override // com.google.android.gms.internal.zzgw.zza
    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public com.google.android.gms.ads.internal.formats.zzd zza(zzgw zzgwVar, JSONObject jSONObject) throws ExecutionException, JSONException, InterruptedException {
        List<zzjg<com.google.android.gms.ads.internal.formats.zzc>> listZza = zzgwVar.zza(jSONObject, "images", true, this.zzHc, this.zzHd);
        zzjg<com.google.android.gms.ads.internal.formats.zzc> zzjgVarZza = zzgwVar.zza(jSONObject, "app_icon", true, this.zzHc);
        zzjg<com.google.android.gms.ads.internal.formats.zza> zzjgVarZzf = zzgwVar.zzf(jSONObject);
        ArrayList arrayList = new ArrayList();
        Iterator<zzjg<com.google.android.gms.ads.internal.formats.zzc>> it = listZza.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().get());
        }
        return new com.google.android.gms.ads.internal.formats.zzd(jSONObject.getString("headline"), arrayList, jSONObject.getString("body"), zzjgVarZza.get(), jSONObject.getString("call_to_action"), jSONObject.optDouble("rating", -1.0d), jSONObject.optString("store"), jSONObject.optString(InAppPurchaseMetaData.KEY_PRICE), zzjgVarZzf.get(), new Bundle());
    }
}
