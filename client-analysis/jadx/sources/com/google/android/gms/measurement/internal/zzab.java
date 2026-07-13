package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.MainThread;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import com.adjust.sdk.Constants;
import com.google.android.gms.internal.zzmq;
import com.google.android.gms.measurement.AppMeasurement;

/* JADX INFO: loaded from: classes.dex */
public class zzab extends zzz {
    private zza zzaYD;
    private AppMeasurement.zza zzaYE;
    private boolean zzaYF;

    @TargetApi(14)
    @MainThread
    private class zza implements Application.ActivityLifecycleCallbacks {
        private zza() {
        }

        private boolean zzfo(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            zzab.this.zza("auto", "_ldl", str);
            return true;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
            Uri data;
            try {
                zzab.this.zzAo().zzCK().zzfg("onActivityCreated");
                Intent intent = activity.getIntent();
                if (intent != null && (data = intent.getData()) != null && data.isHierarchical()) {
                    String queryParameter = data.getQueryParameter(Constants.REFERRER);
                    if (!TextUtils.isEmpty(queryParameter)) {
                        if (queryParameter.contains("gclid")) {
                            zzab.this.zzAo().zzCJ().zzj("Activity created with referrer", queryParameter);
                            zzfo(queryParameter);
                        } else {
                            zzab.this.zzAo().zzCJ().zzfg("Activity created with data 'referrer' param without gclid");
                        }
                    }
                }
            } catch (Throwable th) {
                zzab.this.zzAo().zzCE().zzj("Throwable caught in onActivityCreated", th);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        @MainThread
        public void onActivityPaused(Activity activity) {
            zzab.this.zzCm().zzDw();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        @MainThread
        public void onActivityResumed(Activity activity) {
            zzab.this.zzCm().zzDu();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    }

    protected zzab(zzw zzwVar) {
        super(zzwVar);
    }

    @WorkerThread
    private void zzDm() {
        try {
            zzh(Class.forName(zzDn()));
        } catch (ClassNotFoundException e) {
            zzAo().zzCI().zzfg("Tag Manager is not found and thus will not be used");
        }
    }

    private String zzDn() {
        return "com.google.android.gms.tagmanager.TagManagerService";
    }

    private void zza(String str, String str2, Bundle bundle, boolean z, String str3) {
        zza(str, str2, bundle, z, str3, zzjl().currentTimeMillis());
    }

    private void zza(String str, String str2, Bundle bundle, boolean z, String str3, long j) {
        com.google.android.gms.common.internal.zzx.zzcM(str);
        zzCk().zzfr(str2);
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            int iZzBA = zzCp().zzBA();
            int i = 0;
            for (String str4 : bundle.keySet()) {
                zzCk().zzft(str4);
                if (zzaj.zzfq(str4)) {
                    int i2 = i + 1;
                    com.google.android.gms.common.internal.zzx.zzb(i2 <= iZzBA, "Event can't contain more then " + iZzBA + " params");
                    i = i2;
                }
                Object objZzk = zzCk().zzk(str4, bundle.get(str4));
                if (objZzk != null) {
                    zzCk().zza(bundle2, str4, objZzk);
                }
            }
        }
        int iZzBD = zzCp().zzBD();
        bundle2.putString("_o", str.length() <= iZzBD ? str : str.substring(0, iZzBD));
        zza(str, str2, j, bundle2, z, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void zza(String str, String str2, Object obj, long j) {
        com.google.android.gms.common.internal.zzx.zzcM(str);
        com.google.android.gms.common.internal.zzx.zzcM(str2);
        zzjk();
        zzjj();
        zzjv();
        if (!zzCo().zzAr()) {
            zzAo().zzCJ().zzfg("User property not set since app measurement is disabled");
        } else if (this.zzaTV.zzCS()) {
            zzAo().zzCJ().zze("Setting user property (FE)", str2, obj);
            zzCi().zza(new UserAttributeParcel(str2, j, obj, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void zzas(boolean z) {
        zzjk();
        zzjj();
        zzjv();
        zzAo().zzCJ().zzj("Setting app measurement enabled (FE)", Boolean.valueOf(z));
        zzCo().setMeasurementEnabled(z);
        zzCi().zzDo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void zzb(String str, String str2, long j, Bundle bundle, boolean z, String str3) {
        com.google.android.gms.common.internal.zzx.zzcM(str);
        com.google.android.gms.common.internal.zzx.zzcM(str2);
        com.google.android.gms.common.internal.zzx.zzz(bundle);
        zzjk();
        zzjv();
        if (!zzCo().zzAr()) {
            zzAo().zzCJ().zzfg("Event not sent since app measurement is disabled");
            return;
        }
        if (!this.zzaYF) {
            this.zzaYF = true;
            zzDm();
        }
        if (z && this.zzaYE != null && !zzaj.zzfv(str2)) {
            zzAo().zzCJ().zze("Passing event to registered event handler (FE)", str2, bundle);
            this.zzaYE.zza(str, str2, bundle, j);
        } else if (this.zzaTV.zzCS()) {
            zzAo().zzCJ().zze("Logging event (FE)", str2, bundle);
            zzCi().zzb(new EventParcel(str2, new EventParams(bundle), str, j), str3);
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public void setMeasurementEnabled(final boolean enabled) {
        zzjv();
        zzjj();
        zzCn().zzg(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzab.1
            @Override // java.lang.Runnable
            public void run() {
                zzab.this.zzas(enabled);
            }
        });
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzp zzAo() {
        return super.zzAo();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ void zzCd() {
        super.zzCd();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzc zzCe() {
        return super.zzCe();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzab zzCf() {
        return super.zzCf();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzn zzCg() {
        return super.zzCg();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzg zzCh() {
        return super.zzCh();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzac zzCi() {
        return super.zzCi();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zze zzCj() {
        return super.zzCj();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzaj zzCk() {
        return super.zzCk();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzu zzCl() {
        return super.zzCl();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzad zzCm() {
        return super.zzCm();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzv zzCn() {
        return super.zzCn();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzt zzCo() {
        return super.zzCo();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzd zzCp() {
        return super.zzCp();
    }

    @TargetApi(14)
    public void zzDk() {
        if (getContext().getApplicationContext() instanceof Application) {
            Application application = (Application) getContext().getApplicationContext();
            if (this.zzaYD == null) {
                this.zzaYD = new zza();
            }
            application.unregisterActivityLifecycleCallbacks(this.zzaYD);
            application.registerActivityLifecycleCallbacks(this.zzaYD);
            zzAo().zzCK().zzfg("Registered activity lifecycle callback");
        }
    }

    @WorkerThread
    public void zzDl() {
        zzjk();
        zzjj();
        zzjv();
        if (this.zzaTV.zzCS()) {
            zzCi().zzDl();
            String strZzCQ = zzCo().zzCQ();
            if (TextUtils.isEmpty(strZzCQ) || strZzCQ.equals(zzCh().zzCy())) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("_po", strZzCQ);
            zze("auto", "_ou", bundle);
        }
    }

    protected void zza(final String str, final String str2, final long j, final Bundle bundle, final boolean z, final String str3) {
        com.google.android.gms.common.internal.zzx.zzz(bundle);
        zzCn().zzg(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzab.2
            @Override // java.lang.Runnable
            public void run() {
                zzab.this.zzb(str, str2, j, bundle, z, str3);
            }
        });
    }

    void zza(final String str, final String str2, final long j, final Object obj) {
        zzCn().zzg(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzab.3
            @Override // java.lang.Runnable
            public void run() {
                zzab.this.zza(str, str2, obj, j);
            }
        });
    }

    public void zza(String str, String str2, Object obj) {
        com.google.android.gms.common.internal.zzx.zzcM(str);
        long jCurrentTimeMillis = zzjl().currentTimeMillis();
        zzCk().zzfs(str2);
        if (obj == null) {
            zza(str, str2, jCurrentTimeMillis, (Object) null);
            return;
        }
        zzCk().zzl(str2, obj);
        Object objZzm = zzCk().zzm(str2, obj);
        if (objZzm != null) {
            zza(str, str2, jCurrentTimeMillis, objZzm);
        }
    }

    public void zze(String str, String str2, Bundle bundle) {
        zzjj();
        zza(str, str2, bundle, true, (String) null);
    }

    @WorkerThread
    public void zzh(Class<?> cls) {
        try {
            cls.getDeclaredMethod("initialize", Context.class).invoke(null, getContext());
        } catch (Exception e) {
            zzAo().zzCF().zzj("Failed to invoke Tag Manager's initialize() method", e);
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzz
    protected void zziJ() {
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ void zzjj() {
        super.zzjj();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ void zzjk() {
        super.zzjk();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzmq zzjl() {
        return super.zzjl();
    }
}
