package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzb<R extends Result> extends PendingResult<R> {
    private boolean zzL;
    private final Object zzagI;
    protected final zza<R> zzagJ;
    private final WeakReference<GoogleApiClient> zzagK;
    private final ArrayList<PendingResult.zza> zzagL;
    private ResultCallback<? super R> zzagM;
    private volatile boolean zzagN;
    private boolean zzagO;
    private boolean zzagP;
    private com.google.android.gms.common.internal.zzq zzagQ;
    private Integer zzagR;
    private volatile zzx<R> zzagS;
    private volatile R zzagy;
    private final CountDownLatch zzpJ;

    public static class zza<R extends Result> extends Handler {
        public zza() {
            this(Looper.getMainLooper());
        }

        public zza(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    Pair pair = (Pair) msg.obj;
                    zzb((ResultCallback) pair.first, (Result) pair.second);
                    break;
                case 2:
                    ((zzb) msg.obj).zzx(Status.zzagF);
                    break;
                default:
                    Log.wtf("BasePendingResult", "Don't know how to handle message: " + msg.what, new Exception());
                    break;
            }
        }

        public void zza(ResultCallback<? super R> resultCallback, R r) {
            sendMessage(obtainMessage(1, new Pair(resultCallback, r)));
        }

        public void zza(zzb<R> zzbVar, long j) {
            sendMessageDelayed(obtainMessage(2, zzbVar), j);
        }

        protected void zzb(ResultCallback<? super R> resultCallback, R r) {
            try {
                resultCallback.onResult(r);
            } catch (RuntimeException e) {
                zzb.zzc(r);
                throw e;
            }
        }

        public void zzph() {
            removeMessages(2);
        }
    }

    @Deprecated
    protected zzb(Looper looper) {
        this.zzagI = new Object();
        this.zzpJ = new CountDownLatch(1);
        this.zzagL = new ArrayList<>();
        this.zzagJ = new zza<>(looper);
        this.zzagK = new WeakReference<>(null);
    }

    protected zzb(GoogleApiClient googleApiClient) {
        this.zzagI = new Object();
        this.zzpJ = new CountDownLatch(1);
        this.zzagL = new ArrayList<>();
        this.zzagJ = new zza<>(googleApiClient != null ? googleApiClient.getLooper() : Looper.getMainLooper());
        this.zzagK = new WeakReference<>(googleApiClient);
    }

    private R get() {
        R r;
        synchronized (this.zzagI) {
            com.google.android.gms.common.internal.zzx.zza(this.zzagN ? false : true, "Result has already been consumed.");
            com.google.android.gms.common.internal.zzx.zza(isReady(), "Result is not ready.");
            r = this.zzagy;
            this.zzagy = null;
            this.zzagM = null;
            this.zzagN = true;
        }
        zzpf();
        return r;
    }

    private void zzb(R r) {
        this.zzagy = r;
        this.zzagQ = null;
        this.zzpJ.countDown();
        Status status = this.zzagy.getStatus();
        if (this.zzagM != null) {
            this.zzagJ.zzph();
            if (!this.zzL) {
                this.zzagJ.zza(this.zzagM, get());
            }
        }
        Iterator<PendingResult.zza> it = this.zzagL.iterator();
        while (it.hasNext()) {
            it.next().zzu(status);
        }
        this.zzagL.clear();
    }

    public static void zzc(Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).release();
            } catch (RuntimeException e) {
                Log.w("BasePendingResult", "Unable to release " + result, e);
            }
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final R await() {
        com.google.android.gms.common.internal.zzx.zza(Looper.myLooper() != Looper.getMainLooper(), "await must not be called on the UI thread");
        com.google.android.gms.common.internal.zzx.zza(!this.zzagN, "Result has already been consumed");
        com.google.android.gms.common.internal.zzx.zza(this.zzagS == null, "Cannot await if then() has been called.");
        try {
            this.zzpJ.await();
        } catch (InterruptedException e) {
            zzx(Status.zzagD);
        }
        com.google.android.gms.common.internal.zzx.zza(isReady(), "Result is not ready.");
        return (R) get();
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final R await(long j, TimeUnit timeUnit) {
        com.google.android.gms.common.internal.zzx.zza(j <= 0 || Looper.myLooper() != Looper.getMainLooper(), "await must not be called on the UI thread when time is greater than zero.");
        com.google.android.gms.common.internal.zzx.zza(!this.zzagN, "Result has already been consumed.");
        com.google.android.gms.common.internal.zzx.zza(this.zzagS == null, "Cannot await if then() has been called.");
        try {
            if (!this.zzpJ.await(j, timeUnit)) {
                zzx(Status.zzagF);
            }
        } catch (InterruptedException e) {
            zzx(Status.zzagD);
        }
        com.google.android.gms.common.internal.zzx.zza(isReady(), "Result is not ready.");
        return (R) get();
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public void cancel() {
        synchronized (this.zzagI) {
            if (this.zzL || this.zzagN) {
                return;
            }
            if (this.zzagQ != null) {
                try {
                    this.zzagQ.cancel();
                } catch (RemoteException e) {
                }
            }
            zzc(this.zzagy);
            this.zzagM = null;
            this.zzL = true;
            zzb(zzc(Status.zzagG));
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public boolean isCanceled() {
        boolean z;
        synchronized (this.zzagI) {
            z = this.zzL;
        }
        return z;
    }

    public final boolean isReady() {
        return this.zzpJ.getCount() == 0;
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final void setResultCallback(ResultCallback<? super R> callback) {
        com.google.android.gms.common.internal.zzx.zza(!this.zzagN, "Result has already been consumed.");
        synchronized (this.zzagI) {
            com.google.android.gms.common.internal.zzx.zza(this.zzagS == null, "Cannot set callbacks if then() has been called.");
            if (isCanceled()) {
                return;
            }
            if (this.zzagP && (this.zzagK.get() == null || !(callback instanceof zzx))) {
                cancel();
                return;
            }
            if (isReady()) {
                this.zzagJ.zza(callback, get());
            } else {
                this.zzagM = callback;
            }
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final void setResultCallback(ResultCallback<? super R> callback, long time, TimeUnit units) {
        com.google.android.gms.common.internal.zzx.zza(!this.zzagN, "Result has already been consumed.");
        synchronized (this.zzagI) {
            com.google.android.gms.common.internal.zzx.zza(this.zzagS == null, "Cannot set callbacks if then() has been called.");
            if (isCanceled()) {
                return;
            }
            if (this.zzagP && (this.zzagK.get() == null || !(callback instanceof zzx))) {
                cancel();
                return;
            }
            if (isReady()) {
                this.zzagJ.zza(callback, get());
            } else {
                this.zzagM = callback;
                this.zzagJ.zza(this, units.toMillis(time));
            }
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public <S extends Result> TransformedResult<S> then(ResultTransform<? super R, ? extends S> transform) {
        TransformedResult<S> transformedResultThen;
        com.google.android.gms.common.internal.zzx.zza(!this.zzagN, "Result has already been consumed.");
        synchronized (this.zzagI) {
            com.google.android.gms.common.internal.zzx.zza(this.zzagS == null, "Cannot call then() twice.");
            com.google.android.gms.common.internal.zzx.zza(this.zzagM == null, "Cannot call then() if callbacks are set.");
            this.zzagS = new zzx<>(this.zzagK);
            transformedResultThen = this.zzagS.then(transform);
            if (isReady()) {
                this.zzagJ.zza(this.zzagS, get());
            } else {
                this.zzagM = this.zzagS;
            }
        }
        return transformedResultThen;
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final void zza(PendingResult.zza zzaVar) {
        com.google.android.gms.common.internal.zzx.zza(!this.zzagN, "Result has already been consumed.");
        com.google.android.gms.common.internal.zzx.zzb(zzaVar != null, "Callback cannot be null.");
        synchronized (this.zzagI) {
            if (isReady()) {
                zzaVar.zzu(this.zzagy.getStatus());
            } else {
                this.zzagL.add(zzaVar);
            }
        }
    }

    public final void zza(R r) {
        synchronized (this.zzagI) {
            if (this.zzagO || this.zzL) {
                zzc(r);
                return;
            }
            com.google.android.gms.common.internal.zzx.zza(!isReady(), "Results have already been set");
            com.google.android.gms.common.internal.zzx.zza(this.zzagN ? false : true, "Result has already been consumed");
            zzb(r);
        }
    }

    protected final void zza(com.google.android.gms.common.internal.zzq zzqVar) {
        synchronized (this.zzagI) {
            this.zzagQ = zzqVar;
        }
    }

    protected abstract R zzc(Status status);

    @Override // com.google.android.gms.common.api.PendingResult
    public Integer zzpa() {
        return this.zzagR;
    }

    protected void zzpf() {
    }

    public void zzpg() {
        synchronized (this.zzagI) {
            if (this.zzagK.get() == null) {
                cancel();
                return;
            }
            if (this.zzagM == null || (this.zzagM instanceof zzx)) {
                this.zzagP = true;
            } else {
                cancel();
            }
        }
    }

    public final void zzx(Status status) {
        synchronized (this.zzagI) {
            if (!isReady()) {
                zza(zzc(status));
                this.zzagO = true;
            }
        }
    }
}
