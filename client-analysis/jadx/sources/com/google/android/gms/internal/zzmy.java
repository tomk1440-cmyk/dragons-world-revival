package com.google.android.gms.internal;

/* JADX INFO: loaded from: classes.dex */
public final class zzmy {
    public static String zza(byte[] bArr, int i, int i2, boolean z) {
        int i3;
        if (bArr == null || bArr.length == 0 || i < 0 || i2 <= 0 || i + i2 > bArr.length) {
            return null;
        }
        StringBuilder sb = new StringBuilder((z ? 75 : 57) * (((i2 + 16) - 1) / 16));
        int i4 = i;
        int i5 = i2;
        int i6 = 0;
        int i7 = 0;
        while (i5 > 0) {
            if (i7 == 0) {
                if (i2 < 65536) {
                    sb.append(String.format("%04X:", Integer.valueOf(i4)));
                    i6 = i4;
                } else {
                    sb.append(String.format("%08X:", Integer.valueOf(i4)));
                    i6 = i4;
                }
            } else if (i7 == 8) {
                sb.append(" -");
            }
            sb.append(String.format(" %02X", Integer.valueOf(bArr[i4] & 255)));
            int i8 = i5 - 1;
            int i9 = i7 + 1;
            if (z && (i9 == 16 || i8 == 0)) {
                int i10 = 16 - i9;
                if (i10 > 0) {
                    for (int i11 = 0; i11 < i10; i11++) {
                        sb.append("   ");
                    }
                }
                if (i10 >= 8) {
                    sb.append("  ");
                }
                sb.append("  ");
                for (int i12 = 0; i12 < i9; i12++) {
                    char c = (char) bArr[i6 + i12];
                    if (c < ' ' || c > '~') {
                        c = '.';
                    }
                    sb.append(c);
                }
            }
            if (i9 == 16 || i8 == 0) {
                sb.append('\n');
                i3 = 0;
            } else {
                i3 = i9;
            }
            i4++;
            i7 = i3;
            i5 = i8;
        }
        return sb.toString();
    }
}
