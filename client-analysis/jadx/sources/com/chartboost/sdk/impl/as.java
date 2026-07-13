package com.chartboost.sdk.impl;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class as extends ar {
    private static bj<byte[]> g = new bj<byte[]>(640) { // from class: com.chartboost.sdk.impl.as.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.chartboost.sdk.impl.bj
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public byte[] b() {
            return new byte[16384];
        }
    };
    final byte[] a = new byte[16384];
    final char[] b = new char[16384];
    final List<byte[]> c = new ArrayList();
    final at d = new at();
    private final a e = new a();
    private final a f = new a();

    public as() {
        d();
    }

    public void d() {
        this.e.a();
        this.f.a();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.c.size()) {
                g.b(this.c.get(i2));
                i = i2 + 1;
            } else {
                this.c.clear();
                return;
            }
        }
    }

    @Override // com.chartboost.sdk.impl.ar
    public int a() {
        return this.e.b();
    }

    @Override // com.chartboost.sdk.impl.ar
    public void a(int i) {
        this.e.a(i);
    }

    @Override // com.chartboost.sdk.impl.ar
    public int b() {
        return this.f.b();
    }

    @Override // com.chartboost.sdk.impl.ar, java.io.OutputStream
    public void write(byte[] b) {
        write(b, 0, b.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] b, int off, int len) {
        while (len > 0) {
            byte[] bArrF = f();
            int iMin = Math.min(bArrF.length - this.e.b, len);
            System.arraycopy(b, off, bArrF, this.e.b, iMin);
            this.e.b(iMin);
            len -= iMin;
            off += iMin;
            e();
        }
    }

    @Override // com.chartboost.sdk.impl.ar, java.io.OutputStream
    public void write(int b) {
        f()[this.e.c()] = (byte) (b & 255);
        e();
    }

    void e() {
        if (this.e.b() < this.f.b()) {
            if (this.e.b == 16384) {
                this.e.d();
            }
        } else {
            this.f.a(this.e);
            if (this.f.b >= 16384) {
                this.c.add(g.c());
                this.f.d();
                this.e.a(this.f);
            }
        }
    }

    byte[] f() {
        return b(this.e.a);
    }

    byte[] b(int i) {
        return i < 0 ? this.a : this.c.get(i);
    }

    @Override // com.chartboost.sdk.impl.ar
    public int a(OutputStream outputStream) throws IOException {
        if (outputStream == null) {
            throw new NullPointerException("out is null");
        }
        int i = 0;
        for (int i2 = -1; i2 < this.c.size(); i2++) {
            byte[] bArrB = b(i2);
            int iC = this.f.c(i2);
            outputStream.write(bArrB, 0, iC);
            i += iC;
        }
        return i;
    }

    static class a {
        int a;
        int b;

        a() {
            a();
        }

        void a() {
            this.a = -1;
            this.b = 0;
        }

        void a(a aVar) {
            this.a = aVar.a;
            this.b = aVar.b;
        }

        void a(int i) {
            this.a = (i / 16384) - 1;
            this.b = i % 16384;
        }

        int b() {
            return ((this.a + 1) * 16384) + this.b;
        }

        int c() {
            int i = this.b;
            this.b = i + 1;
            return i;
        }

        void b(int i) {
            this.b += i;
            if (this.b > 16384) {
                throw new IllegalArgumentException("something is wrong");
            }
        }

        void d() {
            if (this.b != 16384) {
                throw new IllegalArgumentException("broken");
            }
            this.a++;
            this.b = 0;
        }

        int c(int i) {
            if (i < this.a) {
                return 16384;
            }
            return this.b;
        }

        public String toString() {
            return String.valueOf(this.a) + "," + this.b;
        }
    }
}
