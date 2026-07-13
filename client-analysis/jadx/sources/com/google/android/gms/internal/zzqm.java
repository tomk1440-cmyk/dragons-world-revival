package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.nearby.connection.AppMetadata;

/* JADX INFO: loaded from: classes.dex */
public interface zzqm extends IInterface {

    public static abstract class zza extends Binder implements zzqm {

        /* JADX INFO: renamed from: com.google.android.gms.internal.zzqm$zza$zza, reason: collision with other inner class name */
        private static class C0172zza implements zzqm {
            private IBinder zzoz;

            C0172zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.zzoz;
            }

            @Override // com.google.android.gms.internal.zzqm
            public void onConnectionRequest(String remoteEndpointId, String remoteDeviceId, String remoteEndpointName, byte[] payload) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    parcelObtain.writeString(remoteEndpointId);
                    parcelObtain.writeString(remoteDeviceId);
                    parcelObtain.writeString(remoteEndpointName);
                    parcelObtain.writeByteArray(payload);
                    this.zzoz.transact(1001, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzqm
            public void onDisconnected(String remoteEndpointId) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    parcelObtain.writeString(remoteEndpointId);
                    this.zzoz.transact(Place.TYPE_INTERSECTION, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzqm
            public void onEndpointFound(String endpointId, String deviceId, String serviceId, String name) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    parcelObtain.writeString(endpointId);
                    parcelObtain.writeString(deviceId);
                    parcelObtain.writeString(serviceId);
                    parcelObtain.writeString(name);
                    this.zzoz.transact(1002, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzqm
            public void onEndpointLost(String endpointId) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    parcelObtain.writeString(endpointId);
                    this.zzoz.transact(Place.TYPE_ADMINISTRATIVE_AREA_LEVEL_3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzqm
            public void onMessageReceived(String remoteEndpointId, byte[] payload, boolean isReliable) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    parcelObtain.writeString(remoteEndpointId);
                    parcelObtain.writeByteArray(payload);
                    parcelObtain.writeInt(isReliable ? 1 : 0);
                    this.zzoz.transact(1007, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzqm
            public void zza(String str, int i, byte[] bArr) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeByteArray(bArr);
                    this.zzoz.transact(Place.TYPE_FLOOR, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzqm
            public void zza(String str, String str2, String str3, String str4, AppMetadata appMetadata) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeString(str4);
                    if (appMetadata != null) {
                        parcelObtain.writeInt(1);
                        appMetadata.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.zzoz.transact(Place.TYPE_COLLOQUIAL_AREA, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzqm
            public void zzfy(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    parcelObtain.writeString(str);
                    this.zzoz.transact(Place.TYPE_COUNTRY, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzqm
            public void zziW(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    parcelObtain.writeInt(i);
                    this.zzoz.transact(Place.TYPE_NATURAL_FEATURE, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzqm
            public void zziX(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    parcelObtain.writeInt(i);
                    this.zzoz.transact(Place.TYPE_NEIGHBORHOOD, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzqm
            public void zziY(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    parcelObtain.writeInt(i);
                    this.zzoz.transact(Place.TYPE_POLITICAL, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzqm
            public void zziZ(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    parcelObtain.writeInt(i);
                    this.zzoz.transact(Place.TYPE_POINT_OF_INTEREST, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzqm
            public void zzja(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    parcelObtain.writeInt(i);
                    this.zzoz.transact(Place.TYPE_POST_BOX, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzqm
            public void zzm(int i, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str);
                    this.zzoz.transact(Place.TYPE_LOCALITY, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
        }

        public static zzqm zzdw(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof zzqm)) ? new C0172zza(iBinder) : (zzqm) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1001:
                    data.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    onConnectionRequest(data.readString(), data.readString(), data.readString(), data.createByteArray());
                    reply.writeNoException();
                    return true;
                case 1002:
                    data.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    onEndpointFound(data.readString(), data.readString(), data.readString(), data.readString());
                    reply.writeNoException();
                    return true;
                case Place.TYPE_ADMINISTRATIVE_AREA_LEVEL_3 /* 1003 */:
                    data.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    onEndpointLost(data.readString());
                    reply.writeNoException();
                    return true;
                case Place.TYPE_COLLOQUIAL_AREA /* 1004 */:
                    data.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    zza(data.readString(), data.readString(), data.readString(), data.readString(), data.readInt() != 0 ? AppMetadata.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case Place.TYPE_COUNTRY /* 1005 */:
                    data.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    zzfy(data.readString());
                    reply.writeNoException();
                    return true;
                case Place.TYPE_FLOOR /* 1006 */:
                    data.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    zza(data.readString(), data.readInt(), data.createByteArray());
                    reply.writeNoException();
                    return true;
                case 1007:
                    data.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    onMessageReceived(data.readString(), data.createByteArray(), data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                case Place.TYPE_INTERSECTION /* 1008 */:
                    data.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    onDisconnected(data.readString());
                    reply.writeNoException();
                    return true;
                case Place.TYPE_LOCALITY /* 1009 */:
                    data.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    zzm(data.readInt(), data.readString());
                    reply.writeNoException();
                    return true;
                case Place.TYPE_NATURAL_FEATURE /* 1010 */:
                    data.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    zziW(data.readInt());
                    reply.writeNoException();
                    return true;
                case Place.TYPE_NEIGHBORHOOD /* 1011 */:
                    data.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    zziX(data.readInt());
                    reply.writeNoException();
                    return true;
                case Place.TYPE_POLITICAL /* 1012 */:
                    data.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    zziY(data.readInt());
                    reply.writeNoException();
                    return true;
                case Place.TYPE_POINT_OF_INTEREST /* 1013 */:
                    data.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    zziZ(data.readInt());
                    reply.writeNoException();
                    return true;
                case Place.TYPE_POST_BOX /* 1014 */:
                    data.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    zzja(data.readInt());
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void onConnectionRequest(String str, String str2, String str3, byte[] bArr) throws RemoteException;

    void onDisconnected(String str) throws RemoteException;

    void onEndpointFound(String str, String str2, String str3, String str4) throws RemoteException;

    void onEndpointLost(String str) throws RemoteException;

    void onMessageReceived(String str, byte[] bArr, boolean z) throws RemoteException;

    void zza(String str, int i, byte[] bArr) throws RemoteException;

    void zza(String str, String str2, String str3, String str4, AppMetadata appMetadata) throws RemoteException;

    void zzfy(String str) throws RemoteException;

    void zziW(int i) throws RemoteException;

    void zziX(int i) throws RemoteException;

    void zziY(int i) throws RemoteException;

    void zziZ(int i) throws RemoteException;

    void zzja(int i) throws RemoteException;

    void zzm(int i, String str) throws RemoteException;
}
