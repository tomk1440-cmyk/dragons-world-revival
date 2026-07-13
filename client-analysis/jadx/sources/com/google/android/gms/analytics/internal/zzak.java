package com.google.android.gms.analytics.internal;

/* JADX INFO: loaded from: classes.dex */
public class zzak extends zzq<zzal> {

    private static class zza extends zzc implements zzq.zza<zzal> {
        private final zzal zzTn;

        public zza(zzf zzfVar) {
            super(zzfVar);
            this.zzTn = new zzal();
        }

        @Override // com.google.android.gms.analytics.internal.zzq.zza
        public void zzc(String str, int i) {
            if ("ga_sessionTimeout".equals(str)) {
                this.zzTn.zzTp = i;
            } else {
                zzd("int configuration name not recognized", str);
            }
        }

        @Override // com.google.android.gms.analytics.internal.zzq.zza
        public void zzf(String str, boolean z) {
            if ("ga_autoActivityTracking".equals(str)) {
                this.zzTn.zzTq = z ? 1 : 0;
                return;
            }
            if ("ga_anonymizeIp".equals(str)) {
                this.zzTn.zzTr = z ? 1 : 0;
            } else if (!"ga_reportUncaughtExceptions".equals(str)) {
                zzd("bool configuration name not recognized", str);
            } else {
                this.zzTn.zzTs = z ? 1 : 0;
            }
        }

        @Override // com.google.android.gms.analytics.internal.zzq.zza
        public void zzj(String str, String str2) {
            this.zzTn.zzTt.put(str, str2);
        }

        @Override // com.google.android.gms.analytics.internal.zzq.zza
        public void zzk(String str, String str2) {
            if ("ga_trackingId".equals(str)) {
                this.zzTn.zzOV = str2;
                return;
            }
            if (!"ga_sampleFrequency".equals(str)) {
                zzd("string configuration name not recognized", str);
                return;
            }
            try {
                this.zzTn.zzTo = Double.parseDouble(str2);
            } catch (NumberFormatException e) {
                zzc("Error parsing ga_sampleFrequency value", str2, e);
            }
        }

        @Override // com.google.android.gms.analytics.internal.zzq.zza
        /* JADX INFO: renamed from: zzlS, reason: merged with bridge method [inline-methods] */
        public zzal zzkq() {
            return this.zzTn;
        }
    }

    public zzak(zzf zzfVar) {
        super(zzfVar, new zza(zzfVar));
    }
}
