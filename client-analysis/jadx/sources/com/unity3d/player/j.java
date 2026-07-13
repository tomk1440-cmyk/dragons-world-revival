package com.unity3d.player;

/* JADX INFO: loaded from: classes.dex */
final class j {
    private static boolean a = false;
    private boolean b;
    private boolean c;
    private boolean d;
    private boolean e;

    j() {
        this.b = !f.c;
        this.c = false;
        this.d = false;
        this.e = true;
    }

    static void a() {
        a = true;
    }

    static void b() {
        a = false;
    }

    static boolean c() {
        return a;
    }

    final void a(boolean z) {
        this.c = z;
    }

    final void b(boolean z) {
        this.e = z;
    }

    final void c(boolean z) {
        this.d = z;
    }

    final void d() {
        this.b = true;
    }

    final boolean e() {
        return this.e;
    }

    final boolean f() {
        return a && this.c && this.b && !this.e && !this.d;
    }

    final boolean g() {
        return this.d;
    }

    public final String toString() {
        return super.toString();
    }
}
