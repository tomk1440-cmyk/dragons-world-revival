package com.google.android.gms.internal;

import android.support.v4.media.TransportMediator;
import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;

/* JADX INFO: loaded from: classes.dex */
public final class zzsn {
    private final ByteBuffer zzbui;

    public static class zza extends IOException {
        zza(int i, int i2) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space (pos " + i + " limit " + i2 + ").");
        }
    }

    private zzsn(ByteBuffer byteBuffer) {
        this.zzbui = byteBuffer;
        this.zzbui.order(ByteOrder.LITTLE_ENDIAN);
    }

    private zzsn(byte[] bArr, int i, int i2) {
        this(ByteBuffer.wrap(bArr, i, i2));
    }

    public static int zzC(int i, int i2) {
        return zzmA(i) + zzmx(i2);
    }

    public static int zzD(int i, int i2) {
        return zzmA(i) + zzmy(i2);
    }

    public static zzsn zzE(byte[] bArr) {
        return zzb(bArr, 0, bArr.length);
    }

    public static int zzG(byte[] bArr) {
        return zzmC(bArr.length) + bArr.length;
    }

    private static int zza(CharSequence charSequence, int i) {
        int length = charSequence.length();
        int i2 = 0;
        int i3 = i;
        while (i3 < length) {
            char cCharAt = charSequence.charAt(i3);
            if (cCharAt < 2048) {
                i2 += (127 - cCharAt) >>> 31;
            } else {
                i2 += 2;
                if (55296 <= cCharAt && cCharAt <= 57343) {
                    if (Character.codePointAt(charSequence, i3) < 65536) {
                        throw new IllegalArgumentException("Unpaired surrogate at index " + i3);
                    }
                    i3++;
                }
            }
            i3++;
        }
        return i2;
    }

    private static int zza(CharSequence charSequence, byte[] bArr, int i, int i2) {
        int i3;
        int length = charSequence.length();
        int i4 = 0;
        int i5 = i + i2;
        while (i4 < length && i4 + i < i5) {
            char cCharAt = charSequence.charAt(i4);
            if (cCharAt >= 128) {
                break;
            }
            bArr[i + i4] = (byte) cCharAt;
            i4++;
        }
        if (i4 == length) {
            return i + length;
        }
        int i6 = i + i4;
        while (i4 < length) {
            char cCharAt2 = charSequence.charAt(i4);
            if (cCharAt2 < 128 && i6 < i5) {
                i3 = i6 + 1;
                bArr[i6] = (byte) cCharAt2;
            } else if (cCharAt2 < 2048 && i6 <= i5 - 2) {
                int i7 = i6 + 1;
                bArr[i6] = (byte) ((cCharAt2 >>> 6) | 960);
                i3 = i7 + 1;
                bArr[i7] = (byte) ((cCharAt2 & '?') | 128);
            } else {
                if ((cCharAt2 >= 55296 && 57343 >= cCharAt2) || i6 > i5 - 3) {
                    if (i6 > i5 - 4) {
                        if (55296 > cCharAt2 || cCharAt2 > 57343 || (i4 + 1 != charSequence.length() && Character.isSurrogatePair(cCharAt2, charSequence.charAt(i4 + 1)))) {
                            throw new ArrayIndexOutOfBoundsException("Failed writing " + cCharAt2 + " at index " + i6);
                        }
                        throw new IllegalArgumentException("Unpaired surrogate at index " + i4);
                    }
                    if (i4 + 1 != charSequence.length()) {
                        i4++;
                        char cCharAt3 = charSequence.charAt(i4);
                        if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                            int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                            int i8 = i6 + 1;
                            bArr[i6] = (byte) ((codePoint >>> 18) | 240);
                            int i9 = i8 + 1;
                            bArr[i8] = (byte) (((codePoint >>> 12) & 63) | 128);
                            int i10 = i9 + 1;
                            bArr[i9] = (byte) (((codePoint >>> 6) & 63) | 128);
                            i3 = i10 + 1;
                            bArr[i10] = (byte) ((codePoint & 63) | 128);
                        }
                    }
                    throw new IllegalArgumentException("Unpaired surrogate at index " + (i4 - 1));
                }
                int i11 = i6 + 1;
                bArr[i6] = (byte) ((cCharAt2 >>> '\f') | 480);
                int i12 = i11 + 1;
                bArr[i11] = (byte) (((cCharAt2 >>> 6) & 63) | 128);
                i3 = i12 + 1;
                bArr[i12] = (byte) ((cCharAt2 & '?') | 128);
            }
            i4++;
            i6 = i3;
        }
        return i6;
    }

    private static void zza(CharSequence charSequence, ByteBuffer byteBuffer) {
        if (byteBuffer.isReadOnly()) {
            throw new ReadOnlyBufferException();
        }
        if (!byteBuffer.hasArray()) {
            zzb(charSequence, byteBuffer);
            return;
        }
        try {
            byteBuffer.position(zza(charSequence, byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining()) - byteBuffer.arrayOffset());
        } catch (ArrayIndexOutOfBoundsException e) {
            BufferOverflowException bufferOverflowException = new BufferOverflowException();
            bufferOverflowException.initCause(e);
            throw bufferOverflowException;
        }
    }

    public static int zzaA(boolean z) {
        return 1;
    }

    public static int zzar(long j) {
        return zzav(j);
    }

    public static int zzas(long j) {
        return zzav(j);
    }

    public static int zzat(long j) {
        return zzav(zzax(j));
    }

    public static int zzav(long j) {
        if (((-128) & j) == 0) {
            return 1;
        }
        if (((-16384) & j) == 0) {
            return 2;
        }
        if (((-2097152) & j) == 0) {
            return 3;
        }
        if (((-268435456) & j) == 0) {
            return 4;
        }
        if (((-34359738368L) & j) == 0) {
            return 5;
        }
        if (((-4398046511104L) & j) == 0) {
            return 6;
        }
        if (((-562949953421312L) & j) == 0) {
            return 7;
        }
        if (((-72057594037927936L) & j) == 0) {
            return 8;
        }
        return (Long.MIN_VALUE & j) == 0 ? 9 : 10;
    }

    public static long zzax(long j) {
        return (j << 1) ^ (j >> 63);
    }

    public static int zzb(int i, double d) {
        return zzmA(i) + zzl(d);
    }

    public static int zzb(int i, zzsu zzsuVar) {
        return (zzmA(i) * 2) + zzd(zzsuVar);
    }

    public static int zzb(int i, byte[] bArr) {
        return zzmA(i) + zzG(bArr);
    }

    public static zzsn zzb(byte[] bArr, int i, int i2) {
        return new zzsn(bArr, i, i2);
    }

    private static void zzb(CharSequence charSequence, ByteBuffer byteBuffer) {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            char cCharAt = charSequence.charAt(i);
            if (cCharAt < 128) {
                byteBuffer.put((byte) cCharAt);
            } else if (cCharAt < 2048) {
                byteBuffer.put((byte) ((cCharAt >>> 6) | 960));
                byteBuffer.put((byte) ((cCharAt & '?') | 128));
            } else {
                if (cCharAt >= 55296 && 57343 >= cCharAt) {
                    if (i + 1 != charSequence.length()) {
                        i++;
                        char cCharAt2 = charSequence.charAt(i);
                        if (Character.isSurrogatePair(cCharAt, cCharAt2)) {
                            int codePoint = Character.toCodePoint(cCharAt, cCharAt2);
                            byteBuffer.put((byte) ((codePoint >>> 18) | 240));
                            byteBuffer.put((byte) (((codePoint >>> 12) & 63) | 128));
                            byteBuffer.put((byte) (((codePoint >>> 6) & 63) | 128));
                            byteBuffer.put((byte) ((codePoint & 63) | 128));
                        }
                    }
                    throw new IllegalArgumentException("Unpaired surrogate at index " + (i - 1));
                }
                byteBuffer.put((byte) ((cCharAt >>> '\f') | 480));
                byteBuffer.put((byte) (((cCharAt >>> 6) & 63) | 128));
                byteBuffer.put((byte) ((cCharAt & '?') | 128));
            }
            i++;
        }
    }

    public static int zzc(int i, float f) {
        return zzmA(i) + zzk(f);
    }

    public static int zzc(int i, zzsu zzsuVar) {
        return zzmA(i) + zze(zzsuVar);
    }

    private static int zzc(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        while (i < length && charSequence.charAt(i) < 128) {
            i++;
        }
        int i2 = i;
        int iZza = length;
        while (i2 < length) {
            char cCharAt = charSequence.charAt(i2);
            if (cCharAt >= 2048) {
                iZza += zza(charSequence, i2);
                break;
            }
            i2++;
            iZza = ((127 - cCharAt) >>> 31) + iZza;
        }
        if (iZza < length) {
            throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) iZza) + 4294967296L));
        }
        return iZza;
    }

    public static int zzd(int i, long j) {
        return zzmA(i) + zzas(j);
    }

    public static int zzd(zzsu zzsuVar) {
        return zzsuVar.getSerializedSize();
    }

    public static int zze(int i, long j) {
        return zzmA(i) + zzat(j);
    }

    public static int zze(zzsu zzsuVar) {
        int serializedSize = zzsuVar.getSerializedSize();
        return serializedSize + zzmC(serializedSize);
    }

    public static int zzf(int i, boolean z) {
        return zzmA(i) + zzaA(z);
    }

    public static int zzgO(String str) {
        int iZzc = zzc(str);
        return iZzc + zzmC(iZzc);
    }

    public static int zzk(float f) {
        return 4;
    }

    public static int zzl(double d) {
        return 8;
    }

    public static int zzmA(int i) {
        return zzmC(zzsx.zzF(i, 0));
    }

    public static int zzmC(int i) {
        if ((i & (-128)) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return ((-268435456) & i) == 0 ? 4 : 5;
    }

    public static int zzmE(int i) {
        return (i << 1) ^ (i >> 31);
    }

    public static int zzmx(int i) {
        if (i >= 0) {
            return zzmC(i);
        }
        return 10;
    }

    public static int zzmy(int i) {
        return zzmC(zzmE(i));
    }

    public static int zzo(int i, String str) {
        return zzmA(i) + zzgO(str);
    }

    public void zzA(int i, int i2) throws IOException {
        zzE(i, 0);
        zzmv(i2);
    }

    public void zzB(int i, int i2) throws IOException {
        zzE(i, 0);
        zzmw(i2);
    }

    public void zzE(int i, int i2) throws IOException {
        zzmB(zzsx.zzF(i, i2));
    }

    public void zzF(byte[] bArr) throws IOException {
        zzmB(bArr.length);
        zzH(bArr);
    }

    public void zzH(byte[] bArr) throws IOException {
        zzc(bArr, 0, bArr.length);
    }

    public int zzJn() {
        return this.zzbui.remaining();
    }

    public void zzJo() {
        if (zzJn() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public void zza(int i, double d) throws IOException {
        zzE(i, 1);
        zzk(d);
    }

    public void zza(int i, long j) throws IOException {
        zzE(i, 0);
        zzao(j);
    }

    public void zza(int i, zzsu zzsuVar) throws IOException {
        zzE(i, 2);
        zzc(zzsuVar);
    }

    public void zza(int i, byte[] bArr) throws IOException {
        zzE(i, 2);
        zzF(bArr);
    }

    public void zzao(long j) throws IOException {
        zzau(j);
    }

    public void zzap(long j) throws IOException {
        zzau(j);
    }

    public void zzaq(long j) throws IOException {
        zzau(zzax(j));
    }

    public void zzau(long j) throws IOException {
        while (((-128) & j) != 0) {
            zzmz((((int) j) & TransportMediator.KEYCODE_MEDIA_PAUSE) | 128);
            j >>>= 7;
        }
        zzmz((int) j);
    }

    public void zzaw(long j) throws IOException {
        if (this.zzbui.remaining() < 8) {
            throw new zza(this.zzbui.position(), this.zzbui.limit());
        }
        this.zzbui.putLong(j);
    }

    public void zzaz(boolean z) throws IOException {
        zzmz(z ? 1 : 0);
    }

    public void zzb(byte b) throws IOException {
        if (!this.zzbui.hasRemaining()) {
            throw new zza(this.zzbui.position(), this.zzbui.limit());
        }
        this.zzbui.put(b);
    }

    public void zzb(int i, float f) throws IOException {
        zzE(i, 5);
        zzj(f);
    }

    public void zzb(int i, long j) throws IOException {
        zzE(i, 0);
        zzap(j);
    }

    public void zzb(zzsu zzsuVar) throws IOException {
        zzsuVar.writeTo(this);
    }

    public void zzc(int i, long j) throws IOException {
        zzE(i, 0);
        zzaq(j);
    }

    public void zzc(zzsu zzsuVar) throws IOException {
        zzmB(zzsuVar.getCachedSize());
        zzsuVar.writeTo(this);
    }

    public void zzc(byte[] bArr, int i, int i2) throws IOException {
        if (this.zzbui.remaining() < i2) {
            throw new zza(this.zzbui.position(), this.zzbui.limit());
        }
        this.zzbui.put(bArr, i, i2);
    }

    public void zze(int i, boolean z) throws IOException {
        zzE(i, 0);
        zzaz(z);
    }

    public void zzgN(String str) throws IOException {
        try {
            int iZzmC = zzmC(str.length());
            if (iZzmC != zzmC(str.length() * 3)) {
                zzmB(zzc(str));
                zza(str, this.zzbui);
                return;
            }
            int iPosition = this.zzbui.position();
            if (this.zzbui.remaining() < iZzmC) {
                throw new zza(iZzmC + iPosition, this.zzbui.limit());
            }
            this.zzbui.position(iPosition + iZzmC);
            zza(str, this.zzbui);
            int iPosition2 = this.zzbui.position();
            this.zzbui.position(iPosition);
            zzmB((iPosition2 - iPosition) - iZzmC);
            this.zzbui.position(iPosition2);
        } catch (BufferOverflowException e) {
            zza zzaVar = new zza(this.zzbui.position(), this.zzbui.limit());
            zzaVar.initCause(e);
            throw zzaVar;
        }
    }

    public void zzj(float f) throws IOException {
        zzmD(Float.floatToIntBits(f));
    }

    public void zzk(double d) throws IOException {
        zzaw(Double.doubleToLongBits(d));
    }

    public void zzmB(int i) throws IOException {
        while ((i & (-128)) != 0) {
            zzmz((i & TransportMediator.KEYCODE_MEDIA_PAUSE) | 128);
            i >>>= 7;
        }
        zzmz(i);
    }

    public void zzmD(int i) throws IOException {
        if (this.zzbui.remaining() < 4) {
            throw new zza(this.zzbui.position(), this.zzbui.limit());
        }
        this.zzbui.putInt(i);
    }

    public void zzmv(int i) throws IOException {
        if (i >= 0) {
            zzmB(i);
        } else {
            zzau(i);
        }
    }

    public void zzmw(int i) throws IOException {
        zzmB(zzmE(i));
    }

    public void zzmz(int i) throws IOException {
        zzb((byte) i);
    }

    public void zzn(int i, String str) throws IOException {
        zzE(i, 2);
        zzgN(str);
    }
}
