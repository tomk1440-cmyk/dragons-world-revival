package com.google.android.gms.internal;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public interface zzrq {

    public static final class zza extends zzso<zza> {
        public long zzbmd;
        public zzaf.zzj zzbme;
        public zzaf.zzf zzju;

        public zza() {
            zzHG();
        }

        public static zza zzy(byte[] bArr) throws zzst {
            return (zza) zzsu.mergeFrom(new zza(), bArr);
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zza)) {
                return false;
            }
            zza zzaVar = (zza) o;
            if (this.zzbmd != zzaVar.zzbmd) {
                return false;
            }
            if (this.zzju == null) {
                if (zzaVar.zzju != null) {
                    return false;
                }
            } else if (!this.zzju.equals(zzaVar.zzju)) {
                return false;
            }
            if (this.zzbme == null) {
                if (zzaVar.zzbme != null) {
                    return false;
                }
            } else if (!this.zzbme.equals(zzaVar.zzbme)) {
                return false;
            }
            if (this.zzbuj == null || this.zzbuj.isEmpty()) {
                return zzaVar.zzbuj == null || zzaVar.zzbuj.isEmpty();
            }
            return this.zzbuj.equals(zzaVar.zzbuj);
        }

        public int hashCode() {
            int iHashCode = 0;
            int iHashCode2 = ((this.zzbme == null ? 0 : this.zzbme.hashCode()) + (((this.zzju == null ? 0 : this.zzju.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + ((int) (this.zzbmd ^ (this.zzbmd >>> 32)))) * 31)) * 31)) * 31;
            if (this.zzbuj != null && !this.zzbuj.isEmpty()) {
                iHashCode = this.zzbuj.hashCode();
            }
            return iHashCode2 + iHashCode;
        }

        @Override // com.google.android.gms.internal.zzso, com.google.android.gms.internal.zzsu
        public void writeTo(zzsn output) throws IOException {
            output.zzb(1, this.zzbmd);
            if (this.zzju != null) {
                output.zza(2, this.zzju);
            }
            if (this.zzbme != null) {
                output.zza(3, this.zzbme);
            }
            super.writeTo(output);
        }

        public zza zzHG() {
            this.zzbmd = 0L;
            this.zzju = null;
            this.zzbme = null;
            this.zzbuj = null;
            this.zzbuu = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzsu
        /* JADX INFO: renamed from: zzJ, reason: merged with bridge method [inline-methods] */
        public zza mergeFrom(zzsm zzsmVar) throws IOException {
            while (true) {
                int iZzIX = zzsmVar.zzIX();
                switch (iZzIX) {
                    case 0:
                        break;
                    case 8:
                        this.zzbmd = zzsmVar.zzJa();
                        break;
                    case 18:
                        if (this.zzju == null) {
                            this.zzju = new zzaf.zzf();
                        }
                        zzsmVar.zza(this.zzju);
                        break;
                    case 26:
                        if (this.zzbme == null) {
                            this.zzbme = new zzaf.zzj();
                        }
                        zzsmVar.zza(this.zzbme);
                        break;
                    default:
                        if (!zza(zzsmVar, iZzIX)) {
                        }
                        break;
                }
            }
            return this;
        }

        @Override // com.google.android.gms.internal.zzso, com.google.android.gms.internal.zzsu
        protected int zzz() {
            int iZzz = super.zzz() + zzsn.zzd(1, this.zzbmd);
            if (this.zzju != null) {
                iZzz += zzsn.zzc(2, this.zzju);
            }
            return this.zzbme != null ? iZzz + zzsn.zzc(3, this.zzbme) : iZzz;
        }
    }
}
