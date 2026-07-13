package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.PointOfInterest;

/* JADX INFO: loaded from: classes.dex */
public interface zzt extends IInterface {

    public static abstract class zza extends Binder implements zzt {

        /* JADX INFO: renamed from: com.google.android.gms.maps.internal.zzt$zza$zza, reason: collision with other inner class name */
        private static class C0233zza implements zzt {
            private IBinder zzoz;

            C0233zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.zzoz;
            }

            @Override // com.google.android.gms.maps.internal.zzt
            public void zza(PointOfInterest pointOfInterest) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnPoiClickListener");
                    if (pointOfInterest != null) {
                        parcelObtain.writeInt(1);
                        pointOfInterest.writeToParcel(parcelObtain, 0);
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
        }

        public static zzt zzcP(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnPoiClickListener");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof zzt)) ? new C0233zza(iBinder) : (zzt) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.maps.internal.IOnPoiClickListener");
                    zza(data.readInt() != 0 ? PointOfInterest.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.maps.internal.IOnPoiClickListener");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zza(PointOfInterest pointOfInterest) throws RemoteException;
}
