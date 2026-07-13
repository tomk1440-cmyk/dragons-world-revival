package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class GoogleSignInOptions implements Api.ApiOptions.Optional, SafeParcelable {
    final int versionCode;
    private Account zzTI;
    private final ArrayList<Scope> zzWZ;
    private boolean zzXa;
    private final boolean zzXb;
    private final boolean zzXc;
    private String zzXd;
    private String zzXe;
    public static final Scope zzWW = new Scope(Scopes.PROFILE);
    public static final Scope zzWX = new Scope("email");
    public static final Scope zzWY = new Scope("openid");
    public static final GoogleSignInOptions DEFAULT_SIGN_IN = new Builder().requestId().requestProfile().build();
    public static final Parcelable.Creator<GoogleSignInOptions> CREATOR = new zzc();
    private static Comparator<Scope> zzWV = new Comparator<Scope>() { // from class: com.google.android.gms.auth.api.signin.GoogleSignInOptions.1
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
        public int compare(Scope scope, Scope scope2) {
            return scope.zzpb().compareTo(scope2.zzpb());
        }
    };

    public static final class Builder {
        private Account zzTI;
        private boolean zzXa;
        private boolean zzXb;
        private boolean zzXc;
        private String zzXd;
        private String zzXe;
        private Set<Scope> zzXf;

        public Builder() {
            this.zzXf = new HashSet();
        }

        public Builder(@NonNull GoogleSignInOptions googleSignInOptions) {
            this.zzXf = new HashSet();
            zzx.zzz(googleSignInOptions);
            this.zzXf = new HashSet(googleSignInOptions.zzWZ);
            this.zzXb = googleSignInOptions.zzXb;
            this.zzXc = googleSignInOptions.zzXc;
            this.zzXa = googleSignInOptions.zzXa;
            this.zzXd = googleSignInOptions.zzXd;
            this.zzTI = googleSignInOptions.zzTI;
            this.zzXe = googleSignInOptions.zzXe;
        }

        private String zzbK(String str) {
            zzx.zzcM(str);
            zzx.zzb(this.zzXd == null || this.zzXd.equals(str), "two different server client ids provided");
            return str;
        }

        public GoogleSignInOptions build() {
            if (this.zzXa && (this.zzTI == null || !this.zzXf.isEmpty())) {
                requestId();
            }
            return new GoogleSignInOptions(this.zzXf, this.zzTI, this.zzXa, this.zzXb, this.zzXc, this.zzXd, this.zzXe);
        }

        public Builder requestEmail() {
            this.zzXf.add(GoogleSignInOptions.zzWX);
            return this;
        }

        public Builder requestId() {
            this.zzXf.add(GoogleSignInOptions.zzWY);
            return this;
        }

        public Builder requestIdToken(String serverClientId) {
            this.zzXa = true;
            this.zzXd = zzbK(serverClientId);
            return this;
        }

        public Builder requestProfile() {
            this.zzXf.add(GoogleSignInOptions.zzWW);
            return this;
        }

        public Builder requestScopes(Scope scope, Scope... scopes) {
            this.zzXf.add(scope);
            this.zzXf.addAll(Arrays.asList(scopes));
            return this;
        }

        public Builder requestServerAuthCode(String serverClientId) {
            return requestServerAuthCode(serverClientId, false);
        }

        public Builder requestServerAuthCode(String serverClientId, boolean forceCodeForRefreshToken) {
            this.zzXb = true;
            this.zzXd = zzbK(serverClientId);
            this.zzXc = forceCodeForRefreshToken;
            return this;
        }

        public Builder setAccountName(String accountName) {
            this.zzTI = new Account(zzx.zzcM(accountName), "com.google");
            return this;
        }

        public Builder setHostedDomain(String hostedDomain) {
            this.zzXe = zzx.zzcM(hostedDomain);
            return this;
        }
    }

    GoogleSignInOptions(int versionCode, ArrayList<Scope> scopes, Account account, boolean idTokenRequested, boolean serverAuthCodeRequested, boolean forceCodeForRefreshToken, String serverClientId, String hostedDomain) {
        this.versionCode = versionCode;
        this.zzWZ = scopes;
        this.zzTI = account;
        this.zzXa = idTokenRequested;
        this.zzXb = serverAuthCodeRequested;
        this.zzXc = forceCodeForRefreshToken;
        this.zzXd = serverClientId;
        this.zzXe = hostedDomain;
    }

    private GoogleSignInOptions(Set<Scope> scopes, Account account, boolean idTokenRequested, boolean serverAuthCodeRequested, boolean forceCodeForRefreshToken, String serverClientId, String hostedDomain) {
        this(2, (ArrayList<Scope>) new ArrayList(scopes), account, idTokenRequested, serverAuthCodeRequested, forceCodeForRefreshToken, serverClientId, hostedDomain);
    }

    @Nullable
    public static GoogleSignInOptions zzbJ(@Nullable String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("scopes");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(new Scope(jSONArray.getString(i)));
        }
        String strOptString = jSONObject.optString("accountName", null);
        return new GoogleSignInOptions(hashSet, !TextUtils.isEmpty(strOptString) ? new Account(strOptString, "com.google") : null, jSONObject.getBoolean("idTokenRequested"), jSONObject.getBoolean("serverAuthRequested"), jSONObject.getBoolean("forceCodeForRefreshToken"), jSONObject.optString("serverClientId", null), jSONObject.optString("hostedDomain", null));
    }

    private JSONObject zzmJ() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            Collections.sort(this.zzWZ, zzWV);
            Iterator<Scope> it = this.zzWZ.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().zzpb());
            }
            jSONObject.put("scopes", jSONArray);
            if (this.zzTI != null) {
                jSONObject.put("accountName", this.zzTI.name);
            }
            jSONObject.put("idTokenRequested", this.zzXa);
            jSONObject.put("forceCodeForRefreshToken", this.zzXc);
            jSONObject.put("serverAuthRequested", this.zzXb);
            if (!TextUtils.isEmpty(this.zzXd)) {
                jSONObject.put("serverClientId", this.zzXd);
            }
            if (!TextUtils.isEmpty(this.zzXe)) {
                jSONObject.put("hostedDomain", this.zzXe);
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
        if (obj == null) {
            return false;
        }
        try {
            GoogleSignInOptions googleSignInOptions = (GoogleSignInOptions) obj;
            if (this.zzWZ.size() != googleSignInOptions.zzmN().size() || !this.zzWZ.containsAll(googleSignInOptions.zzmN())) {
                return false;
            }
            if (this.zzTI == null) {
                if (googleSignInOptions.getAccount() != null) {
                    return false;
                }
            } else if (!this.zzTI.equals(googleSignInOptions.getAccount())) {
                return false;
            }
            if (TextUtils.isEmpty(this.zzXd)) {
                if (!TextUtils.isEmpty(googleSignInOptions.zzmR())) {
                    return false;
                }
            } else if (!this.zzXd.equals(googleSignInOptions.zzmR())) {
                return false;
            }
            return this.zzXc == googleSignInOptions.zzmQ() && this.zzXa == googleSignInOptions.zzmO() && this.zzXb == googleSignInOptions.zzmP();
        } catch (ClassCastException e) {
            return false;
        }
    }

    public Account getAccount() {
        return this.zzTI;
    }

    public Scope[] getScopeArray() {
        return (Scope[]) this.zzWZ.toArray(new Scope[this.zzWZ.size()]);
    }

    public int hashCode() {
        ArrayList arrayList = new ArrayList();
        Iterator<Scope> it = this.zzWZ.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().zzpb());
        }
        Collections.sort(arrayList);
        return new com.google.android.gms.auth.api.signin.internal.zze().zzp(arrayList).zzp(this.zzTI).zzp(this.zzXd).zzP(this.zzXc).zzP(this.zzXa).zzP(this.zzXb).zzne();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        zzc.zza(this, out, flags);
    }

    public String zzmI() {
        return zzmJ().toString();
    }

    public ArrayList<Scope> zzmN() {
        return new ArrayList<>(this.zzWZ);
    }

    public boolean zzmO() {
        return this.zzXa;
    }

    public boolean zzmP() {
        return this.zzXb;
    }

    public boolean zzmQ() {
        return this.zzXc;
    }

    public String zzmR() {
        return this.zzXd;
    }

    public String zzmS() {
        return this.zzXe;
    }
}
