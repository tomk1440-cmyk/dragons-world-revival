package com.google.android.gms.location.places.personalized;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface zza extends IInterface {

    /* JADX INFO: renamed from: com.google.android.gms.location.places.personalized.zza$zza, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0198zza extends Binder implements zza {

        /* JADX INFO: renamed from: com.google.android.gms.location.places.personalized.zza$zza$zza, reason: collision with other inner class name */
        private static class C0199zza implements zza {
            private IBinder zzoz;

            C0199zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.zzoz;
            }

            @Override // com.google.android.gms.location.places.personalized.zza
            public void zza(PlaceAliasResult placeAliasResult) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.location.places.personalized.IPlaceAliasCallbacks");
                    if (placeAliasResult != null) {
                        parcelObtain.writeInt(1);
                        placeAliasResult.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.zzoz.transact(2, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.location.places.personalized.zza
            public void zzb(PlaceAliasResult placeAliasResult) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.location.places.personalized.IPlaceAliasCallbacks");
                    if (placeAliasResult != null) {
                        parcelObtain.writeInt(1);
                        placeAliasResult.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.zzoz.transact(3, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public static zza zzcr(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.places.personalized.IPlaceAliasCallbacks");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof zza)) ? new C0199zza(iBinder) : (zza) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 2:
                    data.enforceInterface("com.google.android.gms.location.places.personalized.IPlaceAliasCallbacks");
                    zza(data.readInt() != 0 ? PlaceAliasResult.CREATOR.createFromParcel(data) : null);
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.location.places.personalized.IPlaceAliasCallbacks");
                    zzb(data.readInt() != 0 ? PlaceAliasResult.CREATOR.createFromParcel(data) : null);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.location.places.personalized.IPlaceAliasCallbacks");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zza(PlaceAliasResult placeAliasResult) throws RemoteException;

    void zzb(PlaceAliasResult placeAliasResult) throws RemoteException;
}
