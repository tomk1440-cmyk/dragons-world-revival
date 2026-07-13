package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.InputDeviceCompat;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.android.gms.internal.zzbz;
import com.google.android.gms.internal.zzcb;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzjp;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzk extends FrameLayout implements zzh {
    private final FrameLayout zzEN;
    private final zzu zzEO;

    @Nullable
    private zzi zzEP;
    private boolean zzEQ;
    private boolean zzER;
    private TextView zzES;
    private long zzET;
    private long zzEU;
    private String zzEV;
    private final zzjp zzpD;
    private String zzzK;

    public zzk(Context context, zzjp zzjpVar, int i, zzcb zzcbVar, zzbz zzbzVar) {
        super(context);
        this.zzpD = zzjpVar;
        this.zzEN = new FrameLayout(context);
        addView(this.zzEN, new FrameLayout.LayoutParams(-1, -1));
        com.google.android.gms.common.internal.zzb.zzv(zzjpVar.zzhR());
        this.zzEP = zzjpVar.zzhR().zzpx.zza(context, zzjpVar, i, zzcbVar, zzbzVar);
        if (this.zzEP != null) {
            this.zzEN.addView(this.zzEP, new FrameLayout.LayoutParams(-1, -1, 17));
        }
        this.zzES = new TextView(context);
        this.zzES.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        zzfG();
        this.zzEO = new zzu(this);
        this.zzEO.zzfQ();
        if (this.zzEP != null) {
            this.zzEP.zza(this);
        }
        if (this.zzEP == null) {
            zzg("AdVideoUnderlay Error", "Allocating player failed.");
        }
    }

    private void zza(String str, String... strArr) {
        HashMap map = new HashMap();
        map.put("event", str);
        int length = strArr.length;
        int i = 0;
        String str2 = null;
        while (i < length) {
            String str3 = strArr[i];
            if (str2 != null) {
                map.put(str2, str3);
                str3 = null;
            }
            i++;
            str2 = str3;
        }
        this.zzpD.zza("onVideoEvent", map);
    }

    private void zzfG() {
        if (zzfI()) {
            return;
        }
        this.zzEN.addView(this.zzES, new FrameLayout.LayoutParams(-1, -1));
        this.zzEN.bringChildToFront(this.zzES);
    }

    private void zzfH() {
        if (zzfI()) {
            this.zzEN.removeView(this.zzES);
        }
    }

    private boolean zzfI() {
        return this.zzES.getParent() != null;
    }

    private void zzfJ() {
        if (this.zzpD.zzhP() == null || this.zzEQ) {
            return;
        }
        this.zzER = (this.zzpD.zzhP().getWindow().getAttributes().flags & 128) != 0;
        if (this.zzER) {
            return;
        }
        this.zzpD.zzhP().getWindow().addFlags(128);
        this.zzEQ = true;
    }

    private void zzfK() {
        if (this.zzpD.zzhP() == null || !this.zzEQ || this.zzER) {
            return;
        }
        this.zzpD.zzhP().getWindow().clearFlags(128);
        this.zzEQ = false;
    }

    public static void zzg(zzjp zzjpVar) {
        HashMap map = new HashMap();
        map.put("event", "no_video_view");
        zzjpVar.zza("onVideoEvent", map);
    }

    public void destroy() {
        this.zzEO.cancel();
        if (this.zzEP != null) {
            this.zzEP.stop();
        }
        zzfK();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzh
    public void onPaused() {
        zza("pause", new String[0]);
        zzfK();
    }

    public void pause() {
        if (this.zzEP == null) {
            return;
        }
        this.zzEP.pause();
    }

    public void play() {
        if (this.zzEP == null) {
            return;
        }
        this.zzEP.play();
    }

    public void seekTo(int millis) {
        if (this.zzEP == null) {
            return;
        }
        this.zzEP.seekTo(millis);
    }

    public void setMimeType(String mimeType) {
        this.zzEV = mimeType;
    }

    public void zza(float f) {
        if (this.zzEP == null) {
            return;
        }
        this.zzEP.zza(f);
    }

    public void zzap(String str) {
        this.zzzK = str;
    }

    public void zzd(int i, int i2, int i3, int i4) {
        if (i3 == 0 || i4 == 0) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3 + 2, i4 + 2);
        layoutParams.setMargins(i - 1, i2 - 1, 0, 0);
        this.zzEN.setLayoutParams(layoutParams);
        requestLayout();
    }

    public void zzd(MotionEvent motionEvent) {
        if (this.zzEP == null) {
            return;
        }
        this.zzEP.dispatchTouchEvent(motionEvent);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzh
    public void zzfA() {
        zzfJ();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzh
    public void zzfB() {
        zza("ended", new String[0]);
        zzfK();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzh
    public void zzfC() {
        zzfG();
        this.zzEU = this.zzET;
    }

    public void zzfD() {
        if (this.zzEP == null) {
            return;
        }
        if (TextUtils.isEmpty(this.zzzK)) {
            zza("no_src", new String[0]);
        } else {
            this.zzEP.setMimeType(this.zzEV);
            this.zzEP.setVideoPath(this.zzzK);
        }
    }

    public void zzfE() {
        if (this.zzEP == null) {
            return;
        }
        TextView textView = new TextView(this.zzEP.getContext());
        textView.setText("AdMob - " + this.zzEP.zzeZ());
        textView.setTextColor(SupportMenu.CATEGORY_MASK);
        textView.setBackgroundColor(InputDeviceCompat.SOURCE_ANY);
        this.zzEN.addView(textView, new FrameLayout.LayoutParams(-2, -2, 17));
        this.zzEN.bringChildToFront(textView);
    }

    void zzfF() {
        if (this.zzEP == null) {
            return;
        }
        long currentPosition = this.zzEP.getCurrentPosition();
        if (this.zzET == currentPosition || currentPosition <= 0) {
            return;
        }
        zzfH();
        zza("timeupdate", "time", String.valueOf(currentPosition / 1000.0f));
        this.zzET = currentPosition;
    }

    public void zzff() {
        if (this.zzEP == null) {
            return;
        }
        this.zzEP.zzff();
    }

    public void zzfg() {
        if (this.zzEP == null) {
            return;
        }
        this.zzEP.zzfg();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzh
    public void zzfy() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzh
    public void zzfz() {
        if (this.zzEP != null && this.zzEU == 0) {
            zza("canplaythrough", "duration", String.valueOf(this.zzEP.getDuration() / 1000.0f), "videoWidth", String.valueOf(this.zzEP.getVideoWidth()), "videoHeight", String.valueOf(this.zzEP.getVideoHeight()));
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzh
    public void zzg(String str, String str2) {
        zza("error", "what", str, "extra", str2);
    }
}
