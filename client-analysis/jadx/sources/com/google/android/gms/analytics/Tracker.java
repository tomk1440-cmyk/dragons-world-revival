package com.google.android.gms.analytics;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.adjust.sdk.Constants;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.analytics.internal.zzab;
import com.google.android.gms.analytics.internal.zzad;
import com.google.android.gms.analytics.internal.zzal;
import com.google.android.gms.analytics.internal.zzam;
import com.google.android.gms.analytics.internal.zzd;
import com.google.android.gms.analytics.internal.zze;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.analytics.internal.zzh;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzpq;
import com.google.android.gms.nearby.messages.Strategy;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

/* JADX INFO: loaded from: classes.dex */
public class Tracker extends zzd {
    private boolean zzPs;
    private final Map<String, String> zzPt;
    private final zzad zzPu;
    private final zza zzPv;
    private ExceptionReporter zzPw;
    private zzal zzPx;
    private final Map<String, String> zzxA;

    private class zza extends zzd implements GoogleAnalytics.zza {
        private boolean zzPG;
        private int zzPH;
        private long zzPI;
        private boolean zzPJ;
        private long zzPK;

        protected zza(zzf zzfVar) {
            super(zzfVar);
            this.zzPI = -1L;
        }

        private void zziN() {
            if (this.zzPI >= 0 || this.zzPG) {
                zziC().zza(Tracker.this.zzPv);
            } else {
                zziC().zzb(Tracker.this.zzPv);
            }
        }

        public void enableAutoActivityTracking(boolean enabled) {
            this.zzPG = enabled;
            zziN();
        }

        public void setSessionTimeout(long sessionTimeout) {
            this.zzPI = sessionTimeout;
            zziN();
        }

        @Override // com.google.android.gms.analytics.internal.zzd
        protected void zziJ() {
        }

        public synchronized boolean zziM() {
            boolean z;
            z = this.zzPJ;
            this.zzPJ = false;
            return z;
        }

        boolean zziO() {
            return zzjl().elapsedRealtime() >= this.zzPK + Math.max(1000L, this.zzPI);
        }

        @Override // com.google.android.gms.analytics.GoogleAnalytics.zza
        public void zzl(Activity activity) {
            if (this.zzPH == 0 && zziO()) {
                this.zzPJ = true;
            }
            this.zzPH++;
            if (this.zzPG) {
                Intent intent = activity.getIntent();
                if (intent != null) {
                    Tracker.this.setCampaignParamsOnNextHit(intent.getData());
                }
                HashMap map = new HashMap();
                map.put("&t", "screenview");
                Tracker.this.set("&cd", Tracker.this.zzPx != null ? Tracker.this.zzPx.zzo(activity) : activity.getClass().getCanonicalName());
                if (TextUtils.isEmpty((CharSequence) map.get("&dr"))) {
                    String strZzn = Tracker.zzn(activity);
                    if (!TextUtils.isEmpty(strZzn)) {
                        map.put("&dr", strZzn);
                    }
                }
                Tracker.this.send(map);
            }
        }

        @Override // com.google.android.gms.analytics.GoogleAnalytics.zza
        public void zzm(Activity activity) {
            this.zzPH--;
            this.zzPH = Math.max(0, this.zzPH);
            if (this.zzPH == 0) {
                this.zzPK = zzjl().elapsedRealtime();
            }
        }
    }

    Tracker(zzf analytics, String trackingId, zzad rateLimiter) {
        super(analytics);
        this.zzxA = new HashMap();
        this.zzPt = new HashMap();
        if (trackingId != null) {
            this.zzxA.put("&tid", trackingId);
        }
        this.zzxA.put("useSecure", AppEventsConstants.EVENT_PARAM_VALUE_YES);
        this.zzxA.put("&a", Integer.toString(new Random().nextInt(Strategy.TTL_SECONDS_INFINITE) + 1));
        if (rateLimiter == null) {
            this.zzPu = new zzad("tracking", zzjl());
        } else {
            this.zzPu = rateLimiter;
        }
        this.zzPv = new zza(analytics);
    }

    private static boolean zza(Map.Entry<String, String> entry) {
        String key = entry.getKey();
        entry.getValue();
        return key.startsWith("&") && key.length() >= 2;
    }

    private static String zzb(Map.Entry<String, String> entry) {
        if (zza(entry)) {
            return entry.getKey().substring(1);
        }
        return null;
    }

    private static void zzb(Map<String, String> map, Map<String, String> map2) {
        zzx.zzz(map2);
        if (map == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String strZzb = zzb(entry);
            if (strZzb != null) {
                map2.put(strZzb, entry.getValue());
            }
        }
    }

    private static void zzc(Map<String, String> map, Map<String, String> map2) {
        zzx.zzz(map2);
        if (map == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String strZzb = zzb(entry);
            if (strZzb != null && !map2.containsKey(strZzb)) {
                map2.put(strZzb, entry.getValue());
            }
        }
    }

    private boolean zziK() {
        return this.zzPw != null;
    }

    static String zzn(Activity activity) {
        zzx.zzz(activity);
        Intent intent = activity.getIntent();
        if (intent == null) {
            return null;
        }
        String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
        if (TextUtils.isEmpty(stringExtra)) {
            return null;
        }
        return stringExtra;
    }

    public void enableAdvertisingIdCollection(boolean enabled) {
        this.zzPs = enabled;
    }

    public void enableAutoActivityTracking(boolean enabled) {
        this.zzPv.enableAutoActivityTracking(enabled);
    }

    public void enableExceptionReporting(boolean enable) {
        synchronized (this) {
            if (zziK() == enable) {
                return;
            }
            if (enable) {
                this.zzPw = new ExceptionReporter(this, Thread.getDefaultUncaughtExceptionHandler(), getContext());
                Thread.setDefaultUncaughtExceptionHandler(this.zzPw);
                zzbd("Uncaught exceptions will be reported to Google Analytics");
            } else {
                Thread.setDefaultUncaughtExceptionHandler(this.zzPw.zziD());
                zzbd("Uncaught exceptions will not be reported to Google Analytics");
            }
        }
    }

    public String get(String key) {
        zzjv();
        if (TextUtils.isEmpty(key)) {
            return null;
        }
        if (this.zzxA.containsKey(key)) {
            return this.zzxA.get(key);
        }
        if (key.equals("&ul")) {
            return zzam.zza(Locale.getDefault());
        }
        if (key.equals("&cid")) {
            return zzjr().zzkk();
        }
        if (key.equals("&sr")) {
            return zzju().zzla();
        }
        if (key.equals("&aid")) {
            return zzjt().zzjS().zzwK();
        }
        if (key.equals("&an")) {
            return zzjt().zzjS().zzlg();
        }
        if (key.equals("&av")) {
            return zzjt().zzjS().zzli();
        }
        if (key.equals("&aiid")) {
            return zzjt().zzjS().zzAJ();
        }
        return null;
    }

    public void send(Map<String, String> params) {
        final long jCurrentTimeMillis = zzjl().currentTimeMillis();
        if (zziC().getAppOptOut()) {
            zzbe("AppOptOut is set to true. Not sending Google Analytics hit");
            return;
        }
        final boolean zIsDryRunEnabled = zziC().isDryRunEnabled();
        final HashMap map = new HashMap();
        zzb(this.zzxA, map);
        zzb(params, map);
        final boolean zZzh = zzam.zzh(this.zzxA.get("useSecure"), true);
        zzc(this.zzPt, map);
        this.zzPt.clear();
        final String str = map.get("t");
        if (TextUtils.isEmpty(str)) {
            zzjm().zzh(map, "Missing hit type parameter");
            return;
        }
        final String str2 = map.get("tid");
        if (TextUtils.isEmpty(str2)) {
            zzjm().zzh(map, "Missing tracking id parameter");
            return;
        }
        final boolean zZziL = zziL();
        synchronized (this) {
            if ("screenview".equalsIgnoreCase(str) || "pageview".equalsIgnoreCase(str) || "appview".equalsIgnoreCase(str) || TextUtils.isEmpty(str)) {
                int i = Integer.parseInt(this.zzxA.get("&a")) + 1;
                if (i >= Integer.MAX_VALUE) {
                    i = 1;
                }
                this.zzxA.put("&a", Integer.toString(i));
            }
        }
        zzjo().zzf(new Runnable() { // from class: com.google.android.gms.analytics.Tracker.1
            @Override // java.lang.Runnable
            public void run() {
                if (Tracker.this.zzPv.zziM()) {
                    map.put("sc", "start");
                }
                zzam.zzd(map, "cid", Tracker.this.zziC().getClientId());
                String str3 = (String) map.get("sf");
                if (str3 != null) {
                    double dZza = zzam.zza(str3, 100.0d);
                    if (zzam.zza(dZza, (String) map.get("cid"))) {
                        Tracker.this.zzb("Sampling enabled. Hit sampled out. sample rate", Double.valueOf(dZza));
                        return;
                    }
                }
                com.google.android.gms.analytics.internal.zza zzaVarZzjs = Tracker.this.zzjs();
                if (zZziL) {
                    zzam.zzb(map, "ate", zzaVarZzjs.zziU());
                    zzam.zzc(map, "adid", zzaVarZzjs.zziY());
                } else {
                    map.remove("ate");
                    map.remove("adid");
                }
                zzpq zzpqVarZzjS = Tracker.this.zzjt().zzjS();
                zzam.zzc(map, "an", zzpqVarZzjS.zzlg());
                zzam.zzc(map, "av", zzpqVarZzjS.zzli());
                zzam.zzc(map, "aid", zzpqVarZzjS.zzwK());
                zzam.zzc(map, "aiid", zzpqVarZzjS.zzAJ());
                map.put("v", AppEventsConstants.EVENT_PARAM_VALUE_YES);
                map.put("_v", zze.zzQm);
                zzam.zzc(map, "ul", Tracker.this.zzju().zzkZ().getLanguage());
                zzam.zzc(map, "sr", Tracker.this.zzju().zzla());
                if (!(str.equals("transaction") || str.equals("item")) && !Tracker.this.zzPu.zzlw()) {
                    Tracker.this.zzjm().zzh(map, "Too many hits sent too quickly, rate limiting invoked");
                    return;
                }
                long jZzbt = zzam.zzbt((String) map.get("ht"));
                if (jZzbt == 0) {
                    jZzbt = jCurrentTimeMillis;
                }
                if (zIsDryRunEnabled) {
                    Tracker.this.zzjm().zzc("Dry run enabled. Would have sent hit", new zzab(Tracker.this, map, jZzbt, zZzh));
                    return;
                }
                String str4 = (String) map.get("cid");
                HashMap map2 = new HashMap();
                zzam.zza(map2, "uid", (Map<String, String>) map);
                zzam.zza(map2, "an", (Map<String, String>) map);
                zzam.zza(map2, "aid", (Map<String, String>) map);
                zzam.zza(map2, "av", (Map<String, String>) map);
                zzam.zza(map2, "aiid", (Map<String, String>) map);
                map.put("_s", String.valueOf(Tracker.this.zziH().zza(new zzh(0L, str4, str2, TextUtils.isEmpty((CharSequence) map.get("adid")) ? false : true, 0L, map2))));
                Tracker.this.zziH().zza(new zzab(Tracker.this, map, jZzbt, zZzh));
            }
        });
    }

    public void set(String key, String value) {
        zzx.zzb(key, "Key should be non-null");
        if (TextUtils.isEmpty(key)) {
            return;
        }
        this.zzxA.put(key, value);
    }

    public void setAnonymizeIp(boolean anonymize) {
        set("&aip", zzam.zzK(anonymize));
    }

    public void setAppId(String appId) {
        set("&aid", appId);
    }

    public void setAppInstallerId(String appInstallerId) {
        set("&aiid", appInstallerId);
    }

    public void setAppName(String appName) {
        set("&an", appName);
    }

    public void setAppVersion(String appVersion) {
        set("&av", appVersion);
    }

    public void setCampaignParamsOnNextHit(Uri uri) {
        if (uri == null || uri.isOpaque()) {
            return;
        }
        String queryParameter = uri.getQueryParameter(Constants.REFERRER);
        if (TextUtils.isEmpty(queryParameter)) {
            return;
        }
        Uri uri2 = Uri.parse("http://hostname/?" + queryParameter);
        String queryParameter2 = uri2.getQueryParameter("utm_id");
        if (queryParameter2 != null) {
            this.zzPt.put("&ci", queryParameter2);
        }
        String queryParameter3 = uri2.getQueryParameter("anid");
        if (queryParameter3 != null) {
            this.zzPt.put("&anid", queryParameter3);
        }
        String queryParameter4 = uri2.getQueryParameter("utm_campaign");
        if (queryParameter4 != null) {
            this.zzPt.put("&cn", queryParameter4);
        }
        String queryParameter5 = uri2.getQueryParameter("utm_content");
        if (queryParameter5 != null) {
            this.zzPt.put("&cc", queryParameter5);
        }
        String queryParameter6 = uri2.getQueryParameter("utm_medium");
        if (queryParameter6 != null) {
            this.zzPt.put("&cm", queryParameter6);
        }
        String queryParameter7 = uri2.getQueryParameter("utm_source");
        if (queryParameter7 != null) {
            this.zzPt.put("&cs", queryParameter7);
        }
        String queryParameter8 = uri2.getQueryParameter("utm_term");
        if (queryParameter8 != null) {
            this.zzPt.put("&ck", queryParameter8);
        }
        String queryParameter9 = uri2.getQueryParameter("dclid");
        if (queryParameter9 != null) {
            this.zzPt.put("&dclid", queryParameter9);
        }
        String queryParameter10 = uri2.getQueryParameter("gclid");
        if (queryParameter10 != null) {
            this.zzPt.put("&gclid", queryParameter10);
        }
        String queryParameter11 = uri2.getQueryParameter("aclid");
        if (queryParameter11 != null) {
            this.zzPt.put("&aclid", queryParameter11);
        }
    }

    public void setClientId(String clientId) {
        set("&cid", clientId);
    }

    public void setEncoding(String encoding) {
        set("&de", encoding);
    }

    public void setHostname(String hostname) {
        set("&dh", hostname);
    }

    public void setLanguage(String language) {
        set("&ul", language);
    }

    public void setLocation(String location) {
        set("&dl", location);
    }

    public void setPage(String page) {
        set("&dp", page);
    }

    public void setReferrer(String referrer) {
        set("&dr", referrer);
    }

    public void setSampleRate(double sampleRate) {
        set("&sf", Double.toString(sampleRate));
    }

    public void setScreenColors(String screenColors) {
        set("&sd", screenColors);
    }

    public void setScreenName(String screenName) {
        set("&cd", screenName);
    }

    public void setScreenResolution(int width, int height) {
        if (width >= 0 || height >= 0) {
            set("&sr", width + "x" + height);
        } else {
            zzbg("Invalid width or height. The values should be non-negative.");
        }
    }

    public void setSessionTimeout(long sessionTimeout) {
        this.zzPv.setSessionTimeout(1000 * sessionTimeout);
    }

    public void setTitle(String title) {
        set("&dt", title);
    }

    public void setUseSecure(boolean useSecure) {
        set("useSecure", zzam.zzK(useSecure));
    }

    public void setViewportSize(String viewportSize) {
        set("&vp", viewportSize);
    }

    void zza(zzal zzalVar) {
        zzbd("Loading Tracker config values");
        this.zzPx = zzalVar;
        if (this.zzPx.zzlT()) {
            String trackingId = this.zzPx.getTrackingId();
            set("&tid", trackingId);
            zza("trackingId loaded", trackingId);
        }
        if (this.zzPx.zzlU()) {
            String string = Double.toString(this.zzPx.zzlV());
            set("&sf", string);
            zza("Sample frequency loaded", string);
        }
        if (this.zzPx.zzlW()) {
            int sessionTimeout = this.zzPx.getSessionTimeout();
            setSessionTimeout(sessionTimeout);
            zza("Session timeout loaded", Integer.valueOf(sessionTimeout));
        }
        if (this.zzPx.zzlX()) {
            boolean zZzlY = this.zzPx.zzlY();
            enableAutoActivityTracking(zZzlY);
            zza("Auto activity tracking loaded", Boolean.valueOf(zZzlY));
        }
        if (this.zzPx.zzlZ()) {
            boolean zZzma = this.zzPx.zzma();
            if (zZzma) {
                set("&aip", AppEventsConstants.EVENT_PARAM_VALUE_YES);
            }
            zza("Anonymize ip loaded", Boolean.valueOf(zZzma));
        }
        enableExceptionReporting(this.zzPx.zzmb());
    }

    @Override // com.google.android.gms.analytics.internal.zzd
    protected void zziJ() {
        this.zzPv.zza();
        String strZzlg = zziI().zzlg();
        if (strZzlg != null) {
            set("&an", strZzlg);
        }
        String strZzli = zziI().zzli();
        if (strZzli != null) {
            set("&av", strZzli);
        }
    }

    boolean zziL() {
        return this.zzPs;
    }
}
