package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import com.google.android.gms.wearable.DataItemBuffer;
import com.google.android.gms.wearable.PutDataRequest;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class zzx implements DataApi {

    public static class zza implements DataApi.DataItemResult {
        private final Status zzUX;
        private final DataItem zzbsv;

        public zza(Status status, DataItem dataItem) {
            this.zzUX = status;
            this.zzbsv = dataItem;
        }

        @Override // com.google.android.gms.wearable.DataApi.DataItemResult
        public DataItem getDataItem() {
            return this.zzbsv;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzUX;
        }
    }

    public static class zzb implements DataApi.DeleteDataItemsResult {
        private final Status zzUX;
        private final int zzbsw;

        public zzb(Status status, int i) {
            this.zzUX = status;
            this.zzbsw = i;
        }

        @Override // com.google.android.gms.wearable.DataApi.DeleteDataItemsResult
        public int getNumDeleted() {
            return this.zzbsw;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzUX;
        }
    }

    public static class zzc implements DataApi.GetFdForAssetResult {
        private volatile boolean mClosed = false;
        private final Status zzUX;
        private volatile InputStream zzbsh;
        private volatile ParcelFileDescriptor zzbsx;

        public zzc(Status status, ParcelFileDescriptor parcelFileDescriptor) {
            this.zzUX = status;
            this.zzbsx = parcelFileDescriptor;
        }

        @Override // com.google.android.gms.wearable.DataApi.GetFdForAssetResult
        public ParcelFileDescriptor getFd() {
            if (this.mClosed) {
                throw new IllegalStateException("Cannot access the file descriptor after release().");
            }
            return this.zzbsx;
        }

        @Override // com.google.android.gms.wearable.DataApi.GetFdForAssetResult
        public InputStream getInputStream() {
            if (this.mClosed) {
                throw new IllegalStateException("Cannot access the input stream after release().");
            }
            if (this.zzbsx == null) {
                return null;
            }
            if (this.zzbsh == null) {
                this.zzbsh = new ParcelFileDescriptor.AutoCloseInputStream(this.zzbsx);
            }
            return this.zzbsh;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzUX;
        }

        @Override // com.google.android.gms.common.api.Releasable
        public void release() {
            if (this.zzbsx == null) {
                return;
            }
            if (this.mClosed) {
                throw new IllegalStateException("releasing an already released result.");
            }
            try {
                if (this.zzbsh != null) {
                    this.zzbsh.close();
                } else {
                    this.zzbsx.close();
                }
                this.mClosed = true;
                this.zzbsx = null;
                this.zzbsh = null;
            } catch (IOException e) {
            }
        }
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, DataApi.DataListener dataListener, IntentFilter[] intentFilterArr) {
        return com.google.android.gms.wearable.internal.zzb.zza(googleApiClient, zza(intentFilterArr), dataListener);
    }

    private static com.google.android.gms.wearable.internal.zzb.zza<DataApi.DataListener> zza(final IntentFilter[] intentFilterArr) {
        return new com.google.android.gms.wearable.internal.zzb.zza<DataApi.DataListener>() { // from class: com.google.android.gms.wearable.internal.zzx.8
            /* JADX INFO: renamed from: zza, reason: avoid collision after fix types in other method */
            public void zza2(zzbp zzbpVar, com.google.android.gms.common.api.internal.zza.zzb<Status> zzbVar, DataApi.DataListener dataListener, com.google.android.gms.common.api.internal.zzq<DataApi.DataListener> zzqVar) throws RemoteException {
                zzbpVar.zza(zzbVar, dataListener, zzqVar, intentFilterArr);
            }

            @Override // com.google.android.gms.wearable.internal.zzb.zza
            public /* bridge */ /* synthetic */ void zza(zzbp zzbpVar, com.google.android.gms.common.api.internal.zza.zzb zzbVar, DataApi.DataListener dataListener, com.google.android.gms.common.api.internal.zzq<DataApi.DataListener> zzqVar) throws RemoteException {
                zza2(zzbpVar, (com.google.android.gms.common.api.internal.zza.zzb<Status>) zzbVar, dataListener, zzqVar);
            }
        };
    }

    private void zza(Asset asset) {
        if (asset == null) {
            throw new IllegalArgumentException("asset is null");
        }
        if (asset.getDigest() == null) {
            throw new IllegalArgumentException("invalid asset");
        }
        if (asset.getData() != null) {
            throw new IllegalArgumentException("invalid asset");
        }
    }

    @Override // com.google.android.gms.wearable.DataApi
    public PendingResult<Status> addListener(GoogleApiClient client, DataApi.DataListener listener) {
        return zza(client, listener, new IntentFilter[]{zzbn.zzgM(DataApi.ACTION_DATA_CHANGED)});
    }

    @Override // com.google.android.gms.wearable.DataApi
    public PendingResult<Status> addListener(GoogleApiClient client, DataApi.DataListener listener, Uri uri, int filterType) {
        com.google.android.gms.common.internal.zzx.zzb(uri != null, "uri must not be null");
        com.google.android.gms.common.internal.zzx.zzb(filterType == 0 || filterType == 1, "invalid filter type");
        return zza(client, listener, new IntentFilter[]{zzbn.zza(DataApi.ACTION_DATA_CHANGED, uri, filterType)});
    }

    @Override // com.google.android.gms.wearable.DataApi
    public PendingResult<DataApi.DeleteDataItemsResult> deleteDataItems(GoogleApiClient client, Uri uri) {
        return deleteDataItems(client, uri, 0);
    }

    @Override // com.google.android.gms.wearable.DataApi
    public PendingResult<DataApi.DeleteDataItemsResult> deleteDataItems(GoogleApiClient client, final Uri uri, final int filterType) {
        com.google.android.gms.common.internal.zzx.zzb(uri != null, "uri must not be null");
        com.google.android.gms.common.internal.zzx.zzb(filterType == 0 || filterType == 1, "invalid filter type");
        return client.zza(new zzi<DataApi.DeleteDataItemsResult>(client) { // from class: com.google.android.gms.wearable.internal.zzx.5
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzbp zzbpVar) throws RemoteException {
                zzbpVar.zzb(this, uri, filterType);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zzb
            /* JADX INFO: renamed from: zzbx, reason: merged with bridge method [inline-methods] */
            public DataApi.DeleteDataItemsResult zzc(Status status) {
                return new zzb(status, 0);
            }
        });
    }

    @Override // com.google.android.gms.wearable.DataApi
    public PendingResult<DataApi.DataItemResult> getDataItem(GoogleApiClient client, final Uri uri) {
        return client.zza(new zzi<DataApi.DataItemResult>(client) { // from class: com.google.android.gms.wearable.internal.zzx.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzbp zzbpVar) throws RemoteException {
                zzbpVar.zza(this, uri);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zzb
            /* JADX INFO: renamed from: zzbv, reason: merged with bridge method [inline-methods] */
            public DataApi.DataItemResult zzc(Status status) {
                return new zza(status, null);
            }
        });
    }

    @Override // com.google.android.gms.wearable.DataApi
    public PendingResult<DataItemBuffer> getDataItems(GoogleApiClient client) {
        return client.zza(new zzi<DataItemBuffer>(client) { // from class: com.google.android.gms.wearable.internal.zzx.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzbp zzbpVar) throws RemoteException {
                zzbpVar.zzr(this);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zzb
            /* JADX INFO: renamed from: zzbw, reason: merged with bridge method [inline-methods] */
            public DataItemBuffer zzc(Status status) {
                return new DataItemBuffer(DataHolder.zzbI(status.getStatusCode()));
            }
        });
    }

    @Override // com.google.android.gms.wearable.DataApi
    public PendingResult<DataItemBuffer> getDataItems(GoogleApiClient client, Uri uri) {
        return getDataItems(client, uri, 0);
    }

    @Override // com.google.android.gms.wearable.DataApi
    public PendingResult<DataItemBuffer> getDataItems(GoogleApiClient client, final Uri uri, final int filterType) {
        com.google.android.gms.common.internal.zzx.zzb(uri != null, "uri must not be null");
        com.google.android.gms.common.internal.zzx.zzb(filterType == 0 || filterType == 1, "invalid filter type");
        return client.zza(new zzi<DataItemBuffer>(client) { // from class: com.google.android.gms.wearable.internal.zzx.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzbp zzbpVar) throws RemoteException {
                zzbpVar.zza(this, uri, filterType);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zzb
            /* JADX INFO: renamed from: zzbw, reason: merged with bridge method [inline-methods] */
            public DataItemBuffer zzc(Status status) {
                return new DataItemBuffer(DataHolder.zzbI(status.getStatusCode()));
            }
        });
    }

    @Override // com.google.android.gms.wearable.DataApi
    public PendingResult<DataApi.GetFdForAssetResult> getFdForAsset(GoogleApiClient client, final Asset asset) {
        zza(asset);
        return client.zza(new zzi<DataApi.GetFdForAssetResult>(client) { // from class: com.google.android.gms.wearable.internal.zzx.6
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzbp zzbpVar) throws RemoteException {
                zzbpVar.zza(this, asset);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zzb
            /* JADX INFO: renamed from: zzby, reason: merged with bridge method [inline-methods] */
            public DataApi.GetFdForAssetResult zzc(Status status) {
                return new zzc(status, null);
            }
        });
    }

    @Override // com.google.android.gms.wearable.DataApi
    public PendingResult<DataApi.GetFdForAssetResult> getFdForAsset(GoogleApiClient client, final DataItemAsset asset) {
        return client.zza(new zzi<DataApi.GetFdForAssetResult>(client) { // from class: com.google.android.gms.wearable.internal.zzx.7
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzbp zzbpVar) throws RemoteException {
                zzbpVar.zza(this, asset);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zzb
            /* JADX INFO: renamed from: zzby, reason: merged with bridge method [inline-methods] */
            public DataApi.GetFdForAssetResult zzc(Status status) {
                return new zzc(status, null);
            }
        });
    }

    @Override // com.google.android.gms.wearable.DataApi
    public PendingResult<DataApi.DataItemResult> putDataItem(GoogleApiClient client, final PutDataRequest request) {
        return client.zza(new zzi<DataApi.DataItemResult>(client) { // from class: com.google.android.gms.wearable.internal.zzx.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzbp zzbpVar) throws RemoteException {
                zzbpVar.zza(this, request);
            }

            @Override // com.google.android.gms.common.api.internal.zzb
            /* JADX INFO: renamed from: zzbv, reason: merged with bridge method [inline-methods] */
            public DataApi.DataItemResult zzc(Status status) {
                return new zza(status, null);
            }
        });
    }

    @Override // com.google.android.gms.wearable.DataApi
    public PendingResult<Status> removeListener(GoogleApiClient client, final DataApi.DataListener listener) {
        return client.zza(new zzi<Status>(client) { // from class: com.google.android.gms.wearable.internal.zzx.9
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzbp zzbpVar) throws RemoteException {
                zzbpVar.zza(this, listener);
            }

            @Override // com.google.android.gms.common.api.internal.zzb
            /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
            public Status zzc(Status status) {
                return status;
            }
        });
    }
}
