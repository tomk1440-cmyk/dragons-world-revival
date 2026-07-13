package com.unity3d.player;

import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public final class f {
    static final boolean a;
    static final boolean b;
    static final boolean c;
    static final b d;

    static {
        a = Build.VERSION.SDK_INT >= 19;
        b = Build.VERSION.SDK_INT >= 21;
        boolean z = Build.VERSION.SDK_INT >= 23;
        c = z;
        d = z ? new e() : null;
    }
}
