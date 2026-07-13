package com.google.android.gms.internal;

/* JADX INFO: loaded from: classes.dex */
public class zzsl {
    private final byte[] zzbtW = new byte[256];
    private int zzbtX;
    private int zzbtY;

    public zzsl(byte[] bArr) {
        for (int i = 0; i < 256; i++) {
            this.zzbtW[i] = (byte) i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < 256; i3++) {
            i2 = (i2 + this.zzbtW[i3] + bArr[i3 % bArr.length]) & 255;
            byte b = this.zzbtW[i3];
            this.zzbtW[i3] = this.zzbtW[i2];
            this.zzbtW[i2] = b;
        }
        this.zzbtX = 0;
        this.zzbtY = 0;
    }

    public void zzC(byte[] bArr) {
        int i = this.zzbtX;
        int i2 = this.zzbtY;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            i = (i + 1) & 255;
            i2 = (i2 + this.zzbtW[i]) & 255;
            byte b = this.zzbtW[i];
            this.zzbtW[i] = this.zzbtW[i2];
            this.zzbtW[i2] = b;
            bArr[i3] = (byte) (bArr[i3] ^ this.zzbtW[(this.zzbtW[i] + this.zzbtW[i2]) & 255]);
        }
        this.zzbtX = i;
        this.zzbtY = i2;
    }
}
