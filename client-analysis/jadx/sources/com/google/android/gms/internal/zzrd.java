package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface zzrd extends IInterface {

    public static abstract class zza extends Binder implements zzrd {

        /* JADX INFO: renamed from: com.google.android.gms.internal.zzrd$zza$zza, reason: collision with other inner class name */
        private static class C0177zza implements zzrd {
            private IBinder zzoz;

            C0177zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.zzoz;
            }

            @Override // com.google.android.gms.internal.zzrd
            public void zza(zzrc zzrcVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.safetynet.internal.ISafetyNetService");
                    parcelObtain.writeStrongBinder(zzrcVar != null ? zzrcVar.asBinder() : null);
                    this.zzoz.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzrd
            public void zza(zzrc zzrcVar, String str, int[] iArr, int i, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.safetynet.internal.ISafetyNetService");
                    parcelObtain.writeStrongBinder(zzrcVar != null ? zzrcVar.asBinder() : null);
                    parcelObtain.writeString(str);
                    parcelObtain.writeIntArray(iArr);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str2);
                    this.zzoz.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzrd
            public void zza(zzrc zzrcVar, byte[] bArr) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.safetynet.internal.ISafetyNetService");
                    parcelObtain.writeStrongBinder(zzrcVar != null ? zzrcVar.asBinder() : null);
                    parcelObtain.writeByteArray(bArr);
                    this.zzoz.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static zzrd zzdV(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.safetynet.internal.ISafetyNetService");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof zzrd)) ? new C0177zza(iBinder) : (zzrd) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.safetynet.internal.ISafetyNetService");
                    zza(zzrc.zza.zzdU(data.readStrongBinder()), data.createByteArray());
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.safetynet.internal.ISafetyNetService");
                    zza(zzrc.zza.zzdU(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.safetynet.internal.ISafetyNetService");
                    zza(zzrc.zza.zzdU(data.readStrongBinder()), data.readString(), data.createIntArray(), data.readInt(), data.readString());
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.safetynet.internal.ISafetyNetService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zza(zzrc zzrcVar) throws RemoteException;

    void zza(zzrc zzrcVar, String str, int[] iArr, int i, String str2) throws RemoteException;

    void zza(zzrc zzrcVar, byte[] bArr) throws RemoteException;
}
