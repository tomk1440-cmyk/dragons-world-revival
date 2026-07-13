package com.google.android.gms.tagmanager;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
class zzaq {
    private final long zzSL;
    private final long zzbiX;
    private final long zzbiY;
    private String zzbiZ;

    zzaq(long j, long j2, long j3) {
        this.zzbiX = j;
        this.zzSL = j2;
        this.zzbiY = j3;
    }

    long zzGD() {
        return this.zzbiX;
    }

    long zzGE() {
        return this.zzbiY;
    }

    String zzGF() {
        return this.zzbiZ;
    }

    void zzgf(String str) {
        if (str == null || TextUtils.isEmpty(str.trim())) {
            return;
        }
        this.zzbiZ = str;
    }
}
