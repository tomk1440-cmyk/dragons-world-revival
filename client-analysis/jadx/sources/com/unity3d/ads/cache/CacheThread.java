package com.unity3d.ads.cache;

import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.facebook.share.internal.ShareConstants;
import com.unity3d.ads.log.DeviceLog;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CacheThread extends Thread {
    public static final int MSG_DOWNLOAD = 1;
    private static CacheThreadHandler _handler = null;
    private static boolean _ready = false;
    private static final Object _readyLock = new Object();
    private static int _connectTimeout = 30000;
    private static int _readTimeout = 30000;
    private static int _progressInterval = 0;

    private static void init() {
        CacheThread thread = new CacheThread();
        thread.setName("UnityAdsCacheThread");
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
        _handler = new CacheThreadHandler();
        _ready = true;
        synchronized (_readyLock) {
            _readyLock.notify();
        }
        Looper.loop();
    }

    public static synchronized void download(String source, String target, HashMap<String, List<String>> headers) {
        if (!_ready) {
            init();
        }
        Bundle params = new Bundle();
        params.putString(ShareConstants.FEED_SOURCE_PARAM, source);
        params.putString("target", target);
        params.putInt("connectTimeout", _connectTimeout);
        params.putInt("readTimeout", _readTimeout);
        params.putInt("progressInterval", _progressInterval);
        if (headers != null) {
            for (String s : headers.keySet()) {
                String[] h = new String[headers.get(s).size()];
                params.putStringArray(s, (String[]) headers.get(s).toArray(h));
            }
        }
        Message msg = new Message();
        msg.what = 1;
        msg.setData(params);
        _handler.setCancelStatus(false);
        _handler.sendMessage(msg);
    }

    public static boolean isActive() {
        if (_ready) {
            return _handler.isActive();
        }
        return false;
    }

    public static void cancel() {
        if (_ready) {
            _handler.removeMessages(1);
            _handler.setCancelStatus(true);
        }
    }

    public static void setProgressInterval(int interval) {
        _progressInterval = interval;
    }

    public static int getProgressInterval() {
        return _progressInterval;
    }

    public static void setConnectTimeout(int connectTimeout) {
        _connectTimeout = connectTimeout;
    }

    public static void setReadTimeout(int readTimeout) {
        _readTimeout = readTimeout;
    }

    public static int getConnectTimeout() {
        return _connectTimeout;
    }

    public static int getReadTimeout() {
        return _readTimeout;
    }
}
