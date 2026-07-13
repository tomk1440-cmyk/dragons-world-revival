package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class AppMetadata implements SafeParcelable {
    public static final Parcelable.Creator<AppMetadata> CREATOR = new zzb();
    private final int mVersionCode;
    private final List<AppIdentifier> zzbaZ;

    AppMetadata(int versionCode, List<AppIdentifier> appIdentifiers) {
        this.mVersionCode = versionCode;
        this.zzbaZ = (List) zzx.zzb(appIdentifiers, "Must specify application identifiers");
        zzx.zza(appIdentifiers.size(), (Object) "Application identifiers cannot be empty");
    }

    public AppMetadata(List<AppIdentifier> appIdentifiers) {
        this(1, appIdentifiers);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<AppIdentifier> getAppIdentifiers() {
        return this.zzbaZ;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        zzb.zza(this, out, flags);
    }
}
