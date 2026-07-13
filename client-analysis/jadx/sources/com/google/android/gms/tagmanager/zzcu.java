package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.adjust.sdk.Constants;

/* JADX INFO: loaded from: classes.dex */
class zzcu extends zzct {
    private static final Object zzbkP = new Object();
    private static zzcu zzbla;
    private Handler handler;
    private Context zzbkQ;
    private zzau zzbkR;
    private volatile zzas zzbkS;
    private zzbl zzbkY;
    private int zzbkT = Constants.THIRTY_MINUTES;
    private boolean zzbkU = true;
    private boolean zzbkV = false;
    private boolean connected = true;
    private boolean zzbkW = true;
    private zzav zzbkX = new zzav() { // from class: com.google.android.gms.tagmanager.zzcu.1
        @Override // com.google.android.gms.tagmanager.zzav
        public void zzax(boolean z) {
            zzcu.this.zzd(z, zzcu.this.connected);
        }
    };
    private boolean zzbkZ = false;

    private zzcu() {
    }

    public static zzcu zzHo() {
        if (zzbla == null) {
            zzbla = new zzcu();
        }
        return zzbla;
    }

    private void zzHp() {
        this.zzbkY = new zzbl(this);
        this.zzbkY.zzba(this.zzbkQ);
    }

    private void zzHq() {
        this.handler = new Handler(this.zzbkQ.getMainLooper(), new Handler.Callback() { // from class: com.google.android.gms.tagmanager.zzcu.2
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message msg) {
                if (1 == msg.what && zzcu.zzbkP.equals(msg.obj)) {
                    zzcu.this.dispatch();
                    if (zzcu.this.zzbkT > 0 && !zzcu.this.zzbkZ) {
                        zzcu.this.handler.sendMessageDelayed(zzcu.this.handler.obtainMessage(1, zzcu.zzbkP), zzcu.this.zzbkT);
                    }
                }
                return true;
            }
        });
        if (this.zzbkT > 0) {
            this.handler.sendMessageDelayed(this.handler.obtainMessage(1, zzbkP), this.zzbkT);
        }
    }

    @Override // com.google.android.gms.tagmanager.zzct
    public synchronized void dispatch() {
        if (this.zzbkV) {
            this.zzbkS.zzj(new Runnable() { // from class: com.google.android.gms.tagmanager.zzcu.3
                @Override // java.lang.Runnable
                public void run() {
                    zzcu.this.zzbkR.dispatch();
                }
            });
        } else {
            zzbg.v("Dispatch call queued. Dispatch will run once initialization is complete.");
            this.zzbkU = true;
        }
    }

    synchronized zzau zzHr() {
        if (this.zzbkR == null) {
            if (this.zzbkQ == null) {
                throw new IllegalStateException("Cant get a store unless we have a context");
            }
            this.zzbkR = new zzby(this.zzbkX, this.zzbkQ);
        }
        if (this.handler == null) {
            zzHq();
        }
        this.zzbkV = true;
        if (this.zzbkU) {
            dispatch();
            this.zzbkU = false;
        }
        if (this.zzbkY == null && this.zzbkW) {
            zzHp();
        }
        return this.zzbkR;
    }

    synchronized void zza(Context context, zzas zzasVar) {
        if (this.zzbkQ == null) {
            this.zzbkQ = context.getApplicationContext();
            if (this.zzbkS == null) {
                this.zzbkS = zzasVar;
            }
        }
    }

    @Override // com.google.android.gms.tagmanager.zzct
    public synchronized void zzay(boolean z) {
        zzd(this.zzbkZ, z);
    }

    synchronized void zzd(boolean z, boolean z2) {
        if (this.zzbkZ != z || this.connected != z2) {
            if ((z || !z2) && this.zzbkT > 0) {
                this.handler.removeMessages(1, zzbkP);
            }
            if (!z && z2 && this.zzbkT > 0) {
                this.handler.sendMessageDelayed(this.handler.obtainMessage(1, zzbkP), this.zzbkT);
            }
            zzbg.v("PowerSaveMode " + ((z || !z2) ? "initiated." : "terminated."));
            this.zzbkZ = z;
            this.connected = z2;
        }
    }

    @Override // com.google.android.gms.tagmanager.zzct
    public synchronized void zzjg() {
        if (!this.zzbkZ && this.connected && this.zzbkT > 0) {
            this.handler.removeMessages(1, zzbkP);
            this.handler.sendMessage(this.handler.obtainMessage(1, zzbkP));
        }
    }
}
