package com.facebook.unity;

import android.os.Bundle;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.model.AppInviteContent;
import com.facebook.share.widget.AppInviteDialog;

/* JADX INFO: loaded from: classes.dex */
public class AppInviteDialogActivity extends BaseActivity {
    public static final String DIALOG_PARAMS = "dialog_params";

    @Override // com.facebook.unity.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final UnityMessage response = new UnityMessage("OnAppInviteComplete");
        Bundle params = getIntent().getBundleExtra(DIALOG_PARAMS);
        AppInviteContent.Builder contentBuilder = new AppInviteContent.Builder();
        if (params.containsKey(Constants.CALLBACK_ID_KEY)) {
            response.put(Constants.CALLBACK_ID_KEY, params.getString(Constants.CALLBACK_ID_KEY));
        }
        if (params.containsKey("appLinkUrl")) {
            contentBuilder.setApplinkUrl(params.getString("appLinkUrl"));
        }
        if (params.containsKey("previewImageUrl")) {
            contentBuilder.setPreviewImageUrl(params.getString("previewImageUrl"));
        }
        AppInviteDialog dialog = new AppInviteDialog(this);
        dialog.registerCallback(this.mCallbackManager, new FacebookCallback<AppInviteDialog.Result>() { // from class: com.facebook.unity.AppInviteDialogActivity.1
            @Override // com.facebook.FacebookCallback
            public void onSuccess(AppInviteDialog.Result result) {
                response.put(NativeProtocol.RESULT_ARGS_DIALOG_COMPLETE_KEY, true);
                response.send();
            }

            @Override // com.facebook.FacebookCallback
            public void onCancel() {
                response.putCancelled();
                response.send();
            }

            @Override // com.facebook.FacebookCallback
            public void onError(FacebookException e) {
                response.sendError(e.getMessage());
            }
        });
        dialog.show(contentBuilder.build());
    }
}
