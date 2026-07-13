package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.panorama.Panorama;
import com.google.android.gms.panorama.PanoramaApi;

/* JADX INFO: loaded from: classes.dex */
public class zzqq implements PanoramaApi {

    private static abstract class zza extends zzc<PanoramaApi.PanoramaResult> {
        public zza(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zzb
        /* JADX INFO: renamed from: zzbd, reason: merged with bridge method [inline-methods] */
        public PanoramaApi.PanoramaResult zzc(Status status) {
            return new zzqs(status, null);
        }
    }

    private static final class zzb extends zzqo.zza {
        private final com.google.android.gms.common.api.internal.zza.zzb<PanoramaApi.PanoramaResult> zzamC;

        public zzb(com.google.android.gms.common.api.internal.zza.zzb<PanoramaApi.PanoramaResult> zzbVar) {
            this.zzamC = zzbVar;
        }

        @Override // com.google.android.gms.internal.zzqo
        public void zza(int i, Bundle bundle, int i2, Intent intent) {
            this.zzamC.zzs(new zzqs(new Status(i, null, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null), intent));
        }
    }

    private static abstract class zzc<R extends Result> extends com.google.android.gms.common.api.internal.zza.AbstractC0049zza<R, zzqr> {
        protected zzc(GoogleApiClient googleApiClient) {
            super(Panorama.zzUI, googleApiClient);
        }

        protected abstract void zza(Context context, zzqp zzqpVar) throws RemoteException;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
        public final void zza(zzqr zzqrVar) throws RemoteException {
            zza(zzqrVar.getContext(), zzqrVar.zzqJ());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zza(Context context, Uri uri) {
        context.revokeUriPermission(uri, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zza(final Context context, zzqp zzqpVar, final zzqo zzqoVar, final Uri uri, Bundle bundle) throws RemoteException {
        context.grantUriPermission("com.google.android.gms", uri, 1);
        try {
            zzqpVar.zza(new zzqo.zza() { // from class: com.google.android.gms.internal.zzqq.3
                @Override // com.google.android.gms.internal.zzqo
                public void zza(int i, Bundle bundle2, int i2, Intent intent) throws RemoteException {
                    zzqq.zza(context, uri);
                    zzqoVar.zza(i, bundle2, i2, intent);
                }
            }, uri, bundle, true);
        } catch (RemoteException e) {
            zza(context, uri);
            throw e;
        } catch (RuntimeException e2) {
            zza(context, uri);
            throw e2;
        }
    }

    @Override // com.google.android.gms.panorama.PanoramaApi
    public PendingResult<PanoramaApi.PanoramaResult> loadPanoramaInfo(GoogleApiClient client, final Uri uri) {
        return client.zza(new zza(client) { // from class: com.google.android.gms.internal.zzqq.1
            @Override // com.google.android.gms.internal.zzqq.zzc
            protected void zza(Context context, zzqp zzqpVar) throws RemoteException {
                zzqpVar.zza(new zzb(this), uri, null, false);
            }
        });
    }

    @Override // com.google.android.gms.panorama.PanoramaApi
    public PendingResult<PanoramaApi.PanoramaResult> loadPanoramaInfoAndGrantAccess(GoogleApiClient client, final Uri uri) {
        return client.zza(new zza(client) { // from class: com.google.android.gms.internal.zzqq.2
            @Override // com.google.android.gms.internal.zzqq.zzc
            protected void zza(Context context, zzqp zzqpVar) throws RemoteException {
                zzqq.zza(context, zzqpVar, new zzb(this), uri, null);
            }
        });
    }
}
