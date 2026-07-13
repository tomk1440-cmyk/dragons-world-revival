package com.google.android.gms.identity.intents.model;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.AddressConstants;

/* JADX INFO: loaded from: classes.dex */
public final class UserAddress implements SafeParcelable {
    public static final Parcelable.Creator<UserAddress> CREATOR = new zzb();
    private final int mVersionCode;
    String name;
    String phoneNumber;
    String zzJU;
    String zzaMD;
    String zzaME;
    String zzaMF;
    String zzaMG;
    String zzaMH;
    String zzaMI;
    String zzaMJ;
    String zzaMK;
    String zzaML;
    boolean zzaMM;
    String zzaMN;
    String zzaMO;

    UserAddress() {
        this.mVersionCode = 1;
    }

    UserAddress(int versionCode, String name, String address1, String address2, String address3, String address4, String address5, String administrativeArea, String locality, String countryCode, String postalCode, String sortingCode, String phoneNumber, boolean isPostBox, String companyName, String emailAddress) {
        this.mVersionCode = versionCode;
        this.name = name;
        this.zzaMD = address1;
        this.zzaME = address2;
        this.zzaMF = address3;
        this.zzaMG = address4;
        this.zzaMH = address5;
        this.zzaMI = administrativeArea;
        this.zzaMJ = locality;
        this.zzJU = countryCode;
        this.zzaMK = postalCode;
        this.zzaML = sortingCode;
        this.phoneNumber = phoneNumber;
        this.zzaMM = isPostBox;
        this.zzaMN = companyName;
        this.zzaMO = emailAddress;
    }

    public static UserAddress fromIntent(Intent data) {
        if (data == null || !data.hasExtra(AddressConstants.Extras.EXTRA_ADDRESS)) {
            return null;
        }
        return (UserAddress) data.getParcelableExtra(AddressConstants.Extras.EXTRA_ADDRESS);
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

    public String getAddress4() {
        return this.zzaMG;
    }

    public String getAddress5() {
        return this.zzaMH;
    }

    public String getAdministrativeArea() {
        return this.zzaMI;
    }

    public String getCompanyName() {
        return this.zzaMN;
    }

    public String getCountryCode() {
        return this.zzJU;
    }

    public String getEmailAddress() {
        return this.zzaMO;
    }

    public String getLocality() {
        return this.zzaMJ;
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

    public String getSortingCode() {
        return this.zzaML;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public boolean isPostBox() {
        return this.zzaMM;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        zzb.zza(this, out, flags);
    }
}
