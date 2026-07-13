package com.google.android.gms.auth.api.signin.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.games.quest.Quests;

/* JADX INFO: loaded from: classes.dex */
public interface zzh extends IInterface {

    public static abstract class zza extends Binder implements zzh {

        /* JADX INFO: renamed from: com.google.android.gms.auth.api.signin.internal.zzh$zza$zza, reason: collision with other inner class name */
        private static class C0045zza implements zzh {
            private IBinder zzoz;

            C0045zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.zzoz;
            }

            @Override // com.google.android.gms.auth.api.signin.internal.zzh
            public void zza(zzg zzgVar, GoogleSignInOptions googleSignInOptions) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.auth.api.signin.internal.ISignInService");
                    parcelObtain.writeStrongBinder(zzgVar != null ? zzgVar.asBinder() : null);
                    if (googleSignInOptions != null) {
                        parcelObtain.writeInt(1);
                        googleSignInOptions.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.zzoz.transact(Quests.SELECT_COMPLETED_UNCLAIMED, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.auth.api.signin.internal.zzh
            public void zza(zzg zzgVar, SignInConfiguration signInConfiguration) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.auth.api.signin.internal.ISignInService");
                    parcelObtain.writeStrongBinder(zzgVar != null ? zzgVar.asBinder() : null);
                    if (signInConfiguration != null) {
                        parcelObtain.writeInt(1);
                        signInConfiguration.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.zzoz.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.auth.api.signin.internal.zzh
            public void zza(zzg zzgVar, SignInConfiguration signInConfiguration, SignInAccount signInAccount, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.auth.api.signin.internal.ISignInService");
                    parcelObtain.writeStrongBinder(zzgVar != null ? zzgVar.asBinder() : null);
                    if (signInConfiguration != null) {
                        parcelObtain.writeInt(1);
                        signInConfiguration.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (signInAccount != null) {
                        parcelObtain.writeInt(1);
                        signInAccount.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeString(str);
                    this.zzoz.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.auth.api.signin.internal.zzh
            public void zzb(zzg zzgVar, GoogleSignInOptions googleSignInOptions) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.auth.api.signin.internal.ISignInService");
                    parcelObtain.writeStrongBinder(zzgVar != null ? zzgVar.asBinder() : null);
                    if (googleSignInOptions != null) {
                        parcelObtain.writeInt(1);
                        googleSignInOptions.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.zzoz.transact(102, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.auth.api.signin.internal.zzh
            public void zzb(zzg zzgVar, SignInConfiguration signInConfiguration) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.auth.api.signin.internal.ISignInService");
                    parcelObtain.writeStrongBinder(zzgVar != null ? zzgVar.asBinder() : null);
                    if (signInConfiguration != null) {
                        parcelObtain.writeInt(1);
                        signInConfiguration.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.zzoz.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.auth.api.signin.internal.zzh
            public void zzc(zzg zzgVar, GoogleSignInOptions googleSignInOptions) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.auth.api.signin.internal.ISignInService");
                    parcelObtain.writeStrongBinder(zzgVar != null ? zzgVar.asBinder() : null);
                    if (googleSignInOptions != null) {
                        parcelObtain.writeInt(1);
                        googleSignInOptions.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.zzoz.transact(Quests.SELECT_RECENTLY_FAILED, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static zzh zzaD(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof zzh)) ? new C0045zza(iBinder) : (zzh) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
                    zza(zzg.zza.zzaC(data.readStrongBinder()), data.readInt() != 0 ? SignInConfiguration.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
                    zzb(zzg.zza.zzaC(data.readStrongBinder()), data.readInt() != 0 ? SignInConfiguration.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
                    zza(zzg.zza.zzaC(data.readStrongBinder()), data.readInt() != 0 ? SignInConfiguration.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? SignInAccount.CREATOR.createFromParcel(data) : null, data.readString());
                    reply.writeNoException();
                    return true;
                case Quests.SELECT_COMPLETED_UNCLAIMED /* 101 */:
                    data.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
                    zza(zzg.zza.zzaC(data.readStrongBinder()), data.readInt() != 0 ? GoogleSignInOptions.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 102:
                    data.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
                    zzb(zzg.zza.zzaC(data.readStrongBinder()), data.readInt() != 0 ? GoogleSignInOptions.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case Quests.SELECT_RECENTLY_FAILED /* 103 */:
                    data.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
                    zzc(zzg.zza.zzaC(data.readStrongBinder()), data.readInt() != 0 ? GoogleSignInOptions.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.auth.api.signin.internal.ISignInService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zza(zzg zzgVar, GoogleSignInOptions googleSignInOptions) throws RemoteException;

    void zza(zzg zzgVar, SignInConfiguration signInConfiguration) throws RemoteException;

    void zza(zzg zzgVar, SignInConfiguration signInConfiguration, SignInAccount signInAccount, String str) throws RemoteException;

    void zzb(zzg zzgVar, GoogleSignInOptions googleSignInOptions) throws RemoteException;

    void zzb(zzg zzgVar, SignInConfiguration signInConfiguration) throws RemoteException;

    void zzc(zzg zzgVar, GoogleSignInOptions googleSignInOptions) throws RemoteException;
}
