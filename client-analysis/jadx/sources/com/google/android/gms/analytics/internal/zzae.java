package com.google.android.gms.analytics.internal;

import android.util.Log;
import com.google.android.gms.analytics.Logger;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class zzae {
    private static volatile Logger zzSV;

    static {
        setLogger(new zzs());
    }

    public static Logger getLogger() {
        return zzSV;
    }

    public static void setLogger(Logger logger) {
        zzSV = logger;
    }

    public static void v(String msg) {
        zzaf zzafVarZzlx = zzaf.zzlx();
        if (zzafVarZzlx != null) {
            zzafVarZzlx.zzbd(msg);
        } else if (zzQ(0)) {
            Log.v(zzy.zzRL.get(), msg);
        }
        Logger logger = zzSV;
        if (logger != null) {
            logger.verbose(msg);
        }
    }

    public static boolean zzQ(int i) {
        return getLogger() != null && getLogger().getLogLevel() <= i;
    }

    public static void zzaJ(String str) {
        zzaf zzafVarZzlx = zzaf.zzlx();
        if (zzafVarZzlx != null) {
            zzafVarZzlx.zzbf(str);
        } else if (zzQ(1)) {
            Log.i(zzy.zzRL.get(), str);
        }
        Logger logger = zzSV;
        if (logger != null) {
            logger.info(str);
        }
    }

    public static void zzaK(String str) {
        zzaf zzafVarZzlx = zzaf.zzlx();
        if (zzafVarZzlx != null) {
            zzafVarZzlx.zzbg(str);
        } else if (zzQ(2)) {
            Log.w(zzy.zzRL.get(), str);
        }
        Logger logger = zzSV;
        if (logger != null) {
            logger.warn(str);
        }
    }

    public static void zzf(String str, Object obj) {
        zzaf zzafVarZzlx = zzaf.zzlx();
        if (zzafVarZzlx != null) {
            zzafVarZzlx.zze(str, obj);
        } else if (zzQ(3)) {
            Log.e(zzy.zzRL.get(), obj != null ? str + ":" + obj : str);
        }
        Logger logger = zzSV;
        if (logger != null) {
            logger.error(str);
        }
    }
}
