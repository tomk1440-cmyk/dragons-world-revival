package com.google.android.gms.drive.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Looper;
import android.os.Process;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.ChangeListener;
import com.google.android.gms.drive.events.DriveEventService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class zzu extends com.google.android.gms.common.internal.zzj<zzam> {
    private final String zzUW;
    final GoogleApiClient.ConnectionCallbacks zzalF;
    private final Bundle zzaqK;
    private final boolean zzaqL;
    private volatile DriveId zzaqM;
    private volatile DriveId zzaqN;
    private volatile boolean zzaqO;
    final Map<DriveId, Map<ChangeListener, zzae>> zzaqP;
    final Map<com.google.android.gms.drive.events.zzc, zzae> zzaqQ;
    final Map<DriveId, Map<com.google.android.gms.drive.events.zzi, zzae>> zzaqR;
    final Map<DriveId, Map<com.google.android.gms.drive.events.zzi, zzae>> zzaqS;

    public zzu(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, Bundle bundle) {
        super(context, looper, 11, zzfVar, connectionCallbacks, onConnectionFailedListener);
        this.zzaqO = false;
        this.zzaqP = new HashMap();
        this.zzaqQ = new HashMap();
        this.zzaqR = new HashMap();
        this.zzaqS = new HashMap();
        this.zzUW = zzfVar.zzqv();
        this.zzalF = connectionCallbacks;
        this.zzaqK = bundle;
        Intent intent = new Intent(DriveEventService.ACTION_HANDLE_EVENT);
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> listQueryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        switch (listQueryIntentServices.size()) {
            case 0:
                this.zzaqL = false;
                return;
            case 1:
                ServiceInfo serviceInfo = listQueryIntentServices.get(0).serviceInfo;
                if (!serviceInfo.exported) {
                    throw new IllegalStateException("Drive event service " + serviceInfo.name + " must be exported in AndroidManifest.xml");
                }
                this.zzaqL = true;
                return;
            default:
                throw new IllegalStateException("AndroidManifest.xml can only define one service that handles the " + intent.getAction() + " action");
        }
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, final int i, final DriveId driveId) {
        com.google.android.gms.common.internal.zzx.zzac(com.google.android.gms.drive.events.zzg.zza(i, driveId));
        com.google.android.gms.common.internal.zzx.zza(isConnected(), "Client must be connected");
        return googleApiClient.zzb(new zzt.zza(googleApiClient) { // from class: com.google.android.gms.drive.internal.zzu.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzu zzuVar) throws RemoteException {
                zzuVar.zzte().zza(new RemoveEventListenerRequest(driveId, i), (zzao) null, (String) null, new zzbu(this));
            }
        });
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, final AddEventListenerRequest addEventListenerRequest) {
        com.google.android.gms.common.internal.zzx.zzac(com.google.android.gms.drive.events.zzg.zza(addEventListenerRequest.getEventType(), addEventListenerRequest.getDriveId()));
        com.google.android.gms.common.internal.zzx.zza(isConnected(), "Client must be connected");
        if (this.zzaqL) {
            return googleApiClient.zzb(new zzt.zza(googleApiClient) { // from class: com.google.android.gms.drive.internal.zzu.3
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
                public void zza(zzu zzuVar) throws RemoteException {
                    zzuVar.zzte().zza(addEventListenerRequest, (zzao) null, (String) null, new zzbu(this));
                }
            });
        }
        throw new IllegalStateException("Application must define an exported DriveEventService subclass in AndroidManifest.xml to add event subscriptions");
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, final AddEventListenerRequest addEventListenerRequest, final zzae zzaeVar) {
        return googleApiClient.zzb(new zzt.zza(googleApiClient) { // from class: com.google.android.gms.drive.internal.zzu.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzu zzuVar) throws RemoteException {
                zzuVar.zzte().zza(addEventListenerRequest, zzaeVar, (String) null, new zzbu(this));
            }
        });
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, final RemoveEventListenerRequest removeEventListenerRequest, final zzae zzaeVar) {
        return googleApiClient.zzb(new zzt.zza(googleApiClient) { // from class: com.google.android.gms.drive.internal.zzu.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzu zzuVar) throws RemoteException {
                zzuVar.zzte().zza(removeEventListenerRequest, zzaeVar, (String) null, new zzbu(this));
            }
        });
    }

    PendingResult<Status> cancelPendingActions(GoogleApiClient apiClient, final List<String> pendingTags) {
        com.google.android.gms.common.internal.zzx.zzac(pendingTags != null);
        com.google.android.gms.common.internal.zzx.zzac(pendingTags.isEmpty() ? false : true);
        com.google.android.gms.common.internal.zzx.zza(isConnected(), "Client must be connected");
        return apiClient.zzb(new zzt.zza(apiClient) { // from class: com.google.android.gms.drive.internal.zzu.5
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzu zzuVar) throws RemoteException {
                zzuVar.zzte().zza(new CancelPendingActionsRequest(pendingTags), new zzbu(this));
            }
        });
    }

    @Override // com.google.android.gms.common.internal.zzj, com.google.android.gms.common.api.Api.zzb
    public void disconnect() {
        if (isConnected()) {
            try {
                zzqJ().zza(new DisconnectRequest());
            } catch (RemoteException e) {
            }
        }
        super.disconnect();
        synchronized (this.zzaqP) {
            this.zzaqP.clear();
        }
        synchronized (this.zzaqQ) {
            this.zzaqQ.clear();
        }
        synchronized (this.zzaqR) {
            this.zzaqR.clear();
        }
        synchronized (this.zzaqS) {
            this.zzaqS.clear();
        }
    }

    PendingResult<Status> zza(GoogleApiClient googleApiClient, DriveId driveId) {
        return zza(googleApiClient, new AddEventListenerRequest(1, driveId));
    }

    PendingResult<Status> zza(GoogleApiClient googleApiClient, DriveId driveId, ChangeListener changeListener) {
        Map<ChangeListener, zzae> map;
        PendingResult<Status> zzjVar;
        com.google.android.gms.common.internal.zzx.zzac(com.google.android.gms.drive.events.zzg.zza(1, driveId));
        com.google.android.gms.common.internal.zzx.zzb(changeListener, "listener");
        com.google.android.gms.common.internal.zzx.zza(isConnected(), "Client must be connected");
        synchronized (this.zzaqP) {
            Map<ChangeListener, zzae> map2 = this.zzaqP.get(driveId);
            if (map2 == null) {
                HashMap map3 = new HashMap();
                this.zzaqP.put(driveId, map3);
                map = map3;
            } else {
                map = map2;
            }
            zzae zzaeVar = map.get(changeListener);
            if (zzaeVar == null) {
                zzaeVar = new zzae(getLooper(), getContext(), 1, changeListener);
                map.put(changeListener, zzaeVar);
            } else if (zzaeVar.zzdh(1)) {
                zzjVar = new zzs.zzj(googleApiClient, Status.zzagC);
            }
            zzaeVar.zzdg(1);
            zzjVar = zza(googleApiClient, new AddEventListenerRequest(1, driveId), zzaeVar);
        }
        return zzjVar;
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected void zza(int i, IBinder iBinder, Bundle bundle, int i2) {
        if (bundle != null) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.zzaqM = (DriveId) bundle.getParcelable("com.google.android.gms.drive.root_id");
            this.zzaqN = (DriveId) bundle.getParcelable("com.google.android.gms.drive.appdata_id");
            this.zzaqO = true;
        }
        super.zza(i, iBinder, bundle, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzj
    /* JADX INFO: renamed from: zzaZ, reason: merged with bridge method [inline-methods] */
    public zzam zzW(IBinder iBinder) {
        return zzam.zza.zzba(iBinder);
    }

    PendingResult<Status> zzb(GoogleApiClient googleApiClient, DriveId driveId) {
        return zza(googleApiClient, 1, driveId);
    }

    PendingResult<Status> zzb(GoogleApiClient googleApiClient, DriveId driveId, ChangeListener changeListener) {
        PendingResult<Status> pendingResultZza;
        com.google.android.gms.common.internal.zzx.zzac(com.google.android.gms.drive.events.zzg.zza(1, driveId));
        com.google.android.gms.common.internal.zzx.zza(isConnected(), "Client must be connected");
        com.google.android.gms.common.internal.zzx.zzb(changeListener, "listener");
        synchronized (this.zzaqP) {
            Map<ChangeListener, zzae> map = this.zzaqP.get(driveId);
            if (map == null) {
                pendingResultZza = new zzs.zzj(googleApiClient, Status.zzagC);
            } else {
                zzae zzaeVarRemove = map.remove(changeListener);
                if (zzaeVarRemove == null) {
                    pendingResultZza = new zzs.zzj(googleApiClient, Status.zzagC);
                } else {
                    if (map.isEmpty()) {
                        this.zzaqP.remove(driveId);
                    }
                    pendingResultZza = zza(googleApiClient, new RemoveEventListenerRequest(driveId, 1), zzaeVarRemove);
                }
            }
        }
        return pendingResultZza;
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzgu() {
        return "com.google.android.gms.drive.ApiService.START";
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzgv() {
        return "com.google.android.gms.drive.internal.IDriveService";
    }

    @Override // com.google.android.gms.common.internal.zzj, com.google.android.gms.common.api.Api.zzb
    public boolean zzmE() {
        return (getContext().getPackageName().equals(this.zzUW) && zztd()) ? false : true;
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected Bundle zzml() {
        String packageName = getContext().getPackageName();
        com.google.android.gms.common.internal.zzx.zzz(packageName);
        com.google.android.gms.common.internal.zzx.zzab(!zzqH().zzqt().isEmpty());
        Bundle bundle = new Bundle();
        if (!packageName.equals(this.zzUW)) {
            bundle.putString("proxy_package_name", this.zzUW);
        }
        bundle.putAll(this.zzaqK);
        return bundle;
    }

    @Override // com.google.android.gms.common.internal.zzj
    public boolean zzqK() {
        return true;
    }

    boolean zztd() {
        return GooglePlayServicesUtil.zzf(getContext(), Process.myUid());
    }

    public zzam zzte() throws DeadObjectException {
        return zzqJ();
    }

    public DriveId zztf() {
        return this.zzaqM;
    }

    public DriveId zztg() {
        return this.zzaqN;
    }

    public boolean zzth() {
        return this.zzaqO;
    }

    public boolean zzti() {
        return this.zzaqL;
    }
}
