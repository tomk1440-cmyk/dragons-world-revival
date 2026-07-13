package com.google.android.gms.internal;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public interface zzsy {

    public static final class zza extends zzsu {
        public String name;
        public zzb[] zzbuE;

        public zza() {
            zzJz();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zza)) {
                return false;
            }
            zza zzaVar = (zza) o;
            if (this.name == null) {
                if (zzaVar.name != null) {
                    return false;
                }
            } else if (!this.name.equals(zzaVar.name)) {
                return false;
            }
            return zzss.equals(this.zzbuE, zzaVar.zzbuE);
        }

        public int hashCode() {
            return (((this.name == null ? 0 : this.name.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31) + zzss.hashCode(this.zzbuE);
        }

        @Override // com.google.android.gms.internal.zzsu
        public void writeTo(zzsn output) throws IOException {
            if (this.name != null) {
                output.zzn(1, this.name);
            }
            if (this.zzbuE != null && this.zzbuE.length > 0) {
                for (int i = 0; i < this.zzbuE.length; i++) {
                    zzb zzbVar = this.zzbuE[i];
                    if (zzbVar != null) {
                        output.zza(2, zzbVar);
                    }
                }
            }
            super.writeTo(output);
        }

        public zza zzJz() {
            this.name = null;
            this.zzbuE = zzb.zzJA();
            this.zzbuu = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzsu
        /* JADX INFO: renamed from: zzQ, reason: merged with bridge method [inline-methods] */
        public zza mergeFrom(zzsm zzsmVar) throws IOException {
            while (true) {
                int iZzIX = zzsmVar.zzIX();
                switch (iZzIX) {
                    case 0:
                        break;
                    case 10:
                        this.name = zzsmVar.readString();
                        break;
                    case 18:
                        int iZzc = zzsx.zzc(zzsmVar, 18);
                        int length = this.zzbuE == null ? 0 : this.zzbuE.length;
                        zzb[] zzbVarArr = new zzb[iZzc + length];
                        if (length != 0) {
                            System.arraycopy(this.zzbuE, 0, zzbVarArr, 0, length);
                        }
                        while (length < zzbVarArr.length - 1) {
                            zzbVarArr[length] = new zzb();
                            zzsmVar.zza(zzbVarArr[length]);
                            zzsmVar.zzIX();
                            length++;
                        }
                        zzbVarArr[length] = new zzb();
                        zzsmVar.zza(zzbVarArr[length]);
                        this.zzbuE = zzbVarArr;
                        break;
                    default:
                        if (!zzsx.zzb(zzsmVar, iZzIX)) {
                        }
                        break;
                }
            }
            return this;
        }

        @Override // com.google.android.gms.internal.zzsu
        protected int zzz() {
            int iZzz = super.zzz();
            if (this.name != null) {
                iZzz += zzsn.zzo(1, this.name);
            }
            if (this.zzbuE == null || this.zzbuE.length <= 0) {
                return iZzz;
            }
            int iZzc = iZzz;
            for (int i = 0; i < this.zzbuE.length; i++) {
                zzb zzbVar = this.zzbuE[i];
                if (zzbVar != null) {
                    iZzc += zzsn.zzc(2, zzbVar);
                }
            }
            return iZzc;
        }
    }

    public static final class zzb extends zzsu {
        private static volatile zzb[] zzbuF;
        public String name;
        public Integer zzbuG;
        public Boolean zzbuH;

        public zzb() {
            zzJB();
        }

        public static zzb[] zzJA() {
            if (zzbuF == null) {
                synchronized (zzss.zzbut) {
                    if (zzbuF == null) {
                        zzbuF = new zzb[0];
                    }
                }
            }
            return zzbuF;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzb)) {
                return false;
            }
            zzb zzbVar = (zzb) o;
            if (this.name == null) {
                if (zzbVar.name != null) {
                    return false;
                }
            } else if (!this.name.equals(zzbVar.name)) {
                return false;
            }
            if (this.zzbuG == null) {
                if (zzbVar.zzbuG != null) {
                    return false;
                }
            } else if (!this.zzbuG.equals(zzbVar.zzbuG)) {
                return false;
            }
            if (this.zzbuH == null) {
                return zzbVar.zzbuH == null;
            }
            return this.zzbuH.equals(zzbVar.zzbuH);
        }

        public int hashCode() {
            return (((this.zzbuG == null ? 0 : this.zzbuG.intValue()) + (((this.name == null ? 0 : this.name.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31) + (this.zzbuH != null ? this.zzbuH.hashCode() : 0);
        }

        @Override // com.google.android.gms.internal.zzsu
        public void writeTo(zzsn output) throws IOException {
            if (this.name != null) {
                output.zzn(1, this.name);
            }
            if (this.zzbuG != null) {
                output.zzA(3, this.zzbuG.intValue());
            }
            if (this.zzbuH != null) {
                output.zze(4, this.zzbuH.booleanValue());
            }
            super.writeTo(output);
        }

        public zzb zzJB() {
            this.name = null;
            this.zzbuG = null;
            this.zzbuH = null;
            this.zzbuu = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzsu
        /* JADX INFO: renamed from: zzR, reason: merged with bridge method [inline-methods] */
        public zzb mergeFrom(zzsm zzsmVar) throws IOException {
            while (true) {
                int iZzIX = zzsmVar.zzIX();
                switch (iZzIX) {
                    case 0:
                        break;
                    case 10:
                        this.name = zzsmVar.readString();
                        break;
                    case 24:
                        int iZzJb = zzsmVar.zzJb();
                        switch (iZzJb) {
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                                this.zzbuG = Integer.valueOf(iZzJb);
                                break;
                        }
                        break;
                    case 32:
                        this.zzbuH = Boolean.valueOf(zzsmVar.zzJc());
                        break;
                    default:
                        if (!zzsx.zzb(zzsmVar, iZzIX)) {
                        }
                        break;
                }
            }
            return this;
        }

        @Override // com.google.android.gms.internal.zzsu
        protected int zzz() {
            int iZzz = super.zzz();
            if (this.name != null) {
                iZzz += zzsn.zzo(1, this.name);
            }
            if (this.zzbuG != null) {
                iZzz += zzsn.zzC(3, this.zzbuG.intValue());
            }
            return this.zzbuH != null ? iZzz + zzsn.zzf(4, this.zzbuH.booleanValue()) : iZzz;
        }
    }
}
