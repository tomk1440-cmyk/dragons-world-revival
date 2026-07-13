package com.google.android.gms.wallet.firstparty;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public final class GetInstrumentsRequest implements SafeParcelable {
    public static final Parcelable.Creator<GetInstrumentsRequest> CREATOR = new zzd();
    private final int mVersionCode;
    int[] zzbpS;

    GetInstrumentsRequest() {
        this(1, null);
    }

    GetInstrumentsRequest(int versionCode, int[] familyFilter) {
        this.mVersionCode = versionCode;
        this.zzbpS = familyFilter;
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
        zzd.zza(this, out, flags);
    }
}
