package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.FusedLocationProviderApi;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

/* JADX INFO: loaded from: classes.dex */
public class zzd implements FusedLocationProviderApi {

    private static abstract class zza extends LocationServices.zza<Status> {
        public zza(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.internal.zzb
        /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
        public Status zzc(Status status) {
            return status;
        }
    }

    private static class zzb extends zzg.zza {
        private final com.google.android.gms.common.api.internal.zza.zzb<Status> zzamC;

        public zzb(com.google.android.gms.common.api.internal.zza.zzb<Status> zzbVar) {
            this.zzamC = zzbVar;
        }

        @Override // com.google.android.gms.location.internal.zzg
        public void zza(FusedLocationProviderResult fusedLocationProviderResult) {
            this.zzamC.zzs(fusedLocationProviderResult.getStatus());
        }
    }

    @Override // com.google.android.gms.location.FusedLocationProviderApi
    public PendingResult<Status> flushLocations(GoogleApiClient client) {
        return client.zzb(new zza(client) { // from class: com.google.android.gms.location.internal.zzd.5
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzl zzlVar) throws RemoteException {
                zzlVar.zza((zzg) new zzb(this));
            }
        });
    }

    @Override // com.google.android.gms.location.FusedLocationProviderApi
    public Location getLastLocation(GoogleApiClient client) {
        try {
            return LocationServices.zzi(client).getLastLocation();
        } catch (Exception e) {
            return null;
        }
    }

    @Override // com.google.android.gms.location.FusedLocationProviderApi
    public LocationAvailability getLocationAvailability(GoogleApiClient client) {
        try {
            return LocationServices.zzi(client).zzyO();
        } catch (Exception e) {
            return null;
        }
    }

    @Override // com.google.android.gms.location.FusedLocationProviderApi
    public PendingResult<Status> removeLocationUpdates(GoogleApiClient client, final PendingIntent callbackIntent) {
        return client.zzb(new zza(client) { // from class: com.google.android.gms.location.internal.zzd.10
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzl zzlVar) throws RemoteException {
                zzlVar.zza(callbackIntent, new zzb(this));
            }
        });
    }

    @Override // com.google.android.gms.location.FusedLocationProviderApi
    public PendingResult<Status> removeLocationUpdates(GoogleApiClient client, final LocationCallback callback) {
        return client.zzb(new zza(client) { // from class: com.google.android.gms.location.internal.zzd.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzl zzlVar) throws RemoteException {
                zzlVar.zza(callback, new zzb(this));
            }
        });
    }

    @Override // com.google.android.gms.location.FusedLocationProviderApi
    public PendingResult<Status> removeLocationUpdates(GoogleApiClient client, final LocationListener listener) {
        return client.zzb(new zza(client) { // from class: com.google.android.gms.location.internal.zzd.9
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzl zzlVar) throws RemoteException {
                zzlVar.zza(listener, new zzb(this));
            }
        });
    }

    @Override // com.google.android.gms.location.FusedLocationProviderApi
    public PendingResult<Status> requestLocationUpdates(GoogleApiClient client, final LocationRequest request, final PendingIntent callbackIntent) {
        return client.zzb(new zza(client) { // from class: com.google.android.gms.location.internal.zzd.8
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzl zzlVar) throws RemoteException {
                zzlVar.zza(request, callbackIntent, new zzb(this));
            }
        });
    }

    @Override // com.google.android.gms.location.FusedLocationProviderApi
    public PendingResult<Status> requestLocationUpdates(GoogleApiClient client, final LocationRequest request, final LocationCallback callback, final Looper looper) {
        return client.zzb(new zza(client) { // from class: com.google.android.gms.location.internal.zzd.7
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzl zzlVar) throws RemoteException {
                zzlVar.zza(LocationRequestInternal.zzb(request), callback, looper, new zzb(this));
            }
        });
    }

    @Override // com.google.android.gms.location.FusedLocationProviderApi
    public PendingResult<Status> requestLocationUpdates(GoogleApiClient client, final LocationRequest request, final LocationListener listener) {
        return client.zzb(new zza(client) { // from class: com.google.android.gms.location.internal.zzd.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzl zzlVar) throws RemoteException {
                zzlVar.zza(request, listener, (Looper) null, new zzb(this));
            }
        });
    }

    @Override // com.google.android.gms.location.FusedLocationProviderApi
    public PendingResult<Status> requestLocationUpdates(GoogleApiClient client, final LocationRequest request, final LocationListener listener, final Looper looper) {
        return client.zzb(new zza(client) { // from class: com.google.android.gms.location.internal.zzd.6
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzl zzlVar) throws RemoteException {
                zzlVar.zza(request, listener, looper, new zzb(this));
            }
        });
    }

    @Override // com.google.android.gms.location.FusedLocationProviderApi
    public PendingResult<Status> setMockLocation(GoogleApiClient client, final Location mockLocation) {
        return client.zzb(new zza(client) { // from class: com.google.android.gms.location.internal.zzd.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzl zzlVar) throws RemoteException {
                zzlVar.zzc(mockLocation);
                zza(Status.zzagC);
            }
        });
    }

    @Override // com.google.android.gms.location.FusedLocationProviderApi
    public PendingResult<Status> setMockMode(GoogleApiClient client, final boolean isMockMode) {
        return client.zzb(new zza(client) { // from class: com.google.android.gms.location.internal.zzd.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzl zzlVar) throws RemoteException {
                zzlVar.zzam(isMockMode);
                zza(Status.zzagC);
            }
        });
    }
}
