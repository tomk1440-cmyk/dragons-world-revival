package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.GraphResponse;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.io.BufferedOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzdg implements zzdf {
    private final Context mContext;
    private final VersionInfoParcel zzpT;

    @zzhb
    static class zza {
        private final String mValue;
        private final String zzvs;

        public zza(String str, String str2) {
            this.zzvs = str;
            this.mValue = str2;
        }

        public String getKey() {
            return this.zzvs;
        }

        public String getValue() {
            return this.mValue;
        }
    }

    @zzhb
    static class zzb {
        private final String zzzp;
        private final URL zzzq;
        private final ArrayList<zza> zzzr;
        private final String zzzs;

        public zzb(String str, URL url, ArrayList<zza> arrayList, String str2) {
            this.zzzp = str;
            this.zzzq = url;
            if (arrayList == null) {
                this.zzzr = new ArrayList<>();
            } else {
                this.zzzr = arrayList;
            }
            this.zzzs = str2;
        }

        public String zzdU() {
            return this.zzzp;
        }

        public URL zzdV() {
            return this.zzzq;
        }

        public ArrayList<zza> zzdW() {
            return this.zzzr;
        }

        public String zzdX() {
            return this.zzzs;
        }
    }

    @zzhb
    class zzc {
        private final zzd zzzt;
        private final boolean zzzu;
        private final String zzzv;

        public zzc(boolean z, zzd zzdVar, String str) {
            this.zzzu = z;
            this.zzzt = zzdVar;
            this.zzzv = str;
        }

        public String getReason() {
            return this.zzzv;
        }

        public boolean isSuccess() {
            return this.zzzu;
        }

        public zzd zzdY() {
            return this.zzzt;
        }
    }

    @zzhb
    static class zzd {
        private final String zzxY;
        private final String zzzp;
        private final int zzzw;
        private final List<zza> zzzx;

        public zzd(String str, int i, List<zza> list, String str2) {
            this.zzzp = str;
            this.zzzw = i;
            if (list == null) {
                this.zzzx = new ArrayList();
            } else {
                this.zzzx = list;
            }
            this.zzxY = str2;
        }

        public String getBody() {
            return this.zzxY;
        }

        public int getResponseCode() {
            return this.zzzw;
        }

        public String zzdU() {
            return this.zzzp;
        }

        public Iterable<zza> zzdZ() {
            return this.zzzx;
        }
    }

    public zzdg(Context context, VersionInfoParcel versionInfoParcel) {
        this.mContext = context;
        this.zzpT = versionInfoParcel;
    }

    public JSONObject zzQ(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = new JSONObject();
            String strOptString = "";
            try {
                strOptString = jSONObject.optString("http_request_id");
                zzc zzcVarZza = zza(zzc(jSONObject));
                if (zzcVarZza.isSuccess()) {
                    jSONObject2.put("response", zza(zzcVarZza.zzdY()));
                    jSONObject2.put(GraphResponse.SUCCESS_KEY, true);
                } else {
                    jSONObject2.put("response", new JSONObject().put("http_request_id", strOptString));
                    jSONObject2.put(GraphResponse.SUCCESS_KEY, false);
                    jSONObject2.put("reason", zzcVarZza.getReason());
                }
                return jSONObject2;
            } catch (Exception e) {
                try {
                    jSONObject2.put("response", new JSONObject().put("http_request_id", strOptString));
                    jSONObject2.put(GraphResponse.SUCCESS_KEY, false);
                    jSONObject2.put("reason", e.toString());
                    return jSONObject2;
                } catch (JSONException e2) {
                    return jSONObject2;
                }
            }
        } catch (JSONException e3) {
            zzin.e("The request is not a valid JSON.");
            try {
                return new JSONObject().put(GraphResponse.SUCCESS_KEY, false);
            } catch (JSONException e4) {
                return new JSONObject();
            }
        }
    }

    protected zzc zza(zzb zzbVar) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) zzbVar.zzdV().openConnection();
            com.google.android.gms.ads.internal.zzr.zzbC().zza(this.mContext, this.zzpT.afmaVersion, false, httpURLConnection);
            for (zza zzaVar : zzbVar.zzdW()) {
                httpURLConnection.addRequestProperty(zzaVar.getKey(), zzaVar.getValue());
            }
            if (!TextUtils.isEmpty(zzbVar.zzdX())) {
                httpURLConnection.setDoOutput(true);
                byte[] bytes = zzbVar.zzdX().getBytes();
                httpURLConnection.setFixedLengthStreamingMode(bytes.length);
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
                bufferedOutputStream.write(bytes);
                bufferedOutputStream.close();
            }
            ArrayList arrayList = new ArrayList();
            if (httpURLConnection.getHeaderFields() != null) {
                for (Map.Entry<String, List<String>> entry : httpURLConnection.getHeaderFields().entrySet()) {
                    Iterator<String> it = entry.getValue().iterator();
                    while (it.hasNext()) {
                        arrayList.add(new zza(entry.getKey(), it.next()));
                    }
                }
            }
            return new zzc(true, new zzd(zzbVar.zzdU(), httpURLConnection.getResponseCode(), arrayList, com.google.android.gms.ads.internal.zzr.zzbC().zza(new InputStreamReader(httpURLConnection.getInputStream()))), null);
        } catch (Exception e) {
            return new zzc(false, null, e.toString());
        }
    }

    protected JSONObject zza(zzd zzdVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("http_request_id", zzdVar.zzdU());
            if (zzdVar.getBody() != null) {
                jSONObject.put("body", zzdVar.getBody());
            }
            JSONArray jSONArray = new JSONArray();
            for (zza zzaVar : zzdVar.zzdZ()) {
                jSONArray.put(new JSONObject().put("key", zzaVar.getKey()).put("value", zzaVar.getValue()));
            }
            jSONObject.put("headers", jSONArray);
            jSONObject.put("response_code", zzdVar.getResponseCode());
        } catch (JSONException e) {
            zzin.zzb("Error constructing JSON for http response.", e);
        }
        return jSONObject;
    }

    @Override // com.google.android.gms.internal.zzdf
    public void zza(final zzjp zzjpVar, final Map<String, String> map) {
        zziq.zza(new Runnable() { // from class: com.google.android.gms.internal.zzdg.1
            @Override // java.lang.Runnable
            public void run() {
                zzin.zzaI("Received Http request.");
                final JSONObject jSONObjectZzQ = zzdg.this.zzQ((String) map.get("http_request"));
                if (jSONObjectZzQ == null) {
                    zzin.e("Response should not be null.");
                } else {
                    zzir.zzMc.post(new Runnable() { // from class: com.google.android.gms.internal.zzdg.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            zzjpVar.zzb("fetchHttpRequestCompleted", jSONObjectZzQ);
                            zzin.zzaI("Dispatched http response.");
                        }
                    });
                }
            }
        });
    }

    protected zzb zzc(JSONObject jSONObject) {
        URL url;
        String strOptString = jSONObject.optString("http_request_id");
        String strOptString2 = jSONObject.optString("url");
        String strOptString3 = jSONObject.optString("post_body", null);
        try {
            url = new URL(strOptString2);
        } catch (MalformedURLException e) {
            zzin.zzb("Error constructing http request.", e);
            url = null;
        }
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("headers");
        if (jSONArrayOptJSONArray == null) {
            jSONArrayOptJSONArray = new JSONArray();
        }
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                arrayList.add(new zza(jSONObjectOptJSONObject.optString("key"), jSONObjectOptJSONObject.optString("value")));
            }
        }
        return new zzb(strOptString, url, arrayList, strOptString3);
    }
}
