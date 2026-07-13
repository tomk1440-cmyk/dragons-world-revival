package com.chartboost.sdk.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class bf<T> {
    private final Map<Class<?>, T> a = bh.c();
    private final Map<Class<?>, T> b = bg.a((bi) new a(this, null));

    public static <T> List<Class<?>> a(Class<T> cls) {
        return be.a(cls);
    }

    private final class a implements bi<Class<?>, T> {
        private a() {
        }

        /* synthetic */ a(bf bfVar, a aVar) {
            this();
        }

        @Override // com.chartboost.sdk.impl.bi
        public T a(Class<?> cls) {
            Iterator<Class<?>> it = bf.a((Class) cls).iterator();
            while (it.hasNext()) {
                T t = (T) bf.this.a.get(it.next());
                if (t != null) {
                    return t;
                }
            }
            return null;
        }
    }

    public T a(Object obj) {
        return this.b.get(obj);
    }

    public T a(Class<?> cls, T t) {
        try {
            return this.a.put(cls, t);
        } finally {
            this.b.clear();
        }
    }

    public int a() {
        return this.a.size();
    }
}
