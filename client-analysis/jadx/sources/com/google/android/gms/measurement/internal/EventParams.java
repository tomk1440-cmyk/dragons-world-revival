package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class EventParams implements SafeParcelable, Iterable<String> {
    public static final zzj CREATOR = new zzj();
    public final int versionCode;
    private final Bundle zzaVS;

    EventParams(int versionCode, Bundle bundle) {
        this.versionCode = versionCode;
        this.zzaVS = bundle;
    }

    EventParams(Bundle bundle) {
        com.google.android.gms.common.internal.zzx.zzz(bundle);
        this.zzaVS = bundle;
        this.versionCode = 1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    Object get(String key) {
        return this.zzaVS.get(key);
    }

    @Override // java.lang.Iterable
    public Iterator<String> iterator() {
        return new Iterator<String>() { // from class: com.google.android.gms.measurement.internal.EventParams.1
            Iterator<String> zzaVT;

            {
                this.zzaVT = EventParams.this.zzaVS.keySet().iterator();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.zzaVT.hasNext();
            }

            @Override // java.util.Iterator
            public String next() {
                return this.zzaVT.next();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("Remove not supported");
            }
        };
    }

    public int size() {
        return this.zzaVS.size();
    }

    public String toString() {
        return this.zzaVS.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        zzj.zza(this, out, flags);
    }

    public Bundle zzCC() {
        return new Bundle(this.zzaVS);
    }
}
