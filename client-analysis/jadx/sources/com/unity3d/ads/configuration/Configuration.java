package com.unity3d.ads.configuration;

import com.unity3d.ads.log.DeviceLog;
import com.unity3d.ads.properties.SdkProperties;
import com.unity3d.ads.request.WebRequest;
import io.fabric.sdk.android.services.network.HttpRequest;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import java.net.MalformedURLException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class Configuration {
    private String _url;
    private Class[] _webAppApiClassList;
    private String _webViewData;
    private String _webViewHash;
    private String _webViewUrl;
    private String _webViewVersion;

    public Configuration() {
    }

    public Configuration(String configUrl) {
        this._url = configUrl;
    }

    public void setConfigUrl(String url) {
        this._url = url;
    }

    public String getConfigUrl() {
        return this._url;
    }

    public void setWebAppApiClassList(Class[] apiClassList) {
        this._webAppApiClassList = apiClassList;
    }

    public Class[] getWebAppApiClassList() {
        return this._webAppApiClassList;
    }

    public String getWebViewUrl() {
        return this._webViewUrl;
    }

    public void setWebViewUrl(String url) {
        this._webViewUrl = url;
    }

    public String getWebViewHash() {
        return this._webViewHash;
    }

    public void setWebViewHash(String hash) {
        this._webViewHash = hash;
    }

    public String getWebViewVersion() {
        return this._webViewVersion;
    }

    public String getWebViewData() {
        return this._webViewData;
    }

    public void setWebViewData(String data) {
        this._webViewData = data;
    }

    protected String buildQueryString() {
        String queryString = "?ts=" + System.currentTimeMillis() + "&sdkVersion=" + SdkProperties.getVersionCode() + "&sdkVersionName=" + SdkProperties.getVersionName();
        return queryString;
    }

    protected void makeRequest() throws Exception {
        if (this._url == null) {
            throw new MalformedURLException("Base URL is null");
        }
        String url = this._url + buildQueryString();
        DeviceLog.debug("Requesting configuration with: " + url);
        WebRequest request = new WebRequest(url, HttpRequest.METHOD_GET, null);
        String data = request.makeRequest();
        JSONObject config = new JSONObject(data);
        this._webViewUrl = config.getString("url");
        if (!config.isNull(SettingsJsonConstants.ICON_HASH_KEY)) {
            this._webViewHash = config.getString(SettingsJsonConstants.ICON_HASH_KEY);
        }
        if (config.has("version")) {
            this._webViewVersion = config.getString("version");
        }
        if (this._webViewUrl == null || this._webViewUrl.isEmpty()) {
            throw new MalformedURLException("Invalid data. Web view URL is null or empty");
        }
    }
}
