package android.support.v4.media;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.ResultReceiver;

/* JADX INFO: loaded from: classes.dex */
class IMediaBrowserServiceAdapterApi21 {
    IMediaBrowserServiceAdapterApi21() {
    }

    static abstract class Stub extends Binder implements IInterface {
        private static final String DESCRIPTOR = "android.service.media.IMediaBrowserService";
        private static final int TRANSACTION_addSubscription = 3;
        private static final int TRANSACTION_connect = 1;
        private static final int TRANSACTION_disconnect = 2;
        private static final int TRANSACTION_getMediaItem = 5;
        private static final int TRANSACTION_removeSubscription = 4;

        public abstract void addSubscription(String str, Object obj);

        public abstract void connect(String str, Bundle bundle, Object obj);

        public abstract void disconnect(Object obj);

        public abstract void getMediaItem(String str, ResultReceiver resultReceiver);

        public abstract void removeSubscription(String str, Object obj);

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            ResultReceiver arg1;
            Bundle arg2;
            switch (code) {
                case 1:
                    data.enforceInterface(DESCRIPTOR);
                    String arg0 = data.readString();
                    if (data.readInt() != 0) {
                        arg2 = (Bundle) Bundle.CREATOR.createFromParcel(data);
                    } else {
                        arg2 = null;
                    }
                    Object arg3 = IMediaBrowserServiceCallbacksAdapterApi21.Stub.asInterface(data.readStrongBinder());
                    connect(arg0, arg2, arg3);
                    return true;
                case 2:
                    data.enforceInterface(DESCRIPTOR);
                    Object arg4 = IMediaBrowserServiceCallbacksAdapterApi21.Stub.asInterface(data.readStrongBinder());
                    disconnect(arg4);
                    return true;
                case 3:
                    data.enforceInterface(DESCRIPTOR);
                    String arg5 = data.readString();
                    Object arg6 = IMediaBrowserServiceCallbacksAdapterApi21.Stub.asInterface(data.readStrongBinder());
                    addSubscription(arg5, arg6);
                    return true;
                case 4:
                    data.enforceInterface(DESCRIPTOR);
                    String arg7 = data.readString();
                    Object arg8 = IMediaBrowserServiceCallbacksAdapterApi21.Stub.asInterface(data.readStrongBinder());
                    removeSubscription(arg7, arg8);
                    return true;
                case 5:
                    data.enforceInterface(DESCRIPTOR);
                    String arg9 = data.readString();
                    if (data.readInt() != 0) {
                        arg1 = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(data);
                    } else {
                        arg1 = null;
                    }
                    getMediaItem(arg9, arg1);
                    return true;
                case 1598968902:
                    reply.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }
}
