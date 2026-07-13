package com.google.android.gms.internal;

import android.util.Base64OutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.PriorityQueue;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzbh {
    private final int zztq;
    private final zzbg zzts = new zzbj();
    private final int zztp = 6;
    private final int zztr = 0;

    static class zza {
        ByteArrayOutputStream zztu = new ByteArrayOutputStream(4096);
        Base64OutputStream zztv = new Base64OutputStream(this.zztu, 10);

        /* JADX WARN: Multi-variable type inference failed */
        public String toString() {
            String string;
            try {
                this.zztv.close();
            } catch (IOException e) {
                zzin.zzb("HashManager: Unable to convert to Base64.", e);
            }
            try {
                this.zztu.close();
                string = this.zztu.toString();
            } catch (IOException e2) {
                zzin.zzb("HashManager: Unable to convert to Base64.", e2);
                string = "";
            } finally {
                this.zztu = null;
                this.zztv = null;
            }
            return string;
        }

        public void write(byte[] data) throws IOException {
            this.zztv.write(data);
        }
    }

    public zzbh(int i) {
        this.zztq = i;
    }

    private String zzv(String str) {
        String[] strArrSplit = str.split("\n");
        if (strArrSplit.length == 0) {
            return "";
        }
        zza zzaVarZzcM = zzcM();
        Arrays.sort(strArrSplit, new Comparator<String>() { // from class: com.google.android.gms.internal.zzbh.1
            @Override // java.util.Comparator
            public int compare(String s1, String s2) {
                return s2.length() - s1.length();
            }
        });
        for (int i = 0; i < strArrSplit.length && i < this.zztq; i++) {
            if (strArrSplit[i].trim().length() != 0) {
                try {
                    zzaVarZzcM.write(this.zzts.zzu(strArrSplit[i]));
                } catch (IOException e) {
                    zzin.zzb("Error while writing hash to byteStream", e);
                }
            }
        }
        return zzaVarZzcM.toString();
    }

    public String zza(ArrayList<String> arrayList) {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            stringBuffer.append(it.next().toLowerCase(Locale.US));
            stringBuffer.append('\n');
        }
        switch (this.zztr) {
            case 0:
                return zzw(stringBuffer.toString());
            case 1:
                return zzv(stringBuffer.toString());
            default:
                return "";
        }
    }

    zza zzcM() {
        return new zza();
    }

    String zzw(String str) {
        String[] strArrSplit = str.split("\n");
        if (strArrSplit.length == 0) {
            return "";
        }
        zza zzaVarZzcM = zzcM();
        PriorityQueue priorityQueue = new PriorityQueue(this.zztq, new Comparator<zzbk.zza>() { // from class: com.google.android.gms.internal.zzbh.2
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
            public int compare(zzbk.zza zzaVar, zzbk.zza zzaVar2) {
                int i = zzaVar.zzty - zzaVar2.zzty;
                return i != 0 ? i : (int) (zzaVar.value - zzaVar2.value);
            }
        });
        for (String str2 : strArrSplit) {
            String[] strArrZzy = zzbi.zzy(str2);
            if (strArrZzy.length != 0) {
                zzbk.zza(strArrZzy, this.zztq, this.zztp, priorityQueue);
            }
        }
        Iterator it = priorityQueue.iterator();
        while (it.hasNext()) {
            try {
                zzaVarZzcM.write(this.zzts.zzu(((zzbk.zza) it.next()).zztx));
            } catch (IOException e) {
                zzin.zzb("Error while writing hash to byteStream", e);
            }
        }
        return zzaVarZzcM.toString();
    }
}
