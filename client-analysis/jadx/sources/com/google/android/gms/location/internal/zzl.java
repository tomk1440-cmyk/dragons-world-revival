package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.LocationStatusCodes;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class zzl extends com.google.android.gms.location.internal.zzb {
    private final zzk zzaOM;

    private static final class zza extends zzh.zza {
        private com.google.android.gms.common.api.internal.zza.zzb<Status> zzaON;

        public zza(com.google.android.gms.common.api.internal.zza.zzb<Status> zzbVar) {
            this.zzaON = zzbVar;
        }

        @Override // com.google.android.gms.location.internal.zzh
        public void zza(int i, PendingIntent pendingIntent) {
            Log.wtf("LocationClientImpl", "Unexpected call to onRemoveGeofencesByPendingIntentResult");
        }

        @Override // com.google.android.gms.location.internal.zzh
        public void zza(int i, String[] strArr) {
            if (this.zzaON == null) {
                Log.wtf("LocationClientImpl", "onAddGeofenceResult called multiple times");
                return;
            }
            this.zzaON.zzs(LocationStatusCodes.zzhz(LocationStatusCodes.zzhy(i)));
            this.zzaON = null;
        }

        @Override // com.google.android.gms.location.internal.zzh
        public void zzb(int i, String[] strArr) {
            Log.wtf("LocationClientImpl", "Unexpected call to onRemoveGeofencesByRequestIdsResult");
        }
    }

    private static final class zzb extends zzh.zza {
        private com.google.android.gms.common.api.internal.zza.zzb<Status> zzaON;

        public zzb(com.google.android.gms.common.api.internal.zza.zzb<Status> zzbVar) {
            this.zzaON = zzbVar;
        }

        private void zzhC(int i) {
            if (this.zzaON == null) {
                Log.wtf("LocationClientImpl", "onRemoveGeofencesResult called multiple times");
                return;
            }
            this.zzaON.zzs(LocationStatusCodes.zzhz(LocationStatusCodes.zzhy(i)));
            this.zzaON = null;
        }

        @Override // com.google.android.gms.location.internal.zzh
        public void zza(int i, PendingIntent pendingIntent) {
            zzhC(i);
        }

        @Override // com.google.android.gms.location.internal.zzh
        public void zza(int i, String[] strArr) {
            Log.wtf("LocationClientImpl", "Unexpected call to onAddGeofencesResult");
        }

        @Override // com.google.android.gms.location.internal.zzh
        public void zzb(int i, String[] strArr) {
            zzhC(i);
        }
    }

    private static final class zzc extends zzj.zza {
        private com.google.android.gms.common.api.internal.zza.zzb<LocationSettingsResult> zzaON;

        public zzc(com.google.android.gms.common.api.internal.zza.zzb<LocationSettingsResult> zzbVar) {
            zzx.zzb(zzbVar != null, "listener can't be null.");
            this.zzaON = zzbVar;
        }

        @Override // com.google.android.gms.location.internal.zzj
        public void zza(LocationSettingsResult locationSettingsResult) throws RemoteException {
            this.zzaON.zzs(locationSettingsResult);
            this.zzaON = null;
        }
    }

    public zzl(Context context, Looper looper, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, String str) {
        this(context, looper, connectionCallbacks, onConnectionFailedListener, str, com.google.android.gms.common.internal.zzf.zzat(context));
    }

    public zzl(Context context, Looper looper, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, String str, com.google.android.gms.common.internal.zzf zzfVar) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, str, zzfVar);
        this.zzaOM = new zzk(context, this.zzaOt);
    }

    @Override // com.google.android.gms.common.internal.zzj, com.google.android.gms.common.api.Api.zzb
    public void disconnect() {
        synchronized (this.zzaOM) {
            if (isConnected()) {
                try {
                    this.zzaOM.removeAllListeners();
                    this.zzaOM.zzyP();
                } catch (Exception e) {
                    Log.e("LocationClientImpl", "Client disconnected before listeners could be cleaned up", e);
                }
                super.disconnect();
            } else {
                super.disconnect();
            }
            throw th;
        }
    }

    public Location getLastLocation() {
        return this.zzaOM.getLastLocation();
    }

    public void zza(long j, PendingIntent pendingIntent) throws RemoteException {
        zzqI();
        zzx.zzz(pendingIntent);
        zzx.zzb(j >= 0, "detectionIntervalMillis must be >= 0");
        zzqJ().zza(j, true, pendingIntent);
    }

    public void zza(PendingIntent pendingIntent) throws RemoteException {
        zzqI();
        zzx.zzz(pendingIntent);
        zzqJ().zza(pendingIntent);
    }

    public void zza(PendingIntent pendingIntent, com.google.android.gms.common.api.internal.zza.zzb<Status> zzbVar) throws RemoteException {
        zzqI();
        zzx.zzb(pendingIntent, "PendingIntent must be specified.");
        zzx.zzb(zzbVar, "ResultHolder not provided.");
        zzqJ().zza(pendingIntent, new zzb(zzbVar), getContext().getPackageName());
    }

    public void zza(PendingIntent pendingIntent, zzg zzgVar) throws RemoteException {
        this.zzaOM.zza(pendingIntent, zzgVar);
    }

    public void zza(GeofencingRequest geofencingRequest, PendingIntent pendingIntent, com.google.android.gms.common.api.internal.zza.zzb<Status> zzbVar) throws RemoteException {
        zzqI();
        zzx.zzb(geofencingRequest, "geofencingRequest can't be null.");
        zzx.zzb(pendingIntent, "PendingIntent must be specified.");
        zzx.zzb(zzbVar, "ResultHolder not provided.");
        zzqJ().zza(geofencingRequest, pendingIntent, new zza(zzbVar));
    }

    public void zza(LocationCallback locationCallback, zzg zzgVar) throws RemoteException {
        this.zzaOM.zza(locationCallback, zzgVar);
    }

    public void zza(LocationListener locationListener, zzg zzgVar) throws RemoteException {
        this.zzaOM.zza(locationListener, zzgVar);
    }

    public void zza(LocationRequest locationRequest, PendingIntent pendingIntent, zzg zzgVar) throws RemoteException {
        this.zzaOM.zza(locationRequest, pendingIntent, zzgVar);
    }

    public void zza(LocationRequest locationRequest, LocationListener locationListener, Looper looper, zzg zzgVar) throws RemoteException {
        synchronized (this.zzaOM) {
            this.zzaOM.zza(locationRequest, locationListener, looper, zzgVar);
        }
    }

    public void zza(LocationSettingsRequest locationSettingsRequest, com.google.android.gms.common.api.internal.zza.zzb<LocationSettingsResult> zzbVar, String str) throws RemoteException {
        zzqI();
        zzx.zzb(locationSettingsRequest != null, "locationSettingsRequest can't be null nor empty.");
        zzx.zzb(zzbVar != null, "listener can't be null.");
        zzqJ().zza(locationSettingsRequest, new zzc(zzbVar), str);
    }

    public void zza(LocationRequestInternal locationRequestInternal, LocationCallback locationCallback, Looper looper, zzg zzgVar) throws RemoteException {
        synchronized (this.zzaOM) {
            this.zzaOM.zza(locationRequestInternal, locationCallback, looper, zzgVar);
        }
    }

    public void zza(zzg zzgVar) throws RemoteException {
        this.zzaOM.zza(zzgVar);
    }

    public void zza(List<String> list, com.google.android.gms.common.api.internal.zza.zzb<Status> zzbVar) throws RemoteException {
        zzqI();
        zzx.zzb(list != null && list.size() > 0, "geofenceRequestIds can't be null nor empty.");
        zzx.zzb(zzbVar, "ResultHolder not provided.");
        zzqJ().zza((String[]) list.toArray(new String[0]), new zzb(zzbVar), getContext().getPackageName());
    }

    public void zzam(boolean z) throws RemoteException {
        this.zzaOM.zzam(z);
    }

    public void zzc(Location location) throws RemoteException {
        this.zzaOM.zzc(location);
    }

    public LocationAvailability zzyO() {
        return this.zzaOM.zzyO();
    }
}
