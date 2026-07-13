package com.unity3d.ads.request;

import android.os.Bundle;
import android.os.ConditionVariable;
import android.os.Looper;
import android.os.Message;
import com.facebook.share.internal.ShareConstants;
import com.unity3d.ads.log.DeviceLog;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class WebRequestThread extends Thread {
    protected static final int MSG_REQUEST = 1;
    private static WebRequestHandler _handler;
    private static boolean _ready = false;
    private static final Object _readyLock = new Object();

    private static void init() {
        WebRequestThread thread = new WebRequestThread();
        thread.setName("UnityAdsWebRequestThread");
        thread.start();
        while (!_ready) {
            try {
                synchronized (_readyLock) {
                    try {
                        _readyLock.wait();
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (InterruptedException e) {
                DeviceLog.debug("Couldn't synchronize thread");
            }
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Looper.prepare();
        if (_handler == null) {
            _handler = new WebRequestHandler();
        }
        _ready = true;
        synchronized (_readyLock) {
            _readyLock.notify();
        }
        Looper.loop();
    }

    public static void cancel() {
        if (_handler != null) {
            _handler.removeMessages(1);
            _handler.setCancelStatus(true);
        }
    }

    public static synchronized void request(String url, WebRequest.RequestType requestType, Map<String, List<String>> headers, Integer connectTimeout, Integer readTimeout, IWebRequestListener listener) {
        request(url, requestType, headers, null, connectTimeout, readTimeout, listener);
    }

    public static synchronized void request(String url, WebRequest.RequestType requestType, Map<String, List<String>> headers, String requestBody, Integer connectTimeout, Integer readTimeout, IWebRequestListener listener) {
        request(1, url, requestType, headers, requestBody, connectTimeout, readTimeout, listener, new WebRequestResultReceiver(_handler, listener));
    }

    public static synchronized void request(int msgWhat, String url, WebRequest.RequestType requestType, Map<String, List<String>> headers, String requestBody, Integer connectTimeout, Integer readTimeout, IWebRequestListener listener, WebRequestResultReceiver receiver) {
        if (!_ready) {
            init();
        }
        if (url == null || url.length() < 3) {
            listener.onFailed(url, "Request is NULL or too short");
        } else {
            Bundle params = new Bundle();
            params.putString("url", url);
            params.putString(ShareConstants.MEDIA_TYPE, requestType.name());
            params.putString("body", requestBody);
            params.putParcelable("receiver", receiver);
            params.putInt("connectTimeout", connectTimeout.intValue());
            params.putInt("readTimeout", readTimeout.intValue());
            if (headers != null) {
                for (String s : headers.keySet()) {
                    String[] h = new String[headers.get(s).size()];
                    params.putStringArray(s, (String[]) headers.get(s).toArray(h));
                }
            }
            Message msg = new Message();
            msg.what = msgWhat;
            msg.setData(params);
            _handler.setCancelStatus(false);
            _handler.sendMessage(msg);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x000c A[Catch: all -> 0x0025, TRY_LEAVE, TryCatch #0 {, blocks: (B:5:0x0005, B:11:0x0016, B:7:0x000c), top: B:16:0x0005 }] */
    public static synchronized boolean resolve(final String host, final IResolveHostListener listener) {
        boolean z;
        if (host == null) {
            listener.onFailed(host, ResolveHostError.INVALID_HOST, "Host is NULL");
            z = false;
        } else if (host.length() < 3) {
            listener.onFailed(host, ResolveHostError.INVALID_HOST, "Host is NULL");
            z = false;
        } else {
            new Thread(new Runnable() { // from class: com.unity3d.ads.request.WebRequestThread.1
                @Override // java.lang.Runnable
                public void run() {
                    final ConditionVariable cv = new ConditionVariable();
                    Thread t = null;
                    try {
                        Thread t2 = new Thread(new Runnable() { // from class: com.unity3d.ads.request.WebRequestThread.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    InetAddress address = InetAddress.getByName(host);
                                    String strAddress = address.getHostAddress();
                                    listener.onResolve(host, strAddress);
                                } catch (UnknownHostException e) {
                                    DeviceLog.exception("Unknown host", e);
                                    listener.onFailed(host, ResolveHostError.UNKNOWN_HOST, e.getMessage());
                                }
                                cv.open();
                            }
                        });
                        try {
                            t2.start();
                            t = t2;
                        } catch (Exception e) {
                            e = e;
                            t = t2;
                            DeviceLog.exception("Exception while resolving host", e);
                            listener.onFailed(host, ResolveHostError.UNEXPECTED_EXCEPTION, e.getMessage());
                        }
                    } catch (Exception e2) {
                        e = e2;
                    }
                    boolean success = cv.block(20000L);
                    if (!success && t != null) {
                        t.interrupt();
                        listener.onFailed(host, ResolveHostError.TIMEOUT, "Timeout");
                    }
                }
            }).start();
            z = true;
        }
        throw th;
        return z;
    }
}
