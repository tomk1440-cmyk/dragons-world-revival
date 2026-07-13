package com.google.android.gms.internal;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzjk {
    public static void zza(View view, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        new zzjl(view, onGlobalLayoutListener).zzhL();
    }

    public static void zza(View view, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        new zzjm(view, onScrollChangedListener).zzhL();
    }
}
