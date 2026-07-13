package com.unity3d.ads.request;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.facebook.share.internal.ShareConstants;
import com.unity3d.ads.log.DeviceLog;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class WebRequestHandler extends Handler {
    private boolean _canceled = false;
    private WebRequest _currentRequest;

    @Override // android.os.Handler
    public void handleMessage(Message msg) {
        Bundle data = msg.getData();
        String url = data.getString("url");
        data.remove("url");
        String type = data.getString(ShareConstants.MEDIA_TYPE);
        data.remove(ShareConstants.MEDIA_TYPE);
        String body = data.getString("body");
        data.remove("body");
        WebRequestResultReceiver receiver = (WebRequestResultReceiver) data.getParcelable("receiver");
        data.remove("receiver");
        int connectTimeout = data.getInt("connectTimeout");
        data.remove("connectTimeout");
        int readTimeout = data.getInt("readTimeout");
        data.remove("readTimeout");
        HashMap<String, List<String>> headers = null;
        if (data.size() > 0) {
            DeviceLog.debug("There are headers left in data, reading them");
            headers = new HashMap<>();
            for (String k : data.keySet()) {
                List<String> values = Arrays.asList(data.getStringArray(k));
                headers.put(k, values);
            }
        }
        if (msg.what == 1) {
            DeviceLog.debug("Handling request message: " + url + " type=" + type);
            try {
                makeRequest(url, type, headers, body, connectTimeout, readTimeout, receiver);
                return;
            } catch (MalformedURLException e) {
                DeviceLog.exception("Malformed URL", e);
                if (receiver != null) {
                    receiver.send(2, getBundleForFailResult(url, "Malformed URL", type, body));
                    return;
                }
                return;
            }
        }
        DeviceLog.error("No implementation for message: " + msg.what);
        if (receiver != null) {
            receiver.send(2, getBundleForFailResult(url, "Invalid Thread Message", type, body));
        }
    }

    public void setCancelStatus(boolean canceled) {
        this._canceled = canceled;
        if (this._canceled && this._currentRequest != null) {
            this._currentRequest.cancel();
        }
    }

    private void makeRequest(String url, String type, HashMap<String, List<String>> headers, String body, int connectTimeout, int readTimeout, WebRequestResultReceiver receiver) throws MalformedURLException {
        if (!this._canceled) {
            this._currentRequest = new WebRequest(url, type, headers, connectTimeout, readTimeout);
            if (body != null) {
                this._currentRequest.setBody(body);
            }
            try {
                String response = this._currentRequest.makeRequest();
                if (!this._currentRequest.isCanceled()) {
                    Bundle data = new Bundle();
                    data.putString("response", response);
                    data.putString("url", url);
                    data.putInt("responseCode", this._currentRequest.getResponseCode());
                    for (String key : this._currentRequest.getResponseHeaders().keySet()) {
                        if (key != null && !key.contentEquals("null")) {
                            String[] values = new String[this._currentRequest.getResponseHeaders().get(key).size()];
                            for (int valueidx = 0; valueidx < this._currentRequest.getResponseHeaders().get(key).size(); valueidx++) {
                                values[valueidx] = this._currentRequest.getResponseHeaders().get(key).get(valueidx);
                            }
                            data.putStringArray(key, values);
                        }
                    }
                    receiver.send(1, data);
                }
            } catch (NetworkIOException | IOException | IllegalStateException e) {
                DeviceLog.exception("Error completing request", e);
                receiver.send(2, getBundleForFailResult(url, e.getClass().getName() + ": " + e.getMessage(), type, body));
            }
        }
    }

    private Bundle getBundleForFailResult(String url, String error, String type, String body) {
        Bundle data = new Bundle();
        data.putString("url", url);
        data.putString("error", error);
        data.putString(ShareConstants.MEDIA_TYPE, type);
        data.putString("body", body);
        return data;
    }
}
