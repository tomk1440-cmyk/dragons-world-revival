package com.google.android.gms.tagmanager;

import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* JADX INFO: loaded from: classes.dex */
class zzcf extends zzcz {
    private static final String ID = com.google.android.gms.internal.zzad.REGEX.toString();
    private static final String zzbkc = com.google.android.gms.internal.zzae.IGNORE_CASE.toString();

    public zzcf() {
        super(ID);
    }

    @Override // com.google.android.gms.tagmanager.zzcz
    protected boolean zza(String str, String str2, Map<String, com.google.android.gms.internal.zzag.zza> map) {
        try {
            return Pattern.compile(str2, zzdf.zzk(map.get(zzbkc)).booleanValue() ? 66 : 64).matcher(str).find();
        } catch (PatternSyntaxException e) {
            return false;
        }
    }
}
