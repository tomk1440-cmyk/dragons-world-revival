package com.chartboost.sdk.Libraries;

import android.graphics.Bitmap;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class a {
    private Map<String, C0003a> a = Collections.synchronizedMap(new LinkedHashMap(10, 1.5f, true));
    private long b = 0;
    private long c = 1000000;

    public a() {
        a((int) (Runtime.getRuntime().maxMemory() * 0.15f));
    }

    public void a(long j) {
        this.c = j;
    }

    public C0003a a(String str) {
        if (this.a.containsKey(str)) {
            return this.a.get(str);
        }
        return null;
    }

    public void a(String str, C0003a c0003a) {
        try {
            if (this.a.containsKey(str)) {
                this.b -= a(this.a.get(str).b());
            }
            this.a.put(str, c0003a);
            this.b += a(c0003a.b());
            b();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void b() {
        if (this.b > this.c) {
            Iterator<Map.Entry<String, C0003a>> it = this.a.entrySet().iterator();
            while (it.hasNext()) {
                this.b -= a(it.next().getValue().b());
                it.remove();
                if (this.b <= this.c) {
                    return;
                }
            }
        }
    }

    public void a() {
        this.a.clear();
    }

    private static long a(Bitmap bitmap) {
        if (bitmap == null) {
            return 0L;
        }
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    /* JADX INFO: renamed from: com.chartboost.sdk.Libraries.a$a, reason: collision with other inner class name */
    public static class C0003a {
        private Bitmap a;
        private int b;
        private float c;
        private boolean d;

        public C0003a(Bitmap bitmap, int i, float f) {
            a(bitmap);
            a(i);
            a(f);
            a(true);
        }

        public void a() {
            if (!this.d) {
                try {
                    if (this.a != null && !this.a.isRecycled()) {
                        this.a.recycle();
                    }
                } catch (Exception e) {
                }
            }
        }

        public Bitmap b() {
            return this.a;
        }

        public void a(Bitmap bitmap) {
            this.a = bitmap;
        }

        public void a(int i) {
            this.b = i;
        }

        public int c() {
            return this.a.getWidth() * this.b;
        }

        public int d() {
            return this.a.getHeight() * this.b;
        }

        public void a(boolean z) {
            this.d = z;
        }

        public void a(float f) {
            this.c = f;
        }

        public float e() {
            return this.c;
        }
    }
}
