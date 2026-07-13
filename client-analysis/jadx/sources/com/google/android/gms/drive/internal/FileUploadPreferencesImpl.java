package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.FileUploadPreferences;

/* JADX INFO: loaded from: classes.dex */
public final class FileUploadPreferencesImpl implements SafeParcelable, FileUploadPreferences {
    public static final Parcelable.Creator<FileUploadPreferencesImpl> CREATOR = new zzag();
    final int mVersionCode;
    int zzarG;
    int zzarH;
    boolean zzarI;

    FileUploadPreferencesImpl(int versionCode, int networkTypePreference, int batteryUsagePreference, boolean allowRoaming) {
        this.mVersionCode = versionCode;
        this.zzarG = networkTypePreference;
        this.zzarH = batteryUsagePreference;
        this.zzarI = allowRoaming;
    }

    public static boolean zzdj(int i) {
        switch (i) {
            case 1:
            case 2:
                return true;
            default:
                return false;
        }
    }

    public static boolean zzdk(int i) {
        switch (i) {
            case 256:
            case 257:
                return true;
            default:
                return false;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.drive.FileUploadPreferences
    public int getBatteryUsagePreference() {
        if (zzdk(this.zzarH)) {
            return this.zzarH;
        }
        return 0;
    }

    @Override // com.google.android.gms.drive.FileUploadPreferences
    public int getNetworkTypePreference() {
        if (zzdj(this.zzarG)) {
            return this.zzarG;
        }
        return 0;
    }

    @Override // com.google.android.gms.drive.FileUploadPreferences
    public boolean isRoamingAllowed() {
        return this.zzarI;
    }

    @Override // com.google.android.gms.drive.FileUploadPreferences
    public void setBatteryUsagePreference(int batteryUsagePreference) {
        if (!zzdk(batteryUsagePreference)) {
            throw new IllegalArgumentException("Invalid battery usage preference value.");
        }
        this.zzarH = batteryUsagePreference;
    }

    @Override // com.google.android.gms.drive.FileUploadPreferences
    public void setNetworkTypePreference(int networkTypePreference) {
        if (!zzdj(networkTypePreference)) {
            throw new IllegalArgumentException("Invalid data connection preference value.");
        }
        this.zzarG = networkTypePreference;
    }

    @Override // com.google.android.gms.drive.FileUploadPreferences
    public void setRoamingAllowed(boolean allowRoaming) {
        this.zzarI = allowRoaming;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        zzag.zza(this, parcel, flags);
    }
}
