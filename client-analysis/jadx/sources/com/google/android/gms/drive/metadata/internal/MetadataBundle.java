package com.google.android.gms.drive.metadata.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.internal.zzz;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.internal.zznm;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class MetadataBundle implements SafeParcelable {
    public static final Parcelable.Creator<MetadataBundle> CREATOR = new zzh();
    final int mVersionCode;
    final Bundle zzasQ;

    MetadataBundle(int versionCode, Bundle valueBundle) {
        this.mVersionCode = versionCode;
        this.zzasQ = (Bundle) zzx.zzz(valueBundle);
        this.zzasQ.setClassLoader(getClass().getClassLoader());
        ArrayList arrayList = new ArrayList();
        for (String str : this.zzasQ.keySet()) {
            if (zze.zzdc(str) == null) {
                arrayList.add(str);
                zzz.zzz("MetadataBundle", "Ignored unknown metadata field in bundle: " + str);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.zzasQ.remove((String) it.next());
        }
    }

    private MetadataBundle(Bundle valueBundle) {
        this(1, valueBundle);
    }

    public static <T> MetadataBundle zzb(MetadataField<T> metadataField, T t) {
        MetadataBundle metadataBundleZztE = zztE();
        metadataBundleZztE.zzc(metadataField, t);
        return metadataBundleZztE;
    }

    public static MetadataBundle zztE() {
        return new MetadataBundle(new Bundle());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MetadataBundle)) {
            return false;
        }
        MetadataBundle metadataBundle = (MetadataBundle) obj;
        Set<String> setKeySet = this.zzasQ.keySet();
        if (!setKeySet.equals(metadataBundle.zzasQ.keySet())) {
            return false;
        }
        for (String str : setKeySet) {
            if (!zzw.equal(this.zzasQ.get(str), metadataBundle.zzasQ.get(str))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int iHashCode = 1;
        Iterator<String> it = this.zzasQ.keySet().iterator();
        while (true) {
            int i = iHashCode;
            if (!it.hasNext()) {
                return i;
            }
            iHashCode = this.zzasQ.get(it.next()).hashCode() + (i * 31);
        }
    }

    public void setContext(Context context) {
        BitmapTeleporter bitmapTeleporter = (BitmapTeleporter) zza(zznm.zzatz);
        if (bitmapTeleporter != null) {
            bitmapTeleporter.zzc(context.getCacheDir());
        }
    }

    public String toString() {
        return "MetadataBundle [values=" + this.zzasQ + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzh.zza(this, dest, flags);
    }

    public <T> T zza(MetadataField<T> metadataField) {
        return metadataField.zzm(this.zzasQ);
    }

    public <T> void zzc(MetadataField<T> metadataField, T t) {
        if (zze.zzdc(metadataField.getName()) == null) {
            throw new IllegalArgumentException("Unregistered field: " + metadataField.getName());
        }
        metadataField.zza(t, this.zzasQ);
    }

    public boolean zzc(MetadataField<?> metadataField) {
        return this.zzasQ.containsKey(metadataField.getName());
    }

    public MetadataBundle zztF() {
        return new MetadataBundle(new Bundle(this.zzasQ));
    }

    public Set<MetadataField<?>> zztG() {
        HashSet hashSet = new HashSet();
        Iterator<String> it = this.zzasQ.keySet().iterator();
        while (it.hasNext()) {
            hashSet.add(zze.zzdc(it.next()));
        }
        return hashSet;
    }
}
