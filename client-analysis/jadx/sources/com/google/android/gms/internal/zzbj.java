package com.google.android.gms.internal;

import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzbj extends zzbg {
    private MessageDigest zztw;

    byte[] zza(String[] strArr) {
        byte[] bArr = new byte[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            bArr[i] = zzk(zzbi.zzx(strArr[i]));
        }
        return bArr;
    }

    byte zzk(int i) {
        return (byte) ((((i & 255) ^ ((65280 & i) >> 8)) ^ ((16711680 & i) >> 16)) ^ (((-16777216) & i) >> 24));
    }

    @Override // com.google.android.gms.internal.zzbg
    public byte[] zzu(String str) {
        byte[] bArr;
        byte[] bArrZza = zza(str.split(" "));
        this.zztw = zzcL();
        synchronized (this.zzpV) {
            if (this.zztw == null) {
                bArr = new byte[0];
            } else {
                this.zztw.reset();
                this.zztw.update(bArrZza);
                byte[] bArrDigest = this.zztw.digest();
                bArr = new byte[bArrDigest.length <= 4 ? bArrDigest.length : 4];
                System.arraycopy(bArrDigest, 0, bArr, 0, bArr.length);
            }
        }
        return bArr;
    }
}
