package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public final class zzeo {
    public final List<zzen> zzBO;
    public final long zzBP;
    public final List<String> zzBQ;
    public final List<String> zzBR;
    public final List<String> zzBS;
    public final String zzBT;
    public final long zzBU;
    public final String zzBV;
    public final int zzBW;
    public final int zzBX;
    public final long zzBY;
    public int zzBZ;
    public int zzCa;

    public zzeo(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        if (zzin.zzQ(2)) {
            zzin.v("Mediation Response JSON: " + jSONObject.toString(2));
        }
        JSONArray jSONArray = jSONObject.getJSONArray("ad_networks");
        ArrayList arrayList = new ArrayList(jSONArray.length());
        int i = -1;
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            zzen zzenVar = new zzen(jSONArray.getJSONObject(i2));
            arrayList.add(zzenVar);
            if (i < 0 && zza(zzenVar)) {
                i = i2;
            }
        }
        this.zzBZ = i;
        this.zzCa = jSONArray.length();
        this.zzBO = Collections.unmodifiableList(arrayList);
        this.zzBT = jSONObject.getString("qdata");
        this.zzBX = jSONObject.optInt("fs_model_type", -1);
        this.zzBY = jSONObject.optLong("timeout_ms", -1L);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("settings");
        if (jSONObjectOptJSONObject == null) {
            this.zzBP = -1L;
            this.zzBQ = null;
            this.zzBR = null;
            this.zzBS = null;
            this.zzBU = -1L;
            this.zzBV = null;
            this.zzBW = 0;
            return;
        }
        this.zzBP = jSONObjectOptJSONObject.optLong("ad_network_timeout_millis", -1L);
        this.zzBQ = com.google.android.gms.ads.internal.zzr.zzbP().zza(jSONObjectOptJSONObject, "click_urls");
        this.zzBR = com.google.android.gms.ads.internal.zzr.zzbP().zza(jSONObjectOptJSONObject, "imp_urls");
        this.zzBS = com.google.android.gms.ads.internal.zzr.zzbP().zza(jSONObjectOptJSONObject, "nofill_urls");
        long jOptLong = jSONObjectOptJSONObject.optLong("refresh", -1L);
        this.zzBU = jOptLong > 0 ? jOptLong * 1000 : -1L;
        RewardItemParcel rewardItemParcelZza = RewardItemParcel.zza(jSONObjectOptJSONObject.optJSONArray("rewards"));
        if (rewardItemParcelZza == null) {
            this.zzBV = null;
            this.zzBW = 0;
        } else {
            this.zzBV = rewardItemParcelZza.type;
            this.zzBW = rewardItemParcelZza.zzKS;
        }
    }

    public zzeo(List<zzen> list, long j, List<String> list2, List<String> list3, List<String> list4, String str, long j2, int i, int i2, String str2, int i3, int i4, long j3) {
        this.zzBO = list;
        this.zzBP = j;
        this.zzBQ = list2;
        this.zzBR = list3;
        this.zzBS = list4;
        this.zzBT = str;
        this.zzBU = j2;
        this.zzBZ = i;
        this.zzCa = i2;
        this.zzBV = str2;
        this.zzBW = i3;
        this.zzBX = i4;
        this.zzBY = j3;
    }

    private boolean zza(zzen zzenVar) {
        Iterator<String> it = zzenVar.zzBB.iterator();
        while (it.hasNext()) {
            if (it.next().equals("com.google.ads.mediation.admob.AdMobAdapter")) {
                return true;
            }
        }
        return false;
    }
}
