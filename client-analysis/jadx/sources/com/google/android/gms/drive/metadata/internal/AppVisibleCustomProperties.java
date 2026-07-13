package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class AppVisibleCustomProperties implements SafeParcelable, Iterable<CustomProperty> {
    public static final Parcelable.Creator<AppVisibleCustomProperties> CREATOR = new com.google.android.gms.drive.metadata.internal.zza();
    public static final AppVisibleCustomProperties zzasK = new zza().zztA();
    final int mVersionCode;
    final List<CustomProperty> zzasL;

    public static class zza {
        private final Map<CustomPropertyKey, CustomProperty> zzasM = new HashMap();

        public zza zza(CustomPropertyKey customPropertyKey, String str) {
            zzx.zzb(customPropertyKey, "key");
            this.zzasM.put(customPropertyKey, new CustomProperty(customPropertyKey, str));
            return this;
        }

        public zza zza(CustomProperty customProperty) {
            zzx.zzb(customProperty, "property");
            this.zzasM.put(customProperty.zztB(), customProperty);
            return this;
        }

        public AppVisibleCustomProperties zztA() {
            return new AppVisibleCustomProperties(this.zzasM.values());
        }
    }

    AppVisibleCustomProperties(int versionCode, Collection<CustomProperty> properties) {
        this.mVersionCode = versionCode;
        zzx.zzz(properties);
        this.zzasL = new ArrayList(properties);
    }

    private AppVisibleCustomProperties(Collection<CustomProperty> properties) {
        this(1, properties);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || o.getClass() != getClass()) {
            return false;
        }
        return zztz().equals(((AppVisibleCustomProperties) o).zztz());
    }

    public int hashCode() {
        return zzw.hashCode(this.zzasL);
    }

    @Override // java.lang.Iterable
    public Iterator<CustomProperty> iterator() {
        return this.zzasL.iterator();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        com.google.android.gms.drive.metadata.internal.zza.zza(this, dest, flags);
    }

    public Map<CustomPropertyKey, String> zztz() {
        HashMap map = new HashMap(this.zzasL.size());
        for (CustomProperty customProperty : this.zzasL) {
            map.put(customProperty.zztB(), customProperty.getValue());
        }
        return Collections.unmodifiableMap(map);
    }
}
