package com.google.android.gms.internal;

import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzsu {
    protected volatile int zzbuu = -1;

    public static final <T extends zzsu> T mergeFrom(T t, byte[] bArr) throws zzst {
        return (T) mergeFrom(t, bArr, 0, bArr.length);
    }

    public static final <T extends zzsu> T mergeFrom(T msg, byte[] data, int off, int len) throws zzst {
        try {
            zzsm zzsmVarZza = zzsm.zza(data, off, len);
            msg.mergeFrom(zzsmVarZza);
            zzsmVarZza.zzmn(0);
            return msg;
        } catch (zzst e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
    }

    public static final boolean messageNanoEquals(zzsu a, zzsu b) {
        int serializedSize;
        if (a == b) {
            return true;
        }
        if (a == null || b == null || a.getClass() != b.getClass() || b.getSerializedSize() != (serializedSize = a.getSerializedSize())) {
            return false;
        }
        byte[] bArr = new byte[serializedSize];
        byte[] bArr2 = new byte[serializedSize];
        toByteArray(a, bArr, 0, serializedSize);
        toByteArray(b, bArr2, 0, serializedSize);
        return Arrays.equals(bArr, bArr2);
    }

    public static final void toByteArray(zzsu msg, byte[] data, int offset, int length) {
        try {
            zzsn zzsnVarZzb = zzsn.zzb(data, offset, length);
            msg.writeTo(zzsnVarZzb);
            zzsnVarZzb.zzJo();
        } catch (IOException e) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
        }
    }

    public static final byte[] toByteArray(zzsu msg) {
        byte[] bArr = new byte[msg.getSerializedSize()];
        toByteArray(msg, bArr, 0, bArr.length);
        return bArr;
    }

    @Override // 
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public zzsu mo4clone() throws CloneNotSupportedException {
        return (zzsu) super.clone();
    }

    public int getCachedSize() {
        if (this.zzbuu < 0) {
            getSerializedSize();
        }
        return this.zzbuu;
    }

    public int getSerializedSize() {
        int iZzz = zzz();
        this.zzbuu = iZzz;
        return iZzz;
    }

    public abstract zzsu mergeFrom(zzsm zzsmVar) throws IOException;

    public String toString() {
        return zzsv.zzf(this);
    }

    public void writeTo(zzsn output) throws IOException {
    }

    protected int zzz() {
        return 0;
    }
}
