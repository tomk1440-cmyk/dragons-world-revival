package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Process;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.internal.zzmq;
import com.google.android.gms.internal.zzmt;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class zza {
    private static zza zzbhA;
    private static Object zzbhz = new Object();
    private volatile boolean mClosed;
    private final Context mContext;
    private final Thread zzLM;
    private volatile AdvertisingIdClient.Info zzPW;
    private volatile long zzbht;
    private volatile long zzbhu;
    private volatile long zzbhv;
    private volatile long zzbhw;
    private final Object zzbhx;
    private InterfaceC0273zza zzbhy;
    private final zzmq zzqW;

    /* JADX INFO: renamed from: com.google.android.gms.tagmanager.zza$zza, reason: collision with other inner class name */
    public interface InterfaceC0273zza {
        AdvertisingIdClient.Info zzFV();
    }

    private zza(Context context) {
        this(context, null, zzmt.zzsc());
    }

    public zza(Context context, InterfaceC0273zza interfaceC0273zza, zzmq zzmqVar) {
        this.zzbht = 900000L;
        this.zzbhu = 30000L;
        this.mClosed = false;
        this.zzbhx = new Object();
        this.zzbhy = new InterfaceC0273zza() { // from class: com.google.android.gms.tagmanager.zza.1
            @Override // com.google.android.gms.tagmanager.zza.InterfaceC0273zza
            public AdvertisingIdClient.Info zzFV() {
                try {
                    return AdvertisingIdClient.getAdvertisingIdInfo(zza.this.mContext);
                } catch (GooglePlayServicesNotAvailableException e) {
                    zzbg.zzd("GooglePlayServicesNotAvailableException getting Advertising Id Info", e);
                    return null;
                } catch (GooglePlayServicesRepairableException e2) {
                    zzbg.zzd("GooglePlayServicesRepairableException getting Advertising Id Info", e2);
                    return null;
                } catch (IOException e3) {
                    zzbg.zzd("IOException getting Ad Id Info", e3);
                    return null;
                } catch (IllegalStateException e4) {
                    zzbg.zzd("IllegalStateException getting Advertising Id Info", e4);
                    return null;
                } catch (Exception e5) {
                    zzbg.zzd("Unknown exception. Could not get the Advertising Id Info.", e5);
                    return null;
                }
            }
        };
        this.zzqW = zzmqVar;
        if (context != null) {
            this.mContext = context.getApplicationContext();
        } else {
            this.mContext = context;
        }
        if (interfaceC0273zza != null) {
            this.zzbhy = interfaceC0273zza;
        }
        this.zzbhv = this.zzqW.currentTimeMillis();
        this.zzLM = new Thread(new Runnable() { // from class: com.google.android.gms.tagmanager.zza.2
            @Override // java.lang.Runnable
            public void run() {
                zza.this.zzFU();
            }
        });
    }

    private void zzFR() {
        synchronized (this) {
            try {
                zzFS();
                wait(500L);
            } catch (InterruptedException e) {
            }
        }
    }

    private void zzFS() {
        if (this.zzqW.currentTimeMillis() - this.zzbhv > this.zzbhu) {
            synchronized (this.zzbhx) {
                this.zzbhx.notify();
            }
            this.zzbhv = this.zzqW.currentTimeMillis();
        }
    }

    private void zzFT() {
        if (this.zzqW.currentTimeMillis() - this.zzbhw > 3600000) {
            this.zzPW = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzFU() {
        Process.setThreadPriority(10);
        while (!this.mClosed) {
            AdvertisingIdClient.Info infoZzFV = this.zzbhy.zzFV();
            if (infoZzFV != null) {
                this.zzPW = infoZzFV;
                this.zzbhw = this.zzqW.currentTimeMillis();
                zzbg.zzaJ("Obtained fresh AdvertisingId info from GmsCore.");
            }
            synchronized (this) {
                notifyAll();
            }
            try {
                synchronized (this.zzbhx) {
                    try {
                        this.zzbhx.wait(this.zzbht);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (InterruptedException e) {
                zzbg.zzaJ("sleep interrupted in AdvertiserDataPoller thread; continuing");
            }
        }
    }

    public static zza zzaW(Context context) {
        if (zzbhA == null) {
            synchronized (zzbhz) {
                if (zzbhA == null) {
                    zzbhA = new zza(context);
                    zzbhA.start();
                }
            }
        }
        return zzbhA;
    }

    public boolean isLimitAdTrackingEnabled() {
        if (this.zzPW == null) {
            zzFR();
        } else {
            zzFS();
        }
        zzFT();
        if (this.zzPW == null) {
            return true;
        }
        return this.zzPW.isLimitAdTrackingEnabled();
    }

    public void start() {
        this.zzLM.start();
    }

    public String zzFQ() {
        if (this.zzPW == null) {
            zzFR();
        } else {
            zzFS();
        }
        zzFT();
        if (this.zzPW == null) {
            return null;
        }
        return this.zzPW.getId();
    }
}
