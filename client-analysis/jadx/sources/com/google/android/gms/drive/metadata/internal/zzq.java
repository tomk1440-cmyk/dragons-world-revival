package com.google.android.gms.drive.metadata.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.UserMetadata;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
public class zzq extends zzk<UserMetadata> {
    public zzq(String str, int i) {
        super(str, zzdg(str), Collections.emptyList(), i);
    }

    private static String zzB(String str, String str2) {
        return str + "." + str2;
    }

    private String zzdf(String str) {
        return zzB(getName(), str);
    }

    private static Collection<String> zzdg(String str) {
        return Arrays.asList(zzB(str, "permissionId"), zzB(str, "displayName"), zzB(str, "picture"), zzB(str, "isAuthenticatedUser"), zzB(str, "emailAddress"));
    }

    @Override // com.google.android.gms.drive.metadata.zza
    protected boolean zzb(DataHolder dataHolder, int i, int i2) {
        return dataHolder.zzcz(zzdf("permissionId")) && !dataHolder.zzi(zzdf("permissionId"), i, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.drive.metadata.zza
    /* JADX INFO: renamed from: zzj, reason: merged with bridge method [inline-methods] */
    public UserMetadata zzc(DataHolder dataHolder, int i, int i2) {
        String strZzd = dataHolder.zzd(zzdf("permissionId"), i, i2);
        if (strZzd == null) {
            return null;
        }
        String strZzd2 = dataHolder.zzd(zzdf("displayName"), i, i2);
        String strZzd3 = dataHolder.zzd(zzdf("picture"), i, i2);
        Boolean boolValueOf = Boolean.valueOf(dataHolder.zze(zzdf("isAuthenticatedUser"), i, i2));
        return new UserMetadata(strZzd, strZzd2, strZzd3, boolValueOf.booleanValue(), dataHolder.zzd(zzdf("emailAddress"), i, i2));
    }
}
