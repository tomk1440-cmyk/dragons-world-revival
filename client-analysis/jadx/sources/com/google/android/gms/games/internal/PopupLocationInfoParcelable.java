package com.google.android.gms.games.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public final class PopupLocationInfoParcelable implements SafeParcelable {
    public static final PopupLocationInfoParcelableCreator CREATOR = new PopupLocationInfoParcelableCreator();
    private final int mVersionCode;
    private final Bundle zzaFH;
    private final IBinder zzaFI;

    PopupLocationInfoParcelable(int versionCode, Bundle infoBundle, IBinder windowToken) {
        this.mVersionCode = versionCode;
        this.zzaFH = infoBundle;
        this.zzaFI = windowToken;
    }

    public PopupLocationInfoParcelable(PopupManager.PopupLocationInfo popupLocationInfo) {
        this.mVersionCode = 1;
        this.zzaFH = popupLocationInfo.zzxg();
        this.zzaFI = popupLocationInfo.zzaFL;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public IBinder getWindowToken() {
        return this.zzaFI;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        PopupLocationInfoParcelableCreator.zza(this, out, flags);
    }

    public Bundle zzxg() {
        return this.zzaFH;
    }
}
