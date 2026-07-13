package com.google.android.gms.internal;

/* JADX INFO: loaded from: classes.dex */
public class zzoz {
    private static final ThreadLocal<String> zzazL = new ThreadLocal<>();

    public static String zzD(String str, String str2) {
        if (str == null || str2 == null) {
            return str;
        }
        byte[] bArr = new byte[str.length() + str2.length()];
        System.arraycopy(str.getBytes(), 0, bArr, 0, str.length());
        System.arraycopy(str2.getBytes(), 0, bArr, str.length(), str2.length());
        return Integer.toHexString(zznd.zza(bArr, 0, bArr.length, 0));
    }

    public static String zzdF(String str) {
        return zzuH() ? str : zzD(str, zzazL.get());
    }

    public static boolean zzuH() {
        String str = zzazL.get();
        return str == null || str.startsWith("com.google");
    }
}
