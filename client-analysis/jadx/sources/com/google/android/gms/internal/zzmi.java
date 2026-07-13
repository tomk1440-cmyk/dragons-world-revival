package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
abstract class zzmi<R extends Result> extends com.google.android.gms.common.api.internal.zza.AbstractC0049zza<R, zzmj> {

    static abstract class zza extends zzmi<Status> {
        public zza(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.internal.zzb
        /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
        public Status zzc(Status status) {
            return status;
        }
    }

    public zzmi(GoogleApiClient googleApiClient) {
        super(zzmf.zzUI, googleApiClient);
    }
}
