package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public class OnPinnedDownloadPreferencesResponse implements SafeParcelable {
    public static final Parcelable.Creator<OnPinnedDownloadPreferencesResponse> CREATOR = new zzbf();
    final int mVersionCode;
    final ParcelableTransferPreferences zzasu;

    OnPinnedDownloadPreferencesResponse(int versionCode, ParcelableTransferPreferences prefs) {
        this.mVersionCode = versionCode;
        this.zzasu = prefs;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzbf.zza(this, dest, flags);
    }
}
