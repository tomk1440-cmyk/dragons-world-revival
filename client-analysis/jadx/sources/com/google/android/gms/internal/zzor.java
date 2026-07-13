package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.ListSubscriptionsResult;

/* JADX INFO: loaded from: classes.dex */
public interface zzor extends IInterface {

    public static abstract class zza extends Binder implements zzor {

        /* JADX INFO: renamed from: com.google.android.gms.internal.zzor$zza$zza, reason: collision with other inner class name */
        private static class C0155zza implements zzor {
            private IBinder zzoz;

            C0155zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.zzoz;
            }

            @Override // com.google.android.gms.internal.zzor
            public void zza(ListSubscriptionsResult listSubscriptionsResult) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IListSubscriptionsCallback");
                    if (listSubscriptionsResult != null) {
                        parcelObtain.writeInt(1);
                        listSubscriptionsResult.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.zzoz.transact(1, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.fitness.internal.IListSubscriptionsCallback");
        }

        public static zzor zzbM(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IListSubscriptionsCallback");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof zzor)) ? new C0155zza(iBinder) : (zzor) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.fitness.internal.IListSubscriptionsCallback");
                    zza(data.readInt() != 0 ? ListSubscriptionsResult.CREATOR.createFromParcel(data) : null);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.fitness.internal.IListSubscriptionsCallback");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zza(ListSubscriptionsResult listSubscriptionsResult) throws RemoteException;
}
