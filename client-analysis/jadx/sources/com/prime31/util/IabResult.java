package com.prime31.util;

/* JADX INFO: loaded from: classes.dex */
public class IabResult {
    String mMessage;
    int mResponse;

    public IabResult(int response, String message) {
        this.mResponse = response;
        if (message == null || message.trim().length() == 0) {
            this.mMessage = IabHelperImpl.getResponseDesc(response);
        } else {
            this.mMessage = String.valueOf(message) + " (response: " + IabHelperImpl.getResponseDesc(response) + ")";
        }
    }

    public int getResponse() {
        return this.mResponse;
    }

    public String getMessage() {
        return this.mMessage;
    }

    public boolean isSuccess() {
        return this.mResponse == 0;
    }

    public boolean isFailure() {
        return !isSuccess();
    }

    public boolean wasCanceled() {
        return this.mResponse == -1005;
    }

    public String toString() {
        return "IabResult: " + getMessage();
    }
}
