package com.google.android.gms.iid;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/* JADX INFO: loaded from: classes.dex */
public class zzc {
    static String zzaNg = null;
    static int zzaNh = 0;
    static int zzaNi = 0;
    static int zzaNj = 0;
    Context context;
    PendingIntent zzaLQ;
    Messenger zzaLU;
    Map<String, Object> zzaNk = new HashMap();
    Messenger zzaNl;
    MessengerCompat zzaNm;
    long zzaNn;
    long zzaNo;
    int zzaNp;
    int zzaNq;
    long zzaNr;

    public zzc(Context context) {
        this.context = context;
    }

    private void zzE(Object obj) {
        synchronized (getClass()) {
            for (String str : this.zzaNk.keySet()) {
                Object obj2 = this.zzaNk.get(str);
                this.zzaNk.put(str, obj);
                zzg(obj2, obj);
            }
        }
    }

    static String zza(KeyPair keyPair, String... strArr) {
        try {
            byte[] bytes = TextUtils.join("\n", strArr).getBytes("UTF-8");
            try {
                PrivateKey privateKey = keyPair.getPrivate();
                Signature signature = Signature.getInstance(privateKey instanceof RSAPrivateKey ? "SHA256withRSA" : "SHA256withECDSA");
                signature.initSign(privateKey);
                signature.update(bytes);
                return InstanceID.zzn(signature.sign());
            } catch (GeneralSecurityException e) {
                Log.e("InstanceID/Rpc", "Unable to sign registration request", e);
                return null;
            }
        } catch (UnsupportedEncodingException e2) {
            Log.e("InstanceID/Rpc", "Unable to encode string", e2);
            return null;
        }
    }

    public static String zzaN(Context context) {
        if (zzaNg != null) {
            return zzaNg;
        }
        zzaNh = Process.myUid();
        PackageManager packageManager = context.getPackageManager();
        for (ResolveInfo resolveInfo : packageManager.queryIntentServices(new Intent("com.google.android.c2dm.intent.REGISTER"), 0)) {
            if (packageManager.checkPermission("com.google.android.c2dm.permission.RECEIVE", resolveInfo.serviceInfo.packageName) == 0) {
                try {
                    ApplicationInfo applicationInfo = packageManager.getApplicationInfo(resolveInfo.serviceInfo.packageName, 0);
                    Log.w("InstanceID/Rpc", "Found " + applicationInfo.uid);
                    zzaNi = applicationInfo.uid;
                    zzaNg = resolveInfo.serviceInfo.packageName;
                    return zzaNg;
                } catch (PackageManager.NameNotFoundException e) {
                }
            } else {
                Log.w("InstanceID/Rpc", "Possible malicious package " + resolveInfo.serviceInfo.packageName + " declares com.google.android.c2dm.intent.REGISTER without permission");
            }
        }
        Log.w("InstanceID/Rpc", "Failed to resolve REGISTER intent, falling back");
        try {
            ApplicationInfo applicationInfo2 = packageManager.getApplicationInfo("com.google.android.gms", 0);
            zzaNg = applicationInfo2.packageName;
            zzaNi = applicationInfo2.uid;
            return zzaNg;
        } catch (PackageManager.NameNotFoundException e2) {
            try {
                ApplicationInfo applicationInfo3 = packageManager.getApplicationInfo("com.google.android.gsf", 0);
                zzaNg = applicationInfo3.packageName;
                zzaNi = applicationInfo3.uid;
                return zzaNg;
            } catch (PackageManager.NameNotFoundException e3) {
                Log.w("InstanceID/Rpc", "Both Google Play Services and legacy GSF package are missing");
                return null;
            }
        }
    }

    private Intent zzb(Bundle bundle, KeyPair keyPair) throws IOException {
        Intent intent;
        ConditionVariable conditionVariable = new ConditionVariable();
        String strZzyF = zzyF();
        synchronized (getClass()) {
            this.zzaNk.put(strZzyF, conditionVariable);
        }
        zza(bundle, keyPair, strZzyF);
        conditionVariable.block(30000L);
        synchronized (getClass()) {
            Object objRemove = this.zzaNk.remove(strZzyF);
            if (!(objRemove instanceof Intent)) {
                if (objRemove instanceof String) {
                    throw new IOException((String) objRemove);
                }
                Log.w("InstanceID/Rpc", "No response " + objRemove);
                throw new IOException(InstanceID.ERROR_TIMEOUT);
            }
            intent = (Intent) objRemove;
        }
        return intent;
    }

    private void zzea(String str) {
        if ("com.google.android.gsf".equals(zzaNg)) {
            this.zzaNp++;
            if (this.zzaNp >= 3) {
                if (this.zzaNp == 3) {
                    this.zzaNq = new Random().nextInt(1000) + 1000;
                }
                this.zzaNq *= 2;
                this.zzaNr = SystemClock.elapsedRealtime() + ((long) this.zzaNq);
                Log.w("InstanceID/Rpc", "Backoff due to " + str + " for " + this.zzaNq);
            }
        }
    }

    private void zzg(Object obj, Object obj2) {
        if (obj instanceof ConditionVariable) {
            ((ConditionVariable) obj).open();
        }
        if (obj instanceof Messenger) {
            Messenger messenger = (Messenger) obj;
            Message messageObtain = Message.obtain();
            messageObtain.obj = obj2;
            try {
                messenger.send(messageObtain);
            } catch (RemoteException e) {
                Log.w("InstanceID/Rpc", "Failed to send response " + e);
            }
        }
    }

    private void zzi(String str, Object obj) {
        synchronized (getClass()) {
            Object obj2 = this.zzaNk.get(str);
            this.zzaNk.put(str, obj);
            zzg(obj2, obj);
        }
    }

    public static synchronized String zzyF() {
        int i;
        i = zzaNj;
        zzaNj = i + 1;
        return Integer.toString(i);
    }

    Intent zza(Bundle bundle, KeyPair keyPair) throws IOException {
        Intent intentZzb = zzb(bundle, keyPair);
        return (intentZzb == null || !intentZzb.hasExtra("google.messenger")) ? intentZzb : zzb(bundle, keyPair);
    }

    void zza(Bundle bundle, KeyPair keyPair, String str) throws IOException {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (this.zzaNr != 0 && jElapsedRealtime <= this.zzaNr) {
            Log.w("InstanceID/Rpc", "Backoff mode, next request attempt: " + (this.zzaNr - jElapsedRealtime) + " interval: " + this.zzaNq);
            throw new IOException(InstanceID.ERROR_BACKOFF);
        }
        zzyE();
        if (zzaNg == null) {
            throw new IOException(InstanceID.ERROR_MISSING_INSTANCEID_SERVICE);
        }
        this.zzaNn = SystemClock.elapsedRealtime();
        Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
        intent.setPackage(zzaNg);
        bundle.putString("gmsv", Integer.toString(GoogleCloudMessaging.zzaK(this.context)));
        bundle.putString("osv", Integer.toString(Build.VERSION.SDK_INT));
        bundle.putString("app_ver", Integer.toString(InstanceID.zzaL(this.context)));
        bundle.putString("cliv", AppEventsConstants.EVENT_PARAM_VALUE_YES);
        bundle.putString("appid", InstanceID.zza(keyPair));
        String strZzn = InstanceID.zzn(keyPair.getPublic().getEncoded());
        bundle.putString("pub2", strZzn);
        bundle.putString("sig", zza(keyPair, this.context.getPackageName(), strZzn));
        intent.putExtras(bundle);
        zzt(intent);
        zzb(intent, str);
    }

    protected void zzb(Intent intent, String str) {
        this.zzaNn = SystemClock.elapsedRealtime();
        intent.putExtra("kid", "|ID|" + str + "|");
        intent.putExtra("X-kid", "|ID|" + str + "|");
        boolean zEquals = "com.google.android.gsf".equals(zzaNg);
        String stringExtra = intent.getStringExtra("useGsf");
        if (stringExtra != null) {
            zEquals = AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(stringExtra);
        }
        if (Log.isLoggable("InstanceID/Rpc", 3)) {
            Log.d("InstanceID/Rpc", "Sending " + intent.getExtras());
        }
        if (this.zzaNl != null) {
            intent.putExtra("google.messenger", this.zzaLU);
            Message messageObtain = Message.obtain();
            messageObtain.obj = intent;
            try {
                this.zzaNl.send(messageObtain);
                return;
            } catch (RemoteException e) {
                if (Log.isLoggable("InstanceID/Rpc", 3)) {
                    Log.d("InstanceID/Rpc", "Messenger failed, fallback to startService");
                }
            }
        }
        if (zEquals) {
            Intent intent2 = new Intent("com.google.android.gms.iid.InstanceID");
            intent2.setPackage(this.context.getPackageName());
            intent2.putExtra("GSF", intent);
            this.context.startService(intent2);
            return;
        }
        intent.putExtra("google.messenger", this.zzaLU);
        intent.putExtra("messenger2", AppEventsConstants.EVENT_PARAM_VALUE_YES);
        if (this.zzaNm != null) {
            Message messageObtain2 = Message.obtain();
            messageObtain2.obj = intent;
            try {
                this.zzaNm.send(messageObtain2);
                return;
            } catch (RemoteException e2) {
                if (Log.isLoggable("InstanceID/Rpc", 3)) {
                    Log.d("InstanceID/Rpc", "Messenger failed, fallback to startService");
                }
            }
        }
        this.context.startService(intent);
    }

    public void zze(Message message) {
        if (message == null) {
            return;
        }
        if (!(message.obj instanceof Intent)) {
            Log.w("InstanceID/Rpc", "Dropping invalid message");
            return;
        }
        Intent intent = (Intent) message.obj;
        intent.setExtrasClassLoader(MessengerCompat.class.getClassLoader());
        if (intent.hasExtra("google.messenger")) {
            Parcelable parcelableExtra = intent.getParcelableExtra("google.messenger");
            if (parcelableExtra instanceof MessengerCompat) {
                this.zzaNm = (MessengerCompat) parcelableExtra;
            }
            if (parcelableExtra instanceof Messenger) {
                this.zzaNl = (Messenger) parcelableExtra;
            }
        }
        zzw((Intent) message.obj);
    }

    synchronized void zzt(Intent intent) {
        if (this.zzaLQ == null) {
            Intent intent2 = new Intent();
            intent2.setPackage("com.google.example.invalidpackage");
            this.zzaLQ = PendingIntent.getBroadcast(this.context, 0, intent2, 0);
        }
        intent.putExtra(SettingsJsonConstants.APP_KEY, this.zzaLQ);
    }

    String zzu(Intent intent) throws IOException {
        if (intent == null) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
        String stringExtra = intent.getStringExtra("registration_id");
        if (stringExtra == null) {
            stringExtra = intent.getStringExtra("unregistered");
        }
        intent.getLongExtra("Retry-After", 0L);
        if (stringExtra != null) {
        }
        if (stringExtra != null) {
            return stringExtra;
        }
        String stringExtra2 = intent.getStringExtra("error");
        if (stringExtra2 != null) {
            throw new IOException(stringExtra2);
        }
        Log.w("InstanceID/Rpc", "Unexpected response from GCM " + intent.getExtras(), new Throwable());
        throw new IOException("SERVICE_NOT_AVAILABLE");
    }

    void zzv(Intent intent) {
        String stringExtra = intent.getStringExtra("error");
        if (stringExtra == null) {
            Log.w("InstanceID/Rpc", "Unexpected response, no error or registration id " + intent.getExtras());
            return;
        }
        if (Log.isLoggable("InstanceID/Rpc", 3)) {
            Log.d("InstanceID/Rpc", "Received InstanceID error " + stringExtra);
        }
        String str = null;
        if (stringExtra.startsWith("|")) {
            String[] strArrSplit = stringExtra.split("\\|");
            if (!"ID".equals(strArrSplit[1])) {
                Log.w("InstanceID/Rpc", "Unexpected structured response " + stringExtra);
            }
            if (strArrSplit.length > 2) {
                str = strArrSplit[2];
                stringExtra = strArrSplit[3];
                if (stringExtra.startsWith(":")) {
                    stringExtra = stringExtra.substring(1);
                }
            } else {
                stringExtra = "UNKNOWN";
            }
            intent.putExtra("error", stringExtra);
        }
        if (str == null) {
            zzE(stringExtra);
        } else {
            zzi(str, stringExtra);
        }
        long longExtra = intent.getLongExtra("Retry-After", 0L);
        if (longExtra > 0) {
            this.zzaNo = SystemClock.elapsedRealtime();
            this.zzaNq = ((int) longExtra) * 1000;
            this.zzaNr = SystemClock.elapsedRealtime() + ((long) this.zzaNq);
            Log.w("InstanceID/Rpc", "Explicit request from server to backoff: " + this.zzaNq);
            return;
        }
        if ("SERVICE_NOT_AVAILABLE".equals(stringExtra) || "AUTHENTICATION_FAILED".equals(stringExtra)) {
            zzea(stringExtra);
        }
    }

    void zzw(Intent intent) {
        if (intent == null) {
            if (Log.isLoggable("InstanceID/Rpc", 3)) {
                Log.d("InstanceID/Rpc", "Unexpected response: null");
                return;
            }
            return;
        }
        String action = intent.getAction();
        if (!"com.google.android.c2dm.intent.REGISTRATION".equals(action) && !"com.google.android.gms.iid.InstanceID".equals(action)) {
            if (Log.isLoggable("InstanceID/Rpc", 3)) {
                Log.d("InstanceID/Rpc", "Unexpected response " + intent.getAction());
                return;
            }
            return;
        }
        String stringExtra = intent.getStringExtra("registration_id");
        String stringExtra2 = stringExtra == null ? intent.getStringExtra("unregistered") : stringExtra;
        if (stringExtra2 == null) {
            zzv(intent);
            return;
        }
        this.zzaNn = SystemClock.elapsedRealtime();
        this.zzaNr = 0L;
        this.zzaNp = 0;
        this.zzaNq = 0;
        if (Log.isLoggable("InstanceID/Rpc", 3)) {
            Log.d("InstanceID/Rpc", "AppIDResponse: " + stringExtra2 + " " + intent.getExtras());
        }
        String str = null;
        if (stringExtra2.startsWith("|")) {
            String[] strArrSplit = stringExtra2.split("\\|");
            if (!"ID".equals(strArrSplit[1])) {
                Log.w("InstanceID/Rpc", "Unexpected structured response " + stringExtra2);
            }
            String str2 = strArrSplit[2];
            if (strArrSplit.length > 4) {
                if ("SYNC".equals(strArrSplit[3])) {
                    InstanceIDListenerService.zzaM(this.context);
                } else if ("RST".equals(strArrSplit[3])) {
                    InstanceIDListenerService.zza(this.context, InstanceID.getInstance(this.context).zzyB());
                    intent.removeExtra("registration_id");
                    zzi(str2, intent);
                    return;
                }
            }
            String strSubstring = strArrSplit[strArrSplit.length - 1];
            if (strSubstring.startsWith(":")) {
                strSubstring = strSubstring.substring(1);
            }
            intent.putExtra("registration_id", strSubstring);
            str = str2;
        }
        if (str == null) {
            zzE(intent);
        } else {
            zzi(str, intent);
        }
    }

    void zzyE() {
        if (this.zzaLU != null) {
            return;
        }
        zzaN(this.context);
        this.zzaLU = new Messenger(new Handler(Looper.getMainLooper()) { // from class: com.google.android.gms.iid.zzc.1
            @Override // android.os.Handler
            public void handleMessage(Message msg) {
                zzc.this.zze(msg);
            }
        });
    }
}
