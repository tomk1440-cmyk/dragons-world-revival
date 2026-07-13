package com.google.android.gms.measurement;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Process;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import com.google.android.gms.analytics.internal.zzam;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzpq;
import com.google.android.gms.internal.zzps;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class zzg {
    private static volatile zzg zzaUv;
    private final Context mContext;
    private volatile zzpq zzQX;
    private final List<zzh> zzaUw;
    private final com.google.android.gms.measurement.zzb zzaUx;
    private final zza zzaUy;
    private Thread.UncaughtExceptionHandler zzaUz;

    private class zza extends ThreadPoolExecutor {
        public zza() {
            super(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
            setThreadFactory(new zzb());
        }

        @Override // java.util.concurrent.AbstractExecutorService
        protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T value) {
            return new FutureTask<T>(runnable, value) { // from class: com.google.android.gms.measurement.zzg.zza.1
                @Override // java.util.concurrent.FutureTask
                protected void setException(Throwable error) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler = zzg.this.zzaUz;
                    if (uncaughtExceptionHandler != null) {
                        uncaughtExceptionHandler.uncaughtException(Thread.currentThread(), error);
                    } else if (Log.isLoggable("GAv4", 6)) {
                        Log.e("GAv4", "MeasurementExecutor: job failed with " + error);
                    }
                    super.setException(error);
                }
            };
        }
    }

    private static class zzb implements ThreadFactory {
        private static final AtomicInteger zzaUD = new AtomicInteger();

        private zzb() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable target) {
            return new zzc(target, "measurement-" + zzaUD.incrementAndGet());
        }
    }

    private static class zzc extends Thread {
        zzc(Runnable runnable, String str) {
            super(runnable, str);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            super.run();
        }
    }

    zzg(Context context) {
        Context applicationContext = context.getApplicationContext();
        zzx.zzz(applicationContext);
        this.mContext = applicationContext;
        this.zzaUy = new zza();
        this.zzaUw = new CopyOnWriteArrayList();
        this.zzaUx = new com.google.android.gms.measurement.zzb();
    }

    public static zzg zzaS(Context context) {
        zzx.zzz(context);
        if (zzaUv == null) {
            synchronized (zzg.class) {
                if (zzaUv == null) {
                    zzaUv = new zzg(context);
                }
            }
        }
        return zzaUv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzb(com.google.android.gms.measurement.zzc zzcVar) {
        zzx.zzcE("deliver should be called from worker thread");
        zzx.zzb(zzcVar.zzAz(), "Measurement must be submitted");
        List<zzi> listZzAw = zzcVar.zzAw();
        if (listZzAw.isEmpty()) {
            return;
        }
        HashSet hashSet = new HashSet();
        for (zzi zziVar : listZzAw) {
            Uri uriZziA = zziVar.zziA();
            if (!hashSet.contains(uriZziA)) {
                hashSet.add(uriZziA);
                zziVar.zzb(zzcVar);
            }
        }
    }

    public static void zzjk() {
        if (!(Thread.currentThread() instanceof zzc)) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public zzpq zzAH() {
        if (this.zzQX == null) {
            synchronized (this) {
                if (this.zzQX == null) {
                    zzpq zzpqVar = new zzpq();
                    PackageManager packageManager = this.mContext.getPackageManager();
                    String packageName = this.mContext.getPackageName();
                    zzpqVar.setAppId(packageName);
                    zzpqVar.setAppInstallerId(packageManager.getInstallerPackageName(packageName));
                    String str = null;
                    try {
                        PackageInfo packageInfo = packageManager.getPackageInfo(this.mContext.getPackageName(), 0);
                        if (packageInfo != null) {
                            CharSequence applicationLabel = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                            if (!TextUtils.isEmpty(applicationLabel)) {
                                packageName = applicationLabel.toString();
                            }
                            str = packageInfo.versionName;
                        }
                    } catch (PackageManager.NameNotFoundException e) {
                        Log.e("GAv4", "Error retrieving package info: appName set to " + packageName);
                    }
                    zzpqVar.setAppName(packageName);
                    zzpqVar.setAppVersion(str);
                    this.zzQX = zzpqVar;
                }
            }
        }
        return this.zzQX;
    }

    public zzps zzAI() {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        zzps zzpsVar = new zzps();
        zzpsVar.setLanguage(zzam.zza(Locale.getDefault()));
        zzpsVar.zziB(displayMetrics.widthPixels);
        zzpsVar.zziC(displayMetrics.heightPixels);
        return zzpsVar;
    }

    public void zza(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.zzaUz = uncaughtExceptionHandler;
    }

    public <V> Future<V> zzc(Callable<V> callable) {
        zzx.zzz(callable);
        if (!(Thread.currentThread() instanceof zzc)) {
            return this.zzaUy.submit(callable);
        }
        FutureTask futureTask = new FutureTask(callable);
        futureTask.run();
        return futureTask;
    }

    void zze(com.google.android.gms.measurement.zzc zzcVar) {
        if (zzcVar.zzAD()) {
            throw new IllegalStateException("Measurement prototype can't be submitted");
        }
        if (zzcVar.zzAz()) {
            throw new IllegalStateException("Measurement can only be submitted once");
        }
        final com.google.android.gms.measurement.zzc zzcVarZzAu = zzcVar.zzAu();
        zzcVarZzAu.zzAA();
        this.zzaUy.execute(new Runnable() { // from class: com.google.android.gms.measurement.zzg.1
            @Override // java.lang.Runnable
            public void run() {
                zzcVarZzAu.zzAB().zza(zzcVarZzAu);
                Iterator it = zzg.this.zzaUw.iterator();
                while (it.hasNext()) {
                    ((zzh) it.next()).zza(zzcVarZzAu);
                }
                zzg.this.zzb(zzcVarZzAu);
            }
        });
    }

    public void zzf(Runnable runnable) {
        zzx.zzz(runnable);
        this.zzaUy.submit(runnable);
    }
}
