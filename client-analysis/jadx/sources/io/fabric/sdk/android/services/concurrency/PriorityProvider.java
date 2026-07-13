package io.fabric.sdk.android.services.concurrency;

/* JADX INFO: loaded from: classes.dex */
public interface PriorityProvider<T> extends Comparable<T> {
    Priority getPriority();
}
