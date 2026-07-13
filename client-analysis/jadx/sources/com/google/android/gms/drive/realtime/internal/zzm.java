package com.google.android.gms.drive.realtime.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.realtime.internal.event.ParcelableEventList;
import com.google.android.gms.location.places.Place;

/* JADX INFO: loaded from: classes.dex */
public interface zzm extends IInterface {

    public static abstract class zza extends Binder implements zzm {

        /* JADX INFO: renamed from: com.google.android.gms.drive.realtime.internal.zzm$zza$zza, reason: collision with other inner class name */
        private static class C0074zza implements zzm {
            private IBinder zzoz;

            C0074zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.zzoz;
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void zza(int i, zzj zzjVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeStrongBinder(zzjVar != null ? zzjVar.asBinder() : null);
                    this.zzoz.transact(30, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void zza(int i, zzo zzoVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeStrongBinder(zzoVar != null ? zzoVar.asBinder() : null);
                    this.zzoz.transact(50, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void zza(DriveId driveId, zzo zzoVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    if (driveId != null) {
                        parcelObtain.writeInt(1);
                        driveId.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(zzoVar != null ? zzoVar.asBinder() : null);
                    this.zzoz.transact(48, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void zza(BeginCompoundOperationRequest beginCompoundOperationRequest, zzo zzoVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    if (beginCompoundOperationRequest != null) {
                        parcelObtain.writeInt(1);
                        beginCompoundOperationRequest.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(zzoVar != null ? zzoVar.asBinder() : null);
                    this.zzoz.transact(18, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void zza(EndCompoundOperationRequest endCompoundOperationRequest, zzj zzjVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    if (endCompoundOperationRequest != null) {
                        parcelObtain.writeInt(1);
                        endCompoundOperationRequest.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(zzjVar != null ? zzjVar.asBinder() : null);
                    this.zzoz.transact(41, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void zza(EndCompoundOperationRequest endCompoundOperationRequest, zzo zzoVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    if (endCompoundOperationRequest != null) {
                        parcelObtain.writeInt(1);
                        endCompoundOperationRequest.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(zzoVar != null ? zzoVar.asBinder() : null);
                    this.zzoz.transact(19, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void zza(ParcelableIndexReference parcelableIndexReference, zzn zznVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    if (parcelableIndexReference != null) {
                        parcelObtain.writeInt(1);
                        parcelableIndexReference.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(zznVar != null ? zznVar.asBinder() : null);
                    this.zzoz.transact(26, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void zza(zzc zzcVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    parcelObtain.writeStrongBinder(zzcVar != null ? zzcVar.asBinder() : null);
                    this.zzoz.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void zza(zzd zzdVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    parcelObtain.writeStrongBinder(zzdVar != null ? zzdVar.asBinder() : null);
                    this.zzoz.transact(32, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void zza(zze zzeVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    parcelObtain.writeStrongBinder(zzeVar != null ? zzeVar.asBinder() : null);
                    this.zzoz.transact(31, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void zza(zzh zzhVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    parcelObtain.writeStrongBinder(zzhVar != null ? zzhVar.asBinder() : null);
                    this.zzoz.transact(36, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void zza(zzi zziVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    parcelObtain.writeStrongBinder(zziVar != null ? zziVar.asBinder() : null);
                    this.zzoz.transact(34, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void zza(zzj zzjVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    parcelObtain.writeStrongBinder(zzjVar != null ? zzjVar.asBinder() : null);
                    this.zzoz.transact(22, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void zza(zzl zzlVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    parcelObtain.writeStrongBinder(zzlVar != null ? zzlVar.asBinder() : null);
                    this.zzoz.transact(40, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void zza(zzo zzoVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    parcelObtain.writeStrongBinder(zzoVar != null ? zzoVar.asBinder() : null);
                    this.zzoz.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void zza(String str, int i, int i2, zzg zzgVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeStrongBinder(zzgVar != null ? zzgVar.asBinder() : null);
                    this.zzoz.transact(17, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void zza(String str, int i, int i2, zzj zzjVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeStrongBinder(zzjVar != null ? zzjVar.asBinder() : null);
                    this.zzoz.transact(11, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void zza(String str, int i, DataHolder dataHolder, zzg zzgVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    if (dataHolder != null) {
                        parcelObtain.writeInt(1);
                        dataHolder.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(zzgVar != null ? zzgVar.asBinder() : null);
                    this.zzoz.transact(16, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void zza(String str, int i, DataHolder dataHolder, zzj zzjVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    if (dataHolder != null) {
                        parcelObtain.writeInt(1);
                        dataHolder.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(zzjVar != null ? zzjVar.asBinder() : null);
                    this.zzoz.transact(15, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void zza(String str, int i, zzn zznVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeStrongBinder(zznVar != null ? zznVar.asBinder() : null);
                    this.zzoz.transact(46, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void zza(String str, int i, zzo zzoVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeStrongBinder(zzoVar != null ? zzoVar.asBinder() : null);
                    this.zzoz.transact(28, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void zza(String str, int i, String str2, int i2, zzj zzjVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeStrongBinder(zzjVar != null ? zzjVar.asBinder() : null);
                    this.zzoz.transact(37, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void zza(String str, int i, String str2, zzj zzjVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeStrongBinder(zzjVar != null ? zzjVar.asBinder() : null);
                    this.zzoz.transact(10, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void zza(String str, DataHolder dataHolder, zzj zzjVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    parcelObtain.writeString(str);
                    if (dataHolder != null) {
                        parcelObtain.writeInt(1);
                        dataHolder.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(zzjVar != null ? zzjVar.asBinder() : null);
                    this.zzoz.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void zza(String str, zzf zzfVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(zzfVar != null ? zzfVar.asBinder() : null);
                    this.zzoz.transact(20, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void zza(String str, zzj zzjVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(zzjVar != null ? zzjVar.asBinder() : null);
                    this.zzoz.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void zza(String str, zzk zzkVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(zzkVar != null ? zzkVar.asBinder() : null);
                    this.zzoz.transact(27, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void zza(String str, zzl zzlVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(zzlVar != null ? zzlVar.asBinder() : null);
                    this.zzoz.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void zza(String str, zzn zznVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(zznVar != null ? zznVar.asBinder() : null);
                    this.zzoz.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void zza(String str, zzo zzoVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(zzoVar != null ? zzoVar.asBinder() : null);
                    this.zzoz.transact(38, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void zza(String str, String str2, DataHolder dataHolder, zzj zzjVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (dataHolder != null) {
                        parcelObtain.writeInt(1);
                        dataHolder.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(zzjVar != null ? zzjVar.asBinder() : null);
                    this.zzoz.transact(43, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void zza(String str, String str2, zzf zzfVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeStrongBinder(zzfVar != null ? zzfVar.asBinder() : null);
                    this.zzoz.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void zza(String str, String str2, zzg zzgVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeStrongBinder(zzgVar != null ? zzgVar.asBinder() : null);
                    this.zzoz.transact(21, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void zza(String str, String str2, zzj zzjVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeStrongBinder(zzjVar != null ? zzjVar.asBinder() : null);
                    this.zzoz.transact(12, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void zza(boolean z, zzo zzoVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    parcelObtain.writeInt(z ? 1 : 0);
                    parcelObtain.writeStrongBinder(zzoVar != null ? zzoVar.asBinder() : null);
                    this.zzoz.transact(47, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void zzb(zzc zzcVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    parcelObtain.writeStrongBinder(zzcVar != null ? zzcVar.asBinder() : null);
                    this.zzoz.transact(33, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void zzb(zzj zzjVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    parcelObtain.writeStrongBinder(zzjVar != null ? zzjVar.asBinder() : null);
                    this.zzoz.transact(23, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void zzb(zzl zzlVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    parcelObtain.writeStrongBinder(zzlVar != null ? zzlVar.asBinder() : null);
                    this.zzoz.transact(29, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void zzb(zzo zzoVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    parcelObtain.writeStrongBinder(zzoVar != null ? zzoVar.asBinder() : null);
                    this.zzoz.transact(35, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void zzb(String str, zzf zzfVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(zzfVar != null ? zzfVar.asBinder() : null);
                    this.zzoz.transact(13, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void zzb(String str, zzl zzlVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(zzlVar != null ? zzlVar.asBinder() : null);
                    this.zzoz.transact(8, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void zzb(String str, zzn zznVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(zznVar != null ? zznVar.asBinder() : null);
                    this.zzoz.transact(9, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void zzb(String str, zzo zzoVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(zzoVar != null ? zzoVar.asBinder() : null);
                    this.zzoz.transact(39, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void zzb(String str, String str2, zzf zzfVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeStrongBinder(zzfVar != null ? zzfVar.asBinder() : null);
                    this.zzoz.transact(42, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void zzc(zzc zzcVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    parcelObtain.writeStrongBinder(zzcVar != null ? zzcVar.asBinder() : null);
                    this.zzoz.transact(45, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void zzc(zzo zzoVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    parcelObtain.writeStrongBinder(zzoVar != null ? zzoVar.asBinder() : null);
                    this.zzoz.transact(49, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void zzc(String str, zzl zzlVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(zzlVar != null ? zzlVar.asBinder() : null);
                    this.zzoz.transact(14, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void zzd(zzc zzcVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    parcelObtain.writeStrongBinder(zzcVar != null ? zzcVar.asBinder() : null);
                    this.zzoz.transact(24, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void zze(zzc zzcVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    parcelObtain.writeStrongBinder(zzcVar != null ? zzcVar.asBinder() : null);
                    this.zzoz.transact(25, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public ParcelableEventList zzf(String str, String str2, String str3) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    this.zzoz.transact(51, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? ParcelableEventList.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void zztT() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    this.zzoz.transact(44, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static zzm zzbo(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof zzm)) ? new C0074zza(iBinder) : (zzm) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zza(parcel.readString(), zzn.zza.zzbp(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zza(zzc.zza.zzbe(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zza(zzo.zza.zzbq(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zza(parcel.readString(), parcel.readString(), zzf.zza.zzbh(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zza(parcel.readString(), zzl.zza.zzbn(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zza(parcel.readString(), parcel.readInt() != 0 ? DataHolder.CREATOR.createFromParcel(parcel) : null, zzj.zza.zzbl(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zza(parcel.readString(), zzj.zza.zzbl(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zzb(parcel.readString(), zzl.zza.zzbn(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zzb(parcel.readString(), zzn.zza.zzbp(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zza(parcel.readString(), parcel.readInt(), parcel.readString(), zzj.zza.zzbl(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 11:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zza(parcel.readString(), parcel.readInt(), parcel.readInt(), zzj.zza.zzbl(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 12:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zza(parcel.readString(), parcel.readString(), zzj.zza.zzbl(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 13:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zzb(parcel.readString(), zzf.zza.zzbh(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 14:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zzc(parcel.readString(), zzl.zza.zzbn(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 15:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zza(parcel.readString(), parcel.readInt(), parcel.readInt() != 0 ? DataHolder.CREATOR.createFromParcel(parcel) : null, zzj.zza.zzbl(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 16:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zza(parcel.readString(), parcel.readInt(), parcel.readInt() != 0 ? DataHolder.CREATOR.createFromParcel(parcel) : null, zzg.zza.zzbi(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 17:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zza(parcel.readString(), parcel.readInt(), parcel.readInt(), zzg.zza.zzbi(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 18:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zza(parcel.readInt() != 0 ? BeginCompoundOperationRequest.CREATOR.createFromParcel(parcel) : null, zzo.zza.zzbq(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 19:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zza(parcel.readInt() != 0 ? EndCompoundOperationRequest.CREATOR.createFromParcel(parcel) : null, zzo.zza.zzbq(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 20:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zza(parcel.readString(), zzf.zza.zzbh(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 21:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zza(parcel.readString(), parcel.readString(), zzg.zza.zzbi(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 22:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zza(zzj.zza.zzbl(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 23:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zzb(zzj.zza.zzbl(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 24:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zzd(zzc.zza.zzbe(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 25:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zze(zzc.zza.zzbe(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 26:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zza(parcel.readInt() != 0 ? ParcelableIndexReference.CREATOR.createFromParcel(parcel) : null, zzn.zza.zzbp(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 27:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zza(parcel.readString(), zzk.zza.zzbm(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 28:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zza(parcel.readString(), parcel.readInt(), zzo.zza.zzbq(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 29:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zzb(zzl.zza.zzbn(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 30:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zza(parcel.readInt(), zzj.zza.zzbl(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 31:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zza(zze.zza.zzbg(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 32:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zza(zzd.zza.zzbf(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 33:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zzb(zzc.zza.zzbe(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 34:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zza(zzi.zza.zzbk(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 35:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zzb(zzo.zza.zzbq(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 36:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zza(zzh.zza.zzbj(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 37:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zza(parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readInt(), zzj.zza.zzbl(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 38:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zza(parcel.readString(), zzo.zza.zzbq(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 39:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zzb(parcel.readString(), zzo.zza.zzbq(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 40:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zza(zzl.zza.zzbn(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 41:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zza(parcel.readInt() != 0 ? EndCompoundOperationRequest.CREATOR.createFromParcel(parcel) : null, zzj.zza.zzbl(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 42:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zzb(parcel.readString(), parcel.readString(), zzf.zza.zzbh(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 43:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zza(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? DataHolder.CREATOR.createFromParcel(parcel) : null, zzj.zza.zzbl(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 44:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zztT();
                    parcel2.writeNoException();
                    return true;
                case 45:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zzc(zzc.zza.zzbe(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 46:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zza(parcel.readString(), parcel.readInt(), zzn.zza.zzbp(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 47:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zza(parcel.readInt() != 0, zzo.zza.zzbq(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case Place.TYPE_HINDU_TEMPLE /* 48 */:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zza(parcel.readInt() != 0 ? DriveId.CREATOR.createFromParcel(parcel) : null, zzo.zza.zzbq(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case Place.TYPE_HOME_GOODS_STORE /* 49 */:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zzc(zzo.zza.zzbq(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 50:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    zza(parcel.readInt(), zzo.zza.zzbq(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case Place.TYPE_INSURANCE_AGENCY /* 51 */:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    ParcelableEventList parcelableEventListZzf = zzf(parcel.readString(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    if (parcelableEventListZzf == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    parcelableEventListZzf.writeToParcel(parcel2, 1);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(int i, zzj zzjVar) throws RemoteException;

    void zza(int i, zzo zzoVar) throws RemoteException;

    void zza(DriveId driveId, zzo zzoVar) throws RemoteException;

    void zza(BeginCompoundOperationRequest beginCompoundOperationRequest, zzo zzoVar) throws RemoteException;

    void zza(EndCompoundOperationRequest endCompoundOperationRequest, zzj zzjVar) throws RemoteException;

    void zza(EndCompoundOperationRequest endCompoundOperationRequest, zzo zzoVar) throws RemoteException;

    void zza(ParcelableIndexReference parcelableIndexReference, zzn zznVar) throws RemoteException;

    void zza(zzc zzcVar) throws RemoteException;

    void zza(zzd zzdVar) throws RemoteException;

    void zza(zze zzeVar) throws RemoteException;

    void zza(zzh zzhVar) throws RemoteException;

    void zza(zzi zziVar) throws RemoteException;

    void zza(zzj zzjVar) throws RemoteException;

    void zza(zzl zzlVar) throws RemoteException;

    void zza(zzo zzoVar) throws RemoteException;

    void zza(String str, int i, int i2, zzg zzgVar) throws RemoteException;

    void zza(String str, int i, int i2, zzj zzjVar) throws RemoteException;

    void zza(String str, int i, DataHolder dataHolder, zzg zzgVar) throws RemoteException;

    void zza(String str, int i, DataHolder dataHolder, zzj zzjVar) throws RemoteException;

    void zza(String str, int i, zzn zznVar) throws RemoteException;

    void zza(String str, int i, zzo zzoVar) throws RemoteException;

    void zza(String str, int i, String str2, int i2, zzj zzjVar) throws RemoteException;

    void zza(String str, int i, String str2, zzj zzjVar) throws RemoteException;

    void zza(String str, DataHolder dataHolder, zzj zzjVar) throws RemoteException;

    void zza(String str, zzf zzfVar) throws RemoteException;

    void zza(String str, zzj zzjVar) throws RemoteException;

    void zza(String str, zzk zzkVar) throws RemoteException;

    void zza(String str, zzl zzlVar) throws RemoteException;

    void zza(String str, zzn zznVar) throws RemoteException;

    void zza(String str, zzo zzoVar) throws RemoteException;

    void zza(String str, String str2, DataHolder dataHolder, zzj zzjVar) throws RemoteException;

    void zza(String str, String str2, zzf zzfVar) throws RemoteException;

    void zza(String str, String str2, zzg zzgVar) throws RemoteException;

    void zza(String str, String str2, zzj zzjVar) throws RemoteException;

    void zza(boolean z, zzo zzoVar) throws RemoteException;

    void zzb(zzc zzcVar) throws RemoteException;

    void zzb(zzj zzjVar) throws RemoteException;

    void zzb(zzl zzlVar) throws RemoteException;

    void zzb(zzo zzoVar) throws RemoteException;

    void zzb(String str, zzf zzfVar) throws RemoteException;

    void zzb(String str, zzl zzlVar) throws RemoteException;

    void zzb(String str, zzn zznVar) throws RemoteException;

    void zzb(String str, zzo zzoVar) throws RemoteException;

    void zzb(String str, String str2, zzf zzfVar) throws RemoteException;

    void zzc(zzc zzcVar) throws RemoteException;

    void zzc(zzo zzoVar) throws RemoteException;

    void zzc(String str, zzl zzlVar) throws RemoteException;

    void zzd(zzc zzcVar) throws RemoteException;

    void zze(zzc zzcVar) throws RemoteException;

    ParcelableEventList zzf(String str, String str2, String str3) throws RemoteException;

    void zztT() throws RemoteException;
}
