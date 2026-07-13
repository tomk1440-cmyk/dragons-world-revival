package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.ShareConstants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public final class zzde {
    public static final zzdf zzyX = new zzdf() { // from class: com.google.android.gms.internal.zzde.1
        @Override // com.google.android.gms.internal.zzdf
        public void zza(zzjp zzjpVar, Map<String, String> map) {
        }
    };
    public static final zzdf zzyY = new zzdf() { // from class: com.google.android.gms.internal.zzde.4
        @Override // com.google.android.gms.internal.zzdf
        public void zza(zzjp zzjpVar, Map<String, String> map) {
            String str = map.get("urls");
            if (TextUtils.isEmpty(str)) {
                zzin.zzaK("URLs missing in canOpenURLs GMSG.");
                return;
            }
            String[] strArrSplit = str.split(",");
            HashMap map2 = new HashMap();
            PackageManager packageManager = zzjpVar.getContext().getPackageManager();
            for (String str2 : strArrSplit) {
                String[] strArrSplit2 = str2.split(";", 2);
                map2.put(str2, Boolean.valueOf(packageManager.resolveActivity(new Intent(strArrSplit2.length > 1 ? strArrSplit2[1].trim() : "android.intent.action.VIEW", Uri.parse(strArrSplit2[0].trim())), 65536) != null));
            }
            zzjpVar.zza("openableURLs", map2);
        }
    };
    public static final zzdf zzyZ = new zzdf() { // from class: com.google.android.gms.internal.zzde.5
        @Override // com.google.android.gms.internal.zzdf
        public void zza(zzjp zzjpVar, Map<String, String> map) {
            PackageManager packageManager = zzjpVar.getContext().getPackageManager();
            try {
                try {
                    JSONArray jSONArray = new JSONObject(map.get(ShareConstants.WEB_DIALOG_PARAM_DATA)).getJSONArray("intents");
                    JSONObject jSONObject = new JSONObject();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        try {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                            String strOptString = jSONObject2.optString(ShareConstants.WEB_DIALOG_PARAM_ID);
                            String strOptString2 = jSONObject2.optString("u");
                            String strOptString3 = jSONObject2.optString("i");
                            String strOptString4 = jSONObject2.optString("m");
                            String strOptString5 = jSONObject2.optString("p");
                            String strOptString6 = jSONObject2.optString("c");
                            jSONObject2.optString("f");
                            jSONObject2.optString("e");
                            Intent intent = new Intent();
                            if (!TextUtils.isEmpty(strOptString2)) {
                                intent.setData(Uri.parse(strOptString2));
                            }
                            if (!TextUtils.isEmpty(strOptString3)) {
                                intent.setAction(strOptString3);
                            }
                            if (!TextUtils.isEmpty(strOptString4)) {
                                intent.setType(strOptString4);
                            }
                            if (!TextUtils.isEmpty(strOptString5)) {
                                intent.setPackage(strOptString5);
                            }
                            if (!TextUtils.isEmpty(strOptString6)) {
                                String[] strArrSplit = strOptString6.split("/", 2);
                                if (strArrSplit.length == 2) {
                                    intent.setComponent(new ComponentName(strArrSplit[0], strArrSplit[1]));
                                }
                            }
                            try {
                                jSONObject.put(strOptString, packageManager.resolveActivity(intent, 65536) != null);
                            } catch (JSONException e) {
                                zzin.zzb("Error constructing openable urls response.", e);
                            }
                        } catch (JSONException e2) {
                            zzin.zzb("Error parsing the intent data.", e2);
                        }
                    }
                    zzjpVar.zzb("openableIntents", jSONObject);
                } catch (JSONException e3) {
                    zzjpVar.zzb("openableIntents", new JSONObject());
                }
            } catch (JSONException e4) {
                zzjpVar.zzb("openableIntents", new JSONObject());
            }
        }
    };
    public static final zzdf zzza = new zzdf() { // from class: com.google.android.gms.internal.zzde.6
        @Override // com.google.android.gms.internal.zzdf
        public void zza(zzjp zzjpVar, Map<String, String> map) {
            Uri uriZza;
            String str = map.get("u");
            if (str == null) {
                zzin.zzaK("URL missing from click GMSG.");
                return;
            }
            Uri uri = Uri.parse(str);
            try {
                zzan zzanVarZzhW = zzjpVar.zzhW();
                uriZza = (zzanVarZzhW == null || !zzanVarZzhW.zzb(uri)) ? uri : zzanVarZzhW.zza(uri, zzjpVar.getContext());
            } catch (zzao e) {
                zzin.zzaK("Unable to append parameter to URL: " + str);
            }
            new zziy(zzjpVar.getContext(), zzjpVar.zzhX().afmaVersion, uriZza.toString()).zzgd();
        }
    };
    public static final zzdf zzzb = new zzdf() { // from class: com.google.android.gms.internal.zzde.7
        @Override // com.google.android.gms.internal.zzdf
        public void zza(zzjp zzjpVar, Map<String, String> map) {
            com.google.android.gms.ads.internal.overlay.zzd zzdVarZzhS = zzjpVar.zzhS();
            if (zzdVarZzhS != null) {
                zzdVarZzhS.close();
                return;
            }
            com.google.android.gms.ads.internal.overlay.zzd zzdVarZzhT = zzjpVar.zzhT();
            if (zzdVarZzhT != null) {
                zzdVarZzhT.close();
            } else {
                zzin.zzaK("A GMSG tried to close something that wasn't an overlay.");
            }
        }
    };
    public static final zzdf zzzc = new zzdf() { // from class: com.google.android.gms.internal.zzde.8
        private void zzc(zzjp zzjpVar) {
            com.google.android.gms.ads.internal.overlay.zzm zzmVar;
            zzin.zzaJ("Received support message, responding.");
            boolean zZzfM = false;
            com.google.android.gms.ads.internal.zzd zzdVarZzhR = zzjpVar.zzhR();
            if (zzdVarZzhR != null && (zzmVar = zzdVarZzhR.zzpy) != null) {
                zZzfM = zzmVar.zzfM();
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("event", "checkSupport");
                jSONObject.put("supports", zZzfM);
                zzjpVar.zzb("appStreaming", jSONObject);
            } catch (Throwable th) {
            }
        }

        @Override // com.google.android.gms.internal.zzdf
        public void zza(zzjp zzjpVar, Map<String, String> map) {
            if ("checkSupport".equals(map.get(NativeProtocol.WEB_DIALOG_ACTION))) {
                zzc(zzjpVar);
                return;
            }
            com.google.android.gms.ads.internal.overlay.zzd zzdVarZzhS = zzjpVar.zzhS();
            if (zzdVarZzhS != null) {
                zzdVarZzhS.zzg(zzjpVar, map);
            }
        }
    };
    public static final zzdf zzzd = new zzdf() { // from class: com.google.android.gms.internal.zzde.9
        @Override // com.google.android.gms.internal.zzdf
        public void zza(zzjp zzjpVar, Map<String, String> map) {
            zzjpVar.zzE(AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(map.get("custom_close")));
        }
    };
    public static final zzdf zzze = new zzdf() { // from class: com.google.android.gms.internal.zzde.10
        @Override // com.google.android.gms.internal.zzdf
        public void zza(zzjp zzjpVar, Map<String, String> map) {
            String str = map.get("u");
            if (str == null) {
                zzin.zzaK("URL missing from httpTrack GMSG.");
            } else {
                new zziy(zzjpVar.getContext(), zzjpVar.zzhX().afmaVersion, str).zzgd();
            }
        }
    };
    public static final zzdf zzzf = new zzdf() { // from class: com.google.android.gms.internal.zzde.11
        @Override // com.google.android.gms.internal.zzdf
        public void zza(zzjp zzjpVar, Map<String, String> map) {
            zzin.zzaJ("Received log message: " + map.get("string"));
        }
    };
    public static final zzdf zzzg = new zzdf() { // from class: com.google.android.gms.internal.zzde.2
        @Override // com.google.android.gms.internal.zzdf
        public void zza(zzjp zzjpVar, Map<String, String> map) {
            String str = map.get("tx");
            String str2 = map.get("ty");
            String str3 = map.get("td");
            try {
                int i = Integer.parseInt(str);
                int i2 = Integer.parseInt(str2);
                int i3 = Integer.parseInt(str3);
                zzan zzanVarZzhW = zzjpVar.zzhW();
                if (zzanVarZzhW != null) {
                    zzanVarZzhW.zzab().zza(i, i2, i3);
                }
            } catch (NumberFormatException e) {
                zzin.zzaK("Could not parse touch parameters from gmsg.");
            }
        }
    };
    public static final zzdf zzzh = new zzdf() { // from class: com.google.android.gms.internal.zzde.3
        @Override // com.google.android.gms.internal.zzdf
        public void zza(zzjp zzjpVar, Map<String, String> map) {
            if (zzbt.zzwT.get().booleanValue()) {
                zzjpVar.zzF(!Boolean.parseBoolean(map.get("disabled")));
            }
        }
    };
    public static final zzdf zzzi = new zzdo();
    public static final zzdf zzzj = new zzds();
    public static final zzdf zzzk = new zzdd();
}
