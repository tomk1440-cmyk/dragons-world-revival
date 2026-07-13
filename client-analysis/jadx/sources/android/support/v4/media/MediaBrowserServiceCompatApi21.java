package android.support.v4.media;

import android.content.Intent;
import android.media.MediaDescription;
import android.media.browse.MediaBrowser;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.ResultReceiver;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class MediaBrowserServiceCompatApi21 {

    public interface ServiceCallbacks {
        IBinder asBinder();

        void onConnect(String str, Object obj, Bundle bundle) throws RemoteException;

        void onConnectFailed() throws RemoteException;

        void onLoadChildren(String str, List<Parcel> list) throws RemoteException;
    }

    public interface ServiceImplApi21 {
        void addSubscription(String str, ServiceCallbacks serviceCallbacks);

        void connect(String str, Bundle bundle, ServiceCallbacks serviceCallbacks);

        void disconnect(ServiceCallbacks serviceCallbacks);

        void removeSubscription(String str, ServiceCallbacks serviceCallbacks);
    }

    MediaBrowserServiceCompatApi21() {
    }

    public static Object createService() {
        return new MediaBrowserServiceAdaptorApi21();
    }

    public static void onCreate(Object serviceObj, ServiceImplApi21 serviceImpl) {
        ((MediaBrowserServiceAdaptorApi21) serviceObj).onCreate(serviceImpl);
    }

    public static IBinder onBind(Object serviceObj, Intent intent) {
        return ((MediaBrowserServiceAdaptorApi21) serviceObj).onBind(intent);
    }

    public static class ServiceCallbacksApi21 implements ServiceCallbacks {
        private static Object sNullParceledListSliceObj;
        private final IMediaBrowserServiceCallbacksAdapterApi21 mCallbacks;

        static {
            MediaDescription nullDescription = new MediaDescription.Builder().setMediaId("android.support.v4.media.MediaBrowserCompat.NULL_MEDIA_ITEM").build();
            MediaBrowser.MediaItem nullMediaItem = new MediaBrowser.MediaItem(nullDescription, 0);
            List<MediaBrowser.MediaItem> nullMediaItemList = new ArrayList<>();
            nullMediaItemList.add(nullMediaItem);
            sNullParceledListSliceObj = ParceledListSliceAdapterApi21.newInstance(nullMediaItemList);
        }

        ServiceCallbacksApi21(Object callbacksObj) {
            this.mCallbacks = new IMediaBrowserServiceCallbacksAdapterApi21(callbacksObj);
        }

        @Override // android.support.v4.media.MediaBrowserServiceCompatApi21.ServiceCallbacks
        public IBinder asBinder() {
            return this.mCallbacks.asBinder();
        }

        @Override // android.support.v4.media.MediaBrowserServiceCompatApi21.ServiceCallbacks
        public void onConnect(String root, Object session, Bundle extras) throws RemoteException {
            this.mCallbacks.onConnect(root, session, extras);
        }

        @Override // android.support.v4.media.MediaBrowserServiceCompatApi21.ServiceCallbacks
        public void onConnectFailed() throws RemoteException {
            this.mCallbacks.onConnectFailed();
        }

        @Override // android.support.v4.media.MediaBrowserServiceCompatApi21.ServiceCallbacks
        public void onLoadChildren(String mediaId, List<Parcel> list) throws RemoteException {
            Object pls;
            ArrayList arrayList = null;
            if (list != null) {
                arrayList = new ArrayList();
                for (Parcel parcel : list) {
                    parcel.setDataPosition(0);
                    arrayList.add(MediaBrowser.MediaItem.CREATOR.createFromParcel(parcel));
                    parcel.recycle();
                }
            }
            if (Build.VERSION.SDK_INT > 23) {
                pls = arrayList == null ? null : ParceledListSliceAdapterApi21.newInstance(arrayList);
            } else {
                pls = arrayList == null ? sNullParceledListSliceObj : ParceledListSliceAdapterApi21.newInstance(arrayList);
            }
            this.mCallbacks.onLoadChildren(mediaId, pls);
        }
    }

    static class MediaBrowserServiceAdaptorApi21 {
        ServiceBinderProxyApi21 mBinder;

        MediaBrowserServiceAdaptorApi21() {
        }

        public void onCreate(ServiceImplApi21 serviceImpl) {
            this.mBinder = new ServiceBinderProxyApi21(serviceImpl);
        }

        public IBinder onBind(Intent intent) {
            if (MediaBrowserServiceCompat.SERVICE_INTERFACE.equals(intent.getAction())) {
                return this.mBinder;
            }
            return null;
        }

        static class ServiceBinderProxyApi21 extends IMediaBrowserServiceAdapterApi21.Stub {
            final ServiceImplApi21 mServiceImpl;

            ServiceBinderProxyApi21(ServiceImplApi21 serviceImpl) {
                this.mServiceImpl = serviceImpl;
            }

            @Override // android.support.v4.media.IMediaBrowserServiceAdapterApi21.Stub
            public void connect(String pkg, Bundle rootHints, Object callbacks) {
                this.mServiceImpl.connect(pkg, rootHints, new ServiceCallbacksApi21(callbacks));
            }

            @Override // android.support.v4.media.IMediaBrowserServiceAdapterApi21.Stub
            public void disconnect(Object callbacks) {
                this.mServiceImpl.disconnect(new ServiceCallbacksApi21(callbacks));
            }

            @Override // android.support.v4.media.IMediaBrowserServiceAdapterApi21.Stub
            public void addSubscription(String id, Object callbacks) {
                this.mServiceImpl.addSubscription(id, new ServiceCallbacksApi21(callbacks));
            }

            @Override // android.support.v4.media.IMediaBrowserServiceAdapterApi21.Stub
            public void removeSubscription(String id, Object callbacks) {
                this.mServiceImpl.removeSubscription(id, new ServiceCallbacksApi21(callbacks));
            }

            @Override // android.support.v4.media.IMediaBrowserServiceAdapterApi21.Stub
            public void getMediaItem(String mediaId, ResultReceiver receiver) {
            }
        }
    }
}
