package com.google.android.gms.fitness.service;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.CallSuper;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.internal.service.FitnessDataSourcesRequest;
import com.google.android.gms.fitness.internal.service.FitnessUnregistrationRequest;
import com.google.android.gms.fitness.internal.service.zzc;
import com.google.android.gms.fitness.result.DataSourcesResult;
import com.google.android.gms.internal.zzne;
import com.google.android.gms.internal.zzoi;
import com.google.android.gms.internal.zzow;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class FitnessSensorService extends Service {
    public static final String SERVICE_INTERFACE = "com.google.android.gms.fitness.service.FitnessSensorService";
    private zza zzaBP;

    private static class zza extends zzc.zza {
        private final FitnessSensorService zzaBQ;

        private zza(FitnessSensorService fitnessSensorService) {
            this.zzaBQ = fitnessSensorService;
        }

        @Override // com.google.android.gms.fitness.internal.service.zzc
        public void zza(FitnessDataSourcesRequest fitnessDataSourcesRequest, zzoi zzoiVar) throws RemoteException {
            this.zzaBQ.zzvr();
            zzoiVar.zza(new DataSourcesResult(this.zzaBQ.onFindDataSources(fitnessDataSourcesRequest.getDataTypes()), Status.zzagC));
        }

        @Override // com.google.android.gms.fitness.internal.service.zzc
        public void zza(FitnessUnregistrationRequest fitnessUnregistrationRequest, zzow zzowVar) throws RemoteException {
            this.zzaBQ.zzvr();
            if (this.zzaBQ.onUnregister(fitnessUnregistrationRequest.getDataSource())) {
                zzowVar.zzp(Status.zzagC);
            } else {
                zzowVar.zzp(new Status(13));
            }
        }

        @Override // com.google.android.gms.fitness.internal.service.zzc
        public void zza(FitnessSensorServiceRequest fitnessSensorServiceRequest, zzow zzowVar) throws RemoteException {
            this.zzaBQ.zzvr();
            if (this.zzaBQ.onRegister(fitnessSensorServiceRequest)) {
                zzowVar.zzp(Status.zzagC);
            } else {
                zzowVar.zzp(new Status(13));
            }
        }
    }

    @Override // android.app.Service
    @CallSuper
    public IBinder onBind(Intent intent) {
        if (!SERVICE_INTERFACE.equals(intent.getAction())) {
            return null;
        }
        if (Log.isLoggable("FitnessSensorService", 3)) {
            Log.d("FitnessSensorService", "Intent " + intent + " received by " + getClass().getName());
        }
        return this.zzaBP.asBinder();
    }

    @Override // android.app.Service
    @CallSuper
    public void onCreate() {
        super.onCreate();
        this.zzaBP = new zza();
    }

    public abstract List<DataSource> onFindDataSources(List<DataType> list);

    public abstract boolean onRegister(FitnessSensorServiceRequest fitnessSensorServiceRequest);

    public abstract boolean onUnregister(DataSource dataSource);

    @TargetApi(19)
    protected void zzvr() throws SecurityException {
        int callingUid = Binder.getCallingUid();
        if (zzne.zzsk()) {
            ((AppOpsManager) getSystemService("appops")).checkPackage(callingUid, "com.google.android.gms");
            return;
        }
        String[] packagesForUid = getPackageManager().getPackagesForUid(callingUid);
        if (packagesForUid != null) {
            for (String str : packagesForUid) {
                if (str.equals("com.google.android.gms")) {
                    return;
                }
            }
        }
        throw new SecurityException("Unauthorized caller");
    }
}
