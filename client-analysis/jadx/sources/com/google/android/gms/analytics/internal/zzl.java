package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Pair;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.analytics.AnalyticsReceiver;
import com.google.android.gms.analytics.AnalyticsService;
import com.google.android.gms.analytics.CampaignTrackingReceiver;
import com.google.android.gms.analytics.CampaignTrackingService;
import com.google.android.gms.internal.zzkd;
import com.google.android.gms.internal.zzke;
import com.google.android.gms.internal.zzpq;
import com.google.android.gms.internal.zzpr;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class zzl extends zzd {
    private boolean mStarted;
    private final zzj zzQY;
    private final zzah zzQZ;
    private final zzag zzRa;
    private final zzi zzRb;
    private long zzRc;
    private final zzt zzRd;
    private final zzt zzRe;
    private final zzaj zzRf;
    private long zzRg;
    private boolean zzRh;

    protected zzl(zzf zzfVar, zzg zzgVar) {
        super(zzfVar);
        com.google.android.gms.common.internal.zzx.zzz(zzgVar);
        this.zzRc = Long.MIN_VALUE;
        this.zzRa = zzgVar.zzk(zzfVar);
        this.zzQY = zzgVar.zzm(zzfVar);
        this.zzQZ = zzgVar.zzn(zzfVar);
        this.zzRb = zzgVar.zzo(zzfVar);
        this.zzRf = new zzaj(zzjl());
        this.zzRd = new zzt(zzfVar) { // from class: com.google.android.gms.analytics.internal.zzl.1
            @Override // com.google.android.gms.analytics.internal.zzt
            public void run() {
                zzl.this.zzjV();
            }
        };
        this.zzRe = new zzt(zzfVar) { // from class: com.google.android.gms.analytics.internal.zzl.2
            @Override // com.google.android.gms.analytics.internal.zzt
            public void run() {
                zzl.this.zzjW();
            }
        };
    }

    private void zza(zzh zzhVar, zzpr zzprVar) {
        com.google.android.gms.common.internal.zzx.zzz(zzhVar);
        com.google.android.gms.common.internal.zzx.zzz(zzprVar);
        com.google.android.gms.analytics.zza zzaVar = new com.google.android.gms.analytics.zza(zzji());
        zzaVar.zzaS(zzhVar.zzjE());
        zzaVar.enableAdvertisingIdCollection(zzhVar.zzjF());
        com.google.android.gms.measurement.zzc zzcVarZziy = zzaVar.zziy();
        zzke zzkeVar = (zzke) zzcVarZziy.zzf(zzke.class);
        zzkeVar.zzaX(ShareConstants.WEB_DIALOG_PARAM_DATA);
        zzkeVar.zzI(true);
        zzcVarZziy.zzb(zzprVar);
        zzkd zzkdVar = (zzkd) zzcVarZziy.zzf(zzkd.class);
        zzpq zzpqVar = (zzpq) zzcVarZziy.zzf(zzpq.class);
        for (Map.Entry<String, String> entry : zzhVar.zzn().entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if ("an".equals(key)) {
                zzpqVar.setAppName(value);
            } else if ("av".equals(key)) {
                zzpqVar.setAppVersion(value);
            } else if ("aid".equals(key)) {
                zzpqVar.setAppId(value);
            } else if ("aiid".equals(key)) {
                zzpqVar.setAppInstallerId(value);
            } else if ("uid".equals(key)) {
                zzkeVar.setUserId(value);
            } else {
                zzkdVar.set(key, value);
            }
        }
        zzb("Sending installation campaign to", zzhVar.zzjE(), zzprVar);
        zzcVarZziy.zzM(zzjq().zzlF());
        zzcVarZziy.zzAy();
    }

    private boolean zzbk(String str) {
        return getContext().checkCallingOrSelfPermission(str) == 0;
    }

    private void zzjT() {
        Context context = zzji().getContext();
        if (!AnalyticsReceiver.zzY(context)) {
            zzbg("AnalyticsReceiver is not registered or is disabled. Register the receiver for reliable dispatching on non-Google Play devices. See http://goo.gl/8Rd3yj for instructions.");
        } else if (!AnalyticsService.zzZ(context)) {
            zzbh("AnalyticsService is not registered or is disabled. Analytics service at risk of not starting. See http://goo.gl/8Rd3yj for instructions.");
        }
        if (!CampaignTrackingReceiver.zzY(context)) {
            zzbg("CampaignTrackingReceiver is not registered, not exported or is disabled. Installation campaign tracking is not possible. See http://goo.gl/8Rd3yj for instructions.");
        } else {
            if (CampaignTrackingService.zzZ(context)) {
                return;
            }
            zzbg("CampaignTrackingService is not registered or is disabled. Installation campaign tracking is not possible. See http://goo.gl/8Rd3yj for instructions.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzjV() {
        zzb(new zzw() { // from class: com.google.android.gms.analytics.internal.zzl.4
            @Override // com.google.android.gms.analytics.internal.zzw
            public void zzc(Throwable th) {
                zzl.this.zzkb();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzjW() {
        try {
            this.zzQY.zzjN();
            zzkb();
        } catch (SQLiteException e) {
            zzd("Failed to delete stale hits", e);
        }
        this.zzRe.zzt(zzjn().zzkT());
    }

    private boolean zzkc() {
        if (this.zzRh) {
            return false;
        }
        return (!zzjn().zzkr() || zzjn().zzks()) && zzki() > 0;
    }

    private void zzkd() {
        zzv zzvVarZzjp = zzjp();
        if (zzvVarZzjp.zzlb() && !zzvVarZzjp.zzbw()) {
            long jZzjO = zzjO();
            if (jZzjO == 0 || Math.abs(zzjl().currentTimeMillis() - jZzjO) > zzjn().zzkB()) {
                return;
            }
            zza("Dispatch alarm scheduled (ms)", Long.valueOf(zzjn().zzkA()));
            zzvVarZzjp.zzlc();
        }
    }

    private void zzke() {
        long jMin;
        zzkd();
        long jZzki = zzki();
        long jZzlH = zzjq().zzlH();
        if (jZzlH != 0) {
            jMin = jZzki - Math.abs(zzjl().currentTimeMillis() - jZzlH);
            if (jMin <= 0) {
                jMin = Math.min(zzjn().zzky(), jZzki);
            }
        } else {
            jMin = Math.min(zzjn().zzky(), jZzki);
        }
        zza("Dispatch scheduled (ms)", Long.valueOf(jMin));
        if (!this.zzRd.zzbw()) {
            this.zzRd.zzt(jMin);
        } else {
            this.zzRd.zzu(Math.max(1L, jMin + this.zzRd.zzkY()));
        }
    }

    private void zzkf() {
        zzkg();
        zzkh();
    }

    private void zzkg() {
        if (this.zzRd.zzbw()) {
            zzbd("All hits dispatched or no network/service. Going to power save mode");
        }
        this.zzRd.cancel();
    }

    private void zzkh() {
        zzv zzvVarZzjp = zzjp();
        if (zzvVarZzjp.zzbw()) {
            zzvVarZzjp.cancel();
        }
    }

    protected void onServiceConnected() {
        zzjk();
        if (zzjn().zzkr()) {
            return;
        }
        zzjY();
    }

    void start() {
        zzjv();
        com.google.android.gms.common.internal.zzx.zza(!this.mStarted, "Analytics backend already started");
        this.mStarted = true;
        if (!zzjn().zzkr()) {
            zzjT();
        }
        zzjo().zzf(new Runnable() { // from class: com.google.android.gms.analytics.internal.zzl.3
            @Override // java.lang.Runnable
            public void run() {
                zzl.this.zzjU();
            }
        });
    }

    public void zzJ(boolean z) {
        zzkb();
    }

    public long zza(zzh zzhVar, boolean z) {
        long jZza;
        com.google.android.gms.common.internal.zzx.zzz(zzhVar);
        zzjv();
        zzjk();
        try {
            this.zzQY.beginTransaction();
            this.zzQY.zza(zzhVar.zzjD(), zzhVar.getClientId());
            jZza = this.zzQY.zza(zzhVar.zzjD(), zzhVar.getClientId(), zzhVar.zzjE());
            if (z) {
                zzhVar.zzn(1 + jZza);
            } else {
                zzhVar.zzn(jZza);
            }
            this.zzQY.zzb(zzhVar);
            this.zzQY.setTransactionSuccessful();
        } catch (SQLiteException e) {
            zze("Failed to update Analytics property", e);
            jZza = -1;
        } finally {
            try {
                this.zzQY.endTransaction();
            } catch (SQLiteException e2) {
                zze("Failed to end transaction", e2);
            }
        }
        return jZza;
    }

    public void zza(zzab zzabVar) {
        com.google.android.gms.common.internal.zzx.zzz(zzabVar);
        com.google.android.gms.measurement.zzg.zzjk();
        zzjv();
        if (this.zzRh) {
            zzbe("Hit delivery not possible. Missing network permissions. See http://goo.gl/8Rd3yj for instructions");
        } else {
            zza("Delivering hit", zzabVar);
        }
        zzab zzabVarZzf = zzf(zzabVar);
        zzjX();
        if (this.zzRb.zzb(zzabVarZzf)) {
            zzbe("Hit sent to the device AnalyticsService for delivery");
            return;
        }
        if (zzjn().zzkr()) {
            zzjm().zza(zzabVarZzf, "Service unavailable on package side");
            return;
        }
        try {
            this.zzQY.zzc(zzabVarZzf);
            zzkb();
        } catch (SQLiteException e) {
            zze("Delivery failed to save hit to a database", e);
            zzjm().zza(zzabVarZzf, "deliver: failed to insert hit to database");
        }
    }

    public void zza(final zzw zzwVar, final long j) {
        com.google.android.gms.measurement.zzg.zzjk();
        zzjv();
        long jZzlH = zzjq().zzlH();
        zzb("Dispatching local hits. Elapsed time since last dispatch (ms)", Long.valueOf(jZzlH != 0 ? Math.abs(zzjl().currentTimeMillis() - jZzlH) : -1L));
        if (!zzjn().zzkr()) {
            zzjX();
        }
        try {
            if (zzjZ()) {
                zzjo().zzf(new Runnable() { // from class: com.google.android.gms.analytics.internal.zzl.5
                    @Override // java.lang.Runnable
                    public void run() {
                        zzl.this.zza(zzwVar, j);
                    }
                });
                return;
            }
            zzjq().zzlI();
            zzkb();
            if (zzwVar != null) {
                zzwVar.zzc(null);
            }
            if (this.zzRg != j) {
                this.zzRa.zzlA();
            }
        } catch (Throwable th) {
            zze("Local dispatch failed", th);
            zzjq().zzlI();
            zzkb();
            if (zzwVar != null) {
                zzwVar.zzc(th);
            }
        }
    }

    public void zzb(zzw zzwVar) {
        zza(zzwVar, this.zzRg);
    }

    public void zzbl(String str) {
        com.google.android.gms.common.internal.zzx.zzcM(str);
        zzjk();
        zzjj();
        zzpr zzprVarZza = zzam.zza(zzjm(), str);
        if (zzprVarZza == null) {
            zzd("Parsing failed. Ignoring invalid campaign data", str);
            return;
        }
        String strZzlJ = zzjq().zzlJ();
        if (str.equals(strZzlJ)) {
            zzbg("Ignoring duplicate install campaign");
            return;
        }
        if (!TextUtils.isEmpty(strZzlJ)) {
            zzd("Ignoring multiple install campaigns. original, new", strZzlJ, str);
            return;
        }
        zzjq().zzbp(str);
        if (zzjq().zzlG().zzv(zzjn().zzkW())) {
            zzd("Campaign received too late, ignoring", zzprVarZza);
            return;
        }
        zzb("Received installation campaign", zzprVarZza);
        Iterator<zzh> it = this.zzQY.zzr(0L).iterator();
        while (it.hasNext()) {
            zza(it.next(), zzprVarZza);
        }
    }

    protected void zzc(zzh zzhVar) {
        zzjk();
        zzb("Sending first hit to property", zzhVar.zzjE());
        if (zzjq().zzlG().zzv(zzjn().zzkW())) {
            return;
        }
        String strZzlJ = zzjq().zzlJ();
        if (TextUtils.isEmpty(strZzlJ)) {
            return;
        }
        zzpr zzprVarZza = zzam.zza(zzjm(), strZzlJ);
        zzb("Found relevant installation campaign", zzprVarZza);
        zza(zzhVar, zzprVarZza);
    }

    zzab zzf(zzab zzabVar) {
        Pair<String, Long> pairZzlN;
        if (!TextUtils.isEmpty(zzabVar.zzlv()) || (pairZzlN = zzjq().zzlK().zzlN()) == null) {
            return zzabVar;
        }
        String str = ((Long) pairZzlN.second) + ":" + ((String) pairZzlN.first);
        HashMap map = new HashMap(zzabVar.zzn());
        map.put("_m", str);
        return zzab.zza(this, zzabVar, map);
    }

    @Override // com.google.android.gms.analytics.internal.zzd
    protected void zziJ() {
        this.zzQY.zza();
        this.zzQZ.zza();
        this.zzRb.zza();
    }

    public long zzjO() {
        com.google.android.gms.measurement.zzg.zzjk();
        zzjv();
        try {
            return this.zzQY.zzjO();
        } catch (SQLiteException e) {
            zze("Failed to get min/max hit times from local store", e);
            return 0L;
        }
    }

    protected void zzjU() {
        zzjv();
        zzjq().zzlF();
        if (!zzbk("android.permission.ACCESS_NETWORK_STATE")) {
            zzbh("Missing required android.permission.ACCESS_NETWORK_STATE. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
            zzkj();
        }
        if (!zzbk("android.permission.INTERNET")) {
            zzbh("Missing required android.permission.INTERNET. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
            zzkj();
        }
        if (AnalyticsService.zzZ(getContext())) {
            zzbd("AnalyticsService registered in the app manifest and enabled");
        } else if (zzjn().zzkr()) {
            zzbh("Device AnalyticsService not registered! Hits will not be delivered reliably.");
        } else {
            zzbg("AnalyticsService not registered in the app manifest. Hits might not be delivered reliably. See http://goo.gl/8Rd3yj for instructions.");
        }
        if (!this.zzRh && !zzjn().zzkr() && !this.zzQY.isEmpty()) {
            zzjX();
        }
        zzkb();
    }

    protected void zzjX() {
        if (this.zzRh || !zzjn().zzkt() || this.zzRb.isConnected()) {
            return;
        }
        if (this.zzRf.zzv(zzjn().zzkO())) {
            this.zzRf.start();
            zzbd("Connecting to service");
            if (this.zzRb.connect()) {
                zzbd("Connected to service");
                this.zzRf.clear();
                onServiceConnected();
            }
        }
    }

    public void zzjY() {
        com.google.android.gms.measurement.zzg.zzjk();
        zzjv();
        zzjj();
        if (!zzjn().zzkt()) {
            zzbg("Service client disabled. Can't dispatch local hits to device AnalyticsService");
        }
        if (!this.zzRb.isConnected()) {
            zzbd("Service not connected");
            return;
        }
        if (this.zzQY.isEmpty()) {
            return;
        }
        zzbd("Dispatching local hits to device AnalyticsService");
        while (true) {
            try {
                List<zzab> listZzp = this.zzQY.zzp(zzjn().zzkC());
                if (listZzp.isEmpty()) {
                    zzkb();
                    return;
                }
                while (!listZzp.isEmpty()) {
                    zzab zzabVar = listZzp.get(0);
                    if (!this.zzRb.zzb(zzabVar)) {
                        zzkb();
                        return;
                    }
                    listZzp.remove(zzabVar);
                    try {
                        this.zzQY.zzq(zzabVar.zzlq());
                    } catch (SQLiteException e) {
                        zze("Failed to remove hit that was send for delivery", e);
                        zzkf();
                        return;
                    }
                }
            } catch (SQLiteException e2) {
                zze("Failed to read hits from store", e2);
                zzkf();
                return;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:107:0x019f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:53:0x0128 A[Catch: all -> 0x01ee, TryCatch #10 {all -> 0x01ee, blocks: (B:16:0x0052, B:17:0x005a, B:19:0x0066, B:24:0x0083, B:25:0x0090, B:26:0x0094, B:28:0x009a, B:30:0x00a8, B:41:0x00f3, B:43:0x00fb, B:45:0x0105, B:46:0x010a, B:48:0x0110, B:51:0x0120, B:53:0x0128, B:54:0x0133, B:56:0x0139, B:66:0x018d, B:67:0x0190, B:76:0x01b7, B:69:0x0199, B:57:0x0148, B:58:0x0158, B:61:0x016e, B:36:0x00d4), top: B:111:0x0052, inners: #5, #6, #11 }] */
    /* JADX WARN: Code duplicated, block: B:56:0x0139 A[Catch: all -> 0x01ee, LOOP:3: B:54:0x0133->B:56:0x0139, LOOP_END, TryCatch #10 {all -> 0x01ee, blocks: (B:16:0x0052, B:17:0x005a, B:19:0x0066, B:24:0x0083, B:25:0x0090, B:26:0x0094, B:28:0x009a, B:30:0x00a8, B:41:0x00f3, B:43:0x00fb, B:45:0x0105, B:46:0x010a, B:48:0x0110, B:51:0x0120, B:53:0x0128, B:54:0x0133, B:56:0x0139, B:66:0x018d, B:67:0x0190, B:76:0x01b7, B:69:0x0199, B:57:0x0148, B:58:0x0158, B:61:0x016e, B:36:0x00d4), top: B:111:0x0052, inners: #5, #6, #11 }] */
    /* JADX WARN: Code duplicated, block: B:69:0x0199 A[Catch: all -> 0x01ee, PHI: r0
  0x0199: PHI (r0v27 long) = (r0v26 long), (r0v38 long) binds: [B:52:0x0126, B:68:0x0198] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TRY_LEAVE, TryCatch #10 {all -> 0x01ee, blocks: (B:16:0x0052, B:17:0x005a, B:19:0x0066, B:24:0x0083, B:25:0x0090, B:26:0x0094, B:28:0x009a, B:30:0x00a8, B:41:0x00f3, B:43:0x00fb, B:45:0x0105, B:46:0x010a, B:48:0x0110, B:51:0x0120, B:53:0x0128, B:54:0x0133, B:56:0x0139, B:66:0x018d, B:67:0x0190, B:76:0x01b7, B:69:0x0199, B:57:0x0148, B:58:0x0158, B:61:0x016e, B:36:0x00d4), top: B:111:0x0052, inners: #5, #6, #11 }] */
    /* JADX WARN: Code duplicated, block: B:99:0x01d6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    protected boolean zzjZ() {
        long j;
        Iterator<Long> it;
        long jMax;
        com.google.android.gms.measurement.zzg.zzjk();
        zzjv();
        zzbd("Dispatching a batch of local hits");
        boolean z = (this.zzRb.isConnected() || zzjn().zzkr()) ? false : true;
        boolean z2 = this.zzQZ.zzlB() ? false : true;
        if (z && z2) {
            zzbd("No network or service available. Will retry later");
        } else {
            long jMax2 = Math.max(zzjn().zzkC(), zzjn().zzkD());
            ArrayList arrayList = new ArrayList();
            long jMax3 = 0;
            loop0: while (true) {
                try {
                    this.zzQY.beginTransaction();
                    arrayList.clear();
                    try {
                        List<zzab> listZzp = this.zzQY.zzp(jMax2);
                        if (listZzp.isEmpty()) {
                            zzbd("Store is empty, nothing to dispatch");
                            zzkf();
                            try {
                                this.zzQY.setTransactionSuccessful();
                                this.zzQY.endTransaction();
                                break;
                            } catch (SQLiteException e) {
                                zze("Failed to commit local dispatch transaction", e);
                                zzkf();
                                break;
                            }
                        }
                        zza("Hits loaded from store. count", Integer.valueOf(listZzp.size()));
                        Iterator<zzab> it2 = listZzp.iterator();
                        while (it2.hasNext()) {
                            if (it2.next().zzlq() == jMax3) {
                                zzd("Database contains successfully uploaded hit", Long.valueOf(jMax3), Integer.valueOf(listZzp.size()));
                                zzkf();
                                try {
                                    this.zzQY.setTransactionSuccessful();
                                    this.zzQY.endTransaction();
                                    break loop0;
                                } catch (SQLiteException e2) {
                                    zze("Failed to commit local dispatch transaction", e2);
                                    zzkf();
                                    break loop0;
                                }
                            }
                        }
                        if (!this.zzRb.isConnected() || zzjn().zzkr()) {
                            j = jMax3;
                            if (this.zzQZ.zzlB()) {
                                List<Long> listZzq = this.zzQZ.zzq(listZzp);
                                it = listZzq.iterator();
                                jMax = j;
                                while (it.hasNext()) {
                                    jMax = Math.max(jMax, it.next().longValue());
                                }
                                listZzp.removeAll(listZzq);
                                try {
                                    this.zzQY.zzo(listZzq);
                                    arrayList.addAll(listZzq);
                                    j = jMax;
                                    if (arrayList.isEmpty()) {
                                        try {
                                            this.zzQY.setTransactionSuccessful();
                                            this.zzQY.endTransaction();
                                            break;
                                        } catch (SQLiteException e3) {
                                            zze("Failed to commit local dispatch transaction", e3);
                                            zzkf();
                                        }
                                    } else {
                                        try {
                                            this.zzQY.setTransactionSuccessful();
                                            this.zzQY.endTransaction();
                                            jMax3 = j;
                                        } catch (SQLiteException e4) {
                                            zze("Failed to commit local dispatch transaction", e4);
                                            zzkf();
                                        }
                                    }
                                } catch (SQLiteException e5) {
                                    zze("Failed to remove successfully uploaded hits", e5);
                                    zzkf();
                                    try {
                                        this.zzQY.setTransactionSuccessful();
                                        this.zzQY.endTransaction();
                                    } catch (SQLiteException e6) {
                                        zze("Failed to commit local dispatch transaction", e6);
                                        zzkf();
                                    }
                                }
                            } else {
                                if (arrayList.isEmpty()) {
                                    this.zzQY.setTransactionSuccessful();
                                    this.zzQY.endTransaction();
                                    break;
                                }
                                this.zzQY.setTransactionSuccessful();
                                this.zzQY.endTransaction();
                                jMax3 = j;
                            }
                        } else {
                            zzbd("Service connected, sending hits to the service");
                            while (true) {
                                if (listZzp.isEmpty()) {
                                    j = jMax3;
                                    break;
                                }
                                zzab zzabVar = listZzp.get(0);
                                if (!this.zzRb.zzb(zzabVar)) {
                                    j = jMax3;
                                    break;
                                }
                                jMax3 = Math.max(jMax3, zzabVar.zzlq());
                                listZzp.remove(zzabVar);
                                zzb("Hit sent do device AnalyticsService for delivery", zzabVar);
                                try {
                                    this.zzQY.zzq(zzabVar.zzlq());
                                    arrayList.add(Long.valueOf(zzabVar.zzlq()));
                                } catch (SQLiteException e7) {
                                    zze("Failed to remove hit that was send for delivery", e7);
                                    zzkf();
                                    try {
                                        this.zzQY.setTransactionSuccessful();
                                        this.zzQY.endTransaction();
                                    } catch (SQLiteException e8) {
                                        zze("Failed to commit local dispatch transaction", e8);
                                        zzkf();
                                    }
                                }
                            }
                            if (this.zzQZ.zzlB()) {
                                List<Long> listZzq2 = this.zzQZ.zzq(listZzp);
                                it = listZzq2.iterator();
                                jMax = j;
                                while (it.hasNext()) {
                                    jMax = Math.max(jMax, it.next().longValue());
                                }
                                listZzp.removeAll(listZzq2);
                                this.zzQY.zzo(listZzq2);
                                arrayList.addAll(listZzq2);
                                j = jMax;
                                if (arrayList.isEmpty()) {
                                    this.zzQY.setTransactionSuccessful();
                                    this.zzQY.endTransaction();
                                    break;
                                }
                                this.zzQY.setTransactionSuccessful();
                                this.zzQY.endTransaction();
                                jMax3 = j;
                            } else {
                                if (arrayList.isEmpty()) {
                                    this.zzQY.setTransactionSuccessful();
                                    this.zzQY.endTransaction();
                                    break;
                                }
                                this.zzQY.setTransactionSuccessful();
                                this.zzQY.endTransaction();
                                jMax3 = j;
                            }
                        }
                    } catch (SQLiteException e9) {
                        zzd("Failed to read hits from persisted store", e9);
                        zzkf();
                        try {
                            this.zzQY.setTransactionSuccessful();
                            this.zzQY.endTransaction();
                        } catch (SQLiteException e10) {
                            zze("Failed to commit local dispatch transaction", e10);
                            zzkf();
                        }
                    }
                } catch (Throwable th) {
                    try {
                        this.zzQY.setTransactionSuccessful();
                        this.zzQY.endTransaction();
                        throw th;
                    } catch (SQLiteException e11) {
                        zze("Failed to commit local dispatch transaction", e11);
                        zzkf();
                    }
                }
            }
        }
        return false;
    }

    public void zzjc() {
        com.google.android.gms.measurement.zzg.zzjk();
        zzjv();
        if (!zzjn().zzkr()) {
            zzbd("Delete all hits from local store");
            try {
                this.zzQY.zzjL();
                this.zzQY.zzjM();
                zzkb();
            } catch (SQLiteException e) {
                zzd("Failed to delete hits from store", e);
            }
        }
        zzjX();
        if (this.zzRb.zzjH()) {
            zzbd("Device service unavailable. Can't clear hits stored on the device service.");
        }
    }

    public void zzjf() {
        com.google.android.gms.measurement.zzg.zzjk();
        zzjv();
        zzbd("Service disconnected");
    }

    void zzjh() {
        zzjk();
        this.zzRg = zzjl().currentTimeMillis();
    }

    public void zzka() {
        com.google.android.gms.measurement.zzg.zzjk();
        zzjv();
        zzbe("Sync dispatching local hits");
        long j = this.zzRg;
        if (!zzjn().zzkr()) {
            zzjX();
        }
        do {
            try {
            } catch (Throwable th) {
                zze("Sync local dispatch failed", th);
                zzkb();
                return;
            }
        } while (zzjZ());
        zzjq().zzlI();
        zzkb();
        if (this.zzRg != j) {
            this.zzRa.zzlA();
        }
    }

    public void zzkb() {
        boolean zIsConnected;
        zzji().zzjk();
        zzjv();
        if (!zzkc()) {
            this.zzRa.unregister();
            zzkf();
            return;
        }
        if (this.zzQY.isEmpty()) {
            this.zzRa.unregister();
            zzkf();
            return;
        }
        if (zzy.zzSs.get().booleanValue()) {
            zIsConnected = true;
        } else {
            this.zzRa.zzly();
            zIsConnected = this.zzRa.isConnected();
        }
        if (zIsConnected) {
            zzke();
        } else {
            zzkf();
            zzkd();
        }
    }

    public long zzki() {
        if (this.zzRc != Long.MIN_VALUE) {
            return this.zzRc;
        }
        return zziI().zzll() ? ((long) zziI().zzmc()) * 1000 : zzjn().zzkz();
    }

    public void zzkj() {
        zzjv();
        zzjk();
        this.zzRh = true;
        this.zzRb.disconnect();
        zzkb();
    }

    public void zzs(long j) {
        com.google.android.gms.measurement.zzg.zzjk();
        zzjv();
        if (j < 0) {
            j = 0;
        }
        this.zzRc = j;
        zzkb();
    }
}
