package com.google.android.gms.ads.internal.formats;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzan;
import com.google.android.gms.internal.zzdf;
import com.google.android.gms.internal.zzed;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzjp;
import com.google.android.gms.internal.zzjq;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzi implements zzh {
    private final Context mContext;
    private zzjp zzpD;
    private final VersionInfoParcel zzpT;
    private final zzp zzyn;
    private final JSONObject zzyq;
    private final zzed zzyr;
    private final zzh.zza zzys;
    private final zzan zzyt;
    private boolean zzyu;
    private String zzyv;
    private final Object zzpV = new Object();
    private WeakReference<View> zzyw = null;

    public zzi(Context context, zzp zzpVar, zzed zzedVar, zzan zzanVar, JSONObject jSONObject, zzh.zza zzaVar, VersionInfoParcel versionInfoParcel) {
        this.mContext = context;
        this.zzyn = zzpVar;
        this.zzyr = zzedVar;
        this.zzyt = zzanVar;
        this.zzyq = jSONObject;
        this.zzys = zzaVar;
        this.zzpT = versionInfoParcel;
    }

    @Override // com.google.android.gms.ads.internal.formats.zzh
    public Context getContext() {
        return this.mContext;
    }

    @Override // com.google.android.gms.ads.internal.formats.zzh
    public void recordImpression() {
        zzx.zzcD("recordImpression must be called on the main UI thread.");
        zzn(true);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ad", this.zzyq);
            this.zzyr.zza("google.afma.nativeAds.handleImpressionPing", jSONObject);
        } catch (JSONException e) {
            zzin.zzb("Unable to create impression JSON.", e);
        }
        this.zzyn.zza(this);
    }

    public zzb zza(View.OnClickListener onClickListener) {
        zza zzaVarZzdN = this.zzys.zzdN();
        if (zzaVarZzdN == null) {
            return null;
        }
        zzb zzbVar = new zzb(this.mContext, zzaVarZzdN);
        zzbVar.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        zzbVar.zzdI().setOnClickListener(onClickListener);
        zzbVar.zzdI().setContentDescription("Ad attribution icon");
        return zzbVar;
    }

    @Override // com.google.android.gms.ads.internal.formats.zzh
    public void zza(View view, Map<String, WeakReference<View>> map, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        zzx.zzcD("performClick must be called on the main UI thread.");
        for (Map.Entry<String, WeakReference<View>> entry : map.entrySet()) {
            if (view.equals(entry.getValue().get())) {
                zza(entry.getKey(), jSONObject, jSONObject2, jSONObject3);
                return;
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.formats.zzh
    public void zza(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        zzx.zzcD("performClick must be called on the main UI thread.");
        try {
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("asset", str);
            jSONObject4.put("template", this.zzys.zzdM());
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put("ad", this.zzyq);
            jSONObject5.put("click", jSONObject4);
            jSONObject5.put("has_custom_click_handler", this.zzyn.zzs(this.zzys.getCustomTemplateId()) != null);
            if (jSONObject != null) {
                jSONObject5.put("view_rectangles", jSONObject);
            }
            if (jSONObject2 != null) {
                jSONObject5.put("click_point", jSONObject2);
            }
            if (jSONObject3 != null) {
                jSONObject5.put("native_view_rectangle", jSONObject3);
            }
            this.zzyr.zza("google.afma.nativeAds.handleClickGmsg", jSONObject5);
        } catch (JSONException e) {
            zzin.zzb("Unable to create click JSON.", e);
        }
    }

    @Override // com.google.android.gms.ads.internal.formats.zzh
    public void zzb(MotionEvent motionEvent) {
        this.zzyt.zza(motionEvent);
    }

    public zzjp zzdR() {
        this.zzpD = zzdT();
        this.zzpD.getView().setVisibility(8);
        this.zzyr.zza("/loadHtml", new zzdf() { // from class: com.google.android.gms.ads.internal.formats.zzi.1
            @Override // com.google.android.gms.internal.zzdf
            public void zza(zzjp zzjpVar, final Map<String, String> map) {
                zzi.this.zzpD.zzhU().zza(new zzjq.zza() { // from class: com.google.android.gms.ads.internal.formats.zzi.1.1
                    @Override // com.google.android.gms.internal.zzjq.zza
                    public void zza(zzjp zzjpVar2, boolean z) {
                        zzi.this.zzyv = (String) map.get(ShareConstants.WEB_DIALOG_PARAM_ID);
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("messageType", "htmlLoaded");
                            jSONObject.put(ShareConstants.WEB_DIALOG_PARAM_ID, zzi.this.zzyv);
                            zzi.this.zzyr.zzb("sendMessageToNativeJs", jSONObject);
                        } catch (JSONException e) {
                            zzin.zzb("Unable to dispatch sendMessageToNativeJsevent", e);
                        }
                    }
                });
                String str = map.get("overlayHtml");
                String str2 = map.get("baseUrl");
                if (TextUtils.isEmpty(str2)) {
                    zzi.this.zzpD.loadData(str, "text/html", "UTF-8");
                } else {
                    zzi.this.zzpD.loadDataWithBaseURL(str2, str, "text/html", "UTF-8", null);
                }
            }
        });
        this.zzyr.zza("/showOverlay", new zzdf() { // from class: com.google.android.gms.ads.internal.formats.zzi.2
            @Override // com.google.android.gms.internal.zzdf
            public void zza(zzjp zzjpVar, Map<String, String> map) {
                zzi.this.zzpD.getView().setVisibility(0);
            }
        });
        this.zzyr.zza("/hideOverlay", new zzdf() { // from class: com.google.android.gms.ads.internal.formats.zzi.3
            @Override // com.google.android.gms.internal.zzdf
            public void zza(zzjp zzjpVar, Map<String, String> map) {
                zzi.this.zzpD.getView().setVisibility(8);
            }
        });
        this.zzpD.zzhU().zza("/hideOverlay", new zzdf() { // from class: com.google.android.gms.ads.internal.formats.zzi.4
            @Override // com.google.android.gms.internal.zzdf
            public void zza(zzjp zzjpVar, Map<String, String> map) {
                zzi.this.zzpD.getView().setVisibility(8);
            }
        });
        this.zzpD.zzhU().zza("/sendMessageToSdk", new zzdf() { // from class: com.google.android.gms.ads.internal.formats.zzi.5
            @Override // com.google.android.gms.internal.zzdf
            public void zza(zzjp zzjpVar, Map<String, String> map) {
                JSONObject jSONObject = new JSONObject();
                try {
                    for (String str : map.keySet()) {
                        jSONObject.put(str, map.get(str));
                    }
                    jSONObject.put(ShareConstants.WEB_DIALOG_PARAM_ID, zzi.this.zzyv);
                    zzi.this.zzyr.zzb("sendMessageToNativeJs", jSONObject);
                } catch (JSONException e) {
                    zzin.zzb("Unable to dispatch sendMessageToNativeJs event", e);
                }
            }
        });
        return this.zzpD;
    }

    @Override // com.google.android.gms.ads.internal.formats.zzh
    public View zzdS() {
        if (this.zzyw != null) {
            return this.zzyw.get();
        }
        return null;
    }

    zzjp zzdT() {
        return zzr.zzbD().zza(this.mContext, AdSizeParcel.zzt(this.mContext), false, false, this.zzyt, this.zzpT);
    }

    public void zzg(View view) {
    }

    @Override // com.google.android.gms.ads.internal.formats.zzh
    public void zzh(View view) {
        synchronized (this.zzpV) {
            if (this.zzyu) {
                return;
            }
            if (view.isShown()) {
                if (view.getGlobalVisibleRect(new Rect(), null)) {
                    recordImpression();
                }
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.formats.zzh
    public void zzi(View view) {
        this.zzyw = new WeakReference<>(view);
    }

    protected void zzn(boolean z) {
        this.zzyu = z;
    }
}
