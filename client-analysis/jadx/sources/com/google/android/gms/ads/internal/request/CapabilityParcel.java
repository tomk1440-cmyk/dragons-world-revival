package com.google.android.gms.ads.internal.request;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzhb;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class CapabilityParcel implements SafeParcelable {
    public static final Parcelable.Creator<CapabilityParcel> CREATOR = new zzi();
    public final int versionCode;
    public final boolean zzIn;
    public final boolean zzIo;
    public final boolean zzIp;

    CapabilityParcel(int versionCode, boolean inAppPurchaseSupported, boolean defaultInAppPurchaseSupported, boolean appStreamingSupported) {
        this.versionCode = versionCode;
        this.zzIn = inAppPurchaseSupported;
        this.zzIo = defaultInAppPurchaseSupported;
        this.zzIp = appStreamingSupported;
    }

    public CapabilityParcel(boolean inAppPurchaseSupported, boolean defaultInAppPurchaseSupported, boolean appStreamingSupported) {
        this(2, inAppPurchaseSupported, defaultInAppPurchaseSupported, appStreamingSupported);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("iap_supported", this.zzIn);
        bundle.putBoolean("default_iap_supported", this.zzIo);
        bundle.putBoolean("app_streaming_supported", this.zzIp);
        return bundle;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzi.zza(this, dest, flags);
    }
}
