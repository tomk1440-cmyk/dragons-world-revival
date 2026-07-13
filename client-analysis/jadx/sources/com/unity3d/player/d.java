package com.unity3d.player;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
final class d {
    protected static boolean a = false;

    protected static void Log(int i, String str) {
        if (a) {
            return;
        }
        if (i == 6) {
            Log.e("Unity", str);
        }
        if (i == 5) {
            Log.w("Unity", str);
        }
    }
}
