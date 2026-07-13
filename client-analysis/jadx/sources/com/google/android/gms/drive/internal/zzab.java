package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.DriveResource;
import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.events.ChangeListener;
import java.util.ArrayList;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class zzab implements DriveResource {
    protected final DriveId zzaoz;

    private static class zza extends com.google.android.gms.drive.internal.zzd {
        private final com.google.android.gms.common.api.internal.zza.zzb<DriveApi.MetadataBufferResult> zzamC;

        public zza(com.google.android.gms.common.api.internal.zza.zzb<DriveApi.MetadataBufferResult> zzbVar) {
            this.zzamC = zzbVar;
        }

        @Override // com.google.android.gms.drive.internal.zzd, com.google.android.gms.drive.internal.zzan
        public void onError(Status status) throws RemoteException {
            this.zzamC.zzs(new zzs.zzg(status, null, false));
        }

        @Override // com.google.android.gms.drive.internal.zzd, com.google.android.gms.drive.internal.zzan
        public void zza(OnListParentsResponse onListParentsResponse) throws RemoteException {
            this.zzamC.zzs(new zzs.zzg(Status.zzagC, new MetadataBuffer(onListParentsResponse.zztv()), false));
        }
    }

    private static class zzb extends com.google.android.gms.drive.internal.zzd {
        private final com.google.android.gms.common.api.internal.zza.zzb<DriveResource.MetadataResult> zzamC;

        public zzb(com.google.android.gms.common.api.internal.zza.zzb<DriveResource.MetadataResult> zzbVar) {
            this.zzamC = zzbVar;
        }

        @Override // com.google.android.gms.drive.internal.zzd, com.google.android.gms.drive.internal.zzan
        public void onError(Status status) throws RemoteException {
            this.zzamC.zzs(new zzc(status, null));
        }

        @Override // com.google.android.gms.drive.internal.zzd, com.google.android.gms.drive.internal.zzan
        public void zza(OnMetadataResponse onMetadataResponse) throws RemoteException {
            this.zzamC.zzs(new zzc(Status.zzagC, new zzp(onMetadataResponse.zztw())));
        }
    }

    private static class zzc implements DriveResource.MetadataResult {
        private final Status zzUX;
        private final Metadata zzarA;

        public zzc(Status status, Metadata metadata) {
            this.zzUX = status;
            this.zzarA = metadata;
        }

        @Override // com.google.android.gms.drive.DriveResource.MetadataResult
        public Metadata getMetadata() {
            return this.zzarA;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzUX;
        }
    }

    private abstract class zzd extends zzt<DriveResource.MetadataResult> {
        private zzd(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.internal.zzb
        /* JADX INFO: renamed from: zzH, reason: merged with bridge method [inline-methods] */
        public DriveResource.MetadataResult zzc(Status status) {
            return new zzc(status, null);
        }
    }

    public zzab(DriveId driveId) {
        this.zzaoz = driveId;
    }

    private PendingResult<DriveResource.MetadataResult> zza(GoogleApiClient googleApiClient, final boolean z) {
        return googleApiClient.zza(new zzd(googleApiClient) { // from class: com.google.android.gms.drive.internal.zzab.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzu zzuVar) throws RemoteException {
                zzuVar.zzte().zza(new GetMetadataRequest(zzab.this.zzaoz, z), new zzb(this));
            }
        });
    }

    @Override // com.google.android.gms.drive.DriveResource
    public PendingResult<Status> addChangeListener(GoogleApiClient apiClient, ChangeListener listener) {
        return ((zzu) apiClient.zza(Drive.zzUI)).zza(apiClient, this.zzaoz, listener);
    }

    @Override // com.google.android.gms.drive.DriveResource
    public PendingResult<Status> addChangeSubscription(GoogleApiClient apiClient) {
        return ((zzu) apiClient.zza(Drive.zzUI)).zza(apiClient, this.zzaoz);
    }

    @Override // com.google.android.gms.drive.DriveResource
    public PendingResult<Status> delete(GoogleApiClient apiClient) {
        return apiClient.zzb(new zzt.zza(apiClient) { // from class: com.google.android.gms.drive.internal.zzab.5
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzu zzuVar) throws RemoteException {
                zzuVar.zzte().zza(new DeleteResourceRequest(zzab.this.zzaoz), new zzbu(this));
            }
        });
    }

    @Override // com.google.android.gms.drive.DriveResource
    public DriveId getDriveId() {
        return this.zzaoz;
    }

    @Override // com.google.android.gms.drive.DriveResource
    public PendingResult<DriveResource.MetadataResult> getMetadata(GoogleApiClient apiClient) {
        return zza(apiClient, false);
    }

    @Override // com.google.android.gms.drive.DriveResource
    public PendingResult<DriveApi.MetadataBufferResult> listParents(GoogleApiClient apiClient) {
        return apiClient.zza(new zzs.zzh(apiClient) { // from class: com.google.android.gms.drive.internal.zzab.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzu zzuVar) throws RemoteException {
                zzuVar.zzte().zza(new ListParentsRequest(zzab.this.zzaoz), new zza(this));
            }
        });
    }

    @Override // com.google.android.gms.drive.DriveResource
    public PendingResult<Status> removeChangeListener(GoogleApiClient apiClient, ChangeListener listener) {
        return ((zzu) apiClient.zza(Drive.zzUI)).zzb(apiClient, this.zzaoz, listener);
    }

    @Override // com.google.android.gms.drive.DriveResource
    public PendingResult<Status> removeChangeSubscription(GoogleApiClient apiClient) {
        return ((zzu) apiClient.zza(Drive.zzUI)).zzb(apiClient, this.zzaoz);
    }

    @Override // com.google.android.gms.drive.DriveResource
    public PendingResult<Status> setParents(GoogleApiClient apiClient, Set<DriveId> parentIds) {
        if (parentIds == null) {
            throw new IllegalArgumentException("ParentIds must be provided.");
        }
        final ArrayList arrayList = new ArrayList(parentIds);
        return apiClient.zzb(new zzt.zza(apiClient) { // from class: com.google.android.gms.drive.internal.zzab.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzu zzuVar) throws RemoteException {
                zzuVar.zzte().zza(new SetResourceParentsRequest(zzab.this.zzaoz, arrayList), new zzbu(this));
            }
        });
    }

    @Override // com.google.android.gms.drive.DriveResource
    public PendingResult<Status> trash(GoogleApiClient apiClient) {
        return apiClient.zzb(new zzt.zza(apiClient) { // from class: com.google.android.gms.drive.internal.zzab.6
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzu zzuVar) throws RemoteException {
                zzuVar.zzte().zza(new TrashResourceRequest(zzab.this.zzaoz), new zzbu(this));
            }
        });
    }

    @Override // com.google.android.gms.drive.DriveResource
    public PendingResult<Status> untrash(GoogleApiClient apiClient) {
        return apiClient.zzb(new zzt.zza(apiClient) { // from class: com.google.android.gms.drive.internal.zzab.7
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzu zzuVar) throws RemoteException {
                zzuVar.zzte().zza(new UntrashResourceRequest(zzab.this.zzaoz), new zzbu(this));
            }
        });
    }

    @Override // com.google.android.gms.drive.DriveResource
    public PendingResult<DriveResource.MetadataResult> updateMetadata(GoogleApiClient apiClient, final MetadataChangeSet changeSet) {
        if (changeSet == null) {
            throw new IllegalArgumentException("ChangeSet must be provided.");
        }
        return apiClient.zzb(new zzd(apiClient) { // from class: com.google.android.gms.drive.internal.zzab.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzu zzuVar) throws RemoteException {
                changeSet.zzsL().setContext(zzuVar.getContext());
                zzuVar.zzte().zza(new UpdateMetadataRequest(zzab.this.zzaoz, changeSet.zzsL()), new zzb(this));
            }
        });
    }
}
