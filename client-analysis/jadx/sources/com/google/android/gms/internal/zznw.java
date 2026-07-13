package com.google.android.gms.internal;

import android.util.Log;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Field;
import com.google.android.gms.fitness.data.Value;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class zznw {
    private static final Set<String> zzazD = Collections.unmodifiableSet(new HashSet(Arrays.asList(zznt.zzaxI.name, zznt.zzaxW.name)));

    public static String zzd(DataPoint dataPoint) {
        double dAsInt;
        DataType dataType = dataPoint.getDataType();
        if (!zznu.zzdD(dataType.getName())) {
            return null;
        }
        for (Field field : dataType.getFields()) {
            Value value = dataPoint.getValue(field);
            if (value.isSet()) {
                if (field.getFormat() == 1) {
                    dAsInt = value.asInt();
                } else if (field.getFormat() == 2) {
                    dAsInt = value.asFloat();
                } else {
                    continue;
                }
                zznx.zza zzaVarZzdE = zznx.zzuG().zzdE(field.getName());
                if (zzaVarZzdE != null && !zzaVarZzdE.zzh(dAsInt)) {
                    return "Field out of range";
                }
                zznx.zza zzaVarZzC = zznx.zzuG().zzC(dataType.getName(), field.getName());
                if (zzaVarZzC != null) {
                    long timestampNanos = dataPoint.getTimestampNanos() - dataPoint.zzuj();
                    if (timestampNanos == 0) {
                        if (dAsInt == 0.0d) {
                            return null;
                        }
                        return "DataPoint out of range";
                    }
                    if (!zzaVarZzC.zzh(dAsInt / timestampNanos)) {
                        return "DataPoint out of range";
                    }
                } else {
                    continue;
                }
            } else if (!zzazD.contains(field.getName())) {
                return field.getName() + " not set";
            }
        }
        return null;
    }

    public static void zze(DataPoint dataPoint) throws IllegalArgumentException {
        String strZzd = zzd(dataPoint);
        if (strZzd != null) {
            Log.w("Fitness", "Invalid data point: " + dataPoint);
            throw new IllegalArgumentException(strZzd);
        }
    }
}
