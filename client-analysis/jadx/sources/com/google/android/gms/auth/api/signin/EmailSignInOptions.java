package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Patterns;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class EmailSignInOptions implements SafeParcelable {
    public static final Parcelable.Creator<EmailSignInOptions> CREATOR = new zza();
    final int versionCode;
    private final Uri zzWL;
    private String zzWM;
    private Uri zzWN;

    EmailSignInOptions(int versionCode, Uri serverWidgetUrl, String modeQueryName, Uri tosUrl) {
        zzx.zzb(serverWidgetUrl, "Server widget url cannot be null in order to use email/password sign in.");
        zzx.zzh(serverWidgetUrl.toString(), "Server widget url cannot be null in order to use email/password sign in.");
        zzx.zzb(Patterns.WEB_URL.matcher(serverWidgetUrl.toString()).matches(), "Invalid server widget url");
        this.versionCode = versionCode;
        this.zzWL = serverWidgetUrl;
        this.zzWM = modeQueryName;
        this.zzWN = tosUrl;
    }

    private JSONObject zzmJ() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("serverWidgetUrl", this.zzWL.toString());
            if (!TextUtils.isEmpty(this.zzWM)) {
                jSONObject.put("modeQueryName", this.zzWM);
            }
            if (this.zzWN != null) {
                jSONObject.put("tosUrl", this.zzWN.toString());
            }
            return jSONObject;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj != null) {
            try {
                EmailSignInOptions emailSignInOptions = (EmailSignInOptions) obj;
                if (this.zzWL.equals(emailSignInOptions.zzmF())) {
                    if (this.zzWN == null) {
                        if (emailSignInOptions.zzmG() == null) {
                            if (TextUtils.isEmpty(this.zzWM) ? this.zzWM.equals(emailSignInOptions.zzmH()) : TextUtils.isEmpty(emailSignInOptions.zzmH())) {
                            }
                        }
                    } else if (this.zzWN.equals(emailSignInOptions.zzmG())) {
                        z = TextUtils.isEmpty(this.zzWM) ? true : true;
                    }
                }
            } catch (ClassCastException e) {
            }
        }
        return z;
    }

    public int hashCode() {
        return new com.google.android.gms.auth.api.signin.internal.zze().zzp(this.zzWL).zzp(this.zzWN).zzp(this.zzWM).zzne();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        zza.zza(this, out, flags);
    }

    public Uri zzmF() {
        return this.zzWL;
    }

    public Uri zzmG() {
        return this.zzWN;
    }

    public String zzmH() {
        return this.zzWM;
    }

    public String zzmI() {
        return zzmJ().toString();
    }
}
