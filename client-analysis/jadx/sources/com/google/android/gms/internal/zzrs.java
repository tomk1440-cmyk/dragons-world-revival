package com.google.android.gms.internal;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class zzrs {

    public static class zza {
        private final zzag.zza zzbkI;
        private final Map<String, zzag.zza> zzbmi;

        private zza(Map<String, zzag.zza> map, zzag.zza zzaVar) {
            this.zzbmi = map;
            this.zzbkI = zzaVar;
        }

        public static zzb zzHH() {
            return new zzb();
        }

        public String toString() {
            return "Properties: " + zzHI() + " pushAfterEvaluate: " + this.zzbkI;
        }

        public Map<String, zzag.zza> zzHI() {
            return Collections.unmodifiableMap(this.zzbmi);
        }

        public zzag.zza zzHh() {
            return this.zzbkI;
        }

        public void zza(String str, zzag.zza zzaVar) {
            this.zzbmi.put(str, zzaVar);
        }
    }

    public static class zzb {
        private zzag.zza zzbkI;
        private final Map<String, zzag.zza> zzbmi;

        private zzb() {
            this.zzbmi = new HashMap();
        }

        public zza zzHJ() {
            return new zza(this.zzbmi, this.zzbkI);
        }

        public zzb zzb(String str, zzag.zza zzaVar) {
            this.zzbmi.put(str, zzaVar);
            return this;
        }

        public zzb zzq(zzag.zza zzaVar) {
            this.zzbkI = zzaVar;
            return this;
        }
    }

    public static class zzc {
        private final String zzadc;
        private final List<zze> zzbmj;
        private final Map<String, List<zza>> zzbmk;
        private final int zzbml;

        private zzc(List<zze> list, Map<String, List<zza>> map, String str, int i) {
            this.zzbmj = Collections.unmodifiableList(list);
            this.zzbmk = Collections.unmodifiableMap(map);
            this.zzadc = str;
            this.zzbml = i;
        }

        public static zzd zzHK() {
            return new zzd();
        }

        public String getVersion() {
            return this.zzadc;
        }

        public String toString() {
            return "Rules: " + zzHL() + "  Macros: " + this.zzbmk;
        }

        public List<zze> zzHL() {
            return this.zzbmj;
        }

        public Map<String, List<zza>> zzHM() {
            return this.zzbmk;
        }
    }

    public static class zzd {
        private String zzadc;
        private final List<zze> zzbmj;
        private final Map<String, List<zza>> zzbmk;
        private int zzbml;

        private zzd() {
            this.zzbmj = new ArrayList();
            this.zzbmk = new HashMap();
            this.zzadc = "";
            this.zzbml = 0;
        }

        public zzc zzHN() {
            return new zzc(this.zzbmj, this.zzbmk, this.zzadc, this.zzbml);
        }

        public zzd zzb(zze zzeVar) {
            this.zzbmj.add(zzeVar);
            return this;
        }

        public zzd zzc(zza zzaVar) {
            String strZzg = com.google.android.gms.tagmanager.zzdf.zzg(zzaVar.zzHI().get(zzae.INSTANCE_NAME.toString()));
            List<zza> arrayList = this.zzbmk.get(strZzg);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.zzbmk.put(strZzg, arrayList);
            }
            arrayList.add(zzaVar);
            return this;
        }

        public zzd zzgD(String str) {
            this.zzadc = str;
            return this;
        }

        public zzd zzko(int i) {
            this.zzbml = i;
            return this;
        }
    }

    public static class zze {
        private final List<zza> zzbmm;
        private final List<zza> zzbmn;
        private final List<zza> zzbmo;
        private final List<zza> zzbmp;
        private final List<zza> zzbmq;
        private final List<zza> zzbmr;
        private final List<String> zzbms;
        private final List<String> zzbmt;
        private final List<String> zzbmu;
        private final List<String> zzbmv;

        private zze(List<zza> list, List<zza> list2, List<zza> list3, List<zza> list4, List<zza> list5, List<zza> list6, List<String> list7, List<String> list8, List<String> list9, List<String> list10) {
            this.zzbmm = Collections.unmodifiableList(list);
            this.zzbmn = Collections.unmodifiableList(list2);
            this.zzbmo = Collections.unmodifiableList(list3);
            this.zzbmp = Collections.unmodifiableList(list4);
            this.zzbmq = Collections.unmodifiableList(list5);
            this.zzbmr = Collections.unmodifiableList(list6);
            this.zzbms = Collections.unmodifiableList(list7);
            this.zzbmt = Collections.unmodifiableList(list8);
            this.zzbmu = Collections.unmodifiableList(list9);
            this.zzbmv = Collections.unmodifiableList(list10);
        }

        public static zzf zzHO() {
            return new zzf();
        }

        public String toString() {
            return "Positive predicates: " + zzHP() + "  Negative predicates: " + zzHQ() + "  Add tags: " + zzHR() + "  Remove tags: " + zzHS() + "  Add macros: " + zzHT() + "  Remove macros: " + zzHY();
        }

        public List<zza> zzHP() {
            return this.zzbmm;
        }

        public List<zza> zzHQ() {
            return this.zzbmn;
        }

        public List<zza> zzHR() {
            return this.zzbmo;
        }

        public List<zza> zzHS() {
            return this.zzbmp;
        }

        public List<zza> zzHT() {
            return this.zzbmq;
        }

        public List<String> zzHU() {
            return this.zzbms;
        }

        public List<String> zzHV() {
            return this.zzbmt;
        }

        public List<String> zzHW() {
            return this.zzbmu;
        }

        public List<String> zzHX() {
            return this.zzbmv;
        }

        public List<zza> zzHY() {
            return this.zzbmr;
        }
    }

    public static class zzf {
        private final List<zza> zzbmm;
        private final List<zza> zzbmn;
        private final List<zza> zzbmo;
        private final List<zza> zzbmp;
        private final List<zza> zzbmq;
        private final List<zza> zzbmr;
        private final List<String> zzbms;
        private final List<String> zzbmt;
        private final List<String> zzbmu;
        private final List<String> zzbmv;

        private zzf() {
            this.zzbmm = new ArrayList();
            this.zzbmn = new ArrayList();
            this.zzbmo = new ArrayList();
            this.zzbmp = new ArrayList();
            this.zzbmq = new ArrayList();
            this.zzbmr = new ArrayList();
            this.zzbms = new ArrayList();
            this.zzbmt = new ArrayList();
            this.zzbmu = new ArrayList();
            this.zzbmv = new ArrayList();
        }

        public zze zzHZ() {
            return new zze(this.zzbmm, this.zzbmn, this.zzbmo, this.zzbmp, this.zzbmq, this.zzbmr, this.zzbms, this.zzbmt, this.zzbmu, this.zzbmv);
        }

        public zzf zzd(zza zzaVar) {
            this.zzbmm.add(zzaVar);
            return this;
        }

        public zzf zze(zza zzaVar) {
            this.zzbmn.add(zzaVar);
            return this;
        }

        public zzf zzf(zza zzaVar) {
            this.zzbmo.add(zzaVar);
            return this;
        }

        public zzf zzg(zza zzaVar) {
            this.zzbmp.add(zzaVar);
            return this;
        }

        public zzf zzgE(String str) {
            this.zzbmu.add(str);
            return this;
        }

        public zzf zzgF(String str) {
            this.zzbmv.add(str);
            return this;
        }

        public zzf zzgG(String str) {
            this.zzbms.add(str);
            return this;
        }

        public zzf zzgH(String str) {
            this.zzbmt.add(str);
            return this;
        }

        public zzf zzh(zza zzaVar) {
            this.zzbmq.add(zzaVar);
            return this;
        }

        public zzf zzi(zza zzaVar) {
            this.zzbmr.add(zzaVar);
            return this;
        }
    }

    public static class zzg extends Exception {
        public zzg(String str) {
            super(str);
        }
    }

    private static zzag.zza zza(int i, zzaf.zzf zzfVar, zzag.zza[] zzaVarArr, Set<Integer> set) throws zzg {
        int i2 = 0;
        if (set.contains(Integer.valueOf(i))) {
            zzgC("Value cycle detected.  Current value reference: " + i + ".  Previous value references: " + set + ".");
        }
        zzag.zza zzaVar = (zzag.zza) zza(zzfVar.zziI, i, "values");
        if (zzaVarArr[i] != null) {
            return zzaVarArr[i];
        }
        zzag.zza zzaVarZzo = null;
        set.add(Integer.valueOf(i));
        switch (zzaVar.type) {
            case 1:
            case 5:
            case 6:
            case 8:
                zzaVarZzo = zzaVar;
                break;
            case 2:
                zzaf.zzh zzhVarZzp = zzp(zzaVar);
                zzaVarZzo = zzo(zzaVar);
                zzaVarZzo.zzjy = new zzag.zza[zzhVarZzp.zzjj.length];
                int[] iArr = zzhVarZzp.zzjj;
                int length = iArr.length;
                int i3 = 0;
                while (i2 < length) {
                    zzaVarZzo.zzjy[i3] = zza(iArr[i2], zzfVar, zzaVarArr, set);
                    i2++;
                    i3++;
                }
                break;
            case 3:
                zzaVarZzo = zzo(zzaVar);
                zzaf.zzh zzhVarZzp2 = zzp(zzaVar);
                if (zzhVarZzp2.zzjk.length != zzhVarZzp2.zzjl.length) {
                    zzgC("Uneven map keys (" + zzhVarZzp2.zzjk.length + ") and map values (" + zzhVarZzp2.zzjl.length + ")");
                }
                zzaVarZzo.zzjz = new zzag.zza[zzhVarZzp2.zzjk.length];
                zzaVarZzo.zzjA = new zzag.zza[zzhVarZzp2.zzjk.length];
                int[] iArr2 = zzhVarZzp2.zzjk;
                int length2 = iArr2.length;
                int i4 = 0;
                int i5 = 0;
                while (i4 < length2) {
                    zzaVarZzo.zzjz[i5] = zza(iArr2[i4], zzfVar, zzaVarArr, set);
                    i4++;
                    i5++;
                }
                int[] iArr3 = zzhVarZzp2.zzjl;
                int length3 = iArr3.length;
                int i6 = 0;
                while (i2 < length3) {
                    zzaVarZzo.zzjA[i6] = zza(iArr3[i2], zzfVar, zzaVarArr, set);
                    i2++;
                    i6++;
                }
                break;
            case 4:
                zzaVarZzo = zzo(zzaVar);
                zzaVarZzo.zzjB = com.google.android.gms.tagmanager.zzdf.zzg(zza(zzp(zzaVar).zzjo, zzfVar, zzaVarArr, set));
                break;
            case 7:
                zzaVarZzo = zzo(zzaVar);
                zzaf.zzh zzhVarZzp3 = zzp(zzaVar);
                zzaVarZzo.zzjF = new zzag.zza[zzhVarZzp3.zzjn.length];
                int[] iArr4 = zzhVarZzp3.zzjn;
                int length4 = iArr4.length;
                int i7 = 0;
                while (i2 < length4) {
                    zzaVarZzo.zzjF[i7] = zza(iArr4[i2], zzfVar, zzaVarArr, set);
                    i2++;
                    i7++;
                }
                break;
        }
        if (zzaVarZzo == null) {
            zzgC("Invalid value: " + zzaVar);
        }
        zzaVarArr[i] = zzaVarZzo;
        set.remove(Integer.valueOf(i));
        return zzaVarZzo;
    }

    private static zza zza(zzaf.zzb zzbVar, zzaf.zzf zzfVar, zzag.zza[] zzaVarArr, int i) throws zzg {
        zzb zzbVarZzHH = zza.zzHH();
        for (int i2 : zzbVar.zzit) {
            zzaf.zze zzeVar = (zzaf.zze) zza(zzfVar.zziJ, Integer.valueOf(i2).intValue(), "properties");
            String str = (String) zza(zzfVar.zziH, zzeVar.key, "keys");
            zzag.zza zzaVar = (zzag.zza) zza(zzaVarArr, zzeVar.value, "values");
            if (zzae.PUSH_AFTER_EVALUATE.toString().equals(str)) {
                zzbVarZzHH.zzq(zzaVar);
            } else {
                zzbVarZzHH.zzb(str, zzaVar);
            }
        }
        return zzbVarZzHH.zzHJ();
    }

    private static zze zza(zzaf.zzg zzgVar, List<zza> list, List<zza> list2, List<zza> list3, zzaf.zzf zzfVar) {
        zzf zzfVarZzHO = zze.zzHO();
        for (int i : zzgVar.zziX) {
            zzfVarZzHO.zzd(list3.get(Integer.valueOf(i).intValue()));
        }
        for (int i2 : zzgVar.zziY) {
            zzfVarZzHO.zze(list3.get(Integer.valueOf(i2).intValue()));
        }
        for (int i3 : zzgVar.zziZ) {
            zzfVarZzHO.zzf(list.get(Integer.valueOf(i3).intValue()));
        }
        for (int i4 : zzgVar.zzjb) {
            zzfVarZzHO.zzgE(zzfVar.zziI[Integer.valueOf(i4).intValue()].zzjx);
        }
        for (int i5 : zzgVar.zzja) {
            zzfVarZzHO.zzg(list.get(Integer.valueOf(i5).intValue()));
        }
        for (int i6 : zzgVar.zzjc) {
            zzfVarZzHO.zzgF(zzfVar.zziI[Integer.valueOf(i6).intValue()].zzjx);
        }
        for (int i7 : zzgVar.zzjd) {
            zzfVarZzHO.zzh(list2.get(Integer.valueOf(i7).intValue()));
        }
        for (int i8 : zzgVar.zzjf) {
            zzfVarZzHO.zzgG(zzfVar.zziI[Integer.valueOf(i8).intValue()].zzjx);
        }
        for (int i9 : zzgVar.zzje) {
            zzfVarZzHO.zzi(list2.get(Integer.valueOf(i9).intValue()));
        }
        for (int i10 : zzgVar.zzjg) {
            zzfVarZzHO.zzgH(zzfVar.zziI[Integer.valueOf(i10).intValue()].zzjx);
        }
        return zzfVarZzHO.zzHZ();
    }

    private static <T> T zza(T[] tArr, int i, String str) throws zzg {
        if (i < 0 || i >= tArr.length) {
            zzgC("Index out of bounds detected: " + i + " in " + str);
        }
        return tArr[i];
    }

    public static zzc zzb(zzaf.zzf zzfVar) throws zzg {
        zzag.zza[] zzaVarArr = new zzag.zza[zzfVar.zziI.length];
        for (int i = 0; i < zzfVar.zziI.length; i++) {
            zza(i, zzfVar, zzaVarArr, new HashSet(0));
        }
        zzd zzdVarZzHK = zzc.zzHK();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < zzfVar.zziL.length; i2++) {
            arrayList.add(zza(zzfVar.zziL[i2], zzfVar, zzaVarArr, i2));
        }
        ArrayList arrayList2 = new ArrayList();
        for (int i3 = 0; i3 < zzfVar.zziM.length; i3++) {
            arrayList2.add(zza(zzfVar.zziM[i3], zzfVar, zzaVarArr, i3));
        }
        ArrayList arrayList3 = new ArrayList();
        for (int i4 = 0; i4 < zzfVar.zziK.length; i4++) {
            zza zzaVarZza = zza(zzfVar.zziK[i4], zzfVar, zzaVarArr, i4);
            zzdVarZzHK.zzc(zzaVarZza);
            arrayList3.add(zzaVarZza);
        }
        for (zzaf.zzg zzgVar : zzfVar.zziN) {
            zzdVarZzHK.zzb(zza(zzgVar, arrayList, arrayList3, arrayList2, zzfVar));
        }
        zzdVarZzHK.zzgD(zzfVar.version);
        zzdVarZzHK.zzko(zzfVar.zziV);
        return zzdVarZzHK.zzHN();
    }

    public static void zzb(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[1024];
        while (true) {
            int i = inputStream.read(bArr);
            if (i == -1) {
                return;
            } else {
                outputStream.write(bArr, 0, i);
            }
        }
    }

    private static void zzgC(String str) throws zzg {
        com.google.android.gms.tagmanager.zzbg.e(str);
        throw new zzg(str);
    }

    public static zzag.zza zzo(zzag.zza zzaVar) {
        zzag.zza zzaVar2 = new zzag.zza();
        zzaVar2.type = zzaVar.type;
        zzaVar2.zzjG = (int[]) zzaVar.zzjG.clone();
        if (zzaVar.zzjH) {
            zzaVar2.zzjH = zzaVar.zzjH;
        }
        return zzaVar2;
    }

    private static zzaf.zzh zzp(zzag.zza zzaVar) throws zzg {
        if (((zzaf.zzh) zzaVar.zza(zzaf.zzh.zzjh)) == null) {
            zzgC("Expected a ServingValue and didn't get one. Value is: " + zzaVar);
        }
        return (zzaf.zzh) zzaVar.zza(zzaf.zzh.zzjh);
    }
}
