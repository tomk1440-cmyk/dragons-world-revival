package com.google.android.gms.analytics.internal;

import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class zza extends zzd {
    public static boolean zzPV;
    private AdvertisingIdClient.Info zzPW;
    private final zzaj zzPX;
    private String zzPY;
    private boolean zzPZ;
    private Object zzQa;

    zza(zzf zzfVar) {
        super(zzfVar);
        this.zzPZ = false;
        this.zzQa = new Object();
        this.zzPX = new zzaj(zzfVar.zzjl());
    }

    private boolean zza(AdvertisingIdClient.Info info, AdvertisingIdClient.Info info2) {
        String strZzkl;
        String id = info2 == null ? null : info2.getId();
        if (TextUtils.isEmpty(id)) {
            return true;
        }
        String strZzkk = zzjr().zzkk();
        synchronized (this.zzQa) {
            if (!this.zzPZ) {
                this.zzPY = zzjb();
                this.zzPZ = true;
            } else if (TextUtils.isEmpty(this.zzPY)) {
                String id2 = info != null ? info.getId() : null;
                if (id2 == null) {
                    return zzbc(id + strZzkk);
                }
                this.zzPY = zzbb(id2 + strZzkk);
            }
            String strZzbb = zzbb(id + strZzkk);
            if (TextUtils.isEmpty(strZzbb)) {
                return false;
            }
            if (strZzbb.equals(this.zzPY)) {
                return true;
            }
            if (TextUtils.isEmpty(this.zzPY)) {
                strZzkl = strZzkk;
            } else {
                zzbd("Resetting the client id because Advertising Id changed.");
                strZzkl = zzjr().zzkl();
                zza("New client Id", strZzkl);
            }
            return zzbc(id + strZzkl);
        }
    }

    private static String zzbb(String str) {
        MessageDigest messageDigestZzbv = zzam.zzbv("MD5");
        if (messageDigestZzbv == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new BigInteger(1, messageDigestZzbv.digest(str.getBytes())));
    }

    private boolean zzbc(String str) {
        try {
            String strZzbb = zzbb(str);
            zzbd("Storing hashed adid.");
            FileOutputStream fileOutputStreamOpenFileOutput = getContext().openFileOutput("gaClientIdData", 0);
            fileOutputStreamOpenFileOutput.write(strZzbb.getBytes());
            fileOutputStreamOpenFileOutput.close();
            this.zzPY = strZzbb;
            return true;
        } catch (IOException e) {
            zze("Error creating hash file", e);
            return false;
        }
    }

    private synchronized AdvertisingIdClient.Info zziZ() {
        if (this.zzPX.zzv(1000L)) {
            this.zzPX.start();
            AdvertisingIdClient.Info infoZzja = zzja();
            if (zza(this.zzPW, infoZzja)) {
                this.zzPW = infoZzja;
            } else {
                zzbh("Failed to reset client id on adid change. Not using adid");
                this.zzPW = new AdvertisingIdClient.Info("", false);
            }
        }
        return this.zzPW;
    }

    @Override // com.google.android.gms.analytics.internal.zzd
    protected void zziJ() {
    }

    public boolean zziU() {
        zzjv();
        AdvertisingIdClient.Info infoZziZ = zziZ();
        return (infoZziZ == null || infoZziZ.isLimitAdTrackingEnabled()) ? false : true;
    }

    public String zziY() {
        zzjv();
        AdvertisingIdClient.Info infoZziZ = zziZ();
        String id = infoZziZ != null ? infoZziZ.getId() : null;
        if (TextUtils.isEmpty(id)) {
            return null;
        }
        return id;
    }

    protected AdvertisingIdClient.Info zzja() {
        try {
            return AdvertisingIdClient.getAdvertisingIdInfo(getContext());
        } catch (IllegalStateException e) {
            zzbg("IllegalStateException getting Ad Id Info. If you would like to see Audience reports, please ensure that you have added '<meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />' to your application manifest file. See http://goo.gl/naFqQk for details.");
            return null;
        } catch (Throwable th) {
            if (zzPV) {
                return null;
            }
            zzPV = true;
            zzd("Error getting advertiser id", th);
            return null;
        }
    }

    protected String zzjb() {
        String str = null;
        try {
            FileInputStream fileInputStreamOpenFileInput = getContext().openFileInput("gaClientIdData");
            byte[] bArr = new byte[128];
            int i = fileInputStreamOpenFileInput.read(bArr, 0, 128);
            if (fileInputStreamOpenFileInput.available() > 0) {
                zzbg("Hash file seems corrupted, deleting it.");
                fileInputStreamOpenFileInput.close();
                getContext().deleteFile("gaClientIdData");
            } else if (i <= 0) {
                zzbd("Hash file is empty.");
                fileInputStreamOpenFileInput.close();
            } else {
                String str2 = new String(bArr, 0, i);
                try {
                    fileInputStreamOpenFileInput.close();
                    str = str2;
                } catch (FileNotFoundException e) {
                    str = str2;
                } catch (IOException e2) {
                    str = str2;
                    e = e2;
                    zzd("Error reading Hash file, deleting it", e);
                    getContext().deleteFile("gaClientIdData");
                    return str;
                }
            }
        } catch (FileNotFoundException e3) {
        } catch (IOException e4) {
            e = e4;
        }
        return str;
    }
}
