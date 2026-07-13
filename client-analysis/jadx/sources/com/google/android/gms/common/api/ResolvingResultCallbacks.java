package com.google.android.gms.common.api;

import android.app.Activity;
import android.content.IntentSender;
import android.support.annotation.NonNull;
import android.util.Log;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.zzx;

/* JADX INFO: loaded from: classes.dex */
public abstract class ResolvingResultCallbacks<R extends Result> extends ResultCallbacks<R> {
    private final Activity mActivity;
    private final int zzagz;

    protected ResolvingResultCallbacks(@NonNull Activity activity, int requestCode) {
        this.mActivity = (Activity) zzx.zzb(activity, "Activity must not be null");
        this.zzagz = requestCode;
    }

    @Override // com.google.android.gms.common.api.ResultCallbacks
    public final void onFailure(@NonNull Status result) {
        if (!result.hasResolution()) {
            onUnresolvableFailure(result);
            return;
        }
        try {
            result.startResolutionForResult(this.mActivity, this.zzagz);
        } catch (IntentSender.SendIntentException e) {
            Log.e("ResolvingResultCallback", "Failed to start resolution", e);
            onUnresolvableFailure(new Status(8));
        }
    }

    @Override // com.google.android.gms.common.api.ResultCallbacks
    public abstract void onSuccess(@NonNull R r);

    public abstract void onUnresolvableFailure(@NonNull Status status);
}
