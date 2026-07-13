package com.google.android.gms.analytics.internal;

import android.content.Context;
import com.facebook.appevents.AppEventsConstants;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes.dex */
public class zzn extends zzd {
    private volatile String zzPO;
    private Future<String> zzRr;

    protected zzn(zzf zzfVar) {
        super(zzfVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean zzh(Context context, String str) {
        boolean z = false;
        com.google.android.gms.common.internal.zzx.zzcM(str);
        com.google.android.gms.common.internal.zzx.zzcE("ClientId should be saved from worker thread");
        FileOutputStream fileOutputStreamOpenFileOutput = 0;
        fileOutputStreamOpenFileOutput = 0;
        fileOutputStreamOpenFileOutput = 0;
        try {
            zza("Storing clientId", str);
            fileOutputStreamOpenFileOutput = context.openFileOutput("gaClientId", 0);
            fileOutputStreamOpenFileOutput.write(str.getBytes());
            z = true;
            fileOutputStreamOpenFileOutput = fileOutputStreamOpenFileOutput;
        } catch (IOException e) {
            zze("Error writing to clientId file", e);
            fileOutputStreamOpenFileOutput = fileOutputStreamOpenFileOutput;
        } catch (FileNotFoundException e2) {
            zze("Error creating clientId file", e2);
            fileOutputStreamOpenFileOutput = fileOutputStreamOpenFileOutput;
        } finally {
            if (fileOutputStreamOpenFileOutput != 0) {
                try {
                    fileOutputStreamOpenFileOutput.close();
                } catch (IOException e3) {
                    zze("Failed to close clientId writing stream", e3);
                }
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String zzkn() {
        String strZzko = zzko();
        try {
            return !zzh(zzjo().getContext(), strZzko) ? AppEventsConstants.EVENT_PARAM_VALUE_NO : strZzko;
        } catch (Exception e) {
            zze("Error saving clientId file", e);
            return AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }
    }

    /* JADX INFO: Removed unreachable split cross block B:70:0x002e */
    /* JADX WARN: Code duplicated, block: B:61:0x009d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v8 */
    protected String zzac(Context context) throws Throwable {
        ?? r2;
        Throwable th;
        FileInputStream fileInputStreamOpenFileInput;
        FileInputStream fileInputStream;
        Object obj;
        String str = null;
        com.google.android.gms.common.internal.zzx.zzcE("ClientId should be loaded from worker thread");
        try {
            try {
                fileInputStreamOpenFileInput = context.openFileInput("gaClientId");
                try {
                    byte[] bArr = new byte[36];
                    int i = fileInputStreamOpenFileInput.read(bArr, 0, bArr.length);
                    if (fileInputStreamOpenFileInput.available() > 0) {
                        zzbg("clientId file seems corrupted, deleting it.");
                        fileInputStreamOpenFileInput.close();
                        context.deleteFile("gaClientId");
                        if (fileInputStreamOpenFileInput != null) {
                            try {
                                r2 = fileInputStreamOpenFileInput;
                                fileInputStreamOpenFileInput.close();
                                r2 = fileInputStreamOpenFileInput;
                            } catch (IOException e) {
                                zze("Failed to close client id reading stream", e);
                                r2 = "Failed to close client id reading stream";
                            }
                        }
                    } else if (i < 14) {
                        zzbg("clientId file is empty, deleting it.");
                        fileInputStreamOpenFileInput.close();
                        context.deleteFile("gaClientId");
                        if (fileInputStreamOpenFileInput != null) {
                            try {
                                r2 = fileInputStreamOpenFileInput;
                                fileInputStreamOpenFileInput.close();
                                r2 = fileInputStreamOpenFileInput;
                            } catch (IOException e2) {
                                zze("Failed to close client id reading stream", e2);
                                r2 = "Failed to close client id reading stream";
                            }
                        }
                    } else {
                        fileInputStreamOpenFileInput.close();
                        String str2 = new String(bArr, 0, i);
                        zza("Read client id from disk", str2);
                        if (fileInputStreamOpenFileInput != null) {
                            try {
                                obj = fileInputStreamOpenFileInput;
                                fileInputStreamOpenFileInput.close();
                                obj = fileInputStreamOpenFileInput;
                            } catch (IOException e3) {
                                zze("Failed to close client id reading stream", e3);
                                obj = "Failed to close client id reading stream";
                            }
                        }
                        obj = fileInputStreamOpenFileInput;
                        str = str2;
                        r2 = obj;
                    }
                } catch (FileNotFoundException e4) {
                    fileInputStream = fileInputStreamOpenFileInput;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e5) {
                            zze("Failed to close client id reading stream", e5);
                        }
                    }
                    return str;
                } catch (IOException e6) {
                    e = e6;
                    zze("Error reading client id file, deleting it", e);
                    context.deleteFile("gaClientId");
                    r2 = fileInputStreamOpenFileInput;
                    if (fileInputStreamOpenFileInput != null) {
                        try {
                            fileInputStreamOpenFileInput.close();
                            r2 = fileInputStreamOpenFileInput;
                        } catch (IOException e7) {
                            zze("Failed to close client id reading stream", e7);
                            r2 = "Failed to close client id reading stream";
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (r2 != 0) {
                    try {
                        r2.close();
                    } catch (IOException e8) {
                        zze("Failed to close client id reading stream", e8);
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException e9) {
            fileInputStream = null;
        } catch (IOException e10) {
            e = e10;
            fileInputStreamOpenFileInput = null;
        } catch (Throwable th3) {
            r2 = 0;
            th = th3;
            if (r2 != 0) {
                r2.close();
            }
            throw th;
        }
        r2 = fileInputStreamOpenFileInput;
        r2 = fileInputStreamOpenFileInput;
        return str;
    }

    @Override // com.google.android.gms.analytics.internal.zzd
    protected void zziJ() {
    }

    public String zzkk() {
        String str;
        zzjv();
        synchronized (this) {
            if (this.zzPO == null) {
                this.zzRr = zzjo().zzc(new Callable<String>() { // from class: com.google.android.gms.analytics.internal.zzn.1
                    @Override // java.util.concurrent.Callable
                    /* JADX INFO: renamed from: zzkp, reason: merged with bridge method [inline-methods] */
                    public String call() throws Exception {
                        return zzn.this.zzkm();
                    }
                });
            }
            if (this.zzRr != null) {
                try {
                    this.zzPO = this.zzRr.get();
                } catch (InterruptedException e) {
                    zzd("ClientId loading or generation was interrupted", e);
                    this.zzPO = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                } catch (ExecutionException e2) {
                    zze("Failed to load or generate client id", e2);
                    this.zzPO = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                }
                if (this.zzPO == null) {
                    this.zzPO = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                }
                zza("Loaded clientId", this.zzPO);
                this.zzRr = null;
                str = this.zzPO;
            } else {
                str = this.zzPO;
            }
            throw th;
        }
        return str;
    }

    String zzkl() {
        synchronized (this) {
            this.zzPO = null;
            this.zzRr = zzjo().zzc(new Callable<String>() { // from class: com.google.android.gms.analytics.internal.zzn.2
                @Override // java.util.concurrent.Callable
                /* JADX INFO: renamed from: zzkp, reason: merged with bridge method [inline-methods] */
                public String call() throws Exception {
                    return zzn.this.zzkn();
                }
            });
        }
        return zzkk();
    }

    String zzkm() throws Throwable {
        String strZzac = zzac(zzjo().getContext());
        return strZzac == null ? zzkn() : strZzac;
    }

    protected String zzko() {
        return UUID.randomUUID().toString().toLowerCase();
    }
}
