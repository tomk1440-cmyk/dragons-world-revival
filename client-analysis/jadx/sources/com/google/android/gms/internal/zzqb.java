package com.google.android.gms.internal;

import android.support.v4.media.TransportMediator;
import com.google.android.gms.location.places.Place;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public interface zzqb {

    public static final class zza extends zzsu {
        private static volatile zza[] zzaZZ;
        public Integer zzaZr;
        public zzf zzbaa;
        public zzf zzbab;
        public Boolean zzbac;

        public zza() {
            zzDQ();
        }

        public static zza[] zzDP() {
            if (zzaZZ == null) {
                synchronized (zzss.zzbut) {
                    if (zzaZZ == null) {
                        zzaZZ = new zza[0];
                    }
                }
            }
            return zzaZZ;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zza)) {
                return false;
            }
            zza zzaVar = (zza) o;
            if (this.zzaZr == null) {
                if (zzaVar.zzaZr != null) {
                    return false;
                }
            } else if (!this.zzaZr.equals(zzaVar.zzaZr)) {
                return false;
            }
            if (this.zzbaa == null) {
                if (zzaVar.zzbaa != null) {
                    return false;
                }
            } else if (!this.zzbaa.equals(zzaVar.zzbaa)) {
                return false;
            }
            if (this.zzbab == null) {
                if (zzaVar.zzbab != null) {
                    return false;
                }
            } else if (!this.zzbab.equals(zzaVar.zzbab)) {
                return false;
            }
            if (this.zzbac == null) {
                return zzaVar.zzbac == null;
            }
            return this.zzbac.equals(zzaVar.zzbac);
        }

        public int hashCode() {
            return (((this.zzbab == null ? 0 : this.zzbab.hashCode()) + (((this.zzbaa == null ? 0 : this.zzbaa.hashCode()) + (((this.zzaZr == null ? 0 : this.zzaZr.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31) + (this.zzbac != null ? this.zzbac.hashCode() : 0);
        }

        @Override // com.google.android.gms.internal.zzsu
        public void writeTo(zzsn output) throws IOException {
            if (this.zzaZr != null) {
                output.zzA(1, this.zzaZr.intValue());
            }
            if (this.zzbaa != null) {
                output.zza(2, this.zzbaa);
            }
            if (this.zzbab != null) {
                output.zza(3, this.zzbab);
            }
            if (this.zzbac != null) {
                output.zze(4, this.zzbac.booleanValue());
            }
            super.writeTo(output);
        }

        @Override // com.google.android.gms.internal.zzsu
        /* JADX INFO: renamed from: zzC, reason: merged with bridge method [inline-methods] */
        public zza mergeFrom(zzsm zzsmVar) throws IOException {
            while (true) {
                int iZzIX = zzsmVar.zzIX();
                switch (iZzIX) {
                    case 0:
                        break;
                    case 8:
                        this.zzaZr = Integer.valueOf(zzsmVar.zzJb());
                        break;
                    case 18:
                        if (this.zzbaa == null) {
                            this.zzbaa = new zzf();
                        }
                        zzsmVar.zza(this.zzbaa);
                        break;
                    case 26:
                        if (this.zzbab == null) {
                            this.zzbab = new zzf();
                        }
                        zzsmVar.zza(this.zzbab);
                        break;
                    case 32:
                        this.zzbac = Boolean.valueOf(zzsmVar.zzJc());
                        break;
                    default:
                        if (!zzsx.zzb(zzsmVar, iZzIX)) {
                        }
                        break;
                }
            }
            return this;
        }

        public zza zzDQ() {
            this.zzaZr = null;
            this.zzbaa = null;
            this.zzbab = null;
            this.zzbac = null;
            this.zzbuu = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzsu
        protected int zzz() {
            int iZzz = super.zzz();
            if (this.zzaZr != null) {
                iZzz += zzsn.zzC(1, this.zzaZr.intValue());
            }
            if (this.zzbaa != null) {
                iZzz += zzsn.zzc(2, this.zzbaa);
            }
            if (this.zzbab != null) {
                iZzz += zzsn.zzc(3, this.zzbab);
            }
            return this.zzbac != null ? iZzz + zzsn.zzf(4, this.zzbac.booleanValue()) : iZzz;
        }
    }

    public static final class zzb extends zzsu {
        private static volatile zzb[] zzbad;
        public Integer count;
        public String name;
        public zzc[] zzbae;
        public Long zzbaf;
        public Long zzbag;

        public zzb() {
            zzDS();
        }

        public static zzb[] zzDR() {
            if (zzbad == null) {
                synchronized (zzss.zzbut) {
                    if (zzbad == null) {
                        zzbad = new zzb[0];
                    }
                }
            }
            return zzbad;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzb)) {
                return false;
            }
            zzb zzbVar = (zzb) o;
            if (!zzss.equals(this.zzbae, zzbVar.zzbae)) {
                return false;
            }
            if (this.name == null) {
                if (zzbVar.name != null) {
                    return false;
                }
            } else if (!this.name.equals(zzbVar.name)) {
                return false;
            }
            if (this.zzbaf == null) {
                if (zzbVar.zzbaf != null) {
                    return false;
                }
            } else if (!this.zzbaf.equals(zzbVar.zzbaf)) {
                return false;
            }
            if (this.zzbag == null) {
                if (zzbVar.zzbag != null) {
                    return false;
                }
            } else if (!this.zzbag.equals(zzbVar.zzbag)) {
                return false;
            }
            if (this.count == null) {
                return zzbVar.count == null;
            }
            return this.count.equals(zzbVar.count);
        }

        public int hashCode() {
            return (((this.zzbag == null ? 0 : this.zzbag.hashCode()) + (((this.zzbaf == null ? 0 : this.zzbaf.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + zzss.hashCode(this.zzbae)) * 31)) * 31)) * 31)) * 31) + (this.count != null ? this.count.hashCode() : 0);
        }

        @Override // com.google.android.gms.internal.zzsu
        public void writeTo(zzsn output) throws IOException {
            if (this.zzbae != null && this.zzbae.length > 0) {
                for (int i = 0; i < this.zzbae.length; i++) {
                    zzc zzcVar = this.zzbae[i];
                    if (zzcVar != null) {
                        output.zza(1, zzcVar);
                    }
                }
            }
            if (this.name != null) {
                output.zzn(2, this.name);
            }
            if (this.zzbaf != null) {
                output.zzb(3, this.zzbaf.longValue());
            }
            if (this.zzbag != null) {
                output.zzb(4, this.zzbag.longValue());
            }
            if (this.count != null) {
                output.zzA(5, this.count.intValue());
            }
            super.writeTo(output);
        }

        @Override // com.google.android.gms.internal.zzsu
        /* JADX INFO: renamed from: zzD, reason: merged with bridge method [inline-methods] */
        public zzb mergeFrom(zzsm zzsmVar) throws IOException {
            while (true) {
                int iZzIX = zzsmVar.zzIX();
                switch (iZzIX) {
                    case 0:
                        break;
                    case 10:
                        int iZzc = zzsx.zzc(zzsmVar, 10);
                        int length = this.zzbae == null ? 0 : this.zzbae.length;
                        zzc[] zzcVarArr = new zzc[iZzc + length];
                        if (length != 0) {
                            System.arraycopy(this.zzbae, 0, zzcVarArr, 0, length);
                        }
                        while (length < zzcVarArr.length - 1) {
                            zzcVarArr[length] = new zzc();
                            zzsmVar.zza(zzcVarArr[length]);
                            zzsmVar.zzIX();
                            length++;
                        }
                        zzcVarArr[length] = new zzc();
                        zzsmVar.zza(zzcVarArr[length]);
                        this.zzbae = zzcVarArr;
                        break;
                    case 18:
                        this.name = zzsmVar.readString();
                        break;
                    case 24:
                        this.zzbaf = Long.valueOf(zzsmVar.zzJa());
                        break;
                    case 32:
                        this.zzbag = Long.valueOf(zzsmVar.zzJa());
                        break;
                    case 40:
                        this.count = Integer.valueOf(zzsmVar.zzJb());
                        break;
                    default:
                        if (!zzsx.zzb(zzsmVar, iZzIX)) {
                        }
                        break;
                }
            }
            return this;
        }

        public zzb zzDS() {
            this.zzbae = zzc.zzDT();
            this.name = null;
            this.zzbaf = null;
            this.zzbag = null;
            this.count = null;
            this.zzbuu = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzsu
        protected int zzz() {
            int iZzz = super.zzz();
            if (this.zzbae != null && this.zzbae.length > 0) {
                for (int i = 0; i < this.zzbae.length; i++) {
                    zzc zzcVar = this.zzbae[i];
                    if (zzcVar != null) {
                        iZzz += zzsn.zzc(1, zzcVar);
                    }
                }
            }
            if (this.name != null) {
                iZzz += zzsn.zzo(2, this.name);
            }
            if (this.zzbaf != null) {
                iZzz += zzsn.zzd(3, this.zzbaf.longValue());
            }
            if (this.zzbag != null) {
                iZzz += zzsn.zzd(4, this.zzbag.longValue());
            }
            return this.count != null ? iZzz + zzsn.zzC(5, this.count.intValue()) : iZzz;
        }
    }

    public static final class zzc extends zzsu {
        private static volatile zzc[] zzbah;
        public String name;
        public Float zzaZo;
        public String zzamJ;
        public Long zzbai;

        public zzc() {
            zzDU();
        }

        public static zzc[] zzDT() {
            if (zzbah == null) {
                synchronized (zzss.zzbut) {
                    if (zzbah == null) {
                        zzbah = new zzc[0];
                    }
                }
            }
            return zzbah;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzc)) {
                return false;
            }
            zzc zzcVar = (zzc) o;
            if (this.name == null) {
                if (zzcVar.name != null) {
                    return false;
                }
            } else if (!this.name.equals(zzcVar.name)) {
                return false;
            }
            if (this.zzamJ == null) {
                if (zzcVar.zzamJ != null) {
                    return false;
                }
            } else if (!this.zzamJ.equals(zzcVar.zzamJ)) {
                return false;
            }
            if (this.zzbai == null) {
                if (zzcVar.zzbai != null) {
                    return false;
                }
            } else if (!this.zzbai.equals(zzcVar.zzbai)) {
                return false;
            }
            if (this.zzaZo == null) {
                return zzcVar.zzaZo == null;
            }
            return this.zzaZo.equals(zzcVar.zzaZo);
        }

        public int hashCode() {
            return (((this.zzbai == null ? 0 : this.zzbai.hashCode()) + (((this.zzamJ == null ? 0 : this.zzamJ.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31) + (this.zzaZo != null ? this.zzaZo.hashCode() : 0);
        }

        @Override // com.google.android.gms.internal.zzsu
        public void writeTo(zzsn output) throws IOException {
            if (this.name != null) {
                output.zzn(1, this.name);
            }
            if (this.zzamJ != null) {
                output.zzn(2, this.zzamJ);
            }
            if (this.zzbai != null) {
                output.zzb(3, this.zzbai.longValue());
            }
            if (this.zzaZo != null) {
                output.zzb(4, this.zzaZo.floatValue());
            }
            super.writeTo(output);
        }

        public zzc zzDU() {
            this.name = null;
            this.zzamJ = null;
            this.zzbai = null;
            this.zzaZo = null;
            this.zzbuu = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzsu
        /* JADX INFO: renamed from: zzE, reason: merged with bridge method [inline-methods] */
        public zzc mergeFrom(zzsm zzsmVar) throws IOException {
            while (true) {
                int iZzIX = zzsmVar.zzIX();
                switch (iZzIX) {
                    case 0:
                        break;
                    case 10:
                        this.name = zzsmVar.readString();
                        break;
                    case 18:
                        this.zzamJ = zzsmVar.readString();
                        break;
                    case 24:
                        this.zzbai = Long.valueOf(zzsmVar.zzJa());
                        break;
                    case 37:
                        this.zzaZo = Float.valueOf(zzsmVar.readFloat());
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
            if (this.zzamJ != null) {
                iZzz += zzsn.zzo(2, this.zzamJ);
            }
            if (this.zzbai != null) {
                iZzz += zzsn.zzd(3, this.zzbai.longValue());
            }
            return this.zzaZo != null ? iZzz + zzsn.zzc(4, this.zzaZo.floatValue()) : iZzz;
        }
    }

    public static final class zzd extends zzsu {
        public zze[] zzbaj;

        public zzd() {
            zzDV();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            return (o instanceof zzd) && zzss.equals(this.zzbaj, ((zzd) o).zzbaj);
        }

        public int hashCode() {
            return ((getClass().getName().hashCode() + 527) * 31) + zzss.hashCode(this.zzbaj);
        }

        @Override // com.google.android.gms.internal.zzsu
        public void writeTo(zzsn output) throws IOException {
            if (this.zzbaj != null && this.zzbaj.length > 0) {
                for (int i = 0; i < this.zzbaj.length; i++) {
                    zze zzeVar = this.zzbaj[i];
                    if (zzeVar != null) {
                        output.zza(1, zzeVar);
                    }
                }
            }
            super.writeTo(output);
        }

        public zzd zzDV() {
            this.zzbaj = zze.zzDW();
            this.zzbuu = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzsu
        /* JADX INFO: renamed from: zzF, reason: merged with bridge method [inline-methods] */
        public zzd mergeFrom(zzsm zzsmVar) throws IOException {
            while (true) {
                int iZzIX = zzsmVar.zzIX();
                switch (iZzIX) {
                    case 0:
                        break;
                    case 10:
                        int iZzc = zzsx.zzc(zzsmVar, 10);
                        int length = this.zzbaj == null ? 0 : this.zzbaj.length;
                        zze[] zzeVarArr = new zze[iZzc + length];
                        if (length != 0) {
                            System.arraycopy(this.zzbaj, 0, zzeVarArr, 0, length);
                        }
                        while (length < zzeVarArr.length - 1) {
                            zzeVarArr[length] = new zze();
                            zzsmVar.zza(zzeVarArr[length]);
                            zzsmVar.zzIX();
                            length++;
                        }
                        zzeVarArr[length] = new zze();
                        zzsmVar.zza(zzeVarArr[length]);
                        this.zzbaj = zzeVarArr;
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
            if (this.zzbaj != null && this.zzbaj.length > 0) {
                for (int i = 0; i < this.zzbaj.length; i++) {
                    zze zzeVar = this.zzbaj[i];
                    if (zzeVar != null) {
                        iZzz += zzsn.zzc(1, zzeVar);
                    }
                }
            }
            return iZzz;
        }
    }

    public static final class zze extends zzsu {
        private static volatile zze[] zzbak;
        public String appId;
        public String osVersion;
        public String zzaMV;
        public String zzaVt;
        public String zzaVu;
        public String zzaVx;
        public Boolean zzbaA;
        public String zzbaB;
        public Long zzbaC;
        public Integer zzbaD;
        public Boolean zzbaE;
        public zza[] zzbaF;
        public Integer zzbal;
        public zzb[] zzbam;
        public zzg[] zzban;
        public Long zzbao;
        public Long zzbap;
        public Long zzbaq;
        public Long zzbar;
        public Long zzbas;
        public String zzbat;
        public String zzbau;
        public String zzbav;
        public Integer zzbaw;
        public Long zzbax;
        public Long zzbay;
        public String zzbaz;

        public zze() {
            zzDX();
        }

        public static zze[] zzDW() {
            if (zzbak == null) {
                synchronized (zzss.zzbut) {
                    if (zzbak == null) {
                        zzbak = new zze[0];
                    }
                }
            }
            return zzbak;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zze)) {
                return false;
            }
            zze zzeVar = (zze) o;
            if (this.zzbal == null) {
                if (zzeVar.zzbal != null) {
                    return false;
                }
            } else if (!this.zzbal.equals(zzeVar.zzbal)) {
                return false;
            }
            if (zzss.equals(this.zzbam, zzeVar.zzbam) && zzss.equals(this.zzban, zzeVar.zzban)) {
                if (this.zzbao == null) {
                    if (zzeVar.zzbao != null) {
                        return false;
                    }
                } else if (!this.zzbao.equals(zzeVar.zzbao)) {
                    return false;
                }
                if (this.zzbap == null) {
                    if (zzeVar.zzbap != null) {
                        return false;
                    }
                } else if (!this.zzbap.equals(zzeVar.zzbap)) {
                    return false;
                }
                if (this.zzbaq == null) {
                    if (zzeVar.zzbaq != null) {
                        return false;
                    }
                } else if (!this.zzbaq.equals(zzeVar.zzbaq)) {
                    return false;
                }
                if (this.zzbar == null) {
                    if (zzeVar.zzbar != null) {
                        return false;
                    }
                } else if (!this.zzbar.equals(zzeVar.zzbar)) {
                    return false;
                }
                if (this.zzbas == null) {
                    if (zzeVar.zzbas != null) {
                        return false;
                    }
                } else if (!this.zzbas.equals(zzeVar.zzbas)) {
                    return false;
                }
                if (this.zzbat == null) {
                    if (zzeVar.zzbat != null) {
                        return false;
                    }
                } else if (!this.zzbat.equals(zzeVar.zzbat)) {
                    return false;
                }
                if (this.osVersion == null) {
                    if (zzeVar.osVersion != null) {
                        return false;
                    }
                } else if (!this.osVersion.equals(zzeVar.osVersion)) {
                    return false;
                }
                if (this.zzbau == null) {
                    if (zzeVar.zzbau != null) {
                        return false;
                    }
                } else if (!this.zzbau.equals(zzeVar.zzbau)) {
                    return false;
                }
                if (this.zzbav == null) {
                    if (zzeVar.zzbav != null) {
                        return false;
                    }
                } else if (!this.zzbav.equals(zzeVar.zzbav)) {
                    return false;
                }
                if (this.zzbaw == null) {
                    if (zzeVar.zzbaw != null) {
                        return false;
                    }
                } else if (!this.zzbaw.equals(zzeVar.zzbaw)) {
                    return false;
                }
                if (this.zzaVu == null) {
                    if (zzeVar.zzaVu != null) {
                        return false;
                    }
                } else if (!this.zzaVu.equals(zzeVar.zzaVu)) {
                    return false;
                }
                if (this.appId == null) {
                    if (zzeVar.appId != null) {
                        return false;
                    }
                } else if (!this.appId.equals(zzeVar.appId)) {
                    return false;
                }
                if (this.zzaMV == null) {
                    if (zzeVar.zzaMV != null) {
                        return false;
                    }
                } else if (!this.zzaMV.equals(zzeVar.zzaMV)) {
                    return false;
                }
                if (this.zzbax == null) {
                    if (zzeVar.zzbax != null) {
                        return false;
                    }
                } else if (!this.zzbax.equals(zzeVar.zzbax)) {
                    return false;
                }
                if (this.zzbay == null) {
                    if (zzeVar.zzbay != null) {
                        return false;
                    }
                } else if (!this.zzbay.equals(zzeVar.zzbay)) {
                    return false;
                }
                if (this.zzbaz == null) {
                    if (zzeVar.zzbaz != null) {
                        return false;
                    }
                } else if (!this.zzbaz.equals(zzeVar.zzbaz)) {
                    return false;
                }
                if (this.zzbaA == null) {
                    if (zzeVar.zzbaA != null) {
                        return false;
                    }
                } else if (!this.zzbaA.equals(zzeVar.zzbaA)) {
                    return false;
                }
                if (this.zzbaB == null) {
                    if (zzeVar.zzbaB != null) {
                        return false;
                    }
                } else if (!this.zzbaB.equals(zzeVar.zzbaB)) {
                    return false;
                }
                if (this.zzbaC == null) {
                    if (zzeVar.zzbaC != null) {
                        return false;
                    }
                } else if (!this.zzbaC.equals(zzeVar.zzbaC)) {
                    return false;
                }
                if (this.zzbaD == null) {
                    if (zzeVar.zzbaD != null) {
                        return false;
                    }
                } else if (!this.zzbaD.equals(zzeVar.zzbaD)) {
                    return false;
                }
                if (this.zzaVx == null) {
                    if (zzeVar.zzaVx != null) {
                        return false;
                    }
                } else if (!this.zzaVx.equals(zzeVar.zzaVx)) {
                    return false;
                }
                if (this.zzaVt == null) {
                    if (zzeVar.zzaVt != null) {
                        return false;
                    }
                } else if (!this.zzaVt.equals(zzeVar.zzaVt)) {
                    return false;
                }
                if (this.zzbaE == null) {
                    if (zzeVar.zzbaE != null) {
                        return false;
                    }
                } else if (!this.zzbaE.equals(zzeVar.zzbaE)) {
                    return false;
                }
                return zzss.equals(this.zzbaF, zzeVar.zzbaF);
            }
            return false;
        }

        public int hashCode() {
            return (((((this.zzaVt == null ? 0 : this.zzaVt.hashCode()) + (((this.zzaVx == null ? 0 : this.zzaVx.hashCode()) + (((this.zzbaD == null ? 0 : this.zzbaD.hashCode()) + (((this.zzbaC == null ? 0 : this.zzbaC.hashCode()) + (((this.zzbaB == null ? 0 : this.zzbaB.hashCode()) + (((this.zzbaA == null ? 0 : this.zzbaA.hashCode()) + (((this.zzbaz == null ? 0 : this.zzbaz.hashCode()) + (((this.zzbay == null ? 0 : this.zzbay.hashCode()) + (((this.zzbax == null ? 0 : this.zzbax.hashCode()) + (((this.zzaMV == null ? 0 : this.zzaMV.hashCode()) + (((this.appId == null ? 0 : this.appId.hashCode()) + (((this.zzaVu == null ? 0 : this.zzaVu.hashCode()) + (((this.zzbaw == null ? 0 : this.zzbaw.hashCode()) + (((this.zzbav == null ? 0 : this.zzbav.hashCode()) + (((this.zzbau == null ? 0 : this.zzbau.hashCode()) + (((this.osVersion == null ? 0 : this.osVersion.hashCode()) + (((this.zzbat == null ? 0 : this.zzbat.hashCode()) + (((this.zzbas == null ? 0 : this.zzbas.hashCode()) + (((this.zzbar == null ? 0 : this.zzbar.hashCode()) + (((this.zzbaq == null ? 0 : this.zzbaq.hashCode()) + (((this.zzbap == null ? 0 : this.zzbap.hashCode()) + (((this.zzbao == null ? 0 : this.zzbao.hashCode()) + (((((((this.zzbal == null ? 0 : this.zzbal.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31) + zzss.hashCode(this.zzbam)) * 31) + zzss.hashCode(this.zzban)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31) + (this.zzbaE != null ? this.zzbaE.hashCode() : 0)) * 31) + zzss.hashCode(this.zzbaF);
        }

        @Override // com.google.android.gms.internal.zzsu
        public void writeTo(zzsn output) throws IOException {
            if (this.zzbal != null) {
                output.zzA(1, this.zzbal.intValue());
            }
            if (this.zzbam != null && this.zzbam.length > 0) {
                for (int i = 0; i < this.zzbam.length; i++) {
                    zzb zzbVar = this.zzbam[i];
                    if (zzbVar != null) {
                        output.zza(2, zzbVar);
                    }
                }
            }
            if (this.zzban != null && this.zzban.length > 0) {
                for (int i2 = 0; i2 < this.zzban.length; i2++) {
                    zzg zzgVar = this.zzban[i2];
                    if (zzgVar != null) {
                        output.zza(3, zzgVar);
                    }
                }
            }
            if (this.zzbao != null) {
                output.zzb(4, this.zzbao.longValue());
            }
            if (this.zzbap != null) {
                output.zzb(5, this.zzbap.longValue());
            }
            if (this.zzbaq != null) {
                output.zzb(6, this.zzbaq.longValue());
            }
            if (this.zzbas != null) {
                output.zzb(7, this.zzbas.longValue());
            }
            if (this.zzbat != null) {
                output.zzn(8, this.zzbat);
            }
            if (this.osVersion != null) {
                output.zzn(9, this.osVersion);
            }
            if (this.zzbau != null) {
                output.zzn(10, this.zzbau);
            }
            if (this.zzbav != null) {
                output.zzn(11, this.zzbav);
            }
            if (this.zzbaw != null) {
                output.zzA(12, this.zzbaw.intValue());
            }
            if (this.zzaVu != null) {
                output.zzn(13, this.zzaVu);
            }
            if (this.appId != null) {
                output.zzn(14, this.appId);
            }
            if (this.zzaMV != null) {
                output.zzn(16, this.zzaMV);
            }
            if (this.zzbax != null) {
                output.zzb(17, this.zzbax.longValue());
            }
            if (this.zzbay != null) {
                output.zzb(18, this.zzbay.longValue());
            }
            if (this.zzbaz != null) {
                output.zzn(19, this.zzbaz);
            }
            if (this.zzbaA != null) {
                output.zze(20, this.zzbaA.booleanValue());
            }
            if (this.zzbaB != null) {
                output.zzn(21, this.zzbaB);
            }
            if (this.zzbaC != null) {
                output.zzb(22, this.zzbaC.longValue());
            }
            if (this.zzbaD != null) {
                output.zzA(23, this.zzbaD.intValue());
            }
            if (this.zzaVx != null) {
                output.zzn(24, this.zzaVx);
            }
            if (this.zzaVt != null) {
                output.zzn(25, this.zzaVt);
            }
            if (this.zzbar != null) {
                output.zzb(26, this.zzbar.longValue());
            }
            if (this.zzbaE != null) {
                output.zze(28, this.zzbaE.booleanValue());
            }
            if (this.zzbaF != null && this.zzbaF.length > 0) {
                for (int i3 = 0; i3 < this.zzbaF.length; i3++) {
                    zza zzaVar = this.zzbaF[i3];
                    if (zzaVar != null) {
                        output.zza(29, zzaVar);
                    }
                }
            }
            super.writeTo(output);
        }

        public zze zzDX() {
            this.zzbal = null;
            this.zzbam = zzb.zzDR();
            this.zzban = zzg.zzDZ();
            this.zzbao = null;
            this.zzbap = null;
            this.zzbaq = null;
            this.zzbar = null;
            this.zzbas = null;
            this.zzbat = null;
            this.osVersion = null;
            this.zzbau = null;
            this.zzbav = null;
            this.zzbaw = null;
            this.zzaVu = null;
            this.appId = null;
            this.zzaMV = null;
            this.zzbax = null;
            this.zzbay = null;
            this.zzbaz = null;
            this.zzbaA = null;
            this.zzbaB = null;
            this.zzbaC = null;
            this.zzbaD = null;
            this.zzaVx = null;
            this.zzaVt = null;
            this.zzbaE = null;
            this.zzbaF = zza.zzDP();
            this.zzbuu = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzsu
        /* JADX INFO: renamed from: zzG, reason: merged with bridge method [inline-methods] */
        public zze mergeFrom(zzsm zzsmVar) throws IOException {
            while (true) {
                int iZzIX = zzsmVar.zzIX();
                switch (iZzIX) {
                    case 0:
                        break;
                    case 8:
                        this.zzbal = Integer.valueOf(zzsmVar.zzJb());
                        break;
                    case 18:
                        int iZzc = zzsx.zzc(zzsmVar, 18);
                        int length = this.zzbam == null ? 0 : this.zzbam.length;
                        zzb[] zzbVarArr = new zzb[iZzc + length];
                        if (length != 0) {
                            System.arraycopy(this.zzbam, 0, zzbVarArr, 0, length);
                        }
                        while (length < zzbVarArr.length - 1) {
                            zzbVarArr[length] = new zzb();
                            zzsmVar.zza(zzbVarArr[length]);
                            zzsmVar.zzIX();
                            length++;
                        }
                        zzbVarArr[length] = new zzb();
                        zzsmVar.zza(zzbVarArr[length]);
                        this.zzbam = zzbVarArr;
                        break;
                    case 26:
                        int iZzc2 = zzsx.zzc(zzsmVar, 26);
                        int length2 = this.zzban == null ? 0 : this.zzban.length;
                        zzg[] zzgVarArr = new zzg[iZzc2 + length2];
                        if (length2 != 0) {
                            System.arraycopy(this.zzban, 0, zzgVarArr, 0, length2);
                        }
                        while (length2 < zzgVarArr.length - 1) {
                            zzgVarArr[length2] = new zzg();
                            zzsmVar.zza(zzgVarArr[length2]);
                            zzsmVar.zzIX();
                            length2++;
                        }
                        zzgVarArr[length2] = new zzg();
                        zzsmVar.zza(zzgVarArr[length2]);
                        this.zzban = zzgVarArr;
                        break;
                    case 32:
                        this.zzbao = Long.valueOf(zzsmVar.zzJa());
                        break;
                    case 40:
                        this.zzbap = Long.valueOf(zzsmVar.zzJa());
                        break;
                    case Place.TYPE_HINDU_TEMPLE /* 48 */:
                        this.zzbaq = Long.valueOf(zzsmVar.zzJa());
                        break;
                    case Place.TYPE_LIQUOR_STORE /* 56 */:
                        this.zzbas = Long.valueOf(zzsmVar.zzJa());
                        break;
                    case Place.TYPE_MUSEUM /* 66 */:
                        this.zzbat = zzsmVar.readString();
                        break;
                    case Place.TYPE_PLACE_OF_WORSHIP /* 74 */:
                        this.osVersion = zzsmVar.readString();
                        break;
                    case Place.TYPE_SCHOOL /* 82 */:
                        this.zzbau = zzsmVar.readString();
                        break;
                    case 90:
                        this.zzbav = zzsmVar.readString();
                        break;
                    case Place.TYPE_ZOO /* 96 */:
                        this.zzbaw = Integer.valueOf(zzsmVar.zzJb());
                        break;
                    case 106:
                        this.zzaVu = zzsmVar.readString();
                        break;
                    case 114:
                        this.appId = zzsmVar.readString();
                        break;
                    case TransportMediator.KEYCODE_MEDIA_RECORD /* 130 */:
                        this.zzaMV = zzsmVar.readString();
                        break;
                    case 136:
                        this.zzbax = Long.valueOf(zzsmVar.zzJa());
                        break;
                    case 144:
                        this.zzbay = Long.valueOf(zzsmVar.zzJa());
                        break;
                    case 154:
                        this.zzbaz = zzsmVar.readString();
                        break;
                    case 160:
                        this.zzbaA = Boolean.valueOf(zzsmVar.zzJc());
                        break;
                    case 170:
                        this.zzbaB = zzsmVar.readString();
                        break;
                    case 176:
                        this.zzbaC = Long.valueOf(zzsmVar.zzJa());
                        break;
                    case 184:
                        this.zzbaD = Integer.valueOf(zzsmVar.zzJb());
                        break;
                    case 194:
                        this.zzaVx = zzsmVar.readString();
                        break;
                    case 202:
                        this.zzaVt = zzsmVar.readString();
                        break;
                    case 208:
                        this.zzbar = Long.valueOf(zzsmVar.zzJa());
                        break;
                    case 224:
                        this.zzbaE = Boolean.valueOf(zzsmVar.zzJc());
                        break;
                    case 234:
                        int iZzc3 = zzsx.zzc(zzsmVar, 234);
                        int length3 = this.zzbaF == null ? 0 : this.zzbaF.length;
                        zza[] zzaVarArr = new zza[iZzc3 + length3];
                        if (length3 != 0) {
                            System.arraycopy(this.zzbaF, 0, zzaVarArr, 0, length3);
                        }
                        while (length3 < zzaVarArr.length - 1) {
                            zzaVarArr[length3] = new zza();
                            zzsmVar.zza(zzaVarArr[length3]);
                            zzsmVar.zzIX();
                            length3++;
                        }
                        zzaVarArr[length3] = new zza();
                        zzsmVar.zza(zzaVarArr[length3]);
                        this.zzbaF = zzaVarArr;
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
            if (this.zzbal != null) {
                iZzz += zzsn.zzC(1, this.zzbal.intValue());
            }
            if (this.zzbam != null && this.zzbam.length > 0) {
                int iZzc = iZzz;
                for (int i = 0; i < this.zzbam.length; i++) {
                    zzb zzbVar = this.zzbam[i];
                    if (zzbVar != null) {
                        iZzc += zzsn.zzc(2, zzbVar);
                    }
                }
                iZzz = iZzc;
            }
            if (this.zzban != null && this.zzban.length > 0) {
                int iZzc2 = iZzz;
                for (int i2 = 0; i2 < this.zzban.length; i2++) {
                    zzg zzgVar = this.zzban[i2];
                    if (zzgVar != null) {
                        iZzc2 += zzsn.zzc(3, zzgVar);
                    }
                }
                iZzz = iZzc2;
            }
            if (this.zzbao != null) {
                iZzz += zzsn.zzd(4, this.zzbao.longValue());
            }
            if (this.zzbap != null) {
                iZzz += zzsn.zzd(5, this.zzbap.longValue());
            }
            if (this.zzbaq != null) {
                iZzz += zzsn.zzd(6, this.zzbaq.longValue());
            }
            if (this.zzbas != null) {
                iZzz += zzsn.zzd(7, this.zzbas.longValue());
            }
            if (this.zzbat != null) {
                iZzz += zzsn.zzo(8, this.zzbat);
            }
            if (this.osVersion != null) {
                iZzz += zzsn.zzo(9, this.osVersion);
            }
            if (this.zzbau != null) {
                iZzz += zzsn.zzo(10, this.zzbau);
            }
            if (this.zzbav != null) {
                iZzz += zzsn.zzo(11, this.zzbav);
            }
            if (this.zzbaw != null) {
                iZzz += zzsn.zzC(12, this.zzbaw.intValue());
            }
            if (this.zzaVu != null) {
                iZzz += zzsn.zzo(13, this.zzaVu);
            }
            if (this.appId != null) {
                iZzz += zzsn.zzo(14, this.appId);
            }
            if (this.zzaMV != null) {
                iZzz += zzsn.zzo(16, this.zzaMV);
            }
            if (this.zzbax != null) {
                iZzz += zzsn.zzd(17, this.zzbax.longValue());
            }
            if (this.zzbay != null) {
                iZzz += zzsn.zzd(18, this.zzbay.longValue());
            }
            if (this.zzbaz != null) {
                iZzz += zzsn.zzo(19, this.zzbaz);
            }
            if (this.zzbaA != null) {
                iZzz += zzsn.zzf(20, this.zzbaA.booleanValue());
            }
            if (this.zzbaB != null) {
                iZzz += zzsn.zzo(21, this.zzbaB);
            }
            if (this.zzbaC != null) {
                iZzz += zzsn.zzd(22, this.zzbaC.longValue());
            }
            if (this.zzbaD != null) {
                iZzz += zzsn.zzC(23, this.zzbaD.intValue());
            }
            if (this.zzaVx != null) {
                iZzz += zzsn.zzo(24, this.zzaVx);
            }
            if (this.zzaVt != null) {
                iZzz += zzsn.zzo(25, this.zzaVt);
            }
            if (this.zzbar != null) {
                iZzz += zzsn.zzd(26, this.zzbar.longValue());
            }
            if (this.zzbaE != null) {
                iZzz += zzsn.zzf(28, this.zzbaE.booleanValue());
            }
            if (this.zzbaF != null && this.zzbaF.length > 0) {
                for (int i3 = 0; i3 < this.zzbaF.length; i3++) {
                    zza zzaVar = this.zzbaF[i3];
                    if (zzaVar != null) {
                        iZzz += zzsn.zzc(29, zzaVar);
                    }
                }
            }
            return iZzz;
        }
    }

    public static final class zzf extends zzsu {
        public long[] zzbaG;
        public long[] zzbaH;

        public zzf() {
            zzDY();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzf)) {
                return false;
            }
            zzf zzfVar = (zzf) o;
            return zzss.equals(this.zzbaG, zzfVar.zzbaG) && zzss.equals(this.zzbaH, zzfVar.zzbaH);
        }

        public int hashCode() {
            return ((((getClass().getName().hashCode() + 527) * 31) + zzss.hashCode(this.zzbaG)) * 31) + zzss.hashCode(this.zzbaH);
        }

        @Override // com.google.android.gms.internal.zzsu
        public void writeTo(zzsn output) throws IOException {
            if (this.zzbaG != null && this.zzbaG.length > 0) {
                for (int i = 0; i < this.zzbaG.length; i++) {
                    output.zza(1, this.zzbaG[i]);
                }
            }
            if (this.zzbaH != null && this.zzbaH.length > 0) {
                for (int i2 = 0; i2 < this.zzbaH.length; i2++) {
                    output.zza(2, this.zzbaH[i2]);
                }
            }
            super.writeTo(output);
        }

        public zzf zzDY() {
            this.zzbaG = zzsx.zzbux;
            this.zzbaH = zzsx.zzbux;
            this.zzbuu = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzsu
        /* JADX INFO: renamed from: zzH, reason: merged with bridge method [inline-methods] */
        public zzf mergeFrom(zzsm zzsmVar) throws IOException {
            while (true) {
                int iZzIX = zzsmVar.zzIX();
                switch (iZzIX) {
                    case 0:
                        break;
                    case 8:
                        int iZzc = zzsx.zzc(zzsmVar, 8);
                        int length = this.zzbaG == null ? 0 : this.zzbaG.length;
                        long[] jArr = new long[iZzc + length];
                        if (length != 0) {
                            System.arraycopy(this.zzbaG, 0, jArr, 0, length);
                        }
                        while (length < jArr.length - 1) {
                            jArr[length] = zzsmVar.zzIZ();
                            zzsmVar.zzIX();
                            length++;
                        }
                        jArr[length] = zzsmVar.zzIZ();
                        this.zzbaG = jArr;
                        break;
                    case 10:
                        int iZzmq = zzsmVar.zzmq(zzsmVar.zzJf());
                        int position = zzsmVar.getPosition();
                        int i = 0;
                        while (zzsmVar.zzJk() > 0) {
                            zzsmVar.zzIZ();
                            i++;
                        }
                        zzsmVar.zzms(position);
                        int length2 = this.zzbaG == null ? 0 : this.zzbaG.length;
                        long[] jArr2 = new long[i + length2];
                        if (length2 != 0) {
                            System.arraycopy(this.zzbaG, 0, jArr2, 0, length2);
                        }
                        while (length2 < jArr2.length) {
                            jArr2[length2] = zzsmVar.zzIZ();
                            length2++;
                        }
                        this.zzbaG = jArr2;
                        zzsmVar.zzmr(iZzmq);
                        break;
                    case 16:
                        int iZzc2 = zzsx.zzc(zzsmVar, 16);
                        int length3 = this.zzbaH == null ? 0 : this.zzbaH.length;
                        long[] jArr3 = new long[iZzc2 + length3];
                        if (length3 != 0) {
                            System.arraycopy(this.zzbaH, 0, jArr3, 0, length3);
                        }
                        while (length3 < jArr3.length - 1) {
                            jArr3[length3] = zzsmVar.zzIZ();
                            zzsmVar.zzIX();
                            length3++;
                        }
                        jArr3[length3] = zzsmVar.zzIZ();
                        this.zzbaH = jArr3;
                        break;
                    case 18:
                        int iZzmq2 = zzsmVar.zzmq(zzsmVar.zzJf());
                        int position2 = zzsmVar.getPosition();
                        int i2 = 0;
                        while (zzsmVar.zzJk() > 0) {
                            zzsmVar.zzIZ();
                            i2++;
                        }
                        zzsmVar.zzms(position2);
                        int length4 = this.zzbaH == null ? 0 : this.zzbaH.length;
                        long[] jArr4 = new long[i2 + length4];
                        if (length4 != 0) {
                            System.arraycopy(this.zzbaH, 0, jArr4, 0, length4);
                        }
                        while (length4 < jArr4.length) {
                            jArr4[length4] = zzsmVar.zzIZ();
                            length4++;
                        }
                        this.zzbaH = jArr4;
                        zzsmVar.zzmr(iZzmq2);
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
            int length;
            int iZzz = super.zzz();
            if (this.zzbaG == null || this.zzbaG.length <= 0) {
                length = iZzz;
            } else {
                int iZzar = 0;
                for (int i = 0; i < this.zzbaG.length; i++) {
                    iZzar += zzsn.zzar(this.zzbaG[i]);
                }
                length = iZzz + iZzar + (this.zzbaG.length * 1);
            }
            if (this.zzbaH == null || this.zzbaH.length <= 0) {
                return length;
            }
            int iZzar2 = 0;
            for (int i2 = 0; i2 < this.zzbaH.length; i2++) {
                iZzar2 += zzsn.zzar(this.zzbaH[i2]);
            }
            return length + iZzar2 + (this.zzbaH.length * 1);
        }
    }

    public static final class zzg extends zzsu {
        private static volatile zzg[] zzbaI;
        public String name;
        public Float zzaZo;
        public String zzamJ;
        public Long zzbaJ;
        public Long zzbai;

        public zzg() {
            zzEa();
        }

        public static zzg[] zzDZ() {
            if (zzbaI == null) {
                synchronized (zzss.zzbut) {
                    if (zzbaI == null) {
                        zzbaI = new zzg[0];
                    }
                }
            }
            return zzbaI;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzg)) {
                return false;
            }
            zzg zzgVar = (zzg) o;
            if (this.zzbaJ == null) {
                if (zzgVar.zzbaJ != null) {
                    return false;
                }
            } else if (!this.zzbaJ.equals(zzgVar.zzbaJ)) {
                return false;
            }
            if (this.name == null) {
                if (zzgVar.name != null) {
                    return false;
                }
            } else if (!this.name.equals(zzgVar.name)) {
                return false;
            }
            if (this.zzamJ == null) {
                if (zzgVar.zzamJ != null) {
                    return false;
                }
            } else if (!this.zzamJ.equals(zzgVar.zzamJ)) {
                return false;
            }
            if (this.zzbai == null) {
                if (zzgVar.zzbai != null) {
                    return false;
                }
            } else if (!this.zzbai.equals(zzgVar.zzbai)) {
                return false;
            }
            if (this.zzaZo == null) {
                return zzgVar.zzaZo == null;
            }
            return this.zzaZo.equals(zzgVar.zzaZo);
        }

        public int hashCode() {
            return (((this.zzbai == null ? 0 : this.zzbai.hashCode()) + (((this.zzamJ == null ? 0 : this.zzamJ.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + (((this.zzbaJ == null ? 0 : this.zzbaJ.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31) + (this.zzaZo != null ? this.zzaZo.hashCode() : 0);
        }

        @Override // com.google.android.gms.internal.zzsu
        public void writeTo(zzsn output) throws IOException {
            if (this.zzbaJ != null) {
                output.zzb(1, this.zzbaJ.longValue());
            }
            if (this.name != null) {
                output.zzn(2, this.name);
            }
            if (this.zzamJ != null) {
                output.zzn(3, this.zzamJ);
            }
            if (this.zzbai != null) {
                output.zzb(4, this.zzbai.longValue());
            }
            if (this.zzaZo != null) {
                output.zzb(5, this.zzaZo.floatValue());
            }
            super.writeTo(output);
        }

        public zzg zzEa() {
            this.zzbaJ = null;
            this.name = null;
            this.zzamJ = null;
            this.zzbai = null;
            this.zzaZo = null;
            this.zzbuu = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzsu
        /* JADX INFO: renamed from: zzI, reason: merged with bridge method [inline-methods] */
        public zzg mergeFrom(zzsm zzsmVar) throws IOException {
            while (true) {
                int iZzIX = zzsmVar.zzIX();
                switch (iZzIX) {
                    case 0:
                        break;
                    case 8:
                        this.zzbaJ = Long.valueOf(zzsmVar.zzJa());
                        break;
                    case 18:
                        this.name = zzsmVar.readString();
                        break;
                    case 26:
                        this.zzamJ = zzsmVar.readString();
                        break;
                    case 32:
                        this.zzbai = Long.valueOf(zzsmVar.zzJa());
                        break;
                    case 45:
                        this.zzaZo = Float.valueOf(zzsmVar.readFloat());
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
            if (this.zzbaJ != null) {
                iZzz += zzsn.zzd(1, this.zzbaJ.longValue());
            }
            if (this.name != null) {
                iZzz += zzsn.zzo(2, this.name);
            }
            if (this.zzamJ != null) {
                iZzz += zzsn.zzo(3, this.zzamJ);
            }
            if (this.zzbai != null) {
                iZzz += zzsn.zzd(4, this.zzbai.longValue());
            }
            return this.zzaZo != null ? iZzz + zzsn.zzc(5, this.zzaZo.floatValue()) : iZzz;
        }
    }
}
