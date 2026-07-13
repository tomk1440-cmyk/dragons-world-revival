package com.google.android.gms.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class zzsr implements Cloneable {
    private zzsp<?, ?> zzbuq;
    private Object zzbur;
    private List<zzsw> zzbus = new ArrayList();

    zzsr() {
    }

    private byte[] toByteArray() throws IOException {
        byte[] bArr = new byte[zzz()];
        writeTo(zzsn.zzE(bArr));
        return bArr;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof zzsr)) {
            return false;
        }
        zzsr zzsrVar = (zzsr) o;
        if (this.zzbur == null || zzsrVar.zzbur == null) {
            if (this.zzbus != null && zzsrVar.zzbus != null) {
                return this.zzbus.equals(zzsrVar.zzbus);
            }
            try {
                return Arrays.equals(toByteArray(), zzsrVar.toByteArray());
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }
        if (this.zzbuq != zzsrVar.zzbuq) {
            return false;
        }
        if (!this.zzbuq.zzbuk.isArray()) {
            return this.zzbur.equals(zzsrVar.zzbur);
        }
        if (this.zzbur instanceof byte[]) {
            return Arrays.equals((byte[]) this.zzbur, (byte[]) zzsrVar.zzbur);
        }
        if (this.zzbur instanceof int[]) {
            return Arrays.equals((int[]) this.zzbur, (int[]) zzsrVar.zzbur);
        }
        if (this.zzbur instanceof long[]) {
            return Arrays.equals((long[]) this.zzbur, (long[]) zzsrVar.zzbur);
        }
        if (this.zzbur instanceof float[]) {
            return Arrays.equals((float[]) this.zzbur, (float[]) zzsrVar.zzbur);
        }
        if (this.zzbur instanceof double[]) {
            return Arrays.equals((double[]) this.zzbur, (double[]) zzsrVar.zzbur);
        }
        return this.zzbur instanceof boolean[] ? Arrays.equals((boolean[]) this.zzbur, (boolean[]) zzsrVar.zzbur) : Arrays.deepEquals((Object[]) this.zzbur, (Object[]) zzsrVar.zzbur);
    }

    public int hashCode() {
        try {
            return Arrays.hashCode(toByteArray()) + 527;
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    void writeTo(zzsn output) throws IOException {
        if (this.zzbur != null) {
            this.zzbuq.zza(this.zzbur, output);
            return;
        }
        Iterator<zzsw> it = this.zzbus.iterator();
        while (it.hasNext()) {
            it.next().writeTo(output);
        }
    }

    /* JADX INFO: renamed from: zzJr, reason: merged with bridge method [inline-methods] */
    public final zzsr clone() {
        zzsr zzsrVar = new zzsr();
        try {
            zzsrVar.zzbuq = this.zzbuq;
            if (this.zzbus == null) {
                zzsrVar.zzbus = null;
            } else {
                zzsrVar.zzbus.addAll(this.zzbus);
            }
            if (this.zzbur != null) {
                if (this.zzbur instanceof zzsu) {
                    zzsrVar.zzbur = ((zzsu) this.zzbur).mo4clone();
                } else if (this.zzbur instanceof byte[]) {
                    zzsrVar.zzbur = ((byte[]) this.zzbur).clone();
                } else if (this.zzbur instanceof byte[][]) {
                    byte[][] bArr = (byte[][]) this.zzbur;
                    byte[][] bArr2 = new byte[bArr.length][];
                    zzsrVar.zzbur = bArr2;
                    for (int i = 0; i < bArr.length; i++) {
                        bArr2[i] = (byte[]) bArr[i].clone();
                    }
                } else if (this.zzbur instanceof boolean[]) {
                    zzsrVar.zzbur = ((boolean[]) this.zzbur).clone();
                } else if (this.zzbur instanceof int[]) {
                    zzsrVar.zzbur = ((int[]) this.zzbur).clone();
                } else if (this.zzbur instanceof long[]) {
                    zzsrVar.zzbur = ((long[]) this.zzbur).clone();
                } else if (this.zzbur instanceof float[]) {
                    zzsrVar.zzbur = ((float[]) this.zzbur).clone();
                } else if (this.zzbur instanceof double[]) {
                    zzsrVar.zzbur = ((double[]) this.zzbur).clone();
                } else if (this.zzbur instanceof zzsu[]) {
                    zzsu[] zzsuVarArr = (zzsu[]) this.zzbur;
                    zzsu[] zzsuVarArr2 = new zzsu[zzsuVarArr.length];
                    zzsrVar.zzbur = zzsuVarArr2;
                    for (int i2 = 0; i2 < zzsuVarArr.length; i2++) {
                        zzsuVarArr2[i2] = zzsuVarArr[i2].mo4clone();
                    }
                }
            }
            return zzsrVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    void zza(zzsw zzswVar) {
        this.zzbus.add(zzswVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    <T> T zzb(zzsp<?, T> zzspVar) {
        if (this.zzbur == null) {
            this.zzbuq = zzspVar;
            this.zzbur = zzspVar.zzJ(this.zzbus);
            this.zzbus = null;
        } else if (this.zzbuq != zzspVar) {
            throw new IllegalStateException("Tried to getExtension with a differernt Extension.");
        }
        return (T) this.zzbur;
    }

    int zzz() {
        int iZzz = 0;
        if (this.zzbur != null) {
            return this.zzbuq.zzY(this.zzbur);
        }
        Iterator<zzsw> it = this.zzbus.iterator();
        while (true) {
            int i = iZzz;
            if (!it.hasNext()) {
                return i;
            }
            iZzz = it.next().zzz() + i;
        }
    }
}
