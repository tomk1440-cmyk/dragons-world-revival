package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.nearby.connection.AppMetadata;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzqj extends zzqm.zza {
    @Override // com.google.android.gms.internal.zzqm
    public void onConnectionRequest(String remoteEndpointId, String remoteDeviceId, String remoteEndpointName, byte[] payload) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.zzqm
    public void onDisconnected(String remoteEndpointId) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.zzqm
    public void onEndpointFound(String endpointId, String deviceId, String applicationId, String name) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.zzqm
    public void onEndpointLost(String endpointId) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.zzqm
    public void onMessageReceived(String remoteEndpointId, byte[] payload, boolean isReliable) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.zzqm
    public void zza(String str, int i, byte[] bArr) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.zzqm
    public void zza(String str, String str2, String str3, String str4, AppMetadata appMetadata) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.zzqm
    public void zzfy(String str) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.zzqm
    public void zziW(int i) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.zzqm
    public void zziX(int i) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.zzqm
    public void zziY(int i) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.zzqm
    public void zziZ(int i) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.zzqm
    public void zzja(int i) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.zzqm
    public void zzm(int i, String str) throws RemoteException {
    }
}
