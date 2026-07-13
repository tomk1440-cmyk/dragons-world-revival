package com.google.android.gms.nearby.messages;

import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.zzx;

/* JADX INFO: loaded from: classes.dex */
public final class SubscribeOptions {
    public static final SubscribeOptions DEFAULT = new Builder().build();
    private final Strategy zzbbI;
    private final MessageFilter zzbbV;

    @Nullable
    private final SubscribeCallback zzbbW;

    public static class Builder {
        private Strategy zzbbI = Strategy.DEFAULT;
        private MessageFilter zzbbV = MessageFilter.INCLUDE_ALL_MY_TYPES;

        @Nullable
        private SubscribeCallback zzbbW;

        public SubscribeOptions build() {
            return new SubscribeOptions(this.zzbbI, this.zzbbV, this.zzbbW);
        }

        public Builder setCallback(SubscribeCallback callback) {
            this.zzbbW = (SubscribeCallback) zzx.zzz(callback);
            return this;
        }

        public Builder setFilter(MessageFilter filter) {
            this.zzbbV = filter;
            return this;
        }

        public Builder setStrategy(Strategy strategy) {
            this.zzbbI = strategy;
            return this;
        }
    }

    private SubscribeOptions(Strategy strategy, MessageFilter filter, @Nullable SubscribeCallback callback) {
        this.zzbbI = strategy;
        this.zzbbV = filter;
        this.zzbbW = callback;
    }

    @Nullable
    public SubscribeCallback getCallback() {
        return this.zzbbW;
    }

    public MessageFilter getFilter() {
        return this.zzbbV;
    }

    public Strategy getStrategy() {
        return this.zzbbI;
    }
}
