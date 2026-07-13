package com.google.android.gms.internal;

import android.content.Context;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzgb implements zzfz {
    private final Context mContext;
    final Set<WebView> zzFr = Collections.synchronizedSet(new HashSet());

    public zzgb(Context context) {
        this.mContext = context;
    }

    @Override // com.google.android.gms.internal.zzfz
    public void zza(String str, final String str2, final String str3) {
        zzin.zzaI("Fetching assets for the given html");
        zzir.zzMc.post(new Runnable() { // from class: com.google.android.gms.internal.zzgb.1
            @Override // java.lang.Runnable
            public void run() {
                final WebView webViewZzfR = zzgb.this.zzfR();
                webViewZzfR.setWebViewClient(new WebViewClient() { // from class: com.google.android.gms.internal.zzgb.1.1
                    @Override // android.webkit.WebViewClient
                    public void onPageFinished(WebView view, String url) {
                        zzin.zzaI("Loading assets have finished");
                        zzgb.this.zzFr.remove(webViewZzfR);
                    }

                    @Override // android.webkit.WebViewClient
                    public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                        zzin.zzaK("Loading assets have failed.");
                        zzgb.this.zzFr.remove(webViewZzfR);
                    }
                });
                zzgb.this.zzFr.add(webViewZzfR);
                webViewZzfR.loadDataWithBaseURL(str2, str3, "text/html", "UTF-8", null);
                zzin.zzaI("Fetching assets finished.");
            }
        });
    }

    public WebView zzfR() {
        WebView webView = new WebView(this.mContext);
        webView.getSettings().setJavaScriptEnabled(true);
        return webView;
    }
}
