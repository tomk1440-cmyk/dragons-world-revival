package com.google.android.gms.drive.internal;

import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

/* JADX INFO: loaded from: classes.dex */
public final class zzp extends Metadata {
    private final MetadataBundle zzaqB;

    public zzp(MetadataBundle metadataBundle) {
        this.zzaqB = metadataBundle;
    }

    @Override // com.google.android.gms.common.data.Freezable
    public boolean isDataValid() {
        return this.zzaqB != null;
    }

    public String toString() {
        return "Metadata [mImpl=" + this.zzaqB + "]";
    }

    @Override // com.google.android.gms.drive.Metadata
    public <T> T zza(MetadataField<T> metadataField) {
        return (T) this.zzaqB.zza(metadataField);
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* JADX INFO: renamed from: zzsK, reason: merged with bridge method [inline-methods] */
    public Metadata freeze() {
        return new zzp(this.zzaqB.zztF());
    }
}
