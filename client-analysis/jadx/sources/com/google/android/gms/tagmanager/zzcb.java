package com.google.android.gms.tagmanager;

import android.net.Uri;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/* JADX INFO: loaded from: classes.dex */
class zzcb {
    private static zzcb zzbjQ;
    private volatile String zzbhM;
    private volatile zza zzbjR;
    private volatile String zzbjS;
    private volatile String zzbjT;

    enum zza {
        NONE,
        CONTAINER,
        CONTAINER_DEBUG
    }

    zzcb() {
        clear();
    }

    static zzcb zzGU() {
        zzcb zzcbVar;
        synchronized (zzcb.class) {
            if (zzbjQ == null) {
                zzbjQ = new zzcb();
            }
            zzcbVar = zzbjQ;
        }
        return zzcbVar;
    }

    private String zzgk(String str) {
        return str.split("&")[0].split("=")[1];
    }

    private String zzq(Uri uri) {
        return uri.getQuery().replace("&gtm_debug=x", "");
    }

    void clear() {
        this.zzbjR = zza.NONE;
        this.zzbjS = null;
        this.zzbhM = null;
        this.zzbjT = null;
    }

    String getContainerId() {
        return this.zzbhM;
    }

    zza zzGV() {
        return this.zzbjR;
    }

    String zzGW() {
        return this.zzbjS;
    }

    synchronized boolean zzp(Uri uri) {
        boolean z = true;
        synchronized (this) {
            try {
                String strDecode = URLDecoder.decode(uri.toString(), "UTF-8");
                if (strDecode.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_auth=\\S+&gtm_preview=\\d+(&gtm_debug=x)?$")) {
                    zzbg.v("Container preview url: " + strDecode);
                    if (strDecode.matches(".*?&gtm_debug=x$")) {
                        this.zzbjR = zza.CONTAINER_DEBUG;
                    } else {
                        this.zzbjR = zza.CONTAINER;
                    }
                    this.zzbjT = zzq(uri);
                    if (this.zzbjR == zza.CONTAINER || this.zzbjR == zza.CONTAINER_DEBUG) {
                        this.zzbjS = "/r?" + this.zzbjT;
                    }
                    this.zzbhM = zzgk(this.zzbjT);
                } else if (!strDecode.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_preview=$")) {
                    zzbg.zzaK("Invalid preview uri: " + strDecode);
                    z = false;
                } else if (zzgk(uri.getQuery()).equals(this.zzbhM)) {
                    zzbg.v("Exit preview mode for container: " + this.zzbhM);
                    this.zzbjR = zza.NONE;
                    this.zzbjS = null;
                } else {
                    z = false;
                }
            } catch (UnsupportedEncodingException e) {
                z = false;
            }
        }
        return z;
    }
}
