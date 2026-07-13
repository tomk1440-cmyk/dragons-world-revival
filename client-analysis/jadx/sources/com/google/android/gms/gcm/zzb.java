package com.google.android.gms.gcm;

import android.R;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.drive.DriveFile;
import java.util.Iterator;
import java.util.List;
import java.util.MissingFormatArgumentException;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes.dex */
class zzb {
    static zzb zzaLC;
    private final Context mContext;
    private final Class<? extends GcmListenerService> zzaLD;

    private class zza extends IllegalArgumentException {
    }

    private zzb(Context context, Class<? extends GcmListenerService> cls) {
        this.mContext = context.getApplicationContext();
        this.zzaLD = cls;
    }

    private Notification zzB(Bundle bundle) {
        String strZzf = zzf(bundle, "gcm.n.title");
        String strZzf2 = zzf(bundle, "gcm.n.body");
        int iZzdW = zzdW(zze(bundle, "gcm.n.icon"));
        String strZze = zze(bundle, "gcm.n.color");
        Uri uriZzdX = zzdX(zze(bundle, "gcm.n.sound2"));
        PendingIntent pendingIntentZzC = zzC(bundle);
        PendingIntent pendingIntentZzD = null;
        if (GcmListenerService.zzx(bundle)) {
            pendingIntentZzC = zza(bundle, pendingIntentZzC);
            pendingIntentZzD = zzD(bundle);
        }
        NotificationCompat.Builder smallIcon = new NotificationCompat.Builder(this.mContext).setAutoCancel(true).setSmallIcon(iZzdW);
        if (TextUtils.isEmpty(strZzf)) {
            smallIcon.setContentTitle(this.mContext.getApplicationInfo().loadLabel(this.mContext.getPackageManager()));
        } else {
            smallIcon.setContentTitle(strZzf);
        }
        if (!TextUtils.isEmpty(strZzf2)) {
            smallIcon.setContentText(strZzf2);
        }
        if (!TextUtils.isEmpty(strZze)) {
            smallIcon.setColor(Color.parseColor(strZze));
        }
        if (uriZzdX != null) {
            smallIcon.setSound(uriZzdX);
        }
        if (pendingIntentZzC != null) {
            smallIcon.setContentIntent(pendingIntentZzC);
        }
        if (pendingIntentZzD != null) {
            smallIcon.setDeleteIntent(pendingIntentZzD);
        }
        return smallIcon.build();
    }

    private PendingIntent zzC(Bundle bundle) {
        Intent intent;
        String strZze = zze(bundle, "gcm.n.click_action");
        if (TextUtils.isEmpty(strZze)) {
            Intent launchIntentForPackage = this.mContext.getPackageManager().getLaunchIntentForPackage(this.mContext.getPackageName());
            if (launchIntentForPackage == null) {
                Log.w("GcmNotification", "No activity found to launch app");
                return null;
            }
            intent = launchIntentForPackage;
        } else {
            Intent intent2 = new Intent(strZze);
            intent2.setPackage(this.mContext.getPackageName());
            intent2.setFlags(DriveFile.MODE_READ_ONLY);
            intent = intent2;
        }
        Bundle bundle2 = new Bundle(bundle);
        GcmListenerService.zzw(bundle2);
        intent.putExtras(bundle2);
        for (String str : bundle2.keySet()) {
            if (str.startsWith("gcm.n.") || str.startsWith("gcm.notification.")) {
                intent.removeExtra(str);
            }
        }
        return PendingIntent.getActivity(this.mContext, zzyj(), intent, 1073741824);
    }

    private PendingIntent zzD(Bundle bundle) {
        Intent intent = new Intent("com.google.android.gms.gcm.NOTIFICATION_DISMISS");
        zza(intent, bundle);
        return PendingIntent.getService(this.mContext, zzyj(), intent, 1073741824);
    }

    private PendingIntent zza(Bundle bundle, PendingIntent pendingIntent) {
        Intent intent = new Intent("com.google.android.gms.gcm.NOTIFICATION_OPEN");
        zza(intent, bundle);
        intent.putExtra("com.google.android.gms.gcm.PENDING_INTENT", pendingIntent);
        return PendingIntent.getService(this.mContext, zzyj(), intent, 1073741824);
    }

    private void zza(Intent intent, Bundle bundle) {
        intent.setClass(this.mContext, this.zzaLD);
        for (String str : bundle.keySet()) {
            if (str.startsWith("google.c.a.") || str.equals("from")) {
                intent.putExtra(str, bundle.getString(str));
            }
        }
    }

    private void zza(String str, Notification notification) {
        if (Log.isLoggable("GcmNotification", 3)) {
            Log.d("GcmNotification", "Showing notification");
        }
        NotificationManager notificationManager = (NotificationManager) this.mContext.getSystemService("notification");
        if (TextUtils.isEmpty(str)) {
            str = "GCM-Notification:" + SystemClock.uptimeMillis();
        }
        notificationManager.notify(str, 0, notification);
    }

    static boolean zzaI(Context context) {
        if (((KeyguardManager) context.getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
            return false;
        }
        int iMyPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == iMyPid) {
                return runningAppProcessInfo.importance == 100;
            }
        }
        return false;
    }

    static synchronized zzb zzc(Context context, Class<? extends GcmListenerService> cls) {
        if (zzaLC == null) {
            zzaLC = new zzb(context, cls);
        }
        return zzaLC;
    }

    private String zzdV(String str) {
        return str.substring("gcm.n.".length());
    }

    private int zzdW(String str) {
        if (!TextUtils.isEmpty(str)) {
            Resources resources = this.mContext.getResources();
            int identifier = resources.getIdentifier(str, "drawable", this.mContext.getPackageName());
            if (identifier != 0) {
                return identifier;
            }
            int identifier2 = resources.getIdentifier(str, "mipmap", this.mContext.getPackageName());
            if (identifier2 != 0) {
                return identifier2;
            }
            Log.w("GcmNotification", "Icon resource " + str + " not found. Notification will use app icon.");
        }
        int i = this.mContext.getApplicationInfo().icon;
        return i == 0 ? R.drawable.sym_def_app_icon : i;
    }

    private Uri zzdX(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return ("default".equals(str) || this.mContext.getResources().getIdentifier(str, "raw", this.mContext.getPackageName()) == 0) ? RingtoneManager.getDefaultUri(2) : Uri.parse("android.resource://" + this.mContext.getPackageName() + "/raw/" + str);
    }

    static String zze(Bundle bundle, String str) {
        String string = bundle.getString(str);
        return string == null ? bundle.getString(str.replace("gcm.n.", "gcm.notification.")) : string;
    }

    private String zzf(Bundle bundle, String str) {
        String strZze = zze(bundle, str);
        if (!TextUtils.isEmpty(strZze)) {
            return strZze;
        }
        String strZze2 = zze(bundle, str + "_loc_key");
        if (TextUtils.isEmpty(strZze2)) {
            return null;
        }
        Resources resources = this.mContext.getResources();
        int identifier = resources.getIdentifier(strZze2, "string", this.mContext.getPackageName());
        if (identifier == 0) {
            Log.w("GcmNotification", zzdV(str + "_loc_key") + " resource not found: " + strZze2 + " Default value will be used.");
            return null;
        }
        String strZze3 = zze(bundle, str + "_loc_args");
        if (TextUtils.isEmpty(strZze3)) {
            return resources.getString(identifier);
        }
        try {
            JSONArray jSONArray = new JSONArray(strZze3);
            Object[] objArr = new String[jSONArray.length()];
            for (int i = 0; i < objArr.length; i++) {
                objArr[i] = jSONArray.opt(i);
            }
            return resources.getString(identifier, objArr);
        } catch (MissingFormatArgumentException e) {
            Log.w("GcmNotification", "Missing format argument for " + strZze2 + ": " + strZze3 + " Default value will be used.", e);
            return null;
        } catch (JSONException e2) {
            Log.w("GcmNotification", "Malformed " + zzdV(str + "_loc_args") + ": " + strZze3 + "  Default value will be used.");
            return null;
        }
    }

    static boolean zzy(Bundle bundle) {
        return AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(zze(bundle, "gcm.n.e")) || zze(bundle, "gcm.n.icon") != null;
    }

    private int zzyj() {
        return (int) SystemClock.uptimeMillis();
    }

    static void zzz(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        Iterator<String> it = bundle.keySet().iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (next.startsWith("gcm.n.")) {
                bundle2.putString(next.substring("gcm.n.".length()), bundle.getString(next));
                it.remove();
            } else if (next.startsWith("gcm.notification.")) {
                bundle2.putString(next.substring("gcm.notification.".length()), bundle.getString(next));
                it.remove();
            }
        }
        if (bundle2.isEmpty()) {
            return;
        }
        bundle.putBundle("notification", bundle2);
    }

    boolean zzA(Bundle bundle) {
        try {
            zza(zze(bundle, "gcm.n.tag"), zzB(bundle));
            return true;
        } catch (zza e) {
            Log.e("GcmNotification", "Failed to show notification: " + e.getMessage());
            return false;
        }
    }
}
