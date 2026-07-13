package com.google.android.gms.internal;

/* JADX INFO: loaded from: classes.dex */
public final class zzsq implements Cloneable {
    private static final zzsr zzbum = new zzsr();
    private int mSize;
    private boolean zzbun;
    private int[] zzbuo;
    private zzsr[] zzbup;

    zzsq() {
        this(10);
    }

    zzsq(int i) {
        this.zzbun = false;
        int iIdealIntArraySize = idealIntArraySize(i);
        this.zzbuo = new int[iIdealIntArraySize];
        this.zzbup = new zzsr[iIdealIntArraySize];
        this.mSize = 0;
    }

    private void gc() {
        int i = this.mSize;
        int[] iArr = this.zzbuo;
        zzsr[] zzsrVarArr = this.zzbup;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            zzsr zzsrVar = zzsrVarArr[i3];
            if (zzsrVar != zzbum) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    zzsrVarArr[i2] = zzsrVar;
                    zzsrVarArr[i3] = null;
                }
                i2++;
            }
        }
        this.zzbun = false;
        this.mSize = i2;
    }

    private int idealByteArraySize(int need) {
        for (int i = 4; i < 32; i++) {
            if (need <= (1 << i) - 12) {
                return (1 << i) - 12;
            }
        }
        return need;
    }

    private int idealIntArraySize(int need) {
        return idealByteArraySize(need * 4) / 4;
    }

    private boolean zza(int[] iArr, int[] iArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (iArr[i2] != iArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    private boolean zza(zzsr[] zzsrVarArr, zzsr[] zzsrVarArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (!zzsrVarArr[i2].equals(zzsrVarArr2[i2])) {
                return false;
            }
        }
        return true;
    }

    private int zzmH(int i) {
        int i2 = 0;
        int i3 = this.mSize - 1;
        while (i2 <= i3) {
            int i4 = (i2 + i3) >>> 1;
            int i5 = this.zzbuo[i4];
            if (i5 < i) {
                i2 = i4 + 1;
            } else {
                if (i5 <= i) {
                    return i4;
                }
                i3 = i4 - 1;
            }
        }
        return i2 ^ (-1);
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof zzsq)) {
            return false;
        }
        zzsq zzsqVar = (zzsq) o;
        if (size() != zzsqVar.size()) {
            return false;
        }
        return zza(this.zzbuo, zzsqVar.zzbuo, this.mSize) && zza(this.zzbup, zzsqVar.zzbup, this.mSize);
    }

    public int hashCode() {
        if (this.zzbun) {
            gc();
        }
        int iHashCode = 17;
        for (int i = 0; i < this.mSize; i++) {
            iHashCode = (((iHashCode * 31) + this.zzbuo[i]) * 31) + this.zzbup[i].hashCode();
        }
        return iHashCode;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    int size() {
        if (this.zzbun) {
            gc();
        }
        return this.mSize;
    }

    /* JADX INFO: renamed from: zzJq, reason: merged with bridge method [inline-methods] */
    public final zzsq clone() {
        int size = size();
        zzsq zzsqVar = new zzsq(size);
        System.arraycopy(this.zzbuo, 0, zzsqVar.zzbuo, 0, size);
        for (int i = 0; i < size; i++) {
            if (this.zzbup[i] != null) {
                zzsqVar.zzbup[i] = this.zzbup[i].clone();
            }
        }
        zzsqVar.mSize = size;
        return zzsqVar;
    }

    void zza(int i, zzsr zzsrVar) {
        int iZzmH = zzmH(i);
        if (iZzmH >= 0) {
            this.zzbup[iZzmH] = zzsrVar;
            return;
        }
        int iZzmH2 = iZzmH ^ (-1);
        if (iZzmH2 < this.mSize && this.zzbup[iZzmH2] == zzbum) {
            this.zzbuo[iZzmH2] = i;
            this.zzbup[iZzmH2] = zzsrVar;
            return;
        }
        if (this.zzbun && this.mSize >= this.zzbuo.length) {
            gc();
            iZzmH2 = zzmH(i) ^ (-1);
        }
        if (this.mSize >= this.zzbuo.length) {
            int iIdealIntArraySize = idealIntArraySize(this.mSize + 1);
            int[] iArr = new int[iIdealIntArraySize];
            zzsr[] zzsrVarArr = new zzsr[iIdealIntArraySize];
            System.arraycopy(this.zzbuo, 0, iArr, 0, this.zzbuo.length);
            System.arraycopy(this.zzbup, 0, zzsrVarArr, 0, this.zzbup.length);
            this.zzbuo = iArr;
            this.zzbup = zzsrVarArr;
        }
        if (this.mSize - iZzmH2 != 0) {
            System.arraycopy(this.zzbuo, iZzmH2, this.zzbuo, iZzmH2 + 1, this.mSize - iZzmH2);
            System.arraycopy(this.zzbup, iZzmH2, this.zzbup, iZzmH2 + 1, this.mSize - iZzmH2);
        }
        this.zzbuo[iZzmH2] = i;
        this.zzbup[iZzmH2] = zzsrVar;
        this.mSize++;
    }

    zzsr zzmF(int i) {
        int iZzmH = zzmH(i);
        if (iZzmH < 0 || this.zzbup[iZzmH] == zzbum) {
            return null;
        }
        return this.zzbup[iZzmH];
    }

    zzsr zzmG(int i) {
        if (this.zzbun) {
            gc();
        }
        return this.zzbup[i];
    }
}
