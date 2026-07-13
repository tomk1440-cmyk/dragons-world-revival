package com.google.android.gms.ads.internal.request;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.zzbt;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzit;
import com.google.android.gms.internal.zzji;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public final class zzc {

    public interface zza {
        void zzb(AdResponseParcel adResponseParcel);
    }

    interface zzb {
        boolean zza(VersionInfoParcel versionInfoParcel);
    }

    public static zzit zza(final Context context, VersionInfoParcel versionInfoParcel, zzji<AdRequestInfoParcel> zzjiVar, zza zzaVar) {
        return zza(context, versionInfoParcel, zzjiVar, zzaVar, new zzb() { // from class: com.google.android.gms.ads.internal.request.zzc.1
            @Override // com.google.android.gms.ads.internal.request.zzc.zzb
            public boolean zza(VersionInfoParcel versionInfoParcel2) {
                return versionInfoParcel2.zzNb || (com.google.android.gms.common.zze.zzap(context) && !zzbt.zzwb.get().booleanValue());
            }
        });
    }

    static zzit zza(Context context, VersionInfoParcel versionInfoParcel, zzji<AdRequestInfoParcel> zzjiVar, zza zzaVar, zzb zzbVar) {
        return zzbVar.zza(versionInfoParcel) ? zza(context, zzjiVar, zzaVar) : zzb(context, versionInfoParcel, zzjiVar, zzaVar);
    }

    private static zzit zza(Context context, zzji<AdRequestInfoParcel> zzjiVar, zza zzaVar) {
        zzin.zzaI("Fetching ad response from local ad request service.");
        zzd.zza zzaVar2 = new zzd.zza(context, zzjiVar, zzaVar);
        zzaVar2.zzgd();
        return zzaVar2;
    }

    private static zzit zzb(Context context, VersionInfoParcel versionInfoParcel, zzji<AdRequestInfoParcel> zzjiVar, zza zzaVar) {
        zzin.zzaI("Fetching ad response from remote ad request service.");
        if (com.google.android.gms.ads.internal.client.zzn.zzcS().zzU(context)) {
            return new zzd.zzb(context, versionInfoParcel, zzjiVar, zzaVar);
        }
        zzin.zzaK("Failed to connect to remote ad request service.");
        return null;
    }
}
