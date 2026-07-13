package com.google.android.gms.internal;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class zznu {
    private static final Map<zzsy.zza, zza> zzazw;
    public static final zzsy.zza zzayA = zza("com.google.step_count.delta", zznt.zzaxz);
    public static final zzsy.zza zzayB = zza("com.google.step_count.cumulative", zznt.zzaxz);
    public static final zzsy.zza zzayC = zza("com.google.step_count.cadence", zznt.zzaxR);
    public static final zzsy.zza zzayD = zza("com.google.activity.segment", zznt.zzaxw);
    public static final zzsy.zza zzayE = zza("com.google.floor_change", zznt.zzaxw, zznt.zzaxx, zznt.zzaxY, zznt.zzayb);
    public static final zzsy.zza zzayF = zza("com.google.calories.consumed", zznt.zzaxT);
    public static final zzsy.zza zzayG = zza("com.google.calories.expended", zznt.zzaxT);
    public static final zzsy.zza zzayH = zza("com.google.calories.bmr", zznt.zzaxT);
    public static final zzsy.zza zzayI = zza("com.google.power.sample", zznt.zzaxU);
    public static final zzsy.zza zzayJ = zza("com.google.activity.sample", zznt.zzaxw, zznt.zzaxx);
    public static final zzsy.zza zzayK = zza("com.google.accelerometer", zznt.zzayq, zznt.zzayr, zznt.zzays);
    public static final zzsy.zza zzayL = zza("com.google.sensor.events", zznt.zzayv, zznt.zzayt, zznt.zzayu);
    public static final zzsy.zza zzayM = zza("com.google.internal.goal", zznt.zzaxK);
    public static final zzsy.zza zzayN = zza("com.google.heart_rate.bpm", zznt.zzaxE);
    public static final zzsy.zza zzayO = zza("com.google.location.sample", zznt.zzaxF, zznt.zzaxG, zznt.zzaxH, zznt.zzaxI);
    public static final zzsy.zza zzayP = zza("com.google.location.track", zznt.zzaxF, zznt.zzaxG, zznt.zzaxH, zznt.zzaxI);
    public static final zzsy.zza zzayQ = zza("com.google.distance.delta", zznt.zzaxJ);
    public static final zzsy.zza zzayR = zza("com.google.distance.cumulative", zznt.zzaxJ);
    public static final zzsy.zza zzayS = zza("com.google.speed", zznt.zzaxQ);
    public static final zzsy.zza zzayT = zza("com.google.cycling.wheel_revolution.cumulative", zznt.zzaxS);
    public static final zzsy.zza zzayU = zza("com.google.cycling.wheel_revolution.rpm", zznt.zzaxR);
    public static final zzsy.zza zzayV = zza("com.google.cycling.pedaling.cumulative", zznt.zzaxS);
    public static final zzsy.zza zzayW = zza("com.google.cycling.pedaling.cadence", zznt.zzaxR);
    public static final zzsy.zza zzayX = zza("com.google.height", zznt.zzaxM);
    public static final zzsy.zza zzayY = zza("com.google.weight", zznt.zzaxN);
    public static final zzsy.zza zzayZ = zza("com.google.body.fat.percentage", zznt.zzaxP);
    public static final zzsy.zza zzaza = zza("com.google.body.waist.circumference", zznt.zzaxO);
    public static final zzsy.zza zzazb = zza("com.google.body.hip.circumference", zznt.zzaxO);
    public static final zzsy.zza zzazc = zza("com.google.nutrition", zznt.zzaxX, zznt.zzaxV, zznt.zzaxW);
    public static final zzsy.zza zzazd = zza("com.google.activity.exercise", zznt.zzaye, zznt.zzayf, zznt.zzaxA, zznt.zzayh, zznt.zzayg);
    public static final Set<String> AGGREGATE_INPUT_TYPES = Collections.unmodifiableSet(new HashSet(Arrays.asList(zzayD.name, zzayF.name, zzayG.name, zzayQ.name, zzayE.name, zzayN.name, zzayO.name, zzazc.name, zzayS.name, zzayA.name, zzayY.name)));
    public static final zzsy.zza zzaze = zza("com.google.activity.summary", zznt.zzaxw, zznt.zzaxA, zznt.zzayi);
    public static final zzsy.zza zzazf = zza("com.google.floor_change.summary", zznt.zzaxC, zznt.zzaxD, zznt.zzaxZ, zznt.zzaya, zznt.zzayc, zznt.zzayd);
    public static final zzsy.zza zzazg = zzayA;
    public static final zzsy.zza zzazh = zzayQ;
    public static final zzsy.zza zzazi = zzayF;
    public static final zzsy.zza zzazj = zzayG;
    public static final zzsy.zza zzazk = zza("com.google.heart_rate.summary", zznt.zzayj, zznt.zzayk, zznt.zzayl);
    public static final zzsy.zza zzazl = zza("com.google.location.bounding_box", zznt.zzaym, zznt.zzayn, zznt.zzayo, zznt.zzayp);
    public static final zzsy.zza zzazm = zza("com.google.power.summary", zznt.zzayj, zznt.zzayk, zznt.zzayl);
    public static final zzsy.zza zzazn = zza("com.google.speed.summary", zznt.zzayj, zznt.zzayk, zznt.zzayl);
    public static final zzsy.zza zzazo = zza("com.google.weight.summary", zznt.zzayj, zznt.zzayk, zznt.zzayl);
    public static final zzsy.zza zzazp = zza("com.google.calories.bmr.summary", zznt.zzayj, zznt.zzayk, zznt.zzayl);
    public static final zzsy.zza zzazq = zza("com.google.body.fat.percentage.summary", zznt.zzayj, zznt.zzayk, zznt.zzayl);
    public static final zzsy.zza zzazr = zza("com.google.body.hip.circumference.summary", zznt.zzayj, zznt.zzayk, zznt.zzayl);
    public static final zzsy.zza zzazs = zza("com.google.body.waist.circumference.summary", zznt.zzayj, zznt.zzayk, zznt.zzayl);
    public static final zzsy.zza zzazt = zza("com.google.nutrition.summary", zznt.zzaxX, zznt.zzaxV);
    public static final zzsy.zza zzazu = zza("com.google.internal.session", zznt.zzayw, zznt.zzaxw, zznt.zzayx, zznt.zzayy, zznt.zzayz);
    private static final Map<String, List<zzsy.zza>> zzawC = zzuF();
    public static final String[] zzazv = {"com.google.accelerometer", "com.google.activity.exercise", "com.google.activity.sample", "com.google.activity.segment", "com.google.activity.summary", "com.google.body.fat.percentage", "com.google.body.fat.percentage.summary", "com.google.body.hip.circumference", "com.google.body.hip.circumference.summary", "com.google.body.waist.circumference", "com.google.body.waist.circumference.summary", "com.google.calories.bmr", "com.google.calories.bmr.summary", "com.google.calories.consumed", "com.google.calories.expended", "com.google.cycling.pedaling.cadence", "com.google.cycling.pedaling.cumulative", "com.google.cycling.wheel_revolution.cumulative", "com.google.cycling.wheel_revolution.rpm", "com.google.distance.cumulative", "com.google.distance.delta", "com.google.floor_change", "com.google.floor_change.summary", "com.google.heart_rate.bpm", "com.google.heart_rate.summary", "com.google.height", "com.google.internal.goal", "com.google.internal.session", "com.google.location.bounding_box", "com.google.location.sample", "com.google.location.track", "com.google.nutrition", "com.google.nutrition.summary", "com.google.power.sample", "com.google.power.summary", "com.google.sensor.events", "com.google.speed", "com.google.speed.summary", "com.google.step_count.cadence", "com.google.step_count.cumulative", "com.google.step_count.delta", "com.google.weight", "com.google.weight.summary"};

    public enum zza {
        CUMULATIVE,
        DELTA,
        SAMPLE,
        OTHER
    }

    static {
        HashSet hashSet = new HashSet();
        hashSet.add(zzayB);
        hashSet.add(zzayR);
        hashSet.add(zzayV);
        HashSet hashSet2 = new HashSet();
        hashSet2.add(zzayQ);
        hashSet2.add(zzayA);
        hashSet2.add(zzayG);
        hashSet2.add(zzayF);
        hashSet2.add(zzayE);
        HashSet hashSet3 = new HashSet();
        hashSet3.add(zzayZ);
        hashSet3.add(zzazb);
        hashSet3.add(zzaza);
        hashSet3.add(zzazc);
        hashSet3.add(zzayX);
        hashSet3.add(zzayY);
        hashSet3.add(zzayN);
        HashMap map = new HashMap();
        zza(map, hashSet, zza.CUMULATIVE);
        zza(map, hashSet2, zza.DELTA);
        zza(map, hashSet3, zza.SAMPLE);
        zzazw = Collections.unmodifiableMap(map);
    }

    public static zzsy.zza zza(String str, zzsy.zzb... zzbVarArr) {
        zzsy.zza zzaVar = new zzsy.zza();
        zzaVar.name = str;
        zzaVar.zzbuE = zzbVarArr;
        return zzaVar;
    }

    private static void zza(Map<zzsy.zza, zza> map, Collection<zzsy.zza> collection, zza zzaVar) {
        Iterator<zzsy.zza> it = collection.iterator();
        while (it.hasNext()) {
            map.put(it.next(), zzaVar);
        }
    }

    public static boolean zzdD(String str) {
        return Arrays.binarySearch(zzazv, str) >= 0;
    }

    private static Map<String, List<zzsy.zza>> zzuF() {
        HashMap map = new HashMap();
        map.put(zzayD.name, Collections.singletonList(zzaze));
        map.put(zzayF.name, Collections.singletonList(zzazi));
        map.put(zzayG.name, Collections.singletonList(zzazj));
        map.put(zzayQ.name, Collections.singletonList(zzazh));
        map.put(zzayE.name, Collections.singletonList(zzazf));
        map.put(zzayO.name, Collections.singletonList(zzazl));
        map.put(zzayI.name, Collections.singletonList(zzazm));
        map.put(zzayN.name, Collections.singletonList(zzazk));
        map.put(zzayS.name, Collections.singletonList(zzazn));
        map.put(zzayA.name, Collections.singletonList(zzazg));
        map.put(zzayY.name, Collections.singletonList(zzazo));
        return map;
    }
}
