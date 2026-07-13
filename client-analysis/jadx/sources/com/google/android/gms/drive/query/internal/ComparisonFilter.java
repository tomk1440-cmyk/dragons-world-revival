package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

/* JADX INFO: loaded from: classes.dex */
public class ComparisonFilter<T> extends AbstractFilter {
    public static final zza CREATOR = new zza();
    final int mVersionCode;
    final Operator zzaug;
    final MetadataBundle zzauh;
    final MetadataField<T> zzaui;

    ComparisonFilter(int i, Operator operator, MetadataBundle metadataBundle) {
        this.mVersionCode = i;
        this.zzaug = operator;
        this.zzauh = metadataBundle;
        this.zzaui = (MetadataField<T>) zze.zza(metadataBundle);
    }

    public ComparisonFilter(Operator operator, SearchableMetadataField<T> field, T value) {
        this(1, operator, MetadataBundle.zzb(field, value));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public T getValue() {
        return (T) this.zzauh.zza(this.zzaui);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        zza.zza(this, out, flags);
    }

    @Override // com.google.android.gms.drive.query.Filter
    public <F> F zza(zzf<F> zzfVar) {
        return zzfVar.zzb(this.zzaug, this.zzaui, getValue());
    }
}
