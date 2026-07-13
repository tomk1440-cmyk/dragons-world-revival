package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public abstract class zzby {

    @zzhb
    public static final zzby zzxs = new zzby() { // from class: com.google.android.gms.internal.zzby.1
        @Override // com.google.android.gms.internal.zzby
        public String zzb(@Nullable String str, String str2) {
            return str2;
        }
    };

    @zzhb
    public static final zzby zzxt = new zzby() { // from class: com.google.android.gms.internal.zzby.2
        @Override // com.google.android.gms.internal.zzby
        public String zzb(@Nullable String str, String str2) {
            return str != null ? str : str2;
        }
    };

    @zzhb
    public static final zzby zzxu = new zzby() { // from class: com.google.android.gms.internal.zzby.3
        @Nullable
        private String zzM(@Nullable String str) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            int i = 0;
            int length = str.length();
            while (i < str.length() && str.charAt(i) == ',') {
                i++;
            }
            while (length > 0 && str.charAt(length - 1) == ',') {
                length--;
            }
            return (i == 0 && length == str.length()) ? str : str.substring(i, length);
        }

        @Override // com.google.android.gms.internal.zzby
        public String zzb(@Nullable String str, String str2) {
            String strZzM = zzM(str);
            String strZzM2 = zzM(str2);
            if (TextUtils.isEmpty(strZzM)) {
                return strZzM2;
            }
            return TextUtils.isEmpty(strZzM2) ? strZzM : strZzM + "," + strZzM2;
        }
    };

    public final void zza(Map<String, String> map, String str, String str2) {
        map.put(str, zzb(map.get(str), str2));
    }

    public abstract String zzb(@Nullable String str, String str2);
}
