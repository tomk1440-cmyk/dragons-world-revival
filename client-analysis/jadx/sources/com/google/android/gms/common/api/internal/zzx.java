package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultCallbacks;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class zzx<R extends Result> extends TransformedResult<R> implements ResultCallback<R> {
    private final WeakReference<GoogleApiClient> zzagK;
    private final zzx<R>.zza zzaiS;
    private ResultTransform<? super R, ? extends Result> zzaiN = null;
    private zzx<? extends Result> zzaiO = null;
    private ResultCallbacks<? super R> zzaiP = null;
    private PendingResult<R> zzaiQ = null;
    private final Object zzagI = new Object();
    private Status zzaiR = null;

    private final class zza extends Handler {
        public zza(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    PendingResult<?> pendingResult = (PendingResult) msg.obj;
                    synchronized (zzx.this.zzagI) {
                        try {
                            if (pendingResult == null) {
                                zzx.this.zzaiO.zzy(new Status(13, "Transform returned null"));
                            } else if (pendingResult instanceof zzt) {
                                zzx.this.zzaiO.zzy(((zzt) pendingResult).getStatus());
                            } else {
                                zzx.this.zzaiO.zza(pendingResult);
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                        break;
                    }
                    return;
                case 1:
                    RuntimeException runtimeException = (RuntimeException) msg.obj;
                    Log.e("TransformedResultImpl", "Runtime exception on the transformation worker thread: " + runtimeException.getMessage());
                    throw runtimeException;
                default:
                    Log.e("TransformedResultImpl", "TransformationResultHandler received unknown message type: " + msg.what);
                    return;
            }
        }
    }

    public zzx(WeakReference<GoogleApiClient> weakReference) {
        com.google.android.gms.common.internal.zzx.zzb(weakReference, "GoogleApiClient reference must not be null");
        this.zzagK = weakReference;
        GoogleApiClient googleApiClient = this.zzagK.get();
        this.zzaiS = new zza(googleApiClient != null ? googleApiClient.getLooper() : Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzc(Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).release();
            } catch (RuntimeException e) {
                Log.w("TransformedResultImpl", "Unable to release " + result, e);
            }
        }
    }

    private void zzpT() {
        if (this.zzaiN == null && this.zzaiP == null) {
            return;
        }
        GoogleApiClient googleApiClient = this.zzagK.get();
        if (this.zzaiN != null && googleApiClient != null) {
            googleApiClient.zza(this);
        }
        if (this.zzaiR != null) {
            zzz(this.zzaiR);
        } else if (this.zzaiQ != null) {
            this.zzaiQ.setResultCallback(this);
        }
    }

    private boolean zzpV() {
        return (this.zzaiP == null || this.zzagK.get() == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzy(Status status) {
        synchronized (this.zzagI) {
            this.zzaiR = status;
            zzz(this.zzaiR);
        }
    }

    private void zzz(Status status) {
        synchronized (this.zzagI) {
            if (this.zzaiN != null) {
                Status statusOnFailure = this.zzaiN.onFailure(status);
                com.google.android.gms.common.internal.zzx.zzb(statusOnFailure, "onFailure must not return null");
                this.zzaiO.zzy(statusOnFailure);
            } else if (zzpV()) {
                this.zzaiP.onFailure(status);
            }
        }
    }

    @Override // com.google.android.gms.common.api.TransformedResult
    public void andFinally(@NonNull ResultCallbacks<? super R> callbacks) {
        synchronized (this.zzagI) {
            com.google.android.gms.common.internal.zzx.zza(this.zzaiP == null, "Cannot call andFinally() twice.");
            com.google.android.gms.common.internal.zzx.zza(this.zzaiN == null, "Cannot call then() and andFinally() on the same TransformedResult.");
            this.zzaiP = callbacks;
            zzpT();
        }
    }

    @Override // com.google.android.gms.common.api.ResultCallback
    public void onResult(final R result) {
        synchronized (this.zzagI) {
            if (!result.getStatus().isSuccess()) {
                zzy(result.getStatus());
                zzc(result);
            } else if (this.zzaiN != null) {
                zzs.zzpN().submit(new Runnable() { // from class: com.google.android.gms.common.api.internal.zzx.1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.lang.Runnable
                    @WorkerThread
                    public void run() {
                        try {
                            zzx.this.zzaiS.sendMessage(zzx.this.zzaiS.obtainMessage(0, zzx.this.zzaiN.onSuccess(result)));
                        } catch (RuntimeException e) {
                            zzx.this.zzaiS.sendMessage(zzx.this.zzaiS.obtainMessage(1, e));
                        } finally {
                            zzx.this.zzc(result);
                            GoogleApiClient googleApiClient = (GoogleApiClient) zzx.this.zzagK.get();
                            if (googleApiClient != null) {
                                googleApiClient.zzb(zzx.this);
                            }
                        }
                    }
                });
            } else if (zzpV()) {
                this.zzaiP.onSuccess(result);
            }
        }
    }

    @Override // com.google.android.gms.common.api.TransformedResult
    @NonNull
    public <S extends Result> TransformedResult<S> then(@NonNull ResultTransform<? super R, ? extends S> transform) {
        zzx<? extends Result> zzxVar;
        synchronized (this.zzagI) {
            com.google.android.gms.common.internal.zzx.zza(this.zzaiN == null, "Cannot call then() twice.");
            com.google.android.gms.common.internal.zzx.zza(this.zzaiP == null, "Cannot call then() and andFinally() on the same TransformedResult.");
            this.zzaiN = transform;
            zzxVar = new zzx<>(this.zzagK);
            this.zzaiO = zzxVar;
            zzpT();
        }
        return zzxVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void zza(PendingResult<?> pendingResult) {
        synchronized (this.zzagI) {
            this.zzaiQ = pendingResult;
            zzpT();
        }
    }

    void zzpU() {
        synchronized (this.zzagI) {
            this.zzaiP = null;
        }
    }
}
