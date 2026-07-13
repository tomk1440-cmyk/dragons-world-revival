package com.google.android.gms.wallet.firstparty;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public final class GetBuyFlowInitializationTokenResponse implements SafeParcelable {
    public static final Parcelable.Creator<GetBuyFlowInitializationTokenResponse> CREATOR = new zzc();
    private final int mVersionCode;
    byte[] zzbpR;

    GetBuyFlowInitializationTokenResponse() {
        this(1, new byte[0]);
    }

    GetBuyFlowInitializationTokenResponse(int versionCode, byte[] buyFlowInitializationToken) {
        this.mVersionCode = versionCode;
        this.zzbpR = buyFlowInitializationToken;
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
        zzc.zza(this, out, flags);
    }
}
