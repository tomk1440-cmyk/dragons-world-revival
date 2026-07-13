package com.google.android.gms.internal;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzfh extends zzfc.zza {
    private final NativeContentAdMapper zzCN;

    public zzfh(NativeContentAdMapper nativeContentAdMapper) {
        this.zzCN = nativeContentAdMapper;
    }

    @Override // com.google.android.gms.internal.zzfc
    public String getAdvertiser() {
        return this.zzCN.getAdvertiser();
    }

    @Override // com.google.android.gms.internal.zzfc
    public String getBody() {
        return this.zzCN.getBody();
    }

    @Override // com.google.android.gms.internal.zzfc
    public String getCallToAction() {
        return this.zzCN.getCallToAction();
    }

    @Override // com.google.android.gms.internal.zzfc
    public Bundle getExtras() {
        return this.zzCN.getExtras();
    }

    @Override // com.google.android.gms.internal.zzfc
    public String getHeadline() {
        return this.zzCN.getHeadline();
    }

    @Override // com.google.android.gms.internal.zzfc
    public List getImages() {
        List<NativeAd.Image> images = this.zzCN.getImages();
        if (images == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (NativeAd.Image image : images) {
            arrayList.add(new com.google.android.gms.ads.internal.formats.zzc(image.getDrawable(), image.getUri(), image.getScale()));
        }
        return arrayList;
    }

    @Override // com.google.android.gms.internal.zzfc
    public boolean getOverrideClickHandling() {
        return this.zzCN.getOverrideClickHandling();
    }

    @Override // com.google.android.gms.internal.zzfc
    public boolean getOverrideImpressionRecording() {
        return this.zzCN.getOverrideImpressionRecording();
    }

    @Override // com.google.android.gms.internal.zzfc
    public void recordImpression() {
        this.zzCN.recordImpression();
    }

    @Override // com.google.android.gms.internal.zzfc
    public void zzc(com.google.android.gms.dynamic.zzd zzdVar) {
        this.zzCN.handleClick((View) com.google.android.gms.dynamic.zze.zzp(zzdVar));
    }

    @Override // com.google.android.gms.internal.zzfc
    public void zzd(com.google.android.gms.dynamic.zzd zzdVar) {
        this.zzCN.trackView((View) com.google.android.gms.dynamic.zze.zzp(zzdVar));
    }

    @Override // com.google.android.gms.internal.zzfc
    public zzch zzdO() {
        NativeAd.Image logo = this.zzCN.getLogo();
        if (logo != null) {
            return new com.google.android.gms.ads.internal.formats.zzc(logo.getDrawable(), logo.getUri(), logo.getScale());
        }
        return null;
    }
}
