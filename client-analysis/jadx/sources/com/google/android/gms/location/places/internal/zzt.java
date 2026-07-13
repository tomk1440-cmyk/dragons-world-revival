package com.google.android.gms.location.places.internal;

import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzsk;
import com.google.android.gms.internal.zzst;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzt extends com.google.android.gms.common.data.zzc {
    private final String TAG;

    public zzt(DataHolder dataHolder, int i) {
        super(dataHolder, i);
        this.TAG = "SafeDataBufferRef";
    }

    protected String zzG(String str, String str2) {
        return (!zzcz(str) || zzcB(str)) ? str2 : getString(str);
    }

    protected <E extends SafeParcelable> E zza(String str, Parcelable.Creator<E> creator) {
        byte[] bArrZzc = zzc(str, null);
        if (bArrZzc == null) {
            return null;
        }
        return (E) com.google.android.gms.common.internal.safeparcel.zzc.zza(bArrZzc, creator);
    }

    protected <E extends SafeParcelable> List<E> zza(String str, Parcelable.Creator<E> creator, List<E> list) {
        byte[] bArrZzc = zzc(str, null);
        if (bArrZzc == null) {
            return list;
        }
        try {
            zzsk zzskVarZzB = zzsk.zzB(bArrZzc);
            if (zzskVarZzB.zzbtV == null) {
                return list;
            }
            ArrayList arrayList = new ArrayList(zzskVarZzB.zzbtV.length);
            byte[][] bArr = zzskVarZzB.zzbtV;
            for (byte[] bArr2 : bArr) {
                arrayList.add(com.google.android.gms.common.internal.safeparcel.zzc.zza(bArr2, creator));
            }
            return arrayList;
        } catch (zzst e) {
            if (!Log.isLoggable("SafeDataBufferRef", 6)) {
                return list;
            }
            Log.e("SafeDataBufferRef", "Cannot parse byte[]", e);
            return list;
        }
    }

    protected List<Integer> zza(String str, List<Integer> list) {
        byte[] bArrZzc = zzc(str, null);
        if (bArrZzc == null) {
            return list;
        }
        try {
            zzsk zzskVarZzB = zzsk.zzB(bArrZzc);
            if (zzskVarZzB.zzbtU == null) {
                return list;
            }
            ArrayList arrayList = new ArrayList(zzskVarZzB.zzbtU.length);
            for (int i = 0; i < zzskVarZzB.zzbtU.length; i++) {
                arrayList.add(Integer.valueOf(zzskVarZzB.zzbtU[i]));
            }
            return arrayList;
        } catch (zzst e) {
            if (!Log.isLoggable("SafeDataBufferRef", 6)) {
                return list;
            }
            Log.e("SafeDataBufferRef", "Cannot parse byte[]", e);
            return list;
        }
    }

    protected float zzb(String str, float f) {
        return (!zzcz(str) || zzcB(str)) ? f : getFloat(str);
    }

    protected List<String> zzb(String str, List<String> list) {
        byte[] bArrZzc = zzc(str, null);
        if (bArrZzc == null) {
            return list;
        }
        try {
            zzsk zzskVarZzB = zzsk.zzB(bArrZzc);
            return zzskVarZzB.zzbtT != null ? Arrays.asList(zzskVarZzB.zzbtT) : list;
        } catch (zzst e) {
            if (!Log.isLoggable("SafeDataBufferRef", 6)) {
                return list;
            }
            Log.e("SafeDataBufferRef", "Cannot parse byte[]", e);
            return list;
        }
    }

    protected byte[] zzc(String str, byte[] bArr) {
        return (!zzcz(str) || zzcB(str)) ? bArr : getByteArray(str);
    }

    protected boolean zzl(String str, boolean z) {
        return (!zzcz(str) || zzcB(str)) ? z : getBoolean(str);
    }

    protected int zzz(String str, int i) {
        return (!zzcz(str) || zzcB(str)) ? i : getInteger(str);
    }
}
