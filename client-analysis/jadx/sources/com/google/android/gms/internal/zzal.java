package com.google.android.gms.internal;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import com.google.ads.afma.nano.NanoAdshieldEvent;
import com.google.ads.afma.nano.NanoAfmaSignals;
import com.google.android.gms.common.api.GoogleApiClient;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzal extends zzak {
    private static Method zznH;
    private static Method zznI;
    private static Method zznJ;
    private static Method zznK;
    private static Method zznL;
    private static Method zznM;
    private static Method zznN;
    private static Method zznO;
    private static Method zznP;
    private static Method zznQ;
    private static Method zznR;
    private static Method zznS;
    private static Method zznT;
    private static String zznU;
    private static String zznV;
    private static String zznW;
    private static zzaq zznX;
    protected static NanoAdshieldEvent.AdShieldEvent zzoa;
    protected static int zzob;
    private static boolean zzoe;
    private static long startTime = 0;
    static boolean zznY = false;
    protected static com.google.android.gms.clearcut.zzb zznZ = null;
    private static Random zzoc = new Random();
    private static com.google.android.gms.common.zzc zzod = com.google.android.gms.common.zzc.zzoK();
    protected static boolean zzof = false;
    protected static boolean zzog = false;
    protected static boolean zzoh = false;
    protected static boolean zzoi = false;
    private static boolean zzoj = false;

    static class zza extends Exception {
        public zza() {
        }

        public zza(Throwable th) {
            super(th);
        }
    }

    protected zzal(Context context, zzap zzapVar) {
        super(context, zzapVar);
        zzoa = new NanoAdshieldEvent.AdShieldEvent();
        zzoa.appId = context.getPackageName();
    }

    private void zzT() {
        if (!zzoi || zznZ == null) {
            return;
        }
        zznZ.zza(zznG, 100L, TimeUnit.MILLISECONDS);
        zznG.disconnect();
    }

    static String zzU() throws zza {
        if (zznU == null) {
            throw new zza();
        }
        return zznU;
    }

    static Long zzV() throws zza {
        if (zznH == null) {
            throw new zza();
        }
        try {
            return (Long) zznH.invoke(null, new Object[0]);
        } catch (IllegalAccessException e) {
            throw new zza(e);
        } catch (InvocationTargetException e2) {
            throw new zza(e2);
        }
    }

    static String zzW() throws zza {
        if (zznJ == null) {
            throw new zza();
        }
        try {
            return (String) zznJ.invoke(null, new Object[0]);
        } catch (IllegalAccessException e) {
            throw new zza(e);
        } catch (InvocationTargetException e2) {
            throw new zza(e2);
        }
    }

    static Long zzX() throws zza {
        if (zznI == null) {
            throw new zza();
        }
        try {
            return (Long) zznI.invoke(null, new Object[0]);
        } catch (IllegalAccessException e) {
            throw new zza(e);
        } catch (InvocationTargetException e2) {
            throw new zza(e2);
        }
    }

    static String zza(Context context, zzap zzapVar) throws zza {
        if (zznV != null) {
            return zznV;
        }
        if (zznK == null) {
            throw new zza();
        }
        try {
            ByteBuffer byteBuffer = (ByteBuffer) zznK.invoke(null, context);
            if (byteBuffer == null) {
                throw new zza();
            }
            zznV = zzapVar.zza(byteBuffer.array(), true);
            return zznV;
        } catch (IllegalAccessException e) {
            throw new zza(e);
        } catch (InvocationTargetException e2) {
            throw new zza(e2);
        }
    }

    static ArrayList<Long> zza(MotionEvent motionEvent, DisplayMetrics displayMetrics) throws zza {
        if (zznL == null || motionEvent == null) {
            throw new zza();
        }
        try {
            return (ArrayList) zznL.invoke(null, motionEvent, displayMetrics);
        } catch (IllegalAccessException e) {
            throw new zza(e);
        } catch (InvocationTargetException e2) {
            throw new zza(e2);
        }
    }

    protected static void zza(int i, int i2) throws IOException {
        if (zzoi && zzof && zznZ != null) {
            com.google.android.gms.clearcut.zzb.zza zzaVarZzi = zznZ.zzi(zzsu.toByteArray(zzoa));
            zzaVarZzi.zzbr(i2);
            zzaVarZzi.zzbq(i);
            zzaVarZzi.zzd(zznG);
        }
    }

    protected static synchronized void zza(String str, Context context, zzap zzapVar) {
        if (!zznY) {
            try {
                zznX = new zzaq(zzapVar, null);
                zznU = str;
                zzbt.initialize(context);
                zzm(context);
                startTime = zzV().longValue();
                zzoc = new Random();
                try {
                    zznG = new GoogleApiClient.Builder(context).addApi(com.google.android.gms.clearcut.zzb.API).build();
                    zzod = com.google.android.gms.common.zzc.zzoK();
                    zzoe = zzod.isGooglePlayServicesAvailable(context) == 0;
                    zzbt.initialize(context);
                    zzof = zzbt.zzwZ.get().booleanValue();
                    zznZ = new com.google.android.gms.clearcut.zzb(context, "ADSHIELD", null, null);
                } catch (NoClassDefFoundError e) {
                }
                zzoj = zzod.zzaj(context) > 0;
                zznY = true;
            } catch (zza e2) {
            } catch (UnsupportedOperationException e3) {
            }
        }
    }

    static String zzb(Context context, zzap zzapVar) throws zza {
        if (zznW != null) {
            return zznW;
        }
        if (zznN == null) {
            throw new zza();
        }
        try {
            ByteBuffer byteBuffer = (ByteBuffer) zznN.invoke(null, context);
            if (byteBuffer == null) {
                throw new zza();
            }
            zznW = zzapVar.zza(byteBuffer.array(), true);
            return zznW;
        } catch (IllegalAccessException e) {
            throw new zza(e);
        } catch (InvocationTargetException e2) {
            throw new zza(e2);
        }
    }

    private static String zzb(byte[] bArr, String str) throws zza {
        try {
            return new String(zznX.zzc(bArr, str), "UTF-8");
        } catch (zzaq.zza e) {
            throw new zza(e);
        } catch (UnsupportedEncodingException e2) {
            throw new zza(e2);
        }
    }

    private void zze(Context context) {
        if (!zzoe) {
            zzoi = false;
        } else {
            zznG.connect();
            zzoi = true;
        }
    }

    static String zzf(Context context) throws zza {
        if (zznM == null) {
            throw new zza();
        }
        try {
            String str = (String) zznM.invoke(null, context);
            if (str == null) {
                throw new zza();
            }
            return str;
        } catch (IllegalAccessException e) {
            throw new zza(e);
        } catch (InvocationTargetException e2) {
            throw new zza(e2);
        }
    }

    static String zzg(Context context) throws zza {
        if (zznQ == null) {
            throw new zza();
        }
        try {
            return (String) zznQ.invoke(null, context);
        } catch (IllegalAccessException e) {
            throw new zza(e);
        } catch (InvocationTargetException e2) {
            throw new zza(e2);
        }
    }

    static Long zzh(Context context) throws zza {
        if (zznR == null) {
            throw new zza();
        }
        try {
            return (Long) zznR.invoke(null, context);
        } catch (IllegalAccessException e) {
            throw new zza(e);
        } catch (InvocationTargetException e2) {
            throw new zza(e2);
        }
    }

    static ArrayList<Long> zzi(Context context) throws zza {
        if (zznO == null) {
            throw new zza();
        }
        try {
            ArrayList<Long> arrayList = (ArrayList) zznO.invoke(null, context);
            if (arrayList == null || arrayList.size() != 2) {
                throw new zza();
            }
            return arrayList;
        } catch (IllegalAccessException e) {
            throw new zza(e);
        } catch (InvocationTargetException e2) {
            throw new zza(e2);
        }
    }

    static int[] zzj(Context context) throws zza {
        if (zznP == null) {
            throw new zza();
        }
        try {
            return (int[]) zznP.invoke(null, context);
        } catch (IllegalAccessException e) {
            throw new zza(e);
        } catch (InvocationTargetException e2) {
            throw new zza(e2);
        }
    }

    static int zzk(Context context) throws zza {
        if (zznS == null) {
            throw new zza();
        }
        try {
            return ((Integer) zznS.invoke(null, context)).intValue();
        } catch (IllegalAccessException e) {
            throw new zza(e);
        } catch (InvocationTargetException e2) {
            throw new zza(e2);
        }
    }

    static int zzl(Context context) throws zza {
        if (zznT == null) {
            throw new zza();
        }
        try {
            return ((Integer) zznT.invoke(null, context)).intValue();
        } catch (IllegalAccessException e) {
            throw new zza(e);
        } catch (InvocationTargetException e2) {
            throw new zza(e2);
        }
    }

    private static void zzm(Context context) throws zza {
        try {
            byte[] bArrZzl = zznX.zzl(zzar.getKey());
            byte[] bArrZzc = zznX.zzc(bArrZzl, zzar.zzac());
            File cacheDir = context.getCacheDir();
            if (cacheDir == null && (cacheDir = context.getDir("dex", 0)) == null) {
                throw new zza();
            }
            File file = cacheDir;
            File fileCreateTempFile = File.createTempFile("ads", ".jar", file);
            FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
            fileOutputStream.write(bArrZzc, 0, bArrZzc.length);
            fileOutputStream.close();
            try {
                DexClassLoader dexClassLoader = new DexClassLoader(fileCreateTempFile.getAbsolutePath(), file.getAbsolutePath(), null, context.getClassLoader());
                Class clsLoadClass = dexClassLoader.loadClass(zzb(bArrZzl, zzar.zzal()));
                Class clsLoadClass2 = dexClassLoader.loadClass(zzb(bArrZzl, zzar.zzaz()));
                Class clsLoadClass3 = dexClassLoader.loadClass(zzb(bArrZzl, zzar.zzat()));
                Class clsLoadClass4 = dexClassLoader.loadClass(zzb(bArrZzl, zzar.zzap()));
                Class clsLoadClass5 = dexClassLoader.loadClass(zzb(bArrZzl, zzar.zzaB()));
                Class clsLoadClass6 = dexClassLoader.loadClass(zzb(bArrZzl, zzar.zzan()));
                Class clsLoadClass7 = dexClassLoader.loadClass(zzb(bArrZzl, zzar.zzax()));
                Class clsLoadClass8 = dexClassLoader.loadClass(zzb(bArrZzl, zzar.zzav()));
                Class clsLoadClass9 = dexClassLoader.loadClass(zzb(bArrZzl, zzar.zzaj()));
                Class clsLoadClass10 = dexClassLoader.loadClass(zzb(bArrZzl, zzar.zzah()));
                Class clsLoadClass11 = dexClassLoader.loadClass(zzb(bArrZzl, zzar.zzaf()));
                Class clsLoadClass12 = dexClassLoader.loadClass(zzb(bArrZzl, zzar.zzar()));
                Class clsLoadClass13 = dexClassLoader.loadClass(zzb(bArrZzl, zzar.zzad()));
                zznH = clsLoadClass.getMethod(zzb(bArrZzl, zzar.zzam()), new Class[0]);
                zznI = clsLoadClass2.getMethod(zzb(bArrZzl, zzar.zzaA()), new Class[0]);
                zznJ = clsLoadClass3.getMethod(zzb(bArrZzl, zzar.zzau()), new Class[0]);
                zznK = clsLoadClass4.getMethod(zzb(bArrZzl, zzar.zzaq()), Context.class);
                zznL = clsLoadClass5.getMethod(zzb(bArrZzl, zzar.zzaC()), MotionEvent.class, DisplayMetrics.class);
                zznM = clsLoadClass6.getMethod(zzb(bArrZzl, zzar.zzao()), Context.class);
                zznN = clsLoadClass7.getMethod(zzb(bArrZzl, zzar.zzay()), Context.class);
                zznO = clsLoadClass8.getMethod(zzb(bArrZzl, zzar.zzaw()), Context.class);
                zznP = clsLoadClass9.getMethod(zzb(bArrZzl, zzar.zzak()), Context.class);
                zznQ = clsLoadClass10.getMethod(zzb(bArrZzl, zzar.zzai()), Context.class);
                zznR = clsLoadClass11.getMethod(zzb(bArrZzl, zzar.zzag()), Context.class);
                zznS = clsLoadClass12.getMethod(zzb(bArrZzl, zzar.zzas()), Context.class);
                zznT = clsLoadClass13.getMethod(zzb(bArrZzl, zzar.zzae()), Context.class);
            } finally {
                String name = fileCreateTempFile.getName();
                fileCreateTempFile.delete();
                new File(file, name.replace(".jar", ".dex")).delete();
            }
        } catch (zzaq.zza e) {
            throw new zza(e);
        } catch (FileNotFoundException e2) {
            throw new zza(e2);
        } catch (IOException e3) {
            throw new zza(e3);
        } catch (ClassNotFoundException e4) {
            throw new zza(e4);
        } catch (NoSuchMethodException e5) {
            throw new zza(e5);
        } catch (NullPointerException e6) {
            throw new zza(e6);
        }
    }

    protected boolean zzS() {
        return zzoj;
    }

    @Override // com.google.android.gms.internal.zzak
    protected NanoAfmaSignals.AFMASignals zzc(Context context) {
        NanoAfmaSignals.AFMASignals aFMASignals = new NanoAfmaSignals.AFMASignals();
        try {
            zze(context);
            zzob = zzoc.nextInt();
            zza(0, zzob);
            try {
                aFMASignals.osVersion = zzW();
                zza(1, zzob);
            } catch (zza e) {
            }
            try {
                aFMASignals.afmaVersion = zzU();
                zza(2, zzob);
            } catch (zza e2) {
            }
            try {
                long jLongValue = zzV().longValue();
                aFMASignals.evtTime = Long.valueOf(jLongValue);
                if (startTime != 0) {
                    aFMASignals.uptSignal = Long.valueOf(jLongValue - startTime);
                    aFMASignals.usgSignal = Long.valueOf(startTime);
                }
                zza(25, zzob);
            } catch (zza e3) {
            }
            try {
                ArrayList<Long> arrayListZzi = zzi(context);
                aFMASignals.uwSignal = Long.valueOf(arrayListZzi.get(0).longValue());
                aFMASignals.uhSignal = Long.valueOf(arrayListZzi.get(1).longValue());
                zza(31, zzob);
            } catch (zza e4) {
            }
            try {
                aFMASignals.utzSignal = zzX();
                zza(33, zzob);
            } catch (zza e5) {
            }
            try {
                if (!zzog || !zzoh) {
                    aFMASignals.intSignal = zza(context, this.zznF);
                    zza(27, zzob);
                }
            } catch (zza e6) {
            }
            try {
                aFMASignals.cerSignal = zzb(context, this.zznF);
                zza(29, zzob);
            } catch (zza e7) {
            }
            try {
                int[] iArrZzj = zzj(context);
                aFMASignals.btsSignal = Long.valueOf(iArrZzj[0]);
                aFMASignals.btlSignal = Long.valueOf(iArrZzj[1]);
                zza(5, zzob);
            } catch (zza e8) {
            }
            try {
                aFMASignals.ornSignal = Long.valueOf(zzk(context));
                zza(12, zzob);
            } catch (zza e9) {
            }
            try {
                aFMASignals.atvSignal = Long.valueOf(zzl(context));
                zza(3, zzob);
            } catch (zza e10) {
            }
            try {
                aFMASignals.vnmSignal = zzg(context);
                zza(34, zzob);
            } catch (zza e11) {
            }
            try {
                aFMASignals.vcdSignal = zzh(context);
                zza(35, zzob);
            } catch (zza e12) {
            }
            zzT();
        } catch (IOException e13) {
        }
        return aFMASignals;
    }

    @Override // com.google.android.gms.internal.zzak
    protected NanoAfmaSignals.AFMASignals zzd(Context context) {
        NanoAfmaSignals.AFMASignals aFMASignals = new NanoAfmaSignals.AFMASignals();
        try {
            zze(context);
            zzob = zzoc.nextInt();
            try {
                aFMASignals.afmaVersion = zzU();
            } catch (zza e) {
            }
            try {
                aFMASignals.osVersion = zzW();
            } catch (zza e2) {
            }
            try {
                aFMASignals.evtTime = zzV();
            } catch (zza e3) {
            }
            zza(0, zzob);
            try {
                ArrayList<Long> arrayListZza = zza(this.zznx, this.zznE);
                aFMASignals.tcxSignal = arrayListZza.get(0);
                aFMASignals.tcySignal = arrayListZza.get(1);
                if (arrayListZza.get(2).longValue() >= 0) {
                    aFMASignals.tctSignal = arrayListZza.get(2);
                }
                aFMASignals.tcpSignal = arrayListZza.get(3);
                aFMASignals.tcdSignal = arrayListZza.get(4);
                zza(14, zzob);
            } catch (zza e4) {
            }
            if (this.zznz > 0) {
                aFMASignals.tcdnSignal = Long.valueOf(this.zznz);
            }
            if (this.zznA > 0) {
                aFMASignals.tcmSignal = Long.valueOf(this.zznA);
            }
            if (this.zznB > 0) {
                aFMASignals.tcuSignal = Long.valueOf(this.zznB);
            }
            if (this.zznC > 0) {
                aFMASignals.tccSignal = Long.valueOf(this.zznC);
            }
            try {
                int size = this.zzny.size() - 1;
                if (size > 0) {
                    aFMASignals.previousTouches = new NanoAfmaSignals.AFMASignals.TouchInfo[size];
                    for (int i = 0; i < size; i++) {
                        ArrayList<Long> arrayListZza2 = zza(this.zzny.get(i), this.zznE);
                        NanoAfmaSignals.AFMASignals.TouchInfo touchInfo = new NanoAfmaSignals.AFMASignals.TouchInfo();
                        touchInfo.tcxSignal = arrayListZza2.get(0);
                        touchInfo.tcySignal = arrayListZza2.get(1);
                        aFMASignals.previousTouches[i] = touchInfo;
                    }
                }
            } catch (zza e5) {
                aFMASignals.previousTouches = null;
            }
            try {
                aFMASignals.vnmSignal = zzg(context);
            } catch (zza e6) {
            }
            try {
                aFMASignals.vcdSignal = zzh(context);
            } catch (zza e7) {
            }
            zzT();
        } catch (IOException e8) {
        }
        return aFMASignals;
    }
}
