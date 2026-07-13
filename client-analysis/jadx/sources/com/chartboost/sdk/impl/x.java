package com.chartboost.sdk.impl;

import android.content.Context;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import com.google.android.gms.appinvite.PreviewActivity;
import java.net.URI;
import java.net.URLDecoder;
import org.json.JSONObject;
import org.json.JSONTokener;

/* JADX INFO: loaded from: classes.dex */
public class x extends com.chartboost.sdk.c {
    private String h;

    public class a extends com.chartboost.sdk.c.b {
        public WebView c;

        public a(Context context, String str) {
            super(context);
            setFocusable(false);
            this.c = x.this.new b(context);
            this.c.setWebViewClient(x.this.new c(x.this));
            addView(this.c);
            this.c.loadDataWithBaseURL("file:///android_asset/", str, "text/html", "utf-8", null);
        }

        @Override // com.chartboost.sdk.c.b
        protected void a(int i, int i2) {
        }
    }

    public x(com.chartboost.sdk.impl.a aVar) {
        super(aVar);
        this.h = null;
    }

    @Override // com.chartboost.sdk.c
    protected com.chartboost.sdk.c.b a(Context context) {
        return new a(context, this.h);
    }

    @Override // com.chartboost.sdk.c
    public void a(JSONObject jSONObject) {
        String strOptString = jSONObject.optString("html");
        if (strOptString != null) {
            this.h = strOptString;
            a();
        }
    }

    private class b extends WebView {
        public b(Context context) {
            super(context);
            setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            setBackgroundColor(0);
            getSettings().setJavaScriptEnabled(true);
        }

        @Override // android.webkit.WebView, android.view.View, android.view.KeyEvent.Callback
        public boolean onKeyDown(int keyCode, KeyEvent event) {
            if ((keyCode == 4 || keyCode == 3) && x.this.a != null) {
                x.this.a.a();
            }
            return super.onKeyDown(keyCode, event);
        }
    }

    private class c extends WebViewClient {
        private x b;

        public c(x xVar) {
            this.b = xVar;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            if (this.b == null || this.b.c == null) {
                return;
            }
            this.b.c.a();
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            if (this.b.d != null) {
                this.b.d.a();
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String url) {
            Exception e;
            String strDecode;
            JSONObject jSONObject;
            try {
                if (new URI(url).getScheme().equals("chartboost")) {
                    String[] strArrSplit = url.split("/");
                    Integer numValueOf = Integer.valueOf(strArrSplit.length);
                    if (numValueOf.intValue() < 3) {
                        if (this.b.a == null) {
                            return false;
                        }
                        this.b.a.a();
                        return false;
                    }
                    String str = strArrSplit[2];
                    if (str.equals(PreviewActivity.ON_CLICK_LISTENER_CLOSE)) {
                        if (this.b.a != null) {
                            this.b.a.a();
                        }
                    } else if (str.equals("link")) {
                        if (numValueOf.intValue() < 4) {
                            if (this.b.a == null) {
                                return false;
                            }
                            this.b.a.a();
                            return false;
                        }
                        try {
                            strDecode = URLDecoder.decode(strArrSplit[3], "UTF-8");
                            try {
                                jSONObject = numValueOf.intValue() > 4 ? new JSONObject(new JSONTokener(URLDecoder.decode(strArrSplit[4], "UTF-8"))) : null;
                            } catch (Exception e2) {
                                e = e2;
                                e.printStackTrace();
                            }
                        } catch (Exception e3) {
                            e = e3;
                            strDecode = null;
                        }
                        if (this.b.b != null) {
                            this.b.b.a(strDecode, jSONObject);
                        }
                    }
                }
                return true;
            } catch (Exception e4) {
                if (this.b.a == null) {
                    return false;
                }
                this.b.a.a();
                return false;
            }
        }
    }
}
