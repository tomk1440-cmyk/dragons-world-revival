package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.EmailSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class SignInConfiguration implements SafeParcelable {
    public static final Parcelable.Creator<SignInConfiguration> CREATOR = new zzp();
    final int versionCode;
    private final String zzXL;
    private EmailSignInOptions zzXM;
    private GoogleSignInOptions zzXN;
    private String zzXO;
    private String zzXd;

    SignInConfiguration(int versionCode, String consumerPkgName, String serverClientId, EmailSignInOptions emailConfig, GoogleSignInOptions googleConfig, String apiKey) {
        this.versionCode = versionCode;
        this.zzXL = zzx.zzcM(consumerPkgName);
        this.zzXd = serverClientId;
        this.zzXM = emailConfig;
        this.zzXN = googleConfig;
        this.zzXO = apiKey;
    }

    public SignInConfiguration(String consumerPkgName) {
        this(2, consumerPkgName, null, null, null, null);
    }

    private JSONObject zzmJ() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("consumerPackageName", this.zzXL);
            if (!TextUtils.isEmpty(this.zzXd)) {
                jSONObject.put("serverClientId", this.zzXd);
            }
            if (this.zzXM != null) {
                jSONObject.put("emailSignInOptions", this.zzXM.zzmI());
            }
            if (this.zzXN != null) {
                jSONObject.put("googleSignInOptions", this.zzXN.zzmI());
            }
            if (!TextUtils.isEmpty(this.zzXO)) {
                jSONObject.put("apiKey", this.zzXO);
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

    /* JADX WARN: Code duplicated, block: B:13:0x002c A[Catch: ClassCastException -> 0x0080, TryCatch #0 {ClassCastException -> 0x0080, blocks: (B:5:0x0004, B:7:0x0012, B:9:0x001a, B:11:0x0024, B:13:0x002c, B:15:0x0036, B:17:0x003a, B:19:0x0040, B:21:0x0044, B:33:0x0073, B:30:0x0066, B:27:0x0059, B:24:0x004c), top: B:39:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:15:0x0036 A[Catch: ClassCastException -> 0x0080, TryCatch #0 {ClassCastException -> 0x0080, blocks: (B:5:0x0004, B:7:0x0012, B:9:0x001a, B:11:0x0024, B:13:0x002c, B:15:0x0036, B:17:0x003a, B:19:0x0040, B:21:0x0044, B:33:0x0073, B:30:0x0066, B:27:0x0059, B:24:0x004c), top: B:39:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:17:0x003a A[Catch: ClassCastException -> 0x0080, TryCatch #0 {ClassCastException -> 0x0080, blocks: (B:5:0x0004, B:7:0x0012, B:9:0x001a, B:11:0x0024, B:13:0x002c, B:15:0x0036, B:17:0x003a, B:19:0x0040, B:21:0x0044, B:33:0x0073, B:30:0x0066, B:27:0x0059, B:24:0x004c), top: B:39:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:19:0x0040 A[Catch: ClassCastException -> 0x0080, TryCatch #0 {ClassCastException -> 0x0080, blocks: (B:5:0x0004, B:7:0x0012, B:9:0x001a, B:11:0x0024, B:13:0x002c, B:15:0x0036, B:17:0x003a, B:19:0x0040, B:21:0x0044, B:33:0x0073, B:30:0x0066, B:27:0x0059, B:24:0x004c), top: B:39:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:21:0x0044 A[Catch: ClassCastException -> 0x0080, TryCatch #0 {ClassCastException -> 0x0080, blocks: (B:5:0x0004, B:7:0x0012, B:9:0x001a, B:11:0x0024, B:13:0x002c, B:15:0x0036, B:17:0x003a, B:19:0x0040, B:21:0x0044, B:33:0x0073, B:30:0x0066, B:27:0x0059, B:24:0x004c), top: B:39:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:27:0x0059 A[Catch: ClassCastException -> 0x0080, TryCatch #0 {ClassCastException -> 0x0080, blocks: (B:5:0x0004, B:7:0x0012, B:9:0x001a, B:11:0x0024, B:13:0x002c, B:15:0x0036, B:17:0x003a, B:19:0x0040, B:21:0x0044, B:33:0x0073, B:30:0x0066, B:27:0x0059, B:24:0x004c), top: B:39:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x0065  */
    /* JADX WARN: Code duplicated, block: B:30:0x0066 A[Catch: ClassCastException -> 0x0080, TryCatch #0 {ClassCastException -> 0x0080, blocks: (B:5:0x0004, B:7:0x0012, B:9:0x001a, B:11:0x0024, B:13:0x002c, B:15:0x0036, B:17:0x003a, B:19:0x0040, B:21:0x0044, B:33:0x0073, B:30:0x0066, B:27:0x0059, B:24:0x004c), top: B:39:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x0072  */
    /* JADX WARN: Code duplicated, block: B:33:0x0073 A[Catch: ClassCastException -> 0x0080, TRY_LEAVE, TryCatch #0 {ClassCastException -> 0x0080, blocks: (B:5:0x0004, B:7:0x0012, B:9:0x001a, B:11:0x0024, B:13:0x002c, B:15:0x0036, B:17:0x003a, B:19:0x0040, B:21:0x0044, B:33:0x0073, B:30:0x0066, B:27:0x0059, B:24:0x004c), top: B:39:0x0004 }] */
    public boolean equals(Object obj) {
        boolean z = false;
        if (obj != null) {
            try {
                SignInConfiguration signInConfiguration = (SignInConfiguration) obj;
                if (this.zzXL.equals(signInConfiguration.zznk())) {
                    if (TextUtils.isEmpty(this.zzXd)) {
                        if (TextUtils.isEmpty(signInConfiguration.zzmR())) {
                            if (TextUtils.isEmpty(this.zzXO)) {
                                if (TextUtils.isEmpty(signInConfiguration.zznn())) {
                                    if (this.zzXM == null) {
                                        if (signInConfiguration.zznl() == null) {
                                            if (this.zzXN == null ? this.zzXN.equals(signInConfiguration.zznm()) : signInConfiguration.zznm() == null) {
                                            }
                                        }
                                    } else if (this.zzXM.equals(signInConfiguration.zznl())) {
                                        z = this.zzXN == null ? true : true;
                                    }
                                }
                            } else if (this.zzXO.equals(signInConfiguration.zznn())) {
                                if (this.zzXM == null) {
                                    if (signInConfiguration.zznl() == null) {
                                        if (this.zzXN == null) {
                                        }
                                    }
                                } else if (this.zzXM.equals(signInConfiguration.zznl())) {
                                    if (this.zzXN == null) {
                                    }
                                }
                            }
                        }
                    } else if (this.zzXd.equals(signInConfiguration.zzmR())) {
                        if (TextUtils.isEmpty(this.zzXO)) {
                            if (TextUtils.isEmpty(signInConfiguration.zznn())) {
                                if (this.zzXM == null) {
                                    if (signInConfiguration.zznl() == null) {
                                        if (this.zzXN == null) {
                                        }
                                    }
                                } else if (this.zzXM.equals(signInConfiguration.zznl())) {
                                    if (this.zzXN == null) {
                                    }
                                }
                            }
                        } else if (this.zzXO.equals(signInConfiguration.zznn())) {
                            if (this.zzXM == null) {
                                if (signInConfiguration.zznl() == null) {
                                    if (this.zzXN == null) {
                                    }
                                }
                            } else if (this.zzXM.equals(signInConfiguration.zznl())) {
                                if (this.zzXN == null) {
                                }
                            }
                        }
                    }
                }
            } catch (ClassCastException e) {
            }
        }
        return z;
    }

    public int hashCode() {
        return new zze().zzp(this.zzXL).zzp(this.zzXd).zzp(this.zzXO).zzp(this.zzXM).zzp(this.zzXN).zzne();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        zzp.zza(this, out, flags);
    }

    public SignInConfiguration zzj(GoogleSignInOptions googleSignInOptions) {
        this.zzXN = (GoogleSignInOptions) zzx.zzb(googleSignInOptions, "GoogleSignInOptions cannot be null.");
        return this;
    }

    public String zzmI() {
        return zzmJ().toString();
    }

    public String zzmR() {
        return this.zzXd;
    }

    public String zznk() {
        return this.zzXL;
    }

    public EmailSignInOptions zznl() {
        return this.zzXM;
    }

    public GoogleSignInOptions zznm() {
        return this.zzXN;
    }

    public String zznn() {
        return this.zzXO;
    }
}
