package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.wallet.wobs.LabelValueRow;
import com.google.android.gms.wallet.wobs.LoyaltyPoints;
import com.google.android.gms.wallet.wobs.TextModuleData;
import com.google.android.gms.wallet.wobs.TimeInterval;
import com.google.android.gms.wallet.wobs.UriData;
import com.google.android.gms.wallet.wobs.WalletObjectMessage;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class LoyaltyWalletObject implements SafeParcelable {
    public static final Parcelable.Creator<LoyaltyWalletObject> CREATOR = new zzk();
    private final int mVersionCode;
    int state;
    String zzaQZ;
    String zzboP;
    String zzboQ;
    String zzboR;
    String zzboS;
    String zzboT;
    String zzboU;
    String zzboV;
    String zzboW;
    ArrayList<WalletObjectMessage> zzboX;
    TimeInterval zzboY;
    ArrayList<LatLng> zzboZ;
    String zzbpa;
    String zzbpb;
    ArrayList<LabelValueRow> zzbpc;
    boolean zzbpd;
    ArrayList<UriData> zzbpe;
    ArrayList<TextModuleData> zzbpf;
    ArrayList<UriData> zzbpg;
    LoyaltyPoints zzbph;
    String zzio;

    LoyaltyWalletObject() {
        this.mVersionCode = 4;
        this.zzboX = zzmn.zzsa();
        this.zzboZ = zzmn.zzsa();
        this.zzbpc = zzmn.zzsa();
        this.zzbpe = zzmn.zzsa();
        this.zzbpf = zzmn.zzsa();
        this.zzbpg = zzmn.zzsa();
    }

    LoyaltyWalletObject(int versionCode, String id, String accountId, String issuerName, String programName, String accountName, String barcodeAlternateText, String barcodeType, String barcodeValue, String barcodeLabel, String classId, int state, ArrayList<WalletObjectMessage> messages, TimeInterval validTimeInterval, ArrayList<LatLng> locations, String infoModuleDataHexFontColor, String infoModuleDataHexBackgroundColor, ArrayList<LabelValueRow> infoModuleDataLabelValueRows, boolean infoModuleDataShowLastUpdateTime, ArrayList<UriData> imageModuleDataMainImageUris, ArrayList<TextModuleData> textModulesData, ArrayList<UriData> linksModuleDataUris, LoyaltyPoints loyaltyPoints) {
        this.mVersionCode = versionCode;
        this.zzio = id;
        this.zzboP = accountId;
        this.zzboQ = issuerName;
        this.zzboR = programName;
        this.zzaQZ = accountName;
        this.zzboS = barcodeAlternateText;
        this.zzboT = barcodeType;
        this.zzboU = barcodeValue;
        this.zzboV = barcodeLabel;
        this.zzboW = classId;
        this.state = state;
        this.zzboX = messages;
        this.zzboY = validTimeInterval;
        this.zzboZ = locations;
        this.zzbpa = infoModuleDataHexFontColor;
        this.zzbpb = infoModuleDataHexBackgroundColor;
        this.zzbpc = infoModuleDataLabelValueRows;
        this.zzbpd = infoModuleDataShowLastUpdateTime;
        this.zzbpe = imageModuleDataMainImageUris;
        this.zzbpf = textModulesData;
        this.zzbpg = linksModuleDataUris;
        this.zzbph = loyaltyPoints;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAccountId() {
        return this.zzboP;
    }

    public String getAccountName() {
        return this.zzaQZ;
    }

    public String getBarcodeAlternateText() {
        return this.zzboS;
    }

    public String getBarcodeType() {
        return this.zzboT;
    }

    public String getBarcodeValue() {
        return this.zzboU;
    }

    public String getId() {
        return this.zzio;
    }

    public String getIssuerName() {
        return this.zzboQ;
    }

    public String getProgramName() {
        return this.zzboR;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzk.zza(this, dest, flags);
    }
}
