package com.google.android.gms.appdatasearch;

import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class zzh {
    private static final String[] zzUb = {"text1", "text2", SettingsJsonConstants.APP_ICON_KEY, "intent_action", "intent_data", "intent_data_id", "intent_extra_data", "suggest_large_icon", "intent_activity"};
    private static final Map<String, Integer> zzUc = new HashMap(zzUb.length);

    static {
        for (int i = 0; i < zzUb.length; i++) {
            zzUc.put(zzUb[i], Integer.valueOf(i));
        }
    }

    public static String zzao(int i) {
        if (i < 0 || i >= zzUb.length) {
            return null;
        }
        return zzUb[i];
    }

    public static int zzbA(String str) {
        Integer num = zzUc.get(str);
        if (num == null) {
            throw new IllegalArgumentException("[" + str + "] is not a valid global search section name");
        }
        return num.intValue();
    }

    public static int zzmg() {
        return zzUb.length;
    }
}
