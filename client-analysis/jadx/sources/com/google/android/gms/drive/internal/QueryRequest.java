package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.Query;

/* JADX INFO: loaded from: classes.dex */
public class QueryRequest implements SafeParcelable {
    public static final Parcelable.Creator<QueryRequest> CREATOR = new zzbo();
    final int mVersionCode;
    final Query zzasB;

    QueryRequest(int versionCode, Query query) {
        this.mVersionCode = versionCode;
        this.zzasB = query;
    }

    public QueryRequest(Query query) {
        this(1, query);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzbo.zza(this, dest, flags);
    }
}
