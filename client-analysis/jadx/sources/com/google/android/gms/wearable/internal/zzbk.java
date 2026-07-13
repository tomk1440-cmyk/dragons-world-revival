package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.WearableStatusCodes;

/* JADX INFO: loaded from: classes.dex */
public final class zzbk {
    public static Status zzgc(int i) {
        return new Status(i, WearableStatusCodes.getStatusCodeString(i));
    }
}
