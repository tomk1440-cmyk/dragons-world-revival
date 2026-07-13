package com.google.android.gms.wallet.firstparty;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class GetBuyFlowInitializationTokenRequest implements SafeParcelable {
    public static final Parcelable.Creator<GetBuyFlowInitializationTokenRequest> CREATOR = new zzb();
    private final int mVersionCode;
    byte[] zzbpP;
    byte[] zzbpQ;

    GetBuyFlowInitializationTokenRequest() {
        this(1, null, null);
    }

    GetBuyFlowInitializationTokenRequest(int versionCode, byte[] encryptedBuyFlowParameters, byte[] unencryptedBuyFlowParameters) {
        this.mVersionCode = versionCode;
        this.zzbpP = encryptedBuyFlowParameters;
        this.zzbpQ = unencryptedBuyFlowParameters;
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
        zzb.zza(this, out, flags);
    }
}
