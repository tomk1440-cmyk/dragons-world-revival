package com.google.android.gms.internal;

import com.google.android.gms.fitness.data.Field;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;

/* JADX INFO: loaded from: classes.dex */
public class zznt {
    public static final zzsy.zzb zzaxw = zzdt("activity");
    public static final zzsy.zzb zzaxx = zzdv("confidence");
    public static final zzsy.zzb zzaxy = zzdz("activity_confidence");
    public static final zzsy.zzb zzaxz = zzdt("steps");
    public static final zzsy.zzb zzaxA = zzdt("duration");
    public static final zzsy.zzb zzaxB = zzdz("activity_duration");
    public static final zzsy.zzb zzaxC = zzdz("activity_duration.ascending");
    public static final zzsy.zzb zzaxD = zzdz("activity_duration.descending");
    public static final zzsy.zzb zzaxE = zzdv("bpm");
    public static final zzsy.zzb zzaxF = zzdv("latitude");
    public static final zzsy.zzb zzaxG = zzdv("longitude");
    public static final zzsy.zzb zzaxH = zzdv("accuracy");
    public static final zzsy.zzb zzaxI = zzdw("altitude");
    public static final zzsy.zzb zzaxJ = zzdv("distance");
    public static final zzsy.zzb zzaxK = zzdC("google.android.fitness.GoalV2");
    public static final zzsy.zzb zzaxL = zzdv("progress");
    public static final zzsy.zzb zzaxM = zzdv(SettingsJsonConstants.ICON_HEIGHT_KEY);
    public static final zzsy.zzb zzaxN = zzdv("weight");
    public static final zzsy.zzb zzaxO = zzdv("circumference");
    public static final zzsy.zzb zzaxP = zzdv("percentage");
    public static final zzsy.zzb zzaxQ = zzdv("speed");
    public static final zzsy.zzb zzaxR = zzdv("rpm");
    public static final zzsy.zzb zzaxS = zzdt("revolutions");
    public static final zzsy.zzb zzaxT = zzdv(Field.NUTRIENT_CALORIES);
    public static final zzsy.zzb zzaxU = zzdv("watts");
    public static final zzsy.zzb zzaxV = zzdt("meal_type");
    public static final zzsy.zzb zzaxW = zzdx("food_item");
    public static final zzsy.zzb zzaxX = zzdz("nutrients");
    public static final zzsy.zzb zzaxY = zzdv("elevation.change");
    public static final zzsy.zzb zzaxZ = zzdz("elevation.gain");
    public static final zzsy.zzb zzaya = zzdz("elevation.loss");
    public static final zzsy.zzb zzayb = zzdv("floors");
    public static final zzsy.zzb zzayc = zzdz("floor.gain");
    public static final zzsy.zzb zzayd = zzdz("floor.loss");
    public static final zzsy.zzb zzaye = zzdx("exercise");
    public static final zzsy.zzb zzayf = zzdt("repetitions");
    public static final zzsy.zzb zzayg = zzdv("resistance");
    public static final zzsy.zzb zzayh = zzdt("resistance_type");
    public static final zzsy.zzb zzayi = zzdt("num_segments");
    public static final zzsy.zzb zzayj = zzdv("average");
    public static final zzsy.zzb zzayk = zzdv("max");
    public static final zzsy.zzb zzayl = zzdv("min");
    public static final zzsy.zzb zzaym = zzdv("low_latitude");
    public static final zzsy.zzb zzayn = zzdv("low_longitude");
    public static final zzsy.zzb zzayo = zzdv("high_latitude");
    public static final zzsy.zzb zzayp = zzdv("high_longitude");
    public static final zzsy.zzb zzayq = zzdv("x");
    public static final zzsy.zzb zzayr = zzdv("y");
    public static final zzsy.zzb zzays = zzdv("z");
    public static final zzsy.zzb zzayt = zzdA("timestamps");
    public static final zzsy.zzb zzayu = zzdB("sensor_values");
    public static final zzsy.zzb zzayv = zzdt("sensor_type");
    public static final zzsy.zzb zzayw = zzdx(SettingsJsonConstants.APP_IDENTIFIER_KEY);
    public static final zzsy.zzb zzayx = zzdy("name");
    public static final zzsy.zzb zzayy = zzdy("description");
    public static final zzsy.zzb zzayz = zzdu("active_time");

    private static zzsy.zzb zzb(String str, int i, Boolean bool) {
        zzsy.zzb zzbVar = new zzsy.zzb();
        zzbVar.name = str;
        zzbVar.zzbuG = Integer.valueOf(i);
        if (bool != null) {
            zzbVar.zzbuH = bool;
        }
        return zzbVar;
    }

    private static zzsy.zzb zzdA(String str) {
        return zzo(str, 5);
    }

    private static zzsy.zzb zzdB(String str) {
        return zzo(str, 6);
    }

    private static zzsy.zzb zzdC(String str) {
        return zzo(str, 7);
    }

    private static zzsy.zzb zzdt(String str) {
        return zzo(str, 1);
    }

    private static zzsy.zzb zzdu(String str) {
        return zzb(str, 1, true);
    }

    private static zzsy.zzb zzdv(String str) {
        return zzo(str, 2);
    }

    private static zzsy.zzb zzdw(String str) {
        return zzb(str, 2, true);
    }

    private static zzsy.zzb zzdx(String str) {
        return zzo(str, 3);
    }

    private static zzsy.zzb zzdy(String str) {
        return zzb(str, 3, true);
    }

    private static zzsy.zzb zzdz(String str) {
        return zzo(str, 4);
    }

    public static zzsy.zzb zzo(String str, int i) {
        return zzb(str, i, null);
    }
}
