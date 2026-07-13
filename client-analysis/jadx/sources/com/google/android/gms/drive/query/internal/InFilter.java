package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.Collection;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
public class InFilter<T> extends AbstractFilter {
    public static final zzj CREATOR = new zzj();
    final int mVersionCode;
    final MetadataBundle zzauh;
    private final com.google.android.gms.drive.metadata.zzb<T> zzauu;

    InFilter(int versionCode, MetadataBundle value) {
        this.mVersionCode = versionCode;
        this.zzauh = value;
        this.zzauu = (com.google.android.gms.drive.metadata.zzb) zze.zza(value);
    }

    public InFilter(SearchableCollectionMetadataField<T> field, T value) {
        this(1, MetadataBundle.zzb(field, Collections.singleton(value)));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public T getValue() {
        return (T) ((Collection) this.zzauh.zza(this.zzauu)).iterator().next();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        zzj.zza(this, out, flags);
    }

    @Override // com.google.android.gms.drive.query.Filter
    public <F> F zza(zzf<F> zzfVar) {
        return zzfVar.zzb(this.zzauu, getValue());
    }
}
