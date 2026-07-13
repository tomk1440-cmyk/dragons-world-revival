package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public class zza {

    /* JADX INFO: renamed from: com.google.android.gms.common.api.internal.zza$zza, reason: collision with other inner class name */
    public static abstract class AbstractC0049zza<R extends Result, A extends Api.zzb> extends com.google.android.gms.common.api.internal.zzb<R> implements zzb<R>, zzj.zze<A> {
        private final Api.zzc<A> zzaeE;
        private AtomicReference<zzj.zzd> zzagH;

        protected AbstractC0049zza(Api.zzc<A> zzcVar, GoogleApiClient googleApiClient) {
            super((GoogleApiClient) com.google.android.gms.common.internal.zzx.zzb(googleApiClient, "GoogleApiClient must not be null"));
            this.zzagH = new AtomicReference<>();
            this.zzaeE = (Api.zzc) com.google.android.gms.common.internal.zzx.zzz(zzcVar);
        }

        private void zza(RemoteException remoteException) {
            zzw(new Status(8, remoteException.getLocalizedMessage(), null));
        }

        protected abstract void zza(A a) throws RemoteException;

        @Override // com.google.android.gms.common.api.internal.zzj.zze
        public void zza(zzj.zzd zzdVar) {
            this.zzagH.set(zzdVar);
        }

        @Override // com.google.android.gms.common.api.internal.zzj.zze
        public final void zzb(A a) throws DeadObjectException {
            try {
                zza(a);
            } catch (DeadObjectException e) {
                zza(e);
                throw e;
            } catch (RemoteException e2) {
                zza(e2);
            }
        }

        @Override // com.google.android.gms.common.api.internal.zzj.zze
        public final Api.zzc<A> zzoR() {
            return this.zzaeE;
        }

        @Override // com.google.android.gms.common.api.internal.zzj.zze
        public void zzpe() {
            setResultCallback(null);
        }

        @Override // com.google.android.gms.common.api.internal.zzb
        protected void zzpf() {
            zzj.zzd andSet = this.zzagH.getAndSet(null);
            if (andSet != null) {
                andSet.zzc(this);
            }
        }

        @Override // com.google.android.gms.common.api.internal.zza.zzb
        public /* synthetic */ void zzs(Object obj) {
            super.zza((Result) obj);
        }

        @Override // com.google.android.gms.common.api.internal.zza.zzb, com.google.android.gms.common.api.internal.zzj.zze
        public final void zzw(Status status) {
            com.google.android.gms.common.internal.zzx.zzb(!status.isSuccess(), "Failed result must not be success");
            zza(zzc(status));
        }
    }

    public interface zzb<R> {
        void zzs(R r);

        void zzw(Status status);
    }
}
