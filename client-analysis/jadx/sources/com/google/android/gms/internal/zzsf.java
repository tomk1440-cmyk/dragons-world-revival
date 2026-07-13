package com.google.android.gms.internal;

import android.app.Activity;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.wallet.fragment.WalletFragmentOptions;

/* JADX INFO: loaded from: classes.dex */
public class zzsf extends com.google.android.gms.dynamic.zzg<zzsa> {
    private static zzsf zzbqD;

    protected zzsf() {
        super("com.google.android.gms.wallet.dynamite.WalletDynamiteCreatorImpl");
    }

    private static zzsf zzIq() {
        if (zzbqD == null) {
            zzbqD = new zzsf();
        }
        return zzbqD;
    }

    public static zzrx zza(Activity activity, com.google.android.gms.dynamic.zzc zzcVar, WalletFragmentOptions walletFragmentOptions, zzry zzryVar) throws GooglePlayServicesNotAvailableException {
        int iIsGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(activity);
        if (iIsGooglePlayServicesAvailable != 0) {
            throw new GooglePlayServicesNotAvailableException(iIsGooglePlayServicesAvailable);
        }
        try {
            return zzIq().zzaB(activity).zza(com.google.android.gms.dynamic.zze.zzC(activity), zzcVar, walletFragmentOptions, zzryVar);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        } catch (com.google.android.gms.dynamic.zzg.zza e2) {
            throw new RuntimeException(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.dynamic.zzg
    /* JADX INFO: renamed from: zzeq, reason: merged with bridge method [inline-methods] */
    public zzsa zzd(IBinder iBinder) {
        return zzsa.zza.zzem(iBinder);
    }
}
