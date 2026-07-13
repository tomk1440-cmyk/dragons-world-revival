package com.google.android.gms.internal;

import android.util.Log;
import com.google.ads.AdRequest;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public final class zzin extends com.google.android.gms.ads.internal.util.client.zzb {
    public static void v(String msg) {
        if (zzhp()) {
            Log.v(AdRequest.LOGTAG, msg);
        }
    }

    public static boolean zzho() {
        return zzbt.zzwK.get().booleanValue();
    }

    private static boolean zzhp() {
        return zzQ(2) && zzho();
    }
}
