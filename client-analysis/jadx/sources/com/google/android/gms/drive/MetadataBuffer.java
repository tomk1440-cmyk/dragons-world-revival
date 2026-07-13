package com.google.android.gms.drive;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.internal.zzp;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.zznm;

/* JADX INFO: loaded from: classes.dex */
public final class MetadataBuffer extends AbstractDataBuffer<Metadata> {
    private zza zzapb;

    private static class zza extends Metadata {
        private final DataHolder zzahi;
        private final int zzajf;
        private final int zzapc;

        public zza(DataHolder dataHolder, int i) {
            this.zzahi = dataHolder;
            this.zzapc = i;
            this.zzajf = dataHolder.zzbH(i);
        }

        @Override // com.google.android.gms.common.data.Freezable
        public boolean isDataValid() {
            return !this.zzahi.isClosed();
        }

        @Override // com.google.android.gms.drive.Metadata
        public <T> T zza(MetadataField<T> metadataField) {
            return metadataField.zza(this.zzahi, this.zzapc, this.zzajf);
        }

        @Override // com.google.android.gms.common.data.Freezable
        /* JADX INFO: renamed from: zzsK, reason: merged with bridge method [inline-methods] */
        public Metadata freeze() {
            MetadataBundle metadataBundleZztE = MetadataBundle.zztE();
            for (MetadataField<?> metadataField : com.google.android.gms.drive.metadata.internal.zze.zztC()) {
                if (metadataField != zznm.zzatz) {
                    metadataField.zza(this.zzahi, metadataBundleZztE, this.zzapc, this.zzajf);
                }
            }
            return new zzp(metadataBundleZztE);
        }
    }

    public MetadataBuffer(DataHolder dataHolder) {
        super(dataHolder);
        dataHolder.zzpZ().setClassLoader(MetadataBuffer.class.getClassLoader());
    }

    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    public Metadata get(int row) {
        zza zzaVar = this.zzapb;
        if (zzaVar != null && zzaVar.zzapc == row) {
            return zzaVar;
        }
        zza zzaVar2 = new zza(this.zzahi, row);
        this.zzapb = zzaVar2;
        return zzaVar2;
    }

    @Deprecated
    public String getNextPageToken() {
        return null;
    }

    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer, com.google.android.gms.common.api.Releasable
    public void release() {
        if (this.zzahi != null) {
            com.google.android.gms.drive.metadata.internal.zze.zza(this.zzahi);
        }
        super.release();
    }
}
