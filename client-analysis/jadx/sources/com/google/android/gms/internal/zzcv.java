package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzcv extends com.google.android.gms.dynamic.zzg<zzck> {
    public zzcv() {
        super("com.google.android.gms.ads.NativeAdViewDelegateCreatorImpl");
    }

    private zzcj zzb(Context context, FrameLayout frameLayout, FrameLayout frameLayout2) {
        try {
            return zzcj.zza.zzu(zzaB(context).zza(com.google.android.gms.dynamic.zze.zzC(context), com.google.android.gms.dynamic.zze.zzC(frameLayout), com.google.android.gms.dynamic.zze.zzC(frameLayout2), 8487000));
        } catch (RemoteException | com.google.android.gms.dynamic.zzg.zza e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not create remote NativeAdViewDelegate.", e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.dynamic.zzg
    /* JADX INFO: renamed from: zzD, reason: merged with bridge method [inline-methods] */
    public zzck zzd(IBinder iBinder) {
        return zzck.zza.zzv(iBinder);
    }

    public zzcj zza(Context context, FrameLayout frameLayout, FrameLayout frameLayout2) {
        zzcj zzcjVarZzb;
        if (com.google.android.gms.ads.internal.client.zzn.zzcS().zzU(context) && (zzcjVarZzb = zzb(context, frameLayout, frameLayout2)) != null) {
            return zzcjVarZzb;
        }
        com.google.android.gms.ads.internal.util.client.zzb.zzaI("Using NativeAdViewDelegate from the client jar.");
        return com.google.android.gms.ads.internal.client.zzn.zzcU().createNativeAdViewDelegate(frameLayout, frameLayout2);
    }
}
