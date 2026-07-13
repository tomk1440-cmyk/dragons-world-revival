package com.google.android.gms.ads.internal;

import android.net.Uri;
import android.text.TextUtils;
import com.adjust.sdk.Constants;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.internal.zzbt;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzif;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzjp;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zze {
    private boolean zzpA;
    private boolean zzpB;
    private zza zzpz;

    public interface zza {
        void zzr(String str);
    }

    @zzhb
    public static class zzb implements zza {
        private final zzif.zza zzpC;
        private final zzjp zzpD;

        public zzb(zzif.zza zzaVar, zzjp zzjpVar) {
            this.zzpC = zzaVar;
            this.zzpD = zzjpVar;
        }

        @Override // com.google.android.gms.ads.internal.zze.zza
        public void zzr(String str) {
            zzin.zzaI("An auto-clicking creative is blocked");
            Uri.Builder builder = new Uri.Builder();
            builder.scheme(Constants.SCHEME);
            builder.path("//pagead2.googlesyndication.com/pagead/gen_204");
            builder.appendQueryParameter(ShareConstants.WEB_DIALOG_PARAM_ID, "gmob-apps-blocked-navigation");
            if (!TextUtils.isEmpty(str)) {
                builder.appendQueryParameter("navigationURL", str);
            }
            if (this.zzpC != null && this.zzpC.zzLe != null && !TextUtils.isEmpty(this.zzpC.zzLe.zzHY)) {
                builder.appendQueryParameter("debugDialog", this.zzpC.zzLe.zzHY);
            }
            zzr.zzbC().zzc(this.zzpD.getContext(), this.zzpD.zzhX().afmaVersion, builder.toString());
        }
    }

    public zze() {
        this.zzpB = zzbt.zzvI.get().booleanValue();
    }

    public zze(boolean z) {
        this.zzpB = z;
    }

    public void recordClick() {
        this.zzpA = true;
    }

    public void zza(zza zzaVar) {
        this.zzpz = zzaVar;
    }

    public boolean zzbh() {
        return !this.zzpB || this.zzpA;
    }

    public void zzq(String str) {
        zzin.zzaI("Action was blocked because no click was detected.");
        if (this.zzpz != null) {
            this.zzpz.zzr(str);
        }
    }
}
