package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class Address implements SafeParcelable {
    public static final Parcelable.Creator<Address> CREATOR = new zza();
    private final int mVersionCode;
    String name;
    String phoneNumber;
    String zzJU;
    String zzaMD;
    String zzaME;
    String zzaMF;
    String zzaMK;
    boolean zzaMM;
    String zzaMN;
    String zzbof;
    String zzbog;

    Address() {
        this.mVersionCode = 1;
    }

    Address(int versionCode, String name, String address1, String address2, String address3, String countryCode, String city, String state, String postalCode, String phoneNumber, boolean isPostBox, String companyName) {
        this.mVersionCode = versionCode;
        this.name = name;
        this.zzaMD = address1;
        this.zzaME = address2;
        this.zzaMF = address3;
        this.zzJU = countryCode;
        this.zzbof = city;
        this.zzbog = state;
        this.zzaMK = postalCode;
        this.phoneNumber = phoneNumber;
        this.zzaMM = isPostBox;
        this.zzaMN = companyName;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAddress1() {
        return this.zzaMD;
    }

    public String getAddress2() {
        return this.zzaME;
    }

    public String getAddress3() {
        return this.zzaMF;
    }

    public String getCity() {
        return this.zzbof;
    }

    public String getCompanyName() {
        return this.zzaMN;
    }

    public String getCountryCode() {
        return this.zzJU;
    }

    public String getName() {
        return this.name;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getPostalCode() {
        return this.zzaMK;
    }

    public String getState() {
        return this.zzbog;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public boolean isPostBox() {
        return this.zzaMM;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        zza.zza(this, out, flags);
    }
}
