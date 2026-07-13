package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.WorkerThread;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.internal.zzmq;
import com.google.android.gms.internal.zzqa;
import com.google.android.gms.internal.zzqb;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.measurement.AppMeasurementReceiver;
import com.google.android.gms.measurement.AppMeasurementService;
import com.unity3d.ads.metadata.InAppPurchaseMetaData;
import io.fabric.sdk.android.services.common.AbstractSpiCall;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class zzw {
    private static zzaa zzaXV;
    private static volatile zzw zzaXW;
    private final Context mContext;
    private final boolean zzQk;
    private final zzd zzaXX;
    private final zzt zzaXY;
    private final zzp zzaXZ;
    private final zzv zzaYa;
    private final zzad zzaYb;
    private final zzu zzaYc;
    private final AppMeasurement zzaYd;
    private final zzaj zzaYe;
    private final zze zzaYf;
    private final zzq zzaYg;
    private final zzac zzaYh;
    private final zzg zzaYi;
    private final zzab zzaYj;
    private final zzn zzaYk;
    private final zzr zzaYl;
    private final zzag zzaYm;
    private final zzc zzaYn;
    private Boolean zzaYo;
    private List<Long> zzaYp;
    private int zzaYq;
    private int zzaYr;
    private final zzmq zzqW;

    private class zza implements zze.zzb {
        zzqb.zze zzaYt;
        List<Long> zzaYu;
        long zzaYv;
        List<zzqb.zzb> zzpH;

        private zza() {
        }

        private long zza(zzqb.zzb zzbVar) {
            return ((zzbVar.zzbaf.longValue() / 1000) / 60) / 60;
        }

        boolean isEmpty() {
            return this.zzpH == null || this.zzpH.isEmpty();
        }

        @Override // com.google.android.gms.measurement.internal.zze.zzb
        public boolean zza(long j, zzqb.zzb zzbVar) {
            com.google.android.gms.common.internal.zzx.zzz(zzbVar);
            if (this.zzpH == null) {
                this.zzpH = new ArrayList();
            }
            if (this.zzaYu == null) {
                this.zzaYu = new ArrayList();
            }
            if (this.zzpH.size() > 0 && zza(this.zzpH.get(0)) != zza(zzbVar)) {
                return false;
            }
            long serializedSize = this.zzaYv + ((long) zzbVar.getSerializedSize());
            if (serializedSize >= zzw.this.zzCp().zzBT()) {
                return false;
            }
            this.zzaYv = serializedSize;
            this.zzpH.add(zzbVar);
            this.zzaYu.add(Long.valueOf(j));
            return this.zzpH.size() < zzw.this.zzCp().zzBU();
        }

        @Override // com.google.android.gms.measurement.internal.zze.zzb
        public void zzc(zzqb.zze zzeVar) {
            com.google.android.gms.common.internal.zzx.zzz(zzeVar);
            this.zzaYt = zzeVar;
        }
    }

    zzw(zzaa zzaaVar) {
        com.google.android.gms.common.internal.zzx.zzz(zzaaVar);
        this.mContext = zzaaVar.mContext;
        this.zzqW = zzaaVar.zzl(this);
        this.zzaXX = zzaaVar.zza(this);
        zzt zztVarZzb = zzaaVar.zzb(this);
        zztVarZzb.zza();
        this.zzaXY = zztVarZzb;
        zzp zzpVarZzc = zzaaVar.zzc(this);
        zzpVarZzc.zza();
        this.zzaXZ = zzpVarZzc;
        zzAo().zzCI().zzj("App measurement is starting up, version", Long.valueOf(zzCp().zzBp()));
        zzAo().zzCI().zzfg("To enable debug logging run: adb shell setprop log.tag.GMPM VERBOSE");
        zzAo().zzCJ().zzfg("Debug logging enabled");
        this.zzaYe = zzaaVar.zzi(this);
        zzg zzgVarZzn = zzaaVar.zzn(this);
        zzgVarZzn.zza();
        this.zzaYi = zzgVarZzn;
        zzn zznVarZzo = zzaaVar.zzo(this);
        zznVarZzo.zza();
        this.zzaYk = zznVarZzo;
        zze zzeVarZzj = zzaaVar.zzj(this);
        zzeVarZzj.zza();
        this.zzaYf = zzeVarZzj;
        zzc zzcVarZzr = zzaaVar.zzr(this);
        zzcVarZzr.zza();
        this.zzaYn = zzcVarZzr;
        zzq zzqVarZzk = zzaaVar.zzk(this);
        zzqVarZzk.zza();
        this.zzaYg = zzqVarZzk;
        zzac zzacVarZzm = zzaaVar.zzm(this);
        zzacVarZzm.zza();
        this.zzaYh = zzacVarZzm;
        zzab zzabVarZzh = zzaaVar.zzh(this);
        zzabVarZzh.zza();
        this.zzaYj = zzabVarZzh;
        zzag zzagVarZzq = zzaaVar.zzq(this);
        zzagVarZzq.zza();
        this.zzaYm = zzagVarZzq;
        this.zzaYl = zzaaVar.zzp(this);
        this.zzaYd = zzaaVar.zzg(this);
        zzad zzadVarZze = zzaaVar.zze(this);
        zzadVarZze.zza();
        this.zzaYb = zzadVarZze;
        zzu zzuVarZzf = zzaaVar.zzf(this);
        zzuVarZzf.zza();
        this.zzaYc = zzuVarZzf;
        zzv zzvVarZzd = zzaaVar.zzd(this);
        zzvVarZzd.zza();
        this.zzaYa = zzvVarZzd;
        if (this.zzaYq != this.zzaYr) {
            zzAo().zzCE().zze("Not all components initialized", Integer.valueOf(this.zzaYq), Integer.valueOf(this.zzaYr));
        }
        this.zzQk = true;
        if (!this.zzaXX.zzkr() && !zzCZ()) {
            if (!(this.mContext.getApplicationContext() instanceof Application)) {
                zzAo().zzCF().zzfg("Application context is not an Application");
            } else if (Build.VERSION.SDK_INT >= 14) {
                zzCf().zzDk();
            } else {
                zzAo().zzCJ().zzfg("Not tracking deep linking pre-ICS");
            }
        }
        this.zzaYa.zzg(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzw.1
            @Override // java.lang.Runnable
            public void run() {
                zzw.this.start();
            }
        });
    }

    private void zzA(List<Long> list) {
        com.google.android.gms.common.internal.zzx.zzac(!list.isEmpty());
        if (this.zzaYp != null) {
            zzAo().zzCE().zzfg("Set uploading progress before finishing the previous upload");
        } else {
            this.zzaYp = new ArrayList(list);
        }
    }

    @WorkerThread
    private boolean zzDb() {
        zzjk();
        return this.zzaYp != null;
    }

    private boolean zzDd() {
        zzjk();
        zzjv();
        return zzCj().zzCv() || !TextUtils.isEmpty(zzCj().zzCq());
    }

    @WorkerThread
    private void zzDe() {
        zzjk();
        zzjv();
        if (!zzCS() || !zzDd()) {
            zzCX().unregister();
            zzCY().cancel();
            return;
        }
        long jZzDf = zzDf();
        if (jZzDf == 0) {
            zzCX().unregister();
            zzCY().cancel();
            return;
        }
        if (!zzCW().zzlB()) {
            zzCX().zzly();
            zzCY().cancel();
            return;
        }
        long j = zzCo().zzaXl.get();
        long jZzBX = zzCp().zzBX();
        if (!zzCk().zzc(j, jZzBX)) {
            jZzDf = Math.max(jZzDf, j + jZzBX);
        }
        zzCX().unregister();
        long jCurrentTimeMillis = jZzDf - zzjl().currentTimeMillis();
        if (jCurrentTimeMillis <= 0) {
            zzCY().zzt(1L);
        } else {
            zzAo().zzCK().zzj("Upload scheduled in approximately ms", Long.valueOf(jCurrentTimeMillis));
            zzCY().zzt(jCurrentTimeMillis);
        }
    }

    private long zzDf() {
        long jCurrentTimeMillis = zzjl().currentTimeMillis();
        long jZzCa = zzCp().zzCa();
        long jZzBY = zzCp().zzBY();
        long j = zzCo().zzaXj.get();
        long j2 = zzCo().zzaXk.get();
        long jMax = Math.max(zzCj().zzCt(), zzCj().zzCu());
        if (jMax == 0) {
            return 0L;
        }
        long jAbs = jCurrentTimeMillis - Math.abs(jMax - jCurrentTimeMillis);
        long jAbs2 = jCurrentTimeMillis - Math.abs(j - jCurrentTimeMillis);
        long jAbs3 = jCurrentTimeMillis - Math.abs(j2 - jCurrentTimeMillis);
        long jMax2 = Math.max(jAbs2, jAbs3);
        long jZzCb = jZzCa + jAbs;
        if (!zzCk().zzc(jMax2, jZzBY)) {
            jZzCb = jMax2 + jZzBY;
        }
        if (jAbs3 == 0 || jAbs3 < jAbs) {
            return jZzCb;
        }
        for (int i = 0; i < zzCp().zzCc(); i++) {
            jZzCb += ((long) (1 << i)) * zzCp().zzCb();
            if (jZzCb > jAbs3) {
                return jZzCb;
            }
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void zza(int i, Throwable th, byte[] bArr) {
        zzjk();
        zzjv();
        if (bArr == null) {
            bArr = new byte[0];
        }
        List<Long> list = this.zzaYp;
        this.zzaYp = null;
        if ((i != 200 && i != 204) || th != null) {
            zzAo().zzCK().zze("Network upload failed. Will retry later. code, error", Integer.valueOf(i), th);
            zzCo().zzaXk.set(zzjl().currentTimeMillis());
            if (i == 503 || i == 429) {
                zzCo().zzaXl.set(zzjl().currentTimeMillis());
            }
            zzDe();
            return;
        }
        zzCo().zzaXj.set(zzjl().currentTimeMillis());
        zzCo().zzaXk.set(0L);
        zzDe();
        zzAo().zzCK().zze("Successful upload. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
        zzCj().beginTransaction();
        try {
            Iterator<Long> it = list.iterator();
            while (it.hasNext()) {
                zzCj().zzZ(it.next().longValue());
            }
            zzCj().setTransactionSuccessful();
            zzCj().endTransaction();
            if (zzCW().zzlB() && zzDd()) {
                zzDc();
            } else {
                zzDe();
            }
        } catch (Throwable th2) {
            zzCj().endTransaction();
            throw th2;
        }
    }

    private void zza(zzy zzyVar) {
        if (zzyVar == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    private void zza(zzz zzzVar) {
        if (zzzVar == null) {
            throw new IllegalStateException("Component not created");
        }
        if (!zzzVar.isInitialized()) {
            throw new IllegalStateException("Component not initialized");
        }
    }

    private zzqb.zza[] zza(String str, zzqb.zzg[] zzgVarArr, zzqb.zzb[] zzbVarArr) {
        com.google.android.gms.common.internal.zzx.zzcM(str);
        return zzCe().zza(str, zzbVarArr, zzgVarArr);
    }

    public static zzw zzaT(Context context) {
        com.google.android.gms.common.internal.zzx.zzz(context);
        com.google.android.gms.common.internal.zzx.zzz(context.getApplicationContext());
        if (zzaXW == null) {
            synchronized (zzw.class) {
                if (zzaXW == null) {
                    zzaXW = (zzaXV != null ? zzaXV : new zzaa(context)).zzDj();
                }
            }
        }
        return zzaXW;
    }

    private void zzb(Bundle bundle, int i) {
        if (bundle.getLong("_err") == 0) {
            bundle.putLong("_err", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void zzb(String str, int i, Throwable th, byte[] bArr) {
        zzjk();
        zzjv();
        com.google.android.gms.common.internal.zzx.zzcM(str);
        if (bArr == null) {
            bArr = new byte[0];
        }
        zzCj().beginTransaction();
        try {
            com.google.android.gms.measurement.internal.zza zzaVarZzeY = zzCj().zzeY(str);
            if (((i == 200 || i == 204 || i == 304) && th == null) || i == 404) {
                if (i == 404 || i == 304) {
                    if (zzCl().zzfk(str) == null && !zzCl().zze(str, null)) {
                        return;
                    }
                } else if (!zzCl().zze(str, bArr)) {
                    return;
                }
                zzaVarZzeY.zzT(zzjl().currentTimeMillis());
                zzCj().zza(zzaVarZzeY);
                if (i == 404) {
                    zzAo().zzCF().zzfg("Config not found. Using empty config");
                } else {
                    zzAo().zzCK().zze("Successfully fetched config. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
                }
                if (zzCW().zzlB() && zzDd()) {
                    zzDc();
                } else {
                    zzDe();
                }
            } else {
                zzaVarZzeY.zzU(zzjl().currentTimeMillis());
                zzCj().zza(zzaVarZzeY);
                zzAo().zzCK().zze("Fetching config failed. code, error", Integer.valueOf(i), th);
                zzCo().zzaXk.set(zzjl().currentTimeMillis());
                if (i == 503 || i == 429) {
                    zzCo().zzaXl.set(zzjl().currentTimeMillis());
                }
                zzDe();
            }
            zzCj().setTransactionSuccessful();
        } finally {
            zzCj().endTransaction();
        }
    }

    @WorkerThread
    private void zze(AppMetadata appMetadata) {
        boolean z = true;
        zzjk();
        zzjv();
        com.google.android.gms.common.internal.zzx.zzz(appMetadata);
        com.google.android.gms.common.internal.zzx.zzcM(appMetadata.packageName);
        com.google.android.gms.measurement.internal.zza zzaVarZzeY = zzCj().zzeY(appMetadata.packageName);
        String strZzfi = zzCo().zzfi(appMetadata.packageName);
        boolean z2 = false;
        if (zzaVarZzeY == null) {
            com.google.android.gms.measurement.internal.zza zzaVar = new com.google.android.gms.measurement.internal.zza(this, appMetadata.packageName);
            zzaVar.zzeM(zzCo().zzCM());
            zzaVar.zzeO(strZzfi);
            zzaVarZzeY = zzaVar;
            z2 = true;
        } else if (!strZzfi.equals(zzaVarZzeY.zzBl())) {
            zzaVarZzeY.zzeO(strZzfi);
            zzaVarZzeY.zzeM(zzCo().zzCM());
            z2 = true;
        }
        if (!TextUtils.isEmpty(appMetadata.zzaVt) && !appMetadata.zzaVt.equals(zzaVarZzeY.zzBk())) {
            zzaVarZzeY.zzeN(appMetadata.zzaVt);
            z2 = true;
        }
        if (appMetadata.zzaVv != 0 && appMetadata.zzaVv != zzaVarZzeY.zzBp()) {
            zzaVarZzeY.zzQ(appMetadata.zzaVv);
            z2 = true;
        }
        if (!TextUtils.isEmpty(appMetadata.zzaMV) && !appMetadata.zzaMV.equals(zzaVarZzeY.zzli())) {
            zzaVarZzeY.setAppVersion(appMetadata.zzaMV);
            z2 = true;
        }
        if (!TextUtils.isEmpty(appMetadata.zzaVu) && !appMetadata.zzaVu.equals(zzaVarZzeY.zzBo())) {
            zzaVarZzeY.zzeP(appMetadata.zzaVu);
            z2 = true;
        }
        if (appMetadata.zzaVw != zzaVarZzeY.zzBq()) {
            zzaVarZzeY.zzR(appMetadata.zzaVw);
            z2 = true;
        }
        if (appMetadata.zzaVy != zzaVarZzeY.zzAr()) {
            zzaVarZzeY.setMeasurementEnabled(appMetadata.zzaVy);
        } else {
            z = z2;
        }
        if (z) {
            zzCj().zza(zzaVarZzeY);
        }
    }

    private boolean zzg(String str, long j) {
        zze zzeVarZzCj;
        int i;
        zzCj().beginTransaction();
        try {
            zza zzaVar = new zza();
            zzCj().zza(str, j, zzaVar);
            if (zzaVar.isEmpty()) {
                zzCj().setTransactionSuccessful();
                return false;
            }
            zzqb.zze zzeVar = zzaVar.zzaYt;
            zzeVar.zzbam = new zzqb.zzb[zzaVar.zzpH.size()];
            int i2 = 0;
            int i3 = 0;
            while (i3 < zzaVar.zzpH.size()) {
                if (zzCl().zzP(zzaVar.zzaYt.appId, zzaVar.zzpH.get(i3).name)) {
                    zzAo().zzCK().zzj("Dropping blacklisted raw event", zzaVar.zzpH.get(i3).name);
                    i = i2;
                } else {
                    zzeVar.zzbam[i2] = zzaVar.zzpH.get(i3);
                    i = i2 + 1;
                }
                i3++;
                i2 = i;
            }
            if (i2 < zzaVar.zzpH.size()) {
                zzeVar.zzbam = (zzqb.zzb[]) Arrays.copyOf(zzeVar.zzbam, i2);
            }
            zzeVar.zzbaF = zza(zzaVar.zzaYt.appId, zzaVar.zzaYt.zzban, zzeVar.zzbam);
            zzeVar.zzbap = zzeVar.zzbam[0].zzbaf;
            zzeVar.zzbaq = zzeVar.zzbam[0].zzbaf;
            for (int i4 = 1; i4 < zzeVar.zzbam.length; i4++) {
                zzqb.zzb zzbVar = zzeVar.zzbam[i4];
                if (zzbVar.zzbaf.longValue() < zzeVar.zzbap.longValue()) {
                    zzeVar.zzbap = zzbVar.zzbaf;
                }
                if (zzbVar.zzbaf.longValue() > zzeVar.zzbaq.longValue()) {
                    zzeVar.zzbaq = zzbVar.zzbaf;
                }
            }
            String str2 = zzaVar.zzaYt.appId;
            com.google.android.gms.measurement.internal.zza zzaVarZzeY = zzCj().zzeY(str2);
            if (zzaVarZzeY == null) {
                zzAo().zzCE().zzfg("Bundling raw events w/o app info");
            } else {
                long jZzBn = zzaVarZzeY.zzBn();
                zzeVar.zzbas = jZzBn != 0 ? Long.valueOf(jZzBn) : null;
                long jZzBm = zzaVarZzeY.zzBm();
                if (jZzBm != 0) {
                    jZzBn = jZzBm;
                }
                zzeVar.zzbar = jZzBn != 0 ? Long.valueOf(jZzBn) : null;
                zzaVarZzeY.zzBu();
                zzeVar.zzbaD = Integer.valueOf((int) zzaVarZzeY.zzBr());
                zzaVarZzeY.zzO(zzeVar.zzbap.longValue());
                zzaVarZzeY.zzP(zzeVar.zzbaq.longValue());
                zzCj().zza(zzaVarZzeY);
            }
            zzeVar.zzaVx = zzAo().zzCL();
            zzCj().zza(zzeVar);
            zzCj().zzz(zzaVar.zzaYu);
            zzCj().zzfc(str2);
            zzCj().setTransactionSuccessful();
            return true;
        } finally {
            zzCj().endTransaction();
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    @WorkerThread
    protected void start() {
        zzjk();
        if (zzCZ() && (!this.zzaYa.isInitialized() || this.zzaYa.zzDi())) {
            zzAo().zzCE().zzfg("Scheduler shutting down before Scion.start() called");
            return;
        }
        zzCj().zzCr();
        if (zzCS()) {
            if (!zzCp().zzkr() && !zzCZ() && !TextUtils.isEmpty(zzCg().zzBk())) {
                zzCf().zzDl();
            }
        } else if (zzCo().zzAr()) {
            if (!zzCk().zzbk("android.permission.INTERNET")) {
                zzAo().zzCE().zzfg("App is missing INTERNET permission");
            }
            if (!zzCk().zzbk("android.permission.ACCESS_NETWORK_STATE")) {
                zzAo().zzCE().zzfg("App is missing ACCESS_NETWORK_STATE permission");
            }
            if (!AppMeasurementReceiver.zzY(getContext())) {
                zzAo().zzCE().zzfg("AppMeasurementReceiver not registered/enabled");
            }
            if (!AppMeasurementService.zzZ(getContext())) {
                zzAo().zzCE().zzfg("AppMeasurementService not registered/enabled");
            }
            zzAo().zzCE().zzfg("Uploading is not possible. App measurement disabled");
        }
        zzDe();
    }

    public zzp zzAo() {
        zza((zzz) this.zzaXZ);
        return this.zzaXZ;
    }

    @WorkerThread
    protected boolean zzCS() {
        zzjv();
        zzjk();
        if (this.zzaYo == null) {
            this.zzaYo = Boolean.valueOf(zzCk().zzbk("android.permission.INTERNET") && zzCk().zzbk("android.permission.ACCESS_NETWORK_STATE") && AppMeasurementReceiver.zzY(getContext()) && AppMeasurementService.zzZ(getContext()));
            if (this.zzaYo.booleanValue() && !zzCp().zzkr()) {
                this.zzaYo = Boolean.valueOf(TextUtils.isEmpty(zzCg().zzBk()) ? false : true);
            }
        }
        return this.zzaYo.booleanValue();
    }

    public zzp zzCT() {
        if (this.zzaXZ == null || !this.zzaXZ.isInitialized()) {
            return null;
        }
        return this.zzaXZ;
    }

    zzv zzCU() {
        return this.zzaYa;
    }

    public AppMeasurement zzCV() {
        return this.zzaYd;
    }

    public zzq zzCW() {
        zza((zzz) this.zzaYg);
        return this.zzaYg;
    }

    public zzr zzCX() {
        if (this.zzaYl == null) {
            throw new IllegalStateException("Network broadcast receiver not created");
        }
        return this.zzaYl;
    }

    public zzag zzCY() {
        zza((zzz) this.zzaYm);
        return this.zzaYm;
    }

    protected boolean zzCZ() {
        return false;
    }

    public zzc zzCe() {
        zza((zzz) this.zzaYn);
        return this.zzaYn;
    }

    public zzab zzCf() {
        zza((zzz) this.zzaYj);
        return this.zzaYj;
    }

    public zzn zzCg() {
        zza((zzz) this.zzaYk);
        return this.zzaYk;
    }

    public zzg zzCh() {
        zza((zzz) this.zzaYi);
        return this.zzaYi;
    }

    public zzac zzCi() {
        zza((zzz) this.zzaYh);
        return this.zzaYh;
    }

    public zze zzCj() {
        zza((zzz) this.zzaYf);
        return this.zzaYf;
    }

    public zzaj zzCk() {
        zza(this.zzaYe);
        return this.zzaYe;
    }

    public zzu zzCl() {
        zza((zzz) this.zzaYc);
        return this.zzaYc;
    }

    public zzad zzCm() {
        zza((zzz) this.zzaYb);
        return this.zzaYb;
    }

    public zzv zzCn() {
        zza((zzz) this.zzaYa);
        return this.zzaYa;
    }

    public zzt zzCo() {
        zza((zzy) this.zzaXY);
        return this.zzaXY;
    }

    public zzd zzCp() {
        return this.zzaXX;
    }

    long zzDa() {
        return ((((zzjl().currentTimeMillis() + zzCo().zzCN()) / 1000) / 60) / 60) / 24;
    }

    @WorkerThread
    public void zzDc() {
        com.google.android.gms.measurement.internal.zza zzaVarZzeY;
        String str;
        List<Pair<zzqb.zze, Long>> listSubList;
        Map<String, String> arrayMap = null;
        zzjk();
        zzjv();
        if (!zzCp().zzkr()) {
            Boolean boolZzCP = zzCo().zzCP();
            if (boolZzCP == null) {
                zzAo().zzCF().zzfg("Upload data called on the client side before use of service was decided");
                return;
            } else if (boolZzCP.booleanValue()) {
                zzAo().zzCE().zzfg("Upload called in the client side when service should be used");
                return;
            }
        }
        if (zzDb()) {
            zzAo().zzCF().zzfg("Uploading requested multiple times");
            return;
        }
        if (!zzCW().zzlB()) {
            zzAo().zzCF().zzfg("Network not connected, ignoring upload request");
            zzDe();
            return;
        }
        long jCurrentTimeMillis = zzjl().currentTimeMillis();
        zzad(jCurrentTimeMillis - zzCp().zzBW());
        long j = zzCo().zzaXj.get();
        if (j != 0) {
            zzAo().zzCJ().zzj("Uploading events. Elapsed time since last upload attempt (ms)", Long.valueOf(Math.abs(jCurrentTimeMillis - j)));
        }
        String strZzCq = zzCj().zzCq();
        if (TextUtils.isEmpty(strZzCq)) {
            String strZzaa = zzCj().zzaa(jCurrentTimeMillis - zzCp().zzBW());
            if (TextUtils.isEmpty(strZzaa) || (zzaVarZzeY = zzCj().zzeY(strZzaa)) == null) {
                return;
            }
            String strZzH = zzCp().zzH(zzaVarZzeY.zzBk(), zzaVarZzeY.zzBj());
            try {
                URL url = new URL(strZzH);
                zzAo().zzCK().zzj("Fetching remote configuration", zzaVarZzeY.zzwK());
                zzqa.zzb zzbVarZzfk = zzCl().zzfk(zzaVarZzeY.zzwK());
                if (zzbVarZzfk != null && zzbVarZzfk.zzaZT != null) {
                    arrayMap = new ArrayMap<>();
                    arrayMap.put("Config-Version", String.valueOf(zzbVarZzfk.zzaZT));
                }
                zzCW().zza(strZzaa, url, arrayMap, new zzq.zza() { // from class: com.google.android.gms.measurement.internal.zzw.3
                    @Override // com.google.android.gms.measurement.internal.zzq.zza
                    public void zza(String str2, int i, Throwable th, byte[] bArr) {
                        zzw.this.zzb(str2, i, th, bArr);
                    }
                });
                return;
            } catch (MalformedURLException e) {
                zzAo().zzCE().zzj("Failed to parse config URL. Not fetching", strZzH);
                return;
            }
        }
        List<Pair<zzqb.zze, Long>> listZzn = zzCj().zzn(strZzCq, zzCp().zzeU(strZzCq), zzCp().zzeV(strZzCq));
        if (listZzn.isEmpty()) {
            return;
        }
        Iterator<Pair<zzqb.zze, Long>> it = listZzn.iterator();
        while (true) {
            if (!it.hasNext()) {
                str = null;
                break;
            }
            zzqb.zze zzeVar = (zzqb.zze) it.next().first;
            if (!TextUtils.isEmpty(zzeVar.zzbaz)) {
                str = zzeVar.zzbaz;
                break;
            }
        }
        if (str == null) {
            listSubList = listZzn;
            break;
        }
        int i = 0;
        while (true) {
            if (i >= listZzn.size()) {
                listSubList = listZzn;
                break;
            }
            zzqb.zze zzeVar2 = (zzqb.zze) listZzn.get(i).first;
            if (!TextUtils.isEmpty(zzeVar2.zzbaz) && !zzeVar2.zzbaz.equals(str)) {
                listSubList = listZzn.subList(0, i);
                break;
            }
            i++;
        }
        zzqb.zzd zzdVar = new zzqb.zzd();
        zzdVar.zzbaj = new zzqb.zze[listSubList.size()];
        ArrayList arrayList = new ArrayList(listSubList.size());
        for (int i2 = 0; i2 < zzdVar.zzbaj.length; i2++) {
            zzdVar.zzbaj[i2] = (zzqb.zze) listSubList.get(i2).first;
            arrayList.add(listSubList.get(i2).second);
            zzdVar.zzbaj[i2].zzbay = Long.valueOf(zzCp().zzBp());
            zzdVar.zzbaj[i2].zzbao = Long.valueOf(jCurrentTimeMillis);
            zzdVar.zzbaj[i2].zzbaE = Boolean.valueOf(zzCp().zzkr());
        }
        Object objZzb = zzAo().zzQ(2) ? zzaj.zzb(zzdVar) : null;
        byte[] bArrZza = zzCk().zza(zzdVar);
        String strZzBV = zzCp().zzBV();
        try {
            URL url2 = new URL(strZzBV);
            zzA(arrayList);
            zzCo().zzaXk.set(jCurrentTimeMillis);
            zzAo().zzCK().zzd("Uploading data. app, uncompressed size, data", zzdVar.zzbaj.length > 0 ? zzdVar.zzbaj[0].appId : "?", Integer.valueOf(bArrZza.length), objZzb);
            zzCW().zza(strZzCq, url2, bArrZza, null, new zzq.zza() { // from class: com.google.android.gms.measurement.internal.zzw.2
                @Override // com.google.android.gms.measurement.internal.zzq.zza
                public void zza(String str2, int i3, Throwable th, byte[] bArr) {
                    zzw.this.zza(i3, th, bArr);
                }
            });
        } catch (MalformedURLException e2) {
            zzAo().zzCE().zzj("Failed to parse upload URL. Not uploading", strZzBV);
        }
    }

    void zzDg() {
        this.zzaYr++;
    }

    void zzE(String str, int i) {
    }

    public void zzJ(boolean z) {
        zzDe();
    }

    void zza(EventParcel eventParcel, String str) {
        com.google.android.gms.measurement.internal.zza zzaVarZzeY = zzCj().zzeY(str);
        if (zzaVarZzeY == null || TextUtils.isEmpty(zzaVarZzeY.zzli())) {
            zzAo().zzCJ().zzj("No app data available; dropping event", str);
            return;
        }
        try {
            String str2 = getContext().getPackageManager().getPackageInfo(str, 0).versionName;
            if (zzaVarZzeY.zzli() != null && !zzaVarZzeY.zzli().equals(str2)) {
                zzAo().zzCF().zzj("App version does not match; dropping event", str);
                return;
            }
        } catch (PackageManager.NameNotFoundException e) {
            zzAo().zzCF().zzj("Could not find package", str);
        }
        zzb(eventParcel, new AppMetadata(str, zzaVarZzeY.zzBk(), zzaVarZzeY.zzli(), zzaVarZzeY.zzBo(), zzaVarZzeY.zzBp(), zzaVarZzeY.zzBq(), null, zzaVarZzeY.zzAr(), false));
    }

    void zza(zzh zzhVar, AppMetadata appMetadata) {
        zzjk();
        zzjv();
        com.google.android.gms.common.internal.zzx.zzz(zzhVar);
        com.google.android.gms.common.internal.zzx.zzz(appMetadata);
        com.google.android.gms.common.internal.zzx.zzcM(zzhVar.zzaUa);
        com.google.android.gms.common.internal.zzx.zzac(zzhVar.zzaUa.equals(appMetadata.packageName));
        zzqb.zze zzeVar = new zzqb.zze();
        zzeVar.zzbal = 1;
        zzeVar.zzbat = AbstractSpiCall.ANDROID_CLIENT_TYPE;
        zzeVar.appId = appMetadata.packageName;
        zzeVar.zzaVu = appMetadata.zzaVu;
        zzeVar.zzaMV = appMetadata.zzaMV;
        zzeVar.zzbax = Long.valueOf(appMetadata.zzaVv);
        zzeVar.zzaVt = appMetadata.zzaVt;
        zzeVar.zzbaC = appMetadata.zzaVw == 0 ? null : Long.valueOf(appMetadata.zzaVw);
        Pair<String, Boolean> pairZzfh = zzCo().zzfh(appMetadata.packageName);
        if (pairZzfh != null && pairZzfh.first != null && pairZzfh.second != null) {
            zzeVar.zzbaz = (String) pairZzfh.first;
            zzeVar.zzbaA = (Boolean) pairZzfh.second;
        }
        zzeVar.zzbau = zzCh().zzht();
        zzeVar.osVersion = zzCh().zzCy();
        zzeVar.zzbaw = Integer.valueOf((int) zzCh().zzCz());
        zzeVar.zzbav = zzCh().zzCA();
        zzeVar.zzbay = null;
        zzeVar.zzbao = null;
        zzeVar.zzbap = null;
        zzeVar.zzbaq = null;
        com.google.android.gms.measurement.internal.zza zzaVarZzeY = zzCj().zzeY(appMetadata.packageName);
        if (zzaVarZzeY == null) {
            zzaVarZzeY = new com.google.android.gms.measurement.internal.zza(this, appMetadata.packageName);
            zzaVarZzeY.zzeM(zzCo().zzCM());
            zzaVarZzeY.zzeN(appMetadata.zzaVt);
            zzaVarZzeY.zzeO(zzCo().zzfi(appMetadata.packageName));
            zzaVarZzeY.zzS(0L);
            zzaVarZzeY.zzO(0L);
            zzaVarZzeY.zzP(0L);
            zzaVarZzeY.setAppVersion(appMetadata.zzaMV);
            zzaVarZzeY.zzeP(appMetadata.zzaVu);
            zzaVarZzeY.zzQ(appMetadata.zzaVv);
            zzaVarZzeY.zzR(appMetadata.zzaVw);
            zzaVarZzeY.setMeasurementEnabled(appMetadata.zzaVy);
            zzCj().zza(zzaVarZzeY);
        }
        zzeVar.zzbaB = zzaVarZzeY.zzBj();
        List<zzai> listZzeX = zzCj().zzeX(appMetadata.packageName);
        zzeVar.zzban = new zzqb.zzg[listZzeX.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= listZzeX.size()) {
                try {
                    zzCj().zza(zzhVar, zzCj().zzb(zzeVar));
                    return;
                } catch (IOException e) {
                    zzAo().zzCE().zzj("Data loss. Failed to insert raw event metadata", e);
                    return;
                }
            }
            zzqb.zzg zzgVar = new zzqb.zzg();
            zzeVar.zzban[i2] = zzgVar;
            zzgVar.name = listZzeX.get(i2).mName;
            zzgVar.zzbaJ = Long.valueOf(listZzeX.get(i2).zzaZp);
            zzCk().zza(zzgVar, listZzeX.get(i2).zzNc);
            i = i2 + 1;
        }
    }

    boolean zzad(long j) {
        return zzg(null, j);
    }

    void zzb(EventParcel eventParcel, AppMetadata appMetadata) {
        zzai zzaiVar;
        zzi zziVarZzab;
        long jNanoTime = System.nanoTime();
        zzjk();
        zzjv();
        String str = appMetadata.packageName;
        com.google.android.gms.common.internal.zzx.zzcM(str);
        if (TextUtils.isEmpty(appMetadata.zzaVt)) {
            return;
        }
        if (!appMetadata.zzaVy) {
            zze(appMetadata);
            return;
        }
        if (zzCl().zzP(str, eventParcel.name)) {
            zzAo().zzCK().zzj("Dropping blacklisted event", eventParcel.name);
            return;
        }
        if (zzAo().zzQ(2)) {
            zzAo().zzCK().zzj("Logging event", eventParcel);
        }
        zzCj().beginTransaction();
        try {
            Bundle bundleZzCC = eventParcel.zzaVV.zzCC();
            zze(appMetadata);
            if ("_iap".equals(eventParcel.name) || "ecommerce_purchase".equals(eventParcel.name)) {
                String string = bundleZzCC.getString(InAppPurchaseMetaData.KEY_CURRENCY);
                long j = bundleZzCC.getLong("value");
                if (!TextUtils.isEmpty(string) && j > 0) {
                    String upperCase = string.toUpperCase(Locale.US);
                    if (upperCase.matches("[A-Z]{3}")) {
                        String str2 = "_ltv_" + upperCase;
                        zzai zzaiVarZzK = zzCj().zzK(str, str2);
                        if (zzaiVarZzK == null || !(zzaiVarZzK.zzNc instanceof Long)) {
                            zzCj().zzA(str, zzCp().zzeT(str) - 1);
                            zzaiVar = new zzai(str, str2, zzjl().currentTimeMillis(), Long.valueOf(j));
                        } else {
                            zzaiVar = new zzai(str, str2, zzjl().currentTimeMillis(), Long.valueOf(j + ((Long) zzaiVarZzK.zzNc).longValue()));
                        }
                        zzCj().zza(zzaiVar);
                    }
                }
            }
            boolean zZzfq = zzaj.zzfq(eventParcel.name);
            boolean zZzI = zzaj.zzI(bundleZzCC);
            zze.zza zzaVarZza = zzCj().zza(zzDa(), str, zZzfq, zZzfq && zZzI);
            long jZzBI = zzaVarZza.zzaVF - zzCp().zzBI();
            if (jZzBI > 0) {
                if (jZzBI % 1000 == 1) {
                    zzAo().zzCF().zzj("Data loss. Too many events logged. count", Long.valueOf(zzaVarZza.zzaVF));
                }
                zzCj().setTransactionSuccessful();
                zzCj().endTransaction();
                return;
            }
            if (zZzfq) {
                long jZzBJ = zzaVarZza.zzaVE - zzCp().zzBJ();
                if (jZzBJ > 0) {
                    zzE(str, 2);
                    if (jZzBJ % 1000 == 1) {
                        zzAo().zzCF().zzj("Data loss. Too many public events logged. count", Long.valueOf(zzaVarZza.zzaVE));
                    }
                    zzCj().setTransactionSuccessful();
                    zzCj().endTransaction();
                    return;
                }
            }
            if (zZzfq && zZzI && zzaVarZza.zzaVG - zzCp().zzBK() > 0) {
                bundleZzCC.remove("_c");
                zzb(bundleZzCC, 4);
            }
            long jZzeZ = zzCj().zzeZ(str);
            if (jZzeZ > 0) {
                zzAo().zzCF().zzj("Data lost. Too many events stored on disk, deleted", Long.valueOf(jZzeZ));
            }
            zzh zzhVar = new zzh(this, eventParcel.zzaVW, str, eventParcel.name, eventParcel.zzaVX, 0L, bundleZzCC);
            zzi zziVarZzI = zzCj().zzI(str, zzhVar.mName);
            if (zziVarZzI != null) {
                zzhVar = zzhVar.zza(this, zziVarZzI.zzaVR);
                zziVarZzab = zziVarZzI.zzab(zzhVar.zzaez);
            } else {
                if (zzCj().zzfd(str) >= zzCp().zzBH()) {
                    zzAo().zzCF().zze("Too many event names used, ignoring event. name, supported count", zzhVar.mName, Integer.valueOf(zzCp().zzBH()));
                    zzE(str, 1);
                    zzCj().endTransaction();
                    return;
                }
                zziVarZzab = new zzi(str, zzhVar.mName, 0L, 0L, zzhVar.zzaez);
            }
            zzCj().zza(zziVarZzab);
            zza(zzhVar, appMetadata);
            zzCj().setTransactionSuccessful();
            if (zzAo().zzQ(2)) {
                zzAo().zzCK().zzj("Event recorded", zzhVar);
            }
            zzCj().endTransaction();
            zzDe();
            zzAo().zzCK().zzj("Background event processing time, ms", Long.valueOf(((System.nanoTime() - jNanoTime) + 500000) / 1000000));
        } catch (Throwable th) {
            zzCj().endTransaction();
            throw th;
        }
    }

    @WorkerThread
    void zzb(UserAttributeParcel userAttributeParcel, AppMetadata appMetadata) {
        zzjk();
        zzjv();
        if (TextUtils.isEmpty(appMetadata.zzaVt)) {
            return;
        }
        if (!appMetadata.zzaVy) {
            zze(appMetadata);
            return;
        }
        zzCk().zzfs(userAttributeParcel.name);
        Object objZzm = zzCk().zzm(userAttributeParcel.name, userAttributeParcel.getValue());
        if (objZzm != null) {
            zzai zzaiVar = new zzai(appMetadata.packageName, userAttributeParcel.name, userAttributeParcel.zzaZm, objZzm);
            zzAo().zzCJ().zze("Setting user property", zzaiVar.mName, objZzm);
            zzCj().beginTransaction();
            try {
                zze(appMetadata);
                boolean zZza = zzCj().zza(zzaiVar);
                zzCj().setTransactionSuccessful();
                if (zZza) {
                    zzAo().zzCJ().zze("User property set", zzaiVar.mName, zzaiVar.zzNc);
                } else {
                    zzAo().zzCH().zze("Ignoring user property. Value too long", zzaiVar.mName, zzaiVar.zzNc);
                }
            } finally {
                zzCj().endTransaction();
            }
        }
    }

    void zzb(zzz zzzVar) {
        this.zzaYq++;
    }

    void zzc(AppMetadata appMetadata) {
        zzjk();
        zzjv();
        com.google.android.gms.common.internal.zzx.zzcM(appMetadata.packageName);
        zze(appMetadata);
    }

    @WorkerThread
    void zzc(UserAttributeParcel userAttributeParcel, AppMetadata appMetadata) {
        zzjk();
        zzjv();
        if (TextUtils.isEmpty(appMetadata.zzaVt)) {
            return;
        }
        if (!appMetadata.zzaVy) {
            zze(appMetadata);
            return;
        }
        zzAo().zzCJ().zzj("Removing user property", userAttributeParcel.name);
        zzCj().beginTransaction();
        try {
            zze(appMetadata);
            zzCj().zzJ(appMetadata.packageName, userAttributeParcel.name);
            zzCj().setTransactionSuccessful();
            zzAo().zzCJ().zzj("User property removed", userAttributeParcel.name);
        } finally {
            zzCj().endTransaction();
        }
    }

    @WorkerThread
    public void zzd(AppMetadata appMetadata) {
        zzjk();
        zzjv();
        com.google.android.gms.common.internal.zzx.zzz(appMetadata);
        com.google.android.gms.common.internal.zzx.zzcM(appMetadata.packageName);
        if (TextUtils.isEmpty(appMetadata.zzaVt)) {
            return;
        }
        if (!appMetadata.zzaVy) {
            zze(appMetadata);
            return;
        }
        long jCurrentTimeMillis = zzjl().currentTimeMillis();
        zzCj().beginTransaction();
        try {
            com.google.android.gms.measurement.internal.zza zzaVarZzeY = zzCj().zzeY(appMetadata.packageName);
            if (zzaVarZzeY != null && zzaVarZzeY.zzli() != null && !zzaVarZzeY.zzli().equals(appMetadata.zzaMV)) {
                Bundle bundle = new Bundle();
                bundle.putString("_pv", zzaVarZzeY.zzli());
                zzb(new EventParcel("_au", new EventParams(bundle), "auto", jCurrentTimeMillis), appMetadata);
            }
            zze(appMetadata);
            if (zzCj().zzI(appMetadata.packageName, "_f") == null) {
                zzb(new UserAttributeParcel("_fot", jCurrentTimeMillis, Long.valueOf(((jCurrentTimeMillis / 3600000) + 1) * 3600000), "auto"), appMetadata);
                Bundle bundle2 = new Bundle();
                bundle2.putLong("_c", 1L);
                zzb(new EventParcel("_f", new EventParams(bundle2), "auto", jCurrentTimeMillis), appMetadata);
            } else if (appMetadata.zzaVz) {
                zzb(new EventParcel("_cd", new EventParams(new Bundle()), "auto", jCurrentTimeMillis), appMetadata);
            }
            zzCj().setTransactionSuccessful();
        } finally {
            zzCj().endTransaction();
        }
    }

    void zzjj() {
        if (zzCp().zzkr()) {
            throw new IllegalStateException("Unexpected call on package side");
        }
    }

    @WorkerThread
    public void zzjk() {
        zzCn().zzjk();
    }

    public zzmq zzjl() {
        return this.zzqW;
    }

    void zzjv() {
        if (!this.zzQk) {
            throw new IllegalStateException("AppMeasurement is not initialized");
        }
    }
}
