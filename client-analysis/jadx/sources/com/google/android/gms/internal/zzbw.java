package com.google.android.gms.internal;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzbw {
    public zzbv zza(zzbu zzbuVar) {
        if (zzbuVar == null) {
            throw new IllegalArgumentException("CSI configuration can't be null. ");
        }
        if (!zzbuVar.zzdu()) {
            zzin.v("CsiReporterFactory: CSI is not enabled. No CSI reporter created.");
            return null;
        }
        if (zzbuVar.getContext() == null) {
            throw new IllegalArgumentException("Context can't be null. Please set up context in CsiConfiguration.");
        }
        if (TextUtils.isEmpty(zzbuVar.zzcs())) {
            throw new IllegalArgumentException("AfmaVersion can't be null or empty. Please set up afmaVersion in CsiConfiguration.");
        }
        return new zzbv(zzbuVar.getContext(), zzbuVar.zzcs(), zzbuVar.zzdv(), zzbuVar.zzdw());
    }
}
