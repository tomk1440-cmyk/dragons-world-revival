package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.zzhb;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzaf extends com.google.android.gms.dynamic.zzg<zzz> {
    public zzaf() {
        super("com.google.android.gms.ads.MobileAdsSettingManagerCreatorImpl");
    }

    private zzy zzv(Context context) {
        try {
            return zzy.zza.zzo(zzaB(context).zza(com.google.android.gms.dynamic.zze.zzC(context), 8487000));
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not get remote MobileAdsSettingManager.", e);
            return null;
        } catch (com.google.android.gms.dynamic.zzg.zza e2) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not get remote MobileAdsSettingManager.", e2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.dynamic.zzg
    /* JADX INFO: renamed from: zzq, reason: merged with bridge method [inline-methods] */
    public zzz zzd(IBinder iBinder) {
        return zzz.zza.zzp(iBinder);
    }

    public zzy zzu(Context context) {
        zzy zzyVarZzv;
        if (zzn.zzcS().zzU(context) && (zzyVarZzv = zzv(context)) != null) {
            return zzyVarZzv;
        }
        com.google.android.gms.ads.internal.util.client.zzb.zzaI("Using MobileAdsSettingManager from the client jar.");
        new VersionInfoParcel(8487000, 8487000, true);
        return zzn.zzcU().getMobileAdsSettingsManager(context);
    }
}
