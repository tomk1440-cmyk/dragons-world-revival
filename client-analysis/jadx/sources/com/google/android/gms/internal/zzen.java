package com.google.android.gms.internal;

import com.facebook.share.internal.ShareConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public final class zzen {
    public final String zzBA;
    public final List<String> zzBB;
    public final String zzBC;
    public final String zzBD;
    public final List<String> zzBE;
    public final List<String> zzBF;
    public final String zzBG;
    public final List<String> zzBH;
    public final List<String> zzBI;
    public final String zzBJ;
    public final String zzBK;
    public final String zzBL;
    public final List<String> zzBM;
    public final String zzBN;
    public final String zzBz;

    public zzen(String str, String str2, List<String> list, String str3, String str4, List<String> list2, List<String> list3, String str5, String str6, List<String> list4, List<String> list5, String str7, String str8, String str9, List<String> list6, String str10) {
        this.zzBz = str;
        this.zzBA = str2;
        this.zzBB = list;
        this.zzBC = str3;
        this.zzBD = str4;
        this.zzBE = list2;
        this.zzBF = list3;
        this.zzBG = str5;
        this.zzBH = list4;
        this.zzBI = list5;
        this.zzBJ = str7;
        this.zzBK = str8;
        this.zzBL = str9;
        this.zzBM = list6;
        this.zzBN = str10;
    }

    public zzen(JSONObject jSONObject) throws JSONException {
        this.zzBA = jSONObject.getString(ShareConstants.WEB_DIALOG_PARAM_ID);
        JSONArray jSONArray = jSONObject.getJSONArray("adapters");
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.getString(i));
        }
        this.zzBB = Collections.unmodifiableList(arrayList);
        this.zzBC = jSONObject.optString("allocation_id", null);
        this.zzBE = com.google.android.gms.ads.internal.zzr.zzbP().zza(jSONObject, "clickurl");
        this.zzBF = com.google.android.gms.ads.internal.zzr.zzbP().zza(jSONObject, "imp_urls");
        this.zzBH = com.google.android.gms.ads.internal.zzr.zzbP().zza(jSONObject, "video_start_urls");
        this.zzBI = com.google.android.gms.ads.internal.zzr.zzbP().zza(jSONObject, "video_complete_urls");
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("ad");
        this.zzBz = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.toString() : null;
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject(ShareConstants.WEB_DIALOG_PARAM_DATA);
        this.zzBG = jSONObjectOptJSONObject2 != null ? jSONObjectOptJSONObject2.toString() : null;
        this.zzBD = jSONObjectOptJSONObject2 != null ? jSONObjectOptJSONObject2.optString("class_name") : null;
        this.zzBJ = jSONObject.optString("html_template", null);
        this.zzBK = jSONObject.optString("ad_base_url", null);
        JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("assets");
        this.zzBL = jSONObjectOptJSONObject3 != null ? jSONObjectOptJSONObject3.toString() : null;
        this.zzBM = com.google.android.gms.ads.internal.zzr.zzbP().zza(jSONObject, "template_ids");
        JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject("ad_loader_options");
        this.zzBN = jSONObjectOptJSONObject4 != null ? jSONObjectOptJSONObject4.toString() : null;
    }
}
