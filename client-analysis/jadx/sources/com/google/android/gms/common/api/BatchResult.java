package com.google.android.gms.common.api;

import com.google.android.gms.common.internal.zzx;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class BatchResult implements Result {
    private final Status zzUX;
    private final PendingResult<?>[] zzagc;

    BatchResult(Status status, PendingResult<?>[] pendingResults) {
        this.zzUX = status;
        this.zzagc = pendingResults;
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.zzUX;
    }

    public <R extends Result> R take(BatchResultToken<R> batchResultToken) {
        zzx.zzb(batchResultToken.mId < this.zzagc.length, "The result token does not belong to this batch");
        return (R) this.zzagc[batchResultToken.mId].await(0L, TimeUnit.MILLISECONDS);
    }
}
