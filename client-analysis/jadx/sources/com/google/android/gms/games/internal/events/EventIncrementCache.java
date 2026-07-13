package com.google.android.gms.games.internal.events;

import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public abstract class EventIncrementCache {
    private Handler zzaIe;
    private boolean zzaIf;
    private int zzaIh;
    final Object zzaId = new Object();
    private HashMap<String, AtomicInteger> zzaIg = new HashMap<>();

    public EventIncrementCache(Looper looper, int flushIntervalMillis) {
        this.zzaIe = new Handler(looper);
        this.zzaIh = flushIntervalMillis;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzxl() {
        synchronized (this.zzaId) {
            this.zzaIf = false;
            flush();
        }
    }

    public void flush() {
        synchronized (this.zzaId) {
            for (Map.Entry<String, AtomicInteger> entry : this.zzaIg.entrySet()) {
                zzs(entry.getKey(), entry.getValue().get());
            }
            this.zzaIg.clear();
        }
    }

    protected abstract void zzs(String str, int i);

    public void zzw(String str, int i) {
        synchronized (this.zzaId) {
            if (!this.zzaIf) {
                this.zzaIf = true;
                this.zzaIe.postDelayed(new Runnable() { // from class: com.google.android.gms.games.internal.events.EventIncrementCache.1
                    @Override // java.lang.Runnable
                    public void run() {
                        EventIncrementCache.this.zzxl();
                    }
                }, this.zzaIh);
            }
            AtomicInteger atomicInteger = this.zzaIg.get(str);
            if (atomicInteger == null) {
                atomicInteger = new AtomicInteger();
                this.zzaIg.put(str, atomicInteger);
            }
            atomicInteger.addAndGet(i);
        }
    }
}
