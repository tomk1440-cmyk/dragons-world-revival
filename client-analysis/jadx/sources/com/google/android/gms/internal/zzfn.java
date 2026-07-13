package com.google.android.gms.internal;

import android.app.Activity;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzfn extends zzfs {
    static final Set<String> zzDa = zzmr.zzc("top-left", "top-right", "top-center", "center", "bottom-left", "bottom-right", "bottom-center");
    private AdSizeParcel zzCh;
    private String zzDb;
    private boolean zzDc;
    private int zzDd;
    private int zzDe;
    private int zzDf;
    private int zzDg;
    private final Activity zzDh;
    private ImageView zzDi;
    private LinearLayout zzDj;
    private zzft zzDk;
    private PopupWindow zzDl;
    private RelativeLayout zzDm;
    private ViewGroup zzDn;
    private int zzoG;
    private int zzoH;
    private final zzjp zzpD;
    private final Object zzpV;

    public zzfn(zzjp zzjpVar, zzft zzftVar) {
        super(zzjpVar, "resize");
        this.zzDb = "top-right";
        this.zzDc = true;
        this.zzDd = 0;
        this.zzDe = 0;
        this.zzoH = -1;
        this.zzDf = 0;
        this.zzDg = 0;
        this.zzoG = -1;
        this.zzpV = new Object();
        this.zzpD = zzjpVar;
        this.zzDh = zzjpVar.zzhP();
        this.zzDk = zzftVar;
    }

    private int[] zzeM() {
        if (!zzeO()) {
            return null;
        }
        if (this.zzDc) {
            return new int[]{this.zzDd + this.zzDf, this.zzDe + this.zzDg};
        }
        int[] iArrZzf = com.google.android.gms.ads.internal.zzr.zzbC().zzf(this.zzDh);
        int[] iArrZzh = com.google.android.gms.ads.internal.zzr.zzbC().zzh(this.zzDh);
        int i = iArrZzf[0];
        int i2 = this.zzDd + this.zzDf;
        int i3 = this.zzDe + this.zzDg;
        if (i2 < 0) {
            i2 = 0;
        } else if (this.zzoG + i2 > i) {
            i2 = i - this.zzoG;
        }
        if (i3 < iArrZzh[0]) {
            i3 = iArrZzh[0];
        } else if (this.zzoH + i3 > iArrZzh[1]) {
            i3 = iArrZzh[1] - this.zzoH;
        }
        return new int[]{i2, i3};
    }

    private void zzh(Map<String, String> map) {
        if (!TextUtils.isEmpty(map.get(SettingsJsonConstants.ICON_WIDTH_KEY))) {
            this.zzoG = com.google.android.gms.ads.internal.zzr.zzbC().zzaD(map.get(SettingsJsonConstants.ICON_WIDTH_KEY));
        }
        if (!TextUtils.isEmpty(map.get(SettingsJsonConstants.ICON_HEIGHT_KEY))) {
            this.zzoH = com.google.android.gms.ads.internal.zzr.zzbC().zzaD(map.get(SettingsJsonConstants.ICON_HEIGHT_KEY));
        }
        if (!TextUtils.isEmpty(map.get("offsetX"))) {
            this.zzDf = com.google.android.gms.ads.internal.zzr.zzbC().zzaD(map.get("offsetX"));
        }
        if (!TextUtils.isEmpty(map.get("offsetY"))) {
            this.zzDg = com.google.android.gms.ads.internal.zzr.zzbC().zzaD(map.get("offsetY"));
        }
        if (!TextUtils.isEmpty(map.get("allowOffscreen"))) {
            this.zzDc = Boolean.parseBoolean(map.get("allowOffscreen"));
        }
        String str = map.get("customClosePosition");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.zzDb = str;
    }

    public void zza(int i, int i2, boolean z) {
        synchronized (this.zzpV) {
            this.zzDd = i;
            this.zzDe = i2;
            if (this.zzDl != null && z) {
                int[] iArrZzeM = zzeM();
                if (iArrZzeM != null) {
                    this.zzDl.update(com.google.android.gms.ads.internal.client.zzn.zzcS().zzb(this.zzDh, iArrZzeM[0]), com.google.android.gms.ads.internal.client.zzn.zzcS().zzb(this.zzDh, iArrZzeM[1]), this.zzDl.getWidth(), this.zzDl.getHeight());
                    zzd(iArrZzeM[0], iArrZzeM[1]);
                } else {
                    zzp(true);
                }
            }
        }
    }

    void zzc(int i, int i2) {
        if (this.zzDk != null) {
            this.zzDk.zza(i, i2, this.zzoG, this.zzoH);
        }
    }

    void zzd(int i, int i2) {
        zzb(i, i2 - com.google.android.gms.ads.internal.zzr.zzbC().zzh(this.zzDh)[0], this.zzoG, this.zzoH);
    }

    public void zze(int i, int i2) {
        this.zzDd = i;
        this.zzDe = i2;
    }

    boolean zzeL() {
        return this.zzoG > -1 && this.zzoH > -1;
    }

    public boolean zzeN() {
        boolean z;
        synchronized (this.zzpV) {
            z = this.zzDl != null;
        }
        return z;
    }

    boolean zzeO() {
        int i;
        int i2;
        int[] iArrZzf = com.google.android.gms.ads.internal.zzr.zzbC().zzf(this.zzDh);
        int[] iArrZzh = com.google.android.gms.ads.internal.zzr.zzbC().zzh(this.zzDh);
        int i3 = iArrZzf[0];
        int i4 = iArrZzf[1];
        if (this.zzoG < 50 || this.zzoG > i3) {
            zzin.zzaK("Width is too small or too large.");
            return false;
        }
        if (this.zzoH < 50 || this.zzoH > i4) {
            zzin.zzaK("Height is too small or too large.");
            return false;
        }
        if (this.zzoH == i4 && this.zzoG == i3) {
            zzin.zzaK("Cannot resize to a full-screen ad.");
            return false;
        }
        if (this.zzDc) {
            switch (this.zzDb) {
                case "top-left":
                    i = this.zzDf + this.zzDd;
                    i2 = this.zzDe + this.zzDg;
                    break;
                case "top-center":
                    i = ((this.zzDd + this.zzDf) + (this.zzoG / 2)) - 25;
                    i2 = this.zzDe + this.zzDg;
                    break;
                case "center":
                    i = ((this.zzDd + this.zzDf) + (this.zzoG / 2)) - 25;
                    i2 = ((this.zzDe + this.zzDg) + (this.zzoH / 2)) - 25;
                    break;
                case "bottom-left":
                    i = this.zzDf + this.zzDd;
                    i2 = ((this.zzDe + this.zzDg) + this.zzoH) - 50;
                    break;
                case "bottom-center":
                    i = ((this.zzDd + this.zzDf) + (this.zzoG / 2)) - 25;
                    i2 = ((this.zzDe + this.zzDg) + this.zzoH) - 50;
                    break;
                case "bottom-right":
                    i = ((this.zzDd + this.zzDf) + this.zzoG) - 50;
                    i2 = ((this.zzDe + this.zzDg) + this.zzoH) - 50;
                    break;
                default:
                    i = ((this.zzDd + this.zzDf) + this.zzoG) - 50;
                    i2 = this.zzDe + this.zzDg;
                    break;
            }
            if (i < 0 || i + 50 > i3 || i2 < iArrZzh[0] || i2 + 50 > iArrZzh[1]) {
                return false;
            }
        }
        return true;
    }

    public void zzi(Map<String, String> map) {
        synchronized (this.zzpV) {
            if (this.zzDh == null) {
                zzam("Not an activity context. Cannot resize.");
                return;
            }
            if (this.zzpD.zzaN() == null) {
                zzam("Webview is not yet available, size is not set.");
                return;
            }
            if (this.zzpD.zzaN().zzui) {
                zzam("Is interstitial. Cannot resize an interstitial.");
                return;
            }
            if (this.zzpD.zzhY()) {
                zzam("Cannot resize an expanded banner.");
                return;
            }
            zzh(map);
            if (!zzeL()) {
                zzam("Invalid width and height options. Cannot resize.");
                return;
            }
            Window window = this.zzDh.getWindow();
            if (window == null || window.getDecorView() == null) {
                zzam("Activity context is not ready, cannot get window or decor view.");
                return;
            }
            int[] iArrZzeM = zzeM();
            if (iArrZzeM == null) {
                zzam("Resize location out of screen or close button is not visible.");
                return;
            }
            int iZzb = com.google.android.gms.ads.internal.client.zzn.zzcS().zzb(this.zzDh, this.zzoG);
            int iZzb2 = com.google.android.gms.ads.internal.client.zzn.zzcS().zzb(this.zzDh, this.zzoH);
            ViewParent parent = this.zzpD.getView().getParent();
            if (parent == null || !(parent instanceof ViewGroup)) {
                zzam("Webview is detached, probably in the middle of a resize or expand.");
                return;
            }
            ((ViewGroup) parent).removeView(this.zzpD.getView());
            if (this.zzDl == null) {
                this.zzDn = (ViewGroup) parent;
                Bitmap bitmapZzk = com.google.android.gms.ads.internal.zzr.zzbC().zzk(this.zzpD.getView());
                this.zzDi = new ImageView(this.zzDh);
                this.zzDi.setImageBitmap(bitmapZzk);
                this.zzCh = this.zzpD.zzaN();
                this.zzDn.addView(this.zzDi);
            } else {
                this.zzDl.dismiss();
            }
            this.zzDm = new RelativeLayout(this.zzDh);
            this.zzDm.setBackgroundColor(0);
            this.zzDm.setLayoutParams(new ViewGroup.LayoutParams(iZzb, iZzb2));
            this.zzDl = com.google.android.gms.ads.internal.zzr.zzbC().zza((View) this.zzDm, iZzb, iZzb2, false);
            this.zzDl.setOutsideTouchable(true);
            this.zzDl.setTouchable(true);
            this.zzDl.setClippingEnabled(!this.zzDc);
            this.zzDm.addView(this.zzpD.getView(), -1, -1);
            this.zzDj = new LinearLayout(this.zzDh);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.google.android.gms.ads.internal.client.zzn.zzcS().zzb(this.zzDh, 50), com.google.android.gms.ads.internal.client.zzn.zzcS().zzb(this.zzDh, 50));
            switch (this.zzDb) {
                case "top-left":
                    layoutParams.addRule(10);
                    layoutParams.addRule(9);
                    break;
                case "top-center":
                    layoutParams.addRule(10);
                    layoutParams.addRule(14);
                    break;
                case "center":
                    layoutParams.addRule(13);
                    break;
                case "bottom-left":
                    layoutParams.addRule(12);
                    layoutParams.addRule(9);
                    break;
                case "bottom-center":
                    layoutParams.addRule(12);
                    layoutParams.addRule(14);
                    break;
                case "bottom-right":
                    layoutParams.addRule(12);
                    layoutParams.addRule(11);
                    break;
                default:
                    layoutParams.addRule(10);
                    layoutParams.addRule(11);
                    break;
            }
            this.zzDj.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.gms.internal.zzfn.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    zzfn.this.zzp(true);
                }
            });
            this.zzDj.setContentDescription("Close button");
            this.zzDm.addView(this.zzDj, layoutParams);
            try {
                this.zzDl.showAtLocation(window.getDecorView(), 0, com.google.android.gms.ads.internal.client.zzn.zzcS().zzb(this.zzDh, iArrZzeM[0]), com.google.android.gms.ads.internal.client.zzn.zzcS().zzb(this.zzDh, iArrZzeM[1]));
                zzc(iArrZzeM[0], iArrZzeM[1]);
                this.zzpD.zza(new AdSizeParcel(this.zzDh, new AdSize(this.zzoG, this.zzoH)));
                zzd(iArrZzeM[0], iArrZzeM[1]);
                zzao("resized");
            } catch (RuntimeException e) {
                zzam("Cannot show popup window: " + e.getMessage());
                this.zzDm.removeView(this.zzpD.getView());
                if (this.zzDn != null) {
                    this.zzDn.removeView(this.zzDi);
                    this.zzDn.addView(this.zzpD.getView());
                    this.zzpD.zza(this.zzCh);
                }
            }
        }
    }

    public void zzp(boolean z) {
        synchronized (this.zzpV) {
            if (this.zzDl != null) {
                this.zzDl.dismiss();
                this.zzDm.removeView(this.zzpD.getView());
                if (this.zzDn != null) {
                    this.zzDn.removeView(this.zzDi);
                    this.zzDn.addView(this.zzpD.getView());
                    this.zzpD.zza(this.zzCh);
                }
                if (z) {
                    zzao("default");
                    if (this.zzDk != null) {
                        this.zzDk.zzbf();
                    }
                }
                this.zzDl = null;
                this.zzDm = null;
                this.zzDn = null;
                this.zzDj = null;
            }
        }
    }
}
