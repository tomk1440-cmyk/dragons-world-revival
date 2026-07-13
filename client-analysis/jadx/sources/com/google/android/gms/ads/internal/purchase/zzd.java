package com.google.android.gms.ads.internal.purchase;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.SystemClock;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.internal.zzgc;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzin;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzd extends zzgc.zza {
    private Context mContext;
    private String zzFI;
    private ArrayList<String> zzFJ;
    private String zzsy;

    public zzd(String str, ArrayList<String> arrayList, Context context, String str2) {
        this.zzFI = str;
        this.zzFJ = arrayList;
        this.zzsy = str2;
        this.mContext = context;
    }

    @Override // com.google.android.gms.internal.zzgc
    public String getProductId() {
        return this.zzFI;
    }

    @Override // com.google.android.gms.internal.zzgc
    public void recordPlayBillingResolution(int billingResponseCode) {
        if (billingResponseCode == 0) {
            zzfX();
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("google_play_status", String.valueOf(billingResponseCode));
        map.put("sku", this.zzFI);
        map.put("status", String.valueOf(zzB(billingResponseCode)));
        LinkedList linkedList = new LinkedList();
        Iterator<String> it = this.zzFJ.iterator();
        while (it.hasNext()) {
            linkedList.add(zza(it.next(), map));
        }
        zzr.zzbC().zza(this.mContext, this.zzsy, linkedList);
    }

    @Override // com.google.android.gms.internal.zzgc
    public void recordResolution(int resolution) {
        if (resolution == 1) {
            zzfX();
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("status", String.valueOf(resolution));
        map.put("sku", this.zzFI);
        LinkedList linkedList = new LinkedList();
        Iterator<String> it = this.zzFJ.iterator();
        while (it.hasNext()) {
            linkedList.add(zza(it.next(), map));
        }
        zzr.zzbC().zza(this.mContext, this.zzsy, linkedList);
    }

    protected int zzB(int i) {
        if (i == 0) {
            return 1;
        }
        if (i == 1) {
            return 2;
        }
        return i == 4 ? 3 : 0;
    }

    protected String zza(String str, HashMap<String, String> map) {
        String str2;
        String packageName = this.mContext.getPackageName();
        try {
            str2 = this.mContext.getPackageManager().getPackageInfo(packageName, 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            zzin.zzd("Error to retrieve app version", e);
            str2 = "";
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime() - zzr.zzbF().zzha().zzhl();
        for (String str3 : map.keySet()) {
            str = str.replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", str3), String.format("$1%s$2", map.get(str3)));
        }
        return str.replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", "sessionid"), String.format("$1%s$2", zzr.zzbF().getSessionId())).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", "appid"), String.format("$1%s$2", packageName)).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", "osversion"), String.format("$1%s$2", String.valueOf(Build.VERSION.SDK_INT))).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", "sdkversion"), String.format("$1%s$2", this.zzsy)).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", "appversion"), String.format("$1%s$2", str2)).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", "timestamp"), String.format("$1%s$2", String.valueOf(jElapsedRealtime))).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", "[^@]+"), String.format("$1%s$2", "")).replaceAll("@@", "@");
    }

    void zzfX() {
        try {
            this.mContext.getClassLoader().loadClass("com.google.ads.conversiontracking.IAPConversionReporter").getDeclaredMethod("reportWithProductId", Context.class, String.class, String.class, Boolean.TYPE).invoke(null, this.mContext, this.zzFI, "", true);
        } catch (ClassNotFoundException e) {
            zzin.zzaK("Google Conversion Tracking SDK 1.2.0 or above is required to report a conversion.");
        } catch (NoSuchMethodException e2) {
            zzin.zzaK("Google Conversion Tracking SDK 1.2.0 or above is required to report a conversion.");
        } catch (Exception e3) {
            zzin.zzd("Fail to report a conversion.", e3);
        }
    }
}
