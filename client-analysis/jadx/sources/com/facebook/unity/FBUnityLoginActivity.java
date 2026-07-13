package com.facebook.unity;

import android.os.Bundle;
import com.facebook.CallbackManager;

/* JADX INFO: loaded from: classes.dex */
public class FBUnityLoginActivity extends BaseActivity {
    public static final String LOGIN_PARAMS = "login_params";
    public static final String LOGIN_TYPE = "login_type";

    public enum LoginType {
        READ,
        PUBLISH
    }

    @Override // com.facebook.unity.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LoginType type = (LoginType) getIntent().getSerializableExtra(LOGIN_TYPE);
        String loginParams = getIntent().getStringExtra(LOGIN_PARAMS);
        switch (type) {
            case READ:
                FBLogin.loginWithReadPermissions(loginParams, this);
                break;
            case PUBLISH:
                FBLogin.loginWithPublishPermissions(loginParams, this);
                break;
        }
    }

    public CallbackManager getCallbackManager() {
        return this.mCallbackManager;
    }
}
