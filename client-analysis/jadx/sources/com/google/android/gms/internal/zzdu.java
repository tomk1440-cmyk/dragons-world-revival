package com.google.android.gms.internal;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzdu extends zzdr {
    private static final Set<String> zzzX = Collections.synchronizedSet(new HashSet());
    private static final DecimalFormat zzzY = new DecimalFormat("#,###");
    private boolean zzAa;
    private File zzzZ;

    public zzdu(zzjp zzjpVar) {
        super(zzjpVar);
        File cacheDir = this.mContext.getCacheDir();
        if (cacheDir == null) {
            zzin.zzaK("Context.getCacheDir() returned null");
            return;
        }
        this.zzzZ = new File(cacheDir, "admobVideoStreams");
        if (!this.zzzZ.isDirectory() && !this.zzzZ.mkdirs()) {
            zzin.zzaK("Could not create preload cache directory at " + this.zzzZ.getAbsolutePath());
            this.zzzZ = null;
        } else {
            if (this.zzzZ.setReadable(true, false) && this.zzzZ.setExecutable(true, false)) {
                return;
            }
            zzin.zzaK("Could not set cache file permissions at " + this.zzzZ.getAbsolutePath());
            this.zzzZ = null;
        }
    }

    private File zza(File file) {
        return new File(this.zzzZ, file.getName() + ".done");
    }

    private static void zzb(File file) {
        if (file.isFile()) {
            file.setLastModified(System.currentTimeMillis());
        } else {
            try {
                file.createNewFile();
            } catch (IOException e) {
            }
        }
    }

    @Override // com.google.android.gms.internal.zzdr
    public void abort() {
        this.zzAa = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v26 */
    /* JADX WARN: Type inference failed for: r3v27, types: [java.lang.String] */
    @Override // com.google.android.gms.internal.zzdr
    public boolean zzU(String str) {
        String strOpenConnection;
        String absolutePath;
        boolean z;
        int responseCode;
        if (this.zzzZ == null) {
            zza(str, null, "noCacheDir", null);
            return false;
        }
        while (zzea() > zzbt.zzvO.get().intValue()) {
            if (!zzeb()) {
                zzin.zzaK("Unable to expire stream cache");
                zza(str, null, "expireFailed", null);
                return false;
            }
        }
        File file = new File(this.zzzZ, zzV(str));
        File fileZza = zza(file);
        if (file.isFile() && fileZza.isFile()) {
            int length = (int) file.length();
            zzin.zzaI("Stream cache hit at " + str);
            zza(str, file.getAbsolutePath(), length);
            return true;
        }
        String str2 = this.zzzZ.getAbsolutePath() + str;
        synchronized (zzzX) {
            if (zzzX.contains(str2)) {
                zzin.zzaK("Stream cache already in progress at " + str);
                zza(str, file.getAbsolutePath(), "inProgress", null);
                z = false;
            } else {
                zzzX.add(str2);
                FileOutputStream fileOutputStream = null;
                try {
                    strOpenConnection = new URL(str).openConnection();
                    int iIntValue = zzbt.zzvT.get().intValue();
                    strOpenConnection.setConnectTimeout(iIntValue);
                    strOpenConnection.setReadTimeout(iIntValue);
                    if (!(strOpenConnection instanceof HttpURLConnection) || (responseCode = ((HttpURLConnection) strOpenConnection).getResponseCode()) < 400) {
                        int contentLength = strOpenConnection.getContentLength();
                        if (contentLength < 0) {
                            zzin.zzaK("Stream cache aborted, missing content-length header at " + str);
                            zza(str, file.getAbsolutePath(), "contentLengthMissing", null);
                            zzzX.remove(str2);
                            z = false;
                        } else {
                            String str3 = zzzY.format(contentLength);
                            int iIntValue2 = zzbt.zzvP.get().intValue();
                            if (contentLength > iIntValue2) {
                                zzin.zzaK("Content length " + str3 + " exceeds limit at " + str);
                                zza(str, file.getAbsolutePath(), "sizeExceeded", "File too big for full file cache. Size: " + str3);
                                zzzX.remove(str2);
                                z = false;
                            } else {
                                StringBuilder sbAppend = new StringBuilder().append("Caching ").append(str3);
                                absolutePath = " bytes from ";
                                zzin.zzaI(sbAppend.append(" bytes from ").append(str).toString());
                                ReadableByteChannel readableByteChannelNewChannel = Channels.newChannel(strOpenConnection.getInputStream());
                                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                                try {
                                    FileChannel channel = fileOutputStream2.getChannel();
                                    ByteBuffer byteBufferAllocate = ByteBuffer.allocate(1048576);
                                    zzmq zzmqVarZzbG = com.google.android.gms.ads.internal.zzr.zzbG();
                                    int i = 0;
                                    long jCurrentTimeMillis = zzmqVarZzbG.currentTimeMillis();
                                    zziz zzizVar = new zziz(zzbt.zzvS.get().longValue());
                                    long jLongValue = zzbt.zzvR.get().longValue();
                                    while (true) {
                                        int i2 = readableByteChannelNewChannel.read(byteBufferAllocate);
                                        if (i2 >= 0) {
                                            i += i2;
                                            try {
                                                try {
                                                    if (i > iIntValue2) {
                                                        String str4 = "File too big for full file cache. Size: " + Integer.toString(i);
                                                        throw new IOException("stream cache file size limit exceeded");
                                                    }
                                                    byteBufferAllocate.flip();
                                                    while (channel.write(byteBufferAllocate) > 0) {
                                                    }
                                                    byteBufferAllocate.clear();
                                                    if (zzmqVarZzbG.currentTimeMillis() - jCurrentTimeMillis > 1000 * jLongValue) {
                                                        String str5 = "Timeout exceeded. Limit: " + Long.toString(jLongValue) + " sec";
                                                        throw new IOException("stream cache time limit exceeded");
                                                    }
                                                    if (this.zzAa) {
                                                        throw new IOException("abort requested");
                                                    }
                                                    if (zzizVar.tryAcquire()) {
                                                        absolutePath = file.getAbsolutePath();
                                                        strOpenConnection = str;
                                                        zza(strOpenConnection, absolutePath, i, contentLength, false);
                                                    }
                                                } catch (IOException e) {
                                                    e = e;
                                                    strOpenConnection = 0;
                                                    fileOutputStream = fileOutputStream2;
                                                } catch (RuntimeException e2) {
                                                    e = e2;
                                                    strOpenConnection = 0;
                                                    fileOutputStream = fileOutputStream2;
                                                }
                                            } catch (IOException e3) {
                                                e = e3;
                                                fileOutputStream = fileOutputStream2;
                                            } catch (RuntimeException e4) {
                                                e = e4;
                                                fileOutputStream = fileOutputStream2;
                                            }
                                        } else {
                                            fileOutputStream2.close();
                                            if (zzin.zzQ(3)) {
                                                zzin.zzaI("Preloaded " + zzzY.format(i) + " bytes from " + str);
                                            }
                                            file.setReadable(true, false);
                                            zzb(fileZza);
                                            zza(str, file.getAbsolutePath(), i);
                                            zzzX.remove(str2);
                                            z = true;
                                        }
                                    }
                                } catch (IOException e5) {
                                    e = e5;
                                    strOpenConnection = 0;
                                    absolutePath = "error";
                                    fileOutputStream = fileOutputStream2;
                                } catch (RuntimeException e6) {
                                    e = e6;
                                    strOpenConnection = 0;
                                    absolutePath = "error";
                                    fileOutputStream = fileOutputStream2;
                                }
                            }
                        }
                    } else {
                        absolutePath = "badUrl";
                        try {
                            strOpenConnection = "HTTP request failed. Code: " + Integer.toString(responseCode);
                            try {
                                throw new IOException("HTTP status code " + responseCode + " at " + str);
                            } catch (IOException e7) {
                                e = e7;
                            } catch (RuntimeException e8) {
                                e = e8;
                            }
                        } catch (IOException e9) {
                            e = e9;
                            strOpenConnection = 0;
                        } catch (RuntimeException e10) {
                            e = e10;
                            strOpenConnection = 0;
                        }
                    }
                } catch (IOException e11) {
                    e = e11;
                    strOpenConnection = 0;
                    absolutePath = "error";
                } catch (RuntimeException e12) {
                    e = e12;
                    strOpenConnection = 0;
                    absolutePath = "error";
                }
                if (e instanceof RuntimeException) {
                    com.google.android.gms.ads.internal.zzr.zzbF().zzb(e, true);
                }
                try {
                    fileOutputStream.close();
                } catch (IOException e13) {
                } catch (NullPointerException e14) {
                }
                if (this.zzAa) {
                    zzin.zzaJ("Preload aborted for URL \"" + str + "\"");
                } else {
                    zzin.zzd("Preload failed for URL \"" + str + "\"", e);
                }
                if (file.exists() && !file.delete()) {
                    zzin.zzaK("Could not delete partial cache file at " + file.getAbsolutePath());
                }
                zza(str, file.getAbsolutePath(), absolutePath, strOpenConnection);
                zzzX.remove(str2);
                z = false;
            }
        }
        return z;
    }

    public int zzea() {
        int i = 0;
        if (this.zzzZ != null) {
            for (File file : this.zzzZ.listFiles()) {
                if (!file.getName().endsWith(".done")) {
                    i++;
                }
            }
        }
        return i;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x004c  */
    public boolean zzeb() {
        boolean zDelete;
        long jLastModified;
        File file;
        if (this.zzzZ == null) {
            return false;
        }
        File file2 = null;
        long j = Long.MAX_VALUE;
        File[] fileArrListFiles = this.zzzZ.listFiles();
        int length = fileArrListFiles.length;
        int i = 0;
        while (i < length) {
            File file3 = fileArrListFiles[i];
            if (file3.getName().endsWith(".done")) {
                jLastModified = j;
                file = file2;
            } else {
                jLastModified = file3.lastModified();
                if (jLastModified < j) {
                    file = file3;
                } else {
                    jLastModified = j;
                    file = file2;
                }
            }
            i++;
            file2 = file;
            j = jLastModified;
        }
        if (file2 != null) {
            zDelete = file2.delete();
            File fileZza = zza(file2);
            if (fileZza.isFile()) {
                zDelete &= fileZza.delete();
            }
        } else {
            zDelete = false;
        }
        return zDelete;
    }
}
