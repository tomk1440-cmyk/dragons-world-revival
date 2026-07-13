package com.google.android.gms.internal;

import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
final class zzsw {
    final int tag;
    final byte[] zzbuv;

    zzsw(int i, byte[] bArr) {
        this.tag = i;
        this.zzbuv = bArr;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof zzsw)) {
            return false;
        }
        zzsw zzswVar = (zzsw) o;
        return this.tag == zzswVar.tag && Arrays.equals(this.zzbuv, zzswVar.zzbuv);
    }

    public int hashCode() {
        return ((this.tag + 527) * 31) + Arrays.hashCode(this.zzbuv);
    }

    void writeTo(zzsn output) throws IOException {
        output.zzmB(this.tag);
        output.zzH(this.zzbuv);
    }

    int zzz() {
        return 0 + zzsn.zzmC(this.tag) + this.zzbuv.length;
    }
}
