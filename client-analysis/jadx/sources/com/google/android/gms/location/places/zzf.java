package com.google.android.gms.location.places;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
public class zzf extends com.google.android.gms.location.places.internal.zzh.zza {
    private final zzb zzaPw;
    private final zza zzaPx;

    public static abstract class zza<A extends Api.zzb> extends zzl.zzb<PlacePhotoResult, A> {
        public zza(Api.zzc<A> zzcVar, GoogleApiClient googleApiClient) {
            super(zzcVar, googleApiClient);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zzb
        /* JADX INFO: renamed from: zzaS, reason: merged with bridge method [inline-methods] */
        public PlacePhotoResult zzc(Status status) {
            return new PlacePhotoResult(status, null);
        }
    }

    public static abstract class zzb<A extends Api.zzb> extends zzl.zzb<PlacePhotoMetadataResult, A> {
        public zzb(Api.zzc<A> zzcVar, GoogleApiClient googleApiClient) {
            super(zzcVar, googleApiClient);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zzb
        /* JADX INFO: renamed from: zzaT, reason: merged with bridge method [inline-methods] */
        public PlacePhotoMetadataResult zzc(Status status) {
            return new PlacePhotoMetadataResult(status, null);
        }
    }

    public zzf(zza zzaVar) {
        this.zzaPw = null;
        this.zzaPx = zzaVar;
    }

    public zzf(zzb zzbVar) {
        this.zzaPw = zzbVar;
        this.zzaPx = null;
    }

    @Override // com.google.android.gms.location.places.internal.zzh
    public void zza(PlacePhotoMetadataResult placePhotoMetadataResult) throws RemoteException {
        this.zzaPw.zza(placePhotoMetadataResult);
    }

    @Override // com.google.android.gms.location.places.internal.zzh
    public void zza(PlacePhotoResult placePhotoResult) throws RemoteException {
        this.zzaPx.zza(placePhotoResult);
    }
}
