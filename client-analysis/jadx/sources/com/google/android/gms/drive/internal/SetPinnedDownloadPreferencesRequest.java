package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public class SetPinnedDownloadPreferencesRequest implements SafeParcelable {
    public static final Parcelable.Creator<SetPinnedDownloadPreferencesRequest> CREATOR = new zzbs();
    final int mVersionCode;
    final ParcelableTransferPreferences zzasu;

    SetPinnedDownloadPreferencesRequest(int versionCode, ParcelableTransferPreferences prefs) {
        this.mVersionCode = versionCode;
        this.zzasu = prefs;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzbs.zza(this, dest, flags);
    }
}
