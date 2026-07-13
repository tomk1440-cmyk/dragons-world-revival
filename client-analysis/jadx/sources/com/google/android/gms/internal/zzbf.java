package com.google.android.gms.internal;

import android.R;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.Context;
import android.graphics.Rect;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@zzhb
@TargetApi(14)
public class zzbf extends Thread {
    private final zzbe zzsZ;
    private final zzbd zzta;
    private final zzha zztb;
    private boolean mStarted = false;
    private boolean zzsY = false;
    private boolean zzam = false;
    private final Object zzpV = new Object();
    private final int zzsK = zzbt.zzwk.get().intValue();
    private final int zztd = zzbt.zzwl.get().intValue();
    private final int zzsM = zzbt.zzwm.get().intValue();
    private final int zzte = zzbt.zzwn.get().intValue();
    private final int zztc = zzbt.zzwo.get().intValue();

    @zzhb
    class zza {
        final int zztm;
        final int zztn;

        zza(int i, int i2) {
            this.zztm = i;
            this.zztn = i2;
        }
    }

    public zzbf(zzbe zzbeVar, zzbd zzbdVar, zzha zzhaVar) {
        this.zzsZ = zzbeVar;
        this.zzta = zzbdVar;
        this.zztb = zzhaVar;
        setName("ContentFetchTask");
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        while (!this.zzam) {
            try {
                if (zzcH()) {
                    Activity activity = this.zzsZ.getActivity();
                    if (activity == null) {
                        zzin.zzaI("ContentFetchThread: no activity");
                    } else {
                        zza(activity);
                    }
                } else {
                    zzin.zzaI("ContentFetchTask: sleeping");
                    zzcJ();
                }
                Thread.sleep(this.zztc * 1000);
            } catch (Throwable th) {
                zzin.zzb("Error in ContentFetchTask", th);
                this.zztb.zza(th, true);
            }
            synchronized (this.zzpV) {
                while (this.zzsY) {
                    try {
                        zzin.zzaI("ContentFetchTask: waiting");
                        this.zzpV.wait();
                    } catch (InterruptedException e) {
                    }
                }
            }
        }
    }

    public void wakeup() {
        synchronized (this.zzpV) {
            this.zzsY = false;
            this.zzpV.notifyAll();
            zzin.zzaI("ContentFetchThread: wakeup");
        }
    }

    zza zza(View view, zzbc zzbcVar) {
        if (view == null) {
            return new zza(0, 0);
        }
        boolean globalVisibleRect = view.getGlobalVisibleRect(new Rect());
        if ((view instanceof TextView) && !(view instanceof EditText)) {
            CharSequence text = ((TextView) view).getText();
            if (TextUtils.isEmpty(text)) {
                return new zza(0, 0);
            }
            zzbcVar.zzd(text.toString(), globalVisibleRect);
            return new zza(1, 0);
        }
        if ((view instanceof WebView) && !(view instanceof zzjp)) {
            zzbcVar.zzcC();
            return zza((WebView) view, zzbcVar, globalVisibleRect) ? new zza(0, 1) : new zza(0, 0);
        }
        if (!(view instanceof ViewGroup)) {
            return new zza(0, 0);
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
            zza zzaVarZza = zza(viewGroup.getChildAt(i3), zzbcVar);
            i2 += zzaVarZza.zztm;
            i += zzaVarZza.zztn;
        }
        return new zza(i2, i);
    }

    void zza(Activity activity) {
        if (activity == null) {
            return;
        }
        View viewFindViewById = null;
        if (activity.getWindow() != null && activity.getWindow().getDecorView() != null) {
            viewFindViewById = activity.getWindow().getDecorView().findViewById(R.id.content);
        }
        if (viewFindViewById != null) {
            zze(viewFindViewById);
        }
    }

    void zza(zzbc zzbcVar, WebView webView, String str, boolean z) {
        zzbcVar.zzcB();
        try {
            if (!TextUtils.isEmpty(str)) {
                String strOptString = new JSONObject(str).optString("text");
                if (TextUtils.isEmpty(webView.getTitle())) {
                    zzbcVar.zzc(strOptString, z);
                } else {
                    zzbcVar.zzc(webView.getTitle() + "\n" + strOptString, z);
                }
            }
            if (zzbcVar.zzcx()) {
                this.zzta.zzb(zzbcVar);
            }
        } catch (JSONException e) {
            zzin.zzaI("Json string may be malformed.");
        } catch (Throwable th) {
            zzin.zza("Failed to get webview content.", th);
            this.zztb.zza(th, true);
        }
    }

    boolean zza(ActivityManager.RunningAppProcessInfo runningAppProcessInfo) {
        return runningAppProcessInfo.importance == 100;
    }

    @TargetApi(19)
    boolean zza(final WebView webView, final zzbc zzbcVar, final boolean z) {
        if (!zzne.zzsk()) {
            return false;
        }
        zzbcVar.zzcC();
        webView.post(new Runnable() { // from class: com.google.android.gms.internal.zzbf.2
            ValueCallback<String> zzth = new ValueCallback<String>() { // from class: com.google.android.gms.internal.zzbf.2.1
                @Override // android.webkit.ValueCallback
                /* JADX INFO: renamed from: zzt, reason: merged with bridge method [inline-methods] */
                public void onReceiveValue(String str) {
                    zzbf.this.zza(zzbcVar, webView, str, z);
                }
            };

            @Override // java.lang.Runnable
            public void run() {
                if (webView.getSettings().getJavaScriptEnabled()) {
                    try {
                        webView.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", this.zzth);
                    } catch (Throwable th) {
                        this.zzth.onReceiveValue("");
                    }
                }
            }
        });
        return true;
    }

    public void zzcG() {
        synchronized (this.zzpV) {
            if (this.mStarted) {
                zzin.zzaI("Content hash thread already started, quiting...");
            } else {
                this.mStarted = true;
                start();
            }
        }
    }

    boolean zzcH() {
        try {
            Context context = this.zzsZ.getContext();
            if (context == null) {
                return false;
            }
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
            if (activityManager == null || keyguardManager == null) {
                return false;
            }
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses == null) {
                return false;
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (Process.myPid() == runningAppProcessInfo.pid) {
                    if (!zza(runningAppProcessInfo) || keyguardManager.inKeyguardRestrictedInputMode() || !zzs(context)) {
                        break;
                        break;
                        break;
                    }
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    public zzbc zzcI() {
        return this.zzta.zzcF();
    }

    public void zzcJ() {
        synchronized (this.zzpV) {
            this.zzsY = true;
            zzin.zzaI("ContentFetchThread: paused, mPause = " + this.zzsY);
        }
    }

    public boolean zzcK() {
        return this.zzsY;
    }

    boolean zze(final View view) {
        if (view == null) {
            return false;
        }
        view.post(new Runnable() { // from class: com.google.android.gms.internal.zzbf.1
            @Override // java.lang.Runnable
            public void run() {
                zzbf.this.zzf(view);
            }
        });
        return true;
    }

    void zzf(View view) {
        try {
            zzbc zzbcVar = new zzbc(this.zzsK, this.zztd, this.zzsM, this.zzte);
            zza zzaVarZza = zza(view, zzbcVar);
            zzbcVar.zzcD();
            if (zzaVarZza.zztm == 0 && zzaVarZza.zztn == 0) {
                return;
            }
            if (zzaVarZza.zztn == 0 && zzbcVar.zzcE() == 0) {
                return;
            }
            if (zzaVarZza.zztn == 0 && this.zzta.zza(zzbcVar)) {
                return;
            }
            this.zzta.zzc(zzbcVar);
        } catch (Exception e) {
            zzin.zzb("Exception in fetchContentOnUIThread", e);
            this.zztb.zza(e, true);
        }
    }

    boolean zzs(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager == null) {
            return false;
        }
        return powerManager.isScreenOn();
    }
}
