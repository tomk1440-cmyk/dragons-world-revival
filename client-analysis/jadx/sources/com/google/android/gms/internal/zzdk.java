package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzdk implements zzdf {
    final HashMap<String, zzjd<JSONObject>> zzzz = new HashMap<>();

    public Future<JSONObject> zzR(String str) {
        zzjd<JSONObject> zzjdVar = new zzjd<>();
        this.zzzz.put(str, zzjdVar);
        return zzjdVar;
    }

    public void zzS(String str) {
        zzjd<JSONObject> zzjdVar = this.zzzz.get(str);
        if (zzjdVar == null) {
            zzin.e("Could not find the ad request for the corresponding ad response.");
            return;
        }
        if (!zzjdVar.isDone()) {
            zzjdVar.cancel(true);
        }
        this.zzzz.remove(str);
    }

    @Override // com.google.android.gms.internal.zzdf
    public void zza(zzjp zzjpVar, Map<String, String> map) {
        zzd(map.get("request_id"), map.get("fetched_ad"));
    }

    public void zzd(String str, String str2) {
        zzin.zzaI("Received ad from the cache.");
        zzjd<JSONObject> zzjdVar = this.zzzz.get(str);
        if (zzjdVar == null) {
            zzin.e("Could not find the ad request for the corresponding ad response.");
            return;
        }
        try {
            zzjdVar.zzg(new JSONObject(str2));
        } catch (JSONException e) {
            zzin.zzb("Failed constructing JSON object from value passed from javascript", e);
            zzjdVar.zzg(null);
        } finally {
            this.zzzz.remove(str);
        }
    }
}
