package com.google.android.gms.internal;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public abstract class zzau implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {
    private final WeakReference<zzif> zzrW;
    private final zzbb zzrY;
    protected final zzaw zzrZ;
    private final Context zzsa;
    private final WindowManager zzsb;
    private final PowerManager zzsc;
    private final KeyguardManager zzsd;
    private zzay zzse;
    private boolean zzsf;
    private boolean zzsi;
    BroadcastReceiver zzsk;
    protected final Object zzpV = new Object();
    private boolean zzqJ = false;
    private boolean zzsg = false;
    private final HashSet<zzav> zzsl = new HashSet<>();
    private final zzdf zzsm = new zzdf() { // from class: com.google.android.gms.internal.zzau.2
        @Override // com.google.android.gms.internal.zzdf
        public void zza(zzjp zzjpVar, Map<String, String> map) {
            if (zzau.this.zzb(map)) {
                zzau.this.zza(zzjpVar.getView(), map);
            }
        }
    };
    private final zzdf zzsn = new zzdf() { // from class: com.google.android.gms.internal.zzau.3
        @Override // com.google.android.gms.internal.zzdf
        public void zza(zzjp zzjpVar, Map<String, String> map) {
            if (zzau.this.zzb(map)) {
                zzin.zzaI("Received request to untrack: " + zzau.this.zzrZ.zzcu());
                zzau.this.destroy();
            }
        }
    };
    private final zzdf zzso = new zzdf() { // from class: com.google.android.gms.internal.zzau.4
        @Override // com.google.android.gms.internal.zzdf
        public void zza(zzjp zzjpVar, Map<String, String> map) {
            if (zzau.this.zzb(map) && map.containsKey("isVisible")) {
                zzau.this.zzg(Boolean.valueOf(AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(map.get("isVisible")) || ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(map.get("isVisible"))).booleanValue());
            }
        }
    };
    private WeakReference<ViewTreeObserver> zzrX = new WeakReference<>(null);
    private boolean zzsh = true;
    private boolean zzsj = false;
    private zziz zzrQ = new zziz(200);

    public static class zza implements zzbb {
        private WeakReference<com.google.android.gms.ads.internal.formats.zzh> zzsq;

        public zza(com.google.android.gms.ads.internal.formats.zzh zzhVar) {
            this.zzsq = new WeakReference<>(zzhVar);
        }

        @Override // com.google.android.gms.internal.zzbb
        public View zzco() {
            com.google.android.gms.ads.internal.formats.zzh zzhVar = this.zzsq.get();
            if (zzhVar != null) {
                return zzhVar.zzdS();
            }
            return null;
        }

        @Override // com.google.android.gms.internal.zzbb
        public boolean zzcp() {
            return this.zzsq.get() == null;
        }

        @Override // com.google.android.gms.internal.zzbb
        public zzbb zzcq() {
            return new zzb(this.zzsq.get());
        }
    }

    public static class zzb implements zzbb {
        private com.google.android.gms.ads.internal.formats.zzh zzsr;

        public zzb(com.google.android.gms.ads.internal.formats.zzh zzhVar) {
            this.zzsr = zzhVar;
        }

        @Override // com.google.android.gms.internal.zzbb
        public View zzco() {
            return this.zzsr.zzdS();
        }

        @Override // com.google.android.gms.internal.zzbb
        public boolean zzcp() {
            return this.zzsr == null;
        }

        @Override // com.google.android.gms.internal.zzbb
        public zzbb zzcq() {
            return this;
        }
    }

    public static class zzc implements zzbb {
        private final View mView;
        private final zzif zzss;

        public zzc(View view, zzif zzifVar) {
            this.mView = view;
            this.zzss = zzifVar;
        }

        @Override // com.google.android.gms.internal.zzbb
        public View zzco() {
            return this.mView;
        }

        @Override // com.google.android.gms.internal.zzbb
        public boolean zzcp() {
            return this.zzss == null || this.mView == null;
        }

        @Override // com.google.android.gms.internal.zzbb
        public zzbb zzcq() {
            return this;
        }
    }

    public static class zzd implements zzbb {
        private final WeakReference<View> zzst;
        private final WeakReference<zzif> zzsu;

        public zzd(View view, zzif zzifVar) {
            this.zzst = new WeakReference<>(view);
            this.zzsu = new WeakReference<>(zzifVar);
        }

        @Override // com.google.android.gms.internal.zzbb
        public View zzco() {
            return this.zzst.get();
        }

        @Override // com.google.android.gms.internal.zzbb
        public boolean zzcp() {
            return this.zzst.get() == null || this.zzsu.get() == null;
        }

        @Override // com.google.android.gms.internal.zzbb
        public zzbb zzcq() {
            return new zzc(this.zzst.get(), this.zzsu.get());
        }
    }

    public zzau(Context context, AdSizeParcel adSizeParcel, zzif zzifVar, VersionInfoParcel versionInfoParcel, zzbb zzbbVar) {
        this.zzrW = new WeakReference<>(zzifVar);
        this.zzrY = zzbbVar;
        this.zzrZ = new zzaw(UUID.randomUUID().toString(), versionInfoParcel, adSizeParcel.zzuh, zzifVar.zzKT, zzifVar.zzcv(), adSizeParcel.zzuk);
        this.zzsb = (WindowManager) context.getSystemService("window");
        this.zzsc = (PowerManager) context.getApplicationContext().getSystemService("power");
        this.zzsd = (KeyguardManager) context.getSystemService("keyguard");
        this.zzsa = context;
    }

    protected void destroy() {
        synchronized (this.zzpV) {
            zzcj();
            zzce();
            this.zzsh = false;
            zzcg();
        }
    }

    boolean isScreenOn() {
        return this.zzsc.isScreenOn();
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        zzh(false);
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public void onScrollChanged() {
        zzh(true);
    }

    public void pause() {
        synchronized (this.zzpV) {
            this.zzqJ = true;
            zzh(false);
        }
    }

    public void resume() {
        synchronized (this.zzpV) {
            this.zzqJ = false;
            zzh(false);
        }
    }

    public void stop() {
        synchronized (this.zzpV) {
            this.zzsg = true;
            zzh(false);
        }
    }

    protected int zza(int i, DisplayMetrics displayMetrics) {
        return (int) (i / displayMetrics.density);
    }

    protected void zza(View view, Map<String, String> map) {
        zzh(false);
    }

    public void zza(zzav zzavVar) {
        this.zzsl.add(zzavVar);
    }

    public void zza(zzay zzayVar) {
        synchronized (this.zzpV) {
            this.zzse = zzayVar;
        }
    }

    protected void zza(JSONObject jSONObject) {
        try {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            jSONArray.put(jSONObject);
            jSONObject2.put("units", jSONArray);
            zzb(jSONObject2);
        } catch (Throwable th) {
            zzin.zzb("Skipping active view message.", th);
        }
    }

    protected void zzb(zzeh zzehVar) {
        zzehVar.zza("/updateActiveView", this.zzsm);
        zzehVar.zza("/untrackActiveViewUnit", this.zzsn);
        zzehVar.zza("/visibilityChanged", this.zzso);
    }

    protected abstract void zzb(JSONObject jSONObject);

    protected boolean zzb(Map<String, String> map) {
        if (map == null) {
            return false;
        }
        String str = map.get("hashCode");
        return !TextUtils.isEmpty(str) && str.equals(this.zzrZ.zzcu());
    }

    protected void zzc(zzeh zzehVar) {
        zzehVar.zzb("/visibilityChanged", this.zzso);
        zzehVar.zzb("/untrackActiveViewUnit", this.zzsn);
        zzehVar.zzb("/updateActiveView", this.zzsm);
    }

    protected void zzcd() {
        synchronized (this.zzpV) {
            if (this.zzsk != null) {
                return;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            this.zzsk = new BroadcastReceiver() { // from class: com.google.android.gms.internal.zzau.1
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    zzau.this.zzh(false);
                }
            };
            this.zzsa.registerReceiver(this.zzsk, intentFilter);
        }
    }

    protected void zzce() {
        synchronized (this.zzpV) {
            if (this.zzsk != null) {
                try {
                    this.zzsa.unregisterReceiver(this.zzsk);
                } catch (IllegalStateException e) {
                    zzin.zzb("Failed trying to unregister the receiver", e);
                } catch (Exception e2) {
                    com.google.android.gms.ads.internal.zzr.zzbF().zzb((Throwable) e2, true);
                }
                this.zzsk = null;
            }
        }
    }

    public void zzcf() {
        synchronized (this.zzpV) {
            if (this.zzsh) {
                this.zzsi = true;
                try {
                    try {
                        zza(zzcn());
                    } catch (RuntimeException e) {
                        zzin.zzb("Failure while processing active view data.", e);
                    }
                } catch (JSONException e2) {
                    zzin.zzb("JSON failure while processing active view data.", e2);
                }
                zzin.zzaI("Untracking ad unit: " + this.zzrZ.zzcu());
            }
        }
    }

    protected void zzcg() {
        if (this.zzse != null) {
            this.zzse.zza(this);
        }
    }

    public boolean zzch() {
        boolean z;
        synchronized (this.zzpV) {
            z = this.zzsh;
        }
        return z;
    }

    protected void zzci() {
        ViewTreeObserver viewTreeObserver;
        ViewTreeObserver viewTreeObserver2;
        View viewZzco = this.zzrY.zzcq().zzco();
        if (viewZzco == null || (viewTreeObserver2 = viewZzco.getViewTreeObserver()) == (viewTreeObserver = this.zzrX.get())) {
            return;
        }
        zzcj();
        if (!this.zzsf || (viewTreeObserver != null && viewTreeObserver.isAlive())) {
            this.zzsf = true;
            viewTreeObserver2.addOnScrollChangedListener(this);
            viewTreeObserver2.addOnGlobalLayoutListener(this);
        }
        this.zzrX = new WeakReference<>(viewTreeObserver2);
    }

    protected void zzcj() {
        ViewTreeObserver viewTreeObserver = this.zzrX.get();
        if (viewTreeObserver == null || !viewTreeObserver.isAlive()) {
            return;
        }
        viewTreeObserver.removeOnScrollChangedListener(this);
        viewTreeObserver.removeGlobalOnLayoutListener(this);
    }

    protected JSONObject zzck() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("afmaVersion", this.zzrZ.zzcs()).put("activeViewJSON", this.zzrZ.zzct()).put("timestamp", com.google.android.gms.ads.internal.zzr.zzbG().elapsedRealtime()).put("adFormat", this.zzrZ.zzcr()).put("hashCode", this.zzrZ.zzcu()).put("isMraid", this.zzrZ.zzcv()).put("isStopped", this.zzsg).put("isPaused", this.zzqJ).put("isScreenOn", isScreenOn()).put("isNative", this.zzrZ.zzcw());
        return jSONObject;
    }

    protected abstract boolean zzcl();

    protected JSONObject zzcm() throws JSONException {
        return zzck().put("isAttachedToWindow", false).put("isScreenOn", isScreenOn()).put("isVisible", false);
    }

    protected JSONObject zzcn() throws JSONException {
        JSONObject jSONObjectZzck = zzck();
        jSONObjectZzck.put("doneReasonCode", "u");
        return jSONObjectZzck;
    }

    protected JSONObject zzd(View view) throws JSONException {
        if (view == null) {
            return zzcm();
        }
        boolean zIsAttachedToWindow = com.google.android.gms.ads.internal.zzr.zzbE().isAttachedToWindow(view);
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        try {
            view.getLocationOnScreen(iArr);
            view.getLocationInWindow(iArr2);
        } catch (Exception e) {
            zzin.zzb("Failure getting view location.", e);
        }
        DisplayMetrics displayMetrics = view.getContext().getResources().getDisplayMetrics();
        Rect rect = new Rect();
        rect.left = iArr[0];
        rect.top = iArr[1];
        rect.right = rect.left + view.getWidth();
        rect.bottom = rect.top + view.getHeight();
        Rect rect2 = new Rect();
        rect2.right = this.zzsb.getDefaultDisplay().getWidth();
        rect2.bottom = this.zzsb.getDefaultDisplay().getHeight();
        Rect rect3 = new Rect();
        boolean globalVisibleRect = view.getGlobalVisibleRect(rect3, null);
        Rect rect4 = new Rect();
        boolean localVisibleRect = view.getLocalVisibleRect(rect4);
        Rect rect5 = new Rect();
        view.getHitRect(rect5);
        JSONObject jSONObjectZzck = zzck();
        jSONObjectZzck.put("windowVisibility", view.getWindowVisibility()).put("isAttachedToWindow", zIsAttachedToWindow).put("viewBox", new JSONObject().put("top", zza(rect2.top, displayMetrics)).put("bottom", zza(rect2.bottom, displayMetrics)).put("left", zza(rect2.left, displayMetrics)).put("right", zza(rect2.right, displayMetrics))).put("adBox", new JSONObject().put("top", zza(rect.top, displayMetrics)).put("bottom", zza(rect.bottom, displayMetrics)).put("left", zza(rect.left, displayMetrics)).put("right", zza(rect.right, displayMetrics))).put("globalVisibleBox", new JSONObject().put("top", zza(rect3.top, displayMetrics)).put("bottom", zza(rect3.bottom, displayMetrics)).put("left", zza(rect3.left, displayMetrics)).put("right", zza(rect3.right, displayMetrics))).put("globalVisibleBoxVisible", globalVisibleRect).put("localVisibleBox", new JSONObject().put("top", zza(rect4.top, displayMetrics)).put("bottom", zza(rect4.bottom, displayMetrics)).put("left", zza(rect4.left, displayMetrics)).put("right", zza(rect4.right, displayMetrics))).put("localVisibleBoxVisible", localVisibleRect).put("hitBox", new JSONObject().put("top", zza(rect5.top, displayMetrics)).put("bottom", zza(rect5.bottom, displayMetrics)).put("left", zza(rect5.left, displayMetrics)).put("right", zza(rect5.right, displayMetrics))).put("screenDensity", displayMetrics.density).put("isVisible", com.google.android.gms.ads.internal.zzr.zzbC().zza(view, this.zzsc, this.zzsd));
        return jSONObjectZzck;
    }

    protected void zzg(boolean z) {
        Iterator<zzav> it = this.zzsl.iterator();
        while (it.hasNext()) {
            it.next().zza(this, z);
        }
    }

    protected void zzh(boolean z) {
        synchronized (this.zzpV) {
            if (zzcl() && this.zzsh) {
                View viewZzco = this.zzrY.zzco();
                boolean z2 = viewZzco != null && com.google.android.gms.ads.internal.zzr.zzbC().zza(viewZzco, this.zzsc, this.zzsd) && viewZzco.getGlobalVisibleRect(new Rect(), null);
                if (z && !this.zzrQ.tryAcquire() && z2 == this.zzsj) {
                    return;
                }
                this.zzsj = z2;
                if (this.zzrY.zzcp()) {
                    zzcf();
                    return;
                }
                try {
                    zza(zzd(viewZzco));
                } catch (RuntimeException | JSONException e) {
                    zzin.zza("Active view update failed.", e);
                }
                zzci();
                zzcg();
            }
        }
    }
}
