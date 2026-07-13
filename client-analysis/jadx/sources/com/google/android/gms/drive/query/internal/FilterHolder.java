package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.query.Filter;

/* JADX INFO: loaded from: classes.dex */
public class FilterHolder implements SafeParcelable {
    public static final Parcelable.Creator<FilterHolder> CREATOR = new zzd();
    final int mVersionCode;
    private final Filter zzapi;
    final ComparisonFilter<?> zzauk;
    final FieldOnlyFilter zzaul;
    final LogicalFilter zzaum;
    final NotFilter zzaun;
    final InFilter<?> zzauo;
    final MatchAllFilter zzaup;
    final HasFilter zzauq;
    final FullTextSearchFilter zzaur;
    final OwnedByMeFilter zzaus;

    FilterHolder(int versionCode, ComparisonFilter<?> comparisonField, FieldOnlyFilter fieldOnlyFilter, LogicalFilter logicalFilter, NotFilter notFilter, InFilter<?> containsFilter, MatchAllFilter matchAllFilter, HasFilter<?> hasFilter, FullTextSearchFilter fullTextSearchFilter, OwnedByMeFilter ownedByMeFilter) {
        this.mVersionCode = versionCode;
        this.zzauk = comparisonField;
        this.zzaul = fieldOnlyFilter;
        this.zzaum = logicalFilter;
        this.zzaun = notFilter;
        this.zzauo = containsFilter;
        this.zzaup = matchAllFilter;
        this.zzauq = hasFilter;
        this.zzaur = fullTextSearchFilter;
        this.zzaus = ownedByMeFilter;
        if (this.zzauk != null) {
            this.zzapi = this.zzauk;
            return;
        }
        if (this.zzaul != null) {
            this.zzapi = this.zzaul;
            return;
        }
        if (this.zzaum != null) {
            this.zzapi = this.zzaum;
            return;
        }
        if (this.zzaun != null) {
            this.zzapi = this.zzaun;
            return;
        }
        if (this.zzauo != null) {
            this.zzapi = this.zzauo;
            return;
        }
        if (this.zzaup != null) {
            this.zzapi = this.zzaup;
            return;
        }
        if (this.zzauq != null) {
            this.zzapi = this.zzauq;
        } else if (this.zzaur != null) {
            this.zzapi = this.zzaur;
        } else {
            if (this.zzaus == null) {
                throw new IllegalArgumentException("At least one filter must be set.");
            }
            this.zzapi = this.zzaus;
        }
    }

    public FilterHolder(Filter filter) {
        zzx.zzb(filter, "Null filter.");
        this.mVersionCode = 2;
        this.zzauk = filter instanceof ComparisonFilter ? (ComparisonFilter) filter : null;
        this.zzaul = filter instanceof FieldOnlyFilter ? (FieldOnlyFilter) filter : null;
        this.zzaum = filter instanceof LogicalFilter ? (LogicalFilter) filter : null;
        this.zzaun = filter instanceof NotFilter ? (NotFilter) filter : null;
        this.zzauo = filter instanceof InFilter ? (InFilter) filter : null;
        this.zzaup = filter instanceof MatchAllFilter ? (MatchAllFilter) filter : null;
        this.zzauq = filter instanceof HasFilter ? (HasFilter) filter : null;
        this.zzaur = filter instanceof FullTextSearchFilter ? (FullTextSearchFilter) filter : null;
        this.zzaus = filter instanceof OwnedByMeFilter ? (OwnedByMeFilter) filter : null;
        if (this.zzauk == null && this.zzaul == null && this.zzaum == null && this.zzaun == null && this.zzauo == null && this.zzaup == null && this.zzauq == null && this.zzaur == null && this.zzaus == null) {
            throw new IllegalArgumentException("Invalid filter type.");
        }
        this.zzapi = filter;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Filter getFilter() {
        return this.zzapi;
    }

    public String toString() {
        return String.format("FilterHolder[%s]", this.zzapi);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        zzd.zza(this, out, flags);
    }
}
