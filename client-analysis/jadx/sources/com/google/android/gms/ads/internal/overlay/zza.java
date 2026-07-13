package com.google.android.gms.ads.internal.overlay;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzin;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zza {
    public boolean zza(Context context, Intent intent, zzp zzpVar) {
        try {
            zzin.v("Launching an intent: " + intent.toURI());
            com.google.android.gms.ads.internal.zzr.zzbC().zzb(context, intent);
            if (zzpVar != null) {
                zzpVar.zzaO();
            }
            return true;
        } catch (ActivityNotFoundException e) {
            zzin.zzaK(e.getMessage());
            return false;
        }
    }

    public boolean zza(Context context, AdLauncherIntentInfoParcel adLauncherIntentInfoParcel, zzp zzpVar) {
        int i = 0;
        if (adLauncherIntentInfoParcel == null) {
            zzin.zzaK("No intent data for launcher overlay.");
            return false;
        }
        if (adLauncherIntentInfoParcel.intent != null) {
            return zza(context, adLauncherIntentInfoParcel.intent, zzpVar);
        }
        Intent intent = new Intent();
        if (TextUtils.isEmpty(adLauncherIntentInfoParcel.url)) {
            zzin.zzaK("Open GMSG did not contain a URL.");
            return false;
        }
        if (TextUtils.isEmpty(adLauncherIntentInfoParcel.mimeType)) {
            intent.setData(Uri.parse(adLauncherIntentInfoParcel.url));
        } else {
            intent.setDataAndType(Uri.parse(adLauncherIntentInfoParcel.url), adLauncherIntentInfoParcel.mimeType);
        }
        intent.setAction("android.intent.action.VIEW");
        if (!TextUtils.isEmpty(adLauncherIntentInfoParcel.packageName)) {
            intent.setPackage(adLauncherIntentInfoParcel.packageName);
        }
        if (!TextUtils.isEmpty(adLauncherIntentInfoParcel.zzDK)) {
            String[] strArrSplit = adLauncherIntentInfoParcel.zzDK.split("/", 2);
            if (strArrSplit.length < 2) {
                zzin.zzaK("Could not parse component name from open GMSG: " + adLauncherIntentInfoParcel.zzDK);
                return false;
            }
            intent.setClassName(strArrSplit[0], strArrSplit[1]);
        }
        String str = adLauncherIntentInfoParcel.zzDL;
        if (!TextUtils.isEmpty(str)) {
            try {
                i = Integer.parseInt(str);
            } catch (NumberFormatException e) {
                zzin.zzaK("Could not parse intent flags.");
            }
            intent.addFlags(i);
        }
        return zza(context, intent, zzpVar);
    }
}
