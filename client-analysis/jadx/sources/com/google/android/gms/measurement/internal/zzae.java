package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.zzpz;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
class zzae {
    final boolean zzaXg;
    final int zzaZh;
    final boolean zzaZi;
    final String zzaZj;
    final List<String> zzaZk;
    final String zzaZl;

    /* JADX WARN: Code duplicated, block: B:42:0x008d  */
    public zzae(zzpz.zzf zzfVar) {
        boolean z;
        boolean z2 = false;
        com.google.android.gms.common.internal.zzx.zzz(zzfVar);
        if (zzfVar.zzaZN == null || zzfVar.zzaZN.intValue() == 0) {
            z = false;
        } else if (zzfVar.zzaZN.intValue() == 6) {
            if (zzfVar.zzaZQ == null || zzfVar.zzaZQ.length == 0) {
                z = false;
            } else {
                z = true;
            }
        } else if (zzfVar.zzaZO == null) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            this.zzaZh = zzfVar.zzaZN.intValue();
            if (zzfVar.zzaZP != null && zzfVar.zzaZP.booleanValue()) {
                z2 = true;
            }
            this.zzaZi = z2;
            if (this.zzaZi || this.zzaZh == 1 || this.zzaZh == 6) {
                this.zzaZj = zzfVar.zzaZO;
            } else {
                this.zzaZj = zzfVar.zzaZO.toUpperCase(Locale.ENGLISH);
            }
            this.zzaZk = zzfVar.zzaZQ == null ? null : zza(zzfVar.zzaZQ, this.zzaZi);
            if (this.zzaZh == 1) {
                this.zzaZl = this.zzaZj;
            } else {
                this.zzaZl = null;
            }
        } else {
            this.zzaZh = 0;
            this.zzaZi = false;
            this.zzaZj = null;
            this.zzaZk = null;
            this.zzaZl = null;
        }
        this.zzaXg = z;
    }

    private List<String> zza(String[] strArr, boolean z) {
        if (z) {
            return Arrays.asList(strArr);
        }
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            arrayList.add(str.toUpperCase(Locale.ENGLISH));
        }
        return arrayList;
    }

    public Boolean zzfp(String str) {
        if (!this.zzaXg) {
            return null;
        }
        if (!this.zzaZi && this.zzaZh != 1) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        switch (this.zzaZh) {
            case 1:
                return Boolean.valueOf(Pattern.compile(this.zzaZl, this.zzaZi ? 0 : 66).matcher(str).matches());
            case 2:
                return Boolean.valueOf(str.startsWith(this.zzaZj));
            case 3:
                return Boolean.valueOf(str.endsWith(this.zzaZj));
            case 4:
                return Boolean.valueOf(str.contains(this.zzaZj));
            case 5:
                return Boolean.valueOf(str.equals(this.zzaZj));
            case 6:
                return Boolean.valueOf(this.zzaZk.contains(str));
            default:
                return null;
        }
    }
}
