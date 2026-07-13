package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.internal.zzmq;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;

/* JADX INFO: loaded from: classes.dex */
public class zzv extends zzz {
    private zzc zzaXI;
    private zzc zzaXJ;
    private final BlockingQueue<FutureTask<?>> zzaXK;
    private final BlockingQueue<FutureTask<?>> zzaXL;
    private final Thread.UncaughtExceptionHandler zzaXM;
    private final Thread.UncaughtExceptionHandler zzaXN;
    private final Object zzaXO;
    private final Semaphore zzaXP;
    private volatile boolean zzaXQ;

    private final class zza<V> extends FutureTask<V> {
        private final String zzaXR;

        zza(Runnable runnable, String str) {
            super(runnable, null);
            com.google.android.gms.common.internal.zzx.zzz(str);
            this.zzaXR = str;
        }

        zza(Callable<V> callable, String str) {
            super(callable);
            com.google.android.gms.common.internal.zzx.zzz(str);
            this.zzaXR = str;
        }

        @Override // java.util.concurrent.FutureTask
        protected void setException(Throwable error) {
            zzv.this.zzAo().zzCE().zzj(this.zzaXR, error);
            super.setException(error);
        }
    }

    private final class zzb implements Thread.UncaughtExceptionHandler {
        private final String zzaXR;

        public zzb(String str) {
            com.google.android.gms.common.internal.zzx.zzz(str);
            this.zzaXR = str;
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public synchronized void uncaughtException(Thread thread, Throwable error) {
            zzv.this.zzAo().zzCE().zzj(this.zzaXR, error);
        }
    }

    private final class zzc extends Thread {
        private final Object zzaXT;
        private final BlockingQueue<FutureTask<?>> zzaXU;

        public zzc(String str, BlockingQueue<FutureTask<?>> blockingQueue) {
            com.google.android.gms.common.internal.zzx.zzz(str);
            this.zzaXT = new Object();
            this.zzaXU = blockingQueue;
            setName(str);
        }

        private void zza(InterruptedException interruptedException) {
            zzv.this.zzAo().zzCF().zzj(getName() + " was interrupted", interruptedException);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            boolean z = false;
            while (!z) {
                try {
                    zzv.this.zzaXP.acquire();
                    z = true;
                } catch (InterruptedException e) {
                    zza(e);
                }
            }
            while (true) {
                try {
                    FutureTask<?> futureTaskPoll = this.zzaXU.poll();
                    if (futureTaskPoll == null) {
                        synchronized (this.zzaXT) {
                            if (this.zzaXU.peek() == null && !zzv.this.zzaXQ) {
                                try {
                                    this.zzaXT.wait(30000L);
                                } catch (InterruptedException e2) {
                                    zza(e2);
                                }
                            }
                        }
                        synchronized (zzv.this.zzaXO) {
                            if (this.zzaXU.peek() == null) {
                                break;
                            }
                        }
                    } else {
                        futureTaskPoll.run();
                    }
                } catch (Throwable th) {
                    synchronized (zzv.this.zzaXO) {
                        zzv.this.zzaXP.release();
                        zzv.this.zzaXO.notifyAll();
                        if (this == zzv.this.zzaXI) {
                            zzv.this.zzaXI = null;
                        } else if (this == zzv.this.zzaXJ) {
                            zzv.this.zzaXJ = null;
                        } else {
                            zzv.this.zzAo().zzCE().zzfg("Current scheduler thread is neither worker nor network");
                        }
                        throw th;
                    }
                }
            }
            synchronized (zzv.this.zzaXO) {
                zzv.this.zzaXP.release();
                zzv.this.zzaXO.notifyAll();
                if (this == zzv.this.zzaXI) {
                    zzv.this.zzaXI = null;
                } else if (this == zzv.this.zzaXJ) {
                    zzv.this.zzaXJ = null;
                } else {
                    zzv.this.zzAo().zzCE().zzfg("Current scheduler thread is neither worker nor network");
                }
            }
        }

        public void zzfb() {
            synchronized (this.zzaXT) {
                this.zzaXT.notifyAll();
            }
        }
    }

    zzv(zzw zzwVar) {
        super(zzwVar);
        this.zzaXO = new Object();
        this.zzaXP = new Semaphore(2);
        this.zzaXK = new LinkedBlockingQueue();
        this.zzaXL = new LinkedBlockingQueue();
        this.zzaXM = new zzb("Thread death: Uncaught exception on worker thread");
        this.zzaXN = new zzb("Thread death: Uncaught exception on network thread");
    }

    private void zza(FutureTask<?> futureTask) {
        synchronized (this.zzaXO) {
            this.zzaXK.add(futureTask);
            if (this.zzaXI == null) {
                this.zzaXI = new zzc("Measurement Worker", this.zzaXK);
                this.zzaXI.setUncaughtExceptionHandler(this.zzaXM);
                this.zzaXI.start();
            } else {
                this.zzaXI.zzfb();
            }
        }
    }

    private void zzb(FutureTask<?> futureTask) {
        synchronized (this.zzaXO) {
            this.zzaXL.add(futureTask);
            if (this.zzaXJ == null) {
                this.zzaXJ = new zzc("Measurement Network", this.zzaXL);
                this.zzaXJ.setUncaughtExceptionHandler(this.zzaXN);
                this.zzaXJ.start();
            } else {
                this.zzaXJ.zzfb();
            }
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzp zzAo() {
        return super.zzAo();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public void zzCd() {
        if (Thread.currentThread() != this.zzaXJ) {
            throw new IllegalStateException("Call expected from network thread");
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ com.google.android.gms.measurement.internal.zzc zzCe() {
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

    public <V> Future<V> zzd(Callable<V> callable) throws IllegalStateException {
        zzjv();
        com.google.android.gms.common.internal.zzx.zzz(callable);
        zza zzaVar = new zza(callable, "Task exception on worker thread");
        if (Thread.currentThread() == this.zzaXI) {
            zzaVar.run();
        } else {
            zza(zzaVar);
        }
        return zzaVar;
    }

    public void zzg(Runnable runnable) throws IllegalStateException {
        zzjv();
        com.google.android.gms.common.internal.zzx.zzz(runnable);
        zza(new zza(runnable, "Task exception on worker thread"));
    }

    public void zzh(Runnable runnable) throws IllegalStateException {
        zzjv();
        com.google.android.gms.common.internal.zzx.zzz(runnable);
        zzb(new zza(runnable, "Task exception on network thread"));
    }

    @Override // com.google.android.gms.measurement.internal.zzz
    protected void zziJ() {
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ void zzjj() {
        super.zzjj();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public void zzjk() {
        if (Thread.currentThread() != this.zzaXI) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzmq zzjl() {
        return super.zzjl();
    }
}
