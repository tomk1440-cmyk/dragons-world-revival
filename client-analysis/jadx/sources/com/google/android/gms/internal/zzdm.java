package com.google.android.gms.internal;

import android.app.ActivityManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.adjust.sdk.Constants;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.ads.internal.overlay.AdLauncherIntentInfoParcel;
import com.google.android.gms.drive.DriveFile;
import io.fabric.sdk.android.services.network.HttpRequest;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public final class zzdm implements zzdf {
    private final com.google.android.gms.ads.internal.zze zzzA;
    private final zzfn zzzB;
    private final zzdh zzzD;

    public static class zza extends zzim {
        private final String zzF;
        private final zzjp zzpD;
        private final String zzzE = "play.google.com";
        private final String zzzF = "market";
        private final int zzzG = 10;

        public zza(zzjp zzjpVar, String str) {
            this.zzpD = zzjpVar;
            this.zzF = str;
        }

        @Override // com.google.android.gms.internal.zzim
        public void onStop() {
        }

        public Intent zzT(String str) {
            Uri uri = Uri.parse(str);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addFlags(DriveFile.MODE_READ_ONLY);
            intent.setData(uri);
            return intent;
        }

        /* JADX WARN: Code duplicated, block: B:55:0x0116  */
        @Override // com.google.android.gms.internal.zzim
        public void zzbr() {
            String str;
            RuntimeException runtimeException;
            IndexOutOfBoundsException indexOutOfBoundsException;
            IOException iOException;
            String str2;
            int i = 0;
            String str3 = this.zzF;
            while (i < 10) {
                int i2 = i + 1;
                try {
                    URL url = new URL(str3);
                    if ("play.google.com".equalsIgnoreCase(url.getHost())) {
                        str = str3;
                    } else if ("market".equalsIgnoreCase(url.getProtocol())) {
                        str = str3;
                    } else {
                        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                        try {
                            com.google.android.gms.ads.internal.zzr.zzbC().zza(this.zzpD.getContext(), this.zzpD.zzhX().afmaVersion, false, httpURLConnection);
                            int responseCode = httpURLConnection.getResponseCode();
                            Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
                            if (responseCode < 300 || responseCode > 399) {
                                str2 = "";
                            } else {
                                List<String> list = null;
                                if (headerFields.containsKey(HttpRequest.HEADER_LOCATION)) {
                                    list = headerFields.get(HttpRequest.HEADER_LOCATION);
                                } else if (headerFields.containsKey("location")) {
                                    list = headerFields.get("location");
                                }
                                if (list == null || list.size() <= 0) {
                                    str2 = "";
                                } else {
                                    str2 = list.get(0);
                                }
                            }
                            if (TextUtils.isEmpty(str2)) {
                                zzin.zzaK("Arrived at landing page, this ideally should not happen. Will open it in browser.");
                                httpURLConnection.disconnect();
                                str = str3;
                            } else {
                                try {
                                    httpURLConnection.disconnect();
                                    i = i2;
                                    str3 = str2;
                                } catch (IOException e) {
                                    str = str2;
                                    iOException = e;
                                    zzin.zzd("Error while pinging URL: " + str, iOException);
                                    com.google.android.gms.ads.internal.zzr.zzbC().zzb(this.zzpD.getContext(), zzT(str));
                                } catch (IndexOutOfBoundsException e2) {
                                    str = str2;
                                    indexOutOfBoundsException = e2;
                                    zzin.zzd("Error while parsing ping URL: " + str, indexOutOfBoundsException);
                                    com.google.android.gms.ads.internal.zzr.zzbC().zzb(this.zzpD.getContext(), zzT(str));
                                } catch (RuntimeException e3) {
                                    str = str2;
                                    runtimeException = e3;
                                    zzin.zzd("Error while pinging URL: " + str, runtimeException);
                                    com.google.android.gms.ads.internal.zzr.zzbC().zzb(this.zzpD.getContext(), zzT(str));
                                }
                            }
                        } catch (Throwable th) {
                            httpURLConnection.disconnect();
                            throw th;
                        }
                    }
                } catch (IOException e4) {
                    iOException = e4;
                    str = str3;
                } catch (IndexOutOfBoundsException e5) {
                    indexOutOfBoundsException = e5;
                    str = str3;
                } catch (RuntimeException e6) {
                    runtimeException = e6;
                    str = str3;
                }
                com.google.android.gms.ads.internal.zzr.zzbC().zzb(this.zzpD.getContext(), zzT(str));
            }
            str = str3;
            com.google.android.gms.ads.internal.zzr.zzbC().zzb(this.zzpD.getContext(), zzT(str));
        }
    }

    public static class zzb {
        private final zzjp zzpD;

        public zzb(zzjp zzjpVar) {
            this.zzpD = zzjpVar;
        }

        public Intent zza(Context context, Map<String, String> map) {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
            ResolveInfo resolveInfoZza;
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            String strZza = map.get("u");
            if (TextUtils.isEmpty(strZza)) {
                return null;
            }
            if (this.zzpD != null) {
                strZza = com.google.android.gms.ads.internal.zzr.zzbC().zza(this.zzpD, strZza);
            }
            Uri uri = Uri.parse(strZza);
            boolean z = Boolean.parseBoolean(map.get("use_first_package"));
            boolean z2 = Boolean.parseBoolean(map.get("use_running_process"));
            Uri uriBuild = "http".equalsIgnoreCase(uri.getScheme()) ? uri.buildUpon().scheme(Constants.SCHEME).build() : Constants.SCHEME.equalsIgnoreCase(uri.getScheme()) ? uri.buildUpon().scheme("http").build() : null;
            ArrayList<ResolveInfo> arrayList = new ArrayList<>();
            Intent intentZzd = zzd(uri);
            Intent intentZzd2 = zzd(uriBuild);
            ResolveInfo resolveInfoZza2 = zza(context, intentZzd, arrayList);
            if (resolveInfoZza2 != null) {
                return zza(intentZzd, resolveInfoZza2);
            }
            if (intentZzd2 != null && (resolveInfoZza = zza(context, intentZzd2)) != null) {
                Intent intentZza = zza(intentZzd, resolveInfoZza);
                if (zza(context, intentZza) != null) {
                    return intentZza;
                }
            }
            if (arrayList.size() == 0) {
                return intentZzd;
            }
            if (z2 && activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
                for (ResolveInfo resolveInfo : arrayList) {
                    Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                    while (it.hasNext()) {
                        if (it.next().processName.equals(resolveInfo.activityInfo.packageName)) {
                            return zza(intentZzd, resolveInfo);
                        }
                    }
                }
            }
            return z ? zza(intentZzd, arrayList.get(0)) : intentZzd;
        }

        public Intent zza(Intent intent, ResolveInfo resolveInfo) {
            Intent intent2 = new Intent(intent);
            intent2.setClassName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name);
            return intent2;
        }

        public ResolveInfo zza(Context context, Intent intent) {
            return zza(context, intent, new ArrayList<>());
        }

        public ResolveInfo zza(Context context, Intent intent, ArrayList<ResolveInfo> arrayList) {
            ResolveInfo resolveInfo;
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return null;
            }
            List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
            ResolveInfo resolveInfoResolveActivity = packageManager.resolveActivity(intent, 65536);
            if (listQueryIntentActivities == null || resolveInfoResolveActivity == null) {
                resolveInfo = null;
            } else {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= listQueryIntentActivities.size()) {
                        break;
                    }
                    ResolveInfo resolveInfo2 = listQueryIntentActivities.get(i2);
                    if (resolveInfoResolveActivity == null || !resolveInfoResolveActivity.activityInfo.name.equals(resolveInfo2.activityInfo.name)) {
                        i = i2 + 1;
                    } else {
                        resolveInfo = resolveInfoResolveActivity;
                    }
                }
                resolveInfo = null;
            }
            arrayList.addAll(listQueryIntentActivities);
            return resolveInfo;
        }

        public Intent zzd(Uri uri) {
            if (uri == null) {
                return null;
            }
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addFlags(DriveFile.MODE_READ_ONLY);
            intent.setData(uri);
            intent.setAction("android.intent.action.VIEW");
            return intent;
        }
    }

    public zzdm(zzdh zzdhVar, com.google.android.gms.ads.internal.zze zzeVar, zzfn zzfnVar) {
        this.zzzD = zzdhVar;
        this.zzzA = zzeVar;
        this.zzzB = zzfnVar;
    }

    private static boolean zzc(Map<String, String> map) {
        return AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(map.get("custom_close"));
    }

    private static int zzd(Map<String, String> map) {
        String str = map.get("o");
        if (str != null) {
            if ("p".equalsIgnoreCase(str)) {
                return com.google.android.gms.ads.internal.zzr.zzbE().zzhw();
            }
            if ("l".equalsIgnoreCase(str)) {
                return com.google.android.gms.ads.internal.zzr.zzbE().zzhv();
            }
            if ("c".equalsIgnoreCase(str)) {
                return com.google.android.gms.ads.internal.zzr.zzbE().zzhx();
            }
        }
        return -1;
    }

    private static void zze(zzjp zzjpVar, Map<String, String> map) {
        String str = map.get("u");
        if (TextUtils.isEmpty(str)) {
            zzin.zzaK("Destination url cannot be empty.");
        } else {
            new zza(zzjpVar, str).zzgd();
        }
    }

    private static void zzf(zzjp zzjpVar, Map<String, String> map) {
        Context context = zzjpVar.getContext();
        if (TextUtils.isEmpty(map.get("u"))) {
            zzin.zzaK("Destination url cannot be empty.");
            return;
        }
        try {
            zzjpVar.zzhU().zza(new AdLauncherIntentInfoParcel(new zzb(zzjpVar).zza(context, map)));
        } catch (ActivityNotFoundException e) {
            zzin.zzaK(e.getMessage());
        }
    }

    private void zzo(boolean z) {
        if (this.zzzB != null) {
            this.zzzB.zzp(z);
        }
    }

    @Override // com.google.android.gms.internal.zzdf
    public void zza(zzjp zzjpVar, Map<String, String> map) {
        String str = map.get("a");
        if (str == null) {
            zzin.zzaK("Action missing from an open GMSG.");
            return;
        }
        if (this.zzzA != null && !this.zzzA.zzbh()) {
            this.zzzA.zzq(map.get("u"));
            return;
        }
        zzjq zzjqVarZzhU = zzjpVar.zzhU();
        if ("expand".equalsIgnoreCase(str)) {
            if (zzjpVar.zzhY()) {
                zzin.zzaK("Cannot expand WebView that is already expanded.");
                return;
            } else {
                zzo(false);
                zzjqVarZzhU.zza(zzc(map), zzd(map));
                return;
            }
        }
        if ("webapp".equalsIgnoreCase(str)) {
            String str2 = map.get("u");
            zzo(false);
            if (str2 != null) {
                zzjqVarZzhU.zza(zzc(map), zzd(map), str2);
                return;
            } else {
                zzjqVarZzhU.zza(zzc(map), zzd(map), map.get("html"), map.get("baseurl"));
                return;
            }
        }
        if ("in_app_purchase".equalsIgnoreCase(str)) {
            String str3 = map.get("product_id");
            String str4 = map.get("report_urls");
            if (this.zzzD != null) {
                if (str4 == null || str4.isEmpty()) {
                    this.zzzD.zza(str3, new ArrayList<>());
                    return;
                } else {
                    this.zzzD.zza(str3, new ArrayList<>(Arrays.asList(str4.split(" "))));
                    return;
                }
            }
            return;
        }
        if (SettingsJsonConstants.APP_KEY.equalsIgnoreCase(str) && ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equalsIgnoreCase(map.get("play_store"))) {
            zze(zzjpVar, map);
            return;
        }
        if (SettingsJsonConstants.APP_KEY.equalsIgnoreCase(str) && ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equalsIgnoreCase(map.get("system_browser"))) {
            zzo(true);
            zzf(zzjpVar, map);
        } else {
            zzo(true);
            String str5 = map.get("u");
            zzjqVarZzhU.zza(new AdLauncherIntentInfoParcel(map.get("i"), !TextUtils.isEmpty(str5) ? com.google.android.gms.ads.internal.zzr.zzbC().zza(zzjpVar, str5) : str5, map.get("m"), map.get("p"), map.get("c"), map.get("f"), map.get("e")));
        }
    }
}
