package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.Uri;
import com.facebook.internal.ServerProtocol;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
class zzj extends zzdd {
    private static final String ID = com.google.android.gms.internal.zzad.ARBITRARY_PIXEL.toString();
    private static final String URL = com.google.android.gms.internal.zzae.URL.toString();
    private static final String zzbhF = com.google.android.gms.internal.zzae.ADDITIONAL_PARAMS.toString();
    private static final String zzbhG = com.google.android.gms.internal.zzae.UNREPEATABLE.toString();
    static final String zzbhH = "gtm_" + ID + "_unrepeatable";
    private static final Set<String> zzbhI = new HashSet();
    private final Context mContext;
    private final zza zzbhJ;

    public interface zza {
        zzar zzFX();
    }

    public zzj(final Context context) {
        this(context, new zza() { // from class: com.google.android.gms.tagmanager.zzj.1
            @Override // com.google.android.gms.tagmanager.zzj.zza
            public zzar zzFX() {
                return zzz.zzaX(context);
            }
        });
    }

    zzj(Context context, zza zzaVar) {
        super(ID, URL);
        this.zzbhJ = zzaVar;
        this.mContext = context;
    }

    private synchronized boolean zzfL(String str) {
        boolean z = true;
        synchronized (this) {
            if (!zzfN(str)) {
                if (zzfM(str)) {
                    zzbhI.add(str);
                } else {
                    z = false;
                }
            }
        }
        return z;
    }

    @Override // com.google.android.gms.tagmanager.zzdd
    public void zzR(Map<String, com.google.android.gms.internal.zzag.zza> map) {
        String strZzg = map.get(zzbhG) != null ? zzdf.zzg(map.get(zzbhG)) : null;
        if (strZzg == null || !zzfL(strZzg)) {
            Uri.Builder builderBuildUpon = Uri.parse(zzdf.zzg(map.get(URL))).buildUpon();
            com.google.android.gms.internal.zzag.zza zzaVar = map.get(zzbhF);
            if (zzaVar != null) {
                Object objZzl = zzdf.zzl(zzaVar);
                if (!(objZzl instanceof List)) {
                    zzbg.e("ArbitraryPixel: additional params not a list: not sending partial hit: " + builderBuildUpon.build().toString());
                    return;
                }
                for (Object obj : (List) objZzl) {
                    if (!(obj instanceof Map)) {
                        zzbg.e("ArbitraryPixel: additional params contains non-map: not sending partial hit: " + builderBuildUpon.build().toString());
                        return;
                    }
                    for (Map.Entry entry : ((Map) obj).entrySet()) {
                        builderBuildUpon.appendQueryParameter(entry.getKey().toString(), entry.getValue().toString());
                    }
                }
            }
            String string = builderBuildUpon.build().toString();
            this.zzbhJ.zzFX().zzgc(string);
            zzbg.v("ArbitraryPixel: url = " + string);
            if (strZzg != null) {
                synchronized (zzj.class) {
                    zzbhI.add(strZzg);
                    zzcv.zzb(this.mContext, zzbhH, strZzg, ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
                }
            }
        }
    }

    boolean zzfM(String str) {
        return this.mContext.getSharedPreferences(zzbhH, 0).contains(str);
    }

    boolean zzfN(String str) {
        return zzbhI.contains(str);
    }
}
