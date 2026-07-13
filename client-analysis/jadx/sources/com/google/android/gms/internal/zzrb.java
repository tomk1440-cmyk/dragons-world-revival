package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.safetynet.SafetyNet;

/* JADX INFO: loaded from: classes.dex */
abstract class zzrb<R extends Result> extends com.google.android.gms.common.api.internal.zza.AbstractC0049zza<R, zzrf> {
    public zzrb(GoogleApiClient googleApiClient) {
        super(SafetyNet.zzUI, googleApiClient);
    }
}
