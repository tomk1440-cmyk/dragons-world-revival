package com.google.android.gms.common;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzn;
import com.google.android.gms.drive.DriveFile;

/* JADX INFO: loaded from: classes.dex */
public class zzc {
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = zze.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    private static final zzc zzafF = new zzc();

    zzc() {
    }

    private String zzj(@Nullable Context context, @Nullable String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("gcore_");
        sb.append(GOOGLE_PLAY_SERVICES_VERSION_CODE);
        sb.append("-");
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
        }
        sb.append("-");
        if (context != null) {
            sb.append(context.getPackageName());
        }
        sb.append("-");
        if (context != null) {
            try {
                sb.append(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
            } catch (PackageManager.NameNotFoundException e) {
            }
        }
        return sb.toString();
    }

    public static zzc zzoK() {
        return zzafF;
    }

    @Nullable
    public PendingIntent getErrorResolutionPendingIntent(Context context, int errorCode, int requestCode) {
        return zza(context, errorCode, requestCode, null);
    }

    public String getErrorString(int errorCode) {
        return zze.getErrorString(errorCode);
    }

    @Nullable
    public String getOpenSourceSoftwareLicenseInfo(Context context) {
        return zze.getOpenSourceSoftwareLicenseInfo(context);
    }

    public int isGooglePlayServicesAvailable(Context context) {
        int iIsGooglePlayServicesAvailable = zze.isGooglePlayServicesAvailable(context);
        if (zze.zzd(context, iIsGooglePlayServicesAvailable)) {
            return 18;
        }
        return iIsGooglePlayServicesAvailable;
    }

    public boolean isUserResolvableError(int errorCode) {
        return zze.isUserRecoverableError(errorCode);
    }

    @Nullable
    public PendingIntent zza(Context context, int i, int i2, @Nullable String str) {
        Intent intentZza = zza(context, i, str);
        if (intentZza == null) {
            return null;
        }
        return PendingIntent.getActivity(context, i2, intentZza, DriveFile.MODE_READ_ONLY);
    }

    @Nullable
    public Intent zza(Context context, int i, @Nullable String str) {
        switch (i) {
            case 1:
            case 2:
                return zzn.zzx("com.google.android.gms", zzj(context, str));
            case 3:
                return zzn.zzcJ("com.google.android.gms");
            case 42:
                return zzn.zzqU();
            default:
                return null;
        }
    }

    public int zzaj(Context context) {
        return zze.zzaj(context);
    }

    public void zzak(Context context) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        zze.zzad(context);
    }

    public void zzal(Context context) {
        zze.zzal(context);
    }

    @Nullable
    @Deprecated
    public Intent zzbu(int i) {
        return zza(null, i, null);
    }

    public boolean zzd(Context context, int i) {
        return zze.zzd(context, i);
    }

    public boolean zzi(Context context, String str) {
        return zze.zzi(context, str);
    }
}
