package com.google.android.gms.nearby.messages;

import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.zzx;

/* JADX INFO: loaded from: classes.dex */
public final class PublishOptions {
    public static final PublishOptions DEFAULT = new Builder().build();
    private final Strategy zzbbI;

    @Nullable
    private final PublishCallback zzbbJ;

    public static class Builder {
        private Strategy zzbbI = Strategy.DEFAULT;

        @Nullable
        private PublishCallback zzbbJ;

        public PublishOptions build() {
            return new PublishOptions(this.zzbbI, this.zzbbJ);
        }

        public Builder setCallback(PublishCallback callback) {
            this.zzbbJ = (PublishCallback) zzx.zzz(callback);
            return this;
        }

        public Builder setStrategy(Strategy strategy) {
            this.zzbbI = (Strategy) zzx.zzz(strategy);
            return this;
        }
    }

    private PublishOptions(Strategy strategy, @Nullable PublishCallback callback) {
        this.zzbbI = strategy;
        this.zzbbJ = callback;
    }

    @Nullable
    public PublishCallback getCallback() {
        return this.zzbbJ;
    }

    public Strategy getStrategy() {
        return this.zzbbI;
    }
}
