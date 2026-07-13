package com.google.android.gms.measurement;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.MainThread;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzrp;
import com.google.android.gms.measurement.internal.zzaj;
import com.google.android.gms.measurement.internal.zzp;
import com.google.android.gms.measurement.internal.zzw;

/* JADX INFO: loaded from: classes.dex */
public final class AppMeasurementService extends Service {
    private static Boolean zzOO;
    private final Handler mHandler = new Handler();

    private zzp zzAo() {
        return zzw.zzaT(this).zzAo();
    }

    public static boolean zzZ(Context context) {
        zzx.zzz(context);
        if (zzOO != null) {
            return zzOO.booleanValue();
        }
        boolean zZza = zzaj.zza(context, (Class<? extends Service>) AppMeasurementService.class);
        zzOO = Boolean.valueOf(zZza);
        return zZza;
    }

    private void zziz() {
        try {
            synchronized (AppMeasurementReceiver.zzqy) {
                try {
                    zzrp zzrpVar = AppMeasurementReceiver.zzOM;
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
    @MainThread
    public IBinder onBind(Intent intent) {
        if (intent == null) {
            zzAo().zzCE().zzfg("onBind called with null intent");
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new com.google.android.gms.measurement.internal.zzx(zzw.zzaT(this));
        }
        zzAo().zzCF().zzj("onBind received unknown action", action);
        return null;
    }

    @Override // android.app.Service
    @MainThread
    public void onCreate() {
        super.onCreate();
        zzw zzwVarZzaT = zzw.zzaT(this);
        zzp zzpVarZzAo = zzwVarZzaT.zzAo();
        if (zzwVarZzaT.zzCp().zzkr()) {
            zzpVarZzAo.zzCK().zzfg("Device AppMeasurementService is starting up");
        } else {
            zzpVarZzAo.zzCK().zzfg("Local AppMeasurementService is starting up");
        }
    }

    @Override // android.app.Service
    @MainThread
    public void onDestroy() {
        zzw zzwVarZzaT = zzw.zzaT(this);
        zzp zzpVarZzAo = zzwVarZzaT.zzAo();
        if (zzwVarZzaT.zzCp().zzkr()) {
            zzpVarZzAo.zzCK().zzfg("Device AppMeasurementService is shutting down");
        } else {
            zzpVarZzAo.zzCK().zzfg("Local AppMeasurementService is shutting down");
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    @MainThread
    public void onRebind(Intent intent) {
        if (intent == null) {
            zzAo().zzCE().zzfg("onRebind called with null intent");
        } else {
            zzAo().zzCK().zzj("onRebind called. action", intent.getAction());
        }
    }

    @Override // android.app.Service
    @MainThread
    public int onStartCommand(Intent intent, int flags, final int startId) {
        zziz();
        final zzw zzwVarZzaT = zzw.zzaT(this);
        final zzp zzpVarZzAo = zzwVarZzaT.zzAo();
        String action = intent.getAction();
        if (zzwVarZzaT.zzCp().zzkr()) {
            zzpVarZzAo.zzCK().zze("Device AppMeasurementService called. startId, action", Integer.valueOf(startId), action);
        } else {
            zzpVarZzAo.zzCK().zze("Local AppMeasurementService called. startId, action", Integer.valueOf(startId), action);
        }
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            zzwVarZzaT.zzCn().zzg(new Runnable() { // from class: com.google.android.gms.measurement.AppMeasurementService.1
                @Override // java.lang.Runnable
                public void run() {
                    zzwVarZzaT.zzDc();
                    AppMeasurementService.this.mHandler.post(new Runnable() { // from class: com.google.android.gms.measurement.AppMeasurementService.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (AppMeasurementService.this.stopSelfResult(startId)) {
                                if (zzwVarZzaT.zzCp().zzkr()) {
                                    zzpVarZzAo.zzCK().zzfg("Device AppMeasurementService processed last upload request");
                                } else {
                                    zzpVarZzAo.zzCK().zzfg("Local AppMeasurementService processed last upload request");
                                }
                            }
                        }
                    });
                }
            });
        }
        return 2;
    }

    @Override // android.app.Service
    @MainThread
    public boolean onUnbind(Intent intent) {
        if (intent == null) {
            zzAo().zzCE().zzfg("onUnbind called with null intent");
        } else {
            zzAo().zzCK().zzj("onUnbind called for intent. action", intent.getAction());
        }
        return true;
    }
}
