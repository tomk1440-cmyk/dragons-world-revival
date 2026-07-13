package com.unity3d.ads.device;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.unity3d.ads.log.DeviceLog;
import io.fabric.sdk.android.services.common.AdvertisingInfoServiceStrategy;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes.dex */
@TargetApi(9)
public class AdvertisingId {
    private static final String ADVERTISING_ID_SERVICE_NAME = "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService";
    private static AdvertisingId instance = null;
    private String advertisingIdentifier = null;
    private boolean limitedAdvertisingTracking = false;

    private static AdvertisingId getInstance() {
        if (instance == null) {
            instance = new AdvertisingId();
        }
        return instance;
    }

    public static void init(Context context) {
        getInstance().fetchAdvertisingId(context);
    }

    public static String getAdvertisingTrackingId() {
        return getInstance().advertisingIdentifier;
    }

    public static boolean getLimitedAdTracking() {
        return getInstance().limitedAdvertisingTracking;
    }

    private void fetchAdvertisingId(Context context) {
        GoogleAdvertisingServiceConnection connection = new GoogleAdvertisingServiceConnection();
        Intent localIntent = new Intent(AdvertisingInfoServiceStrategy.GOOGLE_PLAY_SERVICES_INTENT);
        localIntent.setPackage("com.google.android.gms");
        try {
            if (context.bindService(localIntent, connection, 1)) {
                GoogleAdvertisingInfo advertisingInfo = GoogleAdvertisingInfo.GoogleAdvertisingInfoBinder.create(connection.getBinder());
                this.advertisingIdentifier = advertisingInfo.getId();
                this.limitedAdvertisingTracking = advertisingInfo.getEnabled(true);
            }
        } catch (Exception e) {
            DeviceLog.exception("Couldn't get advertising info", e);
        } finally {
            context.unbindService(connection);
        }
    }

    private interface GoogleAdvertisingInfo extends IInterface {
        boolean getEnabled(boolean z) throws RemoteException;

        String getId() throws RemoteException;

        public static abstract class GoogleAdvertisingInfoBinder extends Binder implements GoogleAdvertisingInfo {
            public static GoogleAdvertisingInfo create(IBinder binder) {
                if (binder == null) {
                    return null;
                }
                IInterface localIInterface = binder.queryLocalInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                if (localIInterface != null && (localIInterface instanceof GoogleAdvertisingInfo)) {
                    return (GoogleAdvertisingInfo) localIInterface;
                }
                return new GoogleAdvertisingInfoImplementation(binder);
            }

            @Override // android.os.Binder
            public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
                switch (code) {
                    case 1:
                        data.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                        String str1 = getId();
                        reply.writeNoException();
                        reply.writeString(str1);
                        return true;
                    case 2:
                        data.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                        boolean bool1 = data.readInt() != 0;
                        boolean bool2 = getEnabled(bool1);
                        reply.writeNoException();
                        reply.writeInt(bool2 ? 1 : 0);
                        return true;
                    default:
                        return super.onTransact(code, data, reply, flags);
                }
            }

            private static class GoogleAdvertisingInfoImplementation implements GoogleAdvertisingInfo {
                private final IBinder _binder;

                GoogleAdvertisingInfoImplementation(IBinder binder) {
                    this._binder = binder;
                }

                @Override // android.os.IInterface
                public IBinder asBinder() {
                    return this._binder;
                }

                @Override // com.unity3d.ads.device.AdvertisingId.GoogleAdvertisingInfo
                public String getId() throws RemoteException {
                    Parcel localParcel1 = Parcel.obtain();
                    Parcel localParcel2 = Parcel.obtain();
                    try {
                        localParcel1.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                        this._binder.transact(1, localParcel1, localParcel2, 0);
                        localParcel2.readException();
                        String str = localParcel2.readString();
                        return str;
                    } finally {
                        localParcel2.recycle();
                        localParcel1.recycle();
                    }
                }

                @Override // com.unity3d.ads.device.AdvertisingId.GoogleAdvertisingInfo
                public boolean getEnabled(boolean paramBoolean) throws RemoteException {
                    Parcel localParcel1 = Parcel.obtain();
                    Parcel localParcel2 = Parcel.obtain();
                    try {
                        localParcel1.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                        localParcel1.writeInt(paramBoolean ? 1 : 0);
                        this._binder.transact(2, localParcel1, localParcel2, 0);
                        localParcel2.readException();
                        boolean bool = localParcel2.readInt() != 0;
                        return bool;
                    } finally {
                        localParcel2.recycle();
                        localParcel1.recycle();
                    }
                }
            }
        }
    }

    private class GoogleAdvertisingServiceConnection implements ServiceConnection {
        private final BlockingQueue<IBinder> _binderQueue;
        boolean _consumed;

        private GoogleAdvertisingServiceConnection() {
            this._consumed = false;
            this._binderQueue = new LinkedBlockingQueue();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName name, IBinder service) {
            try {
                this._binderQueue.put(service);
            } catch (InterruptedException e) {
                DeviceLog.debug("Couldn't put service to binder que");
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName name) {
        }

        public IBinder getBinder() throws InterruptedException {
            if (this._consumed) {
                throw new IllegalStateException();
            }
            this._consumed = true;
            return this._binderQueue.take();
        }
    }
}
