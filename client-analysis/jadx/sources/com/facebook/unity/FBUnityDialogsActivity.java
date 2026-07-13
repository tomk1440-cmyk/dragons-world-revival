package com.facebook.unity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.share.Sharer;
import com.facebook.share.model.ShareContent;
import com.facebook.share.widget.ShareDialog;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class FBUnityDialogsActivity extends BaseActivity {
    public static final String DIALOG_TYPE = "dialog_type";
    public static final String FEED_DIALOG_PARAMS = "feed_dialog_params";
    public static final String SHARE_DIALOG_PARAMS = "share_dialog_params";
    private static String TAG = FBUnityDialogsActivity.class.getName();

    @Override // com.facebook.unity.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        Bundle params;
        ShareContent shareContent;
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        if (intent.hasExtra(SHARE_DIALOG_PARAMS)) {
            params = intent.getBundleExtra(SHARE_DIALOG_PARAMS);
            shareContent = FBDialogUtils.createShareContentBuilder(params).build();
        } else if (intent.hasExtra(FEED_DIALOG_PARAMS)) {
            params = intent.getBundleExtra(FEED_DIALOG_PARAMS);
            shareContent = FBDialogUtils.createFeedContentBuilder(params).build();
        } else {
            Log.e(TAG, String.format(Locale.ROOT, "Failed to find extra %s or %s", SHARE_DIALOG_PARAMS, FEED_DIALOG_PARAMS));
            finish();
            return;
        }
        ShareDialog dialog = new ShareDialog(this);
        final UnityMessage response = new UnityMessage("OnShareLinkComplete");
        String callbackID = params.getString(Constants.CALLBACK_ID_KEY);
        if (callbackID != null) {
            response.put(Constants.CALLBACK_ID_KEY, callbackID);
        }
        dialog.registerCallback(this.mCallbackManager, new FacebookCallback<Sharer.Result>() { // from class: com.facebook.unity.FBUnityDialogsActivity.1
            @Override // com.facebook.FacebookCallback
            public void onSuccess(Sharer.Result result) {
                if (result.getPostId() != null) {
                    response.putID(result.getPostId());
                }
                response.put("posted", true);
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
        ShareDialog.Mode mode = (ShareDialog.Mode) getIntent().getSerializableExtra(DIALOG_TYPE);
        dialog.show(shareContent, mode);
    }
}
