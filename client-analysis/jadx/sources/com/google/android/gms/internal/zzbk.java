package com.google.android.gms.internal;

import java.util.PriorityQueue;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzbk {

    public static class zza {
        final long value;
        final String zztx;
        final int zzty;

        zza(long j, String str, int i) {
            this.value = j;
            this.zztx = str;
            this.zzty = i;
        }

        public boolean equals(Object other) {
            if (other == null || !(other instanceof zza)) {
                return false;
            }
            return ((zza) other).value == this.value && ((zza) other).zzty == this.zzty;
        }

        public int hashCode() {
            return (int) this.value;
        }
    }

    static long zza(int i, int i2, long j, long j2, long j3) {
        return ((((((j + 1073807359) - ((((((long) i) + 2147483647L) % 1073807359) * j2) % 1073807359)) % 1073807359) * j3) % 1073807359) + ((((long) i2) + 2147483647L) % 1073807359)) % 1073807359;
    }

    static long zza(long j, int i) {
        if (i == 0) {
            return 1L;
        }
        if (i != 1) {
            return i % 2 == 0 ? zza((j * j) % 1073807359, i / 2) % 1073807359 : ((zza((j * j) % 1073807359, i / 2) % 1073807359) * j) % 1073807359;
        }
        return j;
    }

    static String zza(String[] strArr, int i, int i2) {
        if (strArr.length < i + i2) {
            zzin.e("Unable to construct shingle");
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i3 = i; i3 < (i + i2) - 1; i3++) {
            stringBuffer.append(strArr[i3]);
            stringBuffer.append(' ');
        }
        stringBuffer.append(strArr[(i + i2) - 1]);
        return stringBuffer.toString();
    }

    static void zza(int i, long j, String str, int i2, PriorityQueue<zza> priorityQueue) {
        zza zzaVar = new zza(j, str, i2);
        if ((priorityQueue.size() != i || priorityQueue.peek().value <= zzaVar.value) && !priorityQueue.contains(zzaVar)) {
            priorityQueue.add(zzaVar);
            if (priorityQueue.size() > i) {
                priorityQueue.poll();
            }
        }
    }

    public static void zza(String[] strArr, int i, int i2, PriorityQueue<zza> priorityQueue) {
        if (strArr.length < i2) {
            zza(i, zzb(strArr, 0, strArr.length), zza(strArr, 0, strArr.length), strArr.length, priorityQueue);
            return;
        }
        long jZzb = zzb(strArr, 0, i2);
        zza(i, jZzb, zza(strArr, 0, i2), i2, priorityQueue);
        long jZza = zza(16785407L, i2 - 1);
        int i3 = 1;
        while (i3 < (strArr.length - i2) + 1) {
            long jZza2 = zza(zzbi.zzx(strArr[i3 - 1]), zzbi.zzx(strArr[(i3 + i2) - 1]), jZzb, jZza, 16785407L);
            zza(i, jZza2, zza(strArr, i3, i2), strArr.length, priorityQueue);
            i3++;
            jZzb = jZza2;
        }
    }

    private static long zzb(String[] strArr, int i, int i2) {
        long jZzx = (((long) zzbi.zzx(strArr[i])) + 2147483647L) % 1073807359;
        for (int i3 = i + 1; i3 < i + i2; i3++) {
            jZzx = (((jZzx * 16785407) % 1073807359) + ((((long) zzbi.zzx(strArr[i3])) + 2147483647L) % 1073807359)) % 1073807359;
        }
        return jZzx;
    }
}
