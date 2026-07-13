package com.google.android.gms.drive.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Drive;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzt<R extends Result> extends com.google.android.gms.common.api.internal.zza.AbstractC0049zza<R, zzu> {

    public static abstract class zza extends zzt<Status> {
        public zza(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zzb
        /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
        public Status zzc(Status status) {
            return status;
        }
    }

    public zzt(GoogleApiClient googleApiClient) {
        super(Drive.zzUI, googleApiClient);
    }
}
