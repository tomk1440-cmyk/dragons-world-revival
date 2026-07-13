package com.google.android.gms.internal;

import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.DriveSpace;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.SortableMetadataField;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
public class zznm {
    public static final MetadataField<DriveId> zzasU = zznp.zzatS;
    public static final MetadataField<String> zzasV = new com.google.android.gms.drive.metadata.internal.zzp("alternateLink", 4300000);
    public static final zza zzasW = new zza(5000000);
    public static final MetadataField<String> zzasX = new com.google.android.gms.drive.metadata.internal.zzp("description", 4300000);
    public static final MetadataField<String> zzasY = new com.google.android.gms.drive.metadata.internal.zzp("embedLink", 4300000);
    public static final MetadataField<String> zzasZ = new com.google.android.gms.drive.metadata.internal.zzp("fileExtension", 4300000);
    public static final MetadataField<Long> zzata = new com.google.android.gms.drive.metadata.internal.zzg("fileSize", 4300000);
    public static final MetadataField<String> zzatb = new com.google.android.gms.drive.metadata.internal.zzp("folderColorRgb", 7500000);
    public static final MetadataField<Boolean> zzatc = new com.google.android.gms.drive.metadata.internal.zzb("hasThumbnail", 4300000);
    public static final MetadataField<String> zzatd = new com.google.android.gms.drive.metadata.internal.zzp("indexableText", 4300000);
    public static final MetadataField<Boolean> zzate = new com.google.android.gms.drive.metadata.internal.zzb("isAppData", 4300000);
    public static final MetadataField<Boolean> zzatf = new com.google.android.gms.drive.metadata.internal.zzb("isCopyable", 4300000);
    public static final MetadataField<Boolean> zzatg = new com.google.android.gms.drive.metadata.internal.zzb("isEditable", 4100000);
    public static final MetadataField<Boolean> zzath = new com.google.android.gms.drive.metadata.internal.zzb("isExplicitlyTrashed", Collections.singleton("trashed"), Collections.emptySet(), 7000000) { // from class: com.google.android.gms.internal.zznm.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.drive.metadata.internal.zzb, com.google.android.gms.drive.metadata.zza
        /* JADX INFO: renamed from: zze */
        public Boolean zzc(DataHolder dataHolder, int i, int i2) {
            return Boolean.valueOf(dataHolder.zzc("trashed", i, i2) == 2);
        }
    };
    public static final MetadataField<Boolean> zzati = new com.google.android.gms.drive.metadata.internal.zzb("isLocalContentUpToDate", 7800000);
    public static final zzb zzatj = new zzb("isPinned", 4100000);
    public static final MetadataField<Boolean> zzatk = new com.google.android.gms.drive.metadata.internal.zzb("isOpenable", 7200000);
    public static final MetadataField<Boolean> zzatl = new com.google.android.gms.drive.metadata.internal.zzb("isRestricted", 4300000);
    public static final MetadataField<Boolean> zzatm = new com.google.android.gms.drive.metadata.internal.zzb("isShared", 4300000);
    public static final MetadataField<Boolean> zzatn = new com.google.android.gms.drive.metadata.internal.zzb("isGooglePhotosFolder", 7000000);
    public static final MetadataField<Boolean> zzato = new com.google.android.gms.drive.metadata.internal.zzb("isGooglePhotosRootFolder", 7000000);
    public static final MetadataField<Boolean> zzatp = new com.google.android.gms.drive.metadata.internal.zzb("isTrashable", 4400000);
    public static final MetadataField<Boolean> zzatq = new com.google.android.gms.drive.metadata.internal.zzb("isViewed", 4300000);
    public static final zzc zzatr = new zzc(4100000);
    public static final MetadataField<String> zzats = new com.google.android.gms.drive.metadata.internal.zzp("originalFilename", 4300000);
    public static final com.google.android.gms.drive.metadata.zzb<String> zzatt = new com.google.android.gms.drive.metadata.internal.zzo("ownerNames", 4300000);
    public static final com.google.android.gms.drive.metadata.internal.zzq zzatu = new com.google.android.gms.drive.metadata.internal.zzq("lastModifyingUser", 6000000);
    public static final com.google.android.gms.drive.metadata.internal.zzq zzatv = new com.google.android.gms.drive.metadata.internal.zzq("sharingUser", 6000000);
    public static final com.google.android.gms.drive.metadata.internal.zzm zzatw = new com.google.android.gms.drive.metadata.internal.zzm(4100000);
    public static final zzd zzatx = new zzd("quotaBytesUsed", 4300000);
    public static final zzf zzaty = new zzf("starred", 4100000);
    public static final MetadataField<BitmapTeleporter> zzatz = new com.google.android.gms.drive.metadata.internal.zzk<BitmapTeleporter>("thumbnail", Collections.emptySet(), Collections.emptySet(), 4400000) { // from class: com.google.android.gms.internal.zznm.2
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.drive.metadata.zza
        /* JADX INFO: renamed from: zzk, reason: merged with bridge method [inline-methods] */
        public BitmapTeleporter zzc(DataHolder dataHolder, int i, int i2) {
            throw new IllegalStateException("Thumbnail field is write only");
        }
    };
    public static final zzg zzatA = new zzg("title", 4100000);
    public static final zzh zzatB = new zzh("trashed", 4100000);
    public static final MetadataField<String> zzatC = new com.google.android.gms.drive.metadata.internal.zzp("webContentLink", 4300000);
    public static final MetadataField<String> zzatD = new com.google.android.gms.drive.metadata.internal.zzp("webViewLink", 4300000);
    public static final MetadataField<String> zzatE = new com.google.android.gms.drive.metadata.internal.zzp("uniqueIdentifier", 5000000);
    public static final com.google.android.gms.drive.metadata.internal.zzb zzatF = new com.google.android.gms.drive.metadata.internal.zzb("writersCanShare", 6000000);
    public static final MetadataField<String> zzatG = new com.google.android.gms.drive.metadata.internal.zzp("role", 6000000);
    public static final MetadataField<String> zzatH = new com.google.android.gms.drive.metadata.internal.zzp("md5Checksum", 7000000);
    public static final zze zzatI = new zze(7000000);
    public static final MetadataField<String> zzatJ = new com.google.android.gms.drive.metadata.internal.zzp("recencyReason", 8000000);
    public static final MetadataField<Boolean> zzatK = new com.google.android.gms.drive.metadata.internal.zzb("subscribed", 8000000);

    public static class zza extends zznn implements SearchableMetadataField<AppVisibleCustomProperties> {
        public zza(int i) {
            super(i);
        }
    }

    public static class zzb extends com.google.android.gms.drive.metadata.internal.zzb implements SearchableMetadataField<Boolean> {
        public zzb(String str, int i) {
            super(str, i);
        }
    }

    public static class zzc extends com.google.android.gms.drive.metadata.internal.zzp implements SearchableMetadataField<String> {
        public zzc(int i) {
            super("mimeType", i);
        }
    }

    public static class zzd extends com.google.android.gms.drive.metadata.internal.zzg implements SortableMetadataField<Long> {
        public zzd(String str, int i) {
            super(str, i);
        }
    }

    public static class zze extends com.google.android.gms.drive.metadata.internal.zzj<DriveSpace> {
        public zze(int i) {
            super("spaces", Arrays.asList("inDriveSpace", "isAppData", "inGooglePhotosSpace"), Collections.emptySet(), i);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.drive.metadata.zzb, com.google.android.gms.drive.metadata.zza
        /* JADX INFO: renamed from: zzd */
        public Collection<DriveSpace> zzc(DataHolder dataHolder, int i, int i2) {
            ArrayList arrayList = new ArrayList();
            if (dataHolder.zze("inDriveSpace", i, i2)) {
                arrayList.add(DriveSpace.zzaoP);
            }
            if (dataHolder.zze("isAppData", i, i2)) {
                arrayList.add(DriveSpace.zzaoQ);
            }
            if (dataHolder.zze("inGooglePhotosSpace", i, i2)) {
                arrayList.add(DriveSpace.zzaoR);
            }
            return arrayList;
        }
    }

    public static class zzf extends com.google.android.gms.drive.metadata.internal.zzb implements SearchableMetadataField<Boolean> {
        public zzf(String str, int i) {
            super(str, i);
        }
    }

    public static class zzg extends com.google.android.gms.drive.metadata.internal.zzp implements SearchableMetadataField<String>, SortableMetadataField<String> {
        public zzg(String str, int i) {
            super(str, i);
        }
    }

    public static class zzh extends com.google.android.gms.drive.metadata.internal.zzb implements SearchableMetadataField<Boolean> {
        public zzh(String str, int i) {
            super(str, i);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.drive.metadata.internal.zzb, com.google.android.gms.drive.metadata.zza
        /* JADX INFO: renamed from: zze */
        public Boolean zzc(DataHolder dataHolder, int i, int i2) {
            return Boolean.valueOf(dataHolder.zzc(getName(), i, i2) != 0);
        }
    }
}
