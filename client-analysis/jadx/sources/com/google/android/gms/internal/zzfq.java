package com.google.android.gms.internal;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzfq {
    private final boolean zzDu;
    private final boolean zzDv;
    private final boolean zzDw;
    private final boolean zzDx;
    private final boolean zzDy;

    public static final class zza {
        private boolean zzDu;
        private boolean zzDv;
        private boolean zzDw;
        private boolean zzDx;
        private boolean zzDy;

        public zzfq zzeP() {
            return new zzfq(this);
        }

        public zza zzq(boolean z) {
            this.zzDu = z;
            return this;
        }

        public zza zzr(boolean z) {
            this.zzDv = z;
            return this;
        }

        public zza zzs(boolean z) {
            this.zzDw = z;
            return this;
        }

        public zza zzt(boolean z) {
            this.zzDx = z;
            return this;
        }

        public zza zzu(boolean z) {
            this.zzDy = z;
            return this;
        }
    }

    private zzfq(zza zzaVar) {
        this.zzDu = zzaVar.zzDu;
        this.zzDv = zzaVar.zzDv;
        this.zzDw = zzaVar.zzDw;
        this.zzDx = zzaVar.zzDx;
        this.zzDy = zzaVar.zzDy;
    }

    public JSONObject toJson() {
        try {
            return new JSONObject().put("sms", this.zzDu).put("tel", this.zzDv).put("calendar", this.zzDw).put("storePicture", this.zzDx).put("inlineVideo", this.zzDy);
        } catch (JSONException e) {
            zzin.zzb("Error occured while obtaining the MRAID capabilities.", e);
            return null;
        }
    }
}
