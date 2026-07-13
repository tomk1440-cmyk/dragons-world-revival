package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.GraphRequest;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.Field;
import com.google.android.gms.internal.zzoj;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DataTypeCreateRequest implements SafeParcelable {
    public static final Parcelable.Creator<DataTypeCreateRequest> CREATOR = new zzi();
    private final String mName;
    private final int mVersionCode;
    private final zzoj zzaBa;
    private final List<Field> zzawE;

    public static class Builder {
        private String mName;
        private List<Field> zzawE = new ArrayList();

        public Builder addField(Field field) {
            if (!this.zzawE.contains(field)) {
                this.zzawE.add(field);
            }
            return this;
        }

        public Builder addField(String name, int format) {
            com.google.android.gms.common.internal.zzx.zzb((name == null || name.isEmpty()) ? false : true, "Invalid name specified");
            return addField(Field.zzn(name, format));
        }

        public DataTypeCreateRequest build() {
            com.google.android.gms.common.internal.zzx.zza(this.mName != null, "Must set the name");
            com.google.android.gms.common.internal.zzx.zza(this.zzawE.isEmpty() ? false : true, "Must specify the data fields");
            return new DataTypeCreateRequest(this);
        }

        public Builder setName(String name) {
            this.mName = name;
            return this;
        }
    }

    DataTypeCreateRequest(int versionCode, String name, List<Field> fields, IBinder callback) {
        this.mVersionCode = versionCode;
        this.mName = name;
        this.zzawE = Collections.unmodifiableList(fields);
        this.zzaBa = zzoj.zza.zzbE(callback);
    }

    private DataTypeCreateRequest(Builder builder) {
        this(builder.mName, builder.zzawE, null);
    }

    public DataTypeCreateRequest(DataTypeCreateRequest request, zzoj callback) {
        this(request.mName, request.zzawE, callback);
    }

    public DataTypeCreateRequest(String name, List<Field> fields, zzoj callback) {
        this.mVersionCode = 3;
        this.mName = name;
        this.zzawE = Collections.unmodifiableList(fields);
        this.zzaBa = callback;
    }

    private boolean zzb(DataTypeCreateRequest dataTypeCreateRequest) {
        return com.google.android.gms.common.internal.zzw.equal(this.mName, dataTypeCreateRequest.mName) && com.google.android.gms.common.internal.zzw.equal(this.zzawE, dataTypeCreateRequest.zzawE);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return o == this || ((o instanceof DataTypeCreateRequest) && zzb((DataTypeCreateRequest) o));
    }

    public IBinder getCallbackBinder() {
        if (this.zzaBa == null) {
            return null;
        }
        return this.zzaBa.asBinder();
    }

    public List<Field> getFields() {
        return this.zzawE;
    }

    public String getName() {
        return this.mName;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.zzw.hashCode(this.mName, this.zzawE);
    }

    public String toString() {
        return com.google.android.gms.common.internal.zzw.zzy(this).zzg("name", this.mName).zzg(GraphRequest.FIELDS_PARAM, this.zzawE).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzi.zza(this, dest, flags);
    }
}
