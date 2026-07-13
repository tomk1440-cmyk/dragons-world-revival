package com.google.android.gms.internal;

import android.support.v4.media.TransportMediator;
import com.google.android.gms.location.places.Place;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public interface zzsz {

    public static final class zza extends zzso<zza> {
        public String[] zzbuI;
        public String[] zzbuJ;
        public int[] zzbuK;
        public long[] zzbuL;

        public zza() {
            zzJC();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zza)) {
                return false;
            }
            zza zzaVar = (zza) o;
            if (!zzss.equals(this.zzbuI, zzaVar.zzbuI) || !zzss.equals(this.zzbuJ, zzaVar.zzbuJ) || !zzss.equals(this.zzbuK, zzaVar.zzbuK) || !zzss.equals(this.zzbuL, zzaVar.zzbuL)) {
                return false;
            }
            if (this.zzbuj == null || this.zzbuj.isEmpty()) {
                return zzaVar.zzbuj == null || zzaVar.zzbuj.isEmpty();
            }
            return this.zzbuj.equals(zzaVar.zzbuj);
        }

        public int hashCode() {
            return ((this.zzbuj == null || this.zzbuj.isEmpty()) ? 0 : this.zzbuj.hashCode()) + ((((((((((getClass().getName().hashCode() + 527) * 31) + zzss.hashCode(this.zzbuI)) * 31) + zzss.hashCode(this.zzbuJ)) * 31) + zzss.hashCode(this.zzbuK)) * 31) + zzss.hashCode(this.zzbuL)) * 31);
        }

        @Override // com.google.android.gms.internal.zzso, com.google.android.gms.internal.zzsu
        public void writeTo(zzsn output) throws IOException {
            if (this.zzbuI != null && this.zzbuI.length > 0) {
                for (int i = 0; i < this.zzbuI.length; i++) {
                    String str = this.zzbuI[i];
                    if (str != null) {
                        output.zzn(1, str);
                    }
                }
            }
            if (this.zzbuJ != null && this.zzbuJ.length > 0) {
                for (int i2 = 0; i2 < this.zzbuJ.length; i2++) {
                    String str2 = this.zzbuJ[i2];
                    if (str2 != null) {
                        output.zzn(2, str2);
                    }
                }
            }
            if (this.zzbuK != null && this.zzbuK.length > 0) {
                for (int i3 = 0; i3 < this.zzbuK.length; i3++) {
                    output.zzA(3, this.zzbuK[i3]);
                }
            }
            if (this.zzbuL != null && this.zzbuL.length > 0) {
                for (int i4 = 0; i4 < this.zzbuL.length; i4++) {
                    output.zzb(4, this.zzbuL[i4]);
                }
            }
            super.writeTo(output);
        }

        public zza zzJC() {
            this.zzbuI = zzsx.zzbuB;
            this.zzbuJ = zzsx.zzbuB;
            this.zzbuK = zzsx.zzbuw;
            this.zzbuL = zzsx.zzbux;
            this.zzbuj = null;
            this.zzbuu = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzsu
        /* JADX INFO: renamed from: zzS, reason: merged with bridge method [inline-methods] */
        public zza mergeFrom(zzsm zzsmVar) throws IOException {
            while (true) {
                int iZzIX = zzsmVar.zzIX();
                switch (iZzIX) {
                    case 0:
                        break;
                    case 10:
                        int iZzc = zzsx.zzc(zzsmVar, 10);
                        int length = this.zzbuI == null ? 0 : this.zzbuI.length;
                        String[] strArr = new String[iZzc + length];
                        if (length != 0) {
                            System.arraycopy(this.zzbuI, 0, strArr, 0, length);
                        }
                        while (length < strArr.length - 1) {
                            strArr[length] = zzsmVar.readString();
                            zzsmVar.zzIX();
                            length++;
                        }
                        strArr[length] = zzsmVar.readString();
                        this.zzbuI = strArr;
                        break;
                    case 18:
                        int iZzc2 = zzsx.zzc(zzsmVar, 18);
                        int length2 = this.zzbuJ == null ? 0 : this.zzbuJ.length;
                        String[] strArr2 = new String[iZzc2 + length2];
                        if (length2 != 0) {
                            System.arraycopy(this.zzbuJ, 0, strArr2, 0, length2);
                        }
                        while (length2 < strArr2.length - 1) {
                            strArr2[length2] = zzsmVar.readString();
                            zzsmVar.zzIX();
                            length2++;
                        }
                        strArr2[length2] = zzsmVar.readString();
                        this.zzbuJ = strArr2;
                        break;
                    case 24:
                        int iZzc3 = zzsx.zzc(zzsmVar, 24);
                        int length3 = this.zzbuK == null ? 0 : this.zzbuK.length;
                        int[] iArr = new int[iZzc3 + length3];
                        if (length3 != 0) {
                            System.arraycopy(this.zzbuK, 0, iArr, 0, length3);
                        }
                        while (length3 < iArr.length - 1) {
                            iArr[length3] = zzsmVar.zzJb();
                            zzsmVar.zzIX();
                            length3++;
                        }
                        iArr[length3] = zzsmVar.zzJb();
                        this.zzbuK = iArr;
                        break;
                    case 26:
                        int iZzmq = zzsmVar.zzmq(zzsmVar.zzJf());
                        int position = zzsmVar.getPosition();
                        int i = 0;
                        while (zzsmVar.zzJk() > 0) {
                            zzsmVar.zzJb();
                            i++;
                        }
                        zzsmVar.zzms(position);
                        int length4 = this.zzbuK == null ? 0 : this.zzbuK.length;
                        int[] iArr2 = new int[i + length4];
                        if (length4 != 0) {
                            System.arraycopy(this.zzbuK, 0, iArr2, 0, length4);
                        }
                        while (length4 < iArr2.length) {
                            iArr2[length4] = zzsmVar.zzJb();
                            length4++;
                        }
                        this.zzbuK = iArr2;
                        zzsmVar.zzmr(iZzmq);
                        break;
                    case 32:
                        int iZzc4 = zzsx.zzc(zzsmVar, 32);
                        int length5 = this.zzbuL == null ? 0 : this.zzbuL.length;
                        long[] jArr = new long[iZzc4 + length5];
                        if (length5 != 0) {
                            System.arraycopy(this.zzbuL, 0, jArr, 0, length5);
                        }
                        while (length5 < jArr.length - 1) {
                            jArr[length5] = zzsmVar.zzJa();
                            zzsmVar.zzIX();
                            length5++;
                        }
                        jArr[length5] = zzsmVar.zzJa();
                        this.zzbuL = jArr;
                        break;
                    case 34:
                        int iZzmq2 = zzsmVar.zzmq(zzsmVar.zzJf());
                        int position2 = zzsmVar.getPosition();
                        int i2 = 0;
                        while (zzsmVar.zzJk() > 0) {
                            zzsmVar.zzJa();
                            i2++;
                        }
                        zzsmVar.zzms(position2);
                        int length6 = this.zzbuL == null ? 0 : this.zzbuL.length;
                        long[] jArr2 = new long[i2 + length6];
                        if (length6 != 0) {
                            System.arraycopy(this.zzbuL, 0, jArr2, 0, length6);
                        }
                        while (length6 < jArr2.length) {
                            jArr2[length6] = zzsmVar.zzJa();
                            length6++;
                        }
                        this.zzbuL = jArr2;
                        zzsmVar.zzmr(iZzmq2);
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
            int length;
            int iZzz = super.zzz();
            if (this.zzbuI == null || this.zzbuI.length <= 0) {
                length = iZzz;
            } else {
                int iZzgO = 0;
                int i = 0;
                for (int i2 = 0; i2 < this.zzbuI.length; i2++) {
                    String str = this.zzbuI[i2];
                    if (str != null) {
                        i++;
                        iZzgO += zzsn.zzgO(str);
                    }
                }
                length = iZzz + iZzgO + (i * 1);
            }
            if (this.zzbuJ != null && this.zzbuJ.length > 0) {
                int iZzgO2 = 0;
                int i3 = 0;
                for (int i4 = 0; i4 < this.zzbuJ.length; i4++) {
                    String str2 = this.zzbuJ[i4];
                    if (str2 != null) {
                        i3++;
                        iZzgO2 += zzsn.zzgO(str2);
                    }
                }
                length = length + iZzgO2 + (i3 * 1);
            }
            if (this.zzbuK != null && this.zzbuK.length > 0) {
                int iZzmx = 0;
                for (int i5 = 0; i5 < this.zzbuK.length; i5++) {
                    iZzmx += zzsn.zzmx(this.zzbuK[i5]);
                }
                length = length + iZzmx + (this.zzbuK.length * 1);
            }
            if (this.zzbuL == null || this.zzbuL.length <= 0) {
                return length;
            }
            int iZzas = 0;
            for (int i6 = 0; i6 < this.zzbuL.length; i6++) {
                iZzas += zzsn.zzas(this.zzbuL[i6]);
            }
            return length + iZzas + (this.zzbuL.length * 1);
        }
    }

    public static final class zzb extends zzso<zzb> {
        public String version;
        public int zzbuM;
        public String zzbuN;

        public zzb() {
            zzJD();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzb)) {
                return false;
            }
            zzb zzbVar = (zzb) o;
            if (this.zzbuM != zzbVar.zzbuM) {
                return false;
            }
            if (this.zzbuN == null) {
                if (zzbVar.zzbuN != null) {
                    return false;
                }
            } else if (!this.zzbuN.equals(zzbVar.zzbuN)) {
                return false;
            }
            if (this.version == null) {
                if (zzbVar.version != null) {
                    return false;
                }
            } else if (!this.version.equals(zzbVar.version)) {
                return false;
            }
            if (this.zzbuj == null || this.zzbuj.isEmpty()) {
                return zzbVar.zzbuj == null || zzbVar.zzbuj.isEmpty();
            }
            return this.zzbuj.equals(zzbVar.zzbuj);
        }

        public int hashCode() {
            int iHashCode = 0;
            int iHashCode2 = ((this.version == null ? 0 : this.version.hashCode()) + (((this.zzbuN == null ? 0 : this.zzbuN.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + this.zzbuM) * 31)) * 31)) * 31;
            if (this.zzbuj != null && !this.zzbuj.isEmpty()) {
                iHashCode = this.zzbuj.hashCode();
            }
            return iHashCode2 + iHashCode;
        }

        @Override // com.google.android.gms.internal.zzso, com.google.android.gms.internal.zzsu
        public void writeTo(zzsn output) throws IOException {
            if (this.zzbuM != 0) {
                output.zzA(1, this.zzbuM);
            }
            if (!this.zzbuN.equals("")) {
                output.zzn(2, this.zzbuN);
            }
            if (!this.version.equals("")) {
                output.zzn(3, this.version);
            }
            super.writeTo(output);
        }

        public zzb zzJD() {
            this.zzbuM = 0;
            this.zzbuN = "";
            this.version = "";
            this.zzbuj = null;
            this.zzbuu = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzsu
        /* JADX INFO: renamed from: zzT, reason: merged with bridge method [inline-methods] */
        public zzb mergeFrom(zzsm zzsmVar) throws IOException {
            while (true) {
                int iZzIX = zzsmVar.zzIX();
                switch (iZzIX) {
                    case 0:
                        break;
                    case 8:
                        int iZzJb = zzsmVar.zzJb();
                        switch (iZzJb) {
                            case 0:
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
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                                this.zzbuM = iZzJb;
                                break;
                        }
                        break;
                    case 18:
                        this.zzbuN = zzsmVar.readString();
                        break;
                    case 26:
                        this.version = zzsmVar.readString();
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
            int iZzz = super.zzz();
            if (this.zzbuM != 0) {
                iZzz += zzsn.zzC(1, this.zzbuM);
            }
            if (!this.zzbuN.equals("")) {
                iZzz += zzsn.zzo(2, this.zzbuN);
            }
            return !this.version.equals("") ? iZzz + zzsn.zzo(3, this.version) : iZzz;
        }
    }

    public static final class zzc extends zzso<zzc> {
        public byte[] zzbuO;
        public byte[][] zzbuP;
        public boolean zzbuQ;

        public zzc() {
            zzJE();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzc)) {
                return false;
            }
            zzc zzcVar = (zzc) o;
            if (!Arrays.equals(this.zzbuO, zzcVar.zzbuO) || !zzss.zza(this.zzbuP, zzcVar.zzbuP) || this.zzbuQ != zzcVar.zzbuQ) {
                return false;
            }
            if (this.zzbuj == null || this.zzbuj.isEmpty()) {
                return zzcVar.zzbuj == null || zzcVar.zzbuj.isEmpty();
            }
            return this.zzbuj.equals(zzcVar.zzbuj);
        }

        public int hashCode() {
            return ((this.zzbuj == null || this.zzbuj.isEmpty()) ? 0 : this.zzbuj.hashCode()) + (((this.zzbuQ ? 1231 : 1237) + ((((((getClass().getName().hashCode() + 527) * 31) + Arrays.hashCode(this.zzbuO)) * 31) + zzss.zza(this.zzbuP)) * 31)) * 31);
        }

        @Override // com.google.android.gms.internal.zzso, com.google.android.gms.internal.zzsu
        public void writeTo(zzsn output) throws IOException {
            if (!Arrays.equals(this.zzbuO, zzsx.zzbuD)) {
                output.zza(1, this.zzbuO);
            }
            if (this.zzbuP != null && this.zzbuP.length > 0) {
                for (int i = 0; i < this.zzbuP.length; i++) {
                    byte[] bArr = this.zzbuP[i];
                    if (bArr != null) {
                        output.zza(2, bArr);
                    }
                }
            }
            if (this.zzbuQ) {
                output.zze(3, this.zzbuQ);
            }
            super.writeTo(output);
        }

        public zzc zzJE() {
            this.zzbuO = zzsx.zzbuD;
            this.zzbuP = zzsx.zzbuC;
            this.zzbuQ = false;
            this.zzbuj = null;
            this.zzbuu = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzsu
        /* JADX INFO: renamed from: zzU, reason: merged with bridge method [inline-methods] */
        public zzc mergeFrom(zzsm zzsmVar) throws IOException {
            while (true) {
                int iZzIX = zzsmVar.zzIX();
                switch (iZzIX) {
                    case 0:
                        break;
                    case 10:
                        this.zzbuO = zzsmVar.readBytes();
                        break;
                    case 18:
                        int iZzc = zzsx.zzc(zzsmVar, 18);
                        int length = this.zzbuP == null ? 0 : this.zzbuP.length;
                        byte[][] bArr = new byte[iZzc + length][];
                        if (length != 0) {
                            System.arraycopy(this.zzbuP, 0, bArr, 0, length);
                        }
                        while (length < bArr.length - 1) {
                            bArr[length] = zzsmVar.readBytes();
                            zzsmVar.zzIX();
                            length++;
                        }
                        bArr[length] = zzsmVar.readBytes();
                        this.zzbuP = bArr;
                        break;
                    case 24:
                        this.zzbuQ = zzsmVar.zzJc();
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
            int iZzz = super.zzz();
            if (!Arrays.equals(this.zzbuO, zzsx.zzbuD)) {
                iZzz += zzsn.zzb(1, this.zzbuO);
            }
            if (this.zzbuP != null && this.zzbuP.length > 0) {
                int iZzG = 0;
                int i = 0;
                for (int i2 = 0; i2 < this.zzbuP.length; i2++) {
                    byte[] bArr = this.zzbuP[i2];
                    if (bArr != null) {
                        i++;
                        iZzG += zzsn.zzG(bArr);
                    }
                }
                iZzz = iZzz + iZzG + (i * 1);
            }
            return this.zzbuQ ? iZzz + zzsn.zzf(3, this.zzbuQ) : iZzz;
        }
    }

    public static final class zzd extends zzso<zzd> {
        public String tag;
        public long zzbuR;
        public long zzbuS;
        public long zzbuT;
        public int zzbuU;
        public boolean zzbuV;
        public zze[] zzbuW;
        public zzb zzbuX;
        public byte[] zzbuY;
        public byte[] zzbuZ;
        public byte[] zzbva;
        public zza zzbvb;
        public String zzbvc;
        public long zzbvd;
        public zzc zzbve;
        public byte[] zzbvf;
        public int zzbvg;
        public int[] zzbvh;
        public long zzbvi;
        public int zzob;

        public zzd() {
            zzJF();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzd)) {
                return false;
            }
            zzd zzdVar = (zzd) o;
            if (this.zzbuR != zzdVar.zzbuR || this.zzbuS != zzdVar.zzbuS || this.zzbuT != zzdVar.zzbuT) {
                return false;
            }
            if (this.tag == null) {
                if (zzdVar.tag != null) {
                    return false;
                }
            } else if (!this.tag.equals(zzdVar.tag)) {
                return false;
            }
            if (this.zzbuU != zzdVar.zzbuU || this.zzob != zzdVar.zzob || this.zzbuV != zzdVar.zzbuV || !zzss.equals(this.zzbuW, zzdVar.zzbuW)) {
                return false;
            }
            if (this.zzbuX == null) {
                if (zzdVar.zzbuX != null) {
                    return false;
                }
            } else if (!this.zzbuX.equals(zzdVar.zzbuX)) {
                return false;
            }
            if (!Arrays.equals(this.zzbuY, zzdVar.zzbuY) || !Arrays.equals(this.zzbuZ, zzdVar.zzbuZ) || !Arrays.equals(this.zzbva, zzdVar.zzbva)) {
                return false;
            }
            if (this.zzbvb == null) {
                if (zzdVar.zzbvb != null) {
                    return false;
                }
            } else if (!this.zzbvb.equals(zzdVar.zzbvb)) {
                return false;
            }
            if (this.zzbvc == null) {
                if (zzdVar.zzbvc != null) {
                    return false;
                }
            } else if (!this.zzbvc.equals(zzdVar.zzbvc)) {
                return false;
            }
            if (this.zzbvd != zzdVar.zzbvd) {
                return false;
            }
            if (this.zzbve == null) {
                if (zzdVar.zzbve != null) {
                    return false;
                }
            } else if (!this.zzbve.equals(zzdVar.zzbve)) {
                return false;
            }
            if (!Arrays.equals(this.zzbvf, zzdVar.zzbvf) || this.zzbvg != zzdVar.zzbvg || !zzss.equals(this.zzbvh, zzdVar.zzbvh) || this.zzbvi != zzdVar.zzbvi) {
                return false;
            }
            if (this.zzbuj == null || this.zzbuj.isEmpty()) {
                return zzdVar.zzbuj == null || zzdVar.zzbuj.isEmpty();
            }
            return this.zzbuj.equals(zzdVar.zzbuj);
        }

        public int hashCode() {
            int iHashCode = 0;
            int iHashCode2 = ((((((((((this.zzbve == null ? 0 : this.zzbve.hashCode()) + (((((this.zzbvc == null ? 0 : this.zzbvc.hashCode()) + (((this.zzbvb == null ? 0 : this.zzbvb.hashCode()) + (((((((((this.zzbuX == null ? 0 : this.zzbuX.hashCode()) + (((((this.zzbuV ? 1231 : 1237) + (((((((this.tag == null ? 0 : this.tag.hashCode()) + ((((((((getClass().getName().hashCode() + 527) * 31) + ((int) (this.zzbuR ^ (this.zzbuR >>> 32)))) * 31) + ((int) (this.zzbuS ^ (this.zzbuS >>> 32)))) * 31) + ((int) (this.zzbuT ^ (this.zzbuT >>> 32)))) * 31)) * 31) + this.zzbuU) * 31) + this.zzob) * 31)) * 31) + zzss.hashCode(this.zzbuW)) * 31)) * 31) + Arrays.hashCode(this.zzbuY)) * 31) + Arrays.hashCode(this.zzbuZ)) * 31) + Arrays.hashCode(this.zzbva)) * 31)) * 31)) * 31) + ((int) (this.zzbvd ^ (this.zzbvd >>> 32)))) * 31)) * 31) + Arrays.hashCode(this.zzbvf)) * 31) + this.zzbvg) * 31) + zzss.hashCode(this.zzbvh)) * 31) + ((int) (this.zzbvi ^ (this.zzbvi >>> 32)))) * 31;
            if (this.zzbuj != null && !this.zzbuj.isEmpty()) {
                iHashCode = this.zzbuj.hashCode();
            }
            return iHashCode2 + iHashCode;
        }

        @Override // com.google.android.gms.internal.zzso, com.google.android.gms.internal.zzsu
        public void writeTo(zzsn output) throws IOException {
            if (this.zzbuR != 0) {
                output.zzb(1, this.zzbuR);
            }
            if (!this.tag.equals("")) {
                output.zzn(2, this.tag);
            }
            if (this.zzbuW != null && this.zzbuW.length > 0) {
                for (int i = 0; i < this.zzbuW.length; i++) {
                    zze zzeVar = this.zzbuW[i];
                    if (zzeVar != null) {
                        output.zza(3, zzeVar);
                    }
                }
            }
            if (!Arrays.equals(this.zzbuY, zzsx.zzbuD)) {
                output.zza(6, this.zzbuY);
            }
            if (this.zzbvb != null) {
                output.zza(7, this.zzbvb);
            }
            if (!Arrays.equals(this.zzbuZ, zzsx.zzbuD)) {
                output.zza(8, this.zzbuZ);
            }
            if (this.zzbuX != null) {
                output.zza(9, this.zzbuX);
            }
            if (this.zzbuV) {
                output.zze(10, this.zzbuV);
            }
            if (this.zzbuU != 0) {
                output.zzA(11, this.zzbuU);
            }
            if (this.zzob != 0) {
                output.zzA(12, this.zzob);
            }
            if (!Arrays.equals(this.zzbva, zzsx.zzbuD)) {
                output.zza(13, this.zzbva);
            }
            if (!this.zzbvc.equals("")) {
                output.zzn(14, this.zzbvc);
            }
            if (this.zzbvd != 180000) {
                output.zzc(15, this.zzbvd);
            }
            if (this.zzbve != null) {
                output.zza(16, this.zzbve);
            }
            if (this.zzbuS != 0) {
                output.zzb(17, this.zzbuS);
            }
            if (!Arrays.equals(this.zzbvf, zzsx.zzbuD)) {
                output.zza(18, this.zzbvf);
            }
            if (this.zzbvg != 0) {
                output.zzA(19, this.zzbvg);
            }
            if (this.zzbvh != null && this.zzbvh.length > 0) {
                for (int i2 = 0; i2 < this.zzbvh.length; i2++) {
                    output.zzA(20, this.zzbvh[i2]);
                }
            }
            if (this.zzbuT != 0) {
                output.zzb(21, this.zzbuT);
            }
            if (this.zzbvi != 0) {
                output.zzb(22, this.zzbvi);
            }
            super.writeTo(output);
        }

        public zzd zzJF() {
            this.zzbuR = 0L;
            this.zzbuS = 0L;
            this.zzbuT = 0L;
            this.tag = "";
            this.zzbuU = 0;
            this.zzob = 0;
            this.zzbuV = false;
            this.zzbuW = zze.zzJG();
            this.zzbuX = null;
            this.zzbuY = zzsx.zzbuD;
            this.zzbuZ = zzsx.zzbuD;
            this.zzbva = zzsx.zzbuD;
            this.zzbvb = null;
            this.zzbvc = "";
            this.zzbvd = 180000L;
            this.zzbve = null;
            this.zzbvf = zzsx.zzbuD;
            this.zzbvg = 0;
            this.zzbvh = zzsx.zzbuw;
            this.zzbvi = 0L;
            this.zzbuj = null;
            this.zzbuu = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzsu
        /* JADX INFO: renamed from: zzV, reason: merged with bridge method [inline-methods] */
        public zzd mergeFrom(zzsm zzsmVar) throws IOException {
            while (true) {
                int iZzIX = zzsmVar.zzIX();
                switch (iZzIX) {
                    case 0:
                        break;
                    case 8:
                        this.zzbuR = zzsmVar.zzJa();
                        break;
                    case 18:
                        this.tag = zzsmVar.readString();
                        break;
                    case 26:
                        int iZzc = zzsx.zzc(zzsmVar, 26);
                        int length = this.zzbuW == null ? 0 : this.zzbuW.length;
                        zze[] zzeVarArr = new zze[iZzc + length];
                        if (length != 0) {
                            System.arraycopy(this.zzbuW, 0, zzeVarArr, 0, length);
                        }
                        while (length < zzeVarArr.length - 1) {
                            zzeVarArr[length] = new zze();
                            zzsmVar.zza(zzeVarArr[length]);
                            zzsmVar.zzIX();
                            length++;
                        }
                        zzeVarArr[length] = new zze();
                        zzsmVar.zza(zzeVarArr[length]);
                        this.zzbuW = zzeVarArr;
                        break;
                    case 50:
                        this.zzbuY = zzsmVar.readBytes();
                        break;
                    case Place.TYPE_LOCKSMITH /* 58 */:
                        if (this.zzbvb == null) {
                            this.zzbvb = new zza();
                        }
                        zzsmVar.zza(this.zzbvb);
                        break;
                    case Place.TYPE_MUSEUM /* 66 */:
                        this.zzbuZ = zzsmVar.readBytes();
                        break;
                    case Place.TYPE_PLACE_OF_WORSHIP /* 74 */:
                        if (this.zzbuX == null) {
                            this.zzbuX = new zzb();
                        }
                        zzsmVar.zza(this.zzbuX);
                        break;
                    case Place.TYPE_ROOFING_CONTRACTOR /* 80 */:
                        this.zzbuV = zzsmVar.zzJc();
                        break;
                    case Place.TYPE_STORE /* 88 */:
                        this.zzbuU = zzsmVar.zzJb();
                        break;
                    case Place.TYPE_ZOO /* 96 */:
                        this.zzob = zzsmVar.zzJb();
                        break;
                    case 106:
                        this.zzbva = zzsmVar.readBytes();
                        break;
                    case 114:
                        this.zzbvc = zzsmVar.readString();
                        break;
                    case 120:
                        this.zzbvd = zzsmVar.zzJe();
                        break;
                    case TransportMediator.KEYCODE_MEDIA_RECORD /* 130 */:
                        if (this.zzbve == null) {
                            this.zzbve = new zzc();
                        }
                        zzsmVar.zza(this.zzbve);
                        break;
                    case 136:
                        this.zzbuS = zzsmVar.zzJa();
                        break;
                    case 146:
                        this.zzbvf = zzsmVar.readBytes();
                        break;
                    case 152:
                        int iZzJb = zzsmVar.zzJb();
                        switch (iZzJb) {
                            case 0:
                            case 1:
                            case 2:
                                this.zzbvg = iZzJb;
                                break;
                        }
                        break;
                    case 160:
                        int iZzc2 = zzsx.zzc(zzsmVar, 160);
                        int length2 = this.zzbvh == null ? 0 : this.zzbvh.length;
                        int[] iArr = new int[iZzc2 + length2];
                        if (length2 != 0) {
                            System.arraycopy(this.zzbvh, 0, iArr, 0, length2);
                        }
                        while (length2 < iArr.length - 1) {
                            iArr[length2] = zzsmVar.zzJb();
                            zzsmVar.zzIX();
                            length2++;
                        }
                        iArr[length2] = zzsmVar.zzJb();
                        this.zzbvh = iArr;
                        break;
                    case 162:
                        int iZzmq = zzsmVar.zzmq(zzsmVar.zzJf());
                        int position = zzsmVar.getPosition();
                        int i = 0;
                        while (zzsmVar.zzJk() > 0) {
                            zzsmVar.zzJb();
                            i++;
                        }
                        zzsmVar.zzms(position);
                        int length3 = this.zzbvh == null ? 0 : this.zzbvh.length;
                        int[] iArr2 = new int[i + length3];
                        if (length3 != 0) {
                            System.arraycopy(this.zzbvh, 0, iArr2, 0, length3);
                        }
                        while (length3 < iArr2.length) {
                            iArr2[length3] = zzsmVar.zzJb();
                            length3++;
                        }
                        this.zzbvh = iArr2;
                        zzsmVar.zzmr(iZzmq);
                        break;
                    case 168:
                        this.zzbuT = zzsmVar.zzJa();
                        break;
                    case 176:
                        this.zzbvi = zzsmVar.zzJa();
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
            int iZzz = super.zzz();
            if (this.zzbuR != 0) {
                iZzz += zzsn.zzd(1, this.zzbuR);
            }
            if (!this.tag.equals("")) {
                iZzz += zzsn.zzo(2, this.tag);
            }
            if (this.zzbuW != null && this.zzbuW.length > 0) {
                int iZzc = iZzz;
                for (int i = 0; i < this.zzbuW.length; i++) {
                    zze zzeVar = this.zzbuW[i];
                    if (zzeVar != null) {
                        iZzc += zzsn.zzc(3, zzeVar);
                    }
                }
                iZzz = iZzc;
            }
            if (!Arrays.equals(this.zzbuY, zzsx.zzbuD)) {
                iZzz += zzsn.zzb(6, this.zzbuY);
            }
            if (this.zzbvb != null) {
                iZzz += zzsn.zzc(7, this.zzbvb);
            }
            if (!Arrays.equals(this.zzbuZ, zzsx.zzbuD)) {
                iZzz += zzsn.zzb(8, this.zzbuZ);
            }
            if (this.zzbuX != null) {
                iZzz += zzsn.zzc(9, this.zzbuX);
            }
            if (this.zzbuV) {
                iZzz += zzsn.zzf(10, this.zzbuV);
            }
            if (this.zzbuU != 0) {
                iZzz += zzsn.zzC(11, this.zzbuU);
            }
            if (this.zzob != 0) {
                iZzz += zzsn.zzC(12, this.zzob);
            }
            if (!Arrays.equals(this.zzbva, zzsx.zzbuD)) {
                iZzz += zzsn.zzb(13, this.zzbva);
            }
            if (!this.zzbvc.equals("")) {
                iZzz += zzsn.zzo(14, this.zzbvc);
            }
            if (this.zzbvd != 180000) {
                iZzz += zzsn.zze(15, this.zzbvd);
            }
            if (this.zzbve != null) {
                iZzz += zzsn.zzc(16, this.zzbve);
            }
            if (this.zzbuS != 0) {
                iZzz += zzsn.zzd(17, this.zzbuS);
            }
            if (!Arrays.equals(this.zzbvf, zzsx.zzbuD)) {
                iZzz += zzsn.zzb(18, this.zzbvf);
            }
            if (this.zzbvg != 0) {
                iZzz += zzsn.zzC(19, this.zzbvg);
            }
            if (this.zzbvh != null && this.zzbvh.length > 0) {
                int iZzmx = 0;
                for (int i2 = 0; i2 < this.zzbvh.length; i2++) {
                    iZzmx += zzsn.zzmx(this.zzbvh[i2]);
                }
                iZzz = iZzz + iZzmx + (this.zzbvh.length * 2);
            }
            if (this.zzbuT != 0) {
                iZzz += zzsn.zzd(21, this.zzbuT);
            }
            return this.zzbvi != 0 ? iZzz + zzsn.zzd(22, this.zzbvi) : iZzz;
        }
    }

    public static final class zze extends zzso<zze> {
        private static volatile zze[] zzbvj;
        public String key;
        public String value;

        public zze() {
            zzJH();
        }

        public static zze[] zzJG() {
            if (zzbvj == null) {
                synchronized (zzss.zzbut) {
                    if (zzbvj == null) {
                        zzbvj = new zze[0];
                    }
                }
            }
            return zzbvj;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zze)) {
                return false;
            }
            zze zzeVar = (zze) o;
            if (this.key == null) {
                if (zzeVar.key != null) {
                    return false;
                }
            } else if (!this.key.equals(zzeVar.key)) {
                return false;
            }
            if (this.value == null) {
                if (zzeVar.value != null) {
                    return false;
                }
            } else if (!this.value.equals(zzeVar.value)) {
                return false;
            }
            if (this.zzbuj == null || this.zzbuj.isEmpty()) {
                return zzeVar.zzbuj == null || zzeVar.zzbuj.isEmpty();
            }
            return this.zzbuj.equals(zzeVar.zzbuj);
        }

        public int hashCode() {
            int iHashCode = 0;
            int iHashCode2 = ((this.value == null ? 0 : this.value.hashCode()) + (((this.key == null ? 0 : this.key.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31;
            if (this.zzbuj != null && !this.zzbuj.isEmpty()) {
                iHashCode = this.zzbuj.hashCode();
            }
            return iHashCode2 + iHashCode;
        }

        @Override // com.google.android.gms.internal.zzso, com.google.android.gms.internal.zzsu
        public void writeTo(zzsn output) throws IOException {
            if (!this.key.equals("")) {
                output.zzn(1, this.key);
            }
            if (!this.value.equals("")) {
                output.zzn(2, this.value);
            }
            super.writeTo(output);
        }

        public zze zzJH() {
            this.key = "";
            this.value = "";
            this.zzbuj = null;
            this.zzbuu = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzsu
        /* JADX INFO: renamed from: zzW, reason: merged with bridge method [inline-methods] */
        public zze mergeFrom(zzsm zzsmVar) throws IOException {
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
                        if (!zza(zzsmVar, iZzIX)) {
                        }
                        break;
                }
            }
            return this;
        }

        @Override // com.google.android.gms.internal.zzso, com.google.android.gms.internal.zzsu
        protected int zzz() {
            int iZzz = super.zzz();
            if (!this.key.equals("")) {
                iZzz += zzsn.zzo(1, this.key);
            }
            return !this.value.equals("") ? iZzz + zzsn.zzo(2, this.value) : iZzz;
        }
    }
}
