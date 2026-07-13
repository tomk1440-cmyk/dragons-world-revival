package com.google.android.gms.location.places.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.places.AddPlaceRequest;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.PlacesOptions;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class zze extends com.google.android.gms.common.internal.zzj<zzg> {
    private final PlacesParams zzaQq;
    private final Locale zzaQr;

    public static class zza extends Api.zza<zze, PlacesOptions> {
        private final String zzaQs;

        public zza(String str) {
            this.zzaQs = str;
        }

        @Override // com.google.android.gms.common.api.Api.zza
        public zze zza(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, PlacesOptions placesOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zze(context, looper, zzfVar, connectionCallbacks, onConnectionFailedListener, this.zzaQs != null ? this.zzaQs : context.getPackageName(), placesOptions == null ? new PlacesOptions.Builder().build() : placesOptions);
        }
    }

    public zze(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, String str, PlacesOptions placesOptions) {
        super(context, looper, 65, zzfVar, connectionCallbacks, onConnectionFailedListener);
        this.zzaQr = Locale.getDefault();
        this.zzaQq = new PlacesParams(str, this.zzaQr, zzfVar.getAccount() != null ? zzfVar.getAccount().name : null, placesOptions.zzaPU, placesOptions.zzaPV);
    }

    public void zza(com.google.android.gms.location.places.zzf zzfVar, String str) throws RemoteException {
        zzx.zzb(str, "placeId cannot be null");
        zzqJ().zza(str, this.zzaQq, zzfVar);
    }

    public void zza(com.google.android.gms.location.places.zzf zzfVar, String str, int i, int i2, int i3) throws RemoteException {
        zzx.zzb(str, "fifeUrl cannot be null");
        zzx.zzb(i > 0, "width should be > 0");
        zzx.zzb(i > 0, "height should be > 0");
        zzqJ().zza(str, i, i2, i3, this.zzaQq, zzfVar);
    }

    public void zza(com.google.android.gms.location.places.zzl zzlVar, AddPlaceRequest addPlaceRequest) throws RemoteException {
        zzx.zzb(addPlaceRequest, "userAddedPlace == null");
        zzqJ().zza(addPlaceRequest, this.zzaQq, zzlVar);
    }

    public void zza(com.google.android.gms.location.places.zzl zzlVar, String str, @Nullable LatLngBounds latLngBounds, @Nullable AutocompleteFilter autocompleteFilter) throws RemoteException {
        zzx.zzb(zzlVar, "callback == null");
        zzqJ().zza(str == null ? "" : str, latLngBounds, autocompleteFilter == null ? AutocompleteFilter.create(null) : autocompleteFilter, this.zzaQq, zzlVar);
    }

    public void zza(com.google.android.gms.location.places.zzl zzlVar, List<String> list) throws RemoteException {
        zzqJ().zzb(list, this.zzaQq, zzlVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzj
    /* JADX INFO: renamed from: zzcl, reason: merged with bridge method [inline-methods] */
    public zzg zzW(IBinder iBinder) {
        return zzg.zza.zzcn(iBinder);
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzgu() {
        return "com.google.android.gms.location.places.GeoDataApi";
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzgv() {
        return "com.google.android.gms.location.places.internal.IGooglePlacesService";
    }
}
