package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public final class LoyaltyPoints implements SafeParcelable {
    public static final Parcelable.Creator<LoyaltyPoints> CREATOR = new zze();
    String label;
    private final int mVersionCode;
    String type;
    TimeInterval zzboY;
    LoyaltyPointsBalance zzbqI;

    LoyaltyPoints() {
        this.mVersionCode = 1;
    }

    LoyaltyPoints(int versionCode, String label, LoyaltyPointsBalance balance, String type, TimeInterval validTimeInterval) {
        this.mVersionCode = versionCode;
        this.label = label;
        this.zzbqI = balance;
        this.type = type;
        this.zzboY = validTimeInterval;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zze.zza(this, dest, flags);
    }
}
