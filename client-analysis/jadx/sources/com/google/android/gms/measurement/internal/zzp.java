package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.internal.zzmq;
import com.google.android.gms.measurement.AppMeasurement;

/* JADX INFO: loaded from: classes.dex */
public class zzp extends zzz {
    private final long zzaVj;
    private final char zzaWB;
    private final zza zzaWC;
    private final zza zzaWD;
    private final zza zzaWE;
    private final zza zzaWF;
    private final zza zzaWG;
    private final zza zzaWH;
    private final zza zzaWI;
    private final zza zzaWJ;
    private final zza zzaWK;
    private final String zzamn;

    public class zza {
        private final int mPriority;
        private final boolean zzaWN;
        private final boolean zzaWO;

        zza(int i, boolean z, boolean z2) {
            this.mPriority = i;
            this.zzaWN = z;
            this.zzaWO = z2;
        }

        public void zzd(String str, Object obj, Object obj2, Object obj3) {
            zzp.this.zza(this.mPriority, this.zzaWN, this.zzaWO, str, obj, obj2, obj3);
        }

        public void zze(String str, Object obj, Object obj2) {
            zzp.this.zza(this.mPriority, this.zzaWN, this.zzaWO, str, obj, obj2, null);
        }

        public void zzfg(String str) {
            zzp.this.zza(this.mPriority, this.zzaWN, this.zzaWO, str, null, null, null);
        }

        public void zzj(String str, Object obj) {
            zzp.this.zza(this.mPriority, this.zzaWN, this.zzaWO, str, obj, null, null);
        }
    }

    zzp(zzw zzwVar) {
        super(zzwVar);
        this.zzamn = zzCp().zzBz();
        this.zzaVj = zzCp().zzBp();
        if (zzCp().zzks()) {
            this.zzaWB = zzCp().zzkr() ? 'P' : 'C';
        } else {
            this.zzaWB = zzCp().zzkr() ? 'p' : 'c';
        }
        this.zzaWC = new zza(6, false, false);
        this.zzaWD = new zza(6, true, false);
        this.zzaWE = new zza(6, false, true);
        this.zzaWF = new zza(5, false, false);
        this.zzaWG = new zza(5, true, false);
        this.zzaWH = new zza(5, false, true);
        this.zzaWI = new zza(4, false, false);
        this.zzaWJ = new zza(3, false, false);
        this.zzaWK = new zza(2, false, false);
    }

    static String zza(boolean z, String str, Object obj, Object obj2, Object obj3) {
        if (str == null) {
            str = "";
        }
        String strZzc = zzc(z, obj);
        String strZzc2 = zzc(z, obj2);
        String strZzc3 = zzc(z, obj3);
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            str2 = ": ";
        }
        if (!TextUtils.isEmpty(strZzc)) {
            sb.append(str2);
            sb.append(strZzc);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(strZzc2)) {
            sb.append(str2);
            sb.append(strZzc2);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(strZzc3)) {
            sb.append(str2);
            sb.append(strZzc3);
        }
        return sb.toString();
    }

    static String zzc(boolean z, Object obj) {
        String className;
        if (obj == null) {
            return "";
        }
        Object objValueOf = obj instanceof Integer ? Long.valueOf(((Integer) obj).intValue()) : obj;
        if (objValueOf instanceof Long) {
            if (z && Math.abs(((Long) objValueOf).longValue()) >= 100) {
                String str = String.valueOf(objValueOf).charAt(0) == '-' ? "-" : "";
                String strValueOf = String.valueOf(Math.abs(((Long) objValueOf).longValue()));
                return str + Math.round(Math.pow(10.0d, strValueOf.length() - 1)) + "..." + str + Math.round(Math.pow(10.0d, strValueOf.length()) - 1.0d);
            }
            return String.valueOf(objValueOf);
        }
        if (objValueOf instanceof Boolean) {
            return String.valueOf(objValueOf);
        }
        if (!(objValueOf instanceof Throwable)) {
            return z ? "-" : String.valueOf(objValueOf);
        }
        Throwable th = (Throwable) objValueOf;
        StringBuilder sb = new StringBuilder(th.toString());
        String strZzff = zzff(AppMeasurement.class.getCanonicalName());
        String strZzff2 = zzff(zzw.class.getCanonicalName());
        for (StackTraceElement stackTraceElement : th.getStackTrace()) {
            if (!stackTraceElement.isNativeMethod() && (className = stackTraceElement.getClassName()) != null) {
                String strZzff3 = zzff(className);
                if (strZzff3.equals(strZzff) || strZzff3.equals(strZzff2)) {
                    sb.append(": ");
                    sb.append(stackTraceElement);
                    break;
                }
            }
        }
        return sb.toString();
    }

    private static String zzff(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int iLastIndexOf = str.lastIndexOf(46);
        return iLastIndexOf != -1 ? str.substring(0, iLastIndexOf) : str;
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzp zzAo() {
        return super.zzAo();
    }

    public zza zzCE() {
        return this.zzaWC;
    }

    public zza zzCF() {
        return this.zzaWF;
    }

    public zza zzCG() {
        return this.zzaWG;
    }

    public zza zzCH() {
        return this.zzaWH;
    }

    public zza zzCI() {
        return this.zzaWI;
    }

    public zza zzCJ() {
        return this.zzaWJ;
    }

    public zza zzCK() {
        return this.zzaWK;
    }

    public String zzCL() {
        Pair<String, Long> pairZzlN = zzCo().zzaXi.zzlN();
        if (pairZzlN == null) {
            return null;
        }
        return String.valueOf(pairZzlN.second) + ":" + ((String) pairZzlN.first);
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

    protected boolean zzQ(int i) {
        return Log.isLoggable(this.zzamn, i);
    }

    protected void zza(int i, boolean z, boolean z2, String str, Object obj, Object obj2, Object obj3) {
        if (!z && zzQ(i)) {
            zzl(i, zza(false, str, obj, obj2, obj3));
        }
        if (z2 || i < 5) {
            return;
        }
        zzb(i, str, obj, obj2, obj3);
    }

    public void zzb(int i, String str, Object obj, Object obj2, Object obj3) {
        com.google.android.gms.common.internal.zzx.zzz(str);
        zzv zzvVarZzCU = this.zzaTV.zzCU();
        if (zzvVarZzCU == null) {
            zzl(6, "Scheduler not set. Not logging error/warn.");
            return;
        }
        if (!zzvVarZzCU.isInitialized()) {
            zzl(6, "Scheduler not initialized. Not logging error/warn.");
            return;
        }
        if (zzvVarZzCU.zzDi()) {
            zzl(6, "Scheduler shutdown. Not logging error/warn.");
            return;
        }
        if (i < 0) {
            i = 0;
        }
        if (i >= "01VDIWEA?".length()) {
            i = "01VDIWEA?".length() - 1;
        }
        String str2 = AppEventsConstants.EVENT_PARAM_VALUE_YES + "01VDIWEA?".charAt(i) + this.zzaWB + this.zzaVj + ":" + zza(true, str, obj, obj2, obj3);
        final String strSubstring = str2.length() > 1024 ? str.substring(0, 1024) : str2;
        zzvVarZzCU.zzg(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzp.1
            @Override // java.lang.Runnable
            public void run() {
                zzt zztVarZzCo = zzp.this.zzaTV.zzCo();
                if (!zztVarZzCo.isInitialized() || zztVarZzCo.zzDi()) {
                    zzp.this.zzl(6, "Persisted config not initialized . Not logging error/warn.");
                } else {
                    zztVarZzCo.zzaXi.zzbq(strSubstring);
                }
            }
        });
    }

    @Override // com.google.android.gms.measurement.internal.zzz
    protected void zziJ() {
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

    protected void zzl(int i, String str) {
        Log.println(i, this.zzamn, str);
    }
}
