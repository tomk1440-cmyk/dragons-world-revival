package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.clearcut.LogEventParcelable;

/* JADX INFO: loaded from: classes.dex */
public interface zzly extends IInterface {

    public static abstract class zza extends Binder implements zzly {

        /* JADX INFO: renamed from: com.google.android.gms.internal.zzly$zza$zza, reason: collision with other inner class name */
        private static class C0140zza implements zzly {
            private IBinder zzoz;

            C0140zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.zzoz;
            }

            @Override // com.google.android.gms.internal.zzly
            public void zza(zzlx zzlxVar, LogEventParcelable logEventParcelable) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
                    parcelObtain.writeStrongBinder(zzlxVar != null ? zzlxVar.asBinder() : null);
                    if (logEventParcelable != null) {
                        parcelObtain.writeInt(1);
                        logEventParcelable.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.zzoz.transact(1, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public static zzly zzaM(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof zzly)) ? new C0140zza(iBinder) : (zzly) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
                    zza(zzlx.zza.zzaL(data.readStrongBinder()), data.readInt() != 0 ? LogEventParcelable.CREATOR.createFromParcel(data) : null);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zza(zzlx zzlxVar, LogEventParcelable logEventParcelable) throws RemoteException;
}
