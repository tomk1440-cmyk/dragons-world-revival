package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.google.android.gms.internal.zzbt;
import com.google.android.gms.internal.zzfv;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzim;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zziu;
import com.google.android.gms.internal.zzjp;
import com.google.android.gms.internal.zzjq;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzd extends zzfv.zza implements zzs {
    static final int zzEg = Color.argb(0, 0, 0, 0);
    private final Activity mActivity;
    RelativeLayout zzDm;
    AdOverlayInfoParcel zzEh;
    zzc zzEi;
    zzo zzEj;
    FrameLayout zzEl;
    WebChromeClient.CustomViewCallback zzEm;
    private boolean zzEs;
    zzjp zzpD;
    boolean zzEk = false;
    boolean zzEn = false;
    boolean zzEo = false;
    boolean zzEp = false;
    int zzEq = 0;
    private boolean zzEt = false;
    private boolean zzEu = true;
    zzl zzEr = new zzq();

    @zzhb
    private static final class zza extends Exception {
        public zza(String str) {
            super(str);
        }
    }

    @zzhb
    static final class zzb extends RelativeLayout {
        zziu zzrU;

        public zzb(Context context, String str) {
            super(context);
            this.zzrU = new zziu(context, str);
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent event) {
            this.zzrU.zze(event);
            return false;
        }
    }

    @zzhb
    public static class zzc {
        public final Context context;
        public final int index;
        public final ViewGroup.LayoutParams zzEw;
        public final ViewGroup zzEx;

        public zzc(zzjp zzjpVar) throws zza {
            this.zzEw = zzjpVar.getLayoutParams();
            ViewParent parent = zzjpVar.getParent();
            this.context = zzjpVar.zzhQ();
            if (parent == null || !(parent instanceof ViewGroup)) {
                throw new zza("Could not get the parent of the WebView for an overlay.");
            }
            this.zzEx = (ViewGroup) parent;
            this.index = this.zzEx.indexOfChild(zzjpVar.getView());
            this.zzEx.removeView(zzjpVar.getView());
            zzjpVar.zzD(true);
        }
    }

    /* JADX INFO: renamed from: com.google.android.gms.ads.internal.overlay.zzd$zzd, reason: collision with other inner class name */
    @zzhb
    private class C0026zzd extends zzim {
        private C0026zzd() {
        }

        @Override // com.google.android.gms.internal.zzim
        public void onStop() {
        }

        @Override // com.google.android.gms.internal.zzim
        public void zzbr() {
            Bitmap bitmapZzf = com.google.android.gms.ads.internal.zzr.zzbC().zzf(zzd.this.mActivity, zzd.this.zzEh.zzEM.zzqn);
            if (bitmapZzf != null) {
                final Drawable drawableZza = com.google.android.gms.ads.internal.zzr.zzbE().zza(zzd.this.mActivity, bitmapZzf, zzd.this.zzEh.zzEM.zzqo, zzd.this.zzEh.zzEM.zzqp);
                zzir.zzMc.post(new Runnable() { // from class: com.google.android.gms.ads.internal.overlay.zzd.zzd.1
                    @Override // java.lang.Runnable
                    public void run() {
                        zzd.this.mActivity.getWindow().setBackgroundDrawable(drawableZza);
                    }
                });
            }
        }
    }

    public zzd(Activity activity) {
        this.mActivity = activity;
    }

    public void close() {
        this.zzEq = 2;
        this.mActivity.finish();
    }

    @Override // com.google.android.gms.internal.zzfv
    public void onBackPressed() {
        this.zzEq = 0;
    }

    @Override // com.google.android.gms.internal.zzfv
    public void onCreate(Bundle savedInstanceState) {
        this.zzEn = savedInstanceState != null ? savedInstanceState.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false) : false;
        try {
            this.zzEh = AdOverlayInfoParcel.zzb(this.mActivity.getIntent());
            if (this.zzEh == null) {
                throw new zza("Could not get info for ad overlay.");
            }
            if (this.zzEh.zzrl.zzNa > 7500000) {
                this.zzEq = 3;
            }
            if (this.mActivity.getIntent() != null) {
                this.zzEu = this.mActivity.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true);
            }
            if (this.zzEh.zzEM != null) {
                this.zzEo = this.zzEh.zzEM.zzql;
            } else {
                this.zzEo = false;
            }
            if (zzbt.zzxe.get().booleanValue() && this.zzEo && this.zzEh.zzEM.zzqn != null) {
                new C0026zzd().zzgd();
            }
            if (savedInstanceState == null) {
                if (this.zzEh.zzEC != null && this.zzEu) {
                    this.zzEh.zzEC.zzaX();
                }
                if (this.zzEh.zzEJ != 1 && this.zzEh.zzEB != null) {
                    this.zzEh.zzEB.onAdClicked();
                }
            }
            this.zzDm = new zzb(this.mActivity, this.zzEh.zzEL);
            this.zzDm.setId(1000);
            switch (this.zzEh.zzEJ) {
                case 1:
                    zzx(false);
                    return;
                case 2:
                    this.zzEi = new zzc(this.zzEh.zzED);
                    zzx(false);
                    return;
                case 3:
                    zzx(true);
                    return;
                case 4:
                    if (this.zzEn) {
                        this.zzEq = 3;
                        this.mActivity.finish();
                        return;
                    } else {
                        if (com.google.android.gms.ads.internal.zzr.zzbz().zza(this.mActivity, this.zzEh.zzEA, this.zzEh.zzEI)) {
                            return;
                        }
                        this.zzEq = 3;
                        this.mActivity.finish();
                        return;
                    }
                default:
                    throw new zza("Could not determine ad overlay type.");
            }
        } catch (zza e) {
            zzin.zzaK(e.getMessage());
            this.zzEq = 3;
            this.mActivity.finish();
        }
    }

    @Override // com.google.android.gms.internal.zzfv
    public void onDestroy() {
        if (this.zzpD != null) {
            this.zzDm.removeView(this.zzpD.getView());
        }
        zzfp();
    }

    @Override // com.google.android.gms.internal.zzfv
    public void onPause() {
        this.zzEr.pause();
        zzfl();
        if (this.zzEh.zzEC != null) {
            this.zzEh.zzEC.onPause();
        }
        if (this.zzpD != null && (!this.mActivity.isFinishing() || this.zzEi == null)) {
            com.google.android.gms.ads.internal.zzr.zzbE().zzi(this.zzpD);
        }
        zzfp();
    }

    @Override // com.google.android.gms.internal.zzfv
    public void onRestart() {
    }

    @Override // com.google.android.gms.internal.zzfv
    public void onResume() {
        if (this.zzEh != null && this.zzEh.zzEJ == 4) {
            if (this.zzEn) {
                this.zzEq = 3;
                this.mActivity.finish();
            } else {
                this.zzEn = true;
            }
        }
        if (this.zzEh.zzEC != null) {
            this.zzEh.zzEC.onResume();
        }
        if (this.zzpD == null || this.zzpD.isDestroyed()) {
            zzin.zzaK("The webview does not exit. Ignoring action.");
        } else {
            com.google.android.gms.ads.internal.zzr.zzbE().zzj(this.zzpD);
        }
        this.zzEr.resume();
    }

    @Override // com.google.android.gms.internal.zzfv
    public void onSaveInstanceState(Bundle outBundle) {
        outBundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.zzEn);
    }

    @Override // com.google.android.gms.internal.zzfv
    public void onStart() {
    }

    @Override // com.google.android.gms.internal.zzfv
    public void onStop() {
        zzfp();
    }

    public void setRequestedOrientation(int requestedOrientation) {
        this.mActivity.setRequestedOrientation(requestedOrientation);
    }

    public void zza(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        this.zzEl = new FrameLayout(this.mActivity);
        this.zzEl.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.zzEl.addView(view, -1, -1);
        this.mActivity.setContentView(this.zzEl);
        zzaD();
        this.zzEm = customViewCallback;
        this.zzEk = true;
    }

    public void zza(boolean z, boolean z2) {
        if (this.zzEj != null) {
            this.zzEj.zza(z, z2);
        }
    }

    @Override // com.google.android.gms.internal.zzfv
    public void zzaD() {
        this.zzEs = true;
    }

    public void zzfl() {
        if (this.zzEh != null && this.zzEk) {
            setRequestedOrientation(this.zzEh.orientation);
        }
        if (this.zzEl != null) {
            this.mActivity.setContentView(this.zzDm);
            zzaD();
            this.zzEl.removeAllViews();
            this.zzEl = null;
        }
        if (this.zzEm != null) {
            this.zzEm.onCustomViewHidden();
            this.zzEm = null;
        }
        this.zzEk = false;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzs
    public void zzfm() {
        this.zzEq = 1;
        this.mActivity.finish();
    }

    @Override // com.google.android.gms.internal.zzfv
    public boolean zzfn() {
        boolean z = true;
        this.zzEq = 0;
        if (this.zzpD != null) {
            z = this.zzpD.zzfL() && this.zzEr.zzfL();
            if (!z) {
                this.zzpD.zza("onbackblocked", Collections.emptyMap());
            }
        }
        return z;
    }

    public void zzfo() {
        this.zzDm.removeView(this.zzEj);
        zzw(true);
    }

    protected void zzfp() {
        if (!this.mActivity.isFinishing() || this.zzEt) {
            return;
        }
        this.zzEt = true;
        if (this.zzpD != null) {
            zzy(this.zzEq);
            this.zzDm.removeView(this.zzpD.getView());
            if (this.zzEi != null) {
                this.zzpD.setContext(this.zzEi.context);
                this.zzpD.zzD(false);
                this.zzEi.zzEx.addView(this.zzpD.getView(), this.zzEi.index, this.zzEi.zzEw);
                this.zzEi = null;
            } else if (this.mActivity.getApplicationContext() != null) {
                this.zzpD.setContext(this.mActivity.getApplicationContext());
            }
            this.zzpD = null;
        }
        if (this.zzEh != null && this.zzEh.zzEC != null) {
            this.zzEh.zzEC.zzaW();
        }
        this.zzEr.destroy();
    }

    public void zzfq() {
        if (this.zzEp) {
            this.zzEp = false;
            zzfr();
        }
    }

    protected void zzfr() {
        this.zzpD.zzfr();
    }

    public void zzg(zzjp zzjpVar, Map<String, String> map) {
        this.zzEr.zzg(zzjpVar, map);
    }

    public void zzw(boolean z) {
        this.zzEj = new zzo(this.mActivity, z ? 50 : 32, this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(z ? 11 : 9);
        this.zzEj.zza(z, this.zzEh.zzEG);
        this.zzDm.addView(this.zzEj, layoutParams);
    }

    protected void zzx(boolean z) throws zza {
        if (!this.zzEs) {
            this.mActivity.requestWindowFeature(1);
        }
        Window window = this.mActivity.getWindow();
        if (window == null) {
            throw new zza("Invalid activity, no window available.");
        }
        if (!this.zzEo || (this.zzEh.zzEM != null && this.zzEh.zzEM.zzqm)) {
            window.setFlags(1024, 1024);
        }
        boolean zZzcv = this.zzEh.zzED.zzhU().zzcv();
        this.zzEp = false;
        if (zZzcv) {
            if (this.zzEh.orientation == com.google.android.gms.ads.internal.zzr.zzbE().zzhv()) {
                this.zzEp = this.mActivity.getResources().getConfiguration().orientation == 1;
            } else if (this.zzEh.orientation == com.google.android.gms.ads.internal.zzr.zzbE().zzhw()) {
                this.zzEp = this.mActivity.getResources().getConfiguration().orientation == 2;
            }
        }
        zzin.zzaI("Delay onShow to next orientation change: " + this.zzEp);
        setRequestedOrientation(this.zzEh.orientation);
        if (com.google.android.gms.ads.internal.zzr.zzbE().zza(window)) {
            zzin.zzaI("Hardware acceleration on the AdActivity window enabled.");
        }
        if (this.zzEo) {
            this.zzDm.setBackgroundColor(zzEg);
        } else {
            this.zzDm.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        this.mActivity.setContentView(this.zzDm);
        zzaD();
        if (z) {
            this.zzpD = com.google.android.gms.ads.internal.zzr.zzbD().zza(this.mActivity, this.zzEh.zzED.zzaN(), true, zZzcv, null, this.zzEh.zzrl, null, this.zzEh.zzED.zzhR());
            this.zzpD.zzhU().zzb(null, null, this.zzEh.zzEE, this.zzEh.zzEI, true, this.zzEh.zzEK, null, this.zzEh.zzED.zzhU().zzig(), null);
            this.zzpD.zzhU().zza(new zzjq.zza() { // from class: com.google.android.gms.ads.internal.overlay.zzd.1
                @Override // com.google.android.gms.internal.zzjq.zza
                public void zza(zzjp zzjpVar, boolean z2) {
                    zzjpVar.zzfr();
                }
            });
            if (this.zzEh.url != null) {
                this.zzpD.loadUrl(this.zzEh.url);
            } else {
                if (this.zzEh.zzEH == null) {
                    throw new zza("No URL or HTML to display in ad overlay.");
                }
                this.zzpD.loadDataWithBaseURL(this.zzEh.zzEF, this.zzEh.zzEH, "text/html", "UTF-8", null);
            }
            if (this.zzEh.zzED != null) {
                this.zzEh.zzED.zzc(this);
            }
        } else {
            this.zzpD = this.zzEh.zzED;
            this.zzpD.setContext(this.mActivity);
        }
        this.zzpD.zzb(this);
        ViewParent parent = this.zzpD.getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(this.zzpD.getView());
        }
        if (this.zzEo) {
            this.zzpD.setBackgroundColor(zzEg);
        }
        this.zzDm.addView(this.zzpD.getView(), -1, -1);
        if (!z && !this.zzEp) {
            zzfr();
        }
        zzw(zZzcv);
        if (this.zzpD.zzhV()) {
            zza(zZzcv, true);
        }
        com.google.android.gms.ads.internal.zzd zzdVarZzhR = this.zzpD.zzhR();
        zzm zzmVar = zzdVarZzhR != null ? zzdVarZzhR.zzpy : null;
        if (zzmVar != null) {
            this.zzEr = zzmVar.zza(this.mActivity, this.zzpD, this.zzDm);
        } else {
            zzin.zzaK("Appstreaming controller is null.");
        }
    }

    protected void zzy(int i) {
        this.zzpD.zzy(i);
    }
}
