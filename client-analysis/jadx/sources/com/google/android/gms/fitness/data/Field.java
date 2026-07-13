package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;

/* JADX INFO: loaded from: classes.dex */
public final class Field implements SafeParcelable {
    public static final int FORMAT_FLOAT = 2;
    public static final int FORMAT_INT32 = 1;
    public static final int FORMAT_MAP = 4;
    public static final int FORMAT_STRING = 3;
    public static final int MEAL_TYPE_BREAKFAST = 1;
    public static final int MEAL_TYPE_DINNER = 3;
    public static final int MEAL_TYPE_LUNCH = 2;
    public static final int MEAL_TYPE_SNACK = 4;
    public static final int MEAL_TYPE_UNKNOWN = 0;
    public static final String NUTRIENT_CALCIUM = "calcium";
    public static final String NUTRIENT_CHOLESTEROL = "cholesterol";
    public static final String NUTRIENT_DIETARY_FIBER = "dietary_fiber";
    public static final String NUTRIENT_IRON = "iron";
    public static final String NUTRIENT_MONOUNSATURATED_FAT = "fat.monounsaturated";
    public static final String NUTRIENT_POLYUNSATURATED_FAT = "fat.polyunsaturated";
    public static final String NUTRIENT_POTASSIUM = "potassium";
    public static final String NUTRIENT_PROTEIN = "protein";
    public static final String NUTRIENT_SATURATED_FAT = "fat.saturated";
    public static final String NUTRIENT_SODIUM = "sodium";
    public static final String NUTRIENT_SUGAR = "sugar";
    public static final String NUTRIENT_TOTAL_CARBS = "carbs.total";
    public static final String NUTRIENT_TOTAL_FAT = "fat.total";
    public static final String NUTRIENT_TRANS_FAT = "fat.trans";
    public static final String NUTRIENT_UNSATURATED_FAT = "fat.unsaturated";
    public static final String NUTRIENT_VITAMIN_A = "vitamin_a";
    public static final String NUTRIENT_VITAMIN_C = "vitamin_c";
    public static final int RESISTANCE_TYPE_BARBELL = 1;
    public static final int RESISTANCE_TYPE_BODY = 6;
    public static final int RESISTANCE_TYPE_CABLE = 2;
    public static final int RESISTANCE_TYPE_DUMBBELL = 3;
    public static final int RESISTANCE_TYPE_KETTLEBELL = 4;
    public static final int RESISTANCE_TYPE_MACHINE = 5;
    public static final int RESISTANCE_TYPE_UNKNOWN = 0;
    private final String mName;
    private final int mVersionCode;
    private final int zzawZ;
    private final Boolean zzaxa;
    public static final Field FIELD_ACTIVITY = zzdo("activity");
    public static final Field FIELD_CONFIDENCE = zzdp("confidence");
    public static final Field zzawM = zzds("activity_confidence");
    public static final Field FIELD_STEPS = zzdo("steps");
    public static final Field FIELD_DURATION = zzdo("duration");
    public static final Field zzawN = zzds("activity_duration");
    public static final Field zzawO = zzds("activity_duration.ascending");
    public static final Field zzawP = zzds("activity_duration.descending");
    public static final Field FIELD_BPM = zzdp("bpm");
    public static final Field FIELD_LATITUDE = zzdp("latitude");
    public static final Field FIELD_LONGITUDE = zzdp("longitude");
    public static final Field FIELD_ACCURACY = zzdp("accuracy");
    public static final Field FIELD_ALTITUDE = zzdq("altitude");
    public static final Field FIELD_DISTANCE = zzdp("distance");
    public static final Field FIELD_HEIGHT = zzdp(SettingsJsonConstants.ICON_HEIGHT_KEY);
    public static final Field FIELD_WEIGHT = zzdp("weight");
    public static final Field FIELD_CIRCUMFERENCE = zzdp("circumference");
    public static final Field FIELD_PERCENTAGE = zzdp("percentage");
    public static final Field FIELD_SPEED = zzdp("speed");
    public static final Field FIELD_RPM = zzdp("rpm");
    public static final Field FIELD_REVOLUTIONS = zzdo("revolutions");
    public static final String NUTRIENT_CALORIES = "calories";
    public static final Field FIELD_CALORIES = zzdp(NUTRIENT_CALORIES);
    public static final Field FIELD_WATTS = zzdp("watts");
    public static final Field FIELD_MEAL_TYPE = zzdo("meal_type");
    public static final Field FIELD_FOOD_ITEM = zzdr("food_item");
    public static final Field FIELD_NUTRIENTS = zzds("nutrients");
    public static final Field zzawQ = zzdp("elevation.change");
    public static final Field zzawR = zzds("elevation.gain");
    public static final Field zzawS = zzds("elevation.loss");
    public static final Field zzawT = zzdp("floors");
    public static final Field zzawU = zzds("floor.gain");
    public static final Field zzawV = zzds("floor.loss");
    public static final Field FIELD_EXERCISE = zzdr("exercise");
    public static final Field FIELD_REPETITIONS = zzdo("repetitions");
    public static final Field FIELD_RESISTANCE = zzdp("resistance");
    public static final Field FIELD_RESISTANCE_TYPE = zzdo("resistance_type");
    public static final Field FIELD_NUM_SEGMENTS = zzdo("num_segments");
    public static final Field FIELD_AVERAGE = zzdp("average");
    public static final Field FIELD_MAX = zzdp("max");
    public static final Field FIELD_MIN = zzdp("min");
    public static final Field FIELD_LOW_LATITUDE = zzdp("low_latitude");
    public static final Field FIELD_LOW_LONGITUDE = zzdp("low_longitude");
    public static final Field FIELD_HIGH_LATITUDE = zzdp("high_latitude");
    public static final Field FIELD_HIGH_LONGITUDE = zzdp("high_longitude");
    public static final Field zzawW = zzdp("x");
    public static final Field zzawX = zzdp("y");
    public static final Field zzawY = zzdp("z");
    public static final Parcelable.Creator<Field> CREATOR = new zzj();

    Field(int versionCode, String name, int format, Boolean optional) {
        this.mVersionCode = versionCode;
        this.mName = (String) zzx.zzz(name);
        this.zzawZ = format;
        this.zzaxa = optional;
    }

    private Field(String name, int format) {
        this(2, name, format, null);
    }

    private Field(String name, int format, Boolean optional) {
        this(2, name, format, optional);
    }

    public static Field zza(String str, int i, Boolean bool) {
        switch (str) {
            case "accuracy":
                return FIELD_ACCURACY;
            case "activity":
                return FIELD_ACTIVITY;
            case "activity_duration":
                return zzawN;
            case "activity_duration.ascending":
                return zzawO;
            case "activity_duration.descending":
                return zzawP;
            case "altitude":
                return FIELD_ALTITUDE;
            case "average":
                return FIELD_AVERAGE;
            case "bpm":
                return FIELD_BPM;
            case "calories":
                return FIELD_CALORIES;
            case "circumference":
                return FIELD_CIRCUMFERENCE;
            case "confidence":
                return FIELD_CONFIDENCE;
            case "distance":
                return FIELD_DISTANCE;
            case "duration":
                return FIELD_DURATION;
            case "elevation.change":
                return zzawQ;
            case "elevation.gain":
                return zzawR;
            case "elevation.loss":
                return zzawS;
            case "exercise":
                return FIELD_EXERCISE;
            case "floor.gain":
                return zzawU;
            case "floor.loss":
                return zzawV;
            case "floors":
                return zzawT;
            case "food_item":
                return FIELD_FOOD_ITEM;
            case "height":
                return FIELD_HEIGHT;
            case "high_latitude":
                return FIELD_HIGH_LATITUDE;
            case "high_longitude":
                return FIELD_HIGH_LONGITUDE;
            case "latitude":
                return FIELD_LATITUDE;
            case "longitude":
                return FIELD_LONGITUDE;
            case "low_latitude":
                return FIELD_LOW_LATITUDE;
            case "low_longitude":
                return FIELD_LOW_LONGITUDE;
            case "max":
                return FIELD_MAX;
            case "meal_type":
                return FIELD_MEAL_TYPE;
            case "min":
                return FIELD_MIN;
            case "num_segments":
                return FIELD_NUM_SEGMENTS;
            case "nutrients":
                return FIELD_NUTRIENTS;
            case "percentage":
                return FIELD_PERCENTAGE;
            case "repetitions":
                return FIELD_REPETITIONS;
            case "resistance":
                return FIELD_RESISTANCE;
            case "resistance_type":
                return FIELD_RESISTANCE_TYPE;
            case "revolutions":
                return FIELD_REVOLUTIONS;
            case "rpm":
                return FIELD_RPM;
            case "speed":
                return FIELD_SPEED;
            case "steps":
                return FIELD_STEPS;
            case "watts":
                return FIELD_WATTS;
            case "weight":
                return FIELD_WEIGHT;
            case "x":
                return zzawW;
            case "y":
                return zzawX;
            case "z":
                return zzawY;
            default:
                return new Field(str, i, bool);
        }
    }

    private boolean zza(Field field) {
        return this.mName.equals(field.mName) && this.zzawZ == field.zzawZ;
    }

    private static Field zzdo(String str) {
        return new Field(str, 1);
    }

    private static Field zzdp(String str) {
        return new Field(str, 2);
    }

    private static Field zzdq(String str) {
        return new Field(str, 2, true);
    }

    private static Field zzdr(String str) {
        return new Field(str, 3);
    }

    private static Field zzds(String str) {
        return new Field(str, 4);
    }

    public static Field zzn(String str, int i) {
        return zza(str, i, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof Field) && zza((Field) that));
    }

    public int getFormat() {
        return this.zzawZ;
    }

    public String getName() {
        return this.mName;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return this.mName.hashCode();
    }

    public Boolean isOptional() {
        return this.zzaxa;
    }

    public String toString() {
        Object[] objArr = new Object[2];
        objArr[0] = this.mName;
        objArr[1] = this.zzawZ == 1 ? "i" : "f";
        return String.format("%s(%s)", objArr);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzj.zza(this, dest, flags);
    }
}
