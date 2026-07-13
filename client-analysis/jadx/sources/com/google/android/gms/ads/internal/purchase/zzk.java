package com.google.android.gms.ads.internal.purchase;

import android.content.Intent;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzin;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzk {
    private final String zzuM;

    public zzk(String str) {
        this.zzuM = str;
    }

    public boolean zza(String str, int i, Intent intent) {
        if (str == null || intent == null) {
            return false;
        }
        String strZze = zzr.zzbM().zze(intent);
        String strZzf = zzr.zzbM().zzf(intent);
        if (strZze == null || strZzf == null) {
            return false;
        }
        if (!str.equals(zzr.zzbM().zzaq(strZze))) {
            zzin.zzaK("Developer payload not match.");
            return false;
        }
        if (this.zzuM == null || zzl.zzc(this.zzuM, strZze, strZzf)) {
            return true;
        }
        zzin.zzaK("Fail to verify signature.");
        return false;
    }

    public String zzfZ() {
        return zzr.zzbC().zzhs();
    }
}
