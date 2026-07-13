package com.google.android.gms.tagmanager;

import android.content.Context;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.internal.zzrs;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
class zzcp {
    private static final zzbw<com.google.android.gms.internal.zzag.zza> zzbkq = new zzbw<>(zzdf.zzHF(), true);
    private final DataLayer zzbhN;
    private volatile String zzbkA;
    private int zzbkB;
    private final zzrs.zzc zzbkr;
    private final zzah zzbks;
    private final Map<String, zzak> zzbkt;
    private final Map<String, zzak> zzbku;
    private final Map<String, zzak> zzbkv;
    private final zzl<zzrs.zza, zzbw<com.google.android.gms.internal.zzag.zza>> zzbkw;
    private final zzl<String, zzb> zzbkx;
    private final Set<zzrs.zze> zzbky;
    private final Map<String, zzc> zzbkz;

    interface zza {
        void zza(zzrs.zze zzeVar, Set<zzrs.zza> set, Set<zzrs.zza> set2, zzck zzckVar);
    }

    private static class zzb {
        private zzbw<com.google.android.gms.internal.zzag.zza> zzbkH;
        private com.google.android.gms.internal.zzag.zza zzbkI;

        public zzb(zzbw<com.google.android.gms.internal.zzag.zza> zzbwVar, com.google.android.gms.internal.zzag.zza zzaVar) {
            this.zzbkH = zzbwVar;
            this.zzbkI = zzaVar;
        }

        public int getSize() {
            return (this.zzbkI == null ? 0 : this.zzbkI.getCachedSize()) + this.zzbkH.getObject().getCachedSize();
        }

        public zzbw<com.google.android.gms.internal.zzag.zza> zzHg() {
            return this.zzbkH;
        }

        public com.google.android.gms.internal.zzag.zza zzHh() {
            return this.zzbkI;
        }
    }

    private static class zzc {
        private zzrs.zza zzbkN;
        private final Set<zzrs.zze> zzbky = new HashSet();
        private final Map<zzrs.zze, List<zzrs.zza>> zzbkJ = new HashMap();
        private final Map<zzrs.zze, List<String>> zzbkL = new HashMap();
        private final Map<zzrs.zze, List<zzrs.zza>> zzbkK = new HashMap();
        private final Map<zzrs.zze, List<String>> zzbkM = new HashMap();

        public Set<zzrs.zze> zzHi() {
            return this.zzbky;
        }

        public Map<zzrs.zze, List<zzrs.zza>> zzHj() {
            return this.zzbkJ;
        }

        public Map<zzrs.zze, List<String>> zzHk() {
            return this.zzbkL;
        }

        public Map<zzrs.zze, List<String>> zzHl() {
            return this.zzbkM;
        }

        public Map<zzrs.zze, List<zzrs.zza>> zzHm() {
            return this.zzbkK;
        }

        public zzrs.zza zzHn() {
            return this.zzbkN;
        }

        public void zza(zzrs.zze zzeVar) {
            this.zzbky.add(zzeVar);
        }

        public void zza(zzrs.zze zzeVar, zzrs.zza zzaVar) {
            List<zzrs.zza> arrayList = this.zzbkJ.get(zzeVar);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.zzbkJ.put(zzeVar, arrayList);
            }
            arrayList.add(zzaVar);
        }

        public void zza(zzrs.zze zzeVar, String str) {
            List<String> arrayList = this.zzbkL.get(zzeVar);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.zzbkL.put(zzeVar, arrayList);
            }
            arrayList.add(str);
        }

        public void zzb(zzrs.zza zzaVar) {
            this.zzbkN = zzaVar;
        }

        public void zzb(zzrs.zze zzeVar, zzrs.zza zzaVar) {
            List<zzrs.zza> arrayList = this.zzbkK.get(zzeVar);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.zzbkK.put(zzeVar, arrayList);
            }
            arrayList.add(zzaVar);
        }

        public void zzb(zzrs.zze zzeVar, String str) {
            List<String> arrayList = this.zzbkM.get(zzeVar);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.zzbkM.put(zzeVar, arrayList);
            }
            arrayList.add(str);
        }
    }

    public zzcp(Context context, zzrs.zzc zzcVar, DataLayer dataLayer, zzt.zza zzaVar, zzt.zza zzaVar2, zzah zzahVar) {
        if (zzcVar == null) {
            throw new NullPointerException("resource cannot be null");
        }
        this.zzbkr = zzcVar;
        this.zzbky = new HashSet(zzcVar.zzHL());
        this.zzbhN = dataLayer;
        this.zzbks = zzahVar;
        this.zzbkw = new zzm().zza(1048576, new zzm.zza<zzrs.zza, zzbw<com.google.android.gms.internal.zzag.zza>>() { // from class: com.google.android.gms.tagmanager.zzcp.1
            @Override // com.google.android.gms.tagmanager.zzm.zza
            /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
            public int sizeOf(zzrs.zza zzaVar3, zzbw<com.google.android.gms.internal.zzag.zza> zzbwVar) {
                return zzbwVar.getObject().getCachedSize();
            }
        });
        this.zzbkx = new zzm().zza(1048576, new zzm.zza<String, zzb>() { // from class: com.google.android.gms.tagmanager.zzcp.2
            @Override // com.google.android.gms.tagmanager.zzm.zza
            /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
            public int sizeOf(String str, zzb zzbVar) {
                return str.length() + zzbVar.getSize();
            }
        });
        this.zzbkt = new HashMap();
        zzb(new zzj(context));
        zzb(new zzt(zzaVar2));
        zzb(new zzx(dataLayer));
        zzb(new zzdg(context, dataLayer));
        zzb(new zzdb(context, dataLayer));
        this.zzbku = new HashMap();
        zzc(new zzr());
        zzc(new zzae());
        zzc(new zzaf());
        zzc(new zzam());
        zzc(new zzan());
        zzc(new zzbc());
        zzc(new zzbd());
        zzc(new zzcf());
        zzc(new zzcy());
        this.zzbkv = new HashMap();
        zza(new com.google.android.gms.tagmanager.zzb(context));
        zza(new com.google.android.gms.tagmanager.zzc(context));
        zza(new zze(context));
        zza(new zzf(context));
        zza(new zzg(context));
        zza(new zzh(context));
        zza(new zzi(context));
        zza(new zzn());
        zza(new zzq(this.zzbkr.getVersion()));
        zza(new zzt(zzaVar));
        zza(new zzv(dataLayer));
        zza(new zzaa(context));
        zza(new zzab());
        zza(new zzad());
        zza(new zzai(this));
        zza(new zzao());
        zza(new zzap());
        zza(new zzaw(context));
        zza(new zzay());
        zza(new zzbb());
        zza(new zzbi());
        zza(new zzbk(context));
        zza(new zzbx());
        zza(new zzbz());
        zza(new zzcc());
        zza(new zzce());
        zza(new zzcg(context));
        zza(new zzcq());
        zza(new zzcr());
        zza(new zzda());
        zza(new zzdh());
        this.zzbkz = new HashMap();
        for (zzrs.zze zzeVar : this.zzbky) {
            if (zzahVar.zzGA()) {
                zza(zzeVar.zzHT(), zzeVar.zzHU(), "add macro");
                zza(zzeVar.zzHY(), zzeVar.zzHV(), "remove macro");
                zza(zzeVar.zzHR(), zzeVar.zzHW(), "add tag");
                zza(zzeVar.zzHS(), zzeVar.zzHX(), "remove tag");
            }
            for (int i = 0; i < zzeVar.zzHT().size(); i++) {
                zzrs.zza zzaVar3 = zzeVar.zzHT().get(i);
                String str = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
                if (zzahVar.zzGA() && i < zzeVar.zzHU().size()) {
                    str = zzeVar.zzHU().get(i);
                }
                zzc zzcVarZzi = zzi(this.zzbkz, zza(zzaVar3));
                zzcVarZzi.zza(zzeVar);
                zzcVarZzi.zza(zzeVar, zzaVar3);
                zzcVarZzi.zza(zzeVar, str);
            }
            for (int i2 = 0; i2 < zzeVar.zzHY().size(); i2++) {
                zzrs.zza zzaVar4 = zzeVar.zzHY().get(i2);
                String str2 = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
                if (zzahVar.zzGA() && i2 < zzeVar.zzHV().size()) {
                    str2 = zzeVar.zzHV().get(i2);
                }
                zzc zzcVarZzi2 = zzi(this.zzbkz, zza(zzaVar4));
                zzcVarZzi2.zza(zzeVar);
                zzcVarZzi2.zzb(zzeVar, zzaVar4);
                zzcVarZzi2.zzb(zzeVar, str2);
            }
        }
        for (Map.Entry<String, List<zzrs.zza>> entry : this.zzbkr.zzHM().entrySet()) {
            for (zzrs.zza zzaVar5 : entry.getValue()) {
                if (!zzdf.zzk(zzaVar5.zzHI().get(com.google.android.gms.internal.zzae.NOT_DEFAULT_MACRO.toString())).booleanValue()) {
                    zzi(this.zzbkz, entry.getKey()).zzb(zzaVar5);
                }
            }
        }
    }

    private String zzHf() {
        if (this.zzbkB <= 1) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toString(this.zzbkB));
        for (int i = 2; i < this.zzbkB; i++) {
            sb.append(' ');
        }
        sb.append(": ");
        return sb.toString();
    }

    private zzbw<com.google.android.gms.internal.zzag.zza> zza(com.google.android.gms.internal.zzag.zza zzaVar, Set<String> set, zzdi zzdiVar) {
        if (!zzaVar.zzjH) {
            return new zzbw<>(zzaVar, true);
        }
        switch (zzaVar.type) {
            case 2:
                com.google.android.gms.internal.zzag.zza zzaVarZzo = zzrs.zzo(zzaVar);
                zzaVarZzo.zzjy = new com.google.android.gms.internal.zzag.zza[zzaVar.zzjy.length];
                for (int i = 0; i < zzaVar.zzjy.length; i++) {
                    zzbw<com.google.android.gms.internal.zzag.zza> zzbwVarZza = zza(zzaVar.zzjy[i], set, zzdiVar.zzkh(i));
                    if (zzbwVarZza == zzbkq) {
                        return zzbkq;
                    }
                    zzaVarZzo.zzjy[i] = zzbwVarZza.getObject();
                }
                return new zzbw<>(zzaVarZzo, false);
            case 3:
                com.google.android.gms.internal.zzag.zza zzaVarZzo2 = zzrs.zzo(zzaVar);
                if (zzaVar.zzjz.length != zzaVar.zzjA.length) {
                    zzbg.e("Invalid serving value: " + zzaVar.toString());
                    return zzbkq;
                }
                zzaVarZzo2.zzjz = new com.google.android.gms.internal.zzag.zza[zzaVar.zzjz.length];
                zzaVarZzo2.zzjA = new com.google.android.gms.internal.zzag.zza[zzaVar.zzjz.length];
                for (int i2 = 0; i2 < zzaVar.zzjz.length; i2++) {
                    zzbw<com.google.android.gms.internal.zzag.zza> zzbwVarZza2 = zza(zzaVar.zzjz[i2], set, zzdiVar.zzki(i2));
                    zzbw<com.google.android.gms.internal.zzag.zza> zzbwVarZza3 = zza(zzaVar.zzjA[i2], set, zzdiVar.zzkj(i2));
                    if (zzbwVarZza2 == zzbkq || zzbwVarZza3 == zzbkq) {
                        return zzbkq;
                    }
                    zzaVarZzo2.zzjz[i2] = zzbwVarZza2.getObject();
                    zzaVarZzo2.zzjA[i2] = zzbwVarZza3.getObject();
                }
                return new zzbw<>(zzaVarZzo2, false);
            case 4:
                if (set.contains(zzaVar.zzjB)) {
                    zzbg.e("Macro cycle detected.  Current macro reference: " + zzaVar.zzjB + ".  Previous macro references: " + set.toString() + ".");
                    return zzbkq;
                }
                set.add(zzaVar.zzjB);
                zzbw<com.google.android.gms.internal.zzag.zza> zzbwVarZza4 = zzdj.zza(zza(zzaVar.zzjB, set, zzdiVar.zzGO()), zzaVar.zzjG);
                set.remove(zzaVar.zzjB);
                return zzbwVarZza4;
            case 5:
            case 6:
            default:
                zzbg.e("Unknown type: " + zzaVar.type);
                return zzbkq;
            case 7:
                com.google.android.gms.internal.zzag.zza zzaVarZzo3 = zzrs.zzo(zzaVar);
                zzaVarZzo3.zzjF = new com.google.android.gms.internal.zzag.zza[zzaVar.zzjF.length];
                for (int i3 = 0; i3 < zzaVar.zzjF.length; i3++) {
                    zzbw<com.google.android.gms.internal.zzag.zza> zzbwVarZza5 = zza(zzaVar.zzjF[i3], set, zzdiVar.zzkk(i3));
                    if (zzbwVarZza5 == zzbkq) {
                        return zzbkq;
                    }
                    zzaVarZzo3.zzjF[i3] = zzbwVarZza5.getObject();
                }
                return new zzbw<>(zzaVarZzo3, false);
        }
    }

    private zzbw<com.google.android.gms.internal.zzag.zza> zza(String str, Set<String> set, zzbj zzbjVar) {
        zzrs.zza next;
        this.zzbkB++;
        zzb zzbVar = this.zzbkx.get(str);
        if (zzbVar != null && !this.zzbks.zzGA()) {
            zza(zzbVar.zzHh(), set);
            this.zzbkB--;
            return zzbVar.zzHg();
        }
        zzc zzcVar = this.zzbkz.get(str);
        if (zzcVar == null) {
            zzbg.e(zzHf() + "Invalid macro: " + str);
            this.zzbkB--;
            return zzbkq;
        }
        zzbw<Set<zzrs.zza>> zzbwVarZza = zza(str, zzcVar.zzHi(), zzcVar.zzHj(), zzcVar.zzHk(), zzcVar.zzHm(), zzcVar.zzHl(), set, zzbjVar.zzGq());
        if (zzbwVarZza.getObject().isEmpty()) {
            next = zzcVar.zzHn();
        } else {
            if (zzbwVarZza.getObject().size() > 1) {
                zzbg.zzaK(zzHf() + "Multiple macros active for macroName " + str);
            }
            next = zzbwVarZza.getObject().iterator().next();
        }
        if (next == null) {
            this.zzbkB--;
            return zzbkq;
        }
        zzbw<com.google.android.gms.internal.zzag.zza> zzbwVarZza2 = zza(this.zzbkv, next, set, zzbjVar.zzGG());
        zzbw<com.google.android.gms.internal.zzag.zza> zzbwVar = zzbwVarZza2 == zzbkq ? zzbkq : new zzbw<>(zzbwVarZza2.getObject(), zzbwVarZza.zzGP() && zzbwVarZza2.zzGP());
        com.google.android.gms.internal.zzag.zza zzaVarZzHh = next.zzHh();
        if (zzbwVar.zzGP()) {
            this.zzbkx.zzh(str, new zzb(zzbwVar, zzaVarZzHh));
        }
        zza(zzaVarZzHh, set);
        this.zzbkB--;
        return zzbwVar;
    }

    private zzbw<com.google.android.gms.internal.zzag.zza> zza(Map<String, zzak> map, zzrs.zza zzaVar, Set<String> set, zzch zzchVar) {
        boolean z;
        com.google.android.gms.internal.zzag.zza zzaVar2 = zzaVar.zzHI().get(com.google.android.gms.internal.zzae.FUNCTION.toString());
        if (zzaVar2 == null) {
            zzbg.e("No function id in properties");
            return zzbkq;
        }
        String str = zzaVar2.zzjC;
        zzak zzakVar = map.get(str);
        if (zzakVar == null) {
            zzbg.e(str + " has no backing implementation.");
            return zzbkq;
        }
        zzbw<com.google.android.gms.internal.zzag.zza> zzbwVar = this.zzbkw.get(zzaVar);
        if (zzbwVar != null && !this.zzbks.zzGA()) {
            return zzbwVar;
        }
        HashMap map2 = new HashMap();
        boolean z2 = true;
        for (Map.Entry<String, com.google.android.gms.internal.zzag.zza> entry : zzaVar.zzHI().entrySet()) {
            zzbw<com.google.android.gms.internal.zzag.zza> zzbwVarZza = zza(entry.getValue(), set, zzchVar.zzgj(entry.getKey()).zze(entry.getValue()));
            if (zzbwVarZza == zzbkq) {
                return zzbkq;
            }
            if (zzbwVarZza.zzGP()) {
                zzaVar.zza(entry.getKey(), zzbwVarZza.getObject());
                z = z2;
            } else {
                z = false;
            }
            map2.put(entry.getKey(), zzbwVarZza.getObject());
            z2 = z;
        }
        if (!zzakVar.zze(map2.keySet())) {
            zzbg.e("Incorrect keys for function " + str + " required " + zzakVar.zzGC() + " had " + map2.keySet());
            return zzbkq;
        }
        boolean z3 = z2 && zzakVar.zzFW();
        zzbw<com.google.android.gms.internal.zzag.zza> zzbwVar2 = new zzbw<>(zzakVar.zzP(map2), z3);
        if (z3) {
            this.zzbkw.zzh(zzaVar, zzbwVar2);
        }
        zzchVar.zzd(zzbwVar2.getObject());
        return zzbwVar2;
    }

    private zzbw<Set<zzrs.zza>> zza(Set<zzrs.zze> set, Set<String> set2, zza zzaVar, zzco zzcoVar) {
        Set<zzrs.zza> hashSet = new HashSet<>();
        Set<zzrs.zza> hashSet2 = new HashSet<>();
        boolean z = true;
        for (zzrs.zze zzeVar : set) {
            zzck zzckVarZzGN = zzcoVar.zzGN();
            zzbw<Boolean> zzbwVarZza = zza(zzeVar, set2, zzckVarZzGN);
            if (zzbwVarZza.getObject().booleanValue()) {
                zzaVar.zza(zzeVar, hashSet, hashSet2, zzckVarZzGN);
            }
            z = z && zzbwVarZza.zzGP();
        }
        hashSet.removeAll(hashSet2);
        zzcoVar.zzf(hashSet);
        return new zzbw<>(hashSet, z);
    }

    private static String zza(zzrs.zza zzaVar) {
        return zzdf.zzg(zzaVar.zzHI().get(com.google.android.gms.internal.zzae.INSTANCE_NAME.toString()));
    }

    private void zza(com.google.android.gms.internal.zzag.zza zzaVar, Set<String> set) {
        zzbw<com.google.android.gms.internal.zzag.zza> zzbwVarZza;
        if (zzaVar == null || (zzbwVarZza = zza(zzaVar, set, new zzbu())) == zzbkq) {
            return;
        }
        Object objZzl = zzdf.zzl(zzbwVarZza.getObject());
        if (objZzl instanceof Map) {
            this.zzbhN.push((Map) objZzl);
            return;
        }
        if (!(objZzl instanceof List)) {
            zzbg.zzaK("pushAfterEvaluate: value not a Map or List");
            return;
        }
        for (Object obj : (List) objZzl) {
            if (obj instanceof Map) {
                this.zzbhN.push((Map) obj);
            } else {
                zzbg.zzaK("pushAfterEvaluate: value not a Map");
            }
        }
    }

    private static void zza(List<zzrs.zza> list, List<String> list2, String str) {
        if (list.size() != list2.size()) {
            zzbg.zzaJ("Invalid resource: imbalance of rule names of functions for " + str + " operation. Using default rule name instead");
        }
    }

    private static void zza(Map<String, zzak> map, zzak zzakVar) {
        if (map.containsKey(zzakVar.zzGB())) {
            throw new IllegalArgumentException("Duplicate function type name: " + zzakVar.zzGB());
        }
        map.put(zzakVar.zzGB(), zzakVar);
    }

    private static zzc zzi(Map<String, zzc> map, String str) {
        zzc zzcVar = map.get(str);
        if (zzcVar != null) {
            return zzcVar;
        }
        zzc zzcVar2 = new zzc();
        map.put(str, zzcVar2);
        return zzcVar2;
    }

    public synchronized void zzF(List<com.google.android.gms.internal.zzaf.zzi> list) {
        for (com.google.android.gms.internal.zzaf.zzi zziVar : list) {
            if (zziVar.name == null || !zziVar.name.startsWith("gaExperiment:")) {
                zzbg.v("Ignored supplemental: " + zziVar);
            } else {
                zzaj.zza(this.zzbhN, zziVar);
            }
        }
    }

    synchronized String zzHe() {
        return this.zzbkA;
    }

    zzbw<Boolean> zza(zzrs.zza zzaVar, Set<String> set, zzch zzchVar) {
        zzbw<com.google.android.gms.internal.zzag.zza> zzbwVarZza = zza(this.zzbku, zzaVar, set, zzchVar);
        Boolean boolZzk = zzdf.zzk(zzbwVarZza.getObject());
        zzchVar.zzd(zzdf.zzR(boolZzk));
        return new zzbw<>(boolZzk, zzbwVarZza.zzGP());
    }

    zzbw<Boolean> zza(zzrs.zze zzeVar, Set<String> set, zzck zzckVar) {
        Iterator<zzrs.zza> it = zzeVar.zzHQ().iterator();
        boolean z = true;
        while (it.hasNext()) {
            zzbw<Boolean> zzbwVarZza = zza(it.next(), set, zzckVar.zzGH());
            if (zzbwVarZza.getObject().booleanValue()) {
                zzckVar.zzf(zzdf.zzR(false));
                return new zzbw<>(false, zzbwVarZza.zzGP());
            }
            z = z && zzbwVarZza.zzGP();
        }
        Iterator<zzrs.zza> it2 = zzeVar.zzHP().iterator();
        while (it2.hasNext()) {
            zzbw<Boolean> zzbwVarZza2 = zza(it2.next(), set, zzckVar.zzGI());
            if (!zzbwVarZza2.getObject().booleanValue()) {
                zzckVar.zzf(zzdf.zzR(false));
                return new zzbw<>(false, zzbwVarZza2.zzGP());
            }
            z = z && zzbwVarZza2.zzGP();
        }
        zzckVar.zzf(zzdf.zzR(true));
        return new zzbw<>(true, z);
    }

    zzbw<Set<zzrs.zza>> zza(String str, Set<zzrs.zze> set, final Map<zzrs.zze, List<zzrs.zza>> map, final Map<zzrs.zze, List<String>> map2, final Map<zzrs.zze, List<zzrs.zza>> map3, final Map<zzrs.zze, List<String>> map4, Set<String> set2, zzco zzcoVar) {
        return zza(set, set2, new zza() { // from class: com.google.android.gms.tagmanager.zzcp.3
            @Override // com.google.android.gms.tagmanager.zzcp.zza
            public void zza(zzrs.zze zzeVar, Set<zzrs.zza> set3, Set<zzrs.zza> set4, zzck zzckVar) {
                List<zzrs.zza> list = (List) map.get(zzeVar);
                List<String> list2 = (List) map2.get(zzeVar);
                if (list != null) {
                    set3.addAll(list);
                    zzckVar.zzGJ().zzc(list, list2);
                }
                List<zzrs.zza> list3 = (List) map3.get(zzeVar);
                List<String> list4 = (List) map4.get(zzeVar);
                if (list3 != null) {
                    set4.addAll(list3);
                    zzckVar.zzGK().zzc(list3, list4);
                }
            }
        }, zzcoVar);
    }

    zzbw<Set<zzrs.zza>> zza(Set<zzrs.zze> set, zzco zzcoVar) {
        return zza(set, new HashSet(), new zza() { // from class: com.google.android.gms.tagmanager.zzcp.4
            @Override // com.google.android.gms.tagmanager.zzcp.zza
            public void zza(zzrs.zze zzeVar, Set<zzrs.zza> set2, Set<zzrs.zza> set3, zzck zzckVar) {
                set2.addAll(zzeVar.zzHR());
                set3.addAll(zzeVar.zzHS());
                zzckVar.zzGL().zzc(zzeVar.zzHR(), zzeVar.zzHW());
                zzckVar.zzGM().zzc(zzeVar.zzHS(), zzeVar.zzHX());
            }
        }, zzcoVar);
    }

    void zza(zzak zzakVar) {
        zza(this.zzbkv, zzakVar);
    }

    void zzb(zzak zzakVar) {
        zza(this.zzbkt, zzakVar);
    }

    void zzc(zzak zzakVar) {
        zza(this.zzbku, zzakVar);
    }

    public synchronized void zzfR(String str) {
        zzgo(str);
        zzag zzagVarZzge = this.zzbks.zzge(str);
        zzu zzuVarZzGy = zzagVarZzge.zzGy();
        Iterator<zzrs.zza> it = zza(this.zzbky, zzuVarZzGy.zzGq()).getObject().iterator();
        while (it.hasNext()) {
            zza(this.zzbkt, it.next(), new HashSet(), zzuVarZzGy.zzGp());
        }
        zzagVarZzge.zzGz();
        zzgo(null);
    }

    public zzbw<com.google.android.gms.internal.zzag.zza> zzgn(String str) {
        this.zzbkB = 0;
        zzag zzagVarZzgd = this.zzbks.zzgd(str);
        zzbw<com.google.android.gms.internal.zzag.zza> zzbwVarZza = zza(str, new HashSet(), zzagVarZzgd.zzGx());
        zzagVarZzgd.zzGz();
        return zzbwVarZza;
    }

    synchronized void zzgo(String str) {
        this.zzbkA = str;
    }
}
