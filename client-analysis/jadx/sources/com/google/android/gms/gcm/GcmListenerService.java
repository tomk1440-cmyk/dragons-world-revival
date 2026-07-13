package com.google.android.gms.gcm;

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import com.facebook.appevents.AppEventsConstants;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public abstract class GcmListenerService extends Service {
    private int zzaLy;
    private final Object zzpV = new Object();
    private int zzaLz = 0;

    private void zzm(Intent intent) {
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("com.google.android.gms.gcm.PENDING_INTENT");
        if (pendingIntent != null) {
            try {
                pendingIntent.send();
            } catch (PendingIntent.CanceledException e) {
                Log.e("GcmListenerService", "Notification pending intent canceled");
            }
        }
        if (zzx(intent.getExtras())) {
            zza.zzf(this, intent);
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.google.android.gms.gcm.GcmListenerService$2] */
    @TargetApi(11)
    private void zzn(final Intent intent) {
        if (Build.VERSION.SDK_INT >= 11) {
            AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() { // from class: com.google.android.gms.gcm.GcmListenerService.1
                @Override // java.lang.Runnable
                public void run() {
                    GcmListenerService.this.zzo(intent);
                }
            });
        } else {
            new AsyncTask<Void, Void, Void>() { // from class: com.google.android.gms.gcm.GcmListenerService.2
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
                public Void doInBackground(Void... voidArr) {
                    GcmListenerService.this.zzo(intent);
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzo(Intent intent) {
        try {
            switch (intent.getAction()) {
                case "com.google.android.c2dm.intent.RECEIVE":
                    zzp(intent);
                    break;
                case "com.google.android.gms.gcm.NOTIFICATION_DISMISS":
                    if (zzx(intent.getExtras())) {
                        zza.zzg(this, intent);
                        break;
                    }
                    break;
                default:
                    Log.d("GcmListenerService", "Unknown intent action: " + intent.getAction());
                    break;
            }
            zzyh();
        } finally {
            GcmReceiver.completeWakefulIntent(intent);
        }
    }

    private void zzp(Intent intent) {
        String stringExtra = intent.getStringExtra("message_type");
        if (stringExtra == null) {
            stringExtra = GoogleCloudMessaging.MESSAGE_TYPE_MESSAGE;
        }
        switch (stringExtra) {
            case "gcm":
                if (zzx(intent.getExtras())) {
                    zza.zze(this, intent);
                }
                zzq(intent);
                break;
            case "deleted_messages":
                onDeletedMessages();
                break;
            case "send_event":
                onMessageSent(intent.getStringExtra("google.message_id"));
                break;
            case "send_error":
                onSendError(intent.getStringExtra("google.message_id"), intent.getStringExtra("error"));
                break;
            default:
                Log.w("GcmListenerService", "Received message with unknown type: " + stringExtra);
                break;
        }
    }

    private void zzq(Intent intent) {
        Bundle extras = intent.getExtras();
        extras.remove("message_type");
        extras.remove("android.support.content.wakelockid");
        if (zzb.zzy(extras)) {
            if (!zzb.zzaI(this)) {
                zzb.zzc(this, getClass()).zzA(extras);
                return;
            } else {
                if (zzx(intent.getExtras())) {
                    zza.zzh(this, intent);
                }
                zzb.zzz(extras);
            }
        }
        String string = extras.getString("from");
        extras.remove("from");
        zzw(extras);
        onMessageReceived(string, extras);
    }

    static void zzw(Bundle bundle) {
        Iterator<String> it = bundle.keySet().iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (next != null && next.startsWith("google.c.")) {
                it.remove();
            }
        }
    }

    static boolean zzx(Bundle bundle) {
        return AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(bundle.getString("google.c.a.e"));
    }

    private void zzyh() {
        synchronized (this.zzpV) {
            this.zzaLz--;
            if (this.zzaLz == 0) {
                zzhd(this.zzaLy);
            }
        }
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return null;
    }

    public void onDeletedMessages() {
    }

    public void onMessageReceived(String from, Bundle data) {
    }

    public void onMessageSent(String msgId) {
    }

    public void onSendError(String msgId, String error) {
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int flags, int startId) {
        synchronized (this.zzpV) {
            this.zzaLy = startId;
            this.zzaLz++;
        }
        if (intent == null) {
            zzyh();
            return 2;
        }
        if ("com.google.android.gms.gcm.NOTIFICATION_OPEN".equals(intent.getAction())) {
            zzm(intent);
            zzyh();
            GcmReceiver.completeWakefulIntent(intent);
        } else {
            zzn(intent);
        }
        return 3;
    }

    boolean zzhd(int i) {
        return stopSelfResult(i);
    }
}
