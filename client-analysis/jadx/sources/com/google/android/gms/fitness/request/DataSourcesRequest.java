package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.internal.zzoi;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DataSourcesRequest implements SafeParcelable {
    public static final Parcelable.Creator<DataSourcesRequest> CREATOR = new zzh();
    private final int mVersionCode;
    private final List<Integer> zzaAV;
    private final boolean zzaAW;
    private final zzoi zzaAX;
    private final List<DataType> zzawe;

    public static class Builder {
        private DataType[] zzaAY = new DataType[0];
        private int[] zzaAZ = {0, 1};
        private boolean zzaAW = false;

        public DataSourcesRequest build() {
            com.google.android.gms.common.internal.zzx.zza(this.zzaAY.length > 0, "Must add at least one data type");
            com.google.android.gms.common.internal.zzx.zza(this.zzaAZ.length > 0, "Must add at least one data source type");
            return new DataSourcesRequest(this);
        }

        public Builder setDataSourceTypes(int... dataSourceTypes) {
            this.zzaAZ = dataSourceTypes;
            return this;
        }

        public Builder setDataTypes(DataType... dataTypes) {
            this.zzaAY = dataTypes;
            return this;
        }
    }

    DataSourcesRequest(int versionCode, List<DataType> dataTypes, List<Integer> dataSourceTypes, boolean includeDbOnlySources, IBinder callback) {
        this.mVersionCode = versionCode;
        this.zzawe = dataTypes;
        this.zzaAV = dataSourceTypes;
        this.zzaAW = includeDbOnlySources;
        this.zzaAX = zzoi.zza.zzbD(callback);
    }

    private DataSourcesRequest(Builder builder) {
        this(zzmn.zzb(builder.zzaAY), Arrays.asList(zzmn.zza(builder.zzaAZ)), builder.zzaAW, null);
    }

    public DataSourcesRequest(DataSourcesRequest request, zzoi callback) {
        this(request.zzawe, request.zzaAV, request.zzaAW, callback);
    }

    public DataSourcesRequest(List<DataType> dataTypes, List<Integer> dataSourceTypes, boolean includeDbOnlySources, zzoi callback) {
        this.mVersionCode = 4;
        this.zzawe = dataTypes;
        this.zzaAV = dataSourceTypes;
        this.zzaAW = includeDbOnlySources;
        this.zzaAX = callback;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public IBinder getCallbackBinder() {
        if (this.zzaAX == null) {
            return null;
        }
        return this.zzaAX.asBinder();
    }

    public List<DataType> getDataTypes() {
        return this.zzawe;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public String toString() {
        com.google.android.gms.common.internal.zzw.zza zzaVarZzg = com.google.android.gms.common.internal.zzw.zzy(this).zzg("dataTypes", this.zzawe).zzg("sourceTypes", this.zzaAV);
        if (this.zzaAW) {
            zzaVarZzg.zzg("includeDbOnlySources", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        }
        return zzaVarZzg.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        zzh.zza(this, parcel, flags);
    }

    public List<Integer> zzuT() {
        return this.zzaAV;
    }

    public boolean zzuU() {
        return this.zzaAW;
    }
}
