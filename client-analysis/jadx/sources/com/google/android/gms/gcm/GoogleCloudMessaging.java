package com.google.android.gms.gcm;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.support.annotation.RequiresPermission;
import android.util.Log;
import com.google.android.gms.iid.InstanceID;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class GoogleCloudMessaging {
    public static final String ERROR_MAIN_THREAD = "MAIN_THREAD";
    public static final String ERROR_SERVICE_NOT_AVAILABLE = "SERVICE_NOT_AVAILABLE";
    public static final String INSTANCE_ID_SCOPE = "GCM";

    @Deprecated
    public static final String MESSAGE_TYPE_DELETED = "deleted_messages";

    @Deprecated
    public static final String MESSAGE_TYPE_MESSAGE = "gcm";

    @Deprecated
    public static final String MESSAGE_TYPE_SEND_ERROR = "send_error";

    @Deprecated
    public static final String MESSAGE_TYPE_SEND_EVENT = "send_event";
    static GoogleCloudMessaging zzaLP;
    private Context context;
    private PendingIntent zzaLQ;
    public static int zzaLM = 5000000;
    public static int zzaLN = 6500000;
    public static int zzaLO = 7000000;
    private static final AtomicInteger zzaLS = new AtomicInteger(1);
    private final BlockingQueue<Intent> zzaLT = new LinkedBlockingQueue();
    private Map<String, Handler> zzaLR = Collections.synchronizedMap(new HashMap());
    final Messenger zzaLU = new Messenger(new Handler(Looper.getMainLooper()) { // from class: com.google.android.gms.gcm.GoogleCloudMessaging.1
        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            if (msg == null || !(msg.obj instanceof Intent)) {
                Log.w(GoogleCloudMessaging.INSTANCE_ID_SCOPE, "Dropping invalid message");
            }
            Intent intent = (Intent) msg.obj;
            if ("com.google.android.c2dm.intent.REGISTRATION".equals(intent.getAction())) {
                GoogleCloudMessaging.this.zzaLT.add(intent);
            } else {
                if (GoogleCloudMessaging.this.zzr(intent)) {
                    return;
                }
                intent.setPackage(GoogleCloudMessaging.this.context.getPackageName());
                GoogleCloudMessaging.this.context.sendBroadcast(intent);
            }
        }
    });

    public static synchronized GoogleCloudMessaging getInstance(Context context) {
        if (zzaLP == null) {
            zzaLP = new GoogleCloudMessaging();
            zzaLP.context = context.getApplicationContext();
        }
        return zzaLP;
    }

    static String zza(Intent intent, String str) throws IOException {
        if (intent == null) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
        String stringExtra = intent.getStringExtra(str);
        if (stringExtra != null) {
            return stringExtra;
        }
        String stringExtra2 = intent.getStringExtra("error");
        if (stringExtra2 != null) {
            throw new IOException(stringExtra2);
        }
        throw new IOException("SERVICE_NOT_AVAILABLE");
    }

    private void zza(String str, String str2, long j, int i, Bundle bundle) throws IOException {
        if (str == null) {
            throw new IllegalArgumentException("Missing 'to'");
        }
        Intent intent = new Intent("com.google.android.gcm.intent.SEND");
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        zzs(intent);
        intent.setPackage(zzaJ(this.context));
        intent.putExtra("google.to", str);
        intent.putExtra("google.message_id", str2);
        intent.putExtra("google.ttl", Long.toString(j));
        intent.putExtra("google.delay", Integer.toString(i));
        intent.putExtra("google.from", zzdZ(str));
        if (!zzaJ(this.context).contains(".gsf")) {
            this.context.sendOrderedBroadcast(intent, "com.google.android.gtalkservice.permission.GTALK_SERVICE");
            return;
        }
        Bundle bundle2 = new Bundle();
        for (String str3 : bundle.keySet()) {
            Object obj = bundle.get(str3);
            if (obj instanceof String) {
                bundle2.putString("gcm." + str3, (String) obj);
            }
        }
        bundle2.putString("google.to", str);
        bundle2.putString("google.message_id", str2);
        InstanceID.getInstance(this.context).zzc(INSTANCE_ID_SCOPE, "upstream", bundle2);
    }

    public static String zzaJ(Context context) {
        return com.google.android.gms.iid.zzc.zzaN(context);
    }

    public static int zzaK(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(zzaJ(context), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            return -1;
        }
    }

    private String zzdZ(String str) {
        int iIndexOf = str.indexOf(64);
        if (iIndexOf > 0) {
            str = str.substring(0, iIndexOf);
        }
        return InstanceID.getInstance(this.context).zzyB().zzi("", str, INSTANCE_ID_SCOPE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean zzr(Intent intent) {
        Handler handlerRemove;
        String stringExtra = intent.getStringExtra("In-Reply-To");
        if (stringExtra == null && intent.hasExtra("error")) {
            stringExtra = intent.getStringExtra("google.message_id");
        }
        if (stringExtra == null || (handlerRemove = this.zzaLR.remove(stringExtra)) == null) {
            return false;
        }
        Message messageObtain = Message.obtain();
        messageObtain.obj = intent;
        return handlerRemove.sendMessage(messageObtain);
    }

    private String zzyk() {
        return "google.rpc" + String.valueOf(zzaLS.getAndIncrement());
    }

    public void close() {
        zzaLP = null;
        zzb.zzaLC = null;
        zzyl();
    }

    public String getMessageType(Intent intent) {
        if (!"com.google.android.c2dm.intent.RECEIVE".equals(intent.getAction())) {
            return null;
        }
        String stringExtra = intent.getStringExtra("message_type");
        return stringExtra == null ? MESSAGE_TYPE_MESSAGE : stringExtra;
    }

    @RequiresPermission("com.google.android.c2dm.permission.RECEIVE")
    @Deprecated
    public synchronized String register(String... senderIds) throws IOException {
        String strZza;
        String strZzc = zzc(senderIds);
        Bundle bundle = new Bundle();
        if (zzaJ(this.context).contains(".gsf")) {
            bundle.putString("legacy.sender", strZzc);
            strZza = InstanceID.getInstance(this.context).getToken(strZzc, INSTANCE_ID_SCOPE, bundle);
        } else {
            bundle.putString("sender", strZzc);
            strZza = zza(zzE(bundle), "registration_id");
        }
        return strZza;
    }

    @RequiresPermission("com.google.android.c2dm.permission.RECEIVE")
    public void send(String to, String msgId, long timeToLive, Bundle data) throws IOException {
        zza(to, msgId, timeToLive, -1, data);
    }

    @RequiresPermission("com.google.android.c2dm.permission.RECEIVE")
    public void send(String to, String msgId, Bundle data) throws IOException {
        send(to, msgId, -1L, data);
    }

    @RequiresPermission("com.google.android.c2dm.permission.RECEIVE")
    @Deprecated
    public synchronized void unregister() throws IOException {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        }
        InstanceID.getInstance(this.context).deleteInstanceID();
    }

    @Deprecated
    Intent zzE(Bundle bundle) throws IOException {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        }
        if (zzaK(this.context) < 0) {
            throw new IOException("Google Play Services missing");
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
        intent.setPackage(zzaJ(this.context));
        zzs(intent);
        intent.putExtra("google.message_id", zzyk());
        intent.putExtras(bundle);
        intent.putExtra("google.messenger", this.zzaLU);
        this.context.startService(intent);
        try {
            return this.zzaLT.poll(30000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            throw new IOException(e.getMessage());
        }
    }

    String zzc(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            throw new IllegalArgumentException("No senderIds");
        }
        StringBuilder sb = new StringBuilder(strArr[0]);
        for (int i = 1; i < strArr.length; i++) {
            sb.append(',').append(strArr[i]);
        }
        return sb.toString();
    }

    synchronized void zzs(Intent intent) {
        if (this.zzaLQ == null) {
            Intent intent2 = new Intent();
            intent2.setPackage("com.google.example.invalidpackage");
            this.zzaLQ = PendingIntent.getBroadcast(this.context, 0, intent2, 0);
        }
        intent.putExtra(SettingsJsonConstants.APP_KEY, this.zzaLQ);
    }

    synchronized void zzyl() {
        if (this.zzaLQ != null) {
            this.zzaLQ.cancel();
            this.zzaLQ = null;
        }
    }
}
