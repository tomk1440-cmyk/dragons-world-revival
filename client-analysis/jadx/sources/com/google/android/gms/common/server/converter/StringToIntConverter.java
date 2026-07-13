package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class StringToIntConverter implements SafeParcelable, FastJsonResponse.zza<String, Integer> {
    public static final zzb CREATOR = new zzb();
    private final int mVersionCode;
    private final HashMap<String, Integer> zzamG;
    private final HashMap<Integer, String> zzamH;
    private final ArrayList<Entry> zzamI;

    public static final class Entry implements SafeParcelable {
        public static final zzc CREATOR = new zzc();
        final int versionCode;
        final String zzamJ;
        final int zzamK;

        Entry(int versionCode, String stringValue, int intValue) {
            this.versionCode = versionCode;
            this.zzamJ = stringValue;
            this.zzamK = intValue;
        }

        Entry(String stringValue, int intValue) {
            this.versionCode = 1;
            this.zzamJ = stringValue;
            this.zzamK = intValue;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            zzc zzcVar = CREATOR;
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int flags) {
            zzc zzcVar = CREATOR;
            zzc.zza(this, out, flags);
        }
    }

    public StringToIntConverter() {
        this.mVersionCode = 1;
        this.zzamG = new HashMap<>();
        this.zzamH = new HashMap<>();
        this.zzamI = null;
    }

    StringToIntConverter(int versionCode, ArrayList<Entry> serializedMap) {
        this.mVersionCode = versionCode;
        this.zzamG = new HashMap<>();
        this.zzamH = new HashMap<>();
        this.zzamI = null;
        zzd(serializedMap);
    }

    private void zzd(ArrayList<Entry> arrayList) {
        for (Entry entry : arrayList) {
            zzh(entry.zzamJ, entry.zzamK);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        zzb zzbVar = CREATOR;
        return 0;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        zzb zzbVar = CREATOR;
        zzb.zza(this, out, flags);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse.zza
    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public String convertBack(Integer num) {
        String str = this.zzamH.get(num);
        return (str == null && this.zzamG.containsKey("gms_unknown")) ? "gms_unknown" : str;
    }

    public StringToIntConverter zzh(String str, int i) {
        this.zzamG.put(str, Integer.valueOf(i));
        this.zzamH.put(Integer.valueOf(i), str);
        return this;
    }

    ArrayList<Entry> zzri() {
        ArrayList<Entry> arrayList = new ArrayList<>();
        for (String str : this.zzamG.keySet()) {
            arrayList.add(new Entry(str, this.zzamG.get(str).intValue()));
        }
        return arrayList;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse.zza
    public int zzrj() {
        return 7;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse.zza
    public int zzrk() {
        return 0;
    }
}
