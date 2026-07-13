package com.google.android.gms.drive.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public class OnStartStreamSession implements SafeParcelable {
    public static final Parcelable.Creator<OnStartStreamSession> CREATOR = new zzbi();
    final int mVersionCode;
    final ParcelFileDescriptor zzasv;
    final IBinder zzasw;
    final String zzsU;

    OnStartStreamSession(int versionCode, ParcelFileDescriptor pfd, IBinder closeToken, String signature) {
        this.mVersionCode = versionCode;
        this.zzasv = pfd;
        this.zzasw = closeToken;
        this.zzsU = signature;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzbi.zza(this, dest, flags | 1);
    }
}
