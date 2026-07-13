package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

/* JADX INFO: loaded from: classes.dex */
public class HasFilter<T> extends AbstractFilter {
    public static final zzi CREATOR = new zzi();
    final int mVersionCode;
    final MetadataBundle zzauh;
    final MetadataField<T> zzaui;

    HasFilter(int i, MetadataBundle metadataBundle) {
        this.mVersionCode = i;
        this.zzauh = metadataBundle;
        this.zzaui = (MetadataField<T>) zze.zza(metadataBundle);
    }

    public HasFilter(SearchableMetadataField<T> field, T value) {
        this(1, MetadataBundle.zzb(field, value));
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
        zzi.zza(this, out, flags);
    }

    @Override // com.google.android.gms.drive.query.Filter
    public <F> F zza(zzf<F> zzfVar) {
        return zzfVar.zze(this.zzaui, getValue());
    }
}
