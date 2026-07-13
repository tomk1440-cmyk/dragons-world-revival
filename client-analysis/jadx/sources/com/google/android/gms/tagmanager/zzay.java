package com.google.android.gms.tagmanager;

import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
class zzay extends zzak {
    private static final String ID = com.google.android.gms.internal.zzad.JOINER.toString();
    private static final String zzbiQ = com.google.android.gms.internal.zzae.ARG0.toString();
    private static final String zzbji = com.google.android.gms.internal.zzae.ITEM_SEPARATOR.toString();
    private static final String zzbjj = com.google.android.gms.internal.zzae.KEY_VALUE_SEPARATOR.toString();
    private static final String zzbjk = com.google.android.gms.internal.zzae.ESCAPE.toString();

    private enum zza {
        NONE,
        URL,
        BACKSLASH
    }

    public zzay() {
        super(ID, zzbiQ);
    }

    private String zza(String str, zza zzaVar, Set<Character> set) {
        switch (zzaVar) {
            case URL:
                try {
                    return zzdj.zzgA(str);
                } catch (UnsupportedEncodingException e) {
                    zzbg.zzb("Joiner: unsupported encoding", e);
                    return str;
                }
            case BACKSLASH:
                String strReplace = str.replace("\\", "\\\\");
                Iterator<Character> it = set.iterator();
                while (true) {
                    String str2 = strReplace;
                    if (!it.hasNext()) {
                        return str2;
                    }
                    String string = it.next().toString();
                    strReplace = str2.replace(string, "\\" + string);
                }
                break;
            default:
                return str;
        }
    }

    private void zza(StringBuilder sb, String str, zza zzaVar, Set<Character> set) {
        sb.append(zza(str, zzaVar, set));
    }

    private void zza(Set<Character> set, String str) {
        for (int i = 0; i < str.length(); i++) {
            set.add(Character.valueOf(str.charAt(i)));
        }
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public boolean zzFW() {
        return true;
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public com.google.android.gms.internal.zzag.zza zzP(Map<String, com.google.android.gms.internal.zzag.zza> map) {
        HashSet hashSet;
        zza zzaVar;
        com.google.android.gms.internal.zzag.zza zzaVar2 = map.get(zzbiQ);
        if (zzaVar2 == null) {
            return zzdf.zzHF();
        }
        com.google.android.gms.internal.zzag.zza zzaVar3 = map.get(zzbji);
        String strZzg = zzaVar3 != null ? zzdf.zzg(zzaVar3) : "";
        com.google.android.gms.internal.zzag.zza zzaVar4 = map.get(zzbjj);
        String strZzg2 = zzaVar4 != null ? zzdf.zzg(zzaVar4) : "=";
        zza zzaVar5 = zza.NONE;
        com.google.android.gms.internal.zzag.zza zzaVar6 = map.get(zzbjk);
        if (zzaVar6 != null) {
            String strZzg3 = zzdf.zzg(zzaVar6);
            if ("url".equals(strZzg3)) {
                zzaVar = zza.URL;
                hashSet = null;
            } else {
                if (!"backslash".equals(strZzg3)) {
                    zzbg.e("Joiner: unsupported escape type: " + strZzg3);
                    return zzdf.zzHF();
                }
                zzaVar = zza.BACKSLASH;
                hashSet = new HashSet();
                zza(hashSet, strZzg);
                zza(hashSet, strZzg2);
                hashSet.remove('\\');
            }
        } else {
            hashSet = null;
            zzaVar = zzaVar5;
        }
        StringBuilder sb = new StringBuilder();
        switch (zzaVar2.type) {
            case 2:
                boolean z = true;
                com.google.android.gms.internal.zzag.zza[] zzaVarArr = zzaVar2.zzjy;
                int length = zzaVarArr.length;
                int i = 0;
                while (i < length) {
                    com.google.android.gms.internal.zzag.zza zzaVar7 = zzaVarArr[i];
                    if (!z) {
                        sb.append(strZzg);
                    }
                    zza(sb, zzdf.zzg(zzaVar7), zzaVar, hashSet);
                    i++;
                    z = false;
                }
                break;
            case 3:
                for (int i2 = 0; i2 < zzaVar2.zzjz.length; i2++) {
                    if (i2 > 0) {
                        sb.append(strZzg);
                    }
                    String strZzg4 = zzdf.zzg(zzaVar2.zzjz[i2]);
                    String strZzg5 = zzdf.zzg(zzaVar2.zzjA[i2]);
                    zza(sb, strZzg4, zzaVar, hashSet);
                    sb.append(strZzg2);
                    zza(sb, strZzg5, zzaVar, hashSet);
                }
                break;
            default:
                zza(sb, zzdf.zzg(zzaVar2), zzaVar, hashSet);
                break;
        }
        return zzdf.zzR(sb.toString());
    }
}
