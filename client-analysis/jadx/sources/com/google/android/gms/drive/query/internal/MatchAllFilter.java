package com.google.android.gms.drive.query.internal;

import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public class MatchAllFilter extends AbstractFilter {
    public static final zzl CREATOR = new zzl();
    final int mVersionCode;

    public MatchAllFilter() {
        this(1);
    }

    MatchAllFilter(int versionCode) {
        this.mVersionCode = versionCode;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        zzl.zza(this, out, flags);
    }

    @Override // com.google.android.gms.drive.query.Filter
    public <F> F zza(zzf<F> zzfVar) {
        return zzfVar.zztQ();
    }
}
