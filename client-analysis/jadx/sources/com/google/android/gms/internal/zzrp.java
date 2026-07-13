package com.google.android.gms.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.PowerManager;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class zzrp {
    private final Context mContext;
    private final String zzanQ;
    private final PowerManager.WakeLock zzbhm;
    private WorkSource zzbhn;
    private final int zzbho;
    private final String zzbhp;
    private boolean zzbhq;
    private int zzbhr;
    private int zzbhs;
    private static String TAG = "WakeLock";
    private static String zzbhl = "*gcore*:";
    private static boolean DEBUG = false;

    public zzrp(Context context, int i, String str) {
        this(context, i, str, null, context == null ? null : context.getPackageName());
    }

    @SuppressLint({"UnwrappedWakeLock"})
    public zzrp(Context context, int i, String str, String str2, String str3) {
        this.zzbhq = true;
        com.google.android.gms.common.internal.zzx.zzh(str, "Wake lock name can NOT be empty");
        this.zzbho = i;
        this.zzbhp = str2;
        this.mContext = context.getApplicationContext();
        if (zzni.zzcV(str3) || "com.google.android.gms" == str3) {
            this.zzanQ = str;
        } else {
            this.zzanQ = zzbhl + str;
        }
        this.zzbhm = ((PowerManager) context.getSystemService("power")).newWakeLock(i, str);
        if (zznj.zzaA(this.mContext)) {
            if (zzni.zzcV(str3)) {
                if (com.google.android.gms.common.internal.zzd.zzakE && zzlz.isInitialized()) {
                    Log.e(TAG, "callingPackage is not supposed to be empty for wakelock " + this.zzanQ + "!", new IllegalArgumentException());
                    str3 = "com.google.android.gms";
                } else {
                    str3 = context.getPackageName();
                }
            }
            this.zzbhn = zznj.zzl(context, str3);
            zzc(this.zzbhn);
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0077 A[Catch: all -> 0x00a3, TryCatch #0 {, blocks: (B:6:0x0069, B:8:0x006d, B:15:0x0080, B:16:0x00a1, B:11:0x0077, B:13:0x007b), top: B:21:0x0069 }] */
    /* JADX WARN: Code duplicated, block: B:15:0x0080 A[Catch: all -> 0x00a3, TryCatch #0 {, blocks: (B:6:0x0069, B:8:0x006d, B:15:0x0080, B:16:0x00a1, B:11:0x0077, B:13:0x007b), top: B:21:0x0069 }] */
    private void zzfJ(String str) {
        boolean zZzfK = zzfK(str);
        String strZzn = zzn(str, zZzfK);
        if (DEBUG) {
            Log.d(TAG, "Release:\n mWakeLockName: " + this.zzanQ + "\n mSecondaryName: " + this.zzbhp + "\nmReferenceCounted: " + this.zzbhq + "\nreason: " + str + "\n mOpenEventCount" + this.zzbhs + "\nuseWithReason: " + zZzfK + "\ntrackingName: " + strZzn);
        }
        synchronized (this) {
            if (this.zzbhq) {
                int i = this.zzbhr - 1;
                this.zzbhr = i;
                if (i == 0 || zZzfK) {
                    com.google.android.gms.common.stats.zzi.zzrZ().zza(this.mContext, com.google.android.gms.common.stats.zzg.zza(this.zzbhm, strZzn), 8, this.zzanQ, strZzn, this.zzbho, zznj.zzb(this.zzbhn));
                    this.zzbhs--;
                } else if (!this.zzbhq && this.zzbhs == 1) {
                    com.google.android.gms.common.stats.zzi.zzrZ().zza(this.mContext, com.google.android.gms.common.stats.zzg.zza(this.zzbhm, strZzn), 8, this.zzanQ, strZzn, this.zzbho, zznj.zzb(this.zzbhn));
                    this.zzbhs--;
                }
            } else if (!this.zzbhq) {
                com.google.android.gms.common.stats.zzi.zzrZ().zza(this.mContext, com.google.android.gms.common.stats.zzg.zza(this.zzbhm, strZzn), 8, this.zzanQ, strZzn, this.zzbho, zznj.zzb(this.zzbhn));
                this.zzbhs--;
            }
        }
    }

    private boolean zzfK(String str) {
        return (TextUtils.isEmpty(str) || str.equals(this.zzbhp)) ? false : true;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0081 A[Catch: all -> 0x00ac, TryCatch #0 {, blocks: (B:6:0x0073, B:8:0x0077, B:15:0x0089, B:16:0x00aa, B:11:0x0081, B:13:0x0085), top: B:21:0x0073 }] */
    /* JADX WARN: Code duplicated, block: B:15:0x0089 A[Catch: all -> 0x00ac, TryCatch #0 {, blocks: (B:6:0x0073, B:8:0x0077, B:15:0x0089, B:16:0x00aa, B:11:0x0081, B:13:0x0085), top: B:21:0x0073 }] */
    private void zzj(String str, long j) {
        boolean zZzfK = zzfK(str);
        String strZzn = zzn(str, zZzfK);
        if (DEBUG) {
            Log.d(TAG, "Acquire:\n mWakeLockName: " + this.zzanQ + "\n mSecondaryName: " + this.zzbhp + "\nmReferenceCounted: " + this.zzbhq + "\nreason: " + str + "\nmOpenEventCount" + this.zzbhs + "\nuseWithReason: " + zZzfK + "\ntrackingName: " + strZzn + "\ntimeout: " + j);
        }
        synchronized (this) {
            if (this.zzbhq) {
                int i = this.zzbhr;
                this.zzbhr = i + 1;
                if (i == 0 || zZzfK) {
                    com.google.android.gms.common.stats.zzi.zzrZ().zza(this.mContext, com.google.android.gms.common.stats.zzg.zza(this.zzbhm, strZzn), 7, this.zzanQ, strZzn, this.zzbho, zznj.zzb(this.zzbhn), j);
                    this.zzbhs++;
                } else if (!this.zzbhq && this.zzbhs == 0) {
                    com.google.android.gms.common.stats.zzi.zzrZ().zza(this.mContext, com.google.android.gms.common.stats.zzg.zza(this.zzbhm, strZzn), 7, this.zzanQ, strZzn, this.zzbho, zznj.zzb(this.zzbhn), j);
                    this.zzbhs++;
                }
            } else if (!this.zzbhq) {
                com.google.android.gms.common.stats.zzi.zzrZ().zza(this.mContext, com.google.android.gms.common.stats.zzg.zza(this.zzbhm, strZzn), 7, this.zzanQ, strZzn, this.zzbho, zznj.zzb(this.zzbhn), j);
                this.zzbhs++;
            }
        }
    }

    private String zzn(String str, boolean z) {
        return (this.zzbhq && z) ? str : this.zzbhp;
    }

    public void acquire(long timeout) {
        if (!zzne.zzsg() && this.zzbhq) {
            Log.wtf(TAG, "Do not acquire with timeout on reference counted WakeLocks before ICS. wakelock: " + this.zzanQ);
        }
        zzj(null, timeout);
        this.zzbhm.acquire(timeout);
    }

    public boolean isHeld() {
        return this.zzbhm.isHeld();
    }

    public void release() {
        zzfJ(null);
        this.zzbhm.release();
    }

    public void setReferenceCounted(boolean value) {
        this.zzbhm.setReferenceCounted(value);
        this.zzbhq = value;
    }

    public void zzc(WorkSource workSource) {
        if (!zznj.zzaA(this.mContext) || workSource == null) {
            return;
        }
        if (this.zzbhn != null) {
            this.zzbhn.add(workSource);
        } else {
            this.zzbhn = workSource;
        }
        this.zzbhm.setWorkSource(this.zzbhn);
    }
}
