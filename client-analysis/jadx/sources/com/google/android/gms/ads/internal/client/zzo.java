package com.google.android.gms.ads.internal.client;

import com.google.android.gms.internal.zzhb;
import java.util.Random;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzo extends zzx.zza {
    private Object zzpV = new Object();
    private final Random zzuy = new Random();
    private long zzuz;

    public zzo() {
        zzcY();
    }

    @Override // com.google.android.gms.ads.internal.client.zzx
    public long getValue() {
        return this.zzuz;
    }

    public void zzcY() {
        synchronized (this.zzpV) {
            int i = 3;
            long jNextInt = 0;
            while (true) {
                i--;
                if (i <= 0) {
                    break;
                }
                jNextInt = ((long) this.zzuy.nextInt()) + 2147483648L;
                if (jNextInt != this.zzuz && jNextInt != 0) {
                    break;
                }
            }
            this.zzuz = jNextInt;
        }
    }
}
