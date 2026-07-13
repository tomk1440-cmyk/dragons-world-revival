package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.zzow;

/* JADX INFO: loaded from: classes.dex */
public class UnsubscribeRequest implements SafeParcelable {
    public static final Parcelable.Creator<UnsubscribeRequest> CREATOR = new zzah();
    private final int mVersionCode;
    private final zzow zzaAD;
    private final DataType zzavT;
    private final DataSource zzavU;

    UnsubscribeRequest(int versionCode, DataType dataType, DataSource dataSource, IBinder callback) {
        this.mVersionCode = versionCode;
        this.zzavT = dataType;
        this.zzavU = dataSource;
        this.zzaAD = zzow.zza.zzbR(callback);
    }

    public UnsubscribeRequest(DataType dataType, DataSource dataSource, zzow callback) {
        this.mVersionCode = 3;
        this.zzavT = dataType;
        this.zzavU = dataSource;
        this.zzaAD = callback;
    }

    private boolean zzb(UnsubscribeRequest unsubscribeRequest) {
        return com.google.android.gms.common.internal.zzw.equal(this.zzavU, unsubscribeRequest.zzavU) && com.google.android.gms.common.internal.zzw.equal(this.zzavT, unsubscribeRequest.zzavT);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return this == o || ((o instanceof UnsubscribeRequest) && zzb((UnsubscribeRequest) o));
    }

    public IBinder getCallbackBinder() {
        if (this.zzaAD == null) {
            return null;
        }
        return this.zzaAD.asBinder();
    }

    public DataSource getDataSource() {
        return this.zzavU;
    }

    public DataType getDataType() {
        return this.zzavT;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.zzw.hashCode(this.zzavU, this.zzavT);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        zzah.zza(this, parcel, flags);
    }
}
