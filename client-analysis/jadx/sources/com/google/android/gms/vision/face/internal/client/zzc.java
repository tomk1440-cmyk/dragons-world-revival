package com.google.android.gms.vision.face.internal.client;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.vision.internal.client.FrameMetadataParcel;

/* JADX INFO: loaded from: classes.dex */
public interface zzc extends IInterface {

    public static abstract class zza extends Binder implements zzc {

        /* JADX INFO: renamed from: com.google.android.gms.vision.face.internal.client.zzc$zza$zza, reason: collision with other inner class name */
        private static class C0276zza implements zzc {
            private IBinder zzoz;

            C0276zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.zzoz;
            }

            @Override // com.google.android.gms.vision.face.internal.client.zzc
            public void zzIh() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.vision.face.internal.client.INativeFaceDetector");
                    this.zzoz.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.vision.face.internal.client.zzc
            public FaceParcel[] zzc(com.google.android.gms.dynamic.zzd zzdVar, FrameMetadataParcel frameMetadataParcel) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.vision.face.internal.client.INativeFaceDetector");
                    parcelObtain.writeStrongBinder(zzdVar != null ? zzdVar.asBinder() : null);
                    if (frameMetadataParcel != null) {
                        parcelObtain.writeInt(1);
                        frameMetadataParcel.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.zzoz.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (FaceParcel[]) parcelObtain2.createTypedArray(FaceParcel.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.vision.face.internal.client.zzc
            public boolean zzkJ(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.vision.face.internal.client.INativeFaceDetector");
                    parcelObtain.writeInt(i);
                    this.zzoz.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static zzc zzeg(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.vision.face.internal.client.INativeFaceDetector");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof zzc)) ? new C0276zza(iBinder) : (zzc) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.vision.face.internal.client.INativeFaceDetector");
                    FaceParcel[] faceParcelArrZzc = zzc(com.google.android.gms.dynamic.zzd.zza.zzbs(data.readStrongBinder()), data.readInt() != 0 ? FrameMetadataParcel.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    reply.writeTypedArray(faceParcelArrZzc, 1);
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.vision.face.internal.client.INativeFaceDetector");
                    boolean zZzkJ = zzkJ(data.readInt());
                    reply.writeNoException();
                    reply.writeInt(zZzkJ ? 1 : 0);
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.vision.face.internal.client.INativeFaceDetector");
                    zzIh();
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.vision.face.internal.client.INativeFaceDetector");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zzIh() throws RemoteException;

    FaceParcel[] zzc(com.google.android.gms.dynamic.zzd zzdVar, FrameMetadataParcel frameMetadataParcel) throws RemoteException;

    boolean zzkJ(int i) throws RemoteException;
}
