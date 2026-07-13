package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.support.v4.media.TransportMediator;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.adjust.sdk.Constants;
import com.google.android.gms.ads.internal.overlay.AdLauncherIntentInfoParcel;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.iid.InstanceID;
import com.google.android.gms.location.places.Place;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzjq extends WebViewClient {
    private static final String[] zzNy = {"UNKNOWN", "HOST_LOOKUP", "UNSUPPORTED_AUTH_SCHEME", "AUTHENTICATION", "PROXY_AUTHENTICATION", "CONNECT", "IO", InstanceID.ERROR_TIMEOUT, "REDIRECT_LOOP", "UNSUPPORTED_SCHEME", "FAILED_SSL_HANDSHAKE", "BAD_URL", "FILE", "FILE_NOT_FOUND", "TOO_MANY_REQUESTS"};
    private static final String[] zzNz = {"NOT_YET_VALID", "EXPIRED", "ID_MISMATCH", "UNTRUSTED", "DATE_INVALID", "INVALID"};
    private zzft zzDk;
    private zza zzGm;
    private final HashMap<String, List<zzdf>> zzNA;
    private com.google.android.gms.ads.internal.overlay.zzg zzNB;
    private zzb zzNC;
    private boolean zzND;
    private boolean zzNE;
    private com.google.android.gms.ads.internal.overlay.zzp zzNF;
    private final zzfr zzNG;
    private boolean zzNH;
    private boolean zzNI;
    private boolean zzNJ;
    private int zzNK;
    protected zzjp zzpD;
    private final Object zzpV;
    private boolean zzsz;
    private com.google.android.gms.ads.internal.client.zza zztz;
    private zzdb zzyW;
    private com.google.android.gms.ads.internal.zze zzzA;
    private zzfn zzzB;
    private zzdh zzzD;
    private zzdj zzzy;

    public interface zza {
        void zza(zzjp zzjpVar, boolean z);
    }

    public interface zzb {
        void zzbi();
    }

    private static class zzc implements com.google.android.gms.ads.internal.overlay.zzg {
        private com.google.android.gms.ads.internal.overlay.zzg zzNB;
        private zzjp zzNM;

        public zzc(zzjp zzjpVar, com.google.android.gms.ads.internal.overlay.zzg zzgVar) {
            this.zzNM = zzjpVar;
            this.zzNB = zzgVar;
        }

        @Override // com.google.android.gms.ads.internal.overlay.zzg
        public void onPause() {
        }

        @Override // com.google.android.gms.ads.internal.overlay.zzg
        public void onResume() {
        }

        @Override // com.google.android.gms.ads.internal.overlay.zzg
        public void zzaW() {
            this.zzNB.zzaW();
            this.zzNM.zzhN();
        }

        @Override // com.google.android.gms.ads.internal.overlay.zzg
        public void zzaX() {
            this.zzNB.zzaX();
            this.zzNM.zzfr();
        }
    }

    private class zzd implements zzdf {
        private zzd() {
        }

        @Override // com.google.android.gms.internal.zzdf
        public void zza(zzjp zzjpVar, Map<String, String> map) {
            if (map.keySet().contains("start")) {
                zzjq.this.zzij();
            } else if (map.keySet().contains("stop")) {
                zzjq.this.zzik();
            } else if (map.keySet().contains("cancel")) {
                zzjq.this.zzil();
            }
        }
    }

    public zzjq(zzjp zzjpVar, boolean z) {
        this(zzjpVar, z, new zzfr(zzjpVar, zzjpVar.zzhQ(), new zzbl(zzjpVar.getContext())), null);
    }

    zzjq(zzjp zzjpVar, boolean z, zzfr zzfrVar, zzfn zzfnVar) {
        this.zzNA = new HashMap<>();
        this.zzpV = new Object();
        this.zzND = false;
        this.zzpD = zzjpVar;
        this.zzsz = z;
        this.zzNG = zzfrVar;
        this.zzzB = zzfnVar;
    }

    private void zza(Context context, String str, String str2, String str3) {
        if (zzbt.zzwO.get().booleanValue()) {
            Bundle bundle = new Bundle();
            bundle.putString("err", str);
            bundle.putString("code", str2);
            bundle.putString("host", zzaN(str3));
            com.google.android.gms.ads.internal.zzr.zzbC().zza(context, this.zzpD.zzhX().afmaVersion, "gmob-apps", bundle, true);
        }
    }

    private String zzaN(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        Uri uri = Uri.parse(str);
        return uri.getHost() != null ? uri.getHost() : "";
    }

    private static boolean zzg(Uri uri) {
        String scheme = uri.getScheme();
        return "http".equalsIgnoreCase(scheme) || Constants.SCHEME.equalsIgnoreCase(scheme);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzij() {
        synchronized (this.zzpV) {
            this.zzNE = true;
        }
        this.zzNK++;
        zzim();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzik() {
        this.zzNK--;
        zzim();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzil() {
        this.zzNJ = true;
        zzim();
    }

    @Override // android.webkit.WebViewClient
    public final void onLoadResource(WebView webView, String url) {
        zzin.v("Loading resource: " + url);
        Uri uri = Uri.parse(url);
        if ("gmsg".equalsIgnoreCase(uri.getScheme()) && "mobileads.google.com".equalsIgnoreCase(uri.getHost())) {
            zzh(uri);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String url) {
        synchronized (this.zzpV) {
            if (this.zzNH) {
                zzin.v("Blank page loaded, 1...");
                this.zzpD.zzhZ();
            } else {
                this.zzNI = true;
                zzim();
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
        zza(this.zzpD.getContext(), "http_err", (errorCode >= 0 || (-errorCode) + (-1) >= zzNy.length) ? String.valueOf(errorCode) : zzNy[(-errorCode) - 1], failingUrl);
        super.onReceivedError(view, errorCode, description, failingUrl);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
        if (error != null) {
            int primaryError = error.getPrimaryError();
            zza(this.zzpD.getContext(), "ssl_err", (primaryError < 0 || primaryError >= zzNz.length) ? String.valueOf(primaryError) : zzNz[primaryError], com.google.android.gms.ads.internal.zzr.zzbE().zza(error));
        }
        super.onReceivedSslError(view, handler, error);
    }

    public final void reset() {
        synchronized (this.zzpV) {
            this.zzNA.clear();
            this.zztz = null;
            this.zzNB = null;
            this.zzGm = null;
            this.zzyW = null;
            this.zzND = false;
            this.zzsz = false;
            this.zzNE = false;
            this.zzzD = null;
            this.zzNF = null;
            this.zzNC = null;
            if (this.zzzB != null) {
                this.zzzB.zzp(true);
                this.zzzB = null;
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideKeyEvent(WebView view, KeyEvent event) {
        switch (event.getKeyCode()) {
            case Place.TYPE_RESTAURANT /* 79 */:
            case Place.TYPE_SPA /* 85 */:
            case Place.TYPE_STADIUM /* 86 */:
            case Place.TYPE_STORAGE /* 87 */:
            case Place.TYPE_STORE /* 88 */:
            case Place.TYPE_SUBWAY_STATION /* 89 */:
            case 90:
            case Place.TYPE_TAXI_STAND /* 91 */:
            case TransportMediator.KEYCODE_MEDIA_PLAY /* 126 */:
            case TransportMediator.KEYCODE_MEDIA_PAUSE /* 127 */:
            case 128:
            case 129:
            case TransportMediator.KEYCODE_MEDIA_RECORD /* 130 */:
            case 222:
                return true;
            default:
                return false;
        }
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String url) {
        Uri uri;
        zzin.v("AdWebView shouldOverrideUrlLoading: " + url);
        Uri uriZza = Uri.parse(url);
        if ("gmsg".equalsIgnoreCase(uriZza.getScheme()) && "mobileads.google.com".equalsIgnoreCase(uriZza.getHost())) {
            zzh(uriZza);
        } else {
            if (this.zzND && webView == this.zzpD.getWebView() && zzg(uriZza)) {
                if (this.zztz != null && zzbt.zzww.get().booleanValue()) {
                    this.zztz.onAdClicked();
                    this.zztz = null;
                }
                return super.shouldOverrideUrlLoading(webView, url);
            }
            if (this.zzpD.getWebView().willNotDraw()) {
                zzin.zzaK("AdWebView unable to handle URL: " + url);
            } else {
                try {
                    zzan zzanVarZzhW = this.zzpD.zzhW();
                    if (zzanVarZzhW != null && zzanVarZzhW.zzb(uriZza)) {
                        uriZza = zzanVarZzhW.zza(uriZza, this.zzpD.getContext());
                    }
                    uri = uriZza;
                } catch (zzao e) {
                    zzin.zzaK("Unable to append parameter to URL: " + url);
                    uri = uriZza;
                }
                if (this.zzzA == null || this.zzzA.zzbh()) {
                    zza(new AdLauncherIntentInfoParcel("android.intent.action.VIEW", uri.toString(), null, null, null, null, null));
                } else {
                    this.zzzA.zzq(url);
                }
            }
        }
        return true;
    }

    public void zzG(boolean z) {
        this.zzND = z;
    }

    public void zza(int i, int i2, boolean z) {
        this.zzNG.zzf(i, i2);
        if (this.zzzB != null) {
            this.zzzB.zza(i, i2, z);
        }
    }

    public final void zza(AdLauncherIntentInfoParcel adLauncherIntentInfoParcel) {
        boolean zZzhY = this.zzpD.zzhY();
        zza(new AdOverlayInfoParcel(adLauncherIntentInfoParcel, (!zZzhY || this.zzpD.zzaN().zzui) ? this.zztz : null, zZzhY ? null : this.zzNB, this.zzNF, this.zzpD.zzhX()));
    }

    public void zza(AdOverlayInfoParcel adOverlayInfoParcel) {
        com.google.android.gms.ads.internal.zzr.zzbA().zza(this.zzpD.getContext(), adOverlayInfoParcel, this.zzzB != null ? this.zzzB.zzeN() : false ? false : true);
    }

    public void zza(zza zzaVar) {
        this.zzGm = zzaVar;
    }

    public void zza(zzb zzbVar) {
        this.zzNC = zzbVar;
    }

    public void zza(String str, zzdf zzdfVar) {
        synchronized (this.zzpV) {
            List<zzdf> copyOnWriteArrayList = this.zzNA.get(str);
            if (copyOnWriteArrayList == null) {
                copyOnWriteArrayList = new CopyOnWriteArrayList<>();
                this.zzNA.put(str, copyOnWriteArrayList);
            }
            copyOnWriteArrayList.add(zzdfVar);
        }
    }

    public final void zza(boolean z, int i) {
        zza(new AdOverlayInfoParcel((!this.zzpD.zzhY() || this.zzpD.zzaN().zzui) ? this.zztz : null, this.zzNB, this.zzNF, this.zzpD, z, i, this.zzpD.zzhX()));
    }

    public final void zza(boolean z, int i, String str) {
        boolean zZzhY = this.zzpD.zzhY();
        zza(new AdOverlayInfoParcel((!zZzhY || this.zzpD.zzaN().zzui) ? this.zztz : null, zZzhY ? null : new zzc(this.zzpD, this.zzNB), this.zzyW, this.zzNF, this.zzpD, z, i, str, this.zzpD.zzhX(), this.zzzD));
    }

    public final void zza(boolean z, int i, String str, String str2) {
        boolean zZzhY = this.zzpD.zzhY();
        zza(new AdOverlayInfoParcel((!zZzhY || this.zzpD.zzaN().zzui) ? this.zztz : null, zZzhY ? null : new zzc(this.zzpD, this.zzNB), this.zzyW, this.zzNF, this.zzpD, z, i, str, str2, this.zzpD.zzhX(), this.zzzD));
    }

    public void zzb(com.google.android.gms.ads.internal.client.zza zzaVar, com.google.android.gms.ads.internal.overlay.zzg zzgVar, zzdb zzdbVar, com.google.android.gms.ads.internal.overlay.zzp zzpVar, boolean z, zzdh zzdhVar, zzdj zzdjVar, com.google.android.gms.ads.internal.zze zzeVar, zzft zzftVar) {
        if (zzeVar == null) {
            zzeVar = new com.google.android.gms.ads.internal.zze(false);
        }
        this.zzzB = new zzfn(this.zzpD, zzftVar);
        zza("/appEvent", new zzda(zzdbVar));
        zza("/backButton", zzde.zzzh);
        zza("/canOpenURLs", zzde.zzyY);
        zza("/canOpenIntents", zzde.zzyZ);
        zza("/click", zzde.zzza);
        zza("/close", zzde.zzzb);
        zza("/customClose", zzde.zzzd);
        zza("/instrument", zzde.zzzk);
        zza("/delayPageLoaded", new zzd());
        zza("/httpTrack", zzde.zzze);
        zza("/log", zzde.zzzf);
        zza("/mraid", new zzdl(zzeVar, this.zzzB));
        zza("/mraidLoaded", this.zzNG);
        zza("/open", new zzdm(zzdhVar, zzeVar, this.zzzB));
        zza("/precache", zzde.zzzj);
        zza("/touch", zzde.zzzg);
        zza("/video", zzde.zzzi);
        zza("/appStreaming", zzde.zzzc);
        if (zzdjVar != null) {
            zza("/setInterstitialProperties", new zzdi(zzdjVar));
        }
        this.zztz = zzaVar;
        this.zzNB = zzgVar;
        this.zzyW = zzdbVar;
        this.zzzD = zzdhVar;
        this.zzNF = zzpVar;
        this.zzzA = zzeVar;
        this.zzDk = zzftVar;
        this.zzzy = zzdjVar;
        zzG(z);
    }

    public void zzb(String str, zzdf zzdfVar) {
        synchronized (this.zzpV) {
            List<zzdf> list = this.zzNA.get(str);
            if (list == null) {
                return;
            }
            list.remove(zzdfVar);
        }
    }

    public boolean zzcv() {
        boolean z;
        synchronized (this.zzpV) {
            z = this.zzsz;
        }
        return z;
    }

    public void zze(int i, int i2) {
        if (this.zzzB != null) {
            this.zzzB.zze(i, i2);
        }
    }

    public final void zzfo() {
        synchronized (this.zzpV) {
            this.zzND = false;
            this.zzsz = true;
            zzir.runOnUiThread(new Runnable() { // from class: com.google.android.gms.internal.zzjq.1
                @Override // java.lang.Runnable
                public void run() {
                    zzjq.this.zzpD.zzid();
                    com.google.android.gms.ads.internal.overlay.zzd zzdVarZzhS = zzjq.this.zzpD.zzhS();
                    if (zzdVarZzhS != null) {
                        zzdVarZzhS.zzfo();
                    }
                    if (zzjq.this.zzNC != null) {
                        zzjq.this.zzNC.zzbi();
                        zzjq.this.zzNC = null;
                    }
                }
            });
        }
    }

    public void zzh(Uri uri) {
        String path = uri.getPath();
        List<zzdf> list = this.zzNA.get(path);
        if (list == null) {
            zzin.v("No GMSG handler found for GMSG: " + uri);
            return;
        }
        Map<String, String> mapZze = com.google.android.gms.ads.internal.zzr.zzbC().zze(uri);
        if (zzin.zzQ(2)) {
            zzin.v("Received GMSG: " + path);
            for (String str : mapZze.keySet()) {
                zzin.v("  " + str + ": " + mapZze.get(str));
            }
        }
        Iterator<zzdf> it = list.iterator();
        while (it.hasNext()) {
            it.next().zza(this.zzpD, mapZze);
        }
    }

    public void zzh(zzjp zzjpVar) {
        this.zzpD = zzjpVar;
    }

    public com.google.android.gms.ads.internal.zze zzig() {
        return this.zzzA;
    }

    public boolean zzih() {
        boolean z;
        synchronized (this.zzpV) {
            z = this.zzNE;
        }
        return z;
    }

    public void zzii() {
        synchronized (this.zzpV) {
            zzin.v("Loading blank page in WebView, 2...");
            this.zzNH = true;
            this.zzpD.zzaL("about:blank");
        }
    }

    public final void zzim() {
        if (this.zzGm != null && ((this.zzNI && this.zzNK <= 0) || this.zzNJ)) {
            this.zzGm.zza(this.zzpD, !this.zzNJ);
            this.zzGm = null;
        }
        this.zzpD.zzie();
    }
}
