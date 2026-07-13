package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzos;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ReadRawRequest implements SafeParcelable {
    public static final Parcelable.Creator<ReadRawRequest> CREATOR = new zzt();
    private final int mVersionCode;
    private final boolean zzaAP;
    private final boolean zzaAQ;
    private final zzos zzaBe;
    private final List<DataSourceQueryParams> zzaBf;

    ReadRawRequest(int versionCode, IBinder callback, List<DataSourceQueryParams> queryParams, boolean flushBufferBeforeRead, boolean serverQueriesEnabled) {
        this.mVersionCode = versionCode;
        this.zzaBe = zzos.zza.zzbN(callback);
        this.zzaBf = queryParams;
        this.zzaAP = flushBufferBeforeRead;
        this.zzaAQ = serverQueriesEnabled;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public IBinder getCallbackBinder() {
        if (this.zzaBe != null) {
            return this.zzaBe.asBinder();
        }
        return null;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        zzt.zza(this, parcel, flags);
    }

    public boolean zzuP() {
        return this.zzaAQ;
    }

    public boolean zzuQ() {
        return this.zzaAP;
    }

    public List<DataSourceQueryParams> zzuW() {
        return this.zzaBf;
    }
}
