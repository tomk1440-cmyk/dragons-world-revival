package com.google.android.gms.internal;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public final class zzeq extends zzez.zza {
    private zzes.zza zzCb;
    private zzep zzCc;
    private final Object zzpV = new Object();

    @Override // com.google.android.gms.internal.zzez
    public void onAdClicked() {
        synchronized (this.zzpV) {
            if (this.zzCc != null) {
                this.zzCc.zzaY();
            }
        }
    }

    @Override // com.google.android.gms.internal.zzez
    public void onAdClosed() {
        synchronized (this.zzpV) {
            if (this.zzCc != null) {
                this.zzCc.zzaZ();
            }
        }
    }

    @Override // com.google.android.gms.internal.zzez
    public void onAdFailedToLoad(int error) {
        synchronized (this.zzpV) {
            if (this.zzCb != null) {
                this.zzCb.zzr(error == 3 ? 1 : 2);
                this.zzCb = null;
            }
        }
    }

    @Override // com.google.android.gms.internal.zzez
    public void onAdLeftApplication() {
        synchronized (this.zzpV) {
            if (this.zzCc != null) {
                this.zzCc.zzba();
            }
        }
    }

    @Override // com.google.android.gms.internal.zzez
    public void onAdLoaded() {
        synchronized (this.zzpV) {
            if (this.zzCb != null) {
                this.zzCb.zzr(0);
                this.zzCb = null;
            } else {
                if (this.zzCc != null) {
                    this.zzCc.zzbc();
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.zzez
    public void onAdOpened() {
        synchronized (this.zzpV) {
            if (this.zzCc != null) {
                this.zzCc.zzbb();
            }
        }
    }

    public void zza(zzep zzepVar) {
        synchronized (this.zzpV) {
            this.zzCc = zzepVar;
        }
    }

    public void zza(zzes.zza zzaVar) {
        synchronized (this.zzpV) {
            this.zzCb = zzaVar;
        }
    }

    @Override // com.google.android.gms.internal.zzez
    public void zza(zzfa zzfaVar) {
        synchronized (this.zzpV) {
            if (this.zzCb != null) {
                this.zzCb.zza(0, zzfaVar);
                this.zzCb = null;
            } else {
                if (this.zzCc != null) {
                    this.zzCc.zzbc();
                }
            }
        }
    }
}
