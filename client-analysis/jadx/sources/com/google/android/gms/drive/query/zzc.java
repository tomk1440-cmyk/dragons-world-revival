package com.google.android.gms.drive.query;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.query.internal.Operator;
import com.google.android.gms.drive.query.internal.zzf;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class zzc implements zzf<String> {
    public <T> String zza(com.google.android.gms.drive.metadata.zzb<T> zzbVar, T t) {
        return String.format("contains(%s,%s)", zzbVar.getName(), t);
    }

    @Override // com.google.android.gms.drive.query.internal.zzf
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public <T> String zzb(Operator operator, MetadataField<T> metadataField, T t) {
        return String.format("cmp(%s,%s,%s)", operator.getTag(), metadataField.getName(), t);
    }

    @Override // com.google.android.gms.drive.query.internal.zzf
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public String zzb(Operator operator, List<String> list) {
        StringBuilder sb = new StringBuilder(operator.getTag() + "(");
        String str = "";
        Iterator<String> it = list.iterator();
        while (true) {
            String str2 = str;
            if (!it.hasNext()) {
                return sb.append(")").toString();
            }
            String next = it.next();
            sb.append(str2);
            sb.append(next);
            str = ",";
        }
    }

    @Override // com.google.android.gms.drive.query.internal.zzf
    public /* synthetic */ String zzb(com.google.android.gms.drive.metadata.zzb zzbVar, Object obj) {
        return zza((com.google.android.gms.drive.metadata.zzb<Object>) zzbVar, obj);
    }

    @Override // com.google.android.gms.drive.query.internal.zzf
    /* JADX INFO: renamed from: zzd, reason: merged with bridge method [inline-methods] */
    public String zze(MetadataField<?> metadataField) {
        return String.format("fieldOnly(%s)", metadataField.getName());
    }

    @Override // com.google.android.gms.drive.query.internal.zzf
    /* JADX INFO: renamed from: zzd, reason: merged with bridge method [inline-methods] */
    public <T> String zze(MetadataField<T> metadataField, T t) {
        return String.format("has(%s,%s)", metadataField.getName(), t);
    }

    @Override // com.google.android.gms.drive.query.internal.zzf
    /* JADX INFO: renamed from: zzdh, reason: merged with bridge method [inline-methods] */
    public String zzB(String str) {
        return String.format("not(%s)", str);
    }

    @Override // com.google.android.gms.drive.query.internal.zzf
    /* JADX INFO: renamed from: zzdi, reason: merged with bridge method [inline-methods] */
    public String zzdj(String str) {
        return String.format("fullTextSearch(%s)", str);
    }

    @Override // com.google.android.gms.drive.query.internal.zzf
    /* JADX INFO: renamed from: zztN, reason: merged with bridge method [inline-methods] */
    public String zztQ() {
        return "all()";
    }

    @Override // com.google.android.gms.drive.query.internal.zzf
    /* JADX INFO: renamed from: zztO, reason: merged with bridge method [inline-methods] */
    public String zztP() {
        return "ownedByMe()";
    }
}
