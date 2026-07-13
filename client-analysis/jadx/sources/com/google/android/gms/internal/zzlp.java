package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.common.images.WebImage;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class zzlp {
    private static final com.google.android.gms.cast.internal.zzl zzaaf = new com.google.android.gms.cast.internal.zzl("MetadataUtils");
    private static final String[] zzaeC = {"Z", "+hh", "+hhmm", "+hh:mm"};
    private static final String zzaeD = "yyyyMMdd'T'HHmmss" + zzaeC[0];

    public static String zza(Calendar calendar) {
        if (calendar == null) {
            zzaaf.zzb("Calendar object cannot be null", new Object[0]);
            return null;
        }
        String str = zzaeD;
        if (calendar.get(11) == 0 && calendar.get(12) == 0 && calendar.get(13) == 0) {
            str = "yyyyMMdd";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
        simpleDateFormat.setTimeZone(calendar.getTimeZone());
        String str2 = simpleDateFormat.format(calendar.getTime());
        return str2.endsWith("+0000") ? str2.replace("+0000", zzaeC[0]) : str2;
    }

    public static void zza(List<WebImage> list, JSONObject jSONObject) {
        try {
            list.clear();
            JSONArray jSONArray = jSONObject.getJSONArray("images");
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                try {
                    list.add(new WebImage(jSONArray.getJSONObject(i)));
                } catch (IllegalArgumentException e) {
                }
            }
        } catch (JSONException e2) {
        }
    }

    public static void zza(JSONObject jSONObject, List<WebImage> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<WebImage> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().toJson());
        }
        try {
            jSONObject.put("images", jSONArray);
        } catch (JSONException e) {
        }
    }

    public static Calendar zzco(String str) {
        if (TextUtils.isEmpty(str)) {
            zzaaf.zzb("Input string is empty or null", new Object[0]);
            return null;
        }
        String strZzcp = zzcp(str);
        if (TextUtils.isEmpty(strZzcp)) {
            zzaaf.zzb("Invalid date format", new Object[0]);
            return null;
        }
        String strZzcq = zzcq(str);
        String str2 = "yyyyMMdd";
        if (!TextUtils.isEmpty(strZzcq)) {
            strZzcp = strZzcp + "T" + strZzcq;
            str2 = strZzcq.length() == "HHmmss".length() ? "yyyyMMdd'T'HHmmss" : zzaeD;
        }
        Calendar gregorianCalendar = GregorianCalendar.getInstance();
        try {
            gregorianCalendar.setTime(new SimpleDateFormat(str2).parse(strZzcp));
            return gregorianCalendar;
        } catch (ParseException e) {
            zzaaf.zzb("Error parsing string: %s", e.getMessage());
            return null;
        }
    }

    private static String zzcp(String str) {
        if (TextUtils.isEmpty(str)) {
            zzaaf.zzb("Input string is empty or null", new Object[0]);
            return null;
        }
        try {
            return str.substring(0, "yyyyMMdd".length());
        } catch (IndexOutOfBoundsException e) {
            zzaaf.zze("Error extracting the date: %s", e.getMessage());
            return null;
        }
    }

    private static String zzcq(String str) {
        if (TextUtils.isEmpty(str)) {
            zzaaf.zzb("string is empty or null", new Object[0]);
            return null;
        }
        int iIndexOf = str.indexOf(84);
        int i = iIndexOf + 1;
        if (iIndexOf != "yyyyMMdd".length()) {
            zzaaf.zzb("T delimeter is not found", new Object[0]);
            return null;
        }
        try {
            String strSubstring = str.substring(i);
            if (strSubstring.length() == "HHmmss".length()) {
                return strSubstring;
            }
            switch (strSubstring.charAt("HHmmss".length())) {
                case '+':
                case '-':
                    if (zzcr(strSubstring)) {
                        return strSubstring.replaceAll("([\\+\\-]\\d\\d):(\\d\\d)", "$1$2");
                    }
                    return null;
                case 'Z':
                    if (strSubstring.length() == "HHmmss".length() + zzaeC[0].length()) {
                        return strSubstring.substring(0, strSubstring.length() - 1) + "+0000";
                    }
                    return null;
                default:
                    return null;
            }
        } catch (IndexOutOfBoundsException e) {
            zzaaf.zzb("Error extracting the time substring: %s", e.getMessage());
            return null;
        }
    }

    private static boolean zzcr(String str) {
        int length = str.length();
        int length2 = "HHmmss".length();
        return length == zzaeC[1].length() + length2 || length == zzaeC[2].length() + length2 || length == length2 + zzaeC[3].length();
    }
}
