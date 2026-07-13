package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public final class zzfu extends com.google.android.gms.dynamic.zzg<zzfw> {
    private static final zzfu zzFp = new zzfu();

    private static final class zza extends Exception {
        public zza(String str) {
            super(str);
        }
    }

    private zzfu() {
        super("com.google.android.gms.ads.AdOverlayCreatorImpl");
    }

    @Nullable
    public static zzfv createAdOverlay(Activity activity) {
        zzfv zzfvVarZzc;
        try {
            if (!zzb(activity) && (zzfvVarZzc = zzFp.zzc(activity)) != null) {
                return zzfvVarZzc;
            }
            com.google.android.gms.ads.internal.util.client.zzb.zzaI("Using AdOverlay from the client jar.");
            return com.google.android.gms.ads.internal.client.zzn.zzcU().createAdOverlay(activity);
        } catch (zza e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaK(e.getMessage());
            return null;
        }
    }

    private static boolean zzb(Activity activity) throws zza {
        Intent intent = activity.getIntent();
        if (intent.hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar")) {
            return intent.getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false);
        }
        throw new zza("Ad overlay requires the useClientJar flag in intent extras.");
    }

    private zzfv zzc(Activity activity) {
        try {
            return zzfv.zza.zzL(zzaB(activity).zze(com.google.android.gms.dynamic.zze.zzC(activity)));
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not create remote AdOverlay.", e);
            return null;
        } catch (com.google.android.gms.dynamic.zzg.zza e2) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not create remote AdOverlay.", e2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.dynamic.zzg
    /* JADX INFO: renamed from: zzK, reason: merged with bridge method [inline-methods] */
    public zzfw zzd(IBinder iBinder) {
        return zzfw.zza.zzM(iBinder);
    }
}
