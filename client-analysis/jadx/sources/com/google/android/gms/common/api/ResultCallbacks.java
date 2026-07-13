package com.google.android.gms.common.api;

import android.support.annotation.NonNull;
import com.google.android.gms.common.api.Result;

/* JADX INFO: loaded from: classes.dex */
public abstract class ResultCallbacks<R extends Result> implements ResultCallback<R> {
    public abstract void onFailure(@NonNull Status status);

    @Override // com.google.android.gms.common.api.ResultCallback
    public final void onResult(@NonNull R result) {
        Status status = result.getStatus();
        if (status.isSuccess()) {
            onSuccess(result);
        } else {
            onFailure(status);
            com.google.android.gms.common.api.internal.zzb.zzc(result);
        }
    }

    public abstract void onSuccess(@NonNull R r);
}
