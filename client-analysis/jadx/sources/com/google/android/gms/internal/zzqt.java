package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class zzqt implements zzqu.zza {
    private final zzqu zzbdw;
    private boolean zzbdx;

    public zzqt(Context context, int i) {
        this(context, i, null);
    }

    public zzqt(Context context, int i, String str) {
        this(context, i, str, null, true);
    }

    public zzqt(Context context, int i, String str, String str2, boolean z) {
        this.zzbdw = new zzqu(context, i, str, str2, this, z, context != context.getApplicationContext() ? context.getClass().getName() : "OneTimePlayLogger");
        this.zzbdx = true;
    }

    private void zzER() {
        if (!this.zzbdx) {
            throw new IllegalStateException("Cannot reuse one-time logger after sending.");
        }
    }

    public void send() {
        zzER();
        this.zzbdw.start();
        this.zzbdx = false;
    }

    @Override // com.google.android.gms.internal.zzqu.zza
    public void zzES() {
        this.zzbdw.stop();
    }

    @Override // com.google.android.gms.internal.zzqu.zza
    public void zzET() {
        Log.w("OneTimePlayLogger", "logger connection failed");
    }

    public void zza(String str, byte[] bArr, String... strArr) {
        zzER();
        this.zzbdw.zzb(str, bArr, strArr);
    }

    @Override // com.google.android.gms.internal.zzqu.zza
    public void zzc(PendingIntent pendingIntent) {
        Log.w("OneTimePlayLogger", "logger connection failed: " + pendingIntent);
    }
}
