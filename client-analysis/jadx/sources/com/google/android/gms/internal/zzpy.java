package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.plus.PlusShare;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class zzpy extends com.google.android.gms.measurement.zze<zzpy> {
    public String mCategory;
    public String zzaUO;
    public String zzaVa;
    public long zzaVb;

    public String getLabel() {
        return this.zzaUO;
    }

    public long getTimeInMillis() {
        return this.zzaVb;
    }

    public void setTimeInMillis(long milliseconds) {
        this.zzaVb = milliseconds;
    }

    public String toString() {
        HashMap map = new HashMap();
        map.put("variableName", this.zzaVa);
        map.put("timeInMillis", Long.valueOf(this.zzaVb));
        map.put("category", this.mCategory);
        map.put(PlusShare.KEY_CALL_TO_ACTION_LABEL, this.zzaUO);
        return zzF(map);
    }

    public String zzAZ() {
        return this.mCategory;
    }

    public String zzBh() {
        return this.zzaVa;
    }

    @Override // com.google.android.gms.measurement.zze
    public void zza(zzpy zzpyVar) {
        if (!TextUtils.isEmpty(this.zzaVa)) {
            zzpyVar.zzeL(this.zzaVa);
        }
        if (this.zzaVb != 0) {
            zzpyVar.setTimeInMillis(this.zzaVb);
        }
        if (!TextUtils.isEmpty(this.mCategory)) {
            zzpyVar.zzeE(this.mCategory);
        }
        if (TextUtils.isEmpty(this.zzaUO)) {
            return;
        }
        zzpyVar.zzeG(this.zzaUO);
    }

    public void zzeE(String str) {
        this.mCategory = str;
    }

    public void zzeG(String str) {
        this.zzaUO = str;
    }

    public void zzeL(String str) {
        this.zzaVa = str;
    }
}
