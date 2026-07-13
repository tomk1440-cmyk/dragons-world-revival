package com.google.android.gms.ads.internal.client;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzhb;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public final class AdRequestParcel implements SafeParcelable {
    public static final zzg CREATOR = new zzg();
    public final Bundle extras;
    public final int versionCode;
    public final long zztC;
    public final int zztD;
    public final List<String> zztE;
    public final boolean zztF;
    public final int zztG;
    public final boolean zztH;
    public final String zztI;
    public final SearchAdRequestParcel zztJ;
    public final Location zztK;
    public final String zztL;
    public final Bundle zztM;
    public final Bundle zztN;
    public final List<String> zztO;
    public final String zztP;
    public final String zztQ;
    public final boolean zztR;

    public AdRequestParcel(int versionCode, long birthday, Bundle extras, int gender, List<String> keywords, boolean isTestDevice, int tagForChildDirectedTreatment, boolean manualImpressionsEnabled, String publisherProvidedId, SearchAdRequestParcel searchAdRequestParcel, Location location, String contentUrl, Bundle networkExtras, Bundle customTargeting, List<String> categoryExclusions, String requestAgent, String requestPackage, boolean isDesignedForFamilies) {
        this.versionCode = versionCode;
        this.zztC = birthday;
        this.extras = extras == null ? new Bundle() : extras;
        this.zztD = gender;
        this.zztE = keywords;
        this.zztF = isTestDevice;
        this.zztG = tagForChildDirectedTreatment;
        this.zztH = manualImpressionsEnabled;
        this.zztI = publisherProvidedId;
        this.zztJ = searchAdRequestParcel;
        this.zztK = location;
        this.zztL = contentUrl;
        this.zztM = networkExtras;
        this.zztN = customTargeting;
        this.zztO = categoryExclusions;
        this.zztP = requestAgent;
        this.zztQ = requestPackage;
        this.zztR = isDesignedForFamilies;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (!(other instanceof AdRequestParcel)) {
            return false;
        }
        AdRequestParcel adRequestParcel = (AdRequestParcel) other;
        return this.versionCode == adRequestParcel.versionCode && this.zztC == adRequestParcel.zztC && com.google.android.gms.common.internal.zzw.equal(this.extras, adRequestParcel.extras) && this.zztD == adRequestParcel.zztD && com.google.android.gms.common.internal.zzw.equal(this.zztE, adRequestParcel.zztE) && this.zztF == adRequestParcel.zztF && this.zztG == adRequestParcel.zztG && this.zztH == adRequestParcel.zztH && com.google.android.gms.common.internal.zzw.equal(this.zztI, adRequestParcel.zztI) && com.google.android.gms.common.internal.zzw.equal(this.zztJ, adRequestParcel.zztJ) && com.google.android.gms.common.internal.zzw.equal(this.zztK, adRequestParcel.zztK) && com.google.android.gms.common.internal.zzw.equal(this.zztL, adRequestParcel.zztL) && com.google.android.gms.common.internal.zzw.equal(this.zztM, adRequestParcel.zztM) && com.google.android.gms.common.internal.zzw.equal(this.zztN, adRequestParcel.zztN) && com.google.android.gms.common.internal.zzw.equal(this.zztO, adRequestParcel.zztO) && com.google.android.gms.common.internal.zzw.equal(this.zztP, adRequestParcel.zztP) && com.google.android.gms.common.internal.zzw.equal(this.zztQ, adRequestParcel.zztQ) && this.zztR == adRequestParcel.zztR;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.zzw.hashCode(Integer.valueOf(this.versionCode), Long.valueOf(this.zztC), this.extras, Integer.valueOf(this.zztD), this.zztE, Boolean.valueOf(this.zztF), Integer.valueOf(this.zztG), Boolean.valueOf(this.zztH), this.zztI, this.zztJ, this.zztK, this.zztL, this.zztM, this.zztN, this.zztO, this.zztP, this.zztQ, Boolean.valueOf(this.zztR));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        zzg.zza(this, out, flags);
    }
}
