package com.google.android.gms.ads.internal.util.client;

import android.os.Parcel;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzhb;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public final class VersionInfoParcel implements SafeParcelable {
    public static final zzc CREATOR = new zzc();
    public String afmaVersion;
    public final int versionCode;
    public int zzMZ;
    public int zzNa;
    public boolean zzNb;

    public VersionInfoParcel(int buddyApkVersion, int clientJarVersion, boolean isClientJar) {
        this(1, "afma-sdk-a-v" + buddyApkVersion + "." + clientJarVersion + "." + (isClientJar ? AppEventsConstants.EVENT_PARAM_VALUE_NO : AppEventsConstants.EVENT_PARAM_VALUE_YES), buddyApkVersion, clientJarVersion, isClientJar);
    }

    VersionInfoParcel(int versionCode, String afmaVersion, int buddyApkVersion, int clientJarVersion, boolean isClientJar) {
        this.versionCode = versionCode;
        this.afmaVersion = afmaVersion;
        this.zzMZ = buddyApkVersion;
        this.zzNa = clientJarVersion;
        this.zzNb = isClientJar;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        zzc.zza(this, out, flags);
    }
}
