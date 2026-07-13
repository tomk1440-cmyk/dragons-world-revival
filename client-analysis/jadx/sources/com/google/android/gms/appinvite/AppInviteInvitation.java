package com.google.android.gms.appinvite;

import android.accounts.Account;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.adjust.sdk.Constants;
import com.google.android.gms.common.internal.zzx;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class AppInviteInvitation {
    private static final String[] zzUK = {"jpg", "jpeg", "png"};

    public static final class IntentBuilder {
        public static final int MAX_CALL_TO_ACTION_TEXT_LENGTH = 20;
        public static final int MAX_EMAIL_HTML_CONTENT = 512000;
        public static final int MAX_MESSAGE_LENGTH = 100;
        public static final int MIN_CALL_TO_ACTION_TEXT_LENGTH = 2;
        private final Intent mIntent;
        private String zzUL;
        private String zzUM;

        @Retention(RetentionPolicy.SOURCE)
        public @interface PlatformMode {
            public static final int PROJECT_PLATFORM_ANDROID = 2;
            public static final int PROJECT_PLATFORM_IOS = 1;
        }

        public IntentBuilder(@NonNull CharSequence title) {
            zzx.zzz(title);
            this.mIntent = new Intent("com.google.android.gms.appinvite.ACTION_APP_INVITE");
            this.mIntent.putExtra("com.google.android.gms.appinvite.TITLE", title);
            this.mIntent.setPackage("com.google.android.gms");
        }

        public Intent build() {
            if (!TextUtils.isEmpty(this.zzUL)) {
                zzx.zzh(this.zzUM, "Email html content must be set when email subject is set.");
                zzx.zzb(this.mIntent.getData() == null, "Custom image must not be set when email html content is set.");
                zzx.zzb(TextUtils.isEmpty(this.mIntent.getCharSequenceExtra("com.google.android.gms.appinvite.BUTTON_TEXT")), "Call to action text must not be set when email html content is set.");
                this.mIntent.putExtra("com.google.android.gms.appinvite.EMAIL_SUBJECT", this.zzUL);
                this.mIntent.putExtra("com.google.android.gms.appinvite.EMAIL_CONTENT", this.zzUM);
            } else if (!TextUtils.isEmpty(this.zzUM)) {
                throw new IllegalArgumentException("Email subject must be set when email html content is set.");
            }
            return this.mIntent;
        }

        public IntentBuilder setAccount(Account account) {
            if (account == null || !"com.google".equals(account.type)) {
                this.mIntent.removeExtra("com.google.android.gms.appinvite.ACCOUNT_NAME");
            } else {
                this.mIntent.putExtra("com.google.android.gms.appinvite.ACCOUNT_NAME", account);
            }
            return this;
        }

        public IntentBuilder setAdditionalReferralParameters(Map<String, String> params) {
            if (params != null) {
                this.mIntent.putExtra("com.google.android.gms.appinvite.REFERRAL_PARAMETERS_URI", AppInviteInvitation.zzJ(params));
            } else {
                this.mIntent.removeExtra("com.google.android.gms.appinvite.REFERRAL_PARAMETERS_URI");
            }
            return this;
        }

        public IntentBuilder setAndroidMinimumVersionCode(int versionCode) {
            this.mIntent.putExtra("com.google.android.gms.appinvite.appMinimumVersionCode", versionCode);
            return this;
        }

        public IntentBuilder setCallToActionText(CharSequence callToActionText) {
            if (callToActionText == null || callToActionText.length() < 2 || callToActionText.length() > 20) {
                throw new IllegalArgumentException(String.format("Text must be between %d and %d chars in length.", 2, 20));
            }
            this.mIntent.putExtra("com.google.android.gms.appinvite.BUTTON_TEXT", callToActionText);
            return this;
        }

        public IntentBuilder setCustomImage(Uri imageUri) {
            zzx.zzz(imageUri);
            zzx.zzb(imageUri.isAbsolute(), "Image uri is not an absolute uri. Did you forget to add a scheme to the Uri?");
            String lowerCase = imageUri.getScheme().toLowerCase();
            boolean z = lowerCase.equals("android.resource") || lowerCase.equals("content") || lowerCase.equals("file");
            zzx.zzb(z || lowerCase.equals("http") || lowerCase.equals(Constants.SCHEME), "Image uri must be a content URI with scheme \"android.resource\", \"content\" or \"file\", or a network url with scheme \"http\" or \"https\".");
            if (!z) {
                String string = imageUri.toString();
                String strSubstring = string.substring(string.lastIndexOf("/") + 1, string.length());
                String lowerCase2 = (strSubstring == null || strSubstring.lastIndexOf(".") == -1) ? null : strSubstring.substring(strSubstring.lastIndexOf(".") + 1, strSubstring.length()).toLowerCase();
                zzx.zzb(TextUtils.isEmpty(lowerCase2) || AppInviteInvitation.zzbE(lowerCase2), lowerCase2 + " images are not supported. Only jpg, jpeg, or png images are supported.");
            }
            this.mIntent.setData(imageUri.buildUpon().scheme(lowerCase).build());
            if (z) {
                this.mIntent.addFlags(1);
            }
            return this;
        }

        public IntentBuilder setDeepLink(Uri deepLink) {
            if (deepLink != null) {
                this.mIntent.putExtra("com.google.android.gms.appinvite.DEEP_LINK_URL", deepLink);
            } else {
                this.mIntent.removeExtra("com.google.android.gms.appinvite.DEEP_LINK_URL");
            }
            return this;
        }

        public IntentBuilder setEmailHtmlContent(String htmlContent) {
            if (htmlContent != null && htmlContent.getBytes().length > 512000) {
                throw new IllegalArgumentException(String.format("Email html content must be %d bytes or less.", Integer.valueOf(MAX_EMAIL_HTML_CONTENT)));
            }
            this.zzUM = htmlContent;
            return this;
        }

        public IntentBuilder setEmailSubject(String subject) {
            this.zzUL = subject;
            return this;
        }

        public IntentBuilder setGoogleAnalyticsTrackingId(String trackingId) {
            this.mIntent.putExtra("com.google.android.gms.appinvite.GOOGLE_ANALYTICS_TRACKING_ID", trackingId);
            return this;
        }

        public IntentBuilder setMessage(CharSequence message) {
            if (message != null && message.length() > 100) {
                throw new IllegalArgumentException(String.format("Message must be %d chars or less.", 100));
            }
            this.mIntent.putExtra("com.google.android.gms.appinvite.MESSAGE", message);
            return this;
        }

        public IntentBuilder setOtherPlatformsTargetApplication(int targetPlatform, String clientId) throws IllegalArgumentException {
            switch (targetPlatform) {
                case 1:
                    this.mIntent.putExtra("com.google.android.gms.appinvite.iosTargetApplication", clientId);
                    return this;
                case 2:
                    this.mIntent.putExtra("com.google.android.gms.appinvite.androidTargetApplication", clientId);
                    return this;
                default:
                    throw new IllegalArgumentException("targetPlatform must be either PROJECT_PLATFORM_IOS or PROJECT_PLATFORM_ANDROID.");
            }
        }
    }

    private AppInviteInvitation() {
    }

    public static String[] getInvitationIds(int resultCode, @NonNull Intent result) {
        if (resultCode == -1) {
            return result.getStringArrayExtra("com.google.android.gms.appinvite.RESULT_INVITATION_IDS");
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Bundle zzJ(Map<String, String> map) {
        Bundle bundle = new Bundle();
        for (String str : map.keySet()) {
            bundle.putString(str, map.get(str));
        }
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zzbE(String str) {
        for (int i = 0; i < zzUK.length; i++) {
            if (zzUK[i].equals(str)) {
                return true;
            }
        }
        return false;
    }
}
