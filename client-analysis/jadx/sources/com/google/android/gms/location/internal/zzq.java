package com.google.android.gms.location.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.SettingsApi;

/* JADX INFO: loaded from: classes.dex */
public class zzq implements SettingsApi {
    @Override // com.google.android.gms.location.SettingsApi
    public PendingResult<LocationSettingsResult> checkLocationSettings(GoogleApiClient client, LocationSettingsRequest request) {
        return zza(client, request, null);
    }

    public PendingResult<LocationSettingsResult> zza(GoogleApiClient googleApiClient, final LocationSettingsRequest locationSettingsRequest, final String str) {
        return googleApiClient.zza(new LocationServices.zza<LocationSettingsResult>(googleApiClient) { // from class: com.google.android.gms.location.internal.zzq.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzl zzlVar) throws RemoteException {
                zzlVar.zza(locationSettingsRequest, this, str);
            }

            @Override // com.google.android.gms.common.api.internal.zzb
            /* JADX INFO: renamed from: zzaR, reason: merged with bridge method [inline-methods] */
            public LocationSettingsResult zzc(Status status) {
                return new LocationSettingsResult(status);
            }
        });
    }
}
