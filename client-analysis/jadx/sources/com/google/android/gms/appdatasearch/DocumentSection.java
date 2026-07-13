package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

/* JADX INFO: loaded from: classes.dex */
public class DocumentSection implements SafeParcelable {
    final int mVersionCode;
    public final String zzTO;
    final RegisterSectionInfo zzTP;
    public final int zzTQ;
    public final byte[] zzTR;
    public static final int zzTM = Integer.parseInt("-1");
    public static final zzd CREATOR = new zzd();
    private static final RegisterSectionInfo zzTN = new RegisterSectionInfo.zza("SsbContext").zzM(true).zzbB("blob").zzmh();

    DocumentSection(int versionCode, String content, RegisterSectionInfo sectionInfo, int globalSearchSectionType, byte[] blobContent) {
        zzx.zzb(globalSearchSectionType == zzTM || zzh.zzao(globalSearchSectionType) != null, "Invalid section type " + globalSearchSectionType);
        this.mVersionCode = versionCode;
        this.zzTO = content;
        this.zzTP = sectionInfo;
        this.zzTQ = globalSearchSectionType;
        this.zzTR = blobContent;
        String strZzmf = zzmf();
        if (strZzmf != null) {
            throw new IllegalArgumentException(strZzmf);
        }
    }

    public DocumentSection(String content, RegisterSectionInfo sectionInfo) {
        this(1, content, sectionInfo, zzTM, null);
    }

    public DocumentSection(String content, RegisterSectionInfo sectionInfo, String globalSearchSectionType) {
        this(1, content, sectionInfo, zzh.zzbA(globalSearchSectionType), null);
    }

    public DocumentSection(byte[] blobContent, RegisterSectionInfo sectionInfo) {
        this(1, null, sectionInfo, zzTM, blobContent);
    }

    public static DocumentSection zzh(byte[] bArr) {
        return new DocumentSection(bArr, zzTN);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        zzd zzdVar = CREATOR;
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzd zzdVar = CREATOR;
        zzd.zza(this, dest, flags);
    }

    public String zzmf() {
        if (this.zzTQ != zzTM && zzh.zzao(this.zzTQ) == null) {
            return "Invalid section type " + this.zzTQ;
        }
        if (this.zzTO == null || this.zzTR == null) {
            return null;
        }
        return "Both content and blobContent set";
    }
}
