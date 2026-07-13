package com.google.android.gms.internal;

import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class zzni {
    private static final Pattern zzaok = Pattern.compile("\\$\\{(.*?)\\}");

    public static boolean zzcV(String str) {
        return str == null || com.google.android.gms.common.internal.zze.zzakF.zzb(str);
    }
}
