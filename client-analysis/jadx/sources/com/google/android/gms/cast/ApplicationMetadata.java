package com.google.android.gms.cast;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationMetadata implements SafeParcelable {
    public static final Parcelable.Creator<ApplicationMetadata> CREATOR = new zza();
    String mName;
    private final int mVersionCode;
    String zzZC;
    List<String> zzZD;
    String zzZE;
    Uri zzZF;
    List<WebImage> zzxX;

    private ApplicationMetadata() {
        this.mVersionCode = 1;
        this.zzxX = new ArrayList();
        this.zzZD = new ArrayList();
    }

    ApplicationMetadata(int versionCode, String applicationId, String name, List<WebImage> images, List<String> namespaces, String senderAppIdentifier, Uri senderAppLaunchUrl) {
        this.mVersionCode = versionCode;
        this.zzZC = applicationId;
        this.mName = name;
        this.zzxX = images;
        this.zzZD = namespaces;
        this.zzZE = senderAppIdentifier;
        this.zzZF = senderAppLaunchUrl;
    }

    public boolean areNamespacesSupported(List<String> namespaces) {
        return this.zzZD != null && this.zzZD.containsAll(namespaces);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ApplicationMetadata)) {
            return false;
        }
        ApplicationMetadata applicationMetadata = (ApplicationMetadata) obj;
        return zzf.zza(this.zzZC, applicationMetadata.zzZC) && zzf.zza(this.zzxX, applicationMetadata.zzxX) && zzf.zza(this.mName, applicationMetadata.mName) && zzf.zza(this.zzZD, applicationMetadata.zzZD) && zzf.zza(this.zzZE, applicationMetadata.zzZE) && zzf.zza(this.zzZF, applicationMetadata.zzZF);
    }

    public String getApplicationId() {
        return this.zzZC;
    }

    public List<WebImage> getImages() {
        return this.zzxX;
    }

    public String getName() {
        return this.mName;
    }

    public String getSenderAppIdentifier() {
        return this.zzZE;
    }

    public List<String> getSupportedNamespaces() {
        return Collections.unmodifiableList(this.zzZD);
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.mVersionCode), this.zzZC, this.mName, this.zzxX, this.zzZD, this.zzZE, this.zzZF);
    }

    public boolean isNamespaceSupported(String namespace) {
        return this.zzZD != null && this.zzZD.contains(namespace);
    }

    public String toString() {
        return "applicationId: " + this.zzZC + ", name: " + this.mName + ", images.count: " + (this.zzxX == null ? 0 : this.zzxX.size()) + ", namespaces.count: " + (this.zzZD != null ? this.zzZD.size() : 0) + ", senderAppIdentifier: " + this.zzZE + ", senderAppLaunchUrl: " + this.zzZF;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        zza.zza(this, out, flags);
    }

    public Uri zznx() {
        return this.zzZF;
    }
}
