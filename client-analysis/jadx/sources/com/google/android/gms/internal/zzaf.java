package com.google.android.gms.internal;

import android.support.v4.media.TransportMediator;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.location.places.Place;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public interface zzaf {

    public static final class zza extends zzso<zza> {
        public int level;
        public int zziq;
        public int zzir;

        public zza() {
            zzB();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zza)) {
                return false;
            }
            zza zzaVar = (zza) o;
            if (this.level != zzaVar.level || this.zziq != zzaVar.zziq || this.zzir != zzaVar.zzir) {
                return false;
            }
            if (this.zzbuj == null || this.zzbuj.isEmpty()) {
                return zzaVar.zzbuj == null || zzaVar.zzbuj.isEmpty();
            }
            return this.zzbuj.equals(zzaVar.zzbuj);
        }

        public int hashCode() {
            return ((this.zzbuj == null || this.zzbuj.isEmpty()) ? 0 : this.zzbuj.hashCode()) + ((((((((getClass().getName().hashCode() + 527) * 31) + this.level) * 31) + this.zziq) * 31) + this.zzir) * 31);
        }

        @Override // com.google.android.gms.internal.zzso, com.google.android.gms.internal.zzsu
        public void writeTo(zzsn output) throws IOException {
            if (this.level != 1) {
                output.zzA(1, this.level);
            }
            if (this.zziq != 0) {
                output.zzA(2, this.zziq);
            }
            if (this.zzir != 0) {
                output.zzA(3, this.zzir);
            }
            super.writeTo(output);
        }

        public zza zzB() {
            this.level = 1;
            this.zziq = 0;
            this.zzir = 0;
            this.zzbuj = null;
            this.zzbuu = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzsu
        /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
        public zza mergeFrom(zzsm zzsmVar) throws IOException {
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
                                this.level = iZzJb;
                                break;
                        }
                        break;
                    case 16:
                        this.zziq = zzsmVar.zzJb();
                        break;
                    case 24:
                        this.zzir = zzsmVar.zzJb();
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
            if (this.level != 1) {
                iZzz += zzsn.zzC(1, this.level);
            }
            if (this.zziq != 0) {
                iZzz += zzsn.zzC(2, this.zziq);
            }
            return this.zzir != 0 ? iZzz + zzsn.zzC(3, this.zzir) : iZzz;
        }
    }

    public static final class zzb extends zzso<zzb> {
        private static volatile zzb[] zzis;
        public int name;
        public int[] zzit;
        public int zziu;
        public boolean zziv;
        public boolean zziw;

        public zzb() {
            zzD();
        }

        public static zzb[] zzC() {
            if (zzis == null) {
                synchronized (zzss.zzbut) {
                    if (zzis == null) {
                        zzis = new zzb[0];
                    }
                }
            }
            return zzis;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzb)) {
                return false;
            }
            zzb zzbVar = (zzb) o;
            if (!zzss.equals(this.zzit, zzbVar.zzit) || this.zziu != zzbVar.zziu || this.name != zzbVar.name || this.zziv != zzbVar.zziv || this.zziw != zzbVar.zziw) {
                return false;
            }
            if (this.zzbuj == null || this.zzbuj.isEmpty()) {
                return zzbVar.zzbuj == null || zzbVar.zzbuj.isEmpty();
            }
            return this.zzbuj.equals(zzbVar.zzbuj);
        }

        public int hashCode() {
            return ((this.zzbuj == null || this.zzbuj.isEmpty()) ? 0 : this.zzbuj.hashCode()) + (((((this.zziv ? 1231 : 1237) + ((((((((getClass().getName().hashCode() + 527) * 31) + zzss.hashCode(this.zzit)) * 31) + this.zziu) * 31) + this.name) * 31)) * 31) + (this.zziw ? 1231 : 1237)) * 31);
        }

        @Override // com.google.android.gms.internal.zzso, com.google.android.gms.internal.zzsu
        public void writeTo(zzsn output) throws IOException {
            if (this.zziw) {
                output.zze(1, this.zziw);
            }
            output.zzA(2, this.zziu);
            if (this.zzit != null && this.zzit.length > 0) {
                for (int i = 0; i < this.zzit.length; i++) {
                    output.zzA(3, this.zzit[i]);
                }
            }
            if (this.name != 0) {
                output.zzA(4, this.name);
            }
            if (this.zziv) {
                output.zze(6, this.zziv);
            }
            super.writeTo(output);
        }

        public zzb zzD() {
            this.zzit = zzsx.zzbuw;
            this.zziu = 0;
            this.name = 0;
            this.zziv = false;
            this.zziw = false;
            this.zzbuj = null;
            this.zzbuu = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzsu
        /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
        public zzb mergeFrom(zzsm zzsmVar) throws IOException {
            while (true) {
                int iZzIX = zzsmVar.zzIX();
                switch (iZzIX) {
                    case 0:
                        break;
                    case 8:
                        this.zziw = zzsmVar.zzJc();
                        break;
                    case 16:
                        this.zziu = zzsmVar.zzJb();
                        break;
                    case 24:
                        int iZzc = zzsx.zzc(zzsmVar, 24);
                        int length = this.zzit == null ? 0 : this.zzit.length;
                        int[] iArr = new int[iZzc + length];
                        if (length != 0) {
                            System.arraycopy(this.zzit, 0, iArr, 0, length);
                        }
                        while (length < iArr.length - 1) {
                            iArr[length] = zzsmVar.zzJb();
                            zzsmVar.zzIX();
                            length++;
                        }
                        iArr[length] = zzsmVar.zzJb();
                        this.zzit = iArr;
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
                        int length2 = this.zzit == null ? 0 : this.zzit.length;
                        int[] iArr2 = new int[i + length2];
                        if (length2 != 0) {
                            System.arraycopy(this.zzit, 0, iArr2, 0, length2);
                        }
                        while (length2 < iArr2.length) {
                            iArr2[length2] = zzsmVar.zzJb();
                            length2++;
                        }
                        this.zzit = iArr2;
                        zzsmVar.zzmr(iZzmq);
                        break;
                    case 32:
                        this.name = zzsmVar.zzJb();
                        break;
                    case Place.TYPE_HINDU_TEMPLE /* 48 */:
                        this.zziv = zzsmVar.zzJc();
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
            int iZzC;
            int iZzmx = 0;
            int iZzz = super.zzz();
            if (this.zziw) {
                iZzz += zzsn.zzf(1, this.zziw);
            }
            int iZzC2 = zzsn.zzC(2, this.zziu) + iZzz;
            if (this.zzit == null || this.zzit.length <= 0) {
                iZzC = iZzC2;
            } else {
                for (int i = 0; i < this.zzit.length; i++) {
                    iZzmx += zzsn.zzmx(this.zzit[i]);
                }
                iZzC = iZzC2 + iZzmx + (this.zzit.length * 1);
            }
            if (this.name != 0) {
                iZzC += zzsn.zzC(4, this.name);
            }
            return this.zziv ? iZzC + zzsn.zzf(6, this.zziv) : iZzC;
        }
    }

    public static final class zzc extends zzso<zzc> {
        private static volatile zzc[] zzix;
        public String key;
        public boolean zziA;
        public long zziB;
        public long zziy;
        public long zziz;

        public zzc() {
            zzF();
        }

        public static zzc[] zzE() {
            if (zzix == null) {
                synchronized (zzss.zzbut) {
                    if (zzix == null) {
                        zzix = new zzc[0];
                    }
                }
            }
            return zzix;
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
            if (this.zziy != zzcVar.zziy || this.zziz != zzcVar.zziz || this.zziA != zzcVar.zziA || this.zziB != zzcVar.zziB) {
                return false;
            }
            if (this.zzbuj == null || this.zzbuj.isEmpty()) {
                return zzcVar.zzbuj == null || zzcVar.zzbuj.isEmpty();
            }
            return this.zzbuj.equals(zzcVar.zzbuj);
        }

        public int hashCode() {
            int iHashCode = 0;
            int iHashCode2 = ((((this.zziA ? 1231 : 1237) + (((((((this.key == null ? 0 : this.key.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31) + ((int) (this.zziy ^ (this.zziy >>> 32)))) * 31) + ((int) (this.zziz ^ (this.zziz >>> 32)))) * 31)) * 31) + ((int) (this.zziB ^ (this.zziB >>> 32)))) * 31;
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
            if (this.zziy != 0) {
                output.zzb(2, this.zziy);
            }
            if (this.zziz != 2147483647L) {
                output.zzb(3, this.zziz);
            }
            if (this.zziA) {
                output.zze(4, this.zziA);
            }
            if (this.zziB != 0) {
                output.zzb(5, this.zziB);
            }
            super.writeTo(output);
        }

        public zzc zzF() {
            this.key = "";
            this.zziy = 0L;
            this.zziz = 2147483647L;
            this.zziA = false;
            this.zziB = 0L;
            this.zzbuj = null;
            this.zzbuu = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzsu
        /* JADX INFO: renamed from: zzc, reason: merged with bridge method [inline-methods] */
        public zzc mergeFrom(zzsm zzsmVar) throws IOException {
            while (true) {
                int iZzIX = zzsmVar.zzIX();
                switch (iZzIX) {
                    case 0:
                        break;
                    case 10:
                        this.key = zzsmVar.readString();
                        break;
                    case 16:
                        this.zziy = zzsmVar.zzJa();
                        break;
                    case 24:
                        this.zziz = zzsmVar.zzJa();
                        break;
                    case 32:
                        this.zziA = zzsmVar.zzJc();
                        break;
                    case 40:
                        this.zziB = zzsmVar.zzJa();
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
            if (this.zziy != 0) {
                iZzz += zzsn.zzd(2, this.zziy);
            }
            if (this.zziz != 2147483647L) {
                iZzz += zzsn.zzd(3, this.zziz);
            }
            if (this.zziA) {
                iZzz += zzsn.zzf(4, this.zziA);
            }
            return this.zziB != 0 ? iZzz + zzsn.zzd(5, this.zziB) : iZzz;
        }
    }

    public static final class zzd extends zzso<zzd> {
        public zzag.zza[] zziC;
        public zzag.zza[] zziD;
        public zzc[] zziE;

        public zzd() {
            zzG();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzd)) {
                return false;
            }
            zzd zzdVar = (zzd) o;
            if (!zzss.equals(this.zziC, zzdVar.zziC) || !zzss.equals(this.zziD, zzdVar.zziD) || !zzss.equals(this.zziE, zzdVar.zziE)) {
                return false;
            }
            if (this.zzbuj == null || this.zzbuj.isEmpty()) {
                return zzdVar.zzbuj == null || zzdVar.zzbuj.isEmpty();
            }
            return this.zzbuj.equals(zzdVar.zzbuj);
        }

        public int hashCode() {
            return ((this.zzbuj == null || this.zzbuj.isEmpty()) ? 0 : this.zzbuj.hashCode()) + ((((((((getClass().getName().hashCode() + 527) * 31) + zzss.hashCode(this.zziC)) * 31) + zzss.hashCode(this.zziD)) * 31) + zzss.hashCode(this.zziE)) * 31);
        }

        @Override // com.google.android.gms.internal.zzso, com.google.android.gms.internal.zzsu
        public void writeTo(zzsn output) throws IOException {
            if (this.zziC != null && this.zziC.length > 0) {
                for (int i = 0; i < this.zziC.length; i++) {
                    zzag.zza zzaVar = this.zziC[i];
                    if (zzaVar != null) {
                        output.zza(1, zzaVar);
                    }
                }
            }
            if (this.zziD != null && this.zziD.length > 0) {
                for (int i2 = 0; i2 < this.zziD.length; i2++) {
                    zzag.zza zzaVar2 = this.zziD[i2];
                    if (zzaVar2 != null) {
                        output.zza(2, zzaVar2);
                    }
                }
            }
            if (this.zziE != null && this.zziE.length > 0) {
                for (int i3 = 0; i3 < this.zziE.length; i3++) {
                    zzc zzcVar = this.zziE[i3];
                    if (zzcVar != null) {
                        output.zza(3, zzcVar);
                    }
                }
            }
            super.writeTo(output);
        }

        public zzd zzG() {
            this.zziC = zzag.zza.zzQ();
            this.zziD = zzag.zza.zzQ();
            this.zziE = zzc.zzE();
            this.zzbuj = null;
            this.zzbuu = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzsu
        /* JADX INFO: renamed from: zzd, reason: merged with bridge method [inline-methods] */
        public zzd mergeFrom(zzsm zzsmVar) throws IOException {
            while (true) {
                int iZzIX = zzsmVar.zzIX();
                switch (iZzIX) {
                    case 0:
                        break;
                    case 10:
                        int iZzc = zzsx.zzc(zzsmVar, 10);
                        int length = this.zziC == null ? 0 : this.zziC.length;
                        zzag.zza[] zzaVarArr = new zzag.zza[iZzc + length];
                        if (length != 0) {
                            System.arraycopy(this.zziC, 0, zzaVarArr, 0, length);
                        }
                        while (length < zzaVarArr.length - 1) {
                            zzaVarArr[length] = new zzag.zza();
                            zzsmVar.zza(zzaVarArr[length]);
                            zzsmVar.zzIX();
                            length++;
                        }
                        zzaVarArr[length] = new zzag.zza();
                        zzsmVar.zza(zzaVarArr[length]);
                        this.zziC = zzaVarArr;
                        break;
                    case 18:
                        int iZzc2 = zzsx.zzc(zzsmVar, 18);
                        int length2 = this.zziD == null ? 0 : this.zziD.length;
                        zzag.zza[] zzaVarArr2 = new zzag.zza[iZzc2 + length2];
                        if (length2 != 0) {
                            System.arraycopy(this.zziD, 0, zzaVarArr2, 0, length2);
                        }
                        while (length2 < zzaVarArr2.length - 1) {
                            zzaVarArr2[length2] = new zzag.zza();
                            zzsmVar.zza(zzaVarArr2[length2]);
                            zzsmVar.zzIX();
                            length2++;
                        }
                        zzaVarArr2[length2] = new zzag.zza();
                        zzsmVar.zza(zzaVarArr2[length2]);
                        this.zziD = zzaVarArr2;
                        break;
                    case 26:
                        int iZzc3 = zzsx.zzc(zzsmVar, 26);
                        int length3 = this.zziE == null ? 0 : this.zziE.length;
                        zzc[] zzcVarArr = new zzc[iZzc3 + length3];
                        if (length3 != 0) {
                            System.arraycopy(this.zziE, 0, zzcVarArr, 0, length3);
                        }
                        while (length3 < zzcVarArr.length - 1) {
                            zzcVarArr[length3] = new zzc();
                            zzsmVar.zza(zzcVarArr[length3]);
                            zzsmVar.zzIX();
                            length3++;
                        }
                        zzcVarArr[length3] = new zzc();
                        zzsmVar.zza(zzcVarArr[length3]);
                        this.zziE = zzcVarArr;
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
            if (this.zziC != null && this.zziC.length > 0) {
                int iZzc = iZzz;
                for (int i = 0; i < this.zziC.length; i++) {
                    zzag.zza zzaVar = this.zziC[i];
                    if (zzaVar != null) {
                        iZzc += zzsn.zzc(1, zzaVar);
                    }
                }
                iZzz = iZzc;
            }
            if (this.zziD != null && this.zziD.length > 0) {
                int iZzc2 = iZzz;
                for (int i2 = 0; i2 < this.zziD.length; i2++) {
                    zzag.zza zzaVar2 = this.zziD[i2];
                    if (zzaVar2 != null) {
                        iZzc2 += zzsn.zzc(2, zzaVar2);
                    }
                }
                iZzz = iZzc2;
            }
            if (this.zziE != null && this.zziE.length > 0) {
                for (int i3 = 0; i3 < this.zziE.length; i3++) {
                    zzc zzcVar = this.zziE[i3];
                    if (zzcVar != null) {
                        iZzz += zzsn.zzc(3, zzcVar);
                    }
                }
            }
            return iZzz;
        }
    }

    public static final class zze extends zzso<zze> {
        private static volatile zze[] zziF;
        public int key;
        public int value;

        public zze() {
            zzI();
        }

        public static zze[] zzH() {
            if (zziF == null) {
                synchronized (zzss.zzbut) {
                    if (zziF == null) {
                        zziF = new zze[0];
                    }
                }
            }
            return zziF;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zze)) {
                return false;
            }
            zze zzeVar = (zze) o;
            if (this.key != zzeVar.key || this.value != zzeVar.value) {
                return false;
            }
            if (this.zzbuj == null || this.zzbuj.isEmpty()) {
                return zzeVar.zzbuj == null || zzeVar.zzbuj.isEmpty();
            }
            return this.zzbuj.equals(zzeVar.zzbuj);
        }

        public int hashCode() {
            return ((this.zzbuj == null || this.zzbuj.isEmpty()) ? 0 : this.zzbuj.hashCode()) + ((((((getClass().getName().hashCode() + 527) * 31) + this.key) * 31) + this.value) * 31);
        }

        @Override // com.google.android.gms.internal.zzso, com.google.android.gms.internal.zzsu
        public void writeTo(zzsn output) throws IOException {
            output.zzA(1, this.key);
            output.zzA(2, this.value);
            super.writeTo(output);
        }

        public zze zzI() {
            this.key = 0;
            this.value = 0;
            this.zzbuj = null;
            this.zzbuu = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzsu
        /* JADX INFO: renamed from: zze, reason: merged with bridge method [inline-methods] */
        public zze mergeFrom(zzsm zzsmVar) throws IOException {
            while (true) {
                int iZzIX = zzsmVar.zzIX();
                switch (iZzIX) {
                    case 0:
                        break;
                    case 8:
                        this.key = zzsmVar.zzJb();
                        break;
                    case 16:
                        this.value = zzsmVar.zzJb();
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
            return super.zzz() + zzsn.zzC(1, this.key) + zzsn.zzC(2, this.value);
        }
    }

    public static final class zzf extends zzso<zzf> {
        public String version;
        public String[] zziG;
        public String[] zziH;
        public zzag.zza[] zziI;
        public zze[] zziJ;
        public zzb[] zziK;
        public zzb[] zziL;
        public zzb[] zziM;
        public zzg[] zziN;
        public String zziO;
        public String zziP;
        public String zziQ;
        public zza zziR;
        public float zziS;
        public boolean zziT;
        public String[] zziU;
        public int zziV;

        public zzf() {
            zzJ();
        }

        public static zzf zzc(byte[] bArr) throws zzst {
            return (zzf) zzsu.mergeFrom(new zzf(), bArr);
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzf)) {
                return false;
            }
            zzf zzfVar = (zzf) o;
            if (!zzss.equals(this.zziG, zzfVar.zziG) || !zzss.equals(this.zziH, zzfVar.zziH) || !zzss.equals(this.zziI, zzfVar.zziI) || !zzss.equals(this.zziJ, zzfVar.zziJ) || !zzss.equals(this.zziK, zzfVar.zziK) || !zzss.equals(this.zziL, zzfVar.zziL) || !zzss.equals(this.zziM, zzfVar.zziM) || !zzss.equals(this.zziN, zzfVar.zziN)) {
                return false;
            }
            if (this.zziO == null) {
                if (zzfVar.zziO != null) {
                    return false;
                }
            } else if (!this.zziO.equals(zzfVar.zziO)) {
                return false;
            }
            if (this.zziP == null) {
                if (zzfVar.zziP != null) {
                    return false;
                }
            } else if (!this.zziP.equals(zzfVar.zziP)) {
                return false;
            }
            if (this.zziQ == null) {
                if (zzfVar.zziQ != null) {
                    return false;
                }
            } else if (!this.zziQ.equals(zzfVar.zziQ)) {
                return false;
            }
            if (this.version == null) {
                if (zzfVar.version != null) {
                    return false;
                }
            } else if (!this.version.equals(zzfVar.version)) {
                return false;
            }
            if (this.zziR == null) {
                if (zzfVar.zziR != null) {
                    return false;
                }
            } else if (!this.zziR.equals(zzfVar.zziR)) {
                return false;
            }
            if (Float.floatToIntBits(this.zziS) != Float.floatToIntBits(zzfVar.zziS) || this.zziT != zzfVar.zziT || !zzss.equals(this.zziU, zzfVar.zziU) || this.zziV != zzfVar.zziV) {
                return false;
            }
            if (this.zzbuj == null || this.zzbuj.isEmpty()) {
                return zzfVar.zzbuj == null || zzfVar.zzbuj.isEmpty();
            }
            return this.zzbuj.equals(zzfVar.zzbuj);
        }

        public int hashCode() {
            int iHashCode = 0;
            int iHashCode2 = ((((((this.zziT ? 1231 : 1237) + (((((this.zziR == null ? 0 : this.zziR.hashCode()) + (((this.version == null ? 0 : this.version.hashCode()) + (((this.zziQ == null ? 0 : this.zziQ.hashCode()) + (((this.zziP == null ? 0 : this.zziP.hashCode()) + (((this.zziO == null ? 0 : this.zziO.hashCode()) + ((((((((((((((((((getClass().getName().hashCode() + 527) * 31) + zzss.hashCode(this.zziG)) * 31) + zzss.hashCode(this.zziH)) * 31) + zzss.hashCode(this.zziI)) * 31) + zzss.hashCode(this.zziJ)) * 31) + zzss.hashCode(this.zziK)) * 31) + zzss.hashCode(this.zziL)) * 31) + zzss.hashCode(this.zziM)) * 31) + zzss.hashCode(this.zziN)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31) + Float.floatToIntBits(this.zziS)) * 31)) * 31) + zzss.hashCode(this.zziU)) * 31) + this.zziV) * 31;
            if (this.zzbuj != null && !this.zzbuj.isEmpty()) {
                iHashCode = this.zzbuj.hashCode();
            }
            return iHashCode2 + iHashCode;
        }

        @Override // com.google.android.gms.internal.zzso, com.google.android.gms.internal.zzsu
        public void writeTo(zzsn output) throws IOException {
            if (this.zziH != null && this.zziH.length > 0) {
                for (int i = 0; i < this.zziH.length; i++) {
                    String str = this.zziH[i];
                    if (str != null) {
                        output.zzn(1, str);
                    }
                }
            }
            if (this.zziI != null && this.zziI.length > 0) {
                for (int i2 = 0; i2 < this.zziI.length; i2++) {
                    zzag.zza zzaVar = this.zziI[i2];
                    if (zzaVar != null) {
                        output.zza(2, zzaVar);
                    }
                }
            }
            if (this.zziJ != null && this.zziJ.length > 0) {
                for (int i3 = 0; i3 < this.zziJ.length; i3++) {
                    zze zzeVar = this.zziJ[i3];
                    if (zzeVar != null) {
                        output.zza(3, zzeVar);
                    }
                }
            }
            if (this.zziK != null && this.zziK.length > 0) {
                for (int i4 = 0; i4 < this.zziK.length; i4++) {
                    zzb zzbVar = this.zziK[i4];
                    if (zzbVar != null) {
                        output.zza(4, zzbVar);
                    }
                }
            }
            if (this.zziL != null && this.zziL.length > 0) {
                for (int i5 = 0; i5 < this.zziL.length; i5++) {
                    zzb zzbVar2 = this.zziL[i5];
                    if (zzbVar2 != null) {
                        output.zza(5, zzbVar2);
                    }
                }
            }
            if (this.zziM != null && this.zziM.length > 0) {
                for (int i6 = 0; i6 < this.zziM.length; i6++) {
                    zzb zzbVar3 = this.zziM[i6];
                    if (zzbVar3 != null) {
                        output.zza(6, zzbVar3);
                    }
                }
            }
            if (this.zziN != null && this.zziN.length > 0) {
                for (int i7 = 0; i7 < this.zziN.length; i7++) {
                    zzg zzgVar = this.zziN[i7];
                    if (zzgVar != null) {
                        output.zza(7, zzgVar);
                    }
                }
            }
            if (!this.zziO.equals("")) {
                output.zzn(9, this.zziO);
            }
            if (!this.zziP.equals("")) {
                output.zzn(10, this.zziP);
            }
            if (!this.zziQ.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                output.zzn(12, this.zziQ);
            }
            if (!this.version.equals("")) {
                output.zzn(13, this.version);
            }
            if (this.zziR != null) {
                output.zza(14, this.zziR);
            }
            if (Float.floatToIntBits(this.zziS) != Float.floatToIntBits(0.0f)) {
                output.zzb(15, this.zziS);
            }
            if (this.zziU != null && this.zziU.length > 0) {
                for (int i8 = 0; i8 < this.zziU.length; i8++) {
                    String str2 = this.zziU[i8];
                    if (str2 != null) {
                        output.zzn(16, str2);
                    }
                }
            }
            if (this.zziV != 0) {
                output.zzA(17, this.zziV);
            }
            if (this.zziT) {
                output.zze(18, this.zziT);
            }
            if (this.zziG != null && this.zziG.length > 0) {
                for (int i9 = 0; i9 < this.zziG.length; i9++) {
                    String str3 = this.zziG[i9];
                    if (str3 != null) {
                        output.zzn(19, str3);
                    }
                }
            }
            super.writeTo(output);
        }

        public zzf zzJ() {
            this.zziG = zzsx.zzbuB;
            this.zziH = zzsx.zzbuB;
            this.zziI = zzag.zza.zzQ();
            this.zziJ = zze.zzH();
            this.zziK = zzb.zzC();
            this.zziL = zzb.zzC();
            this.zziM = zzb.zzC();
            this.zziN = zzg.zzK();
            this.zziO = "";
            this.zziP = "";
            this.zziQ = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            this.version = "";
            this.zziR = null;
            this.zziS = 0.0f;
            this.zziT = false;
            this.zziU = zzsx.zzbuB;
            this.zziV = 0;
            this.zzbuj = null;
            this.zzbuu = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzsu
        /* JADX INFO: renamed from: zzf, reason: merged with bridge method [inline-methods] */
        public zzf mergeFrom(zzsm zzsmVar) throws IOException {
            while (true) {
                int iZzIX = zzsmVar.zzIX();
                switch (iZzIX) {
                    case 0:
                        break;
                    case 10:
                        int iZzc = zzsx.zzc(zzsmVar, 10);
                        int length = this.zziH == null ? 0 : this.zziH.length;
                        String[] strArr = new String[iZzc + length];
                        if (length != 0) {
                            System.arraycopy(this.zziH, 0, strArr, 0, length);
                        }
                        while (length < strArr.length - 1) {
                            strArr[length] = zzsmVar.readString();
                            zzsmVar.zzIX();
                            length++;
                        }
                        strArr[length] = zzsmVar.readString();
                        this.zziH = strArr;
                        break;
                    case 18:
                        int iZzc2 = zzsx.zzc(zzsmVar, 18);
                        int length2 = this.zziI == null ? 0 : this.zziI.length;
                        zzag.zza[] zzaVarArr = new zzag.zza[iZzc2 + length2];
                        if (length2 != 0) {
                            System.arraycopy(this.zziI, 0, zzaVarArr, 0, length2);
                        }
                        while (length2 < zzaVarArr.length - 1) {
                            zzaVarArr[length2] = new zzag.zza();
                            zzsmVar.zza(zzaVarArr[length2]);
                            zzsmVar.zzIX();
                            length2++;
                        }
                        zzaVarArr[length2] = new zzag.zza();
                        zzsmVar.zza(zzaVarArr[length2]);
                        this.zziI = zzaVarArr;
                        break;
                    case 26:
                        int iZzc3 = zzsx.zzc(zzsmVar, 26);
                        int length3 = this.zziJ == null ? 0 : this.zziJ.length;
                        zze[] zzeVarArr = new zze[iZzc3 + length3];
                        if (length3 != 0) {
                            System.arraycopy(this.zziJ, 0, zzeVarArr, 0, length3);
                        }
                        while (length3 < zzeVarArr.length - 1) {
                            zzeVarArr[length3] = new zze();
                            zzsmVar.zza(zzeVarArr[length3]);
                            zzsmVar.zzIX();
                            length3++;
                        }
                        zzeVarArr[length3] = new zze();
                        zzsmVar.zza(zzeVarArr[length3]);
                        this.zziJ = zzeVarArr;
                        break;
                    case 34:
                        int iZzc4 = zzsx.zzc(zzsmVar, 34);
                        int length4 = this.zziK == null ? 0 : this.zziK.length;
                        zzb[] zzbVarArr = new zzb[iZzc4 + length4];
                        if (length4 != 0) {
                            System.arraycopy(this.zziK, 0, zzbVarArr, 0, length4);
                        }
                        while (length4 < zzbVarArr.length - 1) {
                            zzbVarArr[length4] = new zzb();
                            zzsmVar.zza(zzbVarArr[length4]);
                            zzsmVar.zzIX();
                            length4++;
                        }
                        zzbVarArr[length4] = new zzb();
                        zzsmVar.zza(zzbVarArr[length4]);
                        this.zziK = zzbVarArr;
                        break;
                    case 42:
                        int iZzc5 = zzsx.zzc(zzsmVar, 42);
                        int length5 = this.zziL == null ? 0 : this.zziL.length;
                        zzb[] zzbVarArr2 = new zzb[iZzc5 + length5];
                        if (length5 != 0) {
                            System.arraycopy(this.zziL, 0, zzbVarArr2, 0, length5);
                        }
                        while (length5 < zzbVarArr2.length - 1) {
                            zzbVarArr2[length5] = new zzb();
                            zzsmVar.zza(zzbVarArr2[length5]);
                            zzsmVar.zzIX();
                            length5++;
                        }
                        zzbVarArr2[length5] = new zzb();
                        zzsmVar.zza(zzbVarArr2[length5]);
                        this.zziL = zzbVarArr2;
                        break;
                    case 50:
                        int iZzc6 = zzsx.zzc(zzsmVar, 50);
                        int length6 = this.zziM == null ? 0 : this.zziM.length;
                        zzb[] zzbVarArr3 = new zzb[iZzc6 + length6];
                        if (length6 != 0) {
                            System.arraycopy(this.zziM, 0, zzbVarArr3, 0, length6);
                        }
                        while (length6 < zzbVarArr3.length - 1) {
                            zzbVarArr3[length6] = new zzb();
                            zzsmVar.zza(zzbVarArr3[length6]);
                            zzsmVar.zzIX();
                            length6++;
                        }
                        zzbVarArr3[length6] = new zzb();
                        zzsmVar.zza(zzbVarArr3[length6]);
                        this.zziM = zzbVarArr3;
                        break;
                    case Place.TYPE_LOCKSMITH /* 58 */:
                        int iZzc7 = zzsx.zzc(zzsmVar, 58);
                        int length7 = this.zziN == null ? 0 : this.zziN.length;
                        zzg[] zzgVarArr = new zzg[iZzc7 + length7];
                        if (length7 != 0) {
                            System.arraycopy(this.zziN, 0, zzgVarArr, 0, length7);
                        }
                        while (length7 < zzgVarArr.length - 1) {
                            zzgVarArr[length7] = new zzg();
                            zzsmVar.zza(zzgVarArr[length7]);
                            zzsmVar.zzIX();
                            length7++;
                        }
                        zzgVarArr[length7] = new zzg();
                        zzsmVar.zza(zzgVarArr[length7]);
                        this.zziN = zzgVarArr;
                        break;
                    case Place.TYPE_PLACE_OF_WORSHIP /* 74 */:
                        this.zziO = zzsmVar.readString();
                        break;
                    case Place.TYPE_SCHOOL /* 82 */:
                        this.zziP = zzsmVar.readString();
                        break;
                    case 98:
                        this.zziQ = zzsmVar.readString();
                        break;
                    case 106:
                        this.version = zzsmVar.readString();
                        break;
                    case 114:
                        if (this.zziR == null) {
                            this.zziR = new zza();
                        }
                        zzsmVar.zza(this.zziR);
                        break;
                    case 125:
                        this.zziS = zzsmVar.readFloat();
                        break;
                    case TransportMediator.KEYCODE_MEDIA_RECORD /* 130 */:
                        int iZzc8 = zzsx.zzc(zzsmVar, TransportMediator.KEYCODE_MEDIA_RECORD);
                        int length8 = this.zziU == null ? 0 : this.zziU.length;
                        String[] strArr2 = new String[iZzc8 + length8];
                        if (length8 != 0) {
                            System.arraycopy(this.zziU, 0, strArr2, 0, length8);
                        }
                        while (length8 < strArr2.length - 1) {
                            strArr2[length8] = zzsmVar.readString();
                            zzsmVar.zzIX();
                            length8++;
                        }
                        strArr2[length8] = zzsmVar.readString();
                        this.zziU = strArr2;
                        break;
                    case 136:
                        this.zziV = zzsmVar.zzJb();
                        break;
                    case 144:
                        this.zziT = zzsmVar.zzJc();
                        break;
                    case 154:
                        int iZzc9 = zzsx.zzc(zzsmVar, 154);
                        int length9 = this.zziG == null ? 0 : this.zziG.length;
                        String[] strArr3 = new String[iZzc9 + length9];
                        if (length9 != 0) {
                            System.arraycopy(this.zziG, 0, strArr3, 0, length9);
                        }
                        while (length9 < strArr3.length - 1) {
                            strArr3[length9] = zzsmVar.readString();
                            zzsmVar.zzIX();
                            length9++;
                        }
                        strArr3[length9] = zzsmVar.readString();
                        this.zziG = strArr3;
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
            int iZzf;
            int iZzz = super.zzz();
            if (this.zziH == null || this.zziH.length <= 0) {
                iZzf = iZzz;
            } else {
                int iZzgO = 0;
                int i = 0;
                for (int i2 = 0; i2 < this.zziH.length; i2++) {
                    String str = this.zziH[i2];
                    if (str != null) {
                        i++;
                        iZzgO += zzsn.zzgO(str);
                    }
                }
                iZzf = iZzz + iZzgO + (i * 1);
            }
            if (this.zziI != null && this.zziI.length > 0) {
                int iZzc = iZzf;
                for (int i3 = 0; i3 < this.zziI.length; i3++) {
                    zzag.zza zzaVar = this.zziI[i3];
                    if (zzaVar != null) {
                        iZzc += zzsn.zzc(2, zzaVar);
                    }
                }
                iZzf = iZzc;
            }
            if (this.zziJ != null && this.zziJ.length > 0) {
                int iZzc2 = iZzf;
                for (int i4 = 0; i4 < this.zziJ.length; i4++) {
                    zze zzeVar = this.zziJ[i4];
                    if (zzeVar != null) {
                        iZzc2 += zzsn.zzc(3, zzeVar);
                    }
                }
                iZzf = iZzc2;
            }
            if (this.zziK != null && this.zziK.length > 0) {
                int iZzc3 = iZzf;
                for (int i5 = 0; i5 < this.zziK.length; i5++) {
                    zzb zzbVar = this.zziK[i5];
                    if (zzbVar != null) {
                        iZzc3 += zzsn.zzc(4, zzbVar);
                    }
                }
                iZzf = iZzc3;
            }
            if (this.zziL != null && this.zziL.length > 0) {
                int iZzc4 = iZzf;
                for (int i6 = 0; i6 < this.zziL.length; i6++) {
                    zzb zzbVar2 = this.zziL[i6];
                    if (zzbVar2 != null) {
                        iZzc4 += zzsn.zzc(5, zzbVar2);
                    }
                }
                iZzf = iZzc4;
            }
            if (this.zziM != null && this.zziM.length > 0) {
                int iZzc5 = iZzf;
                for (int i7 = 0; i7 < this.zziM.length; i7++) {
                    zzb zzbVar3 = this.zziM[i7];
                    if (zzbVar3 != null) {
                        iZzc5 += zzsn.zzc(6, zzbVar3);
                    }
                }
                iZzf = iZzc5;
            }
            if (this.zziN != null && this.zziN.length > 0) {
                int iZzc6 = iZzf;
                for (int i8 = 0; i8 < this.zziN.length; i8++) {
                    zzg zzgVar = this.zziN[i8];
                    if (zzgVar != null) {
                        iZzc6 += zzsn.zzc(7, zzgVar);
                    }
                }
                iZzf = iZzc6;
            }
            if (!this.zziO.equals("")) {
                iZzf += zzsn.zzo(9, this.zziO);
            }
            if (!this.zziP.equals("")) {
                iZzf += zzsn.zzo(10, this.zziP);
            }
            if (!this.zziQ.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                iZzf += zzsn.zzo(12, this.zziQ);
            }
            if (!this.version.equals("")) {
                iZzf += zzsn.zzo(13, this.version);
            }
            if (this.zziR != null) {
                iZzf += zzsn.zzc(14, this.zziR);
            }
            if (Float.floatToIntBits(this.zziS) != Float.floatToIntBits(0.0f)) {
                iZzf += zzsn.zzc(15, this.zziS);
            }
            if (this.zziU != null && this.zziU.length > 0) {
                int iZzgO2 = 0;
                int i9 = 0;
                for (int i10 = 0; i10 < this.zziU.length; i10++) {
                    String str2 = this.zziU[i10];
                    if (str2 != null) {
                        i9++;
                        iZzgO2 += zzsn.zzgO(str2);
                    }
                }
                iZzf = iZzf + iZzgO2 + (i9 * 2);
            }
            if (this.zziV != 0) {
                iZzf += zzsn.zzC(17, this.zziV);
            }
            if (this.zziT) {
                iZzf += zzsn.zzf(18, this.zziT);
            }
            if (this.zziG == null || this.zziG.length <= 0) {
                return iZzf;
            }
            int iZzgO3 = 0;
            int i11 = 0;
            for (int i12 = 0; i12 < this.zziG.length; i12++) {
                String str3 = this.zziG[i12];
                if (str3 != null) {
                    i11++;
                    iZzgO3 += zzsn.zzgO(str3);
                }
            }
            return iZzf + iZzgO3 + (i11 * 2);
        }
    }

    public static final class zzg extends zzso<zzg> {
        private static volatile zzg[] zziW;
        public int[] zziX;
        public int[] zziY;
        public int[] zziZ;
        public int[] zzja;
        public int[] zzjb;
        public int[] zzjc;
        public int[] zzjd;
        public int[] zzje;
        public int[] zzjf;
        public int[] zzjg;

        public zzg() {
            zzL();
        }

        public static zzg[] zzK() {
            if (zziW == null) {
                synchronized (zzss.zzbut) {
                    if (zziW == null) {
                        zziW = new zzg[0];
                    }
                }
            }
            return zziW;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzg)) {
                return false;
            }
            zzg zzgVar = (zzg) o;
            if (!zzss.equals(this.zziX, zzgVar.zziX) || !zzss.equals(this.zziY, zzgVar.zziY) || !zzss.equals(this.zziZ, zzgVar.zziZ) || !zzss.equals(this.zzja, zzgVar.zzja) || !zzss.equals(this.zzjb, zzgVar.zzjb) || !zzss.equals(this.zzjc, zzgVar.zzjc) || !zzss.equals(this.zzjd, zzgVar.zzjd) || !zzss.equals(this.zzje, zzgVar.zzje) || !zzss.equals(this.zzjf, zzgVar.zzjf) || !zzss.equals(this.zzjg, zzgVar.zzjg)) {
                return false;
            }
            if (this.zzbuj == null || this.zzbuj.isEmpty()) {
                return zzgVar.zzbuj == null || zzgVar.zzbuj.isEmpty();
            }
            return this.zzbuj.equals(zzgVar.zzbuj);
        }

        public int hashCode() {
            return ((this.zzbuj == null || this.zzbuj.isEmpty()) ? 0 : this.zzbuj.hashCode()) + ((((((((((((((((((((((getClass().getName().hashCode() + 527) * 31) + zzss.hashCode(this.zziX)) * 31) + zzss.hashCode(this.zziY)) * 31) + zzss.hashCode(this.zziZ)) * 31) + zzss.hashCode(this.zzja)) * 31) + zzss.hashCode(this.zzjb)) * 31) + zzss.hashCode(this.zzjc)) * 31) + zzss.hashCode(this.zzjd)) * 31) + zzss.hashCode(this.zzje)) * 31) + zzss.hashCode(this.zzjf)) * 31) + zzss.hashCode(this.zzjg)) * 31);
        }

        @Override // com.google.android.gms.internal.zzso, com.google.android.gms.internal.zzsu
        public void writeTo(zzsn output) throws IOException {
            if (this.zziX != null && this.zziX.length > 0) {
                for (int i = 0; i < this.zziX.length; i++) {
                    output.zzA(1, this.zziX[i]);
                }
            }
            if (this.zziY != null && this.zziY.length > 0) {
                for (int i2 = 0; i2 < this.zziY.length; i2++) {
                    output.zzA(2, this.zziY[i2]);
                }
            }
            if (this.zziZ != null && this.zziZ.length > 0) {
                for (int i3 = 0; i3 < this.zziZ.length; i3++) {
                    output.zzA(3, this.zziZ[i3]);
                }
            }
            if (this.zzja != null && this.zzja.length > 0) {
                for (int i4 = 0; i4 < this.zzja.length; i4++) {
                    output.zzA(4, this.zzja[i4]);
                }
            }
            if (this.zzjb != null && this.zzjb.length > 0) {
                for (int i5 = 0; i5 < this.zzjb.length; i5++) {
                    output.zzA(5, this.zzjb[i5]);
                }
            }
            if (this.zzjc != null && this.zzjc.length > 0) {
                for (int i6 = 0; i6 < this.zzjc.length; i6++) {
                    output.zzA(6, this.zzjc[i6]);
                }
            }
            if (this.zzjd != null && this.zzjd.length > 0) {
                for (int i7 = 0; i7 < this.zzjd.length; i7++) {
                    output.zzA(7, this.zzjd[i7]);
                }
            }
            if (this.zzje != null && this.zzje.length > 0) {
                for (int i8 = 0; i8 < this.zzje.length; i8++) {
                    output.zzA(8, this.zzje[i8]);
                }
            }
            if (this.zzjf != null && this.zzjf.length > 0) {
                for (int i9 = 0; i9 < this.zzjf.length; i9++) {
                    output.zzA(9, this.zzjf[i9]);
                }
            }
            if (this.zzjg != null && this.zzjg.length > 0) {
                for (int i10 = 0; i10 < this.zzjg.length; i10++) {
                    output.zzA(10, this.zzjg[i10]);
                }
            }
            super.writeTo(output);
        }

        public zzg zzL() {
            this.zziX = zzsx.zzbuw;
            this.zziY = zzsx.zzbuw;
            this.zziZ = zzsx.zzbuw;
            this.zzja = zzsx.zzbuw;
            this.zzjb = zzsx.zzbuw;
            this.zzjc = zzsx.zzbuw;
            this.zzjd = zzsx.zzbuw;
            this.zzje = zzsx.zzbuw;
            this.zzjf = zzsx.zzbuw;
            this.zzjg = zzsx.zzbuw;
            this.zzbuj = null;
            this.zzbuu = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzsu
        /* JADX INFO: renamed from: zzg, reason: merged with bridge method [inline-methods] */
        public zzg mergeFrom(zzsm zzsmVar) throws IOException {
            while (true) {
                int iZzIX = zzsmVar.zzIX();
                switch (iZzIX) {
                    case 0:
                        break;
                    case 8:
                        int iZzc = zzsx.zzc(zzsmVar, 8);
                        int length = this.zziX == null ? 0 : this.zziX.length;
                        int[] iArr = new int[iZzc + length];
                        if (length != 0) {
                            System.arraycopy(this.zziX, 0, iArr, 0, length);
                        }
                        while (length < iArr.length - 1) {
                            iArr[length] = zzsmVar.zzJb();
                            zzsmVar.zzIX();
                            length++;
                        }
                        iArr[length] = zzsmVar.zzJb();
                        this.zziX = iArr;
                        break;
                    case 10:
                        int iZzmq = zzsmVar.zzmq(zzsmVar.zzJf());
                        int position = zzsmVar.getPosition();
                        int i = 0;
                        while (zzsmVar.zzJk() > 0) {
                            zzsmVar.zzJb();
                            i++;
                        }
                        zzsmVar.zzms(position);
                        int length2 = this.zziX == null ? 0 : this.zziX.length;
                        int[] iArr2 = new int[i + length2];
                        if (length2 != 0) {
                            System.arraycopy(this.zziX, 0, iArr2, 0, length2);
                        }
                        while (length2 < iArr2.length) {
                            iArr2[length2] = zzsmVar.zzJb();
                            length2++;
                        }
                        this.zziX = iArr2;
                        zzsmVar.zzmr(iZzmq);
                        break;
                    case 16:
                        int iZzc2 = zzsx.zzc(zzsmVar, 16);
                        int length3 = this.zziY == null ? 0 : this.zziY.length;
                        int[] iArr3 = new int[iZzc2 + length3];
                        if (length3 != 0) {
                            System.arraycopy(this.zziY, 0, iArr3, 0, length3);
                        }
                        while (length3 < iArr3.length - 1) {
                            iArr3[length3] = zzsmVar.zzJb();
                            zzsmVar.zzIX();
                            length3++;
                        }
                        iArr3[length3] = zzsmVar.zzJb();
                        this.zziY = iArr3;
                        break;
                    case 18:
                        int iZzmq2 = zzsmVar.zzmq(zzsmVar.zzJf());
                        int position2 = zzsmVar.getPosition();
                        int i2 = 0;
                        while (zzsmVar.zzJk() > 0) {
                            zzsmVar.zzJb();
                            i2++;
                        }
                        zzsmVar.zzms(position2);
                        int length4 = this.zziY == null ? 0 : this.zziY.length;
                        int[] iArr4 = new int[i2 + length4];
                        if (length4 != 0) {
                            System.arraycopy(this.zziY, 0, iArr4, 0, length4);
                        }
                        while (length4 < iArr4.length) {
                            iArr4[length4] = zzsmVar.zzJb();
                            length4++;
                        }
                        this.zziY = iArr4;
                        zzsmVar.zzmr(iZzmq2);
                        break;
                    case 24:
                        int iZzc3 = zzsx.zzc(zzsmVar, 24);
                        int length5 = this.zziZ == null ? 0 : this.zziZ.length;
                        int[] iArr5 = new int[iZzc3 + length5];
                        if (length5 != 0) {
                            System.arraycopy(this.zziZ, 0, iArr5, 0, length5);
                        }
                        while (length5 < iArr5.length - 1) {
                            iArr5[length5] = zzsmVar.zzJb();
                            zzsmVar.zzIX();
                            length5++;
                        }
                        iArr5[length5] = zzsmVar.zzJb();
                        this.zziZ = iArr5;
                        break;
                    case 26:
                        int iZzmq3 = zzsmVar.zzmq(zzsmVar.zzJf());
                        int position3 = zzsmVar.getPosition();
                        int i3 = 0;
                        while (zzsmVar.zzJk() > 0) {
                            zzsmVar.zzJb();
                            i3++;
                        }
                        zzsmVar.zzms(position3);
                        int length6 = this.zziZ == null ? 0 : this.zziZ.length;
                        int[] iArr6 = new int[i3 + length6];
                        if (length6 != 0) {
                            System.arraycopy(this.zziZ, 0, iArr6, 0, length6);
                        }
                        while (length6 < iArr6.length) {
                            iArr6[length6] = zzsmVar.zzJb();
                            length6++;
                        }
                        this.zziZ = iArr6;
                        zzsmVar.zzmr(iZzmq3);
                        break;
                    case 32:
                        int iZzc4 = zzsx.zzc(zzsmVar, 32);
                        int length7 = this.zzja == null ? 0 : this.zzja.length;
                        int[] iArr7 = new int[iZzc4 + length7];
                        if (length7 != 0) {
                            System.arraycopy(this.zzja, 0, iArr7, 0, length7);
                        }
                        while (length7 < iArr7.length - 1) {
                            iArr7[length7] = zzsmVar.zzJb();
                            zzsmVar.zzIX();
                            length7++;
                        }
                        iArr7[length7] = zzsmVar.zzJb();
                        this.zzja = iArr7;
                        break;
                    case 34:
                        int iZzmq4 = zzsmVar.zzmq(zzsmVar.zzJf());
                        int position4 = zzsmVar.getPosition();
                        int i4 = 0;
                        while (zzsmVar.zzJk() > 0) {
                            zzsmVar.zzJb();
                            i4++;
                        }
                        zzsmVar.zzms(position4);
                        int length8 = this.zzja == null ? 0 : this.zzja.length;
                        int[] iArr8 = new int[i4 + length8];
                        if (length8 != 0) {
                            System.arraycopy(this.zzja, 0, iArr8, 0, length8);
                        }
                        while (length8 < iArr8.length) {
                            iArr8[length8] = zzsmVar.zzJb();
                            length8++;
                        }
                        this.zzja = iArr8;
                        zzsmVar.zzmr(iZzmq4);
                        break;
                    case 40:
                        int iZzc5 = zzsx.zzc(zzsmVar, 40);
                        int length9 = this.zzjb == null ? 0 : this.zzjb.length;
                        int[] iArr9 = new int[iZzc5 + length9];
                        if (length9 != 0) {
                            System.arraycopy(this.zzjb, 0, iArr9, 0, length9);
                        }
                        while (length9 < iArr9.length - 1) {
                            iArr9[length9] = zzsmVar.zzJb();
                            zzsmVar.zzIX();
                            length9++;
                        }
                        iArr9[length9] = zzsmVar.zzJb();
                        this.zzjb = iArr9;
                        break;
                    case 42:
                        int iZzmq5 = zzsmVar.zzmq(zzsmVar.zzJf());
                        int position5 = zzsmVar.getPosition();
                        int i5 = 0;
                        while (zzsmVar.zzJk() > 0) {
                            zzsmVar.zzJb();
                            i5++;
                        }
                        zzsmVar.zzms(position5);
                        int length10 = this.zzjb == null ? 0 : this.zzjb.length;
                        int[] iArr10 = new int[i5 + length10];
                        if (length10 != 0) {
                            System.arraycopy(this.zzjb, 0, iArr10, 0, length10);
                        }
                        while (length10 < iArr10.length) {
                            iArr10[length10] = zzsmVar.zzJb();
                            length10++;
                        }
                        this.zzjb = iArr10;
                        zzsmVar.zzmr(iZzmq5);
                        break;
                    case Place.TYPE_HINDU_TEMPLE /* 48 */:
                        int iZzc6 = zzsx.zzc(zzsmVar, 48);
                        int length11 = this.zzjc == null ? 0 : this.zzjc.length;
                        int[] iArr11 = new int[iZzc6 + length11];
                        if (length11 != 0) {
                            System.arraycopy(this.zzjc, 0, iArr11, 0, length11);
                        }
                        while (length11 < iArr11.length - 1) {
                            iArr11[length11] = zzsmVar.zzJb();
                            zzsmVar.zzIX();
                            length11++;
                        }
                        iArr11[length11] = zzsmVar.zzJb();
                        this.zzjc = iArr11;
                        break;
                    case 50:
                        int iZzmq6 = zzsmVar.zzmq(zzsmVar.zzJf());
                        int position6 = zzsmVar.getPosition();
                        int i6 = 0;
                        while (zzsmVar.zzJk() > 0) {
                            zzsmVar.zzJb();
                            i6++;
                        }
                        zzsmVar.zzms(position6);
                        int length12 = this.zzjc == null ? 0 : this.zzjc.length;
                        int[] iArr12 = new int[i6 + length12];
                        if (length12 != 0) {
                            System.arraycopy(this.zzjc, 0, iArr12, 0, length12);
                        }
                        while (length12 < iArr12.length) {
                            iArr12[length12] = zzsmVar.zzJb();
                            length12++;
                        }
                        this.zzjc = iArr12;
                        zzsmVar.zzmr(iZzmq6);
                        break;
                    case Place.TYPE_LIQUOR_STORE /* 56 */:
                        int iZzc7 = zzsx.zzc(zzsmVar, 56);
                        int length13 = this.zzjd == null ? 0 : this.zzjd.length;
                        int[] iArr13 = new int[iZzc7 + length13];
                        if (length13 != 0) {
                            System.arraycopy(this.zzjd, 0, iArr13, 0, length13);
                        }
                        while (length13 < iArr13.length - 1) {
                            iArr13[length13] = zzsmVar.zzJb();
                            zzsmVar.zzIX();
                            length13++;
                        }
                        iArr13[length13] = zzsmVar.zzJb();
                        this.zzjd = iArr13;
                        break;
                    case Place.TYPE_LOCKSMITH /* 58 */:
                        int iZzmq7 = zzsmVar.zzmq(zzsmVar.zzJf());
                        int position7 = zzsmVar.getPosition();
                        int i7 = 0;
                        while (zzsmVar.zzJk() > 0) {
                            zzsmVar.zzJb();
                            i7++;
                        }
                        zzsmVar.zzms(position7);
                        int length14 = this.zzjd == null ? 0 : this.zzjd.length;
                        int[] iArr14 = new int[i7 + length14];
                        if (length14 != 0) {
                            System.arraycopy(this.zzjd, 0, iArr14, 0, length14);
                        }
                        while (length14 < iArr14.length) {
                            iArr14[length14] = zzsmVar.zzJb();
                            length14++;
                        }
                        this.zzjd = iArr14;
                        zzsmVar.zzmr(iZzmq7);
                        break;
                    case 64:
                        int iZzc8 = zzsx.zzc(zzsmVar, 64);
                        int length15 = this.zzje == null ? 0 : this.zzje.length;
                        int[] iArr15 = new int[iZzc8 + length15];
                        if (length15 != 0) {
                            System.arraycopy(this.zzje, 0, iArr15, 0, length15);
                        }
                        while (length15 < iArr15.length - 1) {
                            iArr15[length15] = zzsmVar.zzJb();
                            zzsmVar.zzIX();
                            length15++;
                        }
                        iArr15[length15] = zzsmVar.zzJb();
                        this.zzje = iArr15;
                        break;
                    case Place.TYPE_MUSEUM /* 66 */:
                        int iZzmq8 = zzsmVar.zzmq(zzsmVar.zzJf());
                        int position8 = zzsmVar.getPosition();
                        int i8 = 0;
                        while (zzsmVar.zzJk() > 0) {
                            zzsmVar.zzJb();
                            i8++;
                        }
                        zzsmVar.zzms(position8);
                        int length16 = this.zzje == null ? 0 : this.zzje.length;
                        int[] iArr16 = new int[i8 + length16];
                        if (length16 != 0) {
                            System.arraycopy(this.zzje, 0, iArr16, 0, length16);
                        }
                        while (length16 < iArr16.length) {
                            iArr16[length16] = zzsmVar.zzJb();
                            length16++;
                        }
                        this.zzje = iArr16;
                        zzsmVar.zzmr(iZzmq8);
                        break;
                    case Place.TYPE_PHARMACY /* 72 */:
                        int iZzc9 = zzsx.zzc(zzsmVar, 72);
                        int length17 = this.zzjf == null ? 0 : this.zzjf.length;
                        int[] iArr17 = new int[iZzc9 + length17];
                        if (length17 != 0) {
                            System.arraycopy(this.zzjf, 0, iArr17, 0, length17);
                        }
                        while (length17 < iArr17.length - 1) {
                            iArr17[length17] = zzsmVar.zzJb();
                            zzsmVar.zzIX();
                            length17++;
                        }
                        iArr17[length17] = zzsmVar.zzJb();
                        this.zzjf = iArr17;
                        break;
                    case Place.TYPE_PLACE_OF_WORSHIP /* 74 */:
                        int iZzmq9 = zzsmVar.zzmq(zzsmVar.zzJf());
                        int position9 = zzsmVar.getPosition();
                        int i9 = 0;
                        while (zzsmVar.zzJk() > 0) {
                            zzsmVar.zzJb();
                            i9++;
                        }
                        zzsmVar.zzms(position9);
                        int length18 = this.zzjf == null ? 0 : this.zzjf.length;
                        int[] iArr18 = new int[i9 + length18];
                        if (length18 != 0) {
                            System.arraycopy(this.zzjf, 0, iArr18, 0, length18);
                        }
                        while (length18 < iArr18.length) {
                            iArr18[length18] = zzsmVar.zzJb();
                            length18++;
                        }
                        this.zzjf = iArr18;
                        zzsmVar.zzmr(iZzmq9);
                        break;
                    case Place.TYPE_ROOFING_CONTRACTOR /* 80 */:
                        int iZzc10 = zzsx.zzc(zzsmVar, 80);
                        int length19 = this.zzjg == null ? 0 : this.zzjg.length;
                        int[] iArr19 = new int[iZzc10 + length19];
                        if (length19 != 0) {
                            System.arraycopy(this.zzjg, 0, iArr19, 0, length19);
                        }
                        while (length19 < iArr19.length - 1) {
                            iArr19[length19] = zzsmVar.zzJb();
                            zzsmVar.zzIX();
                            length19++;
                        }
                        iArr19[length19] = zzsmVar.zzJb();
                        this.zzjg = iArr19;
                        break;
                    case Place.TYPE_SCHOOL /* 82 */:
                        int iZzmq10 = zzsmVar.zzmq(zzsmVar.zzJf());
                        int position10 = zzsmVar.getPosition();
                        int i10 = 0;
                        while (zzsmVar.zzJk() > 0) {
                            zzsmVar.zzJb();
                            i10++;
                        }
                        zzsmVar.zzms(position10);
                        int length20 = this.zzjg == null ? 0 : this.zzjg.length;
                        int[] iArr20 = new int[i10 + length20];
                        if (length20 != 0) {
                            System.arraycopy(this.zzjg, 0, iArr20, 0, length20);
                        }
                        while (length20 < iArr20.length) {
                            iArr20[length20] = zzsmVar.zzJb();
                            length20++;
                        }
                        this.zzjg = iArr20;
                        zzsmVar.zzmr(iZzmq10);
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
            if (this.zziX == null || this.zziX.length <= 0) {
                length = iZzz;
            } else {
                int iZzmx = 0;
                for (int i = 0; i < this.zziX.length; i++) {
                    iZzmx += zzsn.zzmx(this.zziX[i]);
                }
                length = iZzz + iZzmx + (this.zziX.length * 1);
            }
            if (this.zziY != null && this.zziY.length > 0) {
                int iZzmx2 = 0;
                for (int i2 = 0; i2 < this.zziY.length; i2++) {
                    iZzmx2 += zzsn.zzmx(this.zziY[i2]);
                }
                length = length + iZzmx2 + (this.zziY.length * 1);
            }
            if (this.zziZ != null && this.zziZ.length > 0) {
                int iZzmx3 = 0;
                for (int i3 = 0; i3 < this.zziZ.length; i3++) {
                    iZzmx3 += zzsn.zzmx(this.zziZ[i3]);
                }
                length = length + iZzmx3 + (this.zziZ.length * 1);
            }
            if (this.zzja != null && this.zzja.length > 0) {
                int iZzmx4 = 0;
                for (int i4 = 0; i4 < this.zzja.length; i4++) {
                    iZzmx4 += zzsn.zzmx(this.zzja[i4]);
                }
                length = length + iZzmx4 + (this.zzja.length * 1);
            }
            if (this.zzjb != null && this.zzjb.length > 0) {
                int iZzmx5 = 0;
                for (int i5 = 0; i5 < this.zzjb.length; i5++) {
                    iZzmx5 += zzsn.zzmx(this.zzjb[i5]);
                }
                length = length + iZzmx5 + (this.zzjb.length * 1);
            }
            if (this.zzjc != null && this.zzjc.length > 0) {
                int iZzmx6 = 0;
                for (int i6 = 0; i6 < this.zzjc.length; i6++) {
                    iZzmx6 += zzsn.zzmx(this.zzjc[i6]);
                }
                length = length + iZzmx6 + (this.zzjc.length * 1);
            }
            if (this.zzjd != null && this.zzjd.length > 0) {
                int iZzmx7 = 0;
                for (int i7 = 0; i7 < this.zzjd.length; i7++) {
                    iZzmx7 += zzsn.zzmx(this.zzjd[i7]);
                }
                length = length + iZzmx7 + (this.zzjd.length * 1);
            }
            if (this.zzje != null && this.zzje.length > 0) {
                int iZzmx8 = 0;
                for (int i8 = 0; i8 < this.zzje.length; i8++) {
                    iZzmx8 += zzsn.zzmx(this.zzje[i8]);
                }
                length = length + iZzmx8 + (this.zzje.length * 1);
            }
            if (this.zzjf != null && this.zzjf.length > 0) {
                int iZzmx9 = 0;
                for (int i9 = 0; i9 < this.zzjf.length; i9++) {
                    iZzmx9 += zzsn.zzmx(this.zzjf[i9]);
                }
                length = length + iZzmx9 + (this.zzjf.length * 1);
            }
            if (this.zzjg == null || this.zzjg.length <= 0) {
                return length;
            }
            int iZzmx10 = 0;
            for (int i10 = 0; i10 < this.zzjg.length; i10++) {
                iZzmx10 += zzsn.zzmx(this.zzjg[i10]);
            }
            return length + iZzmx10 + (this.zzjg.length * 1);
        }
    }

    public static final class zzh extends zzso<zzh> {
        public static final zzsp<zzag.zza, zzh> zzjh = zzsp.zza(11, zzh.class, 810);
        private static final zzh[] zzji = new zzh[0];
        public int[] zzjj;
        public int[] zzjk;
        public int[] zzjl;
        public int zzjm;
        public int[] zzjn;
        public int zzjo;
        public int zzjp;

        public zzh() {
            zzM();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzh)) {
                return false;
            }
            zzh zzhVar = (zzh) o;
            if (!zzss.equals(this.zzjj, zzhVar.zzjj) || !zzss.equals(this.zzjk, zzhVar.zzjk) || !zzss.equals(this.zzjl, zzhVar.zzjl) || this.zzjm != zzhVar.zzjm || !zzss.equals(this.zzjn, zzhVar.zzjn) || this.zzjo != zzhVar.zzjo || this.zzjp != zzhVar.zzjp) {
                return false;
            }
            if (this.zzbuj == null || this.zzbuj.isEmpty()) {
                return zzhVar.zzbuj == null || zzhVar.zzbuj.isEmpty();
            }
            return this.zzbuj.equals(zzhVar.zzbuj);
        }

        public int hashCode() {
            return ((this.zzbuj == null || this.zzbuj.isEmpty()) ? 0 : this.zzbuj.hashCode()) + ((((((((((((((((getClass().getName().hashCode() + 527) * 31) + zzss.hashCode(this.zzjj)) * 31) + zzss.hashCode(this.zzjk)) * 31) + zzss.hashCode(this.zzjl)) * 31) + this.zzjm) * 31) + zzss.hashCode(this.zzjn)) * 31) + this.zzjo) * 31) + this.zzjp) * 31);
        }

        @Override // com.google.android.gms.internal.zzso, com.google.android.gms.internal.zzsu
        public void writeTo(zzsn output) throws IOException {
            if (this.zzjj != null && this.zzjj.length > 0) {
                for (int i = 0; i < this.zzjj.length; i++) {
                    output.zzA(1, this.zzjj[i]);
                }
            }
            if (this.zzjk != null && this.zzjk.length > 0) {
                for (int i2 = 0; i2 < this.zzjk.length; i2++) {
                    output.zzA(2, this.zzjk[i2]);
                }
            }
            if (this.zzjl != null && this.zzjl.length > 0) {
                for (int i3 = 0; i3 < this.zzjl.length; i3++) {
                    output.zzA(3, this.zzjl[i3]);
                }
            }
            if (this.zzjm != 0) {
                output.zzA(4, this.zzjm);
            }
            if (this.zzjn != null && this.zzjn.length > 0) {
                for (int i4 = 0; i4 < this.zzjn.length; i4++) {
                    output.zzA(5, this.zzjn[i4]);
                }
            }
            if (this.zzjo != 0) {
                output.zzA(6, this.zzjo);
            }
            if (this.zzjp != 0) {
                output.zzA(7, this.zzjp);
            }
            super.writeTo(output);
        }

        public zzh zzM() {
            this.zzjj = zzsx.zzbuw;
            this.zzjk = zzsx.zzbuw;
            this.zzjl = zzsx.zzbuw;
            this.zzjm = 0;
            this.zzjn = zzsx.zzbuw;
            this.zzjo = 0;
            this.zzjp = 0;
            this.zzbuj = null;
            this.zzbuu = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzsu
        /* JADX INFO: renamed from: zzh, reason: merged with bridge method [inline-methods] */
        public zzh mergeFrom(zzsm zzsmVar) throws IOException {
            while (true) {
                int iZzIX = zzsmVar.zzIX();
                switch (iZzIX) {
                    case 0:
                        break;
                    case 8:
                        int iZzc = zzsx.zzc(zzsmVar, 8);
                        int length = this.zzjj == null ? 0 : this.zzjj.length;
                        int[] iArr = new int[iZzc + length];
                        if (length != 0) {
                            System.arraycopy(this.zzjj, 0, iArr, 0, length);
                        }
                        while (length < iArr.length - 1) {
                            iArr[length] = zzsmVar.zzJb();
                            zzsmVar.zzIX();
                            length++;
                        }
                        iArr[length] = zzsmVar.zzJb();
                        this.zzjj = iArr;
                        break;
                    case 10:
                        int iZzmq = zzsmVar.zzmq(zzsmVar.zzJf());
                        int position = zzsmVar.getPosition();
                        int i = 0;
                        while (zzsmVar.zzJk() > 0) {
                            zzsmVar.zzJb();
                            i++;
                        }
                        zzsmVar.zzms(position);
                        int length2 = this.zzjj == null ? 0 : this.zzjj.length;
                        int[] iArr2 = new int[i + length2];
                        if (length2 != 0) {
                            System.arraycopy(this.zzjj, 0, iArr2, 0, length2);
                        }
                        while (length2 < iArr2.length) {
                            iArr2[length2] = zzsmVar.zzJb();
                            length2++;
                        }
                        this.zzjj = iArr2;
                        zzsmVar.zzmr(iZzmq);
                        break;
                    case 16:
                        int iZzc2 = zzsx.zzc(zzsmVar, 16);
                        int length3 = this.zzjk == null ? 0 : this.zzjk.length;
                        int[] iArr3 = new int[iZzc2 + length3];
                        if (length3 != 0) {
                            System.arraycopy(this.zzjk, 0, iArr3, 0, length3);
                        }
                        while (length3 < iArr3.length - 1) {
                            iArr3[length3] = zzsmVar.zzJb();
                            zzsmVar.zzIX();
                            length3++;
                        }
                        iArr3[length3] = zzsmVar.zzJb();
                        this.zzjk = iArr3;
                        break;
                    case 18:
                        int iZzmq2 = zzsmVar.zzmq(zzsmVar.zzJf());
                        int position2 = zzsmVar.getPosition();
                        int i2 = 0;
                        while (zzsmVar.zzJk() > 0) {
                            zzsmVar.zzJb();
                            i2++;
                        }
                        zzsmVar.zzms(position2);
                        int length4 = this.zzjk == null ? 0 : this.zzjk.length;
                        int[] iArr4 = new int[i2 + length4];
                        if (length4 != 0) {
                            System.arraycopy(this.zzjk, 0, iArr4, 0, length4);
                        }
                        while (length4 < iArr4.length) {
                            iArr4[length4] = zzsmVar.zzJb();
                            length4++;
                        }
                        this.zzjk = iArr4;
                        zzsmVar.zzmr(iZzmq2);
                        break;
                    case 24:
                        int iZzc3 = zzsx.zzc(zzsmVar, 24);
                        int length5 = this.zzjl == null ? 0 : this.zzjl.length;
                        int[] iArr5 = new int[iZzc3 + length5];
                        if (length5 != 0) {
                            System.arraycopy(this.zzjl, 0, iArr5, 0, length5);
                        }
                        while (length5 < iArr5.length - 1) {
                            iArr5[length5] = zzsmVar.zzJb();
                            zzsmVar.zzIX();
                            length5++;
                        }
                        iArr5[length5] = zzsmVar.zzJb();
                        this.zzjl = iArr5;
                        break;
                    case 26:
                        int iZzmq3 = zzsmVar.zzmq(zzsmVar.zzJf());
                        int position3 = zzsmVar.getPosition();
                        int i3 = 0;
                        while (zzsmVar.zzJk() > 0) {
                            zzsmVar.zzJb();
                            i3++;
                        }
                        zzsmVar.zzms(position3);
                        int length6 = this.zzjl == null ? 0 : this.zzjl.length;
                        int[] iArr6 = new int[i3 + length6];
                        if (length6 != 0) {
                            System.arraycopy(this.zzjl, 0, iArr6, 0, length6);
                        }
                        while (length6 < iArr6.length) {
                            iArr6[length6] = zzsmVar.zzJb();
                            length6++;
                        }
                        this.zzjl = iArr6;
                        zzsmVar.zzmr(iZzmq3);
                        break;
                    case 32:
                        this.zzjm = zzsmVar.zzJb();
                        break;
                    case 40:
                        int iZzc4 = zzsx.zzc(zzsmVar, 40);
                        int length7 = this.zzjn == null ? 0 : this.zzjn.length;
                        int[] iArr7 = new int[iZzc4 + length7];
                        if (length7 != 0) {
                            System.arraycopy(this.zzjn, 0, iArr7, 0, length7);
                        }
                        while (length7 < iArr7.length - 1) {
                            iArr7[length7] = zzsmVar.zzJb();
                            zzsmVar.zzIX();
                            length7++;
                        }
                        iArr7[length7] = zzsmVar.zzJb();
                        this.zzjn = iArr7;
                        break;
                    case 42:
                        int iZzmq4 = zzsmVar.zzmq(zzsmVar.zzJf());
                        int position4 = zzsmVar.getPosition();
                        int i4 = 0;
                        while (zzsmVar.zzJk() > 0) {
                            zzsmVar.zzJb();
                            i4++;
                        }
                        zzsmVar.zzms(position4);
                        int length8 = this.zzjn == null ? 0 : this.zzjn.length;
                        int[] iArr8 = new int[i4 + length8];
                        if (length8 != 0) {
                            System.arraycopy(this.zzjn, 0, iArr8, 0, length8);
                        }
                        while (length8 < iArr8.length) {
                            iArr8[length8] = zzsmVar.zzJb();
                            length8++;
                        }
                        this.zzjn = iArr8;
                        zzsmVar.zzmr(iZzmq4);
                        break;
                    case Place.TYPE_HINDU_TEMPLE /* 48 */:
                        this.zzjo = zzsmVar.zzJb();
                        break;
                    case Place.TYPE_LIQUOR_STORE /* 56 */:
                        this.zzjp = zzsmVar.zzJb();
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
            int iZzC;
            int iZzz = super.zzz();
            if (this.zzjj == null || this.zzjj.length <= 0) {
                iZzC = iZzz;
            } else {
                int iZzmx = 0;
                for (int i = 0; i < this.zzjj.length; i++) {
                    iZzmx += zzsn.zzmx(this.zzjj[i]);
                }
                iZzC = iZzz + iZzmx + (this.zzjj.length * 1);
            }
            if (this.zzjk != null && this.zzjk.length > 0) {
                int iZzmx2 = 0;
                for (int i2 = 0; i2 < this.zzjk.length; i2++) {
                    iZzmx2 += zzsn.zzmx(this.zzjk[i2]);
                }
                iZzC = iZzC + iZzmx2 + (this.zzjk.length * 1);
            }
            if (this.zzjl != null && this.zzjl.length > 0) {
                int iZzmx3 = 0;
                for (int i3 = 0; i3 < this.zzjl.length; i3++) {
                    iZzmx3 += zzsn.zzmx(this.zzjl[i3]);
                }
                iZzC = iZzC + iZzmx3 + (this.zzjl.length * 1);
            }
            if (this.zzjm != 0) {
                iZzC += zzsn.zzC(4, this.zzjm);
            }
            if (this.zzjn != null && this.zzjn.length > 0) {
                int iZzmx4 = 0;
                for (int i4 = 0; i4 < this.zzjn.length; i4++) {
                    iZzmx4 += zzsn.zzmx(this.zzjn[i4]);
                }
                iZzC = iZzC + iZzmx4 + (this.zzjn.length * 1);
            }
            if (this.zzjo != 0) {
                iZzC += zzsn.zzC(6, this.zzjo);
            }
            return this.zzjp != 0 ? iZzC + zzsn.zzC(7, this.zzjp) : iZzC;
        }
    }

    public static final class zzi extends zzso<zzi> {
        private static volatile zzi[] zzjq;
        public String name;
        public zzag.zza zzjr;
        public zzd zzjs;

        public zzi() {
            zzO();
        }

        public static zzi[] zzN() {
            if (zzjq == null) {
                synchronized (zzss.zzbut) {
                    if (zzjq == null) {
                        zzjq = new zzi[0];
                    }
                }
            }
            return zzjq;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzi)) {
                return false;
            }
            zzi zziVar = (zzi) o;
            if (this.name == null) {
                if (zziVar.name != null) {
                    return false;
                }
            } else if (!this.name.equals(zziVar.name)) {
                return false;
            }
            if (this.zzjr == null) {
                if (zziVar.zzjr != null) {
                    return false;
                }
            } else if (!this.zzjr.equals(zziVar.zzjr)) {
                return false;
            }
            if (this.zzjs == null) {
                if (zziVar.zzjs != null) {
                    return false;
                }
            } else if (!this.zzjs.equals(zziVar.zzjs)) {
                return false;
            }
            if (this.zzbuj == null || this.zzbuj.isEmpty()) {
                return zziVar.zzbuj == null || zziVar.zzbuj.isEmpty();
            }
            return this.zzbuj.equals(zziVar.zzbuj);
        }

        public int hashCode() {
            int iHashCode = 0;
            int iHashCode2 = ((this.zzjs == null ? 0 : this.zzjs.hashCode()) + (((this.zzjr == null ? 0 : this.zzjr.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31;
            if (this.zzbuj != null && !this.zzbuj.isEmpty()) {
                iHashCode = this.zzbuj.hashCode();
            }
            return iHashCode2 + iHashCode;
        }

        @Override // com.google.android.gms.internal.zzso, com.google.android.gms.internal.zzsu
        public void writeTo(zzsn output) throws IOException {
            if (!this.name.equals("")) {
                output.zzn(1, this.name);
            }
            if (this.zzjr != null) {
                output.zza(2, this.zzjr);
            }
            if (this.zzjs != null) {
                output.zza(3, this.zzjs);
            }
            super.writeTo(output);
        }

        public zzi zzO() {
            this.name = "";
            this.zzjr = null;
            this.zzjs = null;
            this.zzbuj = null;
            this.zzbuu = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzsu
        /* JADX INFO: renamed from: zzi, reason: merged with bridge method [inline-methods] */
        public zzi mergeFrom(zzsm zzsmVar) throws IOException {
            while (true) {
                int iZzIX = zzsmVar.zzIX();
                switch (iZzIX) {
                    case 0:
                        break;
                    case 10:
                        this.name = zzsmVar.readString();
                        break;
                    case 18:
                        if (this.zzjr == null) {
                            this.zzjr = new zzag.zza();
                        }
                        zzsmVar.zza(this.zzjr);
                        break;
                    case 26:
                        if (this.zzjs == null) {
                            this.zzjs = new zzd();
                        }
                        zzsmVar.zza(this.zzjs);
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
            if (!this.name.equals("")) {
                iZzz += zzsn.zzo(1, this.name);
            }
            if (this.zzjr != null) {
                iZzz += zzsn.zzc(2, this.zzjr);
            }
            return this.zzjs != null ? iZzz + zzsn.zzc(3, this.zzjs) : iZzz;
        }
    }

    public static final class zzj extends zzso<zzj> {
        public zzi[] zzjt;
        public zzf zzju;
        public String zzjv;

        public zzj() {
            zzP();
        }

        public static zzj zzd(byte[] bArr) throws zzst {
            return (zzj) zzsu.mergeFrom(new zzj(), bArr);
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzj)) {
                return false;
            }
            zzj zzjVar = (zzj) o;
            if (!zzss.equals(this.zzjt, zzjVar.zzjt)) {
                return false;
            }
            if (this.zzju == null) {
                if (zzjVar.zzju != null) {
                    return false;
                }
            } else if (!this.zzju.equals(zzjVar.zzju)) {
                return false;
            }
            if (this.zzjv == null) {
                if (zzjVar.zzjv != null) {
                    return false;
                }
            } else if (!this.zzjv.equals(zzjVar.zzjv)) {
                return false;
            }
            if (this.zzbuj == null || this.zzbuj.isEmpty()) {
                return zzjVar.zzbuj == null || zzjVar.zzbuj.isEmpty();
            }
            return this.zzbuj.equals(zzjVar.zzbuj);
        }

        public int hashCode() {
            int iHashCode = 0;
            int iHashCode2 = ((this.zzjv == null ? 0 : this.zzjv.hashCode()) + (((this.zzju == null ? 0 : this.zzju.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + zzss.hashCode(this.zzjt)) * 31)) * 31)) * 31;
            if (this.zzbuj != null && !this.zzbuj.isEmpty()) {
                iHashCode = this.zzbuj.hashCode();
            }
            return iHashCode2 + iHashCode;
        }

        @Override // com.google.android.gms.internal.zzso, com.google.android.gms.internal.zzsu
        public void writeTo(zzsn output) throws IOException {
            if (this.zzjt != null && this.zzjt.length > 0) {
                for (int i = 0; i < this.zzjt.length; i++) {
                    zzi zziVar = this.zzjt[i];
                    if (zziVar != null) {
                        output.zza(1, zziVar);
                    }
                }
            }
            if (this.zzju != null) {
                output.zza(2, this.zzju);
            }
            if (!this.zzjv.equals("")) {
                output.zzn(3, this.zzjv);
            }
            super.writeTo(output);
        }

        public zzj zzP() {
            this.zzjt = zzi.zzN();
            this.zzju = null;
            this.zzjv = "";
            this.zzbuj = null;
            this.zzbuu = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzsu
        /* JADX INFO: renamed from: zzj, reason: merged with bridge method [inline-methods] */
        public zzj mergeFrom(zzsm zzsmVar) throws IOException {
            while (true) {
                int iZzIX = zzsmVar.zzIX();
                switch (iZzIX) {
                    case 0:
                        break;
                    case 10:
                        int iZzc = zzsx.zzc(zzsmVar, 10);
                        int length = this.zzjt == null ? 0 : this.zzjt.length;
                        zzi[] zziVarArr = new zzi[iZzc + length];
                        if (length != 0) {
                            System.arraycopy(this.zzjt, 0, zziVarArr, 0, length);
                        }
                        while (length < zziVarArr.length - 1) {
                            zziVarArr[length] = new zzi();
                            zzsmVar.zza(zziVarArr[length]);
                            zzsmVar.zzIX();
                            length++;
                        }
                        zziVarArr[length] = new zzi();
                        zzsmVar.zza(zziVarArr[length]);
                        this.zzjt = zziVarArr;
                        break;
                    case 18:
                        if (this.zzju == null) {
                            this.zzju = new zzf();
                        }
                        zzsmVar.zza(this.zzju);
                        break;
                    case 26:
                        this.zzjv = zzsmVar.readString();
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
            if (this.zzjt != null && this.zzjt.length > 0) {
                for (int i = 0; i < this.zzjt.length; i++) {
                    zzi zziVar = this.zzjt[i];
                    if (zziVar != null) {
                        iZzz += zzsn.zzc(1, zziVar);
                    }
                }
            }
            if (this.zzju != null) {
                iZzz += zzsn.zzc(2, this.zzju);
            }
            return !this.zzjv.equals("") ? iZzz + zzsn.zzo(3, this.zzjv) : iZzz;
        }
    }
}
