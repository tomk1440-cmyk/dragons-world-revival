package com.google.android.gms.wallet.firstparty;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public class InitializeBuyFlowRequest implements SafeParcelable {
    public static final Parcelable.Creator<InitializeBuyFlowRequest> CREATOR = new zzf();
    private final int mVersionCode;
    byte[][] zzbpV;

    InitializeBuyFlowRequest(int versionCode, byte[][] purchaseContextProtos) {
        this.mVersionCode = versionCode;
        this.zzbpV = purchaseContextProtos;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        zzf.zza(this, out, flags);
    }
}
