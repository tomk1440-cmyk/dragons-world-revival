package com.google.android.gms.ads.formats;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.client.zzn;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzcj;

/* JADX INFO: loaded from: classes.dex */
public abstract class NativeAdView extends FrameLayout {
    private final FrameLayout zzoQ;
    private final zzcj zzoR;

    public NativeAdView(Context context) {
        super(context);
        this.zzoQ = zzn(context);
        this.zzoR = zzaI();
    }

    public NativeAdView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.zzoQ = zzn(context);
        this.zzoR = zzaI();
    }

    public NativeAdView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.zzoQ = zzn(context);
        this.zzoR = zzaI();
    }

    public NativeAdView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.zzoQ = zzn(context);
        this.zzoR = zzaI();
    }

    private zzcj zzaI() {
        zzx.zzb(this.zzoQ, "createDelegate must be called after mOverlayFrame has been created");
        return zzn.zzcW().zza(this.zzoQ.getContext(), this, this.zzoQ);
    }

    private FrameLayout zzn(Context context) {
        FrameLayout frameLayoutZzo = zzo(context);
        frameLayoutZzo.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(frameLayoutZzo);
        return frameLayoutZzo;
    }

    @Override // android.view.ViewGroup
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        super.addView(child, index, params);
        super.bringChildToFront(this.zzoQ);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void bringChildToFront(View child) {
        super.bringChildToFront(child);
        if (this.zzoQ != child) {
            super.bringChildToFront(this.zzoQ);
        }
    }

    public void destroy() {
        try {
            this.zzoR.destroy();
        } catch (RemoteException e) {
            zzb.zzb("Unable to destroy native ad view", e);
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        super.removeAllViews();
        super.addView(this.zzoQ);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View child) {
        if (this.zzoQ == child) {
            return;
        }
        super.removeView(child);
    }

    public void setNativeAd(NativeAd ad) {
        try {
            this.zzoR.zza((zzd) ad.zzaH());
        } catch (RemoteException e) {
            zzb.zzb("Unable to call setNativeAd on delegate", e);
        }
    }

    protected void zza(String str, View view) {
        try {
            this.zzoR.zza(str, zze.zzC(view));
        } catch (RemoteException e) {
            zzb.zzb("Unable to call setAssetView on delegate", e);
        }
    }

    protected View zzn(String str) {
        try {
            zzd zzdVarZzK = this.zzoR.zzK(str);
            if (zzdVarZzK != null) {
                return (View) zze.zzp(zzdVarZzK);
            }
        } catch (RemoteException e) {
            zzb.zzb("Unable to call getAssetView on delegate", e);
        }
        return null;
    }

    FrameLayout zzo(Context context) {
        return new FrameLayout(context);
    }
}
