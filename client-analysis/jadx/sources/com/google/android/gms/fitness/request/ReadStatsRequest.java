package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.internal.zzot;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ReadStatsRequest implements SafeParcelable {
    public static final Parcelable.Creator<ReadStatsRequest> CREATOR = new zzu();
    private final int mVersionCode;
    private final List<DataSource> zzaAF;
    private final zzot zzaBg;

    ReadStatsRequest(int versionCode, IBinder callback, List<DataSource> dataSources) {
        this.mVersionCode = versionCode;
        this.zzaBg = zzot.zza.zzbO(callback);
        this.zzaAF = dataSources;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public IBinder getCallbackBinder() {
        return this.zzaBg.asBinder();
    }

    public List<DataSource> getDataSources() {
        return this.zzaAF;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public String toString() {
        return String.format("ReadStatsRequest", new Object[0]);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        zzu.zza(this, parcel, flags);
    }
}
