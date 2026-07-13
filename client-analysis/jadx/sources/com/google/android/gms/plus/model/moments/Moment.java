package com.google.android.gms.plus.model.moments;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.plus.internal.model.moments.ItemScopeEntity;
import com.google.android.gms.plus.internal.model.moments.MomentEntity;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public interface Moment extends Freezable<Moment> {

    public static class Builder {
        private String zzJN;
        private final Set<Integer> zzbeN = new HashSet();
        private String zzbfA;
        private ItemScopeEntity zzbfI;
        private ItemScopeEntity zzbfJ;
        private String zzyv;

        public Moment build() {
            return new MomentEntity(this.zzbeN, this.zzyv, this.zzbfI, this.zzbfA, this.zzbfJ, this.zzJN);
        }

        public Builder setId(String id) {
            this.zzyv = id;
            this.zzbeN.add(2);
            return this;
        }

        public Builder setResult(ItemScope result) {
            this.zzbfI = (ItemScopeEntity) result;
            this.zzbeN.add(4);
            return this;
        }

        public Builder setStartDate(String startDate) {
            this.zzbfA = startDate;
            this.zzbeN.add(5);
            return this;
        }

        public Builder setTarget(ItemScope target) {
            this.zzbfJ = (ItemScopeEntity) target;
            this.zzbeN.add(6);
            return this;
        }

        public Builder setType(String type) {
            this.zzJN = type;
            this.zzbeN.add(7);
            return this;
        }
    }

    String getId();

    ItemScope getResult();

    String getStartDate();

    ItemScope getTarget();

    String getType();

    boolean hasId();

    boolean hasResult();

    boolean hasStartDate();

    boolean hasTarget();

    boolean hasType();
}
