package com.google.android.gms.internal;

import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.net.URI;
import java.net.URISyntaxException;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzjy extends WebViewClient {
    private final zzgo zzGs;
    private final String zzOl;
    private boolean zzOm = false;
    private final zzjp zzpD;

    public zzjy(zzgo zzgoVar, zzjp zzjpVar, String str) {
        this.zzOl = zzaR(str);
        this.zzpD = zzjpVar;
        this.zzGs = zzgoVar;
    }

    private String zzaR(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return str.endsWith("/") ? str.substring(0, str.length() - 1) : str;
        } catch (IndexOutOfBoundsException e) {
            zzin.e(e.getMessage());
            return str;
        }
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView view, String url) {
        zzin.zzaI("JavascriptAdWebViewClient::onLoadResource: " + url);
        if (zzaQ(url)) {
            return;
        }
        this.zzpD.zzhU().onLoadResource(this.zzpD.getWebView(), url);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView view, String url) {
        zzin.zzaI("JavascriptAdWebViewClient::onPageFinished: " + url);
        if (this.zzOm) {
            return;
        }
        this.zzGs.zzge();
        this.zzOm = true;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        zzin.zzaI("JavascriptAdWebViewClient::shouldOverrideUrlLoading: " + url);
        if (!zzaQ(url)) {
            return this.zzpD.zzhU().shouldOverrideUrlLoading(this.zzpD.getWebView(), url);
        }
        zzin.zzaI("shouldOverrideUrlLoading: received passback url");
        return true;
    }

    protected boolean zzaQ(String str) {
        boolean z = false;
        String strZzaR = zzaR(str);
        if (!TextUtils.isEmpty(strZzaR)) {
            try {
                URI uri = new URI(strZzaR);
                if ("passback".equals(uri.getScheme())) {
                    zzin.zzaI("Passback received");
                    this.zzGs.zzgf();
                    z = true;
                } else if (!TextUtils.isEmpty(this.zzOl)) {
                    URI uri2 = new URI(this.zzOl);
                    String host = uri2.getHost();
                    String host2 = uri.getHost();
                    String path = uri2.getPath();
                    String path2 = uri.getPath();
                    if (com.google.android.gms.common.internal.zzw.equal(host, host2) && com.google.android.gms.common.internal.zzw.equal(path, path2)) {
                        zzin.zzaI("Passback received");
                        this.zzGs.zzgf();
                        z = true;
                    }
                }
            } catch (URISyntaxException e) {
                zzin.e(e.getMessage());
            }
        }
        return z;
    }
}
