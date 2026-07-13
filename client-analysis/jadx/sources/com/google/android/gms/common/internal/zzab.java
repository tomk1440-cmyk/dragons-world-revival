package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.view.View;
import com.google.android.gms.common.api.Scope;

/* JADX INFO: loaded from: classes.dex */
public final class zzab extends com.google.android.gms.dynamic.zzg<zzu> {
    private static final zzab zzamw = new zzab();

    private zzab() {
        super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
    }

    public static View zzb(Context context, int i, int i2, Scope[] scopeArr) throws com.google.android.gms.dynamic.zzg.zza {
        return zzamw.zzc(context, i, i2, scopeArr);
    }

    private View zzc(Context context, int i, int i2, Scope[] scopeArr) throws com.google.android.gms.dynamic.zzg.zza {
        try {
            return (View) com.google.android.gms.dynamic.zze.zzp(zzaB(context).zza(com.google.android.gms.dynamic.zze.zzC(context), new SignInButtonConfig(i, i2, scopeArr)));
        } catch (Exception e) {
            throw new com.google.android.gms.dynamic.zzg.zza("Could not get button with size " + i + " and color " + i2, e);
        }
    }

    @Override // com.google.android.gms.dynamic.zzg
    /* JADX INFO: renamed from: zzaV, reason: merged with bridge method [inline-methods] */
    public zzu zzd(IBinder iBinder) {
        return zzu.zza.zzaU(iBinder);
    }
}
