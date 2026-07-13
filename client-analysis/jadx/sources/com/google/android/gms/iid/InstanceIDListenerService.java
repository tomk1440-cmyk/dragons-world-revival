package com.google.android.gms.iid;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.gcm.GcmReceiver;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class InstanceIDListenerService extends Service {
    MessengerCompat zzaMW = new MessengerCompat(new Handler(Looper.getMainLooper()) { // from class: com.google.android.gms.iid.InstanceIDListenerService.1
        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            InstanceIDListenerService.this.zza(msg, MessengerCompat.zzc(msg));
        }
    });
    BroadcastReceiver zzaMX = new BroadcastReceiver() { // from class: com.google.android.gms.iid.InstanceIDListenerService.2
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (Log.isLoggable("InstanceID", 3)) {
                intent.getStringExtra("registration_id");
                Log.d("InstanceID", "Received GSF callback using dynamic receiver: " + intent.getExtras());
            }
            InstanceIDListenerService.this.zzp(intent);
            InstanceIDListenerService.this.stop();
        }
    };
    int zzaNa;
    int zzaNb;
    static String ACTION = NativeProtocol.WEB_DIALOG_ACTION;
    private static String zzaMY = "google.com/iid";
    private static String zzaMZ = "CMD";
    private static String zzaLH = "gcm.googleapis.com/refresh";

    static void zza(Context context, zzd zzdVar) {
        zzdVar.zzyG();
        Intent intent = new Intent("com.google.android.gms.iid.InstanceID");
        intent.putExtra(zzaMZ, "RST");
        intent.setPackage(context.getPackageName());
        context.startService(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zza(Message message, int i) {
        zzc.zzaN(this);
        getPackageManager();
        if (i == zzc.zzaNi || i == zzc.zzaNh) {
            zzp((Intent) message.obj);
        } else {
            Log.w("InstanceID", "Message from unexpected caller " + i + " mine=" + zzc.zzaNh + " appid=" + zzc.zzaNi);
        }
    }

    static void zzaM(Context context) {
        Intent intent = new Intent("com.google.android.gms.iid.InstanceID");
        intent.setPackage(context.getPackageName());
        intent.putExtra(zzaMZ, "SYNC");
        context.startService(intent);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (intent == null || !"com.google.android.gms.iid.InstanceID".equals(intent.getAction())) {
            return null;
        }
        return this.zzaMW.getBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        IntentFilter intentFilter = new IntentFilter("com.google.android.c2dm.intent.REGISTRATION");
        intentFilter.addCategory(getPackageName());
        registerReceiver(this.zzaMX, intentFilter, "com.google.android.c2dm.permission.RECEIVE", null);
    }

    @Override // android.app.Service
    public void onDestroy() {
        unregisterReceiver(this.zzaMX);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        Intent intent2;
        zzhl(startId);
        if (intent == null) {
            stop();
            return 2;
        }
        try {
            if ("com.google.android.gms.iid.InstanceID".equals(intent.getAction())) {
                if (Build.VERSION.SDK_INT <= 18 && (intent2 = (Intent) intent.getParcelableExtra("GSF")) != null) {
                    startService(intent2);
                    stop();
                    return 1;
                }
                zzp(intent);
            }
            stop();
            if (intent.getStringExtra("from") != null) {
                GcmReceiver.completeWakefulIntent(intent);
            }
            return 2;
        } catch (Throwable th) {
            stop();
            throw th;
        }
    }

    public void onTokenRefresh() {
    }

    void stop() {
        synchronized (this) {
            this.zzaNa--;
            if (this.zzaNa == 0) {
                stopSelf(this.zzaNb);
            }
            if (Log.isLoggable("InstanceID", 3)) {
                Log.d("InstanceID", "Stop " + this.zzaNa + " " + this.zzaNb);
            }
        }
    }

    public void zzal(boolean z) {
        onTokenRefresh();
    }

    void zzhl(int i) {
        synchronized (this) {
            this.zzaNa++;
            if (i > this.zzaNb) {
                this.zzaNb = i;
            }
        }
    }

    public void zzp(Intent intent) {
        InstanceID instanceIDZza;
        String stringExtra = intent.getStringExtra("subtype");
        if (stringExtra == null) {
            instanceIDZza = InstanceID.getInstance(this);
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("subtype", stringExtra);
            instanceIDZza = InstanceID.zza(this, bundle);
        }
        String stringExtra2 = intent.getStringExtra(zzaMZ);
        if (intent.getStringExtra("error") != null || intent.getStringExtra("registration_id") != null) {
            if (Log.isLoggable("InstanceID", 3)) {
                Log.d("InstanceID", "Register result in service " + stringExtra);
            }
            instanceIDZza.zzyC().zzw(intent);
            return;
        }
        if (Log.isLoggable("InstanceID", 3)) {
            Log.d("InstanceID", "Service command " + stringExtra + " " + stringExtra2 + " " + intent.getExtras());
        }
        if (intent.getStringExtra("unregistered") != null) {
            zzd zzdVarZzyB = instanceIDZza.zzyB();
            if (stringExtra == null) {
                stringExtra = "";
            }
            zzdVarZzyB.zzef(stringExtra);
            instanceIDZza.zzyC().zzw(intent);
            return;
        }
        if (zzaLH.equals(intent.getStringExtra("from"))) {
            instanceIDZza.zzyB().zzef(stringExtra);
            zzal(false);
            return;
        }
        if ("RST".equals(stringExtra2)) {
            instanceIDZza.zzyA();
            zzal(true);
            return;
        }
        if ("RST_FULL".equals(stringExtra2)) {
            if (instanceIDZza.zzyB().isEmpty()) {
                return;
            }
            instanceIDZza.zzyB().zzyG();
            zzal(true);
            return;
        }
        if ("SYNC".equals(stringExtra2)) {
            instanceIDZza.zzyB().zzef(stringExtra);
            zzal(false);
        } else if ("PING".equals(stringExtra2)) {
            try {
                GoogleCloudMessaging.getInstance(this).send(zzaMY, zzc.zzyF(), 0L, intent.getExtras());
            } catch (IOException e) {
                Log.w("InstanceID", "Failed to send ping response");
            }
        }
    }
}
