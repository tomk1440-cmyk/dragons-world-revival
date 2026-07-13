package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;

/* JADX INFO: loaded from: classes.dex */
public class zzf extends com.google.android.gms.drive.metadata.zza<Integer> {
    public zzf(String str, int i) {
        super(str, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.drive.metadata.zza
    public void zza(Bundle bundle, Integer num) {
        bundle.putInt(getName(), num.intValue());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.drive.metadata.zza
    /* JADX INFO: renamed from: zzg, reason: merged with bridge method [inline-methods] */
    public Integer zzc(DataHolder dataHolder, int i, int i2) {
        return Integer.valueOf(dataHolder.zzc(getName(), i, i2));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.drive.metadata.zza
    /* JADX INFO: renamed from: zzq, reason: merged with bridge method [inline-methods] */
    public Integer zzn(Bundle bundle) {
        return Integer.valueOf(bundle.getInt(getName()));
    }
}
