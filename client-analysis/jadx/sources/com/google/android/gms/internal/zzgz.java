package com.google.android.gms.internal;

import android.support.v4.util.SimpleArrayMap;
import com.facebook.share.internal.ShareConstants;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzgz implements zzgw.zza<com.google.android.gms.ads.internal.formats.zzf> {
    private final boolean zzHc;

    public zzgz(boolean z) {
        this.zzHc = z;
    }

    private void zza(zzgw zzgwVar, JSONObject jSONObject, SimpleArrayMap<String, Future<com.google.android.gms.ads.internal.formats.zzc>> simpleArrayMap) throws JSONException {
        simpleArrayMap.put(jSONObject.getString("name"), zzgwVar.zza(jSONObject, "image_value", this.zzHc));
    }

    private void zza(JSONObject jSONObject, SimpleArrayMap<String, String> simpleArrayMap) throws JSONException {
        simpleArrayMap.put(jSONObject.getString("name"), jSONObject.getString("string_value"));
    }

    private <K, V> SimpleArrayMap<K, V> zzc(SimpleArrayMap<K, Future<V>> simpleArrayMap) throws ExecutionException, InterruptedException {
        SimpleArrayMap<K, V> simpleArrayMap2 = new SimpleArrayMap<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= simpleArrayMap.size()) {
                return simpleArrayMap2;
            }
            simpleArrayMap2.put(simpleArrayMap.keyAt(i2), simpleArrayMap.valueAt(i2).get());
            i = i2 + 1;
        }
    }

    @Override // com.google.android.gms.internal.zzgw.zza
    /* JADX INFO: renamed from: zzd, reason: merged with bridge method [inline-methods] */
    public com.google.android.gms.ads.internal.formats.zzf zza(zzgw zzgwVar, JSONObject jSONObject) throws ExecutionException, JSONException, InterruptedException {
        SimpleArrayMap<String, Future<com.google.android.gms.ads.internal.formats.zzc>> simpleArrayMap = new SimpleArrayMap<>();
        SimpleArrayMap<String, String> simpleArrayMap2 = new SimpleArrayMap<>();
        zzjg<com.google.android.gms.ads.internal.formats.zza> zzjgVarZzf = zzgwVar.zzf(jSONObject);
        JSONArray jSONArray = jSONObject.getJSONArray("custom_assets");
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            String string = jSONObject2.getString(ShareConstants.MEDIA_TYPE);
            if ("string".equals(string)) {
                zza(jSONObject2, simpleArrayMap2);
            } else if ("image".equals(string)) {
                zza(zzgwVar, jSONObject2, simpleArrayMap);
            } else {
                zzin.zzaK("Unknown custom asset type: " + string);
            }
        }
        return new com.google.android.gms.ads.internal.formats.zzf(jSONObject.getString("custom_template_id"), zzc(simpleArrayMap), simpleArrayMap2, zzjgVarZzf.get());
    }
}
