package com.google.android.gms.location.places;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzng;

/* JADX INFO: loaded from: classes.dex */
public class zzl extends com.google.android.gms.location.places.internal.zzi.zza {
    private static final String TAG = zzl.class.getSimpleName();
    private final Context mContext;
    private final zzd zzaPP;
    private final zza zzaPQ;
    private final zze zzaPR;
    private final zzf zzaPS;
    private final zzc zzaPT;

    public static abstract class zza<A extends Api.zzb> extends zzb<AutocompletePredictionBuffer, A> {
        public zza(Api.zzc<A> zzcVar, GoogleApiClient googleApiClient) {
            super(zzcVar, googleApiClient);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zzb
        /* JADX INFO: renamed from: zzaV, reason: merged with bridge method [inline-methods] */
        public AutocompletePredictionBuffer zzc(Status status) {
            return new AutocompletePredictionBuffer(DataHolder.zzbI(status.getStatusCode()));
        }
    }

    public static abstract class zzb<R extends Result, A extends Api.zzb> extends com.google.android.gms.common.api.internal.zza.AbstractC0049zza<R, A> {
        public zzb(Api.zzc<A> zzcVar, GoogleApiClient googleApiClient) {
            super(zzcVar, googleApiClient);
        }
    }

    public static abstract class zzc<A extends Api.zzb> extends zzb<PlaceBuffer, A> {
        public zzc(Api.zzc<A> zzcVar, GoogleApiClient googleApiClient) {
            super(zzcVar, googleApiClient);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zzb
        /* JADX INFO: renamed from: zzaW, reason: merged with bridge method [inline-methods] */
        public PlaceBuffer zzc(Status status) {
            return new PlaceBuffer(DataHolder.zzbI(status.getStatusCode()), null);
        }
    }

    public static abstract class zzd<A extends Api.zzb> extends zzb<PlaceLikelihoodBuffer, A> {
        public zzd(Api.zzc<A> zzcVar, GoogleApiClient googleApiClient) {
            super(zzcVar, googleApiClient);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zzb
        /* JADX INFO: renamed from: zzaX, reason: merged with bridge method [inline-methods] */
        public PlaceLikelihoodBuffer zzc(Status status) {
            return new PlaceLikelihoodBuffer(DataHolder.zzbI(status.getStatusCode()), 100, null);
        }
    }

    public static abstract class zze<A extends Api.zzb> extends zzb<com.google.android.gms.location.places.personalized.zzd, A> {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zzb
        /* JADX INFO: renamed from: zzaY, reason: merged with bridge method [inline-methods] */
        public com.google.android.gms.location.places.personalized.zzd zzc(Status status) {
            return com.google.android.gms.location.places.personalized.zzd.zzaZ(status);
        }
    }

    public static abstract class zzf<A extends Api.zzb> extends zzb<Status, A> {
        public zzf(Api.zzc<A> zzcVar, GoogleApiClient googleApiClient) {
            super(zzcVar, googleApiClient);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zzb
        /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
        public Status zzc(Status status) {
            return status;
        }
    }

    public zzl(zza zzaVar) {
        this.zzaPP = null;
        this.zzaPQ = zzaVar;
        this.zzaPR = null;
        this.zzaPS = null;
        this.zzaPT = null;
        this.mContext = null;
    }

    public zzl(zzc zzcVar, Context context) {
        this.zzaPP = null;
        this.zzaPQ = null;
        this.zzaPR = null;
        this.zzaPS = null;
        this.zzaPT = zzcVar;
        this.mContext = context.getApplicationContext();
    }

    public zzl(zzd zzdVar, Context context) {
        this.zzaPP = zzdVar;
        this.zzaPQ = null;
        this.zzaPR = null;
        this.zzaPS = null;
        this.zzaPT = null;
        this.mContext = context.getApplicationContext();
    }

    public zzl(zzf zzfVar) {
        this.zzaPP = null;
        this.zzaPQ = null;
        this.zzaPR = null;
        this.zzaPS = zzfVar;
        this.zzaPT = null;
        this.mContext = null;
    }

    @Override // com.google.android.gms.location.places.internal.zzi
    public void zzaU(Status status) throws RemoteException {
        this.zzaPS.zza(status);
    }

    @Override // com.google.android.gms.location.places.internal.zzi
    public void zzac(DataHolder dataHolder) throws RemoteException {
        zzx.zza(this.zzaPP != null, "placeEstimator cannot be null");
        if (dataHolder != null) {
            Bundle bundleZzpZ = dataHolder.zzpZ();
            this.zzaPP.zza(new PlaceLikelihoodBuffer(dataHolder, bundleZzpZ == null ? 100 : PlaceLikelihoodBuffer.zzH(bundleZzpZ), this.mContext));
        } else {
            if (Log.isLoggable(TAG, 6)) {
                Log.e(TAG, "onPlaceEstimated received null DataHolder: " + zzng.zzso());
            }
            this.zzaPP.zzw(Status.zzagE);
        }
    }

    @Override // com.google.android.gms.location.places.internal.zzi
    public void zzad(DataHolder dataHolder) throws RemoteException {
        if (dataHolder != null) {
            this.zzaPQ.zza(new AutocompletePredictionBuffer(dataHolder));
            return;
        }
        if (Log.isLoggable(TAG, 6)) {
            Log.e(TAG, "onAutocompletePrediction received null DataHolder: " + zzng.zzso());
        }
        this.zzaPQ.zzw(Status.zzagE);
    }

    @Override // com.google.android.gms.location.places.internal.zzi
    public void zzae(DataHolder dataHolder) throws RemoteException {
        if (dataHolder != null) {
            this.zzaPR.zza(new com.google.android.gms.location.places.personalized.zzd(dataHolder));
            return;
        }
        if (Log.isLoggable(TAG, 6)) {
            Log.e(TAG, "onPlaceUserDataFetched received null DataHolder: " + zzng.zzso());
        }
        this.zzaPR.zzw(Status.zzagE);
    }

    @Override // com.google.android.gms.location.places.internal.zzi
    public void zzaf(DataHolder dataHolder) throws RemoteException {
        this.zzaPT.zza(new PlaceBuffer(dataHolder, this.mContext));
    }
}
