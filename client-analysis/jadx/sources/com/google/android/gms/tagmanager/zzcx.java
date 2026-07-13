package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
class zzcx implements zzac {
    private final Context mContext;
    private final zzb zzblh;
    private final zza zzbli;
    private final String zzzN;

    public interface zza {
        void zza(zzaq zzaqVar);

        void zzb(zzaq zzaqVar);

        void zzc(zzaq zzaqVar);
    }

    interface zzb {
        HttpURLConnection zzd(URL url) throws IOException;
    }

    zzcx(Context context, zza zzaVar) {
        this(new zzb() { // from class: com.google.android.gms.tagmanager.zzcx.1
            @Override // com.google.android.gms.tagmanager.zzcx.zzb
            public HttpURLConnection zzd(URL url) throws IOException {
                return (HttpURLConnection) url.openConnection();
            }
        }, context, zzaVar);
    }

    zzcx(zzb zzbVar, Context context, zza zzaVar) {
        this.zzblh = zzbVar;
        this.mContext = context.getApplicationContext();
        this.zzbli = zzaVar;
        this.zzzN = zza("GoogleTagManager", "4.00", Build.VERSION.RELEASE, zzc(Locale.getDefault()), Build.MODEL, Build.ID);
    }

    static String zzc(Locale locale) {
        if (locale == null || locale.getLanguage() == null || locale.getLanguage().length() == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(locale.getLanguage().toLowerCase());
        if (locale.getCountry() != null && locale.getCountry().length() != 0) {
            sb.append("-").append(locale.getCountry().toLowerCase());
        }
        return sb.toString();
    }

    @Override // com.google.android.gms.tagmanager.zzac
    public void zzE(List<zzaq> list) {
        int iMin = Math.min(list.size(), 40);
        boolean z = true;
        int i = 0;
        while (i < iMin) {
            zzaq zzaqVar = list.get(i);
            URL urlZzd = zzd(zzaqVar);
            if (urlZzd == null) {
                zzbg.zzaK("No destination: discarding hit.");
                this.zzbli.zzb(zzaqVar);
            } else {
                try {
                    HttpURLConnection httpURLConnectionZzd = this.zzblh.zzd(urlZzd);
                    if (z) {
                        try {
                            zzbl.zzbb(this.mContext);
                            z = false;
                        } catch (Throwable th) {
                            boolean z2 = z;
                            try {
                                httpURLConnectionZzd.disconnect();
                                throw th;
                            } catch (IOException e) {
                                z = z2;
                                e = e;
                                zzbg.zzaK("Exception sending hit: " + e.getClass().getSimpleName());
                                zzbg.zzaK(e.getMessage());
                                this.zzbli.zzc(zzaqVar);
                                i++;
                                z = z;
                            }
                        }
                    }
                    httpURLConnectionZzd.setRequestProperty("User-Agent", this.zzzN);
                    int responseCode = httpURLConnectionZzd.getResponseCode();
                    if (responseCode != 200) {
                        zzbg.zzaK("Bad response: " + responseCode);
                        this.zzbli.zzc(zzaqVar);
                    } else {
                        this.zzbli.zza(zzaqVar);
                    }
                    httpURLConnectionZzd.disconnect();
                } catch (IOException e2) {
                    e = e2;
                }
            }
            i++;
            z = z;
        }
    }

    @Override // com.google.android.gms.tagmanager.zzac
    public boolean zzGw() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        zzbg.v("...no network connectivity");
        return false;
    }

    String zza(String str, String str2, String str3, String str4, String str5, String str6) {
        return String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", str, str2, str3, str4, str5, str6);
    }

    URL zzd(zzaq zzaqVar) {
        try {
            return new URL(zzaqVar.zzGF());
        } catch (MalformedURLException e) {
            zzbg.e("Error trying to parse the GTM url.");
            return null;
        }
    }
}
