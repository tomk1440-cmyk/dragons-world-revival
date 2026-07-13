package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzbn implements zzbo {
    @Override // com.google.android.gms.internal.zzbo
    public List<String> zza(AdRequestInfoParcel adRequestInfoParcel) {
        return adRequestInfoParcel.zzHJ == null ? Collections.emptyList() : adRequestInfoParcel.zzHJ;
    }
}
