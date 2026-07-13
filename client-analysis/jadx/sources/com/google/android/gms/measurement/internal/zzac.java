package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.zzmq;
import com.google.android.gms.measurement.AppMeasurementService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class zzac extends zzz {
    private final zza zzaYN;
    private zzm zzaYO;
    private Boolean zzaYP;
    private final zzf zzaYQ;
    private final zzaf zzaYR;
    private final List<Runnable> zzaYS;
    private final zzf zzaYT;

    protected class zza implements ServiceConnection, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
        private volatile boolean zzaYV;
        private volatile zzo zzaYW;

        protected zza() {
        }

        @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
        @MainThread
        public void onConnected(@Nullable Bundle connectionHint) {
            com.google.android.gms.common.internal.zzx.zzcD("MeasurementServiceConnection.onConnected");
            synchronized (this) {
                try {
                    final zzm zzmVarZzqJ = this.zzaYW.zzqJ();
                    this.zzaYW = null;
                    zzac.this.zzCn().zzg(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzac.zza.3
                        @Override // java.lang.Runnable
                        public void run() {
                            synchronized (zza.this) {
                                zza.this.zzaYV = false;
                                if (!zzac.this.isConnected()) {
                                    zzac.this.zzAo().zzCJ().zzfg("Connected to remote service");
                                    zzac.this.zza(zzmVarZzqJ);
                                }
                            }
                        }
                    });
                } catch (DeadObjectException | IllegalStateException e) {
                    this.zzaYW = null;
                    this.zzaYV = false;
                }
            }
        }

        @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
        @MainThread
        public void onConnectionFailed(@NonNull ConnectionResult result) {
            com.google.android.gms.common.internal.zzx.zzcD("MeasurementServiceConnection.onConnectionFailed");
            zzp zzpVarZzCT = zzac.this.zzaTV.zzCT();
            if (zzpVarZzCT != null) {
                zzpVarZzCT.zzCF().zzj("Service connection failed", result);
            }
            synchronized (this) {
                this.zzaYV = false;
                this.zzaYW = null;
            }
        }

        @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
        @MainThread
        public void onConnectionSuspended(int cause) {
            com.google.android.gms.common.internal.zzx.zzcD("MeasurementServiceConnection.onConnectionSuspended");
            zzac.this.zzAo().zzCJ().zzfg("Service connection suspended");
            zzac.this.zzCn().zzg(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzac.zza.4
                @Override // java.lang.Runnable
                public void run() {
                    zzac.this.onServiceDisconnected(new ComponentName(zzac.this.getContext(), (Class<?>) AppMeasurementService.class));
                }
            });
        }

        @Override // android.content.ServiceConnection
        @MainThread
        public void onServiceConnected(ComponentName name, IBinder binder) {
            com.google.android.gms.common.internal.zzx.zzcD("MeasurementServiceConnection.onServiceConnected");
            synchronized (this) {
                if (binder == null) {
                    this.zzaYV = false;
                    zzac.this.zzAo().zzCE().zzfg("Service connected with null binder");
                    return;
                }
                final zzm zzmVarZzdn = null;
                try {
                    String interfaceDescriptor = binder.getInterfaceDescriptor();
                    if ("com.google.android.gms.measurement.internal.IMeasurementService".equals(interfaceDescriptor)) {
                        zzmVarZzdn = zzm.zza.zzdn(binder);
                        zzac.this.zzAo().zzCK().zzfg("Bound to IMeasurementService interface");
                    } else {
                        zzac.this.zzAo().zzCE().zzj("Got binder with a wrong descriptor", interfaceDescriptor);
                    }
                } catch (RemoteException e) {
                    zzac.this.zzAo().zzCE().zzfg("Service connect failed to get IMeasurementService");
                }
                if (zzmVarZzdn == null) {
                    this.zzaYV = false;
                    try {
                        com.google.android.gms.common.stats.zzb.zzrP().zza(zzac.this.getContext(), zzac.this.zzaYN);
                    } catch (IllegalArgumentException e2) {
                    }
                } else {
                    zzac.this.zzCn().zzg(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzac.zza.1
                        @Override // java.lang.Runnable
                        public void run() {
                            synchronized (zza.this) {
                                zza.this.zzaYV = false;
                                if (!zzac.this.isConnected()) {
                                    zzac.this.zzAo().zzCK().zzfg("Connected to service");
                                    zzac.this.zza(zzmVarZzdn);
                                }
                            }
                        }
                    });
                }
            }
        }

        @Override // android.content.ServiceConnection
        @MainThread
        public void onServiceDisconnected(final ComponentName name) {
            com.google.android.gms.common.internal.zzx.zzcD("MeasurementServiceConnection.onServiceDisconnected");
            zzac.this.zzAo().zzCJ().zzfg("Service disconnected");
            zzac.this.zzCn().zzg(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzac.zza.2
                @Override // java.lang.Runnable
                public void run() {
                    zzac.this.onServiceDisconnected(name);
                }
            });
        }

        @WorkerThread
        public void zzDt() {
            zzac.this.zzjk();
            Context context = zzac.this.getContext();
            synchronized (this) {
                if (this.zzaYV) {
                    zzac.this.zzAo().zzCK().zzfg("Connection attempt already in progress");
                    return;
                }
                if (this.zzaYW != null) {
                    zzac.this.zzAo().zzCK().zzfg("Already awaiting connection attempt");
                    return;
                }
                this.zzaYW = new zzo(context, Looper.getMainLooper(), com.google.android.gms.common.internal.zzf.zzat(context), this, this);
                zzac.this.zzAo().zzCK().zzfg("Connecting to remote service");
                this.zzaYV = true;
                this.zzaYW.zzqG();
            }
        }

        @WorkerThread
        public void zzz(Intent intent) {
            zzac.this.zzjk();
            Context context = zzac.this.getContext();
            com.google.android.gms.common.stats.zzb zzbVarZzrP = com.google.android.gms.common.stats.zzb.zzrP();
            synchronized (this) {
                if (this.zzaYV) {
                    zzac.this.zzAo().zzCK().zzfg("Connection attempt already in progress");
                } else {
                    this.zzaYV = true;
                    zzbVarZzrP.zza(context, intent, zzac.this.zzaYN, 129);
                }
            }
        }
    }

    protected zzac(zzw zzwVar) {
        super(zzwVar);
        this.zzaYS = new ArrayList();
        this.zzaYR = new zzaf(zzwVar.zzjl());
        this.zzaYN = new zza();
        this.zzaYQ = new zzf(zzwVar) { // from class: com.google.android.gms.measurement.internal.zzac.1
            @Override // com.google.android.gms.measurement.internal.zzf
            public void run() {
                zzac.this.zzjJ();
            }
        };
        this.zzaYT = new zzf(zzwVar) { // from class: com.google.android.gms.measurement.internal.zzac.2
            @Override // com.google.android.gms.measurement.internal.zzf
            public void run() {
                zzac.this.zzAo().zzCF().zzfg("Tasks have been queued for a long time");
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void onServiceDisconnected(ComponentName name) {
        zzjk();
        if (this.zzaYO != null) {
            this.zzaYO = null;
            zzAo().zzCK().zzj("Disconnected from device MeasurementService", name);
            zzDr();
        }
    }

    private boolean zzDp() {
        List<ResolveInfo> listQueryIntentServices = getContext().getPackageManager().queryIntentServices(new Intent(getContext(), (Class<?>) AppMeasurementService.class), 65536);
        return listQueryIntentServices != null && listQueryIntentServices.size() > 0;
    }

    @WorkerThread
    private boolean zzDq() {
        zzjk();
        zzjv();
        if (zzCp().zzkr()) {
            return true;
        }
        zzAo().zzCK().zzfg("Checking service availability");
        switch (com.google.android.gms.common.zzc.zzoK().isGooglePlayServicesAvailable(getContext())) {
            case 0:
                zzAo().zzCK().zzfg("Service available");
                return true;
            case 1:
                zzAo().zzCK().zzfg("Service missing");
                return false;
            case 2:
                zzAo().zzCK().zzfg("Service version update required");
                return false;
            case 3:
                zzAo().zzCK().zzfg("Service disabled");
                return false;
            case 9:
                zzAo().zzCK().zzfg("Service invalid");
                return false;
            case 18:
                zzAo().zzCK().zzfg("Service updating");
                return true;
            default:
                return false;
        }
    }

    @WorkerThread
    private void zzDr() {
        zzjk();
        zzjX();
    }

    @WorkerThread
    private void zzDs() {
        zzjk();
        zzAo().zzCK().zzj("Processing queued up service tasks", Integer.valueOf(this.zzaYS.size()));
        Iterator<Runnable> it = this.zzaYS.iterator();
        while (it.hasNext()) {
            zzCn().zzg(it.next());
        }
        this.zzaYS.clear();
        this.zzaYT.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void zza(zzm zzmVar) {
        zzjk();
        com.google.android.gms.common.internal.zzx.zzz(zzmVar);
        this.zzaYO = zzmVar;
        zzjI();
        zzDs();
    }

    @WorkerThread
    private void zzi(Runnable runnable) throws IllegalStateException {
        zzjk();
        if (isConnected()) {
            runnable.run();
            return;
        }
        if (this.zzaYS.size() >= zzCp().zzBS()) {
            zzAo().zzCE().zzfg("Discarding data. Max runnable queue size reached");
            return;
        }
        this.zzaYS.add(runnable);
        if (!this.zzaTV.zzCZ()) {
            this.zzaYT.zzt(60000L);
        }
        zzjX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void zzjI() {
        zzjk();
        this.zzaYR.start();
        if (this.zzaTV.zzCZ()) {
            return;
        }
        this.zzaYQ.zzt(zzCp().zzkM());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void zzjJ() {
        zzjk();
        if (isConnected()) {
            zzAo().zzCK().zzfg("Inactivity, disconnecting from AppMeasurementService");
            disconnect();
        }
    }

    @WorkerThread
    private void zzjX() {
        zzjk();
        zzjv();
        if (isConnected()) {
            return;
        }
        if (this.zzaYP == null) {
            this.zzaYP = zzCo().zzCP();
            if (this.zzaYP == null) {
                zzAo().zzCK().zzfg("State of service unknown");
                this.zzaYP = Boolean.valueOf(zzDq());
                zzCo().zzar(this.zzaYP.booleanValue());
            }
        }
        if (this.zzaYP.booleanValue()) {
            zzAo().zzCK().zzfg("Using measurement service");
            this.zzaYN.zzDt();
            return;
        }
        if (zzDp() && !this.zzaTV.zzCZ()) {
            zzAo().zzCK().zzfg("Using local app measurement service");
            Intent intent = new Intent("com.google.android.gms.measurement.START");
            intent.setComponent(new ComponentName(getContext(), (Class<?>) AppMeasurementService.class));
            this.zzaYN.zzz(intent);
            return;
        }
        if (!zzCp().zzks()) {
            zzAo().zzCE().zzfg("Not in main process. Unable to use local measurement implementation. Please register the AppMeasurementService service in the app manifest");
        } else {
            zzAo().zzCK().zzfg("Using direct local measurement implementation");
            zza(new zzx(this.zzaTV, true));
        }
    }

    @WorkerThread
    public void disconnect() {
        zzjk();
        zzjv();
        try {
            com.google.android.gms.common.stats.zzb.zzrP().zza(getContext(), this.zzaYN);
        } catch (IllegalArgumentException e) {
        } catch (IllegalStateException e2) {
        }
        this.zzaYO = null;
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    @WorkerThread
    public boolean isConnected() {
        zzjk();
        zzjv();
        return this.zzaYO != null;
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

    @WorkerThread
    protected void zzDl() {
        zzjk();
        zzjv();
        zzi(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzac.6
            @Override // java.lang.Runnable
            public void run() {
                zzm zzmVar = zzac.this.zzaYO;
                if (zzmVar == null) {
                    zzac.this.zzAo().zzCE().zzfg("Discarding data. Failed to send app launch");
                    return;
                }
                try {
                    zzmVar.zza(zzac.this.zzCg().zzfe(zzac.this.zzAo().zzCL()));
                    zzac.this.zzjI();
                } catch (RemoteException e) {
                    zzac.this.zzAo().zzCE().zzj("Failed to send app launch to AppMeasurementService", e);
                }
            }
        });
    }

    @WorkerThread
    protected void zzDo() {
        zzjk();
        zzjv();
        zzi(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzac.3
            @Override // java.lang.Runnable
            public void run() {
                zzm zzmVar = zzac.this.zzaYO;
                if (zzmVar == null) {
                    zzac.this.zzAo().zzCE().zzfg("Failed to send measurementEnabled to service");
                    return;
                }
                try {
                    zzmVar.zzb(zzac.this.zzCg().zzfe(zzac.this.zzAo().zzCL()));
                    zzac.this.zzjI();
                } catch (RemoteException e) {
                    zzac.this.zzAo().zzCE().zzj("Failed to send measurementEnabled to AppMeasurementService", e);
                }
            }
        });
    }

    @WorkerThread
    protected void zza(final UserAttributeParcel userAttributeParcel) {
        zzjk();
        zzjv();
        zzi(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzac.5
            @Override // java.lang.Runnable
            public void run() {
                zzm zzmVar = zzac.this.zzaYO;
                if (zzmVar == null) {
                    zzac.this.zzAo().zzCE().zzfg("Discarding data. Failed to set user attribute");
                    return;
                }
                try {
                    zzmVar.zza(userAttributeParcel, zzac.this.zzCg().zzfe(zzac.this.zzAo().zzCL()));
                    zzac.this.zzjI();
                } catch (RemoteException e) {
                    zzac.this.zzAo().zzCE().zzj("Failed to send attribute to AppMeasurementService", e);
                }
            }
        });
    }

    @WorkerThread
    protected void zzb(final EventParcel eventParcel, final String str) {
        com.google.android.gms.common.internal.zzx.zzz(eventParcel);
        zzjk();
        zzjv();
        zzi(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzac.4
            @Override // java.lang.Runnable
            public void run() {
                zzm zzmVar = zzac.this.zzaYO;
                if (zzmVar == null) {
                    zzac.this.zzAo().zzCE().zzfg("Discarding data. Failed to send event to service");
                    return;
                }
                try {
                    if (TextUtils.isEmpty(str)) {
                        zzmVar.zza(eventParcel, zzac.this.zzCg().zzfe(zzac.this.zzAo().zzCL()));
                    } else {
                        zzmVar.zza(eventParcel, str, zzac.this.zzAo().zzCL());
                    }
                    zzac.this.zzjI();
                } catch (RemoteException e) {
                    zzac.this.zzAo().zzCE().zzj("Failed to send event to AppMeasurementService", e);
                }
            }
        });
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
