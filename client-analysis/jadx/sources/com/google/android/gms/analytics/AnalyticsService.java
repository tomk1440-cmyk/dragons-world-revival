package com.google.android.gms.analytics;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.RequiresPermission;
import com.google.android.gms.analytics.internal.zzaf;
import com.google.android.gms.analytics.internal.zzam;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.analytics.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzrp;

/* JADX INFO: loaded from: classes.dex */
public final class AnalyticsService extends Service {
    private static Boolean zzOO;
    private final Handler mHandler = new Handler();

    public static boolean zzZ(Context context) {
        zzx.zzz(context);
        if (zzOO != null) {
            return zzOO.booleanValue();
        }
        boolean zZza = zzam.zza(context, (Class<? extends Service>) AnalyticsService.class);
        zzOO = Boolean.valueOf(zZza);
        return zZza;
    }

    private void zziz() {
        try {
            synchronized (AnalyticsReceiver.zzqy) {
                try {
                    zzrp zzrpVar = AnalyticsReceiver.zzOM;
                    if (zzrpVar != null && zzrpVar.isHeld()) {
                        zzrpVar.release();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (SecurityException e) {
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public void onCreate() {
        super.onCreate();
        zzf zzfVarZzaa = zzf.zzaa(this);
        zzaf zzafVarZzjm = zzfVarZzaa.zzjm();
        if (zzfVarZzaa.zzjn().zzkr()) {
            zzafVarZzjm.zzbd("Device AnalyticsService is starting up");
        } else {
            zzafVarZzjm.zzbd("Local AnalyticsService is starting up");
        }
    }

    @Override // android.app.Service
    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public void onDestroy() {
        zzf zzfVarZzaa = zzf.zzaa(this);
        zzaf zzafVarZzjm = zzfVarZzaa.zzjm();
        if (zzfVarZzaa.zzjn().zzkr()) {
            zzafVarZzjm.zzbd("Device AnalyticsService is shutting down");
        } else {
            zzafVarZzjm.zzbd("Local AnalyticsService is shutting down");
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public int onStartCommand(Intent intent, int flags, final int startId) {
        zziz();
        final zzf zzfVarZzaa = zzf.zzaa(this);
        final zzaf zzafVarZzjm = zzfVarZzaa.zzjm();
        String action = intent.getAction();
        if (zzfVarZzaa.zzjn().zzkr()) {
            zzafVarZzjm.zza("Device AnalyticsService called. startId, action", Integer.valueOf(startId), action);
        } else {
            zzafVarZzjm.zza("Local AnalyticsService called. startId, action", Integer.valueOf(startId), action);
        }
        if ("com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(action)) {
            zzfVarZzaa.zziH().zza(new zzw() { // from class: com.google.android.gms.analytics.AnalyticsService.1
                @Override // com.google.android.gms.analytics.internal.zzw
                public void zzc(Throwable th) {
                    AnalyticsService.this.mHandler.post(new Runnable() { // from class: com.google.android.gms.analytics.AnalyticsService.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (AnalyticsService.this.stopSelfResult(startId)) {
                                if (zzfVarZzaa.zzjn().zzkr()) {
                                    zzafVarZzjm.zzbd("Device AnalyticsService processed last dispatch request");
                                } else {
                                    zzafVarZzjm.zzbd("Local AnalyticsService processed last dispatch request");
                                }
                            }
                        }
                    });
                }
            });
        }
        return 2;
    }
}
