package com.google.android.gms.internal;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzje<T> implements zzjg<T> {
    private final T zzNc;
    private final zzjh zzNe = new zzjh();

    public zzje(T t) {
        this.zzNc = t;
        this.zzNe.zzhK();
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean mayInterruptIfRunning) {
        return false;
    }

    @Override // java.util.concurrent.Future
    public T get() {
        return this.zzNc;
    }

    @Override // java.util.concurrent.Future
    public T get(long timeout, TimeUnit unit) {
        return this.zzNc;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return true;
    }

    @Override // com.google.android.gms.internal.zzjg
    public void zzb(Runnable runnable) {
        this.zzNe.zzb(runnable);
    }
}
