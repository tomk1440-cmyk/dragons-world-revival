package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public class zzm extends zzj<DriveId> implements SearchableCollectionMetadataField<DriveId> {
    public static final zze.zza zzasT = new zze.zza() { // from class: com.google.android.gms.drive.metadata.internal.zzm.1
        @Override // com.google.android.gms.drive.metadata.internal.zze.zza
        public void zzb(DataHolder dataHolder) {
            zzm.zzd(dataHolder);
        }

        @Override // com.google.android.gms.drive.metadata.internal.zze.zza
        public String zztD() {
            return "parentsExtraHolder";
        }
    };

    public zzm(int i) {
        super("parents", Collections.emptySet(), Arrays.asList("parentsExtra", "dbInstanceId", "parentsExtraHolder"), i);
    }

    private void zzc(DataHolder dataHolder) {
        synchronized (dataHolder) {
            DataHolder dataHolder2 = (DataHolder) dataHolder.zzpZ().getParcelable("parentsExtraHolder");
            if (dataHolder2 == null) {
                return;
            }
            try {
                int count = dataHolder.getCount();
                ArrayList<? extends Parcelable> arrayList = new ArrayList<>(count);
                HashMap map = new HashMap(count);
                for (int i = 0; i < count; i++) {
                    int iZzbH = dataHolder.zzbH(i);
                    ParentDriveIdSet parentDriveIdSet = new ParentDriveIdSet();
                    arrayList.add(parentDriveIdSet);
                    map.put(Long.valueOf(dataHolder.zzb("sqlId", i, iZzbH)), parentDriveIdSet);
                }
                Bundle bundleZzpZ = dataHolder2.zzpZ();
                String string = bundleZzpZ.getString("childSqlIdColumn");
                String string2 = bundleZzpZ.getString("parentSqlIdColumn");
                String string3 = bundleZzpZ.getString("parentResIdColumn");
                int count2 = dataHolder2.getCount();
                for (int i2 = 0; i2 < count2; i2++) {
                    int iZzbH2 = dataHolder2.zzbH(i2);
                    ((ParentDriveIdSet) map.get(Long.valueOf(dataHolder2.zzb(string, i2, iZzbH2)))).zza(new PartialDriveId(dataHolder2.zzd(string3, i2, iZzbH2), dataHolder2.zzb(string2, i2, iZzbH2), 1));
                }
                dataHolder.zzpZ().putParcelableArrayList("parentsExtra", arrayList);
                dataHolder2.close();
                dataHolder.zzpZ().remove("parentsExtraHolder");
            } catch (Throwable th) {
                dataHolder2.close();
                dataHolder.zzpZ().remove("parentsExtraHolder");
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
            DataHolder dataHolder2 = (DataHolder) bundleZzpZ.getParcelable("parentsExtraHolder");
            if (dataHolder2 != null) {
                dataHolder2.close();
                bundleZzpZ.remove("parentsExtraHolder");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.drive.metadata.zzb, com.google.android.gms.drive.metadata.zza
    /* JADX INFO: renamed from: zzd */
    public Collection<DriveId> zzc(DataHolder dataHolder, int i, int i2) {
        Bundle bundleZzpZ = dataHolder.zzpZ();
        ArrayList parcelableArrayList = bundleZzpZ.getParcelableArrayList("parentsExtra");
        if (parcelableArrayList == null) {
            if (bundleZzpZ.getParcelable("parentsExtraHolder") != null) {
                zzc(dataHolder);
                parcelableArrayList = bundleZzpZ.getParcelableArrayList("parentsExtra");
            }
            if (parcelableArrayList == null) {
                return null;
            }
        }
        return ((ParentDriveIdSet) parcelableArrayList.get(i)).zzD(bundleZzpZ.getLong("dbInstanceId"));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.drive.metadata.internal.zzj, com.google.android.gms.drive.metadata.zza
    /* JADX INFO: renamed from: zzs */
    public Collection<DriveId> zzn(Bundle bundle) {
        Collection collectionZzn = super.zzn(bundle);
        if (collectionZzn == null) {
            return null;
        }
        return new HashSet(collectionZzn);
    }
}
