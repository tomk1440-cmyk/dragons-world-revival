package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.api.internal.zzr;
import com.google.android.gms.common.api.internal.zzv;
import com.google.android.gms.common.internal.zzx;

/* JADX INFO: loaded from: classes.dex */
public final class PendingResults {

    private static final class zza<R extends Result> extends com.google.android.gms.common.api.internal.zzb<R> {
        private final R zzagx;

        public zza(R r) {
            super(Looper.getMainLooper());
            this.zzagx = r;
        }

        @Override // com.google.android.gms.common.api.internal.zzb
        protected R zzc(Status status) {
            if (status.getStatusCode() != this.zzagx.getStatus().getStatusCode()) {
                throw new UnsupportedOperationException("Creating failed results is not supported");
            }
            return this.zzagx;
        }
    }

    private static final class zzb<R extends Result> extends com.google.android.gms.common.api.internal.zzb<R> {
        private final R zzagy;

        public zzb(GoogleApiClient googleApiClient, R r) {
            super(googleApiClient);
            this.zzagy = r;
        }

        @Override // com.google.android.gms.common.api.internal.zzb
        protected R zzc(Status status) {
            return this.zzagy;
        }
    }

    private static final class zzc<R extends Result> extends com.google.android.gms.common.api.internal.zzb<R> {
        public zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.internal.zzb
        protected R zzc(Status status) {
            throw new UnsupportedOperationException("Creating failed results is not supported");
        }
    }

    private PendingResults() {
    }

    public static PendingResult<Status> canceledPendingResult() {
        zzv zzvVar = new zzv(Looper.getMainLooper());
        zzvVar.cancel();
        return zzvVar;
    }

    public static <R extends Result> PendingResult<R> canceledPendingResult(R result) {
        zzx.zzb(result, "Result must not be null");
        zzx.zzb(result.getStatus().getStatusCode() == 16, "Status code must be CommonStatusCodes.CANCELED");
        zza zzaVar = new zza(result);
        zzaVar.cancel();
        return zzaVar;
    }

    public static <R extends Result> OptionalPendingResult<R> immediatePendingResult(R result) {
        zzx.zzb(result, "Result must not be null");
        zzc zzcVar = new zzc(null);
        zzcVar.zza(result);
        return new zzr(zzcVar);
    }

    public static PendingResult<Status> immediatePendingResult(Status result) {
        zzx.zzb(result, "Result must not be null");
        zzv zzvVar = new zzv(Looper.getMainLooper());
        zzvVar.zza(result);
        return zzvVar;
    }

    public static <R extends Result> PendingResult<R> zza(R r, GoogleApiClient googleApiClient) {
        zzx.zzb(r, "Result must not be null");
        zzx.zzb(!r.getStatus().isSuccess(), "Status code must not be SUCCESS");
        zzb zzbVar = new zzb(googleApiClient, r);
        zzbVar.zza(r);
        return zzbVar;
    }

    public static PendingResult<Status> zza(Status status, GoogleApiClient googleApiClient) {
        zzx.zzb(status, "Result must not be null");
        zzv zzvVar = new zzv(googleApiClient);
        zzvVar.zza(status);
        return zzvVar;
    }

    public static <R extends Result> OptionalPendingResult<R> zzb(R r, GoogleApiClient googleApiClient) {
        zzx.zzb(r, "Result must not be null");
        zzc zzcVar = new zzc(googleApiClient);
        zzcVar.zza(r);
        return new zzr(zzcVar);
    }
}
