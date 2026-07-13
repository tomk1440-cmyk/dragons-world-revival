package com.google.android.gms.internal;

import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.ecommerce.Promotion;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzpt extends com.google.android.gms.measurement.zze<zzpt> {
    private ProductAction zzPn;
    private final List<Product> zzPq = new ArrayList();
    private final List<Promotion> zzPp = new ArrayList();
    private final Map<String, List<Product>> zzPo = new HashMap();

    public String toString() {
        HashMap map = new HashMap();
        if (!this.zzPq.isEmpty()) {
            map.put("products", this.zzPq);
        }
        if (!this.zzPp.isEmpty()) {
            map.put("promotions", this.zzPp);
        }
        if (!this.zzPo.isEmpty()) {
            map.put("impressions", this.zzPo);
        }
        map.put("productAction", this.zzPn);
        return zzF(map);
    }

    public ProductAction zzAV() {
        return this.zzPn;
    }

    public List<Product> zzAW() {
        return Collections.unmodifiableList(this.zzPq);
    }

    public Map<String, List<Product>> zzAX() {
        return this.zzPo;
    }

    public List<Promotion> zzAY() {
        return Collections.unmodifiableList(this.zzPp);
    }

    public void zza(Product product, String str) {
        if (product == null) {
            return;
        }
        if (str == null) {
            str = "";
        }
        if (!this.zzPo.containsKey(str)) {
            this.zzPo.put(str, new ArrayList());
        }
        this.zzPo.get(str).add(product);
    }

    @Override // com.google.android.gms.measurement.zze
    public void zza(zzpt zzptVar) {
        zzptVar.zzPq.addAll(this.zzPq);
        zzptVar.zzPp.addAll(this.zzPp);
        for (Map.Entry<String, List<Product>> entry : this.zzPo.entrySet()) {
            String key = entry.getKey();
            Iterator<Product> it = entry.getValue().iterator();
            while (it.hasNext()) {
                zzptVar.zza(it.next(), key);
            }
        }
        if (this.zzPn != null) {
            zzptVar.zzPn = this.zzPn;
        }
    }
}
