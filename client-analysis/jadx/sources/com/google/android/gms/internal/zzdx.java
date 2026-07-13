package com.google.android.gms.internal;

import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
@zzhb
class zzdx {
    com.google.android.gms.ads.internal.client.zzw zzAq;
    zzgd zzAr;
    zzcf zzAs;
    com.google.android.gms.ads.internal.client.zzp zzAt;
    com.google.android.gms.ads.internal.reward.client.zzd zzAu;
    com.google.android.gms.ads.internal.client.zzq zzpK;

    private class zza extends com.google.android.gms.ads.internal.client.zzq.zza {
        com.google.android.gms.ads.internal.client.zzq zzAv;

        zza(com.google.android.gms.ads.internal.client.zzq zzqVar) {
            this.zzAv = zzqVar;
        }

        @Override // com.google.android.gms.ads.internal.client.zzq
        public void onAdClosed() throws RemoteException {
            this.zzAv.onAdClosed();
            com.google.android.gms.ads.internal.zzr.zzbN().zzee();
        }

        @Override // com.google.android.gms.ads.internal.client.zzq
        public void onAdFailedToLoad(int errorCode) throws RemoteException {
            this.zzAv.onAdFailedToLoad(errorCode);
        }

        @Override // com.google.android.gms.ads.internal.client.zzq
        public void onAdLeftApplication() throws RemoteException {
            this.zzAv.onAdLeftApplication();
        }

        @Override // com.google.android.gms.ads.internal.client.zzq
        public void onAdLoaded() throws RemoteException {
            this.zzAv.onAdLoaded();
        }

        @Override // com.google.android.gms.ads.internal.client.zzq
        public void onAdOpened() throws RemoteException {
            this.zzAv.onAdOpened();
        }
    }

    zzdx() {
    }

    void zzc(com.google.android.gms.ads.internal.zzk zzkVar) {
        if (this.zzpK != null) {
            zzkVar.zza(new zza(this.zzpK));
        }
        if (this.zzAq != null) {
            zzkVar.zza(this.zzAq);
        }
        if (this.zzAr != null) {
            zzkVar.zza(this.zzAr);
        }
        if (this.zzAs != null) {
            zzkVar.zza(this.zzAs);
        }
        if (this.zzAt != null) {
            zzkVar.zza(this.zzAt);
        }
        if (this.zzAu != null) {
            zzkVar.zza(this.zzAu);
        }
    }
}
