package com.google.android.gms.internal;

import android.accounts.Account;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.appdatasearch.DocumentContents;
import com.google.android.gms.appdatasearch.DocumentSection;
import com.google.android.gms.appdatasearch.RegisterSectionInfo;
import com.google.android.gms.appdatasearch.UsageInfo;
import com.google.android.gms.appindexing.Action;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class zzkj {
    private static DocumentSection zza(String str, zzpm.zzc zzcVar) {
        return new DocumentSection(zzsu.toByteArray(zzcVar), new RegisterSectionInfo.zza(str).zzM(true).zzbC(str).zzbB("blob").zzmh());
    }

    public static UsageInfo zza(Action action, long j, String str, int i) {
        int i2;
        boolean z = false;
        Bundle bundle = new Bundle();
        bundle.putAll(action.zzmk());
        Bundle bundle2 = bundle.getBundle("object");
        Uri uri = bundle2.containsKey(ShareConstants.WEB_DIALOG_PARAM_ID) ? Uri.parse(bundle2.getString(ShareConstants.WEB_DIALOG_PARAM_ID)) : null;
        String string = bundle2.getString("name");
        String string2 = bundle2.getString(ShareConstants.MEDIA_TYPE);
        Intent intentZza = zzkk.zza(str, Uri.parse(bundle2.getString("url")));
        DocumentContents.zza zzaVarZza = UsageInfo.zza(intentZza, string, uri, string2, null);
        if (bundle.containsKey(".private:ssbContext")) {
            zzaVarZza.zza(DocumentSection.zzh(bundle.getByteArray(".private:ssbContext")));
            bundle.remove(".private:ssbContext");
        }
        if (bundle.containsKey(".private:accountName")) {
            zzaVarZza.zzb(new Account(bundle.getString(".private:accountName"), "com.google"));
            bundle.remove(".private:accountName");
        }
        if (bundle.containsKey(".private:isContextOnly") && bundle.getBoolean(".private:isContextOnly")) {
            i2 = 4;
            bundle.remove(".private:isContextOnly");
        } else {
            i2 = 0;
        }
        if (bundle.containsKey(".private:isDeviceOnly")) {
            z = bundle.getBoolean(".private:isDeviceOnly", false);
            bundle.remove(".private:isDeviceOnly");
        }
        zzaVarZza.zza(zza(".private:action", zzg(bundle)));
        return new UsageInfo.zza().zza(UsageInfo.zza(str, intentZza)).zzw(j).zzar(i2).zza(zzaVarZza.zzme()).zzO(z).zzas(i).zzmi();
    }

    private static zzpm.zzb zzb(String str, Bundle bundle) {
        zzpm.zzb zzbVar = new zzpm.zzb();
        zzbVar.name = str;
        zzbVar.zzaMt = new zzpm.zzd();
        zzbVar.zzaMt.zzaMy = zzg(bundle);
        return zzbVar;
    }

    static zzpm.zzc zzg(Bundle bundle) {
        ArrayList arrayList = new ArrayList();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj instanceof String) {
                arrayList.add(zzp(str, (String) obj));
            } else if (obj instanceof Bundle) {
                arrayList.add(zzb(str, (Bundle) obj));
            } else if (obj instanceof String[]) {
                for (String str2 : (String[]) obj) {
                    if (str2 != null) {
                        arrayList.add(zzp(str, str2));
                    }
                }
            } else if (obj instanceof Bundle[]) {
                for (Bundle bundle2 : (Bundle[]) obj) {
                    if (bundle2 != null) {
                        arrayList.add(zzb(str, bundle2));
                    }
                }
            } else if (obj instanceof Boolean) {
                arrayList.add(zzi(str, ((Boolean) obj).booleanValue()));
            } else {
                Log.e("SearchIndex", "Unsupported value: " + obj);
            }
        }
        zzpm.zzc zzcVar = new zzpm.zzc();
        if (bundle.containsKey(ShareConstants.MEDIA_TYPE)) {
            zzcVar.type = bundle.getString(ShareConstants.MEDIA_TYPE);
        }
        zzcVar.zzaMu = (zzpm.zzb[]) arrayList.toArray(new zzpm.zzb[arrayList.size()]);
        return zzcVar;
    }

    private static zzpm.zzb zzi(String str, boolean z) {
        zzpm.zzb zzbVar = new zzpm.zzb();
        zzbVar.name = str;
        zzbVar.zzaMt = new zzpm.zzd();
        zzbVar.zzaMt.zzaMv = z;
        return zzbVar;
    }

    private static zzpm.zzb zzp(String str, String str2) {
        zzpm.zzb zzbVar = new zzpm.zzb();
        zzbVar.name = str;
        zzbVar.zzaMt = new zzpm.zzd();
        zzbVar.zzaMt.zzamJ = str2;
        return zzbVar;
    }
}
