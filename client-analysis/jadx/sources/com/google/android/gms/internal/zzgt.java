package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.PopupWindow;

/* JADX INFO: loaded from: classes.dex */
@zzhb
@TargetApi(19)
public class zzgt extends zzgs {
    private Object zzGv;
    private PopupWindow zzGw;
    private boolean zzGx;

    zzgt(Context context, zzif.zza zzaVar, zzjp zzjpVar, zzgr.zza zzaVar2) {
        super(context, zzaVar, zzjpVar, zzaVar2);
        this.zzGv = new Object();
        this.zzGx = false;
    }

    private void zzgj() {
        synchronized (this.zzGv) {
            this.zzGx = true;
            if ((this.mContext instanceof Activity) && ((Activity) this.mContext).isDestroyed()) {
                this.zzGw = null;
            }
            if (this.zzGw != null) {
                if (this.zzGw.isShowing()) {
                    this.zzGw.dismiss();
                }
                this.zzGw = null;
            }
        }
    }

    @Override // com.google.android.gms.internal.zzgn, com.google.android.gms.internal.zzit
    public void cancel() {
        zzgj();
        super.cancel();
    }

    @Override // com.google.android.gms.internal.zzgn
    protected void zzC(int i) {
        zzgj();
        super.zzC(i);
    }

    @Override // com.google.android.gms.internal.zzgs
    protected void zzgi() {
        Window window = this.mContext instanceof Activity ? ((Activity) this.mContext).getWindow() : null;
        if (window == null || window.getDecorView() == null || ((Activity) this.mContext).isDestroyed()) {
            return;
        }
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        frameLayout.addView(this.zzpD.getView(), -1, -1);
        synchronized (this.zzGv) {
            if (this.zzGx) {
                return;
            }
            this.zzGw = new PopupWindow((View) frameLayout, 1, 1, false);
            this.zzGw.setOutsideTouchable(true);
            this.zzGw.setClippingEnabled(false);
            zzin.zzaI("Displaying the 1x1 popup off the screen.");
            try {
                this.zzGw.showAtLocation(window.getDecorView(), 0, -1, -1);
            } catch (Exception e) {
                this.zzGw = null;
            }
        }
    }
}
