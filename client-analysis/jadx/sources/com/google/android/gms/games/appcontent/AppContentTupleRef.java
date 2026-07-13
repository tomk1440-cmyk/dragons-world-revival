package com.google.android.gms.games.appcontent;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;

/* JADX INFO: loaded from: classes.dex */
public final class AppContentTupleRef extends zzc implements AppContentTuple {
    AppContentTupleRef(DataHolder holder, int dataRow) {
        super(holder, dataRow);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.common.data.zzc
    public boolean equals(Object obj) {
        return AppContentTupleEntity.zza(this, obj);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentTuple
    public String getName() {
        return getString("tuple_name");
    }

    @Override // com.google.android.gms.games.appcontent.AppContentTuple
    public String getValue() {
        return getString("tuple_value");
    }

    @Override // com.google.android.gms.common.data.zzc
    public int hashCode() {
        return AppContentTupleEntity.zza(this);
    }

    public String toString() {
        return AppContentTupleEntity.zzb(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        ((AppContentTupleEntity) freeze()).writeToParcel(dest, flags);
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* JADX INFO: renamed from: zzwq, reason: merged with bridge method [inline-methods] */
    public AppContentTuple freeze() {
        return new AppContentTupleEntity(this);
    }
}
