package com.google.android.gms.internal;

import com.google.android.gms.location.places.Place;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public interface zzag {

    public static final class zza extends zzso<zza> {
        private static volatile zza[] zzjw;
        public int type;
        public zza[] zzjA;
        public String zzjB;
        public String zzjC;
        public long zzjD;
        public boolean zzjE;
        public zza[] zzjF;
        public int[] zzjG;
        public boolean zzjH;
        public String zzjx;
        public zza[] zzjy;
        public zza[] zzjz;

        public zza() {
            zzR();
        }

        public static zza[] zzQ() {
            if (zzjw == null) {
                synchronized (zzss.zzbut) {
                    if (zzjw == null) {
                        zzjw = new zza[0];
                    }
                }
            }
            return zzjw;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zza)) {
                return false;
            }
            zza zzaVar = (zza) o;
            if (this.type != zzaVar.type) {
                return false;
            }
            if (this.zzjx == null) {
                if (zzaVar.zzjx != null) {
                    return false;
                }
            } else if (!this.zzjx.equals(zzaVar.zzjx)) {
                return false;
            }
            if (!zzss.equals(this.zzjy, zzaVar.zzjy) || !zzss.equals(this.zzjz, zzaVar.zzjz) || !zzss.equals(this.zzjA, zzaVar.zzjA)) {
                return false;
            }
            if (this.zzjB == null) {
                if (zzaVar.zzjB != null) {
                    return false;
                }
            } else if (!this.zzjB.equals(zzaVar.zzjB)) {
                return false;
            }
            if (this.zzjC == null) {
                if (zzaVar.zzjC != null) {
                    return false;
                }
            } else if (!this.zzjC.equals(zzaVar.zzjC)) {
                return false;
            }
            if (this.zzjD != zzaVar.zzjD || this.zzjE != zzaVar.zzjE || !zzss.equals(this.zzjF, zzaVar.zzjF) || !zzss.equals(this.zzjG, zzaVar.zzjG) || this.zzjH != zzaVar.zzjH) {
                return false;
            }
            if (this.zzbuj == null || this.zzbuj.isEmpty()) {
                return zzaVar.zzbuj == null || zzaVar.zzbuj.isEmpty();
            }
            return this.zzbuj.equals(zzaVar.zzbuj);
        }

        public int hashCode() {
            int iHashCode = 0;
            int iHashCode2 = ((((((((this.zzjE ? 1231 : 1237) + (((((this.zzjC == null ? 0 : this.zzjC.hashCode()) + (((this.zzjB == null ? 0 : this.zzjB.hashCode()) + (((((((((this.zzjx == null ? 0 : this.zzjx.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + this.type) * 31)) * 31) + zzss.hashCode(this.zzjy)) * 31) + zzss.hashCode(this.zzjz)) * 31) + zzss.hashCode(this.zzjA)) * 31)) * 31)) * 31) + ((int) (this.zzjD ^ (this.zzjD >>> 32)))) * 31)) * 31) + zzss.hashCode(this.zzjF)) * 31) + zzss.hashCode(this.zzjG)) * 31) + (this.zzjH ? 1231 : 1237)) * 31;
            if (this.zzbuj != null && !this.zzbuj.isEmpty()) {
                iHashCode = this.zzbuj.hashCode();
            }
            return iHashCode2 + iHashCode;
        }

        @Override // com.google.android.gms.internal.zzso, com.google.android.gms.internal.zzsu
        public void writeTo(zzsn output) throws IOException {
            output.zzA(1, this.type);
            if (!this.zzjx.equals("")) {
                output.zzn(2, this.zzjx);
            }
            if (this.zzjy != null && this.zzjy.length > 0) {
                for (int i = 0; i < this.zzjy.length; i++) {
                    zza zzaVar = this.zzjy[i];
                    if (zzaVar != null) {
                        output.zza(3, zzaVar);
                    }
                }
            }
            if (this.zzjz != null && this.zzjz.length > 0) {
                for (int i2 = 0; i2 < this.zzjz.length; i2++) {
                    zza zzaVar2 = this.zzjz[i2];
                    if (zzaVar2 != null) {
                        output.zza(4, zzaVar2);
                    }
                }
            }
            if (this.zzjA != null && this.zzjA.length > 0) {
                for (int i3 = 0; i3 < this.zzjA.length; i3++) {
                    zza zzaVar3 = this.zzjA[i3];
                    if (zzaVar3 != null) {
                        output.zza(5, zzaVar3);
                    }
                }
            }
            if (!this.zzjB.equals("")) {
                output.zzn(6, this.zzjB);
            }
            if (!this.zzjC.equals("")) {
                output.zzn(7, this.zzjC);
            }
            if (this.zzjD != 0) {
                output.zzb(8, this.zzjD);
            }
            if (this.zzjH) {
                output.zze(9, this.zzjH);
            }
            if (this.zzjG != null && this.zzjG.length > 0) {
                for (int i4 = 0; i4 < this.zzjG.length; i4++) {
                    output.zzA(10, this.zzjG[i4]);
                }
            }
            if (this.zzjF != null && this.zzjF.length > 0) {
                for (int i5 = 0; i5 < this.zzjF.length; i5++) {
                    zza zzaVar4 = this.zzjF[i5];
                    if (zzaVar4 != null) {
                        output.zza(11, zzaVar4);
                    }
                }
            }
            if (this.zzjE) {
                output.zze(12, this.zzjE);
            }
            super.writeTo(output);
        }

        public zza zzR() {
            this.type = 1;
            this.zzjx = "";
            this.zzjy = zzQ();
            this.zzjz = zzQ();
            this.zzjA = zzQ();
            this.zzjB = "";
            this.zzjC = "";
            this.zzjD = 0L;
            this.zzjE = false;
            this.zzjF = zzQ();
            this.zzjG = zzsx.zzbuw;
            this.zzjH = false;
            this.zzbuj = null;
            this.zzbuu = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzsu
        /* JADX INFO: renamed from: zzk, reason: merged with bridge method [inline-methods] */
        public zza mergeFrom(zzsm zzsmVar) throws IOException {
            int i;
            while (true) {
                int iZzIX = zzsmVar.zzIX();
                switch (iZzIX) {
                    case 0:
                        break;
                    case 8:
                        int iZzJb = zzsmVar.zzJb();
                        switch (iZzJb) {
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                            case 8:
                                this.type = iZzJb;
                                break;
                        }
                        break;
                    case 18:
                        this.zzjx = zzsmVar.readString();
                        break;
                    case 26:
                        int iZzc = zzsx.zzc(zzsmVar, 26);
                        int length = this.zzjy == null ? 0 : this.zzjy.length;
                        zza[] zzaVarArr = new zza[iZzc + length];
                        if (length != 0) {
                            System.arraycopy(this.zzjy, 0, zzaVarArr, 0, length);
                        }
                        while (length < zzaVarArr.length - 1) {
                            zzaVarArr[length] = new zza();
                            zzsmVar.zza(zzaVarArr[length]);
                            zzsmVar.zzIX();
                            length++;
                        }
                        zzaVarArr[length] = new zza();
                        zzsmVar.zza(zzaVarArr[length]);
                        this.zzjy = zzaVarArr;
                        break;
                    case 34:
                        int iZzc2 = zzsx.zzc(zzsmVar, 34);
                        int length2 = this.zzjz == null ? 0 : this.zzjz.length;
                        zza[] zzaVarArr2 = new zza[iZzc2 + length2];
                        if (length2 != 0) {
                            System.arraycopy(this.zzjz, 0, zzaVarArr2, 0, length2);
                        }
                        while (length2 < zzaVarArr2.length - 1) {
                            zzaVarArr2[length2] = new zza();
                            zzsmVar.zza(zzaVarArr2[length2]);
                            zzsmVar.zzIX();
                            length2++;
                        }
                        zzaVarArr2[length2] = new zza();
                        zzsmVar.zza(zzaVarArr2[length2]);
                        this.zzjz = zzaVarArr2;
                        break;
                    case 42:
                        int iZzc3 = zzsx.zzc(zzsmVar, 42);
                        int length3 = this.zzjA == null ? 0 : this.zzjA.length;
                        zza[] zzaVarArr3 = new zza[iZzc3 + length3];
                        if (length3 != 0) {
                            System.arraycopy(this.zzjA, 0, zzaVarArr3, 0, length3);
                        }
                        while (length3 < zzaVarArr3.length - 1) {
                            zzaVarArr3[length3] = new zza();
                            zzsmVar.zza(zzaVarArr3[length3]);
                            zzsmVar.zzIX();
                            length3++;
                        }
                        zzaVarArr3[length3] = new zza();
                        zzsmVar.zza(zzaVarArr3[length3]);
                        this.zzjA = zzaVarArr3;
                        break;
                    case 50:
                        this.zzjB = zzsmVar.readString();
                        break;
                    case Place.TYPE_LOCKSMITH /* 58 */:
                        this.zzjC = zzsmVar.readString();
                        break;
                    case 64:
                        this.zzjD = zzsmVar.zzJa();
                        break;
                    case Place.TYPE_PHARMACY /* 72 */:
                        this.zzjH = zzsmVar.zzJc();
                        break;
                    case Place.TYPE_ROOFING_CONTRACTOR /* 80 */:
                        int iZzc4 = zzsx.zzc(zzsmVar, 80);
                        int[] iArr = new int[iZzc4];
                        int i2 = 0;
                        int i3 = 0;
                        while (i2 < iZzc4) {
                            if (i2 != 0) {
                                zzsmVar.zzIX();
                            }
                            int iZzJb2 = zzsmVar.zzJb();
                            switch (iZzJb2) {
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                case 7:
                                case 8:
                                case 9:
                                case 10:
                                case 11:
                                case 12:
                                case 13:
                                case 14:
                                case 15:
                                case 16:
                                case 17:
                                    i = i3 + 1;
                                    iArr[i3] = iZzJb2;
                                    break;
                                default:
                                    i = i3;
                                    break;
                            }
                            i2++;
                            i3 = i;
                        }
                        if (i3 != 0) {
                            int length4 = this.zzjG == null ? 0 : this.zzjG.length;
                            if (length4 == 0 && i3 == iArr.length) {
                                this.zzjG = iArr;
                            } else {
                                int[] iArr2 = new int[length4 + i3];
                                if (length4 != 0) {
                                    System.arraycopy(this.zzjG, 0, iArr2, 0, length4);
                                }
                                System.arraycopy(iArr, 0, iArr2, length4, i3);
                                this.zzjG = iArr2;
                            }
                        }
                        break;
                    case Place.TYPE_SCHOOL /* 82 */:
                        int iZzmq = zzsmVar.zzmq(zzsmVar.zzJf());
                        int position = zzsmVar.getPosition();
                        int i4 = 0;
                        while (zzsmVar.zzJk() > 0) {
                            switch (zzsmVar.zzJb()) {
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                case 7:
                                case 8:
                                case 9:
                                case 10:
                                case 11:
                                case 12:
                                case 13:
                                case 14:
                                case 15:
                                case 16:
                                case 17:
                                    i4++;
                                    break;
                            }
                        }
                        if (i4 != 0) {
                            zzsmVar.zzms(position);
                            int length5 = this.zzjG == null ? 0 : this.zzjG.length;
                            int[] iArr3 = new int[i4 + length5];
                            if (length5 != 0) {
                                System.arraycopy(this.zzjG, 0, iArr3, 0, length5);
                            }
                            while (zzsmVar.zzJk() > 0) {
                                int iZzJb3 = zzsmVar.zzJb();
                                switch (iZzJb3) {
                                    case 1:
                                    case 2:
                                    case 3:
                                    case 4:
                                    case 5:
                                    case 6:
                                    case 7:
                                    case 8:
                                    case 9:
                                    case 10:
                                    case 11:
                                    case 12:
                                    case 13:
                                    case 14:
                                    case 15:
                                    case 16:
                                    case 17:
                                        iArr3[length5] = iZzJb3;
                                        length5++;
                                        break;
                                }
                            }
                            this.zzjG = iArr3;
                        }
                        zzsmVar.zzmr(iZzmq);
                        break;
                    case 90:
                        int iZzc5 = zzsx.zzc(zzsmVar, 90);
                        int length6 = this.zzjF == null ? 0 : this.zzjF.length;
                        zza[] zzaVarArr4 = new zza[iZzc5 + length6];
                        if (length6 != 0) {
                            System.arraycopy(this.zzjF, 0, zzaVarArr4, 0, length6);
                        }
                        while (length6 < zzaVarArr4.length - 1) {
                            zzaVarArr4[length6] = new zza();
                            zzsmVar.zza(zzaVarArr4[length6]);
                            zzsmVar.zzIX();
                            length6++;
                        }
                        zzaVarArr4[length6] = new zza();
                        zzsmVar.zza(zzaVarArr4[length6]);
                        this.zzjF = zzaVarArr4;
                        break;
                    case Place.TYPE_ZOO /* 96 */:
                        this.zzjE = zzsmVar.zzJc();
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
            int iZzz = super.zzz() + zzsn.zzC(1, this.type);
            if (!this.zzjx.equals("")) {
                iZzz += zzsn.zzo(2, this.zzjx);
            }
            if (this.zzjy != null && this.zzjy.length > 0) {
                int iZzc = iZzz;
                for (int i = 0; i < this.zzjy.length; i++) {
                    zza zzaVar = this.zzjy[i];
                    if (zzaVar != null) {
                        iZzc += zzsn.zzc(3, zzaVar);
                    }
                }
                iZzz = iZzc;
            }
            if (this.zzjz != null && this.zzjz.length > 0) {
                int iZzc2 = iZzz;
                for (int i2 = 0; i2 < this.zzjz.length; i2++) {
                    zza zzaVar2 = this.zzjz[i2];
                    if (zzaVar2 != null) {
                        iZzc2 += zzsn.zzc(4, zzaVar2);
                    }
                }
                iZzz = iZzc2;
            }
            if (this.zzjA != null && this.zzjA.length > 0) {
                int iZzc3 = iZzz;
                for (int i3 = 0; i3 < this.zzjA.length; i3++) {
                    zza zzaVar3 = this.zzjA[i3];
                    if (zzaVar3 != null) {
                        iZzc3 += zzsn.zzc(5, zzaVar3);
                    }
                }
                iZzz = iZzc3;
            }
            if (!this.zzjB.equals("")) {
                iZzz += zzsn.zzo(6, this.zzjB);
            }
            if (!this.zzjC.equals("")) {
                iZzz += zzsn.zzo(7, this.zzjC);
            }
            if (this.zzjD != 0) {
                iZzz += zzsn.zzd(8, this.zzjD);
            }
            if (this.zzjH) {
                iZzz += zzsn.zzf(9, this.zzjH);
            }
            if (this.zzjG != null && this.zzjG.length > 0) {
                int iZzmx = 0;
                for (int i4 = 0; i4 < this.zzjG.length; i4++) {
                    iZzmx += zzsn.zzmx(this.zzjG[i4]);
                }
                iZzz = iZzz + iZzmx + (this.zzjG.length * 1);
            }
            if (this.zzjF != null && this.zzjF.length > 0) {
                for (int i5 = 0; i5 < this.zzjF.length; i5++) {
                    zza zzaVar4 = this.zzjF[i5];
                    if (zzaVar4 != null) {
                        iZzz += zzsn.zzc(11, zzaVar4);
                    }
                }
            }
            return this.zzjE ? iZzz + zzsn.zzf(12, this.zzjE) : iZzz;
        }
    }
}
