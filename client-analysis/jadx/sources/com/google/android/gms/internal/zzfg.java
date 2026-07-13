package com.google.android.gms.internal;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzfg extends zzfb.zza {
    private final NativeAppInstallAdMapper zzCM;

    public zzfg(NativeAppInstallAdMapper nativeAppInstallAdMapper) {
        this.zzCM = nativeAppInstallAdMapper;
    }

    @Override // com.google.android.gms.internal.zzfb
    public String getBody() {
        return this.zzCM.getBody();
    }

    @Override // com.google.android.gms.internal.zzfb
    public String getCallToAction() {
        return this.zzCM.getCallToAction();
    }

    @Override // com.google.android.gms.internal.zzfb
    public Bundle getExtras() {
        return this.zzCM.getExtras();
    }

    @Override // com.google.android.gms.internal.zzfb
    public String getHeadline() {
        return this.zzCM.getHeadline();
    }

    @Override // com.google.android.gms.internal.zzfb
    public List getImages() {
        List<NativeAd.Image> images = this.zzCM.getImages();
        if (images == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (NativeAd.Image image : images) {
            arrayList.add(new com.google.android.gms.ads.internal.formats.zzc(image.getDrawable(), image.getUri(), image.getScale()));
        }
        return arrayList;
    }

    @Override // com.google.android.gms.internal.zzfb
    public boolean getOverrideClickHandling() {
        return this.zzCM.getOverrideClickHandling();
    }

    @Override // com.google.android.gms.internal.zzfb
    public boolean getOverrideImpressionRecording() {
        return this.zzCM.getOverrideImpressionRecording();
    }

    @Override // com.google.android.gms.internal.zzfb
    public String getPrice() {
        return this.zzCM.getPrice();
    }

    @Override // com.google.android.gms.internal.zzfb
    public double getStarRating() {
        return this.zzCM.getStarRating();
    }

    @Override // com.google.android.gms.internal.zzfb
    public String getStore() {
        return this.zzCM.getStore();
    }

    @Override // com.google.android.gms.internal.zzfb
    public void recordImpression() {
        this.zzCM.recordImpression();
    }

    @Override // com.google.android.gms.internal.zzfb
    public void zzc(com.google.android.gms.dynamic.zzd zzdVar) {
        this.zzCM.handleClick((View) com.google.android.gms.dynamic.zze.zzp(zzdVar));
    }

    @Override // com.google.android.gms.internal.zzfb
    public void zzd(com.google.android.gms.dynamic.zzd zzdVar) {
        this.zzCM.trackView((View) com.google.android.gms.dynamic.zze.zzp(zzdVar));
    }

    @Override // com.google.android.gms.internal.zzfb
    public zzch zzdK() {
        NativeAd.Image icon = this.zzCM.getIcon();
        if (icon != null) {
            return new com.google.android.gms.ads.internal.formats.zzc(icon.getDrawable(), icon.getUri(), icon.getScale());
        }
        return null;
    }
}
