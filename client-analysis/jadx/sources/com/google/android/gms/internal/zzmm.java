package com.google.android.gms.internal;

import android.support.v4.util.ArrayMap;
import android.support.v4.util.SimpleArrayMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class zzmm<E> extends AbstractSet<E> {
    private final ArrayMap<E, E> zzanZ;

    public zzmm() {
        this.zzanZ = new ArrayMap<>();
    }

    public zzmm(int i) {
        this.zzanZ = new ArrayMap<>(i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public zzmm(Collection<E> collection) {
        this(collection.size());
        addAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(E object) {
        if (this.zzanZ.containsKey(object)) {
            return false;
        }
        this.zzanZ.put(object, object);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        return collection instanceof zzmm ? zza((zzmm) collection) : super.addAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.zzanZ.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object object) {
        return this.zzanZ.containsKey(object);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return this.zzanZ.keySet().iterator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object object) {
        if (!this.zzanZ.containsKey(object)) {
            return false;
        }
        this.zzanZ.remove(object);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.zzanZ.size();
    }

    public boolean zza(zzmm<? extends E> zzmmVar) {
        int size = size();
        this.zzanZ.putAll((SimpleArrayMap<? extends E, ? extends E>) zzmmVar.zzanZ);
        return size() > size;
    }
}
