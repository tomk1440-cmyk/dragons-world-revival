package com.chartboost.sdk.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes.dex */
abstract class bc<K, V, M extends Map<K, V>> implements Serializable, ConcurrentMap<K, V> {
    private volatile M a;
    private final transient Lock b = new ReentrantLock();
    private final h<K, V> c;

    abstract <N extends Map<? extends K, ? extends V>> M a(N n);

    protected <N extends Map<? extends K, ? extends V>> bc(N n, h.a aVar) {
        this.a = (M) bd.a("delegate", a((Map) bd.a("map", n)));
        this.c = ((h.a) bd.a("viewType", aVar)).a(this);
    }

    @Override // java.util.Map
    public final void clear() {
        this.b.lock();
        try {
            b(a(Collections.emptyMap()));
        } finally {
            this.b.unlock();
        }
    }

    @Override // java.util.Map
    public final V remove(Object obj) {
        this.b.lock();
        try {
            if (this.a.containsKey(obj)) {
                Map mapA = a();
                try {
                    V v = (V) mapA.remove(obj);
                    b(mapA);
                    this.b.unlock();
                    return v;
                } catch (Throwable th) {
                    b(mapA);
                    throw th;
                }
            }
            this.b.unlock();
            return null;
        } catch (Throwable th2) {
            this.b.unlock();
            throw th2;
        }
    }

    @Override // java.util.concurrent.ConcurrentMap, java.util.Map
    public boolean remove(Object key, Object value) {
        Lock lock;
        this.b.lock();
        try {
            if (this.a.containsKey(key) && a(value, this.a.get(key))) {
                Map mapA = a();
                mapA.remove(key);
                b(mapA);
                return true;
            }
            return false;
        } finally {
            this.b.unlock();
        }
    }

    @Override // java.util.concurrent.ConcurrentMap, java.util.Map
    public boolean replace(K key, V oldValue, V newValue) {
        Lock lock;
        this.b.lock();
        try {
            if (this.a.containsKey(key) && a(oldValue, this.a.get(key))) {
                Map mapA = a();
                mapA.put(key, newValue);
                b(mapA);
                return true;
            }
            return false;
        } finally {
            this.b.unlock();
        }
    }

    @Override // java.util.concurrent.ConcurrentMap, java.util.Map
    public V replace(K k, V v) {
        this.b.lock();
        try {
            if (this.a.containsKey(k)) {
                Map mapA = a();
                try {
                    V v2 = (V) mapA.put(k, v);
                    b(mapA);
                    this.b.unlock();
                    return v2;
                } catch (Throwable th) {
                    b(mapA);
                    throw th;
                }
            }
            this.b.unlock();
            return null;
        } catch (Throwable th2) {
            this.b.unlock();
            throw th2;
        }
    }

    @Override // java.util.Map
    public final V put(K k, V v) {
        this.b.lock();
        try {
            Map mapA = a();
            try {
                V v2 = (V) mapA.put(k, v);
                b(mapA);
                this.b.unlock();
                return v2;
            } catch (Throwable th) {
                b(mapA);
                throw th;
            }
        } catch (Throwable th2) {
            this.b.unlock();
            throw th2;
        }
    }

    @Override // java.util.concurrent.ConcurrentMap, java.util.Map
    public V putIfAbsent(K k, V v) {
        V v2;
        this.b.lock();
        try {
            if (!this.a.containsKey(k)) {
                Map mapA = a();
                try {
                    v2 = (V) mapA.put(k, v);
                    b(mapA);
                    this.b.unlock();
                } catch (Throwable th) {
                    b(mapA);
                    throw th;
                }
            } else {
                v2 = (V) this.a.get(k);
                this.b.unlock();
            }
            return v2;
        } catch (Throwable th2) {
            this.b.unlock();
            throw th2;
        }
    }

    @Override // java.util.Map
    public final void putAll(Map<? extends K, ? extends V> t) {
        this.b.lock();
        try {
            Map mapA = a();
            mapA.putAll(t);
            b(mapA);
        } finally {
            this.b.unlock();
        }
    }

    protected M a() {
        this.b.lock();
        try {
            return (M) a(this.a);
        } finally {
            this.b.unlock();
        }
    }

    protected void b(M m) {
        this.a = m;
    }

    @Override // java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        return this.c.b();
    }

    @Override // java.util.Map
    public final Set<K> keySet() {
        return this.c.a();
    }

    @Override // java.util.Map
    public final Collection<V> values() {
        return this.c.c();
    }

    @Override // java.util.Map
    public final boolean containsKey(Object key) {
        return this.a.containsKey(key);
    }

    @Override // java.util.Map
    public final boolean containsValue(Object value) {
        return this.a.containsValue(value);
    }

    @Override // java.util.Map
    public final V get(Object obj) {
        return (V) this.a.get(obj);
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return this.a.isEmpty();
    }

    @Override // java.util.Map
    public final int size() {
        return this.a.size();
    }

    @Override // java.util.Map
    public final boolean equals(Object o) {
        return this.a.equals(o);
    }

    @Override // java.util.Map
    public final int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return this.a.toString();
    }

    private class d extends a<K> implements Set<K> {
        private d() {
        }

        /* synthetic */ d(bc bcVar, d dVar) {
            this();
        }

        @Override // com.chartboost.sdk.impl.bc.a
        Collection<K> a() {
            return bc.this.a.keySet();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Collection, java.util.Set
        public void clear() {
            bc.this.b.lock();
            try {
                Map mapA = bc.this.a();
                mapA.keySet().clear();
                bc.this.b(mapA);
            } finally {
                bc.this.b.unlock();
            }
        }

        @Override // java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            return bc.this.remove(o) != null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> c) {
            bc.this.b.lock();
            try {
                Map mapA = bc.this.a();
                try {
                    boolean zRemoveAll = mapA.keySet().removeAll(c);
                    bc.this.b(mapA);
                    bc.this.b.unlock();
                    return zRemoveAll;
                } catch (Throwable th) {
                    bc.this.b(mapA);
                    throw th;
                }
            } catch (Throwable th2) {
                bc.this.b.unlock();
                throw th2;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> c) {
            bc.this.b.lock();
            try {
                Map mapA = bc.this.a();
                try {
                    boolean zRetainAll = mapA.keySet().retainAll(c);
                    bc.this.b(mapA);
                    bc.this.b.unlock();
                    return zRetainAll;
                } catch (Throwable th) {
                    bc.this.b(mapA);
                    throw th;
                }
            } catch (Throwable th2) {
                bc.this.b.unlock();
                throw th2;
            }
        }
    }

    private final class g extends a<V> {
        private g() {
        }

        /* synthetic */ g(bc bcVar, g gVar) {
            this();
        }

        @Override // com.chartboost.sdk.impl.bc.a
        Collection<V> a() {
            return bc.this.a.values();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Collection
        public void clear() {
            bc.this.b.lock();
            try {
                Map mapA = bc.this.a();
                mapA.values().clear();
                bc.this.b(mapA);
            } finally {
                bc.this.b.unlock();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Collection
        public boolean remove(Object o) {
            bc.this.b.lock();
            try {
                if (!contains(o)) {
                    bc.this.b.unlock();
                    return false;
                }
                Map mapA = bc.this.a();
                try {
                    boolean zRemove = mapA.values().remove(o);
                    bc.this.b(mapA);
                    bc.this.b.unlock();
                    return zRemove;
                } catch (Throwable th) {
                    bc.this.b(mapA);
                    throw th;
                }
            } catch (Throwable th2) {
                bc.this.b.unlock();
                throw th2;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Collection
        public boolean removeAll(Collection<?> c) {
            bc.this.b.lock();
            try {
                Map mapA = bc.this.a();
                try {
                    boolean zRemoveAll = mapA.values().removeAll(c);
                    bc.this.b(mapA);
                    bc.this.b.unlock();
                    return zRemoveAll;
                } catch (Throwable th) {
                    bc.this.b(mapA);
                    throw th;
                }
            } catch (Throwable th2) {
                bc.this.b.unlock();
                throw th2;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Collection
        public boolean retainAll(Collection<?> c) {
            bc.this.b.lock();
            try {
                Map mapA = bc.this.a();
                try {
                    boolean zRetainAll = mapA.values().retainAll(c);
                    bc.this.b(mapA);
                    bc.this.b.unlock();
                    return zRetainAll;
                } catch (Throwable th) {
                    bc.this.b(mapA);
                    throw th;
                }
            } catch (Throwable th2) {
                bc.this.b.unlock();
                throw th2;
            }
        }
    }

    private class b extends a<Map.Entry<K, V>> implements Set<Map.Entry<K, V>> {
        private b() {
        }

        /* synthetic */ b(bc bcVar, b bVar) {
            this();
        }

        @Override // com.chartboost.sdk.impl.bc.a
        Collection<Map.Entry<K, V>> a() {
            return bc.this.a.entrySet();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Collection, java.util.Set
        public void clear() {
            bc.this.b.lock();
            try {
                Map mapA = bc.this.a();
                mapA.entrySet().clear();
                bc.this.b(mapA);
            } finally {
                bc.this.b.unlock();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            bc.this.b.lock();
            try {
                if (!contains(o)) {
                    bc.this.b.unlock();
                    return false;
                }
                Map mapA = bc.this.a();
                try {
                    boolean zRemove = mapA.entrySet().remove(o);
                    bc.this.b(mapA);
                    bc.this.b.unlock();
                    return zRemove;
                } catch (Throwable th) {
                    bc.this.b(mapA);
                    throw th;
                }
            } catch (Throwable th2) {
                bc.this.b.unlock();
                throw th2;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> c) {
            bc.this.b.lock();
            try {
                Map mapA = bc.this.a();
                try {
                    boolean zRemoveAll = mapA.entrySet().removeAll(c);
                    bc.this.b(mapA);
                    bc.this.b.unlock();
                    return zRemoveAll;
                } catch (Throwable th) {
                    bc.this.b(mapA);
                    throw th;
                }
            } catch (Throwable th2) {
                bc.this.b.unlock();
                throw th2;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> c) {
            bc.this.b.lock();
            try {
                Map mapA = bc.this.a();
                try {
                    boolean zRetainAll = mapA.entrySet().retainAll(c);
                    bc.this.b(mapA);
                    bc.this.b.unlock();
                    return zRetainAll;
                } catch (Throwable th) {
                    bc.this.b(mapA);
                    throw th;
                }
            } catch (Throwable th2) {
                bc.this.b.unlock();
                throw th2;
            }
        }
    }

    private static class f<T> implements Iterator<T> {
        private final Iterator<T> a;

        public f(Iterator<T> it) {
            this.a = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            return this.a.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    protected static abstract class a<E> implements Collection<E> {
        abstract Collection<E> a();

        protected a() {
        }

        @Override // java.util.Collection
        public final boolean contains(Object o) {
            return a().contains(o);
        }

        @Override // java.util.Collection
        public final boolean containsAll(Collection<?> c) {
            return a().containsAll(c);
        }

        @Override // java.util.Collection, java.lang.Iterable
        public final Iterator<E> iterator() {
            return new f(a().iterator());
        }

        @Override // java.util.Collection
        public final boolean isEmpty() {
            return a().isEmpty();
        }

        @Override // java.util.Collection
        public final int size() {
            return a().size();
        }

        @Override // java.util.Collection
        public final Object[] toArray() {
            return a().toArray();
        }

        @Override // java.util.Collection
        public final <T> T[] toArray(T[] tArr) {
            return (T[]) a().toArray(tArr);
        }

        @Override // java.util.Collection
        public int hashCode() {
            return a().hashCode();
        }

        @Override // java.util.Collection
        public boolean equals(Object obj) {
            return a().equals(obj);
        }

        public String toString() {
            return a().toString();
        }

        @Override // java.util.Collection
        public final boolean add(E o) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public final boolean addAll(Collection<? extends E> c) {
            throw new UnsupportedOperationException();
        }
    }

    private boolean a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public static abstract class h<K, V> {
        abstract Set<K> a();

        abstract Set<Map.Entry<K, V>> b();

        abstract Collection<V> c();

        h() {
        }

        public enum a {
            STABLE { // from class: com.chartboost.sdk.impl.bc.h.a.1
                @Override // com.chartboost.sdk.impl.bc.h.a
                <K, V, M extends Map<K, V>> h<K, V> a(bc<K, V, M> bcVar) {
                    bcVar.getClass();
                    return bcVar.new c();
                }
            },
            LIVE { // from class: com.chartboost.sdk.impl.bc.h.a.2
                @Override // com.chartboost.sdk.impl.bc.h.a
                <K, V, M extends Map<K, V>> h<K, V> a(bc<K, V, M> bcVar) {
                    bcVar.getClass();
                    return bcVar.new e();
                }
            };

            /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
            public static a[] valuesCustom() {
                a[] aVarArrValuesCustom = values();
                int length = aVarArrValuesCustom.length;
                a[] aVarArr = new a[length];
                System.arraycopy(aVarArrValuesCustom, 0, aVarArr, 0, length);
                return aVarArr;
            }

            abstract <K, V, M extends Map<K, V>> h<K, V> a(bc<K, V, M> bcVar);

            /* synthetic */ a(a aVar) {
                this();
            }
        }
    }

    final class c extends h<K, V> implements Serializable {
        c() {
        }

        @Override // com.chartboost.sdk.impl.bc.h
        public Set<K> a() {
            return Collections.unmodifiableSet(bc.this.a.keySet());
        }

        @Override // com.chartboost.sdk.impl.bc.h
        public Set<Map.Entry<K, V>> b() {
            return Collections.unmodifiableSet(bc.this.a.entrySet());
        }

        @Override // com.chartboost.sdk.impl.bc.h
        public Collection<V> c() {
            return Collections.unmodifiableCollection(bc.this.a.values());
        }
    }

    final class e extends h<K, V> implements Serializable {
        private final transient bc<K, V, M>.d b;
        private final transient bc<K, V, M>.b c;
        private final transient bc<K, V, M>.g d;

        /* JADX WARN: Multi-variable type inference failed */
        e() {
            this.b = new d(bc.this, null);
            this.c = new b(bc.this, 0 == true ? 1 : 0);
            this.d = new g(bc.this, 0 == true ? 1 : 0);
        }

        @Override // com.chartboost.sdk.impl.bc.h
        public Set<K> a() {
            return this.b;
        }

        @Override // com.chartboost.sdk.impl.bc.h
        public Set<Map.Entry<K, V>> b() {
            return this.c;
        }

        @Override // com.chartboost.sdk.impl.bc.h
        public Collection<V> c() {
            return this.d;
        }
    }
}
