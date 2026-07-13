package com.google.android.gms.ads.internal.formats;

import android.os.Parcel;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzhb;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class NativeAdOptionsParcel implements SafeParcelable {
    public static final zzj CREATOR = new zzj();
    public final int versionCode;
    public final boolean zzyA;
    public final int zzyB;
    public final boolean zzyC;

    public NativeAdOptionsParcel(int versionCode, boolean shouldReturnUrlsForImageAssets, int imageOrientation, boolean shouldRequestMultipleImages) {
        this.versionCode = versionCode;
        this.zzyA = shouldReturnUrlsForImageAssets;
        this.zzyB = imageOrientation;
        this.zzyC = shouldRequestMultipleImages;
    }

    public NativeAdOptionsParcel(NativeAdOptions options) {
        this(1, options.shouldReturnUrlsForImageAssets(), options.getImageOrientation(), options.shouldRequestMultipleImages());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        zzj.zza(this, out, flags);
    }
}
