package com.google.android.gms.analytics.internal;

/* JADX INFO: loaded from: classes.dex */
public class zzz extends zzq<zzaa> {

    private static class zza implements zzq.zza<zzaa> {
        private final zzf zzQj;
        private final zzaa zzSD = new zzaa();

        public zza(zzf zzfVar) {
            this.zzQj = zzfVar;
        }

        @Override // com.google.android.gms.analytics.internal.zzq.zza
        public void zzc(String str, int i) {
            if ("ga_dispatchPeriod".equals(str)) {
                this.zzSD.zzSH = i;
            } else {
                this.zzQj.zzjm().zzd("Int xml configuration name not recognized", str);
            }
        }

        @Override // com.google.android.gms.analytics.internal.zzq.zza
        public void zzf(String str, boolean z) {
            if (!"ga_dryRun".equals(str)) {
                this.zzQj.zzjm().zzd("Bool xml configuration name not recognized", str);
            } else {
                this.zzSD.zzSI = z ? 1 : 0;
            }
        }

        @Override // com.google.android.gms.analytics.internal.zzq.zza
        public void zzj(String str, String str2) {
        }

        @Override // com.google.android.gms.analytics.internal.zzq.zza
        public void zzk(String str, String str2) {
            if ("ga_appName".equals(str)) {
                this.zzSD.zzSE = str2;
                return;
            }
            if ("ga_appVersion".equals(str)) {
                this.zzSD.zzSF = str2;
            } else if ("ga_logLevel".equals(str)) {
                this.zzSD.zzSG = str2;
            } else {
                this.zzQj.zzjm().zzd("String xml configuration name not recognized", str);
            }
        }

        @Override // com.google.android.gms.analytics.internal.zzq.zza
        /* JADX INFO: renamed from: zzle, reason: merged with bridge method [inline-methods] */
        public zzaa zzkq() {
            return this.zzSD;
        }
    }

    public zzz(zzf zzfVar) {
        super(zzfVar, new zza(zzfVar));
    }
}
