package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzmq;
import java.io.ByteArrayInputStream;
import java.security.MessageDigest;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import javax.security.auth.x500.X500Principal;

/* JADX INFO: loaded from: classes.dex */
public class zzn extends zzz {
    private static final X500Principal zzaWz = new X500Principal("CN=Android Debug,O=Android,C=US");
    private String zzSE;
    private String zzSF;
    private String zzaUa;
    private String zzaVd;
    private String zzaVi;
    private long zzaWA;

    zzn(zzw zzwVar) {
        super(zzwVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzp zzAo() {
        return super.zzAo();
    }

    String zzBk() {
        zzjv();
        return this.zzaVd;
    }

    String zzBo() {
        zzjv();
        return this.zzaVi;
    }

    long zzBp() {
        return zzCp().zzBp();
    }

    long zzBq() {
        zzjv();
        return this.zzaWA;
    }

    boolean zzCD() {
        try {
            PackageInfo packageInfo = getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 64);
            if (packageInfo != null && packageInfo.signatures != null && packageInfo.signatures.length > 0) {
                return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(packageInfo.signatures[0].toByteArray()))).getSubjectX500Principal().equals(zzaWz);
            }
        } catch (PackageManager.NameNotFoundException e) {
            zzAo().zzCE().zzj("Package name not found", e);
        } catch (CertificateException e2) {
            zzAo().zzCE().zzj("Error obtaining certificate", e2);
        }
        return true;
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ void zzCd() {
        super.zzCd();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzc zzCe() {
        return super.zzCe();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzab zzCf() {
        return super.zzCf();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzn zzCg() {
        return super.zzCg();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzg zzCh() {
        return super.zzCh();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzac zzCi() {
        return super.zzCi();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zze zzCj() {
        return super.zzCj();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzaj zzCk() {
        return super.zzCk();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzu zzCl() {
        return super.zzCl();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzad zzCm() {
        return super.zzCm();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzv zzCn() {
        return super.zzCn();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzt zzCo() {
        return super.zzCo();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzd zzCp() {
        return super.zzCp();
    }

    protected void zzba(Status status) {
        if (status == null) {
            zzAo().zzCE().zzfg("GoogleService failed to initialize (no status)");
        } else {
            zzAo().zzCE().zze("GoogleService failed to initialize, status", Integer.valueOf(status.getStatusCode()), status.getStatusMessage());
        }
    }

    AppMetadata zzfe(String str) {
        return new AppMetadata(zzwK(), zzBk(), zzli(), zzBo(), zzBp(), zzBq(), str, zzCo().zzAr(), !zzCo().zzaXx);
    }

    @Override // com.google.android.gms.measurement.internal.zzz
    protected void zziJ() {
        boolean zZzAr;
        String str = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        String string = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        PackageManager packageManager = getContext().getPackageManager();
        String packageName = getContext().getPackageName();
        String installerPackageName = packageManager.getInstallerPackageName(packageName);
        if (installerPackageName == null) {
            installerPackageName = "manual_install";
        } else if ("com.android.vending".equals(installerPackageName)) {
            installerPackageName = "";
        }
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(getContext().getPackageName(), 0);
            if (packageInfo != null) {
                CharSequence applicationLabel = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                if (!TextUtils.isEmpty(applicationLabel)) {
                    string = applicationLabel.toString();
                }
                str = packageInfo.versionName;
            }
        } catch (PackageManager.NameNotFoundException e) {
            zzAo().zzCE().zzj("Error retrieving package info: appName", string);
        }
        this.zzaUa = packageName;
        this.zzaVi = installerPackageName;
        this.zzSF = str;
        this.zzSE = string;
        MessageDigest messageDigestZzbv = zzaj.zzbv("MD5");
        if (messageDigestZzbv == null) {
            zzAo().zzCE().zzfg("Could not get MD5 instance");
            this.zzaWA = -1L;
        } else {
            this.zzaWA = 0L;
            try {
                if (!zzCD()) {
                    PackageInfo packageInfo2 = packageManager.getPackageInfo(getContext().getPackageName(), 64);
                    if (packageInfo2.signatures != null && packageInfo2.signatures.length > 0) {
                        this.zzaWA = zzaj.zzq(messageDigestZzbv.digest(packageInfo2.signatures[0].toByteArray()));
                    }
                }
            } catch (PackageManager.NameNotFoundException e2) {
                zzAo().zzCE().zzj("Package name not found", e2);
            }
        }
        Status statusZzb = zzCp().zzkr() ? com.google.android.gms.measurement.zza.zzb(getContext(), "-", true) : com.google.android.gms.measurement.zza.zzaR(getContext());
        boolean z = statusZzb != null && statusZzb.isSuccess();
        if (!z) {
            zzba(statusZzb);
        }
        if (z) {
            zZzAr = com.google.android.gms.measurement.zza.zzAr();
            if (zZzAr) {
                zzAo().zzCK().zzfg("AppMeasurement enabled");
            } else {
                zzAo().zzCI().zzfg("AppMeasurement disabled with google_app_measurement_enable=0");
            }
        } else {
            zZzAr = false;
        }
        this.zzaVd = "";
        if (zzCp().zzkr()) {
            return;
        }
        try {
            String strZzAp = com.google.android.gms.measurement.zza.zzAp();
            if (TextUtils.isEmpty(strZzAp)) {
                strZzAp = "";
            }
            this.zzaVd = strZzAp;
            if (zZzAr) {
                zzAo().zzCK().zze("App package, google app id", this.zzaUa, this.zzaVd);
            }
        } catch (IllegalStateException e3) {
            zzAo().zzCE().zzj("getGoogleAppId or isMeasurementEnabled failed with exception", e3);
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ void zzjj() {
        super.zzjj();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ void zzjk() {
        super.zzjk();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzmq zzjl() {
        return super.zzjl();
    }

    String zzli() {
        zzjv();
        return this.zzSF;
    }

    String zzwK() {
        zzjv();
        return this.zzaUa;
    }
}
