package android.support.v4.media;

import android.media.browse.MediaBrowser;
import android.os.Bundle;
import android.os.Parcel;
import android.os.ResultReceiver;
import android.service.media.MediaBrowserService;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
class MediaBrowserServiceCompatApi23 extends MediaBrowserServiceCompatApi21 {
    private static final String TAG = "MediaBrowserServiceCompatApi21";

    public interface ItemCallback {
        void onItemLoaded(int i, Bundle bundle, Parcel parcel);
    }

    public interface ServiceImplApi23 extends MediaBrowserServiceCompatApi21.ServiceImplApi21 {
        void getMediaItem(String str, ItemCallback itemCallback);
    }

    MediaBrowserServiceCompatApi23() {
    }

    public static Object createService() {
        return new MediaBrowserServiceAdaptorApi23();
    }

    public static void onCreate(Object serviceObj, ServiceImplApi23 serviceImpl) {
        ((MediaBrowserServiceAdaptorApi23) serviceObj).onCreate(serviceImpl);
    }

    static class MediaBrowserServiceAdaptorApi23 extends MediaBrowserServiceCompatApi21.MediaBrowserServiceAdaptorApi21 {
        MediaBrowserServiceAdaptorApi23() {
        }

        public void onCreate(ServiceImplApi23 serviceImpl) {
            this.mBinder = new ServiceBinderProxyApi23(serviceImpl);
        }

        private static class ServiceBinderProxyApi23 extends MediaBrowserServiceCompatApi21.MediaBrowserServiceAdaptorApi21.ServiceBinderProxyApi21 {
            ServiceImplApi23 mServiceImpl;

            ServiceBinderProxyApi23(ServiceImplApi23 serviceImpl) {
                super(serviceImpl);
                this.mServiceImpl = serviceImpl;
            }

            @Override // android.support.v4.media.MediaBrowserServiceCompatApi21.MediaBrowserServiceAdaptorApi21.ServiceBinderProxyApi21, android.support.v4.media.IMediaBrowserServiceAdapterApi21.Stub
            public void getMediaItem(String mediaId, final ResultReceiver receiver) {
                try {
                    final String KEY_MEDIA_ITEM = (String) MediaBrowserService.class.getDeclaredField("KEY_MEDIA_ITEM").get(null);
                    this.mServiceImpl.getMediaItem(mediaId, new ItemCallback() { // from class: android.support.v4.media.MediaBrowserServiceCompatApi23.MediaBrowserServiceAdaptorApi23.ServiceBinderProxyApi23.1
                        @Override // android.support.v4.media.MediaBrowserServiceCompatApi23.ItemCallback
                        public void onItemLoaded(int resultCode, Bundle resultData, Parcel itemParcel) {
                            if (itemParcel != null) {
                                itemParcel.setDataPosition(0);
                                MediaBrowser.MediaItem item = (MediaBrowser.MediaItem) MediaBrowser.MediaItem.CREATOR.createFromParcel(itemParcel);
                                resultData.putParcelable(KEY_MEDIA_ITEM, item);
                                itemParcel.recycle();
                            }
                            receiver.send(resultCode, resultData);
                        }
                    });
                } catch (IllegalAccessException | NoSuchFieldException e) {
                    Log.i(MediaBrowserServiceCompatApi23.TAG, "Failed to get KEY_MEDIA_ITEM via reflection", e);
                }
            }
        }
    }
}
