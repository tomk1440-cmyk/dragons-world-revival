package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.util.LongSparseArray;
import android.util.SparseArray;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.drive.metadata.internal.CustomProperty;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class zznn extends com.google.android.gms.drive.metadata.internal.zzk<AppVisibleCustomProperties> {
    public static final com.google.android.gms.drive.metadata.internal.zze.zza zzatL = new com.google.android.gms.drive.metadata.internal.zze.zza() { // from class: com.google.android.gms.internal.zznn.1
        @Override // com.google.android.gms.drive.metadata.internal.zze.zza
        public void zzb(DataHolder dataHolder) {
            zznn.zzd(dataHolder);
        }

        @Override // com.google.android.gms.drive.metadata.internal.zze.zza
        public String zztD() {
            return "customPropertiesExtraHolder";
        }
    };

    public zznn(int i) {
        super("customProperties", Arrays.asList("hasCustomProperties", "sqlId"), Arrays.asList("customPropertiesExtra", "customPropertiesExtraHolder"), i);
    }

    private static void zzc(DataHolder dataHolder) {
        synchronized (dataHolder) {
            DataHolder dataHolder2 = (DataHolder) dataHolder.zzpZ().getParcelable("customPropertiesExtraHolder");
            if (dataHolder2 == null) {
                return;
            }
            try {
                LongSparseArray<AppVisibleCustomProperties.zza> longSparseArrayZzf = zzf(dataHolder2);
                SparseArray<? extends Parcelable> sparseArray = new SparseArray<>();
                for (int i = 0; i < dataHolder.getCount(); i++) {
                    AppVisibleCustomProperties.zza zzaVar = longSparseArrayZzf.get(dataHolder.zzb("sqlId", i, dataHolder.zzbH(i)));
                    if (zzaVar != null) {
                        sparseArray.append(i, zzaVar.zztA());
                    }
                }
                dataHolder.zzpZ().putSparseParcelableArray("customPropertiesExtra", sparseArray);
                dataHolder2.close();
                dataHolder.zzpZ().remove("customPropertiesExtraHolder");
            } catch (Throwable th) {
                dataHolder2.close();
                dataHolder.zzpZ().remove("customPropertiesExtraHolder");
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzd(DataHolder dataHolder) {
        Bundle bundleZzpZ = dataHolder.zzpZ();
        if (bundleZzpZ == null) {
            return;
        }
        synchronized (dataHolder) {
            DataHolder dataHolder2 = (DataHolder) bundleZzpZ.getParcelable("customPropertiesExtraHolder");
            if (dataHolder2 != null) {
                dataHolder2.close();
                bundleZzpZ.remove("customPropertiesExtraHolder");
            }
        }
    }

    private static LongSparseArray<AppVisibleCustomProperties.zza> zzf(DataHolder dataHolder) {
        Bundle bundleZzpZ = dataHolder.zzpZ();
        String string = bundleZzpZ.getString("entryIdColumn");
        String string2 = bundleZzpZ.getString("keyColumn");
        String string3 = bundleZzpZ.getString("visibilityColumn");
        String string4 = bundleZzpZ.getString("valueColumn");
        LongSparseArray<AppVisibleCustomProperties.zza> longSparseArray = new LongSparseArray<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= dataHolder.getCount()) {
                return longSparseArray;
            }
            int iZzbH = dataHolder.zzbH(i2);
            long jZzb = dataHolder.zzb(string, i2, iZzbH);
            String strZzd = dataHolder.zzd(string2, i2, iZzbH);
            int iZzc = dataHolder.zzc(string3, i2, iZzbH);
            CustomProperty customProperty = new CustomProperty(new CustomPropertyKey(strZzd, iZzc), dataHolder.zzd(string4, i2, iZzbH));
            AppVisibleCustomProperties.zza zzaVar = longSparseArray.get(jZzb);
            if (zzaVar == null) {
                zzaVar = new AppVisibleCustomProperties.zza();
                longSparseArray.put(jZzb, zzaVar);
            }
            zzaVar.zza(customProperty);
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.drive.metadata.zza
    /* JADX INFO: renamed from: zzl, reason: merged with bridge method [inline-methods] */
    public AppVisibleCustomProperties zzc(DataHolder dataHolder, int i, int i2) {
        Bundle bundleZzpZ = dataHolder.zzpZ();
        SparseArray sparseParcelableArray = bundleZzpZ.getSparseParcelableArray("customPropertiesExtra");
        if (sparseParcelableArray == null) {
            if (bundleZzpZ.getParcelable("customPropertiesExtraHolder") != null) {
                zzc(dataHolder);
                sparseParcelableArray = bundleZzpZ.getSparseParcelableArray("customPropertiesExtra");
            }
            if (sparseParcelableArray == null) {
                return AppVisibleCustomProperties.zzasK;
            }
        }
        return (AppVisibleCustomProperties) sparseParcelableArray.get(i, AppVisibleCustomProperties.zzasK);
    }
}
