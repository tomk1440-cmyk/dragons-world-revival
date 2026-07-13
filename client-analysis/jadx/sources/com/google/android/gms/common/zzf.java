package com.google.android.gms.common;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Base64;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class zzf {
    private static final zzf zzafS = new zzf();

    private zzf() {
    }

    public static zzf zzoO() {
        return zzafS;
    }

    zzd.zza zza(PackageInfo packageInfo, zzd.zza... zzaVarArr) {
        if (packageInfo.signatures.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        zzd.zzb zzbVar = new zzd.zzb(packageInfo.signatures[0].toByteArray());
        for (int i = 0; i < zzaVarArr.length; i++) {
            if (zzaVarArr[i].equals(zzbVar)) {
                return zzaVarArr[i];
            }
        }
        if (Log.isLoggable("GoogleSignatureVerifier", 2)) {
            Log.v("GoogleSignatureVerifier", "Signature not valid.  Found: \n" + Base64.encodeToString(zzbVar.getBytes(), 0));
        }
        return null;
    }

    public boolean zza(PackageInfo packageInfo, boolean z) {
        if (packageInfo != null && packageInfo.signatures != null) {
            if ((z ? zza(packageInfo, zzd.C0059zzd.zzafK) : zza(packageInfo, zzd.C0059zzd.zzafK[0])) != null) {
                return true;
            }
        }
        return false;
    }

    public boolean zza(PackageManager packageManager, PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (zze.zzc(packageManager)) {
            return zza(packageInfo, true);
        }
        boolean zZza = zza(packageInfo, false);
        if (zZza || !zza(packageInfo, true)) {
            return zZza;
        }
        Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        return zZza;
    }
}
