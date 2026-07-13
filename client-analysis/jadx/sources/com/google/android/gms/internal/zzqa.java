package com.google.android.gms.internal;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public interface zzqa {

    public static final class zza extends zzsu {
        private static volatile zza[] zzaZR;
        public String name;
        public Boolean zzaZS;

        public zza() {
            zzDL();
        }

        public static zza[] zzDK() {
            if (zzaZR == null) {
                synchronized (zzss.zzbut) {
                    if (zzaZR == null) {
                        zzaZR = new zza[0];
                    }
                }
            }
            return zzaZR;
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
            if (this.zzaZS == null) {
                return zzaVar.zzaZS == null;
            }
            return this.zzaZS.equals(zzaVar.zzaZS);
        }

        public int hashCode() {
            return (((this.name == null ? 0 : this.name.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31) + (this.zzaZS != null ? this.zzaZS.hashCode() : 0);
        }

        @Override // com.google.android.gms.internal.zzsu
        public void writeTo(zzsn output) throws IOException {
            if (this.name != null) {
                output.zzn(1, this.name);
            }
            if (this.zzaZS != null) {
                output.zze(2, this.zzaZS.booleanValue());
            }
            super.writeTo(output);
        }

        public zza zzDL() {
            this.name = null;
            this.zzaZS = null;
            this.zzbuu = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzsu
        protected int zzz() {
            int iZzz = super.zzz();
            if (this.name != null) {
                iZzz += zzsn.zzo(1, this.name);
            }
            return this.zzaZS != null ? iZzz + zzsn.zzf(2, this.zzaZS.booleanValue()) : iZzz;
        }

        @Override // com.google.android.gms.internal.zzsu
        /* JADX INFO: renamed from: zzz, reason: merged with bridge method [inline-methods] */
        public zza mergeFrom(zzsm zzsmVar) throws IOException {
            while (true) {
                int iZzIX = zzsmVar.zzIX();
                switch (iZzIX) {
                    case 0:
                        break;
                    case 10:
                        this.name = zzsmVar.readString();
                        break;
                    case 16:
                        this.zzaZS = Boolean.valueOf(zzsmVar.zzJc());
                        break;
                    default:
                        if (!zzsx.zzb(zzsmVar, iZzIX)) {
                        }
                        break;
                }
            }
            return this;
        }
    }

    public static final class zzb extends zzsu {
        public String zzaVt;
        public Long zzaZT;
        public Integer zzaZU;
        public zzc[] zzaZV;
        public zza[] zzaZW;
        public zzpz.zza[] zzaZX;

        public zzb() {
            zzDM();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzb)) {
                return false;
            }
            zzb zzbVar = (zzb) o;
            if (this.zzaZT == null) {
                if (zzbVar.zzaZT != null) {
                    return false;
                }
            } else if (!this.zzaZT.equals(zzbVar.zzaZT)) {
                return false;
            }
            if (this.zzaVt == null) {
                if (zzbVar.zzaVt != null) {
                    return false;
                }
            } else if (!this.zzaVt.equals(zzbVar.zzaVt)) {
                return false;
            }
            if (this.zzaZU == null) {
                if (zzbVar.zzaZU != null) {
                    return false;
                }
            } else if (!this.zzaZU.equals(zzbVar.zzaZU)) {
                return false;
            }
            return zzss.equals(this.zzaZV, zzbVar.zzaZV) && zzss.equals(this.zzaZW, zzbVar.zzaZW) && zzss.equals(this.zzaZX, zzbVar.zzaZX);
        }

        public int hashCode() {
            return (((((((((this.zzaVt == null ? 0 : this.zzaVt.hashCode()) + (((this.zzaZT == null ? 0 : this.zzaZT.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31) + (this.zzaZU != null ? this.zzaZU.hashCode() : 0)) * 31) + zzss.hashCode(this.zzaZV)) * 31) + zzss.hashCode(this.zzaZW)) * 31) + zzss.hashCode(this.zzaZX);
        }

        @Override // com.google.android.gms.internal.zzsu
        public void writeTo(zzsn output) throws IOException {
            if (this.zzaZT != null) {
                output.zzb(1, this.zzaZT.longValue());
            }
            if (this.zzaVt != null) {
                output.zzn(2, this.zzaVt);
            }
            if (this.zzaZU != null) {
                output.zzA(3, this.zzaZU.intValue());
            }
            if (this.zzaZV != null && this.zzaZV.length > 0) {
                for (int i = 0; i < this.zzaZV.length; i++) {
                    zzc zzcVar = this.zzaZV[i];
                    if (zzcVar != null) {
                        output.zza(4, zzcVar);
                    }
                }
            }
            if (this.zzaZW != null && this.zzaZW.length > 0) {
                for (int i2 = 0; i2 < this.zzaZW.length; i2++) {
                    zza zzaVar = this.zzaZW[i2];
                    if (zzaVar != null) {
                        output.zza(5, zzaVar);
                    }
                }
            }
            if (this.zzaZX != null && this.zzaZX.length > 0) {
                for (int i3 = 0; i3 < this.zzaZX.length; i3++) {
                    zzpz.zza zzaVar2 = this.zzaZX[i3];
                    if (zzaVar2 != null) {
                        output.zza(6, zzaVar2);
                    }
                }
            }
            super.writeTo(output);
        }

        @Override // com.google.android.gms.internal.zzsu
        /* JADX INFO: renamed from: zzA, reason: merged with bridge method [inline-methods] */
        public zzb mergeFrom(zzsm zzsmVar) throws IOException {
            while (true) {
                int iZzIX = zzsmVar.zzIX();
                switch (iZzIX) {
                    case 0:
                        break;
                    case 8:
                        this.zzaZT = Long.valueOf(zzsmVar.zzJa());
                        break;
                    case 18:
                        this.zzaVt = zzsmVar.readString();
                        break;
                    case 24:
                        this.zzaZU = Integer.valueOf(zzsmVar.zzJb());
                        break;
                    case 34:
                        int iZzc = zzsx.zzc(zzsmVar, 34);
                        int length = this.zzaZV == null ? 0 : this.zzaZV.length;
                        zzc[] zzcVarArr = new zzc[iZzc + length];
                        if (length != 0) {
                            System.arraycopy(this.zzaZV, 0, zzcVarArr, 0, length);
                        }
                        while (length < zzcVarArr.length - 1) {
                            zzcVarArr[length] = new zzc();
                            zzsmVar.zza(zzcVarArr[length]);
                            zzsmVar.zzIX();
                            length++;
                        }
                        zzcVarArr[length] = new zzc();
                        zzsmVar.zza(zzcVarArr[length]);
                        this.zzaZV = zzcVarArr;
                        break;
                    case 42:
                        int iZzc2 = zzsx.zzc(zzsmVar, 42);
                        int length2 = this.zzaZW == null ? 0 : this.zzaZW.length;
                        zza[] zzaVarArr = new zza[iZzc2 + length2];
                        if (length2 != 0) {
                            System.arraycopy(this.zzaZW, 0, zzaVarArr, 0, length2);
                        }
                        while (length2 < zzaVarArr.length - 1) {
                            zzaVarArr[length2] = new zza();
                            zzsmVar.zza(zzaVarArr[length2]);
                            zzsmVar.zzIX();
                            length2++;
                        }
                        zzaVarArr[length2] = new zza();
                        zzsmVar.zza(zzaVarArr[length2]);
                        this.zzaZW = zzaVarArr;
                        break;
                    case 50:
                        int iZzc3 = zzsx.zzc(zzsmVar, 50);
                        int length3 = this.zzaZX == null ? 0 : this.zzaZX.length;
                        zzpz.zza[] zzaVarArr2 = new zzpz.zza[iZzc3 + length3];
                        if (length3 != 0) {
                            System.arraycopy(this.zzaZX, 0, zzaVarArr2, 0, length3);
                        }
                        while (length3 < zzaVarArr2.length - 1) {
                            zzaVarArr2[length3] = new zzpz.zza();
                            zzsmVar.zza(zzaVarArr2[length3]);
                            zzsmVar.zzIX();
                            length3++;
                        }
                        zzaVarArr2[length3] = new zzpz.zza();
                        zzsmVar.zza(zzaVarArr2[length3]);
                        this.zzaZX = zzaVarArr2;
                        break;
                    default:
                        if (!zzsx.zzb(zzsmVar, iZzIX)) {
                        }
                        break;
                }
            }
            return this;
        }

        public zzb zzDM() {
            this.zzaZT = null;
            this.zzaVt = null;
            this.zzaZU = null;
            this.zzaZV = zzc.zzDN();
            this.zzaZW = zza.zzDK();
            this.zzaZX = zzpz.zza.zzDA();
            this.zzbuu = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzsu
        protected int zzz() {
            int iZzz = super.zzz();
            if (this.zzaZT != null) {
                iZzz += zzsn.zzd(1, this.zzaZT.longValue());
            }
            if (this.zzaVt != null) {
                iZzz += zzsn.zzo(2, this.zzaVt);
            }
            if (this.zzaZU != null) {
                iZzz += zzsn.zzC(3, this.zzaZU.intValue());
            }
            if (this.zzaZV != null && this.zzaZV.length > 0) {
                int iZzc = iZzz;
                for (int i = 0; i < this.zzaZV.length; i++) {
                    zzc zzcVar = this.zzaZV[i];
                    if (zzcVar != null) {
                        iZzc += zzsn.zzc(4, zzcVar);
                    }
                }
                iZzz = iZzc;
            }
            if (this.zzaZW != null && this.zzaZW.length > 0) {
                int iZzc2 = iZzz;
                for (int i2 = 0; i2 < this.zzaZW.length; i2++) {
                    zza zzaVar = this.zzaZW[i2];
                    if (zzaVar != null) {
                        iZzc2 += zzsn.zzc(5, zzaVar);
                    }
                }
                iZzz = iZzc2;
            }
            if (this.zzaZX != null && this.zzaZX.length > 0) {
                for (int i3 = 0; i3 < this.zzaZX.length; i3++) {
                    zzpz.zza zzaVar2 = this.zzaZX[i3];
                    if (zzaVar2 != null) {
                        iZzz += zzsn.zzc(6, zzaVar2);
                    }
                }
            }
            return iZzz;
        }
    }

    public static final class zzc extends zzsu {
        private static volatile zzc[] zzaZY;
        public String key;
        public String value;

        public zzc() {
            zzDO();
        }

        public static zzc[] zzDN() {
            if (zzaZY == null) {
                synchronized (zzss.zzbut) {
                    if (zzaZY == null) {
                        zzaZY = new zzc[0];
                    }
                }
            }
            return zzaZY;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzc)) {
                return false;
            }
            zzc zzcVar = (zzc) o;
            if (this.key == null) {
                if (zzcVar.key != null) {
                    return false;
                }
            } else if (!this.key.equals(zzcVar.key)) {
                return false;
            }
            if (this.value == null) {
                return zzcVar.value == null;
            }
            return this.value.equals(zzcVar.value);
        }

        public int hashCode() {
            return (((this.key == null ? 0 : this.key.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31) + (this.value != null ? this.value.hashCode() : 0);
        }

        @Override // com.google.android.gms.internal.zzsu
        public void writeTo(zzsn output) throws IOException {
            if (this.key != null) {
                output.zzn(1, this.key);
            }
            if (this.value != null) {
                output.zzn(2, this.value);
            }
            super.writeTo(output);
        }

        @Override // com.google.android.gms.internal.zzsu
        /* JADX INFO: renamed from: zzB, reason: merged with bridge method [inline-methods] */
        public zzc mergeFrom(zzsm zzsmVar) throws IOException {
            while (true) {
                int iZzIX = zzsmVar.zzIX();
                switch (iZzIX) {
                    case 0:
                        break;
                    case 10:
                        this.key = zzsmVar.readString();
                        break;
                    case 18:
                        this.value = zzsmVar.readString();
                        break;
                    default:
                        if (!zzsx.zzb(zzsmVar, iZzIX)) {
                        }
                        break;
                }
            }
            return this;
        }

        public zzc zzDO() {
            this.key = null;
            this.value = null;
            this.zzbuu = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzsu
        protected int zzz() {
            int iZzz = super.zzz();
            if (this.key != null) {
                iZzz += zzsn.zzo(1, this.key);
            }
            return this.value != null ? iZzz + zzsn.zzo(2, this.value) : iZzz;
        }
    }
}
