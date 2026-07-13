package com.google.android.gms.internal;

import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.plus.PlusShare;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class zzpu extends com.google.android.gms.measurement.zze<zzpu> {
    private String mCategory;
    private String zzSU;
    private long zzaDV;
    private String zzaUO;

    public String getAction() {
        return this.zzSU;
    }

    public String getLabel() {
        return this.zzaUO;
    }

    public long getValue() {
        return this.zzaDV;
    }

    public String toString() {
        HashMap map = new HashMap();
        map.put("category", this.mCategory);
        map.put(NativeProtocol.WEB_DIALOG_ACTION, this.zzSU);
        map.put(PlusShare.KEY_CALL_TO_ACTION_LABEL, this.zzaUO);
        map.put("value", Long.valueOf(this.zzaDV));
        return zzF(map);
    }

    public String zzAZ() {
        return this.mCategory;
    }

    public void zzN(long j) {
        this.zzaDV = j;
    }

    @Override // com.google.android.gms.measurement.zze
    public void zza(zzpu zzpuVar) {
        if (!TextUtils.isEmpty(this.mCategory)) {
            zzpuVar.zzeE(this.mCategory);
        }
        if (!TextUtils.isEmpty(this.zzSU)) {
            zzpuVar.zzeF(this.zzSU);
        }
        if (!TextUtils.isEmpty(this.zzaUO)) {
            zzpuVar.zzeG(this.zzaUO);
        }
        if (this.zzaDV != 0) {
            zzpuVar.zzN(this.zzaDV);
        }
    }

    public void zzeE(String str) {
        this.mCategory = str;
    }

    public void zzeF(String str) {
        this.zzSU = str;
    }

    public void zzeG(String str) {
        this.zzaUO = str;
    }
}
