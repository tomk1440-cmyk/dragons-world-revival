package com.prime31.util;

import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class Inventory {
    protected static final String TAG = "Prime31-INV";
    Map<String, SkuDetails> mSkuMap = new HashMap();
    Map<String, Purchase> mPurchaseMap = new HashMap();

    Inventory() {
    }

    private JSONArray getAllSkusAsJson() {
        try {
            JSONArray json = new JSONArray();
            for (SkuDetails skuDetails : this.mSkuMap.values()) {
                json.put(new JSONObject(skuDetails.toJson()));
            }
            return json;
        } catch (JSONException e) {
            Log.i(TAG, "Error creating JSON from skus" + e.getMessage());
            return new JSONArray();
        }
    }

    private JSONArray getAllPurchasesAsJson() {
        try {
            JSONArray json = new JSONArray();
            for (Purchase p : this.mPurchaseMap.values()) {
                json.put(new JSONObject(p.toJson()));
            }
            return json;
        } catch (JSONException e) {
            Log.i(TAG, "Error creating JSON from skus" + e.getMessage());
            return new JSONArray();
        }
    }

    public String getAllSkusAndPurchasesAsJson() {
        try {
            JSONObject json = new JSONObject();
            json.put("purchases", getAllPurchasesAsJson());
            json.put("skus", getAllSkusAsJson());
            return json.toString();
        } catch (JSONException e) {
            Log.i(TAG, "Error creating JSON from skus" + e.getMessage());
            return "{}";
        }
    }

    public SkuDetails getSkuDetails(String sku) {
        return this.mSkuMap.get(sku);
    }

    public Purchase getPurchase(String sku) {
        return this.mPurchaseMap.get(sku);
    }

    public boolean hasPurchase(String sku) {
        return this.mPurchaseMap.containsKey(sku);
    }

    public boolean hasDetails(String sku) {
        return this.mSkuMap.containsKey(sku);
    }

    public void erasePurchase(String sku) {
        if (this.mPurchaseMap.containsKey(sku)) {
            this.mPurchaseMap.remove(sku);
        }
    }

    List<String> getAllOwnedSkus() {
        return new ArrayList(this.mPurchaseMap.keySet());
    }

    List<String> getAllOwnedSkus(String itemType) {
        List<String> result = new ArrayList<>();
        for (Purchase p : this.mPurchaseMap.values()) {
            if (p.getItemType().equals(itemType)) {
                result.add(p.getSku());
            }
        }
        return result;
    }

    public List<Purchase> getAllPurchases() {
        return new ArrayList(this.mPurchaseMap.values());
    }

    public List<SkuDetails> getAllSkuDetails() {
        return new ArrayList(this.mSkuMap.values());
    }

    void addSkuDetails(SkuDetails d) {
        this.mSkuMap.put(d.getSku(), d);
    }

    void addPurchase(Purchase p) {
        this.mPurchaseMap.put(p.getSku(), p);
    }
}
