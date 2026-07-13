package com.google.android.gms.ads.internal.request;

import android.content.Context;
import com.google.android.gms.internal.zzan;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzif;
import com.google.android.gms.internal.zzim;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zza {

    /* JADX INFO: renamed from: com.google.android.gms.ads.internal.request.zza$zza, reason: collision with other inner class name */
    public interface InterfaceC0027zza {
        void zza(zzif.zza zzaVar);
    }

    public zzim zza(Context context, AdRequestInfoParcel.zza zzaVar, zzan zzanVar, InterfaceC0027zza interfaceC0027zza) {
        zzim zzmVar = zzaVar.zzHt.extras.getBundle("sdk_less_server_data") != null ? new zzm(context, zzaVar, interfaceC0027zza) : new zzb(context, zzaVar, zzanVar, interfaceC0027zza);
        zzmVar.zzgd();
        return zzmVar;
    }
}
