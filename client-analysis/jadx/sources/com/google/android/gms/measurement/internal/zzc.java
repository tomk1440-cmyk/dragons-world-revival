package com.google.android.gms.measurement.internal;

import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.google.android.gms.internal.zzpz;
import com.google.android.gms.internal.zzqb;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
class zzc extends zzz {
    zzc(zzw zzwVar) {
        super(zzwVar);
    }

    private Boolean zza(zzpz.zzb zzbVar, zzqb.zzb zzbVar2, long j) {
        if (zzbVar.zzaZz != null) {
            Boolean boolZzac = new zzs(zzbVar.zzaZz).zzac(j);
            if (boolZzac == null) {
                return null;
            }
            if (!boolZzac.booleanValue()) {
                return false;
            }
        }
        HashSet hashSet = new HashSet();
        for (zzpz.zzc zzcVar : zzbVar.zzaZx) {
            if (TextUtils.isEmpty(zzcVar.zzaZE)) {
                zzAo().zzCF().zzj("null or empty param name in filter. event", zzbVar2.name);
                return null;
            }
            hashSet.add(zzcVar.zzaZE);
        }
        ArrayMap arrayMap = new ArrayMap();
        for (zzqb.zzc zzcVar2 : zzbVar2.zzbae) {
            if (hashSet.contains(zzcVar2.name)) {
                if (zzcVar2.zzbai != null) {
                    arrayMap.put(zzcVar2.name, zzcVar2.zzbai);
                } else if (zzcVar2.zzaZo != null) {
                    arrayMap.put(zzcVar2.name, zzcVar2.zzaZo);
                } else {
                    if (zzcVar2.zzamJ == null) {
                        zzAo().zzCF().zze("Unknown value for param. event, param", zzbVar2.name, zzcVar2.name);
                        return null;
                    }
                    arrayMap.put(zzcVar2.name, zzcVar2.zzamJ);
                }
            }
        }
        for (zzpz.zzc zzcVar3 : zzbVar.zzaZx) {
            String str = zzcVar3.zzaZE;
            if (TextUtils.isEmpty(str)) {
                zzAo().zzCF().zzj("Event has empty param name. event", zzbVar2.name);
                return null;
            }
            Object obj = arrayMap.get(str);
            if (obj instanceof Long) {
                if (zzcVar3.zzaZC == null) {
                    zzAo().zzCF().zze("No number filter for long param. event, param", zzbVar2.name, str);
                    return null;
                }
                Boolean boolZzac2 = new zzs(zzcVar3.zzaZC).zzac(((Long) obj).longValue());
                if (boolZzac2 == null) {
                    return null;
                }
                if (!boolZzac2.booleanValue()) {
                    return false;
                }
            } else if (obj instanceof Float) {
                if (zzcVar3.zzaZC == null) {
                    zzAo().zzCF().zze("No number filter for float param. event, param", zzbVar2.name, str);
                    return null;
                }
                Boolean boolZzi = new zzs(zzcVar3.zzaZC).zzi(((Float) obj).floatValue());
                if (boolZzi == null) {
                    return null;
                }
                if (!boolZzi.booleanValue()) {
                    return false;
                }
            } else {
                if (!(obj instanceof String)) {
                    if (obj == null) {
                        zzAo().zzCK().zze("Missing param for filter. event, param", zzbVar2.name, str);
                        return false;
                    }
                    zzAo().zzCF().zze("Unknown param type. event, param", zzbVar2.name, str);
                    return null;
                }
                if (zzcVar3.zzaZB == null) {
                    zzAo().zzCF().zze("No string filter for String param. event, param", zzbVar2.name, str);
                    return null;
                }
                Boolean boolZzfp = new zzae(zzcVar3.zzaZB).zzfp((String) obj);
                if (boolZzfp == null) {
                    return null;
                }
                if (!boolZzfp.booleanValue()) {
                    return false;
                }
            }
        }
        return true;
    }

    private Boolean zza(zzpz.zze zzeVar, zzqb.zzg zzgVar) {
        Boolean boolZzi = null;
        zzpz.zzc zzcVar = zzeVar.zzaZM;
        if (zzcVar == null) {
            zzAo().zzCF().zzj("Missing property filter. property", zzgVar.name);
            return null;
        }
        if (zzgVar.zzbai != null) {
            if (zzcVar.zzaZC != null) {
                return new zzs(zzcVar.zzaZC).zzac(zzgVar.zzbai.longValue());
            }
            zzAo().zzCF().zzj("No number filter for long property. property", zzgVar.name);
            return null;
        }
        if (zzgVar.zzaZo != null) {
            if (zzcVar.zzaZC != null) {
                return new zzs(zzcVar.zzaZC).zzi(zzgVar.zzaZo.floatValue());
            }
            zzAo().zzCF().zzj("No number filter for float property. property", zzgVar.name);
            return null;
        }
        if (zzgVar.zzamJ == null) {
            zzAo().zzCF().zzj("User property has no value, property", zzgVar.name);
            return null;
        }
        if (zzcVar.zzaZB != null) {
            return new zzae(zzcVar.zzaZB).zzfp(zzgVar.zzamJ);
        }
        if (zzcVar.zzaZC == null) {
            zzAo().zzCF().zzj("No string or number filter defined. property", zzgVar.name);
            return null;
        }
        zzs zzsVar = new zzs(zzcVar.zzaZC);
        if (!zzcVar.zzaZC.zzaZG.booleanValue()) {
            if (!zzeQ(zzgVar.zzamJ)) {
                zzAo().zzCF().zze("Invalid user property value for Long number filter. property, value", zzgVar.name, zzgVar.zzamJ);
                return null;
            }
            try {
                return zzsVar.zzac(Long.parseLong(zzgVar.zzamJ));
            } catch (NumberFormatException e) {
                zzAo().zzCF().zze("User property value exceeded Long value range. property, value", zzgVar.name, zzgVar.zzamJ);
                return null;
            }
        }
        if (!zzeR(zzgVar.zzamJ)) {
            zzAo().zzCF().zze("Invalid user property value for Float number filter. property, value", zzgVar.name, zzgVar.zzamJ);
            return null;
        }
        try {
            float f = Float.parseFloat(zzgVar.zzamJ);
            if (Float.isInfinite(f)) {
                zzAo().zzCF().zze("User property value exceeded Float value range. property, value", zzgVar.name, zzgVar.zzamJ);
            } else {
                boolZzi = zzsVar.zzi(f);
            }
            return boolZzi;
        } catch (NumberFormatException e2) {
            zzAo().zzCF().zze("User property value exceeded Float value range. property, value", zzgVar.name, zzgVar.zzamJ);
            return boolZzi;
        }
    }

    void zza(String str, zzpz.zza[] zzaVarArr) {
        zzCj().zzb(str, zzaVarArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    zzqb.zza[] zza(String str, zzqb.zzb[] zzbVarArr, zzqb.zzg[] zzgVarArr) {
        Map<Integer, List<zzpz.zze>> map;
        zzqb.zza zzaVar;
        zzi zziVarZzCB;
        Map<Integer, List<zzpz.zzb>> map2;
        zzqb.zza zzaVar2;
        com.google.android.gms.common.internal.zzx.zzcM(str);
        HashSet hashSet = new HashSet();
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        ArrayMap arrayMap3 = new ArrayMap();
        if (zzbVarArr != null) {
            ArrayMap arrayMap4 = new ArrayMap();
            int length = zzbVarArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                zzqb.zzb zzbVar = zzbVarArr[i2];
                zzi zziVarZzI = zzCj().zzI(str, zzbVar.name);
                if (zziVarZzI == null) {
                    zzAo().zzCF().zzj("Event aggregate wasn't created during raw event logging. event", zzbVar.name);
                    zziVarZzCB = new zzi(str, zzbVar.name, 1L, 1L, zzbVar.zzbaf.longValue());
                } else {
                    zziVarZzCB = zziVarZzI.zzCB();
                }
                zzCj().zza(zziVarZzCB);
                long j = zziVarZzCB.zzaVP;
                Map<Integer, List<zzpz.zzb>> map3 = (Map) arrayMap4.get(zzbVar.name);
                if (map3 == null) {
                    Map<Integer, List<zzpz.zzb>> mapZzL = zzCj().zzL(str, zzbVar.name);
                    if (mapZzL == null) {
                        mapZzL = new ArrayMap<>();
                    }
                    arrayMap4.put(zzbVar.name, mapZzL);
                    map2 = mapZzL;
                } else {
                    map2 = map3;
                }
                zzAo().zzCK().zze("Found audiences. event, audience count", zzbVar.name, Integer.valueOf(map2.size()));
                Iterator<Integer> it = map2.keySet().iterator();
                while (it.hasNext()) {
                    int iIntValue = it.next().intValue();
                    if (hashSet.contains(Integer.valueOf(iIntValue))) {
                        zzAo().zzCK().zzj("Skipping failed audience ID", Integer.valueOf(iIntValue));
                    } else {
                        zzqb.zza zzaVar3 = (zzqb.zza) arrayMap.get(Integer.valueOf(iIntValue));
                        if (zzaVar3 == null) {
                            zzqb.zza zzaVar4 = new zzqb.zza();
                            arrayMap.put(Integer.valueOf(iIntValue), zzaVar4);
                            zzaVar4.zzbac = false;
                            zzaVar2 = zzaVar4;
                        } else {
                            zzaVar2 = zzaVar3;
                        }
                        List<zzpz.zzb> list = map2.get(Integer.valueOf(iIntValue));
                        BitSet bitSet = (BitSet) arrayMap2.get(Integer.valueOf(iIntValue));
                        BitSet bitSet2 = (BitSet) arrayMap3.get(Integer.valueOf(iIntValue));
                        if (bitSet == null) {
                            bitSet = new BitSet();
                            arrayMap2.put(Integer.valueOf(iIntValue), bitSet);
                            bitSet2 = new BitSet();
                            arrayMap3.put(Integer.valueOf(iIntValue), bitSet2);
                        }
                        if (zzaVar2.zzbab == null && !zzaVar2.zzbac.booleanValue()) {
                            zzqb.zzf zzfVarZzC = zzCj().zzC(str, iIntValue);
                            if (zzfVarZzC == null) {
                                zzaVar2.zzbac = true;
                            } else {
                                zzaVar2.zzbab = zzfVarZzC;
                                for (int i3 = 0; i3 < zzfVarZzC.zzbaH.length * 64; i3++) {
                                    if (zzaj.zza(zzfVarZzC.zzbaH, i3)) {
                                        zzAo().zzCK().zze("Event filter already evaluated true. audience ID, filter ID", Integer.valueOf(iIntValue), Integer.valueOf(i3));
                                        bitSet.set(i3);
                                        bitSet2.set(i3);
                                    }
                                }
                            }
                        }
                        for (zzpz.zzb zzbVar2 : list) {
                            if (zzAo().zzQ(2)) {
                                zzAo().zzCK().zzd("Evaluating filter. audience, filter, event", Integer.valueOf(iIntValue), zzbVar2.zzaZv, zzbVar2.zzaZw);
                                zzAo().zzCK().zzj("Filter definition", zzbVar2);
                            }
                            if (zzbVar2.zzaZv.intValue() > 256) {
                                zzAo().zzCF().zzj("Invalid event filter ID > 256. id", zzbVar2.zzaZv);
                            } else if (!bitSet2.get(zzbVar2.zzaZv.intValue())) {
                                Boolean boolZza = zza(zzbVar2, zzbVar, j);
                                zzAo().zzCK().zzj("Event filter result", boolZza);
                                if (boolZza == null) {
                                    hashSet.add(Integer.valueOf(iIntValue));
                                } else {
                                    bitSet2.set(zzbVar2.zzaZv.intValue());
                                    if (boolZza.booleanValue()) {
                                        bitSet.set(zzbVar2.zzaZv.intValue());
                                    }
                                }
                            }
                        }
                    }
                }
                i = i2 + 1;
            }
        }
        if (zzgVarArr != null) {
            ArrayMap arrayMap5 = new ArrayMap();
            for (zzqb.zzg zzgVar : zzgVarArr) {
                Map<Integer, List<zzpz.zze>> map4 = (Map) arrayMap5.get(zzgVar.name);
                if (map4 == null) {
                    Map<Integer, List<zzpz.zze>> mapZzM = zzCj().zzM(str, zzgVar.name);
                    if (mapZzM == null) {
                        mapZzM = new ArrayMap<>();
                    }
                    arrayMap5.put(zzgVar.name, mapZzM);
                    map = mapZzM;
                } else {
                    map = map4;
                }
                zzAo().zzCK().zze("Found audiences. property, audience count", zzgVar.name, Integer.valueOf(map.size()));
                Iterator<Integer> it2 = map.keySet().iterator();
                while (it2.hasNext()) {
                    int iIntValue2 = it2.next().intValue();
                    if (hashSet.contains(Integer.valueOf(iIntValue2))) {
                        zzAo().zzCK().zzj("Skipping failed audience ID", Integer.valueOf(iIntValue2));
                    } else {
                        zzqb.zza zzaVar5 = (zzqb.zza) arrayMap.get(Integer.valueOf(iIntValue2));
                        if (zzaVar5 == null) {
                            zzqb.zza zzaVar6 = new zzqb.zza();
                            arrayMap.put(Integer.valueOf(iIntValue2), zzaVar6);
                            zzaVar6.zzbac = false;
                            zzaVar = zzaVar6;
                        } else {
                            zzaVar = zzaVar5;
                        }
                        List<zzpz.zze> list2 = map.get(Integer.valueOf(iIntValue2));
                        BitSet bitSet3 = (BitSet) arrayMap2.get(Integer.valueOf(iIntValue2));
                        BitSet bitSet4 = (BitSet) arrayMap3.get(Integer.valueOf(iIntValue2));
                        if (bitSet3 == null) {
                            bitSet3 = new BitSet();
                            arrayMap2.put(Integer.valueOf(iIntValue2), bitSet3);
                            bitSet4 = new BitSet();
                            arrayMap3.put(Integer.valueOf(iIntValue2), bitSet4);
                        }
                        if (zzaVar.zzbab == null && !zzaVar.zzbac.booleanValue()) {
                            zzqb.zzf zzfVarZzC2 = zzCj().zzC(str, iIntValue2);
                            if (zzfVarZzC2 == null) {
                                zzaVar.zzbac = true;
                            } else {
                                zzaVar.zzbab = zzfVarZzC2;
                                for (int i4 = 0; i4 < zzfVarZzC2.zzbaH.length * 64; i4++) {
                                    if (zzaj.zza(zzfVarZzC2.zzbaH, i4)) {
                                        bitSet3.set(i4);
                                        bitSet4.set(i4);
                                    }
                                }
                            }
                        }
                        for (zzpz.zze zzeVar : list2) {
                            if (zzAo().zzQ(2)) {
                                zzAo().zzCK().zzd("Evaluating filter. audience, filter, property", Integer.valueOf(iIntValue2), zzeVar.zzaZv, zzeVar.zzaZL);
                                zzAo().zzCK().zzj("Filter definition", zzeVar);
                            }
                            if (zzeVar.zzaZv == null || zzeVar.zzaZv.intValue() > 256) {
                                zzAo().zzCF().zzj("Invalid property filter ID. id", String.valueOf(zzeVar.zzaZv));
                                hashSet.add(Integer.valueOf(iIntValue2));
                                break;
                            }
                            if (bitSet4.get(zzeVar.zzaZv.intValue())) {
                                zzAo().zzCK().zze("Property filter already evaluated true. audience ID, filter ID", Integer.valueOf(iIntValue2), zzeVar.zzaZv);
                            } else {
                                Boolean boolZza2 = zza(zzeVar, zzgVar);
                                zzAo().zzCK().zzj("Property filter result", boolZza2);
                                if (boolZza2 == null) {
                                    hashSet.add(Integer.valueOf(iIntValue2));
                                } else {
                                    bitSet4.set(zzeVar.zzaZv.intValue());
                                    if (boolZza2.booleanValue()) {
                                        bitSet3.set(zzeVar.zzaZv.intValue());
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        zzqb.zza[] zzaVarArr = new zzqb.zza[arrayMap2.size()];
        Iterator it3 = arrayMap2.keySet().iterator();
        int i5 = 0;
        while (it3.hasNext()) {
            int iIntValue3 = ((Integer) it3.next()).intValue();
            if (!hashSet.contains(Integer.valueOf(iIntValue3))) {
                zzqb.zza zzaVar7 = (zzqb.zza) arrayMap.get(Integer.valueOf(iIntValue3));
                if (zzaVar7 == null) {
                    zzaVar7 = new zzqb.zza();
                }
                zzqb.zza zzaVar8 = zzaVar7;
                zzaVarArr[i5] = zzaVar8;
                zzaVar8.zzaZr = Integer.valueOf(iIntValue3);
                zzaVar8.zzbaa = new zzqb.zzf();
                zzaVar8.zzbaa.zzbaH = zzaj.zza((BitSet) arrayMap2.get(Integer.valueOf(iIntValue3)));
                zzaVar8.zzbaa.zzbaG = zzaj.zza((BitSet) arrayMap3.get(Integer.valueOf(iIntValue3)));
                zzCj().zza(str, iIntValue3, zzaVar8.zzbaa);
                i5++;
            }
        }
        return (zzqb.zza[]) Arrays.copyOf(zzaVarArr, i5);
    }

    boolean zzeQ(String str) {
        return Pattern.matches("[+-]?[0-9]+", str);
    }

    boolean zzeR(String str) {
        return Pattern.matches("[+-]?(([0-9]+\\.?)|([0-9]*\\.[0-9]+))", str);
    }

    @Override // com.google.android.gms.measurement.internal.zzz
    protected void zziJ() {
    }
}
