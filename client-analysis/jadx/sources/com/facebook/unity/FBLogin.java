package com.facebook.unity;

import android.text.TextUtils;
import android.util.Log;
import com.facebook.AccessToken;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.internal.NativeProtocol;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class FBLogin {
    public static void loginWithReadPermissions(String params, FBUnityLoginActivity activity) {
        login(params, activity, false);
    }

    public static void loginWithPublishPermissions(String params, FBUnityLoginActivity activity) {
        login(params, activity, true);
    }

    public static void sendLoginSuccessMessage(AccessToken token, String callbackID) {
        UnityMessage unityMessage = new UnityMessage("OnLoginComplete");
        addLoginParametersToMessage(unityMessage, token, callbackID);
        unityMessage.send();
    }

    public static void addLoginParametersToMessage(UnityMessage unityMessage, AccessToken token, String callbackID) {
        unityMessage.put("key_hash", FB.getKeyHash());
        unityMessage.put("opened", true);
        unityMessage.put("access_token", token.getToken());
        Long expiration = Long.valueOf(token.getExpires().getTime() / 1000);
        unityMessage.put("expiration_timestamp", expiration.toString());
        unityMessage.put(AccessToken.USER_ID_KEY, token.getUserId());
        unityMessage.put(NativeProtocol.RESULT_ARGS_PERMISSIONS, TextUtils.join(",", token.getPermissions()));
        unityMessage.put("declined_permissions", TextUtils.join(",", token.getDeclinedPermissions()));
        if (token.getLastRefresh() != null) {
            Long lastRefresh = Long.valueOf(token.getLastRefresh().getTime() / 1000);
            unityMessage.put("last_refresh", lastRefresh.toString());
        }
        if (callbackID != null && !callbackID.isEmpty()) {
            unityMessage.put(Constants.CALLBACK_ID_KEY, callbackID);
        }
    }

    private static void login(String params, FBUnityLoginActivity activity, boolean isPublishPermLogin) {
        if (!FacebookSdk.isInitialized()) {
            Log.w(FB.TAG, "Facebook SDK not initialized. Call init() before calling login()");
            return;
        }
        final UnityMessage unityMessage = new UnityMessage("OnLoginComplete");
        unityMessage.put("key_hash", FB.getKeyHash());
        UnityParams unity_params = UnityParams.parse(params, "couldn't parse login params: " + params);
        List<String> permissions = null;
        if (unity_params.hasString("scope").booleanValue()) {
            permissions = new ArrayList<>(Arrays.asList(unity_params.getString("scope").split(",")));
        }
        String callbackIDString = null;
        if (unity_params.has(Constants.CALLBACK_ID_KEY)) {
            callbackIDString = unity_params.getString(Constants.CALLBACK_ID_KEY);
            unityMessage.put(Constants.CALLBACK_ID_KEY, callbackIDString);
        }
        final String callbackID = callbackIDString;
        LoginManager.getInstance().registerCallback(activity.getCallbackManager(), new FacebookCallback<LoginResult>() { // from class: com.facebook.unity.FBLogin.1
            @Override // com.facebook.FacebookCallback
            public void onSuccess(LoginResult loginResult) {
                FBLogin.sendLoginSuccessMessage(loginResult.getAccessToken(), callbackID);
            }

            @Override // com.facebook.FacebookCallback
            public void onCancel() {
                unityMessage.putCancelled();
                unityMessage.send();
            }

            @Override // com.facebook.FacebookCallback
            public void onError(FacebookException e) {
                unityMessage.sendError(e.getMessage());
            }
        });
        if (isPublishPermLogin) {
            LoginManager.getInstance().logInWithPublishPermissions(activity, permissions);
        } else {
            LoginManager.getInstance().logInWithReadPermissions(activity, permissions);
        }
    }
}
