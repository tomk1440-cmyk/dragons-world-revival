package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: classes.dex */
public final class zzq<L> {
    private volatile L mListener;
    private final zzq<L>.zza zzaiw;

    private final class zza extends Handler {
        public zza(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            com.google.android.gms.common.internal.zzx.zzac(msg.what == 1);
            zzq.this.zzb((zzb) msg.obj);
        }
    }

    public interface zzb<L> {
        void zzpr();

        void zzt(L l);
    }

    zzq(Looper looper, L l) {
        this.zzaiw = new zza(looper);
        this.mListener = (L) com.google.android.gms.common.internal.zzx.zzb(l, "Listener must not be null");
    }

    public void clear() {
        this.mListener = null;
    }

    public void zza(zzb<? super L> zzbVar) {
        com.google.android.gms.common.internal.zzx.zzb(zzbVar, "Notifier must not be null");
        this.zzaiw.sendMessage(this.zzaiw.obtainMessage(1, zzbVar));
    }

    void zzb(zzb<? super L> zzbVar) {
        L l = this.mListener;
        if (l == null) {
            zzbVar.zzpr();
            return;
        }
        try {
            zzbVar.zzt(l);
        } catch (RuntimeException e) {
            zzbVar.zzpr();
            throw e;
        }
    }
}
