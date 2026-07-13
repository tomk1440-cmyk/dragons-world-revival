package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public final class ProxyCard implements SafeParcelable {
    public static final Parcelable.Creator<ProxyCard> CREATOR = new zzr();
    private final int mVersionCode;
    String zzbpF;
    String zzbpG;
    int zzbpH;
    int zzbpI;

    ProxyCard(int versionCode, String pan, String cvn, int expirationMonth, int expirationYear) {
        this.mVersionCode = versionCode;
        this.zzbpF = pan;
        this.zzbpG = cvn;
        this.zzbpH = expirationMonth;
        this.zzbpI = expirationYear;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getCvn() {
        return this.zzbpG;
    }

    public int getExpirationMonth() {
        return this.zzbpH;
    }

    public int getExpirationYear() {
        return this.zzbpI;
    }

    public String getPan() {
        return this.zzbpF;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        zzr.zza(this, out, flags);
    }
}
