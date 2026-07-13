package com.google.android.gms.drive.metadata;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class zza<T> implements MetadataField<T> {
    private final String zzasF;
    private final Set<String> zzasG;
    private final Set<String> zzasH;
    private final int zzasI;

    protected zza(String str, int i) {
        this.zzasF = (String) zzx.zzb(str, "fieldName");
        this.zzasG = Collections.singleton(str);
        this.zzasH = Collections.emptySet();
        this.zzasI = i;
    }

    protected zza(String str, Collection<String> collection, Collection<String> collection2, int i) {
        this.zzasF = (String) zzx.zzb(str, "fieldName");
        this.zzasG = Collections.unmodifiableSet(new HashSet(collection));
        this.zzasH = Collections.unmodifiableSet(new HashSet(collection2));
        this.zzasI = i;
    }

    @Override // com.google.android.gms.drive.metadata.MetadataField
    public final String getName() {
        return this.zzasF;
    }

    public String toString() {
        return this.zzasF;
    }

    @Override // com.google.android.gms.drive.metadata.MetadataField
    public final T zza(DataHolder dataHolder, int i, int i2) {
        if (zzb(dataHolder, i, i2)) {
            return zzc(dataHolder, i, i2);
        }
        return null;
    }

    protected abstract void zza(Bundle bundle, T t);

    @Override // com.google.android.gms.drive.metadata.MetadataField
    public final void zza(DataHolder dataHolder, MetadataBundle metadataBundle, int i, int i2) {
        zzx.zzb(dataHolder, "dataHolder");
        zzx.zzb(metadataBundle, "bundle");
        if (zzb(dataHolder, i, i2)) {
            metadataBundle.zzc(this, zzc(dataHolder, i, i2));
        }
    }

    @Override // com.google.android.gms.drive.metadata.MetadataField
    public final void zza(T t, Bundle bundle) {
        zzx.zzb(bundle, "bundle");
        if (t == null) {
            bundle.putString(getName(), null);
        } else {
            zza(bundle, t);
        }
    }

    protected boolean zzb(DataHolder dataHolder, int i, int i2) {
        for (String str : this.zzasG) {
            if (!dataHolder.zzcz(str) || dataHolder.zzi(str, i, i2)) {
                return false;
            }
        }
        return true;
    }

    protected abstract T zzc(DataHolder dataHolder, int i, int i2);

    @Override // com.google.android.gms.drive.metadata.MetadataField
    public final T zzm(Bundle bundle) {
        zzx.zzb(bundle, "bundle");
        if (bundle.get(getName()) != null) {
            return zzn(bundle);
        }
        return null;
    }

    protected abstract T zzn(Bundle bundle);

    public final Collection<String> zzty() {
        return this.zzasG;
    }
}
