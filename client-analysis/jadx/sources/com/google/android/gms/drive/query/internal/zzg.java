package com.google.android.gms.drive.query.internal;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.query.Filter;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class zzg implements zzf<Boolean> {
    private Boolean zzaut = false;

    private zzg() {
    }

    public static boolean zza(Filter filter) {
        if (filter == null) {
            return false;
        }
        return ((Boolean) filter.zza(new zzg())).booleanValue();
    }

    @Override // com.google.android.gms.drive.query.internal.zzf
    public /* synthetic */ Boolean zzb(com.google.android.gms.drive.metadata.zzb zzbVar, Object obj) {
        return zzc((com.google.android.gms.drive.metadata.zzb<Object>) zzbVar, obj);
    }

    public <T> Boolean zzc(com.google.android.gms.drive.metadata.zzb<T> zzbVar, T t) {
        return this.zzaut;
    }

    @Override // com.google.android.gms.drive.query.internal.zzf
    /* JADX INFO: renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public <T> Boolean zzb(Operator operator, MetadataField<T> metadataField, T t) {
        return this.zzaut;
    }

    @Override // com.google.android.gms.drive.query.internal.zzf
    /* JADX INFO: renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public Boolean zzb(Operator operator, List<Boolean> list) {
        return this.zzaut;
    }

    @Override // com.google.android.gms.drive.query.internal.zzf
    /* JADX INFO: renamed from: zzd, reason: merged with bridge method [inline-methods] */
    public Boolean zzB(Boolean bool) {
        return this.zzaut;
    }

    @Override // com.google.android.gms.drive.query.internal.zzf
    /* JADX INFO: renamed from: zzdk, reason: merged with bridge method [inline-methods] */
    public Boolean zzdj(String str) {
        if (!str.isEmpty()) {
            this.zzaut = true;
        }
        return this.zzaut;
    }

    @Override // com.google.android.gms.drive.query.internal.zzf
    /* JADX INFO: renamed from: zzf, reason: merged with bridge method [inline-methods] */
    public Boolean zze(MetadataField<?> metadataField) {
        return this.zzaut;
    }

    @Override // com.google.android.gms.drive.query.internal.zzf
    /* JADX INFO: renamed from: zzf, reason: merged with bridge method [inline-methods] */
    public <T> Boolean zze(MetadataField<T> metadataField, T t) {
        return this.zzaut;
    }

    @Override // com.google.android.gms.drive.query.internal.zzf
    /* JADX INFO: renamed from: zztR, reason: merged with bridge method [inline-methods] */
    public Boolean zztQ() {
        return this.zzaut;
    }

    @Override // com.google.android.gms.drive.query.internal.zzf
    /* JADX INFO: renamed from: zztS, reason: merged with bridge method [inline-methods] */
    public Boolean zztP() {
        return this.zzaut;
    }
}
