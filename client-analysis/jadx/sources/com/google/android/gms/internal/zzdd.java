package com.google.android.gms.internal;

import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.plus.PlusShare;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public final class zzdd implements zzdf {
    private void zzb(zzjp zzjpVar, Map<String, String> map) {
        String str = map.get(PlusShare.KEY_CALL_TO_ACTION_LABEL);
        String str2 = map.get("start_label");
        String str3 = map.get("timestamp");
        if (TextUtils.isEmpty(str)) {
            zzin.zzaK("No label given for CSI tick.");
            return;
        }
        if (TextUtils.isEmpty(str3)) {
            zzin.zzaK("No timestamp given for CSI tick.");
            return;
        }
        try {
            long jZzc = zzc(Long.parseLong(str3));
            if (TextUtils.isEmpty(str2)) {
                str2 = "native:view_load";
            }
            zzjpVar.zzic().zza(str, str2, jZzc);
        } catch (NumberFormatException e) {
            zzin.zzd("Malformed timestamp for CSI tick.", e);
        }
    }

    private long zzc(long j) {
        return (j - com.google.android.gms.ads.internal.zzr.zzbG().currentTimeMillis()) + com.google.android.gms.ads.internal.zzr.zzbG().elapsedRealtime();
    }

    private void zzc(zzjp zzjpVar, Map<String, String> map) {
        String str = map.get("value");
        if (TextUtils.isEmpty(str)) {
            zzin.zzaK("No value given for CSI experiment.");
            return;
        }
        zzcb zzcbVarZzdA = zzjpVar.zzic().zzdA();
        if (zzcbVarZzdA == null) {
            zzin.zzaK("No ticker for WebView, dropping experiment ID.");
        } else {
            zzcbVarZzdA.zzc("e", str);
        }
    }

    private void zzd(zzjp zzjpVar, Map<String, String> map) {
        String str = map.get("name");
        String str2 = map.get("value");
        if (TextUtils.isEmpty(str2)) {
            zzin.zzaK("No value given for CSI extra.");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            zzin.zzaK("No name given for CSI extra.");
            return;
        }
        zzcb zzcbVarZzdA = zzjpVar.zzic().zzdA();
        if (zzcbVarZzdA == null) {
            zzin.zzaK("No ticker for WebView, dropping extra parameter.");
        } else {
            zzcbVarZzdA.zzc(str, str2);
        }
    }

    @Override // com.google.android.gms.internal.zzdf
    public void zza(zzjp zzjpVar, Map<String, String> map) {
        String str = map.get(NativeProtocol.WEB_DIALOG_ACTION);
        if ("tick".equals(str)) {
            zzb(zzjpVar, map);
        } else if ("experiment".equals(str)) {
            zzc(zzjpVar, map);
        } else if ("extra".equals(str)) {
            zzd(zzjpVar, map);
        }
    }
}
