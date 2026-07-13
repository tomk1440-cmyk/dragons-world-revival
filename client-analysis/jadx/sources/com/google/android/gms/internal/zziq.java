package com.google.android.gms.internal;

import android.os.Process;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public final class zziq {
    private static final ExecutorService zzLU = Executors.newFixedThreadPool(10, zzaB("Default"));
    private static final ExecutorService zzLV = Executors.newFixedThreadPool(5, zzaB("Loader"));

    public static zzjg<Void> zza(int i, final Runnable runnable) {
        return i == 1 ? zza(zzLV, new Callable<Void>() { // from class: com.google.android.gms.internal.zziq.1
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: zzdt, reason: merged with bridge method [inline-methods] */
            public Void call() {
                runnable.run();
                return null;
            }
        }) : zza(zzLU, new Callable<Void>() { // from class: com.google.android.gms.internal.zziq.2
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: zzdt, reason: merged with bridge method [inline-methods] */
            public Void call() {
                runnable.run();
                return null;
            }
        });
    }

    public static zzjg<Void> zza(Runnable runnable) {
        return zza(0, runnable);
    }

    public static <T> zzjg<T> zza(Callable<T> callable) {
        return zza(zzLU, callable);
    }

    public static <T> zzjg<T> zza(ExecutorService executorService, final Callable<T> callable) {
        final zzjd zzjdVar = new zzjd();
        try {
            final Future<?> futureSubmit = executorService.submit(new Runnable() { // from class: com.google.android.gms.internal.zziq.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Process.setThreadPriority(10);
                        zzjdVar.zzg(callable.call());
                    } catch (Exception e) {
                        com.google.android.gms.ads.internal.zzr.zzbF().zzb((Throwable) e, true);
                        zzjdVar.cancel(true);
                    }
                }
            });
            zzjdVar.zzc(new Runnable() { // from class: com.google.android.gms.internal.zziq.4
                @Override // java.lang.Runnable
                public void run() {
                    if (zzjdVar.isCancelled()) {
                        futureSubmit.cancel(true);
                    }
                }
            });
        } catch (RejectedExecutionException e) {
            zzin.zzd("Thread execution is rejected.", e);
            zzjdVar.cancel(true);
        }
        return zzjdVar;
    }

    private static ThreadFactory zzaB(final String str) {
        return new ThreadFactory() { // from class: com.google.android.gms.internal.zziq.5
            private final AtomicInteger zzMa = new AtomicInteger(1);

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "AdWorker(" + str + ") #" + this.zzMa.getAndIncrement());
            }
        };
    }
}
