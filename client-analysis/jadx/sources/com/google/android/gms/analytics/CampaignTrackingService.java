package com.google.android.gms.analytics;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.RequiresPermission;
import android.text.TextUtils;
import com.adjust.sdk.Constants;
import com.google.android.gms.analytics.internal.zzaf;
import com.google.android.gms.analytics.internal.zzam;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzrp;

/* JADX INFO: loaded from: classes.dex */
public class CampaignTrackingService extends Service {
    private static Boolean zzOO;
    private Handler mHandler;

    private Handler getHandler() {
        Handler handler = this.mHandler;
        if (handler != null) {
            return handler;
        }
        Handler handler2 = new Handler(getMainLooper());
        this.mHandler = handler2;
        return handler2;
    }

    public static boolean zzZ(Context context) {
        zzx.zzz(context);
        if (zzOO != null) {
            return zzOO.booleanValue();
        }
        boolean zZza = zzam.zza(context, (Class<? extends Service>) CampaignTrackingService.class);
        zzOO = Boolean.valueOf(zZza);
        return zZza;
    }

    private void zziz() {
        try {
            synchronized (CampaignTrackingReceiver.zzqy) {
                try {
                    zzrp zzrpVar = CampaignTrackingReceiver.zzOM;
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
        zzf.zzaa(this).zzjm().zzbd("CampaignTrackingService is starting up");
    }

    @Override // android.app.Service
    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public void onDestroy() {
        zzf.zzaa(this).zzjm().zzbd("CampaignTrackingService is shutting down");
        super.onDestroy();
    }

    @Override // android.app.Service
    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public int onStartCommand(Intent intent, int flags, final int startId) {
        zziz();
        zzf zzfVarZzaa = zzf.zzaa(this);
        final zzaf zzafVarZzjm = zzfVarZzaa.zzjm();
        String stringExtra = null;
        if (zzfVarZzaa.zzjn().zzkr()) {
            zzafVarZzjm.zzbh("Unexpected installation campaign (package side)");
        } else {
            stringExtra = intent.getStringExtra(Constants.REFERRER);
        }
        final Handler handler = getHandler();
        if (TextUtils.isEmpty(stringExtra)) {
            if (!zzfVarZzaa.zzjn().zzkr()) {
                zzafVarZzjm.zzbg("No campaign found on com.android.vending.INSTALL_REFERRER \"referrer\" extra");
            }
            zzfVarZzaa.zzjo().zzf(new Runnable() { // from class: com.google.android.gms.analytics.CampaignTrackingService.1
                @Override // java.lang.Runnable
                public void run() {
                    CampaignTrackingService.this.zza(zzafVarZzjm, handler, startId);
                }
            });
        } else {
            int iZzkv = zzfVarZzaa.zzjn().zzkv();
            if (stringExtra.length() > iZzkv) {
                zzafVarZzjm.zzc("Campaign data exceed the maximum supported size and will be clipped. size, limit", Integer.valueOf(stringExtra.length()), Integer.valueOf(iZzkv));
                stringExtra = stringExtra.substring(0, iZzkv);
            }
            zzafVarZzjm.zza("CampaignTrackingService called. startId, campaign", Integer.valueOf(startId), stringExtra);
            zzfVarZzaa.zziH().zza(stringExtra, new Runnable() { // from class: com.google.android.gms.analytics.CampaignTrackingService.2
                @Override // java.lang.Runnable
                public void run() {
                    CampaignTrackingService.this.zza(zzafVarZzjm, handler, startId);
                }
            });
        }
        return 2;
    }

    protected void zza(final zzaf zzafVar, Handler handler, final int i) {
        handler.post(new Runnable() { // from class: com.google.android.gms.analytics.CampaignTrackingService.3
            @Override // java.lang.Runnable
            public void run() {
                boolean zStopSelfResult = CampaignTrackingService.this.stopSelfResult(i);
                if (zStopSelfResult) {
                    zzafVar.zza("Install campaign broadcast processed", Boolean.valueOf(zStopSelfResult));
                }
            }
        });
    }
}
