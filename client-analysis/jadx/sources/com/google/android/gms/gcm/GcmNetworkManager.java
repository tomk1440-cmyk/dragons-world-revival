package com.google.android.gms.gcm;

import android.app.PendingIntent;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.zzx;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class GcmNetworkManager {
    public static final int RESULT_FAILURE = 2;
    public static final int RESULT_RESCHEDULE = 1;
    public static final int RESULT_SUCCESS = 0;
    private static GcmNetworkManager zzaLB;
    private Context mContext;
    private final PendingIntent mPendingIntent;

    private GcmNetworkManager(Context context) {
        this.mContext = context;
        this.mPendingIntent = PendingIntent.getBroadcast(this.mContext, 0, new Intent(), 0);
    }

    public static GcmNetworkManager getInstance(Context context) {
        GcmNetworkManager gcmNetworkManager;
        synchronized (GcmNetworkManager.class) {
            if (zzaLB == null) {
                zzaLB = new GcmNetworkManager(context.getApplicationContext());
            }
            gcmNetworkManager = zzaLB;
        }
        return gcmNetworkManager;
    }

    static void zzdT(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Must provide a valid tag.");
        }
        if (100 < str.length()) {
            throw new IllegalArgumentException("Tag is larger than max permissible tag length (100)");
        }
    }

    private void zzdU(String str) {
        boolean z = true;
        zzx.zzb(str, "GcmTaskService must not be null.");
        Intent intent = new Intent(GcmTaskService.SERVICE_ACTION_EXECUTE_TASK);
        intent.setPackage(this.mContext.getPackageName());
        List<ResolveInfo> listQueryIntentServices = this.mContext.getPackageManager().queryIntentServices(intent, 0);
        zzx.zzb((listQueryIntentServices == null || listQueryIntentServices.size() == 0) ? false : true, "There is no GcmTaskService component registered within this package. Have you extended GcmTaskService correctly?");
        Iterator<ResolveInfo> it = listQueryIntentServices.iterator();
        while (it.hasNext()) {
            if (it.next().serviceInfo.name.equals(str)) {
                zzx.zzb(z, "The GcmTaskService class you provided " + str + " does not seem to support receiving com.google.android.gms.gcm.ACTION_TASK_READY.");
            }
        }
        z = false;
        zzx.zzb(z, "The GcmTaskService class you provided " + str + " does not seem to support receiving com.google.android.gms.gcm.ACTION_TASK_READY.");
    }

    private Intent zzyi() {
        int iZzaK = GoogleCloudMessaging.zzaK(this.mContext);
        if (iZzaK < GoogleCloudMessaging.zzaLM) {
            Log.e("GcmNetworkManager", "Google Play Services is not available, dropping GcmNetworkManager request. code=" + iZzaK);
            return null;
        }
        Intent intent = new Intent("com.google.android.gms.gcm.ACTION_SCHEDULE");
        intent.setPackage(GoogleCloudMessaging.zzaJ(this.mContext));
        intent.putExtra(SettingsJsonConstants.APP_KEY, this.mPendingIntent);
        return intent;
    }

    public void cancelAllTasks(Class<? extends GcmTaskService> gcmTaskService) {
        zzc(gcmTaskService);
    }

    public void cancelTask(String tag, Class<? extends GcmTaskService> gcmTaskService) {
        zza(tag, gcmTaskService);
    }

    public void schedule(Task task) {
        zzdU(task.getServiceName());
        Intent intentZzyi = zzyi();
        if (intentZzyi == null) {
            return;
        }
        Bundle extras = intentZzyi.getExtras();
        extras.putString("scheduler_action", "SCHEDULE_TASK");
        task.toBundle(extras);
        intentZzyi.putExtras(extras);
        this.mContext.sendBroadcast(intentZzyi);
    }

    public void zza(String str, Class<? extends Service> cls) {
        zzdT(str);
        zzdU(cls.getName());
        Intent intentZzyi = zzyi();
        if (intentZzyi == null) {
            return;
        }
        intentZzyi.putExtra("scheduler_action", "CANCEL_TASK");
        intentZzyi.putExtra("tag", str);
        intentZzyi.putExtra("component", new ComponentName(this.mContext, cls));
        this.mContext.sendBroadcast(intentZzyi);
    }

    public void zzc(Class<? extends Service> cls) {
        zzdU(cls.getName());
        Intent intentZzyi = zzyi();
        if (intentZzyi == null) {
            return;
        }
        intentZzyi.putExtra("scheduler_action", "CANCEL_ALL");
        intentZzyi.putExtra("component", new ComponentName(this.mContext, cls));
        this.mContext.sendBroadcast(intentZzyi);
    }
}
