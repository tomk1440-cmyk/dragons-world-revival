package com.unity3d.ads.webview.bridge;

import android.os.Parcel;
import android.os.Parcelable;
import com.unity3d.ads.log.DeviceLog;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class WebViewCallback implements Parcelable {
    public static final Parcelable.Creator<WebViewCallback> CREATOR = new Parcelable.Creator<WebViewCallback>() { // from class: com.unity3d.ads.webview.bridge.WebViewCallback.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WebViewCallback createFromParcel(Parcel in) {
            return new WebViewCallback(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WebViewCallback[] newArray(int size) {
            return new WebViewCallback[size];
        }
    };
    private String _callbackId;
    private int _invocationId;
    private boolean _invoked;

    public WebViewCallback(String callbackId, int invocationId) {
        this._callbackId = callbackId;
        this._invocationId = invocationId;
    }

    public WebViewCallback(Parcel in) {
        this._callbackId = in.readString();
        this._invoked = in.readByte() != 0;
        this._invocationId = in.readInt();
    }

    public void invoke(Object... params) {
        invoke(CallbackStatus.OK, null, params);
    }

    private void invoke(CallbackStatus status, Enum error, Object... params) {
        if (!this._invoked && this._callbackId != null && this._callbackId.length() != 0) {
            this._invoked = true;
            ArrayList<Object> paramList = new ArrayList<>();
            paramList.addAll(Arrays.asList(params));
            paramList.add(0, this._callbackId);
            Invocation invocation = Invocation.getInvocationById(this._invocationId);
            if (invocation == null) {
                DeviceLog.error("Couldn't get batch with id: " + getInvocationId());
            } else {
                invocation.setInvocationResponse(status, error, paramList.toArray());
            }
        }
    }

    public void error(Enum error, Object... params) {
        invoke(CallbackStatus.ERROR, error, params);
    }

    public int getInvocationId() {
        return this._invocationId;
    }

    public String getCallbackId() {
        return this._callbackId;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 45678;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this._callbackId);
        dest.writeByte((byte) (this._invoked ? 1 : 0));
        dest.writeInt(this._invocationId);
    }
}
