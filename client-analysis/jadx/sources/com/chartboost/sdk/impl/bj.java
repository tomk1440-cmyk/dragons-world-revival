package com.chartboost.sdk.impl;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes.dex */
public abstract class bj<T> {
    final int a;
    private Queue<T> b = new ConcurrentLinkedQueue();

    protected abstract T b();

    public bj(int i) {
        this.a = i;
    }

    protected boolean a(T t) {
        return true;
    }

    public T c() {
        T tPoll = this.b.poll();
        return tPoll != null ? tPoll : b();
    }

    public void b(T t) {
        if (a(t) && this.b.size() <= this.a) {
            this.b.add(t);
        }
    }
}
