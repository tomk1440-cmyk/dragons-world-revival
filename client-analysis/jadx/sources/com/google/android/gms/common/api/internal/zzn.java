package com.google.android.gms.common.api.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.support.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
abstract class zzn extends BroadcastReceiver {
    protected Context mContext;

    zzn() {
    }

    @Nullable
    public static <T extends zzn> T zza(Context context, T t) {
        return (T) zza(context, t, com.google.android.gms.common.zzc.zzoK());
    }

    @Nullable
    public static <T extends zzn> T zza(Context context, T t, com.google.android.gms.common.zzc zzcVar) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        context.registerReceiver(t, intentFilter);
        t.mContext = context;
        if (zzcVar.zzi(context, "com.google.android.gms")) {
            return t;
        }
        t.zzpJ();
        t.unregister();
        return null;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Uri data = intent.getData();
        if ("com.google.android.gms".equals(data != null ? data.getSchemeSpecificPart() : null)) {
            zzpJ();
            unregister();
        }
    }

    public synchronized void unregister() {
        if (this.mContext != null) {
            this.mContext.unregisterReceiver(this);
        }
        this.mContext = null;
    }

    protected abstract void zzpJ();
}
