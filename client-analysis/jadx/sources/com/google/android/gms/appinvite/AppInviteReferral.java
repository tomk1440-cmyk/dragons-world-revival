package com.google.android.gms.appinvite;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.adjust.sdk.Constants;
import com.google.android.gms.plus.PlusShare;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/* JADX INFO: loaded from: classes.dex */
public class AppInviteReferral {
    private AppInviteReferral() {
    }

    @Deprecated
    public static Intent addPlayStoreReferrerToIntent(Intent playStoreReferrerIntent, Intent referralIntent) {
        Bundle bundleZzh = zzh(playStoreReferrerIntent);
        if (bundleZzh != null && referralIntent != null) {
            referralIntent.putExtra("com.google.android.gms.appinvite.REFERRAL_BUNDLE", bundleZzh);
        }
        return referralIntent;
    }

    @Deprecated
    public static Intent addReferralDataToIntent(String invitationId, String deepLink, Intent referralIntent) {
        if (referralIntent == null) {
            return null;
        }
        return referralIntent.putExtra("com.google.android.gms.appinvite.REFERRAL_BUNDLE", zza(invitationId, deepLink, false));
    }

    public static String getDeepLink(Intent referralIntent) {
        Bundle bundleExtra;
        if (referralIntent == null || (bundleExtra = referralIntent.getBundleExtra("com.google.android.gms.appinvite.REFERRAL_BUNDLE")) == null) {
            return null;
        }
        return bundleExtra.getString("com.google.android.gms.appinvite.DEEP_LINK");
    }

    public static String getInvitationId(Intent referralIntent) {
        Bundle bundleExtra;
        if (referralIntent == null || (bundleExtra = referralIntent.getBundleExtra("com.google.android.gms.appinvite.REFERRAL_BUNDLE")) == null) {
            return null;
        }
        return bundleExtra.getString("com.google.android.gms.appinvite.INVITATION_ID");
    }

    public static boolean hasReferral(Intent referralIntent) {
        return (referralIntent == null || referralIntent.getBundleExtra("com.google.android.gms.appinvite.REFERRAL_BUNDLE") == null) ? false : true;
    }

    public static boolean isOpenedFromPlayStore(Intent referralIntent) {
        return hasReferral(referralIntent) && referralIntent.getBundleExtra("com.google.android.gms.appinvite.REFERRAL_BUNDLE").getBoolean("com.google.android.gms.appinvite.OPENED_FROM_PLAY_STORE", false);
    }

    private static Bundle zza(String str, String str2, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putString("com.google.android.gms.appinvite.INVITATION_ID", str);
        bundle.putString("com.google.android.gms.appinvite.DEEP_LINK", str2);
        bundle.putBoolean("com.google.android.gms.appinvite.OPENED_FROM_PLAY_STORE", z);
        return bundle;
    }

    private static Bundle zzh(Intent intent) {
        if (intent == null || !intent.getAction().equals("com.android.vending.INSTALL_REFERRER") || intent.getStringExtra(Constants.REFERRER) == null) {
            return null;
        }
        String stringExtra = intent.getStringExtra(Constants.REFERRER);
        try {
            String strDecode = URLDecoder.decode(stringExtra, "UTF-8");
            Uri uri = Uri.parse("s://a.b.c?" + strDecode);
            String queryParameter = uri.getQueryParameter("invitation_id");
            String queryParameter2 = uri.getQueryParameter(PlusShare.PARAM_CONTENT_DEEP_LINK_ID);
            if (queryParameter != null || queryParameter2 != null) {
                return zza(queryParameter, queryParameter2, true);
            }
            Log.w("AppInviteRef", "Missing  Referrer query params: " + strDecode);
            return null;
        } catch (UnsupportedEncodingException e) {
            Log.e("AppInviteRef", "Error parsing Play Store referrer URL: " + stringExtra);
            return null;
        }
    }
}
