package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.MainThread;
import android.support.annotation.WorkerThread;

/* JADX INFO: loaded from: classes.dex */
class zzr extends BroadcastReceiver {
    static final String zzSZ = zzr.class.getName();
    private boolean zzTa;
    private boolean zzTb;
    private final zzw zzaTV;

    zzr(zzw zzwVar) {
        com.google.android.gms.common.internal.zzx.zzz(zzwVar);
        this.zzaTV = zzwVar;
    }

    private Context getContext() {
        return this.zzaTV.getContext();
    }

    private zzp zzAo() {
        return this.zzaTV.zzAo();
    }

    @WorkerThread
    public boolean isRegistered() {
        this.zzaTV.zzjk();
        return this.zzTa;
    }

    @Override // android.content.BroadcastReceiver
    @MainThread
    public void onReceive(Context context, Intent intent) {
        this.zzaTV.zzjv();
        String action = intent.getAction();
        zzAo().zzCK().zzj("NetworkBroadcastReceiver received action", action);
        if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            zzAo().zzCF().zzj("NetworkBroadcastReceiver received unknown action", action);
            return;
        }
        final boolean zZzlB = this.zzaTV.zzCW().zzlB();
        if (this.zzTb != zZzlB) {
            this.zzTb = zZzlB;
            this.zzaTV.zzCn().zzg(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzr.1
                @Override // java.lang.Runnable
                public void run() {
                    zzr.this.zzaTV.zzJ(zZzlB);
                }
            });
        }
    }

    @WorkerThread
    public void unregister() {
        this.zzaTV.zzjv();
        this.zzaTV.zzjk();
        if (isRegistered()) {
            zzAo().zzCK().zzfg("Unregistering connectivity change receiver");
            this.zzTa = false;
            this.zzTb = false;
            try {
                getContext().unregisterReceiver(this);
            } catch (IllegalArgumentException e) {
                zzAo().zzCE().zzj("Failed to unregister the network broadcast receiver", e);
            }
        }
    }

    @WorkerThread
    public void zzly() {
        this.zzaTV.zzjv();
        this.zzaTV.zzjk();
        if (this.zzTa) {
            return;
        }
        getContext().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        this.zzTb = this.zzaTV.zzCW().zzlB();
        zzAo().zzCK().zzj("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.zzTb));
        this.zzTa = true;
    }
}
