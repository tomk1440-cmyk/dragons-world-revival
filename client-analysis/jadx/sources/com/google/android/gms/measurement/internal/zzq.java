package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.WorkerThread;
import com.google.android.gms.internal.zzmq;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class zzq extends zzz {

    @WorkerThread
    interface zza {
        void zza(String str, int i, Throwable th, byte[] bArr);
    }

    @WorkerThread
    private static class zzb implements Runnable {
        private final int zzBc;
        private final String zzTJ;
        private final zza zzaWP;
        private final Throwable zzaWQ;
        private final byte[] zzaWR;

        private zzb(String str, zza zzaVar, int i, Throwable th, byte[] bArr) {
            com.google.android.gms.common.internal.zzx.zzz(zzaVar);
            this.zzaWP = zzaVar;
            this.zzBc = i;
            this.zzaWQ = th;
            this.zzaWR = bArr;
            this.zzTJ = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.zzaWP.zza(this.zzTJ, this.zzBc, this.zzaWQ, this.zzaWR);
        }
    }

    @WorkerThread
    private class zzc implements Runnable {
        private final String zzTJ;
        private final byte[] zzaWS;
        private final zza zzaWT;
        private final Map<String, String> zzaWU;
        private final URL zzzq;

        public zzc(String str, URL url, byte[] bArr, Map<String, String> map, zza zzaVar) {
            com.google.android.gms.common.internal.zzx.zzcM(str);
            com.google.android.gms.common.internal.zzx.zzz(url);
            com.google.android.gms.common.internal.zzx.zzz(zzaVar);
            this.zzzq = url;
            this.zzaWS = bArr;
            this.zzaWT = zzaVar;
            this.zzTJ = str;
            this.zzaWU = map;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() throws Throwable {
            Throwable th;
            HttpURLConnection httpURLConnectionZzc;
            OutputStream outputStream;
            int i;
            HttpURLConnection httpURLConnection;
            Object[] objArr = 0;
            Object[] objArr2 = 0;
            Object[] objArr3 = 0;
            Object[] objArr4 = 0;
            Object[] objArr5 = 0;
            Object[] objArr6 = 0;
            Object[] objArr7 = 0;
            Object[] objArr8 = 0;
            zzq.this.zzCd();
            int responseCode = 0;
            try {
                httpURLConnectionZzc = zzq.this.zzc(this.zzzq);
                try {
                    if (this.zzaWU != null) {
                        for (Map.Entry<String, String> entry : this.zzaWU.entrySet()) {
                            httpURLConnectionZzc.addRequestProperty(entry.getKey(), entry.getValue());
                        }
                    }
                    if (this.zzaWS != null) {
                        byte[] bArrZzg = zzq.this.zzCk().zzg(this.zzaWS);
                        zzq.this.zzAo().zzCK().zzj("Uploading data. size", Integer.valueOf(bArrZzg.length));
                        httpURLConnectionZzc.setDoOutput(true);
                        httpURLConnectionZzc.addRequestProperty(HttpRequest.HEADER_CONTENT_ENCODING, HttpRequest.ENCODING_GZIP);
                        httpURLConnectionZzc.setFixedLengthStreamingMode(bArrZzg.length);
                        httpURLConnectionZzc.connect();
                        outputStream = httpURLConnectionZzc.getOutputStream();
                        try {
                            outputStream.write(bArrZzg);
                            outputStream.close();
                        } catch (IOException e) {
                            e = e;
                            i = 0;
                            httpURLConnection = httpURLConnectionZzc;
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (IOException e2) {
                                    zzq.this.zzAo().zzCE().zzj("Error closing HTTP compressed POST connection output stream", e2);
                                }
                            }
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            zzq.this.zzCn().zzg(new zzb(this.zzTJ, this.zzaWT, i, e, objArr6 == true ? 1 : 0));
                            return;
                        } catch (Throwable th2) {
                            th = th2;
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (IOException e3) {
                                    zzq.this.zzAo().zzCE().zzj("Error closing HTTP compressed POST connection output stream", e3);
                                }
                            }
                            if (httpURLConnectionZzc != null) {
                                httpURLConnectionZzc.disconnect();
                            }
                            zzq.this.zzCn().zzg(new zzb(this.zzTJ, this.zzaWT, responseCode, objArr4 == true ? 1 : 0, objArr3 == true ? 1 : 0));
                            throw th;
                        }
                    }
                    responseCode = httpURLConnectionZzc.getResponseCode();
                    byte[] bArrZzc = zzq.this.zzc(httpURLConnectionZzc);
                    if (0 != 0) {
                        try {
                            (objArr == true ? 1 : 0).close();
                        } catch (IOException e4) {
                            zzq.this.zzAo().zzCE().zzj("Error closing HTTP compressed POST connection output stream", e4);
                        }
                    }
                    if (httpURLConnectionZzc != null) {
                        httpURLConnectionZzc.disconnect();
                    }
                    zzq.this.zzCn().zzg(new zzb(this.zzTJ, this.zzaWT, responseCode, objArr8 == true ? 1 : 0, bArrZzc));
                } catch (IOException e5) {
                    e = e5;
                    i = responseCode;
                    outputStream = null;
                    httpURLConnection = httpURLConnectionZzc;
                } catch (Throwable th3) {
                    th = th3;
                    outputStream = null;
                }
            } catch (IOException e6) {
                e = e6;
                i = 0;
                outputStream = null;
                httpURLConnection = null;
            } catch (Throwable th4) {
                th = th4;
                httpURLConnectionZzc = null;
                outputStream = null;
            }
        }
    }

    public zzq(zzw zzwVar) {
        super(zzwVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public byte[] zzc(HttpURLConnection httpURLConnection) throws IOException {
        InputStream inputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            inputStream = httpURLConnection.getInputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int i = inputStream.read(bArr);
                if (i <= 0) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, i);
            }
            return byteArrayOutputStream.toByteArray();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzp zzAo() {
        return super.zzAo();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ void zzCd() {
        super.zzCd();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ com.google.android.gms.measurement.internal.zzc zzCe() {
        return super.zzCe();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzab zzCf() {
        return super.zzCf();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzn zzCg() {
        return super.zzCg();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzg zzCh() {
        return super.zzCh();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzac zzCi() {
        return super.zzCi();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zze zzCj() {
        return super.zzCj();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzaj zzCk() {
        return super.zzCk();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzu zzCl() {
        return super.zzCl();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzad zzCm() {
        return super.zzCm();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzv zzCn() {
        return super.zzCn();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzt zzCo() {
        return super.zzCo();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzd zzCp() {
        return super.zzCp();
    }

    @WorkerThread
    public void zza(String str, URL url, Map<String, String> map, zza zzaVar) {
        zzjk();
        zzjv();
        com.google.android.gms.common.internal.zzx.zzz(url);
        com.google.android.gms.common.internal.zzx.zzz(zzaVar);
        zzCn().zzh(new zzc(str, url, null, map, zzaVar));
    }

    @WorkerThread
    public void zza(String str, URL url, byte[] bArr, Map<String, String> map, zza zzaVar) {
        zzjk();
        zzjv();
        com.google.android.gms.common.internal.zzx.zzz(url);
        com.google.android.gms.common.internal.zzx.zzz(bArr);
        com.google.android.gms.common.internal.zzx.zzz(zzaVar);
        zzCn().zzh(new zzc(str, url, bArr, map, zzaVar));
    }

    @WorkerThread
    protected HttpURLConnection zzc(URL url) throws IOException {
        URLConnection uRLConnectionOpenConnection = url.openConnection();
        if (!(uRLConnectionOpenConnection instanceof HttpURLConnection)) {
            throw new IOException("Failed to obtain HTTP connection");
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
        httpURLConnection.setDefaultUseCaches(false);
        httpURLConnection.setConnectTimeout((int) zzCp().zzBO());
        httpURLConnection.setReadTimeout((int) zzCp().zzBP());
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setDoInput(true);
        return httpURLConnection;
    }

    @Override // com.google.android.gms.measurement.internal.zzz
    protected void zziJ() {
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ void zzjj() {
        super.zzjj();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ void zzjk() {
        super.zzjk();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzmq zzjl() {
        return super.zzjl();
    }

    public boolean zzlB() {
        NetworkInfo activeNetworkInfo;
        zzjv();
        try {
            activeNetworkInfo = ((ConnectivityManager) getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (SecurityException e) {
            activeNetworkInfo = null;
        }
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
