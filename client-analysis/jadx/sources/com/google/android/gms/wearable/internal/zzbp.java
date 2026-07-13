package com.google.android.gms.wearable.internal;

import android.content.Context;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.CapabilityApi;
import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.ChannelApi;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataItemAsset;
import com.google.android.gms.wearable.DataItemBuffer;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.PutDataRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes.dex */
public class zzbp extends com.google.android.gms.common.internal.zzj<zzax> {
    private final ExecutorService zzbkn;
    private final zzay<com.google.android.gms.wearable.zzc.zza> zzbte;
    private final zzay<com.google.android.gms.wearable.zza.InterfaceC0282zza> zzbtf;
    private final zzay<ChannelApi.ChannelListener> zzbtg;
    private final zzay<DataApi.DataListener> zzbth;
    private final zzay<MessageApi.MessageListener> zzbti;
    private final zzay<NodeApi.NodeListener> zzbtj;
    private final zzay<NodeApi.zza> zzbtk;
    private final zzay<CapabilityApi.CapabilityListener> zzbtl;

    public zzbp(Context context, Looper looper, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, com.google.android.gms.common.internal.zzf zzfVar) {
        super(context, looper, 14, zzfVar, connectionCallbacks, onConnectionFailedListener);
        this.zzbkn = Executors.newCachedThreadPool();
        this.zzbte = new zzay<>();
        this.zzbtf = new zzay<>();
        this.zzbtg = new zzay<>();
        this.zzbth = new zzay<>();
        this.zzbti = new zzay<>();
        this.zzbtj = new zzay<>();
        this.zzbtk = new zzay<>();
        this.zzbtl = new zzay<>();
    }

    private FutureTask<Boolean> zza(final ParcelFileDescriptor parcelFileDescriptor, final byte[] bArr) {
        return new FutureTask<>(new Callable<Boolean>() { // from class: com.google.android.gms.wearable.internal.zzbp.1
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: zzvt, reason: merged with bridge method [inline-methods] */
            public Boolean call() {
                if (Log.isLoggable("WearableClient", 3)) {
                    Log.d("WearableClient", "processAssets: writing data to FD : " + parcelFileDescriptor);
                }
                ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream = new ParcelFileDescriptor.AutoCloseOutputStream(parcelFileDescriptor);
                try {
                    autoCloseOutputStream.write(bArr);
                    autoCloseOutputStream.flush();
                    if (Log.isLoggable("WearableClient", 3)) {
                        Log.d("WearableClient", "processAssets: wrote data: " + parcelFileDescriptor);
                    }
                    try {
                        return true;
                    } catch (IOException e) {
                        return true;
                    }
                } catch (IOException e2) {
                    Log.w("WearableClient", "processAssets: writing data failed: " + parcelFileDescriptor);
                    return false;
                } finally {
                    try {
                        if (Log.isLoggable("WearableClient", 3)) {
                            Log.d("WearableClient", "processAssets: closing: " + parcelFileDescriptor);
                        }
                        autoCloseOutputStream.close();
                    } catch (IOException e3) {
                    }
                }
            }
        });
    }

    private Runnable zzb(final com.google.android.gms.common.api.internal.zza.zzb<Status> zzbVar, final String str, final Uri uri, final long j, final long j2) {
        com.google.android.gms.common.internal.zzx.zzz(zzbVar);
        com.google.android.gms.common.internal.zzx.zzz(str);
        com.google.android.gms.common.internal.zzx.zzz(uri);
        com.google.android.gms.common.internal.zzx.zzb(j >= 0, "startOffset is negative: %s", Long.valueOf(j));
        com.google.android.gms.common.internal.zzx.zzb(j2 >= -1, "invalid length: %s", Long.valueOf(j2));
        return new Runnable() { // from class: com.google.android.gms.wearable.internal.zzbp.3
            @Override // java.lang.Runnable
            public void run() {
                if (Log.isLoggable("WearableClient", 2)) {
                    Log.v("WearableClient", "Executing sendFileToChannelTask");
                }
                if (!"file".equals(uri.getScheme())) {
                    Log.w("WearableClient", "Channel.sendFile used with non-file URI");
                    zzbVar.zzw(new Status(10, "Channel.sendFile used with non-file URI"));
                    return;
                }
                File file = new File(uri.getPath());
                try {
                    ParcelFileDescriptor parcelFileDescriptorOpen = ParcelFileDescriptor.open(file, DriveFile.MODE_READ_ONLY);
                    try {
                        zzbp.this.zzqJ().zza(new zzbo.zzr(zzbVar), str, parcelFileDescriptorOpen, j, j2);
                    } catch (RemoteException e) {
                        Log.w("WearableClient", "Channel.sendFile failed.", e);
                        zzbVar.zzw(new Status(8));
                    } finally {
                        try {
                            parcelFileDescriptorOpen.close();
                        } catch (IOException e2) {
                            Log.w("WearableClient", "Failed to close sourceFd", e2);
                        }
                    }
                } catch (FileNotFoundException e3) {
                    Log.w("WearableClient", "File couldn't be opened for Channel.sendFile: " + file);
                    zzbVar.zzw(new Status(13));
                }
            }
        };
    }

    private Runnable zzb(final com.google.android.gms.common.api.internal.zza.zzb<Status> zzbVar, final String str, final Uri uri, final boolean z) {
        com.google.android.gms.common.internal.zzx.zzz(zzbVar);
        com.google.android.gms.common.internal.zzx.zzz(str);
        com.google.android.gms.common.internal.zzx.zzz(uri);
        return new Runnable() { // from class: com.google.android.gms.wearable.internal.zzbp.2
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r1v10, types: [android.os.ParcelFileDescriptor] */
            /* JADX WARN: Type inference failed for: r1v3, types: [java.io.File, java.lang.Object] */
            @Override // java.lang.Runnable
            public void run() {
                if (Log.isLoggable("WearableClient", 2)) {
                    Log.v("WearableClient", "Executing receiveFileFromChannelTask");
                }
                if (!"file".equals(uri.getScheme())) {
                    Log.w("WearableClient", "Channel.receiveFile used with non-file URI");
                    zzbVar.zzw(new Status(10, "Channel.receiveFile used with non-file URI"));
                    return;
                }
                ParcelFileDescriptor file = new File(uri.getPath());
                try {
                    try {
                        file = ParcelFileDescriptor.open(file, (z ? 33554432 : 0) | DriveFile.MODE_WRITE_ONLY);
                        zzbp.this.zzqJ().zza(new zzbo.zzu(zzbVar), str, (ParcelFileDescriptor) file);
                    } catch (FileNotFoundException e) {
                        Log.w("WearableClient", "File couldn't be opened for Channel.receiveFile: " + ((Object) file));
                        zzbVar.zzw(new Status(13));
                    }
                } catch (RemoteException e2) {
                    Log.w("WearableClient", "Channel.receiveFile failed.", e2);
                    zzbVar.zzw(new Status(8));
                } finally {
                    try {
                        file.close();
                    } catch (IOException e3) {
                        Log.w("WearableClient", "Failed to close targetFd", e3);
                    }
                }
            }
        };
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected void zza(int i, IBinder iBinder, Bundle bundle, int i2) {
        if (Log.isLoggable("WearableClient", 2)) {
            Log.d("WearableClient", "onPostInitHandler: statusCode " + i);
        }
        if (i == 0) {
            this.zzbte.zzev(iBinder);
            this.zzbtf.zzev(iBinder);
            this.zzbtg.zzev(iBinder);
            this.zzbth.zzev(iBinder);
            this.zzbti.zzev(iBinder);
            this.zzbtj.zzev(iBinder);
            this.zzbtk.zzev(iBinder);
            this.zzbtl.zzev(iBinder);
        }
        super.zza(i, iBinder, bundle, i2);
    }

    public void zza(com.google.android.gms.common.api.internal.zza.zzb<DataApi.DataItemResult> zzbVar, Uri uri) throws RemoteException {
        zzqJ().zza(new zzbo.zzk(zzbVar), uri);
    }

    public void zza(com.google.android.gms.common.api.internal.zza.zzb<DataItemBuffer> zzbVar, Uri uri, int i) throws RemoteException {
        zzqJ().zza(new zzbo.zzl(zzbVar), uri, i);
    }

    public void zza(com.google.android.gms.common.api.internal.zza.zzb<DataApi.GetFdForAssetResult> zzbVar, Asset asset) throws RemoteException {
        zzqJ().zza(new zzbo.zzm(zzbVar), asset);
    }

    public void zza(com.google.android.gms.common.api.internal.zza.zzb<Status> zzbVar, CapabilityApi.CapabilityListener capabilityListener) throws RemoteException {
        this.zzbtl.zza(this, zzbVar, capabilityListener);
    }

    public void zza(com.google.android.gms.common.api.internal.zza.zzb<Status> zzbVar, CapabilityApi.CapabilityListener capabilityListener, com.google.android.gms.common.api.internal.zzq<CapabilityApi.CapabilityListener> zzqVar, IntentFilter[] intentFilterArr) throws RemoteException {
        this.zzbtl.zza(this, zzbVar, capabilityListener, zzbq.zze(zzqVar, intentFilterArr));
    }

    public void zza(com.google.android.gms.common.api.internal.zza.zzb<Status> zzbVar, ChannelApi.ChannelListener channelListener, com.google.android.gms.common.api.internal.zzq<ChannelApi.ChannelListener> zzqVar, String str, IntentFilter[] intentFilterArr) throws RemoteException {
        if (str == null) {
            this.zzbtg.zza(this, zzbVar, channelListener, zzbq.zzd(zzqVar, intentFilterArr));
        } else {
            this.zzbtg.zza(this, zzbVar, new zzbj(str, channelListener), zzbq.zza(zzqVar, str, intentFilterArr));
        }
    }

    public void zza(com.google.android.gms.common.api.internal.zza.zzb<Status> zzbVar, ChannelApi.ChannelListener channelListener, String str) throws RemoteException {
        if (str == null) {
            this.zzbtg.zza(this, zzbVar, channelListener);
        } else {
            this.zzbtg.zza(this, zzbVar, new zzbj(str, channelListener));
        }
    }

    public void zza(com.google.android.gms.common.api.internal.zza.zzb<Status> zzbVar, DataApi.DataListener dataListener) throws RemoteException {
        this.zzbth.zza(this, zzbVar, dataListener);
    }

    public void zza(com.google.android.gms.common.api.internal.zza.zzb<Status> zzbVar, DataApi.DataListener dataListener, com.google.android.gms.common.api.internal.zzq<DataApi.DataListener> zzqVar, IntentFilter[] intentFilterArr) throws RemoteException {
        this.zzbth.zza(this, zzbVar, dataListener, zzbq.zza(zzqVar, intentFilterArr));
    }

    public void zza(com.google.android.gms.common.api.internal.zza.zzb<DataApi.GetFdForAssetResult> zzbVar, DataItemAsset dataItemAsset) throws RemoteException {
        zza(zzbVar, Asset.createFromRef(dataItemAsset.getId()));
    }

    public void zza(com.google.android.gms.common.api.internal.zza.zzb<Status> zzbVar, MessageApi.MessageListener messageListener) throws RemoteException {
        this.zzbti.zza(this, zzbVar, messageListener);
    }

    public void zza(com.google.android.gms.common.api.internal.zza.zzb<Status> zzbVar, MessageApi.MessageListener messageListener, com.google.android.gms.common.api.internal.zzq<MessageApi.MessageListener> zzqVar, IntentFilter[] intentFilterArr) throws RemoteException {
        this.zzbti.zza(this, zzbVar, messageListener, zzbq.zzb(zzqVar, intentFilterArr));
    }

    public void zza(com.google.android.gms.common.api.internal.zza.zzb<Status> zzbVar, NodeApi.NodeListener nodeListener) throws RemoteException {
        this.zzbtj.zza(this, zzbVar, nodeListener);
    }

    public void zza(com.google.android.gms.common.api.internal.zza.zzb<Status> zzbVar, NodeApi.NodeListener nodeListener, com.google.android.gms.common.api.internal.zzq<NodeApi.NodeListener> zzqVar, IntentFilter[] intentFilterArr) throws RemoteException {
        this.zzbtj.zza(this, zzbVar, nodeListener, zzbq.zzc(zzqVar, intentFilterArr));
    }

    public void zza(com.google.android.gms.common.api.internal.zza.zzb<DataApi.DataItemResult> zzbVar, PutDataRequest putDataRequest) throws RemoteException {
        Iterator<Map.Entry<String, Asset>> it = putDataRequest.getAssets().entrySet().iterator();
        while (it.hasNext()) {
            Asset value = it.next().getValue();
            if (value.getData() == null && value.getDigest() == null && value.getFd() == null && value.getUri() == null) {
                throw new IllegalArgumentException("Put for " + putDataRequest.getUri() + " contains invalid asset: " + value);
            }
        }
        PutDataRequest putDataRequestZzr = PutDataRequest.zzr(putDataRequest.getUri());
        putDataRequestZzr.setData(putDataRequest.getData());
        if (putDataRequest.isUrgent()) {
            putDataRequestZzr.setUrgent();
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, Asset> entry : putDataRequest.getAssets().entrySet()) {
            Asset value2 = entry.getValue();
            if (value2.getData() != null) {
                try {
                    ParcelFileDescriptor[] parcelFileDescriptorArrCreatePipe = ParcelFileDescriptor.createPipe();
                    if (Log.isLoggable("WearableClient", 3)) {
                        Log.d("WearableClient", "processAssets: replacing data with FD in asset: " + value2 + " read:" + parcelFileDescriptorArrCreatePipe[0] + " write:" + parcelFileDescriptorArrCreatePipe[1]);
                    }
                    putDataRequestZzr.putAsset(entry.getKey(), Asset.createFromFd(parcelFileDescriptorArrCreatePipe[0]));
                    FutureTask<Boolean> futureTaskZza = zza(parcelFileDescriptorArrCreatePipe[1], value2.getData());
                    arrayList.add(futureTaskZza);
                    this.zzbkn.submit(futureTaskZza);
                } catch (IOException e) {
                    throw new IllegalStateException("Unable to create ParcelFileDescriptor for asset in request: " + putDataRequest, e);
                }
            } else if (value2.getUri() != null) {
                try {
                    putDataRequestZzr.putAsset(entry.getKey(), Asset.createFromFd(getContext().getContentResolver().openFileDescriptor(value2.getUri(), "r")));
                } catch (FileNotFoundException e2) {
                    new zzbo.zzq(zzbVar, arrayList).zza(new PutDataResponse(4005, null));
                    Log.w("WearableClient", "Couldn't resolve asset URI: " + value2.getUri());
                    return;
                }
            } else {
                putDataRequestZzr.putAsset(entry.getKey(), value2);
            }
        }
        zzqJ().zza(new zzbo.zzq(zzbVar, arrayList), putDataRequestZzr);
    }

    public void zza(com.google.android.gms.common.api.internal.zza.zzb<Status> zzbVar, String str, Uri uri, long j, long j2) {
        try {
            this.zzbkn.execute(zzb(zzbVar, str, uri, j, j2));
        } catch (RuntimeException e) {
            zzbVar.zzw(new Status(8));
            throw e;
        }
    }

    public void zza(com.google.android.gms.common.api.internal.zza.zzb<Status> zzbVar, String str, Uri uri, boolean z) {
        try {
            this.zzbkn.execute(zzb(zzbVar, str, uri, z));
        } catch (RuntimeException e) {
            zzbVar.zzw(new Status(8));
            throw e;
        }
    }

    public void zza(com.google.android.gms.common.api.internal.zza.zzb<MessageApi.SendMessageResult> zzbVar, String str, String str2, byte[] bArr) throws RemoteException {
        zzqJ().zza(new zzbo.zzt(zzbVar), str, str2, bArr);
    }

    public void zzb(com.google.android.gms.common.api.internal.zza.zzb<CapabilityApi.GetAllCapabilitiesResult> zzbVar, int i) throws RemoteException {
        zzqJ().zza(new zzbo.zzf(zzbVar), i);
    }

    public void zzb(com.google.android.gms.common.api.internal.zza.zzb<DataApi.DeleteDataItemsResult> zzbVar, Uri uri, int i) throws RemoteException {
        zzqJ().zzb(new zzbo.zze(zzbVar), uri, i);
    }

    public void zze(com.google.android.gms.common.api.internal.zza.zzb<ChannelApi.OpenChannelResult> zzbVar, String str, String str2) throws RemoteException {
        zzqJ().zza(new zzbo.zzp(zzbVar), str, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzj
    /* JADX INFO: renamed from: zzew, reason: merged with bridge method [inline-methods] */
    public zzax zzW(IBinder iBinder) {
        return zzax.zza.zzeu(iBinder);
    }

    public void zzg(com.google.android.gms.common.api.internal.zza.zzb<CapabilityApi.GetCapabilityResult> zzbVar, String str, int i) throws RemoteException {
        zzqJ().zza(new zzbo.zzg(zzbVar), str, i);
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzgu() {
        return "com.google.android.gms.wearable.BIND";
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzgv() {
        return "com.google.android.gms.wearable.internal.IWearableService";
    }

    public void zzh(com.google.android.gms.common.api.internal.zza.zzb<Status> zzbVar, String str, int i) throws RemoteException {
        zzqJ().zzb(new zzbo.zzd(zzbVar), str, i);
    }

    public void zzr(com.google.android.gms.common.api.internal.zza.zzb<DataItemBuffer> zzbVar) throws RemoteException {
        zzqJ().zzb(new zzbo.zzl(zzbVar));
    }

    public void zzr(com.google.android.gms.common.api.internal.zza.zzb<CapabilityApi.AddLocalCapabilityResult> zzbVar, String str) throws RemoteException {
        zzqJ().zzd(new zzbo.zza(zzbVar), str);
    }

    public void zzs(com.google.android.gms.common.api.internal.zza.zzb<NodeApi.GetLocalNodeResult> zzbVar) throws RemoteException {
        zzqJ().zzc(new zzbo.zzn(zzbVar));
    }

    public void zzs(com.google.android.gms.common.api.internal.zza.zzb<CapabilityApi.RemoveLocalCapabilityResult> zzbVar, String str) throws RemoteException {
        zzqJ().zze(new zzbo.zzs(zzbVar), str);
    }

    public void zzt(com.google.android.gms.common.api.internal.zza.zzb<NodeApi.GetConnectedNodesResult> zzbVar) throws RemoteException {
        zzqJ().zzd(new zzbo.zzj(zzbVar));
    }

    public void zzt(com.google.android.gms.common.api.internal.zza.zzb<Status> zzbVar, String str) throws RemoteException {
        zzqJ().zzf(new zzbo.zzc(zzbVar), str);
    }

    public void zzu(com.google.android.gms.common.api.internal.zza.zzb<Channel.GetInputStreamResult> zzbVar, String str) throws RemoteException {
        zzt zztVar = new zzt();
        zzqJ().zza(new zzbo.zzh(zzbVar, zztVar), zztVar, str);
    }

    public void zzv(com.google.android.gms.common.api.internal.zza.zzb<Channel.GetOutputStreamResult> zzbVar, String str) throws RemoteException {
        zzt zztVar = new zzt();
        zzqJ().zzb(new zzbo.zzi(zzbVar, zztVar), zztVar, str);
    }
}
