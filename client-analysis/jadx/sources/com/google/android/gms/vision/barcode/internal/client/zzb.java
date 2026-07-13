package com.google.android.gms.vision.barcode.internal.client;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.internal.client.FrameMetadataParcel;

/* JADX INFO: loaded from: classes.dex */
public interface zzb extends IInterface {

    public static abstract class zza extends Binder implements zzb {

        /* JADX INFO: renamed from: com.google.android.gms.vision.barcode.internal.client.zzb$zza$zza, reason: collision with other inner class name */
        private static class C0274zza implements zzb {
            private IBinder zzoz;

            C0274zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.zzoz;
            }

            @Override // com.google.android.gms.vision.barcode.internal.client.zzb
            public Barcode[] zza(com.google.android.gms.dynamic.zzd zzdVar, FrameMetadataParcel frameMetadataParcel) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetector");
                    parcelObtain.writeStrongBinder(zzdVar != null ? zzdVar.asBinder() : null);
                    if (frameMetadataParcel != null) {
                        parcelObtain.writeInt(1);
                        frameMetadataParcel.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.zzoz.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (Barcode[]) parcelObtain2.createTypedArray(Barcode.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.vision.barcode.internal.client.zzb
            public Barcode[] zzb(com.google.android.gms.dynamic.zzd zzdVar, FrameMetadataParcel frameMetadataParcel) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetector");
                    parcelObtain.writeStrongBinder(zzdVar != null ? zzdVar.asBinder() : null);
                    if (frameMetadataParcel != null) {
                        parcelObtain.writeInt(1);
                        frameMetadataParcel.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.zzoz.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (Barcode[]) parcelObtain2.createTypedArray(Barcode.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static zzb zzed(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetector");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof zzb)) ? new C0274zza(iBinder) : (zzb) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetector");
                    Barcode[] barcodeArrZza = zza(com.google.android.gms.dynamic.zzd.zza.zzbs(data.readStrongBinder()), data.readInt() != 0 ? FrameMetadataParcel.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    reply.writeTypedArray(barcodeArrZza, 1);
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetector");
                    Barcode[] barcodeArrZzb = zzb(com.google.android.gms.dynamic.zzd.zza.zzbs(data.readStrongBinder()), data.readInt() != 0 ? FrameMetadataParcel.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    reply.writeTypedArray(barcodeArrZzb, 1);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetector");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    Barcode[] zza(com.google.android.gms.dynamic.zzd zzdVar, FrameMetadataParcel frameMetadataParcel) throws RemoteException;

    Barcode[] zzb(com.google.android.gms.dynamic.zzd zzdVar, FrameMetadataParcel frameMetadataParcel) throws RemoteException;
}
