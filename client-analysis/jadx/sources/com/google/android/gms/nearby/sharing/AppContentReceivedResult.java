package com.google.android.gms.nearby.sharing;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

/* JADX INFO: loaded from: classes.dex */
public class AppContentReceivedResult implements SafeParcelable {
    public static final Parcelable.Creator<AppContentReceivedResult> CREATOR = new zza();
    private int statusCode;
    private final int versionCode;
    private Uri zzbde;

    private AppContentReceivedResult() {
        this.versionCode = 1;
    }

    AppContentReceivedResult(int versionCode, Uri destinationUri, int statusCode) {
        this.versionCode = versionCode;
        this.zzbde = destinationUri;
        this.statusCode = statusCode;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof AppContentReceivedResult)) {
            return false;
        }
        AppContentReceivedResult appContentReceivedResult = (AppContentReceivedResult) o;
        return zzw.equal(this.zzbde, appContentReceivedResult.zzbde) && zzw.equal(Integer.valueOf(this.statusCode), Integer.valueOf(appContentReceivedResult.statusCode));
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    int getVersionCode() {
        return this.versionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzbde, Integer.valueOf(this.statusCode));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zza.zza(this, dest, flags);
    }

    public Uri zzEJ() {
        return this.zzbde;
    }
}
