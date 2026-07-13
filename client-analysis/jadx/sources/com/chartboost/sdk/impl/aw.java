package com.chartboost.sdk.impl;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class aw implements Serializable {
    final String a;

    public String a() {
        return this.a;
    }

    public boolean equals(Object o) {
        if (!(o instanceof aw)) {
            return false;
        }
        return this.a.equals(((aw) o).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return a();
    }
}
