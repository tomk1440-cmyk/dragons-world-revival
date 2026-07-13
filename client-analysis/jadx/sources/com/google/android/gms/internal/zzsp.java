package com.google.android.gms.internal;

import com.google.android.gms.internal.zzso;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class zzsp<M extends zzso<M>, T> {
    public final int tag;
    protected final int type;
    protected final Class<T> zzbuk;
    protected final boolean zzbul;

    private zzsp(int i, Class<T> cls, int i2, boolean z) {
        this.type = i;
        this.zzbuk = cls;
        this.tag = i2;
        this.zzbul = z;
    }

    private T zzK(List<zzsw> list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            zzsw zzswVar = list.get(i);
            if (zzswVar.zzbuv.length != 0) {
                zza(zzswVar, arrayList);
            }
        }
        int size = arrayList.size();
        if (size == 0) {
            return null;
        }
        T tCast = this.zzbuk.cast(Array.newInstance(this.zzbuk.getComponentType(), size));
        for (int i2 = 0; i2 < size; i2++) {
            Array.set(tCast, i2, arrayList.get(i2));
        }
        return tCast;
    }

    private T zzL(List<zzsw> list) {
        if (list.isEmpty()) {
            return null;
        }
        return this.zzbuk.cast(zzP(zzsm.zzD(list.get(list.size() - 1).zzbuv)));
    }

    public static <M extends zzso<M>, T extends zzsu> zzsp<M, T> zza(int i, Class<T> cls, long j) {
        return new zzsp<>(i, cls, (int) j, false);
    }

    final T zzJ(List<zzsw> list) {
        if (list == null) {
            return null;
        }
        return this.zzbul ? zzK(list) : zzL(list);
    }

    protected Object zzP(zzsm zzsmVar) {
        Class componentType = this.zzbul ? this.zzbuk.getComponentType() : this.zzbuk;
        try {
            switch (this.type) {
                case 10:
                    zzsu zzsuVar = (zzsu) componentType.newInstance();
                    zzsmVar.zza(zzsuVar, zzsx.zzmJ(this.tag));
                    return zzsuVar;
                case 11:
                    zzsu zzsuVar2 = (zzsu) componentType.newInstance();
                    zzsmVar.zza(zzsuVar2);
                    return zzsuVar2;
                default:
                    throw new IllegalArgumentException("Unknown type " + this.type);
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Error reading extension field", e);
        } catch (IllegalAccessException e2) {
            throw new IllegalArgumentException("Error creating instance of class " + componentType, e2);
        } catch (InstantiationException e3) {
            throw new IllegalArgumentException("Error creating instance of class " + componentType, e3);
        }
    }

    int zzY(Object obj) {
        return this.zzbul ? zzZ(obj) : zzaa(obj);
    }

    protected int zzZ(Object obj) {
        int iZzaa = 0;
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            if (Array.get(obj, i) != null) {
                iZzaa += zzaa(Array.get(obj, i));
            }
        }
        return iZzaa;
    }

    protected void zza(zzsw zzswVar, List<Object> list) {
        list.add(zzP(zzsm.zzD(zzswVar.zzbuv)));
    }

    void zza(Object obj, zzsn zzsnVar) throws IOException {
        if (this.zzbul) {
            zzc(obj, zzsnVar);
        } else {
            zzb(obj, zzsnVar);
        }
    }

    protected int zzaa(Object obj) {
        int iZzmJ = zzsx.zzmJ(this.tag);
        switch (this.type) {
            case 10:
                return zzsn.zzb(iZzmJ, (zzsu) obj);
            case 11:
                return zzsn.zzc(iZzmJ, (zzsu) obj);
            default:
                throw new IllegalArgumentException("Unknown type " + this.type);
        }
    }

    protected void zzb(Object obj, zzsn zzsnVar) {
        try {
            zzsnVar.zzmB(this.tag);
            switch (this.type) {
                case 10:
                    int iZzmJ = zzsx.zzmJ(this.tag);
                    zzsnVar.zzb((zzsu) obj);
                    zzsnVar.zzE(iZzmJ, 4);
                    return;
                case 11:
                    zzsnVar.zzc((zzsu) obj);
                    return;
                default:
                    throw new IllegalArgumentException("Unknown type " + this.type);
            }
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    protected void zzc(Object obj, zzsn zzsnVar) {
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            Object obj2 = Array.get(obj, i);
            if (obj2 != null) {
                zzb(obj2, zzsnVar);
            }
        }
    }
}
