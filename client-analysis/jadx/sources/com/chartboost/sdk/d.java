package com.chartboost.sdk;

import com.chartboost.sdk.impl.j;
import com.chartboost.sdk.impl.k;
import com.facebook.share.internal.ShareConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
final class d {
    private static d a = null;
    private j b = new j("https://www.chartboost.com", null);

    private static d a() {
        if (a == null) {
            a = new d();
        }
        return a;
    }

    private d() {
    }

    protected static void a(String str, Chartboost.CBAPIResponseCallback cBAPIResponseCallback) {
        k kVar = new k("api/get");
        kVar.a("raw", (Object) 1);
        kVar.a("cache", (Object) 1);
        if (str != null) {
            kVar.a("location", (Object) str);
        }
        a().a(kVar, cBAPIResponseCallback);
    }

    protected static void a(String str, int i, Chartboost.CBAPIResponseCallback cBAPIResponseCallback) {
        k kVar = new k("api/get_batch");
        kVar.a("raw", (Object) 1);
        kVar.a("cache", (Object) 1);
        if (str != null) {
            kVar.a("location", (Object) str);
        }
        if (i > 10) {
            i = 10;
        }
        kVar.a("amount", Integer.valueOf(i));
        a().a(kVar, cBAPIResponseCallback);
    }

    protected static void b(String str, Chartboost.CBAPIResponseCallback cBAPIResponseCallback) {
        k kVar = new k("api/show");
        kVar.a("ad_id", (Object) str);
        a().a(kVar, cBAPIResponseCallback);
    }

    protected static void a(Chartboost.CBAPIResponseCallback cBAPIResponseCallback) {
        k kVar = new k("api/more");
        kVar.a("format", (Object) ShareConstants.WEB_DIALOG_PARAM_DATA);
        a().a(kVar, cBAPIResponseCallback);
    }

    private void a(k kVar, final Chartboost.CBAPIResponseCallback cBAPIResponseCallback) {
        Chartboost chartboostSharedChartboost = Chartboost.sharedChartboost();
        kVar.a(chartboostSharedChartboost.a.b());
        kVar.b(chartboostSharedChartboost.getAppID(), chartboostSharedChartboost.getAppSignature());
        this.b.a(kVar, new j.b() { // from class: com.chartboost.sdk.d.1
            @Override // com.chartboost.sdk.impl.j.b
            public void a(JSONObject jSONObject, k kVar2) {
                if (cBAPIResponseCallback != null) {
                    cBAPIResponseCallback.onSuccess(jSONObject);
                }
            }

            @Override // com.chartboost.sdk.impl.j.b
            public void a(k kVar2, String str) {
                if (cBAPIResponseCallback != null) {
                    cBAPIResponseCallback.onFailure(str);
                }
            }
        });
    }
}
