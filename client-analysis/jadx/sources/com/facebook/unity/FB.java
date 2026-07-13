package com.facebook.unity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import android.util.Log;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.internal.ActivityLifecycleTracker;
import com.facebook.applinks.AppLinkData;
import com.facebook.internal.BundleJSONConverter;
import com.facebook.internal.InternalSettings;
import com.facebook.internal.Utility;
import com.facebook.login.LoginManager;
import com.facebook.share.widget.ShareDialog;
import com.unity3d.ads.metadata.InAppPurchaseMetaData;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Currency;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;

/* JADX INFO: loaded from: classes.dex */
public class FB {
    static final String FB_UNITY_OBJECT = "UnityFacebookSDKPlugin";
    private static AppEventsLogger appEventsLogger;
    private static Intent intent;
    static final String TAG = FB.class.getName();
    private static AtomicBoolean activateAppCalled = new AtomicBoolean();
    static ShareDialog.Mode ShareDialogMode = ShareDialog.Mode.AUTOMATIC;

    private static AppEventsLogger getAppEventsLogger() {
        if (appEventsLogger == null) {
            appEventsLogger = AppEventsLogger.newLogger(getUnityActivity().getApplicationContext());
        }
        return appEventsLogger;
    }

    public static Activity getUnityActivity() {
        return UnityReflection.GetUnityActivity();
    }

    @UnityCallable
    public static void Init(String params_str) {
        final String appID;
        Log.v(TAG, "Init(" + params_str + ")");
        UnityParams unity_params = UnityParams.parse(params_str, "couldn't parse init params: " + params_str);
        if (unity_params.hasString("appId").booleanValue()) {
            appID = unity_params.getString("appId");
        } else {
            appID = Utility.getMetadataApplicationId(getUnityActivity());
        }
        FacebookSdk.setApplicationId(appID);
        FacebookSdk.sdkInitialize(getUnityActivity(), new FacebookSdk.InitializeCallback() { // from class: com.facebook.unity.FB.1
            @Override // com.facebook.FacebookSdk.InitializeCallback
            public void onInitialized() {
                UnityMessage unityMessage = new UnityMessage("OnInitComplete");
                AccessToken token = AccessToken.getCurrentAccessToken();
                if (token != null) {
                    FBLogin.addLoginParametersToMessage(unityMessage, token, null);
                } else {
                    unityMessage.put("key_hash", FB.getKeyHash());
                }
                FB.ActivateApp(appID);
                unityMessage.send();
            }
        });
    }

    @UnityCallable
    public static void LoginWithReadPermissions(String params_str) {
        Log.v(TAG, "LoginWithReadPermissions(" + params_str + ")");
        Intent intent2 = new Intent(getUnityActivity(), (Class<?>) FBUnityLoginActivity.class);
        intent2.putExtra(FBUnityLoginActivity.LOGIN_PARAMS, params_str);
        intent2.putExtra(FBUnityLoginActivity.LOGIN_TYPE, FBUnityLoginActivity.LoginType.READ);
        getUnityActivity().startActivity(intent2);
    }

    @UnityCallable
    public static void LoginWithPublishPermissions(String params_str) {
        Log.v(TAG, "LoginWithPublishPermissions(" + params_str + ")");
        Intent intent2 = new Intent(getUnityActivity(), (Class<?>) FBUnityLoginActivity.class);
        intent2.putExtra(FBUnityLoginActivity.LOGIN_PARAMS, params_str);
        intent2.putExtra(FBUnityLoginActivity.LOGIN_TYPE, FBUnityLoginActivity.LoginType.PUBLISH);
        getUnityActivity().startActivity(intent2);
    }

    @UnityCallable
    public static void Logout(String params_str) {
        Log.v(TAG, "Logout(" + params_str + ")");
        LoginManager.getInstance().logOut();
        UnityMessage message = new UnityMessage("OnLogoutComplete");
        message.put("did_complete", true);
        message.send();
    }

    @UnityCallable
    public static void AppRequest(String params_str) {
        Log.v(TAG, "AppRequest(" + params_str + ")");
        Intent intent2 = new Intent(getUnityActivity(), (Class<?>) FBUnityGameRequestActivity.class);
        UnityParams unity_params = UnityParams.parse(params_str);
        Bundle params = unity_params.getStringParams();
        intent2.putExtra(FBUnityGameRequestActivity.GAME_REQUEST_PARAMS, params);
        getUnityActivity().startActivity(intent2);
    }

    @UnityCallable
    public static void GameGroupCreate(String params_str) {
        Log.v(TAG, "GameGroupCreate(" + params_str + ")");
        UnityParams unity_params = UnityParams.parse(params_str);
        Bundle params = unity_params.getStringParams();
        Intent intent2 = new Intent(getUnityActivity(), (Class<?>) FBUnityCreateGameGroupActivity.class);
        intent2.putExtra(FBUnityCreateGameGroupActivity.CREATE_GAME_GROUP_PARAMS, params);
        getUnityActivity().startActivity(intent2);
    }

    @UnityCallable
    public static void GameGroupJoin(String params_str) {
        Log.v(TAG, "GameGroupJoin(" + params_str + ")");
        UnityParams unity_params = UnityParams.parse(params_str);
        Bundle params = unity_params.getStringParams();
        Intent intent2 = new Intent(getUnityActivity(), (Class<?>) FBUnityJoinGameGroupActivity.class);
        intent2.putExtra(FBUnityJoinGameGroupActivity.JOIN_GAME_GROUP_PARAMS, params);
        getUnityActivity().startActivity(intent2);
    }

    @UnityCallable
    public static void ShareLink(String params_str) {
        Log.v(TAG, "ShareLink(" + params_str + ")");
        UnityParams unity_params = UnityParams.parse(params_str);
        Bundle params = unity_params.getStringParams();
        Intent intent2 = new Intent(getUnityActivity(), (Class<?>) FBUnityDialogsActivity.class);
        intent2.putExtra(FBUnityDialogsActivity.DIALOG_TYPE, ShareDialogMode);
        intent2.putExtra(FBUnityDialogsActivity.SHARE_DIALOG_PARAMS, params);
        getUnityActivity().startActivity(intent2);
    }

    @UnityCallable
    public static void FeedShare(String params_str) {
        Log.v(TAG, "FeedShare(" + params_str + ")");
        UnityParams unityParams = UnityParams.parse(params_str);
        Bundle params = unityParams.getStringParams();
        Intent intent2 = new Intent(getUnityActivity(), (Class<?>) FBUnityDialogsActivity.class);
        intent2.putExtra(FBUnityDialogsActivity.DIALOG_TYPE, ShareDialog.Mode.FEED);
        intent2.putExtra(FBUnityDialogsActivity.FEED_DIALOG_PARAMS, params);
        getUnityActivity().startActivity(intent2);
    }

    public static void SetIntent(Intent intent2) {
        intent = intent2;
    }

    public static void SetLimitEventUsage(String params_str) {
        Log.v(TAG, "SetLimitEventUsage(" + params_str + ")");
        FacebookSdk.setLimitEventAndDataUsage(getUnityActivity().getApplicationContext(), Boolean.valueOf(params_str).booleanValue());
    }

    @UnityCallable
    public static void LogAppEvent(String params_str) {
        Log.v(TAG, "LogAppEvent(" + params_str + ")");
        UnityParams unity_params = UnityParams.parse(params_str);
        Bundle parameters = new Bundle();
        if (unity_params.has("parameters")) {
            UnityParams unity_params_parameter = unity_params.getParamsObject("parameters");
            parameters = unity_params_parameter.getStringParams();
        }
        if (unity_params.has("logPurchase")) {
            getAppEventsLogger().logPurchase(new BigDecimal(unity_params.getDouble("logPurchase")), Currency.getInstance(unity_params.getString(InAppPurchaseMetaData.KEY_CURRENCY)), parameters);
            return;
        }
        if (unity_params.hasString("logEvent").booleanValue()) {
            if (unity_params.has("valueToSum")) {
                getAppEventsLogger().logEvent(unity_params.getString("logEvent"), unity_params.getDouble("valueToSum"), parameters);
                return;
            } else {
                getAppEventsLogger().logEvent(unity_params.getString("logEvent"), parameters);
                return;
            }
        }
        Log.e(TAG, "couldn't logPurchase or logEvent params: " + params_str);
    }

    @UnityCallable
    public static void SetShareDialogMode(String mode) {
        Log.v(TAG, "SetShareDialogMode(" + mode + ")");
        if (mode.equalsIgnoreCase("NATIVE")) {
            ShareDialogMode = ShareDialog.Mode.NATIVE;
            return;
        }
        if (mode.equalsIgnoreCase("WEB")) {
            ShareDialogMode = ShareDialog.Mode.WEB;
        } else if (mode.equalsIgnoreCase("FEED")) {
            ShareDialogMode = ShareDialog.Mode.FEED;
        } else {
            ShareDialogMode = ShareDialog.Mode.AUTOMATIC;
        }
    }

    @UnityCallable
    public static String GetSdkVersion() {
        return FacebookSdk.getSdkVersion();
    }

    @UnityCallable
    public static void SetUserAgentSuffix(String suffix) {
        Log.v(TAG, "SetUserAgentSuffix(" + suffix + ")");
        InternalSettings.setCustomUserAgent(suffix);
    }

    @UnityCallable
    public static void AppInvite(String paramsStr) {
        Log.v(TAG, "AppInvite(" + paramsStr + ")");
        Intent intent2 = new Intent(getUnityActivity(), (Class<?>) AppInviteDialogActivity.class);
        UnityParams unityParams = UnityParams.parse(paramsStr);
        Bundle params = unityParams.getStringParams();
        intent2.putExtra(AppInviteDialogActivity.DIALOG_PARAMS, params);
        getUnityActivity().startActivity(intent2);
    }

    @UnityCallable
    public static void FetchDeferredAppLinkData(String paramsStr) {
        LogMethodCall("FetchDeferredAppLinkData", paramsStr);
        UnityParams unityParams = UnityParams.parse(paramsStr);
        final UnityMessage unityMessage = new UnityMessage("OnFetchDeferredAppLinkComplete");
        if (unityParams.hasString(Constants.CALLBACK_ID_KEY).booleanValue()) {
            unityMessage.put(Constants.CALLBACK_ID_KEY, unityParams.getString(Constants.CALLBACK_ID_KEY));
        }
        AppLinkData.fetchDeferredAppLinkData(getUnityActivity(), new AppLinkData.CompletionHandler() { // from class: com.facebook.unity.FB.2
            @Override // com.facebook.applinks.AppLinkData.CompletionHandler
            public void onDeferredAppLinkDataFetched(AppLinkData appLinkData) {
                FB.addAppLinkToMessage(unityMessage, appLinkData);
                unityMessage.send();
            }
        });
    }

    @UnityCallable
    public static void GetAppLink(String paramsStr) {
        Log.v(TAG, "GetAppLink(" + paramsStr + ")");
        UnityParams unityParams = UnityParams.parse(paramsStr);
        UnityMessage unityMessage = UnityMessage.createWithCallbackFromParams("OnGetAppLinkComplete", unityParams);
        if (intent == null) {
            unityMessage.put("did_complete", true);
            unityMessage.send();
            return;
        }
        AppLinkData appLinkData = AppLinkData.createFromAlApplinkData(intent);
        if (appLinkData != null) {
            addAppLinkToMessage(unityMessage, appLinkData);
            unityMessage.put("url", intent.getDataString());
        } else if (intent.getData() != null) {
            unityMessage.put("url", intent.getDataString());
        } else {
            unityMessage.put("did_complete", true);
        }
        unityMessage.send();
    }

    @UnityCallable
    public static void RefreshCurrentAccessToken(String paramsStr) {
        LogMethodCall("RefreshCurrentAccessToken", paramsStr);
        UnityParams unityParams = UnityParams.parse(paramsStr);
        final UnityMessage unityMessage = new UnityMessage("OnRefreshCurrentAccessTokenComplete");
        if (unityParams.hasString(Constants.CALLBACK_ID_KEY).booleanValue()) {
            unityMessage.put(Constants.CALLBACK_ID_KEY, unityParams.getString(Constants.CALLBACK_ID_KEY));
        }
        AccessToken.refreshCurrentAccessTokenAsync(new AccessToken.AccessTokenRefreshCallback() { // from class: com.facebook.unity.FB.3
            @Override // com.facebook.AccessToken.AccessTokenRefreshCallback
            public void OnTokenRefreshed(AccessToken accessToken) {
                FBLogin.addLoginParametersToMessage(unityMessage, accessToken, null);
                unityMessage.send();
            }

            @Override // com.facebook.AccessToken.AccessTokenRefreshCallback
            public void OnTokenRefreshFailed(FacebookException e) {
                unityMessage.sendError(e.getMessage());
            }
        });
        AppLinkData.fetchDeferredAppLinkData(getUnityActivity(), new AppLinkData.CompletionHandler() { // from class: com.facebook.unity.FB.4
            @Override // com.facebook.applinks.AppLinkData.CompletionHandler
            public void onDeferredAppLinkDataFetched(AppLinkData appLinkData) {
                FB.addAppLinkToMessage(unityMessage, appLinkData);
                unityMessage.send();
            }
        });
    }

    @TargetApi(8)
    public static String getKeyHash() {
        try {
            Activity activity = getUnityActivity();
            if (activity == null) {
                return "";
            }
            PackageInfo info = activity.getPackageManager().getPackageInfo(activity.getPackageName(), 64);
            Signature[] arr$ = info.signatures;
            int len$ = arr$.length;
            if (0 < len$) {
                Signature signature = arr$[0];
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                String keyHash = Base64.encodeToString(md.digest(), 0);
                Log.d(TAG, "KeyHash: " + keyHash);
                return keyHash;
            }
        } catch (PackageManager.NameNotFoundException e) {
        } catch (NoSuchAlgorithmException e2) {
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ActivateApp(String appId) {
        if (!activateAppCalled.compareAndSet(false, true)) {
            Log.w(TAG, "Activite app only needs to be called once");
            return;
        }
        final Activity unityActivity = getUnityActivity();
        if (appId != null) {
            AppEventsLogger.activateApp(unityActivity.getApplication(), appId);
        } else {
            AppEventsLogger.activateApp(unityActivity.getApplication());
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.facebook.unity.FB.5
            @Override // java.lang.Runnable
            public void run() {
                ActivityLifecycleTracker.onActivityCreated(unityActivity);
                ActivityLifecycleTracker.onActivityResumed(unityActivity);
            }
        });
    }

    private static void startActivity(Class<?> cls, String paramsStr) {
        Intent intent2 = new Intent(getUnityActivity(), cls);
        UnityParams unityParams = UnityParams.parse(paramsStr);
        Bundle params = unityParams.getStringParams();
        intent2.putExtra(BaseActivity.ACTIVITY_PARAMS, params);
        getUnityActivity().startActivity(intent2);
    }

    private static void LogMethodCall(String methodName, String paramsStr) {
        Log.v(TAG, String.format(Locale.ROOT, "%s(%s)", methodName, paramsStr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void addAppLinkToMessage(UnityMessage unityMessage, AppLinkData appLinkData) {
        if (appLinkData == null) {
            unityMessage.put("did_complete", true);
            return;
        }
        unityMessage.put("ref", appLinkData.getRef());
        unityMessage.put("target_url", appLinkData.getTargetUri().toString());
        try {
            if (appLinkData.getArgumentBundle() != null) {
                unityMessage.put(AppLinkData.ARGUMENTS_EXTRAS_KEY, BundleJSONConverter.convertToJSON(appLinkData.getArgumentBundle()).toString());
            }
        } catch (JSONException ex) {
            Log.e(TAG, ex.getLocalizedMessage());
        }
    }
}
