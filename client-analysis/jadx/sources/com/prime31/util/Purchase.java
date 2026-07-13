package com.prime31.util;

import com.unity3d.ads.metadata.InAppPurchaseMetaData;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class Purchase {
    String _developerPayload;
    String _itemType;
    String _orderId;
    String _originalJson;
    String _originalJsonWithSignature;
    String _packageName;
    int _purchaseState;
    long _purchaseTime;
    String _signature;
    String _sku;
    String _token;

    public Purchase(String itemType, String jsonPurchaseInfo, String signature) throws JSONException {
        this._itemType = itemType;
        this._originalJson = jsonPurchaseInfo;
        JSONObject o = new JSONObject(this._originalJson);
        this._orderId = o.optString("orderId");
        this._packageName = o.optString("packageName");
        this._sku = o.optString(InAppPurchaseMetaData.KEY_PRODUCT_ID);
        this._purchaseTime = o.optLong("purchaseTime");
        this._purchaseState = o.optInt("purchaseState");
        this._developerPayload = o.optString("developerPayload");
        this._token = o.optString("token", o.optString("purchaseToken"));
        signature = signature == null ? "NO SIGNATURE RETURNED FROM PLAY" : signature;
        o.put(InAppPurchaseMetaData.KEY_SIGNATURE, signature);
        o.put("originalJson", this._originalJson);
        o.put("itemType", itemType);
        this._originalJsonWithSignature = o.toString();
        this._signature = signature;
    }

    public String getItemType() {
        return this._itemType;
    }

    public String getOrderId() {
        return this._orderId;
    }

    public String getPackageName() {
        return this._packageName;
    }

    public String getSku() {
        return this._sku;
    }

    public long getPurchaseTime() {
        return this._purchaseTime;
    }

    public int getPurchaseState() {
        return this._purchaseState;
    }

    public String getDeveloperPayload() {
        return this._developerPayload;
    }

    public String getToken() {
        return this._token;
    }

    public boolean isTestSku() {
        return this._sku.startsWith("android.test");
    }

    public String getOriginalJson() {
        return this._originalJson;
    }

    public String getSignature() {
        return this._signature;
    }

    public String toString() {
        return "PurchaseInfo:" + this._originalJson;
    }

    public String toJson() {
        return this._originalJsonWithSignature;
    }
}
