package com.google.android.gms.games.internal.events;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public abstract class EventIncrementManager {
    private final AtomicReference<EventIncrementCache> zzaIj = new AtomicReference<>();

    public void flush() {
        EventIncrementCache eventIncrementCache = this.zzaIj.get();
        if (eventIncrementCache != null) {
            eventIncrementCache.flush();
        }
    }

    public void zzp(String str, int i) {
        EventIncrementCache eventIncrementCacheZzwS = this.zzaIj.get();
        if (eventIncrementCacheZzwS == null) {
            eventIncrementCacheZzwS = zzwS();
            if (!this.zzaIj.compareAndSet(null, eventIncrementCacheZzwS)) {
                eventIncrementCacheZzwS = this.zzaIj.get();
            }
        }
        eventIncrementCacheZzwS.zzw(str, i);
    }

    protected abstract EventIncrementCache zzwS();
}
