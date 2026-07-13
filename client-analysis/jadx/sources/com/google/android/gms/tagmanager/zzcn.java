package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.internal.zzrq;
import com.google.android.gms.internal.zzrs;
import com.google.android.gms.internal.zzst;
import com.google.android.gms.internal.zzsu;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;

/* JADX INFO: loaded from: classes.dex */
class zzcn implements zzp.zzf {
    private final Context mContext;
    private final String zzbhM;
    private zzbf<zzrq.zza> zzbkg;
    private final ExecutorService zzbkn = Executors.newSingleThreadExecutor();

    zzcn(Context context, String str) {
        this.mContext = context;
        this.zzbhM = str;
    }

    private zzrs.zzc zza(ByteArrayOutputStream byteArrayOutputStream) {
        try {
            return zzaz.zzgi(byteArrayOutputStream.toString("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            zzbg.zzaI("Failed to convert binary resource to string for JSON parsing; the file format is not UTF-8 format.");
            return null;
        } catch (JSONException e2) {
            zzbg.zzaK("Failed to extract the container from the resource file. Resource is a UTF-8 encoded string but doesn't contain a JSON container");
            return null;
        }
    }

    private void zzd(zzrq.zza zzaVar) throws IllegalArgumentException {
        if (zzaVar.zzju == null && zzaVar.zzbme == null) {
            throw new IllegalArgumentException("Resource and SupplementedResource are NULL.");
        }
    }

    private zzrs.zzc zzx(byte[] bArr) {
        try {
            zzrs.zzc zzcVarZzb = zzrs.zzb(com.google.android.gms.internal.zzaf.zzf.zzc(bArr));
            if (zzcVarZzb == null) {
                return zzcVarZzb;
            }
            zzbg.v("The container was successfully loaded from the resource (using binary file)");
            return zzcVarZzb;
        } catch (zzrs.zzg e) {
            zzbg.zzaK("The resource file is invalid. The container from the binary file is invalid");
            return null;
        } catch (zzst e2) {
            zzbg.e("The resource file is corrupted. The container cannot be extracted from the binary file");
            return null;
        }
    }

    @Override // com.google.android.gms.common.api.Releasable
    public synchronized void release() {
        this.zzbkn.shutdown();
    }

    @Override // com.google.android.gms.tagmanager.zzp.zzf
    public void zzGl() {
        this.zzbkn.execute(new Runnable() { // from class: com.google.android.gms.tagmanager.zzcn.1
            @Override // java.lang.Runnable
            public void run() {
                zzcn.this.zzHc();
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:10:0x002e  */
    /* JADX WARN: Code duplicated, block: B:12:0x003e  */
    /* JADX WARN: Multi-variable type inference failed */
    void zzHc() {
        boolean zEquals;
        FileInputStream fileInputStream;
        zzcb.zza zzaVar;
        if (this.zzbkg == null) {
            throw new IllegalStateException("Callback must be set before execute");
        }
        this.zzbkg.zzGk();
        zzbg.v("Attempting to load resource from disk");
        if (zzcb.zzGU().zzGV() != zzcb.zza.CONTAINER) {
            zzcb.zza zzaVarZzGV = zzcb.zzGU().zzGV();
            zzaVar = zzcb.zza.CONTAINER_DEBUG;
            if (zzaVarZzGV == zzaVar) {
                fileInputStream = zzaVar;
                String str = this.zzbhM;
                String containerId = zzcb.zzGU().getContainerId();
                zEquals = str.equals(containerId);
                fileInputStream = containerId;
                if (zEquals) {
                    this.zzbkg.zza(zzbf.zza.NOT_AVAILABLE);
                    return;
                }
            }
        } else {
            fileInputStream = zzaVar;
            String str2 = this.zzbhM;
            String containerId2 = zzcb.zzGU().getContainerId();
            zEquals = str2.equals(containerId2);
            fileInputStream = containerId2;
            if (zEquals) {
                this.zzbkg.zza(zzbf.zza.NOT_AVAILABLE);
                return;
            }
        }
        try {
            try {
                fileInputStream = zzaVar;
                fileInputStream = new FileInputStream(zzHd());
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    zzrs.zzb(fileInputStream, byteArrayOutputStream);
                    zzrq.zza zzaVarZzy = zzrq.zza.zzy(byteArrayOutputStream.toByteArray());
                    zzd(zzaVarZzy);
                    this.zzbkg.zzI(zzaVarZzy);
                    try {
                        fileInputStream.close();
                    } catch (IOException e) {
                        zzbg.zzaK("Error closing stream for reading resource from disk");
                    }
                } catch (IOException e2) {
                    this.zzbkg.zza(zzbf.zza.IO_ERROR);
                    zzbg.zzaK("Failed to read the resource from disk");
                    try {
                        fileInputStream.close();
                    } catch (IOException e3) {
                        zzbg.zzaK("Error closing stream for reading resource from disk");
                    }
                } catch (IllegalArgumentException e4) {
                    this.zzbkg.zza(zzbf.zza.IO_ERROR);
                    zzbg.zzaK("Failed to read the resource from disk. The resource is inconsistent");
                    try {
                        fileInputStream.close();
                    } catch (IOException e5) {
                        zzbg.zzaK("Error closing stream for reading resource from disk");
                    }
                }
                zzbg.v("The Disk resource was successfully read.");
            } catch (FileNotFoundException e6) {
                zzbg.zzaI("Failed to find the resource in the disk");
                this.zzbkg.zza(zzbf.zza.NOT_AVAILABLE);
            }
        } catch (Throwable th) {
            try {
                fileInputStream.close();
            } catch (IOException e7) {
                zzbg.zzaK("Error closing stream for reading resource from disk");
            }
            throw th;
        }
    }

    File zzHd() {
        return new File(this.mContext.getDir("google_tagmanager", 0), "resource_" + this.zzbhM);
    }

    @Override // com.google.android.gms.tagmanager.zzp.zzf
    public void zza(zzbf<zzrq.zza> zzbfVar) {
        this.zzbkg = zzbfVar;
    }

    @Override // com.google.android.gms.tagmanager.zzp.zzf
    public void zzb(final zzrq.zza zzaVar) {
        this.zzbkn.execute(new Runnable() { // from class: com.google.android.gms.tagmanager.zzcn.2
            @Override // java.lang.Runnable
            public void run() {
                zzcn.this.zzc(zzaVar);
            }
        });
    }

    boolean zzc(zzrq.zza zzaVar) {
        boolean z = false;
        File fileZzHd = zzHd();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileZzHd);
            try {
                fileOutputStream.write(zzsu.toByteArray(zzaVar));
                z = true;
            } catch (IOException e) {
                zzbg.zzaK("Error writing resource to disk. Removing resource from disk.");
                fileZzHd.delete();
            } finally {
                try {
                    fileOutputStream.close();
                } catch (IOException e2) {
                    zzbg.zzaK("error closing stream for writing resource to disk");
                }
            }
        } catch (FileNotFoundException e3) {
            zzbg.e("Error opening resource file for writing");
        }
        return z;
    }

    @Override // com.google.android.gms.tagmanager.zzp.zzf
    public zzrs.zzc zzke(int i) {
        try {
            InputStream inputStreamOpenRawResource = this.mContext.getResources().openRawResource(i);
            zzbg.v("Attempting to load a container from the resource ID " + i + " (" + this.mContext.getResources().getResourceName(i) + ")");
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                zzrs.zzb(inputStreamOpenRawResource, byteArrayOutputStream);
                zzrs.zzc zzcVarZza = zza(byteArrayOutputStream);
                if (zzcVarZza != null) {
                    zzbg.v("The container was successfully loaded from the resource (using JSON file format)");
                } else {
                    zzcVarZza = zzx(byteArrayOutputStream.toByteArray());
                }
                return zzcVarZza;
            } catch (IOException e) {
                zzbg.zzaK("Error reading the default container with resource ID " + i + " (" + this.mContext.getResources().getResourceName(i) + ")");
                return null;
            }
        } catch (Resources.NotFoundException e2) {
            zzbg.zzaK("Failed to load the container. No default container resource found with the resource ID " + i);
            return null;
        }
    }
}
