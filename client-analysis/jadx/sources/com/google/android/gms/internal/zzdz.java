package com.google.android.gms.internal;

import android.os.Bundle;
import com.facebook.applinks.AppLinkData;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
@zzhb
class zzdz {
    private final Object[] mParams;
    private boolean zzAA;

    zzdz(AdRequestParcel adRequestParcel, String str, int i) {
        this.mParams = zza(adRequestParcel, str, i);
    }

    private static Object[] zza(AdRequestParcel adRequestParcel, String str, int i) {
        HashSet hashSet = new HashSet(Arrays.asList(zzbt.zzwF.get().split(",")));
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        if (hashSet.contains("networkType")) {
            arrayList.add(Integer.valueOf(i));
        }
        if (hashSet.contains("birthday")) {
            arrayList.add(Long.valueOf(adRequestParcel.zztC));
        }
        if (hashSet.contains(AppLinkData.ARGUMENTS_EXTRAS_KEY)) {
            arrayList.add(zzc(adRequestParcel.extras));
        }
        if (hashSet.contains("gender")) {
            arrayList.add(Integer.valueOf(adRequestParcel.zztD));
        }
        if (hashSet.contains("keywords")) {
            if (adRequestParcel.zztE != null) {
                arrayList.add(adRequestParcel.zztE.toString());
            } else {
                arrayList.add(null);
            }
        }
        if (hashSet.contains("isTestDevice")) {
            arrayList.add(Boolean.valueOf(adRequestParcel.zztF));
        }
        if (hashSet.contains("tagForChildDirectedTreatment")) {
            arrayList.add(Integer.valueOf(adRequestParcel.zztG));
        }
        if (hashSet.contains("manualImpressionsEnabled")) {
            arrayList.add(Boolean.valueOf(adRequestParcel.zztH));
        }
        if (hashSet.contains("publisherProvidedId")) {
            arrayList.add(adRequestParcel.zztI);
        }
        if (hashSet.contains("location")) {
            if (adRequestParcel.zztK != null) {
                arrayList.add(adRequestParcel.zztK.toString());
            } else {
                arrayList.add(null);
            }
        }
        if (hashSet.contains("contentUrl")) {
            arrayList.add(adRequestParcel.zztL);
        }
        if (hashSet.contains("networkExtras")) {
            arrayList.add(zzc(adRequestParcel.zztM));
        }
        if (hashSet.contains("customTargeting")) {
            arrayList.add(zzc(adRequestParcel.zztN));
        }
        if (hashSet.contains("categoryExclusions")) {
            if (adRequestParcel.zztO != null) {
                arrayList.add(adRequestParcel.zztO.toString());
            } else {
                arrayList.add(null);
            }
        }
        if (hashSet.contains("requestAgent")) {
            arrayList.add(adRequestParcel.zztP);
        }
        if (hashSet.contains("requestPackage")) {
            arrayList.add(adRequestParcel.zztQ);
        }
        return arrayList.toArray();
    }

    private static String zzc(Bundle bundle) {
        String strZzc;
        if (bundle == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Collections.sort(new ArrayList(bundle.keySet()));
        Iterator<String> it = bundle.keySet().iterator();
        while (it.hasNext()) {
            Object obj = bundle.get(it.next());
            if (obj == null) {
                strZzc = "null";
            } else {
                strZzc = obj instanceof Bundle ? zzc((Bundle) obj) : obj.toString();
            }
            sb.append(strZzc);
        }
        return sb.toString();
    }

    public boolean equals(Object o) {
        if (o instanceof zzdz) {
            return Arrays.equals(this.mParams, ((zzdz) o).mParams);
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(this.mParams);
    }

    public String toString() {
        return "[InterstitialAdPoolKey " + Arrays.toString(this.mParams) + "]";
    }

    void zzeg() {
        this.zzAA = true;
    }

    boolean zzeh() {
        return this.zzAA;
    }
}
