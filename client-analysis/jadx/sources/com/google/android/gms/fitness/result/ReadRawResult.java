package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ReadRawResult implements Result, SafeParcelable {
    public static final Parcelable.Creator<ReadRawResult> CREATOR = new zzi();
    private final int mVersionCode;
    private final List<DataHolder> zzaBN;
    private final DataHolder zzahi;

    ReadRawResult(int versionCode, DataHolder dataHolder, List<DataHolder> dataHolders) {
        this.mVersionCode = versionCode;
        this.zzahi = dataHolder;
        this.zzaBN = dataHolders == null ? Collections.singletonList(dataHolder) : dataHolders;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return new Status(this.zzahi.getStatusCode());
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzi.zza(this, dest, flags);
    }

    DataHolder zzsX() {
        return this.zzahi;
    }

    public List<DataHolder> zzvo() {
        return this.zzaBN;
    }
}
