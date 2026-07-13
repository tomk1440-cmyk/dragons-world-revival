package com.google.android.gms.internal;

import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzjd<T> implements zzjg<T> {
    private final Object zzpV = new Object();
    private T zzNc = null;
    private boolean zzNd = false;
    private boolean zzCy = false;
    private final zzjh zzNe = new zzjh();

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean mayInterruptIfRunning) {
        boolean z = false;
        if (mayInterruptIfRunning) {
            synchronized (this.zzpV) {
                if (!this.zzNd) {
                    this.zzCy = true;
                    this.zzNd = true;
                    this.zzpV.notifyAll();
                    this.zzNe.zzhK();
                    z = true;
                }
            }
        }
        return z;
    }

    @Override // java.util.concurrent.Future
    public T get() {
        T t;
        synchronized (this.zzpV) {
            if (!this.zzNd) {
                try {
                    this.zzpV.wait();
                } catch (InterruptedException e) {
                }
            }
            if (this.zzCy) {
                throw new CancellationException("CallbackFuture was cancelled.");
            }
            t = this.zzNc;
        }
        return t;
    }

    @Override // java.util.concurrent.Future
    public T get(long timeout, TimeUnit unit) throws TimeoutException {
        T t;
        synchronized (this.zzpV) {
            if (!this.zzNd) {
                try {
                    long millis = unit.toMillis(timeout);
                    if (millis != 0) {
                        this.zzpV.wait(millis);
                    }
                } catch (InterruptedException e) {
                }
            }
            if (!this.zzNd) {
                throw new TimeoutException("CallbackFuture timed out.");
            }
            if (this.zzCy) {
                throw new CancellationException("CallbackFuture was cancelled.");
            }
            t = this.zzNc;
        }
        return t;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        boolean z;
        synchronized (this.zzpV) {
            z = this.zzCy;
        }
        return z;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        boolean z;
        synchronized (this.zzpV) {
            z = this.zzNd;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.zzjg
    public void zzb(Runnable runnable) {
        this.zzNe.zzb(runnable);
    }

    public void zzc(Runnable runnable) {
        this.zzNe.zzc(runnable);
    }

    public void zzg(T t) {
        synchronized (this.zzpV) {
            if (this.zzCy) {
                return;
            }
            if (this.zzNd) {
                throw new IllegalStateException("Provided CallbackFuture with multiple values.");
            }
            this.zzNd = true;
            this.zzNc = t;
            this.zzpV.notifyAll();
            this.zzNe.zzhK();
        }
    }
}
