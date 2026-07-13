package com.google.android.gms.internal;

import android.location.Location;
import android.support.annotation.Nullable;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import java.util.Date;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public final class zzfi implements NativeMediationAdRequest {
    private final int zzCH;
    private final Date zzbf;
    private final Set<String> zzbh;
    private final boolean zzbi;
    private final Location zzbj;
    private final NativeAdOptionsParcel zzpP;
    private final List<String> zzpQ;
    private final int zztT;
    private final boolean zzuf;

    public zzfi(@Nullable Date date, int i, @Nullable Set<String> set, @Nullable Location location, boolean z, int i2, NativeAdOptionsParcel nativeAdOptionsParcel, List<String> list, boolean z2) {
        this.zzbf = date;
        this.zztT = i;
        this.zzbh = set;
        this.zzbj = location;
        this.zzbi = z;
        this.zzCH = i2;
        this.zzpP = nativeAdOptionsParcel;
        this.zzpQ = list;
        this.zzuf = z2;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public Date getBirthday() {
        return this.zzbf;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public int getGender() {
        return this.zztT;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public Set<String> getKeywords() {
        return this.zzbh;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public Location getLocation() {
        return this.zzbj;
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public NativeAdOptions getNativeAdOptions() {
        if (this.zzpP == null) {
            return null;
        }
        return new NativeAdOptions.Builder().setReturnUrlsForImageAssets(this.zzpP.zzyA).setImageOrientation(this.zzpP.zzyB).setRequestMultipleImages(this.zzpP.zzyC).build();
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public boolean isAppInstallAdRequested() {
        return this.zzpQ != null && this.zzpQ.contains("2");
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public boolean isContentAdRequested() {
        return this.zzpQ != null && this.zzpQ.contains(AppEventsConstants.EVENT_PARAM_VALUE_YES);
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public boolean isDesignedForFamilies() {
        return this.zzuf;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public boolean isTesting() {
        return this.zzbi;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public int taggedForChildDirectedTreatment() {
        return this.zzCH;
    }
}
