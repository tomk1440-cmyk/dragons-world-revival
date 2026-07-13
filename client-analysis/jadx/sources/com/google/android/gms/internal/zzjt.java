package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.nearby.messages.Strategy;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@zzhb
class zzjt extends WebView implements ViewTreeObserver.OnGlobalLayoutListener, DownloadListener, zzjp {
    private AdSizeParcel zzCh;
    private int zzDC;
    private int zzDD;
    private int zzDF;
    private int zzDG;
    private String zzEY;
    private Boolean zzLB;
    private final zza zzNP;
    private zzjq zzNQ;
    private com.google.android.gms.ads.internal.overlay.zzd zzNR;
    private boolean zzNS;
    private boolean zzNT;
    private boolean zzNU;
    private boolean zzNV;
    private int zzNW;
    private boolean zzNX;
    private zzbz zzNY;
    private zzbz zzNZ;
    private zzbz zzOa;
    private zzca zzOb;
    private WeakReference<View.OnClickListener> zzOc;
    private com.google.android.gms.ads.internal.overlay.zzd zzOd;
    private Map<String, zzdr> zzOe;
    private final VersionInfoParcel zzpT;
    private final Object zzpV;
    private final com.google.android.gms.ads.internal.zzd zzpm;
    private zzjc zzrV;
    private final WindowManager zzsb;
    private final zzan zzyt;

    @zzhb
    public static class zza extends MutableContextWrapper {
        private Activity zzMM;
        private Context zzOg;
        private Context zzsa;

        public zza(Context context) {
            super(context);
            setBaseContext(context);
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public Object getSystemService(String service) {
            return this.zzOg.getSystemService(service);
        }

        @Override // android.content.MutableContextWrapper
        public void setBaseContext(Context base) {
            this.zzsa = base.getApplicationContext();
            this.zzMM = base instanceof Activity ? (Activity) base : null;
            this.zzOg = base;
            super.setBaseContext(this.zzsa);
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public void startActivity(Intent intent) {
            if (this.zzMM != null && !zzne.isAtLeastL()) {
                this.zzMM.startActivity(intent);
            } else {
                intent.setFlags(DriveFile.MODE_READ_ONLY);
                this.zzsa.startActivity(intent);
            }
        }

        public Activity zzhP() {
            return this.zzMM;
        }

        public Context zzhQ() {
            return this.zzOg;
        }
    }

    protected zzjt(zza zzaVar, AdSizeParcel adSizeParcel, boolean z, boolean z2, zzan zzanVar, VersionInfoParcel versionInfoParcel, zzcb zzcbVar, com.google.android.gms.ads.internal.zzd zzdVar) {
        super(zzaVar);
        this.zzpV = new Object();
        this.zzNX = true;
        this.zzEY = "";
        this.zzDD = -1;
        this.zzDC = -1;
        this.zzDF = -1;
        this.zzDG = -1;
        this.zzNP = zzaVar;
        this.zzCh = adSizeParcel;
        this.zzNU = z;
        this.zzNW = -1;
        this.zzyt = zzanVar;
        this.zzpT = versionInfoParcel;
        this.zzpm = zzdVar;
        this.zzsb = (WindowManager) getContext().getSystemService("window");
        setBackgroundColor(0);
        WebSettings settings = getSettings();
        settings.setAllowFileAccess(false);
        settings.setJavaScriptEnabled(true);
        settings.setSavePassword(false);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        if (Build.VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(0);
        }
        com.google.android.gms.ads.internal.zzr.zzbC().zza(zzaVar, versionInfoParcel.afmaVersion, settings);
        com.google.android.gms.ads.internal.zzr.zzbE().zza(getContext(), settings);
        setDownloadListener(this);
        zziq();
        if (zzne.zzsi()) {
            addJavascriptInterface(new zzju(this), "googleAdsJsInterface");
        }
        this.zzrV = new zzjc(this.zzNP.zzhP(), this, null);
        zzd(zzcbVar);
    }

    static zzjt zzb(Context context, AdSizeParcel adSizeParcel, boolean z, boolean z2, zzan zzanVar, VersionInfoParcel versionInfoParcel, zzcb zzcbVar, com.google.android.gms.ads.internal.zzd zzdVar) {
        return new zzjt(new zza(context), adSizeParcel, z, z2, zzanVar, versionInfoParcel, zzcbVar, zzdVar);
    }

    private void zzd(zzcb zzcbVar) {
        zziu();
        this.zzOb = new zzca(new zzcb(true, "make_wv", this.zzCh.zzuh));
        this.zzOb.zzdA().zzc(zzcbVar);
        this.zzNZ = zzbx.zzb(this.zzOb.zzdA());
        this.zzOb.zza("native:view_create", this.zzNZ);
        this.zzOa = null;
        this.zzNY = null;
    }

    private void zzio() {
        synchronized (this.zzpV) {
            this.zzLB = com.google.android.gms.ads.internal.zzr.zzbF().zzhg();
            if (this.zzLB == null) {
                try {
                    evaluateJavascript("(function(){})()", null);
                    zzb((Boolean) true);
                } catch (IllegalStateException e) {
                    zzb((Boolean) false);
                }
            }
        }
    }

    private void zzip() {
        zzbx.zza(this.zzOb.zzdA(), this.zzNY, "aeh");
    }

    private void zziq() {
        synchronized (this.zzpV) {
            if (this.zzNU || this.zzCh.zzui) {
                if (Build.VERSION.SDK_INT < 14) {
                    zzin.zzaI("Disabling hardware acceleration on an overlay.");
                    zzir();
                } else {
                    zzin.zzaI("Enabling hardware acceleration on an overlay.");
                    zzis();
                }
            } else if (Build.VERSION.SDK_INT < 18) {
                zzin.zzaI("Disabling hardware acceleration on an AdView.");
                zzir();
            } else {
                zzin.zzaI("Enabling hardware acceleration on an AdView.");
                zzis();
            }
        }
    }

    private void zzir() {
        synchronized (this.zzpV) {
            if (!this.zzNV) {
                com.google.android.gms.ads.internal.zzr.zzbE().zzn(this);
            }
            this.zzNV = true;
        }
    }

    private void zzis() {
        synchronized (this.zzpV) {
            if (this.zzNV) {
                com.google.android.gms.ads.internal.zzr.zzbE().zzm(this);
            }
            this.zzNV = false;
        }
    }

    private void zzit() {
        synchronized (this.zzpV) {
            if (this.zzOe != null) {
                Iterator<zzdr> it = this.zzOe.values().iterator();
                while (it.hasNext()) {
                    it.next().release();
                }
            }
        }
    }

    private void zziu() {
        zzcb zzcbVarZzdA;
        if (this.zzOb == null || (zzcbVarZzdA = this.zzOb.zzdA()) == null || com.google.android.gms.ads.internal.zzr.zzbF().zzhb() == null) {
            return;
        }
        com.google.android.gms.ads.internal.zzr.zzbF().zzhb().zza(zzcbVarZzdA);
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.zzjp
    public void destroy() {
        synchronized (this.zzpV) {
            zziu();
            this.zzrV.zzhF();
            if (this.zzNR != null) {
                this.zzNR.close();
                this.zzNR.onDestroy();
                this.zzNR = null;
            }
            this.zzNQ.reset();
            if (this.zzNT) {
                return;
            }
            com.google.android.gms.ads.internal.zzr.zzbR().zzd(this);
            zzit();
            this.zzNT = true;
            zzin.v("Initiating WebView self destruct sequence in 3...");
            this.zzNQ.zzii();
        }
    }

    @Override // android.webkit.WebView
    @TargetApi(19)
    public void evaluateJavascript(String script, ValueCallback<String> resultCallback) {
        synchronized (this.zzpV) {
            if (!isDestroyed()) {
                super.evaluateJavascript(script, resultCallback);
                return;
            }
            zzin.zzaK("The webview is destroyed. Ignoring action.");
            if (resultCallback != null) {
                resultCallback.onReceiveValue(null);
            }
        }
    }

    protected void finalize() throws Throwable {
        synchronized (this.zzpV) {
            if (!this.zzNT) {
                com.google.android.gms.ads.internal.zzr.zzbR().zzd(this);
                zzit();
            }
        }
        super.finalize();
    }

    @Override // com.google.android.gms.internal.zzjp
    public String getRequestId() {
        String str;
        synchronized (this.zzpV) {
            str = this.zzEY;
        }
        return str;
    }

    @Override // com.google.android.gms.internal.zzjp
    public int getRequestedOrientation() {
        int i;
        synchronized (this.zzpV) {
            i = this.zzNW;
        }
        return i;
    }

    @Override // com.google.android.gms.internal.zzjp
    public View getView() {
        return this;
    }

    @Override // com.google.android.gms.internal.zzjp
    public WebView getWebView() {
        return this;
    }

    @Override // com.google.android.gms.internal.zzjp
    public boolean isDestroyed() {
        boolean z;
        synchronized (this.zzpV) {
            z = this.zzNT;
        }
        return z;
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.zzjp
    public void loadData(String data, String mimeType, String encoding) {
        synchronized (this.zzpV) {
            if (isDestroyed()) {
                zzin.zzaK("The webview is destroyed. Ignoring action.");
            } else {
                super.loadData(data, mimeType, encoding);
            }
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.zzjp
    public void loadDataWithBaseURL(String baseUrl, String data, String mimeType, String encoding, String historyUrl) {
        synchronized (this.zzpV) {
            if (isDestroyed()) {
                zzin.zzaK("The webview is destroyed. Ignoring action.");
            } else {
                super.loadDataWithBaseURL(baseUrl, data, mimeType, encoding, historyUrl);
            }
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.zzjp
    public void loadUrl(String uri) {
        synchronized (this.zzpV) {
            if (isDestroyed()) {
                zzin.zzaK("The webview is destroyed. Ignoring action.");
            } else {
                try {
                    super.loadUrl(uri);
                } catch (Throwable th) {
                    zzin.zzaK("Could not call loadUrl. " + th);
                }
            }
        }
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        synchronized (this.zzpV) {
            super.onAttachedToWindow();
            if (!isDestroyed()) {
                this.zzrV.onAttachedToWindow();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        synchronized (this.zzpV) {
            if (!isDestroyed()) {
                this.zzrV.onDetachedFromWindow();
            }
            super.onDetachedFromWindow();
        }
    }

    @Override // android.webkit.DownloadListener
    public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimeType, long size) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse(url), mimeType);
            com.google.android.gms.ads.internal.zzr.zzbC().zzb(getContext(), intent);
        } catch (ActivityNotFoundException e) {
            zzin.zzaI("Couldn't find an Activity to view url/mimetype: " + url + " / " + mimeType);
        }
    }

    @Override // android.webkit.WebView, android.view.View
    @TargetApi(21)
    protected void onDraw(Canvas canvas) {
        if (isDestroyed()) {
            return;
        }
        if (Build.VERSION.SDK_INT == 21 && canvas.isHardwareAccelerated() && !isAttachedToWindow()) {
            return;
        }
        super.onDraw(canvas);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        boolean zZzin = zzin();
        com.google.android.gms.ads.internal.overlay.zzd zzdVarZzhS = zzhS();
        if (zzdVarZzhS == null || !zZzin) {
            return;
        }
        zzdVarZzhS.zzfq();
    }

    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int i = Strategy.TTL_SECONDS_INFINITE;
        synchronized (this.zzpV) {
            if (isDestroyed()) {
                setMeasuredDimension(0, 0);
                return;
            }
            if (isInEditMode() || this.zzNU || this.zzCh.zzuk || this.zzCh.zzul) {
                super.onMeasure(widthMeasureSpec, heightMeasureSpec);
                return;
            }
            if (this.zzCh.zzui) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                this.zzsb.getDefaultDisplay().getMetrics(displayMetrics);
                setMeasuredDimension(displayMetrics.widthPixels, displayMetrics.heightPixels);
                return;
            }
            int mode = View.MeasureSpec.getMode(widthMeasureSpec);
            int size = View.MeasureSpec.getSize(widthMeasureSpec);
            int mode2 = View.MeasureSpec.getMode(heightMeasureSpec);
            int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
            int i2 = (mode == Integer.MIN_VALUE || mode == 1073741824) ? size : Integer.MAX_VALUE;
            if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
                i = size2;
            }
            if (this.zzCh.widthPixels > i2 || this.zzCh.heightPixels > i) {
                float f = this.zzNP.getResources().getDisplayMetrics().density;
                zzin.zzaK("Not enough space to show ad. Needs " + ((int) (this.zzCh.widthPixels / f)) + "x" + ((int) (this.zzCh.heightPixels / f)) + " dp, but only has " + ((int) (size / f)) + "x" + ((int) (size2 / f)) + " dp.");
                if (getVisibility() != 8) {
                    setVisibility(4);
                }
                setMeasuredDimension(0, 0);
            } else {
                if (getVisibility() != 8) {
                    setVisibility(0);
                }
                setMeasuredDimension(this.zzCh.widthPixels, this.zzCh.heightPixels);
            }
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.zzjp
    public void onPause() {
        if (isDestroyed()) {
            return;
        }
        try {
            if (zzne.zzsd()) {
                super.onPause();
            }
        } catch (Exception e) {
            zzin.zzb("Could not pause webview.", e);
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.zzjp
    public void onResume() {
        if (isDestroyed()) {
            return;
        }
        try {
            if (zzne.zzsd()) {
                super.onResume();
            }
        } catch (Exception e) {
            zzin.zzb("Could not resume webview.", e);
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        if (this.zzyt != null) {
            this.zzyt.zza(event);
        }
        if (isDestroyed()) {
            return false;
        }
        return super.onTouchEvent(event);
    }

    @Override // com.google.android.gms.internal.zzjp
    public void setContext(Context context) {
        this.zzNP.setBaseContext(context);
        this.zzrV.zzi(this.zzNP.zzhP());
    }

    @Override // android.view.View, com.google.android.gms.internal.zzjp
    public void setOnClickListener(View.OnClickListener listener) {
        this.zzOc = new WeakReference<>(listener);
        super.setOnClickListener(listener);
    }

    @Override // com.google.android.gms.internal.zzjp
    public void setRequestedOrientation(int requestedOrientation) {
        synchronized (this.zzpV) {
            this.zzNW = requestedOrientation;
            if (this.zzNR != null) {
                this.zzNR.setRequestedOrientation(this.zzNW);
            }
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.zzjp
    public void setWebViewClient(WebViewClient webViewClient) {
        super.setWebViewClient(webViewClient);
        if (webViewClient instanceof zzjq) {
            this.zzNQ = (zzjq) webViewClient;
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.zzjp
    public void stopLoading() {
        if (isDestroyed()) {
            return;
        }
        try {
            super.stopLoading();
        } catch (Exception e) {
            zzin.zzb("Could not stop loading webview.", e);
        }
    }

    @Override // com.google.android.gms.internal.zzjp
    public void zzD(boolean z) {
        synchronized (this.zzpV) {
            this.zzNU = z;
            zziq();
        }
    }

    @Override // com.google.android.gms.internal.zzjp
    public void zzE(boolean z) {
        synchronized (this.zzpV) {
            if (this.zzNR != null) {
                this.zzNR.zza(this.zzNQ.zzcv(), z);
            } else {
                this.zzNS = z;
            }
        }
    }

    @Override // com.google.android.gms.internal.zzjp
    public void zzF(boolean z) {
        synchronized (this.zzpV) {
            this.zzNX = z;
        }
    }

    @Override // com.google.android.gms.internal.zzjp
    public void zza(Context context, AdSizeParcel adSizeParcel, zzcb zzcbVar) {
        synchronized (this.zzpV) {
            this.zzrV.zzhF();
            setContext(context);
            this.zzNR = null;
            this.zzCh = adSizeParcel;
            this.zzNU = false;
            this.zzNS = false;
            this.zzEY = "";
            this.zzNW = -1;
            com.google.android.gms.ads.internal.zzr.zzbE().zzj(this);
            loadUrl("about:blank");
            this.zzNQ.reset();
            setOnTouchListener(null);
            setOnClickListener(null);
            this.zzNX = true;
            zzd(zzcbVar);
        }
    }

    @Override // com.google.android.gms.internal.zzjp
    public void zza(AdSizeParcel adSizeParcel) {
        synchronized (this.zzpV) {
            this.zzCh = adSizeParcel;
            requestLayout();
        }
    }

    @Override // com.google.android.gms.internal.zzav
    public void zza(zzau zzauVar, boolean z) {
        HashMap map = new HashMap();
        map.put("isVisible", z ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        zza("onAdVisibilityChanged", map);
    }

    @TargetApi(19)
    protected void zza(String str, ValueCallback<String> valueCallback) {
        synchronized (this.zzpV) {
            if (isDestroyed()) {
                zzin.zzaK("The webview is destroyed. Ignoring action.");
                if (valueCallback != null) {
                    valueCallback.onReceiveValue(null);
                }
            } else {
                evaluateJavascript(str, valueCallback);
            }
        }
    }

    @Override // com.google.android.gms.internal.zzeh
    public void zza(String str, zzdf zzdfVar) {
        if (this.zzNQ != null) {
            this.zzNQ.zza(str, zzdfVar);
        }
    }

    @Override // com.google.android.gms.internal.zzjp
    public void zza(String str, Map<String, ?> map) {
        try {
            zzb(str, com.google.android.gms.ads.internal.zzr.zzbC().zzG(map));
        } catch (JSONException e) {
            zzin.zzaK("Could not convert parameters to JSON.");
        }
    }

    @Override // com.google.android.gms.internal.zzjp, com.google.android.gms.internal.zzeh
    public void zza(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        zze(str, jSONObject.toString());
    }

    @Override // com.google.android.gms.internal.zzjp
    public void zzaL(String str) {
        synchronized (this.zzpV) {
            try {
                super.loadUrl(str);
            } catch (Throwable th) {
                zzin.zzaK("Could not call loadUrl. " + th);
            }
        }
    }

    @Override // com.google.android.gms.internal.zzjp
    public void zzaM(String str) {
        synchronized (this.zzpV) {
            if (str == null) {
                str = "";
            }
            this.zzEY = str;
        }
    }

    @Override // com.google.android.gms.internal.zzjp
    public AdSizeParcel zzaN() {
        AdSizeParcel adSizeParcel;
        synchronized (this.zzpV) {
            adSizeParcel = this.zzCh;
        }
        return adSizeParcel;
    }

    protected void zzaO(String str) {
        synchronized (this.zzpV) {
            if (isDestroyed()) {
                zzin.zzaK("The webview is destroyed. Ignoring action.");
            } else {
                loadUrl(str);
            }
        }
    }

    protected void zzaP(String str) {
        if (!zzne.zzsk()) {
            zzaO("javascript:" + str);
            return;
        }
        if (zzhg() == null) {
            zzio();
        }
        if (zzhg().booleanValue()) {
            zza(str, (ValueCallback<String>) null);
        } else {
            zzaO("javascript:" + str);
        }
    }

    @Override // com.google.android.gms.internal.zzjp
    public void zzb(com.google.android.gms.ads.internal.overlay.zzd zzdVar) {
        synchronized (this.zzpV) {
            this.zzNR = zzdVar;
        }
    }

    void zzb(Boolean bool) {
        this.zzLB = bool;
        com.google.android.gms.ads.internal.zzr.zzbF().zzb(bool);
    }

    @Override // com.google.android.gms.internal.zzeh
    public void zzb(String str, zzdf zzdfVar) {
        if (this.zzNQ != null) {
            this.zzNQ.zzb(str, zzdfVar);
        }
    }

    @Override // com.google.android.gms.internal.zzeh
    public void zzb(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String string = jSONObject.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("AFMA_ReceiveMessage('");
        sb.append(str);
        sb.append("'");
        sb.append(",");
        sb.append(string);
        sb.append(");");
        zzin.v("Dispatching AFMA event: " + sb.toString());
        zzaP(sb.toString());
    }

    @Override // com.google.android.gms.internal.zzjp
    public void zzc(com.google.android.gms.ads.internal.overlay.zzd zzdVar) {
        synchronized (this.zzpV) {
            this.zzOd = zzdVar;
        }
    }

    @Override // com.google.android.gms.internal.zzjp, com.google.android.gms.internal.zzeh
    public void zze(String str, String str2) {
        zzaP(str + "(" + str2 + ");");
    }

    @Override // com.google.android.gms.internal.zzjp
    public boolean zzfL() {
        boolean z;
        synchronized (this.zzpV) {
            zzbx.zza(this.zzOb.zzdA(), this.zzNY, "aebb");
            z = this.zzNX;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.zzjp
    public void zzfr() {
        if (this.zzNY == null) {
            zzbx.zza(this.zzOb.zzdA(), this.zzOa, "aes");
            this.zzNY = zzbx.zzb(this.zzOb.zzdA());
            this.zzOb.zza("native:view_show", this.zzNY);
        }
        HashMap map = new HashMap(1);
        map.put("version", this.zzpT.afmaVersion);
        zza("onshow", map);
    }

    @Override // com.google.android.gms.internal.zzjp
    public void zzhN() {
        zzip();
        HashMap map = new HashMap(1);
        map.put("version", this.zzpT.afmaVersion);
        zza("onhide", map);
    }

    @Override // com.google.android.gms.internal.zzjp
    public void zzhO() {
        HashMap map = new HashMap(2);
        map.put("app_volume", String.valueOf(com.google.android.gms.ads.internal.zzr.zzbC().zzbt()));
        map.put("device_volume", String.valueOf(com.google.android.gms.ads.internal.zzr.zzbC().zzQ(getContext())));
        zza("volume", map);
    }

    @Override // com.google.android.gms.internal.zzjp
    public Activity zzhP() {
        return this.zzNP.zzhP();
    }

    @Override // com.google.android.gms.internal.zzjp
    public Context zzhQ() {
        return this.zzNP.zzhQ();
    }

    @Override // com.google.android.gms.internal.zzjp
    public com.google.android.gms.ads.internal.zzd zzhR() {
        return this.zzpm;
    }

    @Override // com.google.android.gms.internal.zzjp
    public com.google.android.gms.ads.internal.overlay.zzd zzhS() {
        com.google.android.gms.ads.internal.overlay.zzd zzdVar;
        synchronized (this.zzpV) {
            zzdVar = this.zzNR;
        }
        return zzdVar;
    }

    @Override // com.google.android.gms.internal.zzjp
    public com.google.android.gms.ads.internal.overlay.zzd zzhT() {
        com.google.android.gms.ads.internal.overlay.zzd zzdVar;
        synchronized (this.zzpV) {
            zzdVar = this.zzOd;
        }
        return zzdVar;
    }

    @Override // com.google.android.gms.internal.zzjp
    public zzjq zzhU() {
        return this.zzNQ;
    }

    @Override // com.google.android.gms.internal.zzjp
    public boolean zzhV() {
        return this.zzNS;
    }

    @Override // com.google.android.gms.internal.zzjp
    public zzan zzhW() {
        return this.zzyt;
    }

    @Override // com.google.android.gms.internal.zzjp
    public VersionInfoParcel zzhX() {
        return this.zzpT;
    }

    @Override // com.google.android.gms.internal.zzjp
    public boolean zzhY() {
        boolean z;
        synchronized (this.zzpV) {
            z = this.zzNU;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.zzjp
    public void zzhZ() {
        synchronized (this.zzpV) {
            zzin.v("Destroying WebView!");
            zzir.zzMc.post(new Runnable() { // from class: com.google.android.gms.internal.zzjt.1
                @Override // java.lang.Runnable
                public void run() {
                    zzjt.super.destroy();
                }
            });
        }
    }

    Boolean zzhg() {
        Boolean bool;
        synchronized (this.zzpV) {
            bool = this.zzLB;
        }
        return bool;
    }

    @Override // com.google.android.gms.internal.zzjp
    public zzjo zzia() {
        return null;
    }

    @Override // com.google.android.gms.internal.zzjp
    public zzbz zzib() {
        return this.zzOa;
    }

    @Override // com.google.android.gms.internal.zzjp
    public zzca zzic() {
        return this.zzOb;
    }

    @Override // com.google.android.gms.internal.zzjp
    public void zzid() {
        this.zzrV.zzhE();
    }

    @Override // com.google.android.gms.internal.zzjp
    public void zzie() {
        if (this.zzOa == null) {
            this.zzOa = zzbx.zzb(this.zzOb.zzdA());
            this.zzOb.zza("native:view_load", this.zzOa);
        }
    }

    @Override // com.google.android.gms.internal.zzjp
    public View.OnClickListener zzif() {
        return this.zzOc.get();
    }

    public boolean zzin() {
        int iZzb;
        int iZzb2;
        if (!zzhU().zzcv()) {
            return false;
        }
        DisplayMetrics displayMetricsZza = com.google.android.gms.ads.internal.zzr.zzbC().zza(this.zzsb);
        int iZzb3 = com.google.android.gms.ads.internal.client.zzn.zzcS().zzb(displayMetricsZza, displayMetricsZza.widthPixels);
        int iZzb4 = com.google.android.gms.ads.internal.client.zzn.zzcS().zzb(displayMetricsZza, displayMetricsZza.heightPixels);
        Activity activityZzhP = zzhP();
        if (activityZzhP == null || activityZzhP.getWindow() == null) {
            iZzb = iZzb4;
            iZzb2 = iZzb3;
        } else {
            int[] iArrZze = com.google.android.gms.ads.internal.zzr.zzbC().zze(activityZzhP);
            iZzb2 = com.google.android.gms.ads.internal.client.zzn.zzcS().zzb(displayMetricsZza, iArrZze[0]);
            iZzb = com.google.android.gms.ads.internal.client.zzn.zzcS().zzb(displayMetricsZza, iArrZze[1]);
        }
        if (this.zzDC == iZzb3 && this.zzDD == iZzb4 && this.zzDF == iZzb2 && this.zzDG == iZzb) {
            return false;
        }
        boolean z = (this.zzDC == iZzb3 && this.zzDD == iZzb4) ? false : true;
        this.zzDC = iZzb3;
        this.zzDD = iZzb4;
        this.zzDF = iZzb2;
        this.zzDG = iZzb;
        new zzfs(this).zza(iZzb3, iZzb4, iZzb2, iZzb, displayMetricsZza.density, this.zzsb.getDefaultDisplay().getRotation());
        return z;
    }

    @Override // com.google.android.gms.internal.zzjp
    public void zzy(int i) {
        zzip();
        HashMap map = new HashMap(2);
        map.put("closetype", String.valueOf(i));
        map.put("version", this.zzpT.afmaVersion);
        zza("onhide", map);
    }
}
