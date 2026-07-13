package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import com.adjust.sdk.Constants;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class zzax {
    private static String zzbjg;
    static Map<String, String> zzbjh = new HashMap();

    public static String zzU(String str, String str2) {
        if (str2 != null) {
            return Uri.parse("http://hostname/?" + str).getQueryParameter(str2);
        }
        if (str.length() > 0) {
            return str;
        }
        return null;
    }

    public static String zzf(Context context, String str, String str2) {
        String string = zzbjh.get(str);
        if (string == null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("gtm_click_referrers", 0);
            string = sharedPreferences != null ? sharedPreferences.getString(str, "") : "";
            zzbjh.put(str, string);
        }
        return zzU(string, str2);
    }

    public static void zzgh(String str) {
        synchronized (zzax.class) {
            zzbjg = str;
        }
    }

    public static String zzm(Context context, String str) {
        if (zzbjg == null) {
            synchronized (zzax.class) {
                if (zzbjg == null) {
                    SharedPreferences sharedPreferences = context.getSharedPreferences("gtm_install_referrer", 0);
                    if (sharedPreferences != null) {
                        zzbjg = sharedPreferences.getString(Constants.REFERRER, "");
                    } else {
                        zzbjg = "";
                    }
                }
            }
        }
        return zzU(zzbjg, str);
    }

    public static void zzn(Context context, String str) {
        String strZzU = zzU(str, "conv");
        if (strZzU == null || strZzU.length() <= 0) {
            return;
        }
        zzbjh.put(strZzU, str);
        zzcv.zzb(context, "gtm_click_referrers", strZzU, str);
    }
}
