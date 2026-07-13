package com.google.android.gms.analytics;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresPermission;
import android.util.Log;
import com.google.android.gms.analytics.internal.zzae;
import com.google.android.gms.analytics.internal.zzak;
import com.google.android.gms.analytics.internal.zzal;
import com.google.android.gms.analytics.internal.zzan;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.analytics.internal.zzy;
import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class GoogleAnalytics extends com.google.android.gms.analytics.zza {
    private static List<Runnable> zzPe = new ArrayList();
    private boolean zzPf;
    private Set<zza> zzPg;
    private boolean zzPh;
    private boolean zzPi;
    private volatile boolean zzPj;
    private boolean zzPk;
    private boolean zzqA;

    interface zza {
        void zzl(Activity activity);

        void zzm(Activity activity);
    }

    @TargetApi(14)
    class zzb implements Application.ActivityLifecycleCallbacks {
        zzb() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            GoogleAnalytics.this.zzj(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            GoogleAnalytics.this.zzk(activity);
        }
    }

    public GoogleAnalytics(zzf context) {
        super(context);
        this.zzPg = new HashSet();
    }

    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public static GoogleAnalytics getInstance(Context context) {
        return zzf.zzaa(context).zzjz();
    }

    public static void zziF() {
        synchronized (GoogleAnalytics.class) {
            if (zzPe != null) {
                Iterator<Runnable> it = zzPe.iterator();
                while (it.hasNext()) {
                    it.next().run();
                }
                zzPe = null;
            }
        }
    }

    private com.google.android.gms.analytics.internal.zzb zziH() {
        return zzix().zziH();
    }

    private zzan zziI() {
        return zzix().zziI();
    }

    public void dispatchLocalHits() {
        zziH().zzjd();
    }

    @TargetApi(14)
    public void enableAutoActivityReports(Application application) {
        if (Build.VERSION.SDK_INT < 14 || this.zzPh) {
            return;
        }
        application.registerActivityLifecycleCallbacks(new zzb());
        this.zzPh = true;
    }

    public boolean getAppOptOut() {
        return this.zzPj;
    }

    public String getClientId() {
        zzx.zzcE("getClientId can not be called from the main thread");
        return zzix().zzjC().zzkk();
    }

    @Deprecated
    public Logger getLogger() {
        return zzae.getLogger();
    }

    public boolean isDryRunEnabled() {
        return this.zzPi;
    }

    public boolean isInitialized() {
        return this.zzqA && !this.zzPf;
    }

    public Tracker newTracker(int configResId) {
        Tracker tracker;
        zzal zzalVarZzah;
        synchronized (this) {
            tracker = new Tracker(zzix(), null, null);
            if (configResId > 0 && (zzalVarZzah = new zzak(zzix()).zzah(configResId)) != null) {
                tracker.zza(zzalVarZzah);
            }
            tracker.zza();
        }
        return tracker;
    }

    public Tracker newTracker(String trackingId) {
        Tracker tracker;
        synchronized (this) {
            tracker = new Tracker(zzix(), trackingId, null);
            tracker.zza();
        }
        return tracker;
    }

    public void reportActivityStart(Activity activity) {
        if (this.zzPh) {
            return;
        }
        zzj(activity);
    }

    public void reportActivityStop(Activity activity) {
        if (this.zzPh) {
            return;
        }
        zzk(activity);
    }

    public void setAppOptOut(boolean optOut) {
        this.zzPj = optOut;
        if (this.zzPj) {
            zziH().zzjc();
        }
    }

    public void setDryRun(boolean dryRun) {
        this.zzPi = dryRun;
    }

    public void setLocalDispatchPeriod(int dispatchPeriodInSeconds) {
        zziH().setLocalDispatchPeriod(dispatchPeriodInSeconds);
    }

    @Deprecated
    public void setLogger(Logger logger) {
        zzae.setLogger(logger);
        if (this.zzPk) {
            return;
        }
        Log.i(zzy.zzRL.get(), "GoogleAnalytics.setLogger() is deprecated. To enable debug logging, please run:\nadb shell setprop log.tag." + zzy.zzRL.get() + " DEBUG");
        this.zzPk = true;
    }

    public void zza() {
        zziE();
        this.zzqA = true;
    }

    void zza(zza zzaVar) {
        this.zzPg.add(zzaVar);
        Context context = zzix().getContext();
        if (context instanceof Application) {
            enableAutoActivityReports((Application) context);
        }
    }

    void zzb(zza zzaVar) {
        this.zzPg.remove(zzaVar);
    }

    void zziE() {
        Logger logger;
        zzan zzanVarZziI = zziI();
        if (zzanVarZziI.zzlj()) {
            getLogger().setLogLevel(zzanVarZziI.getLogLevel());
        }
        if (zzanVarZziI.zzln()) {
            setDryRun(zzanVarZziI.zzlo());
        }
        if (!zzanVarZziI.zzlj() || (logger = zzae.getLogger()) == null) {
            return;
        }
        logger.setLogLevel(zzanVarZziI.getLogLevel());
    }

    void zziG() {
        zziH().zzje();
    }

    void zzj(Activity activity) {
        Iterator<zza> it = this.zzPg.iterator();
        while (it.hasNext()) {
            it.next().zzl(activity);
        }
    }

    void zzk(Activity activity) {
        Iterator<zza> it = this.zzPg.iterator();
        while (it.hasNext()) {
            it.next().zzm(activity);
        }
    }
}
