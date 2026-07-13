package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public class PlacePhotoMetadataResult implements Result, SafeParcelable {
    public static final Parcelable.Creator<PlacePhotoMetadataResult> CREATOR = new zzh();
    final int mVersionCode;
    private final Status zzUX;
    final DataHolder zzaPE;
    private final PlacePhotoMetadataBuffer zzaPF;

    PlacePhotoMetadataResult(int versionCode, Status status, DataHolder dataHolder) {
        this.mVersionCode = versionCode;
        this.zzUX = status;
        this.zzaPE = dataHolder;
        if (dataHolder == null) {
            this.zzaPF = null;
        } else {
            this.zzaPF = new PlacePhotoMetadataBuffer(this.zzaPE);
        }
    }

    public PlacePhotoMetadataResult(Status status, DataHolder dataHolder) {
        this(0, status, dataHolder);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public PlacePhotoMetadataBuffer getPhotoMetadata() {
        return this.zzaPF;
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.zzUX;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        zzh.zza(this, parcel, flags);
    }
}
