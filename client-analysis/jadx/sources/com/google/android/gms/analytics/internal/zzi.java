package com.google.android.gms.analytics.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
public class zzi extends zzd {
    private final zza zzQH;
    private zzac zzQI;
    private final zzt zzQJ;
    private zzaj zzQK;

    protected class zza implements ServiceConnection {
        private volatile zzac zzQM;
        private volatile boolean zzQN;

        protected zza() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName name, IBinder binder) {
            com.google.android.gms.common.internal.zzx.zzcD("AnalyticsServiceConnection.onServiceConnected");
            synchronized (this) {
                try {
                    if (binder == null) {
                        zzi.this.zzbh("Service connected with null binder");
                        notifyAll();
                        return;
                    }
                    final zzac zzacVarZzaf = null;
                    try {
                        String interfaceDescriptor = binder.getInterfaceDescriptor();
                        if ("com.google.android.gms.analytics.internal.IAnalyticsService".equals(interfaceDescriptor)) {
                            zzacVarZzaf = zzac.zza.zzaf(binder);
                            zzi.this.zzbd("Bound to IAnalyticsService interface");
                        } else {
                            zzi.this.zze("Got binder with a wrong descriptor", interfaceDescriptor);
                        }
                    } catch (RemoteException e) {
                        zzi.this.zzbh("Service connect failed to get IAnalyticsService");
                    }
                    if (zzacVarZzaf == null) {
                        try {
                            com.google.android.gms.common.stats.zzb.zzrP().zza(zzi.this.getContext(), zzi.this.zzQH);
                        } catch (IllegalArgumentException e2) {
                        }
                    } else if (this.zzQN) {
                        this.zzQM = zzacVarZzaf;
                    } else {
                        zzi.this.zzbg("onServiceConnected received after the timeout limit");
                        zzi.this.zzjo().zzf(new Runnable() { // from class: com.google.android.gms.analytics.internal.zzi.zza.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (zzi.this.isConnected()) {
                                    return;
                                }
                                zzi.this.zzbe("Connected to service after a timeout");
                                zzi.this.zza(zzacVarZzaf);
                            }
                        });
                    }
                    notifyAll();
                } catch (Throwable th) {
                    notifyAll();
                    throw th;
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(final ComponentName name) {
            com.google.android.gms.common.internal.zzx.zzcD("AnalyticsServiceConnection.onServiceDisconnected");
            zzi.this.zzjo().zzf(new Runnable() { // from class: com.google.android.gms.analytics.internal.zzi.zza.2
                @Override // java.lang.Runnable
                public void run() {
                    zzi.this.onServiceDisconnected(name);
                }
            });
        }

        public zzac zzjK() {
            zzac zzacVar = null;
            zzi.this.zzjk();
            Intent intent = new Intent("com.google.android.gms.analytics.service.START");
            intent.setComponent(new ComponentName("com.google.android.gms", "com.google.android.gms.analytics.service.AnalyticsService"));
            Context context = zzi.this.getContext();
            intent.putExtra("app_package_name", context.getPackageName());
            com.google.android.gms.common.stats.zzb zzbVarZzrP = com.google.android.gms.common.stats.zzb.zzrP();
            synchronized (this) {
                this.zzQM = null;
                this.zzQN = true;
                boolean zZza = zzbVarZzrP.zza(context, intent, zzi.this.zzQH, 129);
                zzi.this.zza("Bind to service requested", Boolean.valueOf(zZza));
                if (zZza) {
                    try {
                        wait(zzi.this.zzjn().zzkN());
                    } catch (InterruptedException e) {
                        zzi.this.zzbg("Wait for service connect was interrupted");
                    }
                    this.zzQN = false;
                    zzacVar = this.zzQM;
                    this.zzQM = null;
                    if (zzacVar == null) {
                        zzi.this.zzbh("Successfully bound to service but never got onServiceConnected callback");
                    }
                } else {
                    this.zzQN = false;
                }
            }
            return zzacVar;
        }
    }

    protected zzi(zzf zzfVar) {
        super(zzfVar);
        this.zzQK = new zzaj(zzfVar.zzjl());
        this.zzQH = new zza();
        this.zzQJ = new zzt(zzfVar) { // from class: com.google.android.gms.analytics.internal.zzi.1
            @Override // com.google.android.gms.analytics.internal.zzt
            public void run() {
                zzi.this.zzjJ();
            }
        };
    }

    private void onDisconnect() {
        zziH().zzjf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onServiceDisconnected(ComponentName name) {
        zzjk();
        if (this.zzQI != null) {
            this.zzQI = null;
            zza("Disconnected from device AnalyticsService", name);
            onDisconnect();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zza(zzac zzacVar) {
        zzjk();
        this.zzQI = zzacVar;
        zzjI();
        zziH().onServiceConnected();
    }

    private void zzjI() {
        this.zzQK.start();
        this.zzQJ.zzt(zzjn().zzkM());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzjJ() {
        zzjk();
        if (isConnected()) {
            zzbd("Inactivity, disconnecting from device AnalyticsService");
            disconnect();
        }
    }

    public boolean connect() {
        zzjk();
        zzjv();
        if (this.zzQI != null) {
            return true;
        }
        zzac zzacVarZzjK = this.zzQH.zzjK();
        if (zzacVarZzjK == null) {
            return false;
        }
        this.zzQI = zzacVarZzjK;
        zzjI();
        return true;
    }

    public void disconnect() {
        zzjk();
        zzjv();
        try {
            com.google.android.gms.common.stats.zzb.zzrP().zza(getContext(), this.zzQH);
        } catch (IllegalArgumentException e) {
        } catch (IllegalStateException e2) {
        }
        if (this.zzQI != null) {
            this.zzQI = null;
            onDisconnect();
        }
    }

    public boolean isConnected() {
        zzjk();
        zzjv();
        return this.zzQI != null;
    }

    public boolean zzb(zzab zzabVar) {
        com.google.android.gms.common.internal.zzx.zzz(zzabVar);
        zzjk();
        zzjv();
        zzac zzacVar = this.zzQI;
        if (zzacVar == null) {
            return false;
        }
        try {
            zzacVar.zza(zzabVar.zzn(), zzabVar.zzlr(), zzabVar.zzlt() ? zzjn().zzkF() : zzjn().zzkG(), Collections.emptyList());
            zzjI();
            return true;
        } catch (RemoteException e) {
            zzbd("Failed to send hits to AnalyticsService");
            return false;
        }
    }

    @Override // com.google.android.gms.analytics.internal.zzd
    protected void zziJ() {
    }

    public boolean zzjH() {
        zzjk();
        zzjv();
        zzac zzacVar = this.zzQI;
        if (zzacVar == null) {
            return false;
        }
        try {
            zzacVar.zzjc();
            zzjI();
            return true;
        } catch (RemoteException e) {
            zzbd("Failed to clear hits from AnalyticsService");
            return false;
        }
    }
}
