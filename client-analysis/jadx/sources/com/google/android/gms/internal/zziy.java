package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public final class zziy extends zzim {
    private final Context mContext;
    private final String zzF;
    private final String zzsy;
    private String zzzN;

    public zziy(Context context, String str, String str2) {
        this.zzzN = null;
        this.mContext = context;
        this.zzsy = str;
        this.zzF = str2;
    }

    public zziy(Context context, String str, String str2, String str3) {
        this.zzzN = null;
        this.mContext = context;
        this.zzsy = str;
        this.zzF = str2;
        this.zzzN = str3;
    }

    @Override // com.google.android.gms.internal.zzim
    public void onStop() {
    }

    @Override // com.google.android.gms.internal.zzim
    public void zzbr() {
        try {
            zzin.v("Pinging URL: " + this.zzF);
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.zzF).openConnection();
            try {
                if (TextUtils.isEmpty(this.zzzN)) {
                    com.google.android.gms.ads.internal.zzr.zzbC().zza(this.mContext, this.zzsy, true, httpURLConnection);
                } else {
                    com.google.android.gms.ads.internal.zzr.zzbC().zza(this.mContext, this.zzsy, true, httpURLConnection, this.zzzN);
                }
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode < 200 || responseCode >= 300) {
                    zzin.zzaK("Received non-success response code " + responseCode + " from pinging URL: " + this.zzF);
                }
            } finally {
                httpURLConnection.disconnect();
            }
        } catch (IOException e) {
            zzin.zzaK("Error while pinging URL: " + this.zzF + ". " + e.getMessage());
        } catch (IndexOutOfBoundsException e2) {
            zzin.zzaK("Error while parsing ping URL: " + this.zzF + ". " + e2.getMessage());
        } catch (RuntimeException e3) {
            zzin.zzaK("Error while pinging URL: " + this.zzF + ". " + e3.getMessage());
        }
    }
}
