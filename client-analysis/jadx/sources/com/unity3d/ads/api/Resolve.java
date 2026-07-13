package com.unity3d.ads.api;

import com.unity3d.ads.request.IResolveHostListener;
import com.unity3d.ads.request.ResolveHostError;
import com.unity3d.ads.request.ResolveHostEvent;
import com.unity3d.ads.request.WebRequestThread;
import com.unity3d.ads.webview.WebViewApp;
import com.unity3d.ads.webview.WebViewEventCategory;
import com.unity3d.ads.webview.bridge.WebViewCallback;
import com.unity3d.ads.webview.bridge.WebViewExposed;

/* JADX INFO: loaded from: classes.dex */
public class Resolve {
    @WebViewExposed
    public static void resolve(final String id, String host, WebViewCallback callback) {
        if (WebRequestThread.resolve(host, new IResolveHostListener() { // from class: com.unity3d.ads.api.Resolve.1
            @Override // com.unity3d.ads.request.IResolveHostListener
            public void onResolve(String host2, String address) {
                if (WebViewApp.getCurrentApp() != null) {
                    WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.RESOLVE, ResolveHostEvent.COMPLETE, id, host2, address);
                }
            }

            @Override // com.unity3d.ads.request.IResolveHostListener
            public void onFailed(String host2, ResolveHostError error, String errorMessage) {
                if (WebViewApp.getCurrentApp() != null) {
                    WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.RESOLVE, ResolveHostEvent.FAILED, id, host2, error.name(), errorMessage);
                }
            }
        })) {
            callback.invoke(id);
        } else {
            callback.error(ResolveHostError.INVALID_HOST, id);
        }
    }
}
