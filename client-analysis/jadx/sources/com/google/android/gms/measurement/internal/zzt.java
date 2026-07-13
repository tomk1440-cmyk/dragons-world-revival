package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
class zzt extends zzz {
    static final Pair<String, Long> zzaXh = new Pair<>("", 0L);
    private SharedPreferences zzTh;
    public final zzc zzaXi;
    public final zzb zzaXj;
    public final zzb zzaXk;
    public final zzb zzaXl;
    public final zzb zzaXm;
    public final zzb zzaXn;
    private String zzaXo;
    private boolean zzaXp;
    private long zzaXq;
    private final SecureRandom zzaXr;
    public final zzb zzaXs;
    public final zzb zzaXt;
    public final zza zzaXu;
    public final zzb zzaXv;
    public final zzb zzaXw;
    public boolean zzaXx;

    public final class zza {
        private final boolean zzaXy;
        private boolean zzaXz;
        private boolean zzagf;
        private final String zzvs;

        public zza(String str, boolean z) {
            com.google.android.gms.common.internal.zzx.zzcM(str);
            this.zzvs = str;
            this.zzaXy = z;
        }

        @WorkerThread
        private void zzCR() {
            if (this.zzaXz) {
                return;
            }
            this.zzaXz = true;
            this.zzagf = zzt.this.zzTh.getBoolean(this.zzvs, this.zzaXy);
        }

        @WorkerThread
        public boolean get() {
            zzCR();
            return this.zzagf;
        }

        @WorkerThread
        public void set(boolean value) {
            SharedPreferences.Editor editorEdit = zzt.this.zzTh.edit();
            editorEdit.putBoolean(this.zzvs, value);
            editorEdit.apply();
            this.zzagf = value;
        }
    }

    public final class zzb {
        private long zzaDV;
        private final long zzaXB;
        private boolean zzaXz;
        private final String zzvs;

        public zzb(String str, long j) {
            com.google.android.gms.common.internal.zzx.zzcM(str);
            this.zzvs = str;
            this.zzaXB = j;
        }

        @WorkerThread
        private void zzCR() {
            if (this.zzaXz) {
                return;
            }
            this.zzaXz = true;
            this.zzaDV = zzt.this.zzTh.getLong(this.zzvs, this.zzaXB);
        }

        @WorkerThread
        public long get() {
            zzCR();
            return this.zzaDV;
        }

        @WorkerThread
        public void set(long value) {
            SharedPreferences.Editor editorEdit = zzt.this.zzTh.edit();
            editorEdit.putLong(this.zzvs, value);
            editorEdit.apply();
            this.zzaDV = value;
        }
    }

    public final class zzc {
        private final long zzTl;
        final String zzaXC;
        private final String zzaXD;
        private final String zzaXE;

        private zzc(String str, long j) {
            com.google.android.gms.common.internal.zzx.zzcM(str);
            com.google.android.gms.common.internal.zzx.zzac(j > 0);
            this.zzaXC = str + ":start";
            this.zzaXD = str + ":count";
            this.zzaXE = str + ":value";
            this.zzTl = j;
        }

        @WorkerThread
        private void zzlL() {
            zzt.this.zzjk();
            long jCurrentTimeMillis = zzt.this.zzjl().currentTimeMillis();
            SharedPreferences.Editor editorEdit = zzt.this.zzTh.edit();
            editorEdit.remove(this.zzaXD);
            editorEdit.remove(this.zzaXE);
            editorEdit.putLong(this.zzaXC, jCurrentTimeMillis);
            editorEdit.apply();
        }

        @WorkerThread
        private long zzlM() {
            zzt.this.zzjk();
            long jZzlO = zzlO();
            if (jZzlO != 0) {
                return Math.abs(jZzlO - zzt.this.zzjl().currentTimeMillis());
            }
            zzlL();
            return 0L;
        }

        @WorkerThread
        private long zzlO() {
            return zzt.this.zzCO().getLong(this.zzaXC, 0L);
        }

        @WorkerThread
        public void zzbq(String str) {
            zzf(str, 1L);
        }

        @WorkerThread
        public void zzf(String str, long j) {
            zzt.this.zzjk();
            if (zzlO() == 0) {
                zzlL();
            }
            if (str == null) {
                str = "";
            }
            long j2 = zzt.this.zzTh.getLong(this.zzaXD, 0L);
            if (j2 <= 0) {
                SharedPreferences.Editor editorEdit = zzt.this.zzTh.edit();
                editorEdit.putString(this.zzaXE, str);
                editorEdit.putLong(this.zzaXD, j);
                editorEdit.apply();
                return;
            }
            boolean z = (zzt.this.zzaXr.nextLong() & Long.MAX_VALUE) < (Long.MAX_VALUE / (j2 + j)) * j;
            SharedPreferences.Editor editorEdit2 = zzt.this.zzTh.edit();
            if (z) {
                editorEdit2.putString(this.zzaXE, str);
            }
            editorEdit2.putLong(this.zzaXD, j2 + j);
            editorEdit2.apply();
        }

        @WorkerThread
        public Pair<String, Long> zzlN() {
            zzt.this.zzjk();
            long jZzlM = zzlM();
            if (jZzlM < this.zzTl) {
                return null;
            }
            if (jZzlM > this.zzTl * 2) {
                zzlL();
                return null;
            }
            String string = zzt.this.zzCO().getString(this.zzaXE, null);
            long j = zzt.this.zzCO().getLong(this.zzaXD, 0L);
            zzlL();
            return (string == null || j <= 0) ? zzt.zzaXh : new Pair<>(string, Long.valueOf(j));
        }
    }

    zzt(zzw zzwVar) {
        super(zzwVar);
        this.zzaXi = new zzc("health_monitor", zzCp().zzkX());
        this.zzaXj = new zzb("last_upload", 0L);
        this.zzaXk = new zzb("last_upload_attempt", 0L);
        this.zzaXl = new zzb("backoff", 0L);
        this.zzaXm = new zzb("last_delete_stale", 0L);
        this.zzaXs = new zzb("time_before_start", 10000L);
        this.zzaXt = new zzb("session_timeout", 1800000L);
        this.zzaXu = new zza("start_new_session", true);
        this.zzaXv = new zzb("last_pause_time", 0L);
        this.zzaXw = new zzb("time_active", 0L);
        this.zzaXr = new SecureRandom();
        this.zzaXn = new zzb("midnight_offset", 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public SharedPreferences zzCO() {
        zzjk();
        zzjv();
        return this.zzTh;
    }

    @WorkerThread
    void setMeasurementEnabled(boolean enabled) {
        zzjk();
        zzAo().zzCK().zzj("Setting measurementEnabled", Boolean.valueOf(enabled));
        SharedPreferences.Editor editorEdit = zzCO().edit();
        editorEdit.putBoolean("measurement_enabled", enabled);
        editorEdit.apply();
    }

    @WorkerThread
    boolean zzAr() {
        zzjk();
        return zzCO().getBoolean("measurement_enabled", !com.google.android.gms.measurement.zza.zzAs());
    }

    String zzCM() {
        byte[] bArr = new byte[16];
        this.zzaXr.nextBytes(bArr);
        return String.format(Locale.US, "%032x", new BigInteger(1, bArr));
    }

    @WorkerThread
    long zzCN() {
        zzjv();
        zzjk();
        long j = this.zzaXn.get();
        if (j != 0) {
            return j;
        }
        long jNextInt = this.zzaXr.nextInt(86400000) + 1;
        this.zzaXn.set(jNextInt);
        return jNextInt;
    }

    @WorkerThread
    Boolean zzCP() {
        zzjk();
        if (zzCO().contains("use_service")) {
            return Boolean.valueOf(zzCO().getBoolean("use_service", false));
        }
        return null;
    }

    @WorkerThread
    protected String zzCQ() {
        zzjk();
        String string = zzCO().getString("previous_os_version", null);
        String strZzCy = zzCh().zzCy();
        if (!TextUtils.isEmpty(strZzCy) && !strZzCy.equals(string)) {
            SharedPreferences.Editor editorEdit = zzCO().edit();
            editorEdit.putString("previous_os_version", strZzCy);
            editorEdit.apply();
        }
        return string;
    }

    @WorkerThread
    void zzar(boolean z) {
        zzjk();
        zzAo().zzCK().zzj("Setting useService", Boolean.valueOf(z));
        SharedPreferences.Editor editorEdit = zzCO().edit();
        editorEdit.putBoolean("use_service", z);
        editorEdit.apply();
    }

    @WorkerThread
    Pair<String, Boolean> zzfh(String str) {
        zzjk();
        long jElapsedRealtime = zzjl().elapsedRealtime();
        if (this.zzaXo != null && jElapsedRealtime < this.zzaXq) {
            return new Pair<>(this.zzaXo, Boolean.valueOf(this.zzaXp));
        }
        this.zzaXq = jElapsedRealtime + zzCp().zzeS(str);
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(getContext());
            this.zzaXo = advertisingIdInfo.getId();
            this.zzaXp = advertisingIdInfo.isLimitAdTrackingEnabled();
        } catch (Throwable th) {
            zzAo().zzCJ().zzj("Unable to get advertising id", th);
            this.zzaXo = "";
        }
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
        return new Pair<>(this.zzaXo, Boolean.valueOf(this.zzaXp));
    }

    String zzfi(String str) {
        String str2 = (String) zzfh(str).first;
        MessageDigest messageDigestZzbv = zzaj.zzbv("MD5");
        if (messageDigestZzbv == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new BigInteger(1, messageDigestZzbv.digest(str2.getBytes())));
    }

    @Override // com.google.android.gms.measurement.internal.zzz
    protected void zziJ() {
        this.zzTh = getContext().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        this.zzaXx = this.zzTh.getBoolean("has_been_opened", false);
        if (this.zzaXx) {
            return;
        }
        SharedPreferences.Editor editorEdit = this.zzTh.edit();
        editorEdit.putBoolean("has_been_opened", true);
        editorEdit.apply();
    }
}
