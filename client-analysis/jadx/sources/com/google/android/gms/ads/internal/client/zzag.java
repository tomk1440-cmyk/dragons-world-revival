package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.internal.zzcr;
import com.google.android.gms.internal.zzcs;
import com.google.android.gms.internal.zzct;
import com.google.android.gms.internal.zzcu;

/* JADX INFO: loaded from: classes.dex */
public class zzag extends zzs.zza {
    private zzq zzpK;

    private class zza extends zzr.zza {
        private zza() {
        }

        @Override // com.google.android.gms.ads.internal.client.zzr
        public String getMediationAdapterClassName() throws RemoteException {
            return null;
        }

        @Override // com.google.android.gms.ads.internal.client.zzr
        public boolean isLoading() throws RemoteException {
            return false;
        }

        @Override // com.google.android.gms.ads.internal.client.zzr
        public void zzf(AdRequestParcel adRequestParcel) throws RemoteException {
            com.google.android.gms.ads.internal.util.client.zzb.e("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
            com.google.android.gms.ads.internal.util.client.zza.zzMS.post(new Runnable() { // from class: com.google.android.gms.ads.internal.client.zzag.zza.1
                @Override // java.lang.Runnable
                public void run() {
                    if (zzag.this.zzpK != null) {
                        try {
                            zzag.this.zzpK.onAdFailedToLoad(1);
                        } catch (RemoteException e) {
                            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not notify onAdFailedToLoad event.", e);
                        }
                    }
                }
            });
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzs
    public void zza(NativeAdOptionsParcel nativeAdOptionsParcel) throws RemoteException {
    }

    @Override // com.google.android.gms.ads.internal.client.zzs
    public void zza(zzcr zzcrVar) throws RemoteException {
    }

    @Override // com.google.android.gms.ads.internal.client.zzs
    public void zza(zzcs zzcsVar) throws RemoteException {
    }

    @Override // com.google.android.gms.ads.internal.client.zzs
    public void zza(String str, zzcu zzcuVar, zzct zzctVar) throws RemoteException {
    }

    @Override // com.google.android.gms.ads.internal.client.zzs
    public void zzb(zzq zzqVar) throws RemoteException {
        this.zzpK = zzqVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzs
    public void zzb(zzx zzxVar) throws RemoteException {
    }

    @Override // com.google.android.gms.ads.internal.client.zzs
    public zzr zzbn() throws RemoteException {
        return new zza();
    }
}
