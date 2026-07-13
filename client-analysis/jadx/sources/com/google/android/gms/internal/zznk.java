package com.google.android.gms.internal;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class zznk implements ThreadFactory {
    private final int mPriority;
    private final String zzaoq;
    private final AtomicInteger zzaor;
    private final ThreadFactory zzaos;

    public zznk(String str) {
        this(str, 0);
    }

    public zznk(String str, int i) {
        this.zzaor = new AtomicInteger();
        this.zzaos = Executors.defaultThreadFactory();
        this.zzaoq = (String) com.google.android.gms.common.internal.zzx.zzb(str, "Name must not be null");
        this.mPriority = i;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread threadNewThread = this.zzaos.newThread(new zznl(runnable, this.mPriority));
        threadNewThread.setName(this.zzaoq + "[" + this.zzaor.getAndIncrement() + "]");
        return threadNewThread;
    }
}
