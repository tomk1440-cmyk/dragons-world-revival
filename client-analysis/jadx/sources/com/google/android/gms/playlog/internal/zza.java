package com.google.android.gms.playlog.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface zza extends IInterface {

    /* JADX INFO: renamed from: com.google.android.gms.playlog.internal.zza$zza, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0265zza extends Binder implements zza {

        /* JADX INFO: renamed from: com.google.android.gms.playlog.internal.zza$zza$zza, reason: collision with other inner class name */
        private static class C0266zza implements zza {
            private IBinder zzoz;

            C0266zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.zzoz;
            }

            @Override // com.google.android.gms.playlog.internal.zza
            public void zza(String str, PlayLoggerContext playLoggerContext, LogEvent logEvent) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.playlog.internal.IPlayLogService");
                    parcelObtain.writeString(str);
                    if (playLoggerContext != null) {
                        parcelObtain.writeInt(1);
                        playLoggerContext.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (logEvent != null) {
                        parcelObtain.writeInt(1);
                        logEvent.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.zzoz.transact(2, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.playlog.internal.zza
            public void zza(String str, PlayLoggerContext playLoggerContext, List<LogEvent> list) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.playlog.internal.IPlayLogService");
                    parcelObtain.writeString(str);
                    if (playLoggerContext != null) {
                        parcelObtain.writeInt(1);
                        playLoggerContext.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeTypedList(list);
                    this.zzoz.transact(3, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.playlog.internal.zza
            public void zza(String str, PlayLoggerContext playLoggerContext, byte[] bArr) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.playlog.internal.IPlayLogService");
                    parcelObtain.writeString(str);
                    if (playLoggerContext != null) {
                        parcelObtain.writeInt(1);
                        playLoggerContext.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeByteArray(bArr);
                    this.zzoz.transact(4, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public static zza zzdN(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.playlog.internal.IPlayLogService");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof zza)) ? new C0266zza(iBinder) : (zza) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 2:
                    parcel.enforceInterface("com.google.android.gms.playlog.internal.IPlayLogService");
                    zza(parcel.readString(), parcel.readInt() != 0 ? PlayLoggerContext.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? LogEvent.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 3:
                    parcel.enforceInterface("com.google.android.gms.playlog.internal.IPlayLogService");
                    zza(parcel.readString(), parcel.readInt() != 0 ? PlayLoggerContext.CREATOR.createFromParcel(parcel) : null, parcel.createTypedArrayList(LogEvent.CREATOR));
                    return true;
                case 4:
                    parcel.enforceInterface("com.google.android.gms.playlog.internal.IPlayLogService");
                    zza(parcel.readString(), parcel.readInt() != 0 ? PlayLoggerContext.CREATOR.createFromParcel(parcel) : null, parcel.createByteArray());
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.playlog.internal.IPlayLogService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(String str, PlayLoggerContext playLoggerContext, LogEvent logEvent) throws RemoteException;

    void zza(String str, PlayLoggerContext playLoggerContext, List<LogEvent> list) throws RemoteException;

    void zza(String str, PlayLoggerContext playLoggerContext, byte[] bArr) throws RemoteException;
}
