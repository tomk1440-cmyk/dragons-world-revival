package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
@KeepName
public class CommonWalletObject implements SafeParcelable {
    public static final Parcelable.Creator<CommonWalletObject> CREATOR = new com.google.android.gms.wallet.wobs.zza();
    private final int mVersionCode;
    String name;
    int state;
    String zzboQ;
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
    String zzio;

    public final class zza {
        private zza() {
        }

        public CommonWalletObject zzIs() {
            return CommonWalletObject.this;
        }

        public zza zzgK(String str) {
            CommonWalletObject.this.zzio = str;
            return this;
        }
    }

    CommonWalletObject() {
        this.mVersionCode = 1;
        this.zzboX = zzmn.zzsa();
        this.zzboZ = zzmn.zzsa();
        this.zzbpc = zzmn.zzsa();
        this.zzbpe = zzmn.zzsa();
        this.zzbpf = zzmn.zzsa();
        this.zzbpg = zzmn.zzsa();
    }

    CommonWalletObject(int versionCode, String id, String classId, String name, String issuerName, String barcodeAlternateText, String barcodeType, String barcodeValue, String barcodeLabel, int state, ArrayList<WalletObjectMessage> messages, TimeInterval validTimeInterval, ArrayList<LatLng> locations, String infoModuleDataHexFontColor, String infoModuleDataHexBackgroundColor, ArrayList<LabelValueRow> infoModuleDataLabelValueRows, boolean infoModuleDataShowLastUpdateTime, ArrayList<UriData> imageModuleDataMainImageUris, ArrayList<TextModuleData> textModulesData, ArrayList<UriData> linksModuleDataUris) {
        this.mVersionCode = versionCode;
        this.zzio = id;
        this.zzboW = classId;
        this.name = name;
        this.zzboQ = issuerName;
        this.zzboS = barcodeAlternateText;
        this.zzboT = barcodeType;
        this.zzboU = barcodeValue;
        this.zzboV = barcodeLabel;
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
    }

    public static zza zzIr() {
        CommonWalletObject commonWalletObject = new CommonWalletObject();
        commonWalletObject.getClass();
        return new zza();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getId() {
        return this.zzio;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        com.google.android.gms.wallet.wobs.zza.zza(this, dest, flags);
    }
}
