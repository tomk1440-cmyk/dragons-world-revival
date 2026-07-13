package com.google.android.gms.internal;

import android.content.Context;
import com.google.ads.afma.nano.NanoAfmaSignals;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class zzam extends zzal {
    private static AdvertisingIdClient zzok = null;
    private static CountDownLatch zzol = new CountDownLatch(1);
    private boolean zzom;

    class zza {
        private String zzon;
        private boolean zzoo;

        public zza(String str, boolean z) {
            this.zzon = str;
            this.zzoo = z;
        }

        public String getId() {
            return this.zzon;
        }

        public boolean isLimitAdTrackingEnabled() {
            return this.zzoo;
        }
    }

    private static final class zzb implements Runnable {
        private Context zzoq;

        public zzb(Context context) {
            this.zzoq = context.getApplicationContext();
            if (this.zzoq == null) {
                this.zzoq = context;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (zzam.class) {
                try {
                    try {
                        if (zzam.zzok == null) {
                            AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
                            AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(this.zzoq);
                            advertisingIdClient.start();
                            AdvertisingIdClient unused = zzam.zzok = advertisingIdClient;
                        }
                        zzam.zzol.countDown();
                    } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException e) {
                        AdvertisingIdClient unused2 = zzam.zzok = null;
                        zzam.zzol.countDown();
                    }
                } catch (Throwable th) {
                    zzam.zzol.countDown();
                    throw th;
                }
            }
        }
    }

    protected zzam(Context context, zzap zzapVar, boolean z) {
        super(context, zzapVar);
        this.zzom = z;
    }

    public static zzam zza(String str, Context context, boolean z) {
        zzah zzahVar = new zzah();
        zza(str, context, zzahVar);
        if (z) {
            synchronized (zzam.class) {
                if (zzok == null) {
                    new Thread(new zzb(context)).start();
                }
            }
        }
        return new zzam(context, zzahVar, z);
    }

    private void zza(Context context, NanoAfmaSignals.AFMASignals aFMASignals) {
        if (this.zzom) {
            try {
                if (zzS()) {
                    zza zzaVarZzY = zzY();
                    String id = zzaVarZzY.getId();
                    if (id != null) {
                        aFMASignals.didOptOut = Boolean.valueOf(zzaVarZzY.isLimitAdTrackingEnabled());
                        aFMASignals.didSignalType = 5;
                        aFMASignals.didSignal = id;
                        zza(28, zzob);
                    }
                } else {
                    aFMASignals.didSignal = zzf(context);
                    zza(24, zzob);
                }
            } catch (zzal.zza e) {
            } catch (IOException e2) {
            }
        }
    }

    zza zzY() throws IOException {
        zza zzaVar;
        try {
            if (!zzol.await(2L, TimeUnit.SECONDS)) {
                return new zza(null, false);
            }
            synchronized (zzam.class) {
                if (zzok == null) {
                    zzaVar = new zza(null, false);
                } else {
                    AdvertisingIdClient.Info info = zzok.getInfo();
                    zzaVar = new zza(zzk(info.getId()), info.isLimitAdTrackingEnabled());
                }
            }
            return zzaVar;
        } catch (InterruptedException e) {
            return new zza(null, false);
        }
    }

    @Override // com.google.android.gms.internal.zzal, com.google.android.gms.internal.zzak
    protected NanoAfmaSignals.AFMASignals zzc(Context context) {
        NanoAfmaSignals.AFMASignals aFMASignalsZzc = super.zzc(context);
        zza(context, aFMASignalsZzc);
        return aFMASignalsZzc;
    }
}
