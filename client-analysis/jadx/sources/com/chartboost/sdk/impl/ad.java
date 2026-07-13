package com.chartboost.sdk.impl;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
class ad extends ac {
    private bf<ah> a = new bf<>();

    ad() {
    }

    void a(Class cls, ah ahVar) {
        this.a.a(cls, ahVar);
    }

    @Override // com.chartboost.sdk.impl.ah
    public void a(Object obj, StringBuilder sb) {
        Object objA = z.a(obj);
        if (objA == null) {
            sb.append(" null ");
            return;
        }
        ah ahVarA = null;
        Iterator<Class<?>> it = bf.a((Class) objA.getClass()).iterator();
        while (it.hasNext()) {
            ahVarA = this.a.a(it.next());
            if (ahVarA != null) {
                break;
            }
        }
        if (ahVarA == null && objA.getClass().isArray()) {
            ahVarA = this.a.a((Object) Object[].class);
        }
        if (ahVarA == null) {
            throw new RuntimeException("json can't serialize type : " + objA.getClass());
        }
        ahVarA.a(objA, sb);
    }
}
