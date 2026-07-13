package com.google.android.gms.auth.api.consent;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.firstparty.shared.ScopeDetail;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

/* JADX INFO: loaded from: classes.dex */
public class GetConsentIntentRequest implements SafeParcelable {
    public static final Parcelable.Creator<GetConsentIntentRequest> CREATOR = new zzb();
    private final int mVersionCode;
    private final Account zzTI;
    private final String zzVO;
    private final int zzVP;
    private final String zzVQ;
    final ScopeDetail[] zzVR;
    private final boolean zzVS;
    private final int zzVT;
    private final String zzVU;

    GetConsentIntentRequest(int versionCode, String callingPackage, int callingUid, String service, Account account, ScopeDetail[] scopeDetails, boolean hasTitle, int title, String consentCookieWrapper) {
        this.mVersionCode = versionCode;
        this.zzVO = callingPackage;
        this.zzVP = callingUid;
        this.zzVQ = service;
        this.zzTI = (Account) zzx.zzz(account);
        this.zzVR = scopeDetails;
        this.zzVS = hasTitle;
        this.zzVT = title;
        this.zzVU = consentCookieWrapper;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Account getAccount() {
        return this.zzTI;
    }

    public String getCallingPackage() {
        return this.zzVO;
    }

    public int getCallingUid() {
        return this.zzVP;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzb.zza(this, dest, flags);
    }

    public String zzmt() {
        return this.zzVQ;
    }

    public boolean zzmu() {
        return this.zzVS;
    }

    public int zzmv() {
        return this.zzVT;
    }

    public String zzmw() {
        return this.zzVU;
    }
}
