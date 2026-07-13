package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
public final class zzmh implements zzmg {

    private static class zza extends zzme {
        private final com.google.android.gms.common.api.internal.zza.zzb<Status> zzamC;

        public zza(com.google.android.gms.common.api.internal.zza.zzb<Status> zzbVar) {
            this.zzamC = zzbVar;
        }

        @Override // com.google.android.gms.internal.zzme, com.google.android.gms.internal.zzmk
        public void zzcb(int i) throws RemoteException {
            this.zzamC.zzs(new Status(i));
        }
    }

    @Override // com.google.android.gms.internal.zzmg
    public PendingResult<Status> zzf(GoogleApiClient googleApiClient) {
        return googleApiClient.zzb(new zzmi.zza(googleApiClient) { // from class: com.google.android.gms.internal.zzmh.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzmj zzmjVar) throws RemoteException {
                zzmjVar.zzqJ().zza(new zza(this));
            }
        });
    }
}
