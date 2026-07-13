package com.google.android.gms.analytics.internal;

import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class zzab {
    private final List<Command> zzSJ;
    private final long zzSK;
    private final long zzSL;
    private final int zzSM;
    private final boolean zzSN;
    private final String zzSO;
    private final Map<String, String> zzxA;

    public zzab(zzc zzcVar, Map<String, String> map, long j, boolean z) {
        this(zzcVar, map, j, z, 0L, 0, null);
    }

    public zzab(zzc zzcVar, Map<String, String> map, long j, boolean z, long j2, int i) {
        this(zzcVar, map, j, z, j2, i, null);
    }

    public zzab(zzc zzcVar, Map<String, String> map, long j, boolean z, long j2, int i, List<Command> list) {
        String strZza;
        String strZza2;
        com.google.android.gms.common.internal.zzx.zzz(zzcVar);
        com.google.android.gms.common.internal.zzx.zzz(map);
        this.zzSL = j;
        this.zzSN = z;
        this.zzSK = j2;
        this.zzSM = i;
        this.zzSJ = list != null ? list : Collections.EMPTY_LIST;
        this.zzSO = zzp(list);
        HashMap map2 = new HashMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (zzk(entry.getKey()) && (strZza2 = zza(zzcVar, entry.getKey())) != null) {
                map2.put(strZza2, zzb(zzcVar, entry.getValue()));
            }
        }
        for (Map.Entry<String, String> entry2 : map.entrySet()) {
            if (!zzk(entry2.getKey()) && (strZza = zza(zzcVar, entry2.getKey())) != null) {
                map2.put(strZza, zzb(zzcVar, entry2.getValue()));
            }
        }
        if (!TextUtils.isEmpty(this.zzSO)) {
            zzam.zzc(map2, "_v", this.zzSO);
            if (this.zzSO.equals("ma4.0.0") || this.zzSO.equals("ma4.0.1")) {
                map2.remove("adid");
            }
        }
        this.zzxA = Collections.unmodifiableMap(map2);
    }

    public static zzab zza(zzc zzcVar, zzab zzabVar, Map<String, String> map) {
        return new zzab(zzcVar, map, zzabVar.zzlr(), zzabVar.zzlt(), zzabVar.zzlq(), zzabVar.zzlp(), zzabVar.zzls());
    }

    private static String zza(zzc zzcVar, Object obj) {
        if (obj == null) {
            return null;
        }
        String string = obj.toString();
        if (string.startsWith("&")) {
            string = string.substring(1);
        }
        int length = string.length();
        if (length > 256) {
            string = string.substring(0, 256);
            zzcVar.zzc("Hit param name is too long and will be trimmed", Integer.valueOf(length), string);
        }
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return string;
    }

    private static String zzb(zzc zzcVar, Object obj) {
        String string = obj == null ? "" : obj.toString();
        int length = string.length();
        if (length <= 8192) {
            return string;
        }
        String strSubstring = string.substring(0, 8192);
        zzcVar.zzc("Hit param value is too long and will be trimmed", Integer.valueOf(length), strSubstring);
        return strSubstring;
    }

    private static boolean zzk(Object obj) {
        if (obj == null) {
            return false;
        }
        return obj.toString().startsWith("&");
    }

    private String zzm(String str, String str2) {
        com.google.android.gms.common.internal.zzx.zzcM(str);
        com.google.android.gms.common.internal.zzx.zzb(!str.startsWith("&"), "Short param name required");
        String str3 = this.zzxA.get(str);
        return str3 != null ? str3 : str2;
    }

    private static String zzp(List<Command> list) {
        String value;
        if (list == null) {
            value = null;
            break;
        }
        Iterator<Command> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                value = null;
                break;
            }
            Command next = it.next();
            if ("appendVersion".equals(next.getId())) {
                value = next.getValue();
                break;
            }
        }
        if (TextUtils.isEmpty(value)) {
            return null;
        }
        return value;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ht=").append(this.zzSL);
        if (this.zzSK != 0) {
            stringBuffer.append(", dbId=").append(this.zzSK);
        }
        if (this.zzSM != 0) {
            stringBuffer.append(", appUID=").append(this.zzSM);
        }
        ArrayList<String> arrayList = new ArrayList(this.zzxA.keySet());
        Collections.sort(arrayList);
        for (String str : arrayList) {
            stringBuffer.append(", ");
            stringBuffer.append(str);
            stringBuffer.append("=");
            stringBuffer.append(this.zzxA.get(str));
        }
        return stringBuffer.toString();
    }

    public int zzlp() {
        return this.zzSM;
    }

    public long zzlq() {
        return this.zzSK;
    }

    public long zzlr() {
        return this.zzSL;
    }

    public List<Command> zzls() {
        return this.zzSJ;
    }

    public boolean zzlt() {
        return this.zzSN;
    }

    public long zzlu() {
        return zzam.zzbt(zzm("_s", AppEventsConstants.EVENT_PARAM_VALUE_NO));
    }

    public String zzlv() {
        return zzm("_m", "");
    }

    public Map<String, String> zzn() {
        return this.zzxA;
    }
}
