package com.google.android.gms.internal;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public interface zzpm {

    public static final class zza extends zzso<zza> {
        public C0164zza[] zzaMo;

        /* JADX INFO: renamed from: com.google.android.gms.internal.zzpm$zza$zza, reason: collision with other inner class name */
        public static final class C0164zza extends zzso<C0164zza> {
            private static volatile C0164zza[] zzaMp;
            public int viewId;
            public String zzaMq;
            public String zzaMr;

            public C0164zza() {
                zzyr();
            }

            public static C0164zza[] zzyq() {
                if (zzaMp == null) {
                    synchronized (zzss.zzbut) {
                        if (zzaMp == null) {
                            zzaMp = new C0164zza[0];
                        }
                    }
                }
                return zzaMp;
            }

            public boolean equals(Object o) {
                if (o == this) {
                    return true;
                }
                if (!(o instanceof C0164zza)) {
                    return false;
                }
                C0164zza c0164zza = (C0164zza) o;
                if (this.zzaMq == null) {
                    if (c0164zza.zzaMq != null) {
                        return false;
                    }
                } else if (!this.zzaMq.equals(c0164zza.zzaMq)) {
                    return false;
                }
                if (this.zzaMr == null) {
                    if (c0164zza.zzaMr != null) {
                        return false;
                    }
                } else if (!this.zzaMr.equals(c0164zza.zzaMr)) {
                    return false;
                }
                if (this.viewId != c0164zza.viewId) {
                    return false;
                }
                if (this.zzbuj == null || this.zzbuj.isEmpty()) {
                    return c0164zza.zzbuj == null || c0164zza.zzbuj.isEmpty();
                }
                return this.zzbuj.equals(c0164zza.zzbuj);
            }

            public int hashCode() {
                int iHashCode = 0;
                int iHashCode2 = ((((this.zzaMr == null ? 0 : this.zzaMr.hashCode()) + (((this.zzaMq == null ? 0 : this.zzaMq.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31) + this.viewId) * 31;
                if (this.zzbuj != null && !this.zzbuj.isEmpty()) {
                    iHashCode = this.zzbuj.hashCode();
                }
                return iHashCode2 + iHashCode;
            }

            @Override // com.google.android.gms.internal.zzso, com.google.android.gms.internal.zzsu
            public void writeTo(zzsn output) throws IOException {
                if (!this.zzaMq.equals("")) {
                    output.zzn(1, this.zzaMq);
                }
                if (!this.zzaMr.equals("")) {
                    output.zzn(2, this.zzaMr);
                }
                if (this.viewId != 0) {
                    output.zzA(3, this.viewId);
                }
                super.writeTo(output);
            }

            @Override // com.google.android.gms.internal.zzsu
            /* JADX INFO: renamed from: zzp, reason: merged with bridge method [inline-methods] */
            public C0164zza mergeFrom(zzsm zzsmVar) throws IOException {
                while (true) {
                    int iZzIX = zzsmVar.zzIX();
                    switch (iZzIX) {
                        case 0:
                            break;
                        case 10:
                            this.zzaMq = zzsmVar.readString();
                            break;
                        case 18:
                            this.zzaMr = zzsmVar.readString();
                            break;
                        case 24:
                            this.viewId = zzsmVar.zzJb();
                            break;
                        default:
                            if (!zza(zzsmVar, iZzIX)) {
                            }
                            break;
                    }
                }
                return this;
            }

            public C0164zza zzyr() {
                this.zzaMq = "";
                this.zzaMr = "";
                this.viewId = 0;
                this.zzbuj = null;
                this.zzbuu = -1;
                return this;
            }

            @Override // com.google.android.gms.internal.zzso, com.google.android.gms.internal.zzsu
            protected int zzz() {
                int iZzz = super.zzz();
                if (!this.zzaMq.equals("")) {
                    iZzz += zzsn.zzo(1, this.zzaMq);
                }
                if (!this.zzaMr.equals("")) {
                    iZzz += zzsn.zzo(2, this.zzaMr);
                }
                return this.viewId != 0 ? iZzz + zzsn.zzC(3, this.viewId) : iZzz;
            }
        }

        public zza() {
            zzyp();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zza)) {
                return false;
            }
            zza zzaVar = (zza) o;
            if (!zzss.equals(this.zzaMo, zzaVar.zzaMo)) {
                return false;
            }
            if (this.zzbuj == null || this.zzbuj.isEmpty()) {
                return zzaVar.zzbuj == null || zzaVar.zzbuj.isEmpty();
            }
            return this.zzbuj.equals(zzaVar.zzbuj);
        }

        public int hashCode() {
            return ((this.zzbuj == null || this.zzbuj.isEmpty()) ? 0 : this.zzbuj.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + zzss.hashCode(this.zzaMo)) * 31);
        }

        @Override // com.google.android.gms.internal.zzso, com.google.android.gms.internal.zzsu
        public void writeTo(zzsn output) throws IOException {
            if (this.zzaMo != null && this.zzaMo.length > 0) {
                for (int i = 0; i < this.zzaMo.length; i++) {
                    C0164zza c0164zza = this.zzaMo[i];
                    if (c0164zza != null) {
                        output.zza(1, c0164zza);
                    }
                }
            }
            super.writeTo(output);
        }

        @Override // com.google.android.gms.internal.zzsu
        /* JADX INFO: renamed from: zzo, reason: merged with bridge method [inline-methods] */
        public zza mergeFrom(zzsm zzsmVar) throws IOException {
            while (true) {
                int iZzIX = zzsmVar.zzIX();
                switch (iZzIX) {
                    case 0:
                        break;
                    case 10:
                        int iZzc = zzsx.zzc(zzsmVar, 10);
                        int length = this.zzaMo == null ? 0 : this.zzaMo.length;
                        C0164zza[] c0164zzaArr = new C0164zza[iZzc + length];
                        if (length != 0) {
                            System.arraycopy(this.zzaMo, 0, c0164zzaArr, 0, length);
                        }
                        while (length < c0164zzaArr.length - 1) {
                            c0164zzaArr[length] = new C0164zza();
                            zzsmVar.zza(c0164zzaArr[length]);
                            zzsmVar.zzIX();
                            length++;
                        }
                        c0164zzaArr[length] = new C0164zza();
                        zzsmVar.zza(c0164zzaArr[length]);
                        this.zzaMo = c0164zzaArr;
                        break;
                    default:
                        if (!zza(zzsmVar, iZzIX)) {
                        }
                        break;
                }
            }
            return this;
        }

        public zza zzyp() {
            this.zzaMo = C0164zza.zzyq();
            this.zzbuj = null;
            this.zzbuu = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzso, com.google.android.gms.internal.zzsu
        protected int zzz() {
            int iZzz = super.zzz();
            if (this.zzaMo != null && this.zzaMo.length > 0) {
                for (int i = 0; i < this.zzaMo.length; i++) {
                    C0164zza c0164zza = this.zzaMo[i];
                    if (c0164zza != null) {
                        iZzz += zzsn.zzc(1, c0164zza);
                    }
                }
            }
            return iZzz;
        }
    }

    public static final class zzb extends zzso<zzb> {
        private static volatile zzb[] zzaMs;
        public String name;
        public zzd zzaMt;

        public zzb() {
            zzyt();
        }

        public static zzb[] zzys() {
            if (zzaMs == null) {
                synchronized (zzss.zzbut) {
                    if (zzaMs == null) {
                        zzaMs = new zzb[0];
                    }
                }
            }
            return zzaMs;
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
            if (this.zzaMt == null) {
                if (zzbVar.zzaMt != null) {
                    return false;
                }
            } else if (!this.zzaMt.equals(zzbVar.zzaMt)) {
                return false;
            }
            if (this.zzbuj == null || this.zzbuj.isEmpty()) {
                return zzbVar.zzbuj == null || zzbVar.zzbuj.isEmpty();
            }
            return this.zzbuj.equals(zzbVar.zzbuj);
        }

        public int hashCode() {
            int iHashCode = 0;
            int iHashCode2 = ((this.zzaMt == null ? 0 : this.zzaMt.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31;
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
            if (this.zzaMt != null) {
                output.zza(2, this.zzaMt);
            }
            super.writeTo(output);
        }

        @Override // com.google.android.gms.internal.zzsu
        /* JADX INFO: renamed from: zzq, reason: merged with bridge method [inline-methods] */
        public zzb mergeFrom(zzsm zzsmVar) throws IOException {
            while (true) {
                int iZzIX = zzsmVar.zzIX();
                switch (iZzIX) {
                    case 0:
                        break;
                    case 10:
                        this.name = zzsmVar.readString();
                        break;
                    case 18:
                        if (this.zzaMt == null) {
                            this.zzaMt = new zzd();
                        }
                        zzsmVar.zza(this.zzaMt);
                        break;
                    default:
                        if (!zza(zzsmVar, iZzIX)) {
                        }
                        break;
                }
            }
            return this;
        }

        public zzb zzyt() {
            this.name = "";
            this.zzaMt = null;
            this.zzbuj = null;
            this.zzbuu = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzso, com.google.android.gms.internal.zzsu
        protected int zzz() {
            int iZzz = super.zzz();
            if (!this.name.equals("")) {
                iZzz += zzsn.zzo(1, this.name);
            }
            return this.zzaMt != null ? iZzz + zzsn.zzc(2, this.zzaMt) : iZzz;
        }
    }

    public static final class zzc extends zzso<zzc> {
        public String type;
        public zzb[] zzaMu;

        public zzc() {
            zzyu();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzc)) {
                return false;
            }
            zzc zzcVar = (zzc) o;
            if (this.type == null) {
                if (zzcVar.type != null) {
                    return false;
                }
            } else if (!this.type.equals(zzcVar.type)) {
                return false;
            }
            if (!zzss.equals(this.zzaMu, zzcVar.zzaMu)) {
                return false;
            }
            if (this.zzbuj == null || this.zzbuj.isEmpty()) {
                return zzcVar.zzbuj == null || zzcVar.zzbuj.isEmpty();
            }
            return this.zzbuj.equals(zzcVar.zzbuj);
        }

        public int hashCode() {
            int iHashCode = 0;
            int iHashCode2 = ((((this.type == null ? 0 : this.type.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31) + zzss.hashCode(this.zzaMu)) * 31;
            if (this.zzbuj != null && !this.zzbuj.isEmpty()) {
                iHashCode = this.zzbuj.hashCode();
            }
            return iHashCode2 + iHashCode;
        }

        @Override // com.google.android.gms.internal.zzso, com.google.android.gms.internal.zzsu
        public void writeTo(zzsn output) throws IOException {
            if (!this.type.equals("")) {
                output.zzn(1, this.type);
            }
            if (this.zzaMu != null && this.zzaMu.length > 0) {
                for (int i = 0; i < this.zzaMu.length; i++) {
                    zzb zzbVar = this.zzaMu[i];
                    if (zzbVar != null) {
                        output.zza(2, zzbVar);
                    }
                }
            }
            super.writeTo(output);
        }

        @Override // com.google.android.gms.internal.zzsu
        /* JADX INFO: renamed from: zzr, reason: merged with bridge method [inline-methods] */
        public zzc mergeFrom(zzsm zzsmVar) throws IOException {
            while (true) {
                int iZzIX = zzsmVar.zzIX();
                switch (iZzIX) {
                    case 0:
                        break;
                    case 10:
                        this.type = zzsmVar.readString();
                        break;
                    case 18:
                        int iZzc = zzsx.zzc(zzsmVar, 18);
                        int length = this.zzaMu == null ? 0 : this.zzaMu.length;
                        zzb[] zzbVarArr = new zzb[iZzc + length];
                        if (length != 0) {
                            System.arraycopy(this.zzaMu, 0, zzbVarArr, 0, length);
                        }
                        while (length < zzbVarArr.length - 1) {
                            zzbVarArr[length] = new zzb();
                            zzsmVar.zza(zzbVarArr[length]);
                            zzsmVar.zzIX();
                            length++;
                        }
                        zzbVarArr[length] = new zzb();
                        zzsmVar.zza(zzbVarArr[length]);
                        this.zzaMu = zzbVarArr;
                        break;
                    default:
                        if (!zza(zzsmVar, iZzIX)) {
                        }
                        break;
                }
            }
            return this;
        }

        public zzc zzyu() {
            this.type = "";
            this.zzaMu = zzb.zzys();
            this.zzbuj = null;
            this.zzbuu = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzso, com.google.android.gms.internal.zzsu
        protected int zzz() {
            int iZzz = super.zzz();
            if (!this.type.equals("")) {
                iZzz += zzsn.zzo(1, this.type);
            }
            if (this.zzaMu == null || this.zzaMu.length <= 0) {
                return iZzz;
            }
            int iZzc = iZzz;
            for (int i = 0; i < this.zzaMu.length; i++) {
                zzb zzbVar = this.zzaMu[i];
                if (zzbVar != null) {
                    iZzc += zzsn.zzc(2, zzbVar);
                }
            }
            return iZzc;
        }
    }

    public static final class zzd extends zzso<zzd> {
        public boolean zzaMv;
        public long zzaMw;
        public double zzaMx;
        public zzc zzaMy;
        public String zzamJ;

        public zzd() {
            zzyv();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzd)) {
                return false;
            }
            zzd zzdVar = (zzd) o;
            if (this.zzaMv != zzdVar.zzaMv) {
                return false;
            }
            if (this.zzamJ == null) {
                if (zzdVar.zzamJ != null) {
                    return false;
                }
            } else if (!this.zzamJ.equals(zzdVar.zzamJ)) {
                return false;
            }
            if (this.zzaMw != zzdVar.zzaMw || Double.doubleToLongBits(this.zzaMx) != Double.doubleToLongBits(zzdVar.zzaMx)) {
                return false;
            }
            if (this.zzaMy == null) {
                if (zzdVar.zzaMy != null) {
                    return false;
                }
            } else if (!this.zzaMy.equals(zzdVar.zzaMy)) {
                return false;
            }
            if (this.zzbuj == null || this.zzbuj.isEmpty()) {
                return zzdVar.zzbuj == null || zzdVar.zzbuj.isEmpty();
            }
            return this.zzbuj.equals(zzdVar.zzbuj);
        }

        public int hashCode() {
            int iHashCode = 0;
            int iHashCode2 = (((this.zzamJ == null ? 0 : this.zzamJ.hashCode()) + (((this.zzaMv ? 1231 : 1237) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31) + ((int) (this.zzaMw ^ (this.zzaMw >>> 32)));
            long jDoubleToLongBits = Double.doubleToLongBits(this.zzaMx);
            int iHashCode3 = ((this.zzaMy == null ? 0 : this.zzaMy.hashCode()) + (((iHashCode2 * 31) + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)))) * 31)) * 31;
            if (this.zzbuj != null && !this.zzbuj.isEmpty()) {
                iHashCode = this.zzbuj.hashCode();
            }
            return iHashCode3 + iHashCode;
        }

        @Override // com.google.android.gms.internal.zzso, com.google.android.gms.internal.zzsu
        public void writeTo(zzsn output) throws IOException {
            if (this.zzaMv) {
                output.zze(1, this.zzaMv);
            }
            if (!this.zzamJ.equals("")) {
                output.zzn(2, this.zzamJ);
            }
            if (this.zzaMw != 0) {
                output.zzb(3, this.zzaMw);
            }
            if (Double.doubleToLongBits(this.zzaMx) != Double.doubleToLongBits(0.0d)) {
                output.zza(4, this.zzaMx);
            }
            if (this.zzaMy != null) {
                output.zza(5, this.zzaMy);
            }
            super.writeTo(output);
        }

        @Override // com.google.android.gms.internal.zzsu
        /* JADX INFO: renamed from: zzs, reason: merged with bridge method [inline-methods] */
        public zzd mergeFrom(zzsm zzsmVar) throws IOException {
            while (true) {
                int iZzIX = zzsmVar.zzIX();
                switch (iZzIX) {
                    case 0:
                        break;
                    case 8:
                        this.zzaMv = zzsmVar.zzJc();
                        break;
                    case 18:
                        this.zzamJ = zzsmVar.readString();
                        break;
                    case 24:
                        this.zzaMw = zzsmVar.zzJa();
                        break;
                    case 33:
                        this.zzaMx = zzsmVar.readDouble();
                        break;
                    case 42:
                        if (this.zzaMy == null) {
                            this.zzaMy = new zzc();
                        }
                        zzsmVar.zza(this.zzaMy);
                        break;
                    default:
                        if (!zza(zzsmVar, iZzIX)) {
                        }
                        break;
                }
            }
            return this;
        }

        public zzd zzyv() {
            this.zzaMv = false;
            this.zzamJ = "";
            this.zzaMw = 0L;
            this.zzaMx = 0.0d;
            this.zzaMy = null;
            this.zzbuj = null;
            this.zzbuu = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzso, com.google.android.gms.internal.zzsu
        protected int zzz() {
            int iZzz = super.zzz();
            if (this.zzaMv) {
                iZzz += zzsn.zzf(1, this.zzaMv);
            }
            if (!this.zzamJ.equals("")) {
                iZzz += zzsn.zzo(2, this.zzamJ);
            }
            if (this.zzaMw != 0) {
                iZzz += zzsn.zzd(3, this.zzaMw);
            }
            if (Double.doubleToLongBits(this.zzaMx) != Double.doubleToLongBits(0.0d)) {
                iZzz += zzsn.zzb(4, this.zzaMx);
            }
            return this.zzaMy != null ? iZzz + zzsn.zzc(5, this.zzaMy) : iZzz;
        }
    }
}
