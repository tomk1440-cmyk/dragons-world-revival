package com.google.android.gms.safetynet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public class SafeBrowsingData implements SafeParcelable {
    public static final Parcelable.Creator<SafeBrowsingData> CREATOR = new zzb();
    public final int mVersionCode;
    private String zzbgv;

    SafeBrowsingData(int versionCode, String metadata) {
        this.mVersionCode = versionCode;
        this.zzbgv = metadata;
    }

    public SafeBrowsingData(String metadata) {
        this(1, metadata);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getMetadata() {
        return this.zzbgv;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        zzb.zza(this, out, flags);
    }
}
