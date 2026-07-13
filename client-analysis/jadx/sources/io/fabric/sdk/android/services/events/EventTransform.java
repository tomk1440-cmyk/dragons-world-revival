package io.fabric.sdk.android.services.events;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public interface EventTransform<T> {
    byte[] toBytes(T t) throws IOException;
}
