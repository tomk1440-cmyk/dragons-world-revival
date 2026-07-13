package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public class OnDeviceUsagePreferenceResponse implements SafeParcelable {
    public static final Parcelable.Creator<OnDeviceUsagePreferenceResponse> CREATOR = new zzax();
    final int mVersionCode;
    final FileUploadPreferencesImpl zzasg;

    OnDeviceUsagePreferenceResponse(int versionCode, FileUploadPreferencesImpl preferences) {
        this.mVersionCode = versionCode;
        this.zzasg = preferences;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzax.zza(this, dest, flags);
    }

    public FileUploadPreferencesImpl zztp() {
        return this.zzasg;
    }
}
