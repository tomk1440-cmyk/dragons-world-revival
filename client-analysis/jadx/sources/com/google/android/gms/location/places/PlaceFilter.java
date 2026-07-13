package com.google.android.gms.location.places;

import android.os.Parcel;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class PlaceFilter extends com.google.android.gms.location.places.zza implements SafeParcelable {
    public static final zzg CREATOR = new zzg();
    private static final PlaceFilter zzaPz = new PlaceFilter();
    final int mVersionCode;
    final boolean zzaPA;
    final List<String> zzaPj;
    final List<Integer> zzaPk;
    final List<UserDataType> zzaPl;
    private final Set<String> zzaPo;
    private final Set<Integer> zzaPp;
    private final Set<UserDataType> zzaPq;

    @Deprecated
    public static final class zza {
        private boolean zzaPA;
        private Collection<Integer> zzaPB;
        private Collection<UserDataType> zzaPC;
        private String[] zzaPD;

        private zza() {
            this.zzaPB = null;
            this.zzaPA = false;
            this.zzaPC = null;
            this.zzaPD = null;
        }

        public PlaceFilter zzze() {
            return new PlaceFilter(this.zzaPB != null ? new ArrayList(this.zzaPB) : null, this.zzaPA, this.zzaPD != null ? Arrays.asList(this.zzaPD) : null, this.zzaPC != null ? new ArrayList(this.zzaPC) : null);
        }
    }

    public PlaceFilter() {
        this(false, null);
    }

    PlaceFilter(int versionCode, @Nullable List<Integer> placeTypesList, boolean requireOpenNow, @Nullable List<String> placeIdsList, @Nullable List<UserDataType> requestedUserDataTypesList) {
        this.mVersionCode = versionCode;
        this.zzaPk = placeTypesList == null ? Collections.emptyList() : Collections.unmodifiableList(placeTypesList);
        this.zzaPA = requireOpenNow;
        this.zzaPl = requestedUserDataTypesList == null ? Collections.emptyList() : Collections.unmodifiableList(requestedUserDataTypesList);
        this.zzaPj = placeIdsList == null ? Collections.emptyList() : Collections.unmodifiableList(placeIdsList);
        this.zzaPp = zzw(this.zzaPk);
        this.zzaPq = zzw(this.zzaPl);
        this.zzaPo = zzw(this.zzaPj);
    }

    public PlaceFilter(@Nullable Collection<Integer> restrictToPlaceTypes, boolean requireOpenNow, @Nullable Collection<String> restrictToPlaceIds, @Nullable Collection<UserDataType> requestedUserDataTypes) {
        this(0, zzf(restrictToPlaceTypes), requireOpenNow, zzf(restrictToPlaceIds), zzf(requestedUserDataTypes));
    }

    public PlaceFilter(boolean requireOpenNow, @Nullable Collection<String> restrictToPlaceIds) {
        this(null, requireOpenNow, restrictToPlaceIds, null);
    }

    @Deprecated
    public static PlaceFilter zzzd() {
        return new zza().zzze();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof PlaceFilter)) {
            return false;
        }
        PlaceFilter placeFilter = (PlaceFilter) object;
        return this.zzaPp.equals(placeFilter.zzaPp) && this.zzaPA == placeFilter.zzaPA && this.zzaPq.equals(placeFilter.zzaPq) && this.zzaPo.equals(placeFilter.zzaPo);
    }

    @Override // com.google.android.gms.location.places.zza
    public Set<String> getPlaceIds() {
        return this.zzaPo;
    }

    public Set<Integer> getPlaceTypes() {
        return this.zzaPp;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzaPp, Boolean.valueOf(this.zzaPA), this.zzaPq, this.zzaPo);
    }

    @Override // com.google.android.gms.location.places.zza
    public boolean isRestrictedToPlacesOpenNow() {
        return this.zzaPA;
    }

    public String toString() {
        zzw.zza zzaVarZzy = zzw.zzy(this);
        if (!this.zzaPp.isEmpty()) {
            zzaVarZzy.zzg("types", this.zzaPp);
        }
        zzaVarZzy.zzg("requireOpenNow", Boolean.valueOf(this.zzaPA));
        if (!this.zzaPo.isEmpty()) {
            zzaVarZzy.zzg("placeIds", this.zzaPo);
        }
        if (!this.zzaPq.isEmpty()) {
            zzaVarZzy.zzg("requestedUserDataTypes", this.zzaPq);
        }
        return zzaVarZzy.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        zzg.zza(this, parcel, flags);
    }
}
