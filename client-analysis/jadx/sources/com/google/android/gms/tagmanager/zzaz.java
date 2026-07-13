package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzrs;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class zzaz {
    private static com.google.android.gms.internal.zzag.zza zzK(Object obj) throws JSONException {
        return zzdf.zzR(zzL(obj));
    }

    static Object zzL(Object obj) throws JSONException {
        if (obj instanceof JSONArray) {
            throw new RuntimeException("JSONArrays are not supported");
        }
        if (JSONObject.NULL.equals(obj)) {
            throw new RuntimeException("JSON nulls are not supported");
        }
        if (!(obj instanceof JSONObject)) {
            return obj;
        }
        JSONObject jSONObject = (JSONObject) obj;
        HashMap map = new HashMap();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            map.put(next, zzL(jSONObject.get(next)));
        }
        return map;
    }

    public static zzrs.zzc zzgi(String str) throws JSONException {
        com.google.android.gms.internal.zzag.zza zzaVarZzK = zzK(new JSONObject(str));
        zzrs.zzd zzdVarZzHK = zzrs.zzc.zzHK();
        for (int i = 0; i < zzaVarZzK.zzjz.length; i++) {
            zzdVarZzHK.zzc(zzrs.zza.zzHH().zzb(com.google.android.gms.internal.zzae.INSTANCE_NAME.toString(), zzaVarZzK.zzjz[i]).zzb(com.google.android.gms.internal.zzae.FUNCTION.toString(), zzdf.zzgt(zzn.zzFZ())).zzb(zzn.zzGa(), zzaVarZzK.zzjA[i]).zzHJ());
        }
        return zzdVarZzHK.zzHN();
    }
}
