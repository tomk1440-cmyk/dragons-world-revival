package com.chartboost.sdk.impl;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
abstract class bh<K, V> extends bc<K, V, Map<K, V>> {
    public static <K, V> a<K, V> b() {
        return new a<>();
    }

    public static class a<K, V> {
        private bc.h.a a = bc.h.a.STABLE;
        private final Map<K, V> b = new HashMap();

        a() {
        }

        public bh<K, V> a() {
            return new b(this.b, this.a);
        }
    }

    public static <K, V> bh<K, V> c() {
        return b().a();
    }

    protected bh(Map<? extends K, ? extends V> map, bc.h.a aVar) {
        super(map, aVar);
    }

    static class b<K, V> extends bh<K, V> {
        b(Map<? extends K, ? extends V> map, bc.h.a aVar) {
            super(map, aVar);
        }

        @Override // com.chartboost.sdk.impl.bc
        public <N extends Map<? extends K, ? extends V>> Map<K, V> a(N n) {
            return new HashMap(n);
        }
    }
}
