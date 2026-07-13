package com.google.android.gms.location.places.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.PlaceDetectionApi;
import com.google.android.gms.location.places.PlaceFilter;
import com.google.android.gms.location.places.PlaceLikelihoodBuffer;
import com.google.android.gms.location.places.PlaceReport;
import com.google.android.gms.location.places.Places;

/* JADX INFO: loaded from: classes.dex */
public class zzj implements PlaceDetectionApi {
    @Override // com.google.android.gms.location.places.PlaceDetectionApi
    public PendingResult<PlaceLikelihoodBuffer> getCurrentPlace(GoogleApiClient client, final PlaceFilter filter) {
        return client.zza(new com.google.android.gms.location.places.zzl.zzd<zzk>(Places.zzaPO, client) { // from class: com.google.android.gms.location.places.internal.zzj.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzk zzkVar) throws RemoteException {
                zzkVar.zza(new com.google.android.gms.location.places.zzl(this, zzkVar.getContext()), filter);
            }
        });
    }

    @Override // com.google.android.gms.location.places.PlaceDetectionApi
    public PendingResult<Status> reportDeviceAtPlace(GoogleApiClient client, final PlaceReport report) {
        return client.zzb(new com.google.android.gms.location.places.zzl.zzf<zzk>(Places.zzaPO, client) { // from class: com.google.android.gms.location.places.internal.zzj.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzk zzkVar) throws RemoteException {
                zzkVar.zza(new com.google.android.gms.location.places.zzl(this), report);
            }
        });
    }
}
