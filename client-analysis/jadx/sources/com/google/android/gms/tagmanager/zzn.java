package com.google.android.gms.tagmanager;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class zzn extends zzak {
    private static final String ID = com.google.android.gms.internal.zzad.CONSTANT.toString();
    private static final String VALUE = com.google.android.gms.internal.zzae.VALUE.toString();

    public zzn() {
        super(ID, VALUE);
    }

    public static String zzFZ() {
        return ID;
    }

    public static String zzGa() {
        return VALUE;
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public boolean zzFW() {
        return true;
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public com.google.android.gms.internal.zzag.zza zzP(Map<String, com.google.android.gms.internal.zzag.zza> map) {
        return map.get(VALUE);
    }
}
