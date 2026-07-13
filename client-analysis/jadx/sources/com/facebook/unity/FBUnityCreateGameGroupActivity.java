package com.facebook.unity;

import android.os.Bundle;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.share.internal.ShareConstants;
import com.facebook.share.model.AppGroupCreationContent;
import com.facebook.share.widget.CreateAppGroupDialog;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class FBUnityCreateGameGroupActivity extends BaseActivity {
    public static String CREATE_GAME_GROUP_PARAMS = "create_game_group_params";

    @Override // com.facebook.unity.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppGroupCreationContent.Builder contentBuilder = new AppGroupCreationContent.Builder();
        Bundle params = getIntent().getBundleExtra(CREATE_GAME_GROUP_PARAMS);
        final UnityMessage response = new UnityMessage("OnGroupCreateComplete");
        if (params.containsKey(Constants.CALLBACK_ID_KEY)) {
            response.put(Constants.CALLBACK_ID_KEY, params.getString(Constants.CALLBACK_ID_KEY));
        }
        if (params.containsKey("name")) {
            contentBuilder.setName(params.getString("name"));
        }
        if (params.containsKey("description")) {
            contentBuilder.setDescription(params.getString("name"));
        }
        if (params.containsKey(ShareConstants.WEB_DIALOG_PARAM_PRIVACY)) {
            String privacyStr = params.getString(ShareConstants.WEB_DIALOG_PARAM_PRIVACY);
            AppGroupCreationContent.AppGroupPrivacy privacy = AppGroupCreationContent.AppGroupPrivacy.Closed;
            if (privacyStr.equalsIgnoreCase("closed")) {
                privacy = AppGroupCreationContent.AppGroupPrivacy.Closed;
            } else if (privacyStr.equalsIgnoreCase("open")) {
                privacy = AppGroupCreationContent.AppGroupPrivacy.Open;
            } else {
                response.sendError(String.format(Locale.ROOT, "Unknown privacy setting for group creation: %s", privacyStr));
                finish();
            }
            contentBuilder.setAppGroupPrivacy(privacy);
        }
        CreateAppGroupDialog dialog = new CreateAppGroupDialog(this);
        dialog.registerCallback(this.mCallbackManager, new FacebookCallback<CreateAppGroupDialog.Result>() { // from class: com.facebook.unity.FBUnityCreateGameGroupActivity.1
            @Override // com.facebook.FacebookCallback
            public void onSuccess(CreateAppGroupDialog.Result result) {
                response.put(ShareConstants.WEB_DIALOG_PARAM_ID, result.getId());
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
        dialog.show(contentBuilder.build());
    }
}
