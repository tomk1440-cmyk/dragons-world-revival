package com.google.android.gms.drive.query;

import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.SearchableOrderedMetadataField;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.internal.zznm;
import com.google.android.gms.internal.zzno;
import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
public class SearchableField {
    public static final SearchableMetadataField<String> TITLE = zznm.zzatA;
    public static final SearchableMetadataField<String> MIME_TYPE = zznm.zzatr;
    public static final SearchableMetadataField<Boolean> TRASHED = zznm.zzatB;
    public static final SearchableCollectionMetadataField<DriveId> PARENTS = zznm.zzatw;
    public static final SearchableOrderedMetadataField<Date> zzaub = zzno.zzatQ;
    public static final SearchableMetadataField<Boolean> STARRED = zznm.zzaty;
    public static final SearchableOrderedMetadataField<Date> MODIFIED_DATE = zzno.zzatO;
    public static final SearchableOrderedMetadataField<Date> LAST_VIEWED_BY_ME = zzno.zzatN;
    public static final SearchableMetadataField<Boolean> IS_PINNED = zznm.zzatj;
    public static final SearchableMetadataField<AppVisibleCustomProperties> zzauc = zznm.zzasW;
}
