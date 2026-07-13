package com.google.android.gms.plus.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzq;
import com.google.android.gms.common.server.response.SafeParcelResponse;
import com.google.android.gms.plus.Moments;
import com.google.android.gms.plus.People;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.internal.model.moments.MomentEntity;
import com.google.android.gms.plus.internal.model.people.PersonEntity;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.moments.MomentBuffer;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class zze extends zzj<com.google.android.gms.plus.internal.zzd> {
    private Person zzbei;
    private final PlusSession zzbej;

    static final class zza implements Moments.LoadMomentsResult {
        private final Status zzUX;
        private final String zzbek;
        private final String zzbel;
        private final MomentBuffer zzbem;

        public zza(Status status, DataHolder dataHolder, String str, String str2) {
            this.zzUX = status;
            this.zzbek = str;
            this.zzbel = str2;
            this.zzbem = dataHolder != null ? new MomentBuffer(dataHolder) : null;
        }

        @Override // com.google.android.gms.plus.Moments.LoadMomentsResult
        public MomentBuffer getMomentBuffer() {
            return this.zzbem;
        }

        @Override // com.google.android.gms.plus.Moments.LoadMomentsResult
        public String getNextPageToken() {
            return this.zzbek;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzUX;
        }

        @Override // com.google.android.gms.plus.Moments.LoadMomentsResult
        public String getUpdated() {
            return this.zzbel;
        }

        @Override // com.google.android.gms.common.api.Releasable
        public void release() {
            if (this.zzbem != null) {
                this.zzbem.release();
            }
        }
    }

    static final class zzb implements People.LoadPeopleResult {
        private final Status zzUX;
        private final String zzbek;
        private final PersonBuffer zzben;

        public zzb(Status status, DataHolder dataHolder, String str) {
            this.zzUX = status;
            this.zzbek = str;
            this.zzben = dataHolder != null ? new PersonBuffer(dataHolder) : null;
        }

        @Override // com.google.android.gms.plus.People.LoadPeopleResult
        public String getNextPageToken() {
            return this.zzbek;
        }

        @Override // com.google.android.gms.plus.People.LoadPeopleResult
        public PersonBuffer getPersonBuffer() {
            return this.zzben;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzUX;
        }

        @Override // com.google.android.gms.common.api.Releasable
        public void release() {
            if (this.zzben != null) {
                this.zzben.release();
            }
        }
    }

    static final class zzc extends com.google.android.gms.plus.internal.zza {
        private final com.google.android.gms.common.api.internal.zza.zzb<Status> zzaON;

        public zzc(com.google.android.gms.common.api.internal.zza.zzb<Status> zzbVar) {
            this.zzaON = zzbVar;
        }

        @Override // com.google.android.gms.plus.internal.zza, com.google.android.gms.plus.internal.zzb
        public void zzbe(Status status) {
            this.zzaON.zzs(status);
        }
    }

    static final class zzd extends com.google.android.gms.plus.internal.zza {
        private final com.google.android.gms.common.api.internal.zza.zzb<Moments.LoadMomentsResult> zzaON;

        public zzd(com.google.android.gms.common.api.internal.zza.zzb<Moments.LoadMomentsResult> zzbVar) {
            this.zzaON = zzbVar;
        }

        @Override // com.google.android.gms.plus.internal.zza, com.google.android.gms.plus.internal.zzb
        public void zza(DataHolder dataHolder, String str, String str2) {
            Status status = new Status(dataHolder.getStatusCode(), null, dataHolder.zzpZ() != null ? (PendingIntent) dataHolder.zzpZ().getParcelable("pendingIntent") : null);
            if (!status.isSuccess() && dataHolder != null) {
                if (!dataHolder.isClosed()) {
                    dataHolder.close();
                }
                dataHolder = null;
            }
            this.zzaON.zzs(new zza(status, dataHolder, str, str2));
        }
    }

    /* JADX INFO: renamed from: com.google.android.gms.plus.internal.zze$zze, reason: collision with other inner class name */
    static final class BinderC0270zze extends com.google.android.gms.plus.internal.zza {
        private final com.google.android.gms.common.api.internal.zza.zzb<People.LoadPeopleResult> zzaON;

        public BinderC0270zze(com.google.android.gms.common.api.internal.zza.zzb<People.LoadPeopleResult> zzbVar) {
            this.zzaON = zzbVar;
        }

        @Override // com.google.android.gms.plus.internal.zza, com.google.android.gms.plus.internal.zzb
        public void zza(DataHolder dataHolder, String str) {
            Status status = new Status(dataHolder.getStatusCode(), null, dataHolder.zzpZ() != null ? (PendingIntent) dataHolder.zzpZ().getParcelable("pendingIntent") : null);
            if (!status.isSuccess() && dataHolder != null) {
                if (!dataHolder.isClosed()) {
                    dataHolder.close();
                }
                dataHolder = null;
            }
            this.zzaON.zzs(new zzb(status, dataHolder, str));
        }
    }

    static final class zzf extends com.google.android.gms.plus.internal.zza {
        private final com.google.android.gms.common.api.internal.zza.zzb<Status> zzaON;

        public zzf(com.google.android.gms.common.api.internal.zza.zzb<Status> zzbVar) {
            this.zzaON = zzbVar;
        }

        @Override // com.google.android.gms.plus.internal.zza, com.google.android.gms.plus.internal.zzb
        public void zzi(int i, Bundle bundle) {
            this.zzaON.zzs(new Status(i, null, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null));
        }
    }

    public zze(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, PlusSession plusSession, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 2, zzfVar, connectionCallbacks, onConnectionFailedListener);
        this.zzbej = plusSession;
    }

    public static boolean zzd(Set<Scope> set) {
        if (set == null || set.isEmpty()) {
            return false;
        }
        return (set.size() == 1 && set.contains(new Scope("plus_one_placeholder_scope"))) ? false : true;
    }

    public String getAccountName() {
        zzqI();
        try {
            return zzqJ().getAccountName();
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }

    public void zzEY() {
        zzqI();
        try {
            this.zzbei = null;
            zzqJ().zzEY();
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }

    public Person zzFa() {
        zzqI();
        return this.zzbei;
    }

    public zzq zza(com.google.android.gms.common.api.internal.zza.zzb<People.LoadPeopleResult> zzbVar, int i, String str) {
        zzqI();
        BinderC0270zze binderC0270zze = new BinderC0270zze(zzbVar);
        try {
            return zzqJ().zza(binderC0270zze, 1, i, -1, str);
        } catch (RemoteException e) {
            binderC0270zze.zza(DataHolder.zzbI(8), (String) null);
            return null;
        }
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected void zza(int i, IBinder iBinder, Bundle bundle, int i2) {
        if (i == 0 && bundle != null && bundle.containsKey("loaded_person")) {
            this.zzbei = PersonEntity.zzv(bundle.getByteArray("loaded_person"));
        }
        super.zza(i, iBinder, bundle, i2);
    }

    public void zza(com.google.android.gms.common.api.internal.zza.zzb<Moments.LoadMomentsResult> zzbVar, int i, String str, Uri uri, String str2, String str3) {
        zzqI();
        zzd zzdVar = zzbVar != null ? new zzd(zzbVar) : null;
        try {
            zzqJ().zza(zzdVar, i, str, uri, str2, str3);
        } catch (RemoteException e) {
            zzdVar.zza(DataHolder.zzbI(8), (String) null, (String) null);
        }
    }

    public void zza(com.google.android.gms.common.api.internal.zza.zzb<Status> zzbVar, Moment moment) {
        zzqI();
        zzc zzcVar = zzbVar != null ? new zzc(zzbVar) : null;
        try {
            zzqJ().zza(zzcVar, SafeParcelResponse.zza((MomentEntity) moment));
        } catch (RemoteException e) {
            if (zzcVar == null) {
                throw new IllegalStateException(e);
            }
            zzcVar.zzbe(new Status(8, null, null));
        }
    }

    public void zza(com.google.android.gms.common.api.internal.zza.zzb<People.LoadPeopleResult> zzbVar, Collection<String> collection) {
        zzqI();
        BinderC0270zze binderC0270zze = new BinderC0270zze(zzbVar);
        try {
            zzqJ().zza(binderC0270zze, new ArrayList(collection));
        } catch (RemoteException e) {
            binderC0270zze.zza(DataHolder.zzbI(8), (String) null);
        }
    }

    public void zzd(com.google.android.gms.common.api.internal.zza.zzb<People.LoadPeopleResult> zzbVar, String[] strArr) {
        zza(zzbVar, Arrays.asList(strArr));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzj
    /* JADX INFO: renamed from: zzdS, reason: merged with bridge method [inline-methods] */
    public com.google.android.gms.plus.internal.zzd zzW(IBinder iBinder) {
        return com.google.android.gms.plus.internal.zzd.zza.zzdR(iBinder);
    }

    public void zzfG(String str) {
        zzqI();
        try {
            zzqJ().zzfG(str);
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzgu() {
        return "com.google.android.gms.plus.service.START";
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzgv() {
        return "com.google.android.gms.plus.internal.IPlusService";
    }

    @Override // com.google.android.gms.common.internal.zzj, com.google.android.gms.common.api.Api.zzb
    public boolean zzmE() {
        return zzd(zzqH().zzb(Plus.API));
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected Bundle zzml() {
        Bundle bundleZzFk = this.zzbej.zzFk();
        bundleZzFk.putStringArray("request_visible_actions", this.zzbej.zzFe());
        bundleZzFk.putString("auth_package", this.zzbej.zzFg());
        return bundleZzFk;
    }

    public void zzo(com.google.android.gms.common.api.internal.zza.zzb<Moments.LoadMomentsResult> zzbVar) {
        zza(zzbVar, 20, null, null, null, "me");
    }

    public void zzp(com.google.android.gms.common.api.internal.zza.zzb<People.LoadPeopleResult> zzbVar) {
        zzqI();
        BinderC0270zze binderC0270zze = new BinderC0270zze(zzbVar);
        try {
            zzqJ().zza(binderC0270zze, 2, 1, -1, null);
        } catch (RemoteException e) {
            binderC0270zze.zza(DataHolder.zzbI(8), (String) null);
        }
    }

    public zzq zzq(com.google.android.gms.common.api.internal.zza.zzb<People.LoadPeopleResult> zzbVar, String str) {
        return zza(zzbVar, 0, str);
    }

    public void zzq(com.google.android.gms.common.api.internal.zza.zzb<Status> zzbVar) {
        zzqI();
        zzEY();
        zzf zzfVar = new zzf(zzbVar);
        try {
            zzqJ().zzb(zzfVar);
        } catch (RemoteException e) {
            zzfVar.zzi(8, null);
        }
    }
}
