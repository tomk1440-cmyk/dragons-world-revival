package com.google.android.gms.drive.internal;

import android.content.IntentSender;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;

/* JADX INFO: loaded from: classes.dex */
public class zzl {
    private String zzapg;
    private DriveId zzapj;
    protected MetadataChangeSet zzaqt;
    private Integer zzaqu;
    private final int zzaqv;

    public zzl(int i) {
        this.zzaqv = i;
    }

    public IntentSender build(GoogleApiClient apiClient) {
        com.google.android.gms.common.internal.zzx.zzb(this.zzaqt, "Must provide initial metadata to CreateFileActivityBuilder.");
        com.google.android.gms.common.internal.zzx.zza(apiClient.isConnected(), "Client must be connected");
        zzu zzuVar = (zzu) apiClient.zza(Drive.zzUI);
        this.zzaqt.zzsL().setContext(zzuVar.getContext());
        try {
            return zzuVar.zzte().zza(new CreateFileIntentSenderRequest(this.zzaqt.zzsL(), this.zzaqu == null ? 0 : this.zzaqu.intValue(), this.zzapg, this.zzapj, this.zzaqv));
        } catch (RemoteException e) {
            throw new RuntimeException("Unable to connect Drive Play Service", e);
        }
    }

    public void zza(DriveId driveId) {
        this.zzapj = (DriveId) com.google.android.gms.common.internal.zzx.zzz(driveId);
    }

    public void zza(MetadataChangeSet metadataChangeSet) {
        this.zzaqt = (MetadataChangeSet) com.google.android.gms.common.internal.zzx.zzz(metadataChangeSet);
    }

    public void zzcZ(int i) {
        this.zzaqu = Integer.valueOf(i);
    }

    public void zzdb(String str) {
        this.zzapg = (String) com.google.android.gms.common.internal.zzx.zzz(str);
    }
}
