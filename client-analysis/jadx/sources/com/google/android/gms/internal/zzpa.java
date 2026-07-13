package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.BleApi;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.request.BleScanCallback;
import com.google.android.gms.fitness.request.ClaimBleDeviceRequest;
import com.google.android.gms.fitness.request.ListClaimedBleDevicesRequest;
import com.google.android.gms.fitness.request.StartBleScanRequest;
import com.google.android.gms.fitness.request.StopBleScanRequest;
import com.google.android.gms.fitness.request.UnclaimBleDeviceRequest;
import com.google.android.gms.fitness.result.BleDevicesResult;

/* JADX INFO: loaded from: classes.dex */
public class zzpa implements BleApi {

    private static class zza extends zzpj.zza {
        private final com.google.android.gms.common.api.internal.zza.zzb<BleDevicesResult> zzamC;

        private zza(com.google.android.gms.common.api.internal.zza.zzb<BleDevicesResult> zzbVar) {
            this.zzamC = zzbVar;
        }

        @Override // com.google.android.gms.internal.zzpj
        public void zza(BleDevicesResult bleDevicesResult) {
            this.zzamC.zzs(bleDevicesResult);
        }
    }

    @Override // com.google.android.gms.fitness.BleApi
    public PendingResult<Status> claimBleDevice(GoogleApiClient client, final BleDevice bleDevice) {
        return client.zzb(new zznz.zzc(client) { // from class: com.google.android.gms.internal.zzpa.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zznz zznzVar) throws RemoteException {
                ((zzok) zznzVar.zzqJ()).zza(new ClaimBleDeviceRequest(bleDevice.getAddress(), bleDevice, new zzph(this)));
            }
        });
    }

    @Override // com.google.android.gms.fitness.BleApi
    public PendingResult<Status> claimBleDevice(GoogleApiClient client, final String deviceAddress) {
        return client.zzb(new zznz.zzc(client) { // from class: com.google.android.gms.internal.zzpa.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zznz zznzVar) throws RemoteException {
                ((zzok) zznzVar.zzqJ()).zza(new ClaimBleDeviceRequest(deviceAddress, null, new zzph(this)));
            }
        });
    }

    @Override // com.google.android.gms.fitness.BleApi
    public PendingResult<BleDevicesResult> listClaimedBleDevices(GoogleApiClient client) {
        return client.zza(new zznz.zza<BleDevicesResult>(client) { // from class: com.google.android.gms.internal.zzpa.6
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zzb
            /* JADX INFO: renamed from: zzI, reason: merged with bridge method [inline-methods] */
            public BleDevicesResult zzc(Status status) {
                return BleDevicesResult.zzQ(status);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zznz zznzVar) throws RemoteException {
                ((zzok) zznzVar.zzqJ()).zza(new ListClaimedBleDevicesRequest(new zza(this)));
            }
        });
    }

    @Override // com.google.android.gms.fitness.BleApi
    public PendingResult<Status> startBleScan(GoogleApiClient client, final StartBleScanRequest request) {
        return client.zza(new zznz.zzc(client) { // from class: com.google.android.gms.internal.zzpa.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zznz zznzVar) throws RemoteException {
                ((zzok) zznzVar.zzqJ()).zza(new StartBleScanRequest(request, new zzph(this)));
            }
        });
    }

    @Override // com.google.android.gms.fitness.BleApi
    public PendingResult<Status> stopBleScan(GoogleApiClient client, final BleScanCallback requestCallback) {
        return client.zza(new zznz.zzc(client) { // from class: com.google.android.gms.internal.zzpa.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zznz zznzVar) throws RemoteException {
                ((zzok) zznzVar.zzqJ()).zza(new StopBleScanRequest(requestCallback, new zzph(this)));
            }
        });
    }

    @Override // com.google.android.gms.fitness.BleApi
    public PendingResult<Status> unclaimBleDevice(GoogleApiClient client, BleDevice bleDevice) {
        return unclaimBleDevice(client, bleDevice.getAddress());
    }

    @Override // com.google.android.gms.fitness.BleApi
    public PendingResult<Status> unclaimBleDevice(GoogleApiClient client, final String deviceAddress) {
        return client.zzb(new zznz.zzc(client) { // from class: com.google.android.gms.internal.zzpa.5
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zznz zznzVar) throws RemoteException {
                ((zzok) zznzVar.zzqJ()).zza(new UnclaimBleDeviceRequest(deviceAddress, new zzph(this)));
            }
        });
    }
}
