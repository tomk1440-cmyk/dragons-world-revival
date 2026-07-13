package com.google.android.gms.gcm;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.os.Process;
import android.os.RemoteException;
import android.util.Log;
import com.facebook.applinks.AppLinkData;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class GcmTaskService extends Service {
    public static final String SERVICE_ACTION_EXECUTE_TASK = "com.google.android.gms.gcm.ACTION_TASK_READY";
    public static final String SERVICE_ACTION_INITIALIZE = "com.google.android.gms.gcm.SERVICE_ACTION_INITIALIZE";
    public static final String SERVICE_PERMISSION = "com.google.android.gms.permission.BIND_NETWORK_TASK_SERVICE";
    private final Set<String> zzaLI = new HashSet();
    private int zzaLJ;

    private class zza extends Thread {
        private final Bundle mExtras;
        private final String mTag;
        private final zzc zzaLK;

        zza(String str, IBinder iBinder, Bundle bundle) {
            this.mTag = str;
            this.zzaLK = zzc.zza.zzbZ(iBinder);
            this.mExtras = bundle;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            try {
                this.zzaLK.zzhe(GcmTaskService.this.onRunTask(new TaskParams(this.mTag, this.mExtras)));
            } catch (RemoteException e) {
                Log.e("GcmTaskService", "Error reporting result of operation to scheduler for " + this.mTag);
            } finally {
                GcmTaskService.this.zzdY(this.mTag);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzdY(String str) {
        synchronized (this.zzaLI) {
            this.zzaLI.remove(str);
            if (this.zzaLI.size() == 0) {
                stopSelf(this.zzaLJ);
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onInitializeTasks() {
    }

    public abstract int onRunTask(TaskParams taskParams);

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        intent.setExtrasClassLoader(PendingCallback.class.getClassLoader());
        if (SERVICE_ACTION_EXECUTE_TASK.equals(intent.getAction())) {
            String stringExtra = intent.getStringExtra("tag");
            Parcelable parcelableExtra = intent.getParcelableExtra("callback");
            Bundle bundle = (Bundle) intent.getParcelableExtra(AppLinkData.ARGUMENTS_EXTRAS_KEY);
            if (parcelableExtra == null || !(parcelableExtra instanceof PendingCallback)) {
                Log.e("GcmTaskService", getPackageName() + " " + stringExtra + ": Could not process request, invalid callback.");
            } else {
                synchronized (this.zzaLI) {
                    this.zzaLI.add(stringExtra);
                    stopSelf(this.zzaLJ);
                    this.zzaLJ = startId;
                }
                new zza(stringExtra, ((PendingCallback) parcelableExtra).getIBinder(), bundle).start();
            }
        } else if (SERVICE_ACTION_INITIALIZE.equals(intent.getAction())) {
            onInitializeTasks();
            synchronized (this.zzaLI) {
                this.zzaLJ = startId;
                if (this.zzaLI.size() == 0) {
                    stopSelf(this.zzaLJ);
                }
            }
        }
        return 2;
    }
}
