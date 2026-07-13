package com.chartboost.sdk.impl;

/* JADX INFO: loaded from: classes.dex */
public class ax extends aw {
    final al b;

    public al b() {
        return this.b;
    }

    @Override // com.chartboost.sdk.impl.aw
    public boolean equals(Object o) {
        if (!(o instanceof ax)) {
            return false;
        }
        ax axVar = (ax) o;
        return this.a.equals(axVar.a) && this.b.equals(axVar.b);
    }

    @Override // com.chartboost.sdk.impl.aw
    public int hashCode() {
        return this.a.hashCode() ^ this.b.hashCode();
    }
}
