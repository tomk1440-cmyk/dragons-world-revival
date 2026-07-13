package com.google.android.gms.measurement;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmq;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzc {
    private final zzf zzaUi;
    private boolean zzaUj;
    private long zzaUk;
    private long zzaUl;
    private long zzaUm;
    private long zzaUn;
    private long zzaUo;
    private boolean zzaUp;
    private final Map<Class<? extends zze>, zze> zzaUq;
    private final List<zzi> zzaUr;
    private final zzmq zzqW;

    zzc(zzc zzcVar) {
        this.zzaUi = zzcVar.zzaUi;
        this.zzqW = zzcVar.zzqW;
        this.zzaUk = zzcVar.zzaUk;
        this.zzaUl = zzcVar.zzaUl;
        this.zzaUm = zzcVar.zzaUm;
        this.zzaUn = zzcVar.zzaUn;
        this.zzaUo = zzcVar.zzaUo;
        this.zzaUr = new ArrayList(zzcVar.zzaUr);
        this.zzaUq = new HashMap(zzcVar.zzaUq.size());
        for (Map.Entry<Class<? extends zze>, zze> entry : zzcVar.zzaUq.entrySet()) {
            zze zzeVarZzg = zzg(entry.getKey());
            entry.getValue().zza(zzeVarZzg);
            this.zzaUq.put(entry.getKey(), zzeVarZzg);
        }
    }

    zzc(zzf zzfVar, zzmq zzmqVar) {
        zzx.zzz(zzfVar);
        zzx.zzz(zzmqVar);
        this.zzaUi = zzfVar;
        this.zzqW = zzmqVar;
        this.zzaUn = 1800000L;
        this.zzaUo = 3024000000L;
        this.zzaUq = new HashMap();
        this.zzaUr = new ArrayList();
    }

    private static <T extends zze> T zzg(Class<T> cls) {
        try {
            return cls.newInstance();
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException("dataType default constructor is not accessible", e);
        } catch (InstantiationException e2) {
            throw new IllegalArgumentException("dataType doesn't have default constructor", e2);
        }
    }

    void zzAA() {
        this.zzaUm = this.zzqW.elapsedRealtime();
        if (this.zzaUl != 0) {
            this.zzaUk = this.zzaUl;
        } else {
            this.zzaUk = this.zzqW.currentTimeMillis();
        }
        this.zzaUj = true;
    }

    zzf zzAB() {
        return this.zzaUi;
    }

    zzg zzAC() {
        return this.zzaUi.zzAC();
    }

    boolean zzAD() {
        return this.zzaUp;
    }

    void zzAE() {
        this.zzaUp = true;
    }

    public zzc zzAu() {
        return new zzc(this);
    }

    public Collection<zze> zzAv() {
        return this.zzaUq.values();
    }

    public List<zzi> zzAw() {
        return this.zzaUr;
    }

    public long zzAx() {
        return this.zzaUk;
    }

    public void zzAy() {
        zzAC().zze(this);
    }

    public boolean zzAz() {
        return this.zzaUj;
    }

    public void zzM(long j) {
        this.zzaUl = j;
    }

    public void zzb(zze zzeVar) {
        zzx.zzz(zzeVar);
        Class<?> cls = zzeVar.getClass();
        if (cls.getSuperclass() != zze.class) {
            throw new IllegalArgumentException();
        }
        zzeVar.zza(zzf(cls));
    }

    public <T extends zze> T zze(Class<T> cls) {
        return (T) this.zzaUq.get(cls);
    }

    public <T extends zze> T zzf(Class<T> cls) {
        T t = (T) this.zzaUq.get(cls);
        if (t != null) {
            return t;
        }
        T t2 = (T) zzg(cls);
        this.zzaUq.put((Class<? extends zze>) cls, t2);
        return t2;
    }
}
