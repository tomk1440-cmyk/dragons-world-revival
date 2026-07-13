package com.chartboost.sdk.Analytics;

import com.chartboost.sdk.Chartboost;
import com.chartboost.sdk.Libraries.d;
import com.chartboost.sdk.impl.j;
import com.chartboost.sdk.impl.k;
import com.unity3d.ads.metadata.InAppPurchaseMetaData;
import java.math.BigDecimal;
import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
public class CBAnalytics {
    public static final String TAG = "Chartboost Analytics";
    private static CBAnalytics a = null;
    private j b = new j(null, "CBAnalytics");

    public static synchronized CBAnalytics sharedAnalytics() {
        if (a == null) {
            a = new CBAnalytics();
        }
        return a;
    }

    private CBAnalytics() {
        this.b.a();
    }

    private String a(double d, int i, int i2) {
        return new StringBuilder(String.valueOf(new BigDecimal(d).setScale(i, i2).doubleValue())).toString();
    }

    public Boolean recordPaymentTransaction(String sku, String title, double price, String currency, int quantity, Object meta) {
        Chartboost chartboostSharedChartboost = Chartboost.sharedChartboost();
        if (chartboostSharedChartboost.getContext() == null) {
            throw new IllegalStateException("The context must be set through the Chartboost method onCreate() before calling recordPaymentTransaction().");
        }
        if (chartboostSharedChartboost.getAppID() == null || chartboostSharedChartboost.getAppSignature() == null) {
            return false;
        }
        k kVar = new k("api/purchase");
        kVar.a(chartboostSharedChartboost.getContext());
        kVar.a("product_id", (Object) sku);
        kVar.a("title", (Object) title);
        kVar.a(InAppPurchaseMetaData.KEY_PRICE, (Object) a(price, 2, 4));
        kVar.a(InAppPurchaseMetaData.KEY_CURRENCY, (Object) currency);
        kVar.a("quantity", (Object) new StringBuilder(String.valueOf(quantity)).toString());
        kVar.a("timestamp", Integer.valueOf(Long.valueOf(new Date().getTime() / 1000).intValue()));
        if (meta != null) {
            kVar.a("meta", d.a(meta));
        }
        kVar.b(chartboostSharedChartboost.getAppID(), chartboostSharedChartboost.getAppSignature());
        this.b.a(kVar);
        return true;
    }

    public Boolean trackEvent(String eventIdentifier) {
        return trackEvent(eventIdentifier, 1.0d, null);
    }

    public Boolean trackEvent(String eventIdentifier, double value) {
        return trackEvent(eventIdentifier, value, null);
    }

    public Boolean trackEvent(String eventIdentifier, double value, Object meta) {
        Chartboost chartboostSharedChartboost = Chartboost.sharedChartboost();
        if (chartboostSharedChartboost.getContext() == null) {
            throw new IllegalStateException("The context must be set through the Chartboost method onCreate() before calling trackEvent().");
        }
        if (chartboostSharedChartboost.getAppID() == null || chartboostSharedChartboost.getAppSignature() == null) {
            return false;
        }
        k kVar = new k("api/event");
        kVar.a(chartboostSharedChartboost.getContext());
        kVar.a("key", (Object) eventIdentifier);
        kVar.a("value", (Object) new StringBuilder(String.valueOf(value)).toString());
        kVar.a("timestamp", (Object) new StringBuilder(String.valueOf(System.currentTimeMillis() / 1000.0d)).toString());
        if (meta != null) {
            kVar.a("meta", d.a(meta));
        }
        kVar.b(chartboostSharedChartboost.getAppID(), chartboostSharedChartboost.getAppSignature());
        kVar.a(true);
        this.b.a(kVar);
        return true;
    }
}
