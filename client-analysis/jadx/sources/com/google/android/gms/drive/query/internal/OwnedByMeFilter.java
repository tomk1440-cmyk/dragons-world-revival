package com.google.android.gms.drive.query.internal;

import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public class OwnedByMeFilter extends AbstractFilter {
    public static final zzo CREATOR = new zzo();
    final int mVersionCode;

    public OwnedByMeFilter() {
        this(1);
    }

    OwnedByMeFilter(int versionCode) {
        this.mVersionCode = versionCode;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        zzo.zza(this, out, flags);
    }

    @Override // com.google.android.gms.drive.query.Filter
    public <F> F zza(zzf<F> zzfVar) {
        return zzfVar.zztP();
    }
}
