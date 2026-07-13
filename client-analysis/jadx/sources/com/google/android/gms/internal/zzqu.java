package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.gms.playlog.internal.LogEvent;
import com.google.android.gms.playlog.internal.PlayLoggerContext;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class zzqu {
    private final com.google.android.gms.playlog.internal.zzf zzbdy;
    private PlayLoggerContext zzbdz;

    public interface zza {
        void zzES();

        void zzET();

        void zzc(PendingIntent pendingIntent);
    }

    public zzqu(Context context, int i, String str, String str2, zza zzaVar, boolean z, String str3) {
        String packageName = context.getPackageName();
        int i2 = 0;
        try {
            i2 = context.getPackageManager().getPackageInfo(packageName, 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            Log.wtf("PlayLogger", "This can't happen.", e);
        }
        this.zzbdz = new PlayLoggerContext(packageName, i2, i, str, str2, z);
        this.zzbdy = new com.google.android.gms.playlog.internal.zzf(context, context.getMainLooper(), new com.google.android.gms.playlog.internal.zzd(zzaVar), new com.google.android.gms.common.internal.zzf(null, null, null, 49, null, packageName, str3, null));
    }

    public void start() {
        this.zzbdy.start();
    }

    public void stop() {
        this.zzbdy.stop();
    }

    public void zza(long j, String str, byte[] bArr, String... strArr) {
        this.zzbdy.zzb(this.zzbdz, new LogEvent(j, 0L, str, bArr, strArr));
    }

    public void zzb(String str, byte[] bArr, String... strArr) {
        zza(System.currentTimeMillis(), str, bArr, strArr);
    }
}
