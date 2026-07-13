package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.drive.query.Filter;

/* JADX INFO: loaded from: classes.dex */
public class NotFilter extends AbstractFilter {
    public static final Parcelable.Creator<NotFilter> CREATOR = new zzm();
    final int mVersionCode;
    final FilterHolder zzauw;

    NotFilter(int versionCode, FilterHolder toNegate) {
        this.mVersionCode = versionCode;
        this.zzauw = toNegate;
    }

    public NotFilter(Filter toNegate) {
        this(1, new FilterHolder(toNegate));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        zzm.zza(this, out, flags);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.drive.query.Filter
    public <T> T zza(zzf<T> zzfVar) {
        return (T) zzfVar.zzB(this.zzauw.getFilter().zza(zzfVar));
    }
}
