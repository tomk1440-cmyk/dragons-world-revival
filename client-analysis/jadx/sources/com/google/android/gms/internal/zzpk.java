package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface zzpk extends IInterface {

    public static abstract class zza extends Binder implements zzpk {

        /* JADX INFO: renamed from: com.google.android.gms.internal.zzpk$zza$zza, reason: collision with other inner class name */
        private static class C0163zza implements zzpk {
            private IBinder zzoz;

            C0163zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.zzoz;
            }

            @Override // com.google.android.gms.internal.zzpk
            public boolean getBooleanFlagValue(String key, boolean defaultVal, int source) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.flags.IFlagProvider");
                    parcelObtain.writeString(key);
                    parcelObtain.writeInt(defaultVal ? 1 : 0);
                    parcelObtain.writeInt(source);
                    this.zzoz.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzpk
            public int getIntFlagValue(String key, int defaultVal, int source) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.flags.IFlagProvider");
                    parcelObtain.writeString(key);
                    parcelObtain.writeInt(defaultVal);
                    parcelObtain.writeInt(source);
                    this.zzoz.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzpk
            public long getLongFlagValue(String key, long defaultVal, int source) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.flags.IFlagProvider");
                    parcelObtain.writeString(key);
                    parcelObtain.writeLong(defaultVal);
                    parcelObtain.writeInt(source);
                    this.zzoz.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readLong();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzpk
            public String getStringFlagValue(String key, String defaultVal, int source) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.flags.IFlagProvider");
                    parcelObtain.writeString(key);
                    parcelObtain.writeString(defaultVal);
                    parcelObtain.writeInt(source);
                    this.zzoz.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzpk
            public void init(com.google.android.gms.dynamic.zzd context) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.flags.IFlagProvider");
                    parcelObtain.writeStrongBinder(context != null ? context.asBinder() : null);
                    this.zzoz.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.flags.IFlagProvider");
        }

        public static zzpk asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = obj.queryLocalInterface("com.google.android.gms.flags.IFlagProvider");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof zzpk)) ? new C0163zza(obj) : (zzpk) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.flags.IFlagProvider");
                    init(com.google.android.gms.dynamic.zzd.zza.zzbs(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.flags.IFlagProvider");
                    boolean booleanFlagValue = getBooleanFlagValue(data.readString(), data.readInt() != 0, data.readInt());
                    reply.writeNoException();
                    reply.writeInt(booleanFlagValue ? 1 : 0);
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.flags.IFlagProvider");
                    int intFlagValue = getIntFlagValue(data.readString(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    reply.writeInt(intFlagValue);
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.flags.IFlagProvider");
                    long longFlagValue = getLongFlagValue(data.readString(), data.readLong(), data.readInt());
                    reply.writeNoException();
                    reply.writeLong(longFlagValue);
                    return true;
                case 5:
                    data.enforceInterface("com.google.android.gms.flags.IFlagProvider");
                    String stringFlagValue = getStringFlagValue(data.readString(), data.readString(), data.readInt());
                    reply.writeNoException();
                    reply.writeString(stringFlagValue);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.flags.IFlagProvider");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    boolean getBooleanFlagValue(String str, boolean z, int i) throws RemoteException;

    int getIntFlagValue(String str, int i, int i2) throws RemoteException;

    long getLongFlagValue(String str, long j, int i) throws RemoteException;

    String getStringFlagValue(String str, String str2, int i) throws RemoteException;

    void init(com.google.android.gms.dynamic.zzd zzdVar) throws RemoteException;
}
