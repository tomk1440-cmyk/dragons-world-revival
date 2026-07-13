package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzee {

    private static class zza<JavascriptEngine> extends zzjd<JavascriptEngine> {
        JavascriptEngine zzAR;

        private zza() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [JavascriptEngine, com.google.android.gms.internal.zzed, com.google.android.gms.internal.zzef] */
    public zzed zza(Context context, VersionInfoParcel versionInfoParcel, final zza<zzed> zzaVar, zzan zzanVar) {
        ?? zzefVar = new zzef(context, versionInfoParcel, zzanVar);
        zzaVar.zzAR = zzefVar;
        zzefVar.zza(new zzed.zza() { // from class: com.google.android.gms.internal.zzee.2
            @Override // com.google.android.gms.internal.zzed.zza
            public void zzeo() {
                zzaVar.zzg(zzaVar.zzAR);
            }
        });
        return zzefVar;
    }

    public Future<zzed> zza(final Context context, final VersionInfoParcel versionInfoParcel, final String str, final zzan zzanVar) {
        final zza zzaVar = new zza();
        zzir.zzMc.post(new Runnable() { // from class: com.google.android.gms.internal.zzee.1
            @Override // java.lang.Runnable
            public void run() {
                zzee.this.zza(context, versionInfoParcel, (zza<zzed>) zzaVar, zzanVar).zzaa(str);
            }
        });
        return zzaVar;
    }
}
