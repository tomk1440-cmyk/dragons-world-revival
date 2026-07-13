package com.facebook.unity;

import android.os.Bundle;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.ShareConstants;
import com.facebook.share.widget.JoinAppGroupDialog;

/* JADX INFO: loaded from: classes.dex */
public class FBUnityJoinGameGroupActivity extends BaseActivity {
    public static String JOIN_GAME_GROUP_PARAMS = "join_game_group_params";

    @Override // com.facebook.unity.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle params = getIntent().getBundleExtra(JOIN_GAME_GROUP_PARAMS);
        final UnityMessage response = new UnityMessage("OnJoinGroupComplete");
        if (params.containsKey(Constants.CALLBACK_ID_KEY)) {
            response.put(Constants.CALLBACK_ID_KEY, params.getString(Constants.CALLBACK_ID_KEY));
        }
        String groupId = "";
        if (params.containsKey(ShareConstants.WEB_DIALOG_PARAM_ID)) {
            groupId = params.getString(ShareConstants.WEB_DIALOG_PARAM_ID);
        }
        JoinAppGroupDialog dialog = new JoinAppGroupDialog(this);
        dialog.registerCallback(this.mCallbackManager, new FacebookCallback<JoinAppGroupDialog.Result>() { // from class: com.facebook.unity.FBUnityJoinGameGroupActivity.1
            @Override // com.facebook.FacebookCallback
            public void onSuccess(JoinAppGroupDialog.Result result) {
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
                response.sendError(e.getLocalizedMessage());
            }
        });
        dialog.show(groupId);
    }
}
