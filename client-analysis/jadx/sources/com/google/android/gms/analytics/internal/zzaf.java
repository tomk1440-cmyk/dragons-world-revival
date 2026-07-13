package com.google.android.gms.analytics.internal;

import android.util.Log;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class zzaf extends zzd {
    private static String zzSW = "3";
    private static String zzSX = "01VDIWEA?";
    private static zzaf zzSY;

    public zzaf(zzf zzfVar) {
        super(zzfVar);
    }

    public static zzaf zzlx() {
        return zzSY;
    }

    public void zza(int i, String str, Object obj, Object obj2, Object obj3) {
        String str2 = zzy.zzRL.get();
        if (Log.isLoggable(str2, i)) {
            Log.println(i, str2, zzc(str, obj, obj2, obj3));
        }
        if (i >= 5) {
            zzb(i, str, obj, obj2, obj3);
        }
    }

    public void zza(zzab zzabVar, String str) {
        if (str == null) {
            str = "no reason provided";
        }
        zzd("Discarding hit. " + str, zzabVar != null ? zzabVar.toString() : "no hit data");
    }

    public synchronized void zzb(int i, String str, Object obj, Object obj2, Object obj3) {
        char c;
        synchronized (this) {
            com.google.android.gms.common.internal.zzx.zzz(str);
            int i2 = i >= 0 ? i : 0;
            int length = i2 >= zzSX.length() ? zzSX.length() - 1 : i2;
            if (zzjn().zzks()) {
                c = zzjn().zzkr() ? 'P' : 'C';
            } else {
                c = zzjn().zzkr() ? 'p' : 'c';
            }
            String strSubstring = zzSW + zzSX.charAt(length) + c + zze.VERSION + ":" + zzc(str, zzl(obj), zzl(obj2), zzl(obj3));
            if (strSubstring.length() > 1024) {
                strSubstring = strSubstring.substring(0, 1024);
            }
            zzai zzaiVarZzjA = zzji().zzjA();
            if (zzaiVarZzjA != null) {
                zzaiVarZzjA.zzlK().zzbq(strSubstring);
            }
        }
    }

    public void zzh(Map<String, String> map, String str) {
        String string;
        if (str == null) {
            str = "no reason provided";
        }
        if (map != null) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (sb.length() > 0) {
                    sb.append(',');
                }
                sb.append(entry.getKey());
                sb.append('=');
                sb.append(entry.getValue());
            }
            string = sb.toString();
        } else {
            string = "no hit data";
        }
        zzd("Discarding hit. " + str, string);
    }

    @Override // com.google.android.gms.analytics.internal.zzd
    protected void zziJ() {
        synchronized (zzaf.class) {
            zzSY = this;
        }
    }

    protected String zzl(Object obj) {
        if (obj == null) {
            return null;
        }
        Object l = obj instanceof Integer ? new Long(((Integer) obj).intValue()) : obj;
        if (!(l instanceof Long)) {
            if (l instanceof Boolean) {
                return String.valueOf(l);
            }
            return l instanceof Throwable ? l.getClass().getCanonicalName() : "-";
        }
        if (Math.abs(((Long) l).longValue()) < 100) {
            return String.valueOf(l);
        }
        String str = String.valueOf(l).charAt(0) == '-' ? "-" : "";
        String strValueOf = String.valueOf(Math.abs(((Long) l).longValue()));
        return str + Math.round(Math.pow(10.0d, strValueOf.length() - 1)) + "..." + str + Math.round(Math.pow(10.0d, strValueOf.length()) - 1.0d);
    }
}
