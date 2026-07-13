package com.google.android.gms.tagmanager;

import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
class zzdb extends zzak {
    private static final String ID = com.google.android.gms.internal.zzad.TIMER_LISTENER.toString();
    private static final String NAME = com.google.android.gms.internal.zzae.NAME.toString();
    private static final String zzblp = com.google.android.gms.internal.zzae.INTERVAL.toString();
    private static final String zzblq = com.google.android.gms.internal.zzae.LIMIT.toString();
    private static final String zzblr = com.google.android.gms.internal.zzae.UNIQUE_TRIGGER_ID.toString();
    private final Context mContext;
    private Handler mHandler;
    private DataLayer zzbhN;
    private boolean zzbls;
    private boolean zzblt;
    private final HandlerThread zzblu;
    private final Set<String> zzblv;

    private final class zza implements Runnable {
        private final long zzCv = System.currentTimeMillis();
        private final long zzaNY;
        private final String zzblw;
        private final String zzblx;
        private final long zzbly;
        private long zzblz;

        zza(String str, String str2, long j, long j2) {
            this.zzblw = str;
            this.zzblx = str2;
            this.zzaNY = j;
            this.zzbly = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.zzbly > 0 && this.zzblz >= this.zzbly) {
                if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(this.zzblx)) {
                    return;
                }
                zzdb.this.zzblv.remove(this.zzblx);
            } else {
                this.zzblz++;
                if (zzcH()) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    zzdb.this.zzbhN.push(DataLayer.mapOf("event", this.zzblw, "gtm.timerInterval", String.valueOf(this.zzaNY), "gtm.timerLimit", String.valueOf(this.zzbly), "gtm.timerStartTime", String.valueOf(this.zzCv), "gtm.timerCurrentTime", String.valueOf(jCurrentTimeMillis), "gtm.timerElapsedTime", String.valueOf(jCurrentTimeMillis - this.zzCv), "gtm.timerEventNumber", String.valueOf(this.zzblz), "gtm.triggers", this.zzblx));
                }
                zzdb.this.mHandler.postDelayed(this, this.zzaNY);
            }
        }

        protected boolean zzcH() {
            if (zzdb.this.zzblt) {
                return zzdb.this.zzbls;
            }
            ActivityManager activityManager = (ActivityManager) zzdb.this.mContext.getSystemService("activity");
            KeyguardManager keyguardManager = (KeyguardManager) zzdb.this.mContext.getSystemService("keyguard");
            PowerManager powerManager = (PowerManager) zzdb.this.mContext.getSystemService("power");
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                if (Process.myPid() == runningAppProcessInfo.pid && runningAppProcessInfo.importance == 100 && !keyguardManager.inKeyguardRestrictedInputMode() && powerManager.isScreenOn()) {
                    return true;
                }
            }
            return false;
        }
    }

    public zzdb(Context context, DataLayer dataLayer) {
        super(ID, zzblp, NAME);
        this.zzblv = new HashSet();
        this.mContext = context;
        this.zzbhN = dataLayer;
        this.zzblu = new HandlerThread("Google GTM SDK Timer", 10);
        this.zzblu.start();
        this.mHandler = new Handler(this.zzblu.getLooper());
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public boolean zzFW() {
        return false;
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public com.google.android.gms.internal.zzag.zza zzP(Map<String, com.google.android.gms.internal.zzag.zza> map) {
        long j;
        long j2;
        String strZzg = zzdf.zzg(map.get(NAME));
        String strZzg2 = zzdf.zzg(map.get(zzblr));
        String strZzg3 = zzdf.zzg(map.get(zzblp));
        String strZzg4 = zzdf.zzg(map.get(zzblq));
        try {
            j = Long.parseLong(strZzg3);
        } catch (NumberFormatException e) {
            j = 0;
        }
        try {
            j2 = Long.parseLong(strZzg4);
        } catch (NumberFormatException e2) {
            j2 = 0;
        }
        if (j > 0 && !TextUtils.isEmpty(strZzg)) {
            if (strZzg2 == null || strZzg2.isEmpty()) {
                strZzg2 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            }
            if (!this.zzblv.contains(strZzg2)) {
                if (!AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(strZzg2)) {
                    this.zzblv.add(strZzg2);
                }
                this.mHandler.postDelayed(new zza(strZzg, strZzg2, j, j2), j);
            }
        }
        return zzdf.zzHF();
    }
}
