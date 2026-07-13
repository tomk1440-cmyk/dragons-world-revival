package com.google.android.gms.tagmanager;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* JADX INFO: loaded from: classes.dex */
class zzce extends zzak {
    private static final String ID = com.google.android.gms.internal.zzad.REGEX_GROUP.toString();
    private static final String zzbka = com.google.android.gms.internal.zzae.ARG0.toString();
    private static final String zzbkb = com.google.android.gms.internal.zzae.ARG1.toString();
    private static final String zzbkc = com.google.android.gms.internal.zzae.IGNORE_CASE.toString();
    private static final String zzbkd = com.google.android.gms.internal.zzae.GROUP.toString();

    public zzce() {
        super(ID, zzbka, zzbkb);
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public boolean zzFW() {
        return true;
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public com.google.android.gms.internal.zzag.zza zzP(Map<String, com.google.android.gms.internal.zzag.zza> map) {
        int iIntValue;
        com.google.android.gms.internal.zzag.zza zzaVar = map.get(zzbka);
        com.google.android.gms.internal.zzag.zza zzaVar2 = map.get(zzbkb);
        if (zzaVar == null || zzaVar == zzdf.zzHF() || zzaVar2 == null || zzaVar2 == zzdf.zzHF()) {
            return zzdf.zzHF();
        }
        int i = zzdf.zzk(map.get(zzbkc)).booleanValue() ? 66 : 64;
        com.google.android.gms.internal.zzag.zza zzaVar3 = map.get(zzbkd);
        if (zzaVar3 != null) {
            Long lZzi = zzdf.zzi(zzaVar3);
            if (lZzi == zzdf.zzHA()) {
                return zzdf.zzHF();
            }
            iIntValue = lZzi.intValue();
            if (iIntValue < 0) {
                return zzdf.zzHF();
            }
        } else {
            iIntValue = 1;
        }
        try {
            String strZzg = zzdf.zzg(zzaVar);
            String strGroup = null;
            Matcher matcher = Pattern.compile(zzdf.zzg(zzaVar2), i).matcher(strZzg);
            if (matcher.find() && matcher.groupCount() >= iIntValue) {
                strGroup = matcher.group(iIntValue);
            }
            return strGroup == null ? zzdf.zzHF() : zzdf.zzR(strGroup);
        } catch (PatternSyntaxException e) {
            return zzdf.zzHF();
        }
    }
}
