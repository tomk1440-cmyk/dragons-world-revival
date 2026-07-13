package com.google.android.gms.analytics.internal;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes.dex */
class zzah extends zzd {
    private static final byte[] zzTd = "\n".getBytes();
    private final zzaj zzTc;
    private final String zzzN;

    private class zza {
        private int zzTe;
        private ByteArrayOutputStream zzTf = new ByteArrayOutputStream();

        public zza() {
        }

        public byte[] getPayload() {
            return this.zzTf.toByteArray();
        }

        public boolean zzj(zzab zzabVar) {
            com.google.android.gms.common.internal.zzx.zzz(zzabVar);
            if (this.zzTe + 1 > zzah.this.zzjn().zzkD()) {
                return false;
            }
            String strZza = zzah.this.zza(zzabVar, false);
            if (strZza == null) {
                zzah.this.zzjm().zza(zzabVar, "Error formatting hit");
                return true;
            }
            byte[] bytes = strZza.getBytes();
            int length = bytes.length;
            if (length > zzah.this.zzjn().zzkv()) {
                zzah.this.zzjm().zza(zzabVar, "Hit size exceeds the maximum size limit");
                return true;
            }
            if (this.zzTf.size() > 0) {
                length++;
            }
            if (length + this.zzTf.size() > zzah.this.zzjn().zzkx()) {
                return false;
            }
            try {
                if (this.zzTf.size() > 0) {
                    this.zzTf.write(zzah.zzTd);
                }
                this.zzTf.write(bytes);
                this.zzTe++;
                return true;
            } catch (IOException e) {
                zzah.this.zze("Failed to write payload when batching hits", e);
                return true;
            }
        }

        public int zzlE() {
            return this.zzTe;
        }
    }

    zzah(zzf zzfVar) {
        super(zzfVar);
        this.zzzN = zza("GoogleAnalytics", zze.VERSION, Build.VERSION.RELEASE, zzam.zza(Locale.getDefault()), Build.MODEL, Build.ID);
        this.zzTc = new zzaj(zzfVar.zzjl());
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0087  */
    /* JADX WARN: Code duplicated, block: B:48:0x0082 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r2v9 */
    private int zza(URL url, byte[] bArr) throws Throwable {
        HttpURLConnection httpURLConnectionZzc;
        int responseCode;
        OutputStream outputStream = null;
        com.google.android.gms.common.internal.zzx.zzz(url);
        com.google.android.gms.common.internal.zzx.zzz(bArr);
        Integer numValueOf = Integer.valueOf(bArr.length);
        zzb("POST bytes, url", numValueOf, url);
        ?? r2 = numValueOf;
        if (zzhp()) {
            String str = new String(bArr);
            zza("Post payload\n", str);
            r2 = str;
        }
        try {
            try {
                httpURLConnectionZzc = zzc(url);
                try {
                    httpURLConnectionZzc.setDoOutput(true);
                    httpURLConnectionZzc.setFixedLengthStreamingMode(bArr.length);
                    httpURLConnectionZzc.connect();
                    outputStream = httpURLConnectionZzc.getOutputStream();
                    outputStream.write(bArr);
                    zzb(httpURLConnectionZzc);
                    responseCode = httpURLConnectionZzc.getResponseCode();
                    if (responseCode == 200) {
                        zziH().zzjh();
                    }
                    zzb("POST status", Integer.valueOf(responseCode));
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e) {
                            zze("Error closing http post connection output stream", e);
                        }
                    }
                    if (httpURLConnectionZzc != null) {
                        httpURLConnectionZzc.disconnect();
                    }
                } catch (IOException e2) {
                    e = e2;
                    zzd("Network POST connection error", e);
                    responseCode = 0;
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e3) {
                            zze("Error closing http post connection output stream", e3);
                        }
                    }
                    if (httpURLConnectionZzc != null) {
                        httpURLConnectionZzc.disconnect();
                    }
                }
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    try {
                        outputStream.close();
                    } catch (IOException e4) {
                        zze("Error closing http post connection output stream", e4);
                    }
                }
                if (r2 != 0) {
                    r2.disconnect();
                }
                throw th;
            }
        } catch (IOException e5) {
            e = e5;
            httpURLConnectionZzc = null;
        } catch (Throwable th2) {
            th = th2;
            r2 = 0;
            if (0 != 0) {
                outputStream.close();
            }
            if (r2 != 0) {
                r2.disconnect();
            }
            throw th;
        }
        return responseCode;
    }

    private static String zza(String str, String str2, String str3, String str4, String str5, String str6) {
        return String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", str, str2, str3, str4, str5, str6);
    }

    private void zza(StringBuilder sb, String str, String str2) throws UnsupportedEncodingException {
        if (sb.length() != 0) {
            sb.append('&');
        }
        sb.append(URLEncoder.encode(str, "UTF-8"));
        sb.append('=');
        sb.append(URLEncoder.encode(str2, "UTF-8"));
    }

    private int zzb(URL url) {
        int responseCode;
        com.google.android.gms.common.internal.zzx.zzz(url);
        zzb("GET request", url);
        HttpURLConnection httpURLConnectionZzc = null;
        try {
            httpURLConnectionZzc = zzc(url);
            httpURLConnectionZzc.connect();
            zzb(httpURLConnectionZzc);
            responseCode = httpURLConnectionZzc.getResponseCode();
            if (responseCode == 200) {
                zziH().zzjh();
            }
            zzb("GET status", Integer.valueOf(responseCode));
        } catch (IOException e) {
            zzd("Network GET connection error", e);
            responseCode = 0;
        } finally {
            if (httpURLConnectionZzc != null) {
                httpURLConnectionZzc.disconnect();
            }
        }
        return responseCode;
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:60:0x00c3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    private int zzb(URL url, byte[] bArr) throws Throwable {
        HttpURLConnection httpURLConnectionZzc;
        HttpURLConnection httpURLConnection;
        int responseCode;
        OutputStream outputStream = null;
        com.google.android.gms.common.internal.zzx.zzz(url);
        com.google.android.gms.common.internal.zzx.zzz(bArr);
        try {
            byte[] bArrZzg = zzg(bArr);
            zza("POST compressed size, ratio %, url", Integer.valueOf(bArrZzg.length), Long.valueOf((100 * ((long) bArrZzg.length)) / ((long) bArr.length)), url);
            if (bArrZzg.length > bArr.length) {
                zzc("Compressed payload is larger then uncompressed. compressed, uncompressed", Integer.valueOf(bArrZzg.length), Integer.valueOf(bArr.length));
            }
            if (zzhp()) {
                zza("Post payload", "\n" + new String(bArr));
            }
            httpURLConnectionZzc = zzc(url);
            try {
                httpURLConnectionZzc.setDoOutput(true);
                httpURLConnectionZzc.addRequestProperty(HttpRequest.HEADER_CONTENT_ENCODING, HttpRequest.ENCODING_GZIP);
                httpURLConnectionZzc.setFixedLengthStreamingMode(bArrZzg.length);
                httpURLConnectionZzc.connect();
                OutputStream outputStream2 = httpURLConnectionZzc.getOutputStream();
                try {
                    outputStream2.write(bArrZzg);
                    outputStream2.close();
                    OutputStream outputStream3 = null;
                    zzb(httpURLConnectionZzc);
                    responseCode = httpURLConnectionZzc.getResponseCode();
                    if (responseCode == 200) {
                        zziH().zzjh();
                    }
                    zzb("POST status", Integer.valueOf(responseCode));
                    if (0 != 0) {
                        try {
                            outputStream3.close();
                        } catch (IOException e) {
                            zze("Error closing http compressed post connection output stream", e);
                        }
                    }
                    if (httpURLConnectionZzc != null) {
                        httpURLConnectionZzc.disconnect();
                    }
                } catch (IOException e2) {
                    e = e2;
                    outputStream = outputStream2;
                    httpURLConnection = httpURLConnectionZzc;
                    try {
                        zzd("Network compressed POST connection error", e);
                        responseCode = 0;
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e3) {
                                zze("Error closing http compressed post connection output stream", e3);
                            }
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                    } catch (Throwable th) {
                        th = th;
                        httpURLConnectionZzc = httpURLConnection;
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e4) {
                                zze("Error closing http compressed post connection output stream", e4);
                            }
                        }
                        if (httpURLConnectionZzc != null) {
                            httpURLConnectionZzc.disconnect();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    outputStream = outputStream2;
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (httpURLConnectionZzc != null) {
                        httpURLConnectionZzc.disconnect();
                    }
                    throw th;
                }
            } catch (IOException e5) {
                e = e5;
                httpURLConnection = httpURLConnectionZzc;
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (IOException e6) {
            e = e6;
            httpURLConnection = null;
        } catch (Throwable th4) {
            th = th4;
            httpURLConnectionZzc = null;
        }
        return responseCode;
    }

    private URL zzb(zzab zzabVar, String str) {
        try {
            return new URL(zzabVar.zzlt() ? zzjn().zzkF() + zzjn().zzkH() + "?" + str : zzjn().zzkG() + zzjn().zzkH() + "?" + str);
        } catch (MalformedURLException e) {
            zze("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    private void zzb(HttpURLConnection httpURLConnection) throws IOException {
        InputStream inputStream = null;
        try {
            inputStream = httpURLConnection.getInputStream();
            do {
            } while (inputStream.read(new byte[1024]) > 0);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    zze("Error closing http connection input stream", e);
                }
            }
        }
    }

    private boolean zzg(zzab zzabVar) {
        com.google.android.gms.common.internal.zzx.zzz(zzabVar);
        String strZza = zza(zzabVar, !zzabVar.zzlt());
        if (strZza == null) {
            zzjm().zza(zzabVar, "Error formatting hit for upload");
            return true;
        }
        if (strZza.length() <= zzjn().zzku()) {
            URL urlZzb = zzb(zzabVar, strZza);
            if (urlZzb != null) {
                return zzb(urlZzb) == 200;
            }
            zzbh("Failed to build collect GET endpoint url");
            return false;
        }
        String strZza2 = zza(zzabVar, false);
        if (strZza2 == null) {
            zzjm().zza(zzabVar, "Error formatting hit for POST upload");
            return true;
        }
        byte[] bytes = strZza2.getBytes();
        if (bytes.length > zzjn().zzkw()) {
            zzjm().zza(zzabVar, "Hit payload exceeds size limit");
            return true;
        }
        URL urlZzh = zzh(zzabVar);
        if (urlZzh != null) {
            return zza(urlZzh, bytes) == 200;
        }
        zzbh("Failed to build collect POST endpoint url");
        return false;
    }

    private static byte[] zzg(byte[] bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(bArr);
        gZIPOutputStream.close();
        byteArrayOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    private URL zzh(zzab zzabVar) {
        try {
            return new URL(zzabVar.zzlt() ? zzjn().zzkF() + zzjn().zzkH() : zzjn().zzkG() + zzjn().zzkH());
        } catch (MalformedURLException e) {
            zze("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    private String zzi(zzab zzabVar) {
        return String.valueOf(zzabVar.zzlq());
    }

    private URL zzlC() {
        try {
            return new URL(zzjn().zzkF() + zzjn().zzkI());
        } catch (MalformedURLException e) {
            zze("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    String zza(zzab zzabVar, boolean z) {
        com.google.android.gms.common.internal.zzx.zzz(zzabVar);
        StringBuilder sb = new StringBuilder();
        try {
            for (Map.Entry<String, String> entry : zzabVar.zzn().entrySet()) {
                String key = entry.getKey();
                if (!"ht".equals(key) && !"qt".equals(key) && !"AppUID".equals(key) && !"z".equals(key) && !"_gmsv".equals(key)) {
                    zza(sb, key, entry.getValue());
                }
            }
            zza(sb, "ht", String.valueOf(zzabVar.zzlr()));
            zza(sb, "qt", String.valueOf(zzjl().currentTimeMillis() - zzabVar.zzlr()));
            if (zzjn().zzkr()) {
                zza(sb, "_gmsv", zze.VERSION);
            }
            if (z) {
                long jZzlu = zzabVar.zzlu();
                zza(sb, "z", jZzlu != 0 ? String.valueOf(jZzlu) : zzi(zzabVar));
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            zze("Failed to encode name or value", e);
            return null;
        }
    }

    List<Long> zza(List<zzab> list, boolean z) {
        com.google.android.gms.common.internal.zzx.zzac(!list.isEmpty());
        zza("Uploading batched hits. compression, count", Boolean.valueOf(z), Integer.valueOf(list.size()));
        zza zzaVar = new zza();
        ArrayList arrayList = new ArrayList();
        for (zzab zzabVar : list) {
            if (!zzaVar.zzj(zzabVar)) {
                break;
            }
            arrayList.add(Long.valueOf(zzabVar.zzlq()));
        }
        if (zzaVar.zzlE() == 0) {
            return arrayList;
        }
        URL urlZzlC = zzlC();
        if (urlZzlC == null) {
            zzbh("Failed to build batching endpoint url");
            return Collections.emptyList();
        }
        int iZzb = z ? zzb(urlZzlC, zzaVar.getPayload()) : zza(urlZzlC, zzaVar.getPayload());
        if (200 == iZzb) {
            zza("Batched upload completed. Hits batched", Integer.valueOf(zzaVar.zzlE()));
            return arrayList;
        }
        zza("Network error uploading hits. status code", Integer.valueOf(iZzb));
        if (zzjn().zzkL().contains(Integer.valueOf(iZzb))) {
            zzbg("Server instructed the client to stop batching");
            this.zzTc.start();
        }
        return Collections.emptyList();
    }

    HttpURLConnection zzc(URL url) throws IOException {
        URLConnection uRLConnectionOpenConnection = url.openConnection();
        if (!(uRLConnectionOpenConnection instanceof HttpURLConnection)) {
            throw new IOException("Failed to obtain http connection");
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
        httpURLConnection.setDefaultUseCaches(false);
        httpURLConnection.setConnectTimeout(zzjn().zzkU());
        httpURLConnection.setReadTimeout(zzjn().zzkV());
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestProperty("User-Agent", this.zzzN);
        httpURLConnection.setDoInput(true);
        return httpURLConnection;
    }

    @Override // com.google.android.gms.analytics.internal.zzd
    protected void zziJ() {
        zza("Network initialized. User agent", this.zzzN);
    }

    public boolean zzlB() {
        NetworkInfo activeNetworkInfo;
        zzjk();
        zzjv();
        try {
            activeNetworkInfo = ((ConnectivityManager) getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (SecurityException e) {
            activeNetworkInfo = null;
        }
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        zzbd("No network connectivity");
        return false;
    }

    public List<Long> zzq(List<zzab> list) {
        boolean z;
        boolean z2 = true;
        zzjk();
        zzjv();
        com.google.android.gms.common.internal.zzx.zzz(list);
        if (zzjn().zzkL().isEmpty() || !this.zzTc.zzv(zzjn().zzkE() * 1000)) {
            z2 = false;
            z = false;
        } else {
            z = zzjn().zzkJ() != zzm.NONE;
            if (zzjn().zzkK() != zzo.GZIP) {
                z2 = false;
            }
        }
        return z ? zza(list, z2) : zzr(list);
    }

    List<Long> zzr(List<zzab> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (zzab zzabVar : list) {
            if (!zzg(zzabVar)) {
                break;
            }
            arrayList.add(Long.valueOf(zzabVar.zzlq()));
            if (arrayList.size() >= zzjn().zzkC()) {
                break;
            }
        }
        return arrayList;
    }
}
