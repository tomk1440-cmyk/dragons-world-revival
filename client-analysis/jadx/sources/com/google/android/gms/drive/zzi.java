package com.google.android.gms.drive;

/* JADX INFO: loaded from: classes.dex */
public class zzi extends ExecutionOptions {
    private boolean zzapa;

    public static class zza extends ExecutionOptions.Builder {
        private boolean zzapa = true;

        @Override // com.google.android.gms.drive.ExecutionOptions.Builder
        /* JADX INFO: renamed from: zzae, reason: merged with bridge method [inline-methods] */
        public zza setNotifyOnCompletion(boolean z) {
            super.setNotifyOnCompletion(z);
            return this;
        }

        @Override // com.google.android.gms.drive.ExecutionOptions.Builder
        /* JADX INFO: renamed from: zzcZ, reason: merged with bridge method [inline-methods] */
        public zza setTrackingTag(String str) {
            super.setTrackingTag(str);
            return this;
        }

        @Override // com.google.android.gms.drive.ExecutionOptions.Builder
        /* JADX INFO: renamed from: zzcy, reason: merged with bridge method [inline-methods] */
        public zza setConflictStrategy(int i) {
            super.setConflictStrategy(i);
            return this;
        }

        @Override // com.google.android.gms.drive.ExecutionOptions.Builder
        /* JADX INFO: renamed from: zzsJ, reason: merged with bridge method [inline-methods] */
        public zzi build() {
            zzsE();
            return new zzi(this.zzaoV, this.zzaoW, this.zzaoX, this.zzapa);
        }
    }

    private zzi(String str, boolean z, int i, boolean z2) {
        super(str, z, i);
        this.zzapa = z2;
    }

    public static zzi zzb(ExecutionOptions executionOptions) {
        zza zzaVar = new zza();
        if (executionOptions != null) {
            zzaVar.setConflictStrategy(executionOptions.zzsD());
            zzaVar.setNotifyOnCompletion(executionOptions.zzsC());
            String strZzsB = executionOptions.zzsB();
            if (strZzsB != null) {
                zzaVar.setTrackingTag(strZzsB);
            }
        }
        return zzaVar.build();
    }

    public boolean zzsI() {
        return this.zzapa;
    }
}
