package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import android.os.Parcelable;
import java.util.Collection;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzk<T extends Parcelable> extends com.google.android.gms.drive.metadata.zza<T> {
    public zzk(String str, Collection<String> collection, Collection<String> collection2, int i) {
        super(str, collection, collection2, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.drive.metadata.zza
    public void zza(Bundle bundle, T t) {
        bundle.putParcelable(getName(), t);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.drive.metadata.zza
    /* JADX INFO: renamed from: zzt, reason: merged with bridge method [inline-methods] */
    public T zzn(Bundle bundle) {
        return (T) bundle.getParcelable(getName());
    }
}
