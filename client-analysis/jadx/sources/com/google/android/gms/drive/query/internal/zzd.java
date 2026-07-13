package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class zzd implements Parcelable.Creator<FilterHolder> {
    static void zza(FilterHolder filterHolder, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, (Parcelable) filterHolder.zzauk, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, filterHolder.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, (Parcelable) filterHolder.zzaul, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, (Parcelable) filterHolder.zzaum, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, (Parcelable) filterHolder.zzaun, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, (Parcelable) filterHolder.zzauo, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, (Parcelable) filterHolder.zzaup, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, (Parcelable) filterHolder.zzauq, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 8, (Parcelable) filterHolder.zzaur, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 9, (Parcelable) filterHolder.zzaus, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzco, reason: merged with bridge method [inline-methods] */
    public FilterHolder createFromParcel(Parcel parcel) {
        OwnedByMeFilter ownedByMeFilter = null;
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int iZzg = 0;
        FullTextSearchFilter fullTextSearchFilter = null;
        HasFilter hasFilter = null;
        MatchAllFilter matchAllFilter = null;
        InFilter inFilter = null;
        NotFilter notFilter = null;
        LogicalFilter logicalFilter = null;
        FieldOnlyFilter fieldOnlyFilter = null;
        ComparisonFilter comparisonFilter = null;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    comparisonFilter = (ComparisonFilter) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, ComparisonFilter.CREATOR);
                    break;
                case 2:
                    fieldOnlyFilter = (FieldOnlyFilter) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, FieldOnlyFilter.CREATOR);
                    break;
                case 3:
                    logicalFilter = (LogicalFilter) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, LogicalFilter.CREATOR);
                    break;
                case 4:
                    notFilter = (NotFilter) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, NotFilter.CREATOR);
                    break;
                case 5:
                    inFilter = (InFilter) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, InFilter.CREATOR);
                    break;
                case 6:
                    matchAllFilter = (MatchAllFilter) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, MatchAllFilter.CREATOR);
                    break;
                case 7:
                    hasFilter = (HasFilter) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, HasFilter.CREATOR);
                    break;
                case 8:
                    fullTextSearchFilter = (FullTextSearchFilter) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, FullTextSearchFilter.CREATOR);
                    break;
                case 9:
                    ownedByMeFilter = (OwnedByMeFilter) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, OwnedByMeFilter.CREATOR);
                    break;
                case 1000:
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat);
                    break;
            }
        }
        if (parcel.dataPosition() != iZzau) {
            throw new com.google.android.gms.common.internal.safeparcel.zza.C0052zza("Overread allowed size end=" + iZzau, parcel);
        }
        return new FilterHolder(iZzg, comparisonFilter, fieldOnlyFilter, logicalFilter, notFilter, inFilter, matchAllFilter, hasFilter, fullTextSearchFilter, ownedByMeFilter);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzej, reason: merged with bridge method [inline-methods] */
    public FilterHolder[] newArray(int i) {
        return new FilterHolder[i];
    }
}
