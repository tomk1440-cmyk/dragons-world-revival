package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public final class IsReadyToPayRequest implements SafeParcelable {
    public static final Parcelable.Creator<IsReadyToPayRequest> CREATOR = new zzi();
    final int mVersionCode;

    public final class zza {
        private zza() {
        }

        public IsReadyToPayRequest zzIk() {
            return IsReadyToPayRequest.this;
        }
    }

    IsReadyToPayRequest() {
        this.mVersionCode = 1;
    }

    IsReadyToPayRequest(int versionCode) {
        this.mVersionCode = versionCode;
    }

    public static zza zzIj() {
        IsReadyToPayRequest isReadyToPayRequest = new IsReadyToPayRequest();
        isReadyToPayRequest.getClass();
        return new zza();
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
        zzi.zza(this, out, flags);
    }
}
