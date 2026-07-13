package com.google.android.gms.tagmanager;

import android.content.Context;
import android.provider.Settings;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class zzaa extends zzak {
    private static final String ID = com.google.android.gms.internal.zzad.DEVICE_ID.toString();
    private final Context mContext;

    public zzaa(Context context) {
        super(ID, new String[0]);
        this.mContext = context;
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public boolean zzFW() {
        return true;
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public com.google.android.gms.internal.zzag.zza zzP(Map<String, com.google.android.gms.internal.zzag.zza> map) {
        String strZzaY = zzaY(this.mContext);
        return strZzaY == null ? zzdf.zzHF() : zzdf.zzR(strZzaY);
    }

    protected String zzaY(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), "android_id");
    }
}
