package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.PlaceLikelihood;

/* JADX INFO: loaded from: classes.dex */
public class PlaceLikelihoodEntity implements SafeParcelable, PlaceLikelihood {
    public static final Parcelable.Creator<PlaceLikelihoodEntity> CREATOR = new zzm();
    final int mVersionCode;
    final PlaceImpl zzaQM;
    final float zzaQN;

    PlaceLikelihoodEntity(int versionCode, PlaceImpl place, float likelihood) {
        this.mVersionCode = versionCode;
        this.zzaQM = place;
        this.zzaQN = likelihood;
    }

    public static PlaceLikelihoodEntity zza(PlaceImpl placeImpl, float f) {
        return new PlaceLikelihoodEntity(0, (PlaceImpl) zzx.zzz(placeImpl), f);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof PlaceLikelihoodEntity)) {
            return false;
        }
        PlaceLikelihoodEntity placeLikelihoodEntity = (PlaceLikelihoodEntity) object;
        return this.zzaQM.equals(placeLikelihoodEntity.zzaQM) && this.zzaQN == placeLikelihoodEntity.zzaQN;
    }

    @Override // com.google.android.gms.location.places.PlaceLikelihood
    public float getLikelihood() {
        return this.zzaQN;
    }

    @Override // com.google.android.gms.location.places.PlaceLikelihood
    public Place getPlace() {
        return this.zzaQM;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzaQM, Float.valueOf(this.zzaQN));
    }

    @Override // com.google.android.gms.common.data.Freezable
    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return zzw.zzy(this).zzg("place", this.zzaQM).zzg("likelihood", Float.valueOf(this.zzaQN)).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        zzm.zza(this, parcel, flags);
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* JADX INFO: renamed from: zzzy, reason: merged with bridge method [inline-methods] */
    public PlaceLikelihood freeze() {
        return this;
    }
}
