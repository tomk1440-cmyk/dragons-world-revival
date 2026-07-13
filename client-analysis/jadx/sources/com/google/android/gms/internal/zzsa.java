package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.wallet.fragment.WalletFragmentOptions;

/* JADX INFO: loaded from: classes.dex */
public interface zzsa extends IInterface {

    public static abstract class zza extends Binder implements zzsa {

        /* JADX INFO: renamed from: com.google.android.gms.internal.zzsa$zza$zza, reason: collision with other inner class name */
        private static class C0184zza implements zzsa {
            private IBinder zzoz;

            C0184zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.zzoz;
            }

            @Override // com.google.android.gms.internal.zzsa
            public zzrx zza(com.google.android.gms.dynamic.zzd zzdVar, com.google.android.gms.dynamic.zzc zzcVar, WalletFragmentOptions walletFragmentOptions, zzry zzryVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IWalletDynamiteCreator");
                    parcelObtain.writeStrongBinder(zzdVar != null ? zzdVar.asBinder() : null);
                    parcelObtain.writeStrongBinder(zzcVar != null ? zzcVar.asBinder() : null);
                    if (walletFragmentOptions != null) {
                        parcelObtain.writeInt(1);
                        walletFragmentOptions.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(zzryVar != null ? zzryVar.asBinder() : null);
                    this.zzoz.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return zzrx.zza.zzej(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static zzsa zzem(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wallet.internal.IWalletDynamiteCreator");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof zzsa)) ? new C0184zza(iBinder) : (zzsa) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.wallet.internal.IWalletDynamiteCreator");
                    zzrx zzrxVarZza = zza(com.google.android.gms.dynamic.zzd.zza.zzbs(data.readStrongBinder()), com.google.android.gms.dynamic.zzc.zza.zzbr(data.readStrongBinder()), data.readInt() != 0 ? WalletFragmentOptions.CREATOR.createFromParcel(data) : null, zzry.zza.zzek(data.readStrongBinder()));
                    reply.writeNoException();
                    reply.writeStrongBinder(zzrxVarZza != null ? zzrxVarZza.asBinder() : null);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.wallet.internal.IWalletDynamiteCreator");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    zzrx zza(com.google.android.gms.dynamic.zzd zzdVar, com.google.android.gms.dynamic.zzc zzcVar, WalletFragmentOptions walletFragmentOptions, zzry zzryVar) throws RemoteException;
}
