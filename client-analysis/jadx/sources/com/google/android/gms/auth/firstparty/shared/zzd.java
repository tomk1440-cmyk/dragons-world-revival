package com.google.android.gms.auth.firstparty.shared;

import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.NativeProtocol;

/* JADX INFO: loaded from: classes.dex */
public enum zzd {
    CLIENT_LOGIN_DISABLED("ClientLoginDisabled"),
    DEVICE_MANAGEMENT_REQUIRED("DeviceManagementRequiredOrSyncDisabled"),
    SOCKET_TIMEOUT("SocketTimeout"),
    SUCCESS("Ok"),
    UNKNOWN_ERROR("UNKNOWN_ERR"),
    NETWORK_ERROR(NativeProtocol.ERROR_NETWORK_ERROR),
    SERVICE_UNAVAILABLE("ServiceUnavailable"),
    INTNERNAL_ERROR("InternalError"),
    BAD_AUTHENTICATION("BadAuthentication"),
    EMPTY_CONSUMER_PKG_OR_SIG("EmptyConsumerPackageOrSig"),
    NEEDS_2F("InvalidSecondFactor"),
    NEEDS_POST_SIGN_IN_FLOW("PostSignInFlowRequired"),
    NEEDS_BROWSER("NeedsBrowser"),
    UNKNOWN(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN),
    NOT_VERIFIED("NotVerified"),
    TERMS_NOT_AGREED("TermsNotAgreed"),
    ACCOUNT_DISABLED("AccountDisabled"),
    CAPTCHA("CaptchaRequired"),
    ACCOUNT_DELETED("AccountDeleted"),
    SERVICE_DISABLED(NativeProtocol.ERROR_SERVICE_DISABLED),
    NEED_PERMISSION("NeedPermission"),
    INVALID_SCOPE("INVALID_SCOPE"),
    USER_CANCEL("UserCancel"),
    PERMISSION_DENIED(NativeProtocol.ERROR_PERMISSION_DENIED),
    THIRD_PARTY_DEVICE_MANAGEMENT_REQUIRED("ThirdPartyDeviceManagementRequired"),
    DM_INTERNAL_ERROR("DeviceManagementInternalError"),
    DM_SYNC_DISABLED("DeviceManagementSyncDisabled"),
    DM_ADMIN_BLOCKED("DeviceManagementAdminBlocked"),
    DM_ADMIN_PENDING_APPROVAL("DeviceManagementAdminPendingApproval"),
    DM_STALE_SYNC_REQUIRED("DeviceManagementStaleSyncRequired"),
    DM_DEACTIVATED("DeviceManagementDeactivated"),
    DM_REQUIRED("DeviceManagementRequired"),
    REAUTH_REQUIRED("ReauthRequired"),
    ALREADY_HAS_GMAIL("ALREADY_HAS_GMAIL"),
    BAD_PASSWORD("WeakPassword"),
    BAD_REQUEST("BadRequest"),
    BAD_USERNAME("BadUsername"),
    DELETED_GMAIL("DeletedGmail"),
    EXISTING_USERNAME("ExistingUsername"),
    LOGIN_FAIL("LoginFail"),
    NOT_LOGGED_IN("NotLoggedIn"),
    NO_GMAIL("NoGmail"),
    REQUEST_DENIED("RequestDenied"),
    SERVER_ERROR("ServerError"),
    USERNAME_UNAVAILABLE("UsernameUnavailable"),
    GPLUS_OTHER("GPlusOther"),
    GPLUS_NICKNAME("GPlusNickname"),
    GPLUS_INVALID_CHAR("GPlusInvalidChar"),
    GPLUS_INTERSTITIAL("GPlusInterstitial"),
    GPLUS_PROFILE_ERROR("ProfileUpgradeError");

    private final String zzZA;

    zzd(String str) {
        this.zzZA = str;
    }

    public static boolean zza(zzd zzdVar) {
        return BAD_AUTHENTICATION.equals(zzdVar) || CAPTCHA.equals(zzdVar) || NEED_PERMISSION.equals(zzdVar) || NEEDS_BROWSER.equals(zzdVar) || USER_CANCEL.equals(zzdVar) || THIRD_PARTY_DEVICE_MANAGEMENT_REQUIRED.equals(zzdVar) || zzb(zzdVar);
    }

    public static boolean zzb(zzd zzdVar) {
        return DEVICE_MANAGEMENT_REQUIRED.equals(zzdVar) || DM_INTERNAL_ERROR.equals(zzdVar) || DM_SYNC_DISABLED.equals(zzdVar) || DM_ADMIN_BLOCKED.equals(zzdVar) || DM_ADMIN_PENDING_APPROVAL.equals(zzdVar) || DM_STALE_SYNC_REQUIRED.equals(zzdVar) || DM_DEACTIVATED.equals(zzdVar) || DM_REQUIRED.equals(zzdVar);
    }

    public static final zzd zzbY(String str) {
        zzd zzdVar = null;
        zzd[] zzdVarArrValues = values();
        int length = zzdVarArrValues.length;
        int i = 0;
        while (i < length) {
            zzd zzdVar2 = zzdVarArrValues[i];
            if (!zzdVar2.zzZA.equals(str)) {
                zzdVar2 = zzdVar;
            }
            i++;
            zzdVar = zzdVar2;
        }
        return zzdVar;
    }

    public static boolean zzc(zzd zzdVar) {
        return NETWORK_ERROR.equals(zzdVar) || SERVICE_UNAVAILABLE.equals(zzdVar);
    }
}
