package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;

/* JADX INFO: loaded from: classes.dex */
public class zzp extends com.google.android.gms.drive.metadata.zza<String> {
    public zzp(String str, int i) {
        super(str, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.drive.metadata.zza
    /* JADX INFO: renamed from: zzd, reason: merged with bridge method [inline-methods] */
    public void zza(Bundle bundle, String str) {
        bundle.putString(getName(), str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.drive.metadata.zza
    /* JADX INFO: renamed from: zzi, reason: merged with bridge method [inline-methods] */
    public String zzc(DataHolder dataHolder, int i, int i2) {
        return dataHolder.zzd(getName(), i, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.drive.metadata.zza
    /* JADX INFO: renamed from: zzu, reason: merged with bridge method [inline-methods] */
    public String zzn(Bundle bundle) {
        return bundle.getString(getName());
    }
}
