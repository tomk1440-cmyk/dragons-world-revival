package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@zzhb
class zzjs extends FrameLayout implements zzjp {
    private final zzjp zzNN;
    private final zzjo zzNO;

    public zzjs(zzjp zzjpVar) {
        super(zzjpVar.getContext());
        this.zzNN = zzjpVar;
        this.zzNO = new zzjo(zzjpVar.zzhQ(), this, this);
        zzjq zzjqVarZzhU = this.zzNN.zzhU();
        if (zzjqVarZzhU != null) {
            zzjqVarZzhU.zzh(this);
        }
        addView(this.zzNN.getView());
    }

    @Override // com.google.android.gms.internal.zzjp
    public void clearCache(boolean includeDiskFiles) {
        this.zzNN.clearCache(includeDiskFiles);
    }

    @Override // com.google.android.gms.internal.zzjp
    public void destroy() {
        this.zzNN.destroy();
    }

    @Override // com.google.android.gms.internal.zzjp
    public String getRequestId() {
        return this.zzNN.getRequestId();
    }

    @Override // com.google.android.gms.internal.zzjp
    public int getRequestedOrientation() {
        return this.zzNN.getRequestedOrientation();
    }

    @Override // com.google.android.gms.internal.zzjp
    public View getView() {
        return this;
    }

    @Override // com.google.android.gms.internal.zzjp
    public WebView getWebView() {
        return this.zzNN.getWebView();
    }

    @Override // com.google.android.gms.internal.zzjp
    public boolean isDestroyed() {
        return this.zzNN.isDestroyed();
    }

    @Override // com.google.android.gms.internal.zzjp
    public void loadData(String data, String mimeType, String encoding) {
        this.zzNN.loadData(data, mimeType, encoding);
    }

    @Override // com.google.android.gms.internal.zzjp
    public void loadDataWithBaseURL(String baseUrl, String data, String mimeType, String encoding, String historyUrl) {
        this.zzNN.loadDataWithBaseURL(baseUrl, data, mimeType, encoding, historyUrl);
    }

    @Override // com.google.android.gms.internal.zzjp
    public void loadUrl(String url) {
        this.zzNN.loadUrl(url);
    }

    @Override // com.google.android.gms.internal.zzjp
    public void onPause() {
        this.zzNO.onPause();
        this.zzNN.onPause();
    }

    @Override // com.google.android.gms.internal.zzjp
    public void onResume() {
        this.zzNN.onResume();
    }

    @Override // android.view.View, com.google.android.gms.internal.zzjp
    public void setBackgroundColor(int color) {
        this.zzNN.setBackgroundColor(color);
    }

    @Override // com.google.android.gms.internal.zzjp
    public void setContext(Context context) {
        this.zzNN.setContext(context);
    }

    @Override // android.view.View, com.google.android.gms.internal.zzjp
    public void setOnClickListener(View.OnClickListener listener) {
        this.zzNN.setOnClickListener(listener);
    }

    @Override // android.view.View, com.google.android.gms.internal.zzjp
    public void setOnTouchListener(View.OnTouchListener listener) {
        this.zzNN.setOnTouchListener(listener);
    }

    @Override // com.google.android.gms.internal.zzjp
    public void setRequestedOrientation(int requestedOrientation) {
        this.zzNN.setRequestedOrientation(requestedOrientation);
    }

    @Override // com.google.android.gms.internal.zzjp
    public void setWebChromeClient(WebChromeClient client) {
        this.zzNN.setWebChromeClient(client);
    }

    @Override // com.google.android.gms.internal.zzjp
    public void setWebViewClient(WebViewClient client) {
        this.zzNN.setWebViewClient(client);
    }

    @Override // com.google.android.gms.internal.zzjp
    public void stopLoading() {
        this.zzNN.stopLoading();
    }

    @Override // com.google.android.gms.internal.zzjp
    public void zzD(boolean z) {
        this.zzNN.zzD(z);
    }

    @Override // com.google.android.gms.internal.zzjp
    public void zzE(boolean z) {
        this.zzNN.zzE(z);
    }

    @Override // com.google.android.gms.internal.zzjp
    public void zzF(boolean z) {
        this.zzNN.zzF(z);
    }

    @Override // com.google.android.gms.internal.zzjp
    public void zza(Context context, AdSizeParcel adSizeParcel, zzcb zzcbVar) {
        this.zzNN.zza(context, adSizeParcel, zzcbVar);
    }

    @Override // com.google.android.gms.internal.zzjp
    public void zza(AdSizeParcel adSizeParcel) {
        this.zzNN.zza(adSizeParcel);
    }

    @Override // com.google.android.gms.internal.zzav
    public void zza(zzau zzauVar, boolean z) {
        this.zzNN.zza(zzauVar, z);
    }

    @Override // com.google.android.gms.internal.zzeh
    public void zza(String str, zzdf zzdfVar) {
        this.zzNN.zza(str, zzdfVar);
    }

    @Override // com.google.android.gms.internal.zzjp
    public void zza(String str, Map<String, ?> map) {
        this.zzNN.zza(str, map);
    }

    @Override // com.google.android.gms.internal.zzjp, com.google.android.gms.internal.zzeh
    public void zza(String str, JSONObject jSONObject) {
        this.zzNN.zza(str, jSONObject);
    }

    @Override // com.google.android.gms.internal.zzjp
    public void zzaL(String str) {
        this.zzNN.zzaL(str);
    }

    @Override // com.google.android.gms.internal.zzjp
    public void zzaM(String str) {
        this.zzNN.zzaM(str);
    }

    @Override // com.google.android.gms.internal.zzjp
    public AdSizeParcel zzaN() {
        return this.zzNN.zzaN();
    }

    @Override // com.google.android.gms.internal.zzjp
    public void zzb(com.google.android.gms.ads.internal.overlay.zzd zzdVar) {
        this.zzNN.zzb(zzdVar);
    }

    @Override // com.google.android.gms.internal.zzeh
    public void zzb(String str, zzdf zzdfVar) {
        this.zzNN.zzb(str, zzdfVar);
    }

    @Override // com.google.android.gms.internal.zzeh
    public void zzb(String str, JSONObject jSONObject) {
        this.zzNN.zzb(str, jSONObject);
    }

    @Override // com.google.android.gms.internal.zzjp
    public void zzc(com.google.android.gms.ads.internal.overlay.zzd zzdVar) {
        this.zzNN.zzc(zzdVar);
    }

    @Override // com.google.android.gms.internal.zzjp, com.google.android.gms.internal.zzeh
    public void zze(String str, String str2) {
        this.zzNN.zze(str, str2);
    }

    @Override // com.google.android.gms.internal.zzjp
    public boolean zzfL() {
        return this.zzNN.zzfL();
    }

    @Override // com.google.android.gms.internal.zzjp
    public void zzfr() {
        this.zzNN.zzfr();
    }

    @Override // com.google.android.gms.internal.zzjp
    public void zzhN() {
        this.zzNN.zzhN();
    }

    @Override // com.google.android.gms.internal.zzjp
    public void zzhO() {
        this.zzNN.zzhO();
    }

    @Override // com.google.android.gms.internal.zzjp
    public Activity zzhP() {
        return this.zzNN.zzhP();
    }

    @Override // com.google.android.gms.internal.zzjp
    public Context zzhQ() {
        return this.zzNN.zzhQ();
    }

    @Override // com.google.android.gms.internal.zzjp
    public com.google.android.gms.ads.internal.zzd zzhR() {
        return this.zzNN.zzhR();
    }

    @Override // com.google.android.gms.internal.zzjp
    public com.google.android.gms.ads.internal.overlay.zzd zzhS() {
        return this.zzNN.zzhS();
    }

    @Override // com.google.android.gms.internal.zzjp
    public com.google.android.gms.ads.internal.overlay.zzd zzhT() {
        return this.zzNN.zzhT();
    }

    @Override // com.google.android.gms.internal.zzjp
    public zzjq zzhU() {
        return this.zzNN.zzhU();
    }

    @Override // com.google.android.gms.internal.zzjp
    public boolean zzhV() {
        return this.zzNN.zzhV();
    }

    @Override // com.google.android.gms.internal.zzjp
    public zzan zzhW() {
        return this.zzNN.zzhW();
    }

    @Override // com.google.android.gms.internal.zzjp
    public VersionInfoParcel zzhX() {
        return this.zzNN.zzhX();
    }

    @Override // com.google.android.gms.internal.zzjp
    public boolean zzhY() {
        return this.zzNN.zzhY();
    }

    @Override // com.google.android.gms.internal.zzjp
    public void zzhZ() {
        this.zzNO.onDestroy();
        this.zzNN.zzhZ();
    }

    @Override // com.google.android.gms.internal.zzjp
    public zzjo zzia() {
        return this.zzNO;
    }

    @Override // com.google.android.gms.internal.zzjp
    public zzbz zzib() {
        return this.zzNN.zzib();
    }

    @Override // com.google.android.gms.internal.zzjp
    public zzca zzic() {
        return this.zzNN.zzic();
    }

    @Override // com.google.android.gms.internal.zzjp
    public void zzid() {
        this.zzNN.zzid();
    }

    @Override // com.google.android.gms.internal.zzjp
    public void zzie() {
        this.zzNN.zzie();
    }

    @Override // com.google.android.gms.internal.zzjp
    public View.OnClickListener zzif() {
        return this.zzNN.zzif();
    }

    @Override // com.google.android.gms.internal.zzjp
    public void zzy(int i) {
        this.zzNN.zzy(i);
    }
}
