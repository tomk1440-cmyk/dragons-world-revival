package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

/* JADX INFO: loaded from: classes.dex */
public class FieldOnlyFilter extends AbstractFilter {
    public static final Parcelable.Creator<FieldOnlyFilter> CREATOR = new zzb();
    final int mVersionCode;
    final MetadataBundle zzauh;
    private final MetadataField<?> zzaui;

    FieldOnlyFilter(int versionCode, MetadataBundle value) {
        this.mVersionCode = versionCode;
        this.zzauh = value;
        this.zzaui = zze.zza(value);
    }

    public FieldOnlyFilter(SearchableMetadataField<?> field) {
        this(1, MetadataBundle.zzb(field, null));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        zzb.zza(this, out, flags);
    }

    @Override // com.google.android.gms.drive.query.Filter
    public <T> T zza(zzf<T> zzfVar) {
        return zzfVar.zze(this.zzaui);
    }
}
