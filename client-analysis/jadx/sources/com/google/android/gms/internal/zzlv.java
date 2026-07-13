package com.google.android.gms.internal;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.clearcut.LogEventParcelable;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class zzlv implements com.google.android.gms.clearcut.zzc {
    private static final Object zzafn = new Object();
    private static final zze zzafo = new zze();
    private static final long zzafp = TimeUnit.MILLISECONDS.convert(2, TimeUnit.MINUTES);
    private GoogleApiClient zzaaj;
    private final zza zzafq;
    private final Object zzafr;
    private long zzafs;
    private final long zzaft;
    private ScheduledFuture<?> zzafu;
    private final Runnable zzafv;
    private final zzmq zzqW;

    public interface zza {
    }

    public static class zzb implements zza {
    }

    static abstract class zzc<R extends Result> extends com.google.android.gms.common.api.internal.zza.AbstractC0049zza<R, zzlw> {
        public zzc(GoogleApiClient googleApiClient) {
            super(com.google.android.gms.clearcut.zzb.zzUI, googleApiClient);
        }
    }

    final class zzd extends zzc<Status> {
        private final LogEventParcelable zzafx;

        zzd(LogEventParcelable logEventParcelable, GoogleApiClient googleApiClient) {
            super(googleApiClient);
            this.zzafx = logEventParcelable;
        }

        public boolean equals(Object rhs) {
            if (rhs instanceof zzd) {
                return this.zzafx.equals(((zzd) rhs).zzafx);
            }
            return false;
        }

        public String toString() {
            return "MethodImpl(" + this.zzafx + ")";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
        public void zza(zzlw zzlwVar) throws RemoteException {
            zzlx.zza zzaVar = new zzlx.zza() { // from class: com.google.android.gms.internal.zzlv.zzd.1
                @Override // com.google.android.gms.internal.zzlx
                public void zzv(Status status) {
                    zzd.this.zza(status);
                }
            };
            try {
                zzlv.zza(this.zzafx);
                zzlwVar.zza(zzaVar, this.zzafx);
            } catch (Throwable th) {
                Log.e("ClearcutLoggerApiImpl", "MessageNanoProducer " + this.zzafx.zzafl.toString() + " threw: " + th.toString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zzb
        /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
        public Status zzc(Status status) {
            return status;
        }
    }

    private static final class zze {
        private int mSize;

        private zze() {
            this.mSize = 0;
        }

        public boolean zza(long j, TimeUnit timeUnit) throws InterruptedException {
            boolean z;
            long jCurrentTimeMillis = System.currentTimeMillis();
            long jConvert = TimeUnit.MILLISECONDS.convert(j, timeUnit);
            synchronized (this) {
                while (this.mSize != 0) {
                    if (jConvert <= 0) {
                        z = false;
                    } else {
                        wait(jConvert);
                        jConvert -= System.currentTimeMillis() - jCurrentTimeMillis;
                    }
                }
                z = true;
            }
            return z;
        }

        public synchronized void zzoH() {
            this.mSize++;
        }

        public synchronized void zzoI() {
            if (this.mSize == 0) {
                throw new RuntimeException("too many decrements");
            }
            this.mSize--;
            if (this.mSize == 0) {
                notifyAll();
            }
        }
    }

    public zzlv() {
        this(new zzmt(), zzafp, new zzb());
    }

    public zzlv(zzmq zzmqVar, long j, zza zzaVar) {
        this.zzafr = new Object();
        this.zzafs = 0L;
        this.zzafu = null;
        this.zzaaj = null;
        this.zzafv = new Runnable() { // from class: com.google.android.gms.internal.zzlv.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (zzlv.this.zzafr) {
                    if (zzlv.this.zzafs <= zzlv.this.zzqW.elapsedRealtime() && zzlv.this.zzaaj != null) {
                        Log.i("ClearcutLoggerApiImpl", "disconnect managed GoogleApiClient");
                        zzlv.this.zzaaj.disconnect();
                        zzlv.this.zzaaj = null;
                    }
                }
            }
        };
        this.zzqW = zzmqVar;
        this.zzaft = j;
        this.zzafq = zzaVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zza(LogEventParcelable logEventParcelable) {
        if (logEventParcelable.zzafl != null && logEventParcelable.zzafk.zzbuY.length == 0) {
            logEventParcelable.zzafk.zzbuY = logEventParcelable.zzafl.zzoF();
        }
        if (logEventParcelable.zzafm != null && logEventParcelable.zzafk.zzbvf.length == 0) {
            logEventParcelable.zzafk.zzbvf = logEventParcelable.zzafm.zzoF();
        }
        logEventParcelable.zzafi = zzsu.toByteArray(logEventParcelable.zzafk);
    }

    private zzd zzb(GoogleApiClient googleApiClient, LogEventParcelable logEventParcelable) {
        zzafo.zzoH();
        zzd zzdVar = new zzd(logEventParcelable, googleApiClient);
        zzdVar.zza(new PendingResult.zza() { // from class: com.google.android.gms.internal.zzlv.2
            @Override // com.google.android.gms.common.api.PendingResult.zza
            public void zzu(Status status) {
                zzlv.zzafo.zzoI();
            }
        });
        return zzdVar;
    }

    @Override // com.google.android.gms.clearcut.zzc
    public PendingResult<Status> zza(GoogleApiClient googleApiClient, LogEventParcelable logEventParcelable) {
        zza(logEventParcelable);
        return googleApiClient.zza(zzb(googleApiClient, logEventParcelable));
    }

    @Override // com.google.android.gms.clearcut.zzc
    public boolean zza(GoogleApiClient googleApiClient, long j, TimeUnit timeUnit) {
        try {
            return zzafo.zza(j, timeUnit);
        } catch (InterruptedException e) {
            Log.e("ClearcutLoggerApiImpl", "flush interrupted");
            Thread.currentThread().interrupt();
            return false;
        }
    }
}
