package com.google.android.gms.ads.internal.formats;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.internal.zzch;
import com.google.android.gms.internal.zzhb;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzc extends zzch.zza {
    private final Uri mUri;
    private final Drawable zzxU;
    private final double zzxV;

    public zzc(Drawable drawable, Uri uri, double d) {
        this.zzxU = drawable;
        this.mUri = uri;
        this.zzxV = d;
    }

    @Override // com.google.android.gms.internal.zzch
    public double getScale() {
        return this.zzxV;
    }

    @Override // com.google.android.gms.internal.zzch
    public Uri getUri() throws RemoteException {
        return this.mUri;
    }

    @Override // com.google.android.gms.internal.zzch
    public com.google.android.gms.dynamic.zzd zzdJ() throws RemoteException {
        return com.google.android.gms.dynamic.zze.zzC(this.zzxU);
    }
}
